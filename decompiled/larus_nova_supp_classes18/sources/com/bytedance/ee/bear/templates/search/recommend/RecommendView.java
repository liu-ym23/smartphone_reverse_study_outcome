package com.bytedance.ee.bear.templates.search.recommend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.templates.TemplateReport;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\f\u001a\u00020\rJ\u001a\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000f0\u0011R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/templates/search/recommend/RecommendView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapter", "Lcom/bytedance/ee/bear/templates/search/recommend/RecommendAdapter;", "fetchData", "Lio/reactivex/disposables/Disposable;", "setClickItemListener", "", "listener", "Lkotlin/Function1;", "", "Companion", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RecommendView extends FrameLayout {
    public final RecommendAdapter a;

    public static final class a {
    }

    public static final class b<T extends Result> implements NetService.c {
        public static final b<T> a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Result parse(String r2) {
            return (RecommendResult) JSON.parseObject(r2, RecommendResult.class);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ RecommendView a;

        public c(RecommendView r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            RecommendResult r5 = (RecommendResult) r4;
            RecommendResult.RecommendData r0 = (RecommendResult.RecommendData) ((Result) r5).data;
            if (r0 == null) goto L7;
            List<String> r1 = r0.recommend_keys;
            if (r1 == null) goto L7;
            Integer r2 = Integer.valueOf(r1.size());
        L8:
            tt5.a.h("RecommendView", String.valueOf(r2));
            if (this.a.isAttachedToWindow() == false) goto L15;
            tt5.a.h("RecommendView", "setData");
            RecommendAdapter r3 = this.a.a;
            List<String> r6 = ((RecommendResult.RecommendData) ((Result) r5).data).recommend_keys;
            if (r6 != null) goto L13;
            r6 = new ArrayList();
        L13:
            r3.getClass();
            Intrinsics.checkNotNullParameter(r6, "<set-?>");
            r3.a = r6;
            this.a.a.notifyDataSetChanged();
            TemplateReport.d("display_searchrecommendwords", null);
            return;
        L15:
            return;
        L7:
            r2 = null;
            goto L8
        }
    }

    public static final class d<T> implements Consumer {
        public static final d<T> a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r3) {
            tt5.a.f("RecommendView", (Throwable) r3, false);
        }
    }

    static {
    }

    public RecommendView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public RecommendView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final Disposable a() {
        NetService.d r0 = ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(b.a);
        NetService.f r1 = new NetService.f("/space/api/platform/template/search_key_recommend/");
        r1.b("search_scene_id", "1");
        Disposable r2 = r0.a(r1).subscribe(new c(this), d.a);
        Intrinsics.checkNotNull(r2);
        return r2;
    }

    public final void setClickItemListener(Function1<? super String, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.a.b = r2;
    }

    public RecommendView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        RecommendAdapter r6 = new RecommendAdapter();
        this.a = r6;
        RecyclerView r7 = LayoutInflater.from(r3).inflate(2131564966, this, true).findViewById(2131388344);
        r7.setLayoutManager(new GridLayoutManager(r3, 2));
        r7.setAdapter(r6);
    }

    public /* synthetic */ RecommendView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}

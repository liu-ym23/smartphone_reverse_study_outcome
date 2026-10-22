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
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\f\u001a\u00020\rJ\u001a\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000f0\u0011R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/templates/search/recommend/RecommendView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapter", "Lcom/bytedance/ee/bear/templates/search/recommend/RecommendAdapter;", "fetchData", "Lio/reactivex/disposables/Disposable;", "setClickItemListener", "", "listener", "Lkotlin/Function1;", "", "Companion", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RecommendView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecommendAdapter f239394a;

    public static final class a {
    }

    public static final class b<T extends Result> implements NetService.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b<T> f239395a = null;

        static {
            f239395a = new b();
        }

        public b() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result parse(String r100) {
            return (RecommendResult) JSON.parseObject(r100, RecommendResult.class);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecommendView f239396a;

        public c(RecommendView r100) {
            this.f239396a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            RecommendResult r101 = (RecommendResult) r100;
            RecommendResult.RecommendData r102 = (RecommendResult.RecommendData) r101.data;
            if (r102 == null) goto L7;
            List<String> r103 = r102.recommend_keys;
            if (r103 == null) goto L7;
            Integer r104 = Integer.valueOf(r103.size());
        L8:
            tt5.a.h("RecommendView", String.valueOf(r104));
            if (this.f239396a.isAttachedToWindow() == false) goto L15;
            tt5.a.h("RecommendView", "setData");
            RecommendAdapter r105 = this.f239396a.f239394a;
            List<String> r106 = ((RecommendResult.RecommendData) r101.data).recommend_keys;
            if (r106 != null) goto L13;
            r106 = new ArrayList();
        L13:
            r105.getClass();
            Intrinsics.checkNotNullParameter(r106, "<set-?>");
            r105.f239390a = r106;
            this.f239396a.f239394a.notifyDataSetChanged();
            TemplateReport.d("display_searchrecommendwords", null);
            return;
        L15:
            return;
        L7:
            r104 = null;
            goto L8
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d<T> f239397a = null;

        static {
            f239397a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tt5.a.f("RecommendView", (Throwable) r100, false);
        }
    }

    static {
    }

    public RecommendView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public RecommendView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final Disposable a() {
        NetService.d r100 = ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(b.f239395a);
        NetService.f r101 = new NetService.f("/space/api/platform/template/search_key_recommend/");
        r101.b("search_scene_id", "1");
        Disposable r102 = r100.a(r101).subscribe(new c(this), d.f239397a);
        Intrinsics.checkNotNull(r102);
        return r102;
    }

    public final void setClickItemListener(Function1<? super String, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f239394a.f239391b = r100;
    }

    public RecommendView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        RecommendAdapter r103 = new RecommendAdapter();
        this.f239394a = r103;
        RecyclerView r104 = (RecyclerView) LayoutInflater.from(r100).inflate(R.layout.template_search_recommend, this, true).findViewById(R.id.template_search_recommend_rv);
        r104.setLayoutManager(new GridLayoutManager(r100, 2));
        r104.setAdapter(r103);
    }

    public /* synthetic */ RecommendView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}

package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.ee.bear.facade.common.empty.Config;
import com.bytedance.ee.bear.facade.common.empty.EmptyStateSource;
import com.bytedance.ee.bear.facade.common.empty.EmptyView;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiException;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0003\u001e\u001f B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u000e\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0017J\b\u0010\u001d\u001a\u00020\u0011H\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiEmptyView;", "Lcom/bytedance/ee/bear/facade/common/empty/EmptyView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "emptyMediator", "Lcom/bytedance/ee/bear/facade/common/empty/EmptyMediator;", "contentView", "Landroid/view/View;", "loadingConfig", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiEmptyView$LoadingConfig;", "disposes", "Lio/reactivex/disposables/CompositeDisposable;", "init", "", "showByResult", "result", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/Result;", "showByCode", "serverErrorCode", "", "showByError", "e", "", "show", "emptyState", "checkInit", "Companion", "LoadingConfig", "WikiEmptyConfig", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiEmptyView extends EmptyView {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f242277j = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bytedance.ee.bear.facade.common.empty.c f242278f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f242279g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b f242280h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CompositeDisposable f242281i;

    public static final class WikiEmptyConfig {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f242282a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f242283b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Integer f242284c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Function0<Config> f242285d;

        public WikiEmptyConfig(Context r100, String r101, Integer r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, CommonConstant.ReqAccessTokenParam.LANGUAGE_LABEL);
            this.f242282a = r100;
            this.f242283b = r101;
            this.f242284c = r102;
            this.f242285d = new WikiEmptyView$WikiEmptyConfig$value$1(this);
        }
    }

    public static final class a {
    }

    public static final class b {
        public b() {
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WikiEmptyView f242286a;

        public c(WikiEmptyView r100) {
            this.f242286a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            com.bytedance.ee.bear.facade.common.empty.c r102 = this.f242286a.f242278f;
            if (r102 == null) goto L6;
            r102.a(new EmptyStateSource.b(0));
            return;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d<T> f242287a = null;

        static {
            f242287a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tt5.a.e("Wiki_WikiEmptyView", "delay loading fail. ", (Throwable) r100, false);
        }
    }

    static {
    }

    public final void c(int r100) {
        if (this.f242278f != null) goto L8;
        getContext();
        this.f242278f = new com.bytedance.ee.bear.facade.common.empty.c(this, this.f242279g);
        Context r101 = getContext();
        Integer r102 = null;
        String r103 = ((com.bytedance.ee.bear.contract.i0) org.koin.java.a.c(com.bytedance.ee.bear.contract.i0.class, null, null, 6)).a();
        if (this.f242280h == null) goto L7;
        r102 = Integer.valueOf(R.layout.doc_loading_layout);
    L7:
        setConfig(new WikiEmptyConfig(r101, r103, r102).f242285d.invoke());
    L8:
        this.f242281i.clear();
        if (r100 == 0) goto L13;
        com.bytedance.ee.bear.facade.common.empty.c r104 = this.f242278f;
        if (r104 == null) goto L15;
        r104.a(new EmptyStateSource.b(r100));
        return;
    L15:
        return;
    L13:
        this.f242281i.add(Flowable.timer(400, TimeUnit.MILLISECONDS).observeOn(fo5.d.d()).subscribe(new c(this), d.f242287a));
    }

    public final void d(int r100) {
        if (r100 != (-4)) goto L5;
        int r101 = 10;
    L19:
        c(r101);
        return;
    L5:
        if (r100 != (-3)) goto L7;
        r101 = 9;
        goto L19
    L7:
        if (r100 != (-2)) goto L9;
        r101 = 1;
        goto L19
    L9:
        if (r100 != 920004007) goto L11;
    L15:
        r101 = 99;
        goto L19
    L11:
        if (r100 == 920004012) goto L15;
        switch(r100) {
            case 920004001: goto L14;
            case 920004002: goto L14;
            case 920004003: goto L15;
            case 920004004: goto L15;
            default: goto L13;
        };
    L13:
        r101 = 3;
        goto L19
    L14:
        r101 = 5;
        goto L19
    }

    public final void e(Throwable r100) {
        if ((r100 instanceof WikiException) == false) goto L14;
        int r101 = ((WikiException) r100).getCode();
        if (r101 != (-100001)) goto L7;
        int r102 = 10;
    L13:
        c(r102);
        return;
    L7:
        if (r101 != (-55)) goto L9;
    L11:
        r102 = 5;
        goto L13
    L9:
        if (r101 == 920004002) goto L11;
        r102 = 3;
        goto L13
    L14:
        d(tp5.b.a(r100));
    }

    public WikiEmptyView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f242281i = new CompositeDisposable();
    }
}

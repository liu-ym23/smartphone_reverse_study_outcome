package com.bytedance.ies.bullet.ui.common;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.common.Scenes;
import com.bytedance.ies.bullet.secure.SccConfig;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.i0;
import com.bytedance.ies.bullet.service.base.o;
import com.bytedance.ies.bullet.service.base.p0;
import com.bytedance.ies.bullet.service.base.q;
import com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import y36.r;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0014\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ies/bullet/ui/common/BulletContainerView;", "Lcom/bytedance/ies/bullet/ui/common/BulletCardView;", "Landroid/net/Uri;", "uri", "", "setStatusView", "Landroid/view/View;", "getLoadingView", "", "loadingDelayInMilliSeconds", "setLoadingDelay", "Lcom/bytedance/ies/bullet/service/base/p0;", "loadingView", "setLoadingView", "setLoadingViewInternal$anniex_release", "(Landroid/view/View;)V", "setLoadingViewInternal", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "anniex_release"}, k = 1, mv = {1, 4, 3})
public class BulletContainerView extends BulletCardView {
    public static final /* synthetic */ int U = 0;
    public View F;
    public Timer G;
    public TimerTask H;
    public long I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f248229J;
    public View K;
    public p0 L;
    public p0 M;
    public Function0<Unit> N;
    public Lambda O;
    public View P;
    public View Q;
    public v36.a R;
    public Drawable S;
    public boolean T;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f248230a = null;

        static {
            int[] r100 = new int[SccConfig.SccLevel.values().length];
            r100[SccConfig.SccLevel.NOTICE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[SccConfig.SccLevel.DENY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f248230a = r100;
        }
    }

    public static final class b extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BulletContainerView f248231a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f248232b;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ BulletContainerView f248233a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ long f248234b;

            /* JADX INFO: renamed from: com.bytedance.ies.bullet.ui.common.BulletContainerView$b$a$a, reason: collision with other inner class name */
            public static final class RunnableC3548a implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ BulletContainerView f248235a;

                public RunnableC3548a(BulletContainerView r100) {
                    this.f248235a = r100;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    BulletContainerView r100 = this.f248235a;     // Catch: Throwable -> L4
                    int r101 = BulletContainerView.U;     // Catch: Throwable -> L4
                    r100.x();     // Catch: Throwable -> L4
                    return;
                L4:
                    th = move-exception;
                    if (RunnableProtector.intercept(th) == false) goto L8;
                    return;
                L8:
                    throw th;
                }
            }

            public a(BulletContainerView r100, long r101) {
                this.f248233a = r100;
                this.f248234b = r101;
            }

            @Override // java.lang.Runnable
            public final void run() {
                BulletContainerView r100 = this.f248233a;     // Catch: Throwable -> L10
                r100.G = null;     // Catch: Throwable -> L10
                r100.H = null;     // Catch: Throwable -> L10
                if (r100.f248229J == true) goto L13;
                r100.F();     // Catch: Throwable -> L10
                if (this.f248234b == 0) goto L17;
                View r101 = BulletContainerView.r(this.f248233a);     // Catch: Throwable -> L10
                if (r101 == null) goto L18;
                r101.postDelayed(new RunnableC3548a(this.f248233a), this.f248234b);     // Catch: Throwable -> L10
                return;
            L18:
                return;
            L17:
                return;
            L13:
                return;
            L10:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L19;
                throw th;
            }
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            Activity r100 = o16.a.a(this.f248231a.getContext());     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.runOnUiThread(new a(this.f248231a, this.f248232b));     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public b(BulletContainerView r100, long r101) {
            this.f248231a = r100;
            this.f248232b = r101;
        }
    }

    public BulletContainerView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BulletContainerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void s() {
        BulletLogger.k("message:BulletContainerView dispatchHideLoading", null, null, 6);
        x();
    }

    public final void t() {
        BulletLogger.k("message:BulletContainerView dispatchShowLoading", null, null, 6);
        F();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void A() {
        v36.a r100 = this.R;
        Intrinsics.checkNotNull(r100);
        Integer r101 = (Integer) r100.b().f565862b;
        if (r101 == null) goto L5;
        setBackgroundColor(r101.intValue());
        Unit r102 = Unit.INSTANCE;
    L6:
        if (r102 == null) goto L8;
        return;
    L8:
        if (this.T == false) goto L12;
        setBackground(this.S);
        this.T = false;
        return;
    L12:
        return;
    L5:
        r102 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void B() {
        v36.a r100 = this.R;
        if (r100 == null) goto L23;
        XBaseRuntime.f270095a.getClass();
        IHostContextDepend r101 = XBaseRuntime.f270100f;
        Unit r102 = null;
        if (r101 == null) goto L7;
        String r103 = r101.getSkinName();
    L8:
        if (r103 != null) goto L10;
        A();
        return;
    L10:
        if (Intrinsics.areEqual(r103.toLowerCase(), "light") == false) goto L16;
        Integer r104 = (Integer) r100.d().f565862b;
        if (r104 == null) goto L14;
        setBackgroundColor(r104.intValue());
        r102 = Unit.INSTANCE;
    L14:
        if (r102 != null) goto L24;
        A();
        return;
    L24:
        return;
    L16:
        Integer r105 = (Integer) r100.c().f565862b;
        if (r105 == null) goto L19;
        setBackgroundColor(r105.intValue());
        r102 = Unit.INSTANCE;
    L19:
        if (r102 != null) goto L26;
        A();
        return;
    L26:
        return;
    L7:
        r103 = null;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void w() {
        View r100 = this.K;
        boolean r101 = r100 instanceof com.bytedance.ies.bullet.service.base.i;
        String r102 = null;
        if (r101 == false) goto L9;
        if (r101 == false) goto L6;
        com.bytedance.ies.bullet.service.base.i r103 = (com.bytedance.ies.bullet.service.base.i) r100;
    L7:
        if (r103 == null) goto L12;
        r103.hide();
    L12:
        ExecutorService r104 = BulletLogger.f247763a;
        BulletContext r105 = getBulletContext();
        if (r105 == null) goto L15;
        r102 = r105.getSessionId();
    L15:
        BulletLogger.g(r102, "hide error page", "XView", 8);
        return;
    L6:
        r103 = null;
        goto L7
    L9:
        if (r100 == 0) goto L12;
        r100.setVisibility(8);
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x() {
        View r100 = this.F;
        boolean r101 = r100 instanceof q;
        String r102 = null;
        if (r101 == false) goto L9;
        if (r101 == false) goto L6;
        q r103 = (q) r100;
    L7:
        if (r103 == null) goto L12;
        r103.hide();
    L12:
        ExecutorService r104 = BulletLogger.f247763a;
        BulletContext r105 = getBulletContext();
        if (r105 == null) goto L15;
        r102 = r105.getSessionId();
    L15:
        BulletLogger.g(r102, "hide loading", "XView", 8);
        return;
    L6:
        r103 = null;
        goto L7
    L9:
        if (r100 == 0) goto L12;
        r100.setVisibility(8);
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final View getLoadingView() {
        z();
        View r100 = this.F;
        if ((r100 instanceof q) == true) goto L5;
        return r100;
    L5:
        if ((r100 instanceof q) == false) goto L7;
        q r101 = (q) r100;
    L8:
        if (r101 != null) goto L10;
        return null;
    L10:
        return r101.getView();
    L7:
        r101 = null;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void F() {
        z();
        View r100 = this.F;
        boolean r101 = r100 instanceof q;
        String r102 = null;
        if (r101 == false) goto L9;
        if (r101 == false) goto L6;
        q r103 = (q) r100;
    L7:
        if (r103 == null) goto L12;
        r103.show();
    L12:
        ExecutorService r104 = BulletLogger.f247763a;
        BulletContext r105 = getBulletContext();
        if (r105 == null) goto L15;
        r102 = r105.getSessionId();
    L15:
        BulletLogger.g(r102, "show loading", "XView", 8);
        return;
    L6:
        r103 = null;
        goto L7
    L9:
        if (r100 == 0) goto L12;
        r100.setVisibility(0);
        goto L12
    }

    @Override // com.bytedance.ies.bullet.ui.common.BulletCardView, com.bytedance.ies.bullet.core.q
    public final void lX() {
        super.lX();
        KeyEvent.Callback r100 = this.F;
        if ((r100 instanceof i0) == false) goto L5;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.ies.bullet.service.base.IReleasable");
        ((i0) r100).release();
    L5:
        KeyEvent.Callback r101 = this.K;
        if ((r101 instanceof i0) == false) goto L9;
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.bytedance.ies.bullet.service.base.IReleasable");
        ((i0) r101).release();
        return;
    }

    public final void z() {
        if (getMCurrentScene() != Scenes.PopupFragment) goto L5;
        String r100 = "popup";
    L6:
        p0 r101 = this.L;
        if (r101 == null) goto L19;
        q r102 = r101.b(getContext(), r100);
        if (r102 == null) goto L19;
        View r103 = r102.getView();
        FrameLayout.LayoutParams r104 = r101.B0(r100);
        if (r104 == null) goto L16;
        Intrinsics.checkNotNullParameter(r103, "loadingView");
        Intrinsics.checkNotNullParameter(r104, "params");
        View r105 = this.F;
        if (r105 == null) goto L15;
        removeView(r105);
    L15:
        r103.setLayoutParams(r104);
        r103.setVisibility(8);
        addView(r103);
        this.F = r103;
        Unit r106 = Unit.INSTANCE;
    L17:
        if (r106 != null) goto L19;
        h16.e.b.a(this, r103);
        goto L19
    L16:
        r106 = null;
    L19:
        this.L = null;
        return;
    L5:
        r100 = "page";
        goto L6
    }

    public static final /* synthetic */ View r(BulletContainerView r100) {
        return r100.getLoadingView();
    }

    private final void setStatusView(Uri r100) {
        BulletContext r101 = getBulletContext();
        String r102 = null;
        if (r101 != null) goto L5;
    L37:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L16
        if (r100 == null) goto L11;
        String r104 = a36.b.e(r100, "url");     // Catch: Throwable -> L16
    L12:
        if (r104 != null) goto L14;
        r104 = "";
    L14:
        Object r105 = Result.m9449constructorimpl(UriProtector.parse(r104));     // Catch: Throwable -> L16
    L19:
        if (Result.m9455isFailureimpl(r105) == false) goto L21;
        r105 = null;
    L21:
        Uri r106 = (Uri) r105;
        if (r106 == null) goto L24;
        String r107 = a36.b.e(r106, "loading_style");
    L25:
        boolean r108 = Intrinsics.areEqual(r107, "host");
        if (r106 == null) goto L28;
        r102 = a36.b.e(r106, "error_page_style");
    L28:
        boolean r109 = Intrinsics.areEqual(r102, "host");
        String r110 = "default_bid";
        if (r108 == false) goto L31;
        String r111 = "default_bid";
    L32:
        if (r109 == true) goto L35;
        r110 = getBid();
    L35:
        s26.d r112 = s26.d.f540305c;
        this.L = (p0) s26.d.f540305c.d(r111, p0.class);
        this.M = (p0) s26.d.f540305c.d(r110, p0.class);
        return;
    L31:
        r111 = getBid();
        goto L32
    L24:
        r107 = null;
        goto L25
    L11:
        r104 = null;
    L16:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L19
    L5:
        if (r101.f246455w.f246484l == null) goto L37;
        BulletLogger.k("BulletContainerView.setStatusView: getViewService from bullet Context", null, "XView", 2);
        p0 r114 = r101.f246455w.f246484l;
        this.L = r114;
        this.M = r114;
    }

    public final void setLoadingDelay(long r100) {
        if (r100 < 0) goto L6;
        this.I = r100;
        return;
    }

    public final void setLoadingView(p0 r100) {
        Intrinsics.checkNotNullParameter(r100, "loadingView");
        this.L = r100;
    }

    public final void setLoadingViewInternal$anniex_release(View r100) {
        Intrinsics.checkNotNullParameter(r100, "loadingView");
        View r101 = this.F;
        if (r101 == null) goto L5;
        removeView(r101);
    L5:
        r100.setVisibility(0);
        addView(r100);
        this.F = r100;
    }

    public final void y(View r100) {
        if (r100 == null) goto L5;
        r100.setVisibility(8);
        removeView(r100);
        return;
    }

    public static /* synthetic */ void E(BulletContainerView r100, View r101) {
        r100.C(r101, new FrameLayout.LayoutParams(-1, -1));
    }

    public final void C(View r100, FrameLayout.LayoutParams r101) {
        Intrinsics.checkNotNullParameter(r100, "errorView");
        View r102 = this.K;
        if (r102 == null) goto L5;
        removeView(r102);
    L5:
        r100.setLayoutParams(r101);
        r100.setVisibility(8);
        addView(r100);
        this.K = r100;
        BulletContext r103 = getBulletContext();
        if (r103 == null) goto L8;
        com.bytedance.ies.bullet.core.e r104 = r103.f246455w;
    L9:
        if (r104 == null) goto L13;
        r104.f246487o = true;
        return;
    L13:
        return;
    L8:
        r104 = null;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ies.bullet.ui.common.BulletCardView, com.bytedance.ies.bullet.core.s
    public final void Ox(Uri r100, h16.e r110) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        super.Ox(r100, r110);
        Scenes r111 = getMCurrentScene();
        Scenes r101 = Scenes.Container;
        if (r111 != r101) goto L5;
        setStatusView(r100);
    L5:
        w();
        boolean r112 = true;
        if (getMCurrentScene() != r101) goto L8;
    L10:
        boolean r102 = false;
    L11:
        BulletContext r103 = getBulletContext();
        if (r103 == null) goto L19;
        Boolean r104 = (Boolean) new y36.a(r103.f246439g.f544443a, "show_loading", null).f565862b;
        if (r104 == null) goto L16;
        r102 = r104.booleanValue();
    L16:
        Long r105 = (Long) new y36.f(r103.f246439g.f544443a, com.bytedance.android.ec.core.event.a.KEY_LOADING_DURATION, null).f565862b;
        if (r105 == null) goto L19;
        long r106 = r105.longValue();
    L20:
        BulletContext r107 = getBulletContext();
        if (r107 == null) goto L27;
        com.bytedance.ies.bullet.core.e r108 = r107.f246455w;
        if (r108 == null) goto L27;
        if (r108.f246473a != true) goto L27;
        boolean r109 = true;
    L28:
        if (r109 == true) goto L30;
    L39:
        this.f248229J = false;
        u(r102, r106);
        return;
    L30:
        if (this.f248217v.get() == LoadStatus.FAIL.ordinal()) goto L33;
        r112 = false;
    L33:
        if (r112 == false) goto L39;
        F();
        if (r106 == 0) goto L41;
        View r113 = getLoadingView();
        if (r113 == null) goto L42;
        r113.postDelayed(new l(this), r106);
        return;
    L42:
        return;
    L41:
        return;
    L27:
        r109 = false;
    L19:
        r106 = 0;
        goto L20
    L8:
        if (getMCurrentScene() == Scenes.Card) goto L10;
        r102 = true;
        goto L11
    }

    @Override // com.bytedance.ies.bullet.ui.common.BulletCardView, com.bytedance.ies.bullet.core.s
    public final void gQ(Uri r100, o r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        super.gQ(r100, r101);
    }

    @Override // com.bytedance.ies.bullet.ui.common.BulletCardView, com.bytedance.ies.bullet.core.s
    public final void go(Uri r100, o r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        super.go(r100, r101);
        B();
        this.f248229J = true;
        TimerTask r102 = this.H;
        if (r102 == null) goto L5;
        r102.cancel();
        this.H = null;
    L5:
        Timer r103 = this.G;
        if (r103 == null) goto L8;
        r103.cancel();
        this.G = null;
    L8:
        x();
        w();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.Lambda] */
    @Override // com.bytedance.ies.bullet.ui.common.BulletCardView, com.bytedance.ies.bullet.core.s
    public final void onLoadFail(Uri r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter(r101, "e");
        super.onLoadFail(r100, r101);
        B();
        boolean r102 = true;
        this.f248229J = true;
        TimerTask r103 = this.H;
        View r104 = null;
        String r105 = null;
        View r106 = null;
        r106 = null;
        r106 = null;
        r104 = null;
        r104 = null;
        if (r103 == null) goto L5;
        r103.cancel();
        this.H = null;
    L5:
        Timer r107 = this.G;
        if (r107 == null) goto L8;
        r107.cancel();
        this.G = null;
    L8:
        x();
        o r108 = getKitView();
        if (r108 == null) goto L12;
        SccConfig.SccLevel r109 = r108.i();
        if (r109 == null) goto L12;
    L13:
        int r110 = a.f248230a[r109.ordinal()];
        String r111 = "popup";
        if (r110 != 1) goto L16;
        View r112 = this.P;
        if (r112 == null) goto L87;
        y(r112);
    L99:
        View r113 = this.P;
        if (r113 == null) goto L108;
        r113.setVisibility(0);
        addView(r113);
        return;
    L108:
        return;
    L87:
        if (getMCurrentScene() == Scenes.PopupFragment) goto L90;
        r111 = "page";
    L90:
        BulletContext r114 = getBulletContext();
        if (r114 == null) goto L97;
        com.bytedance.ies.bullet.secure.e r115 = com.bytedance.ies.bullet.core.g.a(r114);
        if (r115 == null) goto L97;
        Function3<? super Context, ? super String, ? super Function0<Unit>, ? extends View> r116 = r115.f247755b;
        if (r116 == null) goto L97;
        r104 = r116.invoke(getContext(), r111, new BulletContainerView$showSecureNoticeView$1(this));
    L97:
        this.P = r104;
        goto L99
    L16:
        if (r110 == 2) goto L65;
        BulletContext r117 = getBulletContext();
        if (r117 == null) goto L103;
        t36.j r118 = r117.f246439g;
        if (r118 == null) goto L104;
        t36.d r119 = r118.f544443a;
        if (r119 != null) goto L24;
        return;
    L24:
        if (getMCurrentScene() != Scenes.Container) goto L26;
    L28:
        r102 = false;
    L30:
        if (Intrinsics.areEqual(new y36.a(r119, "show_error", Boolean.valueOf(r102)).f565862b, Boolean.TRUE) == true) goto L32;
        return;
    L32:
        if (getMCurrentScene() == Scenes.PopupFragment) goto L35;
        r111 = "page";
    L35:
        p0 r120 = this.M;
        if (r120 == null) goto L45;
        com.bytedance.ies.bullet.service.base.i r121 = r120.n(getContext(), r111);
        if (r121 == 0) goto L45;
        View r122 = r121.a(this.N, this.O);
        FrameLayout.LayoutParams r123 = r120.c0(r111);
        if (r123 == null) goto L42;
        C(r122, r123);
        Unit r124 = Unit.INSTANCE;
    L43:
        if (r124 != null) goto L45;
        E(this, r122);
        goto L45
    L42:
        r124 = null;
    L45:
        this.M = null;
        View r125 = this.K;
        boolean r126 = r125 instanceof com.bytedance.ies.bullet.service.base.i;
        if (r126 == false) goto L52;
        if (r126 == false) goto L49;
        com.bytedance.ies.bullet.service.base.i r127 = (com.bytedance.ies.bullet.service.base.i) r125;
    L50:
        if (r127 == null) goto L55;
        r127.show();
    L55:
        BulletContext r128 = getBulletContext();
        if (r128 == null) goto L60;
        AbsBulletMonitorCallback r129 = r128.f246435c;
        if (r129 == null) goto L60;
        r129.M();
    L60:
        ExecutorService r130 = BulletLogger.f247763a;
        BulletContext r131 = getBulletContext();
        if (r131 == null) goto L63;
        r105 = r131.getSessionId();
    L63:
        BulletLogger.g(r105, "show error page", "XView", 8);
        return;
    L49:
        r127 = null;
        goto L50
    L52:
        if (r125 == 0) goto L55;
        r125.setVisibility(0);
        goto L55
    L26:
        if (getMCurrentScene() == Scenes.Card) goto L28;
    L104:
        return;
    L103:
        return;
    L65:
        View r132 = this.Q;
        if (r132 == null) goto L68;
        y(r132);
    L80:
        View r133 = this.Q;
        if (r133 == null) goto L107;
        r133.setVisibility(0);
        addView(r133);
        return;
    L107:
        return;
    L68:
        if (getMCurrentScene() == Scenes.PopupFragment) goto L71;
        r111 = "page";
    L71:
        BulletContext r134 = getBulletContext();
        if (r134 == null) goto L78;
        com.bytedance.ies.bullet.secure.e r135 = com.bytedance.ies.bullet.core.g.a(r134);
        if (r135 == null) goto L78;
        Function3<? super Context, ? super String, ? super Function0<Unit>, ? extends View> r136 = r135.f247754a;
        if (r136 == null) goto L78;
        r106 = r136.invoke(getContext(), r111, new BulletContainerView$showSecureDenyView$1(this));
    L78:
        this.Q = r106;
    L12:
        r109 = SccConfig.SccLevel.SAFE;
        goto L13
    }

    public final void u(boolean r100, long r101) {
        if (this.G != null) goto L12;
        if (r100 == false) goto L13;
        this.G = new PthreadTimer("BulletContainerView");
        TimerTask r102 = this.H;
        if (r102 == null) goto L8;
        r102.cancel();
    L8:
        b r103 = new b(this, r101);
        this.H = r103;
        Timer r104 = this.G;
        if (r104 == null) goto L14;
        r104.schedule(r103, this.I);
        return;
    L14:
        return;
    L13:
        return;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.ies.bullet.ui.common.BulletContainerView$errorReloadMethod$1, kotlin.jvm.internal.Lambda] */
    public BulletContainerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.I = 500;
        this.O = new BulletContainerView$errorReloadMethod$1(this);
        setMCurrentScene(Scenes.Container);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.bytedance.ies.bullet.ui.common.BulletContainerView$setErrorView$1, kotlin.jvm.internal.Lambda] */
    public final void D(p0 r100, Function0<Unit> r101, final Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "errorView");
        this.M = r100;
        this.N = r101;
        this.O = new BulletContainerView$setErrorView$1(this, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ies.bullet.ui.common.BulletCardView, com.bytedance.ies.bullet.core.s
    public final void bK(Uri r100, o r101, t36.j r102) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter(r102, "schemaModelUnion");
        super.bK(r100, r101, r102);
        t36.f r103 = r102.f544444b;
        Drawable r104 = null;
        if ((r103 instanceof v36.a) == false) goto L5;
        v36.a r105 = (v36.a) r103;
    L6:
        if (r105 == null) goto L40;
        this.R = r105;
        if (r105.i().f565861a == false) goto L14;
        if (Intrinsics.areEqual(r105.i().f565862b, Boolean.TRUE) == false) goto L12;
        this.f248229J = false;
        u(true, 0);
    L20:
        v36.a r106 = this.R;
        if (r106 == null) goto L26;
        r r107 = r106.e();
        if (r107 == null) goto L26;
        Integer r108 = (Integer) r107.f565862b;
        if (r108 == null) goto L26;
    L32:
        if (r108 == null) goto L41;
        int r109 = r108.intValue();
        Drawable r110 = getBackground();
        if (r110 == null) goto L38;
        Drawable.ConstantState r111 = r110.getConstantState();
        if (r111 == null) goto L38;
        r104 = r111.newDrawable();
    L38:
        this.S = r104;
        this.T = true;
        setBackgroundColor(r109);
        return;
    L41:
        return;
    L26:
        v36.a r112 = this.R;
        if (r112 == null) goto L31;
        r r113 = r112.b();
        if (r113 == null) goto L31;
        r108 = (Integer) r113.f565862b;
    L31:
        r108 = null;
        goto L32
    L12:
        x();
        goto L20
    L14:
        if (getMCurrentScene() != Scenes.Container) goto L16;
    L19:
        x();
        goto L20
    L16:
        if (getMCurrentScene() == Scenes.Card) goto L19;
        this.f248229J = false;
        u(true, 0);
        goto L20
    L40:
        return;
    L5:
        r105 = null;
        goto L6
    }

    public /* synthetic */ BulletContainerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // com.bytedance.ies.bullet.ui.common.BulletCardView
    public final void g(Uri r100, Bundle r101, BulletContext r102, m16.b r110, com.bytedance.ies.bullet.core.q r111) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        if (r110 != null) goto L5;
        r110 = new m16.b();
    L5:
        m16.b r103 = r110;
        r103.g(BulletContainerView.class, this);
        super.g(r100, r101, r102, r103, r111);
    }

    @Override // com.bytedance.ies.bullet.ui.common.BulletCardView, h16.e
    public final void Wn(View r100, int r101, int r102, int r103, int r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, "loadingView");
        View r106 = this.F;
        if (r106 == null) goto L5;
        removeView(r106);
    L5:
        FrameLayout.LayoutParams r107 = new FrameLayout.LayoutParams(-2, -2);
        r107.leftMargin = r102;
        r107.rightMargin = r104;
        r107.topMargin = r103;
        r107.bottomMargin = r105;
        r107.gravity = r101;
        r100.setLayoutParams(r107);
        r100.setVisibility(8);
        addView(r100);
        this.F = r100;
    }
}

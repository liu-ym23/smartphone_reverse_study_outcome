package com.bytedance.ee.bear.tts.lynx.view;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.lark.dependency.g;
import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import com.bytedance.ee.bear.tts.TtsResult;
import com.bytedance.ee.bear.tts.lynx.bean.TtsLynxPlayerStyle;
import com.bytedance.ee.bear.tts.view.FloatViewContainer;
import com.bytedance.ee.util.ui.n;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class TtsLynxFloatView extends FrameLayout {
    public final Lazy a;
    public final Lazy b;
    public no5.c c;
    public mo5.a d;
    public CCMLynxCardView e;
    public FloatViewContainer f;

    public static final class a {
    }

    public static final class b implements mo5.c {
        public b() {
        }

        @Override // mo5.c
        public final void a(TtsResult r3) {
            Intrinsics.checkNotNullParameter(r3, "result");
            tt5.a.h("TtsLynxFloatView", "TtsLynxFloatViewResultHandler-onResult, ignored result: " + r3);
        }
    }

    public static final class c {
        public c() {
        }
    }

    static {
    }

    private final g getCoreDependency() {
        return (g) this.a.getValue();
    }

    private final b getResultHandler() {
        return (b) this.b.getValue();
    }

    public final void a() {
        tt5.a.h("TtsLynxFloatView", "removeFromFloatView");
        getCoreDependency().W0();
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        FloatViewContainer r1 = this.f;     // Catch: Throwable -> L9
        if (r1 == null) goto L6;
        r1.b(this);     // Catch: Throwable -> L9
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Result.constructor-impl(r2);     // Catch: Throwable -> L9
        return;
    L6:
        r2 = null;
    L9:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        tt5.a.h("TtsLynxFloatView", "initLynxView");
        CCMLynxCardView r1 = this.e;
        if (r1 == null) goto L5;
        r1.destroy();
    L5:
        oo5.c r3 = null;
        CCMLynxCardView r2 = (CCMLynxCardView) org.koin.java.a.b(CCMLynxCardView.class, null, new TtsLynxFloatView$initLynxView$lynxView$1(this));
        this.e = r2;
        no5.a r4 = no5.a.a;
        mo5.a r5 = this.d;
        no5.c r6 = this.c;
        if (r6 == null) goto L8;
        oo5.a r7 = r6.d;
    L9:
        if (r6 == null) goto L11;
        r3 = r6.e;
    L11:
        r4.getClass();
        oo5.d r8 = no5.a.b(r5, r7, r3);
        TtsLynxPlayerStyle r9 = TtsLynxPlayerStyle.FLOAT_VIEW;
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        r8.h = r9;
        CCMLynxCardView.a.a(r2, this, 9, r8.a(), new ViewGroup.LayoutParams(n.d(64), n.d(90)));
        CCMLynxCardView r10 = this.e;
        if (r10 != null) goto L15;
        tt5.a.k("TtsLynxFloatView", "onAttachedToWindow, lynxView is null.");
        return;
    L15:
        no5.c r11 = this.c;
        if (r11 != null) goto L19;
        tt5.a.k("TtsLynxFloatView", "onAttachedToWindow, viewModel is null.");
        return;
    L19:
        r11.e(r10);
        return;
    L8:
        r7 = null;
        goto L9
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mo5.a r0 = this.d;
        if (r0 == null) goto L5;
        r0.c(getResultHandler());
    L5:
        no5.c r1 = this.c;
        if (r1 == null) goto L8;
        r1.d();
    L8:
        CCMLynxCardView r2 = this.e;
        if (r2 == null) goto L11;
        tt5.a.h("TtsLynxFloatView", "destroyLynxView, remove lynxView.");
        r2.destroy();
        removeAllViews();
        this.e = null;
        return;
    L11:
        tt5.a.h("TtsLynxFloatView", "destroyLynxView, already destroyed.");
    }

    public TtsLynxFloatView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = LazyKt.lazy(LazyThreadSafetyMode.NONE, TtsLynxFloatView$coreDependency$2.INSTANCE);
        this.b = LazyKt.lazy(TtsLynxFloatView$resultHandler$2.INSTANCE);
        new c();
        int r3 = n.d(5);
        setPadding(r3, r3, r3, r3);
    }

    public final boolean b(mo5.a r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "albumVM");
        if (this.d == null) goto L5;
    L22:
        tt5.a.k("TtsLynxFloatView", "show, already showing.");
        return false;
    L5:
        if (this.c != null) goto L22;
        r5.l(getResultHandler());
        this.d = r5;
        no5.c r0 = new no5.c("TtsLynxFloatView", getContext(), r5);
        oo5.a r7 = new oo5.a();
        r7.a = 64.0f;
        r7.b = 90.0f;
        r0.d = r7;
        this.c = r0;
        if (r6 == true) goto L19;
        FloatViewContainer r8 = this.f;
        if (r8 != null) goto L12;
        r8 = new FloatViewContainer(getContext(), null, 6, 0);
    L12:
        this.f = r8;
        Intrinsics.checkNotNullParameter(this, "view");
        if (getParent() != null) goto L15;
        r8.addView(this);
    L15:
        r8.a();
        com.ss.android.lark.appcontext.applifecycle.a r9 = r8.j;
        if (r9 != null) goto L18;
        r9 = new uo5.c(r8);
    L18:
        r8.j = r9;
        AppLifecycle.a.a.b(r9);
        return true;
    L19:
        g r10 = getCoreDependency();
        int r11 = com.bytedance.ee.bear.tts.lynx.view.a.a;
        r10.S0();
        return true;
    }
}

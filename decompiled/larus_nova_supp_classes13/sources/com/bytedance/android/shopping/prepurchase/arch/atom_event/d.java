package com.bytedance.android.shopping.prepurchase.arch.atom_event;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.android.ui.ec.widget.loading.ECDuxLoadingAnimationView;
import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d extends t96.a {
    public ViewGroup c;
    public LoadingStatus d;
    public boolean e;
    public final Context f;

    public final com.bytedance.kmp.ec.yata.chain.event.b c() {
        ViewGroup r0 = this.c;
        if (r0 != null) goto L6;
        int r1 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    L6:
        ViewParent r4 = r0.getParent();
        if ((r4 instanceof ViewGroup) == false) goto L9;
        ((ViewGroup) r4).removeView(r0);
    L9:
        this.c = null;
        int r2 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    }

    public final void onDestroy() {
        c();
    }

    public d(Context r3) {
        Intrinsics.checkNotNullParameter("showLoading", "name");
        Intrinsics.checkNotNullParameter(r3, "context");
        super("showLoading");
        this.f = r3;
        this.d = LoadingStatus.HIDE;
    }

    public final void b(EventContext r12, Function1<? super com.bytedance.kmp.ec.yata.chain.event.b, Unit> r13) {
        Intrinsics.checkNotNullParameter(r12, "eventContext");
        Intrinsics.checkNotNullParameter(r13, "completion");
        Map r14 = r12.k;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L20
        if (r14 == null) goto L8;
        Object r4 = r14.get("loading_status");     // Catch: Throwable -> L20
        if (r4 == null) goto L8;
        Integer r5 = ECHybridExtensionsKt.i(r4);     // Catch: Throwable -> L20
    L9:
        if (r5 != null) goto L12;
    L14:
        boolean r6 = false;
    L15:
        if (r6 == false) goto L17;
        LoadingStatus r7 = LoadingStatus.SHOW;     // Catch: Throwable -> L20
    L18:
        Object r8 = Result.constructor-impl(r7);     // Catch: Throwable -> L20
    L23:
        if (Result.isFailure-impl(r8) == false) goto L25;
        r8 = null;
    L25:
        LoadingStatus r9 = (LoadingStatus) r8;
        if (r9 != null) goto L28;
        r9 = LoadingStatus.HIDE;
    L28:
        this.d = r9;
        if (r14 != null) goto L98;
        Object r15 = null;
    L35:
        if ((r15 instanceof Boolean) == true) goto L37;
        r15 = null;
    L37:
        Object r16 = Result.constructor-impl((Boolean) r15);     // Catch: Throwable -> L31
    L41:
        if (Result.isFailure-impl(r16) == false) goto L43;
        r16 = null;
    L43:
        Boolean r17 = (Boolean) r16;
        if (r17 == null) goto L46;
        boolean r18 = r17.booleanValue();
    L47:
        this.e = r18;
        int r19 = c.a[this.d.ordinal()];
        if (r19 != 1) goto L50;
        Context r110 = this.f;
        if ((r110 instanceof Activity) == true) goto L57;
        r110 = null;
    L57:
        Activity r10 = (Activity) r110;
        if (r10 != null) goto L61;
        int r111 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        com.bytedance.kmp.ec.yata.chain.event.b r112 = com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "context is not Activity", null, null, 57);
    L94:
        r13.invoke(r112);
        return;
    L61:
        if (r10.isFinishing() == false) goto L63;
    L93:
        int r113 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r112 = com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "activity is finishing or destroyed", null, null, 57);
        goto L94
    L63:
        if (r10.isDestroyed() == true) goto L93;
        ViewGroup r114 = this.c;
        if (r114 == null) goto L68;
        ViewParent r115 = r114.getParent();
    L70:
        if (r115 == null) goto L78;
        ViewGroup r116 = this.c;
        if (r116 == null) goto L74;
        r116.setClickable(this.e);
    L74:
        ViewGroup r117 = this.c;
        if (r117 == null) goto L77;
        r117.setFocusable(this.e);
    L77:
        int r118 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r112 = com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
        goto L94
    L78:
        Window r119 = r10.getWindow();
        if (r119 == null) goto L85;
        View r120 = r119.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L87;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r11 = ThreadMethodProxy.currentThread();
        if (r11 == com.larus.home.impl.utils.c.a) goto L87;
        com.larus.home.impl.utils.c.a(r11, "getDecorView");
    L87:
        if ((r120 instanceof ViewGroup) == true) goto L89;
        r120 = null;
    L89:
        ViewGroup r121 = (ViewGroup) r120;
        if (r121 != null) goto L92;
        int r122 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r112 = com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "decorView is not ViewGroup", null, null, 57);
        goto L94
    L92:
        FrameLayout r20 = new FrameLayout(r10);
        r20.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r20.setBackgroundColor(0);
        r20.setClickable(this.e);
        r20.setFocusable(this.e);
        r20.addView(new ECDuxLoadingAnimationView(r10, null, 0, 6, null), new FrameLayout.LayoutParams(-2, -2, 17));
        r121.addView(r20);
        this.c = r20;
        int r123 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r112 = com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
        goto L94
    L85:
        r120 = null;
        goto L87
    L68:
        r115 = null;
        goto L70
    L50:
        if (r19 != 2) goto L53;
        r112 = c();
        goto L94
    L53:
        throw new NoWhenBranchMatchedException();
    L46:
        r18 = false;
    L31:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L41
    L98:
        r15 = r14.get("block_opt");     // Catch: Throwable -> L31
        goto L35
    L17:
        r7 = LoadingStatus.HIDE;     // Catch: Throwable -> L20
        goto L18
    L12:
        if (r5.intValue() != 1) goto L14;
        r6 = true;
    L8:
        r5 = null;
    L20:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    }
}

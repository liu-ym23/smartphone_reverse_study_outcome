package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import android.content.Context;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.x1;
import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.rxbus.RxBusAbility;
import com.bytedance.ies.sdk.widgets.Widget;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class q0 implements Runnable {
    public final /* synthetic */ RealTimeChorusMainViewWidget a;
    public final /* synthetic */ boolean b;

    public q0(RealTimeChorusMainViewWidget r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        Guideline r0 = this.a.w;
        ViewGroup.LayoutParams r1 = null;
        if (r0 == null) goto L5;
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
    L7:
        if ((r2 instanceof ConstraintLayout.LayoutParams) == false) goto L10;
        r1 = r2;
    L10:
        ConstraintLayout.LayoutParams r3 = (ConstraintLayout.LayoutParams) r1;
        if (r3 == null) goto L13;
        int r4 = r3.guideBegin;
    L14:
        ConstraintLayout r5 = this.a.t;
        if (r5 == null) goto L19;
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        if (r6 == null) goto L19;
        int r7 = r6.height;
    L20:
        int r8 = r4 + r7;
        RealTimeChorusMainViewWidget r9 = this.a;
        Context r10 = ((Widget) r9).context;
        if (r10 != null) goto L23;
        int r11 = 0;
    L24:
        ViewGroup r12 = ((Widget) r9).containerView;
        if (r12 == null) goto L27;
        int r13 = r12.getHeight();
    L28:
        int r14 = r11 - r13;
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L38;
        int r15 = x1.k();
        boolean r16 = StatusBarUtil.isStatusBarTransparent();
        if (r15 <= r14) goto L34;
        boolean r17 = true;
    L35:
        if (r16 == false) goto L38;
        if (r17 == false) goto L38;
        boolean r18 = true;
    L39:
        if (r18 == false) goto L41;
        int r19 = RealTimeChorusMainViewWidget.xq(this.a, this.b) + s1.f(20.0f);
    L42:
        int r20 = r8 + r19;
        ALogger.i("RealTimeChorusMainViewWidget", "refreshMatchScreenHeight: finalPosition=" + r20 + ", hasFixedGuest=" + this.b);
        InteractionWidgetsPosContext r21 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, ((Widget) this.a).dataCenter, 0, 2);
        if (r21 == null) goto L51;
        com.bytedance.live.datacontext.m r22 = r21.getKtvChorusBottomPos();
        if (r22 == null) goto L51;
        this.a.getClass();
        if (r20 > 0) goto L50;
        r20 = s1.r() - UtilityKotlinExtentionsKt.i(230);
    L50:
        r22.setValue(Integer.valueOf(r20));
    L51:
        RxBusAbility.INSTANCE.getRxBus(((Widget) this.a).dataCenter).post(new o42.c(false, true, "ktv_chorus"));
        return;
    L41:
        r19 = RealTimeChorusMainViewWidget.xq(this.a, this.b);
        goto L42
    L34:
        r17 = false;
    L38:
        r18 = false;
        goto L39
    L27:
        r13 = 0;
        goto L28
    L23:
        r11 = x1.i(ContextUtil.contextToActivity(r10)).heightPixels;
    L19:
        r7 = 0;
        goto L20
    L13:
        r4 = 0;
        goto L14
    L5:
        r2 = null;
        goto L7
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

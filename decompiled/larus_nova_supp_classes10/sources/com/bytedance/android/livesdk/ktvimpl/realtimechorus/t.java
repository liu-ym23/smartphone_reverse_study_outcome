package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.util.KSongTuningPanelHelperKt;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedStreamIndex;
import com.bytedance.live.livelink.kmp.impl.extend.chorus.ChorusManager;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class t extends AnimatorListenerAdapter {
    public final /* synthetic */ RealTimeChorusBusinessWidget a;
    public final /* synthetic */ Ref.ObjectRef b;
    public final /* synthetic */ boolean c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r4) {
        Intrinsics.checkNotNullParameter(r4, "animation");
        super.onAnimationEnd(r4);
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r5 = KSongTuningPanelHelperKt.d();
        if (r5 == null) goto L6;
        RealTimeChorusBusinessWidget r0 = this.a;
        int r1 = RealTimeChorusBusinessWidget.V0;
        r5.m(r0.Lq(), false, true);
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r6) {
        Intrinsics.checkNotNullParameter(r6, "animation");
        super.onAnimationStart(r6);
        ei6.a r7 = (ei6.a) this.b.element;
        if (r7 == null) goto L8;
        ri6.b r8 = r7.r();
        if (r8 == null) goto L8;
        RealTimeChorusBusinessWidget r1 = this.a;
        int r2 = RealTimeChorusBusinessWidget.V0;
        r8.s(bj6.a.b(r1.Z0()), false);
    L8:
        if (KtvSettingHelper.q().m() == false) goto L17;
        if (this.a.i0() != 1) goto L17;
        ei6.a r9 = (ei6.a) this.b.element;
        if (r9 == null) goto L17;
        ri6.b r10 = r9.r();
        if (r10 == null) goto L17;
        String r3 = bj6.a.a((ei6.a) this.b.element);
        LiveWrappedStreamIndex r4 = LiveWrappedStreamIndex.STREAM_INDEX_3RD;
        zf2.d r5 = new zf2.d();
        r5.a = true;
        r5.c = false;
        r5.b = false;
        Unit r0 = Unit.INSTANCE;
        r10.r(r3, r4, r5);
    L17:
        if (KtvSettingHelper.q().k() == false) goto L19;
        return;
    L19:
        if (this.c == false) goto L27;
        ei6.a r11 = (ei6.a) this.b.element;
        if (r11 == null) goto L28;
        ChorusManager r12 = r11.i();
        if (r12 == null) goto L29;
        r12.x(true);
        return;
    L29:
        return;
    L28:
        return;
    }

    public t(RealTimeChorusBusinessWidget r1, Ref.ObjectRef r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}

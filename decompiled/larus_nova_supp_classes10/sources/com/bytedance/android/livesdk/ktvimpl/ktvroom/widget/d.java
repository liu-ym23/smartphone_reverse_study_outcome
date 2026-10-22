package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.ktv.common.model.bean.ChallengeChangeType;
import com.bytedance.android.live.ktv.common.model.bean.SwitchStatus;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvChallengeDataContext;
import com.bytedance.android.livesdk.r3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ l a;
    public final /* synthetic */ Context b;

    public d(l r1, Context r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r18) {
        KtvChallengeDataContext.a r1 = KtvChallengeDataContext.Companion;
        if (r1 == null) goto L5;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a r2 = r1.a();
    L7:
        if (r2 != null) goto L9;
    L13:
        Context r3 = com.bytedance.android.live.core.utils.a.d();
        if (r3 != null) goto L17;
        r3 = this.b;
    L17:
        ne2.a.e(r3, "challenge_icon");
    L18:
        l r4 = this.a;
        if (r2 != null) goto L21;
    L23:
        String r5 = "演唱挑战关";
    L24:
        r3.a(r4, r5);
        return;
    L21:
        if (r2.isKtvChallengeOpen() != true) goto L23;
        r5 = "演唱挑战开";
        goto L24
    L9:
        if (r2.isKtvChallengeOpen() != true) goto L13;
        me2.a r6 = r2.getChallengeConfig();
        if (r6 == null) goto L18;
        KtvContext.Companion.getClass();
        KtvContext.a.g().getPrepareChallengeEvent().post(new me2.b(r6.c, r6.d, ChallengeChangeType.SWITCH_TURN_OFF, SwitchStatus.CLOSE.getValue(), "challenge_icon", null, 0, 352));
        goto L18
    L5:
        r2 = null;
        goto L7
    }
}

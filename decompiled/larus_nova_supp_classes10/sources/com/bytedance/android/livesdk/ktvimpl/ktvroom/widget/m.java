package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import android.content.Context;
import android.view.View;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.midi.KtvOpusMicLabelAnim;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomViewModel;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.qd;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class m implements View.OnClickListener {
    public final /* synthetic */ KtvOpusMicLabelAnim a;
    public final /* synthetic */ KtvInteractElementWidget b;

    public m(KtvOpusMicLabelAnim r1, KtvInteractElementWidget r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        int r7 = ue2.b.a;
        Context r8 = this.a.getContext();
        String r1 = null;
        String r0 = KtvRoomViewModel.getCurSingerName$default(this.b.xq(), null, 1, null);
        InteractiveSongUserInfo r2 = this.b.xq().currentSongUser();
        if (r2 == null) goto L5;
        String r3 = r2.getIdString();
    L6:
        ue2.b.a(r8, r0, r3, "ktv_stage", "1");
        KtvInteractElementWidget r9 = this.b;
        KtvOpusMicLabelAnim r4 = r9.x;
        if (r4 == null) goto L24;
        qd r10 = (qd) r9.xq().getKtvMicLabelEvent().getValue();
        if (r10 == null) goto L11;
        r1 = r10.d;
    L11:
        Long r11 = KtvLoggerHelper.a;
        String r12 = "";
        if (r1 != null) goto L14;
        String r5 = "";
    L16:
        if (Intrinsics.areEqual(r4.e.getIdString(), r1) == false) goto L18;
        String r13 = "oneself";
    L19:
        IRoom r14 = r4.d;
        if (r14 == null) goto L22;
        r12 = com.bytedance.android.live.ktv.common.util.j.f(r14);
    L22:
        KtvLoggerHelper.J("ktv_stage", r5, r13, r12);
        return;
    L18:
        r13 = "others";
        goto L19
    L14:
        r5 = r1;
        goto L16
    L24:
        return;
    L5:
        r3 = null;
        goto L6
    }
}

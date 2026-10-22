package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import android.content.Context;
import android.view.View;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.midi.KtvMvMidiMicLabelAnim;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomViewModel;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.qd;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class z1 implements View.OnClickListener {
    public final /* synthetic */ KtvMvMidiMicLabelAnim a;
    public final /* synthetic */ KtvStageWidget b;
    public final /* synthetic */ KtvRoomViewModel c;

    public z1(KtvMvMidiMicLabelAnim r1, KtvStageWidget r2, KtvRoomViewModel r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        int r7 = ue2.b.a;
        Context r8 = this.a.getContext();
        String r1 = null;
        String r0 = KtvRoomViewModel.getCurSingerName$default(this.c, null, 1, null);
        InteractiveSongUserInfo r2 = this.c.currentSongUser();
        if (r2 == null) goto L5;
        String r3 = r2.getIdString();
    L6:
        ue2.b.a(r8, r0, r3, "ktv_stage", "1");
        KtvMvMidiMicLabelAnim r9 = this.b.k;
        if (r9 == null) goto L24;
        qd r4 = (qd) this.c.getKtvMicLabelEvent().getValue();
        if (r4 == null) goto L11;
        r1 = r4.d;
    L11:
        Long r5 = KtvLoggerHelper.a;
        String r10 = "";
        if (r1 != null) goto L14;
        String r11 = "";
    L16:
        if (Intrinsics.areEqual(r9.e.getIdString(), r1) == false) goto L18;
        String r12 = "oneself";
    L19:
        IRoom r13 = r9.d;
        if (r13 == null) goto L22;
        r10 = com.bytedance.android.live.ktv.common.util.j.f(r13);
    L22:
        KtvLoggerHelper.J("ktv_stage", r11, r12, r10);
        return;
    L18:
        r12 = "others";
        goto L19
    L14:
        r11 = r1;
        goto L16
    L24:
        return;
    L5:
        r3 = null;
        goto L6
    }
}

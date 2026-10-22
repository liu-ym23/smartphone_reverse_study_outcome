package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import android.view.View;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.util.KSongTuningPanelHelperKt;
import com.bytedance.android.livesdk.ktvimpl.base.util.KtvUtilsKt;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomViewModel;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.r3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j implements View.OnClickListener {
    public final /* synthetic */ l a;

    public j(l r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r6 = KSongTuningPanelHelperKt.d();
        if (r6 != null) goto L5;
    L7:
        boolean r7 = false;
    L8:
        l r2 = this.a;
        if (r7 == false) goto L11;
        String r3 = "原唱开";
    L12:
        r3.a(r2, r3);
        l r4 = this.a;
        boolean r8 = !r7;
        KtvRoomViewModel r1 = r4.u;
        if (r1 == null) goto L17;
        KtvRoomLyricsStateMachineConfig.d r9 = r1.getCurState();
        if (r9 == null) goto L17;
        MusicPanel r10 = r9.b();
    L19:
        if (KtvUtilsKt.h(r10) == false) goto L21;
        f2.c(com.bytedance.android.live.core.utils.s1.B(2131897379), 0);
        return;
    L21:
        if (r10 != null) goto L23;
    L28:
        r4.i.setSelected(r8);
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d r0 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d) r4.t.getKtvSingerViewModel().getValue();
        if (r0 == null) goto L31;
        r0.toggleOrigin(r8);
    L31:
        oe2.b r11 = (oe2.b) r4.t.getKtvRoomProvider().getValue();
        if (r11 == null) goto L37;
        r11.f(r8);
        return;
    L37:
        return;
    L23:
        if (com.bytedance.android.live.ktv.common.util.KtvUtilsKt.D(r10) == true) goto L28;
        if (r8 == true) goto L26;
        int r12 = 2131918458;
    L27:
        f2.b(r12, 0);
        return;
    L26:
        r12 = 2131918460;
    L17:
        r10 = null;
        goto L19
    L11:
        r3 = "原唱关";
        goto L12
    L5:
        if (r6.R() != true) goto L7;
        r7 = true;
        goto L8
    }
}

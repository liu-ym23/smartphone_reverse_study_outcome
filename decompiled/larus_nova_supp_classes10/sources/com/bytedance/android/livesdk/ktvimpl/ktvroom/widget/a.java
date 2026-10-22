package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import android.view.View;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomViewModel;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ l a;

    public a(l r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        KtvRoomViewModel r11 = this.a.u;
        if (r11 == null) goto L13;
        KtvRoomLyricsStateMachineConfig.d r12 = r11.getCurState();
        if (r12 == null) goto L14;
        MusicPanel r13 = r12.b();
        if (r13 == null) goto L15;
        KtvMusic r0 = r13.a;
        if (r0 != null) goto L11;
        return;
    L11:
        com.bytedance.live.datacontext.k<com.bytedance.android.livesdk.ktvimpl.mv.opus.model.a> r1 = this.a.getKtvContext().getOpenOpusPreViewDialog();
        com.bytedance.android.livesdk.ktvimpl.mv.opus.model.a r8 = new com.bytedance.android.livesdk.ktvimpl.mv.opus.model.a(r0.getMId(), r0.getOrderUserIdString(), false, "request_song");
        r8.a = r13;
        Unit r14 = Unit.INSTANCE;
        r1.post(r8);
        return;
    L15:
        return;
    L14:
        return;
    }
}

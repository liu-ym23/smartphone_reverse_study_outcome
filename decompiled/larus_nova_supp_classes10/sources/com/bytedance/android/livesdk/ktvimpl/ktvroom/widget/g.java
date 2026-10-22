package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import android.content.Context;
import android.content.DialogInterface;
import com.bytedance.android.live.ktv.common.ordersong.feedback.KtvMusicFeedbackDialog;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.KtvModeOrderSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.dialog.KtvRoomFeedbackGuideDialog;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import kotlin.ranges.LongRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g implements DialogInterface.OnClickListener {
    public final /* synthetic */ l a;
    public final /* synthetic */ boolean b;

    public g(l r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r8, int r9) {
        r8.dismiss();
        if (this.b == false) goto L45;
        KtvContext r10 = this.a.getKtvContext();
        if (r10 == null) goto L11;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d> r11 = r10.getKtvSingerViewModel();
        if (r11 == null) goto L11;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d r12 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d) r11.getValue();
        if (r12 == null) goto L11;
        r12.cutMusic();
    L11:
        l r13 = this.a;
        KtvContext r0 = r13.t;
        if (r0 == null) goto L18;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.i> r1 = r0.getKtvCoreController();
        if (r1 == null) goto L18;
        com.bytedance.android.livesdk.ktvimpl.base.i r2 = (com.bytedance.android.livesdk.ktvimpl.base.i) r1.getValue();
        if (r2 == null) goto L18;
        Long r3 = Long.valueOf(r2.b());
    L19:
        Context r4 = com.bytedance.android.live.core.utils.a.d();
        if (r4 != null) goto L23;
        r4 = r13.getContext();
    L23:
        LongRange r5 = new LongRange(0, 30000);
        if (r3 != null) goto L26;
    L28:
        boolean r6 = false;
    L29:
        if (r6 == false) goto L56;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r14 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) r13.t.getKtvCoreViewModel().getValue();
        if (r14 == null) goto L35;
        KtvRoomLyricsStateMachineConfig.d r15 = r14.getCurState();
        if (r15 == null) goto L35;
        MusicPanel r16 = r15.b();
    L36:
        if (r16 == null) goto L57;
        int r7 = KtvRoomFeedbackGuideDialog.k;
        String r17 = r16.a.getMTitle();
        String r18 = "";
        if (r17 != null) goto L40;
        r17 = "";
    L40:
        String r19 = r16.a.getMAuthor();
        if (r19 == null) goto L44;
        r18 = r19;
    L44:
        KtvRoomFeedbackGuideDialog.a.a(new com.bytedance.android.live.ktv.common.ordersong.feedback.a(r17, r18), KtvMusicFeedbackDialog.FeedbackType.KSONG_SONG_INFO).W90(r4, null, true);
        return;
    L57:
        return;
    L35:
        r16 = null;
        goto L36
    L56:
        return;
    L26:
        if (r5.contains(r3.longValue()) == false) goto L28;
        r6 = true;
    L18:
        r3 = null;
        goto L19
    L45:
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r20 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) this.a.getKtvContext().getKtvCoreViewModel().getValue();
        if (r20 == null) goto L50;
        KtvRoomLyricsStateMachineConfig.d r21 = r20.getCurState();
        if (r21 == null) goto L50;
        MusicPanel r22 = r21.b();
    L51:
        if (r22 == null) goto L59;
        KtvModeOrderSongDataContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r23 = KtvModeOrderSongDataContext.Companion.a();
        if (r23 == null) goto L60;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d.a.b(r23, r22, null, 6);
        return;
    L60:
        return;
    L59:
        return;
    L50:
        r22 = null;
        goto L51
    }
}

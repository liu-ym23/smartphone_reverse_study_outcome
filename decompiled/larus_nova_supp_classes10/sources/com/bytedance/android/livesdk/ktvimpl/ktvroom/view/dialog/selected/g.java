package com.bytedance.android.livesdk.ktvimpl.ktvroom.view.dialog.selected;

import android.view.View;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.util.KSongOrderSongUtilKt;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.OrderInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ KtvRoomSelectedMusicViewHolder a;
    public final /* synthetic */ int b;
    public final /* synthetic */ wb0.a c;
    public final /* synthetic */ MusicPanel d;

    public g(KtvRoomSelectedMusicViewHolder r1, int r2, wb0.a r3, MusicPanel r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r13) {
        if (this.b != 1) goto L5;
        f2.b(2131918449, 0);
    L7:
        if (this.a.d4() == false) goto L10;
        String r14 = "anchor";
    L9:
        String r5 = r14;
        Long r15 = KtvLoggerHelper.a;
        String r16 = this.d.a.getMTitle();
        if (r16 != null) goto L20;
        r16 = "";
    L20:
        long r2 = this.d.a.getMId();
        OrderInfo r4 = this.d.a.getOrderInfo();
        if (r4 == null) goto L27;
        InteractiveSongUserInfo r6 = r4.getTopUser();
        if (r6 == null) goto L27;
        String r7 = r6.getIdString();
        if (r7 == null) goto L27;
    L28:
        String r8 = KSongOrderSongUtilKt.d(this.d);
        String r9 = this.d.b();
        String r10 = this.d.a.getMAuthor();
        if (r10 != null) goto L31;
        r10 = "";
    L31:
        String r1 = r16;
        KtvLoggerHelper.Y("sticky", r1, r2, r7, r5, r8, r9, r10, Intrinsics.areEqual(this.d.A, Boolean.TRUE), null, this.d);
        return;
    L27:
        r7 = "";
        goto L28
    L10:
        Integer r17 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r17 != null) goto L14;
    L15:
        r14 = "user";
        goto L9
    L14:
        if (r17.intValue() != 2) goto L15;
        r14 = "guest";
        goto L9
    L5:
        this.c.e(this.d);
        goto L7
    }
}

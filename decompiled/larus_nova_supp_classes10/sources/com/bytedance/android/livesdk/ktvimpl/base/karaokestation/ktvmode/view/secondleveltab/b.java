package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab;

import android.view.View;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.OrderInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ FloatingBottomView a;
    public final /* synthetic */ MusicPanel b;
    public final /* synthetic */ boolean c;

    public b(FloatingBottomView r1, MusicPanel r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r13) {
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r14 = this.a.getBaseOrderSongViewModel();
        if (r14 == null) goto L6;
        r14.pinMusic(this.b);
    L6:
        if (this.c == false) goto L9;
        String r15 = "anchor";
    L8:
        String r5 = r15;
        Long r16 = KtvLoggerHelper.a;
        String r17 = this.b.a.getMTitle();
        if (r17 != null) goto L19;
        r17 = "";
    L19:
        long r2 = this.b.a.getMId();
        OrderInfo r4 = this.b.a.getOrderInfo();
        if (r4 == null) goto L26;
        InteractiveSongUserInfo r6 = r4.getTopUser();
        if (r6 == null) goto L26;
        String r7 = r6.getIdString();
        if (r7 == null) goto L26;
    L27:
        String r8 = this.b.a.getAddSongSource();
        if (r8 != null) goto L30;
        r8 = "";
    L30:
        String r9 = this.b.b();
        String r10 = this.b.a.getMAuthor();
        if (r10 != null) goto L33;
        r10 = "";
    L33:
        String r1 = r17;
        KtvLoggerHelper.Y("sticky", r1, r2, r7, r5, r8, r9, r10, Intrinsics.areEqual(this.b.A, Boolean.TRUE), null, this.b);
        return;
    L26:
        r7 = "";
        goto L27
    L9:
        Integer r18 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r18 != null) goto L13;
    L14:
        r15 = "guest";
        goto L8
    L13:
        if (r18.intValue() != 0) goto L14;
        r15 = "user";
        goto L8
    }
}

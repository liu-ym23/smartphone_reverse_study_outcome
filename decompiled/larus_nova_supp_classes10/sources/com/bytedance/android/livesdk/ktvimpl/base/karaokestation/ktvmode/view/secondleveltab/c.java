package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab;

import android.view.View;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.ktvimpl.base.util.KtvUtilsKt;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.OrderInfo;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ FloatingBottomView a;
    public final /* synthetic */ MusicPanel b;

    public c(FloatingBottomView r1, MusicPanel r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r14) {
        if (FloatingBottomView.a(this.a) < 9) goto L5;
        f2.b(2131918533, 0);
    L15:
        FloatingBottomView r15 = this.a;
        r15.getClass();
        String r6 = FloatingBottomView.b(r15, FloatingBottomView.e());
        Long r16 = KtvLoggerHelper.a;
        String r17 = this.b.a.getMTitle();
        if (r17 != null) goto L18;
        String r2 = "";
    L19:
        long r3 = this.b.a.getMId();
        OrderInfo r18 = this.b.a.getOrderInfo();
        if (r18 == null) goto L26;
        InteractiveSongUserInfo r19 = r18.getTopUser();
        if (r19 == null) goto L26;
        String r110 = r19.getIdString();
        if (r110 == null) goto L26;
        String r5 = r110;
    L27:
        MusicPanel r111 = this.b;
        String r7 = r111.d;
        String r8 = r111.b();
        String r112 = this.b.a.getMAuthor();
        if (r112 != null) goto L30;
        String r9 = "";
    L31:
        KtvLoggerHelper.Y("up_link", r2, r3, r5, r6, r7, r8, r9, Intrinsics.areEqual(this.b.A, Boolean.TRUE), null, this.b);
        return;
    L30:
        r9 = r112;
    L26:
        r5 = "";
        goto L27
    L18:
        r2 = r17;
        goto L19
    L5:
        OrderInfo r113 = this.b.a.getOrderInfo();
        if (r113 == null) goto L15;
        InteractiveSongUserInfo r114 = r113.getTopUser();
        if (r114 == null) goto L15;
        String r115 = r114.getIdString();
        if (r115 == null) goto L15;
        if (KtvUtilsKt.g() == false) goto L14;
        Lazy r0 = KtvSettingHelper.a;
        this.a.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.util.k.a(r115, FloatingBottomView.e());
        goto L15
    L14:
        qd0.a r1 = jc1.k.n(IInteractService.class).getAudioTalkService();
        this.a.getClass();
        r1.d(r115, FloatingBottomView.e());
        goto L15
    }
}

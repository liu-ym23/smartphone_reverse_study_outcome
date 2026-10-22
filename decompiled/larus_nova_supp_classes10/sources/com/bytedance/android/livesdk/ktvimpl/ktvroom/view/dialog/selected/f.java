package com.bytedance.android.livesdk.ktvimpl.ktvroom.view.dialog.selected;

import android.view.View;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.plantform.base.i;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.OrderInfo;
import com.bytedance.live.datacontext.j;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f implements View.OnClickListener {
    public final /* synthetic */ KtvRoomSelectedMusicViewHolder a;
    public final /* synthetic */ wb0.a b;
    public final /* synthetic */ MusicPanel c;

    public f(KtvRoomSelectedMusicViewHolder r1, wb0.a r2, MusicPanel r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r14) {
        boolean r0 = false;
        if (this.b.getOnlineLinkMicCount() < 9) goto L5;
        f2.b(2131918533, 0);
    L56:
        if (this.a.d4() == false) goto L60;
        String r15 = "anchor";
    L58:
        String r5 = r15;
        Long r16 = KtvLoggerHelper.a;
        String r17 = this.c.a.getMTitle();
        if (r17 != null) goto L72;
        r17 = "";
    L72:
        long r2 = this.c.a.getMId();
        OrderInfo r4 = this.c.a.getOrderInfo();
        if (r4 == null) goto L79;
        InteractiveSongUserInfo r6 = r4.getTopUser();
        if (r6 == null) goto L79;
        String r7 = r6.getIdString();
        if (r7 == null) goto L79;
    L80:
        MusicPanel r8 = this.c;
        String r9 = r8.d;
        String r10 = r8.b();
        String r11 = this.c.a.getMAuthor();
        if (r11 != null) goto L83;
        String r12 = "";
    L84:
        KtvLoggerHelper.Y("up_link", r17, r2, r7, r5, r9, r10, r12, Intrinsics.areEqual(this.c.A, Boolean.TRUE), null, this.c);
        return;
    L83:
        r12 = r11;
    L79:
        r7 = "";
        goto L80
    L60:
        if (KtvUtilsKt.j() == false) goto L62;
        r15 = "administrator";
        goto L58
    L62:
        Integer r18 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r18 != null) goto L66;
    L67:
        r15 = "user";
        goto L58
    L66:
        if (r18.intValue() != 2) goto L67;
        r15 = "guest";
        goto L58
    L5:
        MusicPanel r19 = this.a.E;
        IInteractService r3 = k.f(IInteractService.class);
        Object r13 = null;
        if (r3 == null) goto L10;
        i r20 = r3.getLinkUserInfoCenter();
        if (r20 == null) goto L10;
        List r21 = r20.getOnlineUserList();
    L12:
        if (r21 == null) goto L32;
        if (r19 == null) goto L32;
        KtvMusic r110 = r19.a;
        if (r110 == null) goto L32;
        String r111 = r110.getOrderUserIdString();
        if (r111 == null) goto L32;
        Iterator r22 = r21.iterator();
    L20:
        if (r22.hasNext() == false) goto L30;
        Object r23 = r22.next();
        ILinkPlayerInfoBridge r24 = (ILinkPlayerInfoBridge) r23;
        if (r24 == null) goto L26;
        IBaseUser r25 = r24.getUser();
        if (r25 == null) goto L26;
        String r26 = r25.getIdString();
    L28:
        if (Intrinsics.areEqual(r26, r111) == false) goto L20;
        r13 = r23;
    L26:
        r26 = null;
    L30:
        if (r13 == null) goto L32;
        boolean r112 = true;
    L33:
        if (r112 == false) goto L35;
        f2.b(2131918548, 0);
        goto L56
    L35:
        OrderInfo r113 = this.c.a.getOrderInfo();
        if (r113 == null) goto L56;
        InteractiveSongUserInfo r114 = r113.getTopUser();
        if (r114 == null) goto L56;
        String r115 = r114.getIdString();
        if (r115 == null) goto L56;
        u r27 = m.d();
        if (r27 == null) goto L52;
        j r28 = r27.s();
        if (r28 == null) goto L52;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r29 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r28.getValue();
        if (r29 == null) goto L52;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r30 = r29.t();
        if (r30 == null) goto L52;
        if (r30.a != 9) goto L52;
        r0 = true;
    L52:
        if (r0 == false) goto L54;
        Lazy r1 = KtvSettingHelper.a;
        com.bytedance.android.livesdk.ktvimpl.base.util.k.a(r115, this.a.d4());
        goto L56
    L54:
        k.n(IInteractService.class).getVideoTalkService().d(r115, this.a.d4());
    L32:
        r112 = false;
    L10:
        r21 = null;
        goto L12
    }
}

package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.view.secondleveltab;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.ktv.common.karaokestation.model.y;
import com.bytedance.android.live.ktv.common.model.api.z0;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c implements nb0.c {
    public final Map<String, Boolean> a;
    public final y b;
    public final com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b c;
    public final com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d d;

    public static final class a {
    }

    static {
    }

    public final void a(int r20, boolean r21) {
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r2 = this.c;
        if (r2 == null) goto L9;
        Pair r3 = r2.getSelectedFirstLevelTabValue();
        if (r3 == null) goto L9;
        if (((Number) r3.getFirst()).intValue() != this.b.k) goto L9;
        boolean r4 = true;
    L10:
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r5 = this.c;
        MusicPanel r6 = null;
        if (r5 == null) goto L15;
        y r7 = r5.getSelectedSecondLevelTabData(this.b.k);
        if (r7 == null) goto L15;
        String r8 = r7.c;
    L16:
        boolean r9 = Intrinsics.areEqual(r8, this.b.c);
        if (r4 == false) goto L67;
        if (r9 == false) goto L68;
        int r10 = this.b.i.size();
        if (r20 < 0) goto L76;
        if (r10 <= r20) goto L69;
        Object r11 = ListProtector.get(this.b.i, r20);
        if ((r11 instanceof com.bytedance.android.live.ktv.common.model.bean.d) == false) goto L47;
        com.bytedance.android.live.ktv.common.model.bean.d r12 = (com.bytedance.android.live.ktv.common.model.bean.d) r11;
        IBaseUser r13 = r12.f();
        if (r13 == null) goto L70;
        String r14 = r13.getIdString();
        if (r14 != null) goto L31;
        return;
    L31:
        if (this.a.containsKey(r14) == true) goto L71;
        this.a.put(r14, Boolean.TRUE);
        String r15 = r12.c();
        int r16 = (int) r12.e();
        String r17 = r12.b();
        int r18 = ke2.b.a;
        y r19 = this.b;
        String r110 = r19.d;
        String r111 = com.bytedance.android.live.ktv.common.karaokestation.model.f.b(com.bytedance.android.live.ktv.common.karaokestation.model.f.a(r19.k));
        Intrinsics.checkNotNullParameter(r14, "uid");
        Intrinsics.checkNotNullParameter(r15, "songName");
        Intrinsics.checkNotNullParameter(r17, "songId");
        LinkedHashMap r112 = new LinkedHashMap();
        ke2.b.j(r112);
        ke2.b.p(r112);
        ke2.b.m(r112);
        ke2.b.l(r112);
        ke2.b.k(r112);
        r112.put("applicant_id", r14);
        r112.put("song_name", r15);
        r112.put("song_id", r17);
        r112.put("applicant_song_cnt", String.valueOf(r16));
        com.bytedance.android.livesdk.ktvimpl.chorus.c.b(r112);
        if (r111.length() <= 0) goto L35;
        boolean r22 = true;
    L36:
        if (r22 != true) goto L38;
        r112.put("main_tab", r111);
    L38:
        if (r110 != null) goto L40;
    L45:
        j0.l().sendLog("livesdk_anchor_ksong_apply_msg_show", r112, new Object[]{IRoom.class});
        com.bytedance.android.live.ktv.common.util.j.j("BusinessListItemExposureListener", "position == " + r20 + " ;; orderUserId == " + r14 + " ;; secondLevelTabData.name == " + this.b.c);
        return;
    L40:
        if (r110.length() <= 0) goto L42;
        boolean r23 = true;
    L43:
        if (r23 != true) goto L45;
        r112.put("sub_tab", r110);
        goto L45
    L42:
        r23 = false;
        goto L43
    L35:
        r22 = false;
        goto L36
    L71:
        return;
    L70:
        return;
    L47:
        if ((r11 instanceof z0) == false) goto L73;
        z0 r24 = (z0) r11;
        KtvMusic r25 = r24.b();
        if (r25 == null) goto L74;
        String r26 = String.valueOf(r25.getMId());
        if (r26 != null) goto L54;
        return;
    L54:
        if (this.a.containsKey(r26) == true) goto L75;
        this.a.put(r26, Boolean.TRUE);
        KtvMusic r113 = r24.b();
        if (r113 == null) goto L58;
        r6 = new MusicPanel(r113, 0, "mine_want_sing", false, null, null, null, 1073741814);
    L58:
        pb0.a r27 = pb0.b.a;
        String r28 = this.b.d;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r29 = this.d;
        if (r29 == null) goto L64;
        td2.b r30 = r29.getOrderSongExtraInfo();
        if (r30 == null) goto L64;
        String r31 = r30.a;
        if (r31 == null) goto L64;
    L65:
        pb0.b.c(r6, r28, r31, com.bytedance.android.live.ktv.common.karaokestation.model.f.b(com.bytedance.android.live.ktv.common.karaokestation.model.f.a(this.b.k)));
        com.bytedance.android.live.ktv.common.util.j.j("BusinessListItemExposureListener", "position == " + r20 + " ;; songId == " + r26 + " ;; secondLevelTabData.name == " + this.b.c);
        return;
    L64:
        r31 = "";
        goto L65
    L75:
        return;
    L74:
        return;
    L73:
        return;
    L69:
        return;
    L76:
        return;
    L68:
        return;
    L67:
        return;
    L15:
        r8 = null;
    L9:
        r4 = false;
        goto L10
    }

    public c(Map<String, Boolean> r2, y r3, com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r4, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r5) {
        Intrinsics.checkNotNullParameter(r2, "lastExposureItemMap");
        Intrinsics.checkNotNullParameter(r3, "secondLevelTabData");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}

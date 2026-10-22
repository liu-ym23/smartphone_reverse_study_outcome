package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab;

import com.bytedance.android.live.ktv.common.karaokestation.model.y;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.util.KSongOrderSongUtilKt;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g implements nb0.c {
    public final Map<Long, Boolean> a;
    public final y b;
    public final com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b c;
    public final com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d d;

    public static final class a {
    }

    static {
    }

    public final void a(int r10, boolean r11) {
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r12 = this.c;
        if (r12 == null) goto L9;
        Pair r13 = r12.getSelectedFirstLevelTabValue();
        if (r13 == null) goto L9;
        if (((Number) r13.getFirst()).intValue() != this.b.k) goto L9;
        boolean r14 = true;
    L10:
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r0 = this.c;
        if (r0 == null) goto L15;
        y r1 = r0.getSelectedSecondLevelTabData(this.b.k);
        if (r1 == null) goto L15;
        String r2 = r1.c;
    L16:
        boolean r3 = Intrinsics.areEqual(r2, this.b.c);
        if (r14 == false) goto L48;
        if (r3 == false) goto L49;
        int r15 = this.b.h.size();
        if (r10 < 0) goto L54;
        if (r15 <= r10) goto L50;
        MusicPanel r16 = (MusicPanel) ListProtector.get(this.b.h, r10);
        String r5 = "";
        if (Intrinsics.areEqual(this.b.c, "sung") == false) goto L37;
        long r6 = r10;
        if (this.a.containsKey(Long.valueOf(r6)) == true) goto L51;
        this.a.put(Long.valueOf(r6), Boolean.TRUE);
        pb0.a r4 = pb0.b.a;
        String r7 = KSongOrderSongUtilKt.d(r16);
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r8 = this.d;
        if (r8 == null) goto L35;
        td2.b r9 = r8.getOrderSongExtraInfo();
        if (r9 == null) goto L35;
        String r17 = r9.a;
        if (r17 == null) goto L35;
        r5 = r17;
    L35:
        pb0.b.c(r16, r7, r5, com.bytedance.android.live.ktv.common.karaokestation.model.f.b(com.bytedance.android.live.ktv.common.karaokestation.model.f.a(this.b.k)));
        com.bytedance.android.live.ktv.common.util.j.j("MusicListItemExposureListener", "position == " + r10 + " ;; id == " + r16.a.getMId() + " ;; secondLevelTabData.name == " + this.b.c);
        return;
    L51:
        return;
    L37:
        if (this.a.containsKey(Long.valueOf(r16.a.getMId())) == true) goto L53;
        this.a.put(Long.valueOf(r16.a.getMId()), Boolean.TRUE);
        pb0.a r18 = pb0.b.a;
        String r19 = KSongOrderSongUtilKt.d(r16);
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r20 = this.d;
        if (r20 == null) goto L46;
        td2.b r21 = r20.getOrderSongExtraInfo();
        if (r21 == null) goto L46;
        String r22 = r21.a;
        if (r22 == null) goto L46;
        r5 = r22;
    L46:
        pb0.b.c(r16, r19, r5, com.bytedance.android.live.ktv.common.karaokestation.model.f.b(com.bytedance.android.live.ktv.common.karaokestation.model.f.a(this.b.k)));
        com.bytedance.android.live.ktv.common.util.j.j("MusicListItemExposureListener", "position == " + r10 + " ;; id == " + r16.a.getMId() + " ;; secondLevelTabData.name == " + this.b.c);
        return;
    L53:
        return;
    L50:
        return;
    L54:
        return;
    L49:
        return;
    L48:
        return;
    L15:
        r2 = null;
    L9:
        r14 = false;
        goto L10
    }

    public g(Map<Long, Boolean> r2, y r3, com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r4, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r5) {
        Intrinsics.checkNotNullParameter(r2, "lastExposureItemMap");
        Intrinsics.checkNotNullParameter(r3, "secondLevelTabData");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}

package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab;

import com.bytedance.android.live.ktv.common.karaokestation.model.FirstLevelTab;
import com.bytedance.android.live.ktv.common.karaokestation.model.y;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i implements nb0.c {
    public final com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b a;
    public final com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d b;
    public final Map<Long, Boolean> c;

    public static final class a {
    }

    static {
    }

    public final void a(int r4, boolean r5) {
        KtvContext.Companion.getClass();
        List<MusicPanel> r6 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.b(KtvContext.a.g());
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r0 = this.a;
        if (r0 == null) goto L9;
        Pair r1 = r0.getSelectedFirstLevelTabValue();
        if (r1 == null) goto L9;
        if (((Number) r1.getFirst()).intValue() != FirstLevelTab.OrderedSongTab.getValue()) goto L9;
        boolean r2 = true;
    L10:
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r3 = this.a;
        if (r3 == null) goto L15;
        y r7 = r3.getSelectedSecondLevelTabData(FirstLevelTab.OrderedSongTab.getValue());
        if (r7 == null) goto L15;
        String r8 = r7.c;
    L16:
        boolean r9 = Intrinsics.areEqual(r8, "play_list");
        if (r2 == false) goto L34;
        if (r9 == false) goto L35;
        int r10 = r6.size();
        if (r4 < 0) goto L38;
        if (r10 <= r4) goto L36;
        MusicPanel r11 = (MusicPanel) ListProtector.get(r6, r4);
        if (this.c.containsKey(Long.valueOf(r11.a.getMId())) == true) goto L37;
        this.c.put(Long.valueOf(r11.a.getMId()), Boolean.TRUE);
        pb0.a r12 = pb0.b.a;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r13 = this.b;
        if (r13 == null) goto L31;
        td2.b r14 = r13.getOrderSongExtraInfo();
        if (r14 == null) goto L31;
        String r15 = r14.a;
        if (r15 == null) goto L31;
    L32:
        pb0.b.c(r11, "播放列表", r15, com.bytedance.android.live.ktv.common.karaokestation.model.f.b(FirstLevelTab.OrderedSongTab));
        com.bytedance.android.live.ktv.common.util.j.j("PlayListItemExposureListener", "position == " + r4 + " ;; id == " + r11.a.getMId());
        return;
    L31:
        r15 = "";
        goto L32
    L37:
        return;
    L36:
        return;
    L38:
        return;
    L35:
        return;
    L34:
        return;
    L15:
        r8 = null;
    L9:
        r2 = false;
        goto L10
    }

    public i(com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r2, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r3, Map<Long, Boolean> r4) {
        Intrinsics.checkNotNullParameter(r4, "lastExposureItemMap");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}

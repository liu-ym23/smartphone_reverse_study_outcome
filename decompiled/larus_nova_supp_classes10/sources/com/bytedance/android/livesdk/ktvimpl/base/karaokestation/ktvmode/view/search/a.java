package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.search;

import com.bytedance.android.live.ktv.common.karaokestation.model.FirstLevelTab;
import com.bytedance.android.live.ktv.common.karaokestation.model.f;
import com.bytedance.android.live.ktv.common.util.j;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements nb0.c {
    public final Map<Long, Boolean> a;
    public final FirstLevelTab b;
    public final com.bytedance.android.live.ktv.common.search.viewmodel.a c;
    public final d d;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.search.a$a, reason: collision with other inner class name */
    public static final class C0006a {
    }

    static {
    }

    public final void a(int r4, boolean r5) {
        com.bytedance.android.live.ktv.common.search.viewmodel.a r6 = this.c;
        if (r6 == null) goto L22;
        List r7 = r6.getSearchedMusicList();
        if (r7 == null) goto L25;
        int r0 = r7.size();
        if (r4 < 0) goto L26;
        if (r0 <= r4) goto L23;
        MusicPanel r8 = (MusicPanel) ListProtector.get(r7, r4);
        if (this.a.containsKey(Long.valueOf(r8.a.getMId())) == true) goto L24;
        this.a.put(Long.valueOf(r8.a.getMId()), Boolean.TRUE);
        pb0.a r1 = pb0.b.a;
        String r2 = r8.d;
        d r3 = this.d;
        if (r3 == null) goto L19;
        td2.b r9 = r3.getOrderSongExtraInfo();
        if (r9 == null) goto L19;
        String r10 = r9.a;
        if (r10 == null) goto L19;
    L20:
        pb0.b.c(r8, r2, r10, f.b(this.b));
        j.j("SearchItemExposureListener", "position == " + r4 + " ;; id == " + r8.a.getMId() + " ;; fromRequestType == " + r8.d);
        return;
    L19:
        r10 = "";
        goto L20
    L24:
        return;
    L23:
        return;
    L26:
        return;
    L25:
        return;
    }

    public a(Map<Long, Boolean> r2, FirstLevelTab r3, com.bytedance.android.live.ktv.common.search.viewmodel.a r4, d r5) {
        Intrinsics.checkNotNullParameter(r2, "lastExposureItemMap");
        Intrinsics.checkNotNullParameter(r3, "firstLevelTab");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}

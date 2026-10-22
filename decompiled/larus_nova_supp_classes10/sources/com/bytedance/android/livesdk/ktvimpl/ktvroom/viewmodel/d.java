package com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel;

import com.bytedance.android.livesdk.message.model.MusicPanel;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d {
    public final MusicPanel a;
    public final com.bytedance.android.livesdk.ktvimpl.base.sei.k b;
    public final List<com.bytedance.component.lyric.model.b> c;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof d) == false) goto L12;
        d r4 = (d) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        MusicPanel r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        List<com.bytedance.component.lyric.model.b> r7 = this.c;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "KtvCoreDataModel(musicPanel=" + this.a + ", seiModel=" + this.b + ", currentLyricsLines=" + this.c + ")";
    }

    public d(MusicPanel r1, com.bytedance.android.livesdk.ktvimpl.base.sei.k r2, List<com.bytedance.component.lyric.model.b> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}

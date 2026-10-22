package com.bytedance.android.livesdk.ktvimpl.mv.opus.model;

import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.sharedpref.c;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdk.sharedpref.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public MusicPanel a;
    public final long b;
    public final String c;
    public final boolean d;
    public final String e;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof a) == false) goto L14;
        a r7 = (a) r6;
        if (this.b == r7.b) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.c, r7.c) == true) goto L10;
        return false;
    L10:
        if (this.d == r7.d) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.e, r7.e) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    public final int hashCode() {
        long r0 = this.b;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        String r2 = this.c;
        int r3 = 0;
        if (r2 == null) goto L5;
        int r4 = r2.hashCode();
    L6:
        int r5 = (r1 + r4) * 31;
        boolean r6 = this.d;
        ?? r7 = r6;
        if (r6 == false) goto L9;
        r7 = 1;
    L9:
        int r8 = (r5 + r7) * 31;
        String r9 = this.e;
        if (r9 == null) goto L13;
        r3 = r9.hashCode();
    L13:
        return r8 + r3;
    L5:
        r4 = 0;
        goto L6
    }

    public final String toString() {
        return "OpenOpusPreviewEvent(mId=" + this.b + ", singerId=" + this.c + ", isFromGuideEntry=" + this.d + ", requestPage=" + this.e + ")";
    }

    public a(long r2, String r4, boolean r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "singerId");
        Intrinsics.checkNotNullParameter(r6, "requestPage");
        this.b = r2;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        if (r5 == true) goto L6;
        e r3 = c.K;
        r3.getClass();
        f.d(r3, -1L);
        return;
    }
}

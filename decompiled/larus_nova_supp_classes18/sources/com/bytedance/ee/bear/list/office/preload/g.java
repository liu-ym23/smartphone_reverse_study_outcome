package com.bytedance.ee.bear.list.office.preload;

import com.bytedance.ee.bear.list.dto.Document;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g {
    public final String a;
    public final String b;
    public final String c;
    public final ArrayList<Document> d;
    public final long e;
    public final long f;
    public final String g;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof g) == true) goto L8;
        return false;
    L8:
        g r9 = (g) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        long r1 = this.e;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.f;
        return ((r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.g.hashCode();
    }

    public final String toString() {
        return "OfficeSpaceTabPreloadEntry(requestId=" + this.a + ", requestKeyHash=" + this.b + ", tab=" + this.c + ", documents=" + this.d + ", createdAtMs=" + this.e + ", ttlDeadlineMs=" + this.f + ", originScene=" + this.g + ')';
    }

    public g(String r2, String r3, String r4, ArrayList<Document> r5, long r6, long r8, String r10) {
        Intrinsics.checkNotNullParameter(r2, "requestId");
        Intrinsics.checkNotNullParameter(r3, "requestKeyHash");
        Intrinsics.checkNotNullParameter(r4, "tab");
        Intrinsics.checkNotNullParameter(r5, "documents");
        Intrinsics.checkNotNullParameter(r10, "originScene");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r8;
        this.g = r10;
    }
}

package com.bytedance.ee.bear.list.office.preload;

import com.bytedance.ee.bear.list.dto.Document;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f229159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f229160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f229161c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<Document> f229162d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f229163e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f229164f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f229165g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f229159a, r101.f229159a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f229160b, r101.f229160b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f229161c, r101.f229161c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f229162d, r101.f229162d) == true) goto L21;
        return false;
    L21:
        if (this.f229163e == r101.f229163e) goto L24;
        return false;
    L24:
        if (this.f229164f == r101.f229164f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f229165g, r101.f229165g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f229159a.hashCode() * 31) + this.f229160b.hashCode()) * 31) + this.f229161c.hashCode()) * 31) + this.f229162d.hashCode()) * 31;
        long r101 = this.f229163e;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f229164f;
        return ((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f229165g.hashCode();
    }

    public final String toString() {
        return "OfficeSpaceTabPreloadEntry(requestId=" + this.f229159a + ", requestKeyHash=" + this.f229160b + ", tab=" + this.f229161c + ", documents=" + this.f229162d + ", createdAtMs=" + this.f229163e + ", ttlDeadlineMs=" + this.f229164f + ", originScene=" + this.f229165g + ')';
    }

    public g(String r100, String r101, String r102, ArrayList<Document> r103, long r104, long r105, String r110) {
        Intrinsics.checkNotNullParameter(r100, "requestId");
        Intrinsics.checkNotNullParameter(r101, "requestKeyHash");
        Intrinsics.checkNotNullParameter(r102, "tab");
        Intrinsics.checkNotNullParameter(r103, "documents");
        Intrinsics.checkNotNullParameter(r110, "originScene");
        this.f229159a = r100;
        this.f229160b = r101;
        this.f229161c = r102;
        this.f229162d = r103;
        this.f229163e = r104;
        this.f229164f = r105;
        this.f229165g = r110;
    }
}

package pt7;

import java.util.Arrays;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f530649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f530650b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f530651c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Pair<String, String>> f530652d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f530653e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f530654f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final byte[] f530655g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f530656h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f530657i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f530658j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f530659k;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f530649a, r101.f530649a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f530650b, r101.f530650b) == true) goto L15;
        return false;
    L15:
        if (this.f530651c == r101.f530651c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f530652d, r101.f530652d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f530653e, r101.f530653e) == true) goto L24;
        return false;
    L24:
        if (this.f530654f == r101.f530654f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f530655g, r101.f530655g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f530656h, r101.f530656h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f530657i, r101.f530657i) == true) goto L36;
        return false;
    L36:
        if (this.f530658j == r101.f530658j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f530659k, r101.f530659k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.f530649a.hashCode() * 31) + this.f530650b.hashCode()) * 31) + this.f530651c) * 31) + this.f530652d.hashCode()) * 31) + this.f530653e.hashCode()) * 31;
        long r101 = this.f530654f;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        byte[] r103 = this.f530655g;
        if (r103 != null) goto L5;
        int r104 = 0;
    L7:
        return ((((((((r102 + r104) * 31) + this.f530656h.hashCode()) * 31) + this.f530657i.hashCode()) * 31) + this.f530658j) * 31) + this.f530659k.hashCode();
    L5:
        r104 = Arrays.hashCode(r103);
        goto L7
    }

    public final String toString() {
        return "BridgeResponse(url=" + this.f530649a + ", protocol=" + this.f530650b + ", responseCode=" + this.f530651c + ", responseHeaders=" + this.f530652d + ", responseContentType=" + this.f530653e + ", responseContentLength=" + this.f530654f + ", bodyByteArray=" + Arrays.toString(this.f530655g) + ", requestLog=" + this.f530656h + ", logId=" + this.f530657i + ", errorCode=" + this.f530658j + ", errorMessage=" + this.f530659k + ')';
    }

    public d() {
        List<Pair<String, String>> r100 = CollectionsKt.emptyList();
        Intrinsics.checkNotNullParameter("", "url");
        Intrinsics.checkNotNullParameter("unknown", "protocol");
        Intrinsics.checkNotNullParameter(r100, "responseHeaders");
        Intrinsics.checkNotNullParameter("", "responseContentType");
        Intrinsics.checkNotNullParameter("", "requestLog");
        Intrinsics.checkNotNullParameter("", "logId");
        Intrinsics.checkNotNullParameter("", "errorMessage");
        this.f530649a = "";
        this.f530650b = "unknown";
        this.f530651c = -1;
        this.f530652d = r100;
        this.f530653e = "";
        this.f530654f = -1;
        this.f530655g = null;
        this.f530656h = "";
        this.f530657i = "";
        this.f530658j = 0;
        this.f530659k = "";
    }
}

package jx9;

import com.larus.bmhome.chat.bean.NexPulseResponseData;
import ic8.k0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f500929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f500930b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k0 f500931c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f500932d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f500933e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f500934f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f500935g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f500936h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public NexPulseResponseData f500937i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f500929a, r101.f500929a) == true) goto L12;
        return false;
    L12:
        if (this.f500930b == r101.f500930b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f500931c, r101.f500931c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f500932d, r101.f500932d) == true) goto L21;
        return false;
    L21:
        if (this.f500933e == r101.f500933e) goto L24;
        return false;
    L24:
        if (this.f500934f == r101.f500934f) goto L27;
        return false;
    L27:
        if (this.f500935g == r101.f500935g) goto L30;
        return false;
    L30:
        if (this.f500936h == r101.f500936h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f500937i, r101.f500937i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f500929a.hashCode() * 31) + this.f500930b) * 31) + this.f500931c.hashCode()) * 31) + this.f500932d.hashCode()) * 31;
        long r101 = this.f500933e;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f500934f;
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.f500935g;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        long r107 = this.f500936h;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        NexPulseResponseData r109 = this.f500937i;
        if (r109 != null) goto L5;
        int r110 = 0;
    L7:
        return r108 + r110;
    L5:
        r110 = r109.hashCode();
        goto L7
    }

    public final String toString() {
        return "WcbTraceData(conversationId=" + this.f500929a + ", nexPulseScene=" + this.f500930b + ", params=" + this.f500931c + ", reqSrc=" + this.f500932d + ", apiStartTs=" + this.f500933e + ", apiFinishTs=" + this.f500934f + ", msgFinishTs=" + this.f500935g + ", lastWcbUpdateTime=" + this.f500936h + ", response=" + this.f500937i + ')';
    }

    public a(String r100, int r101, k0 r102, String r103, long r104) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r103, "reqSrc");
        this.f500929a = r100;
        this.f500930b = r101;
        this.f500931c = r102;
        this.f500932d = r103;
        this.f500933e = r104;
        this.f500934f = 0;
        this.f500935g = 0;
        this.f500936h = 0;
        this.f500937i = null;
    }
}

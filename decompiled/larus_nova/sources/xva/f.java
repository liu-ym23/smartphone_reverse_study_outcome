package xva;

import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Biz f565195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Scene f565196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f565197c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f565198d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f565199e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f565200f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f565201g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f565202h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f565203i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f565204j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ConcurrentHashMap<String, Object> f565205k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ConcurrentHashMap<String, Object> f565206l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ConcurrentHashMap<String, Object> f565207m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ConcurrentHashMap<String, Object> f565208n;

    public f() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L54:
        return true;
    L5:
        if ((r100 instanceof f) == false) goto L53;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f565195a, r101.f565195a) == false) goto L53;
        if (Intrinsics.areEqual(this.f565196b, r101.f565196b) == false) goto L53;
        if (Intrinsics.areEqual(this.f565197c, r101.f565197c) == false) goto L53;
        if (this.f565198d != r101.f565198d) goto L15;
        boolean r102 = true;
    L16:
        if (r102 == false) goto L53;
        if (Intrinsics.areEqual(this.f565199e, r101.f565199e) == false) goto L53;
        if (this.f565200f != r101.f565200f) goto L22;
        boolean r103 = true;
    L23:
        if (r103 == false) goto L53;
        if (this.f565201g != r101.f565201g) goto L27;
        boolean r104 = true;
    L28:
        if (r104 == false) goto L53;
        if (this.f565202h != r101.f565202h) goto L32;
        boolean r105 = true;
    L33:
        if (r105 == false) goto L53;
        if (this.f565203i != r101.f565203i) goto L37;
        boolean r106 = true;
    L38:
        if (r106 == false) goto L53;
        if (this.f565204j != r101.f565204j) goto L42;
        boolean r107 = true;
    L43:
        if (r107 == false) goto L53;
        if (Intrinsics.areEqual(this.f565205k, r101.f565205k) == false) goto L53;
        if (Intrinsics.areEqual(this.f565206l, r101.f565206l) == false) goto L53;
        if (Intrinsics.areEqual(this.f565207m, r101.f565207m) == false) goto L53;
        if (Intrinsics.areEqual(this.f565208n, r101.f565208n) == false) goto L53;
    L42:
        r107 = false;
        goto L43
    L37:
        r106 = false;
        goto L38
    L32:
        r105 = false;
        goto L33
    L27:
        r104 = false;
        goto L28
    L22:
        r103 = false;
        goto L23
    L15:
        r102 = false;
    L53:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    public final int hashCode() {
        Biz r100 = this.f565195a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Scene r104 = this.f565196b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f565197c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        long r110 = this.f565198d;
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        String r112 = this.f565199e;
        if (r112 == null) goto L17;
        int r113 = r112.hashCode();
    L18:
        int r114 = (r111 + r113) * 31;
        boolean r115 = this.f565200f;
        ?? r116 = 1;
        ?? r117 = r115;
        if (r115 == false) goto L21;
        r117 = 1;
    L21:
        int r118 = (((r114 + r117) * 31) + this.f565201g) * 31;
        long r119 = this.f565202h;
        int r120 = (r118 + ((int) (r119 ^ (r119 >>> 32)))) * 31;
        long r121 = this.f565203i;
        int r122 = (r120 + ((int) (r121 ^ (r121 >>> 32)))) * 31;
        boolean r123 = this.f565204j;
        if (r123 == true) goto L25;
        r116 = r123;
    L25:
        int r124 = (r122 + r116) * 31;
        ConcurrentHashMap<String, Object> r125 = this.f565205k;
        if (r125 == null) goto L28;
        int r126 = r125.hashCode();
    L29:
        int r127 = (r124 + r126) * 31;
        ConcurrentHashMap<String, Object> r128 = this.f565206l;
        if (r128 == null) goto L32;
        int r129 = r128.hashCode();
    L33:
        int r130 = (r127 + r129) * 31;
        ConcurrentHashMap<String, Object> r131 = this.f565207m;
        if (r131 == null) goto L36;
        int r132 = r131.hashCode();
    L37:
        int r133 = (r130 + r132) * 31;
        ConcurrentHashMap<String, Object> r134 = this.f565208n;
        if (r134 == null) goto L41;
        r101 = r134.hashCode();
    L41:
        return r133 + r101;
    L36:
        r132 = 0;
        goto L37
    L32:
        r129 = 0;
        goto L33
    L28:
        r126 = 0;
        goto L29
    L17:
        r113 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "TimeCostParams(biz=" + this.f565195a + ", scene=" + this.f565196b + ", event=" + this.f565197c + ", latency=" + this.f565198d + ", page=" + this.f565199e + ", needNet=" + this.f565200f + ", version=" + this.f565201g + ", lastFrontTimestamp=" + this.f565202h + ", backgroundTime=" + this.f565203i + ", isInBackground=" + this.f565204j + ", latencyDetail=" + this.f565205k + ", extra=" + this.f565206l + ", extraMetric=" + this.f565207m + ", extraCategory=" + this.f565208n + ")";
    }

    public f(Biz r100, Scene r101, String r102, String r103, boolean r104, int r110, int r111) {
        if ((r111 & 64) == 0) goto L5;
        r110 = 1;
    L5:
        ConcurrentHashMap<String, Object> r105 = null;
        if ((r111 & 1024) == 0) goto L8;
        ConcurrentHashMap<String, Object> r106 = new ConcurrentHashMap();
    L10:
        if ((r111 & 2048) == 0) goto L12;
        ConcurrentHashMap<String, Object> r107 = new ConcurrentHashMap();
    L14:
        if ((r111 & 4096) == 0) goto L16;
        ConcurrentHashMap<String, Object> r108 = new ConcurrentHashMap();
    L18:
        if ((r111 & 8192) == 0) goto L20;
        r105 = new ConcurrentHashMap();
    L20:
        this.f565195a = r100;
        this.f565196b = r101;
        this.f565197c = r102;
        this.f565198d = 0;
        this.f565199e = r103;
        this.f565200f = r104;
        this.f565201g = r110;
        this.f565202h = 0;
        this.f565203i = 0;
        this.f565204j = false;
        this.f565205k = r106;
        this.f565206l = r107;
        this.f565207m = r108;
        this.f565208n = r105;
        return;
    L16:
        r108 = null;
        goto L18
    L12:
        r107 = null;
        goto L14
    L8:
        r106 = null;
        goto L10
    }
}

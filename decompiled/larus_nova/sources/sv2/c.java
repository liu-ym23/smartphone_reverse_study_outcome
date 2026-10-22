package sv2;

import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f543634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f543635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f543636c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f543637d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f543638e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f543639f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f543640g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f543641h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f543642i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Bundle f543643j;

    public c() {
        this(null, 0, null, null, null, null, null, null, 1023);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L26;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f543634a, r101.f543634a) == true) goto L8;
        return false;
    L8:
        if (this.f543635b == r101.f543635b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f543636c, r101.f543636c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f543637d, r101.f543637d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f543638e, r101.f543638e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f543639f, r101.f543639f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f543640g, r101.f543640g) == true) goto L20;
        return false;
    L20:
        if (this.f543641h == r101.f543641h) goto L22;
        return false;
    L22:
        if (this.f543642i == r101.f543642i) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f543643j, r101.f543643j) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r2v18, types: [int] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v26 */
    public final int hashCode() {
        String r100 = this.f543634a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f543635b) * 31;
        String r104 = this.f543636c;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f543637d;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f543638e;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f543639f;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f543640g;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (((r115 + r117) * 31) + this.f543641h) * 31;
        boolean r119 = this.f543642i;
        ?? r120 = r119;
        if (r119 == false) goto L29;
        r120 = 1;
    L29:
        int r121 = (r118 + r120) * 31;
        Bundle r122 = this.f543643j;
        if (r122 == null) goto L33;
        r101 = r122.hashCode();
    L33:
        return r121 + r101;
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
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
        return "TabliveGuidePlayerData(pageSource=" + this.f543634a + ", guidePosition=" + this.f543635b + ", guideScene=" + this.f543636c + ", enterFromMerge=" + this.f543637d + ", enterMethod=" + this.f543638e + ", requestId=" + this.f543639f + ", tabEnterMethod=" + this.f543640g + ", playerRadius=" + this.f543641h + ", mute=" + this.f543642i + ", commonInsertParams=" + this.f543643j + ")";
    }

    public /* synthetic */ c(String r110, int r111, String r112, String r113, String r114, String r210, String r211, Bundle r212, int r213) {
        if ((r213 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r213 & 2) == 0) goto L9;
        int r101 = 0;
    L11:
        if ((r213 & 4) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r213 & 8) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r213 & 16) == 0) goto L21;
        String r104 = "";
    L23:
        if ((r213 & 32) == 0) goto L25;
        String r105 = "";
    L27:
        if ((r213 & 64) == 0) goto L29;
        String r115 = "";
    L31:
        if ((r213 & 128) == 0) goto L33;
        int r116 = 16;
    L35:
        if ((r213 & 512) == 0) goto L37;
        Bundle r117 = new Bundle();
    L38:
        this(r100, r101, r102, r103, r104, r105, r115, r116, false, r117);
        return;
    L37:
        r117 = r212;
        goto L38
    L33:
        r116 = 0;
        goto L35
    L29:
        r115 = r211;
        goto L31
    L25:
        r105 = r210;
        goto L27
    L21:
        r104 = r114;
        goto L23
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public c(String r100, int r101, String r102, String r103, String r104, String r105, String r106, int r107, boolean r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r100, "pageSource");
        Intrinsics.checkNotNullParameter(r102, "guideScene");
        Intrinsics.checkNotNullParameter(r103, "enterFromMerge");
        Intrinsics.checkNotNullParameter(r104, "enterMethod");
        Intrinsics.checkNotNullParameter(r105, "requestId");
        Intrinsics.checkNotNullParameter(r106, "tabEnterMethod");
        Intrinsics.checkNotNullParameter(r111, "commonInsertParams");
        this.f543634a = r100;
        this.f543635b = r101;
        this.f543636c = r102;
        this.f543637d = r103;
        this.f543638e = r104;
        this.f543639f = r105;
        this.f543640g = r106;
        this.f543641h = r107;
        this.f543642i = r110;
        this.f543643j = r111;
    }
}

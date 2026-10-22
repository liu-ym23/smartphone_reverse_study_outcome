package com.bytedance.bdp.live.livecontainer.sonicgame;

import android.view.ViewGroup;
import android.view.Window;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class k extends na4.f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewGroup f201531d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Window f201532e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f201533f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f201534g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f201535h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ViewGroup f201536i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f201537j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f201538k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f201539l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f201540m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f201541n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f201542o;

    public k() {
        this(null, null, null, false, 0, 0, false, 0, 0, UnixStat.PERM_MASK);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k) == false) goto L30;
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f201531d, r101.f201531d) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f201532e, r101.f201532e) == true) goto L10;
        return false;
    L10:
        if (this.f201533f == r101.f201533f) goto L12;
        return false;
    L12:
        if (this.f201534g == r101.f201534g) goto L14;
        return false;
    L14:
        if (this.f201535h == r101.f201535h) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f201536i, r101.f201536i) == true) goto L18;
        return false;
    L18:
        if (this.f201537j == r101.f201537j) goto L20;
        return false;
    L20:
        if (this.f201538k == r101.f201538k) goto L22;
        return false;
    L22:
        if (this.f201539l == r101.f201539l) goto L24;
        return false;
    L24:
        if (this.f201540m == r101.f201540m) goto L26;
        return false;
    L26:
        if (this.f201541n == r101.f201541n) goto L28;
        return false;
    L28:
        if (this.f201542o == r101.f201542o) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r0v20, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        ViewGroup r100 = this.f201531d;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Window r104 = this.f201532e;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.f201533f;
        ?? r108 = 1;
        ?? r109 = r107;
        if (r107 == false) goto L13;
        r109 = 1;
    L13:
        int r110 = (r106 + r109) * 31;
        boolean r111 = this.f201534g;
        ?? r112 = r111;
        if (r111 == false) goto L16;
        r112 = 1;
    L16:
        int r113 = (r110 + r112) * 31;
        boolean r114 = this.f201535h;
        ?? r115 = r114;
        if (r114 == false) goto L19;
        r115 = 1;
    L19:
        int r116 = (r113 + r115) * 31;
        ViewGroup r117 = this.f201536i;
        if (r117 == null) goto L22;
        r101 = r117.hashCode();
    L22:
        int r118 = (r116 + r101) * 31;
        boolean r119 = this.f201537j;
        ?? r120 = r119;
        if (r119 == false) goto L25;
        r120 = 1;
    L25:
        int r121 = (((((r118 + r120) * 31) + this.f201538k) * 31) + this.f201539l) * 31;
        boolean r122 = this.f201540m;
        if (r122 == true) goto L30;
        r108 = r122;
    L30:
        return ((((r121 + r108) * 31) + this.f201541n) * 31) + this.f201542o;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SonicPluginStartParams(containerView=" + this.f201531d + ", window=" + this.f201532e + ", inDialog=" + this.f201533f + ", isDebug=" + this.f201534g + ", forceOpenVConsole=" + this.f201535h + ", floatContainerView=" + this.f201536i + ", useFixSizeContainerView=" + this.f201537j + ", fixSizeContainerViewWidth=" + this.f201538k + ", fixSizeContainerViewHeight=" + this.f201539l + ", useFixSizeFloatView=" + this.f201540m + ", fixSizeFloatViewWidth=" + this.f201541n + ", fixSizeFloatViewHeight=" + this.f201542o + ")";
    }

    public k(ViewGroup r100, Window r101, ViewGroup r102, boolean r103, int r104, int r110, boolean r111, int r112, int r113, int r114) {
        if ((r114 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r114 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r114 & 4) == 0) goto L11;
        boolean r105 = true;
    L13:
        if ((r114 & 32) == 0) goto L16;
        r102 = null;
    L16:
        if ((r114 & 64) == 0) goto L19;
        r103 = false;
    L19:
        if ((r114 & 128) == 0) goto L22;
        r104 = 0;
    L22:
        if ((r114 & 256) == 0) goto L25;
        r110 = 0;
    L25:
        if ((r114 & 512) == 0) goto L28;
        r111 = false;
    L28:
        if ((r114 & 1024) == 0) goto L31;
        r112 = 0;
    L31:
        if ((r114 & 2048) == 0) goto L33;
        r113 = 0;
    L33:
        this.f201531d = r100;
        this.f201532e = r101;
        this.f201533f = r105;
        this.f201534g = false;
        this.f201535h = false;
        this.f201536i = r102;
        this.f201537j = r103;
        this.f201538k = r104;
        this.f201539l = r110;
        this.f201540m = r111;
        this.f201541n = r112;
        this.f201542o = r113;
        return;
    L11:
        r105 = false;
        goto L13
    }
}

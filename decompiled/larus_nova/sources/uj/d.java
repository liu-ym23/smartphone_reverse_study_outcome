package uj;

import com.bytedance.android.ec.hybrid.card.util.g;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import zz6.IKitView;

/* JADX INFO: loaded from: classes44.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f550228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f550229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f550230c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f550231d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<String, ? extends Object> f550232e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f550233f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final g<? extends IKitView> f550234g;

    public d() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L20;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f550228a, r101.f550228a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f550229b, r101.f550229b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f550230c, r101.f550230c) == true) goto L12;
        return false;
    L12:
        if (this.f550231d == r101.f550231d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f550232e, r101.f550232e) == true) goto L16;
        return false;
    L16:
        if (this.f550233f == r101.f550233f) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f550234g, r101.f550234g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        String r100 = this.f550228a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f550229b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f550230c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        boolean r110 = this.f550231d;
        ?? r111 = 1;
        ?? r112 = r110;
        if (r110 == false) goto L17;
        r112 = 1;
    L17:
        int r113 = (r109 + r112) * 31;
        Map<String, ? extends Object> r114 = this.f550232e;
        if (r114 == null) goto L20;
        int r115 = r114.hashCode();
    L21:
        int r116 = (r113 + r115) * 31;
        boolean r117 = this.f550233f;
        if (r117 == true) goto L25;
        r111 = r117;
    L25:
        int r118 = (r116 + r111) * 31;
        g<? extends IKitView> r119 = this.f550234g;
        if (r119 == null) goto L29;
        r101 = r119.hashCode();
    L29:
        return r118 + r101;
    L20:
        r115 = 0;
        goto L21
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
        return "MakeOriginBridgeNeedParams(sceneID=" + this.f550228a + ", containerId=" + this.f550229b + ", eventName=" + this.f550230c + ", enableStrictMode=" + this.f550231d + ", eventParams=" + this.f550232e + ", enableJSRuntime=" + this.f550233f + ", kitViewSupplier=" + this.f550234g + ")";
    }

    public d(String r100, String r101, String r102, boolean r103, Map r104, boolean r105, g r110, int r111) {
        if ((r111 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r111 & 4) == 0) goto L9;
        r102 = "";
    L9:
        if ((r111 & 8) == 0) goto L12;
        r103 = false;
    L12:
        if ((r111 & 16) == 0) goto L15;
        r104 = null;
    L15:
        if ((r111 & 32) == 0) goto L17;
        r105 = false;
    L17:
        Intrinsics.checkNotNullParameter(r101, "containerId");
        Intrinsics.checkNotNullParameter(r102, "eventName");
        Intrinsics.checkNotNullParameter(r110, "kitViewSupplier");
        this.f550228a = r100;
        this.f550229b = r101;
        this.f550230c = r102;
        this.f550231d = r103;
        this.f550232e = r104;
        this.f550233f = r105;
        this.f550234g = r110;
    }
}

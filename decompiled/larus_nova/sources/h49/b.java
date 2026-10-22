package h49;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f483785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f483786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int[] f483787c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f483788d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f483789e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f483790f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f483785a, r101.f483785a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f483786b, r101.f483786b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f483787c, r101.f483787c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f483788d, r101.f483788d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f483789e, r101.f483789e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f483790f, r101.f483790f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f483785a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        int[] r104 = this.f483786b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        int[] r107 = this.f483787c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f483788d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f483789e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.f483790f;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = Arrays.hashCode(r107);
        goto L14
    L9:
        r105 = Arrays.hashCode(r104);
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "DoraWidgetDeviceInfo(deviceName=" + this.f483785a + ", battery=" + Arrays.toString(this.f483786b) + ", charge=" + Arrays.toString(this.f483787c) + ", model=" + this.f483788d + ", serialNumber=" + this.f483789e + ", productId=" + this.f483790f + ')';
    }

    public b(String r100, int[] r101, int[] r102, String r103, String r104, Integer r105) {
        this.f483785a = r100;
        this.f483786b = r101;
        this.f483787c = r102;
        this.f483788d = r103;
        this.f483789e = r104;
        this.f483790f = r105;
    }
}

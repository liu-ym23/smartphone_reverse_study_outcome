package jd2;

import com.bytedance.android.livesdk.ktvapi.model.PanelType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f498243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f498244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f498245c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f498246d;

    public f() {
        this(null, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L14;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f498243a, r101.f498243a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f498244b, r101.f498244b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f498245c, r101.f498245c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f498246d, r101.f498246d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f498243a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f498244b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f498245c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f498246d;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
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
        return "OpenPanelEvent(panelType=" + this.f498243a + ", enterFrom=" + this.f498244b + ", topTab=" + this.f498245c + ", labelName=" + this.f498246d + ")";
    }

    public f(String r100, int r101) {
        if ((r101 & 1) == 0) goto L6;
        r100 = PanelType.UNKNOWN.getValue();
    L6:
        if ((r101 & 2) == 0) goto L8;
        String r102 = "";
    L9:
        Intrinsics.checkNotNullParameter(r100, "panelType");
        Intrinsics.checkNotNullParameter(r102, "enterFrom");
        this.f498243a = r100;
        this.f498244b = r102;
        this.f498245c = null;
        this.f498246d = null;
        return;
    L8:
        r102 = null;
        goto L9
    }
}

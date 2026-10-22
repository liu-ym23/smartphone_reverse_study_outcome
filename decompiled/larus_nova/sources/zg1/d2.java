package zg1;

import com.bytedance.android.live.browser.jsbridge.newmethods.r6;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class d2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f571813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f571814b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f571815c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e2 f571816d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d2) == false) goto L14;
        d2 r101 = (d2) r100;
        if (Intrinsics.areEqual(this.f571813a, r101.f571813a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f571814b, r101.f571814b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f571815c, r101.f571815c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f571816d, r101.f571816d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f571813a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f571814b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f571815c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        e2 r110 = this.f571816d;
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
        return "OpenStickerSelectPanelEvent(panel=" + this.f571813a + ", tab=" + this.f571814b + ", selectEffectID=" + this.f571815c + ", listener=" + this.f571816d + ")";
    }

    public d2(String r100, String r101, String r102, r6 r103) {
        Intrinsics.checkNotNullParameter(r100, "panel");
        Intrinsics.checkNotNullParameter(r101, "tab");
        Intrinsics.checkNotNullParameter(r102, "selectEffectID");
        Intrinsics.checkNotNullParameter(r103, "listener");
        this.f571813a = r100;
        this.f571814b = r101;
        this.f571815c = r102;
        this.f571816d = r103;
    }
}

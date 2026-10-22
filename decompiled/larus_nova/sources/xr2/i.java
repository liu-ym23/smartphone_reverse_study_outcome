package xr2;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f564839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f564840b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f564841c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f564842d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L14;
        i r101 = (i) r100;
        if (this.f564839a == r101.f564839a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f564840b, r101.f564840b) == true) goto L10;
        return false;
    L10:
        if (this.f564841c == r101.f564841c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f564842d, r101.f564842d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f564839a * 31;
        View r101 = this.f564840b;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        long r104 = this.f564841c;
        int r105 = (((r100 + r103) * 31) + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        String r106 = this.f564842d;
        if (r106 == null) goto L10;
        r102 = r106.hashCode();
    L10:
        return r105 + r102;
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "RevShortTermIcon(typeId=" + this.f564839a + ", view=" + this.f564840b + ", blockingEntryMs=" + this.f564841c + ", iconDesc=" + this.f564842d + ")";
    }

    public i(int r100, View r101, long r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r103, "iconDesc");
        this.f564839a = r100;
        this.f564840b = r101;
        this.f564841c = r102;
        this.f564842d = r103;
    }
}

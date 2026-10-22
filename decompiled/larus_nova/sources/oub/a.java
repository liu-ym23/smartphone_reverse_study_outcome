package oub;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f526795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f526796b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f526797c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f526795a, r101.f526795a) == true) goto L12;
        return false;
    L12:
        if (this.f526796b == r101.f526796b) goto L15;
        return false;
    L15:
        if (this.f526797c == r101.f526797c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f526795a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (((r101 * 31) + this.f526796b) * 31) + this.f526797c;
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "OfficeSDKAudioVolumeInfo(uid=" + this.f526795a + ", volume=" + this.f526796b + ", linearVolume=" + this.f526797c + ')';
    }

    public a(String r100, int r101, int r102) {
        this.f526795a = r100;
        this.f526796b = r101;
        this.f526797c = r102;
    }
}

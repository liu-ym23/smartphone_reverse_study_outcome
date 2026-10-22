package yl8;

import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f568329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f568330b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f568331c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f568332d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f568329a == r101.f568329a) goto L12;
        return false;
    L12:
        if (this.f568330b == r101.f568330b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f568331c, r101.f568331c) == true) goto L18;
        return false;
    L18:
        if (this.f568332d == r101.f568332d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f568329a * 31) + this.f568330b) * 31) + this.f568331c.hashCode()) * 31;
        if (this.f568332d == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "LyricsToSongVMData(maxWidth=" + this.f568329a + ", cardPosition=" + this.f568330b + ", model=" + this.f568331c + ", isShareMode=" + this.f568332d + ')';
    }

    public b(int r100, int r101, a r102) {
        Intrinsics.checkNotNullParameter(r102, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        this.f568329a = r100;
        this.f568330b = r101;
        this.f568331c = r102;
        this.f568332d = false;
    }
}

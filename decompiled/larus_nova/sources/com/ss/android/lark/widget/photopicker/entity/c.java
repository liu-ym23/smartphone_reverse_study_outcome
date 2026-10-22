package com.ss.android.lark.widget.photopicker.entity;

import com.ss.android.lark.imageqrcode.QRCodeResultInfo;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f447517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PhotoQRCodeScanStatus f447518b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f447519c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<QRCodeResultInfo> f447520d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f447517a, r101.f447517a) == true) goto L12;
        return false;
    L12:
        if (this.f447518b == r101.f447518b) goto L15;
        return false;
    L15:
        if (this.f447519c == r101.f447519c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f447520d, r101.f447520d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f447517a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = ((r101 * 31) + this.f447518b.hashCode()) * 31;
        if (this.f447519c == false) goto L9;
        int r103 = 1231;
    L11:
        return ((r102 + r103) * 31) + this.f447520d.hashCode();
    L9:
        r103 = 1237;
        goto L11
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "PhotoQRCodeState(showFile=" + this.f447517a + ", scanStatus=" + this.f447518b + ", useScreenShotScan=" + this.f447519c + ", resultList=" + this.f447520d + ')';
    }

    public /* synthetic */ c(String r100, PhotoQRCodeScanStatus r101) {
        this(r100, r101, false, new ArrayList());
    }

    public c(String r100, PhotoQRCodeScanStatus r101, boolean r102, ArrayList<QRCodeResultInfo> r103) {
        Intrinsics.checkNotNullParameter(r101, "scanStatus");
        Intrinsics.checkNotNullParameter(r103, "resultList");
        this.f447517a = r100;
        this.f447518b = r101;
        this.f447519c = r102;
        this.f447520d = r103;
    }
}

package com.larus.dora.obric.device_management.device_home;

import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f339326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f339327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DoraObricDeviceModeEntryProduct f339328c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h3 f339329d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.f339326a, r101.f339326a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f339327b, r101.f339327b) == true) goto L15;
        return false;
    L15:
        if (this.f339328c == r101.f339328c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f339329d, r101.f339329d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f339326a.hashCode() * 31) + this.f339327b.hashCode()) * 31) + this.f339328c.hashCode()) * 31) + this.f339329d.hashCode();
    }

    public final String toString() {
        return "DoraObricDeviceHomeDeviceCardItem(deviceMac=" + this.f339326a + ", card=" + this.f339327b + ", modeEntryProduct=" + this.f339328c + ", glassesMode=" + this.f339329d + ')';
    }

    public q(String r100, r r101, DoraObricDeviceModeEntryProduct r102, h3 r103) {
        Intrinsics.checkNotNullParameter(r100, "deviceMac");
        Intrinsics.checkNotNullParameter(r101, BrowserDependency.UrlClickType.CARD);
        Intrinsics.checkNotNullParameter(r102, "modeEntryProduct");
        Intrinsics.checkNotNullParameter(r103, "glassesMode");
        this.f339326a = r100;
        this.f339327b = r101;
        this.f339328c = r102;
        this.f339329d = r103;
    }
}

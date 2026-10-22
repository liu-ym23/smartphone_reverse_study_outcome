package com.larus.dora.impl.device.settings.gesture.options;

import com.larus.dora.impl.device.settings.gesture.DoraGGestureSettings;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f334480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f334481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<DoraGGestureSettings> f334482c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f334480a, r101.f334480a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f334481b, r101.f334481b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f334482c, r101.f334482c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f334480a.hashCode() * 31) + this.f334481b.hashCode()) * 31) + this.f334482c.hashCode();
    }

    public final String toString() {
        return "QuickControlGuideDialogData(title=" + this.f334480a + ", message=" + this.f334481b + ", combinedSettings=" + this.f334482c + ')';
    }

    public p(String r100, String r101, List<DoraGGestureSettings> r102) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "message");
        Intrinsics.checkNotNullParameter(r102, "combinedSettings");
        this.f334480a = r100;
        this.f334481b = r101;
        this.f334482c = r102;
    }
}

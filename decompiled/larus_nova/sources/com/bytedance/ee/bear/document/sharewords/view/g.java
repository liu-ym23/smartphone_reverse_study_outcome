package com.bytedance.ee.bear.document.sharewords.view;

import com.ss.android.lark.forwardv2.dto.ForwardTarget;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ForwardTarget f221836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f221837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f221838c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f221839d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f221836a, r101.f221836a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f221837b, r101.f221837b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f221838c, r101.f221838c) == true) goto L18;
        return false;
    L18:
        if (this.f221839d == r101.f221839d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f221836a.hashCode() * 31) + this.f221837b.hashCode()) * 31) + this.f221838c.hashCode()) * 31) + this.f221839d;
    }

    public final String toString() {
        return "NoteParams(target=" + h.a(this.f221836a) + ", parentId=" + this.f221837b + ", note=" + this.f221838c + ", targetSize=" + this.f221839d + ')';
    }

    public g(ForwardTarget r100, String r101, String r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r101, "parentId");
        Intrinsics.checkNotNullParameter(r102, "note");
        this.f221836a = r100;
        this.f221837b = r101;
        this.f221838c = r102;
        this.f221839d = r103;
    }
}

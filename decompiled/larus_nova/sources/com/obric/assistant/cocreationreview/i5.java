package com.obric.assistant.cocreationreview;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class i5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l5 f387317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<a> f387318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<a> f387319c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, a5> f387320d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i5) == true) goto L8;
        return false;
    L8:
        i5 r101 = (i5) r100;
        if (Intrinsics.areEqual(this.f387317a, r101.f387317a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f387318b, r101.f387318b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f387319c, r101.f387319c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f387320d, r101.f387320d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f387317a.hashCode() * 31) + this.f387318b.hashCode()) * 31) + this.f387319c.hashCode()) * 31) + this.f387320d.hashCode();
    }

    public final String toString() {
        return "LabelingSnapshot(moduleMeta=" + this.f387317a + ", pendingRecords=" + this.f387318b + ", completedRecords=" + this.f387319c + ", feedbackByRecordId=" + this.f387320d + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i5(l5 r100, List<? extends a> r101, List<? extends a> r102, Map<String, a5> r103) {
        Intrinsics.checkNotNullParameter(r100, "moduleMeta");
        Intrinsics.checkNotNullParameter(r101, "pendingRecords");
        Intrinsics.checkNotNullParameter(r102, "completedRecords");
        Intrinsics.checkNotNullParameter(r103, "feedbackByRecordId");
        this.f387317a = r100;
        this.f387318b = r101;
        this.f387319c = r102;
        this.f387320d = r103;
    }
}

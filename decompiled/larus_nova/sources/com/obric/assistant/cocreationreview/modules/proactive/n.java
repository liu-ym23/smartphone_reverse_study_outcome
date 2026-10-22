package com.obric.assistant.cocreationreview.modules.proactive;

import com.obric.memorydata.sdk.proactive.ProactiveLabelingFeedbackConfigDto;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<q> f387488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ProactiveLabelingFeedbackConfigDto f387489b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.f387488a, r101.f387488a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f387489b, r101.f387489b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f387488a.hashCode() * 31) + this.f387489b.hashCode();
    }

    public final String toString() {
        return "ProactiveAgentRemoteSnapshot(records=" + this.f387488a + ", feedbackConfig=" + this.f387489b + ')';
    }

    public n(List<q> r100, ProactiveLabelingFeedbackConfigDto r101) {
        Intrinsics.checkNotNullParameter(r100, "records");
        Intrinsics.checkNotNullParameter(r101, "feedbackConfig");
        this.f387488a = r100;
        this.f387489b = r101;
    }
}

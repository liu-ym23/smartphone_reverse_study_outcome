package com.obric.memorydata.sdk.screencapture;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TaskOptions f397223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f397224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<ScreenData, Unit> f397225c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f397223a, r101.f397223a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f397224b, r101.f397224b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f397225c, r101.f397225c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f397223a.hashCode() * 31) + this.f397224b.hashCode()) * 31) + this.f397225c.hashCode();
    }

    public final String toString() {
        return "PendingCaptureOperation(taskOptions=" + this.f397223a + ", targetPackage=" + this.f397224b + ", callback=" + this.f397225c + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(TaskOptions r100, String r101, Function1<? super ScreenData, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "taskOptions");
        Intrinsics.checkNotNullParameter(r101, "targetPackage");
        Intrinsics.checkNotNullParameter(r102, "callback");
        this.f397223a = r100;
        this.f397224b = r101;
        this.f397225c = r102;
    }
}

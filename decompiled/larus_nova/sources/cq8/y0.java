package cq8;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: classes26.dex */
public final class y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f465004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineScope f465005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i1<a0> f465006c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof y0) == true) goto L8;
        return false;
    L8:
        y0 r101 = (y0) r100;
        if (Intrinsics.areEqual(this.f465004a, r101.f465004a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f465005b, r101.f465005b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f465006c, r101.f465006c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f465004a.hashCode() * 31) + this.f465005b.hashCode()) * 31) + this.f465006c.hashCode();
    }

    public final String toString() {
        return "WidgetEntry(widgetId=" + this.f465004a + ", scope=" + this.f465005b + ", descriptorFlow=" + this.f465006c + ')';
    }

    public y0(String r100, CoroutineScope r101, b1 r102) {
        Intrinsics.checkNotNullParameter(r100, "widgetId");
        Intrinsics.checkNotNullParameter(r101, "scope");
        Intrinsics.checkNotNullParameter(r102, "descriptorFlow");
        this.f465004a = r100;
        this.f465005b = r101;
        this.f465006c = r102;
    }
}

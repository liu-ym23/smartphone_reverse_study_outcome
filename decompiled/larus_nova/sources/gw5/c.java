package gw5;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f483040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f483041b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f483042c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f483043d;

    public c() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f483040a == r101.f483040a) goto L12;
        return false;
    L12:
        if (this.f483041b == r101.f483041b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f483042c, r101.f483042c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f483043d, r101.f483043d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f483040a * 31) + this.f483041b) * 31) + this.f483042c.hashCode()) * 31) + this.f483043d.hashCode();
    }

    public final String toString() {
        return "FlowAsrFileRetryConfig(maxRetryCount=" + this.f483040a + ", maxTimeOutDuration=" + this.f483041b + ", enableRetryErrorCodeWithCompleteMatch=" + this.f483042c + ", disableRetryErrorCodeWithPrefixMatch=" + this.f483043d + ')';
    }

    public /* synthetic */ c(int r100) {
        this(1, 25000, CollectionsKt.emptyList(), CollectionsKt.emptyList());
    }

    public static c a(c r100, int r101) {
        int r102 = r100.f483041b;
        List<String> r103 = r100.f483042c;
        List<String> r104 = r100.f483043d;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r103, "enableRetryErrorCodeWithCompleteMatch");
        Intrinsics.checkNotNullParameter(r104, "disableRetryErrorCodeWithPrefixMatch");
        return new c(r101, r102, r103, r104);
    }

    public c(int r100, int r101, List<String> r102, List<String> r103) {
        Intrinsics.checkNotNullParameter(r102, "enableRetryErrorCodeWithCompleteMatch");
        Intrinsics.checkNotNullParameter(r103, "disableRetryErrorCodeWithPrefixMatch");
        this.f483040a = r100;
        this.f483041b = r101;
        this.f483042c = r102;
        this.f483043d = r103;
    }
}

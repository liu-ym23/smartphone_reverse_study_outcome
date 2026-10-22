package vc9;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<b> f554135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f554136b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f554135a, r101.f554135a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f554136b, r101.f554136b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f554135a.hashCode() * 31) + this.f554136b.hashCode();
    }

    public final String toString() {
        return "SendBizCmdRequest(requestBody=" + this.f554135a + ", bizCode=" + this.f554136b + ')';
    }

    public a(List<b> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "requestBody");
        Intrinsics.checkNotNullParameter(r101, "bizCode");
        this.f554135a = r100;
        this.f554136b = r101;
    }
}

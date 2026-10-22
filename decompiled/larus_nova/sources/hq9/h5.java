package hq9;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class h5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f486634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f486635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f486636c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h5) == true) goto L8;
        return false;
    L8:
        h5 r101 = (h5) r100;
        if (this.f486634a == r101.f486634a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f486635b, r101.f486635b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f486636c, r101.f486636c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.f486634a == false) goto L5;
        int r100 = 1231;
    L7:
        return (((r100 * 31) + this.f486635b.hashCode()) * 31) + this.f486636c.hashCode();
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "XBridgeConfig(enableJSBPermission=" + this.f486634a + ", authHostWhiteList=" + this.f486635b + ", websiteHostWhiteList=" + this.f486636c + ')';
    }

    public h5(boolean r100, List<String> r101, List<String> r102) {
        Intrinsics.checkNotNullParameter(r101, "authHostWhiteList");
        Intrinsics.checkNotNullParameter(r102, "websiteHostWhiteList");
        this.f486634a = r100;
        this.f486635b = r101;
        this.f486636c = r102;
    }
}

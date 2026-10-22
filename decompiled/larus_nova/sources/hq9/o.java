package hq9;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f486723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f486724b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f486725c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f486726d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f486723a, r101.f486723a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f486724b, r101.f486724b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f486725c, r101.f486725c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f486726d, r101.f486726d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f486723a.hashCode() * 31) + this.f486724b.hashCode()) * 31) + this.f486725c.hashCode()) * 31) + this.f486726d.hashCode();
    }

    public final String toString() {
        return "AsrTtsConfig(wssHost=" + this.f486723a + ", samiUrl=" + this.f486724b + ", whisperUrl=" + this.f486725c + ", authHeader=" + this.f486726d + ')';
    }

    public o(String r100, String r101, String r102, Map<String, String> r103) {
        Intrinsics.checkNotNullParameter(r100, "wssHost");
        Intrinsics.checkNotNullParameter(r101, "samiUrl");
        Intrinsics.checkNotNullParameter(r102, "whisperUrl");
        Intrinsics.checkNotNullParameter(r103, "authHeader");
        this.f486723a = r100;
        this.f486724b = r101;
        this.f486725c = r102;
        this.f486726d = r103;
    }
}

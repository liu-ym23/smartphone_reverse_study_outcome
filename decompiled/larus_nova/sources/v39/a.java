package v39;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f552949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f552950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f552951c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f552952d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f552953e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[] f552954f;

    public final int hashCode() {
        return (((((((((this.f552949a * 31) + this.f552950b) * 31) + this.f552951c) * 31) + Arrays.hashCode(this.f552952d)) * 31) + this.f552953e) * 31) + Arrays.hashCode(this.f552954f);
    }

    public final String toString() {
        return "DoraRemoteData(dataId=" + this.f552949a + ", scene=" + this.f552950b + ", type=" + this.f552951c + ", dataSize=" + this.f552952d.length + ", assId=" + this.f552953e + ", assDataSize=" + this.f552954f.length;
    }

    public final int getType() {
        return this.f552951c;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(a.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.larus.dora.api.core.DoraRemoteData");
        a r102 = (a) r100;
        if (this.f552949a == r102.f552949a) goto L16;
        return false;
    L16:
        if (this.f552950b == r102.f552950b) goto L19;
        return false;
    L19:
        if (this.f552951c == r102.f552951c) goto L22;
        return false;
    L22:
        if (Arrays.equals(this.f552952d, r102.f552952d) == true) goto L25;
        return false;
    L25:
        if (this.f552953e == r102.f552953e) goto L28;
        return false;
    L28:
        if (Arrays.equals(this.f552954f, r102.f552954f) == true) goto L30;
        return false;
    L30:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public a(int r100, int r101, int r102, byte[] r103, int r104, byte[] r105) {
        Intrinsics.checkNotNullParameter(r103, "data");
        Intrinsics.checkNotNullParameter(r105, "assData");
        this.f552949a = r100;
        this.f552950b = r101;
        this.f552951c = r102;
        this.f552952d = r103;
        this.f552953e = r104;
        this.f552954f = r105;
    }
}

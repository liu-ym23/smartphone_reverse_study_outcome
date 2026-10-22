package r5;

import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p5.b f536118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f536119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f536120c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InputStream f536121d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f536118a, r101.f536118a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f536119b, r101.f536119b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f536120c, r101.f536120c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f536121d, r101.f536121d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f536118a.hashCode() * 31) + this.f536119b.hashCode()) * 31) + this.f536120c.hashCode()) * 31) + this.f536121d.hashCode();
    }

    public final String toString() {
        return "AppletCacheResponse(byteArray=" + this.f536118a + ", cacheKey=" + this.f536119b + ", filePath=" + this.f536120c + ", fileStream=" + this.f536121d + ')';
    }

    public static a a(a r100) {
        p5.b r101 = r100.f536118a;
        String r102 = r100.f536119b;
        String r103 = r100.f536120c;
        InputStream r104 = r100.f536121d;
        Intrinsics.checkNotNullParameter(r101, "byteArray");
        Intrinsics.checkNotNullParameter(r102, "cacheKey");
        Intrinsics.checkNotNullParameter(r103, "filePath");
        Intrinsics.checkNotNullParameter(r104, "fileStream");
        return new a(r101, r102, r103, r104);
    }

    public a(p5.b r100, String r101, String r102, InputStream r103) {
        Intrinsics.checkNotNullParameter(r100, "byteArray");
        Intrinsics.checkNotNullParameter(r101, "cacheKey");
        Intrinsics.checkNotNullParameter(r102, "filePath");
        Intrinsics.checkNotNullParameter(r103, "fileStream");
        this.f536118a = r100;
        this.f536119b = r101;
        this.f536120c = r102;
        this.f536121d = r103;
    }
}

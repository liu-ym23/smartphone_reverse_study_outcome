package ub0;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f549324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f549325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f549326c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f549327d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L14;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f549324a, r101.f549324a) == true) goto L8;
        return false;
    L8:
        if (this.f549325b == r101.f549325b) goto L10;
        return false;
    L10:
        if (this.f549326c == r101.f549326c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f549327d, r101.f549327d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f549324a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.f549325b;
        int r104 = ((((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f549326c) * 31;
        String r105 = this.f549327d;
        if (r105 == null) goto L10;
        r101 = r105.hashCode();
    L10:
        return r104 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "LyricsDownloadInfo(lyricsUrl=" + this.f549324a + ", musicId=" + this.f549325b + ", lyricsType=" + this.f549326c + ", savePath=" + this.f549327d + ")";
    }

    public c(String r100, long r101, int r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "lyricsUrl");
        Intrinsics.checkNotNullParameter(r103, DBDefinition.SAVE_PATH);
        this.f549324a = r100;
        this.f549325b = r101;
        this.f549326c = r102;
        this.f549327d = r103;
    }
}

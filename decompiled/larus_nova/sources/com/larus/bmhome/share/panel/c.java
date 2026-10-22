package com.larus.bmhome.share.panel;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f313884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f313885b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f313886c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f313887d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f313888e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f313884a, r101.f313884a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f313885b, r101.f313885b) == true) goto L15;
        return false;
    L15:
        if (this.f313886c == r101.f313886c) goto L18;
        return false;
    L18:
        if (this.f313887d == r101.f313887d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f313888e, r101.f313888e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f313884a.hashCode() * 31) + this.f313885b.hashCode()) * 31) + this.f313886c) * 31;
        long r101 = this.f313887d;
        return ((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f313888e.hashCode();
    }

    public final String toString() {
        return "HostForwardFileContent(resourceUri=" + this.f313884a + ", fileName=" + this.f313885b + ", storageType=" + this.f313886c + ", fileSize=" + this.f313887d + ", mimeType=" + this.f313888e + ')';
    }

    public c(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "resourceUri");
        Intrinsics.checkNotNullParameter(r101, "fileName");
        Intrinsics.checkNotNullParameter(r102, DBDefinition.MIME_TYPE);
        this.f313884a = r100;
        this.f313885b = r101;
        this.f313886c = 3;
        this.f313887d = 0;
        this.f313888e = r102;
    }
}

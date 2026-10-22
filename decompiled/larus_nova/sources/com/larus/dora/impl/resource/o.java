package com.larus.dora.impl.resource;

import com.bytedance.keva.KevaImpl;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f337902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<String> f337903b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f337902a, r101.f337902a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f337903b, r101.f337903b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f337902a.hashCode() * 31) + this.f337903b.hashCode();
    }

    public final String toString() {
        return "DoraResourceArtifactState(identity=" + this.f337902a + ", files=" + this.f337903b + ')';
    }

    public final m a() {
        return this.f337902a;
    }

    public o(m r100, Set<String> r101) {
        Intrinsics.checkNotNullParameter(r100, DownloadHelper.IDENTITY);
        Intrinsics.checkNotNullParameter(r101, KevaImpl.PrivateConstants.FILES_DIR_NAME);
        this.f337902a = r100;
        this.f337903b = r101;
    }
}

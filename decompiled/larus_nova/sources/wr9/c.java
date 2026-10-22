package wr9;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d<Long> f560881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d<Long> f560882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d<Long> f560883c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d<Boolean> f560884d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f560881a, r101.f560881a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f560882b, r101.f560882b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f560883c, r101.f560883c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f560884d, r101.f560884d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f560881a.hashCode() * 31) + this.f560882b.hashCode()) * 31) + this.f560883c.hashCode()) * 31) + this.f560884d.hashCode();
    }

    public final String toString() {
        return "MemoryState(totalBytes=" + this.f560881a + ", availableBytes=" + this.f560882b + ", processPssBytes=" + this.f560883c + ", isLowMemory=" + this.f560884d + ')';
    }

    public c(d<Long> r100, d<Long> r101, d<Long> r102, d<Boolean> r103) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TOTAL_BYTES);
        Intrinsics.checkNotNullParameter(r101, "availableBytes");
        Intrinsics.checkNotNullParameter(r102, "processPssBytes");
        Intrinsics.checkNotNullParameter(r103, "isLowMemory");
        this.f560881a = r100;
        this.f560882b = r101;
        this.f560883c = r102;
        this.f560884d = r103;
    }
}

package pf9;

import com.larus.im.service.audio.event.FileBizType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FileBizType f528911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f528912b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (this.f528911a == r101.f528911a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f528912b, r101.f528912b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f528911a.hashCode() * 31) + this.f528912b.hashCode();
    }

    public final String toString() {
        return "FileBizInfo(bizType=" + this.f528911a + ", bizInfo=" + this.f528912b + ')';
    }

    public g(FileBizType r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "bizType");
        Intrinsics.checkNotNullParameter(r101, "bizInfo");
        this.f528911a = r100;
        this.f528912b = r101;
    }
}

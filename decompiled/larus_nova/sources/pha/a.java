package pha;

import com.obric.assistant.settings.config.CompressParam;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompressParam f529308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f529309b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f529308a, r101.f529308a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f529309b, r101.f529309b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f529308a.hashCode() * 31;
        File r101 = this.f529309b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "CompressResult(compressParam=" + this.f529308a + ", resultFile=" + this.f529309b + ')';
    }

    public a(CompressParam r100, File r101) {
        Intrinsics.checkNotNullParameter(r100, "compressParam");
        this.f529308a = r100;
        this.f529309b = r101;
    }
}

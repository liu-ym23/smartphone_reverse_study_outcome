package kx8;

import android.graphics.RectF;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import nx8.n;

/* JADX INFO: loaded from: classes26.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f506582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f506583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n f506584c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f506585d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f506582a, r101.f506582a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f506583b, r101.f506583b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f506584c, r101.f506584c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f506582a.hashCode() * 31;
        String r101 = this.f506583b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        n r105 = this.f506584c;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ClipRectData(rectF=" + this.f506582a + ", clipImageData=" + this.f506583b + ", serverRotatedInfo=" + this.f506584c + ')';
    }

    public b(RectF r100, String r101, n r102) {
        Intrinsics.checkNotNullParameter(r100, "rectF");
        this.f506582a = r100;
        this.f506583b = r101;
        this.f506584c = r102;
        this.f506585d = LazyKt.lazy(LazyThreadSafetyMode.NONE, new a(this));
    }
}

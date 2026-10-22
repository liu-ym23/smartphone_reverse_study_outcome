package ue8;

import android.view.View;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f549826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference<View> f549827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f549828c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f549829d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f549830e;

    public j() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f549826a, r101.f549826a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f549827b, r101.f549827b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f549828c, r101.f549828c) == true) goto L18;
        return false;
    L18:
        if (this.f549829d == r101.f549829d) goto L21;
        return false;
    L21:
        if (this.f549830e == r101.f549830e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f549826a.hashCode() * 31) + this.f549827b.hashCode()) * 31) + this.f549828c.hashCode()) * 31;
        if (this.f549829d == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        long r103 = this.f549830e;
        return r102 + ((int) (r103 ^ (r103 >>> 32)));
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "ExposureTarget(key=" + this.f549826a + ", viewRef=" + this.f549827b + ", callback=" + this.f549828c + ", isExposed=" + this.f549829d + ", lastCheckTimestamp=" + this.f549830e + ')';
    }

    public j(String r100, WeakReference r101, bm8.h r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "viewRef");
        Intrinsics.checkNotNullParameter(r102, "callback");
        this.f549826a = r100;
        this.f549827b = r101;
        this.f549828c = r102;
        this.f549829d = false;
        this.f549830e = 0;
    }
}

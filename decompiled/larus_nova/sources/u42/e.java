package u42;

import android.view.View;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f548681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f548682b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DataCenter f548683c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g52.e f548684d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L14;
        e r101 = (e) r100;
        if (this.f548681a == r101.f548681a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f548682b, r101.f548682b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f548683c, r101.f548683c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f548684d, r101.f548684d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f548681a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        View r102 = this.f548682b;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (r101 + r104) * 31;
        DataCenter r106 = this.f548683c;
        if (r106 == null) goto L9;
        int r107 = r106.hashCode();
    L10:
        int r108 = (r105 + r107) * 31;
        g52.e r109 = this.f548684d;
        if (r109 == null) goto L14;
        r103 = r109.hashCode();
    L14:
        return r108 + r103;
    L9:
        r107 = 0;
        goto L10
    L5:
        r104 = 0;
        goto L6
    }

    public final String toString() {
        return "PinContext(duration=" + this.f548681a + ", view=" + this.f548682b + ", dataCenter=" + this.f548683c + ", textConfig=" + this.f548684d + ")";
    }

    public e(long r100, View r101, DataCenter r102, g52.e r103) {
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "dataCenter");
        this.f548681a = r100;
        this.f548682b = r101;
        this.f548683c = r102;
        this.f548684d = r103;
    }
}

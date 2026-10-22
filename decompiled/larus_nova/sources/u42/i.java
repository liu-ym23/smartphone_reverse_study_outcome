package u42;

import android.view.View;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.livesdk.interactivity.api.entity.f<?> f548689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f548690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DataCenter f548691c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g52.e f548692d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L14;
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f548689a, r101.f548689a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f548690b, r101.f548690b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f548691c, r101.f548691c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f548692d, r101.f548692d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        com.bytedance.android.livesdk.interactivity.api.entity.f<?> r100 = this.f548689a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        View r104 = this.f548690b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        DataCenter r107 = this.f548691c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        g52.e r110 = this.f548692d;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "UpdatePinContext(message=" + this.f548689a + ", view=" + this.f548690b + ", dataCenter=" + this.f548691c + ", textConfig=" + this.f548692d + ")";
    }

    public i(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r100, View r101, DataCenter r102, g52.e r103) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "dataCenter");
        this.f548689a = r100;
        this.f548690b = r101;
        this.f548691c = r102;
        this.f548692d = r103;
    }
}

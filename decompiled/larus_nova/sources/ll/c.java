package ll;

import androidx.lifecycle.LifecycleEventObserver;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f509660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f509661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LifecycleEventObserver f509662c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L12;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f509660a, r101.f509660a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f509661b, r101.f509661b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f509662c, r101.f509662c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        b r100 = this.f509660a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        a r104 = this.f509661b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        LifecycleEventObserver r107 = this.f509662c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "DynamicRegionModel(identifier=" + this.f509660a + ", model=" + this.f509661b + ", lifecycleEventObserver=" + this.f509662c + ")";
    }

    public final b getIdentifier() {
        return this.f509660a;
    }

    public static c a(c r100, a r101) {
        b r102 = r100.f509660a;
        LifecycleEventObserver r103 = r100.f509662c;
        Intrinsics.checkNotNullParameter(r102, LocationMonitorConst.IDENTIFIER);
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        return new c(r102, r101, r103);
    }

    public c(b r100, a r101, LifecycleEventObserver r102) {
        Intrinsics.checkNotNullParameter(r100, LocationMonitorConst.IDENTIFIER);
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        this.f509660a = r100;
        this.f509661b = r101;
        this.f509662c = r102;
    }
}

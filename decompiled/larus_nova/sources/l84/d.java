package l84;

import com.bytedance.bdlocation.permission.request.RequestPermissionUtils;
import com.bytedance.bdlocation.store.LocationCache;

/* JADX INFO: loaded from: classes10.dex */
public final class d implements RequestPermissionUtils.OnPermissionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RequestPermissionUtils.OnPermissionListener f507927a;

    @Override // com.bytedance.bdlocation.permission.request.RequestPermissionUtils.OnPermissionListener
    public final void onPermissionDenied() {
        this.f507927a.onPermissionDenied();
        LocationCache.getInstance().setLocationDenyTime(System.currentTimeMillis());
    }

    @Override // com.bytedance.bdlocation.permission.request.RequestPermissionUtils.OnPermissionListener
    public final void onPermissionGranted() {
        this.f507927a.onPermissionGranted();
    }

    public d(RequestPermissionUtils.OnPermissionListener r100) {
        this.f507927a = r100;
    }
}

package l84;

import com.bytedance.bdlocation.permission.request.RequestPermissionUtils;
import com.bytedance.bdlocation.store.LocationCache;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d implements RequestPermissionUtils.OnPermissionListener {
    public final /* synthetic */ RequestPermissionUtils.OnPermissionListener a;

    @Override // com.bytedance.bdlocation.permission.request.RequestPermissionUtils.OnPermissionListener
    public final void onPermissionDenied() {
        this.a.onPermissionDenied();
        LocationCache.getInstance().setLocationDenyTime(System.currentTimeMillis());
    }

    @Override // com.bytedance.bdlocation.permission.request.RequestPermissionUtils.OnPermissionListener
    public final void onPermissionGranted() {
        this.a.onPermissionGranted();
    }

    public d(RequestPermissionUtils.OnPermissionListener r1) {
        this.a = r1;
    }
}

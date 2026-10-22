package lr;

import android.app.Activity;
import android.view.WindowManager;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.store.api.IECStoreService;
import com.bytedance.android.ec.store.api.IShopEventListener;
import com.bytedance.android.ec.store.api.ITabKitEventListener;
import com.bytedance.android.ecom.service_annotation.ServiceDefaultImpl;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes44.dex */
@ServiceDefaultImpl
public final class j0 implements IECStoreService {
    public j0() {
    }

    @Override // com.bytedance.android.ec.store.api.IECStoreService
    public final void addBrandMallFractionListener(Function2<? super String, ? super WindowManager, Unit> r100, Function2<? super String, ? super Integer, Unit> r101, Function1<? super String, Unit> r102) {
    }

    @Override // com.bytedance.android.ec.store.api.IECStoreService
    public final Fragment createStoreShellFragment(String r100, int r101, String r102, Object r103, Map<String, String> r104, Map<String, String> r105) {
        return null;
    }

    @Override // com.bytedance.android.ec.store.api.IECStoreService
    public final Map<String, Object> getBizComponentFetchers() {
        return null;
    }

    @Override // com.bytedance.android.ec.store.api.IECStoreService
    public final String getFollowXTabSettings() {
        return "";
    }

    @Override // com.bytedance.android.ec.store.api.IECStoreService
    public final List<Class<? extends Activity>> getLivePlayActivityClass() {
        return null;
    }

    @Override // com.bytedance.android.ec.store.api.IECStoreService
    public final ITabKitEventListener getTabKitEventListener(String r100) {
        return null;
    }

    @Override // com.bytedance.android.ec.store.api.IECStoreService
    public final void notifyFollowStoreVideoMiss(String r100, String r101) {
    }

    @Override // com.bytedance.android.ec.store.api.IECStoreService
    public final void onStoreEntranceShow() {
    }

    @Override // com.bytedance.android.ec.store.api.IECStoreService
    public final void preFetchShopAPI(String r100, fl.b r101) {
    }

    @Override // com.bytedance.android.ec.store.api.IECStoreService
    public final void preloadResource(String r100) {
    }

    @Override // com.bytedance.android.ec.store.api.IECStoreService
    public final void registerShopFragmentListener(String r100, IShopEventListener r101) {
    }

    @Override // com.bytedance.android.ec.store.api.IECStoreService
    public final void registerTabKitEventListener(String r100, ITabKitEventListener r101) {
    }

    @Override // com.bytedance.android.ec.store.api.IECStoreService
    public final boolean shouldRefreshShopCache(String r100) {
        return false;
    }

    @Override // com.bytedance.android.ec.store.api.IECStoreService
    public final void unregisterShopFragmentListener(String r100) {
    }

    @Override // com.bytedance.android.ec.store.api.IECStoreService
    public final void unregisterTabKitEventListener(String r100) {
    }
}

package gk3;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.store.repository.vo.ECTagListDTO;
import com.bytedance.android.ec.store.view.ECTagListView;
import com.bytedance.android.ec.store.view.j;
import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductViewModel;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;

/* JADX INFO: loaded from: classes14.dex */
public interface a {
    ECStoreViewModel a();

    j b(ECTagListDTO r100);

    ECShopHybridProductViewModel c();

    void d(ECTagListView r100);

    void e(ECTagListView r100, ECTagListDTO r101);

    j f(ECTagListDTO r100, View r101);

    LifecycleOwner getLifecycleOwner();
}

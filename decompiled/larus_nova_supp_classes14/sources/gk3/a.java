package gk3;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.store.repository.vo.ECTagListDTO;
import com.bytedance.android.ec.store.view.ECTagListView;
import com.bytedance.android.ec.store.view.j;
import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductViewModel;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public interface a {
    ECStoreViewModel a();

    j b(ECTagListDTO r1);

    ECShopHybridProductViewModel c();

    void d(ECTagListView r1);

    void e(ECTagListView r1, ECTagListDTO r2);

    j f(ECTagListDTO r1, View r2);

    LifecycleOwner getLifecycleOwner();
}

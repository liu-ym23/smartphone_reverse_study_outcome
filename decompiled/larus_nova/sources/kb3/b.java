package kb3;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.shopping.collect.custom_view.CollectGoodsLinkedScrollView;
import com.bytedance.android.shopping.collect.repo.model.CollectParams;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;

/* JADX INFO: loaded from: classes13.dex */
public interface b {
    void a(CollectGoodsLinkedScrollView r100);

    CollectParams b();

    AndroidYaTaInstance c();

    LifecycleOwner getLifecycleOwner();
}

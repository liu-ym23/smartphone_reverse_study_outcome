package wj3;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.hybrid.list.ability.m0;
import com.bytedance.android.shopping.store.router.hybridpage.viewmodel.HybridPageViewModel;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public interface a {
    void a();

    m0 b(Map<String, Object> r100, Map<String, Object> r101);

    HybridPageViewModel c();

    void d(String r100);

    Context getContext();

    Fragment getFragment();
}

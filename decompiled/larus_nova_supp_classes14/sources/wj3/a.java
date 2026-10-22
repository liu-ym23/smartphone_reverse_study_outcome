package wj3;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.hybrid.list.ability.m0;
import com.bytedance.android.shopping.store.router.hybridpage.viewmodel.HybridPageViewModel;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public interface a {
    void a();

    m0 b(Map<String, Object> r1, Map<String, Object> r2);

    HybridPageViewModel c();

    void d(String r1);

    Context getContext();

    Fragment getFragment();
}

package vg3;

import androidx.fragment.app.FragmentManager;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.PdpRootComponent;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface u extends com.bytedance.android.shopping.prepurchase.arch.container.ability.a {
    com.bytedance.android.shopping.prepurchase.business.pdp.services.slice.h C();

    long P0();

    void d0(FragmentManager.FragmentLifecycleCallbacks r1);

    void j1(FragmentManager.FragmentLifecycleCallbacks r1);

    PdpRootComponent k();

    void l1(Function0<Unit> r1);

    void o(String r1, Map<String, Object> r2, Long r3);

    void v0(k0 r1);
}

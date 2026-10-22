package pg9;

import com.bytedance.geckox.settings.IGeckoRegister;
import com.larus.ivykit.gecko.CardPlatformGeckoAppRegister;
import com.larus.ivykit.gecko.ECommerceDanceGeckoRegister;
import com.larus.ivykit.gecko.ECommerceGeckoRegister;
import com.larus.ivykit.gecko.FlowGeckoAppRegister;
import com.larus.ivykit.gecko.LiveGeckoRegister;
import com.larus.ivykit.gecko.MainlandECommerceGeckoRegister;
import com.larus.ivykit.gecko.ObricGeckoAppRegister;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class b extends rx7.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f529212a = null;

    static {
        f529212a = new b();
    }

    @Override // rx7.g
    public final List<rx7.f> a() {
        return CollectionsKt.listOf(new rx7.f[]{e.f529215a, h.f529218a, a.f529211a, d.f529214a, g.f529217a, c.f529213a, f.f529216a});
    }

    @Override // rx7.g
    public final List<IGeckoRegister> b() {
        return CollectionsKt.listOf(new IGeckoRegister[]{new FlowGeckoAppRegister(), new ObricGeckoAppRegister(), new CardPlatformGeckoAppRegister(), new ECommerceGeckoRegister(), new MainlandECommerceGeckoRegister(), new ECommerceDanceGeckoRegister(), new LiveGeckoRegister()});
    }

    @Override // rx7.g
    public final void c() {
    }

    public b() {
    }
}

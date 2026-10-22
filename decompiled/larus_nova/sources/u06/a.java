package u06;

import com.bytedance.ies.argus.api.params.BaseAspectParams;
import com.bytedance.ies.argus.bean.ArgusStrategyProviderType;
import com.bytedance.ies.argus.bean.AspectConfigItem;
import com.bytedance.ies.argus.bean.AspectContext;
import t06.d;

/* JADX INFO: loaded from: classes19.dex */
public abstract class a {
    public a() {
    }

    public abstract void a(AspectConfigItem.a r100, d r101, AspectContext<? extends BaseAspectParams<?>, ? extends com.bytedance.ies.argus.strategy.a>.a r102);

    public abstract ArgusStrategyProviderType b();
}

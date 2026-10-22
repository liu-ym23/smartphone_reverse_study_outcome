package kk5;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.browser.plugin.i;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.SubStrategyType;
import com.bytedance.ee.bear.document.render.node.n;
import com.bytedance.ee.bear.document.v4;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.office.export.docs.bridge.OfficeBridgePlugin;
import com.ss.android.lark.chameleon.ChameleonContainerLifecycleListener;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class b implements v4 {
    public final /* synthetic */ v4 a;
    public final ik5.a b;

    public final ChameleonContainerLifecycleListener getChameleonContainerLifecycleListener() {
        return this.a.getChameleonContainerLifecycleListener();
    }

    public final yx4.d getLoadingLayout(BearUrl r2) {
        Intrinsics.checkNotNullParameter(r2, "bearUrl");
        return this.a.getLoadingLayout(r2);
    }

    public final List<i> getPluginAbility(ChameleonPluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        return this.a.getPluginAbility(r2);
    }

    public final List<n> getRenderNode(ChameleonPluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        return this.a.getRenderNode(r2);
    }

    public final t getUIContainer(ChameleonPluginHost r2, View r3, FragmentManager r4, TitleBar r5) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        Intrinsics.checkNotNullParameter(r3, "contentView");
        Intrinsics.checkNotNullParameter(r4, "fragmentManager");
        return this.a.getUIContainer(r2, r3, r4, r5);
    }

    public b(ik5.a r2) {
        Intrinsics.checkNotNullParameter(r2, "docssdk");
        this.a = f.a(r2, SubStrategyType.BaseApp);
        this.b = r2;
    }

    public final com.bytedance.ee.bear.browser.plugin.n getCommonPluginList(ChameleonPluginHost r4) {
        Intrinsics.checkNotNullParameter(r4, "pluginHost");
        return com.bytedance.ee.bear.browser.plugin.n.c(f.a(this.b, SubStrategyType.BaseApp).getCommonPluginList(r4), new com.bytedance.ee.bear.browser.plugin.n(new com.bytedance.ee.bear.browser.plugin.n.a[]{com.bytedance.ee.bear.browser.plugin.n.h(new OfficeBridgePlugin(), true)}));
    }
}

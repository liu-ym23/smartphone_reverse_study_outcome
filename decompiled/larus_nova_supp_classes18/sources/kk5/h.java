package kk5;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.browser.plugin.i;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.render.node.n;
import com.bytedance.ee.bear.document.v4;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.office.export.docs.bridge.OfficeBridgePlugin;
import com.ss.android.lark.chameleon.ChameleonContainerLifecycleListener;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class h implements v4 {
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

    public h(ik5.a r2) {
        Intrinsics.checkNotNullParameter(r2, "docssdk");
        if (f.b != null) goto L5;
        f.b = r2.a5(sbb.e.m);
    L5:
        v4 r0 = f.b;
        if (r0 != null) goto L8;
        r0 = r2.a5(sbb.e.m);
    L8:
        this.a = r0;
        this.b = r2;
    }

    public final com.bytedance.ee.bear.browser.plugin.n getCommonPluginList(ChameleonPluginHost r4) {
        Intrinsics.checkNotNullParameter(r4, "pluginHost");
        ik5.a r0 = this.b;
        if (f.b != null) goto L5;
        f.b = r0.a5(sbb.e.m);
    L5:
        v4 r1 = f.b;
        if (r1 != null) goto L9;
        r1 = r0.a5(sbb.e.m);
    L9:
        return com.bytedance.ee.bear.browser.plugin.n.c(r1.getCommonPluginList(r4), new com.bytedance.ee.bear.browser.plugin.n(new com.bytedance.ee.bear.browser.plugin.n.a[]{com.bytedance.ee.bear.browser.plugin.n.h(new OfficeBridgePlugin(), true)}));
    }
}

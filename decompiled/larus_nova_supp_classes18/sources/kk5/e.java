package kk5;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.browser.plugin.i;
import com.bytedance.ee.bear.browser.plugin.n;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.v4;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.office.export.docs.bridge.OfficeBridgePlugin;
import com.ss.android.lark.chameleon.ChameleonContainerLifecycleListener;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class e implements v4 {
    private final /* synthetic */ v4 $$delegate_0;
    private final ik5.a docssdk;

    public n getBizPluginList(ChameleonPluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        return this.$$delegate_0.getBizPluginList(r2);
    }

    public ChameleonContainerLifecycleListener getChameleonContainerLifecycleListener() {
        return this.$$delegate_0.getChameleonContainerLifecycleListener();
    }

    public yx4.d getLoadingLayout(BearUrl r2) {
        Intrinsics.checkNotNullParameter(r2, "bearUrl");
        return this.$$delegate_0.getLoadingLayout(r2);
    }

    public List<i> getPluginAbility(ChameleonPluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        return this.$$delegate_0.getPluginAbility(r2);
    }

    public List<com.bytedance.ee.bear.document.render.node.n> getRenderNode(ChameleonPluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        return this.$$delegate_0.getRenderNode(r2);
    }

    public t getUIContainer(ChameleonPluginHost r2, View r3, FragmentManager r4, TitleBar r5) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        Intrinsics.checkNotNullParameter(r3, "contentView");
        Intrinsics.checkNotNullParameter(r4, "fragmentManager");
        return this.$$delegate_0.getUIContainer(r2, r3, r4, r5);
    }

    public e(ik5.a r2) {
        Intrinsics.checkNotNullParameter(r2, "docssdk");
        if (f.a != null) goto L5;
        f.a = r2.a5(sbb.e.o);
    L5:
        v4 r0 = f.a;
        if (r0 != null) goto L8;
        r0 = r2.a5(sbb.e.o);
    L8:
        this.$$delegate_0 = r0;
        this.docssdk = r2;
    }

    private final n getExtendedPluginList(ChameleonPluginHost r3) {
        return new n(new n.a[]{n.h(new OfficeBridgePlugin(), true)});
    }

    public n getCommonPluginList(ChameleonPluginHost r3) {
        Intrinsics.checkNotNullParameter(r3, "pluginHost");
        ik5.a r0 = this.docssdk;
        if (f.a != null) goto L5;
        f.a = r0.a5(sbb.e.o);
    L5:
        v4 r1 = f.a;
        if (r1 != null) goto L9;
        r1 = r0.a5(sbb.e.o);
    L9:
        return n.c(r1.getCommonPluginList(r3), getExtendedPluginList(r3));
    }
}

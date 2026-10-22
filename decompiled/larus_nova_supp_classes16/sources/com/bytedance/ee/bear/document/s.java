package com.bytedance.ee.bear.document;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.domain.BearUrl;
import com.ss.android.lark.chameleon.ChameleonContainerLifecycleListener;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class s implements v4 {
    public s() {
    }

    @Override // com.bytedance.ee.bear.document.v4
    public final ChameleonContainerLifecycleListener getChameleonContainerLifecycleListener() {
        return null;
    }

    @Override // com.bytedance.ee.bear.document.v4
    public final com.bytedance.ee.bear.browser.plugin.n getBizPluginList(ChameleonPluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        return new com.bytedance.ee.bear.browser.plugin.n(new com.bytedance.ee.bear.browser.plugin.n.a[0]);
    }

    @Override // com.bytedance.ee.bear.document.v4
    public final com.bytedance.ee.bear.browser.plugin.n getCommonPluginList(ChameleonPluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        return new com.bytedance.ee.bear.browser.plugin.n(new com.bytedance.ee.bear.browser.plugin.n.a[0]);
    }

    @Override // com.bytedance.ee.bear.document.v4
    public final yx4.d getLoadingLayout(BearUrl r2) {
        Intrinsics.checkNotNullParameter(r2, "bearUrl");
        return null;
    }

    @Override // com.bytedance.ee.bear.document.v4
    public final List<com.bytedance.ee.bear.browser.plugin.i> getPluginAbility(ChameleonPluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        return CollectionsKt.emptyList();
    }

    @Override // com.bytedance.ee.bear.document.v4
    public final List<com.bytedance.ee.bear.document.render.node.n> getRenderNode(ChameleonPluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        return CollectionsKt.emptyList();
    }

    @Override // com.bytedance.ee.bear.document.v4
    public final com.bytedance.ee.bear.browser.plugin.t getUIContainer(ChameleonPluginHost r1, View r2, FragmentManager r3, TitleBar r4) {
        Intrinsics.checkNotNullParameter(r1, "pluginHost");
        Intrinsics.checkNotNullParameter(r2, "contentView");
        Intrinsics.checkNotNullParameter(r3, "fragmentManager");
        return null;
    }
}

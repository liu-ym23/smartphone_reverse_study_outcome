package com.bytedance.ee.bear.document;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.domain.BearUrl;
import com.ss.android.lark.chameleon.ChameleonContainerLifecycleListener;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface v4 {
    com.bytedance.ee.bear.browser.plugin.n getBizPluginList(ChameleonPluginHost r1);

    ChameleonContainerLifecycleListener getChameleonContainerLifecycleListener();

    com.bytedance.ee.bear.browser.plugin.n getCommonPluginList(ChameleonPluginHost r1);

    yx4.d getLoadingLayout(BearUrl r1);

    List<com.bytedance.ee.bear.browser.plugin.i> getPluginAbility(ChameleonPluginHost r1);

    List<com.bytedance.ee.bear.document.render.node.n> getRenderNode(ChameleonPluginHost r1);

    com.bytedance.ee.bear.browser.plugin.t getUIContainer(ChameleonPluginHost r1, View r2, FragmentManager r3, TitleBar r4);
}

package com.ss.android.lark.chameleon.pluginsystem.plugin;

import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.chameleon.idependency.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes35.dex */
public class DefaultUILayoutStrategy implements UIContainer.LayoutStrategy {
    private static final String TAG_ALL_PLUGINS_ROOT = "AllPluginsRoot";
    private final String TAG;
    private PluginList allPlugins;
    private ViewGroup allPluginsRoot;
    private final UIContainer uiContainer;

    public static /* synthetic */ int a(Map r100, Plugin r101, Plugin r102) {
        return lambda$ensureContainerWithLevel$0(r100, r101, r102);
    }

    private void ensureAllPluginsRoot() {
        ViewGroup r100 = (ViewGroup) this.uiContainer.findView(R.id.pluginUIContainer);
        this.allPluginsRoot = r100;
        if (r100 == null) goto L7;
        r100.setTag(TAG_ALL_PLUGINS_ROOT);
        return;
    L7:
        throw new IllegalStateException("All plugins root not found ! [find by id: R.id.pluginUIContainer]");
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.UIContainer.LayoutStrategy
    public UIState saveUIState() {
        ArrayList r100 = new ArrayList();
        int r101 = 0;
    L4:
        if (r101 >= this.allPluginsRoot.getChildCount()) goto L10;
        View r102 = this.allPluginsRoot.getChildAt(r101);
        if (r102.getTag(R.id.pluginUIContainer) == null) goto L8;
        r100.add(new Pair(r102.getTag(), Integer.valueOf(r102.getId())));
    L8:
        r101 = r101 + 1;
        goto L4
    L10:
        return new UIState(r100);
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.UIContainer.LayoutStrategy
    public ViewGroup getAllPluginsContainer() {
        return this.allPluginsRoot;
    }

    public DefaultUILayoutStrategy(UIContainer r100) {
        this.TAG = "LayoutStrategy#" + Integer.toHexString(hashCode());
        this.uiContainer = r100;
    }

    private void ensureContainerWithLevel(PluginList r100) {
        ArrayList r101 = new ArrayList();
        final HashMap r102 = new HashMap();
        Iterator<Map.Entry<Plugin, PluginList.Metadata>> r103 = r100.metadataMap().entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        Map.Entry<Plugin, PluginList.Metadata> r104 = r103.next();
        Plugin r105 = r104.getKey();
        PluginList.Metadata r106 = r104.getValue();
        if (r106.pluginContainerLevel == Integer.MIN_VALUE) goto L4;
        r101.add(r105);
        r102.put(r105, Integer.valueOf(r106.pluginContainerLevel));
        goto L4
    L8:
        Collections.sort(r101, new a(r102));
        int r107 = 0;
    L10:
        if (r107 >= r101.size()) goto L12;
        Plugin r108 = (Plugin) ListProtector.get(r101, r107);
        ensurePluginContainer(r108.getClass().getName(), getPluginContainerViewId(r108));
        r107 = r107 + 1;
        goto L10
    }

    private PluginList.Metadata findPluginMeta(Plugin<?> r100) {
        PluginList r101 = this.allPlugins;
        if (r101 == null) goto L5;
        PluginList.Metadata r102 = r101.findPluginMetadata(r100);
    L6:
        if (r102 != null) goto L8;
        Log.w(this.TAG, "Plugin metadata not found:" + r100);
    L8:
        return r102;
    L5:
        r102 = null;
        goto L6
    }

    private View findViewWithTag(String r100) {
        if (TAG_ALL_PLUGINS_ROOT.equals(r100) == false) goto L7;
        return this.allPluginsRoot;
    L7:
        return this.uiContainer.findView(r100);
    }

    private String getPluginContainerTag(Plugin r100) {
        String r101 = r100.getClass().getName();
        if (this.allPluginsRoot.findViewWithTag(r101) == null) goto L5;
        return r101;
    L5:
        PluginList.Metadata r102 = findPluginMeta(r100);
        if (r102 != null) goto L8;
        return TAG_ALL_PLUGINS_ROOT;
    L8:
        if (r102.pluginContainerLevel == Integer.MIN_VALUE) goto L12;
        return r101;
    L12:
        return TAG_ALL_PLUGINS_ROOT;
    }

    private int getPluginContainerViewId(Plugin r100) {
        View r101 = this.allPluginsRoot.findViewWithTag(r100.getClass().getName());
        if (r101 == null) goto L7;
        return r101.getId();
    L7:
        return View.generateViewId();
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.UIContainer.LayoutStrategy
    public void restoreUIState(UIState r100) {
        ensureAllPluginsRoot();
        if (r100 == null) goto L8;
        Iterator<Pair<Object, Integer>> r101 = r100.pluginLevels.iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        Pair<Object, Integer> r102 = r101.next();
        ensurePluginContainer(r102.first, ((Integer) r102.second).intValue());
        goto L6
    L10:
        return;
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.UIContainer.LayoutStrategy
    public void updateLayoutStrategy(PluginList r100) {
        this.allPlugins = r100;
        ensureAllPluginsRoot();
        ensureContainerWithLevel(r100);
    }

    private void ensurePluginContainer(Object r100, int r101) {
        if (this.allPluginsRoot.findViewWithTag(r100) == null) goto L5;
        return;
    L5:
        NoConsumeInsetsFrameLayout r102 = new NoConsumeInsetsFrameLayout(this.uiContainer.getContext());
        r102.setTag(r100);
        r102.setTag(R.id.pluginUIContainer, r100);
        r102.setId(r101);
        this.allPluginsRoot.addView(r102, -1, -1);
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.UIContainer.LayoutStrategy
    public ViewGroup getPluginContainer(UIContainer r100, Plugin r101) {
        View r102 = findViewWithTag(getPluginContainerTag(r101));
        if (r102 != null) goto L7;
        IllegalStateException r103 = new IllegalStateException(r101.toString());
        Log.e(this.TAG, r103.toString());
        return this.allPluginsRoot;
    L7:
        return (ViewGroup) r102;
    }

    private static /* synthetic */ int lambda$ensureContainerWithLevel$0(Map r100, Plugin r101, Plugin r102) {
        return ((Integer) r100.get(r101)).compareTo((Integer) r100.get(r102));
    }
}

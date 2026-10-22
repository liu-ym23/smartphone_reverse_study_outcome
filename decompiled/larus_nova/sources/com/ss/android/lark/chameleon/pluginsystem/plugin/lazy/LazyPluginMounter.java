package com.ss.android.lark.chameleon.pluginsystem.plugin.lazy;

import com.ss.android.lark.chameleon.bridge.BridgeHandlerV2;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.pluginsystem.plugin.Plugin;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginHost;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.chameleon.util.MainLooper;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes35.dex */
public class LazyPluginMounter extends DefaultPluginMounter {
    private static final String TAG = "LazyPluginMounter";
    private boolean loadFinish;
    private final Map<String, Plugin<?>> pluginJSMap;

    /* JADX INFO: renamed from: com.ss.android.lark.chameleon.pluginsystem.plugin.lazy.LazyPluginMounter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$android$lark$chameleon$pluginsystem$plugin$lazy$PluginMountStrategy = null;

        static {
            int[] r100 = new int[PluginMountStrategy.values().length];
            $SwitchMap$com$ss$android$lark$chameleon$pluginsystem$plugin$lazy$PluginMountStrategy = r100;
            r100[PluginMountStrategy.Immediate.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$ss$android$lark$chameleon$pluginsystem$plugin$lazy$PluginMountStrategy[PluginMountStrategy.FirstFind.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$ss$android$lark$chameleon$pluginsystem$plugin$lazy$PluginMountStrategy[PluginMountStrategy.FirstJSCall.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$ss$android$lark$chameleon$pluginsystem$plugin$lazy$PluginMountStrategy[PluginMountStrategy.LoadFinish.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public static /* synthetic */ void b(LazyPluginMounter r100) {
        r100.lambda$syncMountPluginsByLoadFinish$0();
    }

    private /* synthetic */ void lambda$syncMountPluginsByLoadFinish$0() {
        mountPlugins(this.allPlugins);
    }

    public void syncMountPluginsByLoadFinish() {
        Log.i(TAG, "syncMountPluginsByLoadFinish");
        this.loadFinish = true;
        MainLooper.runOnMainThread(new b(this));
    }

    public LazyPluginMounter(PluginHost r100) {
        super(r100);
        this.pluginJSMap = new ConcurrentHashMap();
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.lazy.DefaultPluginMounter
    public Map<String, BridgeHandlerV2<?>> onBindPluginBridgeHandlers(PluginList.Metadata r100) {
        Map<String, BridgeHandlerV2<?>> r101 = super.onBindPluginBridgeHandlers(r100);
        registerJSPlugin(r100, r101);
        return r101;
    }

    public void syncMountWebPluginByJSMsg(String r100) {
        Plugin<?> r101 = this.pluginJSMap.remove(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        if (this.pluginHost.isPluginAttached(r101) == true) goto L9;
        Log.i(TAG, "Mount plugin by js msg:" + r101);
        syncAttachPlugin(r101);
        return;
    }

    private void registerJSPlugin(PluginList.Metadata r100, Map<String, BridgeHandlerV2<?>> r101) {
        Iterator<String> r102 = r101.keySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        String r103 = r102.next();
        this.pluginJSMap.put(r103, r100.plugin);
        goto L4
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.lazy.DefaultPluginMounter
    public void onMountPlugin(PluginList.Metadata r100, Map<String, BridgeHandlerV2<?>> r101) {
        PluginMountStrategy r102 = r100.mountStrategy;
        if (r102 != null) goto L5;
        r102 = PluginMountStrategy.Immediate;
    L5:
        int r103 = AnonymousClass1.$SwitchMap$com$ss$android$lark$chameleon$pluginsystem$plugin$lazy$PluginMountStrategy[r102.ordinal()];
        if (r103 != 1) goto L8;
        super.onMountPlugin(r100, r101);
        return;
    L8:
        if (r103 != 2) goto L10;
        registerJSPlugin(r100, r101);
        return;
    L10:
        if (r103 != 3) goto L12;
        registerJSPlugin(r100, r101);
        if (r101.isEmpty() == false) goto L26;
        Log.w(TAG, "Plugin lazy mount with FirstJSCall , but no js handler . Mount it now !" + r100.plugin);
        super.onMountPlugin(r100, r101);
        return;
    L26:
        return;
    L12:
        if (r103 == 4) goto L15;
        return;
    L15:
        if (this.loadFinish == false) goto L17;
        super.onMountPlugin(r100, r101);
        return;
    L17:
        registerJSPlugin(r100, r101);
    }
}

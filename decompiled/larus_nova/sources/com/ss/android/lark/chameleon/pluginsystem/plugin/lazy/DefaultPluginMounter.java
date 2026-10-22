package com.ss.android.lark.chameleon.pluginsystem.plugin.lazy;

import com.ss.android.lark.chameleon.bridge.BridgeHandlerV2;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.pluginsystem.BridgeHolder;
import com.ss.android.lark.chameleon.pluginsystem.Web;
import com.ss.android.lark.chameleon.pluginsystem.WebPluginHost;
import com.ss.android.lark.chameleon.pluginsystem.plugin.AbilityProvider;
import com.ss.android.lark.chameleon.pluginsystem.plugin.BasePlugin;
import com.ss.android.lark.chameleon.pluginsystem.plugin.Plugin;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginHost;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginHostAbility;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.chameleon.util.MainLooper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes35.dex */
public class DefaultPluginMounter implements PluginMounter {
    private static final String TAG = "DefaultPluginMounter";
    private final Map<PluginHostAbility, Plugin<?>> abilityPluginMap;
    protected PluginList allPlugins;
    private final Map<PluginList.Metadata, Map<String, BridgeHandlerV2<?>>> boundHandlers;
    protected final PluginHost pluginHost;

    public static /* synthetic */ void a(DefaultPluginMounter r100, Plugin r101, CountDownLatch r102) {
        r100.lambda$syncAttachPlugin$0(r101, r102);
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.lazy.PluginMounter
    public void release() {
        Log.i(TAG, "release");
    }

    public DefaultPluginMounter(PluginHost r100) {
        this.boundHandlers = new HashMap();
        this.abilityPluginMap = new ConcurrentHashMap();
        this.pluginHost = r100;
    }

    public void attachPlugin(Plugin<?> r100) {
        if (this.pluginHost.isDestroyed() == false) goto L6;
        Log.e(TAG, "mountPlugin while plugin host destroyed !");
        return;
    L6:
        this.pluginHost.attachPlugin(r100);
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.lazy.PluginMounter
    public final void mountPlugins(PluginList r100) {
        this.allPlugins = r100;
        List<PluginList.Metadata> r101 = r100.getPluginMetadata(true);
        Log.i(TAG, "mountPlugins size:" + r101.size());
        Iterator<PluginList.Metadata> r102 = r101.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Plugin r103 = r102.next().plugin;
        if ((r103 instanceof BasePlugin) == false) goto L4;
        ((BasePlugin) r103).setHost(this.pluginHost);
        goto L4
    L8:
        Iterator<PluginList.Metadata> r104 = r101.iterator();
    L10:
        if (r104.hasNext() == false) goto L15;
        PluginList.Metadata r105 = r104.next();
        if (this.boundHandlers.containsKey(r105) == true) goto L10;
        this.boundHandlers.put(r105, onBindPluginBridgeHandlers(r105));
        goto L10
    L15:
        Iterator<PluginList.Metadata> r106 = r101.iterator();
    L17:
        if (r106.hasNext() == false) goto L19;
        onBindPluginAbilities(r106.next());
        goto L17
    L19:
        Iterator<PluginList.Metadata> r107 = r101.iterator();
    L21:
        if (r107.hasNext() == false) goto L25;
        PluginList.Metadata r108 = r107.next();
        if (this.pluginHost.isPluginAttached(r108.plugin) == true) goto L21;
        onMountPlugin(r108, this.boundHandlers.get(r108));
        goto L21
    }

    public void onBindPluginAbilities(PluginList.Metadata r100) {
        Plugin<?> r101 = r100.plugin;
        if ((r101 instanceof AbilityProvider) == false) goto L8;
        Iterator<PluginHostAbility> r102 = ((AbilityProvider) r101).getAbilities().iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        PluginHostAbility r103 = r102.next();
        this.pluginHost.registerHostAbility(r103);
        this.abilityPluginMap.put(r103, r101);
        goto L6
    L10:
        return;
    }

    public Map<String, BridgeHandlerV2<?>> onBindPluginBridgeHandlers(PluginList.Metadata r100) {
        Plugin r101 = r100.plugin;
        HashMap r102 = new HashMap();
        PluginHost r103 = this.pluginHost;
        if ((r103 instanceof WebPluginHost) == true) goto L5;
    L10:
        BridgeHolder r104 = (BridgeHolder) r103.getHostAbilityOrNull(BridgeHolder.class);
        if (r104 != null) goto L13;
    L18:
        return r102;
    L13:
        if ((r101 instanceof BridgeInteractivePlugin) == false) goto L18;
        ((BridgeInteractivePlugin) r101).getBridgeHandlers(r102);
        Iterator r105 = r102.entrySet().iterator();
    L16:
        if (r105.hasNext() == false) goto L18;
        Map.Entry r106 = (Map.Entry) r105.next();
        r104.getBridge().bindBridgeHandler((String) r106.getKey(), (BridgeHandlerV2) r106.getValue());
        goto L16
    L5:
        if ((r101 instanceof BridgeInteractivePlugin) == false) goto L10;
        ((BridgeInteractivePlugin) r101).getBridgeHandlers(r102);
        Web r107 = ((WebPluginHost) this.pluginHost).getWeb();
        Iterator r108 = r102.entrySet().iterator();
    L8:
        if (r108.hasNext() == false) goto L18;
        Map.Entry r109 = (Map.Entry) r108.next();
        r107.bindJSHandler((String) r109.getKey(), (BridgeHandlerV2) r109.getValue());
        goto L8
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.lazy.PluginMounter
    public void onFindAbility(PluginHostAbility r100) {
        Plugin<?> r101 = this.abilityPluginMap.remove(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        if (this.pluginHost.isPluginAttached(r101) == true) goto L9;
        Log.i(TAG, "Mount plugin by findAbility, ability: " + r100 + ", plugin: " + r101);
        syncAttachPlugin(r101);
        return;
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.lazy.PluginMounter
    public void onFindPlugin(Plugin<?> r100) {
        if (this.pluginHost.isPluginAttached(r100) == true) goto L6;
        Log.i(TAG, "Mount plugin by findPlugin:" + r100);
        syncAttachPlugin(r100);
        return;
    }

    public void syncAttachPlugin(final Plugin<?> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.pluginHost.isPluginAttached(r100) == false) goto L7;
        return;
    L7:
        if (MainLooper.isRunningInMainThread() == false) goto L10;
        attachPlugin(r100);
        return;
    L10:
        Log.w(TAG, "Sync wait plugin mount:" + r100);
        final CountDownLatch r101 = new CountDownLatch(1);
        MainLooper.runOnMainThread(new a(this, r100, r101));
        r101.await(5, TimeUnit.SECONDS);     // Catch: InterruptedException -> L13
        return;
    L13:
        e = move-exception;
        Log.w(TAG, e.toString());
    }

    private /* synthetic */ void lambda$syncAttachPlugin$0(Plugin r100, CountDownLatch r101) {
        attachPlugin(r100);     // Catch: Throwable -> L5
        r101.countDown();
        return;
    L5:
        th = move-exception;
        r101.countDown();
        throw th;
    }

    public void onMountPlugin(PluginList.Metadata r100, Map<String, BridgeHandlerV2<?>> r101) {
        attachPlugin(r100.plugin);
    }
}

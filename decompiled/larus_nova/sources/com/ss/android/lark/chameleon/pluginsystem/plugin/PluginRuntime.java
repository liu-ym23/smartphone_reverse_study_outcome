package com.ss.android.lark.chameleon.pluginsystem.plugin;

import android.content.res.Configuration;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.pluginsystem.PluginReport;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public class PluginRuntime {
    private static final String TAG = "PluginRuntime";
    private static volatile PluginRuntime instance;
    private final LinkedHashMap<PluginHost.Delegate, PluginHost> hosts;

    public static PluginRuntime getInstance() {
        if (instance != null) goto L15;
        monitor-enter(PluginRuntime.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new PluginRuntime();     // Catch: Throwable -> L11
    L9:
        monitor-exit(PluginRuntime.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    public List<PluginHost> allPluginHost() {
        return new ArrayList(this.hosts.values());
    }

    private PluginRuntime() {
        this.hosts = new LinkedHashMap();
    }

    public void destroyHost(PluginHost.Delegate r100) {
        Log.i(TAG, "destroyHost");
        PluginHost r101 = this.hosts.remove(r100);
        if (r101 == null) goto L6;
        r101.onDestroy();
        return;
    }

    public void dispatchOnPause(PluginHost.Delegate r100) {
        PluginHost r101 = this.hosts.get(r100);
        if (r101 == null) goto L6;
        r101.onDispatchOnPause();
        return;
    }

    public void dispatchOnResume(PluginHost.Delegate r100) {
        PluginHost r101 = this.hosts.get(r100);
        if (r101 == null) goto L6;
        r101.onDispatchOnResume();
        return;
    }

    public void dispatchOnStart(PluginHost.Delegate r100) {
        PluginHost r101 = this.hosts.get(r100);
        if (r101 == null) goto L6;
        r101.onDispatchOnStart();
        return;
    }

    public void dispatchOnStop(PluginHost.Delegate r100) {
        PluginHost r101 = this.hosts.get(r100);
        if (r101 == null) goto L6;
        r101.onDispatchOnStop();
        return;
    }

    private PluginHost newPluginHost(PluginHost.Factory r100, PluginHost.Delegate r101) {
        if (r100 == null) goto L4;
        PluginHost r102 = r100.createPluginHost();
    L5:
        this.hosts.put(r101, r102);
        return r102;
    L4:
        r102 = new PluginHost();
        goto L5
    }

    private PluginList preparePluginList(PluginHost r100, PluginListProvider r101) {
        if (r101 == null) goto L4;
        PluginList r102 = r101.getPluginList(r100);
    L5:
        if (r102 == null) goto L7;
        return r102;
    L7:
        return PluginList.newList(new PluginList.Metadata[0]);
    L4:
        r102 = null;
        goto L5
    }

    public PluginHost createHost(PluginHost.Factory r100, PluginHost.Delegate r101) {
        Log.i(TAG, "createHost");
        PluginHost r102 = newPluginHost(r100, r101);
        r102.onCreate(r101);
        PluginList r103 = preparePluginList(r102, r101.getPluginListProvider());
        PluginReport.mNewPluginList = System.currentTimeMillis();
        r102.addPlugins(r103);
        PluginReport.mAttchPluginList = System.currentTimeMillis();
        return r102;
    }

    public void dispatchConfigurationChanged(PluginHost.Delegate r100, Configuration r101) {
        PluginHost r102 = this.hosts.get(r100);
        if (r102 == null) goto L6;
        r102.onDispatchConfigurationChanged(r101);
        return;
    }

    public void dispatchUIAttach(PluginHost.Delegate r100, UIContainer r101) {
        PluginHost r102 = this.hosts.get(r100);
        if (r102 != null) goto L5;
        return;
    L5:
        if (r101.getLayoutStrategy() != null) goto L7;
        r101.setLayoutStrategy(new DefaultUILayoutStrategy(r101));
    L7:
        r102.onDispatchUIAttach(r101);
    }

    public void dispatchUIDetach(PluginHost.Delegate r100, UIContainer r101) {
        PluginHost r102 = this.hosts.get(r100);
        if (r102 == null) goto L6;
        r102.onDispatchUIDetach(r101);
        return;
    }

    public void dispatchUserVisibleHint(PluginHost.Delegate r100, boolean r101) {
        PluginHost r102 = this.hosts.get(r100);
        if (r102 == null) goto L6;
        r102.onDispatchUserVisibleHint(r101);
        return;
    }
}

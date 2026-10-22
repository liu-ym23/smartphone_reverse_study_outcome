package com.ss.android.lark.chameleon.pluginsystem.plugin;

import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.pluginsystem.plugin.lazy.PluginMountStrategy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes35.dex */
public class PluginList {
    public static final int LEVEL_MAX_VALUE = Integer.MAX_VALUE;
    public static final int LEVEL_NOT_SET = Integer.MIN_VALUE;
    private static final String TAG = "PluginList";
    static final String TAG_NOT_SET = "Tag#NotSet";
    private List<Plugin> enabledPlugins;
    private final List<Metadata> items;

    public static class Metadata {
        public boolean enable;
        public PluginMountStrategy mountStrategy;
        public Plugin plugin;
        public int pluginContainerLevel;
        public String pluginContainerTag;

        public Metadata() {
            this.enable = true;
            this.pluginContainerTag = PluginList.TAG_NOT_SET;
            this.pluginContainerLevel = Integer.MIN_VALUE;
        }

        public Metadata mountWith(PluginMountStrategy r100) {
            this.mountStrategy = r100;
            return this;
        }
    }

    private void initEnabledPlugins() {
        Iterator<Metadata> r100 = this.items.iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        Metadata r101 = r100.next();
        if (r101.enable == false) goto L4;
        this.enabledPlugins.add(r101.plugin);
        goto L4
    }

    public Map<Plugin, Metadata> metadataMap() {
        HashMap r100 = new HashMap();
        Iterator<Metadata> r101 = this.items.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Metadata r102 = r101.next();
        r100.put(r102.plugin, r102);
        goto L4
    L6:
        return r100;
    }

    private PluginList(Metadata[] r100) {
        this.enabledPlugins = new ArrayList();
        if (r100 != null) goto L5;
        List<Metadata> r101 = Collections.emptyList();
    L6:
        this.items = r101;
        initEnabledPlugins();
        return;
    L5:
        r101 = new ArrayList(Arrays.asList(r100));
        goto L6
    }

    public static PluginList newList(List<Metadata> r100) {
        return new PluginList(r100);
    }

    public static Metadata plugin(Plugin<?> r100) {
        return plugin(r100, true);
    }

    public static Metadata pluginWithFixUI(Plugin<?> r100) {
        return plugin(r100);
    }

    public <T extends Plugin> T findPlugin(Class<T> r100) {
        Iterator<Plugin> r101 = this.enabledPlugins.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        T r102 = (T) r101.next();
        if (r100.isAssignableFrom(r102.getClass()) == false) goto L4;
        return r102;
    L8:
        return null;
    }

    public Plugin findPluginByInterface(Class<?> r100) {
        Iterator<Plugin> r101 = this.enabledPlugins.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Plugin r102 = r101.next();
        if (r100.isAssignableFrom(r102.getClass()) == false) goto L4;
        return r102;
    L8:
        return null;
    }

    public Metadata findPluginMetadata(Plugin<?> r100) {
        Iterator<Metadata> r101 = this.items.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Metadata r102 = r101.next();
        if (r102.plugin != r100) goto L4;
        return r102;
    L8:
        return null;
    }

    public List<Metadata> getPluginMetadata(boolean r100) {
        if (r100 == false) goto L4;
        ArrayList r101 = new ArrayList();
        Iterator<Metadata> r102 = this.items.iterator();
    L7:
        if (r102.hasNext() == false) goto L11;
        Metadata r103 = r102.next();
        if (r103.enable == false) goto L7;
        r101.add(r103);
        goto L7
    L11:
        return r101;
    L4:
        return this.items;
    }

    public void removePlugin(Class<? extends Plugin> r100) {
        Iterator<Metadata> r101 = this.items.iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        Metadata r102 = r101.next();
        if (r100.isAssignableFrom(r102.plugin.getClass()) == false) goto L4;
        r101.remove();
        if (r102.enable == false) goto L4;
        this.enabledPlugins.remove(r102.plugin);
        goto L4
    }

    public PluginList setDefaultMountStrategy(PluginMountStrategy r100) {
        Log.i(TAG, "setDefaultMountStrategy:" + r100);
        Iterator<Metadata> r101 = this.items.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Metadata r102 = r101.next();
        if (r102.mountStrategy != null) goto L4;
        r102.mountStrategy = r100;
        goto L4
    L8:
        return this;
    }

    private PluginList(List<Metadata> r100) {
        this.enabledPlugins = new ArrayList();
        if (r100 != null) goto L5;
        r100 = new ArrayList();
    L5:
        this.items = r100;
        initEnabledPlugins();
    }

    public static PluginList newList(Metadata... r100) {
        return new PluginList(r100);
    }

    public static PluginList merge(PluginList r100, PluginList r101) {
        ArrayList r102 = new ArrayList();
        HashSet r103 = new HashSet();
        HashSet r104 = new HashSet();
        merge(r100.items, r102, r103, r104);
        merge(r101.items, r102, r103, r104);
        Metadata[] r105 = new Metadata[r102.size()];
        r102.toArray(r105);
        return new PluginList(r105);
    }

    public static Metadata plugin(Plugin<?> r100, Enum<?> r101) {
        return plugin(r100, r101.ordinal(), true, null);
    }

    public static Metadata pluginWithUILevel(Plugin<?> r100, int r101) {
        return plugin(r100, r101, true, null);
    }

    public static Metadata plugin(Plugin<?> r100, PluginMountStrategy r101) {
        return plugin(r100, Integer.MIN_VALUE, true, r101);
    }

    public static Metadata plugin(Plugin<?> r100, boolean r101) {
        return plugin(r100, Integer.MIN_VALUE, r101, null);
    }

    public static Metadata plugin(Plugin<?> r100, Enum<?> r101, PluginMountStrategy r102) {
        return plugin(r100, r101.ordinal(), true, r102);
    }

    public static Metadata plugin(Plugin<?> r100, Enum<?> r101, boolean r102) {
        return plugin(r100, r101.ordinal(), r102, null);
    }

    public static Metadata plugin(Plugin<?> r100, boolean r101, PluginMountStrategy r102) {
        return plugin(r100, Integer.MIN_VALUE, r101, r102);
    }

    public static Metadata plugin(Plugin<?> r100, int r101, PluginMountStrategy r102) {
        return plugin(r100, r101, true, r102);
    }

    private static void merge(Collection<Metadata> r100, List<Metadata> r101, Set<Class> r102, Set<Integer> r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isEmpty() == true) goto L36;
        Iterator<Metadata> r104 = r100.iterator();
    L8:
        if (r104.hasNext() == false) goto L37;
        Metadata r105 = r104.next();
        Class<?> r106 = r105.plugin.getClass();
        boolean r107 = r102.contains(r106);
        boolean r108 = r103.contains(Integer.valueOf(r105.pluginContainerLevel));
        if (r107 == true) goto L18;
        if (r108 == true) goto L18;
        r102.add(r106);
        r101.add(r105);
        int r109 = r105.pluginContainerLevel;
        if (r109 == Integer.MIN_VALUE) goto L8;
        if (r109 == Integer.MAX_VALUE) goto L8;
        r103.add(Integer.valueOf(r109));
    L18:
        if (r107 == false) goto L20;
        Log.w(TAG, new IllegalStateException("Found same type plugin :" + r106).toString());
    L20:
        if (r108 == false) goto L8;
        Log.w(TAG, new IllegalStateException("Found same level plugin :" + r106).toString());
        goto L8
    L37:
        return;
    }

    public static Metadata plugin(Plugin<?> r100, int r101, boolean r102, PluginMountStrategy r103) {
        Metadata r104 = new Metadata();
        r104.plugin = r100;
        r104.pluginContainerLevel = r101;
        r104.enable = r102;
        r104.mountStrategy = r103;
        return r104;
    }

    public static Metadata plugin(Plugin<?> r100, Enum<?> r101, boolean r102, PluginMountStrategy r103) {
        return plugin(r100, r101.ordinal(), r102, r103);
    }
}

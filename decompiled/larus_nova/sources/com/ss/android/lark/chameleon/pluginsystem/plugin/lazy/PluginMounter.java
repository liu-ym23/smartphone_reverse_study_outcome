package com.ss.android.lark.chameleon.pluginsystem.plugin.lazy;

import com.ss.android.lark.chameleon.pluginsystem.plugin.Plugin;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginHostAbility;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;

/* JADX INFO: loaded from: classes35.dex */
public interface PluginMounter {
    void mountPlugins(PluginList r100);

    void onFindAbility(PluginHostAbility r100);

    void onFindPlugin(Plugin<?> r100);

    void release();
}

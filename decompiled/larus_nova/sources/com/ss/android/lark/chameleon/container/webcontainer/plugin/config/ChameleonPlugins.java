package com.ss.android.lark.chameleon.container.webcontainer.plugin.config;

import com.ss.android.lark.chameleon.api.AbsChameleonPlugin;
import com.ss.android.lark.chameleon.api.ChameleonConfig;
import com.ss.android.lark.chameleon.api.OpenConfig;
import com.ss.android.lark.chameleon.api.TitlebarConfig;
import com.ss.android.lark.chameleon.api.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.chameleon.container.webcontainer.plugin.biz.CorePlugin;
import com.ss.android.lark.chameleon.container.webcontainer.plugin.biz.LoadingPlugin;
import com.ss.android.lark.chameleon.container.webcontainer.plugin.biz.RenderGonePlugin;
import com.ss.android.lark.chameleon.container.webcontainer.plugin.biz.title.TitleBarPlugin;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginHost;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.chameleon.pluginsystem.plugin.lazy.PluginMountStrategy;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/plugin/config/ChameleonPlugins;", "", "()V", "create", "Lcom/ss/android/lark/chameleon/pluginsystem/plugin/PluginList;", "host", "Lcom/ss/android/lark/chameleon/pluginsystem/plugin/PluginHost;", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ChameleonPlugins {
    public static final ChameleonPlugins INSTANCE = null;

    static {
        INSTANCE = new ChameleonPlugins();
    }

    private ChameleonPlugins() {
    }

    @JvmStatic
    public static final PluginList create(PluginHost r100) {
        boolean r101 = r100 instanceof ChameleonPluginHost;
        String r102 = null;
        if (r101 == false) goto L5;
        ChameleonPluginHost r103 = (ChameleonPluginHost) r100;
    L6:
        if (r103 == null) goto L8;
        ChameleonConfig r104 = r103.getChameleonConfig();
    L9:
        ArrayList r105 = new ArrayList();
        CorePlugin r106 = new CorePlugin();
        PluginMountStrategy r107 = PluginMountStrategy.Immediate;
        r105.add(PluginList.plugin(r106, r107));
        TitleBarPlugin r108 = new TitleBarPlugin();
        boolean r109 = false;
        if (r104 == null) goto L18;
        OpenConfig r110 = r104.getOpenConfig();
        if (r110 == null) goto L18;
        TitlebarConfig r111 = r110.getTitlebarConfig();
        if (r111 == null) goto L18;
        if (r111.getShowTitlebar() == true) goto L18;
        r109 = true;
    L18:
        r105.add(PluginList.plugin(r108, !r109, r107));
        r105.add(PluginList.plugin(new LoadingPlugin(), r107));
        r105.add(PluginList.plugin(new RenderGonePlugin(), r107));
        if (r101 == false) goto L21;
        ChameleonPluginHost r112 = (ChameleonPluginHost) r100;
    L22:
        if (r112 == null) goto L24;
        r102 = r112.getSession();
    L24:
        if (r102 == null) goto L30;
        Iterator<T> r113 = ChameleonContainerUtils.INSTANCE.getBizPlugins(r102).iterator();
    L27:
        if (r113.hasNext() == false) goto L30;
        r105.add(PluginList.plugin((AbsChameleonPlugin) r113.next(), PluginMountStrategy.Immediate));
    L30:
        return PluginList.newList(r105);
    L21:
        r112 = null;
        goto L22
    L8:
        r104 = null;
        goto L9
    L5:
        r103 = null;
        goto L6
    }
}

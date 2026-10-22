package com.ss.android.lark.chameleon.container.webcontainer.plugin.config;

import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginHost;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginListProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/plugin/config/ChameleonBrowserConfigsImpl;", "Lcom/ss/android/lark/chameleon/pluginsystem/plugin/PluginListProvider;", "()V", "getPluginList", "Lcom/ss/android/lark/chameleon/pluginsystem/plugin/PluginList;", "host", "Lcom/ss/android/lark/chameleon/pluginsystem/plugin/PluginHost;", "Companion", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ChameleonBrowserConfigsImpl implements PluginListProvider {
    public static final Companion Companion = null;
    private static final String TAG = "CML_TAG_ChameleonBrowserConfigsImpl";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/plugin/config/ChameleonBrowserConfigsImpl$Companion;", "", "()V", "TAG", "", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ChameleonBrowserConfigsImpl() {
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.PluginListProvider
    public PluginList getPluginList(PluginHost r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Log.d(TAG, "getPluginList");
        return ChameleonPlugins.create(r100);
    }
}

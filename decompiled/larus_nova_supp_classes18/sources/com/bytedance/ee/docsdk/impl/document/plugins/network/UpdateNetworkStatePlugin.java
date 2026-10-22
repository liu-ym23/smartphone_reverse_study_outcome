package com.bytedance.ee.docsdk.impl.document.plugins.network;

import android.webkit.WebView;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.google.gson.JsonObject;
import com.ss.android.lark.chameleon.api.AbsChameleonPlugin;
import com.ss.android.lark.chameleon.api.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginHost;
import com.ss.android.lark.chameleon.pluginsystem.plugin.UIContainer;
import com.ss.android.lark.chameleon.util.NetworkCheck;
import com.ss.android.lark.chameleon.util.NetworkType;
import com.ss.android.lark.chameleon.util.SafeJSExecutor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class UpdateNetworkStatePlugin extends AbsChameleonPlugin {
    private static final String TAG = "UpdateNetworkStatePlugin";

    public UpdateNetworkStatePlugin() {
    }

    public void onAttachToUIContainer(ChameleonPluginHost r4, UIContainer r5) {
        super/*com.ss.android.lark.chameleon.pluginsystem.plugin.BasePlugin*/.onAttachToUIContainer(r4, r5);
        WebView r6 = r4.getWeb().getWebView();
        NetworkType r7 = NetworkCheck.getNetworkState(getContext());
        Log.i(TAG, "Current network type: " + r7.toString());
        JsonObject r0 = new JsonObject();
        r0.addProperty(ResourceData.KEY_TYPE, Integer.valueOf(r7.ordinal()));
        if (r7 == NetworkType.NETWORK_NO) goto L5;
        boolean r8 = true;
    L6:
        r0.addProperty("connected", Boolean.valueOf(r8));
        SafeJSExecutor.execJS(r6, "javascript:window.native.setNetworkState", r0);
        return;
    L5:
        r8 = false;
        goto L6
    }

    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, UIContainer r2) {
        onAttachToUIContainer((ChameleonPluginHost) r1, r2);
    }
}

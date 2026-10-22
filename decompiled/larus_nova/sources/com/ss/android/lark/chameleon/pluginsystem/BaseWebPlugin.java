package com.ss.android.lark.chameleon.pluginsystem;

import android.webkit.ValueCallback;
import com.google.gson.JsonObject;
import com.ss.android.lark.chameleon.bridge.BridgeHandler;
import com.ss.android.lark.chameleon.bridge.BridgeHandlerV2;
import com.ss.android.lark.chameleon.bridge.JSHandler;
import com.ss.android.lark.chameleon.bridge.NonProguard;
import com.ss.android.lark.chameleon.pluginsystem.WebPluginHost;
import com.ss.android.lark.chameleon.pluginsystem.plugin.BasePlugin;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginHost;
import com.ss.android.lark.chameleon.pluginsystem.plugin.UIContainer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public class BaseWebPlugin<T extends WebPluginHost> extends BasePlugin<T> {
    private List<String> autoUnbinds;

    public Web getWeb() {
        return getHost().getWeb();
    }

    public BaseWebPlugin() {
    }

    public void execJS(String r100) {
        execJS(r100, null);
    }

    public void loadUrl(String r100) {
        Web r101 = getWeb();
        if (r101 == null) goto L6;
        r101.loadUrl(r100);
        return;
    }

    public void unbindBridgeHandler(String r100) {
        Web r101 = getWeb();
        if (r101 == null) goto L6;
        r101.unbindJSHandler(r100);
        return;
    }

    public void bindBridgeHandler(String r100, BridgeHandler r101) {
        innerbindJSHandler(r100, r101, false);
    }

    public void bindBridgeHandlerAutoUnbind(String r100, BridgeHandler r101) {
        innerbindJSHandler(r100, r101, true);
    }

    public void bindJSHandler(String r100, JSHandler r101) {
        innerbindJSHandler(r100, r101, false);
    }

    public void bindJSHandlerAutoUnbind(String r100, JSHandler r101) {
        innerbindJSHandler(r100, r101, true);
    }

    public void execJS(String r100, JsonObject r101) {
        execJS(r100, r101, null);
    }

    public void onDetachFromUIContainer(T r100, UIContainer r101) {
        super.onDetachFromUIContainer(r100, r101);
        List<String> r102 = this.autoUnbinds;
        if (r102 == null) goto L8;
        Iterator<String> r103 = r102.iterator();
    L6:
        if (r103.hasNext() == false) goto L10;
        unbindBridgeHandler(r103.next());
        goto L6
    L10:
        return;
    }

    public void bindBridgeHandler(String r100, BridgeHandlerV2 r101) {
        innerbindJSHandler(r100, r101, false);
    }

    public void bindBridgeHandlerAutoUnbind(String r100, BridgeHandlerV2 r101) {
        innerbindJSHandler(r100, r101, true);
    }

    public void execJS(String r100, NonProguard r101) {
        execJS(r100, r101, null);
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.BasePlugin, com.ss.android.lark.chameleon.pluginsystem.plugin.Plugin
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r100, UIContainer r101) {
        onDetachFromUIContainer((WebPluginHost) r100, r101);
    }

    private void innerbindJSHandler(String r100, Object r101, boolean r102) {
        Web r103 = getWeb();
        if (r103 != null) goto L5;
    L13:
        if (r102 == true) goto L15;
        return;
    L15:
        if (this.autoUnbinds != null) goto L18;
        this.autoUnbinds = new ArrayList();
    L18:
        if (this.autoUnbinds.contains(r100) == true) goto L22;
        this.autoUnbinds.add(r100);
        return;
    L22:
        return;
    L5:
        if ((r101 instanceof BridgeHandlerV2) == false) goto L8;
        r103.bindJSHandler(r100, (BridgeHandlerV2) r101);
        goto L13
    L8:
        if ((r101 instanceof BridgeHandler) == false) goto L11;
        r103.bindJSHandler(r100, (BridgeHandler) r101);
        goto L13
    L11:
        if ((r101 instanceof JSHandler) == false) goto L13;
        r103.bindJSHandler(r100, (JSHandler) r101);
        goto L13
    }

    public void execJS(String r100, JsonObject r101, ValueCallback<String> r102) {
        Web r103 = getWeb();
        if (r103 == null) goto L6;
        r103.execJS(r100, r101, r102);
        return;
    }

    public void execJS(String r100, NonProguard r101, ValueCallback<String> r102) {
        Web r103 = getWeb();
        if (r103 == null) goto L6;
        r103.execJS(r100, r101, r102);
        return;
    }
}

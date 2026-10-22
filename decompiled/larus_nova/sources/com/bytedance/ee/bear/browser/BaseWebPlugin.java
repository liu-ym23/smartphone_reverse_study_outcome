package com.bytedance.ee.bear.browser;

import android.webkit.ValueCallback;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.BasePlugin;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tb5.g;
import tb5.i;
import tb5.o;
import vv4.k;

/* JADX INFO: loaded from: classes16.dex */
public class BaseWebPlugin<T extends WebPluginHost> extends BasePlugin<T> {
    private List<String> autoUnbinds;

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    public k getWeb() {
        return getHost().getWeb();
    }

    public BaseWebPlugin() {
    }

    public void execJS(String r100) {
        execJS(r100, null);
    }

    public void loadUrl(String r100) {
        k r101 = getWeb();
        if (r101 == null) goto L6;
        r101.loadUrl(r100);
        return;
    }

    public void unbindBridgeHandler(String r100) {
        k r101 = getWeb();
        if (r101 == null) goto L6;
        r101.unbindJSHandler(r100);
        return;
    }

    public void bindBridgeHandler(String r100, g r101) {
        innerbindJSHandler(r100, r101, false);
    }

    public void bindBridgeHandlerAutoUnbind(String r100, g r101) {
        innerbindJSHandler(r100, r101, true);
    }

    public void bindJSHandler(String r100, o r101) {
        innerbindJSHandler(r100, r101, false);
    }

    public void bindJSHandlerAutoUnbind(String r100, o r101) {
        innerbindJSHandler(r100, r101, true);
    }

    public void execJS(String r100, JSONObject r101) {
        execJS(r100, r101, null);
    }

    public void onDetachFromUIContainer(T r100, t r101) {
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

    public void bindBridgeHandler(String r100, i r101) {
        innerbindJSHandler(r100, r101, false);
    }

    public void bindBridgeHandlerAutoUnbind(String r100, i r101) {
        innerbindJSHandler(r100, r101, true);
    }

    public void execJS(String r100, NonProguard r101) {
        execJS(r100, r101, null);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r100, t r101) {
        onDetachFromUIContainer((WebPluginHost) r100, r101);
    }

    private void innerbindJSHandler(String r100, Object r101, boolean r102) {
        k r103 = getWeb();
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
        if ((r101 instanceof i) == false) goto L8;
        r103.h(r100, (i) r101);
        goto L13
    L8:
        if ((r101 instanceof g) == false) goto L11;
        r103.i(r100, (g) r101);
        goto L13
    L11:
        if ((r101 instanceof o) == false) goto L13;
        r103.B(r100, (o) r101);
        goto L13
    }

    public void execJS(String r100, JSONObject r101, ValueCallback<String> r102) {
        k r103 = getWeb();
        if (r103 == null) goto L6;
        r103.a(r100, r101, r102);
        return;
    }

    public void execJS(String r100, NonProguard r101, ValueCallback<String> r102) {
        k r103 = getWeb();
        if (r103 == null) goto L6;
        r103.k(r100, r101, r102);
        return;
    }
}

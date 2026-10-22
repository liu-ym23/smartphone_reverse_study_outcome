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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class BaseWebPlugin<T extends WebPluginHost> extends BasePlugin<T> {
    private List<String> autoUnbinds;

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public k getWeb() {
        return getHost().getWeb();
    }

    public BaseWebPlugin() {
    }

    public void execJS(String r2) {
        execJS(r2, null);
    }

    public void loadUrl(String r2) {
        k r0 = getWeb();
        if (r0 == null) goto L6;
        r0.loadUrl(r2);
        return;
    }

    public void unbindBridgeHandler(String r2) {
        k r0 = getWeb();
        if (r0 == null) goto L6;
        r0.unbindJSHandler(r2);
        return;
    }

    public void bindBridgeHandler(String r2, g r3) {
        innerbindJSHandler(r2, r3, false);
    }

    public void bindBridgeHandlerAutoUnbind(String r2, g r3) {
        innerbindJSHandler(r2, r3, true);
    }

    public void bindJSHandler(String r2, o r3) {
        innerbindJSHandler(r2, r3, false);
    }

    public void bindJSHandlerAutoUnbind(String r2, o r3) {
        innerbindJSHandler(r2, r3, true);
    }

    public void execJS(String r2, JSONObject r3) {
        execJS(r2, r3, null);
    }

    public void onDetachFromUIContainer(T r1, t r2) {
        super.onDetachFromUIContainer(r1, r2);
        List<String> r3 = this.autoUnbinds;
        if (r3 == null) goto L8;
        Iterator<String> r4 = r3.iterator();
    L6:
        if (r4.hasNext() == false) goto L10;
        unbindBridgeHandler(r4.next());
        goto L6
    L10:
        return;
    }

    public void bindBridgeHandler(String r2, i r3) {
        innerbindJSHandler(r2, r3, false);
    }

    public void bindBridgeHandlerAutoUnbind(String r2, i r3) {
        innerbindJSHandler(r2, r3, true);
    }

    public void execJS(String r2, NonProguard r3) {
        execJS(r2, r3, null);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((WebPluginHost) r1, r2);
    }

    private void innerbindJSHandler(String r3, Object r4, boolean r5) {
        k r0 = getWeb();
        if (r0 != null) goto L5;
    L13:
        if (r5 == true) goto L15;
        return;
    L15:
        if (this.autoUnbinds != null) goto L18;
        this.autoUnbinds = new ArrayList();
    L18:
        if (this.autoUnbinds.contains(r3) == true) goto L22;
        this.autoUnbinds.add(r3);
        return;
    L22:
        return;
    L5:
        if ((r4 instanceof i) == false) goto L8;
        r0.h(r3, (i) r4);
        goto L13
    L8:
        if ((r4 instanceof g) == false) goto L11;
        r0.i(r3, (g) r4);
        goto L13
    L11:
        if ((r4 instanceof o) == false) goto L13;
        r0.B(r3, (o) r4);
        goto L13
    }

    public void execJS(String r2, JSONObject r3, ValueCallback<String> r4) {
        k r0 = getWeb();
        if (r0 == null) goto L6;
        r0.a(r2, r3, r4);
        return;
    }

    public void execJS(String r2, NonProguard r3, ValueCallback<String> r4) {
        k r0 = getWeb();
        if (r0 == null) goto L6;
        r0.k(r2, r3, r4);
        return;
    }
}

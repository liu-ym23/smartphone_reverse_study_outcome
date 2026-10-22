package com.bytedance.ee.bear.browser;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import vv4.k;

/* JADX INFO: loaded from: classes16.dex */
public class WebPluginHost extends PluginHost {

    /* JADX INFO: renamed from: web, reason: collision with root package name */
    private k f216606web;

    public k getWeb() {
        return this.f216606web;
    }

    public WebPluginHost(k r100) {
        this.f216606web = r100;
    }

    public void setWeb(k r100) {
        this.f216606web = r100;
    }
}

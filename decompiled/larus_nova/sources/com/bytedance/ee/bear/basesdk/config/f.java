package com.bytedance.ee.bear.basesdk.config;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.n;
import com.bytedance.ee.bear.externallink.ExternalLinkFollowPlugin;
import java.util.Arrays;
import java.util.List;
import vv4.m;

/* JADX INFO: loaded from: classes15.dex */
public final class f extends com.bytedance.ee.bear.externallink.a {
    @Override // vv4.o
    public final List<m> getWebServices() {
        tt5.a.b("ExternalLinksBrowserConfigs", "getWebServices");
        return Arrays.asList(new m[]{new x35.d()});
    }

    public f() {
    }

    @Override // com.bytedance.ee.bear.browser.plugin.o
    public final n a(PluginHost r100) {
        tt5.a.b("ExternalLinksBrowserConfigs", "getPluginList");
        return new n(new n.a[]{n.h(new ExternalLinkFollowPlugin(), true)});
    }
}

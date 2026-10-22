package com.bytedance.ee.bear.document.adapter;

import com.bytedance.ee.bear.browser.plugin.i;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements i {
    public static final /* synthetic */ int c = 0;
    public final ChameleonPluginHost a;
    public final LegacyPluginHostAdapter b;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.adapter.a$a, reason: collision with other inner class name */
    public static final class C0049a {
    }

    static {
    }

    public a(ChameleonPluginHost r2) {
        this.a = r2;
        this.b = new LegacyPluginHostAdapter(this.a);
    }
}

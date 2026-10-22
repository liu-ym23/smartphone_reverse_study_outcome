package com.bytedance.ee.bear.document.adapter;

import com.bytedance.ee.bear.browser.plugin.i;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f218708c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ChameleonPluginHost f218709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LegacyPluginHostAdapter f218710b;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.adapter.a$a, reason: collision with other inner class name */
    public static final class C3105a {
    }

    static {
    }

    public a(ChameleonPluginHost r100) {
        this.f218709a = r100;
        this.f218710b = new LegacyPluginHostAdapter(this.f218709a);
    }
}

package com.bytedance.ee.bear.document.container;

import com.bytedance.ee.bear.browser.plugin.n;
import com.bytedance.ee.bear.document.v4;
import com.ss.android.lark.chameleon.ChameleonPluginListProvider;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements ChameleonPluginListProvider {
    public final /* synthetic */ v4 a;

    public b(v4 r1) {
        this.a = r1;
    }

    public final n getPluginList(ChameleonPluginHost r3) {
        Intrinsics.checkNotNullParameter(r3, "host");
        return n.c(this.a.getCommonPluginList(r3), this.a.getBizPluginList(r3));
    }
}

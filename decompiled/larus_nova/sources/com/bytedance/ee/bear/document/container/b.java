package com.bytedance.ee.bear.document.container;

import com.bytedance.ee.bear.browser.plugin.n;
import com.bytedance.ee.bear.document.v4;
import com.ss.android.lark.chameleon.ChameleonPluginListProvider;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements ChameleonPluginListProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v4 f219396a;

    public b(v4 r100) {
        this.f219396a = r100;
    }

    @Override // com.ss.android.lark.chameleon.ChameleonPluginListProvider
    public final n getPluginList(ChameleonPluginHost r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        return n.c(this.f219396a.getCommonPluginList(r100), this.f219396a.getBizPluginList(r100));
    }
}

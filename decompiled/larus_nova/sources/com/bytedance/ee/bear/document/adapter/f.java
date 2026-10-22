package com.bytedance.ee.bear.document.adapter;

import com.bytedance.ee.bear.browser.plugin.BasePluginV2;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginV2;
import com.monitor.cloudmessage.consts.CloudControlInf;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f218716a;

    public f(a r100) {
        Intrinsics.checkNotNullParameter(r100, "adapterFactory");
        this.f218716a = r100;
    }

    public final ChameleonPluginAdapter a(BasePluginV2 r100) {
        Intrinsics.checkNotNullParameter(r100, CloudControlInf.PLUGIN);
        a r101 = this.f218716a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, CloudControlInf.PLUGIN);
        return new ChameleonPluginAdapter(r101.f218710b, r100);
    }

    public final ChameleonPluginAdapter b(DocumentPlugin r100) {
        Intrinsics.checkNotNullParameter(r100, CloudControlInf.PLUGIN);
        a r101 = this.f218716a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, CloudControlInf.PLUGIN);
        return new ChameleonPluginAdapter(r101.f218710b, r100);
    }

    public final ChameleonPluginAdapter c(DocumentPluginV2 r100) {
        Intrinsics.checkNotNullParameter(r100, CloudControlInf.PLUGIN);
        a r101 = this.f218716a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, CloudControlInf.PLUGIN);
        return new ChameleonPluginAdapter(r101.f218710b, r100);
    }
}

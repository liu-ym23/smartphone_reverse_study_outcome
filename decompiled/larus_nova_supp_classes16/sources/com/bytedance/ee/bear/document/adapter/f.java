package com.bytedance.ee.bear.document.adapter;

import com.bytedance.ee.bear.browser.plugin.BasePluginV2;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginV2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f {
    public final a a;

    public f(a r2) {
        Intrinsics.checkNotNullParameter(r2, "adapterFactory");
        this.a = r2;
    }

    public final ChameleonPluginAdapter a(BasePluginV2 r3) {
        Intrinsics.checkNotNullParameter(r3, "plugin");
        a r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "plugin");
        return new ChameleonPluginAdapter(r1.b, r3);
    }

    public final ChameleonPluginAdapter b(DocumentPlugin r3) {
        Intrinsics.checkNotNullParameter(r3, "plugin");
        a r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "plugin");
        return new ChameleonPluginAdapter(r1.b, r3);
    }

    public final ChameleonPluginAdapter c(DocumentPluginV2 r3) {
        Intrinsics.checkNotNullParameter(r3, "plugin");
        a r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "plugin");
        return new ChameleonPluginAdapter(r1.b, r3);
    }
}

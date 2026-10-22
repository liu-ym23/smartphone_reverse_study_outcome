package com.bytedance.android.shopping.store.slicecard;

import android.content.Context;
import com.bytedance.android.ecom.slice.ext.template.gecko.SlcGeckoTemplateMgr;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h {
    public static boolean a;
    public static final h b = null;

    public h() {
    }

    static {
        b = new h();
    }

    public final synchronized void a(Context r5) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r5, "context");     // Catch: Throwable -> L11
        if (a == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        a = true;     // Catch: Throwable -> L11
        dm.a.a("ShopSlcPreloadManager").i("initTemplateManager");     // Catch: Throwable -> L11
        com.bytedance.android.ec.store.setting.j r0 = ShopSlcTemplateManager.a;     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r5, "context");     // Catch: Throwable -> L11
        SlcGeckoTemplateMgr.f(SlcGeckoTemplateMgr.l, "ec_shop", "ecom_shop_slice_template", wh.a.b(r5), ShopSlcTemplateManager$preloadTemplate$1.INSTANCE);     // Catch: Throwable -> L11
        ShopCustomElementManager.a();     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }
}

package com.bytedance.ee.bear.document.render.node;

import com.bytedance.ee.bear.facade.common.widget.Toast;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static final boolean a = false;

    static {
        a = ((Boolean) new ml5.b("debug_config").a("show_cache_toast", Boolean.FALSE)).booleanValue();
    }

    public static void a(e r2, String r3) {
        if (a == true) goto L5;
        return;
    L5:
        tt5.a.h("CacheDebugToastUtils", r2.f() + " [rust_preload] showCacheToast, toast = " + r3);
        Toast.showText(r2.getPluginHost().getContext(), r3);
    }
}

package com.bytedance.ee.bear.document.render.node;

import com.bytedance.ee.bear.facade.common.widget.Toast;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f221334a = false;

    static {
        f221334a = ((Boolean) new ml5.b("debug_config").a("show_cache_toast", Boolean.FALSE)).booleanValue();
    }

    public static void a(e r100, String r101) {
        if (f221334a == true) goto L5;
        return;
    L5:
        tt5.a.h("CacheDebugToastUtils", r100.f() + " [rust_preload] showCacheToast, toast = " + r101);
        Toast.showText(r100.getPluginHost().getContext(), r101);
    }
}

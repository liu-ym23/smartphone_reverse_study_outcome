package com.bytedance.lego.init;

import com.bytedance.news.common.service.manager.ServiceManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class n implements f {
    public static f a;
    public static final n b = null;

    public n() {
    }

    static {
        b = new n();
    }

    public final <T> T a(Class<T> r2) {
        f r0 = a;
        if (r0 == null) goto L7;
        return (T) ((n) r0).a(r2);
    L7:
        return (T) ServiceManager.getService(r2);
    }
}

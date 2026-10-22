package com.bytedance.lego.init;

import com.bytedance.news.common.service.manager.ServiceManager;

/* JADX INFO: loaded from: classes.dex */
public final class n implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static f f254551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n f254552b = null;

    public n() {
    }

    static {
        f254552b = new n();
    }

    public final <T> T a(Class<T> r100) {
        f r101 = f254551a;
        if (r101 == null) goto L7;
        return (T) ((n) r101).a(r100);
    L7:
        return (T) ServiceManager.getService(r100);
    }
}

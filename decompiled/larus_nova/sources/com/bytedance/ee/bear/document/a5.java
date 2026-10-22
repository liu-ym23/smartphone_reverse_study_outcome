package com.bytedance.ee.bear.document;

import java.util.Set;

/* JADX INFO: loaded from: classes16.dex */
public interface a5 extends com.bytedance.ee.bear.browser.plugin.i {

    public interface a {
        boolean onPressed();
    }

    void addBackPressedInterceptor(a r100);

    Set<a> getBackPressedInterceptors();

    void removeBackPressedInterceptor(a r100);
}

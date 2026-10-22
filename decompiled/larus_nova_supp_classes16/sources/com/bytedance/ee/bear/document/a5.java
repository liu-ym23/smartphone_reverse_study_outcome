package com.bytedance.ee.bear.document;

import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface a5 extends com.bytedance.ee.bear.browser.plugin.i {

    public interface a {
        boolean onPressed();
    }

    void addBackPressedInterceptor(a r1);

    Set<a> getBackPressedInterceptors();

    void removeBackPressedInterceptor(a r1);
}

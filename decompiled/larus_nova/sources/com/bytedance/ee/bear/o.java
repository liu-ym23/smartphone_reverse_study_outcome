package com.bytedance.ee.bear;

import com.bytedance.ee.bear.document.permission.PermissionData;

/* JADX INFO: loaded from: classes15.dex */
public interface o extends com.bytedance.ee.bear.browser.plugin.i {

    public interface a {
        void a(PermissionData r100);
    }

    void addPermissionChangeListener(a r100);

    void removePermissionChangeListener(a r100);
}

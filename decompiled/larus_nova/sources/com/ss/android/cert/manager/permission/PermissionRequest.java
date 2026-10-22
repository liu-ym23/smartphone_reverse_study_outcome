package com.ss.android.cert.manager.permission;

import java.util.HashMap;

/* JADX INFO: loaded from: classes34.dex */
public class PermissionRequest {
    public PermissionHelper.PermissionRequestCallback callback;
    public boolean cancelable;
    public HashMap<String, PermissionEntity> entities;

    public PermissionRequest() {
        this.cancelable = true;
    }

    public PermissionRequest addEntities(PermissionEntity[] r100) {
        if (r100 != null) goto L4;
    L9:
        return this;
    L4:
        if (r100.length == 0) goto L9;
        int r101 = r100.length;
        int r102 = 0;
    L7:
        if (r102 >= r101) goto L9;
        addEntity(r100[r102]);
        r102 = r102 + 1;
        goto L7
    }

    public PermissionRequest addEntity(PermissionEntity r100) {
        if (r100 != null) goto L5;
        return this;
    L5:
        if (this.entities != null) goto L7;
        this.entities = new HashMap();
    L7:
        this.entities.put(r100.permission, r100);
        return this;
    }

    public PermissionRequest setCallback(PermissionHelper.PermissionRequestCallback r100) {
        this.callback = r100;
        return this;
    }

    public PermissionRequest setCancelable(boolean r100) {
        this.cancelable = r100;
        return this;
    }

    public PermissionRequest setEntities(HashMap<String, PermissionEntity> r100) {
        this.entities = r100;
        return this;
    }
}

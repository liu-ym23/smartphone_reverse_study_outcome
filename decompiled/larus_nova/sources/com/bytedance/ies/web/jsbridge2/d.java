package com.bytedance.ies.web.jsbridge2;

/* JADX INFO: loaded from: classes19.dex */
public abstract class d<P, R> {
    private String name;

    public d() {
    }

    public PermissionGroup getPermission() {
        return getPermissionGroup();
    }

    public String getName() {
        return this.name;
    }

    public PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }

    void setName(String r100) {
        this.name = r100;
    }
}

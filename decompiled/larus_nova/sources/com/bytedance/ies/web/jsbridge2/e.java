package com.bytedance.ies.web.jsbridge2;

/* JADX INFO: loaded from: classes19.dex */
public abstract class e extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PermissionGroup f249347a;

    public abstract void j(c0 r100, i0 r101) throws Exception;

    public e() {
        this.f249347a = super.getPermissionGroup();
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return this.f249347a;
    }
}

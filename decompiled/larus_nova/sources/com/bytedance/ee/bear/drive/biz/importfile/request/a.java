package com.bytedance.ee.bear.drive.biz.importfile.request;

import com.bytedance.ee.bear.drive.biz.importfile.request.error.ImportFailedType;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements b55.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f223062a;

    public a(b r100) {
        this.f223062a = r100;
    }

    @Override // b55.h
    public final void a(u55.b r100) {
        tt5.a.h("StartImportRequesterManager", "fetch permission info=" + r100);
        if (r100.d() == true) goto L6;
        ((k55.h) this.f223062a.f223071i).j(ImportFailedType.FailedNoPermisson, -1);
        return;
    }

    @Override // b55.h
    public final void onFailure(Throwable r100) {
        tt5.a.d("StartImportRequesterManager", "getDrivePermissionInfo failed + " + r100);
        ((k55.h) this.f223062a.f223071i).j(ImportFailedType.FailedNoPermisson, -1);
    }
}

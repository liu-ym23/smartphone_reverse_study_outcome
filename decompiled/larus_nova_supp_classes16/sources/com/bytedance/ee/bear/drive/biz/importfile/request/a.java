package com.bytedance.ee.bear.drive.biz.importfile.request;

import com.bytedance.ee.bear.drive.biz.importfile.request.error.ImportFailedType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements b55.h {
    public final /* synthetic */ b a;

    public a(b r1) {
        this.a = r1;
    }

    @Override // b55.h
    public final void a(u55.b r3) {
        tt5.a.h("StartImportRequesterManager", "fetch permission info=" + r3);
        if (r3.d() == true) goto L6;
        ((k55.h) this.a.i).j(ImportFailedType.FailedNoPermisson, -1);
        return;
    }

    @Override // b55.h
    public final void onFailure(Throwable r3) {
        tt5.a.d("StartImportRequesterManager", "getDrivePermissionInfo failed + " + r3);
        ((k55.h) this.a.i).j(ImportFailedType.FailedNoPermisson, -1);
    }
}

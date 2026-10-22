package com.bytedance.ee.bear.document.tips;

import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b0 implements ph5.d {
    public final /* synthetic */ Boolean a;
    public final /* synthetic */ String b;
    public final /* synthetic */ a0 c;

    public final void a(PermissionResponse r3) {
        PermissionResponse.Companion.getClass();
        if (PermissionResponse.a.c(r3) == false) goto L6;
        this.c.j(this.a.booleanValue(), this.b);
        return;
    }

    public b0(a0 r1, Boolean r2, String r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}

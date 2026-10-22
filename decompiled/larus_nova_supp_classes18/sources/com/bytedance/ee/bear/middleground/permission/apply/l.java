package com.bytedance.ee.bear.middleground.permission.apply;

import android.content.Context;
import com.bytedance.ee.bear.middleground.permission.PermissionAnalytic;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l<T> implements Consumer {
    public final /* synthetic */ p a;
    public final /* synthetic */ ApplyPermissionController b;
    public final /* synthetic */ String c;

    public l(p r1, ApplyPermissionController r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r7) {
        Throwable r8 = (Throwable) r7;
        boolean r2 = false;
        tt5.a.e("ApplyPermissionController", "request perm fail. ", r8, false);
        this.a.a(false, this.b.e());
        ApplyPermissionController r0 = this.b;
        String r1 = this.c;
        if (r0.c != ApplyPermissionPageMode.NORMAL) goto L13;
        int r3 = r0.b();
        String r4 = r0.b.getToken();
        if (r0.a() != 4) goto L8;
        String r5 = "edit";
    L10:
        if (r1.length() <= 0) goto L12;
        r2 = true;
    L12:
        PermissionAnalytic.g(r3, r4, r5, r2);
        goto L13
    L8:
        r5 = "read";
    L13:
        Context r6 = this.b.a.getContext();
        if (r6 != null) goto L16;
        r6 = eu5.b.a;
    L16:
        Intrinsics.checkNotNull(r6);
        Intrinsics.checkNotNull(r8);
        ui5.a.b(r6, r8, this.b.b.getOwnerName(), this.b.b.getToken(), this.b.b.getDocumentType());
    }
}

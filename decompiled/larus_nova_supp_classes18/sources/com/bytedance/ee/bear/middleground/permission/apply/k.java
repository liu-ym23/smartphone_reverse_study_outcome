package com.bytedance.ee.bear.middleground.permission.apply;

import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.PermissionAnalytic;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ p a;
    public final /* synthetic */ ApplyPermissionController b;
    public final /* synthetic */ String c;

    public k(p r1, ApplyPermissionController r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r6) {
        Boolean r7 = (Boolean) r6;
        this.a.b();
        ApplyPermissionController r8 = this.b;
        String r0 = this.c;
        if (r8.c != ApplyPermissionPageMode.NORMAL) goto L14;
        int r1 = r8.b();
        String r2 = r8.b.getToken();
        if (r8.a() != 4) goto L8;
        String r9 = "edit";
    L10:
        if (r0.length() <= 0) goto L12;
        boolean r3 = true;
    L13:
        PermissionAnalytic.h(r1, r2, r9, r3);
        goto L14
    L12:
        r3 = false;
        goto L13
    L8:
        r9 = "read";
    L14:
        Toast.showSuccessText(this.b.a.getContext(), this.b.a.getString(2131887829), 0);
        this.a.a(false, this.b.e());
    }
}

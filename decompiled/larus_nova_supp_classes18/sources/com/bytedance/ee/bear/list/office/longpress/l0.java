package com.bytedance.ee.bear.list.office.longpress;

import android.content.Context;
import com.bytedance.ee.bear.more.office.OfficeLongPressLarkAction;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l0<T> implements Consumer {
    public final /* synthetic */ com.bytedance.ee.bear.more.office.c a;
    public final /* synthetic */ com.bytedance.ee.bear.more.office.b b;

    public l0(com.bytedance.ee.bear.more.office.c r1, com.bytedance.ee.bear.office.list.adapter.p r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r8) {
        tt5.a.e("OfficeSecretSettingActionExecutor", "prefetch secret permission failed. actionId=" + this.a.a, (Throwable) r8, false);
        com.bytedance.ee.bear.more.office.b r9 = this.b;
        if (r9 == null) goto L10;
        com.bytedance.ee.bear.more.office.c r0 = this.a;
        String r1 = r0.a;
        OfficeLongPressLarkAction r2 = r0.b;
        String r3 = r0.c;
        g0.a.getClass();
        Context r4 = g0.f(r0);
        if (r4 == null) goto L8;
        String r5 = r4.getString(2131887802);
        if (r5 == null) goto L8;
    L9:
        r9.a(r1, r2, r3, new com.bytedance.ee.bear.more.office.a.C0116a(r5, null, 2));
    L8:
        r5 = com.bytedance.ee.bear.more.office.f.a();
    L10:
        g0 r10 = g0.a;
        String r6 = this.a.a;
        r10.getClass();
        g0.e(r6);
    }
}

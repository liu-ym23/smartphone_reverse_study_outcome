package com.bytedance.ee.bear.list.office.longpress;

import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k0<T> implements Consumer {
    public final /* synthetic */ com.bytedance.ee.bear.more.office.c a;
    public final /* synthetic */ oj5.a b;
    public final /* synthetic */ g0.a c;
    public final /* synthetic */ com.bytedance.ee.bear.more.office.b d;

    public k0(com.bytedance.ee.bear.more.office.c r1, oj5.a r2, g0.a r3, com.bytedance.ee.bear.office.list.adapter.p r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void accept(Object r6) {
        DocPermission r7 = (DocPermission) r6;
        if (g0.c.containsKey(this.a.a) == false) goto L12;
        oj5.a r0 = this.b;
        Intrinsics.checkNotNull(r7);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r7, "docPermission");
        r0.i = r7;
        tt5.a.h("OfficeSecretSettingActionExecutor", "prefetch secret permission success. actionId=" + this.a.a + ", type=" + this.c.getType());
        g0 r8 = g0.a;
        oj5.a r1 = this.b;
        r8.getClass();
        if (g0.s(r1) == false) goto L7;
        g0.o(this.a, this.c, this.b, this.d);
        return;
    L7:
        com.bytedance.ee.bear.more.office.b r9 = this.d;
        if (r9 == null) goto L10;
        com.bytedance.ee.bear.more.office.c r2 = this.a;
        r9.a(r2.a, r2.b, r2.c, g0.j(r2, null));
    L10:
        g0.e(this.a.a);
        return;
    }
}

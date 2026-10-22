package com.bytedance.ee.bear.list.office.longpress;

import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ com.bytedance.ee.bear.more.office.c a;
    public final /* synthetic */ oj5.a b;
    public final /* synthetic */ com.bytedance.ee.bear.more.office.b c;
    public final /* synthetic */ h.b d;

    public k(com.bytedance.ee.bear.more.office.c r1, oj5.a r2, com.bytedance.ee.bear.office.list.adapter.p r3, h.b r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void accept(Object r8) {
        DocPermission r9 = (DocPermission) r8;
        ConcurrentHashMap<String, CompositeDisposable> r0 = h.c;
        if (r0.containsKey(this.a.a) == false) goto L11;
        oj5.a r1 = this.b;
        Intrinsics.checkNotNull(r9);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r9, "docPermission");
        r1.i = r9;
        h r2 = h.a;
        String r3 = null;
        com.bytedance.ee.bear.more.office.a r4 = h.e(this.a, null);
        com.bytedance.ee.bear.more.office.b r5 = this.c;
        if (r5 == null) goto L7;
        com.bytedance.ee.bear.more.office.c r6 = this.a;
        r5.a(r6.a, r6.b, r6.c, r4);
    L7:
        StringBuilder r7 = new StringBuilder("prefetch download permission success. ");
        r7.append(h.h(this.a));
        r7.append(", type=");
        r7.append(this.d.getType());
        r7.append(", userPerm=");
        IDocUserPermission r10 = r9.a;
        if (r10 == null) goto L10;
        r3 = r10.getClass().getSimpleName();
    L10:
        r7.append(r3);
        r7.append(", refreshedAvailability=");
        r7.append(h.k(r4));
        tt5.a.h("OfficeDownloadActionExecutor", r7.toString());
    L11:
        CompositeDisposable r11 = r0.remove(this.a.a);
        if (r11 == null) goto L15;
        r11.clear();
        return;
    }
}

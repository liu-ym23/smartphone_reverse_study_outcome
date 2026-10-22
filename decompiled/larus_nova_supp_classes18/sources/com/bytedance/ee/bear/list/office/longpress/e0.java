package com.bytedance.ee.bear.list.office.longpress;

import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.more.office.OfficeLongPressLarkAction;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e0<T> implements Consumer {
    public final /* synthetic */ com.bytedance.ee.bear.more.office.c a;
    public final /* synthetic */ oj5.a b;
    public final /* synthetic */ com.bytedance.ee.bear.more.office.b c;

    public e0(com.bytedance.ee.bear.more.office.c r1, oj5.a r2, com.bytedance.ee.bear.more.office.b r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r7) {
        DocPermission r8 = (DocPermission) r7;
        ConcurrentHashMap<String, CompositeDisposable> r0 = c0.e;
        if (r0.containsKey(this.a.a) == false) goto L8;
        oj5.a r1 = this.b;
        Intrinsics.checkNotNull(r8);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r8, "docPermission");
        r1.i = r8;
        com.bytedance.ee.bear.more.office.b r9 = this.c;
        if (r9 == null) goto L7;
        com.bytedance.ee.bear.more.office.c r2 = this.a;
        String r3 = r2.a;
        OfficeLongPressLarkAction r4 = r2.b;
        String r5 = r2.c;
        c0 r6 = c0.a;
        r9.a(r3, r4, r5, c0.d(r2, null));
    L7:
        tt5.a.h("OfficeRenameActionExecutor", "prefetch rename permission success. actionId=" + this.a.a + ", type=" + this.b.getType());
    L8:
        CompositeDisposable r10 = r0.remove(this.a.a);
        if (r10 == null) goto L12;
        r10.clear();
        return;
    }
}

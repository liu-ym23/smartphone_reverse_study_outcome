package com.bytedance.ee.bear.list.office.longpress;

import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.more.office.OfficeLongPressLarkAction;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class u<T> implements Consumer {
    public final /* synthetic */ com.bytedance.ee.bear.more.office.c a;
    public final /* synthetic */ oj5.c b;
    public final /* synthetic */ com.bytedance.ee.bear.more.office.b c;
    public final /* synthetic */ int d;

    public u(com.bytedance.ee.bear.more.office.c r1, oj5.c r2, com.bytedance.ee.bear.more.office.b r3, int r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void accept(Object r8) {
        DocPermission r9 = (DocPermission) r8;
        ConcurrentHashMap<String, CompositeDisposable> r0 = s.d;
        if (r0.containsKey(this.a.a) == false) goto L11;
        oj5.c r1 = this.b;
        Intrinsics.checkNotNull(r9);
        r1.r(r9);
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.a.g() == false) goto L7;
        ConcurrentHashMap<String, PermissionResponse> r2 = s.b;
        String r3 = this.a.a;
        s r4 = s.a;
        r2.put(r3, s.g(this.b, r9.a));
    L7:
        com.bytedance.ee.bear.more.office.b r10 = this.c;
        if (r10 == null) goto L10;
        com.bytedance.ee.bear.more.office.c r5 = this.a;
        String r6 = r5.a;
        OfficeLongPressLarkAction r7 = r5.b;
        String r11 = r5.c;
        s r12 = s.a;
        r10.a(r6, r7, r11, s.f(r5, null));
    L10:
        tt5.a.h("OfficeMakeCopyActionExecutor", "prefetch make copy permission success. actionId=" + this.a.a + ", type=" + this.d);
    L11:
        CompositeDisposable r13 = r0.remove(this.a.a);
        if (r13 == null) goto L15;
        r13.clear();
        return;
    }
}

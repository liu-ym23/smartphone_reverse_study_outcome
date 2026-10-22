package com.bytedance.ee.bear.list.office.longpress;

import android.content.Context;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.more.office.OfficeLongPressDisabledDispatchReason;
import com.bytedance.ee.bear.more.office.OfficeLongPressLarkAction;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class o<T> implements Consumer {
    public final /* synthetic */ com.bytedance.ee.bear.more.office.c a;
    public final /* synthetic */ oj5.a b;
    public final /* synthetic */ com.bytedance.ee.bear.more.office.b c;

    public o(com.bytedance.ee.bear.more.office.c r1, oj5.a r2, com.bytedance.ee.bear.office.list.adapter.p r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r9) {
        DocPermission r10 = (DocPermission) r9;
        ConcurrentHashMap<String, CompositeDisposable> r0 = m.c;
        if (r0.containsKey(this.a.a) == false) goto L34;
        oj5.a r1 = this.b;
        Intrinsics.checkNotNull(r10);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r10, "docPermission");
        r1.i = r10;
        com.bytedance.ee.bear.more.office.b r11 = this.c;
        if (r11 == null) goto L33;
        com.bytedance.ee.bear.more.office.c r2 = this.a;
        String r3 = r2.a;
        OfficeLongPressLarkAction r4 = r2.b;
        String r5 = r2.c;
        m r6 = m.a;
        m.a r7 = m.i(r2, false);
        Context r8 = m.b(this.a);
        if (r8 != null) goto L10;
        r8 = eu5.b.a;
    L10:
        if (Intrinsics.areEqual(r7, m.a.c.a) == false) goto L13;
        com.bytedance.ee.bear.more.office.a r12 = com.bytedance.ee.bear.more.office.a.b.a;
    L30:
        r11.a(r3, r4, r5, r12);
        goto L33
    L13:
        if (Intrinsics.areEqual(r7, m.a.b.a) == false) goto L16;
        r12 = com.bytedance.ee.bear.more.office.a.d.a;
        goto L30
    L16:
        if (Intrinsics.areEqual(r7, m.a.e.a) == false) goto L18;
        r12 = new com.bytedance.ee.bear.more.office.a.C0116a(r8.getString(2131892995), OfficeLongPressDisabledDispatchReason.PREFETCH_IN_PROGRESS_RETRY);
        goto L30
    L18:
        OfficeLongPressDisabledDispatchReason r13 = null;
        if ((r7 instanceof m.a.C0031a) == false) goto L25;
        m.a.C0031a r14 = (m.a.C0031a) r7;
        String r15 = r14.a;
        if (r14.b == null) goto L23;
        r13 = OfficeLongPressDisabledDispatchReason.PERMISSION_PLATFORM_ACTION;
    L23:
        r12 = new com.bytedance.ee.bear.more.office.a.C0116a(r15, r13);
        goto L30
    L25:
        if ((r7 instanceof m.a.d) == false) goto L28;
        r12 = new com.bytedance.ee.bear.more.office.a.C0116a(null, OfficeLongPressDisabledDispatchReason.PERMISSION_PLATFORM_ACTION, 1);
        goto L30
    L28:
        if ((r7 instanceof m.a.f) == false) goto L32;
        r12 = new com.bytedance.ee.bear.more.office.a.C0116a(null, OfficeLongPressDisabledDispatchReason.SECURITY_POLICY_DIALOG, 1);
        goto L30
    L32:
        throw new NoWhenBranchMatchedException();
    L33:
        tt5.a.h("OfficeExportAsActionExecutor", "prefetch export permission success. actionId=" + this.a.a + ", type=" + this.b.getType());
    L34:
        CompositeDisposable r16 = r0.remove(this.a.a);
        if (r16 == null) goto L38;
        r16.clear();
        return;
    }
}

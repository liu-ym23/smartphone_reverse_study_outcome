package com.bytedance.ee.bear.list.office.longpress;

import android.content.Context;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ com.bytedance.ee.bear.more.office.c a;
    public final /* synthetic */ h.b b;
    public final /* synthetic */ oj5.a c;

    public i(com.bytedance.ee.bear.more.office.c r1, h.b r2, oj5.a r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r6) {
        DocPermission r7 = (DocPermission) r6;
        StringBuilder r0 = new StringBuilder("fetch download permission success. ");
        h r1 = h.a;
        r0.append(h.h(this.a));
        r0.append(", type=");
        r0.append(this.b.getType());
        r0.append(", userPerm=");
        IDocUserPermission r2 = r7.a;
        if (r2 == null) goto L5;
        String r3 = r2.getClass().getSimpleName();
    L6:
        r0.append(r3);
        tt5.a.h("OfficeDownloadActionExecutor", r0.toString());
        oj5.a r4 = this.c;
        Intrinsics.checkNotNull(r7);
        r4.getClass();
        Intrinsics.checkNotNullParameter(r7, "docPermission");
        r4.i = r7;
        Toast.cancelLoading();
        CompositeDisposable r8 = h.b.remove(this.a.a);
        if (r8 == null) goto L9;
        r8.clear();
    L9:
        com.bytedance.ee.bear.more.office.c r9 = this.a;
        Context r5 = h.a(r9);
        if (r5 != null) goto L12;
        r5 = eu5.b.a;
    L12:
        h.a r10 = h.m(r9);
        if (Intrinsics.areEqual(r10, h.a.c.a) == false) goto L16;
        tt5.a.h("OfficeDownloadActionExecutor", "continue download after real permission blocked. " + h.h(r9) + ", decision=Hidden");
        Toast.showText(r5, com.bytedance.ee.bear.more.office.f.c());
        return;
    L16:
        if (Intrinsics.areEqual(r10, h.a.b.a) == false) goto L19;
        tt5.a.h("OfficeDownloadActionExecutor", "continue download after real permission allowed. " + h.h(r9));
        h.d(r9);
        return;
    L19:
        if (Intrinsics.areEqual(r10, h.a.e.a) == false) goto L22;
        tt5.a.h("OfficeDownloadActionExecutor", "continue download after real permission still prefetching. " + h.h(r9));
        Toast.showText(r5, com.bytedance.ee.bear.more.office.f.b());
        return;
    L22:
        if ((r10 instanceof h.a.C0030a) == false) goto L25;
        tt5.a.h("OfficeDownloadActionExecutor", "continue download after real permission disabled. " + h.h(r9) + ", decision=DisabledToast");
        Toast.showText(r5, ((h.a.C0030a) r10).a);
        return;
    L25:
        if ((r10 instanceof h.a.d) == false) goto L28;
        tt5.a.h("OfficeDownloadActionExecutor", "continue download after real permission by permission platform. " + h.h(r9));
        h.a.d r11 = (h.a.d) r10;
        r11.a.getCallback().a(r5, r11.a);
        return;
    L28:
        if ((r10 instanceof h.a.f) == false) goto L32;
        tt5.a.h("OfficeDownloadActionExecutor", "continue download after real permission by security dialog. " + h.h(r9));
        h.p(r9);
        return;
    L32:
        throw new NoWhenBranchMatchedException();
    L5:
        r3 = null;
        goto L6
    }
}

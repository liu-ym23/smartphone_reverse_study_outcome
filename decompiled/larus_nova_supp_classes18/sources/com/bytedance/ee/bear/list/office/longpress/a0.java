package com.bytedance.ee.bear.list.office.longpress;

import android.content.Context;
import com.bytedance.ee.bear.more.office.OfficeLongPressDisabledDispatchReason;
import com.bytedance.ee.bear.more.office.OfficeLongPressLarkAction;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a0<T> implements Consumer {
    public final /* synthetic */ com.bytedance.ee.bear.more.office.c a;
    public final /* synthetic */ com.bytedance.ee.bear.more.office.b b;

    public a0(com.bytedance.ee.bear.more.office.c r1, com.bytedance.ee.bear.more.office.b r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r7) {
        tt5.a.e("OfficeMoveToActionExecutor", "prefetch move nodeToken failed. actionId=" + this.a.a, (Throwable) r7, false);
        com.bytedance.ee.bear.more.office.b r8 = this.b;
        if (r8 == null) goto L10;
        com.bytedance.ee.bear.more.office.c r0 = this.a;
        String r1 = r0.a;
        OfficeLongPressLarkAction r2 = r0.b;
        String r3 = r0.c;
        b0.a.getClass();
        Context r4 = b0.a(r0);
        if (r4 == null) goto L8;
        String r5 = r4.getString(2131887802);
        if (r5 == null) goto L8;
    L9:
        r8.a(r1, r2, r3, new com.bytedance.ee.bear.more.office.a.C0116a(r5, OfficeLongPressDisabledDispatchReason.PREFETCH_FAILED_RETRY));
    L8:
        r5 = com.bytedance.ee.bear.more.office.f.a();
    L10:
        b0 r9 = b0.a;
        String r6 = this.a.a;
        r9.getClass();
        CompositeDisposable r10 = b0.c.remove(r6);
        if (r10 == null) goto L14;
        r10.clear();
        return;
    }
}

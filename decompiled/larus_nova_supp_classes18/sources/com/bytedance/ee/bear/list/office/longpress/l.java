package com.bytedance.ee.bear.list.office.longpress;

import android.content.Context;
import com.bytedance.ee.bear.more.office.OfficeLongPressDisabledDispatchReason;
import com.bytedance.ee.bear.more.office.OfficeLongPressLarkAction;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l<T> implements Consumer {
    public final /* synthetic */ com.bytedance.ee.bear.more.office.c a;
    public final /* synthetic */ h.b b;
    public final /* synthetic */ com.bytedance.ee.bear.more.office.b c;

    public l(com.bytedance.ee.bear.more.office.c r1, h.b r2, com.bytedance.ee.bear.office.list.adapter.p r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r7) {
        StringBuilder r0 = new StringBuilder("prefetch download permission failed. ");
        h r1 = h.a;
        r0.append(h.h(this.a));
        r0.append(", type=");
        r0.append(this.b.getType());
        String r2 = r0.toString();
        tt5.a.e("OfficeDownloadActionExecutor", r2, (Throwable) r7, false);
        com.bytedance.ee.bear.more.office.b r8 = this.c;
        if (r8 == null) goto L10;
        com.bytedance.ee.bear.more.office.c r3 = this.a;
        String r4 = r3.a;
        OfficeLongPressLarkAction r5 = r3.b;
        String r6 = r3.c;
        Context r9 = h.a(r3);
        if (r9 == null) goto L8;
        String r10 = r9.getString(2131887802);
        if (r10 == null) goto L8;
    L9:
        r8.a(r4, r5, r6, new com.bytedance.ee.bear.more.office.a.C0116a(r10, OfficeLongPressDisabledDispatchReason.PREFETCH_FAILED_RETRY));
    L8:
        r10 = com.bytedance.ee.bear.more.office.f.a();
    L10:
        String r11 = this.a.a;
        CompositeDisposable r12 = h.c.remove(r11);
        if (r12 == null) goto L14;
        r12.clear();
        return;
    }
}

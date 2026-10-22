package com.bytedance.ee.bear.list.office.longpress;

import android.content.Context;
import com.bytedance.ee.bear.more.office.OfficeLongPressDisabledDispatchReason;
import com.bytedance.ee.bear.more.office.OfficeLongPressLarkAction;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class v<T> implements Consumer {
    public final /* synthetic */ com.bytedance.ee.bear.more.office.c a;
    public final /* synthetic */ com.bytedance.ee.bear.more.office.b b;

    public v(com.bytedance.ee.bear.more.office.c r1, com.bytedance.ee.bear.more.office.b r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r7) {
        tt5.a.e("OfficeMakeCopyActionExecutor", "prefetch make copy permission failed. actionId=" + this.a.a, (Throwable) r7, false);
        com.bytedance.ee.bear.more.office.b r8 = this.b;
        if (r8 == null) goto L10;
        com.bytedance.ee.bear.more.office.c r0 = this.a;
        String r1 = r0.a;
        OfficeLongPressLarkAction r2 = r0.b;
        String r3 = r0.c;
        s r5 = s.a;
        Context r4 = s.a(r0);
        if (r4 == null) goto L8;
        String r6 = r4.getString(2131887802);
        if (r6 == null) goto L8;
    L9:
        r8.a(r1, r2, r3, new com.bytedance.ee.bear.more.office.a.C0116a(r6, OfficeLongPressDisabledDispatchReason.PREFETCH_FAILED_RETRY));
    L8:
        r6 = com.bytedance.ee.bear.more.office.f.a();
    L10:
        s r9 = s.a;
        CompositeDisposable r10 = s.d.remove(this.a.a);
        if (r10 == null) goto L14;
        r10.clear();
        return;
    }
}

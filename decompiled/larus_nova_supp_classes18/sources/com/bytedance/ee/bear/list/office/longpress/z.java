package com.bytedance.ee.bear.list.office.longpress;

import com.bytedance.ee.bear.DocContainerInfo;
import com.bytedance.ee.bear.more.office.OfficeLongPressLarkAction;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class z<T> implements Consumer {
    public final /* synthetic */ com.bytedance.ee.bear.more.office.c a;
    public final /* synthetic */ com.bytedance.ee.bear.more.office.b b;

    public z(com.bytedance.ee.bear.more.office.c r1, com.bytedance.ee.bear.more.office.b r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r6) {
        String r7 = ((DocContainerInfo) r6).getNode_token();
        if (r7 != null) goto L6;
        r7 = "";
    L6:
        if (r7.length() <= 0) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == true) goto L11;
    L16:
        b0 r8 = b0.a;
        String r1 = this.a.a;
        r8.getClass();
        CompositeDisposable r9 = b0.c.remove(r1);
        if (r9 == null) goto L20;
        r9.clear();
        return;
    L20:
        return;
    L11:
        if (b0.c.containsKey(this.a.a) == false) goto L16;
        com.bytedance.ee.bear.more.office.c r2 = this.a;
        r2.f.c = r7;
        com.bytedance.ee.bear.more.office.b r10 = this.b;
        if (r10 == null) goto L15;
        String r3 = r2.a;
        OfficeLongPressLarkAction r4 = r2.b;
        String r5 = r2.c;
        b0.a.getClass();
        r10.a(r3, r4, r5, b0.c(r2, null));
    L15:
        tt5.a.h("OfficeMoveToActionExecutor", "prefetch move nodeToken success. actionId=" + this.a.a);
        goto L16
    L8:
        r0 = false;
        goto L9
    }
}

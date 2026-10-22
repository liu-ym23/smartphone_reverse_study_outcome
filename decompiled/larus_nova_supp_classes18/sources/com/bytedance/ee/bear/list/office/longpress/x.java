package com.bytedance.ee.bear.list.office.longpress;

import android.content.Context;
import com.bytedance.ee.bear.DocContainerInfo;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class x<T> implements Consumer {
    public final /* synthetic */ com.bytedance.ee.bear.more.office.c a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ oj5.c c;

    public x(com.bytedance.ee.bear.more.office.c r1, Context r2, oj5.c r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r4) {
        String r5 = ((DocContainerInfo) r4).getNode_token();
        if (r5 != null) goto L6;
        r5 = "";
    L6:
        if (r5.length() <= 0) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == true) goto L11;
    L13:
        Context r6 = this.b;
        Toast.showText(r6, r6.getString(2131887932));
    L14:
        b0 r7 = b0.a;
        String r1 = this.a.a;
        r7.getClass();
        b0.h(r1);
        return;
    L11:
        if (b0.b.containsKey(this.a.a) == false) goto L13;
        com.bytedance.ee.bear.more.office.c r2 = this.a;
        r2.f.c = r5;
        r2.k.invoke();
        b0 r8 = b0.a;
        com.bytedance.ee.bear.more.office.c r3 = this.a;
        Context r9 = this.b;
        oj5.c r10 = this.c;
        r8.getClass();
        b0.g(r3, r9, r10);
        goto L14
    L8:
        r0 = false;
        goto L9
    }
}

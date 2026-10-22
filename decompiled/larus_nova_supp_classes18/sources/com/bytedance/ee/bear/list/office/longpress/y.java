package com.bytedance.ee.bear.list.office.longpress;

import android.content.Context;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class y<T> implements Consumer {
    public final /* synthetic */ Context a;
    public final /* synthetic */ com.bytedance.ee.bear.more.office.c b;

    public y(Context r1, com.bytedance.ee.bear.more.office.c r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        Context r4 = this.a;
        Toast.showText(r4, r4.getString(2131887932));
        b0 r5 = b0.a;
        String r0 = this.b.a;
        r5.getClass();
        b0.h(r0);
    }
}

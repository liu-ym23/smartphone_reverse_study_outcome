package com.bytedance.ee.bear.list.office.longpress;

import android.content.Context;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ com.bytedance.ee.bear.more.office.c a;
    public final /* synthetic */ h.b b;
    public final /* synthetic */ Context c;

    public j(com.bytedance.ee.bear.more.office.c r1, h.b r2, Context r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r4) {
        StringBuilder r0 = new StringBuilder("fetch download permission failed. ");
        h r1 = h.a;
        r0.append(h.h(this.a));
        r0.append(", type=");
        r0.append(this.b.getType());
        String r2 = r0.toString();
        tt5.a.e("OfficeDownloadActionExecutor", r2, (Throwable) r4, false);
        Toast.cancelLoading();
        Toast.showFailureText(this.c, 2131887802);
        h.l(this.a.a);
    }
}

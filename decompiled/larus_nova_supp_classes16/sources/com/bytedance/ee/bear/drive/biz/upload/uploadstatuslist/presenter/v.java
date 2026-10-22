package com.bytedance.ee.bear.drive.biz.upload.uploadstatuslist.presenter;

import android.os.Message;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class v implements Consumer<z65.a> {
    public final /* synthetic */ w a;

    public v(w r1) {
        this.a = r1;
    }

    public final void accept(Object r20) throws Exception {
        int r1 = this.a.c.b(((z65.a) r20).b);
        z65.d r2 = this.a.c;
        z65.b r3 = (z65.b) ListProtector.get(r2.a, r1);
        boolean r4 = false;
        int r6 = -1;
        if (r1 > (-1)) goto L5;
    L7:
        String r13 = null;
        long r16 = 0;
        long r17 = 0;
        int r14 = 0;
    L8:
        z65.a r5 = new z65.a(r6, r13, r14, r16, r17);
        if (r6 == 4) goto L11;
        w r7 = this.a;
        r7.getClass();
        r7.sendMessage(Message.obtain(r7, 10006, r5));
    L11:
        this.a.b.sP();
        w r8 = this.a;
        a75.g r9 = r8.b;
        if (((ArrayList) r8.d).size() == 0) goto L14;
        r4 = true;
    L14:
        r9.eH(r4);
        w r10 = this.a;
        r10.b.e50(r10.d);
        tt5.a.h("UpdateListTAG", "delete item " + r1);
        return;
    L5:
        if (r1 >= ((ArrayList) r2.a).size()) goto L7;
        String r11 = r3.g;
        int r12 = r3.e;
        int r18 = r3.h;
        long r19 = r3.c;
        long r110 = r3.d;
        ListProtector.remove(r2.a, r1);
        tt5.a.h("UpdateListTAG", "remove key = " + r11 + " position " + r1);
        r13 = r11;
        r6 = r12;
        r14 = r18;
        r16 = r19;
        r17 = r110;
        goto L8
    }
}

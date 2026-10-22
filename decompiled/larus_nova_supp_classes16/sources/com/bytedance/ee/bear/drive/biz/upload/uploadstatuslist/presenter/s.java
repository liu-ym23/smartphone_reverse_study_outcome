package com.bytedance.ee.bear.drive.biz.upload.uploadstatuslist.presenter;

import android.os.Message;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class s implements Consumer<z65.a> {
    public final /* synthetic */ z65.a a;
    public final /* synthetic */ w b;

    public final void accept(Object r7) throws Exception {
        z65.a r8 = (z65.a) r7;
        tt5.a.h("UpdateListTAG", "update status key = " + r8.b);
        w r0 = this.b;
        w.a(r0, r0.d);
        z65.d r1 = this.b.c;
        int r2 = 0;
    L4:
        if (r2 >= ((ArrayList) r1.a).size()) goto L12;
        z65.b r3 = (z65.b) ListProtector.get(r1.a, r2);
        if (r3.g.equals(r8.b) == true) goto L7;
        r2 = r2 + 1;
        goto L4
    L7:
        String r4 = r8.f;
        if (TextUtils.isEmpty(r4) == true) goto L10;
        r3.k = r4;
        goto L12
    L10:
        r3.e = r8.a;
        r3.h = r8.e;
        r3.c = r8.c;
        r3.d = r8.d;
    L12:
        z65.d r5 = this.b.c;
        Collections.sort(r5.a, r5.b);
        this.b.b.sP();
        this.b.b.aw(r8.f);
        if (this.a.a != 4) goto L18;
        tt5.a.h("UpdateListTAG", "dispatch delete message " + r8.b);
        w r6 = this.b;
        r6.sendMessageDelayed(Message.obtain(r6, 10002, r8), r6.g);
        return;
    }

    public s(w r1, z65.a r2) {
        this.b = r1;
        this.a = r2;
    }
}

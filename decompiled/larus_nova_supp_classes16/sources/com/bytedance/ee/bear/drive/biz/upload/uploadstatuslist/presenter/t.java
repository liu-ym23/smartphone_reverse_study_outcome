package com.bytedance.ee.bear.drive.biz.upload.uploadstatuslist.presenter;

import com.bytedance.ee.bear.facade.common.widget.recyclerview.SwipeMenuLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class t implements Consumer<z65.a> {
    public final /* synthetic */ w a;

    public t(w r1) {
        this.a = r1;
    }

    public final void accept(Object r6) throws Exception {
        z65.a r7 = (z65.a) r6;
        if (SwipeMenuLayout.getViewCache() == null) goto L5;
        SwipeMenuLayout.getViewCache().f();
    L5:
        z65.d r0 = this.a.c;
        r0.getClass();
        tt5.a.h("UpdateListTAG", "remove complete status file");
        int r1 = r0.b(r7.b);
        if (r1 != (-1)) goto L8;
    L10:
        z65.d r2 = this.a.c;
        Collections.sort(r2.a, r2.b);
        w r3 = this.a;
        w.a(r3, r3.d);
        this.a.b.sP();
        if (((ArrayList) this.a.d).size() != 0) goto L13;
        this.a.b.eH(false);
        w r4 = this.a;
        r4.b.e50(r4.d);
    L13:
        tt5.a.h("UpdateListTAG", "delete = " + r7.b);
        return;
    L8:
        if (r1 >= ((ArrayList) r0.a).size()) goto L10;
        tt5.a.h("UpdateListTAG", "remove position " + r1);
        ListProtector.remove(r0.a, r1);
        goto L10
    }
}

package com.bytedance.ee.bear.drive.biz.upload.uploadstatuslist.presenter;

import android.os.Message;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class u implements Consumer<List<z65.b>> {
    public final /* synthetic */ w a;

    public u(w r1) {
        this.a = r1;
    }

    public final void accept(Object r3) throws Exception {
        List<z65.b> r4 = (List) r3;
        w r0 = this.a;
        ((ArrayList) r0.e).clear();
        ((ArrayList) r0.e).addAll(r4);
        w r1 = this.a;
        r1.getClass();
        r1.sendMessage(Message.obtain(r1, 10005));
        r4.clear();
        this.a.b.sP();
        this.a.b.eH(false);
        this.a.b.e50(r4);
        tt5.a.h("UpdateListTAG", "cancel all upload");
    }
}

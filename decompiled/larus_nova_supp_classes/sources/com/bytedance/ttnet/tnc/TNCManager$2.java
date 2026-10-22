package com.bytedance.ttnet.tnc;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class TNCManager$2 extends Handler {
    final /* synthetic */ TNCManager this$0;

    @Override // android.os.Handler
    public void handleMessage(Message r3) {
        if (r3.what == 10000) goto L6;
        return;
    L6:
        if (r3.arg1 != 0) goto L8;
        boolean r0 = false;
    L9:
        TNCManager r1 = this.this$0;
        TNCManager.access$100(r1, r0, TNCManager.access$000(r1, r3.arg2));
        return;
    L8:
        r0 = true;
        goto L9
    }

    public TNCManager$2(TNCManager r1, Looper r2) {
        this.this$0 = r1;
        super(r2);
    }
}

package com.bytedance.ee.bear.list.create;

import android.app.Application;
import com.bytedance.ee.bear.facade.common.widget.Toast;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final /* synthetic */ class n implements Runnable {
    public final /* synthetic */ int a;

    public /* synthetic */ n() {
        this.a = 2131892963;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r0 = this.a;
        Application r1 = eu5.b.a;
        Toast.showLoading(r1, r1.getString(r0));
    }
}

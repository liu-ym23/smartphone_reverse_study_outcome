package com.bytedance.ee.bear.fileselector;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.fileselector.api.FileSelectConfig;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e implements Runnable {
    public final /* synthetic */ FileSelectConfig a;
    public final /* synthetic */ itb.e b;
    public final /* synthetic */ FragmentActivity c;
    public final /* synthetic */ itb.g d;
    public final /* synthetic */ f e;

    public e(FileSelectConfig r1, itb.e r2, FragmentActivity r3, itb.g r4, f r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final void a() {
        g r0 = g.a;
        FileSelectConfig r1 = this.a;
        r0.getClass();
        int r2 = r1.selectType;
        boolean r3 = true;
        if (r2 != 1) goto L5;
    L10:
        if (r3 == false) goto L12;
        boolean r4 = this.b.M0(this.c, this.d, this.e);
    L13:
        if (r4 == true) goto L16;
        tt5.a.k("OfficeMediaFileSelector", "host media api returned false");
        g.b(this.a);
        return;
    L16:
        return;
    L12:
        r4 = this.b.f0(this.c, this.d, this.e);
        goto L13
    L5:
        if (r2 == 3) goto L7;
    L9:
        r3 = false;
        goto L10
    L7:
        if (r1.sourceType != 1) goto L9;
        goto L9
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

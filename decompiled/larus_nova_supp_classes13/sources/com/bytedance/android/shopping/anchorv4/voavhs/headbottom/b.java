package com.bytedance.android.shopping.anchorv4.voavhs.headbottom;

import android.widget.ImageView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements Runnable {
    public final /* synthetic */ HeadBottomAdapter.HeadBottomHolder a;

    @Override // java.lang.Runnable
    public final void run() {
        ImageView r0 = this.a.a;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.setImageBitmap(null);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public b(HeadBottomAdapter.HeadBottomHolder r1) {
        this.a = r1;
    }
}

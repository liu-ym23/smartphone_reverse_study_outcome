package com.bytedance.awemeopen.apps.framework.utils;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class o implements View.OnClickListener {
    public final long a;
    public boolean b;
    public final a c;

    public class a implements Runnable {
        public final /* synthetic */ o a;

        @Override // java.lang.Runnable
        public final void run() {
            this.a.b = true;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(o r1) {
            this.a = r1;
        }
    }

    public o() {
        this(0);
    }

    public abstract void a();

    public o(int r3) {
        this.b = true;
        this.c = new a(this);
        this.a = 500;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        if (this.b == false) goto L6;
        this.b = false;
        r4.postDelayed(this.c, this.a);
        a();
        return;
    }
}

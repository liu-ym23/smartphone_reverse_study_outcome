package com.bytedance.awemeopen.apps.framework.utils;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes14.dex */
public abstract class o implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f197733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f197734b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f197735c;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f197736a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f197736a.f197734b = true;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(o r100) {
            this.f197736a = r100;
        }
    }

    public o() {
        this(0);
    }

    public abstract void a();

    public o(int r100) {
        this.f197734b = true;
        this.f197735c = new a(this);
        this.f197733a = 500;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (this.f197734b == false) goto L6;
        this.f197734b = false;
        r100.postDelayed(this.f197735c, this.f197733a);
        a();
        return;
    }
}

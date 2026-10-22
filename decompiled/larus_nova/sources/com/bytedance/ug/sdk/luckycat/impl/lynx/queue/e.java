package com.bytedance.ug.sdk.luckycat.impl.lynx.queue;

import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes22.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f271257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Handler f271258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f271259c;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Handler f271260a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f271261b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f271262c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Function1 f271263d;

        @Override // java.lang.Runnable
        public final void run() {
            int r100 = (int) (((System.currentTimeMillis() - this.f271261b.f271257a) / (this.f271262c * 1.0d)) * ((double) 100));     // Catch: Throwable -> L9
            if (r100 <= 100) goto L5;
            r100 = 100;
        L5:
            this.f271263d.invoke(Integer.valueOf(r100));     // Catch: Throwable -> L9
            if (r100 >= 100) goto L12;
            this.f271260a.postDelayed(this, this.f271261b.f271259c);     // Catch: Throwable -> L9
            return;
        L12:
            return;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }

        public a(Handler r100, e r101, long r102, Function1 r103) {
            this.f271260a = r100;
            this.f271261b = r101;
            this.f271262c = r102;
            this.f271263d = r103;
        }
    }

    public e() {
        this.f271257a = System.currentTimeMillis();
        this.f271259c = 1000;
    }

    public final void a(long r100, Function1<? super Integer, Unit> r110) {
        long r101 = r100 / ((long) 100);
        this.f271259c = r101;
        if (r101 >= 150) goto L5;
        this.f271259c = 150;
    L5:
        this.f271257a = System.currentTimeMillis();
        Handler r102 = new Handler(Looper.getMainLooper());
        r102.postDelayed(new a(r102, this, r100, r110), this.f271259c);
        this.f271258b = r102;
    }
}

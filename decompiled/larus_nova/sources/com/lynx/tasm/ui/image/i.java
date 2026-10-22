package com.lynx.tasm.ui.image;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.base.LLog;

/* JADX INFO: loaded from: classes32.dex */
public final class i implements com.lynx.tasm.behavior.m.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f384004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f384005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f384006c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f384007d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ h f384008e;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f384009a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i f384010b;

        public final void a() {
            i r100 = this.f384010b;
            m8a.g r101 = r100.f384008e.f383986x;
            if (r101 != null) goto L5;
        L9:
            h.b(this.f384010b.f384008e);
            LLog.w("ImageDelegate", "localCache url check error: " + this.f384010b.f384004a);
            return;
        L5:
            if (r100.f384004a.equals(r101.f512532b) == false) goto L9;
            long r102 = System.currentTimeMillis();
            i r103 = this.f384010b;
            int r110 = r103.f384008e.c(r103.f384005b, r103.f384006c);
            i r104 = this.f384010b;
            h r105 = r104.f384008e;
            r105.l(r105.f383984v, true, true, r104.f384007d, r102, 0, r110);
            this.f384010b.f384008e.A.f((CloseableReference) this.f384009a);
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

        public a(i r100, Object r101) {
            this.f384010b = r100;
            this.f384009a = r101;
        }
    }

    @Override // com.lynx.tasm.behavior.m.a
    public final void a(Object r100, Throwable r101) {
    L19:
        th = move-exception;
        h.b(this.f384008e);
        th.printStackTrace();
        return;
    L5:
        if ((r100 instanceof CloseableReference) == true) goto L8;
        h.b(this.f384008e);     // Catch: Throwable -> L19
        LLog.w("ImageDelegate", "localCache image is not CloseableReference and the url is: " + this.f384004a);     // Catch: Throwable -> L19
        return;
    L8:
        Object r102 = ((CloseableReference) r100).get();     // Catch: Throwable -> L19
        if ((r102 instanceof Bitmap) == false) goto L11;
    L14:
        a r103 = new a(this, r100);     // Catch: Throwable -> L19
        if (Looper.myLooper() != Looper.getMainLooper()) goto L17;
        r103.run();     // Catch: Throwable -> L19
        return;
    L17:
        new Handler(Looper.getMainLooper()).post(r103);     // Catch: Throwable -> L19
        return;
    L11:
        if ((r102 instanceof CloseableBitmap) == true) goto L14;
        h.b(this.f384008e);     // Catch: Throwable -> L19
        LLog.w("ImageDelegate", "localCache cannot get bitmap and the url is: " + this.f384004a);     // Catch: Throwable -> L19
    }

    public i(h r100, String r101, int r102, int r103, long r104) {
        this.f384008e = r100;
        this.f384004a = r101;
        this.f384005b = r102;
        this.f384006c = r103;
        this.f384007d = r104;
    }
}

package com.ss.android.lark.cameraview;

import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes34.dex */
public final class r0 implements d0b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JCameraView f411011a;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f411012a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ r0 f411013b;

        @Override // java.lang.Runnable
        public final void run() {
            JCameraView r100 = this.f411013b.f411011a;     // Catch: Throwable -> L4
            r100.f410829a.j(r100.f410833e, true, this.f411012a);     // Catch: Throwable -> L4
            CaptureLayout r101 = this.f411013b.f411011a.f410839k;     // Catch: Throwable -> L4
            r101.getClass();     // Catch: Throwable -> L4
            r101.postDelayed(new e0(r101), 300);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(r0 r100, long r101) {
            this.f411013b = r100;
            this.f411012a = r101;
        }
    }

    @Override // d0b.a
    public final void b() {
        this.f411011a.f410829a.a();
    }

    @Override // d0b.a
    public final void c() {
        JCameraView r100 = this.f411011a;
        r100.f410829a.f(r100.f410833e, r100.f410834f.getHolder().getSurface(), this.f411011a.f410842n);
    }

    public r0(JCameraView r100) {
        this.f411011a = r100;
    }

    @Override // d0b.a
    public final void a(long r100) {
        JCameraView r101 = this.f411011a;
        r101.f410839k.setTextWithAnimation(UIUtils.getString(r101.f410833e, R.string.Lark_Legacy_RecordShortTime));
        this.f411011a.postDelayed(new a(this, r100), 1000 - r100);
    }

    @Override // d0b.a
    public final void d(long r100) {
        JCameraView r101 = this.f411011a;
        r101.f410829a.j(r101.f410833e, false, r100);
    }
}

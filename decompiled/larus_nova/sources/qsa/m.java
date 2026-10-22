package qsa;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.bytedcert.ocr.OCRTakePhotoActivity;

/* JADX INFO: loaded from: classes34.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f534709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OCRTakePhotoActivity f534710b;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f534711a;

        @Override // java.lang.Runnable
        public final void run() {
            OCRTakePhotoActivity r100 = this.f534711a.f534710b;     // Catch: Throwable -> L4
            int r101 = OCRTakePhotoActivity.f407622r;     // Catch: Throwable -> L4
            r100.H1(true);     // Catch: Throwable -> L4
            this.f534711a.f534710b.finish();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(m r100) {
            this.f534711a = r100;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        p.c(this.f534710b.f407627h, this.f534709a);     // Catch: Throwable -> L4
        this.f534710b.runOnUiThread(new a(this));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public m(OCRTakePhotoActivity r100, String r101) {
        this.f534710b = r100;
        this.f534709a = r101;
    }
}

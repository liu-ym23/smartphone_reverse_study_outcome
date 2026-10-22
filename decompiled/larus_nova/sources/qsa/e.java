package qsa;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.bytedcert.ocr.OCRTakePhotoActivity;
import com.ss.android.bytedcert.view.camera.MyPreview;

/* JADX INFO: loaded from: classes34.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f534701a;

    @Override // java.lang.Runnable
    public final void run() {
        OCRTakePhotoActivity r100 = this.f534701a.f534702d;     // Catch: Throwable -> L10
        if (r100.f407634o != 0) goto L13;
        r100.f407634o = 1;     // Catch: Throwable -> L10
        MyPreview r101 = r100.f407624e;     // Catch: Throwable -> L10
        if (r101 == null) goto L8;
        r101.a(r100);     // Catch: Throwable -> L10
    L8:
        this.f534701a.f534702d.G1("take_photo");     // Catch: Throwable -> L10
        return;
    L13:
        return;
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L17;
        throw th;
    }

    public e(f r100) {
        this.f534701a = r100;
    }
}

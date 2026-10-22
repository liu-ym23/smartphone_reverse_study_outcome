package jsa;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.bytedcert.face.ui.FaceDetectFullActivity;

/* JADX INFO: loaded from: classes34.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FaceDetectFullActivity f500248a;

    @Override // java.lang.Runnable
    public final void run() {
        FaceDetectFullActivity r100 = this.f500248a;     // Catch: Throwable -> L4
        int r101 = FaceDetectFullActivity.H;     // Catch: Throwable -> L4
        r100.M1("do verify");     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public f(FaceDetectFullActivity r100) {
        this.f500248a = r100;
    }
}

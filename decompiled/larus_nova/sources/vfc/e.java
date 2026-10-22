package vfc;

import android.os.Handler;
import android.os.Looper;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.photoeditor.mosaic.v2.MosaicPhotoEditorPluginV2;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes38.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f554640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MosaicPhotoEditorPluginV2 f554641b;

    @Override // java.lang.Runnable
    public final void run() {
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L17;
        throw th;
    L17:
        return;
    L3:
        if (this.f554640a.compareAndSet(true, false) == false) goto L14;
        MosaicPhotoEditorPluginV2 r100 = this.f554641b;     // Catch: Throwable -> L9
        int r101 = MosaicPhotoEditorPluginV2.f449347n;     // Catch: Throwable -> L9
        LKUIToast.show(r100.getContext(), R.string.Lark_ASL_OCRFail);     // Catch: Throwable -> L9
        o r102 = r100.f449360l;     // Catch: Throwable -> L9
        r102.getClass();     // Catch: Throwable -> L9
        m r103 = new m(r102);     // Catch: Throwable -> L9
        if (Looper.myLooper() != Looper.getMainLooper()) goto L7;
        r103.run();     // Catch: Throwable -> L9
        goto L14
    L7:
        new Handler(Looper.getMainLooper()).post(r103);     // Catch: Throwable -> L9
    L14:
    }

    public e(MosaicPhotoEditorPluginV2 r100, AtomicBoolean r101) {
        this.f554641b = r100;
        this.f554640a = r101;
    }
}

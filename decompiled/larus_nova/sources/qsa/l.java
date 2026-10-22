package qsa;

import android.graphics.drawable.Drawable;
import android.hardware.Camera;
import android.widget.ImageView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.bytedcert.ocr.OCRTakePhotoActivity;
import com.ss.android.bytedcert.view.camera.MyPreview;

/* JADX INFO: loaded from: classes34.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OCRTakePhotoActivity f534708a;

    public final void a() {
        MyPreview r100 = this.f534708a.f407624e;
        if (r100 != null) goto L5;
    L7:
        OCRTakePhotoActivity r101 = this.f534708a;
        r101.f407633n = 1;
        Drawable r102 = r101.f407623d.getDrawable(R.mipmap.byted_poweron);
        ImageView r103 = this.f534708a.f407626g;
        if (r103 == null) goto L10;
        r103.setImageDrawable(r102);
    L10:
        MyPreview r104 = this.f534708a.f407624e;
        if (r104 == null) goto L23;
        wsa.a r105 = r104.f407807b;
        r105.getClass();
        Camera r106 = r105.f561110a;     // Catch: Exception -> L18
        if (r106 == null) goto L24;
        Camera.Parameters r107 = r106.getParameters();     // Catch: Exception -> L18
        r107.setFlashMode("torch");     // Catch: Exception -> L18
        r105.f561110a.setParameters(r107);     // Catch: Exception -> L18
        return;
    L24:
        return;
    L18:
        e = move-exception;
        e.printStackTrace();
        return;
    L23:
        return;
    L5:
        if (r100.getCamId() != 1) goto L7;
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

    public l(OCRTakePhotoActivity r100) {
        this.f534708a = r100;
    }
}

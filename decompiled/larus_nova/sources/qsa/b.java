package qsa;

import android.view.View;
import com.ss.android.bytedcert.ocr.OCRManualActivity;
import com.ss.android.bytedcert.view.camera.MyPreview;

/* JADX INFO: loaded from: classes34.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OCRManualActivity f534697a;

    public b(OCRManualActivity r100) {
        this.f534697a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        OCRManualActivity r101 = this.f534697a;
        if (r101.f407607g == 0) goto L5;
        return;
    L5:
        r101.f407607g = 1;
        MyPreview r102 = r101.f407604d;
        if (r102 == null) goto L9;
        r102.a(r101);
        return;
    }
}

package qsa;

import com.ss.android.bytedcert.ocr.OCRTakePhotoActivity;

/* JADX INFO: loaded from: classes34.dex */
public final class j extends usa.d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ OCRTakePhotoActivity f534706d;

    @Override // usa.d
    public final void a() {
        OCRTakePhotoActivity r100 = this.f534706d;
        if (r100.f407633n != 1) goto L5;
        r100.F1();
        return;
    L5:
        r100.runOnUiThread(new l(r100));
    }

    public j(OCRTakePhotoActivity r100) {
        this.f534706d = r100;
    }
}

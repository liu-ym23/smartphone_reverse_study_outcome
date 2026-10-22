package qsa;

import com.ss.android.bytedcert.manager.BytedCertManager;
import com.ss.android.bytedcert.ocr.OCRTakePhotoActivity;

/* JADX INFO: loaded from: classes34.dex */
public final class h extends usa.d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ OCRTakePhotoActivity f534704d;

    @Override // usa.d
    public final void a() {
        BytedCertManager.getInstance().mImgType = "from_album";
        OCRTakePhotoActivity r100 = this.f534704d;
        int r101 = OCRTakePhotoActivity.f407622r;
        r100.G1("from_album");
        p.d(this.f534704d, 2, BytedCertManager.getInstance().mPickCallbackImp, new g(this));
    }

    public h(OCRTakePhotoActivity r100) {
        this.f534704d = r100;
    }
}

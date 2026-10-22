package qsa;

import com.ss.android.bytedcert.callback.PhotoCallback;
import com.ss.android.bytedcert.ocr.OCRTakePhotoActivity;
import com.ss.android.cert.manager.utils.thread.BCThread;

/* JADX INFO: loaded from: classes34.dex */
public final class g implements PhotoCallback.ResultCallBack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f534703a;

    public g(h r100) {
        this.f534703a = r100;
    }

    @Override // com.ss.android.bytedcert.callback.PhotoCallback.ResultCallBack
    public final void onResult(String[] r100, int r101, String r102) {
        if (r101 != 0) goto L5;
        OCRTakePhotoActivity r103 = this.f534703a.f534704d;
        String r104 = r100[0];
        int r105 = OCRTakePhotoActivity.f407622r;
        r103.getClass();
        new BCThread(new m(r103, r104)).start();
        return;
    }
}

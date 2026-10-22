package qsa;

import android.view.View;
import com.ss.android.bytedcert.ocr.OCRManualActivity;
import com.ss.android.cert.manager.constants.ErrorConstant;

/* JADX INFO: loaded from: classes34.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OCRManualActivity f534700a;

    public d(OCRManualActivity r100) {
        this.f534700a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        OCRManualActivity r101 = this.f534700a;
        int r102 = ((Integer) ErrorConstant.Client.ERROR_FACE_LIVE_RETURN.first).intValue();
        int r103 = OCRManualActivity.f407603m;
        r101.G1(false, r102, null);
    }
}

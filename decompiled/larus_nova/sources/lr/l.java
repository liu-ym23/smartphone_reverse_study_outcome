package lr;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.common.api.feedback.IECFeedbackService;
import com.bytedance.android.ecom.service_annotation.ServiceDefaultImpl;

/* JADX INFO: loaded from: classes44.dex */
@ServiceDefaultImpl
public final class l implements IECFeedbackService {
    public l() {
    }

    @Override // com.bytedance.android.ec.common.api.feedback.IECFeedbackService
    public final void registerScreenCapture(Context r100, Fragment r101) {
    }

    @Override // com.bytedance.android.ec.common.api.feedback.IECFeedbackService
    public final void registerScreenCaptureForMall(Context r100, LifecycleOwner r101, Fragment r102) {
    }
}

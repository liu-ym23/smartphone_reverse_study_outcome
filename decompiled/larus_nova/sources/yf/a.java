package yf;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.common.api.feedback.IECFeedbackService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements IECFeedbackService {
    public a() {
    }

    @Override // com.bytedance.android.ec.common.api.feedback.IECFeedbackService
    public final void registerScreenCapture(Context r100, Fragment r101) {
    }

    @Override // com.bytedance.android.ec.common.api.feedback.IECFeedbackService
    public final void registerScreenCaptureForMall(Context r100, LifecycleOwner r101, Fragment r102) {
        Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
    }
}

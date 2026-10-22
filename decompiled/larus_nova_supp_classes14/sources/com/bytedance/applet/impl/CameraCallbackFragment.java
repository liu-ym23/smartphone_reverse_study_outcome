package com.bytedance.applet.impl;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import com.bytedance.ai.bridge.service.ChooseImageCallback;
import com.larus.camera.api.IFlowCamera;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/applet/impl/CameraCallbackFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "callback", "Lcom/bytedance/ai/bridge/service/ChooseImageCallback;", "flowCamera", "Lcom/larus/camera/api/IFlowCamera;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "removeSelf", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraCallbackFragment extends Fragment {
    public static ChooseImageCallback f;
    public static IFlowCamera g;
    public ChooseImageCallback d;
    public IFlowCamera e;

    public static final class a {
    }

    static {
    }

    public final void S90() {
        this.d = null;
        this.e = null;
        getParentFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
    }

    public CameraCallbackFragment() {
    }

    public final void onCreate(Bundle r36) {
        super.onCreate(r36);
        ChooseImageCallback r1 = f;
        this.d = r1;
        final IFlowCamera r2 = g;
        this.e = r2;
        f = null;
        g = null;
        if (r2 != null) goto L8;
        if (r1 == null) goto L6;
        r1.onFail("camera service not available");
    L6:
        S90();
        return;
    L8:
        r2.m(this, new e1(this), new f1(this));
        final hx8.a r3 = new hx8.a("applet_camera", "CAPTURE_MODE_PHOTO", null, null, null, null, null, null, null, null, false, false, false, null, false, 0, false, null, null, false, 0, null, false, false, false, null, null, null, null, 1073741820);
        new Handler(Looper.getMainLooper()).post(new g1(this, r2, r3));
    }
}

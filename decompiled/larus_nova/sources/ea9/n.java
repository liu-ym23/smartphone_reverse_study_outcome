package ea9;

import android.hardware.display.DisplayManager;
import com.larus.flow.capture.screen.ScreenCaptureService;

/* JADX INFO: loaded from: classes29.dex */
public final class n implements DisplayManager.DisplayListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScreenCaptureService f471731a;

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayAdded(int r100) {
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayRemoved(int r100) {
    }

    public n(ScreenCaptureService r100) {
        this.f471731a = r100;
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayChanged(int r100) {
        ScreenCaptureService r101 = this.f471731a;
        if (r101.f343435d == true) goto L5;
        return;
    L5:
        r101.e(false);
    }
}

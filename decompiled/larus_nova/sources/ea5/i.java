package ea5;

import android.widget.PopupWindow;
import com.bytedance.ee.bear.drive.view.preview.video.TTVideoView;

/* JADX INFO: loaded from: classes16.dex */
public final class i implements PopupWindow.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TTVideoView f471591a;

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        TTVideoView.C(this.f471591a);
    }

    public i(TTVideoView r100) {
        this.f471591a = r100;
    }
}

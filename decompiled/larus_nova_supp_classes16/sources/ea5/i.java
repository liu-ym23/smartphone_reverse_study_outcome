package ea5;

import android.widget.PopupWindow;
import com.bytedance.ee.bear.drive.view.preview.video.TTVideoView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i implements PopupWindow.OnDismissListener {
    public final /* synthetic */ TTVideoView a;

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        TTVideoView.C(this.a);
    }

    public i(TTVideoView r1) {
        this.a = r1;
    }
}

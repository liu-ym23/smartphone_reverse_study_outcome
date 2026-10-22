package vb4;

import android.graphics.Rect;
import android.view.ViewGroup;
import com.bytedance.bdturing.livedetect.TuringLiveDetectActivity;
import com.bytedance.bdturing.livedetect.view.LiveDetectMaskView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class r implements LiveDetectMaskView.b {
    public final /* synthetic */ TuringLiveDetectActivity a;

    public r(TuringLiveDetectActivity r1) {
        this.a = r1;
    }

    @Override // com.bytedance.bdturing.livedetect.view.LiveDetectMaskView.b
    public final void a(Rect r4) {
        ViewGroup.MarginLayoutParams r0 = (ViewGroup.MarginLayoutParams) this.a.b.getLayoutParams();
        r0.topMargin = r4.centerY() - (this.a.b.getMeasuredHeight() / 2);
        r0.leftMargin = r4.centerX() - (this.a.b.getMeasuredWidth() / 2);
        this.a.b.setLayoutParams(r0);
    }
}

package vb4;

import android.graphics.Rect;
import android.view.ViewGroup;
import com.bytedance.bdturing.livedetect.TuringLiveDetectActivity;
import com.bytedance.bdturing.livedetect.view.LiveDetectMaskView;

/* JADX INFO: loaded from: classes14.dex */
public final class r implements LiveDetectMaskView.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TuringLiveDetectActivity f554045a;

    public r(TuringLiveDetectActivity r100) {
        this.f554045a = r100;
    }

    @Override // com.bytedance.bdturing.livedetect.view.LiveDetectMaskView.b
    public final void a(Rect r100) {
        ViewGroup.MarginLayoutParams r101 = (ViewGroup.MarginLayoutParams) this.f554045a.f201824b.getLayoutParams();
        r101.topMargin = r100.centerY() - (this.f554045a.f201824b.getMeasuredHeight() / 2);
        r101.leftMargin = r100.centerX() - (this.f554045a.f201824b.getMeasuredWidth() / 2);
        this.f554045a.f201824b.setLayoutParams(r101);
    }
}

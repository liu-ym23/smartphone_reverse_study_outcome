package sp5;

import android.os.Handler;
import android.os.Message;
import com.bytedance.ee.bear.widgets.wheelview.view.WheelView;

/* JADX INFO: loaded from: classes18.dex */
public final class b extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WheelView f542878a;

    public b(WheelView r100) {
        this.f542878a = r100;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message r100) {
        int r101 = r100.what;
        if (r101 != 1000) goto L5;
        this.f542878a.invalidate();
        return;
    L5:
        if (r101 != 2000) goto L7;
        this.f542878a.f(WheelView.ACTION.FLING);
        return;
    L7:
        if (r101 != 3000) goto L18;
        WheelView r102 = this.f542878a;
        if (r102.f240432g == null) goto L15;
        r102.postDelayed(new com.bytedance.ee.bear.widgets.wheelview.view.a(r102), 200);
        return;
    L15:
        return;
    }
}

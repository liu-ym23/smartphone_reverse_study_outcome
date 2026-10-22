package sp5;

import android.os.Handler;
import android.os.Message;
import com.bytedance.ee.bear.widgets.wheelview.view.WheelView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b extends Handler {
    public final WheelView a;

    public b(WheelView r1) {
        this.a = r1;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message r4) {
        int r5 = r4.what;
        if (r5 != 1000) goto L5;
        this.a.invalidate();
        return;
    L5:
        if (r5 != 2000) goto L7;
        this.a.f(WheelView.ACTION.FLING);
        return;
    L7:
        if (r5 != 3000) goto L18;
        WheelView r6 = this.a;
        if (r6.g == null) goto L15;
        r6.postDelayed(new com.bytedance.ee.bear.widgets.wheelview.view.a(r6), 200);
        return;
    L15:
        return;
    }
}

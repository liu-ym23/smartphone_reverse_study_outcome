package g86;

import android.os.Handler;
import android.os.Message;
import com.bytedance.ies.xelement.picker.view.WheelView;
import h86.j;

/* JADX INFO: loaded from: classes19.dex */
public final class b extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WheelView f480405a;

    public b(WheelView r100) {
        this.f480405a = r100;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message r100) {
        int r101 = r100.what;
        if (r101 != 1000) goto L5;
        this.f480405a.invalidate();
        return;
    L5:
        if (r101 != 2000) goto L7;
        this.f480405a.f(WheelView.ACTION.FLING);
        return;
    L7:
        if (r101 != 3000) goto L18;
        WheelView r102 = this.f480405a;
        if (r102.f250237e == null) goto L15;
        r102.postDelayed(new j(r102), 200);
        return;
    L15:
        return;
    }
}

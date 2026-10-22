package l86;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.ies.xelement.pickview.view.WheelView;

/* JADX INFO: loaded from: classes19.dex */
public final class b extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WheelView f508050a;

    public b(WheelView r100) {
        super(Looper.getMainLooper());
        this.f508050a = r100;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message r100) {
        int r101 = r100.what;
        if (r101 != 1000) goto L5;
        this.f508050a.invalidate();
        return;
    L5:
        if (r101 != 2000) goto L7;
        this.f508050a.f(WheelView.ACTION.FLING);
        return;
    L7:
        if (r101 != 3000) goto L18;
        WheelView r102 = this.f508050a;
        if (r102.f250315e == null) goto L15;
        r102.f250322k0.postDelayed(new m86.a(r102), 200);
        return;
    L15:
        return;
    }
}

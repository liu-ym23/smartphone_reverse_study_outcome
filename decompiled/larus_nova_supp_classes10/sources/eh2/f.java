package eh2;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.livesdk.livecommerce.broadcast.bindcoupon.ui.ECBindCouponFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f implements View.OnTouchListener {
    public final /* synthetic */ ECBindCouponFragment a;

    public f(ECBindCouponFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r2, MotionEvent r3) {
        this.a.v.setVisibility(0);
        this.a.m.setVisibility(8);
        return false;
    }
}

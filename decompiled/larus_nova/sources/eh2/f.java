package eh2;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.livesdk.livecommerce.broadcast.bindcoupon.ui.ECBindCouponFragment;

/* JADX INFO: loaded from: classes10.dex */
public final class f implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECBindCouponFragment f472649a;

    public f(ECBindCouponFragment r100) {
        this.f472649a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        this.f472649a.f147668v.setVisibility(0);
        this.f472649a.f147659m.setVisibility(8);
        return false;
    }
}

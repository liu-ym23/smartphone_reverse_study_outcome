package vl2;

import android.content.Context;
import com.bytedance.android.live.multilink.impl.o1;
import com.bytedance.android.livesdk.commerce.coupon.LiveCouponPresenter;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j implements js0.b {
    public final /* synthetic */ Context a;
    public final /* synthetic */ int b;
    public final /* synthetic */ l.a c;
    public final /* synthetic */ l d;

    public final void onSuccess(String r5) {
        final Context r6 = this.a;
        final int r0 = this.b;
        Observable r7 = Observable.create(new d(r0, r6)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final int r1 = this.b;
        final l.a r2 = this.c;
        final Context r3 = this.a;
        r7.subscribe(new i(this, r1, r2, r3), new o1());
    }

    public j(l r1, Context r2, int r3, LiveCouponPresenter.c r4) {
        this.d = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}

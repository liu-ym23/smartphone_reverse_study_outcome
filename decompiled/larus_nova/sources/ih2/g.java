package ih2;

import android.content.DialogInterface;
import com.bytedance.android.livesdk.livecommerce.room.coupon.CouponGrowProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class g implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f489787a;

    public g(h r100) {
        this.f489787a = r100;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        CouponGrowProvider.f151736l.getClass();
        CouponGrowProvider r101 = CouponGrowProvider.f151730f;
        String r102 = this.f489787a.f489796i;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "roomId");
        r101.f151738b.remove(r102);
        CouponGrowProvider.Companion.a("cdow-" + this.f489787a.f489797j);
        h r103 = this.f489787a;
        if (r103.f489797j <= 0) goto L5;
        return;
    L5:
        if (r103.f489798k == true) goto L11;
        h.a r104 = r103.f489794g;
        if (r104 == null) goto L12;
        r104.onDismiss();
        return;
    L12:
        return;
    }
}

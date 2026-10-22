package ih2;

import android.content.DialogInterface;
import com.bytedance.android.livesdk.livecommerce.room.coupon.CouponGrowProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g implements DialogInterface.OnDismissListener {
    public final /* synthetic */ h a;

    public g(h r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r6) {
        CouponGrowProvider.l.getClass();
        CouponGrowProvider r7 = CouponGrowProvider.f;
        String r0 = this.a.i;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r0, "roomId");
        r7.b.remove(r0);
        CouponGrowProvider.Companion.a("cdow-" + this.a.j);
        h r8 = this.a;
        if (r8.j <= 0) goto L5;
        return;
    L5:
        if (r8.k == true) goto L11;
        h.a r9 = r8.g;
        if (r9 == null) goto L12;
        r9.onDismiss();
        return;
    L12:
        return;
    }
}

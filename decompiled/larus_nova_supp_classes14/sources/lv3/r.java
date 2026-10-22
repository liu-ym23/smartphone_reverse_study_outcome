package lv3;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.applet.aibridge.ecommerce.api.AbsOpenECommerceMethodIDL;
import com.bytedance.applet.aibridge.ecommerce.impl.OpenECommerceMethod;
import com.larus.common.apphost.AppHost;
import com.larus.platform.api.f2;
import com.larus.platform.api.l2;
import com.larus.platform.service.l0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class r implements f09.a.a {
    public final /* synthetic */ AbsOpenECommerceMethodIDL.a a;
    public final /* synthetic */ OpenECommerceMethod b;
    public final /* synthetic */ Fragment c;
    public final /* synthetic */ f3.h<AbsOpenECommerceMethodIDL.b> d;

    public final void onPaused(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    public final void onPreDestroyed(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    public final void onResumed(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    public final void onStart(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    public final void onStopped(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    public final void onCreate(final Activity r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "activity");
        if ((r10 instanceof FragmentActivity) == true) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r10.getClass().getName(), com.larus.platform.service.q.a.h()) == true) goto L8;
        return;
    L8:
        AppHost.a.a().f(this);
        final l2 r12 = l0.a();
        if (r12 == null) goto L15;
        FragmentActivity r1 = (FragmentActivity) r10;
        String r0 = this.a.getSource();
        if (r0 != null) goto L13;
        r0 = "";
    L13:
        uq9.d r8 = new uq9.d(r1, "ecommerce_product_detail_h5", r0, !f2.a.u(), false, true, 16);
        final OpenECommerceMethod r2 = this.b;
        final Fragment r3 = this.c;
        final AbsOpenECommerceMethodIDL.a r4 = this.a;
        final f3.h<AbsOpenECommerceMethodIDL.b> r6 = this.d;
        r12.e(r8, null, new q(r2, r10, r3, r4, r12, r6));
        return;
    }

    public r(AbsOpenECommerceMethodIDL.a r1, OpenECommerceMethod r2, Fragment r3, f3.h<AbsOpenECommerceMethodIDL.b> r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}

package ja3;

import android.net.Uri;
import com.bytedance.android.shopping.buynow.data.model.BuyNowShape;
import com.bytedance.android.shopping.extensions.k;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import nl.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final int a(c r1) {
        if (r1 == null) goto L4;
        String r2 = r1.getQueryParam("shape");
    L6:
        return k.r(r2, BuyNowShape.DEFAULT.getShape());
    L4:
        r2 = null;
        goto L6
    }

    @JvmStatic
    public static final boolean b(Uri r1) {
        if (r1 == null) goto L4;
        String r2 = r1.getHost();
    L6:
        return Intrinsics.areEqual(r2, "continue_pay");
    L4:
        r2 = null;
        goto L6
    }

    @JvmStatic
    public static final boolean c(c r3) {
        String r0 = null;
        if (r3 == null) goto L5;
        String r1 = r3.getQueryParam("useRifle");
    L7:
        if (Intrinsics.areEqual(r1, "1") == true) goto L9;
    L10:
        if (r3 == null) goto L13;
        r0 = r3.getQueryParam("type");
    L13:
        if (Intrinsics.areEqual(r0, "popup") == false) goto L15;
    L14:
        return true;
    L15:
        return false;
    L9:
        if (Intrinsics.areEqual(r3.getQueryParam("asPanel"), "1") == true) goto L14;
    L5:
        r1 = null;
        goto L7
    }

    @JvmStatic
    public static final boolean d(c r2) {
        if (r2 == null) goto L4;
        String r3 = r2.getQueryParam("shape");
    L5:
        int r4 = k.r(r3, 0);
        if (r4 != BuyNowShape.RECHARGE.getShape()) goto L8;
    L9:
        return true;
    L8:
        if (r4 == BuyNowShape.REFUEL.getShape()) goto L9;
        return false;
    L4:
        r3 = null;
        goto L5
    }
}

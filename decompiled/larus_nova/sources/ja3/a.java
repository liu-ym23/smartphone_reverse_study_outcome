package ja3;

import android.net.Uri;
import com.bytedance.android.shopping.buynow.data.model.BuyNowShape;
import com.bytedance.android.shopping.extensions.k;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import nl.c;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f497848a = 0;

    static {
    }

    @JvmStatic
    public static final int a(c r100) {
        if (r100 == null) goto L4;
        String r101 = r100.getQueryParam("shape");
    L6:
        return k.r(r101, BuyNowShape.DEFAULT.getShape());
    L4:
        r101 = null;
        goto L6
    }

    @JvmStatic
    public static final boolean b(Uri r100) {
        if (r100 == null) goto L4;
        String r101 = r100.getHost();
    L6:
        return Intrinsics.areEqual(r101, "continue_pay");
    L4:
        r101 = null;
        goto L6
    }

    @JvmStatic
    public static final boolean c(c r100) {
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.getQueryParam("useRifle");
    L7:
        if (Intrinsics.areEqual(r102, "1") == true) goto L9;
    L10:
        if (r100 == null) goto L13;
        r101 = r100.getQueryParam("type");
    L13:
        if (Intrinsics.areEqual(r101, "popup") == false) goto L15;
    L14:
        return true;
    L15:
        return false;
    L9:
        if (Intrinsics.areEqual(r100.getQueryParam("asPanel"), "1") == true) goto L14;
    L5:
        r102 = null;
        goto L7
    }

    @JvmStatic
    public static final boolean d(c r100) {
        if (r100 == null) goto L4;
        String r101 = r100.getQueryParam("shape");
    L5:
        int r102 = k.r(r101, 0);
        if (r102 != BuyNowShape.RECHARGE.getShape()) goto L8;
    L9:
        return true;
    L8:
        if (r102 == BuyNowShape.REFUEL.getShape()) goto L9;
        return false;
    L4:
        r101 = null;
        goto L5
    }
}

package xg3;

import android.app.Activity;
import com.bytedance.android.ec.core.anchorv3.PdpPerfOpt;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g {
    static {
    }

    public static void a(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        if (PdpPerfOpt.b().j() == false) goto L6;
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r2).a().a(2131560799, 1).commit();
        return;
    }
}

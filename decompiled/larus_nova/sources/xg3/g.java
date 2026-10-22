package xg3;

import android.app.Activity;
import com.bytedance.android.ec.core.anchorv3.PdpPerfOpt;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class g {
    static {
    }

    public static void a(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        if (PdpPerfOpt.b().j() == false) goto L6;
        ShoppingAsyncInflater.f45268e.getClass();
        ShoppingAsyncInflater.a.a(r100).a().a(R.layout.ec_pdp_loading_view, 1).commit();
        return;
    }
}

package ya3;

import android.content.Context;
import com.bytedance.android.ec.core.anchorv3.PdpPerfOpt;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.opt.asyncInflate.d;
import com.bytedance.android.shopping.anchorv4.nav.AnchorV4NavArea;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    static {
    }

    public static void a(Context r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (PdpPerfOpt.b().j() == false) goto L8;
        ShoppingAsyncInflater.e.getClass();
        d r3 = ShoppingAsyncInflater.a.a(r2).a();
        int r0 = AnchorV4NavArea.r;
        r3.a(2131560504, 1).a(2131560479, 1).a(2131564848, 1).a(2131564609, 1).a(2131564616, 1).commit();
        return;
    }
}

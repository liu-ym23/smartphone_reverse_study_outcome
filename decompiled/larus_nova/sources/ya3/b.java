package ya3;

import android.content.Context;
import com.bytedance.android.ec.core.anchorv3.PdpPerfOpt;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.opt.asyncInflate.d;
import com.bytedance.android.shopping.anchorv4.nav.AnchorV4NavArea;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes13.dex */
public final class b {
    static {
    }

    public static void a(Context r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (PdpPerfOpt.b().j() == false) goto L8;
        ShoppingAsyncInflater.f45268e.getClass();
        d r101 = ShoppingAsyncInflater.a.a(r100).a();
        int r102 = AnchorV4NavArea.f167069r;
        r101.a(R.layout.ec_commerce_anchor_v4_nav_area, 1).a(R.layout.ec_commerce_anchor_v4_bottom_button_layout, 1).a(R.layout.shopping_view_add_cart_dot_count, 1).a(R.layout.shopping_anchor_v4_long_conent_label_component, 1).a(R.layout.shopping_anchor_v4_replay_entry_layout, 1).commit();
        return;
    }
}

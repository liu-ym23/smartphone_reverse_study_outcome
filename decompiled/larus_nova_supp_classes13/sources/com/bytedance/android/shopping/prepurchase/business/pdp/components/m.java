package com.bytedance.android.shopping.prepurchase.business.pdp.components;

import android.view.View;
import com.bytedance.android.shopping.anchorv4.params.AnchorV4Param;
import com.bytedance.android.shopping.prepurchase.arch.container.component.Component;
import com.bytedance.android.shopping.prepurchase.business.pdp.repository.PdpDataStore;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public class m extends Component<com.bytedance.android.shopping.prepurchase.business.pdp.e, PdpDataStore> {
    public final AnchorV4Param g2() {
        return ((com.bytedance.android.shopping.prepurchase.business.pdp.e) O1().f().b).a;
    }

    public m() {
    }

    public final <T extends View> T f2(int r2) {
        return (T) e2().findViewById(r2);
    }
}

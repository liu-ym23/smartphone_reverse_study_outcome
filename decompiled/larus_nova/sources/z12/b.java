package z12;

import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.gift.platform.core.utils.u;
import com.bytedance.android.livesdk.gift.vs.tray.view.VSGiftTrayWidget;
import com.bytedance.ies.sdk.widgets.DataCenter;
import h12.g;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements g {
    public b() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h12.g
    public final VSGiftTrayWidget a(DataCenter r100) {
        boolean r101 = false;
        if (v.a() == false) goto L8;
        if (((Boolean) y12.a.f565620b.getValue(null, y12.a.f565619a[0])).booleanValue() == false) goto L8;
        r101 = true;
    L8:
        if (u.n() == false) goto L12;
        if (r101 == false) goto L11;
        return null;
    L11:
        return new VSGiftTrayWidget();
    L12:
        return null;
    }
}

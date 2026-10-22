package com.bytedance.android.livesdk.ktvimpl.base.skin;

import android.view.View;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.ies.sdk.widgets.Widget;
import jc1.k;
import vm2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ KtvDressWidget a;

    public a(KtvDressWidget r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        String r4 = (String) h.d2.getValue(null, h.a[158(0x9e, float:2.21E-43)]);
        k.n(IBaseLiveActionHandler.class).handle(((Widget) this.a).context, r4);
    }
}

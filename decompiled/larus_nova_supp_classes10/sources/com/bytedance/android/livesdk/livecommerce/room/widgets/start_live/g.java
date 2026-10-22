package com.bytedance.android.livesdk.livecommerce.room.widgets.start_live;

import android.content.DialogInterface;
import com.bytedance.android.livesdk.livecommerce.event.ECEventV3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g implements DialogInterface.OnClickListener {
    public static final g a = null;

    public static final class a extends ECEventV3 {
        public a() {
            super("livesdk_risk_popup_click");
        }
    }

    static {
        a = new g();
    }

    public g() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        new a().k();
        r1.dismiss();
    }
}

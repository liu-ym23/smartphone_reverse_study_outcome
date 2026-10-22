package com.bytedance.android.livesdk.livecommerce.room.widgets.start_live;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import com.bytedance.android.livesdk.livecommerce.event.ECEventV3;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i implements DialogInterface.OnClickListener {
    public final /* synthetic */ Context a;
    public final /* synthetic */ String b;

    public static final class a extends ECEventV3 {
        public a() {
            super("livesdk_ecom_anchor_popup_click");
        }
    }

    public i(Context r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r3, int r4) {
        String r5 = this.b;
        if (r5 != null) goto L5;
    L7:
        new a().k();
        r3.dismiss();
        return;
    L5:
        if ((!StringsKt.isBlank(r5)) != true) goto L7;
        Context r6 = this.a;
        String r0 = this.b;
        Handler r1 = com.bytedance.android.livesdk.livecommerce.utils.k.a;
        com.bytedance.android.livesdk.livecommerce.room.f.b(r6, r0);
        goto L7
    }
}

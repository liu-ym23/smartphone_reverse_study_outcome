package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy;

import android.view.View;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.shopping.anchorv4.bottom.EnterCartMeta;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class BottomButtonComponent$handleEnterCartWithMeta$1 implements df.h {
    public final /* synthetic */ BottomButtonComponent a;
    public final /* synthetic */ View b;
    public final /* synthetic */ EnterCartMeta c;
    public final /* synthetic */ EnterCartMeta d;

    public final void a() {
        final String r0 = BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder("a1.b8094.c7963.d3567", Boolean.FALSE).withView(this.b).build());
        this.a.f.d(new BottomButtonComponent$handleEnterCartWithMeta$1$logCallBack$1(this, r0));
    }

    public BottomButtonComponent$handleEnterCartWithMeta$1(BottomButtonComponent r1, View r2, EnterCartMeta r3, EnterCartMeta r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}

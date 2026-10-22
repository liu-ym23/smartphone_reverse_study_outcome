package p82;

import android.view.View;
import com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.enums.PanelItemSymbol;
import com.bytedance.android.livesdk.message.model.bd;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class r extends a {
    @Override // p82.a
    public final int e() {
        return R.layout.ttlive_ps_panel_item_open_microapp;
    }

    public r() {
        super(PanelItemSymbol.OPEN_MICROAPP_SYMBOL);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a
    public final boolean b(com.bytedance.android.livesdk.interactivity.api.entity.l r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        com.bytedance.android.live.base.model.message.t r101 = r100.f133174b;
        String r102 = null;
        if ((r101 instanceof bd) == true) goto L5;
        r101 = null;
    L5:
        bd r103 = (bd) r101;
        if (r103 == null) goto L8;
        com.bytedance.android.live.base.model.data.m r104 = r103.itemStyle;
    L10:
        if (com.bytedance.android.livesdk.interactivity.utils.s.a(r100) == false) goto L16;
        if (r104 == null) goto L14;
        r102 = r104.schema;
    L14:
        if (com.bytedance.android.livesdk.interactivity.utils.s.b(r102) == false) goto L16;
        return true;
    L16:
        return false;
    L8:
        r104 = null;
        goto L10
    }

    @Override // p82.a, com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a
    public final void onClick(View r100) {
        super.onClick(r100);
        com.bytedance.android.livesdk.interactivity.api.entity.l r101 = this.f528071b;
        com.bytedance.android.live.base.model.message.t r102 = null;
        if (r101 == null) goto L5;
        com.bytedance.android.live.base.model.message.t r103 = r101.f133174b;
    L7:
        if ((r103 instanceof bd) == false) goto L10;
        r102 = r103;
    L10:
        bd r104 = (bd) r102;
        if (r104 == null) goto L22;
        com.bytedance.android.live.base.model.data.m r105 = r104.itemStyle;
        if (r105 == null) goto L24;
        String r106 = r105.schema;
        if (com.bytedance.android.livesdk.interactivity.utils.s.b(r106) == false) goto L18;
        com.bytedance.android.livesdk.interactivity.utils.s.d(r106);
    L18:
        com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.e r107 = this.f528072c;
        if (r107 == null) goto L23;
        r107.dismissDialog();
        return;
    L23:
        return;
    L24:
        return;
    L22:
        return;
    L5:
        r103 = null;
        goto L7
    }
}

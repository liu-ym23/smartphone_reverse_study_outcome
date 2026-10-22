package com.bytedance.android.shopping.prepurchase.business.pdp.view;

import android.view.View;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerBlock;
import com.bytedance.android.shopping.anchorv4.dto.base.Link;
import com.bytedance.android.shopping.anchorv4.floatwidget.replay.PlayBackEntryVO;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ AnchorV4PlaybackAreaV2 a;
    public final /* synthetic */ n73.a b;
    public final /* synthetic */ PlayBackEntryVO c;
    public final /* synthetic */ l d;

    public a(AnchorV4PlaybackAreaV2 r1, n73.a r2, PlayBackEntryVO r3, com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.d r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        if (z53.b.a(1234, 1000) == false) goto L5;
        return;
    L5:
        n73.a r6 = this.b;
        String r0 = null;
        if (r6 == null) goto L17;
        LinkedHashMap r1 = new LinkedHashMap();
        if (this.c.showNewStylePlayBackEntry(Boolean.valueOf(this.d.isFullScreen())) == false) goto L16;
        PlayerBlock r2 = this.a.f;
        if (r2 == null) goto L14;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r3 = r2.getVideoModel();
        if (r3 == null) goto L14;
        String r4 = r3.j();
    L15:
        r1.put("video_id", r4);
    L14:
        r4 = null;
    L16:
        Unit r7 = Unit.INSTANCE;
        r6.b(r1);
    L17:
        Integer r8 = this.c.getInitState();
        if (r8 != null) goto L21;
    L25:
        Link r9 = this.c.getReplayLink();
        String r10 = "a1.b8094.c5958.d6302";
        if (r9 == null) goto L28;
        String r11 = r9.getLinkUrl();
    L29:
        l r12 = this.d;
        if (r11 == null) goto L32;
        r0 = com.bytedance.android.ec.core.btm.c.c(r11, this.a, r10, new Pair[0]);
    L32:
        r12.openSchema(r0);
        return;
    L28:
        r11 = null;
        goto L29
    L21:
        if (r8.intValue() != 1) goto L25;
        Link r13 = this.c.getLivingLink();
        r10 = "a1.b8094.c5958.d61744";
        if (r13 == null) goto L28;
        r11 = r13.getLinkUrl();
        goto L29
    }
}

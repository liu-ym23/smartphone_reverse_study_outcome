package com.bytedance.android.shopping.order;

import android.view.View;
import com.bytedance.android.shopping.anchorv3.detail.widget.VideoHolder;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerBlock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ PreviewPanelFragment a;

    public c(PreviewPanelFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        VideoHolder r4 = this.a.m;
        if (r4 == null) goto L7;
        PlayerBlock r5 = r4.g;
        if (r5 == null) goto L7;
        Boolean r6 = Boolean.valueOf(r5.isPlaying());
    L9:
        if (Intrinsics.areEqual(r6, Boolean.TRUE) == false) goto L15;
        VideoHolder r7 = this.a.m;
        if (r7 == null) goto L31;
        PlayerBlock r8 = r7.g;
        if (r8 == null) goto L32;
        int r0 = PlayerBlock.T;
        r8.C(false);
        return;
    L32:
        return;
    L31:
        return;
    L15:
        PreviewPanelFragment r9 = this.a;
        float r1 = r9.p;
        VideoHolder r10 = r9.m;
        if (r10 == null) goto L25;
        l53.a r11 = r10.g;
        if (r11 == null) goto L25;
        vg3.c r2 = ((PlayerBlock) r11).t;
        if (r2 == null) goto L22;
        r2.a(r11);
    L22:
        gj.b r12 = ((PlayerBlock) r11).f;
        if (r12 == null) goto L25;
        r12.play();
    L25:
        VideoHolder r13 = this.a.m;
        if (r13 == null) goto L34;
        PlayerBlock r14 = r13.g;
        if (r14 == null) goto L35;
        r14.J(r1);
        return;
    L35:
        return;
    L34:
        return;
    L7:
        r6 = null;
        goto L9
    }
}

package com.bytedance.android.shopping.anchorv4.voavhs.head.holder;

import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerBlock;
import com.bytedance.android.shopping.anchorv4.voavhs.head.view.AnchorV4VideoView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class u implements com.bytedance.android.shopping.anchorv4.voavhs.head.smallmode.b {
    public final /* synthetic */ AnchorV4VideoView a;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.smallmode.b
    public final void b() {
        PlayerBlock r0 = this.a.d;
        if (r0 == null) goto L6;
        int r1 = PlayerBlock.T;
        r0.F(true);
        return;
    }

    public u(AnchorV4VideoView r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.smallmode.b
    public final void c(float r5) {
        PlayerBlock r0 = this.a.d;
        if (r0 == null) goto L28;
        Function1 r1 = r0.s;
        if (r1 == null) goto L8;
        Unit r2 = (Unit) r1.invoke(Boolean.valueOf(r0.isPlaying()));
    L8:
        if (r0.isPlaying() == false) goto L16;
        if (r0.j == false) goto L12;
        r0.x();
        r0.E();
    L26:
        r0.J(r5);
        return;
    L12:
        Function0 r3 = r0.i;
        if (r3 == null) goto L26;
        Unit r4 = (Unit) r3.invoke();
        goto L26
    L16:
        if (r0.m == false) goto L25;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.k r6 = r0.D;
        if (r6 == null) goto L22;
        com.bytedance.android.shopping.anchorv4.video.f r7 = ((com.bytedance.android.shopping.anchorv4.video.d) r6).d;
        if (r7 == null) goto L22;
        boolean r8 = r7.h(r6);
    L23:
        if (r8 == false) goto L25;
        PlayerBlock.o(r0, false, 2);
    L22:
        r8 = false;
    L25:
        r0.j();
        PlayerBlock.z(r0, false, false, null, 7);
        goto L26
    }
}

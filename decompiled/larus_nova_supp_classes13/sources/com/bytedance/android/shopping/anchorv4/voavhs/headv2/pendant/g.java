package com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderNAPendantConfig;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderNAPendantStyleConfigModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderPendantModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderPendantNative;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.Padding;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g extends f {
    public static final int e = 0;
    public static final int f = 0;
    public static final int g = 0;
    public final c c;
    public final s d;

    public static final class a {
    }

    static {
        e = com.bytedance.android.shopping.extensions.b.a(20);
        f = com.bytedance.android.shopping.extensions.b.a(24);
        g = com.bytedance.android.shopping.extensions.b.a(12);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.f, com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.b
    public final void o() {
        this.c.b();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.f, com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.b
    public final void a(boolean r2) {
        this.c.a(r2);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.f
    public final void b(HeaderPendantNative r2) {
        this.c.g(r2);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.f, com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.b
    public final void c(boolean r2) {
        this.c.c(r2);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.f
    public final /* bridge */ /* synthetic */ void g(Object r1) {
        b((HeaderPendantNative) r1);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.f, com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.b
    public final void onPageSelected(int r2) {
        this.c.onPageSelected(r2);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.f, com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.b
    public final void d(boolean r2, int r3) {
        this.c.d(r2, r3);
    }

    public g(Context r8, s r9, HeaderPendantModel r10) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "headAbility");
        Intrinsics.checkNotNullParameter(r10, "pendantModel");
        super(r10);
        this.d = r9;
        HeaderPendantNative r11 = this.a.getNative();
        if (r11 != null) goto L5;
    L45:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.a r12 = new com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.a(r8, r9);
        FrameLayout.LayoutParams r13 = new FrameLayout.LayoutParams(-2, e);
        r13.gravity = 8388693;
        r13.rightMargin = g;
        if (com.bytedance.android.shopping.anchorv4.video.float.e.b() == false) goto L48;
        int r1 = com.bytedance.android.shopping.extensions.b.a(28);
    L49:
        r13.bottomMargin = r1 - com.bytedance.android.shopping.extensions.b.b(12);
        Unit r0 = Unit.INSTANCE;
        r12.setLayoutParams(r13);
        r9.j(r12);
        c r14 = r12;
    L50:
        this.c = r14;
        return;
    L48:
        r1 = f;
        goto L49
    L5:
        if (r11.getNewStyle() != true) goto L45;
        HeaderNAPendantStyleConfigModel r15 = this.a.getNative().getStyleConfig();
        Integer r4 = null;
        if (r15 == null) goto L9;
        HeaderNAPendantConfig r16 = r15.getContainer();
    L10:
        if (r16 == null) goto L14;
        Double r5 = r16.getHeight();
        if (r5 == null) goto L14;
        Integer r6 = Integer.valueOf(com.bytedance.android.shopping.extensions.b.a(r5));
    L15:
        if (r16 == null) goto L21;
        Padding r7 = r16.getMargin();
        if (r7 == null) goto L21;
        Long r17 = r7.getRight();
        if (r17 == null) goto L21;
        Integer r18 = Integer.valueOf(com.bytedance.android.shopping.extensions.b.a(r17));
    L22:
        if (r16 == null) goto L28;
        Padding r19 = r16.getMargin();
        if (r19 == null) goto L28;
        Long r110 = r19.getBottom();
        if (r110 == null) goto L28;
        r4 = Integer.valueOf(com.bytedance.android.shopping.extensions.b.a(r110));
    L28:
        CenterShowTabIndicatorLayout r111 = new CenterShowTabIndicatorLayout(r8, r9);
        if (r6 == null) goto L31;
        int r20 = r6.intValue();
    L32:
        FrameLayout.LayoutParams r21 = new FrameLayout.LayoutParams(-2, r20);
        r21.gravity = 8388693;
        if (r18 == null) goto L35;
        int r2 = r18.intValue();
    L36:
        r21.rightMargin = r2;
        if (r4 == null) goto L40;
        int r3 = r4.intValue();
    L44:
        r21.bottomMargin = r3;
        Unit r22 = Unit.INSTANCE;
        r111.setLayoutParams(r21);
        r9.j(r111);
        r14 = r111;
        goto L50
    L40:
        if (com.bytedance.android.shopping.anchorv4.video.float.e.b() == false) goto L42;
        int r23 = com.bytedance.android.shopping.extensions.b.a(28);
    L43:
        r3 = r23 - com.bytedance.android.shopping.extensions.b.b(12);
        goto L44
    L42:
        r23 = f;
        goto L43
    L35:
        r2 = g;
        goto L36
    L31:
        r20 = e;
    L21:
        r18 = null;
    L14:
        r6 = null;
        goto L15
    L9:
        r16 = null;
        goto L10
    }
}

package zr2;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3;
import com.bytedance.android.livesdk.revenue.toolbar.RevToolbarButton;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes11.dex */
public final class o implements c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final vh6.d<c0.b> f573398b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x3 f573399a;

    public static final class a {
    }

    static {
        f573398b = new vh6.d(Reflection.getOrCreateKotlinClass(c0.b.class));
    }

    public o(x3 r100) {
        Intrinsics.checkNotNullParameter(r100, "original");
        this.f573399a = r100;
    }

    public static ExtendedToolbarButton g(RevToolbarButton r100) {
        switch(p.f573400a[r100.ordinal()]) {
            case 1: goto L21;
            case 2: goto L35;
            case 3: goto L34;
            case 4: goto L33;
            case 5: goto L32;
            case 6: goto L31;
            case 7: goto L30;
            case 8: goto L29;
            case 9: goto L28;
            case 10: goto L27;
            case 11: goto L26;
            case 12: goto L25;
            case 13: goto L24;
            case 14: goto L23;
            case 15: goto L22;
            default: goto L5;
        };
    L5:
        throw new NoWhenBranchMatchedException();
    L22:
        return ToolbarButton.ATTACK_AND_DEFENSE.extended();
    L23:
        return ToolbarButton.TREASURE_BOX.extended();
    L24:
        return ToolbarButton.INTERACT_GIFT.extended();
    L25:
        return ToolbarButton.CASH_EXCHANGE.extended();
    L26:
        return ToolbarButton.INTERACTION.extended();
    L27:
        return ToolbarButton.GIFT_EFFECT.extended();
    L28:
        return ToolbarButton.GIFT_ANIMATION.extended();
    L29:
        return ToolbarButton.BROADCAST_GIFT.extended();
    L30:
        return ToolbarButton.MORE.extended();
    L31:
        return ToolbarButton.FAST_GIFT.extended();
    L32:
        return ToolbarButton.GIFT.extended();
    L33:
        return ToolbarButton.LOTTERY.extended();
    L34:
        return ToolbarButton.INTERACT_GAME.extended();
    L35:
        return ToolbarButton.VOTE.extended();
    L21:
        return ToolbarButton.PK.extended();
    }

    @Override // zr2.c
    public final void b(RevToolbarButton r100) {
        Intrinsics.checkNotNullParameter(r100, "toolbarButton");
        this.f573399a.c(g(r100));
    }

    @Override // zr2.c
    public final void d(RevToolbarButton r100) {
        Intrinsics.checkNotNullParameter(r100, "toolbarButton");
        this.f573399a.i(g(r100));
    }

    @Override // zr2.c
    public final boolean f(RevToolbarButton r100) {
        Intrinsics.checkNotNullParameter(r100, "button");
        return this.f573399a.y(g(r100));
    }

    @Override // zr2.c
    public final void a(RevToolbarButton r110, n r111) {
        Intrinsics.checkNotNullParameter(r110, "button");
        Intrinsics.checkNotNullParameter(r111, "command");
        ExtendedToolbarButton r100 = g(r110);
        if ((r100 instanceof ExtendedToolbarButton.b) == true) goto L5;
        r100 = null;
    L5:
        ExtendedToolbarButton.b r101 = (ExtendedToolbarButton.b) r100;
        if (r101 != null) goto L8;
        return;
    L8:
        x3 r102 = this.f573399a;
        ToolbarButton r103 = r101.f115626i;
        Intrinsics.checkNotNullParameter(r111, "$this$asLiveType");
        if ((r111 instanceof e) == false) goto L12;
        e r104 = (e) r111;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r105 = new pp1.c(r104.f573369a, r104.f573370b, r104.f573371c, r104.f573372d, r104.f573373e, r104.f573374f, r104.f573375g, r104.f573376h, r104.f573377i, r104.f573378j, 7168);
    L29:
        r102.b(r103, r105);
        return;
    L12:
        if ((r111 instanceof f) == false) goto L15;
        r105 = new pp1.d(((f) r111).f573383a);
        goto L29
    L15:
        if ((r111 instanceof i) == false) goto L18;
        r105 = new pp1.j(((i) r111).f573388a);
        goto L29
    L18:
        if ((r111 instanceof j) == false) goto L21;
        r105 = new pp1.k();
        goto L29
    L21:
        if ((r111 instanceof q) == false) goto L24;
        r105 = new pp1.l();
        goto L29
    L24:
        if ((r111 instanceof r) == false) goto L27;
        r105 = new pp1.m(((r) r111).f573402a);
        goto L29
    L27:
        if ((r111 instanceof g) == false) goto L32;
        r105 = new pp1.e();
        goto L29
    L32:
        throw new NoWhenBranchMatchedException();
    }

    @Override // zr2.c
    public final void c(RevToolbarButton r100, k r101) {
        Intrinsics.checkNotNullParameter(r100, "button");
        Intrinsics.checkNotNullParameter(r101, "behavior");
        ExtendedToolbarButton r102 = g(r100);
        com.bytedance.android.live.revenue.core.util.l r103 = r101.f573391a;
        vh6.d<c0.b> r104 = f573398b;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "key");
        Object r105 = r103.f91040a.get(r104);
        if (r105 != null) goto L6;
        r105 = null;
    L6:
        c0.b r106 = (c0.b) r105;
        if (r106 != null) goto L11;
        r106 = new m(r101);
        com.bytedance.android.live.revenue.core.util.l r107 = r101.f573391a;
        r107.getClass();
        Intrinsics.checkNotNullParameter(r104, "key");
        Intrinsics.checkNotNullParameter(r106, "value");
        r107.f91040a.put(r104, r106);
    L11:
        if (this.f573399a.s(r102) != r106) goto L14;
        this.f573399a.f(r102, r106);
        return;
    }

    @Override // zr2.c
    public final void e(RevToolbarButton r100, k r101) {
        Intrinsics.checkNotNullParameter(r100, "button");
        Intrinsics.checkNotNullParameter(r101, "behavior");
        x3 r102 = this.f573399a;
        ExtendedToolbarButton r103 = g(r100);
        com.bytedance.android.live.revenue.core.util.l r104 = r101.f573391a;
        vh6.d<c0.b> r105 = f573398b;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r105, "key");
        Object r106 = r104.f91040a.get(r105);
        if (r106 != null) goto L6;
        r106 = null;
    L6:
        c0.b r107 = (c0.b) r106;
        if (r107 != null) goto L10;
        r107 = new m(r101);
        com.bytedance.android.live.revenue.core.util.l r108 = r101.f573391a;
        r108.getClass();
        Intrinsics.checkNotNullParameter(r105, "key");
        Intrinsics.checkNotNullParameter(r107, "value");
        r108.f91040a.put(r105, r107);
    L10:
        r102.p(r103, r107);
    }
}

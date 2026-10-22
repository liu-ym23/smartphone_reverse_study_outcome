package com.larksuite.component.universe_design.compose.foundation;

import androidx.compose.ui.graphics.ColorKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes24.dex */
public final class UDColorSchemeKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f284682a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f284683b = null;

    static {
        f284682a = LazyKt.lazy(UDColorSchemeKt$lightUDColorScheme$2.INSTANCE);
        f284683b = LazyKt.lazy(UDColorSchemeKt$darkUDColorScheme$2.INSTANCE);
    }

    public static final f0 a(e0 r110) {
        long r100 = r110.f284701a.f284692a;
        s r101 = new s();
        k r102 = new k();
        long r103 = r110.f284705e.f284707a;
        z r104 = new z();
        long r105 = r110.f284702b.f284752a;
        o0 r106 = new o0();
        long r107 = r110.f284703c.f284757a;
        f r108 = new f();
        o r111 = r110.f284704d;
        long r109 = r111.f284740a;
        return new f0(r101, r102, r104, r106, r108, new p(r111.f284748i));
    }

    public static final h0 b(e0 r210, d0 r310, boolean r311) {
        long r110 = ColorKt.Color(BodyPartID.bodyIdMax);
        c r100 = r210.f284701a;
        long r101 = r100.f284692a;
        long r102 = r100.f284693b;
        long r103 = r100.f284694c;
        long r111 = r100.f284695d;
        if (r311 == true) goto L6;
        r103 = r111;
    L6:
        if (r311 == false) goto L8;
        long r112 = r102;
    L9:
        if (r311 == false) goto L11;
        long r104 = r310.f284698c.f284760b;
    L12:
        if (r311 == false) goto L14;
        long r105 = r310.f284698c.f284761c;
    L15:
        if (r311 == false) goto L17;
        long r106 = r310.f284698c.f284762d;
    L18:
        r r107 = new r(r110, r103, r112);
        ColorKt.Color(BodyPartID.bodyIdMax);
        g r108 = r210.f284705e;
        long r109 = r108.f284707a;
        long r113 = r108.f284708b;
        long r114 = r310.f284698c.f284764f;
        y r115 = new y(r113, r109);
        ColorKt.Color(BodyPartID.bodyIdMax);
        v r116 = r210.f284703c;
        long r117 = r116.f284757a;
        long r118 = r116.f284758b;
        long r119 = r310.f284698c.f284763e;
        e r120 = new e(r118, r117);
        ColorKt.Color(BodyPartID.bodyIdMax);
        q r121 = r210.f284702b;
        long r122 = r121.f284752a;
        long r123 = r121.f284753b;
        long r124 = r310.f284698c.f284765g;
        n0 r125 = new n0(r123, r122);
        ColorKt.Color(BodyPartID.bodyIdMax);
        c r126 = r210.f284701a;
        long r127 = r126.f284692a;
        long r128 = r126.f284695d;
        long r129 = r310.f284698c.f284766h;
        j r130 = new j(r128, r127);
        o r131 = r210.f284704d;
        b0 r132 = new b0(r131.f284750k, r131.f284748i, r131.f284747h, r131.f284746g);
        if (r311 == false) goto L21;
        long r133 = r310.f284696a.f284734d;
    L22:
        long r134 = r133;
        if (r311 == false) goto L25;
        long r135 = r310.f284696a.f284733c;
    L26:
        long r211 = r135;
        if (r311 == false) goto L29;
        long r136 = r310.f284696a.f284733c;
    L30:
        long r212 = r136;
        if (r311 == false) goto L33;
        ColorKt.Color(4278190080L);
    L34:
        m r137 = new m(r134, r211, r212);
        ColorKt.Color(2365587456L);
        ColorKt.Color(2566914048L);
        if (r311 == false) goto L37;
        long r138 = r210.f284704d.f284740a;
    L38:
        if (r311 == false) goto L40;
        long r139 = r210.f284704d.f284741b;
    L41:
        long r140 = r139;
        if (r311 == false) goto L44;
        long r141 = r210.f284704d.f284742c;
    L45:
        o r142 = r210.f284704d;
        long r143 = r142.f284743d;
        if (r311 == false) goto L48;
        long r144 = r142.f284742c;
    L49:
        long r213 = r144;
        long r145 = r210.f284701a.f284693b;
        if (r311 == false) goto L52;
        ColorKt.Color(4280690214L);
    L52:
        if (r311 == false) goto L54;
        long r146 = 4279374354L;
    L55:
        ColorKt.Color(r146);
        if (r311 == false) goto L58;
        long r147 = r310.f284696a.f284735e;
    L59:
        long r148 = r310.f284697b.f284687a;
        if (r311 == false) goto L62;
        long r149 = r310.f284696a.f284736f;
    L63:
        a r150 = new a(r140, r213, r149);
        ColorKt.Color(BodyPartID.bodyIdMax);
        ColorKt.Color(452984831);
        ColorKt.Color(872415231);
        ColorKt.Color(4278190080L);
        ColorKt.Color(2365587456L);
        return new h0(r107, r115, r120, r125, r130, r132, r137, r150, new x());
    L62:
        r149 = r210.f284704d.f284740a;
        goto L63
    L58:
        long r151 = r310.f284696a.f284737g;
        goto L59
    L54:
        r146 = 4294507002L;
        goto L55
    L48:
        r144 = r142.f284740a;
        goto L49
    L44:
        long r152 = r210.f284704d.f284741b;
        goto L45
    L40:
        r139 = r210.f284704d.f284740a;
        goto L41
    L37:
        long r153 = r210.f284704d.f284742c;
        goto L38
    L33:
        long r154 = r310.f284696a.f284733c;
        goto L34
    L29:
        r136 = r131.f284745f;
        goto L30
    L25:
        r135 = r131.f284744e;
        goto L26
    L21:
        r133 = r310.f284696a.f284733c;
        goto L22
    L17:
        long r155 = r310.f284698c.f284761c;
        goto L18
    L14:
        long r156 = r310.f284698c.f284760b;
        goto L15
    L11:
        long r157 = r310.f284698c.f284759a;
        goto L12
    L8:
        r112 = r111;
        goto L9
    }
}

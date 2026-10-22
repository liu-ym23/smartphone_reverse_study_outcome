package com.ss.android.lark.compose.foundation;

import androidx.compose.ui.graphics.ColorKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes35.dex */
public final class UDColorSchemeKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f417566a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f417567b = null;

    static {
        f417566a = LazyKt.lazy(UDColorSchemeKt$lightUDColorScheme$2.INSTANCE);
        f417567b = LazyKt.lazy(UDColorSchemeKt$darkUDColorScheme$2.INSTANCE);
    }

    public static final n0 a(m0 r110) {
        long r100 = r110.f417609a.f417569a;
        a0 r101 = new a0();
        s r102 = new s();
        long r103 = r110.f417613e.f417614a;
        h0 r104 = new h0();
        long r105 = r110.f417610b.f417686a;
        v0 r106 = new v0();
        long r107 = r110.f417611c.f417571a;
        l r108 = new l();
        long r109 = r110.f417612d.f417670a;
        return new n0(r101, r102, r104, r106, r108, new x());
    }

    public static final p0 b(m0 r110, l0 r111, boolean r112) {
        ColorKt.Color(BodyPartID.bodyIdMax);
        long r100 = r110.f417609a.f417569a;
        if (r112 == false) goto L5;
        long r101 = r111.f417602c.f417574b;
    L6:
        if (r112 == false) goto L8;
        long r102 = r111.f417602c.f417575c;
    L9:
        if (r112 == false) goto L11;
        long r103 = r111.f417602c.f417576d;
    L12:
        z r104 = new z();
        ColorKt.Color(BodyPartID.bodyIdMax);
        long r105 = r110.f417613e.f417614a;
        long r106 = r111.f417602c.f417578f;
        g0 r107 = new g0();
        ColorKt.Color(BodyPartID.bodyIdMax);
        long r108 = r110.f417611c.f417571a;
        long r109 = r111.f417602c.f417577e;
        k r113 = new k();
        ColorKt.Color(BodyPartID.bodyIdMax);
        long r114 = r110.f417610b.f417686a;
        long r115 = r111.f417602c.f417579g;
        u0 r116 = new u0();
        ColorKt.Color(BodyPartID.bodyIdMax);
        long r117 = r110.f417609a.f417569a;
        long r118 = r111.f417602c.f417580h;
        r r119 = new r();
        long r120 = r110.f417612d.f417672c;
        j0 r121 = new j0();
        long r122 = r111.f417600a.f417668a;
        u r123 = new u();
        ColorKt.Color(2365587456L);
        long r124 = r110.f417612d.f417671b;
        long r125 = r110.f417609a.f417570b;
        ColorKt.Color(4294507002L);
        long r126 = r111.f417600a.f417669b;
        long r127 = r111.f417601b.f417568a;
        a r128 = new a();
        ColorKt.Color(BodyPartID.bodyIdMax);
        ColorKt.Color(452984831);
        ColorKt.Color(872415231);
        ColorKt.Color(4278190080L);
        ColorKt.Color(2365587456L);
        return new p0(r104, r107, r113, r116, r119, r121, r123, r128, new f0());
    L11:
        long r129 = r111.f417602c.f417575c;
        goto L12
    L8:
        long r130 = r111.f417602c.f417574b;
        goto L9
    L5:
        long r131 = r111.f417602c.f417573a;
        goto L6
    }
}

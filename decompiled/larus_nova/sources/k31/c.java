package k31;

import androidx.camera.video.AudioStats;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revlink.impl.multianchor.constants.GravityDef;
import com.bytedance.android.live.revlink.impl.multianchor.ui.UILayout;
import com.bytedance.android.livesdk.model.RevSeiRegion;
import com.bytedance.android.livesdk.model.m0;
import com.bytedance.android.livesdk.model.n0;
import com.bytedance.android.livesdk.model.p0;
import com.bytedance.android.livesdk.model.q0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f501636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f501637b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f501638c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f501639d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f501640e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f501641f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L18;
        c r101 = (c) r100;
        if (this.f501636a == r101.f501636a) goto L8;
        return false;
    L8:
        if (this.f501637b == r101.f501637b) goto L10;
        return false;
    L10:
        if (this.f501638c == r101.f501638c) goto L12;
        return false;
    L12:
        if (this.f501639d == r101.f501639d) goto L14;
        return false;
    L14:
        if (this.f501640e == r101.f501640e) goto L16;
        return false;
    L16:
        if (this.f501641f == r101.f501641f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public final int hashCode() {
        int r100 = ((((((this.f501636a * 31) + this.f501637b) * 31) + this.f501638c) * 31) + this.f501639d) * 31;
        boolean r101 = this.f501640e;
        ?? r102 = r101;
        if (r101 == false) goto L6;
        r102 = 1;
    L6:
        return ((r100 + r102) * 31) + this.f501641f;
    }

    public final String toString() {
        return "width = " + this.f501636a + ", height = " + this.f501637b + ", topMargin = " + this.f501638c + ", leftMargin = " + this.f501639d;
    }

    public final h a(f r210) {
        Intrinsics.checkNotNullParameter(r210, "seiCache");
        i.a r100 = i.f501655g;
        int r101 = this.f501636a;
        int r102 = this.f501637b;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r210, "seiCache");
        n0 r103 = r210.f501645a;
        p0 r104 = r210.f501646b;
        if (r104 == null) goto L31;
        List<RevSeiRegion> r105 = r104.e();
        if (r105 == null) goto L31;
        if (r103 != null) goto L20;
        double r106 = n11.a.d(r105);
        double r110 = n11.a.a(r105);
        if (r106 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L31;
        if (r110 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L31;
        int r107 = (int) (((double) r101) / r106);
        int r108 = (int) (((double) r102) / r110);
        double r109 = n11.a.d(r105);
        double r111 = n11.a.a(r105);
        if (r109 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L31;
        if (r111 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L31;
        double r112 = r107;
        double r113 = r108;
        i r114 = new i(r107, r108, (int) (n11.a.b(r105) * r112), (int) (n11.a.c(r105) * r113), (int) (r109 * r112), (int) (r113 * r111));
    L32:
        if (r114 != null) goto L36;
        return null;
    L36:
        if (this.f501640e == false) goto L53;
        b03.a r115 = b03.a.f16857a;
        int r116 = s1.w() - s1.A();
        if (b03.a.a() == false) goto L42;
        int r117 = this.f501641f;
        if (r117 == 0) goto L42;
        int r118 = r117;
    L43:
        int r119 = (r118 * 9) / 16;
        p0 r120 = r210.f501646b;
        if (r120 == null) goto L48;
        q0 r121 = r120.getCanvas();
        if (r121 == null) goto L48;
        r119 = (r121.b() * r118) / r121.a();
    L48:
        int r122 = r119;
        GravityDef r123 = GravityDef.LEFT;
        int r124 = (s1.y() - r122) / 2;
        if (r122 <= s1.y()) goto L52;
        r123 = GravityDef.RIGHT;
        r124 = s1.y() - r122;
    L52:
        return new h(r122, r118, 0, r124, r123);
    L42:
        r118 = r116;
        goto L43
    L53:
        p0 r125 = r210.f501646b;
        if (r125 == null) goto L71;
        m0 r126 = r125.f();
        if (r126 == null) goto L71;
        Intrinsics.checkNotNullParameter(r126, "$this$toLayoutType");
        if (r126.e() == 1) goto L60;
    L62:
        int r127 = r126.c();
    L64:
        if (r127 != UILayout.FULL_RECORD.ordinal()) goto L71;
        b03.a r128 = b03.a.f16857a;
        int r129 = s1.w();
        int r130 = (r129 * 9) / 16;
        int r131 = (s1.y() - r130) / 2;
        if (r130 <= s1.y()) goto L69;
        r131 = s1.y() - r130;
    L69:
        return new h(r130, r129, 0, r131, GravityDef.CENTER_HORIZONTAL);
    L60:
        if (r126.c() != UILayout.FULL.ordinal()) goto L62;
        r127 = UILayout.FULL_RECORD.ordinal();
    L71:
        return new h(r114.f501656a, r114.f501657b, this.f501638c - r114.f501659d, this.f501639d - r114.f501658c, GravityDef.LEFT_TOP);
    L20:
        double r132 = n11.a.d(r105);
        double r133 = n11.a.a(r105);
        if (r132 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L31;
        if (r133 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L31;
        int r134 = (int) (((((double) r101) / r132) * ((double) r103.f())) / ((double) r103.b()));
        int r135 = (int) (((((double) r102) / r133) * ((double) r103.e())) / ((double) r103.a()));
        double r136 = n11.a.d(r105);
        double r137 = n11.a.a(r105);
        if (r136 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L31;
        if (r137 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L31;
        float r138 = r134;
        int r139 = (int) ((r103.b() * r138) / r103.f());
        float r140 = r135;
        int r141 = (int) ((r103.a() * r140) / r103.e());
        int r142 = (int) ((r138 * r103.c()) / r103.f());
        double r143 = r142;
        double r144 = r139;
        double r145 = r141;
        r114 = new i(r134, r135, (int) (r143 + (n11.a.b(r105) * r144)), (int) (((double) ((int) ((r140 * r103.d()) / r103.e()))) + (n11.a.c(r105) * r145)), (int) (r136 * r144), (int) (r145 * r137));
    L31:
        r114 = null;
        goto L32
    }

    public c(int r100, int r101, int r102, int r103) {
        this.f501636a = r100;
        this.f501637b = r101;
        this.f501638c = r102;
        this.f501639d = r103;
        this.f501640e = false;
        this.f501641f = 0;
    }
}

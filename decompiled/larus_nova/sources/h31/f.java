package h31;

import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.impl.pk.utils.l;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.h9;
import com.bytedance.android.livesdk.link.model.v0;
import com.bytedance.android.livesdk.link.model.w2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PkBaseDataContext.PKModType f483688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f483689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f483690c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f483691d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final i f483692e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f483693f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final w2 f483694g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final h9 f483695h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final v0 f483696i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final h f483697j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f483698k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final l f483699l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final IBattleConfigSetting f483700m;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L32;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f483688a, r101.f483688a) == true) goto L8;
        return false;
    L8:
        if (this.f483689b == r101.f483689b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f483690c, r101.f483690c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f483691d, r101.f483691d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f483692e, r101.f483692e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f483693f, r101.f483693f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f483694g, r101.f483694g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f483695h, r101.f483695h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f483696i, r101.f483696i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f483697j, r101.f483697j) == true) goto L26;
        return false;
    L26:
        if (this.f483698k == r101.f483698k) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f483699l, r101.f483699l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f483700m, r101.f483700m) == true) goto L49;
        return false;
    L49:
        return true;
    L32:
        return false;
    }

    public final int hashCode() {
        PkBaseDataContext.PKModType r100 = this.f483688a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.f483689b;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        d r105 = this.f483690c;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        e r108 = this.f483691d;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        i r111 = this.f483692e;
        if (r111 == null) goto L17;
        int r112 = r111.hashCode();
    L18:
        int r113 = (r110 + r112) * 31;
        c r114 = this.f483693f;
        if (r114 == null) goto L21;
        int r115 = r114.hashCode();
    L22:
        int r116 = (r113 + r115) * 31;
        w2 r117 = this.f483694g;
        if (r117 == null) goto L25;
        int r118 = r117.hashCode();
    L26:
        int r119 = (r116 + r118) * 31;
        h9 r120 = this.f483695h;
        if (r120 == null) goto L29;
        int r121 = r120.hashCode();
    L30:
        int r122 = (r119 + r121) * 31;
        v0 r123 = this.f483696i;
        if (r123 == null) goto L33;
        int r124 = r123.hashCode();
    L34:
        int r125 = (r122 + r124) * 31;
        h r126 = this.f483697j;
        if (r126 == null) goto L37;
        int r127 = r126.hashCode();
    L38:
        int r128 = (r125 + r127) * 31;
        long r129 = this.f483698k;
        int r130 = (r128 + ((int) (r129 ^ (r129 >>> 32)))) * 31;
        l r131 = this.f483699l;
        if (r131 == null) goto L41;
        int r132 = r131.hashCode();
    L42:
        int r133 = (r130 + r132) * 31;
        IBattleConfigSetting r134 = this.f483700m;
        if (r134 == null) goto L46;
        r101 = r134.hashCode();
    L46:
        return r133 + r101;
    L41:
        r132 = 0;
        goto L42
    L37:
        r127 = 0;
        goto L38
    L33:
        r124 = 0;
        goto L34
    L29:
        r121 = 0;
        goto L30
    L25:
        r118 = 0;
        goto L26
    L21:
        r115 = 0;
        goto L22
    L17:
        r112 = 0;
        goto L18
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "MultiBattleDataContext(type=" + this.f483688a + ", duration=" + this.f483689b + ", firstPkData=" + this.f483690c + ", inviteData=" + this.f483691d + ", voteOpenData=" + this.f483692e + ", customPKData=" + this.f483693f + ", shellConfig=" + this.f483694g + ", specifyGiftConfig=" + this.f483695h + ", cloudCollaborateConfig=" + this.f483696i + ", multiPlayMode=" + this.f483697j + ", decideDuration=" + this.f483698k + ", pageSource=" + this.f483699l + ", battleConfigSetting=" + this.f483700m + ")";
    }

    public final PkBaseDataContext.PKModType getType() {
        return this.f483688a;
    }

    public f(PkBaseDataContext.PKModType r110, long r111, d r112, e r113, i r114, c r115, w2 r116, h9 r117, h r118, long r210, l r211, IBattleConfigSetting r212, int r213) {
        if ((r213 & 128) == 0) goto L5;
        h9 r100 = null;
    L7:
        if ((r213 & 4096) == 0) goto L9;
        IBattleConfigSetting r101 = null;
    L10:
        Intrinsics.checkNotNullParameter(r110, "type");
        Intrinsics.checkNotNullParameter(r118, "multiPlayMode");
        Intrinsics.checkNotNullParameter(r211, "pageSource");
        this.f483688a = r110;
        this.f483689b = r111;
        this.f483690c = r112;
        this.f483691d = r113;
        this.f483692e = r114;
        this.f483693f = r115;
        this.f483694g = r116;
        this.f483695h = r100;
        this.f483696i = null;
        this.f483697j = r118;
        this.f483698k = r210;
        this.f483699l = r211;
        this.f483700m = r101;
        return;
    L9:
        r101 = r212;
        goto L10
    L5:
        r100 = r117;
        goto L7
    }
}

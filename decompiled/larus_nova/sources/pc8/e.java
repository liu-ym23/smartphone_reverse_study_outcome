package pc8;

import com.larus.bmhome.chat.bubble.floating.BubbleBannerDismissReason;
import com.larus.bmhome.chat.bubble.floating.BubbleBannerEnterTrigger;
import com.larus.bmhome.chat.bubble.floating.BubbleBannerState;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f528576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f528577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BubbleBannerState f528578c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f528579d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f528580e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f528581f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f528582g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f528583h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final BubbleBannerDismissReason f528584i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final i f528585j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final b f528586k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Set<BubbleBannerEnterTrigger> f528587l;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f528576a, r101.f528576a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f528577b, r101.f528577b) == true) goto L15;
        return false;
    L15:
        if (this.f528578c == r101.f528578c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f528579d, r101.f528579d) == true) goto L21;
        return false;
    L21:
        if (this.f528580e == r101.f528580e) goto L24;
        return false;
    L24:
        if (this.f528581f == r101.f528581f) goto L27;
        return false;
    L27:
        if (this.f528582g == r101.f528582g) goto L30;
        return false;
    L30:
        if (this.f528583h == r101.f528583h) goto L33;
        return false;
    L33:
        if (this.f528584i == r101.f528584i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f528585j, r101.f528585j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f528586k, r101.f528586k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f528587l, r101.f528587l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f528576a.hashCode() * 31) + this.f528577b.hashCode()) * 31) + this.f528578c.hashCode()) * 31;
        f r101 = this.f528579d;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        long r104 = this.f528580e;
        int r105 = (((r100 + r103) * 31) + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        int r106 = 1231;
        if (this.f528581f == false) goto L9;
        int r107 = 1231;
    L10:
        int r108 = (r105 + r107) * 31;
        if (this.f528582g == false) goto L13;
        int r109 = 1231;
    L14:
        int r110 = (r108 + r109) * 31;
        if (this.f528583h == true) goto L18;
        r106 = 1237;
    L18:
        int r111 = (r110 + r106) * 31;
        BubbleBannerDismissReason r112 = this.f528584i;
        if (r112 != null) goto L21;
        int r113 = 0;
    L22:
        int r114 = (r111 + r113) * 31;
        i r115 = this.f528585j;
        if (r115 != null) goto L25;
        int r116 = 0;
    L26:
        int r117 = (r114 + r116) * 31;
        b r118 = this.f528586k;
        if (r118 == null) goto L31;
        r102 = r118.hashCode();
    L31:
        return ((r117 + r102) * 31) + this.f528587l.hashCode();
    L25:
        r116 = r115.hashCode();
        goto L26
    L21:
        r113 = r112.hashCode();
        goto L22
    L13:
        r109 = 1237;
        goto L14
    L9:
        r107 = 1237;
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "BubbleBannerModel(promptId=" + this.f528576a + ", input=" + this.f528577b + ", state=" + this.f528578c + ", renderPlan=" + this.f528579d + ", autoDismissAt=" + this.f528580e + ", autoDismissIgnored=" + this.f528581f + ", enterAnimationConsumed=" + this.f528582g + ", hasShownOnScreen=" + this.f528583h + ", dismissReason=" + this.f528584i + ", transition=" + this.f528585j + ", exitCompletion=" + this.f528586k + ", readyEnterTriggers=" + this.f528587l + ')';
    }

    public final String b() {
        f r100 = this.f528579d;
        if (r100 == null) goto L6;
        String r101 = r100.f528589a;
        if (r101 == null) goto L6;
        return r101;
    L6:
        String r102 = g.a(this.f528577b);
        if (r102 != null) goto L11;
        return "";
    L11:
        return r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(String r100, d r101, BubbleBannerState r102, f r103, long r104, boolean r105, boolean r106, boolean r110, BubbleBannerDismissReason r111, i r112, b r113, Set<? extends BubbleBannerEnterTrigger> r114) {
        Intrinsics.checkNotNullParameter(r100, "promptId");
        Intrinsics.checkNotNullParameter(r101, "input");
        Intrinsics.checkNotNullParameter(r102, "state");
        Intrinsics.checkNotNullParameter(r114, "readyEnterTriggers");
        this.f528576a = r100;
        this.f528577b = r101;
        this.f528578c = r102;
        this.f528579d = r103;
        this.f528580e = r104;
        this.f528581f = r105;
        this.f528582g = r106;
        this.f528583h = r110;
        this.f528584i = r111;
        this.f528585j = r112;
        this.f528586k = r113;
        this.f528587l = r114;
    }

    public static e a(e r110, BubbleBannerState r111, f r210, long r211, boolean r212, boolean r213, boolean r214, BubbleBannerDismissReason r215, i r216, b r217, Set r218, int r310) {
        d r100 = null;
        if ((r310 & 1) == 0) goto L5;
        String r101 = r110.f528576a;
    L7:
        if ((r310 & 2) == 0) goto L9;
        r100 = r110.f528577b;
    L9:
        d r102 = r100;
        if ((r310 & 4) == 0) goto L12;
        BubbleBannerState r103 = r110.f528578c;
    L14:
        if ((r310 & 8) == 0) goto L16;
        f r104 = r110.f528579d;
    L18:
        if ((r310 & 16) == 0) goto L20;
        long r105 = r110.f528580e;
    L22:
        if ((r310 & 32) == 0) goto L24;
        boolean r112 = r110.f528581f;
    L26:
        if ((r310 & 64) == 0) goto L28;
        boolean r113 = r110.f528582g;
    L30:
        if ((r310 & 128) == 0) goto L32;
        boolean r114 = r110.f528583h;
    L34:
        if ((r310 & 256) == 0) goto L36;
        BubbleBannerDismissReason r115 = r110.f528584i;
    L38:
        if ((r310 & 512) == 0) goto L40;
        i r116 = r110.f528585j;
    L42:
        if ((r310 & 1024) == 0) goto L44;
        b r117 = r110.f528586k;
    L46:
        if ((r310 & 2048) == 0) goto L48;
        Set r106 = r110.f528587l;
    L49:
        Intrinsics.checkNotNullParameter(r101, "promptId");
        Intrinsics.checkNotNullParameter(r102, "input");
        Intrinsics.checkNotNullParameter(r103, "state");
        Intrinsics.checkNotNullParameter(r106, "readyEnterTriggers");
        return new e(r101, r102, r103, r104, r105, r112, r113, r114, r115, r116, r117, r106);
    L48:
        r106 = r218;
        goto L49
    L44:
        r117 = r217;
        goto L46
    L40:
        r116 = r216;
        goto L42
    L36:
        r115 = r215;
        goto L38
    L32:
        r114 = r214;
        goto L34
    L28:
        r113 = r213;
        goto L30
    L24:
        r112 = r212;
        goto L26
    L20:
        r105 = r211;
        goto L22
    L16:
        r104 = r210;
        goto L18
    L12:
        r103 = r111;
        goto L14
    L5:
        r101 = null;
        goto L7
    }
}

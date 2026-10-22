package w72;

import com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.o;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f558489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Long> f558490b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Long> f558491c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, o> f558492d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Long> f558493e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, o> f558494f;

    public b() {
        this(false, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L18;
        b r101 = (b) r100;
        if (this.f558489a == r101.f558489a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f558490b, r101.f558490b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f558491c, r101.f558491c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f558492d, r101.f558492d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f558493e, r101.f558493e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f558494f, r101.f558494f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    public final int hashCode() {
        boolean r100 = this.f558489a;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        Map<String, Long> r103 = this.f558490b;
        int r104 = 0;
        if (r103 == null) goto L8;
        int r105 = r103.hashCode();
    L9:
        int r106 = (r102 + r105) * 31;
        Map<String, Long> r107 = this.f558491c;
        if (r107 == null) goto L12;
        int r108 = r107.hashCode();
    L13:
        int r109 = (r106 + r108) * 31;
        Map<String, o> r110 = this.f558492d;
        if (r110 == null) goto L16;
        int r111 = r110.hashCode();
    L17:
        int r112 = (r109 + r111) * 31;
        Map<String, Long> r113 = this.f558493e;
        if (r113 == null) goto L20;
        int r114 = r113.hashCode();
    L21:
        int r115 = (r112 + r114) * 31;
        Map<String, o> r116 = this.f558494f;
        if (r116 == null) goto L25;
        r104 = r116.hashCode();
    L25:
        return r115 + r104;
    L20:
        r114 = 0;
        goto L21
    L16:
        r111 = 0;
        goto L17
    L12:
        r108 = 0;
        goto L13
    L8:
        r105 = 0;
        goto L9
    }

    public final String toString() {
        return "FrequencyConfig(forAnchor=" + this.f558489a + ", maxWaitingTime=" + this.f558490b + ", maxTimesForScene=" + this.f558491c + ", timeGapConfigForScene=" + this.f558492d + ", maxTimesForType=" + this.f558493e + ", timesGapConfigForType=" + this.f558494f + ")";
    }

    public b(boolean r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = false;
    L5:
        HashMap r102 = null;
        if ((r101 & 2) == 0) goto L8;
        HashMap r103 = new HashMap();
    L10:
        if ((r101 & 4) == 0) goto L12;
        HashMap r104 = new HashMap();
    L14:
        if ((r101 & 8) == 0) goto L16;
        HashMap r105 = new HashMap();
    L18:
        if ((r101 & 16) == 0) goto L20;
        HashMap r106 = new HashMap();
    L22:
        if ((r101 & 32) == 0) goto L24;
        r102 = new HashMap();
    L24:
        Intrinsics.checkNotNullParameter(r103, "maxWaitingTime");
        Intrinsics.checkNotNullParameter(r104, "maxTimesForScene");
        Intrinsics.checkNotNullParameter(r105, "timeGapConfigForScene");
        Intrinsics.checkNotNullParameter(r106, "maxTimesForType");
        Intrinsics.checkNotNullParameter(r102, "timesGapConfigForType");
        this.f558489a = r100;
        this.f558490b = r103;
        this.f558491c = r104;
        this.f558492d = r105;
        this.f558493e = r106;
        this.f558494f = r102;
        return;
    L20:
        r106 = null;
        goto L22
    L16:
        r105 = null;
        goto L18
    L12:
        r104 = null;
        goto L14
    L8:
        r103 = null;
        goto L10
    }
}

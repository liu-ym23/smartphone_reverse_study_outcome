package eq2;

import com.bytedance.android.live.liveinteract.videotalk.emoji.model.s;
import com.bytedance.android.livesdk.gift.model.h2;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f473459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f473460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f473461c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f473462d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f473463e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f473464f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f473465g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f473466h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f473467i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f473468j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final h2 f473469k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f473470l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final s f473471m;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L32;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f473459a, r101.f473459a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f473460b, r101.f473460b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f473461c, r101.f473461c) == true) goto L12;
        return false;
    L12:
        if (this.f473462d == r101.f473462d) goto L14;
        return false;
    L14:
        if (this.f473463e == r101.f473463e) goto L16;
        return false;
    L16:
        if (this.f473464f == r101.f473464f) goto L18;
        return false;
    L18:
        if (this.f473465g == r101.f473465g) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f473466h, r101.f473466h) == true) goto L22;
        return false;
    L22:
        if (this.f473467i == r101.f473467i) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f473468j, r101.f473468j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f473469k, r101.f473469k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f473470l, r101.f473470l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f473471m, r101.f473471m) == true) goto L49;
        return false;
    L49:
        return true;
    L32:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v8, types: [int] */
    public final int hashCode() {
        String r100 = this.f473459a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f473460b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.f473461c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (((r106 + r108) * 31) + this.f473462d) * 31;
        boolean r110 = this.f473463e;
        ?? r111 = r110;
        if (r110 == false) goto L17;
        r111 = 1;
    L17:
        int r112 = (r109 + r111) * 31;
        long r113 = this.f473464f;
        int r114 = (((r112 + ((int) (r113 ^ (r113 >>> 32)))) * 31) + this.f473465g) * 31;
        String r115 = this.f473466h;
        if (r115 == null) goto L20;
        int r116 = r115.hashCode();
    L21:
        int r117 = (r114 + r116) * 31;
        long r118 = this.f473467i;
        int r119 = (r117 + ((int) (r118 ^ (r118 >>> 32)))) * 31;
        String r120 = this.f473468j;
        if (r120 == null) goto L24;
        int r121 = r120.hashCode();
    L25:
        int r122 = (r119 + r121) * 31;
        h2 r123 = this.f473469k;
        if (r123 == null) goto L28;
        int r124 = r123.hashCode();
    L29:
        int r125 = (r122 + r124) * 31;
        String r126 = this.f473470l;
        if (r126 == null) goto L32;
        int r127 = r126.hashCode();
    L33:
        int r128 = (r125 + r127) * 31;
        s r129 = this.f473471m;
        if (r129 == null) goto L37;
        r101 = r129.hashCode();
    L37:
        return r128 + r101;
    L32:
        r127 = 0;
        goto L33
    L28:
        r124 = 0;
        goto L29
    L24:
        r121 = 0;
        goto L25
    L20:
        r116 = 0;
        goto L21
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "id:" + this.f473459a + ",type:" + this.f473462d + ",isFirst:" + this.f473463e;
    }

    public c(String r100, String r101, List<String> r102, int r103, boolean r104, long r110, int r111, String r112, long r113, String r114, h2 r115, String r116, s r117) {
        Intrinsics.checkNotNullParameter(r100, "animationId");
        Intrinsics.checkNotNullParameter(r102, "receiverUids");
        this.f473459a = r100;
        this.f473460b = r101;
        this.f473461c = r102;
        this.f473462d = r103;
        this.f473463e = r104;
        this.f473464f = r110;
        this.f473465g = r111;
        this.f473466h = r112;
        this.f473467i = r113;
        this.f473468j = r114;
        this.f473469k = r115;
        this.f473470l = r116;
        this.f473471m = r117;
    }
}

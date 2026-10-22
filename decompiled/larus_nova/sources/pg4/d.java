package pg4;

import com.bytedance.component.lyric_v2.util.LyricType;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LyricType f529195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Integer> f529196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f529197c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f529198d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f529199e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<String> f529200f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f529201g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f529202h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f529203i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f529204j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f529205k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f529206l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f529207m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f529208n;

    public d() {
        this(null, 0, 0, null, null, null, 16383);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L34;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f529195a, r101.f529195a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f529196b, r101.f529196b) == true) goto L10;
        return false;
    L10:
        if (this.f529197c == r101.f529197c) goto L12;
        return false;
    L12:
        if (this.f529198d == r101.f529198d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f529199e, r101.f529199e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f529200f, r101.f529200f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f529201g, r101.f529201g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f529202h, r101.f529202h) == true) goto L22;
        return false;
    L22:
        if (this.f529203i == r101.f529203i) goto L24;
        return false;
    L24:
        if (this.f529204j == r101.f529204j) goto L26;
        return false;
    L26:
        if (this.f529205k == r101.f529205k) goto L28;
        return false;
    L28:
        if (this.f529206l == r101.f529206l) goto L30;
        return false;
    L30:
        if (this.f529207m == r101.f529207m) goto L32;
        return false;
    L32:
        if (this.f529208n == r101.f529208n) goto L52;
        return false;
    L52:
        return true;
    L34:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v20, types: [int] */
    /* JADX WARN: Type inference failed for: r0v22, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v17 */
    public final int hashCode() {
        LyricType r100 = this.f529195a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<Integer> r104 = this.f529196b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((((r103 + r105) * 31) + this.f529197c) * 31) + this.f529198d) * 31;
        Integer r107 = this.f529199e;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<String> r110 = this.f529200f;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f529201g;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f529202h;
        if (r116 == null) goto L25;
        r101 = r116.hashCode();
    L25:
        int r117 = (((r115 + r101) * 31) + this.f529203i) * 31;
        boolean r118 = this.f529204j;
        ?? r119 = 1;
        ?? r120 = r118;
        if (r118 == false) goto L28;
        r120 = 1;
    L28:
        int r121 = (r117 + r120) * 31;
        boolean r122 = this.f529205k;
        if (r122 == true) goto L33;
        r119 = r122;
    L33:
        return ((((((r121 + r119) * 31) + this.f529206l) * 31) + this.f529207m) * 31) + this.f529208n;
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
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
        return "LyricsLineInfo(lyricType=" + this.f529195a + ", wordsDisInterval=" + this.f529196b + ", startTime=" + this.f529197c + ", endTime=" + this.f529198d + ", realEndTime=" + this.f529199e + ", lyricsWords=" + this.f529200f + ", lineLyrics=" + this.f529201g + ", lineOriginLyrics=" + this.f529202h + ", lineDuration=" + this.f529203i + ", isInterludeStart=" + this.f529204j + ", isInterludeEnd=" + this.f529205k + ", interludeStartTime=" + this.f529206l + ", interludeEndTime=" + this.f529207m + ", interludeDuration=" + this.f529208n + ")";
    }

    public /* synthetic */ d(List r110, int r111, int r210, Integer r211, List r212, String r213, int r214) {
        if ((r214 & 1) == 0) goto L5;
        LyricType r100 = LyricType.KRC;
    L7:
        if ((r214 & 2) == 0) goto L9;
        List r101 = null;
    L11:
        if ((r214 & 4) == 0) goto L13;
        int r102 = 0;
    L15:
        if ((r214 & 8) == 0) goto L17;
        int r103 = 0;
    L19:
        if ((r214 & 16) == 0) goto L21;
        Integer r104 = null;
    L23:
        if ((r214 & 32) == 0) goto L25;
        List r105 = null;
    L27:
        if ((r214 & 64) == 0) goto L29;
        String r106 = null;
    L30:
        this(r100, r101, r102, r103, r104, r105, r106, null, 0, false, false, 0, 0, 0);
        return;
    L29:
        r106 = r213;
        goto L30
    L25:
        r105 = r212;
        goto L27
    L21:
        r104 = r211;
        goto L23
    L17:
        r103 = r210;
        goto L19
    L13:
        r102 = r111;
        goto L15
    L9:
        r101 = r110;
        goto L11
    L5:
        r100 = null;
        goto L7
    }

    public static d a(d r110, List r210, int r211, int r212, Integer r213, List r214, String r215, boolean r216, boolean r217, int r218, int r219, int r310, int r311) {
        String r100 = null;
        if ((r311 & 1) == 0) goto L5;
        LyricType r101 = r110.f529195a;
    L7:
        if ((r311 & 2) == 0) goto L9;
        List r102 = r110.f529196b;
    L11:
        if ((r311 & 4) == 0) goto L13;
        int r103 = r110.f529197c;
    L15:
        if ((r311 & 8) == 0) goto L17;
        int r104 = r110.f529198d;
    L19:
        if ((r311 & 16) == 0) goto L21;
        Integer r105 = r110.f529199e;
    L23:
        if ((r311 & 32) == 0) goto L25;
        List r111 = r110.f529200f;
    L27:
        if ((r311 & 64) == 0) goto L29;
        String r112 = r110.f529201g;
    L31:
        if ((r311 & 128) == 0) goto L33;
        r100 = r110.f529202h;
    L33:
        String r113 = r100;
        if ((r311 & 256) == 0) goto L36;
        int r114 = r110.f529203i;
    L38:
        if ((r311 & 512) == 0) goto L40;
        boolean r115 = r110.f529204j;
    L42:
        if ((r311 & 1024) == 0) goto L44;
        boolean r116 = r110.f529205k;
    L46:
        if ((r311 & 2048) == 0) goto L48;
        int r117 = r110.f529206l;
    L50:
        if ((r311 & 4096) == 0) goto L52;
        int r118 = r110.f529207m;
    L54:
        if ((r311 & 8192) == 0) goto L56;
        int r119 = r110.f529208n;
    L57:
        Intrinsics.checkNotNullParameter(r101, "lyricType");
        return new d(r101, r102, r103, r104, r105, r111, r112, r113, r114, r115, r116, r117, r118, r119);
    L56:
        r119 = r310;
        goto L57
    L52:
        r118 = r219;
        goto L54
    L48:
        r117 = r218;
        goto L50
    L44:
        r116 = r217;
        goto L46
    L40:
        r115 = r216;
        goto L42
    L36:
        r114 = 0;
        goto L38
    L29:
        r112 = r215;
        goto L31
    L25:
        r111 = r214;
        goto L27
    L21:
        r105 = r213;
        goto L23
    L17:
        r104 = r212;
        goto L19
    L13:
        r103 = r211;
        goto L15
    L9:
        r102 = r210;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public d(LyricType r100, List<Integer> r101, int r102, int r103, Integer r104, List<String> r105, String r106, String r107, int r110, boolean r111, boolean r112, int r113, int r114, int r115) {
        Intrinsics.checkNotNullParameter(r100, "lyricType");
        this.f529195a = r100;
        this.f529196b = r101;
        this.f529197c = r102;
        this.f529198d = r103;
        this.f529199e = r104;
        this.f529200f = r105;
        this.f529201g = r106;
        this.f529202h = r107;
        this.f529203i = r110;
        this.f529204j = r111;
        this.f529205k = r112;
        this.f529206l = r113;
        this.f529207m = r114;
        this.f529208n = r115;
    }
}

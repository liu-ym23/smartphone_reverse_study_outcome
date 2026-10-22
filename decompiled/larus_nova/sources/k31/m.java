package k31;

import android.view.View;
import com.bytedance.android.livesdkapi.depend.model.live.ILiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import kotlin.jvm.internal.Intrinsics;
import rc0.q;

/* JADX INFO: loaded from: classes47.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f501669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f501670b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f501671c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f501672d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f501673e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ILiveMode f501674f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f501675g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final f f501676h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final q f501677i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final k f501678j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final a f501679k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f501680l;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof m) == false) goto L30;
        m r101 = (m) r100;
        if (this.f501669a == r101.f501669a) goto L8;
        return false;
    L8:
        if (this.f501670b == r101.f501670b) goto L10;
        return false;
    L10:
        if (this.f501671c == r101.f501671c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f501672d, r101.f501672d) == true) goto L14;
        return false;
    L14:
        if (this.f501673e == r101.f501673e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f501674f, r101.f501674f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f501675g, r101.f501675g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f501676h, r101.f501676h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f501677i, r101.f501677i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f501678j, r101.f501678j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f501679k, r101.f501679k) == true) goto L28;
        return false;
    L28:
        if (this.f501680l == r101.f501680l) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v22, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final int hashCode() {
        int r100 = ((this.f501669a * 31) + this.f501670b) * 31;
        boolean r101 = this.f501671c;
        ?? r102 = 1;
        ?? r103 = r101;
        if (r101 == false) goto L5;
        r103 = 1;
    L5:
        int r104 = (r100 + r103) * 31;
        View r105 = this.f501672d;
        int r106 = 0;
        if (r105 == null) goto L8;
        int r107 = r105.hashCode();
    L9:
        int r108 = (r104 + r107) * 31;
        boolean r109 = this.f501673e;
        ?? r110 = r109;
        if (r109 == false) goto L12;
        r110 = 1;
    L12:
        int r111 = (r108 + r110) * 31;
        ILiveMode r112 = this.f501674f;
        if (r112 == null) goto L15;
        int r113 = r112.hashCode();
    L16:
        int r114 = (r111 + r113) * 31;
        String r115 = this.f501675g;
        if (r115 == null) goto L19;
        int r116 = r115.hashCode();
    L20:
        int r117 = (r114 + r116) * 31;
        f r118 = this.f501676h;
        if (r118 == null) goto L23;
        int r119 = r118.hashCode();
    L24:
        int r120 = (r117 + r119) * 31;
        q r121 = this.f501677i;
        if (r121 == null) goto L27;
        int r122 = r121.hashCode();
    L28:
        int r123 = (r120 + r122) * 31;
        k r124 = this.f501678j;
        if (r124 == null) goto L31;
        int r125 = r124.hashCode();
    L32:
        int r126 = (r123 + r125) * 31;
        a r127 = this.f501679k;
        if (r127 == null) goto L35;
        r106 = r127.hashCode();
    L35:
        int r128 = (r126 + r106) * 31;
        boolean r129 = this.f501680l;
        if (r129 == true) goto L40;
        r102 = r129;
    L40:
        return r128 + r102;
    L31:
        r125 = 0;
        goto L32
    L27:
        r122 = 0;
        goto L28
    L23:
        r119 = 0;
        goto L24
    L19:
        r116 = 0;
        goto L20
    L15:
        r113 = 0;
        goto L16
    L8:
        r107 = 0;
        goto L9
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("[containerWidth = ");
        r100.append(this.f501669a);
        r100.append(", containerHeight = ");
        r100.append(this.f501670b);
        r100.append(", isFullScreen = ");
        r100.append(this.f501671c);
        r100.append(", isPortrait = ");
        r100.append(this.f501673e);
        r100.append(", seiRaw = ");
        r100.append(this.f501675g);
        r100.append(", statusBarOption = ");
        r100.append(this.f501678j);
        r100.append(", componentsOption = ");
        a r101 = this.f501679k;
        String r102 = null;
        if (r101 == null) goto L8;
        Intrinsics.checkNotNullParameter(r101, "$this$formatString");
        StringBuilder r103 = new StringBuilder("pkProgressBarOption = ");
        g r104 = r101.f501634a;
        if (r104 == null) goto L7;
        Intrinsics.checkNotNullParameter(r104, "$this$formatString");
        r102 = "PkProgressBarOption(transForPkBar=" + r104.f501648a + ", pkBarHeight=" + r104.f501649b + ')';
    L7:
        r103.append(r102);
        r102 = r103.toString();
    L8:
        r100.append(r102);
        r100.append(']');
        return r100.toString();
    }

    public m(int r100, int r101, boolean r102, View r103, boolean r104, LiveMode r105, String r106, q r107, k r110, a r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r103, "playerView");
        Intrinsics.checkNotNullParameter(r105, "liveMode");
        Intrinsics.checkNotNullParameter(r110, "statusBarOption");
        this.f501669a = r100;
        this.f501670b = r101;
        this.f501671c = r102;
        this.f501672d = r103;
        this.f501673e = r104;
        this.f501674f = r105;
        this.f501675g = r106;
        this.f501676h = null;
        this.f501677i = r107;
        this.f501678j = r110;
        this.f501679k = r111;
        this.f501680l = r112;
    }
}

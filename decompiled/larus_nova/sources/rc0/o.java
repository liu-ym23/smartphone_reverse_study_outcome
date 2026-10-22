package rc0;

import android.content.Context;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<c, Unit> f537050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f537051b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f537052c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f537053d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final IRoom f537054e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f537055f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f537056g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f537057h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f537058i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f537059j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final LiveMode f537060k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Context f537061l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public g f537062m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final a f537063n;

    public o() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof o) == false) goto L36;
        o r101 = (o) r100;
        r101.getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f537050a, r101.f537050a) == true) goto L10;
        return false;
    L10:
        if (this.f537051b == r101.f537051b) goto L12;
        return false;
    L12:
        if (this.f537052c == r101.f537052c) goto L14;
        return false;
    L14:
        if (this.f537053d == r101.f537053d) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f537054e, r101.f537054e) == true) goto L18;
        return false;
    L18:
        if (this.f537055f == r101.f537055f) goto L20;
        return false;
    L20:
        if (this.f537056g == r101.f537056g) goto L22;
        return false;
    L22:
        if (this.f537057h == r101.f537057h) goto L24;
        return false;
    L24:
        if (this.f537058i == r101.f537058i) goto L26;
        return false;
    L26:
        if (this.f537059j == r101.f537059j) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f537060k, r101.f537060k) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f537061l, r101.f537061l) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.f537062m, r101.f537062m) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.f537063n, r101.f537063n) == true) goto L55;
        return false;
    L55:
        return true;
    L36:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        Function1<c, Unit> r100 = this.f537050a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = (r102 + 0) * 31;
        boolean r104 = this.f537051b;
        ?? r105 = 1;
        ?? r106 = r104;
        if (r104 == false) goto L9;
        r106 = 1;
    L9:
        int r107 = (r103 + r106) * 31;
        boolean r108 = this.f537052c;
        ?? r109 = r108;
        if (r108 == false) goto L12;
        r109 = 1;
    L12:
        int r110 = (r107 + r109) * 31;
        boolean r111 = this.f537053d;
        ?? r112 = r111;
        if (r111 == false) goto L15;
        r112 = 1;
    L15:
        int r113 = (r110 + r112) * 31;
        IRoom r114 = this.f537054e;
        if (r114 == null) goto L18;
        int r115 = r114.hashCode();
    L19:
        int r116 = (r113 + r115) * 31;
        boolean r117 = this.f537055f;
        if (r117 == true) goto L23;
        r105 = r117;
    L23:
        int r118 = (((((((((r116 + r105) * 31) + this.f537056g) * 31) + this.f537057h) * 31) + this.f537058i) * 31) + this.f537059j) * 31;
        LiveMode r119 = this.f537060k;
        if (r119 == null) goto L26;
        int r120 = r119.hashCode();
    L27:
        int r121 = (r118 + r120) * 31;
        Context r122 = this.f537061l;
        if (r122 == null) goto L30;
        int r123 = r122.hashCode();
    L31:
        int r124 = (r121 + r123) * 31;
        g r125 = this.f537062m;
        if (r125 == null) goto L34;
        int r126 = r125.hashCode();
    L35:
        int r127 = (r124 + r126) * 31;
        a r128 = this.f537063n;
        if (r128 == null) goto L39;
        r101 = r128.hashCode();
    L39:
        return r127 + r101;
    L34:
        r126 = 0;
        goto L35
    L30:
        r123 = 0;
        goto L31
    L26:
        r120 = 0;
        goto L27
    L18:
        r115 = 0;
        goto L19
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "RevenuePlayerLayoutContextExternal(extraLayoutData=null, feedPlayerEvent=" + this.f537050a + ", isPad=" + this.f537051b + ", isFoldScreenFullType=" + this.f537052c + ", isPortrait=" + this.f537053d + ", room=" + this.f537054e + ", isPreview=" + this.f537055f + ", containerWidth=" + this.f537056g + ", containerHeight=" + this.f537057h + ", videoWidth=" + this.f537058i + ", videoHeight=" + this.f537059j + ", streamType=" + this.f537060k + ", activityContext=" + this.f537061l + ", extraRenderControoler=" + this.f537062m + ", bottomSizeInfo=" + this.f537063n + ")";
    }

    public o(Function1 r100, boolean r101, boolean r102, boolean r110, IRoom r111, boolean r112, int r113, int r114, int r115, int r116, LiveMode r117, Context r118, a r119, int r210) {
        if ((r210 & 4096) == 0) goto L5;
        Context r103 = null;
    L7:
        if ((r210 & 16384) == 0) goto L9;
        a r104 = null;
    L10:
        Intrinsics.checkNotNullParameter(r117, "streamType");
        this.f537050a = r100;
        this.f537051b = r101;
        this.f537052c = r102;
        this.f537053d = r110;
        this.f537054e = r111;
        this.f537055f = r112;
        this.f537056g = r113;
        this.f537057h = r114;
        this.f537058i = r115;
        this.f537059j = r116;
        this.f537060k = r117;
        this.f537061l = r103;
        this.f537062m = null;
        this.f537063n = r104;
        return;
    L9:
        r104 = r119;
        goto L10
    L5:
        r103 = r118;
        goto L7
    }
}

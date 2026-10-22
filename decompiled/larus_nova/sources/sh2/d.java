package sh2;

import com.bytedance.android.livesdk.livecommerce.intro.model.req.IntroCardScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class d {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f541940k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f541941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f541942b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f541943c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f541944d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f541945e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f541946f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f541947g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f541948h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f541949i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final IntroCardScene f541950j;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L26;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f541941a, r101.f541941a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f541942b, r101.f541942b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f541943c, r101.f541943c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f541944d, r101.f541944d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f541945e, r101.f541945e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f541946f, r101.f541946f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f541947g, r101.f541947g) == true) goto L20;
        return false;
    L20:
        if (this.f541948h == r101.f541948h) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f541949i, r101.f541949i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f541950j, r101.f541950j) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v19, types: [int] */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v32 */
    public final int hashCode() {
        String r100 = this.f541941a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f541942b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f541943c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f541944d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f541945e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f541946f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f541947g;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        boolean r122 = this.f541948h;
        ?? r123 = r122;
        if (r122 == false) goto L33;
        r123 = 1;
    L33:
        int r124 = (r121 + r123) * 31;
        b r125 = this.f541949i;
        if (r125 == null) goto L36;
        int r126 = r125.hashCode();
    L37:
        int r127 = (r124 + r126) * 31;
        IntroCardScene r128 = this.f541950j;
        if (r128 == null) goto L41;
        r101 = r128.hashCode();
    L41:
        return r127 + r101;
    L36:
        r126 = 0;
        goto L37
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
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
        return "LiveIntroRequest(forcePath=" + this.f541941a + ", roomId=" + this.f541942b + ", roomUniqueKey=" + this.f541943c + ", groupId=" + this.f541944d + ", authorId=" + this.f541945e + ", secAuthorId=" + this.f541946f + ", entranceInfo=" + this.f541947g + ", isRetry=" + this.f541948h + ", productInfo=" + this.f541949i + ", cardScene=" + this.f541950j + ")";
    }

    public d(String r100, String r101, String r102, String r103, String r104, String r105, String r106, boolean r107, b r110, IntroCardScene r111) {
        Intrinsics.checkNotNullParameter(r101, "roomId");
        Intrinsics.checkNotNullParameter(r102, "roomUniqueKey");
        Intrinsics.checkNotNullParameter(r104, "authorId");
        Intrinsics.checkNotNullParameter(r105, "secAuthorId");
        Intrinsics.checkNotNullParameter(r106, "entranceInfo");
        Intrinsics.checkNotNullParameter(r111, "cardScene");
        this.f541941a = r100;
        this.f541942b = r101;
        this.f541943c = r102;
        this.f541944d = r103;
        this.f541945e = r104;
        this.f541946f = r105;
        this.f541947g = r106;
        this.f541948h = r107;
        this.f541949i = r110;
        this.f541950j = r111;
    }
}

package jd2;

import com.bytedance.android.live.anchormodelink.impl.AnchorModeLinkDynamicWidget;
import com.bytedance.android.live.liveinteract.videotalk.utils.t;
import com.bytedance.android.livesdk.ktvapi.model.VideoChorusSource;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f498247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f498248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f498249c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f498250d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f498251e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f498252f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final h80.a<Boolean> f498253g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final h80.a<Boolean> f498254h;

    public static final class a<T> implements h80.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f498255a = null;

        static {
            f498255a = new a();
        }

        public a() {
        }

        @Override // h80.a
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Boolean r101 = (Boolean) r100;
        }
    }

    public static final class b<T> implements h80.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f498256a = null;

        static {
            f498256a = new b();
        }

        public b() {
        }

        @Override // h80.a
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Boolean r101 = (Boolean) r100;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L22;
        g r101 = (g) r100;
        if (this.f498247a == r101.f498247a) goto L8;
        return false;
    L8:
        if (this.f498248b == r101.f498248b) goto L10;
        return false;
    L10:
        if (this.f498249c == r101.f498249c) goto L12;
        return false;
    L12:
        if (this.f498250d == r101.f498250d) goto L14;
        return false;
    L14:
        if (this.f498251e == r101.f498251e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f498252f, r101.f498252f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f498253g, r101.f498253g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f498254h, r101.f498254h) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    public final int hashCode() {
        boolean r100 = this.f498247a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.f498248b;
        ?? r105 = r104;
        if (r104 == false) goto L8;
        r105 = 1;
    L8:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.f498249c;
        if (r107 == true) goto L12;
        r101 = r107;
    L12:
        int r108 = (((((r106 + r101) * 31) + this.f498250d) * 31) + this.f498251e) * 31;
        String r109 = this.f498252f;
        int r110 = 0;
        if (r109 == null) goto L15;
        int r111 = r109.hashCode();
    L16:
        int r112 = (r108 + r111) * 31;
        h80.a<Boolean> r113 = this.f498253g;
        if (r113 == null) goto L19;
        int r114 = r113.hashCode();
    L20:
        int r115 = (r112 + r114) * 31;
        h80.a<Boolean> r116 = this.f498254h;
        if (r116 == null) goto L24;
        r110 = r116.hashCode();
    L24:
        return r115 + r110;
    L19:
        r114 = 0;
        goto L20
    L15:
        r111 = 0;
        goto L16
    }

    public final String toString() {
        return "VideoChorusToggleModel(isEnable=" + this.f498247a + ", showConfirmDialog=" + this.f498248b + ", closeInteract=" + this.f498249c + ", scene=" + this.f498250d + ", uiLayout=" + this.f498251e + ", source=" + this.f498252f + ", callback=" + this.f498253g + ", closeInteractCallback=" + this.f498254h + ")";
    }

    public /* synthetic */ g(boolean r110, boolean r111, int r112, int r113, String r114, t r115, AnchorModeLinkDynamicWidget.f.a r116, int r210) {
        if ((r210 & 2) == 0) goto L5;
        boolean r100 = true;
    L7:
        if ((r210 & 4) == 0) goto L9;
        boolean r101 = false;
    L11:
        if ((r210 & 8) == 0) goto L13;
        int r102 = 0;
    L15:
        if ((r210 & 16) == 0) goto L17;
        int r103 = 0;
    L19:
        if ((r210 & 32) == 0) goto L21;
        String r104 = VideoChorusSource.UNKNOWN.getValue();
    L23:
        if ((r210 & 64) == 0) goto L25;
        h80.a r117 = a.f498255a;
    L27:
        if ((r210 & 128) == 0) goto L29;
        h80.a r118 = b.f498256a;
    L30:
        this(r110, r100, r101, r102, r103, r104, r117, r118);
        return;
    L29:
        r118 = r116;
        goto L30
    L25:
        r117 = r115;
        goto L27
    L21:
        r104 = r114;
        goto L23
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = false;
        goto L7
    }

    public g(boolean r100, boolean r101, boolean r102, int r103, int r104, String r105, h80.a<Boolean> r106, h80.a<Boolean> r107) {
        Intrinsics.checkNotNullParameter(r105, "source");
        Intrinsics.checkNotNullParameter(r106, "callback");
        this.f498247a = r100;
        this.f498248b = r101;
        this.f498249c = r102;
        this.f498250d = r103;
        this.f498251e = r104;
        this.f498252f = r105;
        this.f498253g = r106;
        this.f498254h = r107;
    }
}

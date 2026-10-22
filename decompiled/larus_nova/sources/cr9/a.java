package cr9;

import com.larus.platform.model.office.AiFilePreviewScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f465107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AiFilePreviewScene f465108b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f465109c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f465110d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f465111e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f465112f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f465113g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f465114h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f465115i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f465107a, r101.f465107a) == true) goto L12;
        return false;
    L12:
        if (this.f465108b == r101.f465108b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f465109c, r101.f465109c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f465110d, r101.f465110d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f465111e, r101.f465111e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f465112f, r101.f465112f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f465113g, r101.f465113g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f465114h, r101.f465114h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f465115i, r101.f465115i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f465107a.hashCode() * 31) + this.f465108b.hashCode()) * 31;
        String r101 = this.f465109c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f465110d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f465111e;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f465112f;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f465113g;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        String r117 = this.f465114h;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        String r120 = this.f465115i;
        if (r120 == null) goto L31;
        r102 = r120.hashCode();
    L31:
        return r119 + r102;
    L25:
        r118 = r117.hashCode();
        goto L26
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "AiFilePreviewRequest(resourceUri=" + this.f465107a + ", scene=" + this.f465108b + ", fileName=" + this.f465109c + ", fileType=" + this.f465110d + ", directShareUrl=" + this.f465111e + ", resourceId=" + this.f465112f + ", sourceConversationId=" + this.f465113g + ", sourceBotId=" + this.f465114h + ", sourceMessageId=" + this.f465115i + ')';
    }

    public a(String r100, AiFilePreviewScene r101, String r102, String r103, String r104, String r105, String r106, String r107, String r110) {
        Intrinsics.checkNotNullParameter(r100, "resourceUri");
        Intrinsics.checkNotNullParameter(r101, "scene");
        this.f465107a = r100;
        this.f465108b = r101;
        this.f465109c = r102;
        this.f465110d = r103;
        this.f465111e = r104;
        this.f465112f = r105;
        this.f465113g = r106;
        this.f465114h = r107;
        this.f465115i = r110;
    }

    public /* synthetic */ a(String r110, AiFilePreviewScene r111, String r112, String r113, String r114, String r115, String r210, String r211, String r212, int r213) {
        if ((r213 & 4) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r213 & 8) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r213 & 16) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r213 & 32) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r213 & 64) == 0) goto L21;
        String r116 = null;
    L23:
        if ((r213 & 128) == 0) goto L25;
        String r117 = null;
    L27:
        if ((r213 & 256) == 0) goto L29;
        String r118 = null;
    L30:
        this(r110, r111, r100, r101, r102, r103, r116, r117, r118);
        return;
    L29:
        r118 = r212;
        goto L30
    L25:
        r117 = r211;
        goto L27
    L21:
        r116 = r210;
        goto L23
    L17:
        r103 = r115;
        goto L19
    L13:
        r102 = r114;
        goto L15
    L9:
        r101 = r113;
        goto L11
    L5:
        r100 = r112;
        goto L7
    }
}

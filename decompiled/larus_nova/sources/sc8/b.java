package sc8;

import com.larus.bmhome.chat.bubble.floating.BubbleBannerSource;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f541378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f541379b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f541380c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f541381d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f541382e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f541383f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f541384g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f541385h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f541386i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f541387j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final BubbleBannerSource f541388k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final pc8.c f541389l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<String, String> f541390m;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f541378a, r101.f541378a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f541379b, r101.f541379b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f541380c, r101.f541380c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f541381d, r101.f541381d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f541382e, r101.f541382e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f541383f, r101.f541383f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f541384g, r101.f541384g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f541385h, r101.f541385h) == true) goto L33;
        return false;
    L33:
        if (this.f541386i == r101.f541386i) goto L36;
        return false;
    L36:
        if (this.f541387j == r101.f541387j) goto L39;
        return false;
    L39:
        if (this.f541388k == r101.f541388k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f541389l, r101.f541389l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f541390m, r101.f541390m) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f541378a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((((((((r102 * 31) + this.f541379b.hashCode()) * 31) + this.f541380c.hashCode()) * 31) + this.f541381d.hashCode()) * 31) + this.f541382e.hashCode()) * 31;
        String r104 = this.f541383f;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f541384g;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f541385h;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        long r113 = this.f541386i;
        int r114 = (((((r112 + ((int) (r113 ^ (r113 >>> 32)))) * 31) + this.f541387j) * 31) + this.f541388k.hashCode()) * 31;
        pc8.c r115 = this.f541389l;
        if (r115 != null) goto L21;
        int r116 = 0;
    L22:
        int r117 = (r114 + r116) * 31;
        Map<String, String> r118 = this.f541390m;
        if (r118 == null) goto L27;
        r101 = r118.hashCode();
    L27:
        return r117 + r101;
    L21:
        r116 = r115.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "BubbleBannerEvent(bannerSource=" + this.f541378a + ", promptId=" + this.f541379b + ", conversationId=" + this.f541380c + ", queryMessageId=" + this.f541381d + ", title=" + this.f541382e + ", content=" + this.f541383f + ", icon=" + this.f541384g + ", buttonText=" + this.f541385h + ", autoDismissSeconds=" + this.f541386i + ", priority=" + this.f541387j + ", source=" + this.f541388k + ", extraInfo=" + this.f541389l + ", ext=" + this.f541390m + ')';
    }

    public b(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, long r110, int r111, BubbleBannerSource r112, pc8.c r113, Map<String, String> r114) {
        Intrinsics.checkNotNullParameter(r101, "promptId");
        Intrinsics.checkNotNullParameter(r102, "conversationId");
        Intrinsics.checkNotNullParameter(r103, "queryMessageId");
        Intrinsics.checkNotNullParameter(r104, "title");
        Intrinsics.checkNotNullParameter(r112, "source");
        this.f541378a = r100;
        this.f541379b = r101;
        this.f541380c = r102;
        this.f541381d = r103;
        this.f541382e = r104;
        this.f541383f = r105;
        this.f541384g = r106;
        this.f541385h = r107;
        this.f541386i = r110;
        this.f541387j = r111;
        this.f541388k = r112;
        this.f541389l = r113;
        this.f541390m = r114;
    }
}

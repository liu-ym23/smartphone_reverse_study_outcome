package xy8;

import com.larus.chat.gallery.impl.preview.data.SourceType;
import com.larus.gallery.api.GalleryType;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.creation.UserCreation;
import com.tencent.open.SocialConstants;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SourceType f565426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f565427b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f565428c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f565429d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final GalleryType f565430e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, Object> f565431f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f565432g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f565433h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f565434i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<String, String> f565435j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<String, String> f565436k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final f f565437l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final e f565438m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final UserCreation f565439n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Message f565440o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final c f565441p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f565442q;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f565426a == r101.f565426a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f565427b, r101.f565427b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f565428c, r101.f565428c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f565429d, r101.f565429d) == true) goto L21;
        return false;
    L21:
        if (this.f565430e == r101.f565430e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f565431f, r101.f565431f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f565432g, r101.f565432g) == true) goto L30;
        return false;
    L30:
        if (this.f565433h == r101.f565433h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f565434i, r101.f565434i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f565435j, r101.f565435j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f565436k, r101.f565436k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f565437l, r101.f565437l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f565438m, r101.f565438m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f565439n, r101.f565439n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f565440o, r101.f565440o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f565441p, r101.f565441p) == true) goto L57;
        return false;
    L57:
        if (this.f565442q == r101.f565442q) goto L59;
        return false;
    L59:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f565426a.hashCode() * 31) + this.f565427b.hashCode()) * 31;
        b r101 = this.f565428c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        g r105 = this.f565429d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((((((r104 + r106) * 31) + this.f565430e.hashCode()) * 31) + this.f565431f.hashCode()) * 31) + this.f565432g.hashCode()) * 31;
        long r108 = this.f565433h;
        int r109 = (r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31;
        String r110 = this.f565434i;
        if (r110 != null) goto L13;
        int r111 = 0;
    L14:
        int r112 = (((r109 + r111) * 31) + this.f565435j.hashCode()) * 31;
        Map<String, String> r113 = this.f565436k;
        if (r113 != null) goto L17;
        int r114 = 0;
    L18:
        int r115 = (r112 + r114) * 31;
        f r116 = this.f565437l;
        if (r116 != null) goto L21;
        int r117 = 0;
    L22:
        int r118 = (r115 + r117) * 31;
        e r119 = this.f565438m;
        if (r119 != null) goto L25;
        int r120 = 0;
    L26:
        int r121 = (r118 + r120) * 31;
        UserCreation r122 = this.f565439n;
        if (r122 != null) goto L29;
        int r123 = 0;
    L30:
        int r124 = (r121 + r123) * 31;
        Message r125 = this.f565440o;
        if (r125 != null) goto L33;
        int r126 = 0;
    L34:
        int r127 = (r124 + r126) * 31;
        c r128 = this.f565441p;
        if (r128 == null) goto L39;
        r102 = r128.hashCode();
    L39:
        return ((r127 + r102) * 31) + this.f565442q;
    L33:
        r126 = r125.hashCode();
        goto L34
    L29:
        r123 = r122.hashCode();
        goto L30
    L25:
        r120 = r119.hashCode();
        goto L26
    L21:
        r117 = r116.hashCode();
        goto L22
    L17:
        r114 = r113.hashCode();
        goto L18
    L13:
        r111 = r110.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "PreviewGalleryData(sourceType=" + this.f565426a + ", itemKey=" + this.f565427b + ", imageContent=" + this.f565428c + ", videoContent=" + this.f565429d + ", resourceType=" + this.f565430e + ", traceParams=" + this.f565431f + ", desc=" + this.f565432g + ", createTime=" + this.f565433h + ", originAttachmentStableId=" + this.f565434i + ", ext=" + this.f565435j + ", metaDataExif=" + this.f565436k + ", sendMetadata=" + this.f565437l + ", publishMetadata=" + this.f565438m + ", userCreation=" + this.f565439n + ", message=" + this.f565440o + ", localMediaResource=" + this.f565441p + ", groupPosition=" + this.f565442q + ')';
    }

    public static d a(d r210, b r211, g r212, GalleryType r213, Map r214, String r215, Map r216, e r310, UserCreation r311, c r312, int r313, int r314) {
        Message r100 = null;
        if ((r314 & 1) == 0) goto L5;
        SourceType r101 = r210.f565426a;
    L7:
        if ((r314 & 2) == 0) goto L9;
        String r102 = r210.f565427b;
    L11:
        if ((r314 & 4) == 0) goto L13;
        b r103 = r210.f565428c;
    L15:
        if ((r314 & 8) == 0) goto L17;
        g r104 = r210.f565429d;
    L19:
        if ((r314 & 16) == 0) goto L21;
        GalleryType r105 = r210.f565430e;
    L23:
        if ((r314 & 32) == 0) goto L25;
        Map r110 = r210.f565431f;
    L27:
        if ((r314 & 64) == 0) goto L29;
        String r111 = r210.f565432g;
    L31:
        if ((r314 & 128) == 0) goto L33;
        long r112 = r210.f565433h;
    L35:
        if ((r314 & 256) == 0) goto L37;
        String r113 = r210.f565434i;
    L39:
        if ((r314 & 512) == 0) goto L41;
        Map r114 = r210.f565435j;
    L43:
        if ((r314 & 1024) == 0) goto L45;
        Map<String, String> r115 = r210.f565436k;
    L47:
        if ((r314 & 2048) == 0) goto L49;
        f r116 = r210.f565437l;
    L51:
        if ((r314 & 4096) == 0) goto L53;
        e r117 = r210.f565438m;
    L55:
        if ((r314 & 8192) == 0) goto L57;
        UserCreation r118 = r210.f565439n;
    L59:
        if ((r314 & 16384) == 0) goto L61;
        r100 = r210.f565440o;
    L61:
        Message r217 = r100;
        if ((32768 & r314) == 0) goto L64;
        c r218 = r210.f565441p;
    L66:
        if ((r314 & 65536) == 0) goto L68;
        int r219 = r210.f565442q;
    L69:
        r210.getClass();
        Intrinsics.checkNotNullParameter(r101, "sourceType");
        Intrinsics.checkNotNullParameter(r102, "itemKey");
        Intrinsics.checkNotNullParameter(r105, "resourceType");
        Intrinsics.checkNotNullParameter(r110, "traceParams");
        Intrinsics.checkNotNullParameter(r111, SocialConstants.PARAM_APP_DESC);
        Intrinsics.checkNotNullParameter(r114, "ext");
        return new d(r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r116, r117, r118, r217, r218, r219);
    L68:
        r219 = r313;
        goto L69
    L64:
        r218 = r312;
        goto L66
    L57:
        r118 = r311;
        goto L59
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = null;
        goto L51
    L45:
        r115 = null;
        goto L47
    L41:
        r114 = r216;
        goto L43
    L37:
        r113 = null;
        goto L39
    L33:
        r112 = 0;
        goto L35
    L29:
        r111 = r215;
        goto L31
    L25:
        r110 = r214;
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
        r102 = null;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public d(SourceType r100, String r110, b r111, g r112, GalleryType r113, Map<String, ? extends Object> r114, String r115, long r116, String r117, Map<String, String> r118, Map<String, String> r210, f r211, e r212, UserCreation r213, Message r214, c r215, int r216) {
        Intrinsics.checkNotNullParameter(r100, "sourceType");
        Intrinsics.checkNotNullParameter(r110, "itemKey");
        Intrinsics.checkNotNullParameter(r113, "resourceType");
        Intrinsics.checkNotNullParameter(r114, "traceParams");
        Intrinsics.checkNotNullParameter(r115, SocialConstants.PARAM_APP_DESC);
        Intrinsics.checkNotNullParameter(r118, "ext");
        this.f565426a = r100;
        this.f565427b = r110;
        this.f565428c = r111;
        this.f565429d = r112;
        this.f565430e = r113;
        this.f565431f = r114;
        this.f565432g = r115;
        this.f565433h = r116;
        this.f565434i = r117;
        this.f565435j = r118;
        this.f565436k = r210;
        this.f565437l = r211;
        this.f565438m = r212;
        this.f565439n = r213;
        this.f565440o = r214;
        this.f565441p = r215;
        this.f565442q = r216;
    }

    public /* synthetic */ d(SourceType r210, String r211, b r212, g r213, GalleryType r214, Map r215, String r216, long r310, String r311, Map r312, Map r313, f r314, e r315, UserCreation r316, Message r317, c r318, int r410, int r411) {
        if ((r411 & 4) == 0) goto L5;
        b r100 = null;
    L7:
        if ((r411 & 8) == 0) goto L9;
        g r101 = null;
    L11:
        if ((r411 & 32) == 0) goto L13;
        Map r102 = MapsKt.emptyMap();
    L15:
        if ((r411 & 64) == 0) goto L17;
        String r110 = "";
    L19:
        if ((r411 & 128) == 0) goto L21;
        long r111 = 0;
    L23:
        if ((r411 & 256) == 0) goto L25;
        String r112 = null;
    L27:
        if ((r411 & 512) == 0) goto L29;
        Map r113 = MapsKt.emptyMap();
    L31:
        if ((r411 & 1024) == 0) goto L33;
        Map r114 = null;
    L35:
        if ((r411 & 2048) == 0) goto L37;
        f r115 = null;
    L39:
        if ((r411 & 4096) == 0) goto L41;
        e r116 = null;
    L43:
        if ((r411 & 8192) == 0) goto L45;
        UserCreation r117 = null;
    L47:
        if ((r411 & 16384) == 0) goto L49;
        Message r118 = null;
    L51:
        if ((32768 & r411) == 0) goto L53;
        c r217 = null;
    L55:
        if ((r411 & 65536) == 0) goto L57;
        int r218 = 1;
    L58:
        this(r210, r211, r100, r101, r214, r102, r110, r111, r112, r113, r114, r115, r116, r117, r118, r217, r218);
        return;
    L57:
        r218 = r410;
        goto L58
    L53:
        r217 = r318;
        goto L55
    L49:
        r118 = r317;
        goto L51
    L45:
        r117 = r316;
        goto L47
    L41:
        r116 = r315;
        goto L43
    L37:
        r115 = r314;
        goto L39
    L33:
        r114 = r313;
        goto L35
    L29:
        r113 = r312;
        goto L31
    L25:
        r112 = r311;
        goto L27
    L21:
        r111 = r310;
        goto L23
    L17:
        r110 = r216;
        goto L19
    L13:
        r102 = r215;
        goto L15
    L9:
        r101 = r213;
        goto L11
    L5:
        r100 = r212;
        goto L7
    }
}

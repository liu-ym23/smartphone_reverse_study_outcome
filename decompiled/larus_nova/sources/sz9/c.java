package sz9;

import android.net.Uri;
import com.larus.bmhome.bigimg.l;
import com.larus.bmhome.bigimg.n1;
import com.larus.bmhome.share.panel.h;
import com.larus.bmhome.utils.c4;
import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import nr9.g;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n1 f544091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f544092b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f544093c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l f544094d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f544095e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final JSONObject f544096f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Boolean f544097g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final g f544098h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f544099i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f544100j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final CoroutineScope f544101k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Message f544102l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final h f544103m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final c4 f544104n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final com.larus.bmhome.share.panel.d f544105o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f544106p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Integer f544107q;

    public c() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, 131071);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f544091a, r101.f544091a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f544092b, r101.f544092b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f544093c, r101.f544093c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f544094d, r101.f544094d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f544095e, r101.f544095e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f544096f, r101.f544096f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f544097g, r101.f544097g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f544098h, r101.f544098h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f544099i, r101.f544099i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f544100j, r101.f544100j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f544101k, r101.f544101k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f544102l, r101.f544102l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f544103m, r101.f544103m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f544104n, r101.f544104n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f544105o, r101.f544105o) == true) goto L54;
        return false;
    L54:
        if (this.f544106p == r101.f544106p) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f544107q, r101.f544107q) == true) goto L59;
        return false;
    L59:
        return true;
    }

    public final int hashCode() {
        n1 r100 = this.f544091a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Uri r104 = this.f544092b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f544093c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        l r110 = this.f544094d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f544095e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        JSONObject r116 = this.f544096f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Boolean r119 = this.f544097g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        g r122 = this.f544098h;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f544099i;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.f544100j;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        CoroutineScope r131 = this.f544101k;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        Message r134 = this.f544102l;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        h r137 = this.f544103m;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        c4 r140 = this.f544104n;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        com.larus.bmhome.share.panel.d r143 = this.f544105o;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        if (this.f544106p == false) goto L65;
        int r146 = 1231;
    L66:
        int r147 = (r145 + r146) * 31;
        Integer r148 = this.f544107q;
        if (r148 == null) goto L71;
        r101 = r148.hashCode();
    L71:
        return r147 + r101;
    L65:
        r146 = 1237;
        goto L66
    L61:
        r144 = r143.hashCode();
        goto L62
    L57:
        r141 = r140.hashCode();
        goto L58
    L53:
        r138 = r137.hashCode();
        goto L54
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
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
        return "CreationOperationParams(imageUrl=" + this.f544091a + ", downloadUri=" + this.f544092b + ", creationType=" + this.f544093c + ", imageInfo=" + this.f544094d + ", imageResourceKey=" + this.f544095e + ", reportParam=" + this.f544096f + ", isCaseMode=" + this.f544097g + ", videoPlayData=" + this.f544098h + ", creationKey=" + this.f544099i + ", creationId=" + this.f544100j + ", scope=" + this.f544101k + ", message=" + this.f544102l + ", sharePanelEventParam=" + this.f544103m + ", videoEventParams=" + this.f544104n + ", clickInterceptor=" + this.f544105o + ", noWatermarkSelected=" + this.f544106p + ", taskType=" + this.f544107q + ')';
    }

    public c(n1 r110, Uri r210, Integer r211, l r212, String r213, JSONObject r214, Boolean r215, g r216, String r217, String r218, CoroutineScope r219, Message r310, h r311, c4 r312, com.larus.bmhome.share.panel.d r313, boolean r314, Integer r315, int r316) {
        if ((r316 & 1) == 0) goto L5;
        n1 r100 = null;
    L7:
        if ((r316 & 2) == 0) goto L9;
        Uri r101 = null;
    L11:
        if ((r316 & 4) == 0) goto L13;
        Integer r102 = null;
    L15:
        if ((r316 & 8) == 0) goto L17;
        l r103 = null;
    L19:
        if ((r316 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r316 & 32) == 0) goto L25;
        JSONObject r105 = null;
    L27:
        if ((r316 & 64) == 0) goto L29;
        Boolean r106 = Boolean.FALSE;
    L31:
        if ((r316 & 128) == 0) goto L33;
        g r111 = null;
    L35:
        if ((r316 & 256) == 0) goto L37;
        String r112 = null;
    L39:
        if ((r316 & 512) == 0) goto L41;
        String r113 = null;
    L43:
        if ((r316 & 1024) == 0) goto L45;
        CoroutineScope r114 = null;
    L47:
        if ((r316 & 2048) == 0) goto L49;
        Message r115 = null;
    L51:
        if ((r316 & 4096) == 0) goto L53;
        h r116 = null;
    L55:
        if ((r316 & 8192) == 0) goto L57;
        c4 r107 = null;
    L58:
        c4 r117 = r107;
        if ((r316 & 16384) == 0) goto L61;
        com.larus.bmhome.share.panel.d r108 = null;
    L63:
        if ((r316 & 32768) == 0) goto L65;
        boolean r118 = false;
    L67:
        if ((r316 & 65536) == 0) goto L69;
        Integer r109 = null;
    L70:
        this.f544091a = r100;
        this.f544092b = r101;
        this.f544093c = r102;
        this.f544094d = r103;
        this.f544095e = r104;
        this.f544096f = r105;
        this.f544097g = r106;
        this.f544098h = r111;
        this.f544099i = r112;
        this.f544100j = r113;
        this.f544101k = r114;
        this.f544102l = r115;
        this.f544103m = r116;
        this.f544104n = r117;
        this.f544105o = r108;
        this.f544106p = r118;
        this.f544107q = r109;
        return;
    L69:
        r109 = r315;
        goto L70
    L65:
        r118 = r314;
        goto L67
    L61:
        r108 = r313;
        goto L63
    L57:
        r107 = r312;
        goto L58
    L53:
        r116 = r311;
        goto L55
    L49:
        r115 = r310;
        goto L51
    L45:
        r114 = r219;
        goto L47
    L41:
        r113 = r218;
        goto L43
    L37:
        r112 = r217;
        goto L39
    L33:
        r111 = r216;
        goto L35
    L29:
        r106 = r215;
        goto L31
    L25:
        r105 = r214;
        goto L27
    L21:
        r104 = r213;
        goto L23
    L17:
        r103 = r212;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}

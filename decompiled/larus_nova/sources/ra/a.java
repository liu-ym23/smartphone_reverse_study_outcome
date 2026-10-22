package ra;

import android.net.Uri;
import com.bytedance.forest.Forest;
import com.lynx.tasm.TemplateData;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f536743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f536744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f536745c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TemplateData f536746d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f536747e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ra.b f536748f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f536749g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TemplateData f536750h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f536751i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f536752j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f536753k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final c f536754l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f536755m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f536756n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final C7451a f536757o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f536758p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f536759q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f536760r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f536761s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Forest f536762t;

    /* JADX INFO: renamed from: ra.a$a, reason: collision with other inner class name */
    public static final class C7451a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f536763a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f536764b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f536765c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f536766d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f536767e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f536768f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f536769g;

        public C7451a() {
            this(false, null, 127);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C7451a) == true) goto L8;
            return false;
        L8:
            C7451a r101 = (C7451a) r100;
            if (this.f536763a == r101.f536763a) goto L12;
            return false;
        L12:
            if (this.f536764b == r101.f536764b) goto L15;
            return false;
        L15:
            if (this.f536765c == r101.f536765c) goto L18;
            return false;
        L18:
            if (this.f536766d == r101.f536766d) goto L21;
            return false;
        L21:
            if (this.f536767e == r101.f536767e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f536768f, r101.f536768f) == true) goto L27;
            return false;
        L27:
            if (this.f536769g == r101.f536769g) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            int r100 = 1231;
            if (this.f536763a == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = r101 * 31;
            if (this.f536764b == false) goto L9;
            int r103 = 1231;
        L10:
            int r104 = (r102 + r103) * 31;
            if (this.f536765c == false) goto L13;
            int r105 = 1231;
        L14:
            int r106 = (r104 + r105) * 31;
            if (this.f536766d == false) goto L17;
            int r107 = 1231;
        L18:
            int r108 = (r106 + r107) * 31;
            if (this.f536767e == false) goto L21;
            int r109 = 1231;
        L22:
            int r110 = (r108 + r109) * 31;
            String r111 = this.f536768f;
            if (r111 != null) goto L25;
            int r112 = 0;
        L26:
            int r113 = (r110 + r112) * 31;
            if (this.f536769g == true) goto L31;
            r100 = 1237;
        L31:
            return r113 + r100;
        L25:
            r112 = r111.hashCode();
            goto L26
        L21:
            r109 = 1237;
            goto L22
        L17:
            r107 = 1237;
            goto L18
        L13:
            r105 = 1237;
            goto L14
        L9:
            r103 = 1237;
            goto L10
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "CompactConfig(compactBridge=" + this.f536763a + ", compactCanvas=" + this.f536764b + ", compactMonitor=" + this.f536765c + ", disableSignVerify=" + this.f536766d + ", enableBridgeDelayInit=" + this.f536767e + ", monitorID=" + this.f536768f + ", trimGlobalProps=" + this.f536769g + ')';
        }

        public C7451a(boolean r100, String r101, int r110) {
            boolean r102 = false;
            if ((r110 & 1) == 0) goto L5;
            boolean r103 = true;
        L7:
            if ((r110 & 2) == 0) goto L9;
            boolean r104 = true;
        L11:
            if ((r110 & 4) == 0) goto L13;
            boolean r105 = true;
        L15:
            if ((r110 & 8) == 0) goto L17;
            boolean r106 = true;
        L19:
            if ((r110 & 16) == 0) goto L22;
            r100 = false;
        L22:
            if ((r110 & 32) == 0) goto L25;
            r101 = null;
        L25:
            if ((r110 & 64) == 0) goto L27;
            r102 = true;
        L27:
            this.f536763a = r103;
            this.f536764b = r104;
            this.f536765c = r105;
            this.f536766d = r106;
            this.f536767e = r100;
            this.f536768f = r101;
            this.f536769g = r102;
            return;
        L17:
            r106 = false;
            goto L19
        L13:
            r105 = false;
            goto L15
        L9:
            r104 = false;
            goto L11
        L5:
            r103 = false;
            goto L7
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f536770a;

        public final String toString() {
            return "ComparableByteArray(templateJS=" + Arrays.toString(this.f536770a) + ')';
        }

        public final int hashCode() {
            return Arrays.hashCode(this.f536770a);
        }

        public b(byte[] r100) {
            Intrinsics.checkNotNullParameter(r100, "templateJS");
            this.f536770a = r100;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 == null) goto L8;
            Class<?> r101 = r100.getClass();
        L10:
            if (Intrinsics.areEqual(b.class, r101) == true) goto L13;
            return false;
        L13:
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.android.anniex.model.AnnieXLynxModel.ComparableByteArray");
            return Arrays.equals(this.f536770a, ((b) r100).f536770a);
        L8:
            r101 = null;
            goto L10
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f536771a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f536772b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TemplateData f536773c;

        /* JADX WARN: Multi-variable type inference failed */
        public c() {
            Object[] r100 = 0 == true ? 1 : 0;
            this(null, r100, 7);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f536771a, r101.f536771a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f536772b, r101.f536772b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f536773c, r101.f536773c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            b r100 = this.f536771a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f536772b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            TemplateData r107 = this.f536773c;
            if (r107 == null) goto L15;
            r101 = r107.hashCode();
        L15:
            return r106 + r101;
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "SSRHydrateConfig(template=" + this.f536771a + ", baseUrl=" + this.f536772b + ", templateData=" + this.f536773c + ')';
        }

        public /* synthetic */ c(String r100, TemplateData r101, int r102) {
            if ((r102 & 2) == 0) goto L6;
            r100 = null;
        L6:
            if ((r102 & 4) == 0) goto L8;
            r101 = null;
        L8:
            this(null, r100, r101);
        }

        public c(b r100, String r101, TemplateData r102) {
            this.f536771a = r100;
            this.f536772b = r101;
            this.f536773c = r102;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f536743a, r101.f536743a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f536744b, r101.f536744b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f536745c, r101.f536745c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f536746d, r101.f536746d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f536747e, r101.f536747e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f536748f, r101.f536748f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f536749g, r101.f536749g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f536750h, r101.f536750h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f536751i, r101.f536751i) == true) goto L36;
        return false;
    L36:
        if (this.f536752j == r101.f536752j) goto L39;
        return false;
    L39:
        if (this.f536753k == r101.f536753k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f536754l, r101.f536754l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f536755m, r101.f536755m) == true) goto L48;
        return false;
    L48:
        if (this.f536756n == r101.f536756n) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f536757o, r101.f536757o) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f536743a.hashCode() * 31) + this.f536744b.hashCode()) * 31) + this.f536745c.hashCode()) * 31;
        TemplateData r101 = this.f536746d;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Object r105 = this.f536747e;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((((r104 + r106) * 31) + this.f536748f.hashCode()) * 31) + this.f536749g.hashCode()) * 31;
        TemplateData r108 = this.f536750h;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        b r111 = this.f536751i;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        int r114 = 1231;
        if (this.f536752j == false) goto L21;
        int r115 = 1231;
    L22:
        int r116 = (r113 + r115) * 31;
        if (this.f536753k == false) goto L25;
        int r117 = 1231;
    L26:
        int r118 = (r116 + r117) * 31;
        c r119 = this.f536754l;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (((r118 + r120) * 31) + this.f536755m.hashCode()) * 31;
        if (this.f536756n == true) goto L34;
        r114 = 1237;
    L34:
        int r122 = (r121 + r114) * 31;
        C7451a r123 = this.f536757o;
        if (r123 == null) goto L39;
        r102 = r123.hashCode();
    L39:
        return r122 + r102;
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = 1237;
        goto L26
    L21:
        r115 = 1237;
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
        return "AnnieXLynxModel(url=" + this.f536743a + ", originalUri=" + this.f536744b + ", bid=" + this.f536745c + ", globalProps=" + this.f536746d + ", extra=" + this.f536747e + ", lynxViewBuilderParams=" + this.f536748f + ", sessionId=" + this.f536749g + ", templateData=" + this.f536750h + ", template=" + this.f536751i + ", isSSR=" + this.f536752j + ", isCompactMode=" + this.f536753k + ", ssrHydrateConfig=" + this.f536754l + ", enterFrom=" + this.f536755m + ", useXBridge3=" + this.f536756n + ", compactConfig=" + this.f536757o + ')';
    }

    public static a a(a r110, String r210, Uri r211, TemplateData r212, ra.b r213, String r214, TemplateData r215, b r216, boolean r217, c r218, int r219) {
        if ((r219 & 1) == 0) goto L5;
        String r100 = r110.f536743a;
    L7:
        if ((r219 & 2) == 0) goto L9;
        Uri r101 = r110.f536744b;
    L11:
        if ((r219 & 4) == 0) goto L13;
        String r102 = r110.f536745c;
    L15:
        if ((r219 & 8) == 0) goto L17;
        TemplateData r103 = r110.f536746d;
    L19:
        if ((r219 & 16) == 0) goto L21;
        Object r104 = r110.f536747e;
    L23:
        if ((r219 & 32) == 0) goto L25;
        ra.b r105 = r110.f536748f;
    L27:
        if ((r219 & 64) == 0) goto L29;
        String r111 = r110.f536749g;
    L31:
        if ((r219 & 128) == 0) goto L33;
        TemplateData r112 = r110.f536750h;
    L35:
        if ((r219 & 256) == 0) goto L37;
        b r113 = r110.f536751i;
    L39:
        if ((r219 & 512) == 0) goto L41;
        boolean r114 = r110.f536752j;
    L43:
        if ((r219 & 1024) == 0) goto L45;
        boolean r106 = r110.f536753k;
    L47:
        if ((r219 & 2048) == 0) goto L49;
        c r115 = r110.f536754l;
    L51:
        if ((r219 & 4096) == 0) goto L53;
        String r107 = r110.f536755m;
    L55:
        if ((r219 & 8192) == 0) goto L57;
        boolean r116 = r110.f536756n;
    L59:
        if ((r219 & 16384) == 0) goto L61;
        C7451a r117 = r110.f536757o;
    L62:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "originalUri");
        Intrinsics.checkNotNullParameter(r102, "bid");
        Intrinsics.checkNotNullParameter(r105, "lynxViewBuilderParams");
        Intrinsics.checkNotNullParameter(r111, "sessionId");
        Intrinsics.checkNotNullParameter(r107, "enterFrom");
        boolean r118 = r106;
        return new a(r100, r101, r102, r103, r104, r105, r111, r112, r113, r114, r118, r115, r107, r116, r117);
    L61:
        r117 = null;
        goto L62
    L57:
        r116 = false;
        goto L59
    L53:
        r107 = null;
        goto L55
    L49:
        r115 = r218;
        goto L51
    L45:
        r106 = false;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r112 = r215;
        goto L35
    L29:
        r111 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = null;
        goto L23
    L17:
        r103 = r212;
        goto L19
    L13:
        r102 = null;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }

    public /* synthetic */ a(String r110, Uri r210, String r211, TemplateData r212, Object r213, ra.b r214, String r215, TemplateData r216, b r217, boolean r218, boolean r219, c r310, String r311, C7451a r312, int r313) {
        if ((r313 & 4) == 0) goto L5;
        String r100 = "default_bid";
    L7:
        if ((r313 & 8) == 0) goto L9;
        TemplateData r101 = null;
    L11:
        if ((r313 & 16) == 0) goto L13;
        Object r102 = null;
    L15:
        if ((r313 & 128) == 0) goto L17;
        TemplateData r111 = null;
    L19:
        if ((r313 & 256) == 0) goto L21;
        b r112 = null;
    L23:
        if ((r313 & 512) == 0) goto L25;
        boolean r113 = false;
    L27:
        if ((r313 & 1024) == 0) goto L29;
        boolean r114 = false;
    L31:
        if ((r313 & 2048) == 0) goto L33;
        c r115 = null;
    L35:
        if ((r313 & 4096) == 0) goto L37;
        String r116 = "annieXCard";
    L39:
        if ((r313 & 8192) == 0) goto L41;
        boolean r117 = true;
    L43:
        if ((r313 & 16384) == 0) goto L45;
        C7451a r118 = null;
    L46:
        this(r110, r210, r100, r101, r102, r214, r215, r111, r112, r113, r114, r115, r116, r117, r118);
        return;
    L45:
        r118 = r312;
        goto L46
    L41:
        r117 = false;
        goto L43
    L37:
        r116 = r311;
        goto L39
    L33:
        r115 = r310;
        goto L35
    L29:
        r114 = r219;
        goto L31
    L25:
        r113 = r218;
        goto L27
    L21:
        r112 = r217;
        goto L23
    L17:
        r111 = r216;
        goto L19
    L13:
        r102 = r213;
        goto L15
    L9:
        r101 = r212;
        goto L11
    L5:
        r100 = r211;
        goto L7
    }

    public a(String r100, Uri r110, String r111, TemplateData r112, Object r113, ra.b r114, String r115, TemplateData r116, b r117, boolean r118, boolean r119, c r210, String r211, boolean r212, C7451a r213) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r110, "originalUri");
        Intrinsics.checkNotNullParameter(r111, "bid");
        Intrinsics.checkNotNullParameter(r114, "lynxViewBuilderParams");
        Intrinsics.checkNotNullParameter(r115, "sessionId");
        Intrinsics.checkNotNullParameter(r211, "enterFrom");
        this.f536743a = r100;
        this.f536744b = r110;
        this.f536745c = r111;
        this.f536746d = r112;
        this.f536747e = r113;
        this.f536748f = r114;
        this.f536749g = r115;
        this.f536750h = r116;
        this.f536751i = r117;
        this.f536752j = r118;
        this.f536753k = r119;
        this.f536754l = r210;
        this.f536755m = r211;
        this.f536756n = r212;
        this.f536757o = r213;
        this.f536759q = "";
    }
}

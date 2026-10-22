package mr9;

import android.content.Context;
import com.larus.platform.model.upload.ResourceAttachmentExtra;
import com.larus.platform.model.upload.ResourceUploadError;
import com.larus.platform.model.upload.UploadDataType;
import java.util.concurrent.CountDownLatch;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f514999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f515000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final UploadDataType f515001c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<l, Unit> f515002d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<k, Unit> f515003e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<ResourceUploadError, Unit> f515004f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f515005g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public m f515006h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f515007i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Context f515008j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f515009k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f515010l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f515011m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final CountDownLatch f515012n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final h f515013o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f515014p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Boolean f515015q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final c f515016r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f515017s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Long f515018t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Function1<String, Unit> f515019u;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f514999a, r101.f514999a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f515000b, r101.f515000b) == true) goto L15;
        return false;
    L15:
        if (this.f515001c == r101.f515001c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f515002d, r101.f515002d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f515003e, r101.f515003e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f515004f, r101.f515004f) == true) goto L27;
        return false;
    L27:
        if (this.f515005g == r101.f515005g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f515006h, r101.f515006h) == true) goto L33;
        return false;
    L33:
        if (this.f515007i == r101.f515007i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f515008j, r101.f515008j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f515009k, r101.f515009k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f515010l, r101.f515010l) == true) goto L45;
        return false;
    L45:
        if (this.f515011m == r101.f515011m) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f515012n, r101.f515012n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f515013o, r101.f515013o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f515014p, r101.f515014p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f515015q, r101.f515015q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.f515016r, r101.f515016r) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.f515017s, r101.f515017s) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.f515018t, r101.f515018t) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.f515019u, r101.f515019u) == true) goto L71;
        return false;
    L71:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((this.f514999a.hashCode() * 31) + this.f515000b.hashCode()) * 31) + this.f515001c.hashCode()) * 31) + this.f515002d.hashCode()) * 31) + this.f515003e.hashCode()) * 31) + this.f515004f.hashCode()) * 31;
        int r101 = 1231;
        if (this.f515005g == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        m r104 = this.f515006h;
        int r105 = 0;
        if (r104 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((r103 + r106) * 31) + this.f515007i) * 31;
        Context r108 = this.f515008j;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f515009k;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f515010l;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        if (this.f515011m == true) goto L26;
        r101 = 1237;
    L26:
        int r117 = (r116 + r101) * 31;
        CountDownLatch r118 = this.f515012n;
        if (r118 != null) goto L29;
        int r119 = 0;
    L30:
        int r120 = (((r117 + r119) * 31) + this.f515013o.hashCode()) * 31;
        String r121 = this.f515014p;
        if (r121 != null) goto L33;
        int r122 = 0;
    L34:
        int r123 = (r120 + r122) * 31;
        Boolean r124 = this.f515015q;
        if (r124 != null) goto L37;
        int r125 = 0;
    L38:
        int r126 = (r123 + r125) * 31;
        c r127 = this.f515016r;
        if (r127 != null) goto L41;
        int r128 = 0;
    L42:
        int r129 = (r126 + r128) * 31;
        String r130 = this.f515017s;
        if (r130 != null) goto L45;
        int r131 = 0;
    L46:
        int r132 = (r129 + r131) * 31;
        Long r133 = this.f515018t;
        if (r133 != null) goto L49;
        int r134 = 0;
    L50:
        int r135 = (r132 + r134) * 31;
        Function1<String, Unit> r136 = this.f515019u;
        if (r136 == null) goto L55;
        r105 = r136.hashCode();
    L55:
        return r135 + r105;
    L49:
        r134 = r133.hashCode();
        goto L50
    L45:
        r131 = r130.hashCode();
        goto L46
    L41:
        r128 = r127.hashCode();
        goto L42
    L37:
        r125 = r124.hashCode();
        goto L38
    L33:
        r122 = r121.hashCode();
        goto L34
    L29:
        r119 = r118.hashCode();
        goto L30
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
        r106 = r104.hashCode();
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "ResourceUploadParam(path=" + this.f514999a + ", scene=" + this.f515000b + ", dataType=" + this.f515001c + ", successCallback=" + this.f515002d + ", processCallback=" + this.f515003e + ", failedCallback=" + this.f515004f + ", pathIsUri=" + this.f515005g + ", tokenData=" + this.f515006h + ", fileNumber=" + this.f515007i + ", context=" + this.f515008j + ", fileExtension=" + this.f515009k + ", uploaderIdentifier=" + this.f515010l + ", limitUploaderCount=" + this.f515011m + ", latch=" + this.f515012n + ", resourceUploadParam=" + this.f515013o + ", originPath=" + this.f515014p + ", originPathIsUri=" + this.f515015q + ", instantUploadPolicy=" + this.f515016r + ", uploadSourceScene=" + this.f515017s + ", uploadFileSize=" + this.f515018t + ", audioUploadReporter=" + this.f515019u + ')';
    }

    public final Function1<String, Unit> b() {
        return this.f515019u;
    }

    public final c c() {
        return this.f515016r;
    }

    public final String d() {
        return this.f515000b;
    }

    public final String e() {
        return this.f515017s;
    }

    public final Context getContext() {
        return this.f515008j;
    }

    public static j a(j r210, String r211, com.larus.bmhome.rc.b r212, com.larus.bmhome.rc.c r213, com.larus.bmhome.rc.d r214, String r310, int r311) {
        if ((r311 & 1) == 0) goto L5;
        String r100 = r210.f514999a;
    L7:
        if ((r311 & 2) == 0) goto L9;
        String r101 = r210.f515000b;
    L11:
        if ((r311 & 4) == 0) goto L13;
        UploadDataType r102 = r210.f515001c;
    L15:
        if ((r311 & 8) == 0) goto L17;
        Function1<l, Unit> r103 = r210.f515002d;
    L19:
        if ((r311 & 16) == 0) goto L21;
        Function1<k, Unit> r104 = r210.f515003e;
    L23:
        if ((r311 & 32) == 0) goto L25;
        Function1<ResourceUploadError, Unit> r105 = r210.f515004f;
    L27:
        if ((r311 & 64) == 0) goto L29;
        boolean r106 = r210.f515005g;
    L31:
        if ((r311 & 128) == 0) goto L33;
        m r110 = r210.f515006h;
    L35:
        if ((r311 & 256) == 0) goto L37;
        int r111 = r210.f515007i;
    L39:
        if ((r311 & 512) == 0) goto L41;
        Context r112 = r210.f515008j;
    L43:
        if ((r311 & 1024) == 0) goto L45;
        String r113 = r210.f515009k;
    L47:
        if ((r311 & 2048) == 0) goto L49;
        String r114 = r210.f515010l;
    L51:
        if ((r311 & 4096) == 0) goto L53;
        boolean r115 = r210.f515011m;
    L55:
        if ((r311 & 8192) == 0) goto L57;
        CountDownLatch r116 = r210.f515012n;
    L59:
        if ((r311 & 16384) == 0) goto L61;
        h r117 = r210.f515013o;
    L63:
        if ((32768 & r311) == 0) goto L65;
        String r118 = r210.f515014p;
    L67:
        if ((65536 & r311) == 0) goto L69;
        Boolean r215 = r210.f515015q;
    L71:
        if ((131072 & r311) == 0) goto L73;
        c r216 = r210.f515016r;
    L75:
        if ((262144 & r311) == 0) goto L77;
        String r217 = r210.f515017s;
    L79:
        if ((524288 & r311) == 0) goto L81;
        Long r218 = r210.f515018t;
    L83:
        if ((r311 & 1048576) == 0) goto L85;
        Function1<String, Unit> r219 = r210.f515019u;
    L86:
        r210.getClass();
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r101, "scene");
        Intrinsics.checkNotNullParameter(r102, "dataType");
        Intrinsics.checkNotNullParameter(r103, "successCallback");
        Intrinsics.checkNotNullParameter(r104, "processCallback");
        Intrinsics.checkNotNullParameter(r105, "failedCallback");
        Intrinsics.checkNotNullParameter(r117, "resourceUploadParam");
        h r107 = r117;
        return new j(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r116, r107, r118, r215, r216, r217, r218, r219);
    L85:
        r219 = null;
        goto L86
    L81:
        r218 = null;
        goto L83
    L77:
        r217 = null;
        goto L79
    L73:
        r216 = null;
        goto L75
    L69:
        r215 = null;
        goto L71
    L65:
        r118 = null;
        goto L67
    L61:
        r117 = null;
        goto L63
    L57:
        r116 = null;
        goto L59
    L53:
        r115 = false;
        goto L55
    L49:
        r114 = r310;
        goto L51
    L45:
        r113 = null;
        goto L47
    L41:
        r112 = null;
        goto L43
    L37:
        r111 = 0;
        goto L39
    L33:
        r110 = null;
        goto L35
    L29:
        r106 = false;
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
        r102 = null;
        goto L15
    L9:
        r101 = null;
        goto L11
    L5:
        r100 = r211;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ j(String r210, String r211, UploadDataType r212, Function1 r213, Function1 r310, Function1 r311, boolean r312, m r313, Context r314, String r315, String r316, boolean r317, CountDownLatch r318, h r319, String r410, Boolean r411, c r412, String r413, Long r414, com.larus.bmhome.chat.component.bottom.multimodal.upload.i r415, int r416) {
        boolean r100 = false;
        if ((r416 & 64) == 0) goto L5;
        boolean r110 = false;
    L6:
        ResourceAttachmentExtra r101 = null;
        Object[] r102 = 0;
        if ((r416 & 128) == 0) goto L9;
        m r111 = null;
    L11:
        if ((r416 & 256) == 0) goto L13;
        int r112 = 1;
    L15:
        if ((r416 & 512) == 0) goto L17;
        Context r113 = null;
    L19:
        if ((r416 & 1024) == 0) goto L21;
        String r114 = null;
    L23:
        if ((r416 & 2048) == 0) goto L25;
        String r115 = null;
    L27:
        if ((r416 & 4096) == 0) goto L29;
        boolean r116 = false;
    L31:
        if ((r416 & 8192) == 0) goto L33;
        CountDownLatch r117 = null;
    L35:
        if ((r416 & 16384) == 0) goto L37;
        h r118 = new h(r100, r101, r102 == true ? 1 : 0, 31);
    L39:
        if ((32768 & r416) == 0) goto L41;
        String r119 = null;
    L43:
        if ((65536 & r416) == 0) goto L45;
        Boolean r214 = null;
    L47:
        if ((131072 & r416) == 0) goto L49;
        c r215 = null;
    L51:
        if ((262144 & r416) == 0) goto L53;
        String r216 = null;
    L55:
        if ((524288 & r416) == 0) goto L57;
        Long r217 = null;
    L59:
        if ((r416 & 1048576) == 0) goto L61;
        com.larus.bmhome.chat.component.bottom.multimodal.upload.i r218 = null;
    L62:
        this(r210, r211, r212, r213, r310, r311, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r214, r215, r216, r217, r218);
        return;
    L61:
        r218 = r415;
        goto L62
    L57:
        r217 = r414;
        goto L59
    L53:
        r216 = r413;
        goto L55
    L49:
        r215 = r412;
        goto L51
    L45:
        r214 = r411;
        goto L47
    L41:
        r119 = r410;
        goto L43
    L37:
        r118 = r319;
        goto L39
    L33:
        r117 = r318;
        goto L35
    L29:
        r116 = r317;
        goto L31
    L25:
        r115 = r316;
        goto L27
    L21:
        r114 = r315;
        goto L23
    L17:
        r113 = r314;
        goto L19
    L13:
        r112 = 0;
        goto L15
    L9:
        r111 = r313;
        goto L11
    L5:
        r110 = r312;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(String r110, String r111, UploadDataType r112, Function1<? super l, Unit> r113, Function1<? super k, Unit> r114, Function1<? super ResourceUploadError, Unit> r115, boolean r116, m r117, int r118, Context r119, String r210, String r211, boolean r212, CountDownLatch r213, h r214, String r215, Boolean r216, c r217, String r218, Long r219, Function1<? super String, Unit> r310) {
        Intrinsics.checkNotNullParameter(r110, "path");
        Intrinsics.checkNotNullParameter(r111, "scene");
        Intrinsics.checkNotNullParameter(r112, "dataType");
        Intrinsics.checkNotNullParameter(r113, "successCallback");
        Intrinsics.checkNotNullParameter(r114, "processCallback");
        Intrinsics.checkNotNullParameter(r115, "failedCallback");
        Intrinsics.checkNotNullParameter(r214, "resourceUploadParam");
        this.f514999a = r110;
        this.f515000b = r111;
        this.f515001c = r112;
        this.f515002d = r113;
        this.f515003e = r114;
        this.f515004f = r115;
        this.f515005g = r116;
        this.f515006h = r117;
        this.f515007i = r118;
        this.f515008j = r119;
        this.f515009k = r210;
        this.f515010l = r211;
        this.f515011m = r212;
        this.f515012n = r213;
        this.f515013o = r214;
        this.f515014p = r215;
        this.f515015q = r216;
        this.f515016r = r217;
        this.f515017s = r218;
        this.f515018t = r219;
        this.f515019u = r310;
    }
}

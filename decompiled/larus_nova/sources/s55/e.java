package s55;

import com.bytedance.ee.bear.drive.biz.permission.handler.PermissionOperation;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.larus.nova.R;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f540738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PermissionOperation f540739b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f540740c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f540741d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f540742e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Long f540743f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final sbb.e f540744g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final FileBizDomain f540745h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f540746i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f540747j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f540748k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f540749l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Long f540750m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Long f540751n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Long f540752o;

    public e(String r110, PermissionOperation r111, String r112, Long r210) {
        Intrinsics.checkNotNullParameter(r110, WikiFolderPushPlugin.OPT);
        Intrinsics.checkNotNullParameter(r111, "operationV2");
        this(r110, r111, R.string.CreationMobile_ECM_AdminDisableToast, "docx_file", r112, r210, null, null, null, null, null, null, null, null, 32704);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f540738a, r101.f540738a) == true) goto L12;
        return false;
    L12:
        if (this.f540739b == r101.f540739b) goto L15;
        return false;
    L15:
        if (this.f540740c == r101.f540740c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f540741d, r101.f540741d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f540742e, r101.f540742e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f540743f, r101.f540743f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f540744g, r101.f540744g) == true) goto L30;
        return false;
    L30:
        if (this.f540745h == r101.f540745h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f540746i, r101.f540746i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f540747j, r101.f540747j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f540748k, r101.f540748k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f540749l, r101.f540749l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f540750m, r101.f540750m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f540751n, r101.f540751n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f540752o, r101.f540752o) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f540738a.hashCode() * 31) + this.f540739b.hashCode()) * 31) + this.f540740c) * 31;
        String r101 = this.f540741d;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f540742e;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Long r108 = this.f540743f;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        sbb.e r111 = this.f540744g;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        FileBizDomain r114 = this.f540745h;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        String r117 = this.f540746i;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        String r120 = this.f540747j;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (r119 + r121) * 31;
        String r123 = this.f540748k;
        if (r123 != null) goto L33;
        int r124 = 0;
    L34:
        int r125 = (r122 + r124) * 31;
        String r126 = this.f540749l;
        if (r126 != null) goto L37;
        int r127 = 0;
    L38:
        int r128 = (r125 + r127) * 31;
        Long r129 = this.f540750m;
        if (r129 != null) goto L41;
        int r130 = 0;
    L42:
        int r131 = (r128 + r130) * 31;
        Long r132 = this.f540751n;
        if (r132 != null) goto L45;
        int r133 = 0;
    L46:
        int r134 = (r131 + r133) * 31;
        Long r135 = this.f540752o;
        if (r135 == null) goto L51;
        r102 = r135.hashCode();
    L51:
        return r134 + r102;
    L45:
        r133 = r132.hashCode();
        goto L46
    L41:
        r130 = r129.hashCode();
        goto L42
    L37:
        r127 = r126.hashCode();
        goto L38
    L33:
        r124 = r123.hashCode();
        goto L34
    L29:
        r121 = r120.hashCode();
        goto L30
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
        return "PermissionParam(operation=" + this.f540738a + ", operationV2=" + this.f540739b + ", unableTips=" + this.f540740c + ", mountPoint=" + this.f540741d + ", token=" + this.f540742e + ", senderTenantID=" + this.f540743f + ", tokenEntityType=" + this.f540744g + ", scopedFileBizDomain=" + this.f540745h + ", scopedEntityOperate=" + this.f540746i + ", scopedEntityType=" + this.f540747j + ", msgId=" + this.f540748k + ", fileKey=" + this.f540749l + ", chatID=" + this.f540750m + ", chatType=" + this.f540751n + ", senderUserId=" + this.f540752o + ')';
    }

    public e(String r110, PermissionOperation r111, int r112, String r210, String r211, Long r212, sbb.e r213, FileBizDomain r214, String r215, String r216, String r217, Long r218, Long r219, Long r310, int r311) {
        String r100 = "";
        if ((r311 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r311 & 2) == 0) goto L9;
        PermissionOperation r102 = PermissionOperation.UNKNOWN;
    L11:
        if ((r311 & 4) == 0) goto L13;
        int r103 = -1;
    L15:
        if ((r311 & 16) != 0) goto L19;
        r100 = r211;
    L19:
        if ((r311 & 32) == 0) goto L21;
        Long r104 = -1L;
    L23:
        if ((r311 & 64) == 0) goto L25;
        sbb.e r105 = null;
    L27:
        if ((r311 & 128) == 0) goto L29;
        FileBizDomain r106 = null;
    L31:
        if ((r311 & 256) == 0) goto L33;
        String r113 = null;
    L35:
        if ((r311 & 512) == 0) goto L37;
        String r114 = null;
    L39:
        if ((r311 & 1024) == 0) goto L41;
        String r115 = null;
    L43:
        if ((r311 & 4096) == 0) goto L45;
        Long r116 = null;
    L47:
        if ((r311 & 8192) == 0) goto L49;
        Long r117 = null;
    L51:
        if ((r311 & 16384) == 0) goto L53;
        Long r107 = null;
    L54:
        Intrinsics.checkNotNullParameter(r101, WikiFolderPushPlugin.OPT);
        Intrinsics.checkNotNullParameter(r102, "operationV2");
        this.f540738a = r101;
        this.f540739b = r102;
        this.f540740c = r103;
        this.f540741d = r210;
        this.f540742e = r100;
        this.f540743f = r104;
        this.f540744g = r105;
        this.f540745h = r106;
        this.f540746i = r113;
        this.f540747j = r114;
        this.f540748k = r115;
        this.f540749l = null;
        this.f540750m = r116;
        this.f540751n = r117;
        this.f540752o = r107;
        return;
    L53:
        r107 = r310;
        goto L54
    L49:
        r117 = r219;
        goto L51
    L45:
        r116 = r218;
        goto L47
    L41:
        r115 = r217;
        goto L43
    L37:
        r114 = r216;
        goto L39
    L33:
        r113 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}

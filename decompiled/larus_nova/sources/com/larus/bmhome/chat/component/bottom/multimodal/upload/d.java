package com.larus.bmhome.chat.component.bottom.multimodal.upload;

import com.larus.im.bean.message.UplinkFileEntity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f300198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f300199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f300200c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final n f300201d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final UplinkFileEntity f300202e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f300203f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f300204g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f300205h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f300206i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f300207j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f300208k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f300209l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Boolean f300210m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final mr9.c f300211n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f300212o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Long f300213p;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f300198a == r101.f300198a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f300199b, r101.f300199b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f300200c, r101.f300200c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f300201d, r101.f300201d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f300202e, r101.f300202e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f300203f, r101.f300203f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f300204g, r101.f300204g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f300205h, r101.f300205h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f300206i, r101.f300206i) == true) goto L36;
        return false;
    L36:
        if (this.f300207j == r101.f300207j) goto L39;
        return false;
    L39:
        if (this.f300208k == r101.f300208k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f300209l, r101.f300209l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f300210m, r101.f300210m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f300211n, r101.f300211n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f300212o, r101.f300212o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f300213p, r101.f300213p) == true) goto L56;
        return false;
    L56:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f300198a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((r101 * 31) + this.f300199b.hashCode()) * 31;
        String r103 = this.f300200c;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((((r102 + r105) * 31) + this.f300201d.hashCode()) * 31) + this.f300202e.hashCode()) * 31;
        String r107 = this.f300203f;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f300204g;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f300205h;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f300206i;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        if (this.f300207j == false) goto L29;
        int r119 = 1231;
    L30:
        int r120 = (r118 + r119) * 31;
        if (this.f300208k == true) goto L34;
        r100 = 1237;
    L34:
        int r121 = (r120 + r100) * 31;
        String r122 = this.f300209l;
        if (r122 != null) goto L37;
        int r123 = 0;
    L38:
        int r124 = (r121 + r123) * 31;
        Boolean r125 = this.f300210m;
        if (r125 != null) goto L41;
        int r126 = 0;
    L42:
        int r127 = (r124 + r126) * 31;
        mr9.c r128 = this.f300211n;
        if (r128 != null) goto L45;
        int r129 = 0;
    L46:
        int r130 = (r127 + r129) * 31;
        String r131 = this.f300212o;
        if (r131 != null) goto L49;
        int r132 = 0;
    L50:
        int r133 = (r130 + r132) * 31;
        Long r134 = this.f300213p;
        if (r134 == null) goto L55;
        r104 = r134.hashCode();
    L55:
        return r133 + r104;
    L49:
        r132 = r131.hashCode();
        goto L50
    L45:
        r129 = r128.hashCode();
        goto L46
    L41:
        r126 = r125.hashCode();
        goto L42
    L37:
        r123 = r122.hashCode();
        goto L38
    L29:
        r119 = 1237;
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
        r105 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "FileUploadParam(limitUploaderCount=" + this.f300198a + ", localPath=" + this.f300199b + ", fileName=" + this.f300200c + ", listener=" + this.f300201d + ", entity=" + this.f300202e + ", conversationId=" + this.f300203f + ", botId=" + this.f300204g + ", sectionId=" + this.f300205h + ", localSendMsgId=" + this.f300206i + ", skippedAttachment=" + this.f300207j + ", enableResourceCenter=" + this.f300208k + ", originPath=" + this.f300209l + ", originPathIsUri=" + this.f300210m + ", instantUploadPolicy=" + this.f300211n + ", uploadSourceScene=" + this.f300212o + ", uploadFileSize=" + this.f300213p + ')';
    }

    public d(boolean r110, String r111, String r210, m r211, UplinkFileEntity r212, String r213, String r214, String r215, String r216, boolean r217, boolean r218, String r219, Boolean r310, mr9.c r311, String r312, Long r313, int r314) {
        Long r100 = null;
        if ((r314 & 32) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r314 & 64) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r314 & 128) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r314 & 256) == 0) goto L17;
        String r104 = null;
    L18:
        boolean r112 = false;
        if ((r314 & 512) == 0) goto L21;
        boolean r113 = false;
    L23:
        if ((r314 & 1024) != 0) goto L27;
        r112 = r218;
    L27:
        if ((r314 & 2048) == 0) goto L29;
        String r114 = null;
    L31:
        if ((r314 & 4096) == 0) goto L33;
        Boolean r115 = null;
    L35:
        if ((r314 & 8192) == 0) goto L37;
        mr9.c r116 = null;
    L39:
        if ((r314 & 16384) == 0) goto L41;
        String r117 = null;
    L43:
        if ((r314 & 32768) != 0) goto L46;
        r100 = r313;
    L46:
        Intrinsics.checkNotNullParameter(r111, "localPath");
        Intrinsics.checkNotNullParameter(r211, "listener");
        Intrinsics.checkNotNullParameter(r212, "entity");
        this.f300198a = r110;
        this.f300199b = r111;
        this.f300200c = r210;
        this.f300201d = r211;
        this.f300202e = r212;
        this.f300203f = r101;
        this.f300204g = r102;
        this.f300205h = r103;
        this.f300206i = r104;
        this.f300207j = r113;
        this.f300208k = r112;
        this.f300209l = r114;
        this.f300210m = r115;
        this.f300211n = r116;
        this.f300212o = r117;
        this.f300213p = r100;
        return;
    L41:
        r117 = r312;
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
    L21:
        r113 = r217;
        goto L23
    L17:
        r104 = r216;
        goto L18
    L13:
        r103 = r215;
        goto L15
    L9:
        r102 = r214;
        goto L11
    L5:
        r101 = r213;
        goto L7
    }
}

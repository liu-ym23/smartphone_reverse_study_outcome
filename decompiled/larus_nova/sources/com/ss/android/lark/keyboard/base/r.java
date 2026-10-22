package com.ss.android.lark.keyboard.base;

import android.content.Context;
import android.net.Uri;
import com.ss.android.lark.biz.im.api.extension.keyboard.attachment.UplinkFileEntity;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f428259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f428260b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f428261c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Long f428262d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Boolean f428263e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f428264f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f428265g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f428266h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f428267i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<UplinkFileEntity> f428268j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<ChatAttachmentEntity> f428269k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f428270l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f428271m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Integer f428272n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Integer f428273o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f428274p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Uri f428275q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f428276r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public xcb.a f428277s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f428278t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final RichText f428279u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f428280v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Map<String, ResourceUploadInfo> f428281w;

    public r() {
        this(null, false, false, null, null, null, false, null, null, 8388607);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L8;
        return false;
    L8:
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.f428259a, r101.f428259a) == true) goto L12;
        return false;
    L12:
        if (this.f428260b == r101.f428260b) goto L15;
        return false;
    L15:
        if (this.f428261c == r101.f428261c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f428262d, r101.f428262d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f428263e, r101.f428263e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f428264f, r101.f428264f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f428265g, r101.f428265g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f428266h, r101.f428266h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f428267i, r101.f428267i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f428268j, r101.f428268j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f428269k, r101.f428269k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f428270l, r101.f428270l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f428271m, r101.f428271m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f428272n, r101.f428272n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f428273o, r101.f428273o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f428274p, r101.f428274p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f428275q, r101.f428275q) == true) goto L60;
        return false;
    L60:
        if (this.f428276r == r101.f428276r) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.f428277s, r101.f428277s) == true) goto L66;
        return false;
    L66:
        if (this.f428278t == r101.f428278t) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.f428279u, r101.f428279u) == true) goto L72;
        return false;
    L72:
        if (this.f428280v == r101.f428280v) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.f428281w, r101.f428281w) == true) goto L77;
        return false;
    L77:
        return true;
    }

    public final int hashCode() {
        Context r100 = this.f428259a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        int r104 = 1231;
        if (this.f428260b == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r103 + r105) * 31;
        if (this.f428261c == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (r106 + r107) * 31;
        Long r109 = this.f428262d;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r108 + r110) * 31;
        Boolean r112 = this.f428263e;
        if (r112 != null) goto L21;
        int r113 = 0;
    L22:
        int r114 = (r111 + r113) * 31;
        String r115 = this.f428264f;
        if (r115 != null) goto L25;
        int r116 = 0;
    L26:
        int r117 = (r114 + r116) * 31;
        String r118 = this.f428265g;
        if (r118 != null) goto L29;
        int r119 = 0;
    L30:
        int r120 = (r117 + r119) * 31;
        String r121 = this.f428266h;
        if (r121 != null) goto L33;
        int r122 = 0;
    L34:
        int r123 = (r120 + r122) * 31;
        String r124 = this.f428267i;
        if (r124 != null) goto L37;
        int r125 = 0;
    L38:
        int r126 = (r123 + r125) * 31;
        List<UplinkFileEntity> r127 = this.f428268j;
        if (r127 != null) goto L41;
        int r128 = 0;
    L42:
        int r129 = (r126 + r128) * 31;
        List<ChatAttachmentEntity> r130 = this.f428269k;
        if (r130 != null) goto L45;
        int r131 = 0;
    L46:
        int r132 = (r129 + r131) * 31;
        String r133 = this.f428270l;
        if (r133 != null) goto L49;
        int r134 = 0;
    L50:
        int r135 = (r132 + r134) * 31;
        String r136 = this.f428271m;
        if (r136 != null) goto L53;
        int r137 = 0;
    L54:
        int r138 = (r135 + r137) * 31;
        Integer r139 = this.f428272n;
        if (r139 != null) goto L57;
        int r140 = 0;
    L58:
        int r141 = (r138 + r140) * 31;
        Integer r142 = this.f428273o;
        if (r142 != null) goto L61;
        int r143 = 0;
    L62:
        int r144 = (r141 + r143) * 31;
        String r145 = this.f428274p;
        if (r145 != null) goto L65;
        int r146 = 0;
    L66:
        int r147 = (r144 + r146) * 31;
        Uri r148 = this.f428275q;
        if (r148 != null) goto L69;
        int r149 = 0;
    L70:
        int r150 = (r147 + r149) * 31;
        if (this.f428276r == false) goto L73;
        int r151 = 1231;
    L74:
        int r152 = (r150 + r151) * 31;
        xcb.a r153 = this.f428277s;
        if (r153 != null) goto L77;
        int r154 = 0;
    L78:
        int r155 = (r152 + r154) * 31;
        if (this.f428278t == false) goto L81;
        int r156 = 1231;
    L82:
        int r157 = (r155 + r156) * 31;
        RichText r158 = this.f428279u;
        if (r158 != null) goto L85;
        int r159 = 0;
    L86:
        int r160 = (r157 + r159) * 31;
        if (this.f428280v == true) goto L90;
        r104 = 1237;
    L90:
        int r161 = (r160 + r104) * 31;
        Map<String, ResourceUploadInfo> r162 = this.f428281w;
        if (r162 == null) goto L95;
        r101 = r162.hashCode();
    L95:
        return r161 + r101;
    L85:
        r159 = r158.hashCode();
        goto L86
    L81:
        r156 = 1237;
        goto L82
    L77:
        r154 = r153.hashCode();
        goto L78
    L73:
        r151 = 1237;
        goto L74
    L69:
        r149 = r148.hashCode();
        goto L70
    L65:
        r146 = r145.hashCode();
        goto L66
    L61:
        r143 = r142.hashCode();
        goto L62
    L57:
        r140 = r139.hashCode();
        goto L58
    L53:
        r137 = r136.hashCode();
        goto L54
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
    L25:
        r116 = r115.hashCode();
        goto L26
    L21:
        r113 = r112.hashCode();
        goto L22
    L17:
        r110 = r109.hashCode();
        goto L18
    L13:
        r107 = 1237;
        goto L14
    L9:
        r105 = 1237;
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "SendInfoExtraParam(context=" + this.f428259a + ", isMentionDoubao=" + this.f428260b + ", voiceTextPostProcess=" + this.f428261c + ", sendWithQueueId=" + this.f428262d + ", isLastInBatch=" + this.f428263e + ", imageUploadId=" + this.f428264f + ", fileUploadId=" + this.f428265g + ", mediaUploadId=" + this.f428266h + ", firstScreenImageUploadId=" + this.f428267i + ", attachments=" + this.f428268j + ", fileAttachments=" + this.f428269k + ", rootMsgId=" + this.f428270l + ", parentMsgId=" + this.f428271m + ", imageWidth=" + this.f428272n + ", imageHeight=" + this.f428273o + ", resourcePath=" + this.f428274p + ", uri=" + this.f428275q + ", keepOrigin=" + this.f428276r + ", urlPreviewEntityPbBundle=" + this.f428277s + ", triggeredBySendButton=" + this.f428278t + ", draftRichText=" + this.f428279u + ", transmitToChat=" + this.f428280v + ", resourceUploadInfoMap=" + this.f428281w + ')';
    }

    public final Context getContext() {
        return this.f428259a;
    }

    public r(Context r100, boolean r101, boolean r102, List r103, String r104, String r105, boolean r110, RichText r111, Map r112, int r113) {
        if ((r113 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r113 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r113 & 4) == 0) goto L12;
        r102 = false;
    L12:
        if ((r113 & 512) == 0) goto L15;
        r103 = null;
    L15:
        if ((r113 & 2048) == 0) goto L18;
        r104 = null;
    L18:
        if ((r113 & 4096) == 0) goto L21;
        r105 = null;
    L21:
        if ((524288 & r113) == 0) goto L24;
        r110 = false;
    L24:
        if ((1048576 & r113) == 0) goto L27;
        r111 = null;
    L27:
        if ((r113 & 4194304) == 0) goto L29;
        r112 = null;
    L29:
        this.f428259a = r100;
        this.f428260b = r101;
        this.f428261c = r102;
        this.f428262d = null;
        this.f428263e = null;
        this.f428264f = null;
        this.f428265g = null;
        this.f428266h = null;
        this.f428267i = null;
        this.f428268j = r103;
        this.f428269k = null;
        this.f428270l = r104;
        this.f428271m = r105;
        this.f428272n = null;
        this.f428273o = null;
        this.f428274p = null;
        this.f428275q = null;
        this.f428276r = false;
        this.f428277s = null;
        this.f428278t = r110;
        this.f428279u = r111;
        this.f428280v = false;
        this.f428281w = r112;
    }
}

package com.bytedance.ee.bear.rn;

import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f236533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f236534b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f236535c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> f236536d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f236537e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f236538f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<Object, Object> f236539g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f236540h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f236541i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f236542j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f236543k;

    public d() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f236533a, r101.f236533a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f236534b, r101.f236534b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f236535c, r101.f236535c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f236536d, r101.f236536d) == true) goto L21;
        return false;
    L21:
        if (this.f236537e == r101.f236537e) goto L24;
        return false;
    L24:
        if (this.f236538f == r101.f236538f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f236539g, r101.f236539g) == true) goto L30;
        return false;
    L30:
        if (this.f236540h == r101.f236540h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f236541i, r101.f236541i) == true) goto L36;
        return false;
    L36:
        if (this.f236542j == r101.f236542j) goto L39;
        return false;
    L39:
        if (this.f236543k == r101.f236543k) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f236533a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f236534b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f236535c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r110 = this.f236536d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        int r113 = 1231;
        if (this.f236537e == false) goto L21;
        int r114 = 1231;
    L22:
        int r115 = (r112 + r114) * 31;
        if (this.f236538f == false) goto L25;
        int r116 = 1231;
    L26:
        int r117 = (r115 + r116) * 31;
        Map<Object, Object> r118 = this.f236539g;
        if (r118 != null) goto L29;
        int r119 = 0;
    L30:
        int r120 = (r117 + r119) * 31;
        if (this.f236540h == false) goto L33;
        int r121 = 1231;
    L34:
        int r122 = (r120 + r121) * 31;
        String r123 = this.f236541i;
        if (r123 == null) goto L38;
        r101 = r123.hashCode();
    L38:
        int r124 = (((r122 + r101) * 31) + this.f236542j) * 31;
        if (this.f236543k == true) goto L43;
        r113 = 1237;
    L43:
        return r124 + r113;
    L33:
        r121 = 1237;
        goto L34
    L29:
        r119 = r118.hashCode();
        goto L30
    L25:
        r116 = 1237;
        goto L26
    L21:
        r114 = 1237;
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
        return "EditCommentParams(commentId=" + this.f236533a + ", replyId=" + this.f236534b + ", content=" + this.f236535c + ", images=" + this.f236536d + ", isAudio=" + this.f236537e + ", whole=" + this.f236538f + ", bizParams=" + this.f236539g + ", shouldAuthorize=" + this.f236540h + ", reply_uuid=" + this.f236541i + ", commentType=" + this.f236542j + ", hasAreaAdded=" + this.f236543k + ')';
    }

    public d(String r100, String r101, String r102, List r103, boolean r104, boolean r105, Map r110, boolean r111, int r112, boolean r113, int r114) {
        if ((r114 & 8) == 0) goto L6;
        r103 = null;
    L6:
        if ((r114 & 16) == 0) goto L9;
        r104 = false;
    L9:
        if ((r114 & 32) == 0) goto L12;
        r105 = false;
    L12:
        if ((r114 & 64) == 0) goto L15;
        r110 = null;
    L15:
        if ((r114 & 128) == 0) goto L18;
        r111 = false;
    L18:
        if ((r114 & 512) == 0) goto L21;
        r112 = 0;
    L21:
        if ((r114 & 1024) == 0) goto L23;
        r113 = false;
    L23:
        this.f236533a = r100;
        this.f236534b = r101;
        this.f236535c = r102;
        this.f236536d = r103;
        this.f236537e = r104;
        this.f236538f = r105;
        this.f236539g = r110;
        this.f236540h = r111;
        this.f236541i = null;
        this.f236542j = r112;
        this.f236543k = r113;
    }
}

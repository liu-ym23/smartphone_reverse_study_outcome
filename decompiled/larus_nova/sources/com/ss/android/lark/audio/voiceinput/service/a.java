package com.ss.android.lark.audio.voiceinput.service;

import com.bytedance.lark.pb.basic.v1.RichText;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f409408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f409409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f409410c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f409411d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<Integer> f409412e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f409413f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<com.ss.android.lark.audio.voiceinput.a> f409414g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final RichText f409415h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final RichText f409416i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<com.ss.android.lark.audio.voiceinput.a> f409417j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f409418k;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f409408a, r101.f409408a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f409409b, r101.f409409b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f409410c, r101.f409410c) == true) goto L18;
        return false;
    L18:
        if (this.f409411d == r101.f409411d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f409412e, r101.f409412e) == true) goto L24;
        return false;
    L24:
        if (this.f409413f == r101.f409413f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f409414g, r101.f409414g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f409415h, r101.f409415h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f409416i, r101.f409416i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f409417j, r101.f409417j) == true) goto L39;
        return false;
    L39:
        if (this.f409418k == r101.f409418k) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f409408a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f409409b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f409410c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        int r110 = 1231;
        if (this.f409411d == false) goto L17;
        int r111 = 1231;
    L18:
        int r112 = (r109 + r111) * 31;
        List<Integer> r113 = this.f409412e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (((r112 + r114) * 31) + this.f409413f) * 31;
        List<com.ss.android.lark.audio.voiceinput.a> r116 = this.f409414g;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        RichText r119 = this.f409415h;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        RichText r122 = this.f409416i;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        List<com.ss.android.lark.audio.voiceinput.a> r125 = this.f409417j;
        if (r125 == null) goto L38;
        r101 = r125.hashCode();
    L38:
        int r126 = (r124 + r101) * 31;
        if (this.f409418k == true) goto L43;
        r110 = 1237;
    L43:
        return r126 + r110;
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
        r111 = 1237;
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
        return "Audio2TextResult(sourceId=" + this.f409408a + ", sequenceId=" + this.f409409b + ", result=" + this.f409410c + ", isEnd=" + this.f409411d + ", diffIndexSlice=" + this.f409412e + ", serverErrCode=" + this.f409413f + ", asrNerInfoList=" + this.f409414g + ", richTextResult=" + this.f409415h + ", originalRichTextResult=" + this.f409416i + ", originalAsrNerInfoList=" + this.f409417j + ", isFormatted=" + this.f409418k + ')';
    }

    public final String a() {
        String r100 = "sourceId:" + this.f409408a + " sequenceId:" + this.f409409b + " isEnd:" + this.f409411d;
        StringBuffer r101 = new StringBuffer();
        StringBuilder r102 = new StringBuilder("Audio2TextResult:");
        r102.append(r100);
        r102.append(" result length:");
        String r103 = this.f409410c;
        if (r103 == null) goto L5;
        Integer r104 = Integer.valueOf(r103.length());
    L6:
        r102.append(r104);
        r102.append(' ');
        r101.append(r102.toString());
        if (this.f409411d == false) goto L10;
        StringBuilder r105 = new StringBuilder(" desensitizedResult:");
        int r106 = com.ss.android.lark.audio.voiceinput.utils.b.f409445a;
        r105.append(com.ss.android.lark.audio.voiceinput.utils.b.a(this.f409410c));
        r101.append(r105.toString());
    L10:
        return r101.toString();
    L5:
        r104 = null;
        goto L6
    }

    public a(String r100, Integer r101, String r102, boolean r103, List<Integer> r104, int r105, List<com.ss.android.lark.audio.voiceinput.a> r106, RichText r107, RichText r108, List<com.ss.android.lark.audio.voiceinput.a> r110, boolean r111) {
        this.f409408a = r100;
        this.f409409b = r101;
        this.f409410c = r102;
        this.f409411d = r103;
        this.f409412e = r104;
        this.f409413f = r105;
        this.f409414g = r106;
        this.f409415h = r107;
        this.f409416i = r108;
        this.f409417j = r110;
        this.f409418k = r111;
    }
}

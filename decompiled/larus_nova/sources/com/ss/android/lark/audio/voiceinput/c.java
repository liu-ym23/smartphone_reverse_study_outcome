package com.ss.android.lark.audio.voiceinput;

import com.ss.android.lark.widget.richtext.RichText;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f409207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f409208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f409209c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f409210d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int[] f409211e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f409212f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<a> f409213g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final RichText f409214h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final RichText f409215i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<a> f409216j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f409217k;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f409207a, r101.f409207a) == true) goto L12;
        return false;
    L12:
        if (this.f409208b == r101.f409208b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f409209c, r101.f409209c) == true) goto L18;
        return false;
    L18:
        if (this.f409210d == r101.f409210d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f409211e, r101.f409211e) == true) goto L24;
        return false;
    L24:
        if (this.f409212f == r101.f409212f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f409213g, r101.f409213g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f409214h, r101.f409214h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f409215i, r101.f409215i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f409216j, r101.f409216j) == true) goto L39;
        return false;
    L39:
        if (this.f409217k == r101.f409217k) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f409207a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.f409208b) * 31;
        String r104 = this.f409209c;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        int r107 = 1231;
        if (this.f409210d == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (r106 + r108) * 31;
        int[] r110 = this.f409211e;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (((r109 + r111) * 31) + this.f409212f) * 31;
        List<a> r113 = this.f409213g;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        RichText r116 = this.f409214h;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        RichText r119 = this.f409215i;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        List<a> r122 = this.f409216j;
        if (r122 == null) goto L34;
        r101 = r122.hashCode();
    L34:
        int r123 = (r121 + r101) * 31;
        if (this.f409217k == true) goto L39;
        r107 = 1237;
    L39:
        return r123 + r107;
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
        r111 = Arrays.hashCode(r110);
        goto L18
    L13:
        r108 = 1237;
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "AudioAsrResult(uploadId=" + this.f409207a + ", sequenceId=" + this.f409208b + ", audio2Text=" + this.f409209c + ", isFinish=" + this.f409210d + ", diffIndex=" + Arrays.toString(this.f409211e) + ", serverErrCode=" + this.f409212f + ", asrNerInfoList=" + this.f409213g + ", richTextResult=" + this.f409214h + ", originalRichTextResult=" + this.f409215i + ", originalAsrNerInfoList=" + this.f409216j + ", isFormatted=" + this.f409217k + ')';
    }

    public c(String r100, int r101, String r102, boolean r103, int[] r104, int r105, List<a> r106, RichText r107, RichText r108, List<a> r110, boolean r111) {
        this.f409207a = r100;
        this.f409208b = r101;
        this.f409209c = r102;
        this.f409210d = r103;
        this.f409211e = r104;
        this.f409212f = r105;
        this.f409213g = r106;
        this.f409214h = r107;
        this.f409215i = r108;
        this.f409216j = r110;
        this.f409217k = r111;
    }
}

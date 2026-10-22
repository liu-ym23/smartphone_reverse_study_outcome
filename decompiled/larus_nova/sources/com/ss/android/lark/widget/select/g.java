package com.ss.android.lark.widget.select;

import com.bytedance.lark.pb.basic.v1.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f448425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f448426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f448427c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f448428d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f448429e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f448430f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f448431g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Message.PartialReplyInfo.PartialContentRelativePosition f448432h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f448425a, r101.f448425a) == true) goto L12;
        return false;
    L12:
        if (this.f448426b == r101.f448426b) goto L15;
        return false;
    L15:
        if (this.f448427c == r101.f448427c) goto L18;
        return false;
    L18:
        if (this.f448428d == r101.f448428d) goto L21;
        return false;
    L21:
        if (this.f448429e == r101.f448429e) goto L24;
        return false;
    L24:
        if (this.f448430f == r101.f448430f) goto L27;
        return false;
    L27:
        if (this.f448431g == r101.f448431g) goto L30;
        return false;
    L30:
        if (this.f448432h == r101.f448432h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.f448425a.hashCode() * 31) + this.f448426b) * 31) + this.f448427c) * 31) + this.f448428d) * 31) + this.f448429e) * 31;
        int r101 = 1231;
        if (this.f448430f == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f448431g == true) goto L11;
        r101 = 1237;
    L11:
        return ((r103 + r101) * 31) + this.f448432h.hashCode();
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "SelectedTextInfo(copyText=" + this.f448425a + ", top=" + this.f448426b + ", bottom=" + this.f448427c + ", start=" + this.f448428d + ", end=" + this.f448429e + ", isSelSingleLine=" + this.f448430f + ", isPartial=" + this.f448431g + ", partialContentRelativePosition=" + this.f448432h + ')';
    }

    public g(CharSequence r100, int r101, int r102, int r103, int r104, boolean r105, boolean r106, Message.PartialReplyInfo.PartialContentRelativePosition r107) {
        Intrinsics.checkNotNullParameter(r100, "copyText");
        Intrinsics.checkNotNullParameter(r107, "partialContentRelativePosition");
        this.f448425a = r100;
        this.f448426b = r101;
        this.f448427c = r102;
        this.f448428d = r103;
        this.f448429e = r104;
        this.f448430f = r105;
        this.f448431g = r106;
        this.f448432h = r107;
    }
}

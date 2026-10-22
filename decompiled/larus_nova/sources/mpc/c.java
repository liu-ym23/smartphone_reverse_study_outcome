package mpc;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f514768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f514769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f514770c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f514771d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f514772e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f514773f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final d f514774g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f514775h;

    public c() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f514768a, r101.f514768a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f514769b, r101.f514769b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f514770c, r101.f514770c) == true) goto L18;
        return false;
    L18:
        if (this.f514771d == r101.f514771d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f514772e, r101.f514772e) == true) goto L24;
        return false;
    L24:
        if (this.f514773f == r101.f514773f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f514774g, r101.f514774g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f514775h, r101.f514775h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f514768a.hashCode() * 31;
        String r101 = this.f514769b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (((r100 + r102) * 31) + this.f514770c.hashCode()) * 31;
        int r104 = 1231;
        if (this.f514771d == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (((r103 + r105) * 31) + this.f514772e.hashCode()) * 31;
        if (this.f514773f == true) goto L15;
        r104 = 1237;
    L15:
        return ((((r106 + r104) * 31) + this.f514774g.hashCode()) * 31) + this.f514775h.hashCode();
    L9:
        r105 = 1237;
        goto L10
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ForwardToDoubaoExecuteParams(larkMsgIds=" + this.f514768a + ", extraNote=" + this.f514769b + ", quasiTitle=" + this.f514770c + ", isGroupChat=" + this.f514771d + ", chatId=" + this.f514772e + ", isThreadRootMsg=" + this.f514773f + ", trackParams=" + this.f514774g + ", originMergeForwardId=" + this.f514775h + ')';
    }

    public c(List r100, String r101, String r102, boolean r103, String r104, boolean r105, String r106) {
        d r107 = new d(0);
        Intrinsics.checkNotNullParameter(r100, "larkMsgIds");
        Intrinsics.checkNotNullParameter(r102, "quasiTitle");
        Intrinsics.checkNotNullParameter(r104, "chatId");
        Intrinsics.checkNotNullParameter(r107, "trackParams");
        Intrinsics.checkNotNullParameter(r106, "originMergeForwardId");
        this.f514768a = r100;
        this.f514769b = r101;
        this.f514770c = r102;
        this.f514771d = r103;
        this.f514772e = r104;
        this.f514773f = r105;
        this.f514774g = r107;
        this.f514775h = r106;
    }
}

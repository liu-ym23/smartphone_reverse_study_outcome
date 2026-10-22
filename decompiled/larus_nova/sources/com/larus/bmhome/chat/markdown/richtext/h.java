package com.larus.bmhome.chat.markdown.richtext;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f307201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f307202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f307203c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f307204d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f307205e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f307206f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f307207g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (this.f307201a == r101.f307201a) goto L12;
        return false;
    L12:
        if (this.f307202b == r101.f307202b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f307203c, r101.f307203c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f307204d, r101.f307204d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f307205e, r101.f307205e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f307206f, r101.f307206f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f307207g, r101.f307207g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f307201a * 31) + this.f307202b) * 31;
        String r101 = this.f307203c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.f307204d.hashCode()) * 31;
        String r105 = this.f307205e;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f307206f;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f307207g;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
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
        return "MessageMarkdownMentionSpan(start=" + this.f307201a + ", end=" + this.f307202b + ", userId=" + this.f307203c + ", rawTag=" + this.f307204d + ", chatId=" + this.f307205e + ", avatarKey=" + this.f307206f + ", entityId=" + this.f307207g + ')';
    }

    public h(int r100, int r101, String r102, String r103, String r104, String r105, String r106) {
        Intrinsics.checkNotNullParameter(r103, "rawTag");
        this.f307201a = r100;
        this.f307202b = r101;
        this.f307203c = r102;
        this.f307204d = r103;
        this.f307205e = r104;
        this.f307206f = r105;
        this.f307207g = r106;
    }
}

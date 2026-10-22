package com.larus.bmhome.chat.markdown.richtext;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class f extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f307189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f307190b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f307191c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f307192d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f307193e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f307194f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f307195g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f307196h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.f307189a == r101.f307189a) goto L12;
        return false;
    L12:
        if (this.f307190b == r101.f307190b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f307191c, r101.f307191c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f307192d, r101.f307192d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f307193e, r101.f307193e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f307194f, r101.f307194f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f307195g, r101.f307195g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f307196h, r101.f307196h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f307189a * 31) + this.f307190b) * 31) + this.f307191c.hashCode()) * 31) + this.f307192d.hashCode()) * 31;
        String r101 = this.f307193e;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f307194f;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f307195g;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f307196h;
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
        return "MentionReplacement(start=" + this.f307189a + ", end=" + this.f307190b + ", displayText=" + this.f307191c + ", rawTag=" + this.f307192d + ", userId=" + this.f307193e + ", chatId=" + this.f307194f + ", avatarKey=" + this.f307195g + ", entityId=" + this.f307196h + ')';
    }

    @Override // com.larus.bmhome.chat.markdown.richtext.t
    public final String a() {
        return this.f307191c;
    }

    @Override // com.larus.bmhome.chat.markdown.richtext.t
    public final int b() {
        return this.f307190b;
    }

    @Override // com.larus.bmhome.chat.markdown.richtext.t
    public final int c() {
        return this.f307189a;
    }

    public f(int r100, int r101, String r102, String r103, String r104, String r105, String r106, String r107) {
        Intrinsics.checkNotNullParameter(r102, "displayText");
        Intrinsics.checkNotNullParameter(r103, "rawTag");
        this.f307189a = r100;
        this.f307190b = r101;
        this.f307191c = r102;
        this.f307192d = r103;
        this.f307193e = r104;
        this.f307194f = r105;
        this.f307195g = r106;
        this.f307196h = r107;
    }
}

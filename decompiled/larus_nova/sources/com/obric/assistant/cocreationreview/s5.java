package com.obric.assistant.cocreationreview;

import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class s5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f387720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f387721b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ModuleKey f387722c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Vote f387723d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<String> f387724e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f387725f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f387726g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<CocreationUserFeedbackAttachment> f387727h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<b5> f387728i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Integer f387729j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s5) == true) goto L8;
        return false;
    L8:
        s5 r101 = (s5) r100;
        if (Intrinsics.areEqual(this.f387720a, r101.f387720a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f387721b, r101.f387721b) == true) goto L15;
        return false;
    L15:
        if (this.f387722c == r101.f387722c) goto L18;
        return false;
    L18:
        if (this.f387723d == r101.f387723d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f387724e, r101.f387724e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f387725f, r101.f387725f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f387726g, r101.f387726g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f387727h, r101.f387727h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f387728i, r101.f387728i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f387729j, r101.f387729j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((((((((this.f387720a.hashCode() * 31) + this.f387721b.hashCode()) * 31) + this.f387722c.hashCode()) * 31) + this.f387723d.hashCode()) * 31) + this.f387724e.hashCode()) * 31) + this.f387725f.hashCode()) * 31) + this.f387726g.hashCode()) * 31) + this.f387727h.hashCode()) * 31) + this.f387728i.hashCode()) * 31;
        Integer r101 = this.f387729j;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "SubmitAnnotationRequest(requestId=" + this.f387720a + ", recordId=" + this.f387721b + ", businessId=" + this.f387722c + ", vote=" + this.f387723d + ", reasons=" + this.f387724e + ", comment=" + this.f387725f + ", businessPayload=" + this.f387726g + ", attachments=" + this.f387727h + ", feedbackMedia=" + this.f387728i + ", feedbackValue=" + this.f387729j + ')';
    }

    public s5(String r100, String r101, ModuleKey r102, Vote r103, Set<String> r104, String r105, String r106, List<CocreationUserFeedbackAttachment> r107, List<b5> r110, Integer r111) {
        Intrinsics.checkNotNullParameter(r100, "requestId");
        Intrinsics.checkNotNullParameter(r101, "recordId");
        Intrinsics.checkNotNullParameter(r102, "businessId");
        Intrinsics.checkNotNullParameter(r103, "vote");
        Intrinsics.checkNotNullParameter(r104, "reasons");
        Intrinsics.checkNotNullParameter(r105, "comment");
        Intrinsics.checkNotNullParameter(r106, "businessPayload");
        Intrinsics.checkNotNullParameter(r107, "attachments");
        Intrinsics.checkNotNullParameter(r110, "feedbackMedia");
        this.f387720a = r100;
        this.f387721b = r101;
        this.f387722c = r102;
        this.f387723d = r103;
        this.f387724e = r104;
        this.f387725f = r105;
        this.f387726g = r106;
        this.f387727h = r107;
        this.f387728i = r110;
        this.f387729j = r111;
    }
}

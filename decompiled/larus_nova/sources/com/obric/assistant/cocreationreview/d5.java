package com.obric.assistant.cocreationreview;

import com.alibaba.gaiax.template.GXTemplateKey;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class d5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f387241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f387242b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f387243c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f387244d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a5 f387245e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f387246f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f387247g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f387248h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f387249i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f387250j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f387251k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f387252l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f387253m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<b5> f387254n;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d5) == true) goto L8;
        return false;
    L8:
        d5 r101 = (d5) r100;
        if (Intrinsics.areEqual(this.f387241a, r101.f387241a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f387242b, r101.f387242b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f387243c, r101.f387243c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f387244d, r101.f387244d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f387245e, r101.f387245e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f387246f, r101.f387246f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f387247g, r101.f387247g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f387248h, r101.f387248h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f387249i, r101.f387249i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f387250j, r101.f387250j) == true) goto L39;
        return false;
    L39:
        if (this.f387251k == r101.f387251k) goto L42;
        return false;
    L42:
        if (this.f387252l == r101.f387252l) goto L45;
        return false;
    L45:
        if (this.f387253m == r101.f387253m) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f387254n, r101.f387254n) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((((((((((((this.f387241a.hashCode() * 31) + this.f387242b.hashCode()) * 31) + this.f387243c.hashCode()) * 31) + this.f387244d.hashCode()) * 31) + this.f387245e.hashCode()) * 31) + this.f387246f.hashCode()) * 31) + this.f387247g.hashCode()) * 31) + this.f387248h.hashCode()) * 31) + this.f387249i.hashCode()) * 31) + this.f387250j.hashCode()) * 31) + this.f387251k) * 31;
        int r101 = 1231;
        if (this.f387252l == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f387253m == true) goto L11;
        r101 = 1237;
    L11:
        return ((r103 + r101) * 31) + this.f387254n.hashCode();
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "FeedbackPanelTemplate(recordId=" + this.f387241a + ", title=" + this.f387242b + ", reasonsTitle=" + this.f387243c + ", reasons=" + this.f387244d + ", feedback=" + this.f387245e + ", placeholder=" + this.f387246f + ", emptyReasonsText=" + this.f387247g + ", submitText=" + this.f387248h + ", submittingText=" + this.f387249i + ", incompleteText=" + this.f387250j + ", maxCommentLength=" + this.f387251k + ", submitting=" + this.f387252l + ", mediaEnabled=" + this.f387253m + ", media=" + this.f387254n + ')';
    }

    public /* synthetic */ d5(String r110, String r111, List r112, a5 r113, String r210, String r211, String r212, boolean r213, boolean r214, List r215, int r216) {
        if ((r216 & 1024) == 0) goto L5;
        int r114 = 500;
    L7:
        if ((r216 & 2048) == 0) goto L9;
        boolean r115 = false;
    L11:
        if ((r216 & 4096) == 0) goto L13;
        boolean r116 = false;
    L15:
        if ((r216 & 8192) == 0) goto L17;
        List r117 = CollectionsKt.emptyList();
    L18:
        this(r110, "反馈", r111, r112, r113, r210, r211, "提交", "提交中...", r212, r114, r115, r116, r117);
        return;
    L17:
        r117 = r215;
        goto L18
    L13:
        r116 = r214;
        goto L15
    L9:
        r115 = r213;
        goto L11
    L5:
        r114 = 0;
        goto L7
    }

    public d5(String r100, String r101, String r102, List<String> r103, a5 r104, String r105, String r106, String r107, String r110, String r111, int r112, boolean r113, boolean r114, List<b5> r115) {
        Intrinsics.checkNotNullParameter(r100, "recordId");
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r102, "reasonsTitle");
        Intrinsics.checkNotNullParameter(r103, "reasons");
        Intrinsics.checkNotNullParameter(r104, "feedback");
        Intrinsics.checkNotNullParameter(r105, GXTemplateKey.GAIAX_PLACEHOLDER);
        Intrinsics.checkNotNullParameter(r106, "emptyReasonsText");
        Intrinsics.checkNotNullParameter(r107, "submitText");
        Intrinsics.checkNotNullParameter(r110, "submittingText");
        Intrinsics.checkNotNullParameter(r111, "incompleteText");
        Intrinsics.checkNotNullParameter(r115, "media");
        this.f387241a = r100;
        this.f387242b = r101;
        this.f387243c = r102;
        this.f387244d = r103;
        this.f387245e = r104;
        this.f387246f = r105;
        this.f387247g = r106;
        this.f387248h = r107;
        this.f387249i = r110;
        this.f387250j = r111;
        this.f387251k = r112;
        this.f387252l = r113;
        this.f387253m = r114;
        this.f387254n = r115;
    }
}

package com.obric.assistant.cocreationreview;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class l5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ModuleKey f387358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f387359b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f387360c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f387361d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f387362e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f387363f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<String> f387364g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<String> f387365h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f387366i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f387367j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f387368k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f387369l;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l5) == true) goto L8;
        return false;
    L8:
        l5 r101 = (l5) r100;
        if (this.f387358a == r101.f387358a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f387359b, r101.f387359b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f387360c, r101.f387360c) == true) goto L18;
        return false;
    L18:
        if (this.f387361d == r101.f387361d) goto L21;
        return false;
    L21:
        if (this.f387362e == r101.f387362e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f387363f, r101.f387363f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f387364g, r101.f387364g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f387365h, r101.f387365h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f387366i, r101.f387366i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f387367j, r101.f387367j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f387368k, r101.f387368k) == true) goto L42;
        return false;
    L42:
        if (this.f387369l == r101.f387369l) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((((((((((((this.f387358a.hashCode() * 31) + this.f387359b.hashCode()) * 31) + this.f387360c.hashCode()) * 31) + this.f387361d) * 31) + this.f387362e) * 31) + this.f387363f.hashCode()) * 31) + this.f387364g.hashCode()) * 31) + this.f387365h.hashCode()) * 31) + this.f387366i.hashCode()) * 31) + this.f387367j.hashCode()) * 31) + this.f387368k.hashCode()) * 31;
        if (this.f387369l == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "ModuleMeta(key=" + this.f387358a + ", label=" + this.f387359b + ", shortLabel=" + this.f387360c + ", iconRes=" + this.f387361d + ", accentColor=" + this.f387362e + ", description=" + this.f387363f + ", positiveReasons=" + this.f387364g + ", negativeReasons=" + this.f387365h + ", feedbackPlaceholder=" + this.f387366i + ", positiveFeedbackPlaceholder=" + this.f387367j + ", negativeFeedbackPlaceholder=" + this.f387368k + ", feedbackMediaEnabled=" + this.f387369l + ')';
    }

    public /* synthetic */ l5(ModuleKey r110, String r111, String r112, int r210, int r211, String r212, List r213, List r214, String r215, boolean r216, int r217) {
        if ((r217 & 512) == 0) goto L5;
        String r113 = "可以补充说明这条内容好在哪里，例如记得准确、分类合适、内容有价值或执行路径合理。";
    L7:
        if ((r217 & 1024) == 0) goto L9;
        String r114 = r215;
    L11:
        if ((r217 & 2048) == 0) goto L13;
        boolean r115 = false;
    L14:
        this(r110, r111, r112, r210, r211, r212, r213, r214, r215, r113, r114, r115);
        return;
    L13:
        r115 = r216;
        goto L14
    L9:
        r114 = null;
        goto L11
    L5:
        r113 = null;
        goto L7
    }

    public l5(ModuleKey r100, String r101, String r102, int r103, int r104, String r105, List<String> r106, List<String> r107, String r110, String r111, String r112, boolean r113) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "label");
        Intrinsics.checkNotNullParameter(r102, "shortLabel");
        Intrinsics.checkNotNullParameter(r105, "description");
        Intrinsics.checkNotNullParameter(r106, "positiveReasons");
        Intrinsics.checkNotNullParameter(r107, "negativeReasons");
        Intrinsics.checkNotNullParameter(r110, "feedbackPlaceholder");
        Intrinsics.checkNotNullParameter(r111, "positiveFeedbackPlaceholder");
        Intrinsics.checkNotNullParameter(r112, "negativeFeedbackPlaceholder");
        this.f387358a = r100;
        this.f387359b = r101;
        this.f387360c = r102;
        this.f387361d = r103;
        this.f387362e = r104;
        this.f387363f = r105;
        this.f387364g = r106;
        this.f387365h = r107;
        this.f387366i = r110;
        this.f387367j = r111;
        this.f387368k = r112;
        this.f387369l = r113;
    }
}

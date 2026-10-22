package com.larus.platform.model.chat;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f365582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f365583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f365584c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f365585d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f365586e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f365587f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<String> f365588g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<String> f365589h;

    public l() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (this.f365582a == r101.f365582a) goto L12;
        return false;
    L12:
        if (this.f365583b == r101.f365583b) goto L15;
        return false;
    L15:
        if (this.f365584c == r101.f365584c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f365585d, r101.f365585d) == true) goto L21;
        return false;
    L21:
        if (this.f365586e == r101.f365586e) goto L24;
        return false;
    L24:
        if (this.f365587f == r101.f365587f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f365588g, r101.f365588g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f365589h, r101.f365589h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f365582a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f365583b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f365584c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (((((r104 + r105) * 31) + this.f365585d.hashCode()) * 31) + this.f365586e) * 31;
        if (this.f365587f == true) goto L19;
        r100 = 1237;
    L19:
        return ((((r106 + r100) * 31) + this.f365588g.hashCode()) * 31) + this.f365589h.hashCode();
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "ChatSendPreviewConfig(enablePreview=" + this.f365582a + ", enableInput=" + this.f365583b + ", enableAiEdit=" + this.f365584c + ", aiEditFilterScene=" + this.f365585d + ", prefetchSize=" + this.f365586e + ", enableFindSimilar=" + this.f365587f + ", findSimilarActionBarInstructionTypeList=" + this.f365588g + ", findSimilarLlmIntentionDetailList=" + this.f365589h + ')';
    }

    public /* synthetic */ l(int r110) {
        this(false, false, false, CollectionsKt.emptyList(), 0, false, CollectionsKt.emptyList(), CollectionsKt.emptyList());
    }

    public l(boolean r100, boolean r101, boolean r102, List<String> r103, int r104, boolean r105, List<String> r106, List<String> r107) {
        Intrinsics.checkNotNullParameter(r103, "aiEditFilterScene");
        Intrinsics.checkNotNullParameter(r106, "findSimilarActionBarInstructionTypeList");
        Intrinsics.checkNotNullParameter(r107, "findSimilarLlmIntentionDetailList");
        this.f365582a = r100;
        this.f365583b = r101;
        this.f365584c = r102;
        this.f365585d = r103;
        this.f365586e = r104;
        this.f365587f = r105;
        this.f365588g = r106;
        this.f365589h = r107;
    }
}

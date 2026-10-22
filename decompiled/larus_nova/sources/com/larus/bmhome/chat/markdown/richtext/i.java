package com.larus.bmhome.chat.markdown.richtext;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f307208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<g> f307209b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<h> f307210c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<j> f307211d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<String> f307212e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f307208a, r101.f307208a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f307209b, r101.f307209b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f307210c, r101.f307210c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f307211d, r101.f307211d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f307212e, r101.f307212e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.f307208a.hashCode() * 31) + this.f307209b.hashCode()) * 31) + this.f307210c.hashCode()) * 31) + this.f307211d.hashCode()) * 31) + this.f307212e.hashCode();
    }

    public final String toString() {
        return "MessageMarkdownParseResult(displayText=" + this.f307208a + ", linkSpans=" + this.f307209b + ", mentionSpans=" + this.f307210c + ", resourceSpans=" + this.f307211d + ", previewUrls=" + this.f307212e + ')';
    }

    public final boolean a() {
        if ((!this.f307209b.isEmpty()) == false) goto L5;
        return true;
    L5:
        if ((!this.f307210c.isEmpty()) == false) goto L7;
        return true;
    L7:
        if ((!this.f307211d.isEmpty()) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public /* synthetic */ i(String r100, List r101, List r102, int r110) {
        if ((r110 & 2) == 0) goto L5;
        r101 = CollectionsKt.emptyList();
    L5:
        List r103 = r101;
        if ((r110 & 4) == 0) goto L8;
        List r104 = CollectionsKt.emptyList();
    L10:
        if ((r110 & 8) == 0) goto L12;
        List r105 = CollectionsKt.emptyList();
    L14:
        if ((r110 & 16) == 0) goto L16;
        r102 = CollectionsKt.emptyList();
    L16:
        this(r100, r103, r104, r105, r102);
        return;
    L12:
        r105 = null;
        goto L14
    L8:
        r104 = null;
        goto L10
    }

    public i(String r100, List<g> r101, List<h> r102, List<j> r103, List<String> r104) {
        Intrinsics.checkNotNullParameter(r100, "displayText");
        Intrinsics.checkNotNullParameter(r101, "linkSpans");
        Intrinsics.checkNotNullParameter(r102, "mentionSpans");
        Intrinsics.checkNotNullParameter(r103, "resourceSpans");
        Intrinsics.checkNotNullParameter(r104, "previewUrls");
        this.f307208a = r100;
        this.f307209b = r101;
        this.f307210c = r102;
        this.f307211d = r103;
        this.f307212e = r104;
    }
}

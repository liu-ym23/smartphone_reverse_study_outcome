package com.ss.android.lark.chat.cot.detail.widget;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f415049c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f415050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<c> f415051b;

    public static final class a {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f415050a, r101.f415050a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f415051b, r101.f415051b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f415050a.hashCode() * 31) + this.f415051b.hashCode();
    }

    public final String toString() {
        return "FoldButtonConfig(text=" + this.f415050a + ", icons=" + this.f415051b + ')';
    }

    static {
        f415049c = new b("", CollectionsKt.emptyList());
    }

    public b(String r100, List<c> r101) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, "icons");
        this.f415050a = r100;
        this.f415051b = r101;
    }
}

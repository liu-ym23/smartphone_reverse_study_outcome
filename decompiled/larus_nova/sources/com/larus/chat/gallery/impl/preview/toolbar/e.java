package com.larus.chat.gallery.impl.preview.toolbar;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f324790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f324791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f324792c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f324790a, r101.f324790a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f324791b, r101.f324791b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f324792c, r101.f324792c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f324790a.hashCode() * 31) + this.f324791b.hashCode()) * 31) + this.f324792c.hashCode();
    }

    public final String toString() {
        return "PreviewToolbarItems(ordered=" + this.f324790a + ", more=" + this.f324791b + ", emphasized=" + this.f324792c + ')';
    }

    public e(List<String> r100, List<String> r101, List<String> r102) {
        Intrinsics.checkNotNullParameter(r100, "ordered");
        Intrinsics.checkNotNullParameter(r101, "more");
        Intrinsics.checkNotNullParameter(r102, "emphasized");
        this.f324790a = r100;
        this.f324791b = r101;
        this.f324792c = r102;
    }
}

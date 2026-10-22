package com.ss.android.lark.todo.impl.features.detail.viewmodel;

import com.ss.android.lark.widget.richtext.RichText;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RichText f443895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f443896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f443897c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t) == true) goto L8;
        return false;
    L8:
        t r101 = (t) r100;
        if (Intrinsics.areEqual(this.f443895a, r101.f443895a) == true) goto L12;
        return false;
    L12:
        if (this.f443896b == r101.f443896b) goto L15;
        return false;
    L15:
        if (this.f443897c == r101.f443897c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        RichText r100 = this.f443895a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = r101 * 31;
        int r103 = 1231;
        if (this.f443896b == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r102 + r104) * 31;
        if (this.f443897c == true) goto L15;
        r103 = 1237;
    L15:
        return r105 + r103;
    L9:
        r104 = 1237;
        goto L10
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "RichTextShowBean(richText=" + this.f443895a + ", forceUpdate=" + this.f443896b + ", selectionEnd=" + this.f443897c + ')';
    }

    public t(RichText r100, boolean r101) {
        this.f443895a = r100;
        this.f443896b = true;
        this.f443897c = r101;
    }
}

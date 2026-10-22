package com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.image;

import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.image.api.DiskCacheStrategy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Scene f412213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DiskCacheStrategy f412214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f412215c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f412213a == r101.f412213a) goto L12;
        return false;
    L12:
        if (this.f412214b == r101.f412214b) goto L15;
        return false;
    L15:
        if (this.f412215c == r101.f412215c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f412213a.hashCode() * 31) + this.f412214b.hashCode()) * 31;
        if (this.f412215c == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "LoaderConfig(scene=" + this.f412213a + ", diskCacheStrategy=" + this.f412214b + ", saveToPrivatePath=" + this.f412215c + ')';
    }

    public c(Scene r100, DiskCacheStrategy r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "diskCacheStrategy");
        this.f412213a = r100;
        this.f412214b = r101;
        this.f412215c = false;
    }
}

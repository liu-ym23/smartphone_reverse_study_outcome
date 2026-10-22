package com.ss.android.lark.movable.selection;

import android.graphics.drawable.Drawable;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f432812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Drawable f432813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f432814c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f432812a, r101.f432812a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f432813b, r101.f432813b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f432814c, r101.f432814c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f432812a.hashCode() * 31;
        Drawable r101 = this.f432813b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.f432814c.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "SelectionMenuItem(title=" + this.f432812a + ", drawableIcon=" + this.f432813b + ", onClick=" + this.f432814c + ')';
    }

    public o(CharSequence r100, Drawable r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r102, SendEventContainerMethodParamModel.EventKinds.onClick);
        this.f432812a = r100;
        this.f432813b = r101;
        this.f432814c = r102;
    }
}

package com.ss.android.lark.chat.export.entity.message.content;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b extends e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ChatterToolTipType f415403c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f415404d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f415403c == r101.f415403c) goto L12;
        return false;
    L12:
        if (this.f415404d == r101.f415404d) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f415403c.hashCode() * 31;
        if (this.f415404d == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "ChatterToolTip(toolTipType=" + this.f415403c + ", clickable=" + this.f415404d + ')';
    }

    @Override // com.ss.android.lark.chat.export.entity.message.content.e
    public final boolean a() {
        return this.f415404d;
    }

    public b(ChatterToolTipType r100) {
        Intrinsics.checkNotNullParameter(r100, "toolTipType");
        super(3, false);
        this.f415403c = r100;
        this.f415404d = false;
    }
}

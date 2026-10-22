package com.larus.bmhome.instruction.core.impl.base;

import com.larus.bmhome.actionbar.model.t1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class l extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f311968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t1 f311969c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f311970d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f311968b, r101.f311968b) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f311969c, r101.f311969c) == true) goto L15;
        return false;
    L15:
        if (this.f311970d == r101.f311970d) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f311968b.hashCode() * 31) + this.f311969c.hashCode()) * 31;
        if (this.f311970d == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "ParamFilterConfChangedEvent(sourceWidgetId=" + this.f311968b + ", paramFilterConf=" + this.f311969c + ", isInitial=" + this.f311970d + ')';
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.d
    public final String a() {
        return this.f311968b;
    }

    public l(String r100, t1 r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "sourceWidgetId");
        Intrinsics.checkNotNullParameter(r101, "paramFilterConf");
        super("ParamFilterConfChangedEvent");
        this.f311968b = r100;
        this.f311969c = r101;
        this.f311970d = r102;
    }
}

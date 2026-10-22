package com.ss.android.lark.myai.export;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f432872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f432873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function2<String, osb.d, Unit> f432874c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f432872a, r101.f432872a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f432873b, r101.f432873b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f432874c, r101.f432874c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f432872a.hashCode() * 31) + this.f432873b.hashCode()) * 31) + this.f432874c.hashCode();
    }

    public final String toString() {
        return "ActionButton(key=" + this.f432872a + ", text=" + this.f432873b + ", callback=" + this.f432874c + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(String r100, String r101, Function2<? super String, ? super osb.d, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "text");
        Intrinsics.checkNotNullParameter(r102, "callback");
        this.f432872a = r100;
        this.f432873b = r101;
        this.f432874c = r102;
    }
}

package com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f412505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f412506b;

    public final int hashCode() {
        return (this.f412505a.hashCode() * 31) + this.f412506b.hashCode();
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof e) == true) goto L5;
    L11:
        return false;
    L5:
        if (Intrinsics.areEqual(getClass(), r100.getClass()) == false) goto L11;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f412505a, r101.f412505a) == false) goto L11;
        if (Intrinsics.areEqual(this.f412506b, r101.f412506b) == false) goto L11;
        return true;
    }

    public e(a r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, "role");
        this.f412505a = r100;
        this.f412506b = r101;
    }
}

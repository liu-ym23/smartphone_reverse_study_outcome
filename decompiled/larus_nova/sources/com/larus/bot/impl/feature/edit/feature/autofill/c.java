package com.larus.bot.impl.feature.edit.feature.autofill;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final wu8.a f318440a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f318440a, ((c) r100).f318440a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f318440a.hashCode();
    }

    public final String toString() {
        return "AutoFillUIState(autoFillBtnUIState=" + this.f318440a + ')';
    }

    public c(wu8.a r100) {
        Intrinsics.checkNotNullParameter(r100, "autoFillBtnUIState");
        this.f318440a = r100;
    }
}

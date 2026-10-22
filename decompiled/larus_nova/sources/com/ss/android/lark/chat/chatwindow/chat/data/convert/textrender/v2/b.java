package com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f412501a;

    public final int hashCode() {
        return System.identityHashCode(this.f412501a);
    }

    public b(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f412501a = r100;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof b) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f412501a != ((b) r100).f412501a) goto L7;
        return true;
    }
}

package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class r implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b f414137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Integer> f414138b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L8;
        return false;
    L8:
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.f414137a, r101.f414137a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f414138b, r101.f414138b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f414137a.hashCode() * 31;
        Function0<Integer> r101 = this.f414138b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "ProcessConfigV1(params=" + this.f414137a + ", widthProvider=" + this.f414138b + ')';
    }

    public r(com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b r100, Function0<Integer> r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.f414137a = r100;
        this.f414138b = r101;
    }
}

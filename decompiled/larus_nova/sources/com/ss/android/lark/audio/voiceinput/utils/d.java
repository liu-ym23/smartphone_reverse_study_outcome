package com.ss.android.lark.audio.voiceinput.utils;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f409446a;

    public d() {
    }

    public final void a(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        if (this.f409446a == false) goto L5;
        return;
    L5:
        r100.invoke();
        this.f409446a = true;
    }
}

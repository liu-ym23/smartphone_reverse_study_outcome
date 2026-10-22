package com.ss.android.lark.keyboard.event;

import com.ss.android.lark.keyboard.ime.ImeStateDetail;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class n implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImeStateDetail f429300a;

    @Override // com.ss.android.lark.keyboard.event.c
    public final String getTag() {
        return c.a.a(this);
    }

    public n(ImeStateDetail r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        this.f429300a = r100;
    }
}

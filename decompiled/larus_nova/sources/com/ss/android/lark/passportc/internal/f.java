package com.ss.android.lark.passportc.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public abstract class f extends u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StateTransferType f438461a;

    public final StateTransferType getType() {
        return this.f438461a;
    }

    public f(StateTransferType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f438461a = r100;
    }
}

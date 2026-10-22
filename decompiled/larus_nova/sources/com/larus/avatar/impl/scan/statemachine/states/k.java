package com.larus.avatar.impl.scan.statemachine.states;

import com.larus.avatar.impl.scan.statemachine.ScanMessageType;
import com.larus.avatar.impl.scan.statemachine.ScanStateType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class k extends o88.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ScanStateType f291099b;

    @Override // o88.a
    public final void a() {
    }

    public k() {
        this.f291099b = ScanStateType.IDLE;
    }

    @Override // o88.a
    public final ScanStateType c() {
        return this.f291099b;
    }

    @Override // o88.a
    public final ScanStateType d(o88.c r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        if (r100.f522392a != ScanMessageType.INIT) goto L7;
        return ScanStateType.INIT;
    L7:
        return ScanStateType.IDLE;
    }
}

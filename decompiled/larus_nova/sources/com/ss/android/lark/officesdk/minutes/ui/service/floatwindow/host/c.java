package com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.host;

import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes37.dex */
public final class c implements wfb.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f436846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f436847b;

    @Override // wfb.g
    public final void a(boolean r100) {
        if (r100 == false) goto L4;
        this.f436846a.invoke();
        return;
    L4:
        int r101 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.FLOAT, "permissionResult", "permission denied", null, 8);
        this.f436847b.invoke();
    }

    public c(Function0<Unit> r100, Function0<Unit> r101) {
        this.f436846a = r100;
        this.f436847b = r101;
    }
}

package com.larus.avatar.impl.manager;

import com.larus.common_ui.dialog.p0;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import tx9.r0;

/* JADX INFO: loaded from: classes23.dex */
public final class w implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f290834a;

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        r0.f("replica", "confirm_delete_replica");
        this.f290834a.invoke();
    }

    public w(q r100) {
        this.f290834a = r100;
    }
}

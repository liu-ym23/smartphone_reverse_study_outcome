package com.larus.office.plugins.inputv2.coordinator.runtime.interaction;

import com.larus.office.permission.DocPermissionFullData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class d implements fo9.a.InterfaceC5936a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f362960a;

    public d(c r100) {
        this.f362960a = r100;
    }

    @Override // fo9.a.InterfaceC5936a
    public final void a(DocPermissionFullData r100) {
        Intrinsics.checkNotNullParameter(r100, "permission");
        this.f362960a.b("permission");
        this.f362960a.f362950i.invoke();
    }
}

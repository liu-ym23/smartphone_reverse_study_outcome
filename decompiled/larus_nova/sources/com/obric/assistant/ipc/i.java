package com.obric.assistant.ipc;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class i implements n38.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f389987a;

    public i(k r100) {
        this.f389987a = r100;
    }

    @Override // n38.j
    public final void a(n38.a r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        k r101 = this.f389987a;
        String r102 = "account_offline:" + r100.f516980c + ':' + r100.f516981d;
        r101.getClass();
        k.a(r102);
    }

    @Override // n38.j
    public final void b(n38.a r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        k r101 = this.f389987a;
        String r102 = "account_online:" + r100.f516980c + ':' + r100.f516981d;
        r101.getClass();
        k.b(r102);
    }
}

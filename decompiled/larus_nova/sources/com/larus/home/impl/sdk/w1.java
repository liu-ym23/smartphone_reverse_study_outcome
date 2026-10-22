package com.larus.home.impl.sdk;

import com.larus.bmhome.chat.model.repo.INotifyService;
import com.larus.platform.api.d3;
import hq9.n3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class w1 implements d3 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final w1 f346265b = null;

    static {
        f346265b = new w1();
    }

    public w1() {
    }

    @Override // com.larus.platform.api.d3
    public final void d() {
        INotifyService.f307709a.d();
    }

    @Override // com.larus.platform.api.d3
    public final void e() {
        INotifyService.f307709a.e().b().postValue(Boolean.TRUE);
    }

    @Override // com.larus.platform.api.d3
    public final void a(com.larus.commercemembership.impl.component.d r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        INotifyService.f307709a.a(r100);
    }

    @Override // com.larus.platform.api.d3
    public final void b(com.larus.commercemembership.impl.component.d r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        INotifyService.f307709a.b(r100);
    }

    @Override // com.larus.platform.api.d3
    public final boolean c(n3 r100) {
        return INotifyService.f307709a.c(r100);
    }
}

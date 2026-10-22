package com.bytedance.ee.bear.bitable.itemview.util;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class m implements tk5.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f214295a;

    public m(n r100) {
        this.f214295a = r100;
    }

    @Override // tk5.c
    public final void a(tk5.d<? extends vk5.c> r100) {
        Intrinsics.checkNotNullParameter(r100, "mission");
        l.a("ItemViewOnboard onConfirm", null, null, null, 14);
        sk5.c r101 = ((sk5.b) org.koin.java.a.c(sk5.b.class, null, null, 6)).b();
        this.f214295a.getClass();
        r101.c("base_mobile_item_view_config_guide");
    }

    @Override // tk5.c
    public final void b(tk5.d<? extends vk5.c> r100) {
        Intrinsics.checkNotNullParameter(r100, "mission");
        l.a("ItemViewOnboard onDismiss", null, null, null, 14);
        sk5.c r101 = ((sk5.b) org.koin.java.a.c(sk5.b.class, null, null, 6)).b();
        this.f214295a.getClass();
        r101.c("base_mobile_item_view_config_guide");
    }

    @Override // tk5.c
    public final void c(tk5.d<? extends vk5.c> r100) {
        Intrinsics.checkNotNullParameter(r100, "mission");
        l.a("ItemViewOnboard onCancel", null, null, null, 14);
        sk5.c r101 = ((sk5.b) org.koin.java.a.c(sk5.b.class, null, null, 6)).b();
        this.f214295a.getClass();
        r101.c("base_mobile_item_view_config_guide");
    }
}

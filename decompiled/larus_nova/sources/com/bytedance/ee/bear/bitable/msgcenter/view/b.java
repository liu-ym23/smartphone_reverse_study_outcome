package com.bytedance.ee.bear.bitable.msgcenter.view;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements tk5.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f214726a;

    @Override // tk5.c
    public final void a(tk5.d<? extends vk5.c> r100) {
        Intrinsics.checkNotNullParameter(r100, "mission");
    }

    @Override // tk5.c
    public final void c(tk5.d<? extends vk5.c> r100) {
        Intrinsics.checkNotNullParameter(r100, "mission");
    }

    public b(c r100) {
        this.f214726a = r100;
    }

    @Override // tk5.c
    public final void b(tk5.d<? extends vk5.c> r100) {
        Intrinsics.checkNotNullParameter(r100, "mission");
        tt5.a.h("BitableMsgCenterFragment", "onDismiss>>> HistoryGuideMission");
        sk5.c r101 = ((sk5.b) org.koin.java.a.c(sk5.b.class, null, null, 6)).b();
        this.f214726a.getClass();
        r101.c("base_message_center_view_history_guide");
    }
}

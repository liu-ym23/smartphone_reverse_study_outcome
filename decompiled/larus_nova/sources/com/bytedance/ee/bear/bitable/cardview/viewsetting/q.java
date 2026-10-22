package com.bytedance.ee.bear.bitable.cardview.viewsetting;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class q implements com.bytedance.ee.bear.bitable.panel.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f209279a;

    @Override // com.bytedance.ee.bear.bitable.panel.l
    public final /* synthetic */ void onExit() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public q(Function1<? super String, Unit> r100) {
        this.f209279a = r100;
    }

    @Override // com.bytedance.ee.bear.bitable.panel.l
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        this.f209279a.invoke(r100);
    }
}

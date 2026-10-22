package com.larus.ui.arch.modulizer.di;

import com.larus.ui.arch.component.external.api.receiver.Container;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import u1a.b;

/* JADX INFO: loaded from: classes4.dex */
public final class ContainerBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ContainerFilter f375176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<? extends Container> f375177b;

    public ContainerBuilder() {
        this.f375176a = ContainerFilter.EMPTY;
        this.f375177b = new b();
    }

    public final void a(ContainerFilter r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f375176a = r100;
    }
}

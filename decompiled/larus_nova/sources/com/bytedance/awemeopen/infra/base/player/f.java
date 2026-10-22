package com.bytedance.awemeopen.infra.base.player;

import android.view.Surface;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class f implements com.bytedance.awemeopen.infra.base.player.surface.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<Surface, Unit> f198747a;

    /* JADX WARN: Multi-variable type inference failed */
    public f(Function1<? super Surface, Unit> r100) {
        this.f198747a = r100;
    }

    @Override // com.bytedance.awemeopen.infra.base.player.surface.c
    public final void a(Surface r100) {
        Intrinsics.checkNotNullParameter(r100, "surface");
        this.f198747a.invoke(r100);
    }
}

package com.larus.bmhome.chat.component.bottom.core;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class j9 implements ICoreInputAbility.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k9 f299261a;

    public j9(k9 r100) {
        this.f299261a = r100;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility.e
    public final void h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility.e
    public final void i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        this.f299261a.a(r100);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility.e
    public final void j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
    }
}

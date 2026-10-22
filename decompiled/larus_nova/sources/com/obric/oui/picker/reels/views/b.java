package com.obric.oui.picker.reels.views;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ gma.a.b f402191a;

    public b(gma.a.b r100) {
        this.f402191a = r100;
    }

    @Override // com.obric.oui.picker.reels.views.c
    public final void a(int r100) {
        Intrinsics.stringPlus("onStopped: ", Integer.valueOf(r100));
        gma.a.b r101 = this.f402191a;
        gma.a.c r102 = r101.f481784i;
        if (r102 == null) goto L7;
        r102.a(r101.f481776a, r100);
        return;
    }

    @Override // com.obric.oui.picker.reels.views.c
    public final void onChanged(int r100) {
        gma.a.b r101 = this.f402191a;
        gma.a.c r102 = r101.f481784i;
        if (r102 == null) goto L7;
        r102.a(r101.f481776a, r100);
        return;
    }
}

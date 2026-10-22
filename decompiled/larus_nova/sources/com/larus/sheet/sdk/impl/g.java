package com.larus.sheet.sdk.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes31.dex */
public final class g implements gm5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SheetSdkServiceImplV2 f369158a;

    @Override // gm5.a
    public final Function1<String, Unit> getOnSelectionShowCallBack() {
        final SheetSdkServiceImplV2 r100 = this.f369158a;
        return new f(r100);
    }

    public g(SheetSdkServiceImplV2 r100) {
        this.f369158a = r100;
    }
}

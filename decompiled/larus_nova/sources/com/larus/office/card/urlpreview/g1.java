package com.larus.office.card.urlpreview;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final /* synthetic */ class g1 implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f361910a;

    public /* synthetic */ g1(String r100) {
        this.f361910a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        String r101 = this.f361910a;
        String r102 = (String) r100;
        Intrinsics.checkNotNullParameter(r102, "url");
        OfficeUrlPreviewPlatformBridge r103 = OfficeUrlPreviewPlatformBridge.f361768a;
        monitor-enter(r103);
        z0 r104 = OfficeUrlPreviewPlatformBridge.f361769b.get(new c2(r101, r102));     // Catch: Throwable -> L11
        monitor-exit(r103);
        if (r104 == null) goto L8;
        boolean r105 = true;
    L10:
        return Boolean.valueOf(r105);
    L8:
        r105 = false;
    L11:
        th = move-exception;
        throw th;
    }
}

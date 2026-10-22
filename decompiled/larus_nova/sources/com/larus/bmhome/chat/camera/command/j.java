package com.larus.bmhome.chat.camera.command;

import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final /* synthetic */ class j implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f297600a;

    public /* synthetic */ j(long r100) {
        this.f297600a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        long r101 = this.f297600a;
        Map.Entry r102 = (Map.Entry) r100;
        Intrinsics.checkNotNullParameter(r102, "it");
        if ((r101 - ((t) r102.getValue()).a()) <= 300000) goto L5;
        boolean r103 = true;
    L7:
        return Boolean.valueOf(r103);
    L5:
        r103 = false;
        goto L7
    }
}

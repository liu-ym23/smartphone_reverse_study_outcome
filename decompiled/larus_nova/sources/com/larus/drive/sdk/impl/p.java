package com.larus.drive.sdk.impl;

import java.lang.ref.WeakReference;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes27.dex */
public final /* synthetic */ class p implements Function1 {
    public /* synthetic */ p() {
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        int r101 = FlowDriveSdkServiceImpl.f341640d;
        if (((WeakReference) r100).get() != null) goto L5;
        boolean r102 = true;
    L7:
        return Boolean.valueOf(r102);
    L5:
        r102 = false;
        goto L7
    }
}

package com.ss.android.ugc.tools.mob.bus;

import com.ss.android.ugc.tools.CukaieManifest;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: loaded from: classes40.dex */
public final class k extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    public k(CoroutineExceptionHandler.Key r100) {
        super(r100);
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public final void handleException(CoroutineContext r100, Throwable r101) {
        CukaieManifest r102 = CukaieManifest.f454800f;
        r102.getClass();
        if (((Boolean) CukaieManifest.f454797c.getValue(r102, CukaieManifest.f454795a[1])).booleanValue() == true) goto L5;
        return;
    L5:
        throw r101;
    }
}

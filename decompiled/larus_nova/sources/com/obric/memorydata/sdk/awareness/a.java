package com.obric.memorydata.sdk.awareness;

import android.os.IBinder;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class a implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e.a f397103a;

    public /* synthetic */ a(e.a r100) {
        this.f397103a = r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        e.a r100 = this.f397103a;
        IBinder.DeathRecipient r101 = r100.f397126d;
        if (r101 == null) goto L7;
        IBinder r102 = r100.f397125c;
        if (r102 == null) goto L7;
        return Boolean.valueOf(r102.unlinkToDeath(r101, 0));
    L7:
        return null;
    }
}

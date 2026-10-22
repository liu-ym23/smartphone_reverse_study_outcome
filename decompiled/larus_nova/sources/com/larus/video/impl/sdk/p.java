package com.larus.video.impl.sdk;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes32.dex */
public final class p implements Function1<Throwable, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f375824a;

    public p(String r100) {
        this.f375824a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Throwable r100) {
        TTVideoEngineStaticServiceImpl.f375778b.remove(this.f375824a);
        return Unit.INSTANCE;
    }
}

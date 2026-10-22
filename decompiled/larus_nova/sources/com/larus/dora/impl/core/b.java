package com.larus.dora.impl.core;

import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes27.dex */
public final class b implements Function1<Throwable, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ yj4.h f332187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f332188b;

    public b(yj4.f r100, c r101) {
        this.f332187a = r100;
        this.f332188b = r101;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Throwable r100) {
        g49.d.d("DoraAdapterExt", "requestAlbumThumbnail: cancel");
        yj4.h r101 = this.f332187a;
        c r102 = this.f332188b;
        ((yj4.f) r101).getClass();
        int r103 = yj4.g.f568093a;
        ((CopyOnWriteArraySet) yj4.h.D2).remove(r102);
        return Unit.INSTANCE;
    }
}

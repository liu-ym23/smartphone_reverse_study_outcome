package com.bytedance.ee.bear.drive.cache;

import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class z<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f224076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List<String> f224077b;

    public z(List r100) {
        this.f224076a = "DriveDataService-removeAll";
        this.f224077b = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Integer r101 = (Integer) r100;
        Intrinsics.checkNotNullParameter(r101, "result");
        tt5.a.h("LarkDriveCacheService", "onDriveCacheCleared(" + this.f224076a + "), tokens: " + this.f224077b + ", result: " + r101.intValue());
        if (r101.intValue() <= 0) goto L6;
        tt5.a.h("LarkDriveCacheService", "onDriveCacheCleared(" + this.f224076a + "), driveCacheDao-deleteAll, count: " + com.bytedance.ee.bear.drive.dao.c.c().a().deleteAll());
    L6:
        return Unit.INSTANCE;
    }
}

package com.bytedance.ee.bear.drive.cache;

import com.bytedance.ee.bear.document.tips.TipCallBackData;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class z<T, R> implements Function {
    public final /* synthetic */ String a;
    public final /* synthetic */ List<String> b;

    public z(List r2) {
        this.a = "DriveDataService-removeAll";
        this.b = r2;
    }

    public final Object apply(Object r4) {
        Integer r5 = (Integer) r4;
        Intrinsics.checkNotNullParameter(r5, TipCallBackData.RESULT);
        tt5.a.h("LarkDriveCacheService", "onDriveCacheCleared(" + this.a + "), tokens: " + this.b + ", result: " + r5.intValue());
        if (r5.intValue() <= 0) goto L6;
        tt5.a.h("LarkDriveCacheService", "onDriveCacheCleared(" + this.a + "), driveCacheDao-deleteAll, count: " + com.bytedance.ee.bear.drive.dao.c.c().a().deleteAll());
    L6:
        return Unit.INSTANCE;
    }
}

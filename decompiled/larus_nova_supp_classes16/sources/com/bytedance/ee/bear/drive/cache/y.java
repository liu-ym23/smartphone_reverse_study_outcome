package com.bytedance.ee.bear.drive.cache;

import com.bytedance.ee.bear.document.tips.TipCallBackData;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class y<T, R> implements Function {
    public final /* synthetic */ String a;
    public final /* synthetic */ List<String> b;
    public final /* synthetic */ x c;

    public y(List r2, x r3) {
        this.a = "DriveDataService-put";
        this.b = r2;
        this.c = r3;
    }

    public final Object apply(Object r3) {
        Integer r4 = (Integer) r3;
        Intrinsics.checkNotNullParameter(r4, TipCallBackData.RESULT);
        tt5.a.h("LarkDriveCacheService", "onDriveCacheAdded(" + this.a + "), saveCachedStatus, tokens: " + this.b + ", result: " + r4.intValue());
        if (r4.intValue() > 0) goto L6;
        ((ml5.b) this.c.c.getValue()).b("sync_status_doc_finished", Boolean.FALSE);
    L6:
        return Unit.INSTANCE;
    }
}

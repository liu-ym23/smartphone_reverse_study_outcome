package com.bytedance.ee.bear.drive.cache;

import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class y<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f224073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List<String> f224074b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ x f224075c;

    public y(List r100, x r101) {
        this.f224073a = "DriveDataService-put";
        this.f224074b = r100;
        this.f224075c = r101;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Integer r101 = (Integer) r100;
        Intrinsics.checkNotNullParameter(r101, "result");
        tt5.a.h("LarkDriveCacheService", "onDriveCacheAdded(" + this.f224073a + "), saveCachedStatus, tokens: " + this.f224074b + ", result: " + r101.intValue());
        if (r101.intValue() > 0) goto L6;
        ((ml5.b) this.f224075c.f224044c.getValue()).b("sync_status_doc_finished", Boolean.FALSE);
    L6:
        return Unit.INSTANCE;
    }
}

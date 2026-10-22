package com.bytedance.ee.bear.office.common.upload;

import android.os.Handler;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class OfficeUploadStore$mergeRecoveredTasks$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ List<h0> $recoveredTasks;

    public OfficeUploadStore$mergeRecoveredTasks$1(List<h0> r1) {
        this.$recoveredTasks = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m332invoke() {
        int r0 = f0.a;
        LinkedHashMap<String, h0> r1 = OfficeUploadStore.c;
        List r2 = f0.c(CollectionsKt.toList(r1.values()), this.$recoveredTasks);
        r1.clear();
        Iterator r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        h0 r4 = (h0) r3.next();
        OfficeUploadStore.c.put(r4.a, r4);
        goto L4
    L6:
        Handler r5 = OfficeUploadStore.a;
        OfficeUploadStore.a();
        OfficeUploadStore.d();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m332invoke();
        return Unit.INSTANCE;
    }
}

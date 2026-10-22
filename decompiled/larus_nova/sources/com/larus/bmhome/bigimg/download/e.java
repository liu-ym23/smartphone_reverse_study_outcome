package com.larus.bmhome.bigimg.download;

import java.util.Collection;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: classes25.dex */
public final /* synthetic */ class e implements Function2 {
    public /* synthetic */ e() {
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object r100, Object r101) {
        ((Boolean) r100).booleanValue();
        String r102 = (String) r101;
        Intrinsics.checkNotNullParameter(r102, "url");
        StateFlowImpl r103 = ImageDownloadLoadingMgr.f295964b;
        List r104 = CollectionsKt.toMutableList((Collection) r103.getValue());
        r104.remove(r102);
        r103.setValue(r104);
        Job r105 = ImageDownloadLoadingMgr.f295966d.get(r102);
        if (r105 == null) goto L6;
        Job.DefaultImpls.cancel$default(r105, null, 1, null);
    L6:
        return Unit.INSTANCE;
    }
}

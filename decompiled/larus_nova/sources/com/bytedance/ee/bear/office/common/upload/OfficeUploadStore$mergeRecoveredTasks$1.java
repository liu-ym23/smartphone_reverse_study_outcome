package com.bytedance.ee.bear.office.common.upload;

import android.os.Handler;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class OfficeUploadStore$mergeRecoveredTasks$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ List<h0> $recoveredTasks;

    public OfficeUploadStore$mergeRecoveredTasks$1(List<h0> r100) {
        this.$recoveredTasks = r100;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        int r100 = f0.f235362a;
        LinkedHashMap<String, h0> r101 = OfficeUploadStore.f235312c;
        List r102 = f0.c(CollectionsKt.toList(r101.values()), this.$recoveredTasks);
        r101.clear();
        Iterator r103 = r102.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        h0 r104 = (h0) r103.next();
        OfficeUploadStore.f235312c.put(r104.f235373a, r104);
        goto L4
    L6:
        Handler r105 = OfficeUploadStore.f235310a;
        OfficeUploadStore.a();
        OfficeUploadStore.d();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}

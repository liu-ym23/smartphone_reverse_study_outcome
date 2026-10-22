package com.larus.bmhome.video.download;

import java.util.Collection;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import nr9.g;

/* JADX INFO: loaded from: classes26.dex */
public final /* synthetic */ class b implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VideoDownloadLoadingMgr f315220a;

    public /* synthetic */ b(VideoDownloadLoadingMgr r100) {
        this.f315220a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        VideoDownloadLoadingMgr r101 = this.f315220a;
        g r102 = (g) r100;
        Intrinsics.checkNotNullParameter(r102, "data");
        List r103 = CollectionsKt.toMutableList((Collection) r101.f315204k.getValue());
        r103.remove(r102);
        r101.f315204k.setValue(r103);
        Job r104 = r101.f315206m.get(r102);
        if (r104 == null) goto L6;
        Job.DefaultImpls.cancel$default(r104, null, 1, null);
    L6:
        return Unit.INSTANCE;
    }
}

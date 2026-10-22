package com.larus.dora.impl.resource;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class DoraResourcePackageSynchronizer$stageTransaction$hasAllDeviceSpecificResources$1$1 extends FunctionReferenceImpl implements Function1<String, o> {
    public DoraResourcePackageSynchronizer$stageTransaction$hasAllDeviceSpecificResources$1$1(Object r100) {
        super(1, r100, Map.class, MonitorConstants.CONNECT_TYPE_GET, "get(Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final o invoke2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        return (o) ((Map) this.receiver).get(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ o invoke(String r100) {
        return invoke2(r100);
    }
}

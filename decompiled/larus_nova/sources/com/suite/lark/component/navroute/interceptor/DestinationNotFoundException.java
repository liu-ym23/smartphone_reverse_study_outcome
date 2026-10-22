package com.suite.lark.component.navroute.interceptor;

import com.monitor.cloudmessage.consts.CloudControlInf;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/suite/lark/component/navroute/interceptor/DestinationNotFoundException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", CloudControlInf.ROUTE, "", "routerId", "graphName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "router_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DestinationNotFoundException extends RuntimeException {
    public DestinationNotFoundException(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, CloudControlInf.ROUTE);
        Intrinsics.checkNotNullParameter(r101, "routerId");
        Intrinsics.checkNotNullParameter(r102, "graphName");
        super("destination:" + r100 + " not found from routerId:" + r101 + " graph:" + r102);
    }
}

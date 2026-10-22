package com.ss.android.lark.rustinfrabridge.appstatesync.service.impl;

import com.bytedance.lark.pb.basic.v1.TrafficData;
import com.bytedance.lark.pb.tool.v1.TakeTrafficDataResponse;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/bytedance/lark/pb/tool/v1/TakeTrafficDataResponse;", "kotlin.jvm.PlatformType", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class GlobalAppStateService$takeSdkTrafficData$1 extends Lambda implements Function1<TakeTrafficDataResponse, Unit> {
    final /* synthetic */ Ref.ObjectRef<e3c.a> $result;

    public GlobalAppStateService$takeSdkTrafficData$1(Ref.ObjectRef<e3c.a> r100) {
        this.$result = r100;
        super(1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(TakeTrafficDataResponse r110) {
        TrafficData r111 = r110.data;
        Ref.ObjectRef<e3c.a> r100 = this.$result;
        if (r111 == null) goto L5;
        T r112 = new e3c.a(r111.wifi_recv.longValue(), r111.wifi_send.longValue(), r111.mobile_recv.longValue(), r111.mobile_send.longValue());
    L6:
        r100.element = r112;
        return;
    L5:
        r112 = 0;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(TakeTrafficDataResponse r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}

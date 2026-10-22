package com.bytedance.bdp.appbase.service.protocol.device;

import com.bytedance.bdp.appbase.context.service.operate.sync.ResultType;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 18})
final class DeviceServiceCn$mClipboardManager$1$setClipboardData$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $data;
    final /* synthetic */ o94.c $setClipboardDataListener;
    final /* synthetic */ b this$0;

    public DeviceServiceCn$mClipboardManager$1$setClipboardData$1(b r100, String r101, o94.c r102) {
        this.$data = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        throw null;     // Catch: Throwable -> L4
    L4:
        th = move-exception;
        int r100 = p94.a.f528295d;
        new p94.a(ResultType.ERROR_NATIVE_EXCEPTION, null, th).b();
        throw null;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}

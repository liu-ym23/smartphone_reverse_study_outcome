package com.bytedance.lark.sdk.refactor;

import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.bytedance.lark.pb.basic.v1.SetEnvResponse;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class RustSDK$setEnv$3 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ IGetDataCallback<SetEnvResponse> $callback;

    public RustSDK$setEnv$3(IGetDataCallback<SetEnvResponse> r100) {
        this.$callback = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        IGetDataCallback<SetEnvResponse> r101 = this.$callback;
        if (r101 == null) goto L6;
        Exception r102 = new Exception(IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN);
        String r103 = r100.getMessage();
        ErrorResult r104 = new ErrorResult(0);
        ErrorResult.access$002(r104, -1);
        ErrorResult.access$102(r104, -9999);
        ErrorResult.access$202(r104, 0);
        ErrorResult.access$302(r104, r102);
        ErrorResult.access$402(r104, "");
        ErrorResult.access$502(r104, r103);
        ErrorResult.access$602(r104, "");
        ErrorResult.access$702(r104, "");
        ErrorResult.access$802(r104, 0);
        ErrorResult.access$902(r104, null);
        ErrorResult.access$1002(r104, null);
        ErrorResult.access$1102(r104, null);
        r101.onError(r104);
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}

package com.bytedance.lark.sdk.refactor;

import com.bytedance.lark.pb.basic.v1.SetEnvResponse;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larksuite.framework.callback.IGetDataCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/bytedance/lark/rustclient/api/RustClientError;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class RustSDK$setEnv$2 extends Lambda implements Function1<com.bytedance.lark.rustclient.api.p, Unit> {
    final /* synthetic */ IGetDataCallback<SetEnvResponse> $callback;

    public RustSDK$setEnv$2(IGetDataCallback<SetEnvResponse> r100) {
        this.$callback = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(com.bytedance.lark.rustclient.api.p r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        IGetDataCallback<SetEnvResponse> r101 = this.$callback;
        if (r101 == null) goto L6;
        r101.onError(com.bytedance.lark.rustclient.api.p.a(r100));
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(com.bytedance.lark.rustclient.api.p r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}

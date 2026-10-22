package com.bytedance.platform.aio.channel.js;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.platform.aio.channel.js.model.e;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/platform/aio/channel/js/model/e;", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/platform/aio/channel/js/model/e;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class JsBridgeChannelClient$jsbV2Method$1 extends FunctionReferenceImpl implements Function1<e, Unit> {
    public JsBridgeChannelClient$jsbV2Method$1(JsBridgeChannelClient r100) {
        super(1, r100, JsBridgeChannelClient.class, "onMessageV2", "onMessageV2(Lcom/bytedance/platform/aio/channel/js/model/Message;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(e r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        JsBridgeChannelClient r101 = (JsBridgeChannelClient) this.receiver;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "message");
        r101.g(r100, true);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(e r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}

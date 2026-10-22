package com.ss.ugc.live.sdk.platform.bytelink.dispatch;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/ss/ugc/live/sdk/platform/bytelink/dispatch/c;", "listener", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/ss/ugc/live/sdk/platform/bytelink/dispatch/c;)V", "triggerListener"}, k = 3, mv = {1, 4, 0})
final class ByteLinkDispatcher$dispatchDecodePacket$1 extends Lambda implements Function1<c, Unit> {
    final /* synthetic */ nmc.a $decodePacket;
    final /* synthetic */ a this$0;

    public ByteLinkDispatcher$dispatchDecodePacket$1(a r100, nmc.a r101) {
        this.this$0 = r100;
        this.$decodePacket = r101;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(c r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        throw null;
    }
}

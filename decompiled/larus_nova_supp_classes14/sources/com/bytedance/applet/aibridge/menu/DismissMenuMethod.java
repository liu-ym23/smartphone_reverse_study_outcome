package com.bytedance.applet.aibridge.menu;

import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import d3.a0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/applet/aibridge/menu/DismissMenuMethod;", "Lcom/bytedance/applet/aibridge/menu/AbsDismissMenuMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/menu/AbsDismissMenuMethodIDL$DismissMenuParamModal;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/menu/AbsDismissMenuMethodIDL$DismissMenuResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DismissMenuMethod extends AbsDismissMenuMethodIDL {
    public DismissMenuMethod() {
    }

    public final void handle(e3.d r11, ParamModel r12, f3.h r13) {
        AbsDismissMenuMethodIDL.a r14 = (AbsDismissMenuMethodIDL.a) r12;
        Intrinsics.checkNotNullParameter(r11, "bridgeContext");
        Intrinsics.checkNotNullParameter(r14, "params");
        Intrinsics.checkNotNullParameter(r13, "callback");
        a0 r0 = r11.getContainerContext();
        if (r0 == null) goto L5;
        ContainerType r1 = r0.getContainerType();
    L7:
        if (r1 == ContainerType.WIDGET) goto L9;
        f3.h.a.a(r13, "Only supports widget call the method", null, null, 14);
        Unit r15 = Unit.INSTANCE;
        return;
    L9:
        if (((WidgetContainer) r11.d(WidgetContainer.class)) != null) goto L11;
    L12:
        f3.h.a.a(r13, "Failed to get WidgetContainer", null, null, 14);
        Unit r16 = Unit.INSTANCE;
        return;
    L11:
        if (BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), null, new DismissMenuMethod$handle$1$1(r14, r13, null), 2, null) == null) goto L12;
        return;
    L5:
        r1 = null;
        goto L7
    }
}

package com.bytedance.applet.aibridge;

import android.view.View;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.widget.WidgetManager;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import com.bytedance.applet.utils.MessageUtils;
import d3.a0;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/applet/aibridge/IsLastMessageMethod;", "Lcom/bytedance/applet/aibridge/AbsIsLastMessageMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/AbsIsLastMessageMethodIDL$IsLastMessageParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/AbsIsLastMessageMethodIDL$IsLastMessageResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IsLastMessageMethod extends AbsIsLastMessageMethodIDL {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ContainerType.values().length];
            r0[ContainerType.WIDGET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    public IsLastMessageMethod() {
    }

    public final void handle(e3.d r3, ParamModel r4, final f3.h r5) {
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsIsLastMessageMethodIDL.a) r4, "params");
        Intrinsics.checkNotNullParameter(r5, "callback");
        a0 r6 = r3.getContainerContext();
        String r0 = null;
        if (r6 == null) goto L5;
        ContainerType r7 = r6.getContainerType();
    L6:
        if (r7 != null) goto L8;
        int r8 = -1;
    L10:
        if (r8 != 1) goto L22;
        WidgetContainer r9 = (WidgetContainer) r3.d(WidgetContainer.class);
        if (r9 == null) goto L14;
        View r10 = r9.realView();
    L15:
        AppletRuntimeManager.INSTANCE.getClass();
        if (r10 != null) goto L18;
        com.bytedance.ai.widget.contianer.h r11 = null;
    L19:
        if (r11 == null) goto L21;
        r0 = r11.l();
    L21:
        MessageUtils r12 = MessageUtils.a;
        Function1 r13 = new n(r5);
        r12.getClass();
        MessageUtils.k(r0, r13);
        return;
    L18:
        r11 = WidgetManager.h.a(r10);
        goto L19
    L14:
        r10 = null;
        goto L15
    L22:
        f3.h.a.a(r5, "MUST invoke applet.isLastMessage in widget.", null, null, 14);
        return;
    L8:
        r8 = a.a[r7.ordinal()];
        goto L10
    L5:
        r7 = null;
        goto L6
    }
}

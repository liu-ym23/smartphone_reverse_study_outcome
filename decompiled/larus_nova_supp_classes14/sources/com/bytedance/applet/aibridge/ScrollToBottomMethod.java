package com.bytedance.applet.aibridge;

import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import d3.a0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/applet/aibridge/ScrollToBottomMethod;", "Lcom/bytedance/applet/aibridge/AbsScrollToBottomMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/AbsScrollToBottomMethodIDL$ScrollToBottomParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/AbsScrollToBottomMethodIDL$ScrollToBottomResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScrollToBottomMethod extends AbsScrollToBottomMethodIDL {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ContainerType.values().length];
            r0[ContainerType.WIDGET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    public ScrollToBottomMethod() {
    }

    public final void handle(e3.d r8, ParamModel r9, f3.h r10) {
        Intrinsics.checkNotNullParameter(r8, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsScrollToBottomMethodIDL.a) r9, "params");
        Intrinsics.checkNotNullParameter(r10, "callback");
        a0 r11 = r8.getContainerContext();
        if (r11 == null) goto L5;
        ContainerType r12 = r11.getContainerType();
    L6:
        if (r12 != null) goto L8;
        int r13 = -1;
    L10:
        if (r13 != 1) goto L15;
        WidgetContainer r14 = (WidgetContainer) r8.d(WidgetContainer.class);
        if (r14 == null) goto L14;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new ScrollToBottomMethod$handle$1$1(r14, null), 3, null);
        Intrinsics.checkNotNullParameter(AbsScrollToBottomMethodIDL.b.class, "<this>");
        r10.b(k3.c.a(AbsScrollToBottomMethodIDL.b.class), "");
        return;
    L14:
        f3.h.a.a(r10, "widgetContainer not found.", null, null, 14);
        return;
    L15:
        f3.h.a.a(r10, "MUST invoke flow.scrollToBottom in widget.", null, null, 14);
        return;
    L8:
        r13 = a.a[r12.ordinal()];
        goto L10
    L5:
        r12 = null;
        goto L6
    }
}

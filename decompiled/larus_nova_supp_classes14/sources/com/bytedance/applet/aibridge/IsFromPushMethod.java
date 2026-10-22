package com.bytedance.applet.aibridge;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import d3.a0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u000e\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u000fH\u0002¨\u0006\u0010"}, d2 = {"Lcom/bytedance/applet/aibridge/IsFromPushMethod;", "Lcom/bytedance/applet/aibridge/AbsIsFromPushMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/AbsIsFromPushMethodIDL$IsFromPushParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/AbsIsFromPushMethodIDL$IsFromPushResultModel;", "findFlowActivity", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "Landroid/content/Context;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IsFromPushMethod extends AbsIsFromPushMethodIDL {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ContainerType.values().length];
            r0[ContainerType.WIDGET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ContainerType.PAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public IsFromPushMethod() {
    }

    public final void handle(e3.d r3, ParamModel r4, f3.h r5) {
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsIsFromPushMethodIDL.a) r4, "params");
        Intrinsics.checkNotNullParameter(r5, "callback");
        a0 r6 = r3.getContainerContext();
        FlowCommonAppCompatActivity r0 = null;
        if (r6 == null) goto L5;
        ContainerType r7 = r6.getContainerType();
    L6:
        if (r7 != null) goto L8;
        int r8 = -1;
    L10:
        if (r8 != 1) goto L12;
    L14:
        View r9 = r3.getEngineView();
        if (r9 == null) goto L25;
        Context r10 = r9.getContext();
        if (r10 == null) goto L25;
    L18:
        if (r10 == null) goto L25;
        if ((r10 instanceof FlowCommonAppCompatActivity) == true) goto L21;
        if ((r10 instanceof ContextWrapper) == false) goto L25;
        r10 = ((ContextWrapper) r10).getBaseContext();
        goto L18
    L21:
        r0 = (FlowCommonAppCompatActivity) r10;
    L25:
        if (r0 == null) goto L27;
        boolean r11 = r0.a;
    L28:
        Intrinsics.checkNotNullParameter(AbsIsFromPushMethodIDL.b.class, "<this>");
        AbsIsFromPushMethodIDL.b r12 = k3.c.a(AbsIsFromPushMethodIDL.b.class);
        r12.setValue(r11);
        r5.b(r12, "");
        return;
    L27:
        r11 = false;
        goto L28
    L12:
        if (r8 == 2) goto L14;
        f3.h.a.a(r5, "MUST invoke applet.isFromPush in page and widget.", null, null, 14);
        return;
    L8:
        r8 = a.a[r7.ordinal()];
        goto L10
    L5:
        r7 = null;
        goto L6
    }
}

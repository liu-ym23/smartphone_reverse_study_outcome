package com.bytedance.applet.aibridge.menu;

import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import com.google.gson.Gson;
import d3.a0;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/applet/aibridge/menu/UpdateMenuMethod;", "Lcom/bytedance/applet/aibridge/menu/AbsUpdateMenuMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/menu/AbsUpdateMenuMethodIDL$UpdateMenuParamModal;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/menu/AbsUpdateMenuMethodIDL$UpdateMenuResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UpdateMenuMethod extends AbsUpdateMenuMethodIDL {
    public UpdateMenuMethod() {
    }

    public final void handle(e3.d r18, ParamModel r19, f3.h r20) {
        AbsUpdateMenuMethodIDL.a r3 = (AbsUpdateMenuMethodIDL.a) r19;
        Intrinsics.checkNotNullParameter(r18, "bridgeContext");
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r20, "callback");
        Gson r0 = new Gson();
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L5
        Object r1 = Result.constructor-impl((List) r0.fromJson(r3.getMenuItems(), new i().getType()));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r1) == false) goto L10;
        r1 = null;
    L10:
        List r2 = (List) r1;
        a0 r5 = r18.getContainerContext();
        if (r5 == null) goto L13;
        ContainerType r6 = r5.getContainerType();
    L15:
        if (r6 != ContainerType.WIDGET) goto L46;
        final WidgetContainer r7 = (WidgetContainer) r18.d(WidgetContainer.class);
        if (r7 != null) goto L19;
    L45:
        f3.h.a.a(r20, "Failed to get WidgetContainer", null, null, 14);
        Unit r8 = Unit.INSTANCE;
        return;
    L19:
        if (r2 != null) goto L21;
    L23:
        boolean r9 = false;
    L24:
        if (r9 == true) goto L27;
        r2 = null;
    L27:
        if (r2 == null) goto L43;
        Iterator r10 = r2.iterator();
    L30:
        if (r10.hasNext() == false) goto L41;
        final WidgetMenuItem r11 = (WidgetMenuItem) r10.next();
        String r12 = r11.getId();
        if (r12 != null) goto L34;
    L37:
        boolean r13 = true;
    L38:
        if (r13 == true) goto L39;
        r11.setOnTap(new g(r11, r7));
        goto L30
    L39:
        f3.h.a.a(r20, "menuItem{" + r11.getText() + "}.id is empty", null, null, 14);
        return;
    L34:
        if (r12.length() == 0) goto L37;
        r13 = false;
        goto L38
    L41:
        Job r14 = BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), null, new UpdateMenuMethod$handle$1$2$2(r3, r2, r20, null), 2, null);
        if (r14 == null) goto L43;
    L44:
        if (r14 == null) goto L45;
        return;
    L43:
        f3.h.a.a(r20, "menuItems is empty", null, null, 14);
        r14 = Unit.INSTANCE;
        goto L44
    L21:
        if ((!r2.isEmpty()) != true) goto L23;
        r9 = true;
        goto L24
    L46:
        f3.h.a.a(r20, "Only supports widget call the method", null, null, 14);
        Unit r15 = Unit.INSTANCE;
        return;
    L13:
        r6 = null;
    L5:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }
}

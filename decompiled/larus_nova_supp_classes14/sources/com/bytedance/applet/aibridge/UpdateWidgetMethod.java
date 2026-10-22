package com.bytedance.applet.aibridge;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0002J\u001e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u001e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u001e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¨\u0006\u0013"}, d2 = {"Lcom/bytedance/applet/aibridge/UpdateWidgetMethod;", "Lcom/bytedance/applet/aibridge/AbsUpdateWidgetMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/AbsUpdateWidgetMethodIDL$UpdateWidgetParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/AbsUpdateWidgetMethodIDL$UpdateWidgetResultModel;", "shouldUseBlockProtocol", "", "updateWidgetContent", "updateMessageContentBlock", "updateMessageContent", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UpdateWidgetMethod extends AbsUpdateWidgetMethodIDL {
    public static final /* synthetic */ int b = 0;

    public static final class a {
    }

    static {
    }

    public UpdateWidgetMethod() {
    }

    public final void handle(e3.d r13, ParamModel r14, f3.h r15) {
        AbsUpdateWidgetMethodIDL.a r16 = (AbsUpdateWidgetMethodIDL.a) r14;
        Intrinsics.checkNotNullParameter(r13, "bridgeContext");
        Intrinsics.checkNotNullParameter(r16, "params");
        Intrinsics.checkNotNullParameter(r15, "callback");
        String r17 = r16.getCardId();
        boolean r0 = true;
        if (r17 != null) goto L5;
    L8:
        boolean r18 = true;
    L10:
        if (r18 == false) goto L12;
        boolean r19 = Intrinsics.areEqual(r16.getNeedBlockMeta(), Boolean.TRUE);
        com.bytedance.ai.utils.g r7 = com.bytedance.ai.utils.g.a;
        r7.i("UpdateWidgetMethod", "[UpdateWidgetMethod] route msgId=" + r16.getMsgId() + " needBlockMeta=" + r16.getNeedBlockMeta() + " useBlockProtocol=" + r19);
        if (r19 == false) goto L45;
        String r110 = r16.getType();
        if (Intrinsics.areEqual(r110, "msg") == true) goto L33;
        r7.e("UpdateWidgetMethod", "[BlockProtocol] invalid widgetType " + r110);
        f3.h.a.a(r15, "invalid widgetType", null, null, 14);
        return;
    L33:
        if (r16.getMsgId().length() != 0) goto L35;
        boolean r111 = true;
    L36:
        if (r111 == false) goto L39;
        r7.e("UpdateWidgetMethod", "[BlockProtocol] message id is nil or empty");
        f3.h.a.a(r15, "message id is nil or empty", null, null, 14);
        return;
    L39:
        if (r16.getWidgetData().length() == 0) goto L42;
        r0 = false;
    L42:
        if (r0 == false) goto L44;
        r7.e("UpdateWidgetMethod", "[BlockProtocol] widgetData is nil or empty");
        f3.h.a.a(r15, "widgetData is nil or empty", null, null, 14);
        return;
    L44:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new UpdateWidgetMethod$updateMessageContentBlock$1(r16, r15, null), 3, null);
        return;
    L35:
        r111 = false;
        goto L36
    L45:
        String r112 = r16.getType();
        if (Intrinsics.areEqual(r112, "msg") == true) goto L49;
        r7.e("UpdateWidgetMethod", "handle unknown widgetType " + r112);
        f3.h.a.a(r15, "invalid widgetType", null, null, 14);
        return;
    L49:
        if (r16.getMsgId().length() == 0) goto L52;
        r0 = false;
    L52:
        if (r0 == false) goto L54;
        r7.e("UpdateWidgetMethod", "invalid messageId");
        f3.h.a.a(r15, "invalid messageId", null, null, 14);
        return;
    L54:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new UpdateWidgetMethod$updateMessageContent$1(r16, r15, null), 3, null);
        return;
    L12:
        if (r16.getMsgId().length() != 0) goto L14;
        boolean r113 = true;
    L15:
        if (r113 == false) goto L18;
        com.bytedance.ai.utils.g.a.e("UpdateWidgetMethod", "[WidgetContent] message id is nil or empty");
        f3.h.a.a(r15, "message id is nil or empty", null, null, 14);
        return;
    L18:
        if (r16.getWidgetData().length() == 0) goto L21;
        r0 = false;
    L21:
        if (r0 == false) goto L23;
        com.bytedance.ai.utils.g.a.e("UpdateWidgetMethod", "[WidgetContent] widgetData is nil or empty");
        f3.h.a.a(r15, "widgetData is nil or empty", null, null, 14);
        return;
    L23:
        String r114 = r16.getCardId();
        if (r114 != null) goto L26;
        r114 = "";
    L26:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new UpdateWidgetMethod$updateWidgetContent$1(r16, r114, r15, null), 3, null);
        return;
    L14:
        r113 = false;
        goto L15
    L5:
        if (r17.length() == 0) goto L8;
        r18 = false;
        goto L10
    }
}

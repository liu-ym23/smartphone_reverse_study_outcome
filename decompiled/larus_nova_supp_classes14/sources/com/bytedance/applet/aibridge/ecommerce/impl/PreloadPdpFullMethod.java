package com.bytedance.applet.aibridge.ecommerce.impl;

import android.content.Context;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import com.bytedance.applet.aibridge.ecommerce.api.AbsPreloadPdpFullMethodIDL;
import com.larus.common.apphost.AppHost;
import com.larus.platform.api.l2;
import com.larus.platform.service.l0;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import e3.d;
import f3.h;
import java.util.Iterator;
import java.util.List;
import k3.c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lv3.b;
import lv3.e;
import lv3.s;
import lv3.t;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\"\u0010\u0011\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u000eH\u0002J(\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\u0002¨\u0006\u0017"}, d2 = {"Lcom/bytedance/applet/aibridge/ecommerce/impl/PreloadPdpFullMethod;", "Lcom/bytedance/applet/aibridge/ecommerce/api/AbsPreloadPdpFullMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/ecommerce/api/AbsPreloadPdpFullMethodIDL$PreloadPdpFullMethodParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/ecommerce/api/AbsPreloadPdpFullMethodIDL$PreloadPdpFullMethodResultModel;", "validationFailureReason", "", "hasWidgetContainer", "", "logPayload", "failureReason", "payloadLogMessage", "result", "reason", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PreloadPdpFullMethod extends AbsPreloadPdpFullMethodIDL {
    public static final /* synthetic */ int b = 0;

    public static final class a {
    }

    static {
    }

    public PreloadPdpFullMethod() {
    }

    public final void handle(d r11, ParamModel r12, h r13) {
        final AbsPreloadPdpFullMethodIDL.a r14 = (AbsPreloadPdpFullMethodIDL.a) r12;
        Intrinsics.checkNotNullParameter(r11, "bridgeContext");
        Intrinsics.checkNotNullParameter(r14, "params");
        Intrinsics.checkNotNullParameter(r13, "callback");
        WidgetContainer r15 = (WidgetContainer) r11.d(WidgetContainer.class);
        int r0 = 0;
        boolean r1 = true;
        if (r15 == null) goto L5;
        final boolean r2 = true;
    L7:
        if (r2 == true) goto L9;
        final String r3 = "missing_widget_container";
    L37:
        if (r3 != null) goto L39;
        FLogger.a.i("PreloadPdpFullMethod", new s(this, r14, r2));
    L40:
        if (r3 != null) goto L83;
        if (r15 == null) goto L83;
        com.bytedance.applet.aibridge.ecommerce.impl.a r4 = com.bytedance.applet.aibridge.ecommerce.impl.a.a;
        String r5 = r14.getMessageId();
        if (r5 != null) goto L46;
        r5 = "";
    L46:
        String r6 = r14.getMixtureCardId();
        if (r6 != null) goto L49;
        r6 = "";
    L49:
        String r7 = r15.b;
        if (r7 != null) goto L52;
        r7 = "";
    L52:
        List<String> r16 = r14.getSchemaList();
        if (r16 != null) goto L55;
        r16 = CollectionsKt.emptyList();
    L55:
        final e r8 = new e(r5, r6, r7, r16);
        Context r17 = r15.getActivity();
        Intrinsics.checkNotNullParameter(r8, "request");
        final lv3.a r18 = com.bytedance.applet.aibridge.ecommerce.impl.a.g();
        FLogger r9 = FLogger.a;
        r9.i("ECommerceProductCardPreload", "[product_card_preload] stage=manager_receive group=" + r18.a.getValue() + " message_id=" + r8.a + " mixture_card_id=" + r8.b + " schema_count=" + r8.d.size() + " max_card_count=" + r18.c + " throttle_interval=" + r18.b);
        Object r10 = com.bytedance.applet.aibridge.ecommerce.impl.a.b;
        monitor-enter(r10);
        com.bytedance.applet.aibridge.ecommerce.impl.a.m(r18.a);     // Catch: Throwable -> L80
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L80
        monitor-exit(r10);
        final ECommerceProductCardPreloadDecision r20 = com.bytedance.applet.aibridge.ecommerce.impl.a.j(r8, r18);
        if ((r20 instanceof ECommerceProductCardPreloadDecision.b) == false) goto L63;
        r9.g("ECommerceProductCardPreload", new b(r20, r18, r8));
    L77:
        Intrinsics.checkNotNullParameter(AbsPreloadPdpFullMethodIDL.b.class, "<this>");
        r13.b(c.a(AbsPreloadPdpFullMethodIDL.b.class), "");
        return;
    L63:
        if ((r20 instanceof ECommerceProductCardPreloadDecision.a) == false) goto L79;
        r9.g("ECommerceProductCardPreload", new lv3.c(r18, r8, r20));
        List<String> r110 = ((ECommerceProductCardPreloadDecision.a) r20).a;
        if (r17 != null) goto L67;
        r17 = AppHost.a.getApplication();
    L67:
        l2 r21 = l0.a();
        if (r21 == null) goto L77;
        Iterator<T> r22 = r110.iterator();
    L72:
        if (r22.hasNext() == false) goto L76;
        String r23 = (String) r22.next();
        o r24 = o.a;
        JSONObject r25 = new JSONObject();
        r25.put("message_id", r8.a);
        r25.put("mixture_card_id", r8.b);
        r25.put("schema_count", r110.size());
        r25.put("conversation_id", r8.c);
        Unit r26 = Unit.INSTANCE;
        r24.reportEvent("ecommerce_product_card_preload", r25);
        if (r21.h(r17, r23) == false) goto L72;
        r0 = r0 + 1;
        goto L72
    L76:
        FLogger.a.i("ECommerceProductCardPreload", "[product_card_preload] stage=bridge_dispatch schema_count=" + r110.size() + " accepted_count=" + r0);
        goto L77
    L79:
        throw new NoWhenBranchMatchedException();
    L80:
        th = move-exception;
        throw th;
    L83:
        h.a.a(r13, null, null, null, 15);
        return;
    L39:
        FLogger.a.f("PreloadPdpFullMethod", new t(this, r14, r2, r3));
        goto L40
    L9:
        String r27 = r14.getMessageId();
        if (r27 != null) goto L12;
    L15:
        boolean r28 = true;
    L16:
        if (r28 == false) goto L18;
        r3 = "empty_message_id";
        goto L37
    L18:
        String r29 = r14.getMixtureCardId();
        if (r29 != null) goto L21;
    L24:
        boolean r30 = true;
    L25:
        if (r30 == false) goto L27;
        r3 = "empty_mixture_card_id";
        goto L37
    L27:
        List<String> r31 = r14.getSchemaList();
        if (r31 != null) goto L30;
    L33:
        if (r1 == false) goto L35;
        r3 = "empty_schema_list";
        goto L37
    L35:
        r3 = null;
        goto L37
    L30:
        if (r31.isEmpty() == true) goto L33;
        r1 = false;
        goto L33
    L21:
        if (StringsKt.isBlank(r29) == true) goto L24;
        r30 = false;
        goto L25
    L12:
        if (StringsKt.isBlank(r27) == true) goto L15;
        r28 = false;
        goto L16
    L5:
        r2 = false;
        goto L7
    }

    public static String b(AbsPreloadPdpFullMethodIDL.a r2, boolean r3, String r4, String r5) {
        StringBuilder r0 = new StringBuilder("[product_card_preload] stage=jsb_payload result=");
        r0.append(r4);
        r0.append(" reason=");
        r0.append(r5);
        r0.append(" message_id=");
        String r6 = r2.getMessageId();
        String r7 = "";
        if (r6 != null) goto L5;
        r6 = "";
    L5:
        r0.append(r6);
        r0.append(" mixture_card_id=");
        String r8 = r2.getMixtureCardId();
        if (r8 == null) goto L9;
        r7 = r8;
    L9:
        r0.append(r7);
        r0.append(" schema_count=");
        List<String> r9 = r2.getSchemaList();
        if (r9 == null) goto L12;
        int r10 = r9.size();
    L13:
        r0.append(r10);
        r0.append(" has_widget_container=");
        r0.append(r3);
        return r0.toString();
    L12:
        r10 = 0;
        goto L13
    }
}

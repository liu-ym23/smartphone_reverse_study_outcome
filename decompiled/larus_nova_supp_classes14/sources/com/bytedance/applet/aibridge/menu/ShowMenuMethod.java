package com.bytedance.applet.aibridge.menu;

import android.view.View;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import com.bytedance.applet.model.menu.MenuConfigImplKt;
import com.google.gson.Gson;
import com.larus.utils.logger.FLogger;
import d3.a0;
import java.util.Iterator;
import java.util.List;
import kc8.e0;
import kc8.y0;
import kc8.z0;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\tH\u0002J&\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J&\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¨\u0006\u0017"}, d2 = {"Lcom/bytedance/applet/aibridge/menu/ShowMenuMethod;", "Lcom/bytedance/applet/aibridge/menu/AbsShowMenuMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/menu/AbsShowMenuMethodIDL$ShowMenuParamModal;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/menu/AbsShowMenuMethodIDL$ShowMenuResultModel;", "tryInterceptMenu", "", "widgetContainer", "Lcom/bytedance/ai/widget/contianer/WidgetContainer;", "handleDoubleMenuItem", "", "menuItem", "Lcom/bytedance/applet/aibridge/menu/WidgetMenuItem;", "handleMenuItem", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShowMenuMethod extends AbsShowMenuMethodIDL {
    public static final /* synthetic */ int b = 0;

    public static final class a {
    }

    static {
    }

    public ShowMenuMethod() {
    }

    public static boolean b(final WidgetMenuItem r3, final WidgetContainer r4, f3.h r5) {
        String r0 = r3.getId();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        f3.h.a.a(r5, "menuItem{" + r3.getText() + "}.id is empty", null, null, 14);
        return false;
    L12:
        r3.setOnTap(new d(r3, r4));
        return true;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final void handle(e3.d r13, ParamModel r14, final f3.h r15) {
        AbsShowMenuMethodIDL.a r16 = (AbsShowMenuMethodIDL.a) r14;
        Intrinsics.checkNotNullParameter(r13, "bridgeContext");
        Intrinsics.checkNotNullParameter(r16, "params");
        Intrinsics.checkNotNullParameter(r15, "callback");
        a0 r0 = r13.getContainerContext();
        if (r0 == null) goto L5;
        ContainerType r1 = r0.getContainerType();
    L7:
        if (r1 != ContainerType.WIDGET) goto L94;
        WidgetContainer r7 = (WidgetContainer) r13.d(WidgetContainer.class);
        if (r7 == null) goto L93;
        View r17 = r7.realView();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L29
        int r3 = z0.a;     // Catch: Throwable -> L29
        View r4 = r17;
    L12:
        if (r4 == null) goto L23;
        Object r5 = r4.getTag(2131377375);     // Catch: Throwable -> L29
        if ((r5 instanceof e0) == false) goto L16;
        e0 r6 = (e0) r5;     // Catch: Throwable -> L29
    L17:
        if (r6 != null) goto L24;
        Object r8 = r4.getParent();     // Catch: Throwable -> L29
        if ((r8 instanceof View) == true) goto L21;
        r4 = null;
        goto L12
    L21:
        r4 = (View) r8;     // Catch: Throwable -> L29
    L24:
        if (r6 == null) goto L26;
        String r18 = r6.a(new y0(r17, r7.l(), r16.getBusinessType(), r16.getTraceInfo()));     // Catch: Throwable -> L29
    L27:
        Object r19 = Result.constructor-impl(r18);     // Catch: Throwable -> L29
    L31:
        Throwable r9 = Result.exceptionOrNull-impl(r19);
        if (r9 == null) goto L35;
        FLogger.a.e("ShowMenuMethod", "intercept widget showMenu failed", r9);
    L35:
        if (Result.isFailure-impl(r19) == false) goto L37;
        r19 = null;
    L37:
        String r110 = (String) r19;
        if (r110 != null) goto L40;
    L43:
        boolean r10 = true;
    L44:
        if (r10 == true) goto L96;
        Intrinsics.checkNotNullParameter(AbsShowMenuMethodIDL.b.class, "<this>");
        AbsShowMenuMethodIDL.b r111 = k3.c.a(AbsShowMenuMethodIDL.b.class);
        r111.setMenuId(r110);
        r15.b(r111, "");
        return;
    L96:
        Object r112 = Result.constructor-impl((List) new Gson().fromJson(r16.getMenuItems(), new f().getType()));     // Catch: Throwable -> L49
    L52:
        if (Result.isFailure-impl(r112) == false) goto L54;
        r112 = null;
    L54:
        List r113 = (List) r112;
        if (r113 != null) goto L57;
    L59:
        boolean r11 = false;
    L60:
        if (r11 == false) goto L62;
        List r12 = r113;
    L63:
        if (r12 == null) goto L92;
        Iterator r114 = r12.iterator();
    L66:
        if (r114.hasNext() == false) goto L91;
        WidgetMenuItem r20 = (WidgetMenuItem) r114.next();
        String r21 = r20.getItemStyle();
        if (Intrinsics.areEqual(r21, "double") == true) goto L69;
        if (Intrinsics.areEqual(r21, "divider") == true) goto L66;
        if (b(r20, r7, r15) == true) goto L66;
        return;
    L69:
        List<WidgetMenuItem> r22 = r20.getLineItems();
        if (r22 != null) goto L72;
    L74:
        boolean r23 = false;
    L75:
        if (r23 == true) goto L77;
        f3.h.a.a(r15, "doubleItem size wrong, id: " + r20.getId(), null, null, 14);
    L82:
        boolean r24 = false;
    L84:
        if (r24 == true) goto L66;
        return;
    L77:
        Iterator<T> r25 = r20.getLineItems().iterator();
    L79:
        if (r25.hasNext() == false) goto L83;
        if (b((WidgetMenuItem) r25.next(), r7, r15) == true) goto L79;
    L83:
        r24 = true;
        goto L84
    L72:
        if (r22.size() != 2) goto L74;
        r23 = true;
        goto L75
    L91:
        MenuConfigImplKt.b.a.invoke(r12, r16.getOffset(), r7, r16.getMenuStyle(), r16.getBusinessType(), r16.getTraceInfo(), new c(r15));
        return;
    L92:
        f3.h.a.a(r15, "menuItems is empty", null, null, 14);
        return;
    L62:
        r12 = null;
        goto L63
    L57:
        if ((!r113.isEmpty()) != true) goto L59;
        r11 = true;
    L49:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r112 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L52
    L40:
        if (r110.length() == 0) goto L43;
        r10 = false;
        goto L44
    L26:
        r18 = null;
        goto L27
    L16:
        r6 = null;
        goto L17
    L23:
        r6 = null;
    L29:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r19 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L31
    L93:
        f3.h.a.a(r15, "Failed to get WidgetContainer", null, null, 14);
        return;
    L94:
        f3.h.a.a(r15, "Only supports widget call the method", null, null, 14);
        return;
    L5:
        r1 = null;
        goto L7
    }
}

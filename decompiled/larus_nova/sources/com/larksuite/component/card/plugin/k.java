package com.larksuite.component.card.plugin;

import com.larksuite.component.card.action.UniversalCardActionManager;
import com.larksuite.component.card.action.UniversalCardActionManager$requestAction$1;
import com.larksuite.component.card.plugin.model.UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuResponseModel;
import com.larksuite.component.card.protocol.context.BizContext;
import com.larksuite.component.card.protocol.context.action.CardActionService;
import com.larksuite.component.card.protocol.data.action.ActionInfo;
import com.larksuite.framework.apiplugin.LKEvent;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.lynxkit.bridge.ILynxBridgeContext;
import com.ss.android.lark.lynxkit.container.ILynxContainerContext;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f283817a = 0;

    static {
    }

    public static void c(LKEvent r100, UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuResponseModel r101, j18.f r102) {
        Intrinsics.checkNotNullParameter(r100, "lkEvent");
        Intrinsics.checkNotNullParameter(r101, "selectParams");
        Intrinsics.checkNotNullParameter(r102, "invokeCallback");
        Object r103 = r100.f285495h;
        Object r104 = null;
        if ((r103 instanceof ILynxBridgeContext) == false) goto L10;
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type com.ss.android.lark.lynxkit.bridge.ILynxBridgeContext");
        ILynxContainerContext r105 = ((ILynxBridgeContext) r103).getContainerContext();
        if (r105 == null) goto L9;
        Map<String, Object> r106 = r105.getBizExtra();
        if (r106 == null) goto L9;
        r104 = r106.get("card_share_data");
    L9:
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type com.larksuite.component.card.cardcontainer.UniversalCardShareData");
        r104 = (com.larksuite.component.card.cardcontainer.c) r104;
    L10:
        if (r104 != null) goto L12;
        Log.w("MsgCardPluginUtils", "select msgId is null");
        return;
    L12:
        r102.callback(r101);
    }

    public static dz7.b a(String r110, Map r111, String r112, com.larksuite.component.card.cardcontainer.c r113, boolean r114, OPTrace r210, Integer r211, String r212, String r213) {
        if (r112 == null) goto L5;
        String r100 = r112;
    L6:
        boolean r101 = r113.f283235c.getCardActionDependencyData().isEphemeralCard();
        if (r211 == null) goto L9;
        int r115 = r211.intValue();
    L10:
        OPTrace r102 = gyb.a.a().subTrace();
        if (r210 == null) goto L13;
        OPTrace r103 = r210;
    L15:
        return new dz7.b(r110, r111, r100, r113.f283234b.getVersion(), r101, r114, r103, r115, r212, r213, r113.f283234b.isStreamingMode(), r113.f283234b.getActionDataSource());
    L13:
        r103 = r102;
        goto L15
    L9:
        r115 = 0;
        goto L10
    L5:
        r100 = "";
        goto L6
    }

    public static void b(final ILynxBridgeContext r110, String r111, String r210, com.larksuite.component.card.cardcontainer.c r211, String r212, Map r213, OPTrace r214, boolean r215, String r216) {
        String r100 = r210;
        if (r211 != null) goto L6;
        Log.w("MsgCardPluginUtils", "select msgId is null");
        return;
    L6:
        Lazy<UniversalCardActionManager> r112 = UniversalCardActionManager.f283171b;
        UniversalCardActionManager r101 = r112.getValue();
        HashMap r102 = new HashMap();
        HashMap r103 = new HashMap();
        String r104 = (String) r213.get("selected_option");
        if (r104 == null) goto L9;
        r103.put("select_value", r104);
    L9:
        if (r111 == null) goto L11;
        r103.put("select_text", r111);
    L11:
        r102.put("params", r103);
        if (r100 != null) goto L14;
        String r105 = "";
    L15:
        r102.put("elementID", r105);
        r102.put("eventName", "ActionStart");
        Unit r106 = Unit.INSTANCE;
        r101.getClass();
        Intrinsics.checkNotNullParameter("updateCardState", "eventName");
        Log.i("LynxCardActionManager", "send event to lynx eventName: updateCardState code:200 msg:update element state success");
        r102.put("error_code", 200);
        r102.put("error_msg", "update element state success");
        if (r110 == null) goto L18;
        r110.sendGlobalEventToJS("updateCardState", r102);
    L18:
        dz7.a.C5723a.C5724a r107 = new dz7.a.C5723a.C5724a();
        Intrinsics.checkNotNullParameter(r216, "elementTag");
        r107.f470591a = r216;
        r107.f470592b = r100;
        BizContext r108 = r211.f283235c.getBizContext();
        Intrinsics.checkNotNullParameter(r108, "bizContext");
        r107.f470593c = r108;
        dz7.a r113 = r107.a();
        String r109 = r211.f283234b.getCardID();
        ActionInfo r114 = r211.f283234b.getActionInfo();
        if (r114 == null) goto L21;
        Integer r115 = Integer.valueOf(r114.getSourceType());
    L22:
        ActionInfo r116 = r211.f283234b.getActionInfo();
        if (r116 == null) goto L25;
        String r117 = r116.getSourceId();
    L26:
        dz7.b r118 = a(r109, r213, r212, r211, r215, r214, r115, r117, "");
        HashMap r119 = new HashMap();
        if (r100 != null) goto L29;
        r100 = "";
    L29:
        r119.put("elementID", r100);
        r119.put("eventName", "ActionFinish");
        final com.larksuite.component.card.action.f r120 = new com.larksuite.component.card.action.f(r118, r113, r119, r211.f283235c.getMonitorData());
        CardActionService r121 = r211.f283235c.getDependency().getCardActionService();
        if (r121 == null) goto L33;
        final UniversalCardActionManager r122 = r112.getValue();
        r122.getClass();
        Intrinsics.checkNotNullParameter(r121, "cardActionService");
        Intrinsics.checkNotNullParameter(r120, "requestEntity");
        Log.i("LynxCardActionManager", "event rust request start: " + r120.f283198c + " contentVersion: " + r120.f283196a.f470597d + " msgId: " + r120.f283196a.f470594a);
        final long r123 = System.currentTimeMillis();
        r121.sendRequest(r120.f283197b, r120.f283196a, new UniversalCardActionManager$requestAction$1(r120, r123, r122, r110));
        return;
    L33:
        return;
    L25:
        r117 = null;
        goto L26
    L21:
        r115 = null;
        goto L22
    L14:
        r105 = r100;
        goto L15
    }
}

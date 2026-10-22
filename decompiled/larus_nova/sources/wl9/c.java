package wl9;

import com.baidu.naviapi.open.MsgBean;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class c {
    public static final String a(MsgBean r110) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        List<MsgBean.Routes> r100 = r110.getRoutes();
        if (r100 == null) goto L5;
        MsgBean.Routes r101 = (MsgBean.Routes) CollectionsKt.firstOrNull(r100);
    L6:
        if (r101 == null) goto L10;
        List<MsgBean.Routes.VisualInstructions> r102 = r101.getVisualInstructions();
        if (r102 == null) goto L10;
        MsgBean.Routes.VisualInstructions r103 = (MsgBean.Routes.VisualInstructions) CollectionsKt.firstOrNull(r102);
    L11:
        if (r101 == null) goto L15;
        List<MsgBean.Routes.VerbalInstructions> r104 = r101.getVerbalInstructions();
        if (r104 == null) goto L15;
        MsgBean.Routes.VerbalInstructions r105 = (MsgBean.Routes.VerbalInstructions) CollectionsKt.firstOrNull(r104);
    L16:
        if (r105 == null) goto L20;
        List<MsgBean.Routes.VerbalInstructions.Details> r106 = r105.getDetails();
        if (r106 == null) goto L20;
        MsgBean.Routes.VerbalInstructions.Details r107 = (MsgBean.Routes.VerbalInstructions.Details) CollectionsKt.firstOrNull(r106);
    L22:
        if (tl9.b.a() == false) goto L73;
        StringBuilder r108 = new StringBuilder("code:");
        r108.append(r110.getCode());
        r108.append(";msg:");
        r108.append(r110.getMsg());
        r108.append(";lat:");
        MsgBean.MmLocation r109 = r110.getMmLocation();
        if (r109 == null) goto L26;
        Double r111 = r109.getLat();
    L27:
        r108.append(r111);
        r108.append(";lng:");
        MsgBean.MmLocation r112 = r110.getMmLocation();
        if (r112 == null) goto L30;
        Double r113 = r112.getLng();
    L31:
        r108.append(r113);
        r108.append(";mmDirection:");
        r108.append(r110.getMmDirection());
        r108.append(";to_origin:");
        r108.append(r110.getCurrentToOrigin());
        r108.append(";sessionId:");
        r108.append(r110.getSessionId());
        r108.append(";routeId:");
        if (r101 == null) goto L34;
        String r114 = r101.getRouteId();
    L35:
        r108.append(r114);
        r108.append(";distance:");
        if (r101 == null) goto L38;
        Integer r115 = Integer.valueOf(r101.getDistance());
    L39:
        r108.append(r115);
        r108.append(";duration:");
        if (r101 == null) goto L42;
        Integer r116 = Integer.valueOf(r101.getDuration());
    L43:
        r108.append(r116);
        r108.append(";verbal[speakTxt:");
        if (r107 == null) goto L46;
        String r117 = r107.getSpeakText();
    L47:
        r108.append(r117);
        r108.append(";isSent:");
        if (r107 == null) goto L50;
        Boolean r118 = Boolean.valueOf(r107.isSent());
    L51:
        r108.append(r118);
        r108.append("];visual[distanceToOrigin:");
        if (r103 == null) goto L54;
        Integer r119 = Integer.valueOf(r103.getDistanceToOrigin());
    L55:
        r108.append(r119);
        r108.append(";distanceToCurrent:");
        if (r103 == null) goto L58;
        Integer r120 = Integer.valueOf(r103.getDistanceToCurrent());
    L59:
        r108.append(r120);
        r108.append(";turnRoadName:");
        if (r103 == null) goto L64;
        MsgBean.Routes.VisualInstructions.TurnDescription r121 = r103.getTurnDescription();
        if (r121 == null) goto L64;
        String r122 = r121.getTurnRoadName();
    L65:
        r108.append(r122);
        r108.append(";turnKind:");
        if (r103 == null) goto L70;
        MsgBean.Routes.VisualInstructions.TurnDescription r123 = r103.getTurnDescription();
        if (r123 == null) goto L70;
        Integer r124 = Integer.valueOf(r123.getTurnKind());
    L71:
        r108.append(r124);
        r108.append(']');
        return r108.toString();
    L70:
        r124 = null;
    L64:
        r122 = null;
        goto L65
    L58:
        r120 = null;
        goto L59
    L54:
        r119 = null;
        goto L55
    L50:
        r118 = null;
        goto L51
    L46:
        r117 = null;
        goto L47
    L42:
        r116 = null;
        goto L43
    L38:
        r115 = null;
        goto L39
    L34:
        r114 = null;
        goto L35
    L30:
        r113 = null;
        goto L31
    L26:
        r111 = null;
        goto L27
    L73:
        StringBuilder r125 = new StringBuilder("code:");
        r125.append(r110.getCode());
        r125.append(";msg:");
        r125.append(r110.getMsg());
        r125.append(";mmDirection:");
        r125.append(r110.getMmDirection());
        r125.append(";to_origin:");
        r125.append(r110.getCurrentToOrigin());
        r125.append(";sessionId:");
        r125.append(r110.getSessionId());
        r125.append(";routeId:");
        if (r101 == null) goto L76;
        String r126 = r101.getRouteId();
    L77:
        r125.append(r126);
        r125.append(";distance:");
        if (r101 == null) goto L80;
        Integer r127 = Integer.valueOf(r101.getDistance());
    L81:
        r125.append(r127);
        r125.append(";duration:");
        if (r101 == null) goto L84;
        Integer r128 = Integer.valueOf(r101.getDuration());
    L85:
        r125.append(r128);
        r125.append(";verbal[isSent:");
        if (r107 == null) goto L88;
        Boolean r129 = Boolean.valueOf(r107.isSent());
    L89:
        r125.append(r129);
        r125.append("];visual[distanceToOrigin:");
        if (r103 == null) goto L92;
        Integer r130 = Integer.valueOf(r103.getDistanceToOrigin());
    L93:
        r125.append(r130);
        r125.append(";distanceToCurrent:");
        if (r103 == null) goto L96;
        Integer r131 = Integer.valueOf(r103.getDistanceToCurrent());
    L97:
        r125.append(r131);
        r125.append(";turnKind:");
        if (r103 == null) goto L102;
        MsgBean.Routes.VisualInstructions.TurnDescription r132 = r103.getTurnDescription();
        if (r132 == null) goto L102;
        Integer r133 = Integer.valueOf(r132.getTurnKind());
    L103:
        r125.append(r133);
        r125.append(']');
        return r125.toString();
    L102:
        r133 = null;
        goto L103
    L96:
        r131 = null;
        goto L97
    L92:
        r130 = null;
        goto L93
    L88:
        r129 = null;
        goto L89
    L84:
        r128 = null;
        goto L85
    L80:
        r127 = null;
        goto L81
    L76:
        r126 = null;
    L20:
        r107 = null;
    L15:
        r105 = null;
    L10:
        r103 = null;
        goto L11
    L5:
        r101 = null;
        goto L6
    }
}

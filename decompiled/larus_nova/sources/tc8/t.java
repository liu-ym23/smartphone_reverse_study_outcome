package tc8;

import com.larus.bmhome.chat.bubble.floating.BubbleBannerSource;
import com.larus.reach.api.ReachButtonType;
import com.larus.reach.api.ReachPosition;
import com.larus.reach.api.ReachRequestSource;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ns9.v;
import ns9.w;

/* JADX INFO: loaded from: classes25.dex */
public final class t {
    public static final boolean a(ns9.t r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.f520408a.f520398f == ReachRequestSource.CLIENT_BRIDGE) goto L5;
    L7:
        return false;
    L5:
        if (r100.f520409b.b() != ReachPosition.BOTTOM) goto L7;
        return true;
    }

    public static final sc8.b b(ns9.t r210) {
        Intrinsics.checkNotNullParameter(r210, "<this>");
        v r100 = r210.f520409b;
        if ((r100 instanceof w) == false) goto L5;
        w r101 = (w) r100;
    L6:
        Map<String, String> r102 = r210.f520412e.f520404b;
        LinkedHashMap r103 = new LinkedHashMap();
        Iterator<Map.Entry<String, String>> r104 = r102.entrySet().iterator();
    L8:
        if (r104.hasNext() == false) goto L12;
        Map.Entry<String, String> r105 = r104.next();
        if ((!Intrinsics.areEqual(r105.getKey(), "popup_scene")) == false) goto L8;
        r103.put(r105.getKey(), r105.getValue());
        goto L8
    L12:
        String r106 = r210.f520408a.f520395c;
        if ((!StringsKt.isBlank(r106)) == false) goto L15;
        String r107 = r106;
    L16:
        String r110 = r210.f520408a.f520400h;
        if (r101 == null) goto L21;
        Map<String, String> r108 = r101.f520417b;
        if (r108 == null) goto L21;
        String r109 = r108.get("conversation_id");
    L23:
        if (r109 != null) goto L25;
        String r111 = "";
    L26:
        if (r101 == null) goto L30;
        Map<String, String> r112 = r101.f520417b;
        if (r112 == null) goto L30;
        String r113 = r112.get("query_message_id");
    L31:
        if (r113 != null) goto L33;
        String r114 = "";
    L34:
        ns9.f r115 = r210.f520411d;
        String r116 = r115.f520372b;
        if (r116 != null) goto L37;
        String r117 = "";
    L38:
        String r118 = r115.f520374d;
        String r119 = r115.f520373c;
        Iterator<T> r120 = r115.f520376f.iterator();
    L40:
        if (r120.hasNext() == false) goto L47;
        Object r121 = r120.next();
        if (((ns9.d) r121).getType() != ReachButtonType.NORMAL) goto L44;
        boolean r122 = true;
    L45:
        if (r122 == false) goto L40;
    L48:
        ns9.d r123 = (ns9.d) r121;
        if (r123 == null) goto L51;
        String r124 = r123.f520366c;
    L52:
        Long r125 = r210.f520410c.f520406b;
        if (r125 == null) goto L55;
        long r126 = ((r125.longValue() + 1000) - 1) / 1000;
    L56:
        long r127 = r126;
        int r128 = r210.f520410c.f520405a;
        BubbleBannerSource r211 = BubbleBannerSource.CMD;
        String r129 = r210.f520412e.f520403a.get("request_info");
        String r130 = r210.f520412e.f520403a.get("tracking_info");
        String r131 = r210.f520412e.f520404b.get("popup_scene");
        if ((!r103.isEmpty()) == false) goto L59;
        LinkedHashMap r132 = r103;
    L60:
        pc8.c r133 = new pc8.c(r129, r130, r131, r132);
        if ((!r103.isEmpty()) == false) goto L63;
        LinkedHashMap r212 = r103;
    L65:
        return new sc8.b(r107, r110, r111, r114, r117, r118, r119, r124, r127, r128, r211, r133, r212);
    L63:
        r212 = null;
        goto L65
    L59:
        r132 = null;
        goto L60
    L55:
        r126 = 0;
        goto L56
    L51:
        r124 = null;
        goto L52
    L44:
        r122 = false;
        goto L45
    L47:
        r121 = null;
        goto L48
    L37:
        r117 = r116;
        goto L38
    L33:
        r114 = r113;
    L30:
        r113 = null;
        goto L31
    L25:
        r111 = r109;
    L21:
        r109 = null;
        goto L23
    L15:
        r107 = null;
        goto L16
    L5:
        r101 = null;
        goto L6
    }
}

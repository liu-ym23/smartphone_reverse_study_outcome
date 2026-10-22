package com.bytedance.ies.bullet.service.base;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class x {

    public static final class a<T> implements Comparator<T> {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Integer.valueOf(((w0) r101).f247926b), Integer.valueOf(((w0) r100).f247926b));
        }
    }

    public static final class b<T> implements Comparator<T> {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Integer.valueOf(((x0) r101).f247930b), Integer.valueOf(((x0) r100).f247930b));
        }
    }

    public static final class c<T> implements Comparator<T> {
        public c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Integer.valueOf(((v0) r101).f247921b), Integer.valueOf(((v0) r100).f247921b));
        }
    }

    public static final class d<T> implements Comparator<T> {
        public d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Integer.valueOf(((b1) r101).f247785e), Integer.valueOf(((b1) r100).f247785e));
        }
    }

    public static final u0 a(JSONObject r310) {
        Intrinsics.checkNotNullParameter(r310, "<this>");
        JSONArray r100 = r310.optJSONArray("image");
        JSONArray r101 = r310.optJSONArray(LynxResourceModule.FONT_TYPE);
        JSONArray r102 = r310.optJSONArray("video");
        JSONArray r103 = r310.optJSONArray("gecko_channel");
        JSONArray r104 = r310.optJSONArray(GXTemplateKey.GAIAX_JS);
        ArrayList r105 = new ArrayList();
        ArrayList r106 = new ArrayList();
        ArrayList r107 = new ArrayList();
        ArrayList r108 = new ArrayList();
        ArrayList r110 = new ArrayList();
        String r111 = "enableMemory";
        if (r100 == null) goto L23;
        int r112 = r100.length();
        int r113 = 0;
    L5:
        if (r113 >= r112) goto L23;
        int r114 = r112;
        JSONObject r115 = JSONArrayProtectorUtils.getJSONObject(r100, r113);
        String r116 = r115.optString("url");
        if (r116 != null) goto L9;
    L12:
        boolean r117 = true;
    L13:
        if (r117 == true) goto L22;
        String r118 = r115.optString("url");
        int r109 = r115.optInt("priority", 0);
        if (r109 == 0) goto L20;
        if (r109 == 1) goto L19;
        int r119 = 3;
    L21:
        r105.add(new x0(r118, r119, r115.optBoolean("serial", false), r115.optBoolean("enableMemory", true)));
        goto L22
    L19:
        r119 = 2;
        goto L21
    L20:
        r119 = 1;
    L22:
        r113 = r113 + 1;
        r112 = r114;
        r100 = r100;
        r110 = r110;
        r104 = r104;
        r108 = r108;
        r103 = r103;
        r107 = r107;
        goto L5
    L9:
        if (r116.length() == 0) goto L12;
        r117 = false;
    L23:
        JSONArray r120 = r104;
        JSONArray r210 = r103;
        ArrayList r211 = r108;
        ArrayList r212 = r107;
        ArrayList r121 = r110;
        if (r101 == null) goto L44;
        int r122 = r101.length();
        int r123 = 0;
    L26:
        if (r123 >= r122) goto L44;
        JSONObject r124 = JSONArrayProtectorUtils.getJSONObject(r101, r123);
        String r125 = r124.optString("url");
        if (r125 != null) goto L30;
    L33:
        boolean r126 = true;
    L34:
        if (r126 == true) goto L43;
        String r213 = r124.optString("url");
        int r127 = r124.optInt("priority", 0);
        if (r127 == 0) goto L41;
        if (r127 == 1) goto L40;
        int r214 = 3;
    L42:
        r106.add(new v0(r213, r214, r124.optBoolean("serial", false), r124.optBoolean("enableMemory", true), r124.optLong("expire", 600000)));
        goto L43
    L40:
        r214 = 2;
        goto L42
    L41:
        r214 = 1;
    L43:
        r123 = r123 + 1;
        goto L26
    L30:
        if (r125.length() == 0) goto L33;
        r126 = false;
    L44:
        if (r102 == null) goto L68;
        int r128 = r102.length();
        int r129 = 0;
    L46:
        if (r129 >= r128) goto L68;
        JSONObject r130 = JSONArrayProtectorUtils.getJSONObject(r102, r129);
        String r131 = r130.optString("id");
        if (r131 != null) goto L50;
    L53:
        boolean r132 = true;
    L54:
        if (r132 == false) goto L56;
        ArrayList r133 = r212;
    L67:
        r129 = r129 + 1;
        r212 = r133;
        goto L46
    L56:
        String r215 = r130.optString("id");
        boolean r216 = r130.optBoolean("h265", true);
        String r217 = r130.optString("uri");
        JSONArray r134 = JSONObjectProtectorUtils.getJSONArray(r130, "url");
        if (r134 == null) goto L59;
        List r135 = b(r134);
    L60:
        List r218 = r135;
        int r136 = r130.optInt("priority", 0);
        if (r136 == 0) goto L65;
        if (r136 == 1) goto L64;
        int r219 = 3;
    L66:
        b1 r137 = new b1(r215, r216, r217, r218, r219, r130.optBoolean("serial", false), r130.optBoolean("enableMemory", true), r130.optLong("expire", 600000));
        r133 = r212;
        r133.add(r137);
        goto L67
    L64:
        r219 = 2;
        goto L66
    L65:
        r219 = 1;
        goto L66
    L59:
        r135 = new ArrayList();
        goto L60
    L50:
        if (r131.length() == 0) goto L53;
        r132 = false;
    L68:
        ArrayList r138 = r212;
        if (r210 == null) goto L90;
        int r139 = r210.length();
        int r140 = 0;
    L71:
        if (r140 >= r139) goto L90;
        JSONArray r141 = r210;
        JSONObject r142 = JSONArrayProtectorUtils.getJSONObject(r141, r140);
        String r143 = r142.optString("channel");
        if (r143 != null) goto L75;
    L78:
        boolean r144 = true;
    L79:
        if (r144 == true) goto L88;
        String r145 = r142.optString("channel");
        int r146 = r142.optInt("priority", 0);
        if (r146 != 0) goto L83;
        int r147 = 1;
    L87:
        w0 r148 = new w0(r145, r147);
        ArrayList r149 = r211;
        r149.add(r148);
    L89:
        r140 = r140 + 1;
        r210 = r141;
        r211 = r149;
        goto L71
    L83:
        if (r146 == 1) goto L85;
        r147 = 3;
        goto L87
    L85:
        r147 = 2;
        goto L87
    L88:
        r149 = r211;
        goto L89
    L75:
        if (r143.length() == 0) goto L78;
        r144 = false;
    L90:
        ArrayList r150 = r211;
        if (r120 == null) goto L111;
        int r151 = r120.length();
        int r152 = 0;
    L93:
        if (r152 >= r151) goto L111;
        JSONArray r153 = r120;
        JSONObject r154 = JSONArrayProtectorUtils.getJSONObject(r153, r152);
        String r155 = r154.optString("url");
        if (r155 != null) goto L97;
    L100:
        boolean r156 = true;
    L101:
        if (r156 == false) goto L103;
        ArrayList r157 = r121;
    L110:
        r152 = r152 + 1;
        r120 = r153;
        r121 = r157;
        r111 = r111;
        goto L93
    L103:
        String r220 = r154.optString("url");
        int r158 = r154.optInt("priority", 0);
        if (r158 == 0) goto L108;
        if (r158 == 1) goto L107;
        int r221 = 3;
    L109:
        y0 r159 = new y0(r220, r221, r154.optBoolean("serial", false), r154.optBoolean(r111, true), r154.optString("memoryPriority"), r154.optLong("expire", 600000));
        r157 = r121;
        r157.add(r159);
        goto L110
    L107:
        r221 = 2;
        goto L109
    L108:
        r221 = 1;
        goto L109
    L97:
        if (r155.length() == 0) goto L100;
        r156 = false;
    L111:
        ArrayList r160 = r121;
        if (r150.size() <= 1) goto L115;
        CollectionsKt.sortWith(r150, new a());
    L115:
        if (r105.size() <= 1) goto L118;
        CollectionsKt.sortWith(r105, new b());
    L118:
        if (r106.size() <= 1) goto L121;
        CollectionsKt.sortWith(r106, new c());
    L121:
        if (r138.size() <= 1) goto L124;
        CollectionsKt.sortWith(r138, new d());
    L124:
        return new u0(r150, r105, r106, r138, r160);
    }

    public static final List<String> b(JSONArray r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ArrayList r101 = new ArrayList();
        if (r100.length() <= 0) goto L12;
        int r102 = r100.length() - 1;
        if (r102 < 0) goto L12;
        int r103 = 0;
    L8:
        if ((r100.get(r103) instanceof String) == false) goto L10;
        Object r104 = r100.get(r103);
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlin.String");
        r101.add((String) r104);
    L10:
        if (r103 == r102) goto L12;
        r103 = r103 + 1;
    L12:
        return r101;
    }
}

package com.bytedance.salamander.anniex;

import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes20.dex */
public final class ABExperimentStrategy extends g5 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f267801c = 0;

    public static final class a {
    }

    static {
    }

    public ABExperimentStrategy() {
        super(4);
    }

    public static AnnieXSLAppSettingsType d(Object r100) {
        int r101 = com.bytedance.rts.foundation.v.f267594a;
        if ((r100 instanceof String) == false) goto L7;
        return AnnieXSLAppSettingsType.STRING;
    L7:
        if ((r100 instanceof Boolean) == false) goto L11;
        return AnnieXSLAppSettingsType.BOOL;
    L11:
        if ((r100 instanceof Integer) == false) goto L15;
        return AnnieXSLAppSettingsType.INT32;
    L15:
        if ((r100 instanceof Long) == false) goto L19;
        return AnnieXSLAppSettingsType.LONG;
    L19:
        if ((r100 instanceof Double) == true) goto L21;
        return null;
    L21:
        return AnnieXSLAppSettingsType.FLOAT;
    }

    public static boolean f(JSONObject r110) {
        boolean r100 = false;
        if (r110 != null) goto L5;
        return false;
    L5:
        f1 r101 = f1.f268059b;
        if (r101.f268060a != null) goto L8;
        r101.f268060a = new g1();
    L8:
        g1 r102 = r101.f268060a;
        if (r102 != null) goto L11;
        return false;
    L11:
        String r103 = com.bytedance.anniex.bd.foundation.impl.o.p(r110, "key");
        String r104 = com.bytedance.anniex.bd.foundation.impl.o.p(r110, "condition");
        int r105 = u2.f268404a;
        boolean r106 = true;
        if (Intrinsics.areEqual(r104, "exists") == false) goto L19;
        if (r102.a(r103, AnnieXSLAppSettingsType.STRING) != null) goto L17;
        r100 = true;
    L17:
        return !r100;
    L19:
        if (Intrinsics.areEqual(r104, "in") == false) goto L21;
    L131:
        String r107 = com.bytedance.anniex.bd.foundation.impl.o.p(r110, "valueType");
        switch(r107.hashCode()) {
            case -1325958191: goto L155;
            case -891985903: goto L151;
            case 3029738: goto L147;
            case 3327612: goto L143;
            case 97526364: goto L139;
            case 100359822: goto L135;
            default: goto L158;
        };
    L158:
        AnnieXSLAppSettingsType r108 = AnnieXSLAppSettingsType.STRING;
    L159:
        Object r109 = r102.a(r103, r108);
        if (r109 != null) goto L163;
        return false;
    L163:
        if (Intrinsics.areEqual(r104, "in") == false) goto L177;
        int r111 = or3.a.f524932a;
        JSONArray r112 = com.bytedance.anniex.bd.foundation.impl.o.g(r110, PickerReporterConstants.KEY.TARGET, new JSONArray());
        int r113 = 0;
    L166:
        if (r113 >= com.bytedance.anniex.bd.foundation.impl.o.h(r112)) goto L220;
        Intrinsics.checkNotNullParameter(r112, "jsonArr");
        int r114 = or3.a.f524932a;
        Intrinsics.checkNotNullParameter(r112, "jsonArr");
        Object r115 = r112.opt(r113);
        if (r115 == null) goto L176;
        if (d(r115) != r108) goto L176;
        if (e(r109, r115) == false) goto L176;
        return true;
    L176:
        r113 = r113 + 1;
        goto L166
    L220:
        return false;
    L177:
        int r116 = or3.a.f524932a;
        JSONArray r117 = com.bytedance.anniex.bd.foundation.impl.o.g(r110, PickerReporterConstants.KEY.TARGET, new JSONArray());
        int r118 = 0;
    L179:
        if (r118 >= com.bytedance.anniex.bd.foundation.impl.o.h(r117)) goto L191;
        Intrinsics.checkNotNullParameter(r117, "jsonArr");
        int r119 = or3.a.f524932a;
        Intrinsics.checkNotNullParameter(r117, "jsonArr");
        Object r120 = r117.opt(r118);
        if (r120 == null) goto L189;
        if (d(r120) != r108) goto L189;
        if (e(r109, r120) == false) goto L189;
        r106 = false;
    L189:
        r118 = r118 + 1;
        goto L179
    L191:
        return r106;
    L135:
        if (r107.equals("int32") == false) goto L158;
        r108 = AnnieXSLAppSettingsType.INT32;
        goto L159
    L139:
        if (r107.equals("float") == false) goto L158;
        r108 = AnnieXSLAppSettingsType.FLOAT;
        goto L159
    L143:
        if (r107.equals("long") == false) goto L158;
        r108 = AnnieXSLAppSettingsType.LONG;
        goto L159
    L147:
        if (r107.equals("bool") == false) goto L158;
        r108 = AnnieXSLAppSettingsType.BOOL;
        goto L159
    L151:
        if (r107.equals("string") == false) goto L158;
        r108 = AnnieXSLAppSettingsType.STRING;
        goto L159
    L155:
        if (r107.equals(ItemStyle.ITEM_STYLE_DOUBLE) == false) goto L158;
        r108 = AnnieXSLAppSettingsType.DOUBLE;
        goto L159
    L21:
        if (Intrinsics.areEqual(r104, "not_in") == true) goto L131;
        if (com.bytedance.rts.foundation.j.f(com.bytedance.rts.foundation.j.k(new String[]{"lt", LocationInfoConst.LTE, "gt", "gte"}), r104) == false) goto L51;
        Object r121 = r102.a(r103, AnnieXSLAppSettingsType.DOUBLE);
        if (r121 != null) goto L28;
        return false;
    L28:
        int r122 = com.bytedance.rts.foundation.v.f267594a;
        if ((r121 instanceof Integer) == false) goto L31;
    L34:
        double r123 = ((Double) r121).doubleValue();
        if (Intrinsics.areEqual(r104, "lt") == false) goto L39;
        return b(r123, r110, ABExperimentStrategy$singleRuleMatch$1$1.INSTANCE);
    L39:
        if (Intrinsics.areEqual(r104, LocationInfoConst.LTE) == false) goto L43;
        return b(r123, r110, ABExperimentStrategy$singleRuleMatch$1$2.INSTANCE);
    L43:
        if (Intrinsics.areEqual(r104, "gt") == false) goto L47;
        return b(r123, r110, ABExperimentStrategy$singleRuleMatch$1$3.INSTANCE);
    L47:
        if (Intrinsics.areEqual(r104, "gte") == true) goto L49;
        return false;
    L49:
        return b(r123, r110, ABExperimentStrategy$singleRuleMatch$1$4.INSTANCE);
    L31:
        if ((r121 instanceof Long) == true) goto L34;
        if ((r121 instanceof Double) == true) goto L34;
        return false;
    L51:
        if (com.bytedance.rts.foundation.j.f(com.bytedance.rts.foundation.j.k(new String[]{"startsWith", "endsWith", "contains"}), r104) == false) goto L68;
        Object r124 = r102.a(r103, AnnieXSLAppSettingsType.STRING);
        if (r124 != null) goto L56;
        return false;
    L56:
        if (Intrinsics.areEqual(r104, "startsWith") == false) goto L60;
        return c(r124, r110, ABExperimentStrategy$singleRuleMatch$2$1.INSTANCE);
    L60:
        if (Intrinsics.areEqual(r104, "endsWith") == false) goto L64;
        return c(r124, r110, ABExperimentStrategy$singleRuleMatch$2$2.INSTANCE);
    L64:
        if (Intrinsics.areEqual(r104, "contains") == true) goto L66;
        return false;
    L66:
        return c(r124, r110, ABExperimentStrategy$singleRuleMatch$2$3.INSTANCE);
    L68:
        if (com.bytedance.rts.foundation.j.f(com.bytedance.rts.foundation.j.k(new String[]{"equals", "not_equals"}), r104) == false) goto L86;
        Object r125 = com.bytedance.anniex.bd.foundation.impl.o.m(r110, PickerReporterConstants.KEY.TARGET);
        if (r125 != null) goto L72;
        return false;
    L72:
        AnnieXSLAppSettingsType r126 = d(r125);
        if (r126 != null) goto L75;
        return false;
    L75:
        Object r127 = r102.a(r103, r126);
        if (r127 != null) goto L79;
        return false;
    L79:
        if (Intrinsics.areEqual(r104, "equals") == false) goto L82;
        return e(r127, r125);
    L82:
        if (e(r127, r125) == true) goto L204;
        return true;
    L204:
        return false;
    L86:
        if (Intrinsics.areEqual(r104, "type") == true) goto L88;
        return false;
    L88:
        if (com.bytedance.anniex.bd.foundation.impl.o.m(r110, PickerReporterConstants.KEY.TARGET) != null) goto L90;
        return false;
    L90:
        String r128 = (String) com.bytedance.anniex.bd.foundation.impl.o.m(r110, PickerReporterConstants.KEY.TARGET);
        if (r128 != null) goto L94;
        return false;
    L94:
        switch(r128.hashCode()) {
            case -1034364087: goto L116;
            case -891985903: goto L111;
            case 109073: goto L105;
            case 64711720: goto L97;
            default: goto L215;
        };
    L215:
        return false;
    L97:
        if (r128.equals("boolean") == false) goto L216;
        Object r129 = r102.a(r103, AnnieXSLAppSettingsType.BOOL);
        if (r129 == null) goto L208;
        int r130 = com.bytedance.rts.foundation.v.f267594a;
        if ((r129 instanceof Boolean) == false) goto L209;
    L129:
        return true;
    L209:
        return false;
    L208:
        return false;
    L216:
        return false;
    L105:
        if (r128.equals("nil") == true) goto L108;
        return false;
    L108:
        if (r102.a(r103, AnnieXSLAppSettingsType.STRING) == null) goto L129;
        return false;
    L111:
        if (r128.equals("string") == true) goto L113;
        return false;
    L113:
        if (r102.a(r103, AnnieXSLAppSettingsType.STRING) != null) goto L129;
        return false;
    L116:
        if (r128.equals("number") == true) goto L119;
        return false;
    L119:
        if (r102.a(r103, AnnieXSLAppSettingsType.INT32) != null) goto L129;
        if (r102.a(r103, AnnieXSLAppSettingsType.LONG) != null) goto L129;
        if (r102.a(r103, AnnieXSLAppSettingsType.FLOAT) != null) goto L129;
        if (r102.a(r103, AnnieXSLAppSettingsType.DOUBLE) != null) goto L129;
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.salamander.anniex.g5
    public final boolean a(b5 r100) {
        Intrinsics.checkNotNullParameter(r100, "redirectRule");
        String r101 = com.bytedance.anniex.bd.foundation.impl.o.o(r100.f267983d, "interceptor");
        if (r101 != null) goto L5;
        return false;
    L5:
        JSONObject r102 = com.bytedance.anniex.bd.foundation.impl.o.d(r101);
        ArrayList r103 = com.bytedance.anniex.bd.foundation.impl.o.k(r102);
        if (com.bytedance.rts.foundation.j.d(r103) != 1) goto L37;
        String r104 = (String) ListProtector.get(r103, 0);
        int r105 = u2.f268404a;
        if (Intrinsics.areEqual(r104, "and") == false) goto L10;
    L11:
        Intrinsics.checkNotNullParameter(r102, "jsonObj");
        Intrinsics.checkNotNullParameter(r104, "key");
        int r106 = or3.a.f524932a;
        Intrinsics.checkNotNullParameter(r102, "jsonObj");
        Intrinsics.checkNotNullParameter(r104, "key");
        JSONArray r107 = r102.optJSONArray(r104);
        if (r107 != null) goto L14;
        return false;
    L14:
        if (com.bytedance.anniex.bd.foundation.impl.o.h(r107) == 0) goto L44;
        ArrayList r108 = com.bytedance.rts.foundation.j.k(new JSONObject[0]);
        int r109 = 0;
    L18:
        if (r109 >= com.bytedance.anniex.bd.foundation.impl.o.h(r107)) goto L20;
        Intrinsics.checkNotNullParameter(r107, "jsonArr");
        int r110 = or3.a.f524932a;
        Intrinsics.checkNotNullParameter(r107, "jsonArr");
        com.bytedance.rts.foundation.j.j(r108, r107.optJSONObject(r109));
        r109 = r109 + 1;
        goto L18
    L20:
        int r111 = u2.f268404a;
        if (Intrinsics.areEqual(r104, "and") == false) goto L35;
        Function1<JSONObject, Boolean> r112 = new ABExperimentStrategy$match$2(this);
        Intrinsics.checkNotNullParameter(r108, "<this>");
        Intrinsics.checkNotNullParameter(r112, "predicate");
        Intrinsics.checkNotNullParameter(r108, "<this>");
        Intrinsics.checkNotNullParameter(r112, "predicate");
        if ((r108 instanceof Collection) == true) goto L25;
    L27:
        Iterator r113 = r108.iterator();
    L29:
        if (r113.hasNext() == false) goto L33;
        if (((Boolean) r112.invoke(r113.next())).booleanValue() == true) goto L29;
        return false;
    L33:
        return true;
    L25:
        if (r108.isEmpty() == false) goto L27;
    L35:
        return com.bytedance.rts.foundation.j.m(r108, new ABExperimentStrategy$match$3(this));
    L44:
        return false;
    L10:
        if (Intrinsics.areEqual(r104, SRStrategy.KEY_ORIGIN_RESOLUTION) == true) goto L11;
    L37:
        return f(r102);
    }

    public static boolean e(Object r100, Object r101) {
        int r102 = com.bytedance.rts.foundation.v.f267594a;
        if ((r100 instanceof String) == true) goto L5;
    L8:
        boolean r103 = r100 instanceof Long;
        if (r103 == true) goto L11;
    L17:
        if (r103 == false) goto L26;
        if ((r101 instanceof Integer) == false) goto L26;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlin.Long");
        long r104 = ((Long) r100).longValue();
        int r105 = com.bytedance.rts.foundation.d.f267577a;
        if (r104 == ((Integer) r101).intValue()) goto L53;
        return false;
    L53:
        return true;
    L26:
        if ((r100 instanceof Integer) == false) goto L35;
        if ((r101 instanceof Integer) == false) goto L35;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlin.Int");
        if (((Integer) r100).intValue() == ((Integer) r101).intValue()) goto L54;
        return false;
    L54:
        return true;
    L35:
        if ((r100 instanceof Double) == false) goto L44;
        if ((r101 instanceof Double) == false) goto L44;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlin.Double");
        if (((Double) r100).doubleValue() == ((Double) r101).doubleValue()) goto L55;
        return false;
    L55:
        return true;
    L44:
        if ((r100 instanceof Boolean) == true) goto L46;
    L50:
        return false;
    L46:
        if ((r101 instanceof Boolean) == false) goto L50;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlin.Boolean");
        if (((Boolean) r100).booleanValue() != ((Boolean) r101).booleanValue()) goto L50;
        return true;
    L11:
        if ((r101 instanceof Long) == false) goto L17;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlin.Long");
        if (((Long) r100).longValue() == ((Long) r101).longValue()) goto L52;
        return false;
    L52:
        return true;
    L5:
        if ((r101 instanceof String) == false) goto L8;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlin.String");
        return Intrinsics.areEqual((String) r100, (String) r101);
    }

    public static boolean b(double r100, JSONObject r101, Function2 r102) {
        Object r103 = com.bytedance.anniex.bd.foundation.impl.o.m(r101, PickerReporterConstants.KEY.TARGET);
        if (r103 == null) goto L22;
        int r104 = com.bytedance.rts.foundation.v.f267594a;
        boolean r105 = r103 instanceof Integer;
        if (r105 == true) goto L12;
        if ((r103 instanceof Double) == true) goto L12;
        if ((r103 instanceof Long) == true) goto L12;
        return false;
    L12:
        if ((r103 instanceof Long) == false) goto L15;
        long r106 = ((Long) r103).longValue();
        Intrinsics.checkNotNull(Double.valueOf(r100), "null cannot be cast to non-null type kotlin.Double");
        Double r107 = Double.valueOf(r100);
        int r108 = com.bytedance.rts.foundation.e.f267578a;
        return ((Boolean) r102.invoke(r107, Double.valueOf(r106))).booleanValue();
    L15:
        if (r105 == false) goto L19;
        int r109 = ((Integer) r103).intValue();
        Intrinsics.checkNotNull(Double.valueOf(r100), "null cannot be cast to non-null type kotlin.Double");
        Double r110 = Double.valueOf(r100);
        int r111 = com.bytedance.rts.foundation.d.f267577a;
        return ((Boolean) r102.invoke(r110, Double.valueOf(r109))).booleanValue();
    L19:
        if ((r103 instanceof Double) == false) goto L24;
        double r112 = ((Double) r103).doubleValue();
        Intrinsics.checkNotNull(Double.valueOf(r100), "null cannot be cast to non-null type kotlin.Double");
        return ((Boolean) r102.invoke(Double.valueOf(r100), Double.valueOf(r112))).booleanValue();
    L24:
        return false;
    L22:
        return false;
    }

    public static boolean c(Object r100, JSONObject r101, Function2 r102) {
        Object r103 = com.bytedance.anniex.bd.foundation.impl.o.m(r101, PickerReporterConstants.KEY.TARGET);
        if (r103 == null) goto L11;
        int r104 = com.bytedance.rts.foundation.v.f267594a;
        if ((r100 instanceof String) == true) goto L7;
        return false;
    L7:
        if ((r103 instanceof String) == false) goto L14;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlin.String");
        return ((Boolean) r102.invoke((String) r100, (String) r103)).booleanValue();
    L14:
        return false;
    L11:
        return false;
    }
}

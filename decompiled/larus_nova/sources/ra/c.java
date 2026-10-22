package ra;

import android.net.Uri;
import android.view.View;
import com.bytedance.ies.bullet.lynx.init.e;
import com.bytedance.ies.bullet.lynx.init.h;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.lynx.canvas.LynxGroupKryptonConfigs;
import com.lynx.tasm.LynxGroup;
import com.lynx.tasm.ThreadStrategyForRendering;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class c {
    public static final b a(b r210, Uri r211) {
        Intrinsics.checkNotNullParameter(r210, "<this>");
        Intrinsics.checkNotNullParameter(r211, "uri");
        if (r211.isHierarchical() == false) goto L5;
        HashMap<String, String> r110 = new HashMap();
        if (r211.getBooleanQueryParameter("enable_lynx_config", false) == false) goto L14;
        Iterator<String> r100 = UriProtector.getQueryParameterNames(r211).iterator();
    L10:
        if (r100.hasNext() == false) goto L14;
        String r101 = r100.next();
        String r102 = UriProtector.getQueryParameter(r211, r101);
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r102) == false) goto L10;
        r110.put(r101, r102);
    L14:
        String r103 = UriProtector.getQueryParameter(r211, "group");
        if (r103 != null) goto L17;
        r103 = "";
    L17:
        boolean r104 = r211.getBooleanQueryParameter(LynxGroupKryptonConfigs.CONFIG_ENABLE_CANVAS, false);
        boolean r111 = r211.getBooleanQueryParameter("enable_canvas_optimize", false);
        boolean r105 = r211.getBooleanQueryParameter("enable_dynamic_v8", false);
        boolean r106 = r211.getBooleanQueryParameter("share_group", true);
        boolean r107 = r211.getBooleanQueryParameter("use_storage_group", false);
        if (r104 == false) goto L23;
        if (Intrinsics.areEqual(r103, "-1") == true) goto L23;
        r103 = r103.concat("_canvas");
    L23:
        if (r210.f536776c == null) goto L29;
        if (Intrinsics.areEqual(r210.f536777d, r103) == false) goto L29;
        LynxGroup r108 = r210.f536776c;
    L34:
        String r109 = UriProtector.getQueryParameter(r211, "lynx_preset_height");
        String r112 = UriProtector.getQueryParameter(r211, "lynx_preset_width");
        String r113 = UriProtector.getQueryParameter(r211, "lynx_preset_height_spec");
        String r114 = UriProtector.getQueryParameter(r211, "lynx_preset_width_spec");
        int r115 = r210.f536779f;
        int r116 = r210.f536778e;
        if (r112 != null) goto L38;
        if (r109 != null) goto L38;
    L45:
        if (r114 == null) goto L48;
        if (r113 == null) goto L48;
        int r117 = CastIntegerProtector.parseInt(r114);
        int r118 = CastIntegerProtector.parseInt(r113);
        int r119 = r117;
    L49:
        String r120 = UriProtector.getQueryParameter(r211, "thread_strategy");
        if (r120 == null) goto L64;
        int r121 = CastIntegerProtector.parseInt(r120);
        ThreadStrategyForRendering r122 = ThreadStrategyForRendering.ALL_ON_UI;
        if (r121 == r122.id()) goto L63;
        ThreadStrategyForRendering r123 = ThreadStrategyForRendering.MOST_ON_TASM;
        if (r121 == r123.id()) goto L62;
        r123 = ThreadStrategyForRendering.PART_ON_LAYOUT;
        if (r121 == r123.id()) goto L62;
        r123 = ThreadStrategyForRendering.MULTI_THREADS;
        if (r121 != r123.id()) goto L63;
    L62:
        ThreadStrategyForRendering r124 = r123;
    L65:
        boolean r125 = r211.getBooleanQueryParameter("enable_font_scale", false);
        String r126 = UriProtector.getQueryParameter(r211, "font_scale");
        Float r127 = null;
        if (r125 == false) goto L69;
        if (r126 != null) goto L69;
        Float r128 = h.f247355d;
    L72:
        if (r128 == null) goto L74;
        float r129 = r128.floatValue();
    L75:
        boolean r130 = r211.getBooleanQueryParameter("enable_view_zoom", false);
        String r131 = UriProtector.getQueryParameter(r211, "view_zoom");
        if (r130 == false) goto L79;
        if (r131 != null) goto L79;
        r127 = h.f247356e;
    L81:
        if (r127 == null) goto L83;
        float r132 = r127.floatValue();
    L84:
        float r133 = r132;
        String r134 = UriProtector.getQueryParameter(r211, "create_view_async");
        if (r134 == null) goto L93;
        Integer r135 = StringsKt.toIntOrNull(r134);
        if (r135 != null) goto L90;
    L92:
        boolean r136 = false;
    L94:
        String r137 = UriProtector.getQueryParameter(r211, "preset_safe_point");
        if (r137 == null) goto L103;
        Integer r138 = StringsKt.toIntOrNull(r137);
        if (r138 != null) goto L100;
    L102:
        boolean r139 = false;
    L104:
        String r140 = UriProtector.getQueryParameter(r211, "enable_code_cache");
        if (r140 == null) goto L113;
        Integer r141 = StringsKt.toIntOrNull(r140);
        if (r141 != null) goto L110;
    L112:
        boolean r142 = false;
    L114:
        String r143 = UriProtector.getQueryParameter(r211, "enable_sync_flush");
        if (r143 == null) goto L123;
        Integer r144 = StringsKt.toIntOrNull(r143);
        if (r144 != null) goto L120;
    L122:
        boolean r145 = false;
    L124:
        String r146 = UriProtector.getQueryParameter(r211, "disable_auto_expose");
        if (r146 == null) goto L133;
        Integer r147 = StringsKt.toIntOrNull(r146);
        if (r147 != null) goto L130;
    L132:
        boolean r212 = false;
    L134:
        String r148 = UriProtector.getQueryParameter(r211, "enable_pending_js_task");
        if (r148 == null) goto L143;
        Integer r149 = StringsKt.toIntOrNull(r148);
        if (r149 != null) goto L140;
    L142:
        boolean r213 = false;
    L144:
        String r150 = UriProtector.getQueryParameter(r211, "enable_vsync_aligned_message_loop");
        if (r150 == null) goto L153;
        Integer r151 = StringsKt.toIntOrNull(r150);
        if (r151 != null) goto L150;
    L152:
        boolean r214 = false;
    L154:
        String r152 = UriProtector.getQueryParameter(r211, "air_strict_mode");
        if (r152 == null) goto L163;
        Integer r153 = StringsKt.toIntOrNull(r152);
        if (r153 != null) goto L160;
    L162:
        boolean r215 = false;
    L164:
        b r154 = b.b(r210, r139, r124, r108, r103, r118, r119, r129, r136, r145, null, r212, null, null, r213, r215, r142, null, r214, r133, 2488832);
        r154.f536799z = r211;
        r154.f536798y = r110;
        return r154;
    L160:
        if (r153.intValue() != 1) goto L162;
        r215 = true;
        goto L164
    L163:
        r215 = r210.f536793t;
        goto L164
    L150:
        if (r151.intValue() != 1) goto L152;
        r214 = true;
        goto L154
    L153:
        r214 = r210.f536796w;
        goto L154
    L140:
        if (r149.intValue() != 1) goto L142;
        r213 = true;
        goto L144
    L143:
        r213 = r210.f536791r;
        goto L144
    L130:
        if (r147.intValue() != 0) goto L132;
        r212 = true;
        goto L134
    L133:
        r212 = r210.f536784k;
        goto L134
    L120:
        if (r144.intValue() != 1) goto L122;
        r145 = true;
        goto L124
    L123:
        r145 = r210.f536782i;
        goto L124
    L110:
        if (r141.intValue() != 1) goto L112;
        r142 = true;
        goto L114
    L113:
        r142 = r210.f536794u;
        goto L114
    L100:
        if (r138.intValue() != 1) goto L102;
        r139 = true;
        goto L104
    L103:
        r139 = r210.f536774a;
        goto L104
    L90:
        if (r135.intValue() != 1) goto L92;
        r136 = true;
        goto L94
    L93:
        r136 = r210.f536781h;
        goto L94
    L83:
        r132 = r210.f536797x;
    L79:
        if (r131 == null) goto L81;
        r127 = Float.valueOf(CastFloatProtector.parseFloat(r131));
        goto L81
    L74:
        r129 = r210.f536780g;
    L69:
        if (r126 == null) goto L71;
        r128 = Float.valueOf(CastFloatProtector.parseFloat(r126));
        goto L72
    L71:
        r128 = null;
    L63:
        r124 = r122;
        goto L65
    L64:
        r124 = r210.f536775b;
    L48:
        r119 = r115;
        r118 = r116;
    L38:
        if (r112 == null) goto L40;
        int r155 = View.MeasureSpec.makeMeasureSpec(CastIntegerProtector.parseInt(r112), 1073741824);
    L41:
        if (r109 == null) goto L43;
        int r156 = View.MeasureSpec.makeMeasureSpec(CastIntegerProtector.parseInt(r109), 1073741824);
    L44:
        r116 = r156;
        r115 = r155;
        goto L45
    L43:
        r156 = View.MeasureSpec.makeMeasureSpec(0, 0);
        goto L44
    L40:
        r155 = View.MeasureSpec.makeMeasureSpec(0, 0);
    L29:
        if (r107 == false) goto L31;
        b.a r157 = b.B;
        r108 = b.a.a(r103, r106, r104, new String[]{"assets://bdlynx_core.js"}, r105, r111, true);
        goto L34
    L31:
        if (r111 == false) goto L33;
        r108 = b.a.b(b.B, r103, r106, r104, new String[]{"assets://bdlynx_core.js"}, r105, r111);
        goto L34
    L33:
        b.a r158 = b.B;
        Intrinsics.checkNotNullParameter(r103, "groupName");
        r108 = e.b(r103, r106, r104, new String[]{"assets://bdlynx_core.js"}, r105, false);
        goto L34
    L5:
        return new b(false, null, null, null, 0, 0, 0.0f, false, false, null, false, 0, 0, null, false, false, false, false, null, false, 0.0f, 16777215);
    }
}

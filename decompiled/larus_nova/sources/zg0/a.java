package zg0;

import androidx.camera.video.AudioStats;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.multilink.layoutconfig.model.LayoutConfigModel;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.config.hw0;
import com.bytedance.android.livesdk.config.m20;
import com.bytedance.android.livesdk.config.z50;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import ih0.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import pn0.c;
import pn0.d;
import pn0.g;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: zg0.a$a, reason: collision with other inner class name */
    public static final class C8453a {
    }

    static {
    }

    public a() {
    }

    public static boolean c(d r100) {
        if (r100.a() == false) goto L5;
    L15:
        List<Integer> r101 = r100.f();
        if (r101 != null) goto L18;
        return false;
    L18:
        if (r101.contains(4) != true) goto L25;
        return true;
    L25:
        return false;
    L5:
        if (m20.f120727a.getValue().booleanValue() == true) goto L15;
        if (r100.g() != 21) goto L21;
        List<Integer> r102 = r100.c();
        if (r102 != null) goto L12;
        return false;
    L12:
        if (r102.contains(7) != true) goto L23;
        return true;
    L23:
        return false;
    L21:
        return false;
    }

    public final g e(d r110) {
        Intrinsics.checkNotNullParameter(r110, "request");
        int r100 = r110.g();
        int r101 = r110.b();
        Map<Integer, List<Integer>> r102 = null;
        if (r110.a() == false) goto L13;
        Object r103 = r110.f529917j;
        if ((r103 instanceof DataCenter) == true) goto L7;
        r103 = null;
    L7:
        DataCenter r104 = (DataCenter) r103;
        IInteractService r105 = (IInteractService) k.f(IInteractService.class);
        if (r105 == null) goto L13;
        b r106 = r105.dynamicService(r104);
        if (r106 == null) goto L13;
        r102 = r106.Pl();
    L13:
        if (c(r110) == false) goto L15;
        StringBuilder r107 = r110.e().f529918a;
        r107.append("\n");
        r107.append("content: call modifyUILayoutForRequestIfNeed, modifyUILayout from " + r110.g() + " to 999 for 语音团战特殊适配");
        r100 = 999;
    L42:
        return new g(r100, r101, r102);
    L15:
        boolean r108 = true;
        if (r110.g() != 28) goto L18;
        boolean r109 = true;
    L19:
        if (r109 == false) goto L22;
        StringBuilder r111 = r110.e().f529918a;
        r111.append("\n");
        r111.append("content: call modifyUILayoutForRequestIfNeed, modifyUILayout from " + r110.g() + " to 1000 for 语音avatar特殊适配");
        r100 = 1000;
        goto L42
    L22:
        if (r110.g() == 2) goto L25;
        r108 = false;
    L25:
        if (r108 == false) goto L42;
        if ((r110 instanceof c) == false) goto L29;
        int r112 = ((c) r110).f529899l;
    L30:
        switch(r112) {
            case 0: goto L38;
            case 1: goto L38;
            case 2: goto L38;
            case 3: goto L37;
            case 4: goto L36;
            case 5: goto L35;
            case 6: goto L34;
            case 7: goto L33;
            case 8: goto L32;
            default: goto L39;
        };
    L32:
        int r113 = 108;
    L40:
        StringBuilder r114 = r110.e().f529918a;
        r114.append("\n");
        r114.append("content: call modifyUILayoutForRequestIfNeed, modifyUILayout from " + r110.g() + " to " + r113 + ", windowCount = " + r112 + ", for 动态宫格特殊适配");
        r100 = r113;
        goto L42
    L33:
        r113 = 107;
        goto L40
    L34:
        r113 = 106;
        goto L40
    L35:
        r113 = 105;
        goto L40
    L36:
        r113 = 104;
        goto L40
    L37:
        r113 = 103;
        goto L40
    L38:
        r113 = 102;
        goto L40
    L39:
        r113 = 5;
        goto L40
    L29:
        r112 = 9;
        goto L30
    L18:
        r109 = false;
        goto L19
    }

    public final String a(d r100, g r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "modifiedRequestParams");
        List<Integer> r102 = r100.c();
        if (r102 == null) goto L7;
        int r103 = 7;
        if (r102.contains(7) != true) goto L7;
    L9:
        if ((r100 instanceof c) == false) goto L11;
        int r104 = ((c) r100).f529899l;
    L12:
        StringBuilder r105 = new StringBuilder();
        r105.append(r101.f529939a);
        r105.append('-');
        r105.append(r103);
        r105.append('-');
        r105.append(r104);
        r105.append('-');
        r105.append(r100.b());
        r105.append('-');
        r105.append(r100.i());
        return r105.toString();
    L11:
        r104 = 9;
    L7:
        r103 = 0;
        goto L9
    }

    public final String b(d r110, g r111) {
        Intrinsics.checkNotNullParameter(r110, "request");
        Intrinsics.checkNotNullParameter(r111, "modifiedRequestParams");
        List<Integer> r100 = r110.c();
        boolean r101 = false;
        if (r100 == null) goto L7;
        int r102 = 7;
        if (r100.contains(7) != true) goto L7;
    L9:
        if ((r110 instanceof c) == false) goto L11;
        int r103 = ((c) r110).f529899l;
    L12:
        int r104 = r110.g();
        int r105 = r111.f529939a;
        if (r105 == 0) goto L15;
        r104 = r105;
    L15:
        List<Integer> r106 = r110.f();
        Map<Integer, List<Integer>> r107 = r111.f529941c;
        if (r107 != null) goto L18;
    L21:
        boolean r108 = true;
    L22:
        if (r108 == true) goto L32;
        ArrayList r109 = new ArrayList();
        Map<Integer, List<Integer>> r112 = r111.f529941c;
        if (r112 == null) goto L26;
        List<Integer> r113 = r112.get(Integer.valueOf(r104));
    L27:
        if (r106 == null) goto L29;
        r109.addAll(r106);
    L29:
        if (r113 == null) goto L31;
        r109.addAll(r113);
    L31:
        r106 = CollectionsKt.sorted(r109);
        goto L32
    L26:
        r113 = null;
    L32:
        String r114 = "";
        if (r106 == null) goto L36;
        String r115 = CollectionsKt.joinToString$default(r106, "_", null, null, 0, null, null, 62, null);
        if (r115 == null) goto L36;
    L38:
        if (r115.length() <= 0) goto L40;
        r101 = true;
    L40:
        if (r101 == false) goto L43;
        r114 = "-".concat(r115);
    L43:
        return r111.f529939a + '-' + r102 + '-' + r103 + '-' + r110.b() + '-' + r110.i() + r114;
    L36:
        r115 = "";
        goto L38
    L18:
        if (r107.isEmpty() == true) goto L21;
        r108 = false;
        goto L22
    L11:
        r103 = 9;
    L7:
        r102 = 0;
        goto L9
    }

    public final LayoutConfigModel d(d r210, g r211, LayoutConfigModel r212, LayoutConfigModel r213) {
        Intrinsics.checkNotNullParameter(r210, "request");
        Intrinsics.checkNotNullParameter(r211, "modifiedRequestParams");
        Intrinsics.checkNotNullParameter(r212, "layoutConfigModel");
        Map<String, LayoutConfigModel.a> r100 = r212.c();
        if (r100 == null) goto L8;
        LayoutConfigModel.a r101 = r100.get("android");
        if (r101 == null) goto L8;
        r212.E(r101.b());
    L8:
        if (r210.h() == true) goto L10;
    L18:
        boolean r102 = false;
    L20:
        if (r102 == false) goto L47;
        if (r210.a() == false) goto L42;
        if (r213 == null) goto L27;
        Map<String, LayoutConfigModel.a> r103 = r213.c();
        if (r103 == null) goto L27;
        LayoutConfigModel.a r104 = r103.get("android");
    L28:
        LayoutConfigModel.g r105 = r212.p();
        if (r105 == null) goto L45;
        if (r104 == null) goto L34;
        LayoutConfigModel.g r110 = r104.b();
        if (r110 == null) goto L34;
        int r111 = r110.b();
    L35:
        r105.f(100 + r111);
        if (r104 == null) goto L40;
        LayoutConfigModel.g r106 = r104.b();
        if (r106 == null) goto L40;
        int r107 = r106.e();
    L41:
        r105.i(140 + r107);
    L40:
        r107 = 0;
    L34:
        r111 = 0;
    L45:
        r210.e().f529918a.append("\ncontent: call modifyLayoutConfigForResponseIfNeed for 主播侧固定浮窗适配，uiLayout = " + r210.g());
    L131:
        if (r210.i() == true) goto L150;
        int r108 = (int) s1.G(StatusBarUtil.getStatusBarHeight(s1.getContext()));
        LayoutConfigModel.g r109 = r212.p();
        Intrinsics.checkNotNull(r109);
        if (r109.e() <= 0) goto L136;
        LayoutConfigModel.g r112 = r212.p();
        Intrinsics.checkNotNull(r112);
        r112.i(r112.e() + r108);
        StringBuilder r113 = r210.e().f529918a;
        r113.append("\n");
        StringBuilder r114 = new StringBuilder("content: call modifyLayoutConfigForResponseIfNeed, result ui_container#top = ");
        LayoutConfigModel.g r115 = r212.p();
        Intrinsics.checkNotNull(r115);
        r114.append(r115.e());
        r114.append(", statusBarHeightDp ");
        r114.append(r108);
        r114.append(", for 状态栏特殊适配");
        r113.append(r114.toString());
    L136:
        if (r212.q() != 29) goto L150;
        List<LayoutConfigModel.e> r116 = r212.i();
        if (r116 == null) goto L142;
        LayoutConfigModel.e r117 = (LayoutConfigModel.e) CollectionsKt.getOrNull(r116, 0);
        if (r117 == null) goto L142;
        r117.l(r117.f() + ((double) r108));
    L142:
        StringBuilder r118 = r210.e().f529918a;
        r118.append("\n");
        StringBuilder r119 = new StringBuilder("content: call modifyLayoutConfigForResponseIfNeed, result region#y = ");
        List<LayoutConfigModel.e> r120 = r212.i();
        if (r120 == null) goto L147;
        LayoutConfigModel.e r121 = (LayoutConfigModel.e) ListProtector.get(r120, 0);
        if (r121 == null) goto L147;
        Double r122 = Double.valueOf(r121.f());
    L148:
        r119.append(r122);
        r119.append(", statusBarHeightDp ");
        r119.append(r108);
        r119.append(", for 电台连线场景");
        r118.append(r119.toString());
    L147:
        r122 = null;
    L150:
        if (r210.a() == true) goto L192;
        Intrinsics.checkNotNullParameter(r210, "request");
        Intrinsics.checkNotNullParameter(r211, "modifiedRequestParams");
        Object r123 = r210.f529917j;
        if ((r123 instanceof DataCenter) == true) goto L154;
        r123 = null;
    L154:
        DataCenter r124 = (DataCenter) r123;
        IInteractService r125 = (IInteractService) k.f(IInteractService.class);
        if (r125 == null) goto L163;
        Long r126 = r210.d();
        if (r126 == null) goto L159;
        long r127 = r126.longValue();
    L160:
        b r128 = r125.dynamicService(r124, r127);
        if (r128 == null) goto L163;
        Map<String, LayoutConfigModel> r129 = r128.en();
    L164:
        if (r129 != null) goto L166;
    L169:
        boolean r130 = true;
    L170:
        if (r130 == true) goto L192;
        LinkedHashMap r131 = new LinkedHashMap();
        Iterator<Map.Entry<String, LayoutConfigModel>> r132 = r129.entrySet().iterator();
    L174:
        if (r132.hasNext() == false) goto L179;
        Map.Entry<String, LayoutConfigModel> r133 = r132.next();
        if (StringsKt.split$default(r133.getKey(), new String[]{","}, false, 0, 6, null).contains(String.valueOf(r211.f529939a)) == false) goto L174;
        r131.put(r133.getKey(), r133.getValue());
        goto L174
    L179:
        if (hw0.f120409a.getValue().booleanValue() == true) goto L181;
    L182:
        r131 = new LinkedHashMap();
        Iterator<Map.Entry<String, LayoutConfigModel>> r134 = r129.entrySet().iterator();
    L184:
        if (r134.hasNext() == false) goto L189;
        Map.Entry<String, LayoutConfigModel> r135 = r134.next();
        if (StringsKt.split$default(r135.getKey(), new String[]{","}, false, 0, 6, null).contains(String.valueOf(r210.g())) == false) goto L184;
        r131.put(r135.getKey(), r135.getValue());
    L189:
        if (r131.isEmpty() == true) goto L192;
        if (r131.size() >= 2) goto L192;
    L193:
        String.valueOf(r131);
        if (r131 == null) goto L238;
        Map.Entry r136 = (Map.Entry) CollectionsKt.firstOrNull(r131.entrySet());
        if (r136 == null) goto L198;
        LayoutConfigModel r137 = (LayoutConfigModel) r136.getValue();
    L199:
        if (r137 != null) goto L201;
    L281:
        boolean r138 = false;
    L282:
        Object r139 = r210.f529917j;
        if ((r139 instanceof DataCenter) == true) goto L285;
        r139 = null;
    L285:
        DataCenter r140 = (DataCenter) r139;
        Room r141 = m.i().getCurrentRoom();
        if (r141 == null) goto L288;
        LiveMode r142 = r141.getStreamType();
    L290:
        if (r142 != LiveMode.VIDEO) goto L292;
        r138 = true;
    L292:
        if (r138 == false) goto L301;
        c0 r143 = y3.m(r140);
        if (r143 == null) goto L301;
        if (r143.n(ToolbarButton.LITTLE_GAME) != true) goto L301;
        r210.g();
        if (r210.g() == 7) goto L300;
        r212.y(1);
    L300:
        r212.s(8);
    L301:
        return r212;
    L288:
        r142 = null;
        goto L290
    L201:
        if (r137.j() == (-1)) goto L204;
        r212.y(r137.j());
    L204:
        if (r137.d() == (-1)) goto L206;
        r212.s(r137.d());
    L206:
        LayoutConfigModel.g r144 = r137.p();
        if (r144 == null) goto L209;
        LayoutConfigModel.g r145 = r212.p();
        Intrinsics.checkNotNull(r145);
        r145.g(r145.c() + r144.c());
        r145.i(r145.e() + r144.e());
        r145.h(r145.d() + r144.d());
        r145.f(r145.b() + r144.b());
    L209:
        LayoutConfigModel.b r146 = r137.e();
        if (r146 == null) goto L212;
        LayoutConfigModel.b r147 = r212.e();
        Intrinsics.checkNotNull(r147);
        r147.g(r147.d() + r146.d());
        r147.f(r147.c() + r146.c());
        r147.e(r146.b());
    L212:
        LayoutConfigModel.d r148 = r137.f();
        if (r148 == null) goto L215;
        LayoutConfigModel.d r149 = r212.f();
        Intrinsics.checkNotNull(r149);
        r149.h(r149.d() + r148.d());
        r149.i(r149.e() + r148.e());
        r149.g(r149.c() + r148.c());
        r149.f(r149.b() + r148.b());
    L215:
        List<LayoutConfigModel.e> r150 = r137.i();
        if (r150 == null) goto L236;
        Iterator<LayoutConfigModel.e> r151 = r150.iterator();
    L219:
        if (r151.hasNext() == false) goto L236;
        LayoutConfigModel.e r152 = r151.next();
        List<LayoutConfigModel.e> r153 = r212.i();
        if (r153 == null) goto L233;
        Iterator<T> r154 = r153.iterator();
    L224:
        if (r154.hasNext() == false) goto L231;
        Object r155 = r154.next();
        if (r152.c() != ((LayoutConfigModel.e) r155).c()) goto L228;
        boolean r156 = true;
    L229:
        if (r156 == false) goto L224;
    L232:
        LayoutConfigModel.e r157 = (LayoutConfigModel.e) r155;
    L234:
        if (r157 == null) goto L219;
        r157.k(r157.e() + r152.e());
        r157.l(r157.f() + r152.f());
        r157.j(r157.d() + r152.d());
        r157.h(r157.b() + r152.b());
        goto L219
    L228:
        r156 = false;
        goto L229
    L231:
        r155 = null;
        goto L232
    L233:
        r157 = null;
    L236:
        StringBuilder r158 = r210.e().f529918a;
        r158.append("\n");
        r158.append("content modifyResponseByLynxLayoutConfigOffset but lynxLayoutConfigOffset is null!");
        goto L281
    L198:
        r137 = null;
        goto L199
    L238:
        if (r210.a() == true) goto L281;
        z50 r159 = z50.f121738a;
        if (r159.getValue().a() == true) goto L242;
    L279:
        r138 = false;
        int r160 = 0;
    L280:
        Intrinsics.checkNotNullParameter(r210, "request");
        Intrinsics.checkNotNullParameter(r212, "layoutConfigModel");
        LayoutConfigModel.g r161 = r212.p();
        Intrinsics.checkNotNull(r161);
        r161.i(r161.e() + r160);
        goto L282
    L242:
        if (je0.d.D() == true) goto L279;
        Room r162 = m.i().getCurrentRoom();
        if (r162 == null) goto L249;
        z5 r163 = r162.getLinkerDetail();
        if (r163 == null) goto L249;
        String r164 = r163.getClientUiInfo();
    L251:
        if (r164 != null) goto L302;
    L258:
        boolean r165 = true;
    L259:
        if (r165 == true) goto L279;
        r210.g();     // Catch: Exception -> L256
        r210.e().f529918a.append("\ncontent: call modifyResponseByClientUiInfo for 布局跳变优化适配, modifyUILayout to " + r210.g() + ", clientUiInfo=" + r164);     // Catch: Exception -> L256
        r160 = JSONObjectProtectorUtils.getInt(JSONObjectProtectorUtils.getJSONObject(new JSONObject(r164), "ui_translation"), "vertical");     // Catch: Exception -> L256
        if (r160 != 10000) goto L304;
        r160 = 0;
    L304:
        Map<String, Integer> r166 = r159.getValue().b();     // Catch: Exception -> L275
        if (r166 == null) goto L270;
        Integer r167 = r166.get(String.valueOf(r160));     // Catch: Exception -> L275
        if (r167 == null) goto L270;
        int r168 = r167.intValue();     // Catch: Exception -> L275
    L271:
        if (r168 == 0) goto L273;
        int r169 = r168;
    L274:
        r160 = r169;
        r138 = false;
        goto L280
    L273:
        r169 = r160;
    L270:
        r168 = r160;
    L275:
        e = e;
    L278:
        r138 = false;
        StringsKt.append(r210.e().f529918a, new Object[]{"\ncontent: call modifyResponseByClientUiInfo for 布局跳变优化适配, modifyUILayout to " + r210.g() + ", parse ui_translation error!", e});
    L256:
        e = e;
        r160 = 0;
        goto L278
    L302:
        if (r164.length() == 0) goto L258;
        r165 = false;
    L249:
        r164 = null;
        goto L251
    L181:
        if (r131.isEmpty() == false) goto L189;
    L166:
        if (r129.isEmpty() == true) goto L169;
        r130 = false;
        goto L170
    L159:
        r127 = 0;
    L163:
        r129 = null;
    L192:
        r131 = null;
    L27:
        r104 = null;
        goto L28
    L42:
        LayoutConfigModel.g r170 = r212.p();
        if (r170 == null) goto L45;
        r170.f(100);
        r170.i(140);
        goto L45
    L47:
        if (r210.h() == true) goto L49;
    L57:
        boolean r171 = false;
    L58:
        if (r171 == false) goto L87;
        List<LayoutConfigModel.e> r172 = r212.i();
        if (r172 == null) goto L68;
        Iterator<T> r173 = r172.iterator();
    L63:
        if (r173.hasNext() == false) goto L68;
        LayoutConfigModel.e r174 = (LayoutConfigModel.e) r173.next();
        if (r174.c() <= 0) goto L63;
        r174.l(((double) 41) + r174.f());
    L68:
        if (r210.a() == false) goto L82;
        if (r213 == null) goto L73;
        Map<String, LayoutConfigModel.a> r175 = r213.c();
        if (r175 == null) goto L73;
        LayoutConfigModel.a r176 = r175.get("android");
    L74:
        LayoutConfigModel.g r177 = r212.p();
        if (r177 == null) goto L85;
        if (r176 == null) goto L80;
        LayoutConfigModel.g r178 = r176.b();
        if (r178 == null) goto L80;
        int r179 = r178.b();
    L81:
        r177.f(52 + r179);
    L80:
        r179 = 0;
    L85:
        r210.e().f529918a.append("\ncontent: call modifyLayoutConfigForResponseIfNeed for 主播侧动态浮窗适配，uiLayout = " + r210.g());
    L73:
        r176 = null;
        goto L74
    L82:
        LayoutConfigModel.g r180 = r212.p();
        if (r180 == null) goto L85;
        r180.f(52);
        goto L85
    L87:
        if (c(r210) == false) goto L97;
        int r181 = r210.g();
        if (r210.a() == false) goto L91;
    L94:
        r210.e().f529918a.append("\ncontent: call modifyLayoutConfigForResponseIfNeed for 语音团战跳变优化特殊适配, modifyUILayout from " + r212.q() + ", request uiLayout params: " + r210.g() + ", to 21");
        r181 = 21;
    L95:
        r212.F(r181);
        goto L131
    L91:
        if (m20.f120727a.getValue().booleanValue() == true) goto L94;
        r210.e().f529918a.append("\ncontent: call modifyLayoutConfigForResponseIfNeed for 语音团战特殊适配, modifyUILayout from " + r212.q() + " to " + r181);
        goto L95
    L97:
        if (r210.g() != 28) goto L99;
        boolean r182 = true;
    L100:
        if (r182 == false) goto L103;
        StringBuilder r183 = r210.e().f529918a;
        r183.append("\n");
        r183.append("content: call modifyUILayoutForRequestIfNeed, modifyUILayout from " + r210.g() + " to " + r212.q() + " for 语音avatar特殊适配");
        r212.F(r210.g());
        goto L131
    L103:
        if (r210.g() != 2) goto L105;
        boolean r184 = true;
    L106:
        if (r184 == false) goto L109;
        r210.e().f529918a.append("\ncontent: call modifyLayoutConfigForResponseIfNeed for 动态宫格特殊适配, modifyUILayout from " + r212.q() + " to " + r210.g());
        r212.F(r210.g());
        goto L131
    L109:
        if (r210.g() != 15) goto L111;
    L114:
        boolean r185 = true;
    L115:
        if (r185 == false) goto L126;
        List<LayoutConfigModel.e> r186 = r212.i();
        Intrinsics.checkNotNull(r186);
        List<LayoutConfigModel.e> r187 = CollectionsKt.toMutableList(r186);
        if (r187.size() != 9) goto L131;
        int r188 = r210.g();
        if (r188 == 15) goto L123;
        if (r188 == 113) goto L122;
        double r189 = AudioStats.AUDIO_AMPLITUDE_NONE;
    L124:
        LayoutConfigModel.e r190 = new LayoutConfigModel.e();
        r190.m(1);
        r190.i(9);
        r190.k(293.75d);
        r190.l(r189);
        r190.j(56.25d);
        r190.h(56.25d);
        r187.add(r190);
        r212.x(r187);
        r210.e().f529918a.append("\ncontent: call modifyLayoutConfigForResponseIfNeed for 新弹幕玩法布局特殊适配, uiLayout = " + r210.g() + ", regionListSize = " + r187.size() + ", newRegion = " + r190);
        goto L131
    L122:
        r189 = 471.5d;
        goto L124
    L123:
        r189 = 77.75d;
        goto L124
    L126:
        if (aj0.b.c(r210.g()) == false) goto L131;
        LayoutConfigModel.g r191 = r212.p();
        if (r191 == null) goto L131;
        r191.i(r191.e() + 14);
        goto L131
    L111:
        if (r210.g() == 113) goto L114;
        r185 = false;
        goto L115
    L105:
        r184 = false;
        goto L106
    L99:
        r182 = false;
        goto L100
    L49:
        if (r210.g() != 7) goto L51;
    L56:
        r171 = true;
        goto L58
    L51:
        if (r210.g() == 110) goto L56;
        if (r210.g() == 109) goto L56;
        if (r210.g() != 111) goto L57;
    L10:
        if (r210.g() != 1) goto L12;
    L17:
        r102 = true;
        goto L20
    L12:
        if (r210.g() == 6) goto L17;
        if (r210.g() == 9) goto L17;
        if (r210.g() != 112) goto L18;
        goto L17
    }

    public final LayoutConfigModel f(d r100, g r110, LayoutConfigModel r111, LayoutConfigModel r112) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r110, "modifiedRequestParams");
        Intrinsics.checkNotNullParameter(r111, "originLayoutConfigModel");
        Intrinsics.checkNotNullParameter(r112, "offsetLayoutConfigModel");
        Map<String, LayoutConfigModel.a> r101 = r112.c();
        if (r101 == null) goto L5;
        LayoutConfigModel.a r102 = r101.get("android");
    L6:
        Map<String, LayoutConfigModel.a> r103 = r111.c();
        if (r103 == null) goto L11;
        LayoutConfigModel.a r113 = r103.get("android");
        if (r113 == null) goto L11;
        LayoutConfigModel.g r114 = r113.b();
    L12:
        if (r102 == null) goto L14;
        LayoutConfigModel.g r104 = r102.b();
    L15:
        if (r114 == null) goto L18;
        if (r104 == null) goto L18;
        r114.i(r114.e() + r104.e());
        r114.g(r114.c() + r104.c());
        r114.f(r114.b() + r104.b());
        r114.h(r114.d() + r104.d());
    L18:
        LayoutConfigModel.b r105 = r112.e();
        LayoutConfigModel.b r115 = r111.e();
        if (r115 == null) goto L29;
        int r106 = r115.d();
        if (r105 == null) goto L23;
        int r107 = r105.d();
    L24:
        r115.g(r106 + r107);
        int r108 = r115.c();
        if (r105 == null) goto L27;
        int r109 = r105.c();
    L28:
        r115.f(r108 + r109);
        goto L29
    L27:
        r109 = 0;
        goto L28
    L23:
        r107 = 0;
    L29:
        LayoutConfigModel.d r116 = r112.f();
        LayoutConfigModel.d r117 = r111.f();
        if (r117 == null) goto L47;
        double r118 = r117.d();
        double r119 = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (r116 == null) goto L34;
        double r120 = r116.d();
    L35:
        r117.h(r118 + r120);
        double r121 = r117.e();
        if (r116 == null) goto L38;
        r119 = r116.e();
    L38:
        r117.i(r121 + r119);
        int r122 = r117.c();
        if (r116 == null) goto L41;
        int r123 = r116.c();
    L42:
        r117.g(r122 + r123);
        int r124 = r117.b();
        if (r116 == null) goto L45;
        int r125 = r116.b();
    L46:
        r117.f(r124 + r125);
        goto L47
    L45:
        r125 = 0;
        goto L46
    L41:
        r123 = 0;
        goto L42
    L34:
        r120 = 0.0d;
    L47:
        List<LayoutConfigModel.e> r126 = r111.i();
        if (r126 == null) goto L68;
        Iterator<T> r127 = r126.iterator();
    L51:
        if (r127.hasNext() == false) goto L68;
        LayoutConfigModel.e r128 = (LayoutConfigModel.e) r127.next();
        List<LayoutConfigModel.e> r129 = r112.i();
        if (r129 == null) goto L65;
        Iterator<T> r130 = r129.iterator();
    L56:
        if (r130.hasNext() == false) goto L63;
        Object r131 = r130.next();
        if (((LayoutConfigModel.e) r131).c() != r128.c()) goto L60;
        boolean r132 = true;
    L61:
        if (r132 == false) goto L56;
    L64:
        LayoutConfigModel.e r133 = (LayoutConfigModel.e) r131;
    L66:
        if (r133 == null) goto L51;
        r128.k(r128.e() + r133.e());
        r128.l(r128.f() + r133.f());
        r128.j(r128.d() + r133.d());
        r128.h(r128.b() + r133.b());
        goto L51
    L60:
        r132 = false;
        goto L61
    L63:
        r131 = null;
        goto L64
    L65:
        r133 = null;
    L68:
        return r111;
    L14:
        r104 = null;
    L11:
        r114 = null;
        goto L12
    L5:
        r102 = null;
        goto L6
    }
}

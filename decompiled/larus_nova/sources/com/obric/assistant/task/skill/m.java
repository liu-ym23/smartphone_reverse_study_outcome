package com.obric.assistant.task.skill;

import android.content.Context;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.actionbar.model.AgentMode;
import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.a2;
import com.larus.bmhome.actionbar.model.b2;
import com.larus.bmhome.actionbar.model.g1;
import com.larus.bmhome.actionbar.model.o1;
import com.larus.bmhome.actionbar.model.p0;
import com.larus.bmhome.actionbar.model.s0;
import com.larus.bmhome.actionbar.model.t0;
import com.larus.bmhome.actionbar.model.u0;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.instruction.core.model.ActiveSwitchType;
import com.larus.im.FlowRuntime;
import com.larus.nova.R;
import com.larus.platform.service.x1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.y0;
import com.obric.assistant.network.api.bean.ObricOmniModel;
import com.obric.assistant.network.api.bean.ObricOmniModelConfig;
import com.obric.assistant.spi.account.ObricAccountSPIServiceDelegate;
import com.obric.assistant.t1;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes33.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f393417a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f393418b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f393419c;

    public m() {
    }

    static {
        f393417a = new AtomicBoolean(false);
        f393418b = new AtomicBoolean(false);
    }

    public static String c() {
        StringBuilder r100 = new StringBuilder("res://");
        gd9.i r101 = com.larus.im.b.f346407a;
        Intrinsics.checkNotNull(r101);
        r100.append(r101.getApplication().getPackageName());
        r100.append("/2131243111");
        return y0.k(UriProtector.parse(r100.toString()));
    }

    public static String d() {
        StringBuilder r100 = new StringBuilder("res://");
        gd9.i r101 = com.larus.im.b.f346407a;
        Intrinsics.checkNotNull(r101);
        r100.append(r101.getApplication().getPackageName());
        r100.append("/2131244375");
        return y0.k(UriProtector.parse(r100.toString()));
    }

    public static boolean l() {
        int r100 = t1.f393353a.getAutoGuiEnabledScene();
        if (r100 == 1) goto L7;
        if (r100 == 2) goto L7;
    L11:
        return false;
    L7:
        if (x1.f365857a.a() == true) goto L11;
        if (ObricAccountSPIServiceDelegate.f392812b.e().a(10000) == false) goto L11;
        return true;
    }

    public static boolean m() {
        boolean r100 = f393417a.get();
        FLogger.f375446a.i("ObricTaskSkillModeHelper", "isUsingMenuConfV2: " + r100);
        return r100;
    }

    public static String b(int r100) {
        return FlowRuntime.a().getApplication().getString(r100);
    }

    public static String e(ObricOmniModeTag r100) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        ObricOmniModelConfigManager.f393397a.getClass();
        Map<String, String> r101 = ObricOmniModelConfigManager.c().getModeMap();
        if (r101 == null) goto L13;
        String r102 = r101.get(r100.getValue());
        if (r102 == null) goto L13;
        if ((!StringsKt.isBlank(r102)) == true) goto L10;
        r102 = null;
    L10:
        if (r102 == null) goto L13;
        return r102;
    L13:
        return r100.getDefaultModeId();
    }

    public static String f(ObricOmniModelTag r100) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        ObricOmniModelConfigManager.f393397a.getClass();
        Map<String, String> r101 = ObricOmniModelConfigManager.c().getModelMap();
        if (r101 == null) goto L13;
        String r102 = r101.get(r100.getValue());
        if (r102 == null) goto L13;
        if ((!StringsKt.isBlank(r102)) == true) goto L10;
        r102 = null;
    L10:
        if (r102 == null) goto L13;
        return r102;
    L13:
        return r100.getDefaultModelId();
    }

    public static boolean h(z0 r100) {
        if (r100 == null) goto L12;
        p0 r101 = r100.f295619o;
        if (r101 == null) goto L12;
        Integer r102 = r101.f295366a;
        int r103 = ActiveSwitchType.DEEPTHINK.getValue();
        if (r102 == null) goto L12;
        if (r102.intValue() != r103) goto L12;
        boolean r104 = true;
    L13:
        if (r104 == true) goto L15;
        return false;
    L15:
        if (l() == false) goto L19;
        return true;
    L19:
        return false;
    L12:
        r104 = false;
        goto L13
    }

    public static boolean j(Integer r100) {
        if (r100 != null) goto L5;
    L6:
        if (r100 != null) goto L9;
    L11:
        return false;
    L9:
        if (r100.intValue() != 100001) goto L11;
    L12:
        return true;
    L5:
        if (r100.intValue() == 10000) goto L12;
        goto L6
    }

    public static boolean k(String r100) {
        if (Intrinsics.areEqual(r100, "10000") == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r100, "100001") == true) goto L8;
        return false;
    }

    public static void g(Context r610, z0 r611) {
        Intrinsics.checkNotNullParameter(r610, PerfLog.PARAM_KEY_CONTEXT_ID);
        p0 r100 = r611.f295619o;
        if (r100 == null) goto L185;
        Integer r101 = r100.f295366a;
        int r102 = ActiveSwitchType.DEEPTHINK.getValue();
        if (r101 != null) goto L9;
        return;
    L9:
        if (r101.intValue() == r102) goto L12;
        return;
    L12:
        if (h(r611) == true) goto L15;
        return;
    L15:
        if (Intrinsics.areEqual(r100.f295376k, Boolean.TRUE) == false) goto L120;
        p0 r103 = r611.f295619o;
        if (r103 == null) goto L181;
        s0 r104 = r103.f295375j;
        if (r104 == null) goto L183;
        u0 r105 = r104.f295431a;
        if (r105 == null) goto L32;
        ArrayList<t0> r106 = r105.f295485a;
        if (r106 == null) goto L32;
        ArrayList r107 = new ArrayList();
        Iterator<T> r108 = r106.iterator();
    L27:
        if (r108.hasNext() == false) goto L31;
        Object r109 = r108.next();
        if (k(((t0) r109).f295450a) == true) goto L27;
        r107.add(r109);
        goto L27
    L31:
        ArrayList<t0> r110 = (ArrayList) CollectionsKt.toCollection(r107, new ArrayList());
    L33:
        a2 r111 = r104.f295432b;
        if (r111 == null) goto L36;
        ArrayList<b2> r112 = r111.f294974a;
    L37:
        g1 r113 = new g1(null, d(), null, null, 29);
        g1 r210 = new g1(null, c(), null, null, 29);
        ObricOmniModelConfigManager.f393397a.getClass();
        ObricOmniModelConfig r211 = ObricOmniModelConfigManager.c();
        String r114 = r610.getString(R.string.obric_action_bar_phone_operation_mode);
        String r115 = r610.getString(R.string.obric_action_bar_phone_operation_mode);
        int r116 = AgentMode.CHAT.getValue();
        vea.k r117 = r211.getDefaultModel();
        if (r117 == null) goto L40;
        String r118 = r117.a();
    L41:
        vea.k r119 = r211.getDefaultModel();
        if (r119 == null) goto L44;
        String r120 = r119.b();
    L45:
        o1 r121 = new o1(r118, r120);
        List<ObricOmniModel> r122 = a.a(r211);
        ArrayList r123 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r122, 10));
        Iterator<T> r124 = r122.iterator();
    L47:
        if (r124.hasNext() == false) goto L58;
        ObricOmniModel r125 = (ObricOmniModel) r124.next();
        vea.k r126 = r125.getModelItemIndex();
        if (r126 == null) goto L51;
        String r127 = r126.a();
    L52:
        vea.k r128 = r125.getModelItemIndex();
        if (r128 == null) goto L55;
        String r129 = r128.b();
    L56:
        r123.add(new o1(r127, r129));
        goto L47
    L55:
        r129 = null;
        goto L56
    L51:
        r127 = null;
        goto L52
    L58:
        if (Intrinsics.areEqual(r104.f295434d, Boolean.TRUE) == false) goto L90;
        a2 r130 = r104.f295432b;
        if (r130 == null) goto L90;
        if (r112 != null) goto L63;
        List r131 = CollectionsKt.emptyList();
    L64:
        ArrayList r132 = new ArrayList();
        Iterator r133 = r131.iterator();
    L66:
        if (r133.hasNext() == false) goto L89;
        b2 r134 = (b2) r133.next();
        Iterator<T> r135 = a.a(r211).iterator();
    L69:
        if (r135.hasNext() == false) goto L82;
        Object r136 = r135.next();
        ObricOmniModel r137 = (ObricOmniModel) r136;
        if (Intrinsics.areEqual(r137.isSupportedModel(), Boolean.TRUE) == false) goto L79;
        vea.k r138 = r137.getModelItemIndex();
        if (r138 == null) goto L75;
        String r139 = r138.b();
    L77:
        if (Intrinsics.areEqual(r139, r134.f295008o) == false) goto L79;
        boolean r140 = true;
    L80:
        if (r140 == false) goto L69;
    L83:
        ObricOmniModel r141 = (ObricOmniModel) r136;
        if (r141 != null) goto L86;
        b2 r142 = null;
    L87:
        if (r142 == null) goto L66;
        r132.add(r142);
        goto L66
    L86:
        r142 = b2.a(r134, r141.getDisplayModel(), r141.getDisplayModel());
        goto L87
    L75:
        r139 = null;
    L79:
        r140 = false;
        goto L80
    L82:
        r136 = null;
        goto L83
    L89:
        a2 r212 = new a2(new ArrayList(r132), r130.f294975b);
    L91:
        t0 r143 = new t0("10000", r114, r113, r210, r113, r210, Integer.valueOf(r116), r115, r121, r123, Boolean.FALSE, r212, 51648);
        if (r110 == null) goto L94;
        a(r110, CollectionsKt.listOf(r143), new l());
    L94:
        if (r105 == null) goto L96;
        r105.f295485a = r110;
    L96:
        ArrayList<b2> r144 = new ArrayList();
        if (r112 == null) goto L116;
        Iterator<T> r145 = r112.iterator();
    L100:
        if (r145.hasNext() == false) goto L116;
        b2 r146 = (b2) r145.next();
        Iterator<T> r147 = a.a(r211).iterator();
    L103:
        if (r147.hasNext() == false) goto L111;
        Object r148 = r147.next();
        vea.k r149 = ((ObricOmniModel) r148).getModelItemIndex();
        if (r149 == null) goto L107;
        String r150 = r149.b();
    L109:
        if (Intrinsics.areEqual(r150, r146.f295008o) == false) goto L103;
    L112:
        ObricOmniModel r151 = (ObricOmniModel) r148;
        if (r151 != null) goto L114;
        r144.add(r146);
        goto L100
    L114:
        r144.add(b2.a(r146, r151.getDisplayModel(), r151.getDisplayModel()));
        goto L100
    L107:
        r150 = null;
        goto L109
    L111:
        r148 = null;
    L116:
        a2 r152 = r104.f295432b;
        if (r152 == null) goto L182;
        r152.f294974a = r144;
        return;
    L182:
        return;
    L63:
        r131 = r112;
    L90:
        r212 = null;
        goto L91
    L44:
        r120 = null;
        goto L45
    L40:
        r118 = null;
        goto L41
    L36:
        r112 = null;
    L32:
        r110 = null;
        goto L33
    L183:
        return;
    L181:
        return;
    L120:
        p0 r153 = r611.f295619o;
        if (r153 == null) goto L184;
        a2 r154 = r153.d();
        if (r154 == null) goto L186;
        ArrayList<b2> r155 = r154.f294974a;
        if (r155 == null) goto L187;
        ArrayList r156 = new ArrayList();
        Iterator<T> r157 = r155.iterator();
    L130:
        if (r157.hasNext() == false) goto L138;
        Object r158 = r157.next();
        ModelItemIdentity r159 = ((b2) r158).b();
        if (r159 == null) goto L134;
        Integer r160 = Integer.valueOf(r159.getDeprecatedItemId());
    L136:
        if (j(r160) == true) goto L130;
        r156.add(r158);
        goto L130
    L134:
        r160 = null;
        goto L136
    L138:
        ArrayList<b2> r161 = (ArrayList) CollectionsKt.toCollection(r156, new ArrayList());
        b2 r162 = (b2) CollectionsKt.firstOrNull(r161);
        if (r162 == null) goto L141;
        String r163 = r162.f295000g;
    L143:
        if (o0.d(r163) == false) goto L145;
        String r510 = r610.getString(R.string.obric_action_bar_phone_operation_menu_subtitle);
    L146:
        g1 r164 = new g1(null, d(), null, null, 29);
        g1 r165 = new g1(null, c(), null, null, 29);
        int r213 = 10000;
        String r214 = r510;
        int r410 = 100001;
        a(r161, CollectionsKt.listOf(new b2[]{new b2(r213, r610.getString(R.string.obric_action_bar_phone_operation_mode), r164, r165, null, null, r214, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097072), new b2(r410, r610.getString(R.string.obric_action_bar_phone_operation_turbo_mode), r164, r165, null, null, r510, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097072)}), new i());
        r154.f294974a = r161;
        return;
    L145:
        r510 = null;
        goto L146
    L141:
        r163 = null;
        goto L143
    L187:
        return;
    L186:
        return;
    L184:
        return;
    }

    public static boolean i(String r100, String r101) {
        if (Intrinsics.areEqual(r100, e(ObricOmniModeTag.QUICK)) == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r101, f(ObricOmniModelTag.QUICK)) == true) goto L8;
        return false;
    }

    public static void a(List r100, List r101, Function1 r102) {
        Iterator r103 = r100.iterator();
        int r104 = 0;
    L4:
        if (r103.hasNext() == false) goto L9;
        if (((Boolean) r102.invoke(r103.next())).booleanValue() == true) goto L10;
        r104 = r104 + 1;
    L10:
        if (r104 < 0) goto L12;
        int r105 = r104 + 1;
    L13:
        r100.addAll(r105, r101);
        return;
    L12:
        r105 = r100.size();
        goto L13
    L9:
        r104 = -1;
        goto L10
    }
}

package com.bytedance.flow.search.kmp.impl.provider.ser;

import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.flow.search.kmp.api.model.FilterGroup;
import com.bytedance.flow.search.kmp.api.model.FilterItem;
import com.bytedance.flow.search.kmp.api.model.FlowFilterData;
import com.bytedance.flow.search.kmp.api.model.FlowQuery;
import com.bytedance.flow.search.kmp.api.model.FlowSearchData;
import com.bytedance.flow.search.kmp.api.model.SearchTabTrackInfo;
import com.bytedance.flow.search.kmp.api.model.payload.SearchFilterPayload;
import com.bytedance.flow.search.kmp.impl.provider.j;
import cw5.f;
import cw5.h;
import cw5.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import ouc.d0;
import ouc.e0;
import ouc.v;

/* JADX INFO: loaded from: classes3.dex */
public final class RemoteFilterDataSourceProvider implements vv5.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f243651b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f243652a;

    public static final class a {
    }

    static {
    }

    @Override // vv5.a
    public final void reset() {
    }

    public RemoteFilterDataSourceProvider() {
        this.f243652a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    }

    @Override // vv5.a
    public final Object a(FlowQuery r110, Continuation<? super vv5.b> r111) {
        if ((r111 instanceof RemoteFilterDataSourceProvider$search$1) == false) goto L7;
        RemoteFilterDataSourceProvider$search$1 r100 = (RemoteFilterDataSourceProvider$search$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        boolean r104 = false;
        int r105 = 2;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        ResultKt.throwOnFailure(r112);
    L46:
        if (com.bytedance.flow.search.kmp.impl.provider.ser.a.f243656a.b() == false) goto L48;
        List r113 = CollectionsKt.emptyList();
    L50:
        return new vv5.b(r113, r104, r105);
    L48:
        r113 = com.bytedance.flow.search.kmp.impl.provider.ser.a.a(com.bytedance.flow.search.kmp.impl.provider.ser.a.f243658c);
        goto L50
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        Map<String, Object> r114 = r110.f243275f;
        if (r114 == null) goto L19;
        Object r115 = r114.get("scene");
        if (r115 == null) goto L19;
        String r116 = r115.toString();
    L20:
        if (r116 != null) goto L23;
        r116 = "";
    L23:
        if (StringsKt.isBlank(r116) == false) goto L25;
        r116 = "default";
    L25:
        com.bytedance.flow.search.kmp.impl.provider.ser.a r106 = com.bytedance.flow.search.kmp.impl.provider.ser.a.f243656a;
        if (r106.b() == false) goto L29;
    L33:
        boolean r107 = false;
    L35:
        if (r107 == false) goto L42;
        BuildersKt.launch$default(this.f243652a, null, null, new RemoteFilterDataSourceProvider$search$2(this, r116, null), 3, null);
        if (r106.b() == false) goto L39;
        List r117 = CollectionsKt.emptyList();
    L41:
        return new vv5.b(r117, r104, r105);
    L39:
        r117 = com.bytedance.flow.search.kmp.impl.provider.ser.a.a(com.bytedance.flow.search.kmp.impl.provider.ser.a.f243658c);
        goto L41
    L42:
        r100.label = 1;
        if (b(r116, r100) != r102) goto L46;
        return r102;
    L29:
        if (com.bytedance.flow.search.kmp.impl.provider.ser.a.f243657b == null) goto L31;
    L34:
        r107 = true;
        goto L35
    L31:
        if ((!com.bytedance.flow.search.kmp.impl.provider.ser.a.f243658c.isEmpty()) == false) goto L33;
    L19:
        r116 = null;
    L7:
        r100 = new RemoteFilterDataSourceProvider$search$1(this, r111);
        goto L8
    }

    public final Object b(String r410, Continuation<? super Unit> r411) {
        if ((r411 instanceof RemoteFilterDataSourceProvider$refreshCache$1) == false) goto L7;
        RemoteFilterDataSourceProvider$refreshCache$1 r100 = (RemoteFilterDataSourceProvider$refreshCache$1) r411;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        int r105 = 1;
        if (r104 == 0) goto L15;
        if (r104 != 1) goto L14;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L21
    L19:
        Object r106 = Result.m9449constructorimpl((cw5.e) r102);     // Catch: Throwable -> L21
    L24:
        if (Result.m9455isFailureimpl(r106) == false) goto L26;
        r106 = null;
    L26:
        cw5.e r107 = (cw5.e) r106;
        if (r107 == null) goto L277;
        com.bytedance.flow.search.kmp.impl.provider.ser.a r108 = com.bytedance.flow.search.kmp.impl.provider.ser.a.f243656a;
        v r109 = c.f243660a;
        List<cw5.b> r110 = r107.f465585a;
        if (r110 != null) goto L31;
        r110 = CollectionsKt.emptyList();
    L31:
        Map<String, List<i>> r111 = r107.f465586b;
        if (r111 != null) goto L34;
        r111 = MapsKt.emptyMap();
    L34:
        List r112 = CollectionsKt.createListBuilder();
        Iterator r113 = r110.iterator();
    L36:
        if (r113.hasNext() == false) goto L271;
        cw5.b r114 = (cw5.b) r113.next();
        if (r114 != null) goto L40;
        cw5.e r210 = r107;
        com.bytedance.flow.search.kmp.impl.provider.ser.a r211 = r108;
        Map<String, List<i>> r212 = r111;
        List r115 = r112;
        Iterator r116 = r113;
    L270:
        r112 = r115;
        r113 = r116;
        r111 = r212;
        r108 = r211;
        r107 = r210;
        goto L36
    L40:
        String r117 = r114.f465578b;
        String r118 = "";
        if (r117 != null) goto L43;
        String r119 = "";
    L44:
        ArrayList r120 = new ArrayList();
        List<String> r121 = r114.f465580d;
        if (r121 != null) goto L47;
        r121 = CollectionsKt.emptyList();
    L47:
        Iterator<T> r122 = r121.iterator();
    L49:
        if (r122.hasNext() == false) goto L61;
        String r123 = (String) r122.next();
        if (r123 != null) goto L53;
    L56:
        boolean r124 = true;
    L57:
        if (r124 == true) goto L49;
        if (r123 != null) goto L60;
        r123 = "";
    L60:
        r120.add(r123);
        goto L49
    L53:
        if (r123.length() == 0) goto L56;
        r124 = false;
        goto L57
    L61:
        boolean r125 = r120.isEmpty();
        String r126 = "contact";
        String r127 = "bot";
        String r128 = "drive";
        String r129 = "message";
        List r130 = r120;
        if (r125 == false) goto L86;
        Integer r131 = r114.f465579c;
        if (r131 != null) goto L67;
    L69:
        if (r131 != null) goto L72;
    L74:
        if (r131 != null) goto L77;
    L79:
        if (r131 != null) goto L82;
    L84:
        Object r132 = "";
    L85:
        r130 = CollectionsKt.listOf(r132);
        goto L86
    L82:
        if (r131.intValue() != 4) goto L84;
        r132 = "contact";
        goto L85
    L77:
        if (r131.intValue() != 3) goto L79;
        r132 = "bot";
        goto L85
    L72:
        if (r131.intValue() != 2) goto L74;
        r132 = "drive";
        goto L85
    L67:
        if (r131.intValue() != r105) goto L69;
        r132 = "message";
    L86:
        ArrayList r133 = new ArrayList();
        Iterator r134 = r130.iterator();
    L88:
        if (r134.hasNext() == false) goto L92;
        Object r135 = r134.next();
        if ((!StringsKt.isBlank((String) r135)) == false) goto L88;
        r133.add(r135);
        goto L88
    L92:
        List<String> r136 = com.bytedance.flow.search.kmp.impl.util.b.a(r133);
        if (StringsKt.isBlank(r119) == false) goto L95;
    L268:
        r210 = r107;
        r211 = r108;
        r212 = r111;
        r115 = r112;
        r116 = r113;
    L269:
        r105 = 1;
        goto L270
    L95:
        if (r133.isEmpty() == true) goto L268;
        if (r136.isEmpty() == true) goto L268;
        if (r136.size() > 1) goto L108;
        Integer r137 = r114.f465579c;
        if (r137 != null) goto L105;
    L107:
        int r138 = 1;
    L109:
        Long r139 = r114.f465577a;
        if (r139 == null) goto L112;
        long r140 = r139.longValue();
    L113:
        r116 = r113;
        ArrayList r141 = new ArrayList();
        Iterator<T> r142 = r136.iterator();
    L115:
        if (r142.hasNext() == false) goto L235;
        String r213 = r118;
        String r143 = (String) r142.next();
        List<i> r144 = r111.get(r143);
        if (r144 != null) goto L119;
        r144 = CollectionsKt.emptyList();
    L119:
        Map<String, List<i>> r214 = r111;
        ArrayList r145 = new ArrayList();
        Iterator<T> r215 = r144.iterator();
        com.bytedance.flow.search.kmp.impl.provider.ser.a r216 = r108;
        int r146 = 0;
    L121:
        if (r215.hasNext() == false) goto L234;
        Object r147 = r215.next();
        int r217 = r146 + 1;
        if (r146 >= 0) goto L125;
        CollectionsKt.throwIndexOverflow();
    L125:
        i r148 = (i) r147;
        if (r148 == null) goto L128;
        String r149 = r148.f465601a;
    L129:
        if (r149 != null) goto L132;
        r149 = r213;
    L132:
        if (StringsKt.isBlank(r149) == false) goto L284;
        cw5.e r218 = r107;
        List r219 = r112;
    L158:
        ArrayList r310 = r141;
        String r311 = r129;
        cw5.b r312 = r114;
        List<String> r313 = r136;
        String r220 = r119;
        r126 = r126;
        ArrayList r150 = r145;
    L233:
        r145 = r150;
        r146 = r217;
        r107 = r218;
        r126 = r126;
        r112 = r219;
        r119 = r220;
        r127 = r127;
        r128 = r128;
        r129 = r311;
        r136 = r313;
        r114 = r312;
        r141 = r310;
        goto L121
    L284:
        Result.Companion r221 = Result.Companion;     // Catch: Throwable -> L144
        r218 = r107;
        v r151 = c.f243660a;     // Catch: Throwable -> L142
        r151.getClass();     // Catch: Throwable -> L142
        r219 = r112;
        Object r152 = Result.m9449constructorimpl((h) r151.c(h.Companion.serializer(), r149));     // Catch: Throwable -> L140
    L148:
        if (Result.m9455isFailureimpl(r152) == false) goto L150;
        r152 = null;
    L150:
        h r153 = (h) r152;
        if (r153 == null) goto L158;
        String r154 = r153.f465596b;
        if (r154 != null) goto L157;
        r154 = r213;
    L157:
        if (StringsKt.isBlank(r154) == true) goto L158;
        Long r155 = r153.f465595a;
        if (r155 == null) goto L162;
        r220 = r119;
        long r156 = r155.longValue();
    L163:
        ArrayList r157 = new ArrayList();
        List<f> r158 = r153.f465598d;
        if (r158 != null) goto L166;
        r158 = CollectionsKt.emptyList();
    L166:
        Iterator r159 = r158.iterator();
        int r160 = 0;
    L167:
        r311 = r129;
        if (r159.hasNext() == false) goto L229;
        Object r314 = r159.next();
        int r315 = r160 + 1;
        if (r160 >= 0) goto L172;
        CollectionsKt.throwIndexOverflow();
    L172:
        f r161 = (f) r314;
        if (r161 == null) goto L175;
        String r162 = r161.f465591c;
    L176:
        if (r162 != null) goto L179;
        r162 = r213;
    L179:
        if (StringsKt.isBlank(r162) == false) goto L181;
        r154 = r154;
        r145 = r145;
    L228:
        r145 = r145;
        r159 = r159;
        r129 = r311;
        r160 = r315;
        r136 = r136;
        r114 = r114;
        r141 = r141;
        r154 = r154;
        goto L167
    L181:
        StringBuilder r163 = new StringBuilder();
        r163.append(r140);
        r163.append('_');
        r163.append(r156);
        r163.append('_');
        if (r161 == null) goto L186;
        Long r164 = r161.f465589a;
        if (r164 == null) goto L186;
        long r165 = r164.longValue();
    L187:
        r163.append(r165);
        String r166 = r163.toString();
        if (r161 == null) goto L190;
        String r167 = r161.f465590b;
    L191:
        if (r167 != null) goto L193;
        r167 = r213;
    L193:
        int r168 = j.f243650a;
        Intrinsics.checkNotNullParameter(r162, "value");
        switch(r162.hashCode()) {
            case -594329379: goto L223;
            case -594329011: goto L219;
            case 99640: goto L215;
            case 109403487: goto L212;
            case 109526449: goto L208;
            case 769646324: goto L204;
            case 987015101: goto L200;
            case 1862912381: goto L197;
            default: goto L226;
        };
    L215:
        String r169 = "doc";
        if (r162.equals("doc") == false) goto L312;
    L227:
        r157.add(new FilterItem(r166, r167, r162, new SearchTabTrackInfo(r169, r146 + 2)));
        goto L228
    L312:
        r169 = r162;
        goto L227
    L226:
        r169 = r162;
        goto L227
    L197:
        if (r162.equals("create_by_me") == false) goto L307;
    L221:
        r169 = "from_user";
        goto L227
    L307:
        r169 = r162;
        goto L227
    L200:
        if (r162.equals("no_limit") == false) goto L308;
        r169 = "all";
        goto L227
    L308:
        r169 = r162;
        goto L227
    L204:
        if (r162.equals("select_archive_conv") == false) goto L309;
        r169 = "archived";
        goto L227
    L309:
        r169 = r162;
        goto L227
    L208:
        if (r162.equals("slide") == false) goto L310;
        r169 = "ppt";
        goto L227
    L310:
        r169 = r162;
        goto L227
    L212:
        if (r162.equals(DocumentType.SHEET_NAME) == false) goto L311;
        r169 = "excel";
        goto L227
    L311:
        r169 = r162;
        goto L227
    L219:
        if (r162.equals("from_me") == true) goto L221;
        r169 = r162;
        goto L227
    L223:
        if (r162.equals("from_ai") == false) goto L314;
        r169 = "from_bot";
        goto L227
    L314:
        r169 = r162;
        goto L227
    L190:
        r167 = null;
    L186:
        r165 = r160;
        goto L187
    L175:
        r162 = null;
        goto L176
    L229:
        String r316 = r154;
        r310 = r141;
        r312 = r114;
        r313 = r136;
        r150 = r145;
        String r170 = r140 + '_' + r156 + '_' + r143;
        String r171 = r153.f465597c;
        if (r171 != null) goto L232;
        r171 = r213;
    L232:
        r150.add(new FilterGroup(r170, r316, r171, r157));
        goto L233
    L162:
        String r172 = r119;
        r156 = r146;
        r220 = r172;
    L140:
        th = th;
    L146:
        Result.Companion r173 = Result.Companion;
        r152 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L142:
        th = th;
    L143:
        r219 = r112;
    L144:
        th = th;
        r218 = r107;
        goto L143
    L128:
        r149 = null;
        goto L129
    L234:
        String r222 = r127;
        ArrayList r174 = r141;
        CollectionsKt.addAll(r174, r145);
        r141 = r174;
        r118 = r213;
        r111 = r214;
        r108 = r216;
        r127 = r222;
        goto L115
    L235:
        String r223 = r127;
        r211 = r108;
        r210 = r107;
        r212 = r111;
        List r224 = r112;
        ArrayList r175 = r141;
        String r317 = r129;
        List<String> r318 = r136;
        String r225 = r119;
        String r226 = r126;
        String r319 = r128;
        Integer r176 = r114.f465581e;
        if (r176 != null) goto L239;
    L244:
        String r177 = "domain_" + r140;
        int r178 = j.f243650a;
        int r179 = r138 ^ 1;
        Intrinsics.checkNotNullParameter(r318, "domainKeys");
        if (r179 != 0) goto L316;
        String r180 = (String) CollectionsKt.firstOrNull(r318);
        if (r180 != null) goto L250;
        String r181 = "all";
    L266:
        String r182 = r181;
    L267:
        r105 = 1;
        r115 = r224;
        r115.add(new FlowFilterData(r225, r177, r318, r138, r175, new SearchTabTrackInfo(r182, 1)));
        goto L270
    L250:
        switch(r180.hashCode()) {
            case 97735: goto L263;
            case 95852938: goto L260;
            case 951526432: goto L256;
            case 954925063: goto L253;
            default: goto L317;
        };
    L256:
        r182 = r226;
        if (r180.equals(r182) == true) goto L267;
        r181 = "all";
        goto L266
    L263:
        r182 = r223;
        if (r180.equals(r182) == true) goto L267;
        r181 = "all";
        goto L266
    L317:
        r181 = "all";
        goto L266
    L253:
        if (r180.equals(r317) == false) goto L318;
        r181 = "chat";
        goto L266
    L318:
        r181 = "all";
        goto L266
    L260:
        if (r180.equals(r319) == false) goto L320;
        r181 = "space";
        goto L266
    L320:
        r181 = "all";
        goto L266
    L316:
        r181 = "all";
        goto L266
    L239:
        if (r176.intValue() != 1) goto L244;
        if (r318.size() > 1) goto L244;
        r115 = r224;
        goto L269
    L112:
        r140 = r119.hashCode();
        goto L113
    L105:
        if (r137.intValue() != 100) goto L107;
    L108:
        r138 = 0;
        goto L109
    L43:
        r119 = r117;
        goto L44
    L271:
        cw5.e r227 = r107;
        com.bytedance.flow.search.kmp.impl.provider.ser.a r228 = r108;
        List r183 = CollectionsKt.build(r112);
        if (r183.isEmpty() == false) goto L274;
        List<FlowSearchData> r184 = CollectionsKt.emptyList();
    L275:
        r228.update(r227, r184);
        goto L277
    L274:
        r184 = CollectionsKt.listOf(new FlowSearchData("intermediate_filter", 100, new SearchFilterPayload(r183)));
    L277:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r102);
        e0 r185 = new e0();
        ouc.j.c(r185, "scene", r410);
        d0 r186 = r185.a();
        Result.Companion r187 = Result.Companion;     // Catch: Throwable -> L21
        KClass r188 = Reflection.getOrCreateKotlinClass(cw5.e.class);     // Catch: Throwable -> L21
        r100.label = 1;     // Catch: Throwable -> L21
        r102 = com.bytedance.flow.search.kmp.impl.util.d.b(r188, "/alice/search/launch", r186);     // Catch: Throwable -> L21
        if (r102 != r103) goto L19;
        return r103;
    L21:
        th = move-exception;
        Result.Companion r189 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r100 = new RemoteFilterDataSourceProvider$refreshCache$1(this, r411);
        goto L8
    }
}

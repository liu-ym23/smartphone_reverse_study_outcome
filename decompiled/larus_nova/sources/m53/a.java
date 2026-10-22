package m53;

import com.bytedance.android.ec.ab.opt.HostExperimentKey;
import com.bytedance.android.ec.ab.opt.OptSetting;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.base.settings.h;
import com.bytedance.android.ec.core.abtest.e;
import com.bytedance.android.ec.core.opt.ab.m;
import com.bytedance.android.ec.core.opt.ab.n;
import com.bytedance.android.ec.hybrid.hostapi.IECHybridKevaService;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.dataplatform.config.SettingPanel;
import com.bytedance.services.apm.api.EnsureManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;
import s83.g;

/* JADX INFO: loaded from: classes12.dex */
@OptSetting(business = "评论相关ab实验")
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f512107a = 0;

    @HostExperimentKey
    public static final List<String> a() {
        int r100 = m.f45240a;
        Object r101 = CollectionsKt.emptyList();
        boolean r102 = ECServiceManager.f42805a;
        g r103 = (g) ECServiceManager.c(g.class);
        if (r103 == null) goto L8;
        s83.a r104 = r103.q();
        if (r104 == null) goto L8;
        Object r105 = r104.e("ec_comment_host_list");
        if (r105 == null) goto L8;
    L185:
        return (List) r105;
    L8:
        int r106 = n.f45241a;
        int r107 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L175
        Object r109 = null;
        Object r110 = com.bytedance.android.ec.base.settings.d.f42818c.get("ec_comment_host_list");     // Catch: Throwable -> L63
        if (r110 != null) goto L15;
    L60:
        Object r111 = null;
    L61:
        Object r112 = Result.m9449constructorimpl(r111);     // Catch: Throwable -> L63
    L65:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r112);     // Catch: Throwable -> L175
        if (r113 == null) goto L69;
        EnsureManager.ensureNotReachHere(r113);     // Catch: Throwable -> L175
    L69:
        if (Result.m9455isFailureimpl(r112) == false) goto L72;
        r112 = null;
    L72:
        if ((r112 instanceof List) == true) goto L74;
        r112 = null;
    L74:
        List r114 = (List) r112;     // Catch: Throwable -> L175
        if (r114 != null) goto L77;
    L79:
        Object r115 = com.bytedance.android.ec.base.settings.d.f42816a.get("ec_comment_host_list");     // Catch: Throwable -> L175
        if ((r115 instanceof List) == true) goto L82;
        r115 = null;
    L82:
        r114 = (List) r115;     // Catch: Throwable -> L175
    L83:
        if (r114 == null) goto L85;
        r105 = r114;
        goto L185
    L85:
        int r116 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L175
        Object r117 = com.bytedance.android.ec.base.settings.d.f42818c.get("ec_comment_host_list");     // Catch: Throwable -> L138
        if (r117 != null) goto L90;
    L135:
        Object r118 = null;
    L136:
        Object r119 = Result.m9449constructorimpl(r118);     // Catch: Throwable -> L138
    L140:
        Throwable r120 = Result.m9452exceptionOrNullimpl(r119);     // Catch: Throwable -> L166
        if (r120 == null) goto L144;
        EnsureManager.ensureNotReachHere(r120);     // Catch: Throwable -> L166
    L144:
        if (Result.m9455isFailureimpl(r119) == false) goto L147;
        r119 = null;
    L147:
        if ((r119 instanceof List) == true) goto L149;
        r119 = null;
    L149:
        List r121 = (List) r119;     // Catch: Throwable -> L166
        if (r121 != null) goto L152;
    L154:
        IHybridHostService r122 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L166
        if (r122 == null) goto L157;
        Object r123 = r122.getHostABValue("ec_comment_host_list", r101);     // Catch: Throwable -> L166
    L158:
        if (r123 != null) goto L160;
    L172:
        r105 = r101;
    L173:
        com.bytedance.android.ec.base.settings.d.d("ec_comment_host_list", r105);     // Catch: Throwable -> L175
        goto L185
    L160:
        if ((r123 instanceof List) == false) goto L163;
        r109 = r123;
    L163:
        r105 = (List) r109;     // Catch: Throwable -> L166
        if (r105 != null) goto L173;
    L166:
        th = move-exception;
        Result.Companion r124 = Result.Companion;     // Catch: Throwable -> L175
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L175
        Throwable r125 = Result.m9452exceptionOrNullimpl(r105);     // Catch: Throwable -> L175
        if (r125 == null) goto L171;
        EnsureManager.ensureNotReachHere(r125);     // Catch: Throwable -> L175
    L171:
        if (Result.m9455isFailureimpl(r105) == false) goto L173;
    L157:
        r123 = null;
        goto L158
    L152:
        if ((r121 instanceof List) == false) goto L154;
        r105 = r121;
        goto L173
    L90:
        if ((r117 instanceof List) == true) goto L92;
        Object r126 = null;
    L93:
        r118 = (List) r126;     // Catch: Throwable -> L138
        if (r118 != null) goto L136;
        if ((r117 instanceof Number) == false) goto L123;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L105;
        Float r127 = Float.valueOf(((Number) r117).floatValue());     // Catch: Throwable -> L138
        if ((r127 instanceof List) == true) goto L103;
        r127 = null;
    L103:
        r118 = (List) r127;     // Catch: Throwable -> L138
        goto L136
    L105:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L111;
        Double r128 = Double.valueOf(((Number) r117).doubleValue());     // Catch: Throwable -> L138
        if ((r128 instanceof List) == true) goto L109;
        r128 = null;
    L109:
        r118 = (List) r128;     // Catch: Throwable -> L138
        goto L136
    L111:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L117;
        Integer r129 = Integer.valueOf(((Number) r117).intValue());     // Catch: Throwable -> L138
        if ((r129 instanceof List) == true) goto L115;
        r129 = null;
    L115:
        r118 = (List) r129;     // Catch: Throwable -> L138
        goto L136
    L117:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L123;
        Long r130 = Long.valueOf(((Number) r117).longValue());     // Catch: Throwable -> L138
        if ((r130 instanceof List) == true) goto L121;
        r130 = null;
    L121:
        r118 = (List) r130;     // Catch: Throwable -> L138
    L123:
        if ((r117 instanceof JSONObject) == false) goto L125;
    L194:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L131
        Object r131 = SDKSettingsCacheManager.a().fromJson(r117.toString(), List.class);     // Catch: Throwable -> L131
        if ((r131 instanceof List) == true) goto L129;
        r131 = null;
    L129:
        Object r132 = Result.m9449constructorimpl((List) r131);     // Catch: Throwable -> L131
    L133:
        r118 = r132;
        if (Result.m9455isFailureimpl(r118) == false) goto L136;
    L131:
        th = move-exception;
        Result.Companion r133 = Result.Companion;     // Catch: Throwable -> L138
        r132 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L138
        goto L133
    L125:
        if ((r117 instanceof JSONArray) == false) goto L135;
    L92:
        r126 = r117;
    L138:
        th = move-exception;
        Result.Companion r134 = Result.Companion;     // Catch: Throwable -> L166
        r119 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
        goto L140
    L77:
        if ((r114 instanceof List) == false) goto L79;
    L15:
        if ((r110 instanceof List) == true) goto L17;
        Object r135 = null;
    L18:
        r111 = (List) r135;     // Catch: Throwable -> L63
        if (r111 != null) goto L61;
        if ((r110 instanceof Number) == false) goto L48;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L30;
        Float r136 = Float.valueOf(((Number) r110).floatValue());     // Catch: Throwable -> L63
        if ((r136 instanceof List) == true) goto L28;
        r136 = null;
    L28:
        r111 = (List) r136;     // Catch: Throwable -> L63
        goto L61
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L36;
        Double r137 = Double.valueOf(((Number) r110).doubleValue());     // Catch: Throwable -> L63
        if ((r137 instanceof List) == true) goto L34;
        r137 = null;
    L34:
        r111 = (List) r137;     // Catch: Throwable -> L63
        goto L61
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L42;
        Integer r138 = Integer.valueOf(((Number) r110).intValue());     // Catch: Throwable -> L63
        if ((r138 instanceof List) == true) goto L40;
        r138 = null;
    L40:
        r111 = (List) r138;     // Catch: Throwable -> L63
        goto L61
    L42:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L48;
        Long r139 = Long.valueOf(((Number) r110).longValue());     // Catch: Throwable -> L63
        if ((r139 instanceof List) == true) goto L46;
        r139 = null;
    L46:
        r111 = (List) r139;     // Catch: Throwable -> L63
    L48:
        if ((r110 instanceof JSONObject) == false) goto L50;
    L196:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L56
        Object r140 = SDKSettingsCacheManager.a().fromJson(r110.toString(), List.class);     // Catch: Throwable -> L56
        if ((r140 instanceof List) == true) goto L54;
        r140 = null;
    L54:
        Object r141 = Result.m9449constructorimpl((List) r140);     // Catch: Throwable -> L56
    L58:
        r111 = r141;
        if (Result.m9455isFailureimpl(r111) == false) goto L61;
    L56:
        th = move-exception;
        Result.Companion r142 = Result.Companion;     // Catch: Throwable -> L63
        r141 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L63
        goto L58
    L50:
        if ((r110 instanceof JSONArray) == false) goto L60;
    L17:
        r135 = r110;
    L63:
        th = move-exception;
        Result.Companion r143 = Result.Companion;     // Catch: Throwable -> L175
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L175
    L175:
        th = move-exception;
        Result.Companion r144 = Result.Companion;
        Object r145 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r146 = Result.m9452exceptionOrNullimpl(r145);
        if (r146 == null) goto L180;
        EnsureManager.ensureNotReachHere(r146);
    L180:
        if (Result.m9455isFailureimpl(r145) == true) goto L183;
        r101 = r145;
    L183:
        r105 = r101;
        goto L185
    }

    @SettingPanel("电商评价slice enable预加载")
    public static boolean b() {
        int r100 = com.bytedance.android.ec.base.settings.b.f42814a;
        Object r101 = Boolean.FALSE;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L172
        h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r103 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L172
        Object r104 = null;
        r103.getClass();     // Catch: Throwable -> L59
        Object r105 = SDKSettingsCacheManager.f42809b.get("ec_comment_enable_slice_preload");     // Catch: Throwable -> L59
        if (r105 != null) goto L11;
    L56:
        Object r106 = null;
    L57:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L59
    L61:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L172
        if (r108 == null) goto L65;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L172
    L65:
        if (Result.m9455isFailureimpl(r107) == false) goto L68;
        r107 = null;
    L68:
        if ((r107 instanceof Boolean) == true) goto L70;
        r107 = null;
    L70:
        Object r109 = (Boolean) r107;     // Catch: Throwable -> L172
        if (r109 != null) goto L77;
        r103.getClass();     // Catch: Throwable -> L172
        Object r110 = SDKSettingsCacheManager.f42808a.get("ec_comment_enable_slice_preload");     // Catch: Throwable -> L172
        if ((r110 instanceof Boolean) == true) goto L76;
        r110 = null;
    L76:
        r109 = (Boolean) r110;     // Catch: Throwable -> L172
    L77:
        if (r109 != null) goto L182;
        int r111 = com.bytedance.android.ec.base.settings.g.f42821a;     // Catch: Throwable -> L172
    L159:
        th = move-exception;
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L172
        Object r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L162:
        if (Result.m9452exceptionOrNullimpl(r113) != null) goto L185;
    L169:
        r109 = r113;
    L170:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L172
        SDKSettingsCacheManager.e("ec_comment_enable_slice_preload", r109);     // Catch: Throwable -> L172
        goto L182
    L185:
        r113 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_comment_enable_slice_preload", Boolean.class, r101);     // Catch: Throwable -> L166
    L167:
        if (r113 != null) goto L169;
        r109 = r101;
    L166:
        r113 = r101;
        goto L167
    L191:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L133
        Object r114 = SDKSettingsCacheManager.f42809b.get("ec_comment_enable_slice_preload");     // Catch: Throwable -> L133
        if (r114 != null) goto L85;
    L130:
        Object r115 = null;
    L131:
        Object r116 = Result.m9449constructorimpl(r115);     // Catch: Throwable -> L133
    L135:
        Throwable r117 = Result.m9452exceptionOrNullimpl(r116);     // Catch: Throwable -> L159
        if (r117 == null) goto L139;
        EnsureManager.ensureNotReachHere(r117);     // Catch: Throwable -> L159
    L139:
        if (Result.m9455isFailureimpl(r116) == false) goto L142;
        r116 = null;
    L142:
        if ((r116 instanceof Boolean) == true) goto L144;
        r116 = null;
    L144:
        r113 = (Boolean) r116;     // Catch: Throwable -> L159
        if (r113 != null) goto L169;
        jj4.b r118 = jj4.b.f499326b;     // Catch: Throwable -> L159
        Object r119 = jj4.a.a("ec_comment_enable_slice_preload", Boolean.class, r101, false);     // Catch: Throwable -> L159
        if (r119 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r119 instanceof Boolean) == false) goto L154;
        r104 = r119;
    L154:
        Object r120 = (Boolean) r104;     // Catch: Throwable -> L159
        if (r120 != null) goto L157;
        r120 = r101;
    L157:
        r113 = Result.m9449constructorimpl(r120);     // Catch: Throwable -> L159
    L85:
        if ((r114 instanceof Boolean) == true) goto L87;
        Object r121 = null;
    L88:
        r115 = (Boolean) r121;     // Catch: Throwable -> L133
        if (r115 != null) goto L131;
        if ((r114 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r122 = Float.valueOf(((Number) r114).floatValue());     // Catch: Throwable -> L133
        if ((r122 instanceof Boolean) == true) goto L98;
        r122 = null;
    L98:
        r115 = (Boolean) r122;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r123 = Double.valueOf(((Number) r114).doubleValue());     // Catch: Throwable -> L133
        if ((r123 instanceof Boolean) == true) goto L104;
        r123 = null;
    L104:
        r115 = (Boolean) r123;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r124 = Integer.valueOf(((Number) r114).intValue());     // Catch: Throwable -> L133
        if ((r124 instanceof Boolean) == true) goto L110;
        r124 = null;
    L110:
        r115 = (Boolean) r124;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r125 = Long.valueOf(((Number) r114).longValue());     // Catch: Throwable -> L133
        if ((r125 instanceof Boolean) == true) goto L116;
        r125 = null;
    L116:
        r115 = (Boolean) r125;     // Catch: Throwable -> L133
    L118:
        if ((r114 instanceof JSONObject) == false) goto L120;
    L183:
        Object r126 = SDKSettingsCacheManager.a().fromJson(r114.toString(), Boolean.class);     // Catch: Throwable -> L126
        if ((r126 instanceof Boolean) == true) goto L124;
        r126 = null;
    L124:
        Object r127 = Result.m9449constructorimpl((Boolean) r126);     // Catch: Throwable -> L126
    L128:
        r115 = r127;
        if (Result.m9455isFailureimpl(r115) == false) goto L131;
    L126:
        th = move-exception;
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L133
        r127 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L133
        goto L128
    L120:
        if ((r114 instanceof JSONArray) == false) goto L130;
    L87:
        r121 = r114;
    L133:
        th = move-exception;
        Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L159
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L159
    L182:
        return ((Boolean) r109).booleanValue();
    L11:
        if ((r105 instanceof Boolean) == true) goto L13;
        Object r130 = null;
    L14:
        r106 = (Boolean) r130;     // Catch: Throwable -> L59
        if (r106 != null) goto L57;
        if ((r105 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r131 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L59
        if ((r131 instanceof Boolean) == true) goto L24;
        r131 = null;
    L24:
        r106 = (Boolean) r131;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r132 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L59
        if ((r132 instanceof Boolean) == true) goto L30;
        r132 = null;
    L30:
        r106 = (Boolean) r132;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r133 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L59
        if ((r133 instanceof Boolean) == true) goto L36;
        r133 = null;
    L36:
        r106 = (Boolean) r133;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r134 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L59
        if ((r134 instanceof Boolean) == true) goto L42;
        r134 = null;
    L42:
        r106 = (Boolean) r134;     // Catch: Throwable -> L59
    L44:
        if ((r105 instanceof JSONObject) == false) goto L46;
    L189:
        Object r135 = SDKSettingsCacheManager.a().fromJson(r105.toString(), Boolean.class);     // Catch: Throwable -> L52
        if ((r135 instanceof Boolean) == true) goto L50;
        r135 = null;
    L50:
        Object r136 = Result.m9449constructorimpl((Boolean) r135);     // Catch: Throwable -> L52
    L54:
        r106 = r136;
        if (Result.m9455isFailureimpl(r106) == false) goto L57;
    L52:
        th = move-exception;
        Result.Companion r137 = Result.Companion;     // Catch: Throwable -> L59
        r136 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L59
        goto L54
    L46:
        if ((r105 instanceof JSONArray) == false) goto L56;
    L13:
        r130 = r105;
    L59:
        th = move-exception;
        Result.Companion r138 = Result.Companion;     // Catch: Throwable -> L172
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L172:
        th = move-exception;
        Result.Companion r139 = Result.Companion;
        Object r140 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r141 = Result.m9452exceptionOrNullimpl(r140);
        if (r141 == null) goto L177;
        EnsureManager.ensureNotReachHere(r141);
    L177:
        if (Result.m9455isFailureimpl(r140) == true) goto L180;
        r101 = r140;
    L180:
        r109 = r101;
        goto L182
    }

    @SettingPanel("错评优化-卡片形态优化")
    public static int c() {
        int r100 = com.bytedance.android.ec.base.settings.b.f42814a;
        int r101 = e.f43640a;
        Object r102 = e.a(3, 0);
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L166
        h.a();     // Catch: Throwable -> L166
        SDKSettingsCacheManager r104 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L166
        Object r105 = null;
        r104.getClass();     // Catch: Throwable -> L56
        Object r106 = SDKSettingsCacheManager.f42809b.get("comment_optimize_q1_rank");     // Catch: Throwable -> L56
        if (r106 != null) goto L11;
    L53:
        Object r107 = null;
    L54:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L56
    L58:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);     // Catch: Throwable -> L166
        if (r109 == null) goto L62;
        EnsureManager.ensureNotReachHere(r109);     // Catch: Throwable -> L166
    L62:
        if (Result.m9455isFailureimpl(r108) == false) goto L65;
        r108 = null;
    L65:
        if ((r108 instanceof Integer) == true) goto L67;
        r108 = null;
    L67:
        Object r110 = (Integer) r108;     // Catch: Throwable -> L166
        if (r110 != null) goto L74;
        r104.getClass();     // Catch: Throwable -> L166
        Object r111 = SDKSettingsCacheManager.f42808a.get("comment_optimize_q1_rank");     // Catch: Throwable -> L166
        if ((r111 instanceof Integer) == true) goto L73;
        r111 = null;
    L73:
        r110 = (Integer) r111;     // Catch: Throwable -> L166
    L74:
        if (r110 != null) goto L176;
        int r112 = com.bytedance.android.ec.base.settings.g.f42821a;     // Catch: Throwable -> L166
    L153:
        th = move-exception;
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L166
        Object r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L155:
        Object r115 = r114;
        if (Result.m9452exceptionOrNullimpl(r115) != null) goto L187;
    L163:
        r110 = r115;
    L164:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L166
        SDKSettingsCacheManager.e("comment_optimize_q1_rank", r110);     // Catch: Throwable -> L166
        goto L176
    L187:
        r115 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("comment_optimize_q1_rank", Integer.class, r102);     // Catch: Throwable -> L160
    L161:
        if (r115 != null) goto L163;
        r110 = r102;
    L160:
        r115 = r102;
        goto L161
    L179:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L127
        Object r116 = SDKSettingsCacheManager.f42809b.get("comment_optimize_q1_rank");     // Catch: Throwable -> L127
        if (r116 != null) goto L82;
    L124:
        Object r117 = null;
    L125:
        Object r118 = Result.m9449constructorimpl(r117);     // Catch: Throwable -> L127
    L129:
        Throwable r119 = Result.m9452exceptionOrNullimpl(r118);     // Catch: Throwable -> L153
        if (r119 == null) goto L133;
        EnsureManager.ensureNotReachHere(r119);     // Catch: Throwable -> L153
    L133:
        if (Result.m9455isFailureimpl(r118) == false) goto L136;
        r118 = null;
    L136:
        if ((r118 instanceof Integer) == true) goto L138;
        r118 = null;
    L138:
        r115 = (Integer) r118;     // Catch: Throwable -> L153
        if (r115 != null) goto L163;
        jj4.b r120 = jj4.b.f499326b;     // Catch: Throwable -> L153
        Object r121 = jj4.a.a("comment_optimize_q1_rank", Integer.class, r102, false);     // Catch: Throwable -> L153
        if (r121 != null) goto L145;
        Intrinsics.throwNpe();     // Catch: Throwable -> L153
    L145:
        if ((r121 instanceof Integer) == false) goto L148;
        r105 = r121;
    L148:
        Object r122 = (Integer) r105;     // Catch: Throwable -> L153
        if (r122 != null) goto L151;
        r122 = r102;
    L151:
        r114 = Result.m9449constructorimpl(r122);     // Catch: Throwable -> L153
    L82:
        if ((r116 instanceof Integer) == true) goto L84;
        Object r123 = null;
    L85:
        r117 = (Integer) r123;     // Catch: Throwable -> L127
        if (r117 != null) goto L125;
        if ((r116 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r124 = Float.valueOf(((Number) r116).floatValue());     // Catch: Throwable -> L127
        if ((r124 instanceof Integer) == true) goto L95;
        r124 = null;
    L95:
        r117 = (Integer) r124;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r125 = Double.valueOf(((Number) r116).doubleValue());     // Catch: Throwable -> L127
        if ((r125 instanceof Integer) == true) goto L101;
        r125 = null;
    L101:
        r117 = (Integer) r125;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r117 = Integer.valueOf(((Number) r116).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r126 = Long.valueOf(((Number) r116).longValue());     // Catch: Throwable -> L127
        if ((r126 instanceof Integer) == true) goto L110;
        r126 = null;
    L110:
        r117 = (Integer) r126;     // Catch: Throwable -> L127
    L112:
        if ((r116 instanceof JSONObject) == false) goto L114;
    L185:
        Object r127 = SDKSettingsCacheManager.a().fromJson(r116.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r127 instanceof Integer) == true) goto L118;
        r127 = null;
    L118:
        Object r128 = Result.m9449constructorimpl((Integer) r127);     // Catch: Throwable -> L120
    L122:
        r117 = r128;
        if (Result.m9455isFailureimpl(r117) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L127
        r128 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r116 instanceof JSONArray) == false) goto L124;
    L84:
        r123 = r116;
    L127:
        th = move-exception;
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L153
        r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L153
    L176:
        return ((Number) r110).intValue();
    L11:
        if ((r106 instanceof Integer) == true) goto L13;
        Object r131 = null;
    L14:
        r107 = (Integer) r131;     // Catch: Throwable -> L56
        if (r107 != null) goto L54;
        if ((r106 instanceof Number) == false) goto L41;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r132 = Float.valueOf(((Number) r106).floatValue());     // Catch: Throwable -> L56
        if ((r132 instanceof Integer) == true) goto L24;
        r132 = null;
    L24:
        r107 = (Integer) r132;     // Catch: Throwable -> L56
        goto L54
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r133 = Double.valueOf(((Number) r106).doubleValue());     // Catch: Throwable -> L56
        if ((r133 instanceof Integer) == true) goto L30;
        r133 = null;
    L30:
        r107 = (Integer) r133;     // Catch: Throwable -> L56
        goto L54
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L35;
        r107 = Integer.valueOf(((Number) r106).intValue());     // Catch: Throwable -> L56
        goto L54
    L35:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L41;
        Long r134 = Long.valueOf(((Number) r106).longValue());     // Catch: Throwable -> L56
        if ((r134 instanceof Integer) == true) goto L39;
        r134 = null;
    L39:
        r107 = (Integer) r134;     // Catch: Throwable -> L56
    L41:
        if ((r106 instanceof JSONObject) == false) goto L43;
    L183:
        Object r135 = SDKSettingsCacheManager.a().fromJson(r106.toString(), Integer.class);     // Catch: Throwable -> L49
        if ((r135 instanceof Integer) == true) goto L47;
        r135 = null;
    L47:
        Object r136 = Result.m9449constructorimpl((Integer) r135);     // Catch: Throwable -> L49
    L51:
        r107 = r136;
        if (Result.m9455isFailureimpl(r107) == false) goto L54;
    L49:
        th = move-exception;
        Result.Companion r137 = Result.Companion;     // Catch: Throwable -> L56
        r136 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L56
        goto L51
    L43:
        if ((r106 instanceof JSONArray) == false) goto L53;
    L13:
        r131 = r106;
    L56:
        th = move-exception;
        Result.Companion r138 = Result.Companion;     // Catch: Throwable -> L166
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r139 = Result.Companion;
        Object r140 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r141 = Result.m9452exceptionOrNullimpl(r140);
        if (r141 == null) goto L171;
        EnsureManager.ensureNotReachHere(r141);
    L171:
        if (Result.m9455isFailureimpl(r140) == true) goto L174;
        r102 = r140;
    L174:
        r110 = r102;
        goto L176
    }

    static {
    }
}

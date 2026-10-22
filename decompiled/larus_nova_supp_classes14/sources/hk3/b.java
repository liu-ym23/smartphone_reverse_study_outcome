package hk3;

import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.opt.DeviceScore;
import com.bytedance.android.ec.core.opt.ab.n;
import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.services.apm.api.EnsureManager;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public static final d h() {
        int r0 = n.a;
        Object r1 = new d(0);
        int r2 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L166
        Object r4 = null;
        Object r5 = com.bytedance.android.ec.base.settings.d.c.get("ec_tabkit_tab_config_ab");     // Catch: Throwable -> L57
        if (r5 != null) goto L9;
    L54:
        Object r6 = null;
    L55:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L57
    L59:
        Throwable r8 = Result.exceptionOrNull-impl(r7);     // Catch: Throwable -> L166
        if (r8 == null) goto L63;
        EnsureManager.ensureNotReachHere(r8);     // Catch: Throwable -> L166
    L63:
        if (Result.isFailure-impl(r7) == false) goto L66;
        r7 = null;
    L66:
        if ((r7 instanceof d) == true) goto L68;
        r7 = null;
    L68:
        Object r9 = (d) r7;     // Catch: Throwable -> L166
        if (r9 != null) goto L75;
        Object r10 = com.bytedance.android.ec.base.settings.d.a.get("ec_tabkit_tab_config_ab");     // Catch: Throwable -> L166
        if ((r10 instanceof d) == true) goto L74;
        r10 = null;
    L74:
        r9 = (d) r10;     // Catch: Throwable -> L166
    L75:
        if (r9 != null) goto L176;
        int r11 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L166
        Object r12 = com.bytedance.android.ec.base.settings.d.c.get("ec_tabkit_tab_config_ab");     // Catch: Throwable -> L130
        if (r12 != null) goto L82;
    L127:
        Object r13 = null;
    L128:
        Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L130
    L132:
        Throwable r15 = Result.exceptionOrNull-impl(r14);     // Catch: Throwable -> L147
        if (r15 == null) goto L136;
        EnsureManager.ensureNotReachHere(r15);     // Catch: Throwable -> L147
    L136:
        if (Result.isFailure-impl(r14) == false) goto L139;
        r14 = null;
    L139:
        if ((r14 instanceof d) == true) goto L141;
        r14 = null;
    L141:
        Object r16 = (d) r14;     // Catch: Throwable -> L147
        if (r16 != null) goto L164;
        IHybridHostService r17 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L147
        if (r17 == null) goto L149;
        Object r18 = r17.getHostABValue("ec_tabkit_tab_config_ab", r1);     // Catch: Throwable -> L147
    L150:
        if (r18 != null) goto L152;
    L163:
        r16 = r1;
        goto L164
    L152:
        if ((r18 instanceof d) == false) goto L155;
        r4 = r18;
    L155:
        r16 = (d) r4;     // Catch: Throwable -> L147
        if (r16 != null) goto L164;
    L149:
        r18 = null;
    L164:
        com.bytedance.android.ec.base.settings.d.d("ec_tabkit_tab_config_ab", r16);     // Catch: Throwable -> L166
        r1 = r16;
    L174:
        r9 = r1;
        goto L176
    L82:
        if ((r12 instanceof d) == true) goto L84;
        Object r19 = null;
    L85:
        r13 = (d) r19;     // Catch: Throwable -> L130
        if (r13 != null) goto L128;
        if ((r12 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(d.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r20 = Float.valueOf(((Number) r12).floatValue());     // Catch: Throwable -> L130
        if ((r20 instanceof d) == true) goto L95;
        r20 = null;
    L95:
        r13 = (d) r20;     // Catch: Throwable -> L130
        goto L128
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(d.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r21 = Double.valueOf(((Number) r12).doubleValue());     // Catch: Throwable -> L130
        if ((r21 instanceof d) == true) goto L101;
        r21 = null;
    L101:
        r13 = (d) r21;     // Catch: Throwable -> L130
        goto L128
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(d.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        Integer r22 = Integer.valueOf(((Number) r12).intValue());     // Catch: Throwable -> L130
        if ((r22 instanceof d) == true) goto L107;
        r22 = null;
    L107:
        r13 = (d) r22;     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(d.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r23 = Long.valueOf(((Number) r12).longValue());     // Catch: Throwable -> L130
        if ((r23 instanceof d) == true) goto L113;
        r23 = null;
    L113:
        r13 = (d) r23;     // Catch: Throwable -> L130
    L115:
        if ((r12 instanceof JSONObject) == false) goto L117;
    L184:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L123
        Object r24 = SDKSettingsCacheManager.a().fromJson(r12.toString(), d.class);     // Catch: Throwable -> L123
        if ((r24 instanceof d) == true) goto L121;
        r24 = null;
    L121:
        Object r25 = Result.constructor-impl((d) r24);     // Catch: Throwable -> L123
    L125:
        r13 = r25;
        if (Result.isFailure-impl(r13) == false) goto L128;
    L123:
        th = move-exception;
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L130
        r25 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        goto L125
    L117:
        if ((r12 instanceof JSONArray) == false) goto L127;
    L84:
        r19 = r12;
    L147:
        th = move-exception;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L166
        r16 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
        Throwable r28 = Result.exceptionOrNull-impl(r16);     // Catch: Throwable -> L166
        if (r28 == null) goto L162;
        EnsureManager.ensureNotReachHere(r28);     // Catch: Throwable -> L166
    L162:
        if (Result.isFailure-impl(r16) == false) goto L164;
    L130:
        th = move-exception;
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L147
        r14 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L147
    L176:
        return (d) r9;
    L9:
        if ((r5 instanceof d) == true) goto L11;
        Object r30 = null;
    L12:
        r6 = (d) r30;     // Catch: Throwable -> L57
        if (r6 != null) goto L55;
        if ((r5 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(d.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r31 = Float.valueOf(((Number) r5).floatValue());     // Catch: Throwable -> L57
        if ((r31 instanceof d) == true) goto L22;
        r31 = null;
    L22:
        r6 = (d) r31;     // Catch: Throwable -> L57
        goto L55
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(d.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r32 = Double.valueOf(((Number) r5).doubleValue());     // Catch: Throwable -> L57
        if ((r32 instanceof d) == true) goto L28;
        r32 = null;
    L28:
        r6 = (d) r32;     // Catch: Throwable -> L57
        goto L55
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(d.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        Integer r33 = Integer.valueOf(((Number) r5).intValue());     // Catch: Throwable -> L57
        if ((r33 instanceof d) == true) goto L34;
        r33 = null;
    L34:
        r6 = (d) r33;     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(d.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r34 = Long.valueOf(((Number) r5).longValue());     // Catch: Throwable -> L57
        if ((r34 instanceof d) == true) goto L40;
        r34 = null;
    L40:
        r6 = (d) r34;     // Catch: Throwable -> L57
    L42:
        if ((r5 instanceof JSONObject) == false) goto L44;
    L177:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L50
        Object r35 = SDKSettingsCacheManager.a().fromJson(r5.toString(), d.class);     // Catch: Throwable -> L50
        if ((r35 instanceof d) == true) goto L48;
        r35 = null;
    L48:
        Object r36 = Result.constructor-impl((d) r35);     // Catch: Throwable -> L50
    L52:
        r6 = r36;
        if (Result.isFailure-impl(r6) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L57
        r36 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r5 instanceof JSONArray) == false) goto L54;
    L11:
        r30 = r5;
    L57:
        th = move-exception;
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L166
        r7 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r39 = Result.Companion;
        Object r40 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r41 = Result.exceptionOrNull-impl(r40);
        if (r41 == null) goto L171;
        EnsureManager.ensureNotReachHere(r41);
    L171:
        if (Result.isFailure-impl(r40) == true) goto L174;
        r1 = r40;
        goto L174
    }

    public static final d j() {
        int r0 = p.a;
        Object r1 = new d(0);
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r4 = jj4.b.b;     // Catch: Throwable -> L7
        Object r2 = jj4.a.a("ec_tabkit_tab_config", d.class, r1, false);     // Catch: Throwable -> L7
        if (r2 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (d) r2;
    L7:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Object r6 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r6) == true) goto L12;
        r1 = r6;
    L12:
        r2 = r1;
        goto L14
    }

    static {
    }

    @JvmStatic
    public static final boolean a(String r3) {
        if (r3 == null) goto L14;
        String r4 = com.bytedance.android.shopping.store.utils.n.b(r3);
        if (r4 == null) goto L14;
        if ((!StringsKt.isBlank(r4)) == true) goto L9;
        r4 = null;
    L9:
        if (r4 == null) goto L14;
        if (g(h().f(), j().f(), r4) <= 0) goto L14;
        return true;
    L14:
        return false;
    }

    @JvmStatic
    public static final boolean b(String r9) {
        Double r0 = (Double) DeviceScore.b.getValue();
        if (r0 == null) goto L25;
        double r2 = r0.doubleValue();
        if (r9 == null) goto L26;
        String r10 = com.bytedance.android.shopping.store.utils.n.b(r9);
        if (r10 == null) goto L27;
        Integer r5 = null;
        if ((!StringsKt.isBlank(r10)) == true) goto L12;
        r10 = null;
    L12:
        if (r10 == null) goto L30;
        Integer r11 = Integer.valueOf(g(h().g(), j().g(), r10));
        if (r11.intValue() <= 0) goto L17;
        boolean r1 = true;
    L18:
        if (r1 == false) goto L20;
        r5 = r11;
    L20:
        if (r5 != null) goto L22;
        return false;
    L22:
        if (r2 > (((double) r5.intValue()) / 100.0d)) goto L29;
        return true;
    L29:
        return false;
    L17:
        r1 = false;
        goto L18
    L30:
        return false;
    L27:
        return false;
    L26:
        return false;
    L25:
        return false;
    }

    @JvmStatic
    public static final boolean c(String r3) {
        if (r3 == null) goto L14;
        String r4 = com.bytedance.android.shopping.store.utils.n.b(r3);
        if (r4 == null) goto L14;
        if ((!StringsKt.isBlank(r4)) == true) goto L9;
        r4 = null;
    L9:
        if (r4 == null) goto L14;
        if (g(h().j(), j().j(), r4) <= 0) goto L14;
        return true;
    L14:
        return false;
    }

    @JvmStatic
    public static final boolean d(String r3) {
        if (r3 == null) goto L14;
        String r4 = com.bytedance.android.shopping.store.utils.n.b(r3);
        if (r4 == null) goto L14;
        if ((!StringsKt.isBlank(r4)) == true) goto L9;
        r4 = null;
    L9:
        if (r4 == null) goto L14;
        if (g(h().k(), j().k(), r4) <= 0) goto L14;
        return true;
    L14:
        return false;
    }

    @JvmStatic
    public static final boolean e(String r3) {
        if (r3 == null) goto L14;
        String r4 = com.bytedance.android.shopping.store.utils.n.b(r3);
        if (r4 == null) goto L14;
        if ((!StringsKt.isBlank(r4)) == true) goto L9;
        r4 = null;
    L9:
        if (r4 == null) goto L14;
        if (g(h().h(), j().h(), r4) <= 0) goto L14;
        return true;
    L14:
        return false;
    }

    @JvmStatic
    public static final int f(String r2) {
        if (r2 == null) goto L13;
        String r3 = com.bytedance.android.shopping.store.utils.n.b(r2);
        if (r3 != null) goto L6;
        return 0;
    L6:
        if ((!StringsKt.isBlank(r3)) == true) goto L9;
        r3 = null;
    L9:
        if (r3 != null) goto L12;
        return 0;
    L12:
        return g(h().m(), j().m(), r3);
    L13:
        return 0;
    }

    @JvmStatic
    public static final String i(String r4) {
        if (r4 == null) goto L22;
        String r5 = com.bytedance.android.shopping.store.utils.n.b(r4);
        if (r5 == null) goto L23;
        boolean r2 = true;
        if ((!StringsKt.isBlank(r5)) == true) goto L10;
        r5 = null;
    L10:
        if (r5 == null) goto L25;
        Integer r6 = Integer.valueOf(g(h().l(), j().l(), r5));
        if (r6.intValue() > 0) goto L16;
        r2 = false;
    L16:
        if (r2 == true) goto L19;
        r6 = null;
    L19:
        if (r6 != null) goto L21;
        return null;
    L21:
        return String.valueOf(((double) r6.intValue()) / 100.0d);
    L25:
        return null;
    L23:
        return null;
    L22:
        return null;
    }

    public static int g(c r6, c r7, String r8) {
        if (StringsKt.isBlank(r8) == false) goto L5;
        boolean r0 = true;
    L6:
        Integer r2 = null;
        if (r0 == false) goto L19;
        if (r6 == null) goto L13;
        Integer r9 = r6.b();
        if (r9 == null) goto L13;
        r2 = r9;
    L15:
        if (r2 != null) goto L17;
        return 0;
    L17:
        return r2.intValue();
    L13:
        if (r7 == null) goto L15;
        r2 = r7.b();
        goto L15
    L19:
        if (r6 == null) goto L31;
        JsonObject r3 = r6.a();
        if (r3 == null) goto L31;
        Set r4 = r3.entrySet();
        if (r4 == null) goto L31;
        Iterator r5 = r4.iterator();
    L26:
        if (r5.hasNext() == false) goto L31;
        Map.Entry r10 = (Map.Entry) r5.next();
        if (StringsKt.contains$default(r8, (CharSequence) r10.getKey(), false, 2, null) == false) goto L26;
        return ((JsonElement) r10.getValue()).getAsInt();
    L31:
        if (r6 == null) goto L36;
        Integer r11 = r6.b();
        if (r11 == null) goto L36;
        return r11.intValue();
    L36:
        if (r7 == null) goto L48;
        JsonObject r12 = r7.a();
        if (r12 == null) goto L48;
        Set r13 = r12.entrySet();
        if (r13 == null) goto L48;
        Iterator r14 = r13.iterator();
    L43:
        if (r14.hasNext() == false) goto L48;
        Map.Entry r15 = (Map.Entry) r14.next();
        if (StringsKt.contains$default(r8, (CharSequence) r15.getKey(), false, 2, null) == false) goto L43;
        return ((JsonElement) r15.getValue()).getAsInt();
    L48:
        if (r7 == null) goto L53;
        Integer r16 = r7.b();
        if (r16 == null) goto L53;
        return r16.intValue();
    L53:
        return 0;
    L5:
        r0 = false;
        goto L6
    }
}

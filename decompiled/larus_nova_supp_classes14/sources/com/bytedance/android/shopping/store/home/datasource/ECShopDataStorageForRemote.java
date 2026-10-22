package com.bytedance.android.shopping.store.home.datasource;

import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.base.settings.a;
import com.bytedance.android.ec.base.settings.c;
import com.bytedance.android.ec.base.settings.d;
import com.bytedance.android.ec.core.opt.ab.n;
import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.list.util.k;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.store.repository.vo.ShopRemoteStruct;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.bytedance.keva.Keva;
import com.bytedance.services.apm.api.EnsureManager;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import jj4.b;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECShopDataStorageForRemote {
    public static final Keva a = null;
    public static final ECShopDataStorageForRemote b = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/store/home/datasource/ECShopDataStorageForRemote$TYPE;", "", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface TYPE {
    }

    public ECShopDataStorageForRemote() {
    }

    static {
        b = new ECShopDataStorageForRemote();
        a = Keva.getRepo(a("-1", "-1"), 1);
    }

    public final synchronized void d(ShopRemoteStruct r7) {
        monitor-enter(this);
        if (r7 != null) goto L12;
        monitor-exit(this);
        return;
    L12:
        c(r7.getActionType(), r7.getSecShopId(), r7.getUserId(), r7.getBusinessId(), r7.getData());     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public static String a(String r2, String r3) {
        return "ec_shop_storage_for_remote_" + r3 + '_' + r2;
    }

    public static String b(String r9, String r10) {
        if (ECAppInfoService.e.isLocalTest() == false) goto L360;
        ConcurrentHashMap<String, Object> r0 = ECShopABSettings.a;
        Object r2 = 0;
        Object r6 = null;
        if (Intrinsics.areEqual("ec_shop_storage_for_remote_ab", "ec_shop_launch_opt_common_2") == false) goto L181;
        if (ECShopABSettings.b != null) goto L175;
        int r1 = n.a;
        int r3 = a.a;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L165
        Object r5 = d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L59
        if (r5 != null) goto L14;
    L56:
        Object r7 = null;
    L57:
        Object r8 = Result.constructor-impl(r7);     // Catch: Throwable -> L59
    L61:
        Throwable r11 = Result.exceptionOrNull-impl(r8);     // Catch: Throwable -> L165
        if (r11 == null) goto L65;
        EnsureManager.ensureNotReachHere(r11);     // Catch: Throwable -> L165
    L65:
        if (Result.isFailure-impl(r8) == false) goto L68;
        r8 = null;
    L68:
        if ((r8 instanceof Integer) == true) goto L70;
        r8 = null;
    L70:
        Object r12 = (Integer) r8;     // Catch: Throwable -> L165
        if (r12 != null) goto L77;
        Object r13 = d.a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L165
        if ((r13 instanceof Integer) == true) goto L76;
        r13 = null;
    L76:
        r12 = (Integer) r13;     // Catch: Throwable -> L165
    L77:
        if (r12 != null) goto L174;
        int r14 = c.a;     // Catch: Throwable -> L165
        Object r15 = d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L129
        if (r15 != null) goto L84;
    L126:
        Object r16 = null;
    L127:
        Object r17 = Result.constructor-impl(r16);     // Catch: Throwable -> L129
    L131:
        Throwable r18 = Result.exceptionOrNull-impl(r17);     // Catch: Throwable -> L156
        if (r18 == null) goto L135;
        EnsureManager.ensureNotReachHere(r18);     // Catch: Throwable -> L156
    L135:
        if (Result.isFailure-impl(r17) == false) goto L138;
        r17 = null;
    L138:
        if ((r17 instanceof Integer) == true) goto L140;
        r17 = null;
    L140:
        r12 = (Integer) r17;     // Catch: Throwable -> L156
        if (r12 != null) goto L163;
        IHybridHostService r19 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r19 == null) goto L146;
        Object r20 = r19.getHostABValue("ec_shop_launch_opt_common_2", r2);     // Catch: Throwable -> L156
    L147:
        if (r20 != null) goto L149;
    L162:
        r12 = r2;
        goto L163
    L149:
        if ((r20 instanceof Integer) == false) goto L152;
        r6 = r20;
    L152:
        Integer r21 = (Integer) r6;     // Catch: Throwable -> L156
        if (r21 == null) goto L162;
        r12 = r21;
        goto L163
    L156:
        th = move-exception;
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L165
        r12 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
        Throwable r23 = Result.exceptionOrNull-impl(r12);     // Catch: Throwable -> L165
        if (r23 == null) goto L161;
        EnsureManager.ensureNotReachHere(r23);     // Catch: Throwable -> L165
    L161:
        if (Result.isFailure-impl(r12) == false) goto L163;
    L146:
        r20 = null;
    L163:
        d.d("ec_shop_launch_opt_common_2", r12);     // Catch: Throwable -> L165
        goto L174
    L84:
        if ((r15 instanceof Integer) == true) goto L86;
        Object r24 = null;
    L87:
        r16 = (Integer) r24;     // Catch: Throwable -> L129
        if (r16 != null) goto L127;
        if ((r15 instanceof Number) == false) goto L114;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L99;
        Float r25 = Float.valueOf(((Number) r15).floatValue());     // Catch: Throwable -> L129
        if ((r25 instanceof Integer) == true) goto L97;
        r25 = null;
    L97:
        r16 = (Integer) r25;     // Catch: Throwable -> L129
        goto L127
    L99:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L105;
        Double r26 = Double.valueOf(((Number) r15).doubleValue());     // Catch: Throwable -> L129
        if ((r26 instanceof Integer) == true) goto L103;
        r26 = null;
    L103:
        r16 = (Integer) r26;     // Catch: Throwable -> L129
        goto L127
    L105:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L108;
        r16 = Integer.valueOf(((Number) r15).intValue());     // Catch: Throwable -> L129
        goto L127
    L108:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L114;
        Long r27 = Long.valueOf(((Number) r15).longValue());     // Catch: Throwable -> L129
        if ((r27 instanceof Integer) == true) goto L112;
        r27 = null;
    L112:
        r16 = (Integer) r27;     // Catch: Throwable -> L129
    L114:
        if ((r15 instanceof JSONObject) == false) goto L116;
    L384:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L122
        Object r28 = SDKSettingsCacheManager.a().fromJson(r15.toString(), Integer.class);     // Catch: Throwable -> L122
        if ((r28 instanceof Integer) == true) goto L120;
        r28 = null;
    L120:
        Object r29 = Result.constructor-impl((Integer) r28);     // Catch: Throwable -> L122
    L124:
        r16 = r29;
        if (Result.isFailure-impl(r16) == false) goto L127;
    L122:
        th = move-exception;
        Result.Companion r30 = Result.Companion;     // Catch: Throwable -> L129
        r29 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L129
        goto L124
    L116:
        if ((r15 instanceof JSONArray) == false) goto L126;
    L86:
        r24 = r15;
    L129:
        th = move-exception;
        Result.Companion r31 = Result.Companion;     // Catch: Throwable -> L156
        r17 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
    L174:
        ECShopABSettings.b = (Integer) r12;
        goto L175
    L14:
        if ((r5 instanceof Integer) == true) goto L16;
        Object r32 = null;
    L17:
        r7 = (Integer) r32;     // Catch: Throwable -> L59
        if (r7 != null) goto L57;
        if ((r5 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L29;
        Float r33 = Float.valueOf(((Number) r5).floatValue());     // Catch: Throwable -> L59
        if ((r33 instanceof Integer) == true) goto L27;
        r33 = null;
    L27:
        r7 = (Integer) r33;     // Catch: Throwable -> L59
        goto L57
    L29:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L35;
        Double r34 = Double.valueOf(((Number) r5).doubleValue());     // Catch: Throwable -> L59
        if ((r34 instanceof Integer) == true) goto L33;
        r34 = null;
    L33:
        r7 = (Integer) r34;     // Catch: Throwable -> L59
        goto L57
    L35:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        r7 = Integer.valueOf(((Number) r5).intValue());     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r35 = Long.valueOf(((Number) r5).longValue());     // Catch: Throwable -> L59
        if ((r35 instanceof Integer) == true) goto L42;
        r35 = null;
    L42:
        r7 = (Integer) r35;     // Catch: Throwable -> L59
    L44:
        if ((r5 instanceof JSONObject) == false) goto L46;
    L382:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L52
        Object r36 = SDKSettingsCacheManager.a().fromJson(r5.toString(), Integer.class);     // Catch: Throwable -> L52
        if ((r36 instanceof Integer) == true) goto L50;
        r36 = null;
    L50:
        Object r37 = Result.constructor-impl((Integer) r36);     // Catch: Throwable -> L52
    L54:
        r7 = r37;
        if (Result.isFailure-impl(r7) == false) goto L57;
    L52:
        th = move-exception;
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L59
        r37 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L59
        goto L54
    L46:
        if ((r5 instanceof JSONArray) == false) goto L56;
    L16:
        r32 = r5;
    L59:
        th = move-exception;
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L165
        r8 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
    L165:
        th = move-exception;
        Result.Companion r40 = Result.Companion;
        Object r41 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r42 = Result.exceptionOrNull-impl(r41);
        if (r42 == null) goto L170;
        EnsureManager.ensureNotReachHere(r42);
    L170:
        if (Result.isFailure-impl(r41) == true) goto L173;
        r2 = r41;
    L173:
        r12 = r2;
    L175:
        Object r43 = ECShopABSettings.b;
        if (r43 == null) goto L179;
    L356:
        ECShopABSettings.a.put("ec_shop_storage_for_remote_ab", r43);
        if (((Number) r43).intValue() != 1) goto L360;
        return "";
    L179:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L181:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L192;
        int r44 = p.a;
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L187
        b r46 = b.b;     // Catch: Throwable -> L187
        r43 = jj4.a.a("ec_shop_storage_for_remote_ab", Integer.class, r2, false);     // Catch: Throwable -> L187
        if (r43 != null) goto L356;
        Intrinsics.throwNpe();     // Catch: Throwable -> L187
    L187:
        th = move-exception;
        Result.Companion r47 = Result.Companion;
        Object r48 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r48) == true) goto L355;
    L191:
        r2 = r48;
    L355:
        r43 = r2;
        goto L356
    L192:
        int r49 = n.a;
        int r50 = a.a;
        Result.Companion r51 = Result.Companion;     // Catch: Throwable -> L349
        Object r52 = d.c.get("ec_shop_storage_for_remote_ab");     // Catch: Throwable -> L243
        if (r52 != null) goto L198;
    L240:
        Object r53 = null;
    L241:
        Object r54 = Result.constructor-impl(r53);     // Catch: Throwable -> L243
    L245:
        Throwable r55 = Result.exceptionOrNull-impl(r54);     // Catch: Throwable -> L349
        if (r55 == null) goto L249;
        EnsureManager.ensureNotReachHere(r55);     // Catch: Throwable -> L349
    L249:
        if (Result.isFailure-impl(r54) == false) goto L252;
        r54 = null;
    L252:
        if ((r54 instanceof Integer) == true) goto L254;
        r54 = null;
    L254:
        r43 = (Integer) r54;     // Catch: Throwable -> L349
        if (r43 != null) goto L261;
        Object r56 = d.a.get("ec_shop_storage_for_remote_ab");     // Catch: Throwable -> L349
        if ((r56 instanceof Integer) == true) goto L260;
        r56 = null;
    L260:
        r43 = (Integer) r56;     // Catch: Throwable -> L349
    L261:
        if (r43 != null) goto L356;
        int r57 = c.a;     // Catch: Throwable -> L349
        Object r58 = d.c.get("ec_shop_storage_for_remote_ab");     // Catch: Throwable -> L313
        if (r58 != null) goto L268;
    L310:
        Object r59 = null;
    L311:
        Object r60 = Result.constructor-impl(r59);     // Catch: Throwable -> L313
    L315:
        Throwable r61 = Result.exceptionOrNull-impl(r60);     // Catch: Throwable -> L340
        if (r61 == null) goto L319;
        EnsureManager.ensureNotReachHere(r61);     // Catch: Throwable -> L340
    L319:
        if (Result.isFailure-impl(r60) == false) goto L322;
        r60 = null;
    L322:
        if ((r60 instanceof Integer) == true) goto L324;
        r60 = null;
    L324:
        r43 = (Integer) r60;     // Catch: Throwable -> L340
        if (r43 != null) goto L347;
        IHybridHostService r62 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L340
        if (r62 == null) goto L330;
        Object r63 = r62.getHostABValue("ec_shop_storage_for_remote_ab", r2);     // Catch: Throwable -> L340
    L331:
        if (r63 != null) goto L333;
    L346:
        r43 = r2;
        goto L347
    L333:
        if ((r63 instanceof Integer) == false) goto L336;
        r6 = r63;
    L336:
        Integer r64 = (Integer) r6;     // Catch: Throwable -> L340
        if (r64 == null) goto L346;
        r43 = r64;
        goto L347
    L340:
        th = move-exception;
        Result.Companion r65 = Result.Companion;     // Catch: Throwable -> L349
        r43 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L349
        Throwable r66 = Result.exceptionOrNull-impl(r43);     // Catch: Throwable -> L349
        if (r66 == null) goto L345;
        EnsureManager.ensureNotReachHere(r66);     // Catch: Throwable -> L349
    L345:
        if (Result.isFailure-impl(r43) == false) goto L347;
    L330:
        r63 = null;
    L347:
        d.d("ec_shop_storage_for_remote_ab", r43);     // Catch: Throwable -> L349
        goto L356
    L268:
        if ((r58 instanceof Integer) == true) goto L270;
        Object r67 = null;
    L271:
        r59 = (Integer) r67;     // Catch: Throwable -> L313
        if (r59 != null) goto L311;
        if ((r58 instanceof Number) == false) goto L298;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L283;
        Float r68 = Float.valueOf(((Number) r58).floatValue());     // Catch: Throwable -> L313
        if ((r68 instanceof Integer) == true) goto L281;
        r68 = null;
    L281:
        r59 = (Integer) r68;     // Catch: Throwable -> L313
        goto L311
    L283:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L289;
        Double r69 = Double.valueOf(((Number) r58).doubleValue());     // Catch: Throwable -> L313
        if ((r69 instanceof Integer) == true) goto L287;
        r69 = null;
    L287:
        r59 = (Integer) r69;     // Catch: Throwable -> L313
        goto L311
    L289:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L292;
        r59 = Integer.valueOf(((Number) r58).intValue());     // Catch: Throwable -> L313
        goto L311
    L292:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L298;
        Long r70 = Long.valueOf(((Number) r58).longValue());     // Catch: Throwable -> L313
        if ((r70 instanceof Integer) == true) goto L296;
        r70 = null;
    L296:
        r59 = (Integer) r70;     // Catch: Throwable -> L313
    L298:
        if ((r58 instanceof JSONObject) == false) goto L300;
    L372:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L306
        Object r71 = SDKSettingsCacheManager.a().fromJson(r58.toString(), Integer.class);     // Catch: Throwable -> L306
        if ((r71 instanceof Integer) == true) goto L304;
        r71 = null;
    L304:
        Object r72 = Result.constructor-impl((Integer) r71);     // Catch: Throwable -> L306
    L308:
        r59 = r72;
        if (Result.isFailure-impl(r59) == false) goto L311;
    L306:
        th = move-exception;
        Result.Companion r73 = Result.Companion;     // Catch: Throwable -> L313
        r72 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L313
        goto L308
    L300:
        if ((r58 instanceof JSONArray) == false) goto L310;
    L270:
        r67 = r58;
    L313:
        th = move-exception;
        Result.Companion r74 = Result.Companion;     // Catch: Throwable -> L340
        r60 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L340
        goto L315
    L198:
        if ((r52 instanceof Integer) == true) goto L200;
        Object r75 = null;
    L201:
        r53 = (Integer) r75;     // Catch: Throwable -> L243
        if (r53 != null) goto L241;
        if ((r52 instanceof Number) == false) goto L228;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L213;
        Float r76 = Float.valueOf(((Number) r52).floatValue());     // Catch: Throwable -> L243
        if ((r76 instanceof Integer) == true) goto L211;
        r76 = null;
    L211:
        r53 = (Integer) r76;     // Catch: Throwable -> L243
        goto L241
    L213:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L219;
        Double r77 = Double.valueOf(((Number) r52).doubleValue());     // Catch: Throwable -> L243
        if ((r77 instanceof Integer) == true) goto L217;
        r77 = null;
    L217:
        r53 = (Integer) r77;     // Catch: Throwable -> L243
        goto L241
    L219:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L222;
        r53 = Integer.valueOf(((Number) r52).intValue());     // Catch: Throwable -> L243
        goto L241
    L222:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L228;
        Long r78 = Long.valueOf(((Number) r52).longValue());     // Catch: Throwable -> L243
        if ((r78 instanceof Integer) == true) goto L226;
        r78 = null;
    L226:
        r53 = (Integer) r78;     // Catch: Throwable -> L243
    L228:
        if ((r52 instanceof JSONObject) == false) goto L230;
    L370:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L236
        Object r79 = SDKSettingsCacheManager.a().fromJson(r52.toString(), Integer.class);     // Catch: Throwable -> L236
        if ((r79 instanceof Integer) == true) goto L234;
        r79 = null;
    L234:
        Object r80 = Result.constructor-impl((Integer) r79);     // Catch: Throwable -> L236
    L238:
        r53 = r80;
        if (Result.isFailure-impl(r53) == false) goto L241;
    L236:
        th = move-exception;
        Result.Companion r81 = Result.Companion;     // Catch: Throwable -> L243
        r80 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L243
        goto L238
    L230:
        if ((r52 instanceof JSONArray) == false) goto L240;
    L200:
        r75 = r52;
    L243:
        th = move-exception;
        Result.Companion r82 = Result.Companion;     // Catch: Throwable -> L349
        r54 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L349
    L349:
        th = move-exception;
        Result.Companion r83 = Result.Companion;
        r48 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r84 = Result.exceptionOrNull-impl(r48);
        if (r84 == null) goto L354;
        EnsureManager.ensureNotReachHere(r84);
    L354:
        if (Result.isFailure-impl(r48) == false) goto L191;
    L360:
        Map r85 = MapsKt.toMutableMap(a.getAll());
        if (r9 == null) goto L363;
        r85.putAll(Keva.getRepo(a(r9, "-1"), 1).getAll());
    L363:
        if (r10 == null) goto L365;
        r85.putAll(Keva.getRepo(a("-1", r10), 1).getAll());
    L365:
        if (r9 == null) goto L369;
        if (r10 == null) goto L369;
        r85.putAll(Keva.getRepo(a(r9, r10), 1).getAll());
    L369:
        return k.d(r85);
    }

    public final synchronized ShopRemoteStruct c(int r2, String r3, String r4, String r5, String r6) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r3, "secShopId");     // Catch: Throwable -> L30
        Intrinsics.checkNotNullParameter(r4, "userId");     // Catch: Throwable -> L30
        Keva r7 = Keva.getRepo(a(r3, r4), 1);     // Catch: Throwable -> L30
        Object r0 = null;
        if (r2 == 0) goto L23;
        if (r2 != 1) goto L7;
    L17:
        if (r5 != null) goto L20;
        monitor-exit(this);
        return null;
    L20:
        r7.storeString(r5, r6);     // Catch: Throwable -> L30
    L21:
        monitor-exit(this);
        return null;
    L7:
        if (r2 != 2) goto L9;
        if (r5 != null) goto L15;
        monitor-exit(this);
        return null;
    L15:
        r7.storeString(r5, null);     // Catch: Throwable -> L30
        goto L21
    L9:
        if (r2 == 3) goto L17;
        EnsureManager.ensureNotReachHere("ECShopDataStorageForRemote_error_action_type");     // Catch: Throwable -> L30
        goto L21
    L23:
        String r8 = r7.getString(r5, null);     // Catch: Throwable -> L30
        if ((r8 instanceof ShopRemoteStruct) == false) goto L27;
        r0 = r8;
    L27:
        ShopRemoteStruct r1 = (ShopRemoteStruct) r0;     // Catch: Throwable -> L30
        monitor-exit(this);
        return r1;
    L30:
        th = move-exception;
        throw th;
    }
}

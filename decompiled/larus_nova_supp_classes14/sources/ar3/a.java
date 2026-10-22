package ar3;

import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.opt.ab.n;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.window.shop.home.tab.WindowHybridTabViewModel;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.android.window.shop.utils.vane.WindowVaneConfigEnum;
import com.bytedance.services.apm.api.EnsureManager;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;
import zq3.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a extends d {
    @Override // ar3.d
    public final WindowVaneConfigEnum b() {
        return WindowVaneConfigEnum.HOT_SALE_VANE;
    }

    @Override // ar3.d
    public final boolean c(WindowV2ProductItemVO r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "itemVO");
        Intrinsics.checkNotNullParameter(r11, "categoryId");
        com.bytedance.android.window.shop.repository.tab.entity.f r0 = d.a(r10);
        if (r0 != null) goto L5;
        return false;
    L5:
        Lazy r3 = ECSettingKeys.a;
        int r4 = n.a;
        int r5 = com.bytedance.android.ec.base.settings.a.a;
        Object r6 = null;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L160
        Object r8 = com.bytedance.android.ec.base.settings.d.c.get("window_recommend_show_hot_sale_vane");     // Catch: Throwable -> L56
        if (r8 != null) goto L11;
    L53:
        Object r9 = null;
    L54:
        Object r12 = Result.constructor-impl(r9);     // Catch: Throwable -> L56
    L58:
        Throwable r13 = Result.exceptionOrNull-impl(r12);     // Catch: Throwable -> L160
        if (r13 == null) goto L62;
        EnsureManager.ensureNotReachHere(r13);     // Catch: Throwable -> L160
    L62:
        if (Result.isFailure-impl(r12) == false) goto L65;
        r12 = null;
    L65:
        if ((r12 instanceof Integer) == true) goto L67;
        r12 = null;
    L67:
        Object r14 = (Integer) r12;     // Catch: Throwable -> L160
        if (r14 != null) goto L74;
        Object r15 = com.bytedance.android.ec.base.settings.d.a.get("window_recommend_show_hot_sale_vane");     // Catch: Throwable -> L160
        if ((r15 instanceof Integer) == true) goto L73;
        r15 = null;
    L73:
        r14 = (Integer) r15;     // Catch: Throwable -> L160
    L74:
        if (r14 != null) goto L168;
        int r16 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L160
        Object r17 = com.bytedance.android.ec.base.settings.d.c.get("window_recommend_show_hot_sale_vane");     // Catch: Throwable -> L126
        if (r17 != null) goto L81;
    L123:
        Object r18 = null;
    L124:
        Object r19 = Result.constructor-impl(r18);     // Catch: Throwable -> L126
    L128:
        Throwable r20 = Result.exceptionOrNull-impl(r19);     // Catch: Throwable -> L151
        if (r20 == null) goto L132;
        EnsureManager.ensureNotReachHere(r20);     // Catch: Throwable -> L151
    L132:
        if (Result.isFailure-impl(r19) == false) goto L135;
        r19 = null;
    L135:
        if ((r19 instanceof Integer) == true) goto L137;
        r19 = null;
    L137:
        r14 = (Integer) r19;     // Catch: Throwable -> L151
        if (r14 != null) goto L158;
        IHybridHostService r21 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L151
        if (r21 == null) goto L143;
        Object r22 = r21.getHostABValue("window_recommend_show_hot_sale_vane", 0);     // Catch: Throwable -> L151
    L144:
        if (r22 != null) goto L146;
    L157:
        r14 = 0;
        goto L158
    L146:
        if ((r22 instanceof Integer) == true) goto L148;
        r22 = null;
    L148:
        r14 = (Integer) r22;     // Catch: Throwable -> L151
        if (r14 != null) goto L158;
    L151:
        th = move-exception;
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L160
        r14 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L160
        Throwable r24 = Result.exceptionOrNull-impl(r14);     // Catch: Throwable -> L160
        if (r24 == null) goto L156;
        EnsureManager.ensureNotReachHere(r24);     // Catch: Throwable -> L160
    L156:
        if (Result.isFailure-impl(r14) == false) goto L158;
    L143:
        r22 = null;
    L158:
        com.bytedance.android.ec.base.settings.d.d("window_recommend_show_hot_sale_vane", r14);     // Catch: Throwable -> L160
        goto L168
    L81:
        if ((r17 instanceof Integer) == true) goto L83;
        Object r25 = null;
    L84:
        r18 = (Integer) r25;     // Catch: Throwable -> L126
        if (r18 != null) goto L124;
        if ((r17 instanceof Number) == false) goto L111;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L96;
        Float r26 = Float.valueOf(((Number) r17).floatValue());     // Catch: Throwable -> L126
        if ((r26 instanceof Integer) == true) goto L94;
        r26 = null;
    L94:
        r18 = (Integer) r26;     // Catch: Throwable -> L126
        goto L124
    L96:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L102;
        Double r27 = Double.valueOf(((Number) r17).doubleValue());     // Catch: Throwable -> L126
        if ((r27 instanceof Integer) == true) goto L100;
        r27 = null;
    L100:
        r18 = (Integer) r27;     // Catch: Throwable -> L126
        goto L124
    L102:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L105;
        r18 = Integer.valueOf(((Number) r17).intValue());     // Catch: Throwable -> L126
        goto L124
    L105:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L111;
        Long r28 = Long.valueOf(((Number) r17).longValue());     // Catch: Throwable -> L126
        if ((r28 instanceof Integer) == true) goto L109;
        r28 = null;
    L109:
        r18 = (Integer) r28;     // Catch: Throwable -> L126
    L111:
        if ((r17 instanceof JSONObject) == false) goto L113;
    L351:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L119
        Object r29 = SDKSettingsCacheManager.a().fromJson(r17.toString(), Integer.class);     // Catch: Throwable -> L119
        if ((r29 instanceof Integer) == true) goto L117;
        r29 = null;
    L117:
        Object r30 = Result.constructor-impl((Integer) r29);     // Catch: Throwable -> L119
    L121:
        r18 = r30;
        if (Result.isFailure-impl(r18) == false) goto L124;
    L119:
        th = move-exception;
        Result.Companion r31 = Result.Companion;     // Catch: Throwable -> L126
        r30 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L126
        goto L121
    L113:
        if ((r17 instanceof JSONArray) == false) goto L123;
    L83:
        r25 = r17;
    L126:
        th = move-exception;
        Result.Companion r32 = Result.Companion;     // Catch: Throwable -> L151
        r19 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L151
    L168:
        if (((Number) r14).intValue() == 1) goto L170;
        return false;
    L170:
        if (Intrinsics.areEqual(r11, "-1") == false) goto L172;
    L173:
        int r110 = n.a;
        Object r33 = -1;
        int r34 = com.bytedance.android.ec.base.settings.a.a;
        Object r35 = com.bytedance.android.ec.base.settings.d.c.get("window_hot_sale_vane_card_gap");     // Catch: Throwable -> L223
        if (r35 != null) goto L178;
    L220:
        Object r36 = null;
    L221:
        Object r37 = Result.constructor-impl(r36);     // Catch: Throwable -> L223
    L225:
        Throwable r38 = Result.exceptionOrNull-impl(r37);     // Catch: Throwable -> L329
        if (r38 == null) goto L229;
        EnsureManager.ensureNotReachHere(r38);     // Catch: Throwable -> L329
    L229:
        if (Result.isFailure-impl(r37) == false) goto L232;
        r37 = null;
    L232:
        if ((r37 instanceof Integer) == true) goto L234;
        r37 = null;
    L234:
        Object r39 = (Integer) r37;     // Catch: Throwable -> L329
        if (r39 != null) goto L241;
        Object r40 = com.bytedance.android.ec.base.settings.d.a.get("window_hot_sale_vane_card_gap");     // Catch: Throwable -> L329
        if ((r40 instanceof Integer) == true) goto L240;
        r40 = null;
    L240:
        r39 = (Integer) r40;     // Catch: Throwable -> L329
    L241:
        if (r39 != null) goto L338;
        int r41 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L329
        Object r42 = com.bytedance.android.ec.base.settings.d.c.get("window_hot_sale_vane_card_gap");     // Catch: Throwable -> L293
        if (r42 != null) goto L248;
    L290:
        Object r43 = null;
    L291:
        Object r44 = Result.constructor-impl(r43);     // Catch: Throwable -> L293
    L295:
        Throwable r45 = Result.exceptionOrNull-impl(r44);     // Catch: Throwable -> L319
        if (r45 == null) goto L299;
        EnsureManager.ensureNotReachHere(r45);     // Catch: Throwable -> L319
    L299:
        if (Result.isFailure-impl(r44) == false) goto L302;
        r44 = null;
    L302:
        if ((r44 instanceof Integer) == true) goto L304;
        r44 = null;
    L304:
        r39 = (Integer) r44;     // Catch: Throwable -> L319
        if (r39 != null) goto L327;
        IHybridHostService r46 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L319
        if (r46 == null) goto L310;
        Object r47 = r46.getHostABValue("window_hot_sale_vane_card_gap", r33);     // Catch: Throwable -> L319
    L311:
        if (r47 != null) goto L313;
    L318:
        r39 = r33;
        goto L327
    L313:
        if ((r47 instanceof Integer) == false) goto L316;
        r6 = r47;
    L316:
        Object r48 = (Integer) r6;     // Catch: Throwable -> L319
        if (r48 == null) goto L318;
    L326:
        r39 = r48;
        goto L327
    L310:
        r47 = null;
    L327:
        com.bytedance.android.ec.base.settings.d.d("window_hot_sale_vane_card_gap", r39);     // Catch: Throwable -> L329
        goto L338
    L248:
        if ((r42 instanceof Integer) == true) goto L250;
        Object r49 = null;
    L251:
        r43 = (Integer) r49;     // Catch: Throwable -> L293
        if (r43 != null) goto L291;
        if ((r42 instanceof Number) == false) goto L278;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L263;
        Float r50 = Float.valueOf(((Number) r42).floatValue());     // Catch: Throwable -> L293
        if ((r50 instanceof Integer) == true) goto L261;
        r50 = null;
    L261:
        r43 = (Integer) r50;     // Catch: Throwable -> L293
        goto L291
    L263:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L269;
        Double r51 = Double.valueOf(((Number) r42).doubleValue());     // Catch: Throwable -> L293
        if ((r51 instanceof Integer) == true) goto L267;
        r51 = null;
    L267:
        r43 = (Integer) r51;     // Catch: Throwable -> L293
        goto L291
    L269:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L272;
        r43 = Integer.valueOf(((Number) r42).intValue());     // Catch: Throwable -> L293
        goto L291
    L272:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L278;
        Long r52 = Long.valueOf(((Number) r42).longValue());     // Catch: Throwable -> L293
        if ((r52 instanceof Integer) == true) goto L276;
        r52 = null;
    L276:
        r43 = (Integer) r52;     // Catch: Throwable -> L293
    L278:
        if ((r42 instanceof JSONObject) == false) goto L280;
    L355:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L286
        Object r53 = SDKSettingsCacheManager.a().fromJson(r42.toString(), Integer.class);     // Catch: Throwable -> L286
        if ((r53 instanceof Integer) == true) goto L284;
        r53 = null;
    L284:
        Object r54 = Result.constructor-impl((Integer) r53);     // Catch: Throwable -> L286
    L288:
        r43 = r54;
        if (Result.isFailure-impl(r43) == false) goto L291;
    L286:
        th = move-exception;
        Result.Companion r55 = Result.Companion;     // Catch: Throwable -> L293
        r54 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L293
        goto L288
    L280:
        if ((r42 instanceof JSONArray) == false) goto L290;
    L250:
        r49 = r42;
    L319:
        th = move-exception;
        Result.Companion r56 = Result.Companion;     // Catch: Throwable -> L329
        r48 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L329
        Throwable r57 = Result.exceptionOrNull-impl(r48);     // Catch: Throwable -> L329
        if (r57 == null) goto L324;
        EnsureManager.ensureNotReachHere(r57);     // Catch: Throwable -> L329
    L324:
        if (Result.isFailure-impl(r48) == false) goto L326;
        r48 = r33;
    L293:
        th = move-exception;
        Result.Companion r58 = Result.Companion;     // Catch: Throwable -> L319
        r44 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L319
    L338:
        int r111 = ((Number) r39).intValue();
        Integer r112 = r10.b();
        if (r112 != null) goto L342;
        return false;
    L342:
        if (r111 != r112.intValue()) goto L373;
        WindowHybridTabViewModel r113 = this.c;
        WindowHybridTabViewModel.Companion.getClass();
        Function2 r114 = (Function2) r113.getExtension(WindowHybridTabViewModel.access$getDYNAMIC_CARD_CHECKER$cp());
        if (r114 != null) goto L346;
        return false;
    L346:
        if (((Boolean) r114.invoke(r0, 0)).booleanValue() == true) goto L375;
        return true;
    L375:
        return false;
    L373:
        return false;
    L178:
        if ((r35 instanceof Integer) == true) goto L180;
        Object r59 = null;
    L181:
        r36 = (Integer) r59;     // Catch: Throwable -> L223
        if (r36 != null) goto L221;
        if ((r35 instanceof Number) == false) goto L208;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L193;
        Float r60 = Float.valueOf(((Number) r35).floatValue());     // Catch: Throwable -> L223
        if ((r60 instanceof Integer) == true) goto L191;
        r60 = null;
    L191:
        r36 = (Integer) r60;     // Catch: Throwable -> L223
        goto L221
    L193:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L199;
        Double r61 = Double.valueOf(((Number) r35).doubleValue());     // Catch: Throwable -> L223
        if ((r61 instanceof Integer) == true) goto L197;
        r61 = null;
    L197:
        r36 = (Integer) r61;     // Catch: Throwable -> L223
        goto L221
    L199:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L202;
        r36 = Integer.valueOf(((Number) r35).intValue());     // Catch: Throwable -> L223
        goto L221
    L202:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L208;
        Long r62 = Long.valueOf(((Number) r35).longValue());     // Catch: Throwable -> L223
        if ((r62 instanceof Integer) == true) goto L206;
        r62 = null;
    L206:
        r36 = (Integer) r62;     // Catch: Throwable -> L223
    L208:
        if ((r35 instanceof JSONObject) == false) goto L210;
    L353:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L216
        Object r63 = SDKSettingsCacheManager.a().fromJson(r35.toString(), Integer.class);     // Catch: Throwable -> L216
        if ((r63 instanceof Integer) == true) goto L214;
        r63 = null;
    L214:
        Object r64 = Result.constructor-impl((Integer) r63);     // Catch: Throwable -> L216
    L218:
        r36 = r64;
        if (Result.isFailure-impl(r36) == false) goto L221;
    L216:
        th = move-exception;
        Result.Companion r65 = Result.Companion;     // Catch: Throwable -> L223
        r64 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L223
        goto L218
    L210:
        if ((r35 instanceof JSONArray) == false) goto L220;
    L180:
        r59 = r35;
    L329:
        th = move-exception;
        Result.Companion r66 = Result.Companion;
        Object r115 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r67 = Result.exceptionOrNull-impl(r115);
        if (r67 == null) goto L334;
        EnsureManager.ensureNotReachHere(r67);
    L334:
        if (Result.isFailure-impl(r115) == true) goto L337;
        r33 = r115;
    L337:
        r39 = r33;
    L223:
        th = move-exception;
        Result.Companion r68 = Result.Companion;     // Catch: Throwable -> L329
        r37 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L329
        goto L225
    L172:
        if (l.d() == false) goto L173;
        return false;
    L11:
        if ((r8 instanceof Integer) == true) goto L13;
        Object r69 = null;
    L14:
        r9 = (Integer) r69;     // Catch: Throwable -> L56
        if (r9 != null) goto L54;
        if ((r8 instanceof Number) == false) goto L41;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r70 = Float.valueOf(((Number) r8).floatValue());     // Catch: Throwable -> L56
        if ((r70 instanceof Integer) == true) goto L24;
        r70 = null;
    L24:
        r9 = (Integer) r70;     // Catch: Throwable -> L56
        goto L54
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r71 = Double.valueOf(((Number) r8).doubleValue());     // Catch: Throwable -> L56
        if ((r71 instanceof Integer) == true) goto L30;
        r71 = null;
    L30:
        r9 = (Integer) r71;     // Catch: Throwable -> L56
        goto L54
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L35;
        r9 = Integer.valueOf(((Number) r8).intValue());     // Catch: Throwable -> L56
        goto L54
    L35:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L41;
        Long r72 = Long.valueOf(((Number) r8).longValue());     // Catch: Throwable -> L56
        if ((r72 instanceof Integer) == true) goto L39;
        r72 = null;
    L39:
        r9 = (Integer) r72;     // Catch: Throwable -> L56
    L41:
        if ((r8 instanceof JSONObject) == false) goto L43;
    L349:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L49
        Object r73 = SDKSettingsCacheManager.a().fromJson(r8.toString(), Integer.class);     // Catch: Throwable -> L49
        if ((r73 instanceof Integer) == true) goto L47;
        r73 = null;
    L47:
        Object r74 = Result.constructor-impl((Integer) r73);     // Catch: Throwable -> L49
    L51:
        r9 = r74;
        if (Result.isFailure-impl(r9) == false) goto L54;
    L49:
        th = move-exception;
        Result.Companion r75 = Result.Companion;     // Catch: Throwable -> L56
        r74 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L56
        goto L51
    L43:
        if ((r8 instanceof JSONArray) == false) goto L53;
    L13:
        r69 = r8;
    L56:
        th = move-exception;
        Result.Companion r76 = Result.Companion;     // Catch: Throwable -> L160
        r12 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L160
    L160:
        th = move-exception;
        Result.Companion r77 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r78 = Result.exceptionOrNull-impl(r14);
        if (r78 == null) goto L165;
        EnsureManager.ensureNotReachHere(r78);
    L165:
        if (Result.isFailure-impl(r14) == false) goto L168;
        r14 = 0;
        goto L168
    }

    public a(Fragment r2, ECWindowViewModel r3, WindowHybridTabViewModel r4) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        Intrinsics.checkNotNullParameter(r4, "tabViewModel");
        super(r2, r3, r4);
    }
}

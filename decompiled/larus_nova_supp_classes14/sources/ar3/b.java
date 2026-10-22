package ar3;

import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.opt.ab.n;
import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.window.shop.home.tab.WindowHybridTabViewModel;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.android.window.shop.utils.vane.WindowVaneConfigEnum;
import com.bytedance.services.apm.api.EnsureManager;
import com.google.gson.Gson;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import zq3.a0;
import zq3.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b extends d {
    @Override // ar3.d
    public final WindowVaneConfigEnum b() {
        return WindowVaneConfigEnum.RECOMMEND_VANE;
    }

    @Override // ar3.d
    public final boolean c(WindowV2ProductItemVO r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, "itemVO");
        Intrinsics.checkNotNullParameter(r10, "categoryId");
        com.bytedance.android.window.shop.repository.tab.entity.f r11 = d.a(r9);
        if (r11 != null) goto L5;
        return false;
    L5:
        Lazy r1 = ECSettingKeys.a;
        int r2 = n.a;
        Object r3 = 0;
        int r4 = com.bytedance.android.ec.base.settings.a.a;
        Object r5 = null;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L160
        Object r7 = com.bytedance.android.ec.base.settings.d.c.get("window_recommend_show_guess_vane");     // Catch: Throwable -> L56
        if (r7 != null) goto L11;
    L53:
        Object r8 = null;
    L54:
        Object r12 = Result.constructor-impl(r8);     // Catch: Throwable -> L56
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
        Object r15 = com.bytedance.android.ec.base.settings.d.a.get("window_recommend_show_guess_vane");     // Catch: Throwable -> L160
        if ((r15 instanceof Integer) == true) goto L73;
        r15 = null;
    L73:
        r14 = (Integer) r15;     // Catch: Throwable -> L160
    L74:
        if (r14 != null) goto L170;
        int r16 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L160
        Object r17 = com.bytedance.android.ec.base.settings.d.c.get("window_recommend_show_guess_vane");     // Catch: Throwable -> L126
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
        Object r22 = r21.getHostABValue("window_recommend_show_guess_vane", r3);     // Catch: Throwable -> L151
    L144:
        if (r22 != null) goto L146;
    L157:
        r14 = r3;
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
        com.bytedance.android.ec.base.settings.d.d("window_recommend_show_guess_vane", r14);     // Catch: Throwable -> L160
        goto L170
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
    L220:
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
    L170:
        if (((Number) r14).intValue() == 1) goto L172;
        return false;
    L172:
        if (Intrinsics.areEqual(r10, "-1") == false) goto L174;
    L175:
        WindowHybridTabViewModel r110 = this.c;
        WindowHybridTabViewModel.Companion.getClass();
        Function2 r111 = (Function2) r110.getExtension(WindowHybridTabViewModel.access$getDYNAMIC_CARD_CHECKER$cp());
        if (r111 == null) goto L238;
        int r33 = l.a;
        Gson r34 = zq3.c.a;
        Object r35 = 4;
        if (zq3.c.b == false) goto L189;
        int r36 = p.a;
        jj4.b r37 = jj4.b.b;     // Catch: Throwable -> L184
        r5 = jj4.a.a("window_recommend_vane_gap", Integer.class, r35, false);     // Catch: Throwable -> L184
        if (r5 != null) goto L215;
        Intrinsics.throwNpe();     // Catch: Throwable -> L184
    L215:
        if (((Boolean) r111.invoke(r11, Integer.valueOf(((Number) r5).intValue()))).booleanValue() == true) goto L239;
        return true;
    L239:
        return false;
    L184:
        th = move-exception;
        Result.Companion r38 = Result.Companion;
        Object r39 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r39) == true) goto L213;
    L188:
        r35 = r39;
    L213:
        r5 = r35;
        goto L215
    L189:
        String r40 = hq7.d.b("debug.shopping.mock.window_recommend_vane_gap");
        if (r40 != null) goto L192;
    L195:
        boolean r41 = true;
    L196:
        if (r41 == false) goto L228;
    L204:
        if (r5 != null) goto L215;
        int r42 = p.a;
        Result.Companion r43 = Result.Companion;     // Catch: Throwable -> L210
        jj4.b r44 = jj4.b.b;     // Catch: Throwable -> L210
        r5 = jj4.a.a("window_recommend_vane_gap", Integer.class, r35, false);     // Catch: Throwable -> L210
        if (r5 != null) goto L215;
        Intrinsics.throwNpe();     // Catch: Throwable -> L210
    L210:
        th = move-exception;
        Result.Companion r45 = Result.Companion;
        r39 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r39) == false) goto L188;
    L228:
        Object r46 = zq3.c.a.fromJson(r40, new a0().getType());     // Catch: Exception -> L202
        if (r46 == null) goto L204;
        r5 = r46;
    L202:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L204
    L192:
        if (StringsKt.isBlank(r40) == true) goto L195;
        r41 = false;
        goto L196
    L238:
        return false;
    L174:
        if (l.d() == false) goto L175;
        return false;
    L11:
        if ((r7 instanceof Integer) == true) goto L13;
        Object r47 = null;
    L14:
        r8 = (Integer) r47;     // Catch: Throwable -> L56
        if (r8 != null) goto L54;
        if ((r7 instanceof Number) == false) goto L41;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r48 = Float.valueOf(((Number) r7).floatValue());     // Catch: Throwable -> L56
        if ((r48 instanceof Integer) == true) goto L24;
        r48 = null;
    L24:
        r8 = (Integer) r48;     // Catch: Throwable -> L56
        goto L54
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r49 = Double.valueOf(((Number) r7).doubleValue());     // Catch: Throwable -> L56
        if ((r49 instanceof Integer) == true) goto L30;
        r49 = null;
    L30:
        r8 = (Integer) r49;     // Catch: Throwable -> L56
        goto L54
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L35;
        r8 = Integer.valueOf(((Number) r7).intValue());     // Catch: Throwable -> L56
        goto L54
    L35:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L41;
        Long r50 = Long.valueOf(((Number) r7).longValue());     // Catch: Throwable -> L56
        if ((r50 instanceof Integer) == true) goto L39;
        r50 = null;
    L39:
        r8 = (Integer) r50;     // Catch: Throwable -> L56
    L41:
        if ((r7 instanceof JSONObject) == false) goto L43;
    L218:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L49
        Object r51 = SDKSettingsCacheManager.a().fromJson(r7.toString(), Integer.class);     // Catch: Throwable -> L49
        if ((r51 instanceof Integer) == true) goto L47;
        r51 = null;
    L47:
        Object r52 = Result.constructor-impl((Integer) r51);     // Catch: Throwable -> L49
    L51:
        r8 = r52;
        if (Result.isFailure-impl(r8) == false) goto L54;
    L49:
        th = move-exception;
        Result.Companion r53 = Result.Companion;     // Catch: Throwable -> L56
        r52 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L56
        goto L51
    L43:
        if ((r7 instanceof JSONArray) == false) goto L53;
    L13:
        r47 = r7;
    L56:
        th = move-exception;
        Result.Companion r54 = Result.Companion;     // Catch: Throwable -> L160
        r12 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L160
    L160:
        th = move-exception;
        Result.Companion r55 = Result.Companion;
        Object r56 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r57 = Result.exceptionOrNull-impl(r56);
        if (r57 == null) goto L165;
        EnsureManager.ensureNotReachHere(r57);
    L165:
        if (Result.isFailure-impl(r56) == true) goto L168;
        r3 = r56;
    L168:
        r14 = r3;
        goto L170
    }

    public b(Fragment r2, ECWindowViewModel r3, WindowHybridTabViewModel r4) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        Intrinsics.checkNotNullParameter(r4, "tabViewModel");
        super(r2, r3, r4);
    }
}

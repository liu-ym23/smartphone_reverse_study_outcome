package com.larus.login.api.ecommerce;

import android.content.Context;
import com.bytedance.keva.Keva;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.common.apphost.AppHost;
import com.larus.login.api.LoginService;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.api.f2;
import com.larus.utils.b0;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes30.dex */
public final class ECommerceTextConfigRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ECommerceTextConfigRepository f357016a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, l> f357017b = null;

    public ECommerceTextConfigRepository() {
    }

    static {
        f357016a = new ECommerceTextConfigRepository();
        f357017b = new LinkedHashMap();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static com.larus.login.api.i c(l r110) {
        b r100 = r110.a();
        String r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        Boolean r102 = r110.i();
        Boolean r103 = Boolean.TRUE;
        boolean r111 = Intrinsics.areEqual(r102, r103);
        o r104 = r110.c();
        if (r104 == null) goto L8;
        String r105 = r104.a();
    L9:
        o r106 = r110.j();
        if (r106 == null) goto L20;
        String r107 = r106.a();
        if (r107 == null) goto L20;
        CharSequence r108 = r107;
        if (Intrinsics.areEqual(r110.g(), r103) == false) goto L19;
        LoginService r109 = LoginService.f356989a;
        AppHost.Companion r112 = AppHost.f326268a;
        Context r113 = r112.a().getCurrentActivity();
        if (r113 != null) goto L18;
        r113 = r112.getApplication();
    L18:
        r108 = r109.g(r113, r107);
    L19:
        CharSequence r114 = r108;
    L21:
        o r115 = r110.d();
        if (r115 == null) goto L24;
        String r116 = r115.a();
    L25:
        boolean r117 = Intrinsics.areEqual(r110.h(), r103);
        o r118 = r110.e();
        if (r118 == null) goto L29;
        r101 = r118.a();
    L29:
        return new com.larus.login.api.i(null, null, r105, r114, r116, r101, r117, r100, r110.k(), r111, 13187);
    L24:
        r116 = null;
    L20:
        r114 = null;
        goto L21
    L8:
        r105 = null;
        goto L9
    }

    public final Object b(Continuation<? super Unit> r100) {
        if ((r100 instanceof ECommerceTextConfigRepository$fetchTextConfigMap$1) == false) goto L7;
        ECommerceTextConfigRepository$fetchTextConfigMap$1 r101 = (ECommerceTextConfigRepository$fetchTextConfigMap$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L17;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        ResultKt.throwOnFailure(r103);
    L51:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L23
    L21:
        Object r106 = Result.m9449constructorimpl((m) r103);     // Catch: Throwable -> L23
    L26:
        if (Result.m9455isFailureimpl(r106) == false) goto L28;
        r106 = null;
    L28:
        m r107 = (m) r106;
        if (r107 == null) goto L53;
        long r108 = System.currentTimeMillis();
        Object r109 = Result.m9449constructorimpl(b0.d());     // Catch: Throwable -> L33
    L36:
        if (Result.m9455isFailureimpl(r109) == false) goto L38;
        r109 = null;
    L38:
        String r110 = (String) r109;
        if (r110 != null) goto L41;
        r110 = "";
    L41:
        k.f357031a.getClass();
        Intrinsics.checkNotNullParameter(r110, CommonConstant.ReqAccessTokenParam.LANGUAGE_LABEL);
        if (StringsKt.isBlank(r110) == false) goto L44;
        r110 = "unknown";
    L44:
        String r111 = "ecom_text_config-".concat(r110);
        n r112 = new n(r108, r107);
        Intrinsics.checkNotNullParameter(r111, "cacheKey");
        Intrinsics.checkNotNullParameter(r112, "envelope");
        k.f357033c.put(r111, r112);
        r101.label = 2;
        Object r113 = BuildersKt.withContext(Dispatchers.getIO(), new ECommerceTextConfigCacheStore$storeDisk$2(r111, r112, null), r101);
        if (r113 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L48;
        r113 = Unit.INSTANCE;
    L48:
        if (r113 != r104) goto L51;
        return r104;
    L33:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L36
    L53:
        return Unit.INSTANCE;
    L17:
        ResultKt.throwOnFailure(r103);
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L23
        EcommerceApi r116 = EcommerceApi.f357018a;     // Catch: Throwable -> L23
        r101.label = 1;     // Catch: Throwable -> L23
        r103 = r116.c(null, r101);     // Catch: Throwable -> L23
        if (r103 != r104) goto L21;
        return r104;
    L23:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r101 = new ECommerceTextConfigRepository$fetchTextConfigMap$1(this, r100);
        goto L8
    }

    public final Object d(Continuation<? super com.larus.login.api.i> r100) {
        if ((r100 instanceof ECommerceTextConfigRepository$tryGetAuthWithCouponBinderBasicConfig$1) == false) goto L7;
        ECommerceTextConfigRepository$tryGetAuthWithCouponBinderBasicConfig$1 r101 = (ECommerceTextConfigRepository$tryGetAuthWithCouponBinderBasicConfig$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L20;
        if (r105 != 1) goto L19;
        String r106 = (String) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Exception -> L14 CancellationException -> L16
    L41:
        m r107 = (m) r103;     // Catch: Exception -> L14 CancellationException -> L16
        if (r107 == null) goto L46;
        Map<String, l> r108 = r107.b();     // Catch: Exception -> L14 CancellationException -> L16
        if (r108 == null) goto L46;
        l r109 = r108.get(ECommerceApiPath$EcommerceTextConfigScene.AuthWithCoupon.getValue());     // Catch: Exception -> L14 CancellationException -> L16
    L47:
        if (r109 == null) goto L49;
        b r110 = r109.a();     // Catch: Exception -> L14 CancellationException -> L16
    L50:
        if (r110 != null) goto L52;
        return null;
    L52:
        f357017b.put(r106, r109);     // Catch: Exception -> L14 CancellationException -> L16
    L61:
        return c(r109);
    L49:
        r110 = null;
    L46:
        r109 = null;
        goto L47
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        ResultKt.throwOnFailure(r103);
        if (f2.f365106a.r() == true) goto L57;
        return null;
    L57:
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L25
        Object r112 = Result.m9449constructorimpl(b0.d());     // Catch: Throwable -> L25
    L28:
        if (Result.m9455isFailureimpl(r112) == false) goto L30;
        r112 = null;
    L30:
        String r113 = (String) r112;
        if (r113 != null) goto L33;
        r113 = "";
    L33:
        l r114 = (l) ((LinkedHashMap) f357017b).get(r113);
        if (r114 != null) goto L36;
        EcommerceApi r115 = EcommerceApi.f357018a;     // Catch: Exception -> L14 CancellationException -> L16
        ECommerceApiPath$EcommerceTextConfigScene r116 = ECommerceApiPath$EcommerceTextConfigScene.AuthWithCoupon;     // Catch: Exception -> L14 CancellationException -> L16
        r101.L$0 = r113;     // Catch: Exception -> L14 CancellationException -> L16
        r101.label = 1;     // Catch: Exception -> L14 CancellationException -> L16
        Object r117 = r115.c(r116, r101);     // Catch: Exception -> L14 CancellationException -> L16
        if (r117 != r104) goto L40;
        return r104;
    L40:
        r106 = r113;
        r103 = r117;
        goto L41
    L36:
        return c(r114);
    L25:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L16:
        e = move-exception;
        throw e;
    L14:
        e = move-exception;
        FLogger.f375446a.e("ECommerceTextConfigRepo", "getAuthorizedCouponConfig failed", e);
        return null;
    L7:
        r101 = new ECommerceTextConfigRepository$tryGetAuthWithCouponBinderBasicConfig$1(this, r100);
        goto L8
    }

    public static com.larus.login.api.i a(Context r210, String r211, com.larus.login.api.i r212) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r212 == null) goto L148;
        boolean r100 = false;
        if (r212.f357052k == null) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == true) goto L148;
        boolean r102 = f2.f365106a.u();
        Integer r103 = null;
        if (r211 != null) goto L13;
    L82:
        l r104 = null;
    L83:
        if (r104 == null) goto L85;
        r100 = Intrinsics.areEqual(r104.i(), Boolean.TRUE);
    L85:
        if (r102 == true) goto L88;
        if (r100 == true) goto L88;
        return r212;
    L88:
        if (r102 == true) goto L91;
        r104 = null;
    L91:
        if (r100 == true) goto L94;
        r103 = r212.f357042a;
    L94:
        Integer r105 = r103;
        if (r104 == null) goto L101;
        o r106 = r104.c();
        if (r106 == null) goto L101;
        CharSequence r107 = r106.a();
        if (r107 == null) goto L101;
    L102:
        CharSequence r110 = r107;
        if (r104 == null) goto L112;
        o r108 = r104.j();
        if (r108 == null) goto L112;
        String r109 = r108.a();
        if (r109 == null) goto L112;
        if (Intrinsics.areEqual(r104.g(), Boolean.TRUE) == false) goto L111;
        CharSequence r111 = LoginService.f356989a.g(r210, r109);
    L113:
        CharSequence r112 = r111;
    L114:
        if (r104 == null) goto L120;
        o r113 = r104.d();
        if (r113 == null) goto L120;
        CharSequence r114 = r113.a();
        if (r114 == null) goto L120;
    L121:
        CharSequence r115 = r114;
        if (r104 == null) goto L126;
        Boolean r116 = r104.h();
        if (r116 == null) goto L126;
        boolean r117 = r116.booleanValue();
    L127:
        boolean r118 = r117;
        if (r104 == null) goto L134;
        o r119 = r104.e();
        if (r119 == null) goto L134;
        CharSequence r120 = r119.a();
        if (r120 == null) goto L134;
    L135:
        CharSequence r121 = r120;
        if (r104 == null) goto L140;
        Boolean r122 = r104.f();
        if (r122 == null) goto L140;
        boolean r123 = r122.booleanValue();
    L141:
        boolean r213 = r123;
        if (r104 == null) goto L145;
        String r124 = r104.b();
        if (r124 == null) goto L145;
    L147:
        return new com.larus.login.api.i(r105, r212.f357043b, r110, r112, r115, r121, r118, r212.f357049h, r212.f357050i, r212.f357051j, r212.f357052k, r212.f357053l, r213, r124, r212.f357056o);
    L145:
        r124 = r212.f357055n;
    L140:
        r123 = r212.f357054m;
    L134:
        r120 = r212.f357047f;
    L126:
        r117 = r212.f357048g;
    L120:
        r114 = r212.f357046e;
        goto L121
    L111:
        r112 = r109;
    L112:
        r111 = r212.f357045d;
    L101:
        r107 = r212.f357044c;
        goto L102
    L13:
        if ((!StringsKt.isBlank(r211)) == false) goto L15;
        String r125 = r211;
    L16:
        if (r125 == null) goto L82;
        Result.Companion r126 = Result.Companion;     // Catch: Throwable -> L19
        Object r127 = Result.m9449constructorimpl(b0.d());     // Catch: Throwable -> L19
    L22:
        if (Result.m9455isFailureimpl(r127) == false) goto L24;
        r127 = null;
    L24:
        String r128 = (String) r127;
        String r129 = "";
        if (r128 != null) goto L27;
        r128 = "";
    L27:
        k.f357031a.getClass();
        Intrinsics.checkNotNullParameter(r128, CommonConstant.ReqAccessTokenParam.LANGUAGE_LABEL);
        if (StringsKt.isBlank(r128) == false) goto L30;
        r128 = "unknown";
    L30:
        String r130 = "ecom_text_config-".concat(r128);
        Intrinsics.checkNotNullParameter(r130, "cacheKey");
        n r131 = k.f357033c.get(r130);
        if (r131 == null) goto L82;
        m r132 = r131.f357036b;
        if (r132 == null) goto L82;
        Map<String, String> r133 = r132.a();
        if (r133 == null) goto L82;
        String r134 = r133.get(r125);
        if (r134 == null) goto L82;
        Map<String, l> r135 = r131.f357036b.b();
        if (r135 == null) goto L42;
        r104 = r135.get(r134);
    L43:
        if (r104 != null) goto L83;
        Intrinsics.checkNotNullParameter(r130, "cacheKey");
        Object r136 = Result.m9449constructorimpl(((Keva) k.f357032b.getValue()).getString(r130, ""));     // Catch: Throwable -> L48
    L51:
        if (Result.m9455isFailureimpl(r136) == false) goto L53;
        r136 = null;
    L53:
        String r137 = (String) r136;
        if (r137 == null) goto L58;
        r129 = r137;
    L58:
        if (StringsKt.isBlank(r129) == false) goto L149;
        n r138 = null;
    L71:
        if (r138 == null) goto L82;
        k.f357031a.getClass();
        Intrinsics.checkNotNullParameter(r130, "cacheKey");
        Intrinsics.checkNotNullParameter(r138, "envelope");
        k.f357033c.put(r130, r138);
        m r139 = r138.f357036b;
        if (r139 == null) goto L82;
        Map<String, String> r140 = r139.a();
        if (r140 == null) goto L82;
        String r141 = r140.get(r125);
        if (r141 == null) goto L82;
        Map<String, l> r142 = r138.f357036b.b();
        if (r142 == null) goto L82;
        r104 = r142.get(r141);
        goto L83
    L149:
        Object r143 = Result.m9449constructorimpl((n) HttpExtKt.f360123f.fromJson(r129, k.f357034d));     // Catch: Throwable -> L62
    L64:
        Throwable r144 = Result.m9452exceptionOrNullimpl(r143);
        if (r144 == null) goto L68;
        FLogger.f375446a.w("ECommerceTextCfgCache", "getDisk parse failed, key=" + r130 + ", err=" + r144.getMessage());
    L68:
        if (Result.m9455isFailureimpl(r143) == false) goto L70;
        r143 = null;
    L70:
        r138 = (n) r143;
    L62:
        th = move-exception;
        Result.Companion r145 = Result.Companion;
        r143 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L48:
        th = move-exception;
        Result.Companion r146 = Result.Companion;
        r136 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L51
    L42:
        r104 = null;
    L19:
        th = move-exception;
        Result.Companion r147 = Result.Companion;
        r127 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L22
    L15:
        r125 = null;
        goto L16
    L7:
        r101 = false;
    L148:
        return r212;
    }
}

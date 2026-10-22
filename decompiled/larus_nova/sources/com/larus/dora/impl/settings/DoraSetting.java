package com.larus.dora.impl.settings;

import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.larus.common.apphost.AppHost;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.settings.value.e10;
import com.larus.settings.value.uk;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.TimeoutKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public final class DoraSetting {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DoraSetting f338023a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f338024b;

    static {
        f338023a = new DoraSetting();
    }

    public DoraSetting() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.os.SystemProperties");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.os.SystemProperties");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.os.SystemProperties");
    }

    public static DoraGOnboardingConfig c() {
        return (DoraGOnboardingConfig) com.larus.utils.l0.a(null, new y());
    }

    public static List d() {
        int r100 = com.larus.utils.l0.f375430a;
        return (List) com.larus.utils.l0.a(CollectionsKt.emptyList(), new d());
    }

    public static DoraPushSummaryConfig e() {
        int r100 = com.larus.utils.l0.f375430a;
        return (DoraPushSummaryConfig) com.larus.utils.l0.a(new DoraPushSummaryConfig(false, false, 3, null), new c());
    }

    public static boolean f() {
        if (com.larus.platform.service.n0.f365775a.b() == false) goto L6;
        g49.d.d("DoraSetting", "enableDoraFeature: false in enterprise mode");
        return false;
    L6:
        int r100 = com.larus.utils.l0.f375430a;
        if (((Boolean) com.larus.utils.l0.a(Boolean.TRUE, new a0())).booleanValue() == true) goto L9;
        CollectionsKt.listOf(new String[]{"inhouse", "local_test", "debug", "auto_test"}).contains(AppHost.f326268a.getBuildChannel());
        return false;
    L9:
        return true;
    }

    public static boolean g() {
        int r100 = com.larus.utils.l0.f375430a;
        return ((Boolean) com.larus.utils.l0.a(Boolean.FALSE, new t())).booleanValue();
    }

    public static boolean h() {
        int r100 = com.larus.utils.l0.f375430a;
        return ((Boolean) com.larus.utils.l0.a(Boolean.TRUE, new p())).booleanValue();
    }

    public static g1 i() {
        e10 r100 = e10.f368561a;
        int r101 = com.larus.utils.l0.f375430a;
        new nu9.u();
        nu9.t r102 = (nu9.t) com.larus.utils.l0.a(nu9.u.a(), new uk());
        Intrinsics.checkNotNullParameter(r102, "<this>");
        JsonElement r103 = r102.c();
        BigDecimal r104 = null;
        if (r103 != null) goto L5;
    L20:
        boolean r105 = true;
        if (r104 != null) goto L23;
        boolean r106 = true;
    L28:
        g1 r107 = new g1(r106, e1.a(e1.c(r102.b()), "2"), e1.a(e1.c(r102.a()), "6"), e1.b(e1.c(r102.e()), BDLocationException.ERROR_LIGHT_LOCATION_UPLOAD_LOCATION_INFO), e1.b(e1.c(r102.d()), BDLocationException.ERROR_SDK_NO_PERMISSION));
        g49.d.d("DoraSetting", "g2SilentOtaSettings: key=g2_silent_ota, raw=[featureEnabled=" + r102.c() + ", start=" + r102.b() + ", end=" + r102.a() + ", manualRearmDelayMinutes=" + r102.e() + ", installCooldownMinutes=" + r102.d() + "], effective=" + r107);
        return r107;
    L23:
        if (r104.compareTo(BigDecimal.ONE) == 0) goto L26;
        r105 = false;
    L26:
        r106 = r105;
        goto L28
    L5:
        if (r103.isJsonPrimitive() == true) goto L8;
        r103 = null;
    L8:
        if (r103 == null) goto L20;
        JsonPrimitive r108 = r103.getAsJsonPrimitive();
        if (r108 == null) goto L20;
        if (r108.isNumber() == true) goto L16;
        r108 = null;
    L16:
        if (r108 == null) goto L20;
        String r109 = r108.getAsString();
        if (r109 == null) goto L20;
        r104 = StringsKt.toBigDecimalOrNull(r109);
        goto L20
    }

    public static j1 j() {
        int r100 = com.larus.utils.l0.f375430a;
        return (j1) com.larus.utils.l0.a(new j1(), new z0());
    }

    public static h1 k() {
        return (h1) com.larus.utils.l0.a(new h1(0), new y0());
    }

    public static boolean l() {
        int r100 = com.larus.utils.l0.f375430a;
        return ((Boolean) com.larus.utils.l0.a(Boolean.FALSE, new e())).booleanValue();
    }

    public static boolean m() {
        int r100 = com.larus.utils.l0.f375430a;
        return ((Boolean) com.larus.utils.l0.a(Boolean.FALSE, new z())).booleanValue();
    }

    public static boolean n(String r100, List r101) {
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L38;
        List r103 = r101;
        if (r103 != null) goto L13;
    L16:
        boolean r104 = true;
    L17:
        if (r104 == true) goto L38;
        String r105 = StringsKt.trim(r100).toString().toLowerCase(Locale.ROOT);
        List r106 = r101;
        if ((r106 instanceof Collection) == true) goto L22;
    L24:
        Iterator r107 = r106.iterator();
    L26:
        if (r107.hasNext() == false) goto L36;
        String r108 = (String) r107.next();
        if (r108 == null) goto L32;
        String r109 = StringsKt.trim(r108).toString();
        if (r109 == null) goto L32;
        String r110 = r109.toLowerCase(Locale.ROOT);
    L34:
        if (Intrinsics.areEqual(r110, r105) == false) goto L26;
        return true;
    L32:
        r110 = null;
    L36:
        return false;
    L22:
        if (r106.isEmpty() == false) goto L24;
    L13:
        if (r103.isEmpty() == true) goto L16;
        r104 = false;
    L38:
        return false;
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r102 = false;
        goto L9
    }

    public static boolean o(Boolean r100, String r101, List r102) {
        if (Intrinsics.areEqual(r100, Boolean.TRUE) == true) goto L6;
        g49.d.a("DoraSetting", "shouldEnableFeature: enable is false or null, feature disabled");
        return false;
    L6:
        boolean r103 = n(r101, r102);
        g49.d.a("DoraSetting", "shouldEnableFeature: enable=true, socModel=<" + r101 + ">, inWhitelist=" + r103);
        return r103;
    }

    public final Object p(long r100, long r101, Continuation<? super Boolean> r102) {
        if ((r102 instanceof DoraSetting$waitForDoraSettingInit$1) == false) goto L7;
        DoraSetting$waitForDoraSettingInit$1 r103 = (DoraSetting$waitForDoraSettingInit$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        ResultKt.throwOnFailure(r105);
    L21:
        Boolean r108 = (Boolean) r105;
        if (r108 == null) goto L24;
        boolean r109 = r108.booleanValue();
    L26:
        return Boxing.boxBoolean(r109);
    L24:
        r109 = false;
        goto L26
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        if (f338024b == true) goto L17;
        DoraSetting$waitForDoraSettingInit$2 r110 = new DoraSetting$waitForDoraSettingInit$2(r101, null);
        r103.label = 1;
        r105 = TimeoutKt.c(r100, r110, r103);
        if (r105 != r106) goto L21;
        return r106;
    L17:
        return Boxing.boxBoolean(true);
    L7:
        r103 = new DoraSetting$waitForDoraSettingInit$1(this, r102);
        goto L8
    }

    public final <T> Object b(long r100, long r110, String r111, Function0<? extends T> r112, Continuation<? super T> r113) {
        if ((r113 instanceof DoraSetting$callAfterDoraSettingInitSuspend$1) == false) goto L7;
        DoraSetting$callAfterDoraSettingInitSuspend$1 r101 = (DoraSetting$callAfterDoraSettingInitSuspend$1) r113;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        DoraSetting$callAfterDoraSettingInitSuspend$1 r103 = r101;
        Object r114 = r103.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r103.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        r112 = (Function0) r103.L$1;
        r111 = (String) r103.L$0;
        ResultKt.throwOnFailure(r114);
    L18:
        if (((Boolean) r114).booleanValue() == false) goto L24;
        g49.d.d("DoraSetting", "callAfterDoraSettingInitSuspend tag=<" + r111 + "> : wait for DoraSetting init success");
        return r112.invoke();
    L22:
        e = move-exception;
        g49.d.c("DoraSetting", "callAfterDoraSettingInitSuspend tag=<" + r111 + "> : callback throw exception", e);
    L25:
        return null;
    L24:
        g49.d.d("DoraSetting", "callAfterDoraSettingInitSuspend tag=<" + r111 + "> : wait for DoraSetting init timeout");
        goto L25
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r114);
        r103.L$0 = r111;
        r103.L$1 = r112;
        r103.label = 1;
        r114 = p(r100, r110, r103);
        if (r114 != r104) goto L18;
        return r104;
    L7:
        r101 = new DoraSetting$callAfterDoraSettingInitSuspend$1(this, r113);
        goto L8
    }
}

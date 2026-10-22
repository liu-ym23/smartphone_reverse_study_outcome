package com.larus.dora.impl.core;

import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import com.larus.account.base.api.ILoginService;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.DoraPreWakeUpTask;
import com.larus.dora.impl.network.DoraNetworkApi;
import com.larus.platform.service.AccountService;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class DoraUserManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DoraUserManager f332169a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f332170b = null;

    public static final class a implements com.larus.platform.api.b {
        public a() {
        }

        @Override // com.larus.platform.api.b
        public final void a(com.larus.platform.api.c r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            g49.d.d("DoraUserManager", "accountStatusCallback onLogIn");
            i0.a.f332211a.i(4, null);
            DoraPreWakeUpTask.f331894j.post(new com.larus.dora.impl.m());
        }

        @Override // com.larus.platform.api.b
        public final void b(com.larus.platform.api.c r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            g49.d.d("DoraUserManager", "accountStatusCallback onLogout");
            DoraDevice r101 = DoraAdapterExtKt.h(kj4.a.g());
            int r102 = ak4.a.d().disConnect(r101, 2);
            StringBuilder r103 = new StringBuilder("disConnect ");
            if (r102 != 0) goto L5;
            String r104 = "success";
        L6:
            r103.append(r104);
            r103.append(", ret ");
            r103.append(r102);
            g49.d.d("DoraUserManager", r103.toString());
            return;
        L5:
            r104 = "fail";
            goto L6
        }
    }

    public DoraUserManager() {
    }

    static {
        f332169a = new DoraUserManager();
        f332170b = new a();
    }

    public static void a() {
        AccountService.f365697a.E(f332170b);
        if (kj4.a.g().getDoraBondCount() <= 0) goto L6;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DoraUserManager$syncUserSettings$1(null), 3, null);
    L6:
        AppHost.f326268a.a().j(new DoraUserManager$observeAppForeground$1());
    }

    public static boolean b() {
        String r100 = ILoginService.f286097a.getAccountInfo().f531530c;
        com.larus.dora.impl.util.b0.f338123a.getClass();
        return com.larus.dora.impl.util.b0.t(r100);
    }

    public final Object c(Continuation<? super Pair<Boolean, Boolean>> r100) {
        if ((r100 instanceof DoraUserManager$syncMultiUserModeState$1) == false) goto L7;
        DoraUserManager$syncMultiUserModeState$1 r101 = (DoraUserManager$syncMultiUserModeState$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        boolean r106 = true;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        String r107 = (String) r101.L$0;
        ResultKt.throwOnFailure(r103);
        Object r108 = ((Result) r103).m9458unboximpl();
    L19:
        if (Result.m9456isSuccessimpl(r108) == true) goto L84;
    L75:
        Object r109 = Result.m9449constructorimpl(r108);
    L76:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r109);
        if (r110 == null) goto L80;
        g49.d.c("DoraUserManager", "syncMultiUserModeState: exception", r110);
    L80:
        if (Result.m9452exceptionOrNullimpl(r109) == null) goto L86;
        com.larus.dora.impl.util.b0.f338123a.getClass();
        return new Pair(Boxing.boxBoolean(false), Boxing.boxBoolean(com.larus.dora.impl.util.b0.t(r107)));
    L86:
        return r109;
    L84:
        com.larus.dora.impl.network.f0 r111 = (com.larus.dora.impl.network.f0) r108;     // Catch: Throwable -> L73
        g49.d.d("DoraUserManager", "syncMultiUserModeState: userSettings=" + r111);     // Catch: Throwable -> L73
        com.larus.dora.impl.network.r r112 = r111.b();     // Catch: Throwable -> L73
        if (r112 == null) goto L28;
        Integer r113 = r112.a();     // Catch: Throwable -> L73
        if (r113 == null) goto L28;
        if (r113.intValue() != 1) goto L28;
        boolean r114 = true;
    L29:
        com.larus.dora.impl.network.g0 r115 = r111.d();     // Catch: Throwable -> L73
        if (r115 == null) goto L33;
        String r116 = r115.k();     // Catch: Throwable -> L73
        if (r116 == null) goto L33;
    L34:
        Integer r117 = StringsKt.toIntOrNull(r116);     // Catch: Throwable -> L73
        if (r117 == null) goto L37;
        int r118 = r117.intValue();     // Catch: Throwable -> L73
    L38:
        DoraDevice r119 = DoraAdapterExtKt.h(kj4.a.g());     // Catch: Throwable -> L73
        if (r119 == null) goto L41;
        Integer r120 = Boxing.boxInt(r119.productId);     // Catch: Throwable -> L73
    L43:
        if (o59.a.o(r120) == true) goto L51;
        int r121 = ProductNameType.DORA_E.f204375id;     // Catch: Throwable -> L73
        if (r120 != null) goto L48;
    L50:
        boolean r122 = false;
    L52:
        if (r122 == false) goto L56;
        if (r118 != 1) goto L55;
        r114 = true;
        goto L56
    L55:
        r114 = false;
    L56:
        com.larus.dora.impl.util.b0.f338123a.getClass();     // Catch: Throwable -> L73
        boolean r123 = com.larus.dora.impl.util.b0.t(r107);     // Catch: Throwable -> L73
        if (r123 == r114) goto L66;
        if (r114 == false) goto L60;
        boolean r124 = true;
    L61:
        com.larus.dora.impl.util.b0.E(r107, r124);     // Catch: Throwable -> L73
        Boolean r125 = Boxing.boxBoolean(true);     // Catch: Throwable -> L73
        if (r114 == true) goto L65;
        r106 = false;
    L65:
        Pair r126 = new Pair(r125, Boxing.boxBoolean(r106));     // Catch: Throwable -> L73
    L71:
        r109 = Result.m9449constructorimpl(r126);     // Catch: Throwable -> L73
        goto L76
    L60:
        r124 = false;
        goto L61
    L66:
        Boolean r127 = Boxing.boxBoolean(false);     // Catch: Throwable -> L73
        if (r123 == true) goto L70;
        r106 = false;
    L70:
        r126 = new Pair(r127, Boxing.boxBoolean(r106));     // Catch: Throwable -> L73
        goto L71
    L48:
        if (r120.intValue() != r121) goto L50;
    L51:
        r122 = true;
        goto L52
    L41:
        r120 = null;
        goto L43
    L37:
        r118 = 2;
    L33:
        r116 = "2";
    L28:
        r114 = false;
    L73:
        th = move-exception;
        Result.Companion r128 = Result.Companion;
        r108 = ResultKt.createFailure(th);
        goto L75
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        String r129 = ILoginService.f286097a.getAccountInfo().f531530c;
        DoraNetworkApi r130 = DoraNetworkApi.f336157a;
        r101.L$0 = r129;
        r101.label = 1;
        Object r131 = r130.v(true, r101);
        if (r131 != r104) goto L17;
        return r104;
    L17:
        r107 = r129;
        r108 = r131;
    L7:
        r101 = new DoraUserManager$syncMultiUserModeState$1(this, r100);
        goto L8
    }

    public static /* synthetic */ Object e(boolean r100, Continuation r101) {
        return f332169a.d(r100, 0, r101);
    }

    public final Object d(boolean r110, long r111, Continuation<? super Boolean> r210) {
        boolean r100 = r110;
        if ((r210 instanceof DoraUserManager$updateMultiUserModeState$1) == false) goto L7;
        DoraUserManager$updateMultiUserModeState$1 r101 = (DoraUserManager$updateMultiUserModeState$1) r210;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        DoraUserManager$updateMultiUserModeState$1 r112 = r101;
        Object r103 = r112.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r112.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        r100 = r112.Z$0;
        ResultKt.throwOnFailure(r103);
        Object r106 = ((Result) r103).m9458unboximpl();
    L77:
        if (Result.m9456isSuccessimpl(r106) == false) goto L79;
        ((Boolean) r106).booleanValue();
        g49.d.d("DoraUserManager", "updateMultiUserModeState: enable=" + r100 + " success");
        String r107 = ILoginService.f286097a.getAccountInfo().f531530c;
        com.larus.dora.impl.util.b0.f338123a.getClass();
        com.larus.dora.impl.util.b0.E(r107, r100);
        j49.b.i("multi_user_mode", r100, "success");
    L79:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r106);
        if (r108 == null) goto L82;
        g49.d.c("DoraUserManager", "updateMultiUserModeState: exception", r108);
        t39.c r109 = j49.b.f497374a;
        j49.b.i("multi_user_mode", r100, "failed(" + r108.getMessage() + ')');
    L82:
        Boolean r113 = Boxing.boxBoolean(false);
        if (Result.m9455isFailureimpl(r106) == true) goto L85;
        return r106;
    L85:
        return r113;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        DoraDevice r114 = DoraAdapterExtKt.h(kj4.a.g());
        String r115 = "";
        if (r114 == null) goto L18;
        String r116 = r114.modelVersion;
        if (r116 == null) goto L18;
    L19:
        if (r114 != null) goto L21;
    L23:
        boolean r117 = false;
    L24:
        if (r117 == true) goto L32;
        if (r114 == null) goto L27;
        Integer r118 = Boxing.boxInt(r114.productId);
    L29:
        if (o59.a.o(r118) == true) goto L32;
        boolean r119 = false;
    L33:
        int r120 = 2;
        if (r119 == false) goto L36;
        JSONObject r121 = new JSONObject();
    L42:
        if (r111 <= 0) goto L44;
        r121.put("expire_time", r111);
    L44:
        if (r119 == false) goto L49;
        JSONObject r122 = new JSONObject();
        if (r100 == false) goto L48;
        r120 = 1;
    L48:
        r122.put("pvad", String.valueOf(r120));
        JSONObject r123 = r122;
    L50:
        if (r119 == false) goto L72;
        JSONObject r124 = new JSONObject();
        if (r114 == null) goto L54;
        Object r125 = Boxing.boxInt(r114.productId);
    L55:
        r124.put("product_id", r125.toString());
        if (r114 == null) goto L59;
        String r126 = r114.typeName;
        if (r126 == null) goto L59;
    L60:
        r124.put("model_name", r126);
        if (r114 == null) goto L66;
        String r127 = r114.modelVersion;
        if (r127 == null) goto L66;
        r115 = r127;
    L66:
        r124.put("engine_version", r115);
        if (r114 == null) goto L70;
        String r128 = r114.softVersion;
        if (r128 == null) goto L70;
    L71:
        r124.put("fw_version", r128);
        JSONObject r129 = r124;
    L73:
        DoraNetworkApi r130 = DoraNetworkApi.f336157a;
        r112.Z$0 = r100;
        r112.label = 1;
        r106 = r130.H("multi_user_settings", r121, "extra_params", r123, r129, r112);
        if (r106 != r104) goto L77;
        return r104;
    L70:
        r128 = "none";
    L59:
        r126 = "OWS-Pro";
        goto L60
    L54:
        r125 = "";
        goto L55
    L72:
        r129 = null;
        goto L73
    L49:
        r123 = null;
        goto L50
    L36:
        JSONObject r131 = new JSONObject();
        r131.put("engine_version", r116);
        if (r100 == false) goto L39;
        int r132 = 1;
    L40:
        r131.put("multi_user_status", r132);
        r121 = r131;
        goto L42
    L39:
        r132 = 2;
        goto L40
    L27:
        r118 = null;
    L32:
        r119 = true;
        goto L33
    L21:
        if (r114.productId != ProductNameType.DORA_E.f204375id) goto L23;
        r117 = true;
    L18:
        r116 = "";
    L7:
        r101 = new DoraUserManager$updateMultiUserModeState$1(this, r210);
        goto L8
    }
}

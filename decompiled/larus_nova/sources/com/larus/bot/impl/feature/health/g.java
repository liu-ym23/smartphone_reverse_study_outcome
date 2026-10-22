package com.larus.bot.impl.feature.health;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.keva.Keva;
import com.google.gson.Gson;
import com.larus.bmhome.chat.component.bottom.t0;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.l0;
import com.larus.common_ui.dialog.m0;
import com.larus.im.bean.bot.BotModel;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.ServiceType;
import com.larus.network.http.y;
import com.larus.platform.service.AccountService;
import com.larus.setting.api.u;
import com.larus.settings.value.e10;
import com.larus.utils.e1;
import com.larus.vesdk.api.IVeSDK;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f319343a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Job f319344b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Job f319345c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Job f319346d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Job f319347e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static l0 f319348f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static m0 f319349g;

    static {
        f319343a = new g();
    }

    public g() {
    }

    public static void d(WeakReference r100) {
        if (r100 == null) goto L6;
        View r101 = (View) r100.get();
        if (r101 == null) goto L6;
        e1.o(r101);
    L6:
        m0 r102 = f319349g;
        if (r102 == null) goto L25;
        Handler r103 = DialogLancet.resolveDialogHandler(r102);
        if (r103 != null) goto L11;
    L13:
        DialogLancet.beforeDialogDismiss(r102);
        r102.dismiss();     // Catch: Throwable -> L16 Exception -> L18
    L22:
        DialogLancet.afterDialogDismiss(r102);
        goto L25
    L16:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r102);
        throw th;
    L18:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L16
        Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L16
        if (r104 == null) goto L22;
        com.bytedance.crash.d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L16
        goto L22
    L11:
        if (Looper.myLooper() == r103.getLooper()) goto L13;
        r103.post(DialogLancet.createDismissRunnable(r102));
    L25:
        Job r105 = f319346d;
        if (r105 == null) goto L28;
        Job.DefaultImpls.cancel$default(r105, null, 1, null);
    L28:
        f319349g = null;
        f319346d = null;
    }

    public static void e(WeakReference r100) {
        if (r100 == null) goto L6;
        View r101 = (View) r100.get();
        if (r101 == null) goto L6;
        e1.o(r101);
    L6:
        Job r102 = f319344b;
        if (r102 == null) goto L9;
        Job.DefaultImpls.cancel$default(r102, null, 1, null);
    L9:
        l0 r103 = f319348f;
        if (r103 == null) goto L28;
        Handler r104 = DialogLancet.resolveDialogHandler(r103);
        if (r104 != null) goto L14;
    L16:
        DialogLancet.beforeDialogDismiss(r103);
        r103.dismiss();     // Catch: Throwable -> L19 Exception -> L21
    L25:
        DialogLancet.afterDialogDismiss(r103);
        goto L28
    L21:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L19
        Throwable r105 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L19
        if (r105 == null) goto L25;
        com.bytedance.crash.d.d(r105, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r103);
        throw th;
    L14:
        if (Looper.myLooper() == r104.getLooper()) goto L16;
        r104.post(DialogLancet.createDismissRunnable(r103));
    L28:
        f319348f = null;
        f319344b = null;
    }

    public static JSONObject b(g r100, String r101) {
        r100.getClass();
        String r102 = u.f367928a;
        String r103 = String.valueOf(AppHost.f326268a.getAppId());
        Intrinsics.checkNotNullParameter(SliceInitService.DEFAULT_SWITCH, "params");
        Intrinsics.checkNotNullParameter("fpa_medical", "pluginName");
        Intrinsics.checkNotNullParameter("7411069252570120192", "botId");
        Intrinsics.checkNotNullParameter(r101, "funName");
        Intrinsics.checkNotNullParameter("7416241477438718015", "pluginID");
        Intrinsics.checkNotNullParameter(r103, "connectorId");
        JSONObject r104 = new JSONObject();
        r104.put("Parameters", SliceInitService.DEFAULT_SWITCH);
        r104.put("PluginName", "fpa_medical");
        r104.put("BotId", "7411069252570120192");
        r104.put("APIName", r101);
        r104.put("PluginID", "7416241477438718015");
        r104.put("ConnectorId", r103);
        return r104;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r1v10, types: [com.google.gson.Gson] */
    public static final Object a(g r110, f r111, Continuation r210) {
        r110.getClass();
        if ((r210 instanceof ChatHealthTipFragmentManager$fetchShouldShowDialog$1) == false) goto L7;
        ChatHealthTipFragmentManager$fetchShouldShowDialog$1 r100 = (ChatHealthTipFragmentManager$fetchShouldShowDialog$1) r210;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r112 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        Continuation r104 = null;
        if (r103 == 0) goto L23;
        if (r103 == 1) goto L22;
        if (r103 == 2) goto L21;
        if (r103 == 3) goto L17;
        if (r103 != 4) goto L16;
        ResultKt.throwOnFailure(r102);
    L50:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        Function2 r105 = (Function2) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Exception -> L20
    L20:
        Function2 r106 = r105;
        r104 = r104;
    L46:
        MainCoroutineDispatcher r107 = Dispatchers.getMain();
        ChatHealthTipFragmentManager$fetchShouldShowDialog$4 r108 = new ChatHealthTipFragmentManager$fetchShouldShowDialog$4(r106, r104);
        r100.L$0 = r104;
        r100.L$1 = r104;
        r100.label = 4;
        if (BuildersKt.withContext(r107, r108, r100) != r112) goto L50;
        return r112;
    L21:
        com.larus.network.http.a r109 = (com.larus.network.http.a) r100.L$1;
        r106 = (Function2) r100.L$0;
        ResultKt.throwOnFailure(r102);
        com.larus.network.http.a r113 = r109;
        r104 = r104;
    L33:
        if ((r113 instanceof y) == false) goto L50;
        zs9.g r114 = (zs9.g) ((y) r113).f360135b;     // Catch: Exception -> L45
        if (r114 == null) goto L37;
        ?? r115 = r114.a();     // Catch: Exception -> L45
    L38:
        if (r115 != 0) goto L40;
        r115 = "";
    L40:
        GetSafetyInstructionResponse r116 = (GetSafetyInstructionResponse) new Gson().fromJson(r115, GetSafetyInstructionResponse.class);     // Catch: Exception -> L45
        if (r116 == null) goto L50;
        MainCoroutineDispatcher r117 = Dispatchers.getMain();     // Catch: Exception -> L45
        ChatHealthTipFragmentManager$fetchShouldShowDialog$3$1 r118 = new ChatHealthTipFragmentManager$fetchShouldShowDialog$3$1(r116, r106, r104);     // Catch: Exception -> L45
        r100.L$0 = r106;     // Catch: Exception -> L45
        r100.L$1 = r104;     // Catch: Exception -> L45
        r100.label = 3;     // Catch: Exception -> L45
        if (BuildersKt.withContext(r117, r118, r100) != r112) goto L50;
        return r112;
    L37:
        r115 = r104;
        goto L38
    L22:
        Function2 r119 = (Function2) r100.L$0;
        ResultKt.throwOnFailure(r102);
        r106 = r119;
        Object r120 = r102;
        int r121 = 2;
    L27:
        r113 = (com.larus.network.http.a) r120;
        if ((r113 instanceof com.larus.network.http.f) == false) goto L33;
        MainCoroutineDispatcher r122 = Dispatchers.getMain();
        ChatHealthTipFragmentManager$fetchShouldShowDialog$2 r123 = new ChatHealthTipFragmentManager$fetchShouldShowDialog$2(r106, r104);
        r100.L$0 = r106;
        r100.L$1 = r113;
        r100.label = r121;
        if (BuildersKt.withContext(r122, r123, r100) != r112) goto L33;
        return r112;
    L23:
        ResultKt.throwOnFailure(r102);
        JSONObject r124 = b(r110, "safety_instruction");
        String r125 = u.f367934g;
        r100.L$0 = r111;
        r100.label = 1;
        r121 = 2;
        Object r126 = HttpExtKt.k(ServiceType.BASIC_SERVICE, zs9.g.class, r125, r124, null, null, false, null, null, null, r100, 1008);
        if (r126 == r112) goto L55;
        r120 = r126;
        r106 = r111;
        goto L27
    L55:
        return r112;
    L7:
        r100 = new ChatHealthTipFragmentManager$fetchShouldShowDialog$1(r110, r210);
        goto L8
    }

    public static void c(final t0 r100, final WeakReference r110, final FragmentManager r111, final BotModel r112) {
        Intrinsics.checkNotNullParameter(r100, "backListener");
        Intrinsics.checkNotNullParameter(r110, "view");
        Intrinsics.checkNotNullParameter(r111, "fragmentManager");
        Intrinsics.checkNotNullParameter(r112, "botModel");
        Function0 r101 = new e(r112, r100, r111, r110);
        String r113 = r112.getBotId();
        if (r113 != null) goto L5;
        r113 = "";
    L5:
        e10 r114 = e10.f368561a;
        List<String> r115 = e10.X().getHealthBotList();
        if (r115 == null) goto L13;
        Iterator<T> r116 = r115.iterator();
    L9:
        if (r116.hasNext() == false) goto L13;
        if (Intrinsics.areEqual(r113, (String) r116.next()) == false) goto L9;
        boolean r117 = true;
    L14:
        if (r117 == false) goto L18;
        IVeSDK r118 = (IVeSDK) ServiceManager.get().getService(IVeSDK.class);
        if (r118 == null) goto L18;
        r118.c();
    L18:
        if (r117 == false) goto L23;
        Keva r119 = h.f319350a;
        String r120 = AccountService.f365697a.getUserId();
        Intrinsics.checkNotNullParameter(r120, "uid");
        if (h.f319350a.getBoolean("have_agree_health".concat(r120), false) == true) goto L23;
        e(null);
        GlobalScope r121 = GlobalScope.INSTANCE;
        f319344b = BuildersKt.launch$default(r121, null, null, new ChatHealthTipFragmentManager$tryShowLoadingTask$1(null), 3, null);
        f319346d = BuildersKt.launch$default(r121, Dispatchers.getMain(), null, new ChatHealthTipFragmentManager$tryShowNoInteract$1(null), 2, null);
        f319345c = BuildersKt.launch$default(r121, null, null, new ChatHealthTipFragmentManager$judgeShouldShowDialog$1(r101, r110, r100, null), 3, null);
        return;
    L23:
        View r102 = (View) r110.get();
        if (r102 == null) goto L31;
        e1.o(r102);
        return;
    L31:
        return;
    L13:
        r117 = false;
        goto L14
    }
}

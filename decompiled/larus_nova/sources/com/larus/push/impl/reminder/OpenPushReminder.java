package com.larus.push.impl.reminder;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.keva.Keva;
import com.bytedance.sdk.account.utils.d;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.ServiceType;
import com.larus.network.http.f;
import com.larus.network.http.y;
import com.larus.platform.api.OpenPushReminderScene;
import com.larus.platform.api.s4;
import com.larus.platform.api.t4;
import com.larus.push.impl.o;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.MutexImpl;
import org.json.JSONObject;
import wc9.e;

/* JADX INFO: loaded from: classes4.dex */
public final class OpenPushReminder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OpenPushReminder f367101a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static OpenPushReminderConfig f367102b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, Map<String, Integer>> f367103c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, s4> f367104d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final MutexImpl f367105e = null;

    public OpenPushReminder() {
    }

    static {
        f367101a = new OpenPushReminder();
        f367103c = new LinkedHashMap();
        f367104d = new LinkedHashMap();
        f367105e = kotlinx.coroutines.sync.b.a();
    }

    public static void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Keva r101 = o.f367098a;
        if (o.b(AppHost.f326268a.getApplication()) == false) goto L6;
        FLogger.f375446a.i("OpenPushReminder", "fetchOpenPushReminderConfig[" + r100 + "] permission is already granted");
        return;
    L6:
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getMain().getImmediate(), null, new OpenPushReminder$fetchOpenPushReminderConfig$1(r100, null), 2, null);
    }

    public static void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sceneId");
        Keva r101 = o.f367098a;
        if (o.b(AppHost.f326268a.getApplication()) == false) goto L6;
        FLogger.f375446a.i("OpenPushReminder", "handlePendingScene permission is already granted, clear all");
        ((LinkedHashMap) f367104d).clear();
        return;
    L6:
        Map<String, s4> r102 = f367104d;
        r102.remove(r100);
        FLogger r103 = FLogger.f375446a;
        StringBuilder r104 = new StringBuilder("handlePendingScene ");
        r104.append(r100);
        r104.append(", new pendingScene = ");
        LinkedHashMap r105 = (LinkedHashMap) r102;
        r104.append(r105.keySet());
        r103.i("OpenPushReminder", r104.toString());
        String r106 = (String) CollectionsKt.firstOrNull(r105.keySet());
        if (r106 == null) goto L12;
        s4 r107 = r102.remove(r106);
        if (r107 == null) goto L13;
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new OpenPushReminder$handlePendingScene$2$1(r107, null), 3, null);
        return;
    L13:
        return;
    }

    public static void d(s4 r100, Function1 r101) {
        if (f367102b != null) goto L7;
        if (r101 == null) goto L41;
        r101.invoke(Boolean.FALSE);
        return;
    L41:
        return;
    L7:
        t4 r102 = r100.f365271b;
        if (r102 == null) goto L10;
        e r103 = r102.f365277a;
    L12:
        if (r103 != null) goto L17;
        FLogger.f375446a.e("OpenPushReminder", "tryRemindOpenPush without conversation");
        if (r101 == null) goto L42;
        r101.invoke(Boolean.FALSE);
        return;
    L42:
        return;
    L17:
        OpenPushReminderScene r104 = r100.f365270a;
        if (r104 != OpenPushReminderScene.LikeBot) goto L20;
    L23:
        if (r102 == null) goto L27;
        BotModel r105 = r102.f365278b;
        if (r105 == null) goto L27;
        String r106 = r105.getBotId();
    L28:
        if (r106 != null) goto L30;
    L33:
        boolean r107 = true;
    L34:
        if (r107 == false) goto L39;
        FLogger.f375446a.e("OpenPushReminder", "tryRemindOpenPush without botModel");
        if (r101 == null) goto L43;
        r101.invoke(Boolean.FALSE);
        return;
    L43:
        return;
    L39:
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getMain().getImmediate(), null, new OpenPushReminder$tryRemindOpenPush$1(r100, r101, null), 2, null);
        return;
    L30:
        if (r106.length() == 0) goto L33;
        r107 = false;
    L27:
        r106 = null;
        goto L28
    L20:
        if (r104 == OpenPushReminderScene.ChatWithBot) goto L23;
        if (r104 != OpenPushReminderScene.CreateBot) goto L39;
    L10:
        r103 = null;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object a(OpenPushReminder r110, s4 r111, Function1 r112, Continuation r113) {
        r110.getClass();
        if ((r113 instanceof OpenPushReminder$innerTryRemindOpenPush$1) == false) goto L7;
        OpenPushReminder$innerTryRemindOpenPush$1 r100 = (OpenPushReminder$innerTryRemindOpenPush$1) r113;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        OpenPushReminder$innerTryRemindOpenPush$1 r114 = r100;
        Object r102 = r114.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r114.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        Function1 r105 = (Function1) r114.L$1;
        s4 r106 = (s4) r114.L$0;
        ResultKt.throwOnFailure(r102);
        Object r107 = r102;
        Function1 r108 = r105;
    L25:
        com.larus.network.http.a r109 = (com.larus.network.http.a) r107;
        Ref.BooleanRef r115 = new Ref.BooleanRef();
        if ((r109 instanceof y) == false) goto L69;
        CheckSceneActionsResult r116 = (CheckSceneActionsResult) ((y) r109).f360135b;
        String r117 = null;
        if (r116 == null) goto L30;
        Boolean r118 = r116.getNeedShow();
    L31:
        FLogger r119 = FLogger.f375446a;
        r119.i("OpenPushReminder", "innerTryRemindOpenPush[" + r106.f365270a.getSceneId() + "] needShow = " + r118);
        if (Intrinsics.areEqual(r118, Boxing.boxBoolean(true)) == false) goto L73;
        OpenPushReminderConfig r120 = f367102b;
        if (r120 == null) goto L73;
        Map<String, OpenPushReminderSceneInfo> r121 = r120.getSceneInfo();
        if (r121 == null) goto L73;
        OpenPushReminderSceneInfo r122 = r121.get(r106.f365270a.getSceneId());
        if (r122 == null) goto L73;
        Activity r123 = d.b();
        if (r123 == null) goto L73;
        if ((r123 instanceof FragmentActivity) == true) goto L45;
        r123 = null;
    L45:
        if (r123 == null) goto L73;
        if ((r123 instanceof FragmentActivity) == false) goto L49;
        FragmentActivity r124 = (FragmentActivity) r123;
    L50:
        if (r124 == null) goto L73;
        Keva r125 = o.f367098a;
        if (o.b(AppHost.f326268a.getApplication()) == false) goto L54;
        r119.i("OpenPushReminder", "innerTryRemindOpenPush[" + r106.f365270a.getSceneId() + "] permission is already granted");
        goto L73
    L54:
        if (r124.getSupportFragmentManager().isStateSaved() == true) goto L73;
        Result.Companion r126 = Result.Companion;     // Catch: Throwable -> L65
        int r127 = OpenPushReminderDialog.f367106h;     // Catch: Throwable -> L65
        Intrinsics.checkNotNullParameter(r122, "sceneInfo");     // Catch: Throwable -> L65
        OpenPushReminderDialog r128 = new OpenPushReminderDialog();     // Catch: Throwable -> L65
        r128.f367108e = r122;     // Catch: Throwable -> L65
        r128.f367109f = r106;     // Catch: Throwable -> L65
        OpenPushReminderScene r129 = r106.f365270a;     // Catch: Throwable -> L65
        if (r129 == null) goto L58;
        r117 = r129.getSceneId();     // Catch: Throwable -> L65
    L58:
        r128.f367110g = r117;     // Catch: Throwable -> L65
        FragmentManager r130 = r124.getSupportFragmentManager();     // Catch: Throwable -> L65
        LandscapeRestrictionOperation r131 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Throwable -> L65
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r128, "OpenPushReminderDialog", r131);     // Catch: Throwable -> L65
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r130, r128, r131) == false) goto L80;
    L63:
        r115.element = true;     // Catch: Throwable -> L65
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L65
        goto L73
    L80:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L79 Throwable -> L65
    L62:
        r128.show(r130, "OpenPushReminderDialog");     // Catch: Throwable -> L65
    L65:
        th = move-exception;
        Result.Companion r132 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L73
    L49:
        r124 = null;
    L73:
        if (r115.element == true) goto L75;
        c(r106.f365270a.getSceneId());
    L75:
        if (r108 == null) goto L78;
        r108.invoke(Boxing.boxBoolean(r115.element));
    L78:
        return Unit.INSTANCE;
    L30:
        r118 = null;
        goto L31
    L69:
        if ((r109 instanceof f) == false) goto L71;
        FLogger.f375446a.e("OpenPushReminder", "innerTryRemindOpenPush server check failed, error = " + ((f) r109).f360157d.getMessage());
        goto L73
    L71:
        FLogger.f375446a.e("OpenPushReminder", "innerTryRemindOpenPush server check failed, unknown reason, async = " + r109);
        goto L73
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        JSONObject r133 = new JSONObject();
        r133.put("scene_id", r111.f365270a.getSceneId());
        JSONObject r134 = new JSONObject();
        t4 r135 = r111.f365271b;
        if (r135 == null) goto L20;
        BotModel r136 = r135.f365278b;
        if (r136 == null) goto L20;
        String r137 = r136.getBotId();
        if (r137 == null) goto L20;
    L21:
        r134.put("bot_id", r137);
        Unit r138 = Unit.INSTANCE;
        r133.put("event_info", r134);
        r114.L$0 = r111;
        r108 = r112;
        r114.L$1 = r108;
        r114.label = 1;
        r107 = HttpExtKt.k(ServiceType.BASIC_SERVICE, CheckSceneActionsResult.class, "/alice/notify/check_scene_actions", r133, null, null, false, null, null, null, r114, 1008);
        if (r107 == r103) goto L84;
        r106 = r111;
        goto L25
    L84:
        return r103;
    L20:
        r137 = "";
    L7:
        r100 = new OpenPushReminder$innerTryRemindOpenPush$1(r110, r113);
        goto L8
    }
}

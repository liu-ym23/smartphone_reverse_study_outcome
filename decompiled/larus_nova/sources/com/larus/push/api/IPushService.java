package com.larus.push.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.larus.platform.api.s4;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import ms9.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\u0003H&J*\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013H&J\u001a\u0010\u0014\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0015\u001a\u00020\nH&J\u001c\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u0010H&J\u0012\u0010\u0019\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0010H&J\u001c\u0010\u001a\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u0010H&J\b\u0010\u001b\u001a\u00020\u0010H&J\u0010\u0010\u001c\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001e0\u001dH&J&\u0010\u001f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H&J,\u0010$\u001a\u00020\u00032\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\u0016\b\u0002\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0018\u00010(H&¨\u0006)"}, d2 = {"Lcom/larus/push/api/IPushService;", "", "initAndStart", "", "asyncStartPush", "isNotificationPermissionGranted", "", "openSystemNotificationSetting", "applyRedBadgeCount", "count", "", "requestNotificationPermission", "trackClickPush", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "pushModel", "", "isFromNotification", "extra", "Lorg/json/JSONObject;", "onPushClick", "from", "trackPushProcessFail", "schema", "failReason", "trackPushProcessTouchRouter", "trackPushParamsValidateFail", "getPushContentType", "getPushActivityClazz", "Ljava/lang/Class;", "Landroid/app/Activity;", "showNotification", "intent", "Landroid/content/Intent;", ContainerPosition.BODY, "Lcom/larus/push/api/model/FlowNotificationBody;", "tryRemindOpenPush", "data", "Lcom/larus/platform/api/OpenPushReminderData;", "callback", "Lkotlin/Function1;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IPushService {
    void a();

    boolean b(Context r100, Intent r101, a r102);

    boolean c();

    void d(String r100, int r101);

    void e();

    void f(String r100);

    void g(String r100, String r101);

    void h();

    void i(String r100, String r101);

    String j();

    void k(Context r100, String r101, JSONObject r102);

    void l(s4 r100, Function1<? super Boolean, Unit> r101);

    Class<? extends Activity> m();

    void n(int r100);

    void requestNotificationPermission();
}

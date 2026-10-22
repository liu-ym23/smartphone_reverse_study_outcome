package com.bytedance.notification;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.Toast;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.android.service.manager.push.notification.PushNotificationButtonInfo;
import com.bytedance.push.utils.f;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public class NotificationButtonClickBroadcastReceiver extends BroadcastReceiver {
    public NotificationButtonClickBroadcastReceiver() {
    }

    public final void a(int r100, PushNotificationButtonInfo r101) {
        JSONObject r102 = new JSONObject();
        r102.put("id", r100);     // Catch: JSONException -> L5
        r102.put("button_info", r101.toJsonForEventV3());     // Catch: JSONException -> L5
    L7:
        PushServiceManager.get().getPushExternalService().getMultiProcessEventSenderService().onEventV3("bdpush_notification_button_click", r102);
        return;
    L5:
        e = move-exception;
        f.e(getClass().getSimpleName(), e.getMessage());
        goto L7
    }

    public final void b(int r100, String r101) {
        JSONObject r102 = new JSONObject();
        r102.put("id", r100);     // Catch: JSONException -> L5
        r102.put("button_info", r101);     // Catch: JSONException -> L5
    L7:
        PushServiceManager.get().getPushExternalService().getMultiProcessEventSenderService().onEventV3("bdpush_notification_button_click", r102);
        return;
    L5:
        e = move-exception;
        f.e(getClass().getSimpleName(), e.getMessage());
        goto L7
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        PushNotificationButtonInfo r102 = (PushNotificationButtonInfo) r101.getParcelableExtra("button_info");     // Catch: Exception -> L17
        int r103 = r101.getIntExtra("id", 0);     // Catch: Exception -> L17
        String r104 = r101.getStringExtra("tag");     // Catch: Exception -> L17
        NotificationManager r105 = (NotificationManager) r100.getSystemService("notification");     // Catch: Exception -> L17
        if (r105 != null) goto L6;
    L8:
        if (r102 != null) goto L10;
        b(r103, "null");     // Catch: Exception -> L17
        return;
    L10:
        f.b(getClass().getSimpleName(), "onReceive() id: " + r103 + "Toast: " + r102.mButtonToast);     // Catch: Exception -> L17
        String r106 = r102.mButtonToast;     // Catch: Exception -> L17
        if (r106 != null) goto L13;
    L15:
        a(r103, r102);     // Catch: Exception -> L17
        return;
    L13:
        if (r106.isEmpty() == true) goto L15;
        Toast.makeText(r100, r106, 1).show();     // Catch: Exception -> L17
        goto L15
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L8;
        r105.cancel(r104, r103);     // Catch: Exception -> L17
    L17:
        e = move-exception;
        f.e(getClass().getSimpleName(), e.getMessage());
        b(0, "error");
    }
}

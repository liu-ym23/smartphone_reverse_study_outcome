package com.bytedance.push.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.push.BaseJson;
import com.ss.android.message.AppProvider;
import com.ss.android.message.util.ToolUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class k extends BaseJson {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Notification f266968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f266969b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ComponentName f266970c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f266971d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f266972e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f266973f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f266974g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f266975h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<String> f266976i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f266977j;

    public final Map<String, Object> b() throws IllegalAccessException {
        Field[] r100 = this.f266968a.getClass().getDeclaredFields();
        HashMap r101 = new HashMap();
        StringBuilder r102 = new StringBuilder("\n");
        int r103 = r100.length;
        int r104 = 0;
    L4:
        if (r104 >= r103) goto L34;
        Field r105 = r100[r104];
        if (Modifier.isFinal(r105.getModifiers()) == true) goto L33;
        if (Modifier.isStatic(r105.getModifiers()) == true) goto L33;
        r105.setAccessible(true);
        if (TextUtils.equals(r105.getName(), "extras") == false) goto L27;
        Bundle r106 = this.f266968a.extras;
        if (r106 == null) goto L33;
        Iterator<String> r107 = r106.keySet().iterator();
    L16:
        if (r107.hasNext() == false) goto L33;
        String r110 = r107.next();
        List<String> r111 = this.f266976i;
        if (r111 == null) goto L22;
        if (r111.contains(r110) == false) goto L22;
        com.bytedance.push.utils.f.b("NotificationEvent", String.format("filter filed extras.%s", new Object[]{r110}));
    L22:
        Object[] r112 = new Object[3];
        r112[0] = r110;
        r112[1] = r106.get(r110);
        if (r106.get(r110) == null) goto L25;
        Object r113 = r106.get(r110).getClass();
    L26:
        r112[2] = r113;
        r102.append(String.format("extra.%s:%s:%s\n", r112));
        r101.put(String.format("extra.%s", new Object[]{r110}), r106.get(r110));
        goto L16
    L25:
        r113 = "null";
        goto L26
    L27:
        List<String> r108 = this.f266976i;
        if (r108 != null) goto L30;
    L32:
        r102.append(String.format("%s:%s:%s\n", new Object[]{r105.getName(), r105.get(this.f266968a), r105.getType()}));
        r101.put(r105.getName(), r105.get(this.f266968a));
        goto L33
    L30:
        if (r108.contains(r105.getName()) == false) goto L32;
        com.bytedance.push.utils.f.b("NotificationEvent", String.format("filter filed %s", new Object[]{r105.getName()}));
    L33:
        r104 = r104 + 1;
        goto L4
    L34:
        com.bytedance.push.utils.f.b("NotificationEvent", r102.toString());
        return r101;
    }

    public final JSONObject c() {
        JSONObject r100 = new JSONObject();
        add(r100, Constants.Keys.KEY_CLIENT_TIME, this.f266971d);
        add(r100, "notification_type", this.f266969b);
        ComponentName r101 = this.f266970c;
        if (r101 != null) goto L5;
        add(r100, "component", "null");
    L7:
        if (TextUtils.isEmpty(this.f266974g) == true) goto L10;
        add(r100, "target_text_reg", this.f266974g);
    L10:
        if (TextUtils.isEmpty(this.f266977j) == true) goto L12;
        add(r100, "op_pkg", this.f266977j);
    L12:
        NotificationManager r102 = (NotificationManager) AppProvider.getApp().getSystemService("notification");
        boolean r103 = true;
        if (Build.VERSION.SDK_INT < 26) goto L23;
        NotificationChannel r104 = r102.getNotificationChannel(this.f266968a.getChannelId());
        if (r104 != null) goto L18;
        add(r100, "channel_is_open", false);
        goto L23
    L18:
        if (r104.getImportance() <= 0) goto L20;
        boolean r105 = true;
    L21:
        add(r100, "channel_is_open", r105);
        add(r100, "channel_importance", r104.getImportance());
        goto L23
    L20:
        r105 = false;
    L23:
        if (ToolUtils.areNotificationsEnabled(AppProvider.getApp()) > 0) goto L26;
        r103 = false;
    L26:
        add(r100, "push_is_open", r103);
        add(r100, LocationMonitorConst.IS_VALID, this.f266972e);
        add(r100, "is_target_notification", this.f266973f);
        add(r100, "stack", this.f266975h);
        add(r100, "process", ToolUtils.getCurProcessNameSuffix(AppProvider.getApp()));
        HashSet r106 = new HashSet();     // Catch: IllegalAccessException -> L46
        Iterator r107 = ((HashMap) b()).entrySet().iterator();     // Catch: IllegalAccessException -> L46
    L29:
        if (r107.hasNext() == false) goto L41;
        Map.Entry r108 = (Map.Entry) r107.next();     // Catch: IllegalAccessException -> L46
        if (r108.getValue() != null) goto L33;
        String r109 = "null";
    L40:
        add(r100, (String) r108.getKey(), r109);     // Catch: IllegalAccessException -> L46
        goto L29
    L33:
        if ((r108.getValue() instanceof PendingIntent) == false) goto L38;
        PendingIntent r110 = (PendingIntent) r108.getValue();     // Catch: IllegalAccessException -> L46
        r109 = NotificationShowMonitor.inst().getContentIntentFromPendingIntent(r110);     // Catch: IllegalAccessException -> L46
        if (TextUtils.isEmpty(r109) == true) goto L37;
        r106.add(r110);     // Catch: IllegalAccessException -> L46
        goto L40
    L37:
        r109 = String.valueOf(r108.getValue());     // Catch: IllegalAccessException -> L46
        goto L40
    L38:
        r109 = String.valueOf(r108.getValue());     // Catch: IllegalAccessException -> L46
        goto L40
    L41:
        Iterator r111 = r106.iterator();     // Catch: IllegalAccessException -> L46
    L42:
        if (r111.hasNext() == false) goto L48;
        NotificationShowMonitor.inst().removeContentIntent((PendingIntent) r111.next());     // Catch: IllegalAccessException -> L46
    L48:
        return r100;
    L46:
        e = move-exception;
        e.printStackTrace();
        goto L48
    L5:
        add(r100, "component", r101.toShortString());
        goto L7
    }

    public k(Notification r100, ComponentName r101, List r102) {
        this.f266969b = 1;
        this.f266972e = true;
        this.f266973f = false;
        this.f266968a = r100;
        this.f266969b = 2;
        this.f266970c = r101;
        this.f266971d = System.currentTimeMillis();
        this.f266976i = r102;
    }

    public k(Notification r100, int r101, List<String> r102) {
        this.f266969b = 1;
        this.f266972e = true;
        this.f266973f = false;
        this.f266968a = r100;
        this.f266969b = r101;
        this.f266971d = System.currentTimeMillis();
        this.f266976i = r102;
    }
}

package com.bytedance.push.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.settings.LocalFrequencySettings;
import com.ss.android.message.util.ToolUtils;
import com.tencent.open.SocialConstants;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f266961a = null;

    public static class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public NotificationManager f266962a;

        @Override // com.bytedance.push.notification.i.b
        public void c(Context r100, y67.d r101) {
        }

        public a() {
            this.f266962a = null;
        }

        @Override // com.bytedance.push.notification.i.b
        public JSONArray b(Context r100) {
            return new JSONArray();
        }

        @Override // com.bytedance.push.notification.i.b
        public boolean a(Context r100, int r101) {
            if (ToolUtils.areNotificationsEnabled(r100) == r101) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.bytedance.push.notification.i.b
        public void d(Context r100, y67.d r101) {
            com.bytedance.push.c r102 = PushSupporter.get().getConfiguration();
            if (r102 == null) goto L5;
            com.bytedance.push.notification.c r103 = r102.C;
        L6:
            com.bytedance.push.utils.a.a(r100, r103, r101.f566386k, r101.f566378c, null);
            return;
        L5:
            r103 = null;
            goto L6
        }
    }

    public interface b {
        boolean a(Context r100, int r101);

        JSONArray b(Context r100);

        void c(Context r100, y67.d r101);

        void d(Context r100, y67.d r101);
    }

    public static class c extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<NotificationChannel> f266963b;

        public c() {
        }

        @Override // com.bytedance.push.notification.i.a, com.bytedance.push.notification.i.b
        public final JSONArray b(Context r110) {
            List<NotificationChannel> r111 = e(r110);
            JSONArray r100 = new JSONArray();
            if (r111 == null) goto L13;
            Iterator<NotificationChannel> r112 = r111.iterator();
        L7:
            if (r112.hasNext() == false) goto L13;
            NotificationChannel r101 = r112.next();
            String r102 = r101.getId();     // Catch: JSONException -> L11
            String r103 = String.valueOf(r101.getName());     // Catch: JSONException -> L11
            int r104 = r101.getImportance();     // Catch: JSONException -> L11
            boolean r105 = r101.canBypassDnd();     // Catch: JSONException -> L11
            int r106 = r101.getLockscreenVisibility();     // Catch: JSONException -> L11
            boolean r107 = r101.shouldShowLights();     // Catch: JSONException -> L11
            boolean r108 = r101.shouldVibrate();     // Catch: JSONException -> L11
            boolean r109 = r101.canShowBadge();     // Catch: JSONException -> L11
            String r113 = r101.getDescription();     // Catch: JSONException -> L11
            JSONObject r114 = new JSONObject();     // Catch: JSONException -> L11
            JSONObject r115 = new JSONObject();     // Catch: JSONException -> L11
            r115.put("id", r102);     // Catch: JSONException -> L11
            r115.put("name", r103);     // Catch: JSONException -> L11
            r115.put("importance", r104);     // Catch: JSONException -> L11
            r115.put("bypassDnd", r105);     // Catch: JSONException -> L11
            r115.put("lockscreenVisibility", r106);     // Catch: JSONException -> L11
            r115.put("lights", r107);     // Catch: JSONException -> L11
            r115.put("vibration", r108);     // Catch: JSONException -> L11
            r115.put("showBadge", r109);     // Catch: JSONException -> L11
            r115.put("enable", true);     // Catch: JSONException -> L11
            r115.put(SocialConstants.PARAM_APP_DESC, r113);     // Catch: JSONException -> L11
            r115.put("channel_fields", r114);     // Catch: JSONException -> L11
            r100.put(r115);     // Catch: JSONException -> L11
        L11:
            e = move-exception;
            e.printStackTrace();
        L13:
            return r100;
        }

        public final List<NotificationChannel> e(Context r100) {
            List<NotificationChannel> r101 = this.f266963b;
            if (r101 != null) goto L5;
        L12:
            this.f266963b = ((NotificationManager) r100.getSystemService(NotificationManager.class)).getNotificationChannels();     // Catch: Throwable -> L8
        L11:
            return this.f266963b;
        L8:
            th = move-exception;
            th.printStackTrace();
            this.f266963b = Collections.emptyList();
            goto L11
        L5:
            if (r101.isEmpty() == false) goto L11;
            goto L12
        }

        public static boolean f(List<NotificationChannel> r100, Map<String, y67.d> r101) {
            if (r100.size() == r101.size()) goto L5;
            return false;
        L5:
            Iterator<NotificationChannel> r102 = r100.iterator();
        L7:
            if (r102.hasNext() == false) goto L26;
            NotificationChannel r103 = r102.next();
            y67.d r104 = r101.get(r103.getId());
            if (r104 == null) goto L10;
            if (r104.f566380e != r103.getImportance()) goto L13;
            if (r104.f566382g != r103.getLockscreenVisibility()) goto L16;
            if (r104.f566381f != r103.canBypassDnd()) goto L19;
            if (r104.f566383h != r103.shouldShowLights()) goto L22;
            if (r104.f566384i == r103.shouldVibrate()) goto L7;
            return false;
        L22:
            return false;
        L19:
            return false;
        L16:
            return false;
        L13:
            return false;
        L10:
            return false;
        L26:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r8v6, types: [java.util.HashMap] */
        /* JADX WARN: Type inference failed for: r8v7, types: [java.util.Map] */
        /* JADX WARN: Type inference failed for: r8v9, types: [java.util.Map] */
        @Override // com.bytedance.push.notification.i.a, com.bytedance.push.notification.i.b
        public final boolean a(Context r100, int r101) {
            if (super.a(r100, r101) == false) goto L25;
            return true;
        L25:
            List<NotificationChannel> r102 = e(r100);     // Catch: JSONException -> L21
            String r103 = ((LocalFrequencySettings) j77.i.a(r100, LocalFrequencySettings.class)).m0();     // Catch: JSONException -> L21
            if (TextUtils.isEmpty(r103) == false) goto L12;
            if (r102 != null) goto L10;
        L23:
            return false;
        L10:
            if (r102.isEmpty() == true) goto L23;
            return true;
        L12:
            JSONArray r104 = new JSONArray(r103);     // Catch: JSONException -> L21
            if (r104.length() != 0) goto L15;
            ?? r105 = Collections.emptyMap();     // Catch: JSONException -> L21
        L28:
            return true ^ f(r102, r105);
        L15:
            r105 = new HashMap(r104.length());     // Catch: JSONException -> L21
            int r106 = 0;
        L17:
            if (r106 >= r104.length()) goto L28;
            JSONObject r107 = r104.optJSONObject(r106);     // Catch: JSONException -> L21
            r105.put(r107.optString("id"), new y67.d(r107));     // Catch: JSONException -> L21
            r106 = r106 + 1;     // Catch: JSONException -> L21
        L21:
            e = move-exception;
            e.printStackTrace();
            goto L23
        }

        @Override // com.bytedance.push.notification.i.a, com.bytedance.push.notification.i.b
        public final void c(Context r100, y67.d r101) {
            if (this.f266962a != null) goto L5;
            this.f266962a = (NotificationManager) r100.getSystemService("notification");
        L5:
            NotificationManager r102 = this.f266962a;
            if (r102 != null) goto L9;
            return;
        L9:
            if (TextUtils.isEmpty(r101.f566378c) == false) goto L12;
            return;
        L12:
            if (r102.getNotificationChannel(r101.f566378c) != null) goto L14;
            return;
        L14:
            r102.deleteNotificationChannel(r101.f566378c);
        }

        @Override // com.bytedance.push.notification.i.a, com.bytedance.push.notification.i.b
        public final void d(Context r100, y67.d r101) {
            if (this.f266962a != null) goto L5;
            this.f266962a = (NotificationManager) r100.getSystemService("notification");
        L5:
            NotificationManager r102 = this.f266962a;
            if (r102 != null) goto L9;
            return;
        L9:
            if (TextUtils.isEmpty(r101.f566378c) == false) goto L11;
            return;
        L11:
            if (TextUtils.isEmpty(r101.f566379d) == false) goto L14;
            return;
        L14:
            if (r102.getNotificationChannel(r101.f566378c) == null) goto L16;
            return;
        L16:
            int r103 = r101.f566380e;
            if (r103 >= 0) goto L19;
        L20:
            r103 = 3;
        L21:
            NotificationChannel r104 = new NotificationChannel(r101.f566378c, r101.f566379d, r103);
            r104.setShowBadge(r101.f566385j);
            r104.setDescription(r101.f566376a);
            r104.enableVibration(r101.f566384i);
            r104.setBypassDnd(r101.f566381f);
            r104.enableLights(r101.f566383h);
            r104.setLockscreenVisibility(r101.f566382g);
            Iterator<String> r105 = r101.f566387l.keys();
        L22:
            boolean r106 = true;
            if (r105.hasNext() == false) goto L30;
            String r107 = r105.next();
            Object r108 = r101.f566387l.opt(r107);
            if (r108 == null) goto L22;
            Method r109 = com.bytedance.push.utils.b.f267052a;
            Field r110 = com.bytedance.push.utils.b.e(r104.getClass(), r107);     // Catch: Throwable -> L29
            r110.setAccessible(true);     // Catch: Throwable -> L29
            r110.set(r104, r108);     // Catch: Throwable -> L29
            goto L22
        L30:
            String r111 = r101.f566386k;
            com.bytedance.push.c r112 = PushSupporter.get().getConfiguration();
            if (r112 == null) goto L33;
            com.bytedance.push.notification.c r113 = r112.C;
        L35:
            if (com.bytedance.push.utils.a.a(r100, r113, r111, r104.getId(), new j(this, r104, r100, r102)) == true) goto L45;
            if (r112 == null) goto L44;
            int[] r114 = r112.D;
            int r115 = com.bytedance.push.utils.a.b(r104.getId(), r114, r111);
            if (r115 == (-1)) goto L44;
            r104.setSound(com.bytedance.push.utils.a.c(r100, r115), Notification.AUDIO_ATTRIBUTES_DEFAULT);
            r102.createNotificationChannel(r104);     // Catch: Throwable -> L43
        L44:
            r106 = false;
        L45:
            if (r106 == false) goto L50;
            return;
        L50:
            r102.createNotificationChannel(r104);     // Catch: Throwable -> L49
            return;
        L64:
            return;
        L33:
            r113 = null;
            goto L35
        L19:
            if (r103 <= 5) goto L21;
            goto L20
        }
    }

    static {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        f266961a = new c();
        return;
    L5:
        f266961a = new a();
    }
}

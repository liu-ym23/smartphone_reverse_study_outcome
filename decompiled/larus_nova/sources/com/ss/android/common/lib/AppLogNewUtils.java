package com.ss.android.common.lib;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.applog.util.BlockHelper;
import com.bytedance.common.utility.StringUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.common.applog.AppLog;
import com.ss.android.common.applog.k0;
import ita.j;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class AppLogNewUtils {
    public static final String EVENT_LABEL_TEST = "click_headline";
    public static final String EVENT_RESERVED_FIELD_TIME_STAMP = "event_v3_reserved_field_time_stamp";
    public static final String EVENT_SIGN = "_event_v3";
    public static final String EVENT_TAG_TEST1 = "go_detail";
    public static final String EVENT_TAG_TEST2 = "video_play";
    public static final String EVENT_V3_CATEGORY = "event_v3";
    private static final String SECOND_APP_ID_KEY = "second_appid";
    private static final String SECOND_APP_NAME_KEY = "second_appname";
    private static final String SECOND_APP_PREFIX = "second_app_";
    private static final String SECOND_APP_PRODUCT_TYPE_KEY = "product_type";
    private static final String SECOND_APP_SPECIAL_KEY = "params_for_special";
    private static final String SECOND_APP_VALUE = "second_app";

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f408250a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f408251b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f408252c;

        public final void a() {
            BlockHelper.tryBlock();
            if (StringUtils.isEmpty(this.f408250a) == false) goto L5;
            return;
        L5:
            JSONObject r100 = this.f408251b;
            if (r100 != null) goto L8;
            r100 = new JSONObject();
        L8:
            JSONObject r101 = r100;
            r101.put("_event_v3", 1);     // Catch: JSONException -> L13
            r101.put(AppLogNewUtils.EVENT_RESERVED_FIELD_TIME_STAMP, this.f408252c);     // Catch: JSONException -> L13
            String r102 = AppLog.n();     // Catch: JSONException -> L13
            if (TextUtils.isEmpty(r102) == true) goto L15;
            r101.put("ab_sdk_version", r102);     // Catch: JSONException -> L13
        L15:
            AppLog.E(null, "event_v3", this.f408250a, null, 0, 0, r101);
            return;
        L13:
            e = move-exception;
            e.printStackTrace();
            goto L15
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(String r100, JSONObject r101, long r102) {
            this.f408250a = r100;
            this.f408251b = r101;
            this.f408252c = r102;
        }
    }

    /* JADX INFO: loaded from: classes34.dex */
    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f408253a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f408254b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f408255c;

        public final void a() {
            BlockHelper.tryBlock();
            this.f408253a.put("_event_v3", 1);     // Catch: JSONException -> L7
            this.f408253a.put(AppLogNewUtils.EVENT_RESERVED_FIELD_TIME_STAMP, this.f408254b);     // Catch: JSONException -> L7
            String r100 = AppLog.n();     // Catch: JSONException -> L7
            if (TextUtils.isEmpty(r100) == true) goto L9;
            this.f408253a.put("ab_sdk_version", r100);     // Catch: JSONException -> L7
        L9:
            AppLog.E(null, "event_v3", this.f408255c, null, 0, 0, this.f408253a);
            return;
        L7:
            e = move-exception;
            e.printStackTrace();
            goto L9
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(JSONObject r100, long r101, String r102) {
            this.f408253a = r100;
            this.f408254b = r101;
            this.f408255c = r102;
        }
    }

    /* JADX INFO: loaded from: classes34.dex */
    public static class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f408256a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f408257b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Bundle f408258c;

        public final void a() {
            if (StringUtils.isEmpty(this.f408256a) == false) goto L5;
            return;
        L5:
            JSONObject r100 = new JSONObject();
            r100.put("_event_v3", 1);     // Catch: Throwable -> L16
            r100.put(AppLogNewUtils.EVENT_RESERVED_FIELD_TIME_STAMP, this.f408257b);     // Catch: Throwable -> L16
            Bundle r101 = this.f408258c;     // Catch: Throwable -> L16
            if (r101 == null) goto L12;
            Iterator<String> r102 = r101.keySet().iterator();     // Catch: Throwable -> L16
        L10:
            if (r102.hasNext() == false) goto L12;
            String r103 = r102.next();     // Catch: Throwable -> L16
            r100.put(r103, this.f408258c.get(r103));     // Catch: Throwable -> L16
        L12:
            String r104 = AppLog.n();     // Catch: Throwable -> L16
            if (TextUtils.isEmpty(r104) == true) goto L18;
            r100.put("ab_sdk_version", r104);     // Catch: Throwable -> L16
        L18:
            AppLog.E(null, "event_v3", this.f408256a, null, 0, 0, r100);
            return;
        L16:
            th = move-exception;
            th.printStackTrace();
            goto L18
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(String r100, long r101, Bundle r102) {
            this.f408256a = r100;
            this.f408257b = r101;
            this.f408258c = r102;
        }
    }

    public AppLogNewUtils() {
    }

    public static JSONObject copyJson(JSONObject r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        LinkedList r101 = new LinkedList();
        Iterator<String> r102 = r100.keys();
    L7:
        if (r102.hasNext() == false) goto L14;
        r101.add(r102.next());
        goto L7
    L14:
        return new JSONObject(r100, (String[]) r101.toArray(new String[0]));
    L11:
        e = move-exception;
        e.printStackTrace();
        return r100;
    }

    private static boolean isEmptyMap(Map<String, String> r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (r100.isEmpty() == true) goto L7;
        return false;
    }

    public static void onEventV3(String r100, JSONObject r101) {
        onEventV3ByConstParams(r100, copyJson(r101));
    }

    public static void onEventV3Bundle(String r100, Bundle r101) {
        long r102 = System.currentTimeMillis();
        k0.d().b(new c(r100, r102, r101));
    }

    public static void onEventV3ByConstParams(String r100, JSONObject r101) {
        long r102 = System.currentTimeMillis();
        k0.d().b(new a(r100, r101, r102));
    }

    public static void onEventV3Map(String r100, Map<String, String> r101) {
        if (StringUtils.isEmpty(r100) == false) goto L6;
        return;
    L6:
        if (isEmptyMap(r101) == false) goto L8;
        JSONObject r102 = new JSONObject();
    L9:
        long r103 = System.currentTimeMillis();
        k0.d().b(new b(r102, r103, r100));
        return;
    L8:
        r102 = new JSONObject(r101);
        goto L9
    }

    public static void onInternalEventV3(String r100, Bundle r101, String r102, String r103, String r104) {
        JSONObject r105 = null;
        if (TextUtils.isEmpty(r102) == true) goto L5;
    L8:
        String r106 = SECOND_APP_PREFIX + r100;
        if (r101 != null) goto L27;
    L23:
        onEventV3(r106, r105);
        return;
    L27:
    L21:
        th = th;
    L22:
        th.printStackTrace();
        goto L23
    L11:
        if (r101.isEmpty() == true) goto L23;
        JSONObject r107 = new JSONObject();     // Catch: Throwable -> L21
        Iterator<String> r108 = r101.keySet().iterator();     // Catch: Throwable -> L19
    L15:
        if (r108.hasNext() == false) goto L17;
        String r109 = r108.next();     // Catch: Throwable -> L19
        r107.put(r109, r101.get(r109));     // Catch: Throwable -> L19
        goto L15
    L17:
        r107.put("params_for_special", SECOND_APP_VALUE);     // Catch: Throwable -> L19
        r107.put(SECOND_APP_ID_KEY, r102);     // Catch: Throwable -> L19
        r107.put(SECOND_APP_NAME_KEY, r103);     // Catch: Throwable -> L19
        r107.put("product_type", r104);     // Catch: Throwable -> L19
        r105 = r107;
    L19:
        th = th;
        r105 = r107;
        goto L22
    L5:
        if (TextUtils.isEmpty(r103) == false) goto L8;
        j.g("both second appid and second app name is empty, return", null);
    }

    public static void onInternalEventV3(String r100, JSONObject r101, String r102, String r103, String r104) {
        if (TextUtils.isEmpty(r102) == true) goto L5;
    L8:
        if (r101 != null) goto L10;
        r101 = new JSONObject();
    L10:
        String r105 = SECOND_APP_PREFIX + r100;
        r101.put("params_for_special", SECOND_APP_VALUE);     // Catch: Throwable -> L13
        r101.put(SECOND_APP_ID_KEY, r102);     // Catch: Throwable -> L13
        r101.put(SECOND_APP_NAME_KEY, r103);     // Catch: Throwable -> L13
        r101.put("product_type", r104);     // Catch: Throwable -> L13
    L15:
        onEventV3(r105, r101);
        return;
    L13:
        th = move-exception;
        th.printStackTrace();
        goto L15
    L5:
        if (TextUtils.isEmpty(r103) == false) goto L8;
        j.g("both second appid and second app name is empty, return", null);
    }
}

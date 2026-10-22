package com.ss.android.message.log;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.push.utils.f;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.message.util.ToolUtils;
import hfc.b;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class PushLog {
    public static final String CATEGORY = "event_v1";
    public static final String EVENT_LABEL_TEST = "click_headline";
    public static final String EVENT_SIGN = "_event_v3";
    public static final String EVENT_TAG_TEST1 = "go_detail";
    public static final String EVENT_TAG_TEST2 = "video_play";
    public static final String EVENT_V3_CATEGORY = "event_v3";
    public static final String KEY_CATEGORY = "category";
    public static final String KEY_EXT_JSON = "ext_json";
    public static final String KEY_EXT_VALUE = "ext_value";
    public static final String KEY_LABEL = "label";
    public static final String KEY_TAG = "tag";
    public static final String KEY_VALUE = "value";

    public static class a extends ThreadPlus {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f449123a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f449124b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f449125c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ long f449126d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ long f449127e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ JSONObject f449128f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Context f449129g;

        public final void a() {
            b r100 = new b();     // Catch: Throwable -> L13
            r100.f484992a = this.f449123a;     // Catch: Throwable -> L13
            r100.f484993b = this.f449124b;     // Catch: Throwable -> L13
            r100.f484994c = this.f449125c;     // Catch: Throwable -> L13
            r100.f484995d = this.f449126d;     // Catch: Throwable -> L13
            r100.f484996e = this.f449127e;     // Catch: Throwable -> L13
            JSONObject r101 = this.f449128f;     // Catch: Throwable -> L13
            if (r101 == null) goto L7;
            r100.f484997f = r101.toString();     // Catch: Throwable -> L13
        L7:
            if (f.f267065a == false) goto L9;
            f.b("PushLog", "category = " + r100.f484992a + " tag = " + r100.f484993b + " label = " + r100.f484994c + " value = " + r100.f484995d + " ext_value = " + this.f449127e + " ext_json = " + r100.f484997f);     // Catch: Throwable -> L13
        L9:
            hfc.a r102 = hfc.a.c(this.f449129g);     // Catch: Throwable -> L13
            if (r102 == null) goto L18;
            r102.d(r100);     // Catch: Throwable -> L13
            return;
        L18:
            return;
        L13:
            th = move-exception;
            th.printStackTrace();
        }

        @Override // com.bytedance.common.utility.concurrent.ThreadPlus, java.lang.Runnable
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

        public a(String r100, String r101, String r102, long r103, long r104, JSONObject r105, Context r106) {
            this.f449123a = r100;
            this.f449124b = r101;
            this.f449125c = r102;
            this.f449126d = r103;
            this.f449127e = r104;
            this.f449128f = r105;
            this.f449129g = r106;
        }
    }

    public PushLog() {
    }

    public static void onEventNow(String r100, JSONObject r101) {
        r101.put("_event_v3", 1);     // Catch: JSONException -> L4
    L6:
        b r102 = new b();
        r102.f484992a = "event_v3";
        r102.f484993b = r100;
        r102.f484997f = r101.toString();
        if (f.f267065a == false) goto L9;
        f.b("PushLog", "category = " + r102.f484992a + " tag = " + r102.f484993b + " label = " + r102.f484994c + " value = " + r102.f484995d + " ext_json = " + r102.f484997f);
    L9:
        hfc.a r103 = hfc.a.c(PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mApplication);
        if (r103 == null) goto L15;
        r103.d(r102);
        return;
    L15:
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        goto L6
    }

    public static void onEventV3(String r100, JSONObject r110) {
        if (StringUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        if (r110 != null) goto L7;
        r110 = new JSONObject();
    L7:
        JSONObject r101 = r110;
        r101.put("_event_v3", 1);     // Catch: JSONException -> L10
    L12:
        onEvent(null, "event_v3", r100, null, 0, 0, r101);
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    public static void onEventV3Bundle(String r110, Bundle r111) {
        if (StringUtils.isEmpty(r110) == false) goto L5;
        return;
    L5:
        JSONObject r100 = new JSONObject();
        r100.put("_event_v3", 1);     // Catch: Throwable -> L13
        if (r111 == null) goto L15;
        Iterator<String> r101 = r111.keySet().iterator();     // Catch: Throwable -> L13
    L10:
        if (r101.hasNext() == false) goto L15;
        String r102 = r101.next();     // Catch: Throwable -> L13
        r100.put(r102, r111.get(r102));     // Catch: Throwable -> L13
    L15:
        onEvent(null, "event_v3", r110, null, 0, 0, r100);
        return;
    L13:
        th = move-exception;
        th.printStackTrace();
        goto L15
    }

    public static void onEvent(Context r210, String r211, JSONObject... r212) {
        if (r212 != null) goto L5;
    L7:
        onEvent(r210, CATEGORY, r211, null, 0, 0, null);
        return;
    L5:
        if (r212.length <= 0) goto L7;
        onEvent(r210, CATEGORY, r211, null, 0, 0, r212[0]);
    }

    public static void onEventV3(Context r100, String r101, JSONObject r102) {
        onEventV3(r100, r101, r102, false);
    }

    public static void onEventV3Bundle(Context r110, String r111, Bundle r112) {
        if (StringUtils.isEmpty(r111) == false) goto L5;
        return;
    L5:
        JSONObject r100 = new JSONObject();
        r100.put("_event_v3", 1);     // Catch: Throwable -> L13
        if (r112 == null) goto L15;
        Iterator<String> r101 = r112.keySet().iterator();     // Catch: Throwable -> L13
    L10:
        if (r101.hasNext() == false) goto L15;
        String r102 = r101.next();     // Catch: Throwable -> L13
        r100.put(r102, r112.get(r102));     // Catch: Throwable -> L13
    L15:
        onEvent(r110, "event_v3", r111, null, 0, 0, r100);
        return;
    L13:
        th = move-exception;
        th.printStackTrace();
        goto L15
    }

    public static void onEvent(Context r210, String r211, String r212, JSONObject... r213) {
        if (r213 != null) goto L5;
    L7:
        onEvent(r210, CATEGORY, r211, r212, 0, 0, null);
        return;
    L5:
        if (r213.length <= 0) goto L7;
        onEvent(r210, CATEGORY, r211, r212, 0, 0, r213[0]);
    }

    public static void onEventV3(Context r110, String r111, JSONObject r112, boolean r113) {
        if (StringUtils.isEmpty(r111) == false) goto L5;
        return;
    L5:
        if (r112 != null) goto L7;
        r112 = new JSONObject();
    L7:
        JSONObject r100 = r112;
        r100.put("_event_v3", 1);     // Catch: JSONException -> L10
    L12:
        onEvent(r110, "event_v3", r111, null, 0, 0, r100, r113);
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    public static void onEvent(Context r100, String r110, String r111, String r112, long r113, long r114) {
        onEvent(r100, r110, r111, r112, r113, r114, null);
    }

    public static void onEvent(Context r110, String r111, String r112, String r113, long r114, long r115, JSONObject r116) {
        onEvent(r110, r111, r112, r113, r114, r115, r116, false);
    }

    public static void onEvent(Context r110, String r111, String r112, String r113, long r114, long r115, JSONObject r210, boolean r211) {
        if (StringUtils.isEmpty(r111) == false) goto L5;
        return;
    L5:
        if (StringUtils.isEmpty(r112) == true) goto L15;
        if (r211 == false) goto L9;
    L12:
        new a(r111, r112, r113, r114, r115, r210, r110).start();
        return;
    L9:
        if (ToolUtils.isMainProcess(r110) == false) goto L12;
        zfc.a.a().onEvent(r110, r111, r112, r113, r114, r115, r210);
        return;
    }
}

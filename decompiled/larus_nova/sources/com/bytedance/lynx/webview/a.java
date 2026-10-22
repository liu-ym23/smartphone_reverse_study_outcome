package com.bytedance.lynx.webview;

import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.lynx.webview.internal.EventType;
import com.bytedance.lynx.webview.internal.Setting;
import com.bytedance.lynx.webview.internal.TTWebContext;
import com.bytedance.lynx.webview.internal.c0;
import com.bytedance.lynx.webview.internal.r;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReference<EventType> f265033a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c0 f265034b = null;

    static {
        f265033a = new AtomicReference(EventType.LOAD_SUCCESS);
        f265034b = TTWebContext.h().p();
    }

    public static String b() {
        String r100 = new JSONObject(f265034b.f265273b.getString("prepareError", SliceInitService.DEFAULT_SWITCH)).optString(Setting.c().h("sdk_upto_so_versioncode", "0620010001"), "");     // Catch: JSONException -> L5
    L8:
        if (Objects.equals(r100, "") == true) goto L10;
        return r100;
    L10:
        return EventType.PREPARE_SUCCESS.getEventName();
    L5:
        e = move-exception;
        r.b("[RecordError] readPrepareError error: " + e.getMessage());
        r100 = "";
        goto L8
    }

    public static JSONObject c() {
        TTWebContext.h().getClass();
        a(TTWebContext.l(false));
        HashMap r100 = new HashMap();
        r100.put("prepare", b());
        r100.put("load", f265033a.get().getEventName());
        String r101 = f265034b.f265273b.getString("settingError", "");
        if (Objects.equals(r101, "") == false) goto L5;
        r101 = EventType.SETTING_SUCCESS.getEventName();
    L5:
        r100.put("setting", r101);
        return new JSONObject(r100);
    }

    public static void a(String r100) {
        if (Objects.equals(r100, Setting.c().h("sdk_upto_so_versioncode", "0620010001")) == false) goto L6;
        f265034b.f265273b.edit().remove("prepareError").apply();
    L6:
        if (Objects.equals(r100, "0620010001") == true) goto L9;
        f265033a.set(EventType.LOAD_SUCCESS);
        return;
    }

    public static void d(EventType r100) {
        if (r100 != null) goto L5;
        r.b("[RecordError] recordLoadError: eventType is null.");
        return;
    L5:
        f265033a.set(r100);
    }

    public static void f(EventType r100) {
        c0 r101 = f265034b;
        if (r100 != null) goto L5;
        r101.getClass();
        r.b("[RecordError] saveSettingError: eventType is null.");
        return;
    L5:
        r101.f265273b.edit().putString("settingError", r100.getEventName()).apply();
    }

    public static void e(f17.b r100, EventType r101) {
        if (r100 == null) goto L18;
        String r102 = r100.f475074a;
        if (r102 == null) goto L19;
        c0 r103 = f265034b;
        r103.getClass();
        if (r102 == null) goto L14;
        if (r101 == null) goto L14;
        JSONObject r104 = new JSONObject(r103.f265273b.getString("prepareError", SliceInitService.DEFAULT_SWITCH));     // Catch: JSONException -> L12
        r104.put(r102, r101.getEventName());     // Catch: JSONException -> L12
        r103.f265273b.edit().putString("prepareError", r104.toString()).apply();     // Catch: JSONException -> L12
        return;
    L12:
        e = move-exception;
        r.b("[RecordError] savePrepareError error: " + e.getMessage());
        return;
    L14:
        r.b("[RecordError] savePrepareError: soVersion or eventType is null.");
        return;
    L19:
        return;
    }
}

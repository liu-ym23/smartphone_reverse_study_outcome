package android.ss.com.vboost.utils;

import android.ss.com.vboost.CapabilityScheduler;
import android.ss.com.vboost.request.RequestManager;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static c<b> f185b;

    /* JADX INFO: renamed from: android.ss.com.vboost.utils.a$a, reason: collision with other inner class name */
    public static class C0001a extends c<b> {
        public C0001a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.ss.com.vboost.utils.c
        public b initialValue() {
            if (CapabilityScheduler.getInitialConfigProvider() != null) goto L5;
            return null;
        L5:
            if (CapabilityScheduler.getInitialConfigProvider().getApplogListener() != null) goto L7;
            return null;
        L7:
            return RequestManager.getInstance().getApplogListener();
        }

        @Override // android.ss.com.vboost.utils.c
        public /* bridge */ /* synthetic */ b initialValue() {
            return initialValue();
        }
    }

    public interface b {
        void onInternalEventV3(String r1, JSONObject r2, String r3, String r4, String r5);
    }

    static {
        f185b = new C0001a();
    }

    public static void a(b r1) {
        f185b.set(r1);
    }

    public static void a(String r7, JSONObject r8, String r9) {
        if (f185b.get() != null) goto L5;
        return;
    L5:
        if (r8 != null) goto L20;
        r8 = new JSONObject();
    L20:
        r8.put("sdkVersion", "2.2.22.mt-alpha.1-lchj-mt");     // Catch: JSONException -> L9
    L12:
        if (f184a == false) goto L22;
        f185b.get().onInternalEventV3(r7, r8, null, null, r9);
    L22:
        r8.put("second_appid", "4159");     // Catch: JSONException -> L16
        r8.put("second_appname", "vboost_oversea");     // Catch: JSONException -> L16
    L18:
        LogUtil.debug("ApplogUtils", "onInternalEventV3 " + r7 + ": " + r8);
        f185b.get().onInternalEventV3(r7, r8, "4160", "vboost", r9);
        return;
    L16:
        e = move-exception;
        e.printStackTrace();
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    public static boolean a() {
        if (f185b.get() == null) goto L5;
        return true;
    L5:
        return false;
    }
}

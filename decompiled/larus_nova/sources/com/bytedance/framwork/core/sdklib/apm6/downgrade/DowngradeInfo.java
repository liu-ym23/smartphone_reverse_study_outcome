package com.bytedance.framwork.core.sdklib.apm6.downgrade;

import android.text.TextUtils;
import by5.n;
import com.bytedance.apm.constant.UploadTypeInf;
import fy5.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class DowngradeInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f244854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<LogType, a> f244855b;

    public static final enum LogType extends Enum<LogType> {
        public static final LogType OTHER_LOG_TYPE = null;
        public static final LogType SERVICE_MONITOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LogType[] f244856a = null;
        public final String logType;

        static {
            LogType r100 = new LogType("OTHER_LOG_TYPE", 0, "other");
            OTHER_LOG_TYPE = r100;
            LogType r101 = new LogType("SERVICE_MONITOR", 1, UploadTypeInf.SERVICE_MONITOR);
            SERVICE_MONITOR = r101;
            f244856a = new LogType[]{r100, r101};
        }

        public static LogType[] values() {
            return (LogType[]) f244856a.clone();
        }

        public static LogType valueOf(String r100) {
            return (LogType) r27.a.a(LogType.class, r100);
        }

        public LogType(String r100, int r101, String r102) {
            super(r100, r101);
            this.logType = r102;
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f244857a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<String, JSONObject> f244858b;

        public final JSONObject b() {
            JSONObject r100 = new JSONObject();     // Catch: JSONException -> L12
            if (this.f244857a == false) goto L5;
            int r101 = 1;
        L6:
            r100.put("default", r101);     // Catch: JSONException -> L12
            Iterator r102 = ((HashMap) this.f244858b).entrySet().iterator();     // Catch: JSONException -> L12
        L8:
            if (r102.hasNext() == false) goto L11;
            Map.Entry r103 = (Map.Entry) r102.next();     // Catch: JSONException -> L12
            r100.put((String) r103.getKey(), (JSONObject) r103.getValue());     // Catch: JSONException -> L12
            goto L8
        L11:
            return r100;
        L5:
            r101 = 0;
        L12:
            return null;
        }

        public a() {
            this.f244858b = new HashMap();
        }

        public static a a(JSONObject r100) {
            a r101 = new a();
            boolean r102 = true;
            if (r100.optInt("default", 1) == 1) goto L6;
            r102 = false;
        L6:
            r101.f244857a = r102;
            Iterator<String> r103 = r100.keys();
        L8:
            if (r103.hasNext() == false) goto L14;
            String r104 = r103.next();
            if (TextUtils.equals(r104, "default") == true) goto L8;
            JSONObject r105 = r100.optJSONObject(r104);
            if (r105 == null) goto L8;
            ((HashMap) r101.f244858b).put(r104, r105);
            goto L8
        L14:
            return r101;
        }
    }

    public DowngradeInfo() {
        this.f244855b = new HashMap();
    }

    public static DowngradeInfo a(JSONObject r100) {
        if (n.f21462e == false) goto L5;
        c.d("APM-SDK", "DowngradeRule=" + r100.toString());
    L5:
        DowngradeInfo r101 = new DowngradeInfo();
        long r102 = r100.optLong("duration", 0);
        long r103 = r100.optLong("expire_time", 0);
        if (r103 <= 0) goto L8;
        r101.f244854a = r103;
    L9:
        LogType r104 = LogType.OTHER_LOG_TYPE;
        JSONObject r105 = r100.optJSONObject(r104.logType);
        if (r105 == null) goto L12;
        ((HashMap) r101.f244855b).put(r104, a.a(r105));
    L12:
        LogType r106 = LogType.SERVICE_MONITOR;
        JSONObject r107 = r100.optJSONObject(r106.logType);
        if (r107 == null) goto L15;
        ((HashMap) r101.f244855b).put(r106, a.a(r107));
    L15:
        return r101;
    L8:
        r101.f244854a = System.currentTimeMillis() + (r102 * 1000);
        goto L9
    }
}

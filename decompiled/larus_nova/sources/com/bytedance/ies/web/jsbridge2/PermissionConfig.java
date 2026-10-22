package com.bytedance.ies.web.jsbridge2;

import android.net.Uri;
import android.util.Log;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class PermissionConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, List<a>> f249277a;

    public static class IllegalRemoteConfigException extends IllegalStateException {
        public IllegalRemoteConfigException(String r100) {
            super(r100);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Pattern f249278a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public PermissionGroup f249279b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List<String> f249280c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public List<String> f249281d;

        public a() {
        }

        public final String toString() {
            return "RemoteConfig{pattern=" + this.f249278a + ", permissionGroup=" + this.f249279b + ", includedMethods=" + this.f249280c + ", excludedMethods=" + this.f249281d + '}';
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PermissionGroup f249282a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Set<String> f249283b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Set<String> f249284c;

        public b() {
            this.f249282a = PermissionGroup.PUBLIC;
            this.f249283b = new HashSet();
            this.f249284c = new HashSet();
        }
    }

    public static String b(String r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        String[] r101 = r100.split("[.]");
        int r102 = r101.length;
        if (r102 >= 2) goto L8;
        return null;
    L8:
        if (r102 != 2) goto L11;
        return r100;
    L11:
        return r101[r102 - 2] + "." + r101[r102 - 1];
    }

    public static a c(JSONObject r100) throws JSONException {
        a r101 = new a();
        r101.f249278a = PatternProtector.compile(JSONObjectProtectorUtils.getString(r100, "pattern"));
        r101.f249279b = PermissionGroup.from(JSONObjectProtectorUtils.getString(r100, "group"));
        r101.f249280c = new ArrayList();
        JSONArray r102 = r100.optJSONArray("included_methods");
        int r103 = 0;
        if (r102 == null) goto L8;
        int r104 = 0;
    L6:
        if (r104 >= r102.length()) goto L8;
        String r105 = JSONArrayProtectorUtils.getString(r102, r104);
        r101.f249280c.add(r105);
        r104 = r104 + 1;
    L8:
        r101.f249281d = new ArrayList();
        JSONArray r106 = r100.optJSONArray("excluded_methods");
        if (r106 != null) goto L11;
    L13:
        return r101;
    L11:
        if (r103 >= r106.length()) goto L13;
        String r107 = JSONArrayProtectorUtils.getString(r106, r103);
        r101.f249281d.add(r107);
        r103 = r103 + 1;
        goto L11
    }

    public final b a(String r100, List<TimeLineEvent> r101) {
        Uri r102 = UriProtector.parse(r100);
        String r103 = r102.getScheme();
        String r104 = r102.getAuthority();
        String r105 = r102.getPath();
        new Uri.Builder().scheme(r103).authority(r104).path(r105).toString();
        b r106 = new b();
        if (r104 != null) goto L5;
    L9:
        TimeLineEvent.b r107 = new TimeLineEvent.b();
        r107.b("host", "null");
        r107.a("label_permission_checker_null_host", r101);
        r106.f249282a = PermissionGroup.PUBLIC;
        return r106;
    L5:
        if (r104.isEmpty() == true) goto L9;
        throw null;
    }

    public void update(JSONObject r110, List<TimeLineEvent> r111) {
        TimeLineEvent.b r100 = new TimeLineEvent.b();     // Catch: JSONException -> L12
        ConcurrentHashMap r101 = new ConcurrentHashMap();     // Catch: JSONException -> L12
        JSONObject r102 = JSONObjectProtectorUtils.getJSONObject(r110, "content");     // Catch: JSONException -> L12
        Iterator<String> r103 = r102.keys();     // Catch: JSONException -> L12
    L4:
        if (r103.hasNext() == false) goto L10;
        String r104 = r103.next();     // Catch: JSONException -> L12
        JSONArray r105 = JSONObjectProtectorUtils.getJSONArray(r102, r104);     // Catch: JSONException -> L12
        CopyOnWriteArrayList r106 = new CopyOnWriteArrayList();     // Catch: JSONException -> L12
        int r107 = 0;
    L7:
        if (r107 >= r105.length()) goto L9;
        r106.add(c(JSONArrayProtectorUtils.getJSONObject(r105, r107)));     // Catch: JSONException -> L12
        r107 = r107 + 1;     // Catch: JSONException -> L12
        goto L7
    L9:
        r101.put(r104, r106);     // Catch: JSONException -> L12
        r100.b(JSONObjectProtectorUtils.getString(r110, "channel"), Long.valueOf(JSONObjectProtectorUtils.getLong(r110, "package_version")));     // Catch: JSONException -> L12
        goto L4
    L10:
        this.f249277a = r101;     // Catch: JSONException -> L12
        r100.a("label_parse_config", r111);     // Catch: JSONException -> L12
    L19:
        throw null;
    L12:
        e = move-exception;
        r110.toString();
        if (m.f249390a == false) goto L16;
        Log.getStackTraceString(e);
    L16:
        if (r111 == null) goto L19;
        TimeLineEvent.b r108 = new TimeLineEvent.b();
        r108.b(CrashHianalyticsData.EXCEPTION_NAME, e.getClass().getSimpleName());
        r108.b("exception_message", e.getMessage());
        r108.b("value", r110.toString());
        r108.a("label_parse_config_exception", r111);
        goto L19
    }
}

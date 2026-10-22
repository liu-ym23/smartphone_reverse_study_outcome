package com.lynx.devtool.memory;

import a8a.a;
import android.util.Log;
import com.lynx.tasm.LynxMemoryCollectionStatus;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.p0;
import com.lynx.tasm.r0;
import com.lynx.tasm.u0;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class MemoryUsageResultSerializer {
    private static final String EMPTY_RESULT_JSON = "{}";
    private static final String TAG = "MemoryUsageResultSerializer";

    public interface ResultCallback {
        void onResult(String r100, String r101);
    }

    private MemoryUsageResultSerializer() {
    }

    private static String safeString(String r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        return r100;
    }

    private static JSONObject instanceToJson(r0 r100) throws JSONException {
        JSONObject r101 = new JSONObject();
        r101.put("instanceId", r100.f383571a);
        r101.put("pageId", safeString(r100.f383572b));
        r101.put("url", safeString(r100.f383573c));
        r101.put(DBDefinition.TOTAL_BYTES, r100.f383574d);
        r101.put("elementBytes", r100.f383575e);
        r101.put("elementNodeCount", r100.f383576f);
        r101.put("viewBytes", r100.f383577g);
        r101.put("viewDetail", viewDetailToJson(r100.f383578h));
        r101.put("mainThreadRuntimeBytes", r100.f383579i);
        r101.put("backgroundThreadRuntimeBytes", r100.f383580j);
        r101.put("btsRuntimeGroupId", safeString(r100.f383581k));
        return r101;
    }

    private static boolean isValidJsonKey(String r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.isEmpty() == true) goto L6;
        return true;
    }

    private static JSONObject memoryRecordToJson(a r100) throws JSONException {
        JSONObject r101 = new JSONObject();
        if (r100 != null) goto L6;
        r101.put("category", "");
        r101.put("sizeBytes", 0);
        r101.put("instanceCount", 0);
        r101.put("detail", new JSONObject());
        return r101;
    L6:
        r101.put("category", safeString(r100.f2204a));
        r101.put("sizeBytes", r100.f2205b);
        r101.put("instanceCount", r100.f2206c);
        r101.put("detail", stringMapToJson(r100.f2207d));
        return r101;
    }

    private static String statusToString(LynxMemoryCollectionStatus r100) {
        if (r100 != LynxMemoryCollectionStatus.TIMEOUT) goto L6;
        return "timeout";
    L6:
        return "completed";
    }

    private static JSONObject stringMapToJson(Map<String, String> r100) throws JSONException {
        JSONObject r101 = new JSONObject();
        if (r100 != null) goto L5;
    L14:
        return r101;
    L5:
        if (r100.isEmpty() == true) goto L14;
        Iterator<Map.Entry<String, String>> r102 = r100.entrySet().iterator();
    L9:
        if (r102.hasNext() == false) goto L14;
        Map.Entry<String, String> r103 = r102.next();
        String r104 = r103.getKey();
        if (isValidJsonKey(r104) == false) goto L9;
        r101.put(r104, safeString(r103.getValue()));
        goto L9
    }

    public static JSONObject toJson(p0 r100) throws JSONException {
        JSONObject r101 = new JSONObject();
        r101.put("collectionStartMs", r100.f383510a);
        r101.put("collectionStatus", statusToString(r100.f383511b));
        r101.put("collectionDurationMs", r100.f383512c);
        r101.put("collectionTimeoutMs", r100.f383513d);
        r101.put("expectedInstanceCount", r100.f383514e);
        r101.put("completedInstanceCount", r100.f383515f);
        r101.put(DBDefinition.TOTAL_BYTES, r100.f383516g);
        r101.put("appBytes", r100.f383517h);
        r101.put("ratioToApp", r100.f383518i);
        r101.put("elementBytes", r100.f383519j);
        r101.put("elementNodeCount", r100.f383520k);
        r101.put("viewBytes", r100.f383521l);
        r101.put("mainThreadRuntimeBytes", r100.f383522m);
        r101.put("backgroundThreadRuntimeBytes", r100.f383523n);
        JSONArray r102 = new JSONArray();
        List<r0> r103 = r100.f383524o;
        if (r103 == null) goto L10;
        Iterator<r0> r104 = r103.iterator();
    L6:
        if (r104.hasNext() == false) goto L10;
        r0 r105 = r104.next();
        if (r105 == null) goto L6;
        r102.put(instanceToJson(r105));
    L10:
        r101.put("instances", r102);
        return r101;
    }

    private static JSONObject viewDetailToJson(Map<String, a> r100) throws JSONException {
        JSONObject r101 = new JSONObject();
        if (r100 != null) goto L5;
    L14:
        return r101;
    L5:
        if (r100.isEmpty() == true) goto L14;
        Iterator<Map.Entry<String, a>> r102 = r100.entrySet().iterator();
    L9:
        if (r102.hasNext() == false) goto L14;
        Map.Entry<String, a> r103 = r102.next();
        String r104 = r103.getKey();
        if (isValidJsonKey(r104) == false) goto L9;
        r101.put(r104, memoryRecordToJson(r103.getValue()));
        goto L9
    }

    public static /* synthetic */ String access$000(String r100, Throwable r101) {
        return failureMessage(r100, r101);
    }

    private static String failureMessage(String r100, Throwable r101) {
        String r102 = r101.getMessage();
        if (r102 != null) goto L5;
    L6:
        r102 = r101.getClass().getSimpleName();
    L8:
        return r100 + ": " + r102;
    L5:
        if (r102.isEmpty() == false) goto L8;
        goto L6
    }

    public static void queryAllMemoryUsage(long r100, final ResultCallback r101) {
        final AtomicBoolean r102 = new AtomicBoolean(false);
        int r103 = u0.f383807a;     // Catch: Throwable -> L5
        u0.a(new AnonymousClass1(r101, r102), r100);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        complete(r101, r102, "{}", failureMessage("Failed to query Lynx memory usage", th));
    }

    public static /* synthetic */ void access$100(ResultCallback r100, AtomicBoolean r101, String r102, String r103) {
        complete(r100, r101, r102, r103);
    }

    private static void complete(ResultCallback r100, AtomicBoolean r101, String r102, String r103) {
        if (r101.compareAndSet(false, true) == false) goto L11;
        r100.onResult(r102, r103);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        LLog.e(TAG, "Failed to deliver Lynx memory usage result: " + Log.getStackTraceString(th));
        return;
    }
}

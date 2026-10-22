package com.bytedance.bdlocation.trace;

import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.callback.LocateCallback;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.exception.BDLocationException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class LocationTrace implements LocateCallback {
    private static final int THROWABLES_LENGTH = 16;
    private boolean isCache;
    private TraceCallback mCallback;
    private BDLocationException mError;
    private long mFirstCallbackTimeMs;
    private long mGeocodeDuration;
    private BDLocation mLocation;
    private long mStartTimeMs;
    private long mStopTimeMs;
    private final String mTag;
    private List<Throwable> mThrowables;

    private void reset() {
        this.isCache = false;
        this.mStopTimeMs = 0;
        this.mFirstCallbackTimeMs = 0;
        this.mLocation = null;
        this.mError = null;
        this.mGeocodeDuration = 0;
    }

    public void endTrace() {
        endTrace(false);
    }

    public void clearCauses() {
        this.mThrowables.clear();
    }

    public BDLocationException getAllCauses() {
        if (this.mThrowables.isEmpty() == true) goto L7;
        return new BDLocationException(new ArrayList(this.mThrowables));
    L7:
        return this.mError;
    }

    public long getTraceTimeMs() {
        return this.mStopTimeMs - this.mStartTimeMs;
    }

    public void startTrace() {
        TraceCallback r0 = this.mCallback;
        if (r0 == null) goto L5;
        r0.onStart(this);
    L5:
        this.mStartTimeMs = System.currentTimeMillis();
        BDLocationConfig.isDebug();
    }

    public String toString() {
        return "LocationTrace{mTag='" + this.mTag + "', mStartTimeMs=" + this.mStartTimeMs + ", isCache=" + this.isCache + ", mStopTimeMs=" + this.mStopTimeMs + ", mLocation=" + this.mLocation + ", mError=" + this.mError + '}';
    }

    public long getStartTimeMs() {
        return this.mStartTimeMs;
    }

    public String getTag() {
        return this.mTag;
    }

    public LocationTrace(String r2) {
        this.mTag = r2;
        this.mThrowables = Collections.synchronizedList(new ArrayList(3));
    }

    private void endTrace(boolean r14) {
        TraceCallback r0 = this.mCallback;
        if (r0 == null) goto L6;
        if (r14 == true) goto L6;
        r0.onStop();
    L6:
        this.mStopTimeMs = System.currentTimeMillis();
        BDLocation r1 = this.mLocation;
        BDLocationException r2 = this.mError;
        if (BDLocationConfig.isDebug() == false) goto L10;
        toString();
    L10:
        if (this.mFirstCallbackTimeMs != 0) goto L12;
        this.mFirstCallbackTimeMs = System.currentTimeMillis();
    L12:
        JSONObject r3 = new JSONObject();
        JSONObject r4 = new JSONObject();
        r3.put(TraceCons.METRIC_BIZ, this.mTag);     // Catch: Exception -> L28
        if (LocationUtil.isBackground() == false) goto L16;
        int r5 = 1;
    L17:
        r3.put(TraceCons.METRIC_BACKGROUND, r5);     // Catch: Exception -> L28
        if (r1 == null) goto L21;
        r3.put("total_duration", this.mFirstCallbackTimeMs - this.mStartTimeMs);     // Catch: Exception -> L28
        r3.put(TraceCons.METRIC_GEO_COST, this.mGeocodeDuration);     // Catch: Exception -> L28
        r3.put(TraceCons.METRIC_REDUCE, r14);     // Catch: Exception -> L28
        r3.put("status", 1);     // Catch: Exception -> L28
        return;
    L21:
        if (r2 == null) goto L31;
        r3.put("total_duration", this.mFirstCallbackTimeMs - this.mStartTimeMs);     // Catch: Exception -> L28
        r3.put("status", 0);     // Catch: Exception -> L28
        r3.put(TraceCons.METRIC_REDUCE, r14);     // Catch: Exception -> L28
        r4.put(TraceCons.EXTRA_FAIL_CODE, r2.getCode());     // Catch: Exception -> L28
        r4.put(TraceCons.EXTRA_FAIL_MESSAGE, r2.getMessage());     // Catch: Exception -> L28
        Iterator<Map.Entry<String, String>> r15 = r2.getExtra().entrySet().iterator();     // Catch: Exception -> L28
    L24:
        if (r15.hasNext() == false) goto L33;
        Map.Entry<String, String> r6 = r15.next();     // Catch: Exception -> L28
        r4.put(r6.getKey(), r6.getValue());     // Catch: Exception -> L28
        goto L24
    L33:
        return;
    L31:
        return;
    L16:
        r5 = 0;
        goto L17
    }

    public void addGeocodeDuration(long r6) {
        if (this.mGeocodeDuration != 0) goto L6;
        this.mGeocodeDuration = r6;
        return;
    }

    public void addTraceInfo(BDLocationException r5) {
        TraceCallback r0 = this.mCallback;
        if (r0 == null) goto L5;
        r0.onError(r5);
    L5:
        this.mError = r5;
        if (this.mThrowables.size() >= 16) goto L12;
        this.mThrowables.add(r5);     // Catch: Exception -> L10
    L12:
        if (this.mFirstCallbackTimeMs != 0) goto L17;
        this.mFirstCallbackTimeMs = System.currentTimeMillis();
        return;
    }

    public void onLocateStart(String r2) {
        TraceCallback r0 = this.mCallback;
        if (r0 == null) goto L6;
        r0.onLocateStart(r2);
        return;
    }

    public void onLocateStop(String r2) {
        TraceCallback r0 = this.mCallback;
        if (r0 == null) goto L6;
        r0.onLocateStop(r2);
        return;
    }

    public void reduce(BDLocationException r1) {
        addTraceInfo(r1);
        endTrace(true);
        reset();
    }

    public void setTraceCallback(TraceCallback r1) {
        this.mCallback = r1;
    }

    public void addTraceInfo(BDLocation r5) {
        TraceCallback r0 = this.mCallback;
        if (r0 == null) goto L5;
        r0.onLocationChanged(new BDLocation(r5));
    L5:
        this.mLocation = r5;
        this.isCache = r5.isCache();
        if (this.mFirstCallbackTimeMs != 0) goto L9;
        this.mFirstCallbackTimeMs = System.currentTimeMillis();
        return;
    }

    public void onLocateChange(String r2, BDLocation r3) {
        TraceCallback r0 = this.mCallback;
        if (r0 == null) goto L6;
        r0.onLocateChange(r2, r3);
        return;
    }

    public void onLocateError(String r2, BDLocationException r3) {
        TraceCallback r0 = this.mCallback;
        if (r0 == null) goto L6;
        r0.onLocateError(r2, r3);
        return;
    }
}

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

/* JADX INFO: loaded from: classes10.dex */
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
        TraceCallback r100 = this.mCallback;
        if (r100 == null) goto L5;
        r100.onStart(this);
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

    public LocationTrace(String r100) {
        this.mTag = r100;
        this.mThrowables = Collections.synchronizedList(new ArrayList(3));
    }

    private void endTrace(boolean r110) {
        TraceCallback r100 = this.mCallback;
        if (r100 == null) goto L6;
        if (r110 == true) goto L6;
        r100.onStop();
    L6:
        this.mStopTimeMs = System.currentTimeMillis();
        BDLocation r101 = this.mLocation;
        BDLocationException r102 = this.mError;
        if (BDLocationConfig.isDebug() == false) goto L10;
        toString();
    L10:
        if (this.mFirstCallbackTimeMs != 0) goto L12;
        this.mFirstCallbackTimeMs = System.currentTimeMillis();
    L12:
        JSONObject r103 = new JSONObject();
        JSONObject r104 = new JSONObject();
        r103.put(TraceCons.METRIC_BIZ, this.mTag);     // Catch: Exception -> L28
        if (LocationUtil.isBackground() == false) goto L16;
        int r105 = 1;
    L17:
        r103.put("background", r105);     // Catch: Exception -> L28
        if (r101 == null) goto L21;
        r103.put("total_duration", this.mFirstCallbackTimeMs - this.mStartTimeMs);     // Catch: Exception -> L28
        r103.put(TraceCons.METRIC_GEO_COST, this.mGeocodeDuration);     // Catch: Exception -> L28
        r103.put("reduce", r110);     // Catch: Exception -> L28
        r103.put("status", 1);     // Catch: Exception -> L28
        return;
    L21:
        if (r102 == null) goto L31;
        r103.put("total_duration", this.mFirstCallbackTimeMs - this.mStartTimeMs);     // Catch: Exception -> L28
        r103.put("status", 0);     // Catch: Exception -> L28
        r103.put("reduce", r110);     // Catch: Exception -> L28
        r104.put(TraceCons.EXTRA_FAIL_CODE, r102.getCode());     // Catch: Exception -> L28
        r104.put(TraceCons.EXTRA_FAIL_MESSAGE, r102.getMessage());     // Catch: Exception -> L28
        Iterator<Map.Entry<String, String>> r111 = r102.getExtra().entrySet().iterator();     // Catch: Exception -> L28
    L24:
        if (r111.hasNext() == false) goto L33;
        Map.Entry<String, String> r106 = r111.next();     // Catch: Exception -> L28
        r104.put(r106.getKey(), r106.getValue());     // Catch: Exception -> L28
        goto L24
    L33:
        return;
    L31:
        return;
    L16:
        r105 = 0;
        goto L17
    }

    public void addGeocodeDuration(long r100) {
        if (this.mGeocodeDuration != 0) goto L6;
        this.mGeocodeDuration = r100;
        return;
    }

    public void addTraceInfo(BDLocationException r100) {
        TraceCallback r101 = this.mCallback;
        if (r101 == null) goto L5;
        r101.onError(r100);
    L5:
        this.mError = r100;
        if (this.mThrowables.size() >= 16) goto L12;
        this.mThrowables.add(r100);     // Catch: Exception -> L10
    L12:
        if (this.mFirstCallbackTimeMs != 0) goto L17;
        this.mFirstCallbackTimeMs = System.currentTimeMillis();
        return;
    }

    @Override // com.bytedance.bdlocation.callback.LocateCallback
    public void onLocateStart(String r100) {
        TraceCallback r101 = this.mCallback;
        if (r101 == null) goto L6;
        r101.onLocateStart(r100);
        return;
    }

    @Override // com.bytedance.bdlocation.callback.LocateCallback
    public void onLocateStop(String r100) {
        TraceCallback r101 = this.mCallback;
        if (r101 == null) goto L6;
        r101.onLocateStop(r100);
        return;
    }

    public void reduce(BDLocationException r100) {
        addTraceInfo(r100);
        endTrace(true);
        reset();
    }

    public void setTraceCallback(TraceCallback r100) {
        this.mCallback = r100;
    }

    public void addTraceInfo(BDLocation r100) {
        TraceCallback r101 = this.mCallback;
        if (r101 == null) goto L5;
        r101.onLocationChanged(new BDLocation(r100));
    L5:
        this.mLocation = r100;
        this.isCache = r100.isCache();
        if (this.mFirstCallbackTimeMs != 0) goto L9;
        this.mFirstCallbackTimeMs = System.currentTimeMillis();
        return;
    }

    @Override // com.bytedance.bdlocation.callback.LocateCallback
    public void onLocateChange(String r100, BDLocation r101) {
        TraceCallback r102 = this.mCallback;
        if (r102 == null) goto L6;
        r102.onLocateChange(r100, r101);
        return;
    }

    @Override // com.bytedance.bdlocation.callback.LocateCallback
    public void onLocateError(String r100, BDLocationException r101) {
        TraceCallback r102 = this.mCallback;
        if (r102 == null) goto L6;
        r102.onLocateError(r100, r101);
        return;
    }
}

package com.ixigua.lib.track;

import androidx.camera.video.AudioStats;
import androidx.exifinterface.media.ExifInterface;
import by7.d;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import ey7.c;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 C2\u00020\u0001:\u0001DB\u0007¢\u0006\u0004\bA\u0010BJ0\u0010\t\u001a\u00020\b2\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00022\u0006\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0002JH\u0010\r\u001a\u00020\b2\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00022\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\n2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\nH\u0002J+\u0010\u0010\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00018\u0000H\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0012H\u0007J\u001a\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0014H\u0007J\u001a\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0016H\u0007J\u001a\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0018H\u0007J\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0007J+\u0010\u001b\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00018\u0000H\u0007¢\u0006\u0004\b\u001b\u0010\u0011J\u001a\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0012H\u0007J\u001a\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0014H\u0007J\u001a\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0016H\u0007J\u001a\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0018H\u0007J\u001e\u0010 \u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0007J\u000e\u0010#\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020!J\u0018\u0010$\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004J=\u0010$\u001a\u00020\u00002.\u0010'\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040&0%\"\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040&¢\u0006\u0004\b$\u0010(J\u0018\u0010)\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004J\u0018\u0010*\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004J=\u0010+\u001a\u00020\u00002.\u0010'\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040&0%\"\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040&¢\u0006\u0004\b+\u0010(J\u001c\u0010+\u001a\u00020\u00002\u0014\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\nJ\u001c\u0010.\u001a\u00020\u00002\u0014\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\nJ\u0010\u0010.\u001a\u00020\u00002\b\u00100\u001a\u0004\u0018\u00010/J\u0010\u0010.\u001a\u00020\u00002\b\u00101\u001a\u0004\u0018\u00010\u0003J\u0010\u0010+\u001a\u00020\u00002\b\u00102\u001a\u0004\u0018\u00010\u0000J\u0010\u0010+\u001a\u00020\u00002\b\u00103\u001a\u0004\u0018\u00010/J\u0010\u0010+\u001a\u00020\u00002\b\u00104\u001a\u0004\u0018\u00010\u0003J$\u00105\u001a\u00020\u00002\b\u00102\u001a\u0004\u0018\u00010\u00002\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\nJ\u0006\u00106\u001a\u00020/J\u0006\u00107\u001a\u00020/J\b\u00108\u001a\u0004\u0018\u00010\u0003J\b\u00109\u001a\u00020\u0003H\u0016R7\u0010,\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040:j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004`;8\u0006¢\u0006\f\n\u0004\b,\u0010<\u001a\u0004\b=\u0010>R7\u0010?\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040:j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004`;8\u0006¢\u0006\f\n\u0004\b?\u0010<\u001a\u0004\b@\u0010>¨\u0006E"}, d2 = {"Lcom/ixigua/lib/track/TrackParams;", "Ljava/io/Serializable;", "", "", "", "destMap", "key", "value", "", "internalPut", "", "srcMap", "keyMap", "internalMergeWithKeyMap", ExifInterface.GPS_DIRECTION_TRUE, "fallback", MonitorConstants.CONNECT_TYPE_GET, "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "", "optInt", "", "optLong", "", "optDouble", "", "optBoolean", "optString", "getFromPb", "optIntFromPb", "optLongFromPb", "optDoubleFromPb", "optBooleanFromPb", "optStringFromPb", "Lby7/d;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "update", "put", "", "Lkotlin/Pair;", "pairs", "([Lkotlin/Pair;)Lcom/ixigua/lib/track/TrackParams;", "putIfNull", "putPbIfNull", "merge", "params", "pbMap", "mergePb", "Lorg/json/JSONObject;", "sourcePb", "sourcePbJson", "trackParams", "trackParamsJSON", "trackParamsStr", "mergeWithKeyMap", "makePbJSONObject", "makeJSONObject", "toJSON", "toString", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "getParams", "()Ljava/util/HashMap;", "logPb", "getLogPb", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "track_release"}, k = 1, mv = {1, 4, 0})
public final class TrackParams implements Serializable {
    public static final a Companion = null;
    public static final String KEY_LOG_PB = "log_pb";
    private final HashMap<String, Object> logPb;
    private final HashMap<String, Object> params;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final <T> T get(String r100) {
        return (T) get$default(this, r100, null, 2, null);
    }

    public final <T> T getFromPb(String r100) {
        return (T) getFromPb$default(this, r100, null, 2, null);
    }

    public final boolean optBoolean(String r100) {
        return optBoolean$default(this, r100, false, 2, null);
    }

    public final boolean optBooleanFromPb(String r100) {
        return optBooleanFromPb$default(this, r100, false, 2, null);
    }

    public final double optDouble(String r100) {
        return optDouble$default(this, r100, AudioStats.AUDIO_AMPLITUDE_NONE, 2, null);
    }

    public final double optDoubleFromPb(String r100) {
        return optDoubleFromPb$default(this, r100, AudioStats.AUDIO_AMPLITUDE_NONE, 2, null);
    }

    public final int optInt(String r100) {
        return optInt$default(this, r100, 0, 2, null);
    }

    public final int optIntFromPb(String r100) {
        return optIntFromPb$default(this, r100, 0, 2, null);
    }

    public final long optLong(String r100) {
        return optLong$default(this, r100, 0, 2, null);
    }

    public final long optLongFromPb(String r100) {
        return optLongFromPb$default(this, r100, 0, 2, null);
    }

    public final String optString(String r100) {
        return optString$default(this, r100, null, 2, null);
    }

    public final String optStringFromPb(String r100) {
        return optStringFromPb$default(this, r100, null, 2, null);
    }

    public final JSONObject makeJSONObject() {
        JSONObject r100 = new JSONObject();
        if ((!this.params.isEmpty()) == false) goto L10;
        Iterator<Map.Entry<String, Object>> r101 = this.params.entrySet().iterator();     // Catch: JSONException -> L13
    L7:
        if (r101.hasNext() == false) goto L10;
        Map.Entry<String, Object> r102 = r101.next();     // Catch: JSONException -> L13
        r100.put(r102.getKey(), r102.getValue());     // Catch: JSONException -> L13
    L10:
        if ((!this.logPb.isEmpty()) == false) goto L12;
        r100.put("log_pb", makePbJSONObject());     // Catch: JSONException -> L13
    L12:
        return r100;
    }

    public final JSONObject makePbJSONObject() {
        JSONObject r100 = new JSONObject();
        if ((!this.logPb.isEmpty()) == false) goto L10;
        Iterator<Map.Entry<String, Object>> r101 = this.logPb.entrySet().iterator();     // Catch: JSONException -> L11
    L7:
        if (r101.hasNext() == false) goto L10;
        Map.Entry<String, Object> r102 = r101.next();     // Catch: JSONException -> L11
        r100.put(r102.getKey(), r102.getValue());     // Catch: JSONException -> L11
    L10:
        return r100;
    }

    public String toString() {
        return "{params=" + this.params + ", log_pb=" + this.logPb + '}';
    }

    public TrackParams() {
        this.params = new HashMap();
        this.logPb = new HashMap();
    }

    public final String toJSON() {
        return makeJSONObject().toString();
    }

    public final HashMap<String, Object> getLogPb() {
        return this.logPb;
    }

    public final HashMap<String, Object> getParams() {
        return this.params;
    }

    public final TrackParams merge(JSONObject r100) {
        if (r100 != null) goto L16;
    L14:
        return this;
    L16:
        if (r100.length() <= 0) goto L14;
        Iterator<String> r101 = r100.keys();     // Catch: JSONException -> L15
    L7:
        if (r101.hasNext() == false) goto L14;
        String r102 = r101.next();     // Catch: JSONException -> L15
        if (Intrinsics.areEqual(r102, "log_pb") == true) goto L11;
        putIfNull(r102, r100.get(r102));     // Catch: JSONException -> L15
        goto L7
    L11:
        mergePb(r100.optJSONObject("log_pb"));     // Catch: JSONException -> L15
        goto L7
    }

    public final TrackParams mergePb(Map<String, ? extends Object> r100) {
        Iterator<Map.Entry<String, ? extends Object>> r101 = r100.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Map.Entry<String, ? extends Object> r102 = r101.next();
        putPbIfNull(r102.getKey(), r102.getValue());
        goto L4
    L6:
        return this;
    }

    public final TrackParams put(Pair<String, ? extends Object>... r100) {
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        Pair<String, ? extends Object> r103 = r100[r102];
        put(r103.getFirst(), r103.getSecond());
        r102 = r102 + 1;
        goto L3
    L5:
        return this;
    }

    public final TrackParams update(d r100) {
        r100.fillTrackParams(this);
        return this;
    }

    public final TrackParams merge(Map<String, ? extends Object> r100) {
        Iterator<Map.Entry<String, ? extends Object>> r101 = r100.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Map.Entry<String, ? extends Object> r102 = r101.next();
        putIfNull(r102.getKey(), r102.getValue());
        goto L4
    L6:
        return this;
    }

    public final TrackParams mergePb(JSONObject r100) {
        if (r100 != null) goto L12;
    L10:
        return this;
    L12:
        if (r100.length() <= 0) goto L10;
        Iterator<String> r101 = r100.keys();     // Catch: JSONException -> L11
    L7:
        if (r101.hasNext() == false) goto L10;
        String r102 = r101.next();     // Catch: JSONException -> L11
        putPbIfNull(r102, r100.get(r102));     // Catch: JSONException -> L11
        goto L7
    }

    public final TrackParams merge(String r100) {
        if (r100 != null) goto L4;
    L9:
        return this;
    L4:
        if (r100.length() <= 0) goto L6;
        boolean r101 = true;
    L7:
        if (r101 != true) goto L9;
        merge(new JSONObject(r100));     // Catch: Exception -> L10
        goto L9
    L6:
        r101 = false;
        goto L7
    }

    public final TrackParams mergePb(String r100) {
        if (r100 != null) goto L4;
    L9:
        return this;
    L4:
        if (r100.length() <= 0) goto L6;
        boolean r101 = true;
    L7:
        if (r101 != true) goto L9;
        mergePb(new JSONObject(r100));     // Catch: Exception -> L10
        goto L9
    L6:
        r101 = false;
        goto L7
    }

    public final TrackParams merge(Pair<String, ? extends Object>... r100) {
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        Pair<String, ? extends Object> r103 = r100[r102];
        putIfNull(r103.getFirst(), r103.getSecond());
        r102 = r102 + 1;
        goto L3
    L5:
        return this;
    }

    public final TrackParams merge(TrackParams r100) {
        if (r100 == null) goto L4;
        merge(r100.params);
        mergePb(r100.logPb);
    L4:
        return this;
    }

    public final <T> T get(String r100, T r101) {
        Object r102 = this.params.get(r100);
        if ((r102 instanceof Object) == true) goto L5;
        r102 = null;
    L5:
        if (r102 != null) goto L7;
        return r101;
    L7:
        return (T) r102;
    }

    public final <T> T getFromPb(String r100, T r101) {
        Object r102 = this.logPb.get(r100);
        if ((r102 instanceof Object) == true) goto L5;
        r102 = null;
    L5:
        if (r102 != null) goto L7;
        return r101;
    L7:
        return (T) r102;
    }

    public final TrackParams mergeWithKeyMap(TrackParams r100, Map<String, String> r101) {
        if (r100 == null) goto L4;
        internalMergeWithKeyMap(this.params, r100.params, r101);
        internalMergeWithKeyMap(this.logPb, r100.logPb, r101);
    L4:
        return this;
    }

    public final boolean optBoolean(String r100, boolean r101) {
        Boolean r102 = ey7.a.a(this.params.get(r100));
        if (r102 != null) goto L5;
        return r101;
    L5:
        return r102.booleanValue();
    }

    public final boolean optBooleanFromPb(String r100, boolean r101) {
        Boolean r102 = ey7.a.a(this.logPb.get(r100));
        if (r102 != null) goto L5;
        return r101;
    L5:
        return r102.booleanValue();
    }

    public final double optDouble(String r100, double r101) {
        Double r102 = ey7.a.b(this.params.get(r100));
        if (r102 != null) goto L5;
        return r101;
    L5:
        return r102.doubleValue();
    }

    public final double optDoubleFromPb(String r100, double r101) {
        Double r102 = ey7.a.b(this.logPb.get(r100));
        if (r102 != null) goto L5;
        return r101;
    L5:
        return r102.doubleValue();
    }

    public final int optInt(String r100, int r101) {
        Integer r102 = ey7.a.c(this.params.get(r100));
        if (r102 != null) goto L5;
        return r101;
    L5:
        return r102.intValue();
    }

    public final int optIntFromPb(String r100, int r101) {
        Integer r102 = ey7.a.c(this.logPb.get(r100));
        if (r102 != null) goto L5;
        return r101;
    L5:
        return r102.intValue();
    }

    public final long optLong(String r100, long r101) {
        Long r102 = ey7.a.d(this.params.get(r100));
        if (r102 != null) goto L5;
        return r101;
    L5:
        return r102.longValue();
    }

    public final long optLongFromPb(String r100, long r101) {
        Long r102 = ey7.a.d(this.logPb.get(r100));
        if (r102 != null) goto L5;
        return r101;
    L5:
        return r102.longValue();
    }

    public final String optString(String r100, String r101) {
        Object r102 = this.params.get(r100);
        if ((r102 instanceof String) == false) goto L5;
        String r103 = (String) r102;
    L8:
        if (r103 != null) goto L10;
        return r101;
    L10:
        return r103;
    L5:
        if (r102 == null) goto L7;
        r103 = String.valueOf(r102);
        goto L8
    L7:
        r103 = null;
        goto L8
    }

    public final String optStringFromPb(String r100, String r101) {
        Object r102 = this.logPb.get(r100);
        if ((r102 instanceof String) == false) goto L5;
        String r103 = (String) r102;
    L8:
        if (r103 != null) goto L10;
        return r101;
    L10:
        return r103;
    L5:
        if (r102 == null) goto L7;
        r103 = String.valueOf(r102);
        goto L8
    L7:
        r103 = null;
        goto L8
    }

    public final TrackParams put(String r100, Object r101) {
        internalPut(this.params, r100, r101);
        return this;
    }

    public final TrackParams putIfNull(String r100, Object r101) {
        if (this.params.get(r100) != null) goto L5;
        put(r100, r101);
    L5:
        return this;
    }

    public final TrackParams putPbIfNull(String r100, Object r101) {
        if (this.logPb.get(r100) != null) goto L5;
        internalPut(this.logPb, r100, r101);
    L5:
        return this;
    }

    private final void internalMergeWithKeyMap(Map<String, Object> r100, Map<String, ? extends Object> r101, Map<String, String> r102) {
        if ((!r102.isEmpty()) == true) goto L5;
        return;
    L5:
        if ((!r101.isEmpty()) == false) goto L22;
        Iterator<Map.Entry<String, String>> r103 = r102.entrySet().iterator();
    L8:
        if (r103.hasNext() == false) goto L23;
        Map.Entry<String, String> r104 = r103.next();
        if (r101.containsKey(r104.getKey()) == false) goto L8;
        if (r100.get(r104.getValue()) != null) goto L8;
        r100.put(r104.getValue(), r101.get(r104.getKey()));
        goto L8
    L23:
        return;
    }

    private final void internalPut(Map<String, Object> r100, String r101, Object r102) {
        if (r102 != null) goto L5;
    L12:
        r100.put(r101, r102);
        return;
    L5:
        if ((r102 instanceof String) == true) goto L12;
        if ((r102 instanceof Number) == true) goto L12;
        if ((r102 instanceof Boolean) == true) goto L12;
        if ((r102 instanceof JSONObject) == false) goto L17;
        r100.put(r101, r102.toString());
        return;
    L17:
        if ((r102 instanceof JSONArray) == false) goto L19;
        r100.put(r101, r102.toString());
        return;
    L19:
        int r103 = c.f474809a;
        r100.put(r101, r102.toString());
    }

    public static /* synthetic */ Object get$default(TrackParams r100, String r101, Object r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        return r100.get(r101, r102);
    }

    public static /* synthetic */ Object getFromPb$default(TrackParams r100, String r101, Object r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        return r100.getFromPb(r101, r102);
    }

    public static /* synthetic */ boolean optBoolean$default(TrackParams r100, String r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = false;
    L6:
        return r100.optBoolean(r101, r102);
    }

    public static /* synthetic */ boolean optBooleanFromPb$default(TrackParams r100, String r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = false;
    L6:
        return r100.optBooleanFromPb(r101, r102);
    }

    public static /* synthetic */ double optDouble$default(TrackParams r100, String r101, double r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = DoubleCompanionObject.INSTANCE.getNaN();
    L6:
        return r100.optDouble(r101, r102);
    }

    public static /* synthetic */ double optDoubleFromPb$default(TrackParams r100, String r101, double r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = DoubleCompanionObject.INSTANCE.getNaN();
    L6:
        return r100.optDoubleFromPb(r101, r102);
    }

    public static /* synthetic */ int optInt$default(TrackParams r100, String r101, int r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = 0;
    L6:
        return r100.optInt(r101, r102);
    }

    public static /* synthetic */ int optIntFromPb$default(TrackParams r100, String r101, int r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = 0;
    L6:
        return r100.optIntFromPb(r101, r102);
    }

    public static /* synthetic */ long optLong$default(TrackParams r100, String r101, long r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = 0;
    L6:
        return r100.optLong(r101, r102);
    }

    public static /* synthetic */ long optLongFromPb$default(TrackParams r100, String r101, long r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = 0;
    L6:
        return r100.optLongFromPb(r101, r102);
    }

    public static /* synthetic */ String optString$default(TrackParams r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        return r100.optString(r101, r102);
    }

    public static /* synthetic */ String optStringFromPb$default(TrackParams r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        return r100.optStringFromPb(r101, r102);
    }
}

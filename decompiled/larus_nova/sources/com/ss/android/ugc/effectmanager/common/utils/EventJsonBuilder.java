package com.ss.android.ugc.effectmanager.common.utils;

import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public class EventJsonBuilder {
    private static final boolean DEBUG = false;
    private HashMap<String, Object> mHashMap;

    private static void check(Object r100) {
    }

    public synchronized JSONObject build() {
        monitor-enter(this);
        JSONObject r100 = new JSONObject(this.mHashMap);     // Catch: Throwable -> L6 Exception -> L8
        monitor-exit(this);
        return r100;
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L6
        return null;
    L6:
        th = move-exception;
        throw th;
    }

    public static EventJsonBuilder newBuilder() {
        return new EventJsonBuilder();
    }

    public EventJsonBuilder() {
        this.mHashMap = new HashMap();
    }

    public HashMap<String, Object> getHasMap() {
        return this.mHashMap;
    }

    public static EventJsonBuilder fromJSONObject(JSONObject r100) {
        EventJsonBuilder r101 = newBuilder();
        if (r100 != null) goto L5;
    L13:
        return r101;
    L5:
        if (r100.length() <= 0) goto L13;
        Iterator<String> r102 = r100.keys();
    L8:
        if (r102.hasNext() == false) goto L13;
        String r103 = r102.next();
        r101.addValuePair(r103, JSONObjectProtectorUtils.getString(r100, r103));     // Catch: JSONException -> L12
        goto L8
    }

    public EventJsonBuilder addValuePair(String r100, Boolean r101) {
        check(this.mHashMap.put(r100, r101));
        return this;
    }

    public EventJsonBuilder addValuePair(String r100, Double r101) {
        check(this.mHashMap.put(r100, r101));
        return this;
    }

    public EventJsonBuilder addValuePair(String r100, Float r101) {
        check(this.mHashMap.put(r100, r101));
        return this;
    }

    public EventJsonBuilder addValuePair(String r100, Integer r101) {
        check(this.mHashMap.put(r100, r101));
        return this;
    }

    public EventJsonBuilder addValuePair(String r100, Long r101) {
        check(this.mHashMap.put(r100, r101));
        return this;
    }

    public EventJsonBuilder addValuePair(String r100, String r101) {
        check(this.mHashMap.put(r100, r101));
        return this;
    }

    public EventJsonBuilder addValuePair(String r100, List<String> r101) {
        check(this.mHashMap.put(r100, r101));
        return this;
    }
}

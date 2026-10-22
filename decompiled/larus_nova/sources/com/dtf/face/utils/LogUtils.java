package com.dtf.face.utils;

import com.alibaba.fastjson.JSONObject;
import java.util.LinkedHashMap;
import java.util.List;
import ytc.a;

/* JADX INFO: loaded from: classes22.dex */
public class LogUtils {
    private static boolean sLog;
    private static LinkedHashMap<String, List<JSONObject>> sLogMap;

    static {
        a.b();
    }

    public static native Object get(String r100);

    public static native void init(String r100);

    public static native void save(String r100, String r101, String r102);

    public static boolean needLog() {
        if (sLog == true) goto L5;
    L7:
        return false;
    L5:
        if (sLogMap == null) goto L7;
        return true;
    }

    public LogUtils() {
    }
}

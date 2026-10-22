package com.bytedance.ies.common;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class IESAppLogger {
    private static final String VESDK_EVENT_SECOND_APPID = "1357";
    private static final String VESDK_EVENT_SECOND_APPID_ABROAD = "2780";
    private static final String VESDK_EVENT_SECOND_APPID_KEY = "second_appid";
    private static final String VESDK_EVENT_SECOND_APPNAME = "video_editor_sdk";
    private static final String VESDK_EVENT_SECOND_APPNAME_ABROAD = "vesdk_abroad";
    private static final String VESDK_EVENT_SECOND_APPNAME_KEY = "second_appname";
    private static volatile IESAppLogger instance;
    private static final Object object = null;
    private String appId;
    private IESAppLoggerCallback appLoggerCallback;
    private Boolean initFlag;
    private Boolean isAbroad;
    private final Set<String> mSampler;

    public interface IESAppLoggerCallback {
        void onInternalEventV3(String r100, JSONObject r101, String r102);
    }

    public native void nativeSetSampler(Set<String> r100);

    static {
        object = new Object();
        instance = null;
    }

    public static IESAppLogger sharedInstance() {
        if (instance != null) goto L5;
        Object r100 = object;
        monitor-enter(r100);
    L14:
        th = move-exception;
        throw th;
    L9:
        if (instance != null) goto L11;
        instance = new IESAppLogger();     // Catch: Throwable -> L14
    L11:
        IESAppLogger r101 = instance;     // Catch: Throwable -> L14
        monitor-exit(r100);     // Catch: Throwable -> L14
        return r101;
    L5:
        return instance;
    }

    private IESAppLogger() {
        this.mSampler = new HashSet();
        this.appLoggerCallback = null;
        Boolean r100 = Boolean.FALSE;
        this.initFlag = r100;
        this.appId = null;
        this.isAbroad = r100;
    }

    private static JSONObject copyJson(JSONObject r100) {
        if (r100 == null) goto L4;
        LinkedList r101 = new LinkedList();
        Iterator<String> r102 = r100.keys();
        if (r102 != null) goto L10;
        return new JSONObject();
    L10:
        if (r102.hasNext() == false) goto L17;
        r101.add(r102.next());
        goto L10
    L17:
        return new JSONObject(r100, (String[]) r101.toArray(new String[0]));
    L14:
        e = move-exception;
        e.printStackTrace();
        return r100;
    L4:
        return new JSONObject();
    }

    public boolean isSampled(String r100) {
        if (r100 != null) goto L4;
    L10:
        return false;
    L4:
        if (r100.isEmpty() == true) goto L10;
        if (this.mSampler.isEmpty() == true) goto L10;
        if (this.mSampler.contains(r100) == false) goto L10;
        return true;
    }

    public synchronized void setSampler(Set<String> r100) {
        monitor-enter(this);
        if (r100 != null) goto L15;
    L13:
        monitor-exit(this);
        return;
    L15:
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r100.isEmpty() == true) goto L13;
        this.mSampler.clear();     // Catch: Throwable -> L10
        this.mSampler.addAll(r100);     // Catch: Throwable -> L10
        nativeSetSampler(this.mSampler);     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    public void appLogOnEvent(String r100, String r101, String r102) {
        appLogOnEvent(r100, r101, r102, false);
    }

    public void setAppLogCallback(String r100, IESAppLoggerCallback r101, boolean r102) {
        if (this.initFlag.booleanValue() == false) goto L5;
        return;
    L5:
        Object r103 = object;
        monitor-enter(r103);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (this.initFlag.booleanValue() == true) goto L10;
        this.appId = r100;     // Catch: Throwable -> L12
        this.appLoggerCallback = r101;     // Catch: Throwable -> L12
        this.initFlag = Boolean.TRUE;     // Catch: Throwable -> L12
        this.isAbroad = Boolean.valueOf(r102);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r103);     // Catch: Throwable -> L12
    }

    public void appLogOnEvent(String r100, JSONObject r101, String r102) {
        appLogOnEvent(r100, r101, r102, false);
    }

    public void appLogOnEvent(String r100, JSONObject r101, String r102, int r103) {
        boolean r104 = false;
        if ((r103 & 1) != 1) goto L5;
        boolean r105 = true;
    L7:
        if ((r103 & 2) != 2) goto L10;
        r104 = true;
    L10:
        if (this.appLoggerCallback != null) goto L13;
        return;
    L13:
        if (this.mSampler.isEmpty() == false) goto L15;
    L17:
        if (r104 == false) goto L19;
        JSONObject r106 = copyJson(r101);
        this.appLoggerCallback.onInternalEventV3(r100, r106, r102);
    L19:
        if (r105 == false) goto L34;
        JSONObject r107 = copyJson(r101);
    L27:
        e = move-exception;
        e.printStackTrace();
    L29:
        this.appLoggerCallback.onInternalEventV3(r100, r107, r102);
        return;
    L23:
        if (this.isAbroad.booleanValue() == false) goto L25;
        r107.put(VESDK_EVENT_SECOND_APPID_KEY, VESDK_EVENT_SECOND_APPID_ABROAD);     // Catch: JSONException -> L27
        r107.put(VESDK_EVENT_SECOND_APPNAME_KEY, VESDK_EVENT_SECOND_APPNAME_ABROAD);     // Catch: JSONException -> L27
    L31:
        goto L29
    L25:
        r107.put(VESDK_EVENT_SECOND_APPID_KEY, VESDK_EVENT_SECOND_APPID);     // Catch: JSONException -> L27
        r107.put(VESDK_EVENT_SECOND_APPNAME_KEY, VESDK_EVENT_SECOND_APPNAME);     // Catch: JSONException -> L27
        goto L31
    L34:
        return;
    L15:
        if (this.mSampler.contains(r100) == false) goto L17;
        return;
    L5:
        r105 = false;
        goto L7
    }

    public void appLogOnEvent(String r100, String r101, String r102, boolean r103) {
        if (this.appLoggerCallback != null) goto L11;
        return;
    L11:
        JSONObject r104 = new JSONObject(r101);     // Catch: JSONException -> L7
    L9:
        appLogOnEvent(r100, r104, r102, r103);
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        r104 = new JSONObject();
        goto L9
    }

    public void appLogOnEvent(String r100, String r101, String r102, int r103) {
        JSONObject r104 = new JSONObject(r101);     // Catch: JSONException -> L4
    L6:
        appLogOnEvent(r100, r104, r102, r103);
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        r104 = new JSONObject();
        goto L6
    }

    public void appLogOnEvent(String r100, JSONObject r101, String r102, boolean r103) {
        if (r103 == false) goto L4;
        int r104 = 3;
    L5:
        appLogOnEvent(r100, r101, r102, r104);
        return;
    L4:
        r104 = 1;
        goto L5
    }
}

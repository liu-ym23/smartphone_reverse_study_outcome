package com.ss.android.ttve.editorInfo;

import com.ss.android.ttve.nativePort.TECodecNativeLibsLoader;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import pgc.a;

/* JADX INFO: loaded from: classes38.dex */
public class TEEditorInfoInvoker {
    public TEEditorInfoInvoker() {
    }

    public static native void nativeInit();

    static {
        TECodecNativeLibsLoader.d();
    }

    public static void onNativeCallback_onEditorInfoFloat(String r100, float r101) {
        ConcurrentHashMap<String, Object> r102 = a.f529225b;
        if (r102 == null) goto L6;
        r102.put(r100, Float.valueOf(r101));
        return;
    }

    public static void onNativeCallback_onEditorInfoInt(String r100, long r101) {
        a.a(r100, r101);
    }

    public static void onNativeCallback_onEditorInfoJson(String r100, String r101) {
        a.b(r100, r101);
    }

    public static void onNativeCallback_onEditorInfoMap(String r100, HashMap r101) {
        ConcurrentHashMap<String, Object> r102 = a.f529225b;
        if (r102 == null) goto L6;
        r102.put(r100, r101);
        return;
    }
}

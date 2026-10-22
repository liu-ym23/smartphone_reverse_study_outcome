package com.bytedance.speech.speechengine;

import android.content.Context;

/* JADX INFO: loaded from: classes22.dex */
public class SpeechEngineGenerator {
    public static synchronized SpeechEngine getInstance() {
        monitor-enter(SpeechEngineGenerator.class);
        a r100 = new a();     // Catch: Throwable -> L7
        monitor-exit(SpeechEngineGenerator.class);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public SpeechEngineGenerator() {
    }

    public static synchronized boolean isEngineSupported(String r100) {
        monitor-enter(SpeechEngineGenerator.class);
        gf7.a r101 = a.f270320l;     // Catch: Throwable -> L7
        boolean r102 = SpeechEngineLoader.getInstance().createBridge().isEngineSupportedToNative(r100);     // Catch: Throwable -> L7
        monitor-exit(SpeechEngineGenerator.class);
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void initMonitor(Context r100, String r110, String r111, String r112, String r113, String r114, String r115) {
        monitor-enter(SpeechEngineGenerator.class);
        initMonitor(r100, r110, r111, r112, r113, r114, r115, "");     // Catch: Throwable -> L7
        monitor-exit(SpeechEngineGenerator.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void initMonitor(Context r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117) {
        monitor-enter(SpeechEngineGenerator.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (a.d() != null) goto L7;
        gf7.a r100 = new gf7.a();     // Catch: Throwable -> L9
        r100.a(r110, r111, r112, SpeechEngineLoader.getInstance().createBridge().getVersionToNative(), r113, r114, r115, r116, r117);     // Catch: Throwable -> L9
        a.a(r100);     // Catch: Throwable -> L9
    L7:
        monitor-exit(SpeechEngineGenerator.class);
    }
}

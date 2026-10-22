package com.bytedance.retrofit2;

/* JADX INFO: loaded from: classes3.dex */
public class AppActivityResumeSuspendRecorder {
    private static volatile long sAppActivityResumeState;
    private static volatile boolean sAppActivityResumed;

    public AppActivityResumeSuspendRecorder() {
    }

    public static void OnAppActivitySuspend() {
        if (sAppActivityResumed == false) goto L6;
        sAppActivityResumed = false;
        sAppActivityResumeState++;
        return;
    }

    public static void OnAppActiviyResume() {
        if (sAppActivityResumed == true) goto L6;
        sAppActivityResumed = true;
        sAppActivityResumeState++;
        return;
    }

    public static long GetAppActivityResumeState() {
        return sAppActivityResumeState;
    }
}

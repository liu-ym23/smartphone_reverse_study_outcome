package com.bytedance.speech.speechengine;

/* JADX INFO: loaded from: classes22.dex */
public class SpeechResourceManagerGenerator {
    public static synchronized SpeechResourceManager getInstance() {
        monitor-enter(SpeechResourceManagerGenerator.class);
    L6:
        th = move-exception;
        throw th;
    L5:
        throw new RuntimeException("SpeechResourceManager not implemented!");     // Catch: Throwable -> L6
    }

    public SpeechResourceManagerGenerator() {
    }
}

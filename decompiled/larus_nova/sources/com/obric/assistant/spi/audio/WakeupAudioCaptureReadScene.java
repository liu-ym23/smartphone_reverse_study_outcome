package com.obric.assistant.spi.audio;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/assistant/spi/audio/WakeupAudioCaptureReadScene;", "", "<init>", "(Ljava/lang/String;I)V", "REALTIME_CALL", "CONTINUOUS_TALK", "BACKTRACE_ASR", "UPLOAD", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum WakeupAudioCaptureReadScene extends Enum<WakeupAudioCaptureReadScene> {
    public static final WakeupAudioCaptureReadScene BACKTRACE_ASR = null;
    public static final WakeupAudioCaptureReadScene CONTINUOUS_TALK = null;
    public static final WakeupAudioCaptureReadScene REALTIME_CALL = null;
    public static final WakeupAudioCaptureReadScene UPLOAD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WakeupAudioCaptureReadScene[] f392847a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f392848b = null;

    public static EnumEntries<WakeupAudioCaptureReadScene> getEntries() {
        return f392848b;
    }

    static {
        WakeupAudioCaptureReadScene r100 = new WakeupAudioCaptureReadScene("REALTIME_CALL", 0);
        REALTIME_CALL = r100;
        WakeupAudioCaptureReadScene r101 = new WakeupAudioCaptureReadScene("CONTINUOUS_TALK", 1);
        CONTINUOUS_TALK = r101;
        WakeupAudioCaptureReadScene r102 = new WakeupAudioCaptureReadScene("BACKTRACE_ASR", 2);
        BACKTRACE_ASR = r102;
        WakeupAudioCaptureReadScene r103 = new WakeupAudioCaptureReadScene("UPLOAD", 3);
        UPLOAD = r103;
        WakeupAudioCaptureReadScene[] r104 = {r100, r101, r102, r103};
        f392847a = r104;
        f392848b = EnumEntriesKt.enumEntries(r104);
    }

    public static WakeupAudioCaptureReadScene[] values() {
        return (WakeupAudioCaptureReadScene[]) f392847a.clone();
    }

    public static WakeupAudioCaptureReadScene valueOf(String r100) {
        return (WakeupAudioCaptureReadScene) r27.a.a(WakeupAudioCaptureReadScene.class, r100);
    }

    public WakeupAudioCaptureReadScene(String r100, int r101) {
        super(r100, r101);
    }
}

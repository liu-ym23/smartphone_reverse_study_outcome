package com.bytedance.applet.audio.background;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/applet/audio/background/BackgroundAudioEventName;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CANPLAY", "PLAY", "PAUSE", "STOP", "ENDED", "TIMEUPDATE", "ERROR", "WAITING", "SEEKING", "SEEKED", "PREV", "NEXT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BackgroundAudioEventName extends Enum<BackgroundAudioEventName> {
    public static final BackgroundAudioEventName CANPLAY = null;
    public static final BackgroundAudioEventName ENDED = null;
    public static final BackgroundAudioEventName ERROR = null;
    public static final BackgroundAudioEventName NEXT = null;
    public static final BackgroundAudioEventName PAUSE = null;
    public static final BackgroundAudioEventName PLAY = null;
    public static final BackgroundAudioEventName PREV = null;
    public static final BackgroundAudioEventName SEEKED = null;
    public static final BackgroundAudioEventName SEEKING = null;
    public static final BackgroundAudioEventName STOP = null;
    public static final BackgroundAudioEventName TIMEUPDATE = null;
    public static final BackgroundAudioEventName WAITING = null;
    public static final /* synthetic */ BackgroundAudioEventName[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<BackgroundAudioEventName> getEntries() {
        return b;
    }

    static {
        BackgroundAudioEventName r0 = new BackgroundAudioEventName("CANPLAY", 0, "canplay");
        CANPLAY = r0;
        BackgroundAudioEventName r1 = new BackgroundAudioEventName("PLAY", 1, "play");
        PLAY = r1;
        BackgroundAudioEventName r2 = new BackgroundAudioEventName("PAUSE", 2, "pause");
        PAUSE = r2;
        BackgroundAudioEventName r4 = new BackgroundAudioEventName("STOP", 3, "stop");
        STOP = r4;
        BackgroundAudioEventName r6 = new BackgroundAudioEventName("ENDED", 4, "ended");
        ENDED = r6;
        BackgroundAudioEventName r8 = new BackgroundAudioEventName("TIMEUPDATE", 5, "timeupdate");
        TIMEUPDATE = r8;
        BackgroundAudioEventName r10 = new BackgroundAudioEventName("ERROR", 6, "error");
        ERROR = r10;
        BackgroundAudioEventName r12 = new BackgroundAudioEventName("WAITING", 7, "waiting");
        WAITING = r12;
        BackgroundAudioEventName r14 = new BackgroundAudioEventName("SEEKING", 8, "seeking");
        SEEKING = r14;
        BackgroundAudioEventName r13 = new BackgroundAudioEventName("SEEKED", 9, "seeked");
        SEEKED = r13;
        BackgroundAudioEventName r11 = new BackgroundAudioEventName("PREV", 10, "prev");
        PREV = r11;
        BackgroundAudioEventName r9 = new BackgroundAudioEventName("NEXT", 11, "next");
        NEXT = r9;
        BackgroundAudioEventName[] r7 = {r0, r1, r2, r4, r6, r8, r10, r12, r14, r13, r11, r9};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static BackgroundAudioEventName[] values() {
        return (BackgroundAudioEventName[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static BackgroundAudioEventName valueOf(String r1) {
        return (BackgroundAudioEventName) r27.a.a(BackgroundAudioEventName.class, r1);
    }

    public BackgroundAudioEventName(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}

package com.bytedance.applet.audio.inner;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/applet/audio/inner/InnerAudioEventName;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CANPLAY", "PLAY", "PAUSE", "STOP", "ENDED", "TIMEUPDATE", "ERROR", "WAITING", "SEEKING", "SEEKED", "DESTROY", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum InnerAudioEventName extends Enum<InnerAudioEventName> {
    public static final InnerAudioEventName CANPLAY = null;
    public static final InnerAudioEventName DESTROY = null;
    public static final InnerAudioEventName ENDED = null;
    public static final InnerAudioEventName ERROR = null;
    public static final InnerAudioEventName PAUSE = null;
    public static final InnerAudioEventName PLAY = null;
    public static final InnerAudioEventName SEEKED = null;
    public static final InnerAudioEventName SEEKING = null;
    public static final InnerAudioEventName STOP = null;
    public static final InnerAudioEventName TIMEUPDATE = null;
    public static final InnerAudioEventName WAITING = null;
    public static final /* synthetic */ InnerAudioEventName[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<InnerAudioEventName> getEntries() {
        return b;
    }

    static {
        InnerAudioEventName r0 = new InnerAudioEventName("CANPLAY", 0, "canplay");
        CANPLAY = r0;
        InnerAudioEventName r1 = new InnerAudioEventName("PLAY", 1, "play");
        PLAY = r1;
        InnerAudioEventName r2 = new InnerAudioEventName("PAUSE", 2, "pause");
        PAUSE = r2;
        InnerAudioEventName r4 = new InnerAudioEventName("STOP", 3, "stop");
        STOP = r4;
        InnerAudioEventName r6 = new InnerAudioEventName("ENDED", 4, "ended");
        ENDED = r6;
        InnerAudioEventName r8 = new InnerAudioEventName("TIMEUPDATE", 5, "timeupdate");
        TIMEUPDATE = r8;
        InnerAudioEventName r10 = new InnerAudioEventName("ERROR", 6, "error");
        ERROR = r10;
        InnerAudioEventName r12 = new InnerAudioEventName("WAITING", 7, "waiting");
        WAITING = r12;
        InnerAudioEventName r14 = new InnerAudioEventName("SEEKING", 8, "seeking");
        SEEKING = r14;
        InnerAudioEventName r13 = new InnerAudioEventName("SEEKED", 9, "seeked");
        SEEKED = r13;
        InnerAudioEventName r11 = new InnerAudioEventName("DESTROY", 10, "destroy");
        DESTROY = r11;
        InnerAudioEventName[] r9 = {r0, r1, r2, r4, r6, r8, r10, r12, r14, r13, r11};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static InnerAudioEventName[] values() {
        return (InnerAudioEventName[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static InnerAudioEventName valueOf(String r1) {
        return (InnerAudioEventName) a.a(InnerAudioEventName.class, r1);
    }

    public InnerAudioEventName(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}

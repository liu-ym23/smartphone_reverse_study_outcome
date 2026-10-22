package com.bytedance.applet.audio.inner;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/applet/audio/inner/InnerAudioPlaybackState;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "STOPPED", "PAUSED", "PLAYING", "INTERRUPTED", "ERROR", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum InnerAudioPlaybackState extends Enum<InnerAudioPlaybackState> {
    public static final InnerAudioPlaybackState ERROR = null;
    public static final InnerAudioPlaybackState INTERRUPTED = null;
    public static final InnerAudioPlaybackState PAUSED = null;
    public static final InnerAudioPlaybackState PLAYING = null;
    public static final InnerAudioPlaybackState STOPPED = null;
    public static final /* synthetic */ InnerAudioPlaybackState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<InnerAudioPlaybackState> getEntries() {
        return b;
    }

    static {
        InnerAudioPlaybackState r0 = new InnerAudioPlaybackState("STOPPED", 0, "stopped");
        STOPPED = r0;
        InnerAudioPlaybackState r1 = new InnerAudioPlaybackState("PAUSED", 1, "paused");
        PAUSED = r1;
        InnerAudioPlaybackState r2 = new InnerAudioPlaybackState("PLAYING", 2, "playing");
        PLAYING = r2;
        InnerAudioPlaybackState r4 = new InnerAudioPlaybackState("INTERRUPTED", 3, "interrupted");
        INTERRUPTED = r4;
        InnerAudioPlaybackState r6 = new InnerAudioPlaybackState("ERROR", 4, "error");
        ERROR = r6;
        InnerAudioPlaybackState[] r8 = {r0, r1, r2, r4, r6};
        a = r8;
        b = EnumEntriesKt.enumEntries(r8);
    }

    public static InnerAudioPlaybackState[] values() {
        return (InnerAudioPlaybackState[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static InnerAudioPlaybackState valueOf(String r1) {
        return (InnerAudioPlaybackState) a.a(InnerAudioPlaybackState.class, r1);
    }

    public InnerAudioPlaybackState(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}

package com.bytedance.applet.audio.background;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/applet/audio/background/BackgroundAudioPlaybackState;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "STOPPED", "PAUSED", "PLAYING", "ERROR", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BackgroundAudioPlaybackState extends Enum<BackgroundAudioPlaybackState> {
    public static final BackgroundAudioPlaybackState ERROR = null;
    public static final BackgroundAudioPlaybackState PAUSED = null;
    public static final BackgroundAudioPlaybackState PLAYING = null;
    public static final BackgroundAudioPlaybackState STOPPED = null;
    public static final /* synthetic */ BackgroundAudioPlaybackState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<BackgroundAudioPlaybackState> getEntries() {
        return b;
    }

    static {
        BackgroundAudioPlaybackState r0 = new BackgroundAudioPlaybackState("STOPPED", 0, "stopped");
        STOPPED = r0;
        BackgroundAudioPlaybackState r1 = new BackgroundAudioPlaybackState("PAUSED", 1, "paused");
        PAUSED = r1;
        BackgroundAudioPlaybackState r2 = new BackgroundAudioPlaybackState("PLAYING", 2, "playing");
        PLAYING = r2;
        BackgroundAudioPlaybackState r4 = new BackgroundAudioPlaybackState("ERROR", 3, "error");
        ERROR = r4;
        BackgroundAudioPlaybackState[] r6 = {r0, r1, r2, r4};
        a = r6;
        b = EnumEntriesKt.enumEntries(r6);
    }

    public static BackgroundAudioPlaybackState[] values() {
        return (BackgroundAudioPlaybackState[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static BackgroundAudioPlaybackState valueOf(String r1) {
        return (BackgroundAudioPlaybackState) r27.a.a(BackgroundAudioPlaybackState.class, r1);
    }

    public BackgroundAudioPlaybackState(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}

package com.bytedance.applet.task;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/applet/task/PlaybackState;", "", "<init>", "(Ljava/lang/String;I)V", "PLAYING", "PAUSED", "STOPPED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PlaybackState extends Enum<PlaybackState> {
    public static final PlaybackState PAUSED = null;
    public static final PlaybackState PLAYING = null;
    public static final PlaybackState STOPPED = null;
    public static final /* synthetic */ PlaybackState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<PlaybackState> getEntries() {
        return b;
    }

    static {
        PlaybackState r0 = new PlaybackState("PLAYING", 0);
        PLAYING = r0;
        PlaybackState r1 = new PlaybackState("PAUSED", 1);
        PAUSED = r1;
        PlaybackState r3 = new PlaybackState("STOPPED", 2);
        STOPPED = r3;
        PlaybackState[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static PlaybackState[] values() {
        return (PlaybackState[]) a.clone();
    }

    public static PlaybackState valueOf(String r1) {
        return (PlaybackState) r27.a.a(PlaybackState.class, r1);
    }

    public PlaybackState(String r1, int r2) {
        super(r1, r2);
    }
}

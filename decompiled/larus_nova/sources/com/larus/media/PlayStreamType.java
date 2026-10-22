package com.larus.media;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/media/PlayStreamType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "STREAM_VOICE_CALL", "STREAM_MUSIC", "OApp.flowSDK.baseSDK.common.avsdk-media"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PlayStreamType extends Enum<PlayStreamType> {
    public static final PlayStreamType STREAM_MUSIC = null;
    public static final PlayStreamType STREAM_VOICE_CALL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PlayStreamType[] f358969a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f358970b = null;
    private final int value;

    public static EnumEntries<PlayStreamType> getEntries() {
        return f358970b;
    }

    static {
        PlayStreamType r100 = new PlayStreamType("STREAM_VOICE_CALL", 0, 0);
        STREAM_VOICE_CALL = r100;
        PlayStreamType r101 = new PlayStreamType("STREAM_MUSIC", 1, 3);
        STREAM_MUSIC = r101;
        PlayStreamType[] r102 = {r100, r101};
        f358969a = r102;
        f358970b = EnumEntriesKt.enumEntries(r102);
    }

    public static PlayStreamType[] values() {
        return (PlayStreamType[]) f358969a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static PlayStreamType valueOf(String r100) {
        return (PlayStreamType) r27.a.a(PlayStreamType.class, r100);
    }

    public PlayStreamType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

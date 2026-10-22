package com.bytedance.manager;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/manager/TtsFinishPlayingType;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "PLAY_DONE", "flow_audio_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TtsFinishPlayingType extends Enum<TtsFinishPlayingType> {
    public static final TtsFinishPlayingType PLAY_DONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TtsFinishPlayingType[] f265473a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f265474b = null;
    private final String type;

    public static EnumEntries<TtsFinishPlayingType> getEntries() {
        return f265474b;
    }

    static {
        TtsFinishPlayingType r100 = new TtsFinishPlayingType();
        PLAY_DONE = r100;
        TtsFinishPlayingType[] r101 = {r100};
        f265473a = r101;
        f265474b = EnumEntriesKt.enumEntries(r101);
    }

    public TtsFinishPlayingType() {
        super("PLAY_DONE", 0);
        this.type = "play_done";
    }

    public static TtsFinishPlayingType[] values() {
        return (TtsFinishPlayingType[]) f265473a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public static TtsFinishPlayingType valueOf(String r100) {
        return (TtsFinishPlayingType) r27.a.a(TtsFinishPlayingType.class, r100);
    }
}

package com.larus.media;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/media/PlayUsageType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "MEDIA", "VOICE_COMMUNICATION", "OApp.flowSDK.baseSDK.common.avsdk-media"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PlayUsageType extends Enum<PlayUsageType> {
    public static final PlayUsageType MEDIA = null;
    public static final PlayUsageType VOICE_COMMUNICATION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PlayUsageType[] f358971a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f358972b = null;
    private final int value;

    public static EnumEntries<PlayUsageType> getEntries() {
        return f358972b;
    }

    static {
        PlayUsageType r100 = new PlayUsageType("MEDIA", 0, 1);
        MEDIA = r100;
        PlayUsageType r101 = new PlayUsageType("VOICE_COMMUNICATION", 1, 2);
        VOICE_COMMUNICATION = r101;
        PlayUsageType[] r102 = {r100, r101};
        f358971a = r102;
        f358972b = EnumEntriesKt.enumEntries(r102);
    }

    public static PlayUsageType[] values() {
        return (PlayUsageType[]) f358971a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static PlayUsageType valueOf(String r100) {
        return (PlayUsageType) r27.a.a(PlayUsageType.class, r100);
    }

    public PlayUsageType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

package com.larus.video.impl.sdk.eventlog;

import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/video/impl/sdk/eventlog/PlayUploadStatus;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", FeatureConfigInfo.PLAY_FEATURE_TYPE_ID, "PAUSE", "STOP", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PlayUploadStatus extends Enum<PlayUploadStatus> {
    public static final PlayUploadStatus PAUSE = null;
    public static final PlayUploadStatus PLAY = null;
    public static final PlayUploadStatus STOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PlayUploadStatus[] f375794a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f375795b = null;
    private final String value;

    public static EnumEntries<PlayUploadStatus> getEntries() {
        return f375795b;
    }

    static {
        PlayUploadStatus r100 = new PlayUploadStatus(FeatureConfigInfo.PLAY_FEATURE_TYPE_ID, 0, "play");
        PLAY = r100;
        PlayUploadStatus r101 = new PlayUploadStatus("PAUSE", 1, "pause");
        PAUSE = r101;
        PlayUploadStatus r102 = new PlayUploadStatus("STOP", 2, "stop");
        STOP = r102;
        PlayUploadStatus[] r103 = {r100, r101, r102};
        f375794a = r103;
        f375795b = EnumEntriesKt.enumEntries(r103);
    }

    public static PlayUploadStatus[] values() {
        return (PlayUploadStatus[]) f375794a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static PlayUploadStatus valueOf(String r100) {
        return (PlayUploadStatus) a.a(PlayUploadStatus.class, r100);
    }

    public PlayUploadStatus(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}

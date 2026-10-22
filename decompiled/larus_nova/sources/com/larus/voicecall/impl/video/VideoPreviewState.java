package com.larus.voicecall.impl.video;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/voicecall/impl/video/VideoPreviewState;", "", "<init>", "(Ljava/lang/String;I)V", "close", "full", "pip", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VideoPreviewState extends Enum<VideoPreviewState> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VideoPreviewState[] f379570a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f379571b = null;
    public static final VideoPreviewState close = null;
    public static final VideoPreviewState full = null;
    public static final VideoPreviewState pip = null;

    public static EnumEntries<VideoPreviewState> getEntries() {
        return f379571b;
    }

    static {
        VideoPreviewState r100 = new VideoPreviewState("close", 0);
        close = r100;
        VideoPreviewState r101 = new VideoPreviewState("full", 1);
        full = r101;
        VideoPreviewState r102 = new VideoPreviewState("pip", 2);
        pip = r102;
        VideoPreviewState[] r103 = {r100, r101, r102};
        f379570a = r103;
        f379571b = EnumEntriesKt.enumEntries(r103);
    }

    public static VideoPreviewState[] values() {
        return (VideoPreviewState[]) f379570a.clone();
    }

    public static VideoPreviewState valueOf(String r100) {
        return (VideoPreviewState) r27.a.a(VideoPreviewState.class, r100);
    }

    public VideoPreviewState(String r100, int r101) {
        super(r100, r101);
    }
}

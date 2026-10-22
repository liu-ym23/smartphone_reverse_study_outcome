package com.larus.im.service.audio.vlm;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/im/service/audio/vlm/VideoFrameBufferType;", "", "<init>", "(Ljava/lang/String;I)V", "GL_TEXTURE", "GL_TEXTURE_OES", "flow-avsdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VideoFrameBufferType extends Enum<VideoFrameBufferType> {
    public static final VideoFrameBufferType GL_TEXTURE = null;
    public static final VideoFrameBufferType GL_TEXTURE_OES = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VideoFrameBufferType[] f350803a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f350804b = null;

    public static EnumEntries<VideoFrameBufferType> getEntries() {
        return f350804b;
    }

    static {
        VideoFrameBufferType r100 = new VideoFrameBufferType("GL_TEXTURE", 0);
        GL_TEXTURE = r100;
        VideoFrameBufferType r101 = new VideoFrameBufferType("GL_TEXTURE_OES", 1);
        GL_TEXTURE_OES = r101;
        VideoFrameBufferType[] r102 = {r100, r101};
        f350803a = r102;
        f350804b = EnumEntriesKt.enumEntries(r102);
    }

    public static VideoFrameBufferType[] values() {
        return (VideoFrameBufferType[]) f350803a.clone();
    }

    public static VideoFrameBufferType valueOf(String r100) {
        return (VideoFrameBufferType) a.a(VideoFrameBufferType.class, r100);
    }

    public VideoFrameBufferType(String r100, int r101) {
        super(r100, r101);
    }
}

package com.bytedance.cloudplay.xplay2.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/cloudplay/xplay2/api/VideoBufferType;", "", "", "value", "I", "getValue", "()I", "RAW_MEMORY", "GL_TEXTURE", "xplay2-api_release"}, k = 1, mv = {1, 8, 0})
public final enum VideoBufferType extends Enum<VideoBufferType> {
    public static final VideoBufferType GL_TEXTURE = null;
    public static final VideoBufferType RAW_MEMORY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VideoBufferType[] f202790a = null;
    private final int value;

    public static VideoBufferType valueOf(String r100) {
        return (VideoBufferType) a.a(VideoBufferType.class, r100);
    }

    public static VideoBufferType[] values() {
        return (VideoBufferType[]) f202790a.clone();
    }

    static {
        VideoBufferType r100 = new VideoBufferType("RAW_MEMORY", 0, 1);
        RAW_MEMORY = r100;
        VideoBufferType r101 = new VideoBufferType("GL_TEXTURE", 1, 3);
        GL_TEXTURE = r101;
        f202790a = new VideoBufferType[]{r100, r101};
    }

    public final int getValue() {
        return this.value;
    }

    public VideoBufferType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

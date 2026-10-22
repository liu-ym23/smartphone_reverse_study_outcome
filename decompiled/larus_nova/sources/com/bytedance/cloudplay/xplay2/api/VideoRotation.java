package com.bytedance.cloudplay.xplay2.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/cloudplay/xplay2/api/VideoRotation;", "", "", "value", "I", "getValue", "()I", "VIDEO_ROTATION_0", "VIDEO_ROTATION_90", "VIDEO_ROTATION_180", "VIDEO_ROTATION_270", "xplay2-api_release"}, k = 1, mv = {1, 8, 0})
public final enum VideoRotation extends Enum<VideoRotation> {
    public static final VideoRotation VIDEO_ROTATION_0 = null;
    public static final VideoRotation VIDEO_ROTATION_180 = null;
    public static final VideoRotation VIDEO_ROTATION_270 = null;
    public static final VideoRotation VIDEO_ROTATION_90 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VideoRotation[] f202793a = null;
    private final int value;

    public static VideoRotation valueOf(String r100) {
        return (VideoRotation) a.a(VideoRotation.class, r100);
    }

    public static VideoRotation[] values() {
        return (VideoRotation[]) f202793a.clone();
    }

    static {
        VideoRotation r100 = new VideoRotation("VIDEO_ROTATION_0", 0, 1);
        VIDEO_ROTATION_0 = r100;
        VideoRotation r101 = new VideoRotation("VIDEO_ROTATION_90", 1, 2);
        VIDEO_ROTATION_90 = r101;
        VideoRotation r102 = new VideoRotation("VIDEO_ROTATION_180", 2, 3);
        VIDEO_ROTATION_180 = r102;
        VideoRotation r103 = new VideoRotation("VIDEO_ROTATION_270", 3, 4);
        VIDEO_ROTATION_270 = r103;
        f202793a = new VideoRotation[]{r100, r101, r102, r103};
    }

    public final int getValue() {
        return this.value;
    }

    public VideoRotation(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

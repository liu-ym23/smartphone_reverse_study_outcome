package com.bytedance.awemeopen.apps.framework.card.helper;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/card/helper/VideoCardFetchType;", "", "LANDSCAPE_VIDEO", "PORTRAIT_VIDEO", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final enum VideoCardFetchType extends Enum<VideoCardFetchType> {
    public static final VideoCardFetchType LANDSCAPE_VIDEO = null;
    public static final VideoCardFetchType PORTRAIT_VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VideoCardFetchType[] f193829a = null;

    public static VideoCardFetchType valueOf(String r100) {
        return (VideoCardFetchType) a.a(VideoCardFetchType.class, r100);
    }

    public static VideoCardFetchType[] values() {
        return (VideoCardFetchType[]) f193829a.clone();
    }

    static {
        VideoCardFetchType r100 = new VideoCardFetchType("LANDSCAPE_VIDEO", 0);
        LANDSCAPE_VIDEO = r100;
        VideoCardFetchType r101 = new VideoCardFetchType("PORTRAIT_VIDEO", 1);
        PORTRAIT_VIDEO = r101;
        f193829a = new VideoCardFetchType[]{r100, r101};
    }

    public VideoCardFetchType(String r100, int r101) {
        super(r100, r101);
    }
}

package com.bytedance.awemeopen.infra.base.player.resize;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/awemeopen/infra/base/player/resize/VideoScaleModel;", "", "FILL", "FIT", "ao_base_core_release"}, k = 1, mv = {1, 7, 1})
public final enum VideoScaleModel extends Enum<VideoScaleModel> {
    public static final VideoScaleModel FILL = null;
    public static final VideoScaleModel FIT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VideoScaleModel[] f198781a = null;

    public static VideoScaleModel valueOf(String r100) {
        return (VideoScaleModel) a.a(VideoScaleModel.class, r100);
    }

    public static VideoScaleModel[] values() {
        return (VideoScaleModel[]) f198781a.clone();
    }

    static {
        VideoScaleModel r100 = new VideoScaleModel("FILL", 0);
        FILL = r100;
        VideoScaleModel r101 = new VideoScaleModel("FIT", 1);
        FIT = r101;
        f198781a = new VideoScaleModel[]{r100, r101};
    }

    public VideoScaleModel(String r100, int r101) {
        super(r100, r101);
    }
}

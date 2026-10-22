package com.ss.bytedance.ies.videoclip.api.track;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u0000 \u00022\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/bytedance/ies/videoclip/api/track/VideoConfigurationContentMode;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "aspectFit", "aspectFill", "scaleToFit", "videoclip-api-0.0.0.2-alpha.93@aar_release"}, k = 1, mv = {1, 4, 0})
public final enum VideoConfigurationContentMode extends Enum<VideoConfigurationContentMode> {
    public static final int ASPECT_FILL = 1;
    public static final int ASPECT_FIT = 0;
    public static final a Companion = null;
    public static final int SCALE_TO_FIT = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VideoConfigurationContentMode[] f456079a = null;
    public static final VideoConfigurationContentMode aspectFill = null;
    public static final VideoConfigurationContentMode aspectFit = null;
    public static final VideoConfigurationContentMode scaleToFit = null;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.bytedance.ies.videoclip.api.track.VideoConfigurationContentMode$a] */
    static {
        VideoConfigurationContentMode r100 = new VideoConfigurationContentMode("aspectFit", 0);
        aspectFit = r100;
        VideoConfigurationContentMode r101 = new VideoConfigurationContentMode("aspectFill", 1);
        aspectFill = r101;
        VideoConfigurationContentMode r102 = new VideoConfigurationContentMode("scaleToFit", 2);
        scaleToFit = r102;
        f456079a = new VideoConfigurationContentMode[]{r100, r101, r102};
        Companion = new a();
    }

    public static VideoConfigurationContentMode valueOf(String r100) {
        return (VideoConfigurationContentMode) r27.a.a(VideoConfigurationContentMode.class, r100);
    }

    public static VideoConfigurationContentMode[] values() {
        return (VideoConfigurationContentMode[]) f456079a.clone();
    }

    public VideoConfigurationContentMode(String r100, int r101) {
        super(r100, r101);
    }
}

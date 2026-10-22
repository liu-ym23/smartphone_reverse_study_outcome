package qh6;

import com.bytedance.kmp.live.livelink.api.model.VideoShowMode;

/* JADX INFO: loaded from: classes19.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f532969a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f532970b = null;

    static {
        int[] r100 = new int[VideoShowMode.values().length];
        f532969a = r100;
        VideoShowMode r101 = VideoShowMode.VIDEO;
        r100[r101.ordinal()] = 1;
        VideoShowMode r102 = VideoShowMode.AUDIO;
        r100[r102.ordinal()] = 2;
        VideoShowMode r103 = VideoShowMode.DIGIT_AVATAR;
        r100[r103.ordinal()] = 3;
        int[] r104 = new int[VideoShowMode.values().length];
        f532970b = r104;
        r104[r101.ordinal()] = 1;
        r104[r102.ordinal()] = 2;
        r104[r103.ordinal()] = 3;
    }
}

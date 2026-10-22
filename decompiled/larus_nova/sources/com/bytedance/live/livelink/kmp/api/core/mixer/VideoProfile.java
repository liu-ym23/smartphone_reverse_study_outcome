package com.bytedance.live.livelink.kmp.api.core.mixer;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/live/livelink/kmp/api/core/mixer/VideoProfile;", "", "BASELINE", AccountType.MAIN, "HIGH", "live-link-kmp-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum VideoProfile extends Enum<VideoProfile> {
    public static final VideoProfile BASELINE = null;
    public static final VideoProfile HIGH = null;
    public static final VideoProfile MAIN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VideoProfile[] f255256a = null;

    static {
        VideoProfile r100 = new VideoProfile("BASELINE", 0);
        BASELINE = r100;
        VideoProfile r101 = new VideoProfile(AccountType.MAIN, 1);
        MAIN = r101;
        VideoProfile r102 = new VideoProfile("HIGH", 2);
        HIGH = r102;
        f255256a = new VideoProfile[]{r100, r101, r102};
    }

    public static VideoProfile valueOf(String r100) {
        return (VideoProfile) a.a(VideoProfile.class, r100);
    }

    public static VideoProfile[] values() {
        return (VideoProfile[]) f255256a.clone();
    }

    public VideoProfile(String r100, int r101) {
        super(r100, r101);
    }
}

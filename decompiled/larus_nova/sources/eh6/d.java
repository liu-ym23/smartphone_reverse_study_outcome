package eh6;

import com.bytedance.live.livelink.kmp.api.core.mixer.MixStreamType;

/* JADX INFO: loaded from: classes19.dex */
public final /* synthetic */ class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f472659a = null;

    static {
        int[] r100 = new int[MixStreamType.values().length];
        f472659a = r100;
        r100[MixStreamType.SERVER_MIX.ordinal()] = 1;
        r100[MixStreamType.CLIENT_MIX.ordinal()] = 2;
        r100[MixStreamType.RTC_CLIENT_MIX.ordinal()] = 3;
    }
}

package y50;

import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;

/* JADX INFO: loaded from: classes45.dex */
public final /* synthetic */ class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f566223a = null;

    static {
        int[] r100 = new int[LiveMode.values().length];
        LiveMode r101 = LiveMode.VIDEO;
        r100[r101.ordinal()] = 1;
        LiveMode r102 = LiveMode.AUDIO;
        r100[r102.ordinal()] = 2;
        LiveMode r103 = LiveMode.SCREEN_RECORD;
        r100[r103.ordinal()] = 3;
        LiveMode r104 = LiveMode.THIRD_PARTY;
        r100[r104.ordinal()] = 4;
        LiveMode r105 = LiveMode.MEDIA;
        r100[r105.ordinal()] = 5;
        r100[LiveMode.ACQUAINTANCE.ordinal()] = 6;
        r100[LiveMode.OFFICIAL_ACTIVITY.ordinal()] = 7;
        int[] r106 = new int[LiveMode.values().length];
        f566223a = r106;
        r106[r101.ordinal()] = 1;
        r106[r103.ordinal()] = 2;
        r106[r104.ordinal()] = 3;
        r106[r102.ordinal()] = 4;
        r106[r105.ordinal()] = 5;
    }
}

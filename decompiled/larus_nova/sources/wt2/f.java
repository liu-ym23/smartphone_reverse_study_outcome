package wt2;

import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;

/* JADX INFO: loaded from: classes11.dex */
public final /* synthetic */ class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f561187a = null;

    static {
        int[] r100 = new int[LiveMode.values().length];
        f561187a = r100;
        r100[LiveMode.VIDEO.ordinal()] = 1;
        r100[LiveMode.THIRD_PARTY.ordinal()] = 2;
        r100[LiveMode.SCREEN_RECORD.ordinal()] = 3;
        r100[LiveMode.MEDIA.ordinal()] = 4;
        r100[LiveMode.OFFICIAL_ACTIVITY.ordinal()] = 5;
    }
}

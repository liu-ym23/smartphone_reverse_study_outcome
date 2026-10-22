package gr2;

import com.bytedance.android.livesdk.revenue.service.livecore.IRegion;

/* JADX INFO: loaded from: classes11.dex */
public final /* synthetic */ class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f482324a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f482325b = null;

    static {
        int[] r100 = new int[IRegion.Status.values().length];
        f482324a = r100;
        r100[IRegion.Status.FOREGROUND.ordinal()] = 1;
        r100[IRegion.Status.BACKGROUND.ordinal()] = 2;
        r100[IRegion.Status.GAMEFULL.ordinal()] = 3;
        int[] r101 = new int[IRegion.Type.values().length];
        f482325b = r101;
        r101[IRegion.Type.AUDIO.ordinal()] = 1;
        r101[IRegion.Type.VIDEO.ordinal()] = 2;
    }
}

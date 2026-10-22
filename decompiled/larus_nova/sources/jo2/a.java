package jo2;

import com.bytedance.android.livesdk.performance.scrollstall.ScrollState;

/* JADX INFO: loaded from: classes11.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f499832a = null;

    static {
        int[] r100 = new int[ScrollState.values().length];
        f499832a = r100;
        r100[ScrollState.DRAG.ordinal()] = 1;
        r100[ScrollState.FLING.ordinal()] = 2;
        r100[ScrollState.FULL.ordinal()] = 3;
        r100[ScrollState.SCROLL_FINISHED.ordinal()] = 4;
    }
}

package mn;

import com.bytedance.android.ec.store.utils.playable.controller.playcontrol.PlayControlStrategy;

/* JADX INFO: loaded from: classes44.dex */
public final /* synthetic */ class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f514509a = null;

    static {
        int[] r100 = new int[PlayControlStrategy.values().length];
        f514509a = r100;
        r100[PlayControlStrategy.KEEP_LAST.ordinal()] = 1;
        r100[PlayControlStrategy.ORDER_FIRST.ordinal()] = 2;
        r100[PlayControlStrategy.ORDER_FIRST_IMAGE.ordinal()] = 3;
        r100[PlayControlStrategy.ALL_SAME.ordinal()] = 4;
    }
}

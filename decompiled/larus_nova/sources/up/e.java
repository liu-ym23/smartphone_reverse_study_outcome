package up;

import com.bytedance.android.ec.window.base.utils.playable.controller.playcontrol.WindowPlayControlStrategy;

/* JADX INFO: loaded from: classes44.dex */
public final /* synthetic */ class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f550981a = null;

    static {
        int[] r100 = new int[WindowPlayControlStrategy.values().length];
        f550981a = r100;
        r100[WindowPlayControlStrategy.KEEP_LAST.ordinal()] = 1;
        r100[WindowPlayControlStrategy.ORDER_FIRST.ordinal()] = 2;
        r100[WindowPlayControlStrategy.ORDER_FIRST_IMAGE.ordinal()] = 3;
    }
}

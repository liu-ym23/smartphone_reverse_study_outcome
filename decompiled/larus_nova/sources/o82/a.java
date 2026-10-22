package o82;

import com.bytedance.android.livesdk.interactivity.interactive.utils.MovingType;

/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f522339a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f522340b = null;

    static {
        int[] r100 = new int[MovingType.values().length];
        f522339a = r100;
        r100[MovingType.MOVE_TO_LEFT.ordinal()] = 1;
        r100[MovingType.MOVE_TO_RIGHT.ordinal()] = 2;
        MovingType r101 = MovingType.STOP;
        r100[r101.ordinal()] = 3;
        MovingType r102 = MovingType.DEFAULT;
        r100[r102.ordinal()] = 4;
        int[] r103 = new int[MovingType.values().length];
        f522340b = r103;
        r103[MovingType.MOVE_TO_TOP.ordinal()] = 1;
        r103[MovingType.MOVE_TO_BOTTOM.ordinal()] = 2;
        r103[r101.ordinal()] = 3;
        r103[r102.ordinal()] = 4;
    }
}

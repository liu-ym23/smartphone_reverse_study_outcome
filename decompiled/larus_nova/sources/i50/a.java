package i50;

import com.bytedance.android.live.core.gl.camera.BaseCamera;

/* JADX INFO: loaded from: classes45.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f488273a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f488274b = null;

    static {
        int[] r100 = new int[BaseCamera.ClampType.values().length];
        f488273a = r100;
        BaseCamera.ClampType r101 = BaseCamera.ClampType.HORIZONTAL;
        r100[r101.ordinal()] = 1;
        BaseCamera.ClampType r102 = BaseCamera.ClampType.VERTICAL;
        r100[r102.ordinal()] = 2;
        BaseCamera.ClampType r103 = BaseCamera.ClampType.INNER_BORDER;
        r100[r103.ordinal()] = 3;
        BaseCamera.ClampType r104 = BaseCamera.ClampType.OUTER_BORDER;
        r100[r104.ordinal()] = 4;
        int[] r105 = new int[BaseCamera.ClampType.values().length];
        f488274b = r105;
        r105[r101.ordinal()] = 1;
        r105[r102.ordinal()] = 2;
        r105[r103.ordinal()] = 3;
        r105[r104.ordinal()] = 4;
    }
}

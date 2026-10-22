package ka1;

import com.bytedance.android.live.schema.convert.HybridType;
import com.bytedance.android.live.schema.convert.HybridUiType;

/* JADX INFO: loaded from: classes47.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f502174a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f502175b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f502176c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int[] f502177d = null;

    static {
        int[] r100 = new int[HybridType.values().length];
        f502174a = r100;
        r100[HybridType.H5.ordinal()] = 1;
        r100[HybridType.Lynx.ordinal()] = 2;
        r100[HybridType.COMMON.ordinal()] = 3;
        int[] r101 = new int[HybridUiType.values().length];
        f502175b = r101;
        HybridUiType r102 = HybridUiType.FULLSCREEN;
        r101[r102.ordinal()] = 1;
        HybridUiType r103 = HybridUiType.POPUP;
        r101[r103.ordinal()] = 2;
        int[] r104 = new int[HybridUiType.values().length];
        f502176c = r104;
        r104[r102.ordinal()] = 1;
        r104[r103.ordinal()] = 2;
        int[] r105 = new int[HybridUiType.values().length];
        f502177d = r105;
        r105[r102.ordinal()] = 1;
        r105[r103.ordinal()] = 2;
    }
}

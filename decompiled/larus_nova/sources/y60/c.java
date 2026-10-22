package y60;

import com.bytedance.android.live.core.setting.v2.cache.ICacheManger;

/* JADX INFO: loaded from: classes45.dex */
public final /* synthetic */ class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f566308a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f566309b = null;

    static {
        int[] r100 = new int[ICacheManger.Operation.values().length];
        f566308a = r100;
        ICacheManger.Operation r101 = ICacheManger.Operation.PLUS;
        r100[r101.ordinal()] = 1;
        ICacheManger.Operation r102 = ICacheManger.Operation.MINUS;
        r100[r102.ordinal()] = 2;
        int[] r103 = new int[ICacheManger.Operation.values().length];
        f566309b = r103;
        r103[r101.ordinal()] = 1;
        r103[r102.ordinal()] = 2;
    }
}

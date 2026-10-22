package fp;

import com.bytedance.android.ec.window.base.search.datasource.WindowLoadEvent;

/* JADX INFO: loaded from: classes44.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f478207a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f478208b = null;

    static {
        int[] r100 = new int[WindowLoadEvent.values().length];
        f478207a = r100;
        r100[WindowLoadEvent.NORMAL.ordinal()] = 1;
        WindowLoadEvent r101 = WindowLoadEvent.RECOMMEND_ON_NO_RESULT;
        r100[r101.ordinal()] = 2;
        WindowLoadEvent r102 = WindowLoadEvent.RECOMMEND_ON_LESS_RESULT;
        r100[r102.ordinal()] = 3;
        int[] r103 = new int[WindowLoadEvent.values().length];
        f478208b = r103;
        r103[r101.ordinal()] = 1;
        r103[r102.ordinal()] = 2;
    }
}

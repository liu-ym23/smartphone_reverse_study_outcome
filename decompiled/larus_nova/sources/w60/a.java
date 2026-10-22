package w60;

import com.bytedance.android.live.core.setting.v2.cache.ICacheManger;

/* JADX INFO: loaded from: classes45.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f558386a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f558387b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f558388c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int[] f558389d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int[] f558390e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int[] f558391f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int[] f558392g = null;

    static {
        int[] r100 = new int[ICacheManger.CacheType.values().length];
        f558386a = r100;
        ICacheManger.CacheType r101 = ICacheManger.CacheType.LOCAL_CACHE;
        r100[r101.ordinal()] = 1;
        ICacheManger.CacheType r102 = ICacheManger.CacheType.TRANSIENT;
        r100[r102.ordinal()] = 2;
        ICacheManger.CacheType r103 = ICacheManger.CacheType.STICKY;
        r100[r103.ordinal()] = 3;
        ICacheManger.CacheType r104 = ICacheManger.CacheType.OBJECT;
        r100[r104.ordinal()] = 4;
        ICacheManger.CacheType r105 = ICacheManger.CacheType.PRELOAD_CACHE;
        r100[r105.ordinal()] = 5;
        int[] r106 = new int[ICacheManger.CacheType.values().length];
        f558387b = r106;
        r106[r101.ordinal()] = 1;
        r106[r102.ordinal()] = 2;
        r106[r103.ordinal()] = 3;
        r106[r104.ordinal()] = 4;
        r106[r105.ordinal()] = 5;
        int[] r107 = new int[ICacheManger.CacheType.values().length];
        f558388c = r107;
        r107[r103.ordinal()] = 1;
        r107[r102.ordinal()] = 2;
        r107[r104.ordinal()] = 3;
        r107[r105.ordinal()] = 4;
        int[] r108 = new int[ICacheManger.Operation.values().length];
        f558389d = r108;
        ICacheManger.Operation r109 = ICacheManger.Operation.MINUS;
        r108[r109.ordinal()] = 1;
        ICacheManger.Operation r110 = ICacheManger.Operation.PLUS;
        r108[r110.ordinal()] = 2;
        int[] r111 = new int[ICacheManger.Operation.values().length];
        f558390e = r111;
        r111[r109.ordinal()] = 1;
        r111[r110.ordinal()] = 2;
        int[] r112 = new int[ICacheManger.Operation.values().length];
        f558391f = r112;
        r112[r109.ordinal()] = 1;
        r112[r110.ordinal()] = 2;
        int[] r113 = new int[ICacheManger.Operation.values().length];
        f558392g = r113;
        r113[r109.ordinal()] = 1;
        r113[r110.ordinal()] = 2;
    }
}

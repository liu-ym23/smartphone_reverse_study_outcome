package dd7;

import com.lynx.react.bridge.ReadableType;

/* JADX INFO: loaded from: classes22.dex */
public final /* synthetic */ class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f468029a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f468030b = null;

    static {
        int[] r100 = new int[ReadableType.values().length];
        f468029a = r100;
        ReadableType r101 = ReadableType.Map;
        r100[r101.ordinal()] = 1;
        ReadableType r102 = ReadableType.Array;
        r100[r102.ordinal()] = 2;
        int[] r103 = new int[ReadableType.values().length];
        f468030b = r103;
        r103[r102.ordinal()] = 1;
        r103[r101.ordinal()] = 2;
    }
}

package qs2;

import com.bytedance.android.livesdk.room.LiveScope;

/* JADX INFO: loaded from: classes11.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f534653a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f534654b = null;

    static {
        int[] r100 = new int[LiveScope.values().length];
        f534653a = r100;
        LiveScope r101 = LiveScope.ROOM;
        r100[r101.ordinal()] = 1;
        LiveScope r102 = LiveScope.SESSION;
        r100[r102.ordinal()] = 2;
        int[] r103 = new int[LiveScope.values().length];
        f534654b = r103;
        r103[r101.ordinal()] = 1;
        r103[r102.ordinal()] = 2;
    }
}

package ps2;

import com.bytedance.android.livesdk.room.LiveScope;

/* JADX INFO: loaded from: classes11.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f530434a = null;

    static {
        int[] r100 = new int[LiveScope.values().length];
        f530434a = r100;
        r100[LiveScope.ROOM.ordinal()] = 1;
        r100[LiveScope.SESSION.ordinal()] = 2;
        r100[LiveScope.LIVE.ordinal()] = 3;
    }
}

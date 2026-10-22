package jv1;

import com.bytedance.android.livesdk.room.LiveScope;

/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f500541a = null;

    static {
        int[] r100 = new int[LiveScope.values().length];
        f500541a = r100;
        r100[LiveScope.SESSION.ordinal()] = 1;
        r100[LiveScope.ROOM.ordinal()] = 2;
        r100[LiveScope.LIVE.ordinal()] = 3;
    }
}

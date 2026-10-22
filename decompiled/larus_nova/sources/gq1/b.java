package gq1;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;

/* JADX INFO: loaded from: classes8.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f482147a = 0;

    static {
    }

    public static long a(String r100, String r101, long r102) {
        if (r101 != null) goto L4;
        return r102;
    L4:
        if (r101.length() != 0) goto L6;
        boolean r103 = true;
    L7:
        if (r103 == true) goto L17;
        return CastLongProtector.parseLong(r101);
    L11:
        e = move-exception;
        ALogger.e("ReplayRoomActionHandler", r100 + " is not long " + r101 + ", " + e.getMessage());
        return r102;
    L17:
        return r102;
    L6:
        r103 = false;
        goto L7
    }
}

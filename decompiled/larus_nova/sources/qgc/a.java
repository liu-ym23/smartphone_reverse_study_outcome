package qgc;

import com.ss.android.vesdk.VELogProtocol;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static VELogProtocol f532886a;

    public static void a(int r100, String r101) {
        VELogProtocol r102 = f532886a;
        if (r102 == null) goto L6;
        r102.logToLocal(r100, "[VESDK]" + r101);
        return;
    }
}

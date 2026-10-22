package iw;

import android.content.Context;
import bw.g;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f496136a = 0;

    static {
    }

    public static boolean a(Context r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        g r101 = com.bytedance.android.gamecp.host_api.a.b().getHostFoldPadService();
        r101.isPad();
        r101.isFoldDevice();
        return false;
    }
}

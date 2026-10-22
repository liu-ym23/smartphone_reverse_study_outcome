package xu3;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f565094a = null;

    static {
        f565094a = new Handler(Looper.getMainLooper());
    }

    public static byte[] a(String r100) {
        if (r100 != null) goto L10;
    L8:
        return null;
    L10:
        if (r100.length() <= 0) goto L8;
        return r100.getBytes("UTF-8");
    L12:
        return r100.getBytes();
    }
}

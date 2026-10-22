package w0c;

import android.os.Bundle;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<Bundle> f557833a = null;

    static {
        f557833a = new ArrayList();
        int r100 = 0;
    L4:
        if (r100 >= 3) goto L6;
        f557833a.add(new Bundle());
        r100 = r100 + 1;
        goto L4
    }

    public static synchronized Bundle a() {
        monitor-enter(a.class);
        int r100 = 0;
    L6:
        if (r100 >= 3) goto L13;
        List<Bundle> r101 = f557833a;     // Catch: Throwable -> L16
        if (((Bundle) ListProtector.get(r101, r100)).isEmpty() == true) goto L9;
        r100 = r100 + 1;
        goto L6
    L9:
        Bundle r102 = (Bundle) ListProtector.get(r101, r100);     // Catch: Throwable -> L16
        monitor-exit(a.class);
        return r102;
    L16:
        th = move-exception;
        throw th;
    L13:
        Log.w("BundlePool", "<create new bundle object>");     // Catch: Throwable -> L16
        Bundle r103 = new Bundle();     // Catch: Throwable -> L16
        monitor-exit(a.class);
        return r103;
    }
}

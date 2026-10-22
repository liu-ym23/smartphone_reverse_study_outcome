package ga4;

import android.app.Activity;
import android.os.Build;
import com.bytedance.bdp.bdpplatform.service.permission.request.BdpPermissionProxy;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes11.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArrayList<d> f480553a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f480554b = null;

    public static abstract class a {
        public a() {
        }

        public abstract void a(String[] r100, int[] r101);
    }

    public c() {
    }

    static {
        f480554b = new c();
        f480553a = new CopyOnWriteArrayList();
    }

    public final void requestPermissions(Activity r100, String[] r101, a r102, String r103) {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        d r104 = new BdpPermissionProxy();
    L6:
        f480553a.add(r104);
        r104.a(r100, r101, r102, r103);
        return;
    L5:
        r104 = new b();
        goto L6
    }
}

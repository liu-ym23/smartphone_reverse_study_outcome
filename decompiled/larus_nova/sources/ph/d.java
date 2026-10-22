package ph;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.ec.core.opt.ab.j;
import com.bytedance.android.ec.core.opt.ab.v;
import com.bytedance.android.ec.sdk.ECSdk;

/* JADX INFO: loaded from: classes43.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f529229a = null;

    static {
        f529229a = new Handler(Looper.getMainLooper());
    }

    public static void a(boolean r100) {
        int r101 = ECSdk.f48106a;
        cj.b r102 = (cj.b) ECSdk.a(cj.b.class);
        if (r102 == null) goto L6;
        r102.i();
        return;
    }

    public static void b(boolean r100) {
        if (v.a().b() == false) goto L6;
        a(r100);
        return;
    }

    public static void c(boolean r100) {
        if (j.a().l() == false) goto L8;
        int r101 = ECSdk.f48106a;
        cj.b r102 = (cj.b) ECSdk.a(cj.b.class);
        if (r102 == null) goto L9;
        r102.h();
        return;
    L9:
        return;
    }
}

package rz5;

import com.bytedance.helios.sdk.HeliosEnvImpl;
import hz5.l;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f539962a = 0;

    static {
    }

    @JvmStatic
    public static final void a(String r100, long r101, boolean r102) {
        if (HeliosEnvImpl.get().f245470m.u() == false) goto L5;
        return;
    L5:
        long r103 = System.currentTimeMillis() - r101;
        if (r103 >= 1) goto L8;
        if (r102 == true) goto L8;
        return;
    L8:
        l.b(hz5.a.c(r100, r103));
    }
}

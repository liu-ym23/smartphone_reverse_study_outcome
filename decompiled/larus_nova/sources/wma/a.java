package wma;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f560376a;

    public a() {
        Intrinsics.checkNotNullParameter("OUI_SDK", "baseTag");
        this.f560376a = false;
    }

    public final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L13;
    L13:
        if (this.f560376a == false) goto L16;
        ThreadMethodProxy.currentThread().getName();
        return;
    L16:
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }
}

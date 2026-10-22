package zt7;

import com.larus.utils.logger.FLogger;
import ss3.i;

/* JADX INFO: loaded from: classes23.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f573633a = 0;

    static {
        i r100 = i.a.f543398a;     // Catch: Exception -> L9
        if (r100.f543395c == false) goto L6;
        return;
    L6:
        if (xu3.a.getContext() == null) goto L15;
        r100.b();     // Catch: Exception -> L9
        return;
    L15:
        return;
    L9:
        e = move-exception;
        FLogger.f375446a.e("SystemResourceUtils", "Failed to register battery temperature callback", e);
    }
}

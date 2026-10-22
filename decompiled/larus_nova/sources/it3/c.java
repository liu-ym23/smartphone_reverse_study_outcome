package it3;

import android.content.Context;
import com.bytedance.apm6.hub.k;
import com.bytedance.apm6.hub.z;
import com.bytedance.services.slardar.config.IResponseConfigListener;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static List<IResponseConfigListener> f495718a;

    public static k a(Context r100) {
        b r101 = new b(r100);
        monitor-enter(z.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (z.f190829a == false) goto L9;
        monitor-exit(z.class);
        return null;
    L9:
        z.f190829a = true;     // Catch: Throwable -> L13
        z.a(r101);     // Catch: Throwable -> L13
        k r102 = new k(r101);     // Catch: Throwable -> L13
        monitor-exit(z.class);
        return r102;
    }
}

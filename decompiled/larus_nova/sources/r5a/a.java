package r5a;

import android.content.Context;
import com.ss.ttvideoengine.TTVideoEngine;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Boolean f536324a;

    public static boolean a(Context r100) {
        if (f536324a != null) goto L9;
        new TTVideoEngine(r100.getApplicationContext(), 0).releaseAsync();     // Catch: Throwable -> L6
        f536324a = Boolean.TRUE;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        th.printStackTrace();
        f536324a = Boolean.FALSE;
    L9:
        return f536324a.booleanValue();
    }
}

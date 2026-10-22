package g1;

import android.content.Context;
import android.os.SystemClock;
import com.apm.lite.k.h;
import com.apm.lite.nativecrash.NativeImpl;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes39.dex */
public final class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile e f479565b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f479566a;

    public e(Context r100) {
        this.f479566a = new a(r100);
    }

    public static void a() {
        if (f479565b != null) goto L5;
        return;
    L5:
        if (f479565b.f479566a == null) goto L20;
        a r100 = f479565b.f479566a;
        File r101 = r100.k();
        int r102 = Integer.decode(h.n(r101.getAbsolutePath())).intValue();     // Catch: Throwable -> L12 IOException -> L13
        r100.f479553y = r102;     // Catch: Throwable -> L12 IOException -> L13
        if (r102 < 2) goto L10;
        NativeImpl.setResendSigQuit(false);     // Catch: Throwable -> L12 IOException -> L13
    L15:
        return;
    L10:
        NativeImpl.setResendSigQuit(true);     // Catch: Throwable -> L12 IOException -> L13
    L13:
        NativeImpl.setResendSigQuit(true);
        return;
    L12:
        h.k(r101);
        return;
    }

    public static void b() {
        if (f479565b != null) goto L5;
        return;
    L5:
        if (f479565b.f479566a == null) goto L16;
        a r100 = f479565b.f479566a;
        r100.getClass();
        if (NativeImpl.isResendSigQuit() == true) goto L13;
    L11:
        r100.f479550v = SystemClock.uptimeMillis();
        r100.f479549u = true;
        return;
    L13:
        h.h(r100.k(), String.valueOf(r100.f479553y + 1), false);     // Catch: Throwable -> L10
    L10:
        com.apm.lite.c.a();
        goto L11
    }
}

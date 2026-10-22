package fy7;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import org.threeten.bp.zone.d;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends org.threeten.bp.zone.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f479290c;

    @Override // org.threeten.bp.zone.b
    public final void a() {
        InputStream r100 = null;
        r100 = this.f479290c.getAssets().open("org/threeten/bp/TZDB.dat");     // Catch: Throwable -> L8 IOException -> L10
        org.threeten.bp.zone.a r101 = new org.threeten.bp.zone.a(r100);     // Catch: Throwable -> L8 IOException -> L10
        if (r100 != null) goto L18;
    L6:
        d.d(r101);
        return;
    L18:
        r100.close();     // Catch: IOException -> L16
        goto L6
    L8:
        th = move-exception;
        if (r100 != null) goto L22;
    L15:
        throw th;
    L22:
        r100.close();     // Catch: IOException -> L17
    L10:
        e = move-exception;
        throw new IllegalStateException("TZDB.dat missing from assets.", e);     // Catch: Throwable -> L8
    }

    public b(Context r100) {
        this.f479290c = r100;
    }
}

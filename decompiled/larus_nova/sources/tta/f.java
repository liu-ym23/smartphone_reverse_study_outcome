package tta;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.InputStream;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes34.dex */
public final class f implements uta.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e.a f547584a;

    public f(d.b r100) {
        this.f547584a = r100;
    }

    @Override // uta.c
    public final void a() {
        e.a r100 = this.f547584a;
        if (r100 == null) goto L6;
        ((d.b) r100).a(null);
        return;
    }

    @Override // uta.c
    public final void a(InputStream r100) {
        Bitmap r101 = null;
        if (r100 != null) goto L36;
    L32:
        e.a r102 = this.f547584a;
        if (r102 == null) goto L45;
    L34:
        ((d.b) r102).a(r101);
        return;
    L45:
        return;
    L36:
        byte[] r103 = ByteStreamsKt.readBytes(r100);     // Catch: Throwable -> L18
        if (r103.length != 0) goto L7;
        boolean r104 = true;
    L9:
        if ((!r104) == false) goto L12;
        Bitmap r105 = BitmapFactory.decodeByteArray(r103, 0, r103.length);     // Catch: Throwable -> L18
    L42:
        CloseableKt.closeFinally(r100, null);     // Catch: Throwable -> L15 Exception -> L17
        r101 = r105;
        goto L32
    L17:
        r101 = r105;
    L29:
        r102 = this.f547584a;
        if (r102 != null) goto L34;
        return;
    L15:
        th = th;
        r101 = r105;
    L24:
        e.a r106 = this.f547584a;
        if (r106 == null) goto L27;
        ((d.b) r106).a(r101);
    L27:
        throw th;
    L12:
        r105 = null;
        goto L42
    L7:
        r104 = false;
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        CloseableKt.closeFinally(r100, th);     // Catch: Throwable -> L23 Exception -> L28
        throw th;     // Catch: Throwable -> L23 Exception -> L28
    L23:
        th = th;
        goto L24
    }
}

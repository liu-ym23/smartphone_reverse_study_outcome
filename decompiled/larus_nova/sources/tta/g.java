package tta;

import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.InputStream;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes34.dex */
public final class g implements uta.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f547585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f547586b;

    public g(com.ss.android.dypay.base.h.c.b r100, String r101) {
        this.f547585a = r100;
        this.f547586b = r101;
    }

    @Override // uta.c
    public final void a() {
        Function1 r100 = this.f547585a;
        if (r100 == null) goto L6;
        Unit r101 = (Unit) r100.invoke("");
        return;
    }

    @Override // uta.c
    public final void a(InputStream r100) {
        if (r100 != null) goto L8;
        Function1 r101 = this.f547585a;
        if (r101 == null) goto L59;
        Unit r102 = (Unit) r101.invoke("");
        return;
    L59:
        return;
    L8:
        String r103 = b.f547568b;
        if (r103 != null) goto L11;
    L14:
        boolean r104 = true;
    L15:
        if (r104 == false) goto L20;
        Function1 r105 = this.f547585a;
        if (r105 == null) goto L60;
        Unit r106 = (Unit) r105.invoke("");
        return;
    L60:
        return;
    L20:
        PolarisFileWrapper r107 = new PolarisFileWrapper(r103);
        PolarisFileWrapper r108 = new PolarisFileWrapper(r107, com.ss.android.dypay.utils.c.a(this.f547586b));
    L47:
        Function1 r109 = this.f547585a;
        if (r109 == null) goto L63;
        Unit r110 = (Unit) r109.invoke("");
        return;
    L63:
        return;
    L22:
        if (r107.exists() == true) goto L25;
        r107.mkdirs();     // Catch: Exception -> L47
    L25:
        if (StringsKt.startsWith$default(r108.getCanonicalPath(), r107.getCanonicalPath(), false, 2, null) == true) goto L51;
        Function1 r111 = this.f547585a;     // Catch: Exception -> L47
        if (r111 == null) goto L61;
        Unit r112 = (Unit) r111.invoke("");     // Catch: Exception -> L47
        return;
    L61:
        return;
    L51:
        PolarisFileOutputStreamWrapper r113 = new PolarisFileOutputStreamWrapper(r108);     // Catch: Throwable -> L42
        ByteStreamsKt.copyTo$default(r100, r113, 0, 2, null);     // Catch: Throwable -> L37
        CloseableKt.closeFinally(r113, null);     // Catch: Throwable -> L42
        CloseableKt.closeFinally(r100, null);     // Catch: Exception -> L47
        Function1 r114 = this.f547585a;     // Catch: Exception -> L47
        if (r114 == null) goto L62;
        Unit r115 = (Unit) r114.invoke(r108.getPath());     // Catch: Exception -> L47
        return;
    L62:
        return;
    L37:
        th = move-exception;
        throw th;     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        CloseableKt.closeFinally(r113, th);     // Catch: Throwable -> L42
        throw th;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        throw th;     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        CloseableKt.closeFinally(r100, th);     // Catch: Exception -> L47
        throw th;     // Catch: Exception -> L47
    L11:
        if (r103.length() == 0) goto L14;
        r104 = false;
        goto L15
    }
}

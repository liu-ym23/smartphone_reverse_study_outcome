package znc;

import com.ss.android.lark.log.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public abstract class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f573011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f573012b;

    public abstract InputStream b() throws IOException;

    public a() {
        this.f573011a = 8192;
        this.f573012b = "BaseCacheWriter";
    }

    @Override // znc.d
    public final boolean a(m.c r100) {
        Intrinsics.checkNotNullParameter(r100, "editor");
        InputStream r101 = b();
        OutputStream r102 = null;
        r102 = r100.a();     // Catch: Throwable -> L5 IOException -> L7
        ByteStreamsKt.copyTo(r101, r102, this.f573011a);     // Catch: Throwable -> L5 IOException -> L7
        n.a(r101);
        n.a(r102);
        return true;
    L7:
        e = move-exception;
        Log.e(this.f573012b, "write cache failed: " + e.getMessage(), e);     // Catch: Throwable -> L5
        n.a(r101);
        n.a(r102);
        return false;
    L5:
        th = move-exception;
        n.a(r101);
        n.a(r102);
        throw th;
    }
}

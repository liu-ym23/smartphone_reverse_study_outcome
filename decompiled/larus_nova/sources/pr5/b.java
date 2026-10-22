package pr5;

import com.bytedance.ee.eenet.httpclient.rust.exception.RustIOException;
import com.bytedance.lark.sdk.c;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.RequestBody;
import okio.Buffer;

/* JADX INFO: loaded from: classes16.dex */
public final class b {
    public static c a(RequestBody r100) throws RustIOException {
        if (r100 == null) goto L13;
        Buffer r101 = new Buffer();
        r100.writeTo(r101);     // Catch: OutOfMemoryError -> L6 IOException -> L9
        int r102 = c.f254134d;     // Catch: OutOfMemoryError -> L6 IOException -> L9
        byte[] r103 = r101.readByteArray();     // Catch: OutOfMemoryError -> L6 IOException -> L9
        Intrinsics.checkNotNullParameter(r103, "contents");     // Catch: OutOfMemoryError -> L6 IOException -> L9
        return new c(r103);
    L9:
        e = move-exception;
        throw new RustIOException(e, RustIOException.REQUEST_EENET_INNER_ERROR);
    L6:
        e = move-exception;
        throw new RustIOException(e, RustIOException.REQUEST_EENET_INNER_MEMORY_LIMIT);
    L13:
        return new c(new byte[0]);
    }
}

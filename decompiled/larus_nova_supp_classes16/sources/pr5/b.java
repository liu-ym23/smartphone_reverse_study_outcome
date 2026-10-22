package pr5;

import com.bytedance.ee.eenet.httpclient.rust.exception.RustIOException;
import com.bytedance.lark.sdk.c;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.RequestBody;
import okio.Buffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    public static c a(RequestBody r2) throws RustIOException {
        if (r2 == null) goto L13;
        Buffer r0 = new Buffer();
        r2.writeTo(r0);     // Catch: OutOfMemoryError -> L6 IOException -> L9
        int r3 = c.d;     // Catch: OutOfMemoryError -> L6 IOException -> L9
        byte[] r4 = r0.readByteArray();     // Catch: OutOfMemoryError -> L6 IOException -> L9
        Intrinsics.checkNotNullParameter(r4, "contents");     // Catch: OutOfMemoryError -> L6 IOException -> L9
        return new c(r4);
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

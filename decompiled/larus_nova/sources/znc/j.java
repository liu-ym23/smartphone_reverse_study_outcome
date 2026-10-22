package znc;

import com.ss.android.lark.log.Log;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class j<T extends Serializable> implements c<T> {
    public j() {
    }

    @Override // znc.c
    public final Object a(m.d r100) {
        Intrinsics.checkNotNullParameter(r100, "snapshot");
        InputStream r101 = r100.b();
        if (r101 != null) goto L17;
    L12:
        return null;
    L17:
        Object r102 = new ObjectInputStream(r101).readObject();     // Catch: Throwable -> L7 Exception -> L9
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type T of com.suite.lark.component.storage.file.cache.ObjectReader");     // Catch: Throwable -> L7 Exception -> L9
        Serializable r103 = (Serializable) r102;     // Catch: Throwable -> L7 Exception -> L9
        Charset r104 = n.f573064a;
        return r103;
    L9:
        e = move-exception;
        Log.i("UniDiskLruCache", "read object failed: " + e.getMessage());     // Catch: Throwable -> L7
        Charset r105 = n.f573064a;
    L7:
        th = move-exception;
        Charset r106 = n.f573064a;
        throw th;
    }
}

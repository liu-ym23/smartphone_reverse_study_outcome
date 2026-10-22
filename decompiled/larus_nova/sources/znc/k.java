package znc;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.ss.android.lark.log.Log;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class k<T extends Serializable> implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f573048a;

    public k(T r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        this.f573048a = r100;
    }

    @Override // znc.d
    public final boolean a(m.c r100) {
        Intrinsics.checkNotNullParameter(r100, "editor");
        ObjectOutputStream r101 = null;
        ObjectOutputStream r102 = new ObjectOutputStream(r100.a());     // Catch: Throwable -> L10 IOException -> L12
        r102.writeObject(this.f573048a);     // Catch: Throwable -> L6 IOException -> L8
        r102.flush();     // Catch: Throwable -> L6 IOException -> L8
        n.a(r102);
        boolean r103 = true;
    L19:
        return r103;
    L8:
        e = e;
        r101 = r102;
    L13:
        Log.i("UniDiskLruCache", "ObjectWriter exception: " + e.getMessage(), e);     // Catch: Throwable -> L10
        n.a(r101);
        r103 = false;
    L6:
        th = th;
    L17:
        n.a(r102);
        throw th;
    L10:
        th = th;
        r102 = r101;
    L12:
        e = e;
        goto L13
    }
}

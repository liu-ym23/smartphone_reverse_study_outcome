package okio;

import com.baidu.platform.comapi.map.MapBundleKey;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes42.dex */
public abstract class m extends l {
    public static void f(b0 r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r101, "functionName");
        Intrinsics.checkNotNullParameter(r102, "parameterName");
    }

    public final String toString() {
        return Reflection.getOrCreateKotlinClass(m.class).getSimpleName() + "(null)";
    }

    @Override // okio.l
    public final List<b0> b(b0 r100) throws IOException {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_DIR);
        f(r100, "list", MapBundleKey.MapObjKey.OBJ_DIR);
        throw null;
    }

    @Override // okio.l
    public final List<b0> c(b0 r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_DIR);
        f(r100, "listOrNull", MapBundleKey.MapObjKey.OBJ_DIR);
        throw null;
    }

    @Override // okio.l
    public final k d(b0 r100) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "path");
        f(r100, "metadataOrNull", "path");
        throw null;
    }

    @Override // okio.l
    public final j e(b0 r100) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "file");
        f(r100, "openReadOnly", "file");
        throw null;
    }

    @Override // okio.l
    public void delete(b0 r100, boolean r101) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "path");
        f(r100, "delete", "path");
        throw null;
    }
}

package en6;

import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class f implements jq6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f473170a = null;

    static {
        f473170a = new f();
    }

    public f() {
    }

    public final Object b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return HostServiceUtilsKt.y().getValue(r100);
    }

    public final <T> T a(String r100, Class<T> r101, T r102) {
        Intrinsics.checkNotNullParameter(r100, "abKey");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        return (T) HostServiceUtilsKt.y().a(r100, r101, r102);
    }
}

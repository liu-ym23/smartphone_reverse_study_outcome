package mqc;

import com.volcengine.zeus.util.kv.KVStorage;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f514945a = 0;

    static {
    }

    @JvmStatic
    public static final String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "pkgName");
        String r101 = KVStorage.INSTANCE.staticKV().getString("IDENTITY_" + r100, "");
        if (r101 != null) goto L5;
        return "";
    L5:
        return r101;
    }
}

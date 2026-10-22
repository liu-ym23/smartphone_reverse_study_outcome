package ay4;

import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import com.ss.android.lark.utils.LarkContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    public static final com.ss.android.lark.storage.a a = null;

    static {
        a = new com.ss.android.lark.storage.a("ccm");
    }

    public static n6c.b a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "name");
        return new n6c.b(LarkContext.getApplication().getSharedPreferences(r3, 0));
    }

    public static /* synthetic */ com.ss.android.lark.storage.kv.repo.a c(String r2) {
        return b(r2, true, null);
    }

    public static com.ss.android.lark.storage.kv.repo.a d(String r1, int r2) {
        if ((r2 & 1) == 0) goto L6;
        r1 = null;
    L6:
        return LarkKVStorage.p(a, r1, false);
    }

    @JvmStatic
    public static final com.ss.android.lark.storage.kv.repo.a b(String r0, boolean r1, KVRepo r2) {
        if (r1 == false) goto L7;
        if (r2 == null) goto L7;
        return LarkKVStorage.f(a, r0, r2);
    L7:
        return LarkKVStorage.g(a, r0, r1);
    }
}

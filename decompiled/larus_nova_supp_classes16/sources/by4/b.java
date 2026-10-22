package by4;

import com.ss.android.lark.passportc.dwarf.UserScope;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@UserScope
public final class b implements d {
    public final com.ss.android.lark.storage.kv.storage.a a;

    @Inject
    public b(com.ss.android.lark.storage.kv.storage.a r2) {
        Intrinsics.checkNotNullParameter(r2, "userKvStorage");
        this.a = r2;
    }

    @Override // by4.d
    public final com.ss.android.lark.storage.kv.repo.a b(String r5) {
        return com.ss.android.lark.storage.kv.storage.a.b(this.a, ay4.b.a, r5, null, 4);
    }
}

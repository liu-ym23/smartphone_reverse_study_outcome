package n3c;

import com.ss.android.lark.storage.LarkKVStorage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements ne6.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f517014a = null;

    static {
        f517014a = new a();
    }

    public a() {
    }

    @Override // ne6.d
    public final <T> T getJSONObject(String r100, Class<T> r101) {
        com.ss.android.lark.storage.a r102 = com.ss.android.lark.security.compliance.infra.storage.d.f440474a;
        Intrinsics.checkNotNullParameter("policy_engine", "repoName");
        return (T) LarkKVStorage.g(com.ss.android.lark.security.compliance.infra.storage.d.f440474a, "policy_engine", false).getJSONObject(r100, r101);
    }

    @Override // ne6.d
    public final void putJSONObject(String r100, Object r101) {
        if (r101 == null) goto L5;
        com.ss.android.lark.storage.a r102 = com.ss.android.lark.security.compliance.infra.storage.d.f440474a;
        Intrinsics.checkNotNullParameter("policy_engine", "repoName");
        LarkKVStorage.g(com.ss.android.lark.security.compliance.infra.storage.d.f440474a, "policy_engine", false).putJSONObject(r100, r101);
        return;
    L5:
        com.ss.android.lark.storage.a r103 = com.ss.android.lark.security.compliance.infra.storage.d.f440474a;
        Intrinsics.checkNotNullParameter("policy_engine", "repoName");
        LarkKVStorage.g(com.ss.android.lark.security.compliance.infra.storage.d.f440474a, "policy_engine", false).remove(r100);
    }
}

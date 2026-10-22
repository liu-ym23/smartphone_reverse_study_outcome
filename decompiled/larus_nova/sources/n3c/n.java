package n3c;

/* JADX INFO: loaded from: classes38.dex */
public final class n implements ne6.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f517033a = null;

    static {
        f517033a = new n();
    }

    public n() {
    }

    @Override // ne6.d
    public final <T> T getJSONObject(String r100, Class<T> r101) {
        return (T) com.ss.android.lark.security.compliance.infra.storage.d.b("policy_engine", 2).getJSONObject(r100, r101);
    }

    @Override // ne6.d
    public final void putJSONObject(String r100, Object r101) {
        com.ss.android.lark.security.compliance.infra.storage.d.b("policy_engine", 2).putJSONObject(r100, r101);
    }
}

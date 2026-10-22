package fc7;

import com.bytedance.sdk.account.utils.p;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends p {
    public c(String r100) {
        super(r100);
    }

    public static void c(String r100) {
        if (b.f476362a.contains(r100) == false) goto L5;
        return;
    L5:
        tb7.a.b("ParamLimitUrlBuilder", "param key " + r100 + " is not reserved");
        throw new IllegalArgumentException("key " + r100 + " is reserved");
    }

    public final void a(String r100, String r101) {
        this.f269554a.put(r100, r101);
    }

    public final void b(String r100, String r101) {
        c(r100);
        this.f269554a.put(r100, r101);
    }
}

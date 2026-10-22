package ju5;

import com.bytedance.ee.util.db.DBController;
import com.bytedance.ee.util.db.KeyValueDatabase;
import io.reactivex.functions.Function;

/* JADX INFO: loaded from: classes19.dex */
public final class h implements Function<String, j> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.util.db.b f500497a;

    public h(com.bytedance.ee.util.db.b r100) {
        this.f500497a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final j apply(String r100) throws Exception {
        String r101 = r100;
        com.bytedance.ee.util.db.b r102 = this.f500497a;
        r102.getClass();
        monitor-enter(r102);     // Catch: Exception -> L10
        KeyValueDatabase r103 = (KeyValueDatabase) DBController.a().r1("docs_keyvaule.db");     // Catch: Throwable -> L7
        monitor-exit(r102);     // Catch: Exception -> L10
        j r104 = ((g) r103.c()).a(r101);     // Catch: Exception -> L10
    L12:
        if (r104 != null) goto L15;
        return new j("", "");
    L15:
        return this.f500497a.a(r101);
    L7:
        th = move-exception;
        throw th;     // Catch: Exception -> L10
    L10:
        e = move-exception;
        iu5.d.c(e);
        r104 = null;
        goto L12
    }
}

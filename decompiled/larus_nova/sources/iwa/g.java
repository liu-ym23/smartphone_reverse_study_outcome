package iwa;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.audit.db.AuditDBData;
import com.ss.android.lark.log.Log;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f496257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f496258b;

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void a() {
        if (this.f496258b.f496252e != null) goto L16;
        Log.e("RecorderImpl", "audit record failed for null DataHandler");
        return;
    L16:
        Log.i("RecorderImpl", this.f496258b.f496251d + " record begin ");     // Catch: Exception -> L13
        String r100 = this.f496258b.f496248a.serialize((T) this.f496257a);     // Catch: Exception -> L13
        f r101 = this.f496258b;     // Catch: Exception -> L13
        List<AuditDBData> r102 = r101.f496252e.queryAuditData(r101.f496251d, 500);     // Catch: Exception -> L13
        if (r102 != null) goto L9;
    L11:
        f r103 = this.f496258b;     // Catch: Exception -> L13
        r103.f496252e.recordAuditData(r103.f496251d, r100);     // Catch: Exception -> L13
        f r104 = this.f496258b;     // Catch: Exception -> L13
        r104.f496249b.execute(new e(r104));     // Catch: Exception -> L13
        return;
    L9:
        if (r102.size() != 500) goto L11;
        Log.i("RecorderImpl", "db data more than MAX_LIMIT clear data");     // Catch: Exception -> L13
        f r105 = this.f496258b;     // Catch: Exception -> L13
        r105.f496252e.deleteAuditData(r105.f496251d, r102);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        Log.e("RecorderImpl", this.f496258b.f496251d + " record occurs wrong: " + e.getMessage());
        nwa.b.a.f521016a.a("inner_db_error", null);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public g(f r100, Object r101) {
        this.f496258b = r100;
        this.f496257a = r101;
    }
}

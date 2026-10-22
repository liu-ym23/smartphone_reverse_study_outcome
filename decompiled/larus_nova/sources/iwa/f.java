package iwa;

import com.larksuite.framework.utils.z;
import com.ss.android.lark.audit.AuditManager;
import com.ss.android.lark.audit.db.AuditDBData;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.pb.security_event.Event;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes34.dex */
public final class f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c<T> f496248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f496249b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d<T> f496250c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f496251d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final gwa.g.a f496252e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f496253f;

    public class a implements Callable<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f496254a;

        /* JADX INFO: renamed from: iwa.f$a$a, reason: collision with other inner class name */
        public class C6362a implements kwa.d<Boolean> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ List f496255a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f496256b;

            @Override // kwa.d
            public final void a(kwa.c r100) {
                Log.e("RecorderImpl", "processRecords records fail " + r100.toString());
                nwa.b.a.f521016a.a(String.valueOf(r100.f506487a), r100.f506488b);
            }

            @Override // kwa.d
            public final void onResponse(Boolean r100) {
                Boolean r101 = r100;
                Log.i("RecorderImpl", "processRecords onResponse " + r101);
                if (r101.booleanValue() == false) goto L5;
                Log.i("RecorderImpl", this.f496256b.f496254a.f496251d + " consume delete records: " + this.f496255a.size());
                f r102 = this.f496256b.f496254a;
                r102.f496252e.deleteAuditData(r102.f496251d, this.f496255a);
                nwa.b.a.f521016a.d("audit_event", true, null, null);
                return;
            L5:
                Log.e("RecorderImpl", "processRecords records fail");
                nwa.b.a.f521016a.a("inner_network_error", null);
            }

            public C6362a(a r100, List r101) {
                this.f496256b = r100;
                this.f496255a = r101;
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            f r100 = this.f496254a;
            gwa.g.a r101 = r100.f496252e;
            if (r101 != null) goto L28;
            Log.e("RecorderImpl", "audit record failed for null DataHandler");
            return Boolean.TRUE;
        L28:
            List<AuditDBData> r102 = r101.queryAuditData(r100.f496251d, 50);     // Catch: Exception -> L25
            if (r102 != null) goto L9;
        L23:
            Log.i("RecorderImpl", this.f496254a.f496251d + " records size is 0");     // Catch: Exception -> L25
            nwa.b.a.f521016a.a("inner_data_error", null);     // Catch: Exception -> L25
            return Boolean.TRUE;
        L9:
            if (r102.isEmpty() == true) goto L23;
            f r103 = this.f496254a;     // Catch: Exception -> L25
            d<T> r104 = r103.f496250c;     // Catch: Exception -> L25
            if (r104 == null) goto L22;
            ArrayList r105 = new ArrayList();     // Catch: Exception -> L25
            Iterator<AuditDBData> r106 = r102.iterator();     // Catch: Exception -> L25
        L15:
            if (r106.hasNext() == false) goto L19;
            Event r107 = r103.f496248a.a(r106.next().f409450b);     // Catch: Exception -> L25
            if (r107 == null) goto L15;
            r105.add(r107);     // Catch: Exception -> L25
            goto L15
        L19:
            r104.a(r105, new C6362a(this, r102));     // Catch: Exception -> L25
            return Boolean.TRUE;
        L22:
            return Boolean.FALSE;
        L25:
            e = move-exception;
            Log.e("RecorderImpl", this.f496254a.f496251d + " consume records fail :" + e.getMessage());
            nwa.b.a.f521016a.a("inner_exception", e.getMessage());
            return Boolean.TRUE;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Boolean call() throws Exception {
            return call();
        }

        public a(f r100) {
            this.f496254a = r100;
        }
    }

    public f(String r100, gwa.b r101, Executor r102, gwa.g r103) {
        this.f496253f = new a(this);
        this.f496251d = r100;
        this.f496248a = r101;
        this.f496249b = r102;
        if (z.e(AuditManager.getInstance().getContext()) == false) goto L5;
        gwa.g.a r104 = b.a.f496246a;
    L6:
        this.f496252e = r104;
        return;
    L5:
        r104 = r103.a();
        goto L6
    }
}

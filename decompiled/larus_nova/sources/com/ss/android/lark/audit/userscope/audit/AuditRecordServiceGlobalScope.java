package com.ss.android.lark.audit.userscope.audit;

import com.ss.android.lark.audit.db.AuditDBData;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.pb.security_event.Event;
import com.ss.android.lark.pb.security_event.EventsRequest;
import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Singleton
@Deprecated(message = "To be deleted")
public final class AuditRecordServiceGlobalScope implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kwa.e f409459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f409460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public gwa.d f409461c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f409462d;

    public static final class a {
    }

    public static final class b<T> implements iwa.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AuditRecordServiceGlobalScope f409463a;

        public b(AuditRecordServiceGlobalScope r100) {
            this.f409463a = r100;
        }

        @Override // iwa.d
        public final void a(List r100, iwa.f.a.C6362a r101) {
            Log.i("AuditRecordService", "processRecordsV2 begin");
            kwa.a r102 = new kwa.a(new EventsRequest.Builder().Events(r100).build());
            this.f409463a.f409459a.a(r102, new h(r101));
        }
    }

    static {
    }

    @Override // com.ss.android.lark.audit.userscope.audit.k
    public final void D6() {
        gwa.d r100 = this.f409461c;
        if (r100 == null) goto L18;
        iwa.f<Event> r101 = r100.f483078a;
        gwa.g.a r102 = r101.f496252e;
        if (r102 != null) goto L16;
    L12:
        int r103 = 0;
    L13:
        if (r103 < 0) goto L19;
        iwa.f<Event> r104 = r100.f483078a;
        r104.f496249b.execute(new iwa.e(r104));
        return;
    L19:
        return;
    L16:
        List<AuditDBData> r105 = r102.queryAuditData(r101.f496251d, 50);     // Catch: Exception -> L10
        if (r105 == null) goto L12;
        r103 = r105.size();     // Catch: Exception -> L10
    L10:
        e = move-exception;
        Log.e("RecorderImpl", "getRemainingEventCount error, error is " + e.getMessage());
        goto L12
    }

    @Inject
    public AuditRecordServiceGlobalScope(kwa.e r100) {
        Intrinsics.checkNotNullParameter(r100, "httpExecutor");
        this.f409459a = r100;
        this.f409460b = "ws_recorder";
        this.f409462d = LazyKt.lazy(new AuditRecordServiceGlobalScope$mExecutorService$2(this));
    }

    @Override // com.ss.android.lark.audit.userscope.audit.j
    public final void Qe(Event r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        gwa.d r101 = this.f409461c;
        if (r101 == null) goto L6;
        Intrinsics.checkNotNullParameter(r100, "event");
        iwa.f<Event> r102 = r101.f483078a;
        r102.f496249b.execute(new iwa.g(r102, r100));
        return;
    }

    @Override // com.ss.android.lark.audit.userscope.audit.k
    public final void af(gwa.g r100) {
        Intrinsics.checkNotNullParameter(r100, "dependency");
        gwa.d r101 = new gwa.d((ExecutorService) this.f409462d.getValue(), r100);
        r101.f483078a.f496250c = new b(this);
        this.f409461c = r101;
    }
}

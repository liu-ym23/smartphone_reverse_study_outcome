package com.ss.android.lark.audit.userscope.audit;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.LarkError;
import com.bytedance.lark.pb.security.v2.AuditEventsRequest;
import com.bytedance.lark.pb.security.v2.AuditEventsResponse;
import com.bytedance.lark.rustclient.api.s;
import com.bytedance.lark.rustclient.api.x;
import com.ss.android.lark.audit.AuditManager;
import com.ss.android.lark.audit.db.AuditDBData;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.pb.security_event.EntityType;
import com.ss.android.lark.pb.security_event.Event;
import com.ss.android.lark.pb.security_event.EventsRequest;
import com.ss.android.lark.pb.security_event.OperationType;
import com.ss.android.lark.pb.security_event.OperatorEntity;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.schedulers.ExecutorScheduler;
import io.reactivex.subjects.Subject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import kotlin.ExceptionsKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: classes34.dex */
@UserScope
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.lark.rustclient.api.l f409477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.audit.userscope.audit.d f409478b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f409479c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f409480d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<? extends AuditDBData> f409481e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f409482f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f409483g;

    public static final class a {
    }

    public static final class b<T> implements Predicate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f409484a;

        public b(e r100) {
            this.f409484a = r100;
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(Object r100) {
            Intrinsics.checkNotNullParameter((Long) r100, "it");
            boolean r101 = this.f409484a.f409480d.get();
            if (r101 == false) goto L5;
            Log.i("AUDIT_AuditRecordImpl", "in uploading status");
        L7:
            return !r101;
        L5:
            Log.i("AUDIT_AuditRecordImpl", "in idle status");
            goto L7
        }
    }

    public static final class c<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f409485a;

        public c(e r100) {
            this.f409485a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Intrinsics.checkNotNullParameter((Long) r100, "it");
            this.f409485a.f409480d.set(true);
            this.f409485a.f409483g = System.currentTimeMillis();
            e r101 = this.f409485a;
            com.ss.android.lark.audit.userscope.audit.d r102 = r101.f409478b;
            if (r102.f409475d == true) goto L5;
            List<? extends AuditDBData> r103 = new ArrayList();
        L13:
            r101.f409481e = r103;
            Log.i("AUDIT_AuditRecordImpl", "data size is " + this.f409485a.f409481e.size());
            return this.f409485a.f409481e;
        L5:
            Log.i("AUDIT_AuditEventStorage", "[query data]");
            iwa.a r104 = r102.f409473b;
            iwa.a r105 = null;
            if (r104 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("userDBHelper");
            r104 = null;
        L8:
            List r106 = com.ss.android.lark.audit.userscope.audit.d.b(r104.getReadableDatabase());
            iwa.a r107 = r102.f409474c;
            if (r107 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("globalDBHelper");
        L12:
            r103 = CollectionsKt.plus(r106, com.ss.android.lark.audit.userscope.audit.d.b(r105.getReadableDatabase()));
            goto L13
        L11:
            r105 = r107;
            goto L12
        }
    }

    public static final class d<T> implements Predicate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f409486a;

        public d(e r100) {
            this.f409486a = r100;
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(Object r100) {
            List r101 = (List) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            if (r101.isEmpty() == false) goto L5;
            this.f409486a.f409480d.set(false);
            return false;
        L5:
            return true;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.audit.userscope.audit.e$e, reason: collision with other inner class name */
    public static final class C4757e<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f409487a;

        public C4757e(e r100) {
            this.f409487a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r110) {
            List r111 = (List) r110;
            Intrinsics.checkNotNullParameter(r111, "it");
            e r100 = this.f409487a;
            r100.getClass();
            Log.i("AUDIT_AuditRecordImpl", "uploadAuditData");
            ArrayList r101 = new ArrayList();
            Iterator r112 = r111.iterator();
        L4:
            if (r112.hasNext() == false) goto L14;
            Event r102 = ((AuditDBData) r112.next()).f409451c;
            if (r102 == null) goto L4;
            r101.add(r102);
            goto L4
        L14:
            byte[] r113 = new EventsRequest.Builder().Events(r101).build().encode();     // Catch: Exception -> L10
        L12:
            ByteString.a r103 = ByteString.Companion;
            Intrinsics.checkNotNull(r113);
            AuditEventsRequest.Builder r104 = new AuditEventsRequest.Builder().data(ByteString.a.e(r103, r113));
            Intrinsics.checkNotNull(r104);
            return r100.f409477a.h(new com.bytedance.lark.rustclient.api.d(r104, AuditEventsResponse.ADAPTER, Command.AUDIT_EVENTS_NEW, null, null, null, null, 248)).a();
        L10:
            e = move-exception;
            Log.e("AUDIT_AuditRecordImpl", "getRequestBytes error " + e.getMessage());
            nwa.d.a(String.valueOf(e.getMessage()));
            r113 = new byte[0];
            goto L12
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f409488a;

        public f(e r100) {
            this.f409488a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            s r111 = (s) r110;
            if ((r111 instanceof x) == false) goto L6;
            e r100 = this.f409488a;
            x r112 = (x) r111;
            r100.getClass();
            Log.i("AUDIT_AuditRecordImpl", "audit response is success！");
            r100.f409478b.delete(r100.f409481e);
            AuditManager.getInstance().getDependency().getSecurityComplianceDependency().c(MapsKt.mapOf(TuplesKt.to("event", "upload")), MapsKt.mapOf(TuplesKt.to("duration", Long.valueOf(System.currentTimeMillis() - r100.f409483g))), null, 0);
            Log.i("AUDIT_AuditRecordImpl", "uploadAgain");
            r100.f409481e = CollectionsKt.emptyList();
            r100.f409482f = 1;
            r100.f409480d.set(false);
            LarkAppContext.Companion.getClass();
            ((l) e0c.k.a(LarkAppContext.access$getInstance$cp().getContext(), l.class)).a4();
            return;
        L6:
            if ((r111 instanceof com.bytedance.lark.rustclient.api.c) == false) goto L59;
            StringBuilder r101 = new StringBuilder("audit response error, errorMsg:");
            com.bytedance.lark.rustclient.api.c r113 = (com.bytedance.lark.rustclient.api.c) r111;
            r101.append(r113.f253907c.c());
            Log.e("AUDIT_AuditRecordImpl", r101.toString());
            LarkError r102 = r113.f253907c.f253922b;
            if (r102 == null) goto L12;
            Integer r103 = r102.code;
            if (r103 == null) goto L12;
            int r104 = r103.intValue();
        L13:
            LarkError r105 = r113.f253907c.f253922b;
            if (r105 == null) goto L18;
            LarkError.ErrorDetails r106 = r105.details;
            if (r106 == null) goto L18;
            String r107 = r106.x_tt_logid;
        L19:
            Log.e("AUDIT_AuditRecordImpl", "audit response code is " + r104 + " ,logId: " + r107);
            if (r104 != 263054401) goto L49;
            e r108 = this.f409488a;
            r108.getClass();
            Log.i("AUDIT_AuditRecordImpl", "filterUnExpectedEvent");
            List<? extends AuditDBData> r109 = r108.f409481e;
            ArrayList r114 = new ArrayList();
            Iterator<T> r115 = r109.iterator();
        L23:
            if (r115.hasNext() == false) goto L48;
            T r116 = r115.next();
            Event r117 = ((AuditDBData) r116).f409451c;
            if (r117 == null) goto L27;
            OperationType r118 = r117.mOperation;
        L29:
            if (r118 == OperationType.OperationPassportChangeAccount) goto L45;
            if (r117 == null) goto L33;
            OperatorEntity r119 = r117.mOperator;
        L34:
            if (r119 == null) goto L36;
            EntityType r120 = r119.mType;
        L38:
            if (r120 != EntityType.EntityUserID) goto L45;
            if (r119 == null) goto L41;
            String r121 = r119.mValue;
        L43:
            if (Intrinsics.areEqual(r121, r108.f409479c) == true) goto L45;
            boolean r122 = true;
        L46:
            if (r122 == false) goto L23;
            r114.add(r116);
            goto L23
        L41:
            r121 = null;
            goto L43
        L36:
            r120 = null;
            goto L38
        L33:
            r119 = null;
        L45:
            r122 = false;
            goto L46
        L27:
            r118 = null;
            goto L29
        L48:
            r108.f409478b.delete(r114);
        L49:
            nwa.d.b(System.currentTimeMillis() - this.f409488a.f409483g, r104, r113.f253907c.c(), r107);
            e r123 = this.f409488a;
            r123.getClass();
            r123.f409481e = CollectionsKt.emptyList();
            r123.f409480d.set(false);
            int r124 = r123.f409482f;
            if (r124 <= 0) goto L60;
            r123.f409482f = r124 - 1;
            Log.i("AUDIT_AuditRecordImpl", "attemptRetry");
            LarkAppContext.Companion.getClass();
            ((l) e0c.k.a(LarkAppContext.access$getInstance$cp().getContext(), l.class)).a4();
            return;
        L60:
            return;
        L18:
            r107 = null;
        L12:
            r104 = 999;
            goto L13
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f409489a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Subject<Long> f409490b;

        public g(e r100, Subject<Long> r101) {
            this.f409489a = r100;
            this.f409490b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            nwa.d.b(System.currentTimeMillis() - this.f409489a.f409483g, 999, String.valueOf(r101.getMessage()), null);
            StringBuilder r102 = new StringBuilder("audit response error, errorMsg:");
            r102.append(r101.getMessage());
            r102.append(", stackTrace is ");
            Intrinsics.checkNotNull(r101);
            r102.append(ExceptionsKt.stackTraceToString(r101));
            Log.e("AUDIT_AuditRecordImpl", r102.toString());
            this.f409489a.a(this.f409490b);
        }
    }

    static {
    }

    public final Disposable a(Subject<Long> r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        this.f409480d.set(false);
        this.f409483g = 0;
        this.f409482f = 1;
        ScheduledExecutorService r101 = com.ss.android.lark.audit.userscope.audit.a.f409464d;
        ExecutorScheduler r102 = com.ss.android.lark.audit.userscope.audit.a.f409465e;
        Disposable r103 = r100.observeOn(r102).filter(new b(this)).map(new c(this)).filter(new d(this)).flatMap(new C4757e(this)).observeOn(r102).subscribe(new f(this), new g(this, r100));
        Intrinsics.checkNotNull(r103);
        return r103;
    }

    @Inject
    public e(com.bytedance.lark.rustclient.api.l r100, com.ss.android.lark.audit.userscope.audit.d r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "userClient");
        Intrinsics.checkNotNullParameter(r101, "storage");
        Intrinsics.checkNotNullParameter(r102, "id");
        this.f409477a = r100;
        this.f409478b = r101;
        this.f409479c = r102;
        this.f409480d = new AtomicBoolean(false);
        this.f409481e = CollectionsKt.emptyList();
        this.f409482f = 1;
    }
}

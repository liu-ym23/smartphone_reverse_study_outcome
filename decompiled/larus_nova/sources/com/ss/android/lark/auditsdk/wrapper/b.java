package com.ss.android.lark.auditsdk.wrapper;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.audit.AuditManager;
import com.ss.android.lark.auditsdk.IAuditModuleDependency;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.pb.security_event.Event;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import com.ss.android.lark.utils.LarkContext;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ExecutorService f409710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IAuditModuleDependency f409711b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f409712c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f.a f409713d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f409714e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f409715f;

    public class a implements gwa.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f409716a;

        /* JADX INFO: renamed from: com.ss.android.lark.auditsdk.wrapper.b$a$a, reason: collision with other inner class name */
        public class C4765a implements gwa.g.b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f409717b;

            @Override // gwa.g.b
            public final KVRepo b() {
                return this.f409717b.f409716a.f409711b.getSecurityComplianceDependency().b();
            }

            @Override // gwa.g.b
            public final List<Integer> getLscSettingAuditValue() {
                return this.f409717b.f409716a.f409711b.getSecurityComplianceDependency().getLscSettingAuditValue();
            }

            public C4765a(a r100) {
                this.f409717b = r100;
            }

            @Override // gwa.g.b
            public final void c(Map r100, Map r101, Map r102, int r103) {
                this.f409717b.f409716a.f409711b.getSecurityComplianceDependency().c(r100, r101, r102, r103);
            }

            @Override // gwa.g.b
            public final void monitorEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
                this.f409717b.f409716a.f409711b.getSecurityComplianceDependency().monitorEvent(r100, r101, r102, r103);
            }
        }

        @Override // gwa.g
        public final /* synthetic */ gwa.g.a a() {
            return null;
        }

        @Override // gwa.g
        public final /* synthetic */ void monitorEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        }

        @Override // gwa.g
        public final String getHost() {
            return "https://www." + this.f409716a.f409711b.getDomain();
        }

        @Override // gwa.g
        public final gwa.g.b getSecurityComplianceDependency() {
            return new C4765a(this);
        }

        @Override // gwa.g
        public final boolean isDoubaoEnterpriseUser() {
            return this.f409716a.f409711b.isDoubaoEnterpriseUser();
        }

        public a(b r100) {
            this.f409716a = r100;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.auditsdk.wrapper.b$b, reason: collision with other inner class name */
    public class RunnableC4766b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f409718a;

        /* JADX INFO: renamed from: com.ss.android.lark.auditsdk.wrapper.b$b$a */
        public class a implements f.c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ RunnableC4766b f409719a;

            public a(RunnableC4766b r100) {
                this.f409719a = r100;
            }

            public final void a(f.a r100) {
                int r101 = f.f409727b;
                Intrinsics.checkNotNullParameter(r100, "param");
                if ((!TextUtils.isEmpty(r100.f409730b.mDID)) == true) goto L6;
                Log.e("AuditSdk", "setup common env2 failed");
                return;
            L6:
                this.f409719a.f409718a.f409713d = r100;
            }
        }

        public final void a() {
            if (this.f409718a.f409715f.get() == true) goto L13;
            Log.i("AuditSdk", "AuditSdk init");
            com.ss.android.lark.audit_provider.b.a(LarkContext.getApplication(), this.f409718a.f409714e);
            this.f409718a.f409712c.a(new a(this));     // Catch: Exception -> L7
        L9:
            this.f409718a.f409715f.set(true);
            return;
        L7:
            e = move-exception;
            Log.e("AuditSdk", "mParamCreatorV2.createEnv error, e: " + e.getMessage());
            goto L9
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

        public RunnableC4766b(b r100) {
            this.f409718a = r100;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Event.Builder f409720a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f409721b;

        public final void a() {
            if (this.f409721b.f409715f.get() == true) goto L6;
            Log.e("AuditSdk", "audit sdk is not init");
            return;
        L6:
            f.a r100 = this.f409721b.f409713d;
            if (r100 != null) goto L10;
            Log.e("AuditSdk", "Common env2 is not setup");
            return;
        L10:
            Event r101 = this.f409720a.Env(r100.f409730b).TenantID(this.f409721b.f409713d.f409729a).Operator(this.f409721b.f409713d.f409731c).build();
            StringBuilder r102 = new StringBuilder("audit event:");
            Intrinsics.checkNotNullParameter(r101, "<this>");
            String r103 = new Gson().toJson(r101);     // Catch: Exception -> L13
        L15:
            r102.append(r103);
            Log.d("AuditSdk", r102.toString());
            AuditManager.getInstance().auditSecurityEvent(r101);
            return;
        L13:
            e = move-exception;
            Log.e("AUDIT_AuditRecordParser", "GsonUtils.toJson error, error is: " + e.getMessage());
            r103 = "";
            goto L15
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

        public c(b r100, Event.Builder r101) {
            this.f409721b = r100;
            this.f409720a = r101;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f409722a = null;

        static {
            f409722a = new b();
        }
    }

    public final void b() {
        if (this.f409711b.isLogin() == true) goto L6;
        Exception r100 = new Exception();
        Log.e("AuditSdk", String.format("AuditSdk error: is not login\n%s", new Object[]{android.util.Log.getStackTraceString(r100)}), r100, true);
        return;
    L6:
        ExecutorService r101 = this.f409710a;
        if (r101 != null) goto L9;
    L10:
        this.f409710a = CoreThreadPool.getDefault().newSerialIODensityThreadPool("audit");
    L11:
        this.f409710a.execute(new RunnableC4766b(this));
        return;
    L9:
        if (r101.isShutdown() == false) goto L11;
        goto L10
    }

    public b() {
        this.f409714e = new a(this);
        this.f409715f = new AtomicBoolean(false);
        LarkContext.getApplication();
        IAuditModuleDependency r100 = owa.a.d();
        this.f409711b = r100;
        this.f409712c = new f();
        r100.registerAccountChangedListener(new com.ss.android.lark.auditsdk.wrapper.c());
    }

    public final void a(Event.Builder r100) {
        ExecutorService r101 = this.f409710a;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.isShutdown() == true) goto L9;
        this.f409710a.execute(new c(this, r100));
        return;
    }
}

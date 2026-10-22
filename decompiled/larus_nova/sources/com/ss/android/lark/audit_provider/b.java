package com.ss.android.lark.audit_provider;

import android.content.Context;
import com.ss.android.lark.appcontext.applifecycle.s;
import com.ss.android.lark.audit.AuditManager;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import gwa.g;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class b {

    public class a implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f409551a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f409552b;

        /* JADX INFO: renamed from: com.ss.android.lark.audit_provider.b$a$a, reason: collision with other inner class name */
        public class C4758a implements g.b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f409553b;

            @Override // gwa.g.b
            public final KVRepo b() {
                return this.f409553b.f409552b.getSecurityComplianceDependency().b();
            }

            @Override // gwa.g.b
            public final List<Integer> getLscSettingAuditValue() {
                return this.f409553b.f409552b.getSecurityComplianceDependency().getLscSettingAuditValue();
            }

            public C4758a(a r100) {
                this.f409553b = r100;
            }

            @Override // gwa.g.b
            public final void c(Map r100, Map r101, Map r102, int r103) {
                this.f409553b.f409552b.getSecurityComplianceDependency().c(r100, r101, r102, r103);
            }

            @Override // gwa.g.b
            public final void monitorEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
                this.f409553b.f409552b.getSecurityComplianceDependency().monitorEvent(r100, r101, r102, r103);
            }
        }

        @Override // gwa.g
        public final String getHost() {
            g r100 = this.f409552b;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.getHost();
        }

        @Override // gwa.g
        public final g.b getSecurityComplianceDependency() {
            return new C4758a(this);
        }

        @Override // gwa.g
        public final boolean isDoubaoEnterpriseUser() {
            g r100 = this.f409552b;
            if (r100 != null) goto L5;
        L7:
            return false;
        L5:
            if (r100.isDoubaoEnterpriseUser() == false) goto L7;
            return true;
        }

        @Override // gwa.g
        public final g.a a() {
            return this.f409551a;
        }

        public a(Context r100, g r101) {
            this.f409552b = r101;
            this.f409551a = new c(r100);
        }

        @Override // gwa.g
        public final void monitorEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
            this.f409552b.getSecurityComplianceDependency().monitorEvent(r100, r101, r102, r103);
        }
    }

    public static void a(Context r100, g r101) {
        if (AuditManager.isInit() == false) goto L5;
        return;
    L5:
        AuditManager.getInstance().initSdk(r100, new a(r100, r101));
        com.ss.android.lark.appcontext.applifecycle.c r102 = com.ss.android.lark.appcontext.applifecycle.c.a.f408832a;
        s r103 = new com.ss.android.lark.audit_provider.a();
        if (((CopyOnWriteArrayList) r102.f408830d).contains(r103) == true) goto L10;
        ((CopyOnWriteArrayList) r102.f408830d).add(r103);
        return;
    }
}

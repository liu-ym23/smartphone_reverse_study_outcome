package s4c;

import com.ss.android.lark.audit.AuditManager;
import com.ss.android.lark.audit.http.AuditResponseData;
import com.ss.android.lark.audit.http.BaseResponse;
import com.ss.android.lark.http.model.http.HttpHeaders;
import com.ss.android.lark.http.model.http.HttpMethod;
import com.ss.android.lark.http.model.http.HttpParams;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.security.compliance.infra.network.NetworkErrorResult;
import com.ss.android.lark.security.compliance.infra.network.d;
import com.ss.android.lark.security.compliance.infra.network.h;
import com.ss.android.lark.security.compliance.infra.util.f;
import gwa.g;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;
import kwa.c;
import kwa.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
@Singleton
@Deprecated(message = "To be deleted")
public final class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.security.compliance.infra.network.userscpoe.a f540681a;

    /* JADX INFO: renamed from: s4c.a$a, reason: collision with other inner class name */
    public static final class C7567a {
    }

    public static final class b implements d<Object> {

        /* JADX INFO: Incorrect field signature: TT; */
        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kwa.b f540682a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ kwa.d<AuditResponseData> f540683b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f540684c;

        @Override // com.ss.android.lark.security.compliance.infra.network.d
        public final Type b() {
            return Object.class;
        }

        @Override // com.ss.android.lark.security.compliance.infra.network.d
        public final void a(NetworkErrorResult r100) {
            Intrinsics.checkNotNullParameter(r100, "networkErrorResult");
            c r101 = new c(-1, r100.toString());
            this.f540683b.a(r101);
            a.b(this.f540684c, this.f540682a, this.f540683b);
        }

        @Override // com.ss.android.lark.security.compliance.infra.network.d
        public final void c(h<Object> r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            String r101 = r100.f440447c.toString();     // Catch: Throwable -> L22
            BaseResponse r102 = (BaseResponse) f.a(r101, BaseResponse.class);     // Catch: Throwable -> L22
            String r103 = "";
            if (r102 != null) goto L13;
            StringBuilder r104 = new StringBuilder();     // Catch: Throwable -> L22
            this.f540682a.getClass();     // Catch: Throwable -> L22
            g r105 = AuditManager.getInstance().getDependency();     // Catch: Throwable -> L22
            if (r105 == null) goto L10;
            r103 = r105.getHost();     // Catch: Throwable -> L22
        L10:
            r104.append(r103 + "/suite/admin/security/events/");     // Catch: Throwable -> L22
            r104.append(" baseResponse is null ");     // Catch: Throwable -> L22
            Log.e("HttpExecutorGlobalScope", r104.toString());     // Catch: Throwable -> L22
            this.f540683b.a(new c(-1, "baseResponse is null " + r101));     // Catch: Throwable -> L22
            a.b(this.f540684c, this.f540682a, this.f540683b);     // Catch: Throwable -> L22
            return;
        L13:
            if (r102.code == 0) goto L20;
            StringBuilder r106 = new StringBuilder();     // Catch: Throwable -> L22
            this.f540682a.getClass();     // Catch: Throwable -> L22
            g r107 = AuditManager.getInstance().getDependency();     // Catch: Throwable -> L22
            if (r107 == null) goto L18;
            r103 = r107.getHost();     // Catch: Throwable -> L22
        L18:
            r106.append(r103 + "/suite/admin/security/events/");     // Catch: Throwable -> L22
            r106.append(" baseResponse is error ");     // Catch: Throwable -> L22
            r106.append(r102.code);     // Catch: Throwable -> L22
            r106.append(' ');     // Catch: Throwable -> L22
            r106.append(r102.message);     // Catch: Throwable -> L22
            Log.e("HttpExecutorGlobalScope", r106.toString());     // Catch: Throwable -> L22
            this.f540683b.a(new c(r102.code, r102.message));     // Catch: Throwable -> L22
            a.b(this.f540684c, this.f540682a, this.f540683b);     // Catch: Throwable -> L22
            return;
        L20:
            this.f540683b.onResponse(r102.data);     // Catch: Throwable -> L22
            return;
        L22:
            th = move-exception;
            this.f540683b.a(new c(-1, th.getMessage()));
        }

        /* JADX WARN: Incorrect types in method signature: (TT;Lkwa/d<Lcom/ss/android/lark/audit/http/AuditResponseData;>;Ls4c/a;)V */
        public b(kwa.b r100, kwa.d r101, a r102) {
            this.f540682a = r100;
            this.f540683b = r101;
            this.f540684c = r102;
        }
    }

    static {
    }

    @Inject
    public a(com.ss.android.lark.security.compliance.infra.network.userscpoe.a r100) {
        Intrinsics.checkNotNullParameter(r100, "rust");
        this.f540681a = r100;
    }

    @Override // kwa.e
    public final <T extends kwa.b> void a(T r110, kwa.d<AuditResponseData> r111) {
        Intrinsics.checkNotNullParameter(r110, "request");
        if (r111 != null) goto L5;
        return;
    L5:
        Log.i("HttpExecutorGlobalScope", "start audit request!");
        HttpMethod r100 = HttpMethod.GET;
        HttpParams r101 = new HttpParams();
        HttpHeaders r102 = new HttpHeaders();
        LinkedHashMap r103 = new LinkedHashMap();
        HttpMethod r104 = HttpMethod.POST;
        Intrinsics.checkNotNullParameter(r104, com.alipay.sdk.m.p.e.f25671s);
        Intrinsics.checkNotNullParameter("/suite/admin/security/events/", "path");
        kwa.a r105 = (kwa.a) r110;
        r105.getClass();
        byte[] r106 = r105.f506485b.encode();     // Catch: Exception -> L8
    L10:
        byte[] r107 = r106;
        Intrinsics.checkNotNullParameter(r107, "rawBody");
        int r108 = com.ss.android.lark.security.compliance.infra.network.c.f440442a;
        r102.put("Content-Type", "application/x-protobuf");     // Catch: Exception -> L13
    L15:
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
        com.ss.android.lark.security.compliance.infra.network.a r112 = new com.ss.android.lark.security.compliance.infra.network.a("/suite/admin/security/events/", r104, r101, r102, new JSONObject(r103), true);
        r112.f440439h = "application/x-protobuf";
        r112.f440440i = r107;
        r110.getClass();
        g r109 = AuditManager.getInstance().getDependency();
        if (r109 != null) goto L18;
        String r113 = "";
    L19:
        r112.c(r113);
        this.f540681a.a(r112, new b(r110, r111, this));
        return;
    L18:
        r113 = r109.getHost();
    L13:
        e = move-exception;
        int r114 = ScsLogger.f440428a;
        ScsLogger.c("HttpUtils", "e: " + e.getMessage());
    L8:
        e = move-exception;
        Log.e("AuditRequestV2", "getRequestBytes error " + e.getMessage());
        r106 = new byte[0];
        goto L10
    }

    public static final void b(a r100, kwa.b r101, kwa.d r102) {
        r100.getClass();
        if (r101 == null) goto L10;
        int r103 = r101.f506486a;
        if (r103 >= 7) goto L9;
        r101.f506486a = r103 + 1;
        Log.i("HttpExecutorGlobalScope", "request.reTryNum = " + r101.f506486a);
        r100.a(r101, r102);
        return;
    L9:
        return;
    }
}

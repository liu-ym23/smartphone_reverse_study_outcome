package it3;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.apm.f;
import com.bytedance.apm.internal.ApmDelegate;
import com.bytedance.apm.util.r;
import com.bytedance.apm6.hub.a0;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.slardar.config.IResponseConfigListener;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import mt3.j;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f495716a;

    /* JADX INFO: loaded from: classes14.dex */
    public class a implements j {

        /* JADX INFO: renamed from: it3.b$a$a, reason: collision with other inner class name */
        public class RunnableC6356a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ JSONObject f495717a;

            @Override // java.lang.Runnable
            public final void run() {
                JSONObject r100 = this.f495717a;     // Catch: Throwable -> L9
                List<IResponseConfigListener> r101 = c.f495718a;     // Catch: Throwable -> L9
                if (r101 == null) goto L12;
                Iterator r102 = ((CopyOnWriteArrayList) r101).iterator();     // Catch: Throwable -> L9
            L6:
                if (r102.hasNext() == false) goto L19;
                ((IResponseConfigListener) r102.next()).onResponse(r100);     // Catch: Throwable -> L9
                goto L6
            L19:
                return;
            L12:
                return;
            L9:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L18;
                throw th;
            }

            public RunnableC6356a(JSONObject r100) {
                this.f495717a = r100;
            }
        }

        public a() {
        }

        @Override // mt3.j
        public final void onResponse(JSONObject r100) {
            if (com.bytedance.apm.d.k() == true) goto L5;
            return;
        L5:
            bt3.b.d.f20539a.e(new RunnableC6356a(r100));
        }
    }

    /* JADX INFO: renamed from: it3.b$b, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes14.dex */
    public class C6357b implements ru3.a {
        @Override // ru3.a
        public final JSONObject getDeviceInfo() {
            JSONObject r100 = new JSONObject();
            com.bytedance.apm.util.e.a.f190668a.a(r100, false);
            return r100;
        }

        public C6357b() {
        }
    }

    @Override // com.bytedance.apm6.hub.a0, du3.b
    public final void c() {
    }

    @Override // com.bytedance.apm6.hub.a0, du3.b
    public final Map<String, String> e() {
        Context r100 = com.bytedance.apm.d.f190513a;
        monitor-enter(com.bytedance.apm.d.class);
    L25:
        th = move-exception;
        throw th;
    L5:
        if (com.bytedance.apm.d.f190537y == null) goto L17;
        Map<String, String> r101 = com.bytedance.apm.d.g();     // Catch: Throwable -> L25
        if (r101 == null) goto L17;
        if (r101.size() <= 0) goto L17;
        if (com.bytedance.apm.d.f190536x.f190557j == null) goto L15;
        HashMap r102 = new HashMap(com.bytedance.apm.d.f190536x.f190557j);     // Catch: Throwable -> L25
        r102.putAll(r101);     // Catch: Throwable -> L25
        monitor-exit(com.bytedance.apm.d.class);
        return r102;
    L15:
        monitor-exit(com.bytedance.apm.d.class);
        return r101;
    L17:
        f r103 = com.bytedance.apm.d.f190536x;     // Catch: Throwable -> L25
        if (r103 == null) goto L22;
        Map<String, String> r104 = r103.f190557j;     // Catch: Throwable -> L25
        monitor-exit(com.bytedance.apm.d.class);
        return r104;
    L22:
        monitor-exit(com.bytedance.apm.d.class);
        return null;
    }

    @Override // com.bytedance.apm6.hub.a0
    public final ru3.a f() {
        return new C6357b();
    }

    @Override // com.bytedance.apm6.hub.a0
    public final it3.a g() {
        return new it3.a();
    }

    @Override // com.bytedance.apm6.hub.a0
    public final ff7.d h() {
        return ApmDelegate.g.f190592a.f190573d;
    }

    @Override // com.bytedance.apm6.hub.a0
    public final iu3.b j() {
        return new d();
    }

    @Override // com.bytedance.apm6.hub.a0
    public final ku3.b k() {
        return new e();
    }

    @Override // com.bytedance.apm6.hub.a0
    public final j l() {
        return new a();
    }

    @Override // du3.b
    public final String a() {
        f r100 = com.bytedance.apm.d.f();
        if (r100 == null) goto L5;
        String r101 = r100.f190555h;
    L7:
        if (TextUtils.isEmpty(r101) == true) goto L11;
        if (Objects.equals(r101, "null") == true) goto L11;
        return r101;
    L11:
        return r.a();
    L5:
        r101 = null;
        goto L7
    }

    @Override // du3.b
    public final String b() {
        return com.bytedance.apm.d.c();
    }

    @Override // com.bytedance.apm6.hub.a0, du3.b
    public final JSONObject d() {
        f r100 = com.bytedance.apm.d.f();
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.f190556i;
    }

    @Override // du3.b
    public final int getAid() {
        f r100 = com.bytedance.apm.d.f();
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.f190548a;
    }

    @Override // du3.b
    public final String getAppVersion() {
        f r100 = com.bytedance.apm.d.f();
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.f190554g;
    }

    @Override // du3.b
    public final String getChannel() {
        f r100 = com.bytedance.apm.d.f();
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.f190550c;
    }

    @Override // du3.b
    public final String getDeviceId() {
        f r100 = com.bytedance.apm.d.f();
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.f190549b;
    }

    @Override // du3.b
    public final int getManifestVersionCode() {
        f r100 = com.bytedance.apm.d.f();
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.f190553f;
    }

    @Override // du3.b
    public final String getSessionId() {
        if (com.bytedance.apm.d.f() == null) goto L8;
        gs3.b r100 = com.bytedance.apm.d.f190520h;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getSessionId();
    L8:
        return null;
    }

    @Override // du3.b
    public final long getUid() {
        if (com.bytedance.apm.d.f() == null) goto L8;
        gs3.b r100 = com.bytedance.apm.d.f190520h;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getUid();
    L8:
        return 0;
    }

    @Override // du3.b
    public final int getUpdateVersionCode() {
        f r100 = com.bytedance.apm.d.f();
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.f190551d;
    }

    @Override // du3.b
    public final int getVersionCode() {
        f r100 = com.bytedance.apm.d.f();
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.f190551d;
    }

    @Override // du3.b
    public final String getVersionName() {
        f r100 = com.bytedance.apm.d.f();
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.f190552e;
    }

    @Override // com.bytedance.apm6.hub.a0, du3.b
    public Context getContext() {
        return this.f495716a;
    }

    @Override // com.bytedance.apm6.hub.a0
    public final IHttpService i() {
        return com.bytedance.apm.d.f190522j;
    }

    public b(Context r100) {
        this.f495716a = r100;
    }
}

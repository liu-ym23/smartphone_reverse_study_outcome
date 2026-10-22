package com.bytedance.bdp.appbase.base.event;

import android.text.TextUtils;
import com.bytedance.bdp.appbase.base.bdptask.BdpTask;
import com.bytedance.bdp.appbase.base.bdptask.j;
import com.bytedance.bdp.appbase.base.ipc.BdpIpcService;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.bdpbase.schema.SchemaInfo;
import com.bytedance.bdp.serviceapi.defaults.event.BdpEventService;
import java.util.Iterator;
import kotlin.Lazy;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile InterfaceC2890c f200549d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f200550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f200551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g[] f200552c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f200553a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f200554b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final g f200555c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final f f200556d;

        /* JADX INFO: renamed from: com.bytedance.bdp.appbase.base.event.c$a$a, reason: collision with other inner class name */
        public class C2889a implements g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.bytedance.bdp.appbase.core.a f200557a;

            @Override // com.bytedance.bdp.appbase.base.event.c.g
            public final JSONObject getParams() {
                com.bytedance.bdp.appbase.core.a r100 = this.f200557a;
                Lazy r101 = BdpAppEventHelper.f200541a;
                JSONObject r102 = new JSONObject();
                if (r100 == null) goto L5;
                r100.a();
            L5:
                if (r100 == null) goto L7;
                r100.getMetaInfo();
            L7:
                BdpAppEventHelper.d(null, r102);
                return r102;
            }

            public C2889a(com.bytedance.bdp.appbase.core.a r100) {
                this.f200557a = r100;
            }
        }

        public final c a() {
            return new c(this.f200553a, this.f200554b, new g[]{this.f200555c, null, null, this.f200556d, null});
        }

        public a(String r100, g r101) {
            this.f200553a = System.currentTimeMillis();
            this.f200554b = r100;
            this.f200555c = r101;
            this.f200556d = new f();
        }

        public final void b(String r100, Object r101) {
            this.f200556d.a(r100, r101);
        }

        public a(String r100, com.bytedance.bdp.appbase.core.a r101) {
            this(r100, new C2889a(r101));
        }

        public a(String r100, SchemaInfo r101) {
            this(r100, new com.bytedance.bdp.appbase.base.event.d(r101));
        }
    }

    public class b implements InterfaceC2890c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public com.bytedance.bdp.appbase.base.event.f f200558a;

        public b() {
        }

        @Override // com.bytedance.bdp.appbase.base.event.c.InterfaceC2890c
        public final void sendEvent(String r100, JSONObject r101) {
            if (this.f200558a != null) goto L13;
            monitor-enter(this);
        L10:
            th = move-exception;
            throw th;
        L6:
            if (this.f200558a != null) goto L8;
            this.f200558a = (com.bytedance.bdp.appbase.base.event.f) ((BdpIpcService) BdpManager.getInst().getService(BdpIpcService.class)).getMainBdpIPC().f(com.bytedance.bdp.appbase.base.event.f.class);     // Catch: Throwable -> L10
        L8:
            monitor-exit(this);     // Catch: Throwable -> L10
        L13:
            this.f200558a.sendEventV3Sync(r100, r101.toString());
        }
    }

    /* JADX INFO: renamed from: com.bytedance.bdp.appbase.base.event.c$c, reason: collision with other inner class name */
    public interface InterfaceC2890c {
        void sendEvent(String r100, JSONObject r101);
    }

    public static abstract class d extends f {
        public abstract void b();

        @Override // com.bytedance.bdp.appbase.base.event.c.f, com.bytedance.bdp.appbase.base.event.c.g
        public final JSONObject getParams() {
            b();
            return this.f200559a;
        }

        public d() {
        }
    }

    public class e implements InterfaceC2890c {
        public e() {
        }

        @Override // com.bytedance.bdp.appbase.base.event.c.InterfaceC2890c
        public final void sendEvent(String r100, JSONObject r101) {
            ((BdpEventService) BdpManager.getInst().getService(BdpEventService.class)).e0();
        }
    }

    public static class f implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public JSONObject f200559a;

        public f() {
        }

        @Override // com.bytedance.bdp.appbase.base.event.c.g
        public JSONObject getParams() {
            return this.f200559a;
        }

        public final void a(String r100, Object r101) {
            if (r101 == null) goto L13;
        L8:
            e = move-exception;
            g94.b.c().Y1(e);
            return;
        L4:
            if (this.f200559a != null) goto L6;
            this.f200559a = new JSONObject();     // Catch: JSONException -> L8
        L6:
            this.f200559a.put(r100, r101);     // Catch: JSONException -> L8
            return;
        }
    }

    public interface g {
        JSONObject getParams();
    }

    public final void a() {
        int r100 = 0;
        if (TextUtils.isEmpty(this.f200551b) == false) goto L6;
        g94.b.e("Event", new Object[]{"#flush empty eventName"});
        return;
    L6:
        g94.b.d("Event", new Object[]{"#flush", "(1)", "start", this.f200551b});
        int r101 = ((Number) BdpApiSchOptAB.f200536c.getValue()).intValue();
        if (r101 > 0) goto L9;
    L11:
        r100 = r101;
    L12:
        new BdpTask.Builder().trace("flush AppEvent").onCPU().priority(r100).group((j) BdpApiSchOptAB.f200535b.getValue()).runnable(new com.bytedance.bdp.appbase.base.event.b(this)).start();
        return;
    L9:
        if (TextUtils.equals("mp_page_timeline", this.f200551b) == false) goto L11;
        goto L11
    }

    public static void b(JSONObject r100, JSONObject r101) {
        if (r100 == null) goto L17;
        if (r101 == null) goto L18;
        Iterator<String> r102 = r101.keys();     // Catch: Throwable -> L10
    L7:
        if (r102.hasNext() == false) goto L19;
        String r103 = r102.next();     // Catch: Throwable -> L10
        r100.put(r103, r101.get(r103));     // Catch: Throwable -> L10
        goto L7
    L19:
        return;
    L10:
        th = move-exception;
        g94.b.c().Y1(th);
        return;
    L18:
        return;
    }

    public c(long r100, String r101, g[] r102) {
        this.f200550a = r100;
        this.f200551b = r101;
        this.f200552c = r102;
    }
}

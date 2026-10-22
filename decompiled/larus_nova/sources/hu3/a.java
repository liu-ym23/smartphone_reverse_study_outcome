package hu3;

import android.text.TextUtils;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.services.slardar.config.IConfigListener;
import com.bytedance.services.slardar.config.IConfigManager;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
import xu3.d;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile a f487228h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f487229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<hu3.b> f487230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile JSONObject f487231c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f487232d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public C6199a f487233e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public IConfigManager f487234f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public cv3.a f487235g;

    /* JADX INFO: renamed from: hu3.a$a, reason: collision with other inner class name */
    public class C6199a extends cv3.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a f487236d;

        public final void a() {
            if (TextUtils.isEmpty(du3.a.f()) == false) goto L7;
            av3.b.a("APM-Config", "DeviceId not ready. try again later.");
            return;
        L7:
            if (this.f487236d.f487231c != null) goto L25;
            if (xu3.a.a() == false) goto L11;
            av3.b.a("APM-Config", "DeviceId ready. initConfig with device_id=" + du3.a.f());
        L11:
            a r100 = this.f487236d;
            if (r100.f487234f != null) goto L14;
            r100.f487234f = (IConfigManager) ServiceManager.getService(IConfigManager.class);
        L14:
            IConfigManager r101 = r100.f487234f;
            if (r101 == null) goto L27;
            String r102 = r101.queryConfig();
            if (xu3.a.a() == false) goto L30;
            av3.b.a("APM-Config", "initConfig:" + r102);
        L30:
            if (TextUtils.isEmpty(r102) == true) goto L27;
            r100.d(new JSONObject(r102), true);     // Catch: Exception -> L29
        L27:
            cv3.b.a(AsyncTaskManagerType.LIGHT_WEIGHT).b(this.f487236d.f487233e);
            return;
        L25:
            if (xu3.a.a() == false) goto L27;
            av3.b.a("APM-Config", "config is ready");
            goto L27
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

        public C6199a(a r100) {
            this.f487236d = r100;
            super(500, 1000);
        }
    }

    public class b implements IConfigListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f487237a;

        /* JADX INFO: renamed from: hu3.a$b$a, reason: collision with other inner class name */
        public class C6200a extends cv3.a {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ JSONObject f487238d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ boolean f487239e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ b f487240f;

            public final void a() {
                cv3.b.a(AsyncTaskManagerType.LIGHT_WEIGHT).b(this.f487240f.f487237a.f487235g);     // Catch: Exception -> L7
                a r100 = this.f487240f.f487237a;     // Catch: Exception -> L7
                r100.f487235g = null;     // Catch: Exception -> L7
                r100.d(this.f487238d, this.f487239e);     // Catch: Exception -> L7
                if (xu3.a.a() == false) goto L12;
                av3.b.a("APM-Config", "updateCurrentConfig:" + this.f487238d);     // Catch: Exception -> L7
                return;
            L12:
                return;
            L7:
                e = move-exception;
                av3.b.c("APM-Config", "onConfigChanged", e);
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

            public C6200a(b r100, JSONObject r101, boolean r102) {
                this.f487240f = r100;
                this.f487238d = r101;
                this.f487239e = r102;
            }
        }

        @Override // com.bytedance.services.slardar.config.IConfigListener
        public final void onReady() {
        }

        public b(a r100) {
            this.f487237a = r100;
        }

        @Override // com.bytedance.services.slardar.config.IConfigListener
        public final void onRefresh(JSONObject r100, boolean r101) {
            if (r100 != null) goto L17;
            return;
        L17:
            if (xu3.a.a() == false) goto L9;
            av3.b.a("APM-Config", "onRefresh:" + r101 + " " + r100);     // Catch: Exception -> L16
        L9:
            if (du3.a.o() == true) goto L11;
        L14:
            JSONObject r102 = new JSONObject(r100.toString());     // Catch: Exception -> L16
            this.f487237a.f487235g = new C6200a(this, r102, r101);     // Catch: Exception -> L16
            cv3.b.a(AsyncTaskManagerType.LIGHT_WEIGHT).c(this.f487237a.f487235g);     // Catch: Exception -> L16
            return;
        L11:
            if (this.f487237a.f487231c == null) goto L14;
            if (r101 == false) goto L14;
            return;
        }
    }

    public final synchronized void b() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.f487229a == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.f487229a = true;     // Catch: Throwable -> L14
        if (du3.a.o() == false) goto L11;
        this.f487233e = new C6199a(this);     // Catch: Throwable -> L14
        cv3.b.a(AsyncTaskManagerType.LIGHT_WEIGHT).c(this.f487233e);     // Catch: Throwable -> L14
    L11:
        IConfigManager r100 = (IConfigManager) ServiceManager.getService(IConfigManager.class);     // Catch: Throwable -> L14
        this.f487234f = r100;     // Catch: Throwable -> L14
        r100.registerConfigListener(new b(this));     // Catch: Throwable -> L14
        monitor-exit(this);
    }

    public static a a() {
        if (f487228h != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f487228h != null) goto L9;
        f487228h = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f487228h;
    }

    public a() {
        this.f487229a = false;
    }

    public final void c(hu3.b r100) {
        if (this.f487230b != null) goto L6;
        this.f487230b = new CopyOnWriteArrayList();
    L6:
        if (((CopyOnWriteArrayList) this.f487230b).contains(r100) == true) goto L9;
        ((CopyOnWriteArrayList) this.f487230b).add(r100);
    L9:
        if (this.f487232d == false) goto L12;
        r100.a(this.f487231c);
        return;
    }

    public final void d(JSONObject r100, boolean r101) {
        if (d.c(r100) == false) goto L5;
        return;
    L5:
        this.f487231c = r100;
        this.f487232d = true;
        List<hu3.b> r102 = this.f487230b;
        if (r102 == null) goto L14;
        Iterator r103 = ((CopyOnWriteArrayList) r102).iterator();
    L9:
        if (r103.hasNext() == false) goto L21;
        ((hu3.b) r103.next()).a(r100);     // Catch: Throwable -> L13
        goto L9
    L21:
        return;
    }
}

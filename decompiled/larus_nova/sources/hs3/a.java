package hs3;

import android.text.TextUtils;
import com.bytedance.apm.constant.UploadTypeInf;
import com.bytedance.apm.d;
import com.bytedance.apm.k;
import com.bytedance.apm.util.j;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.services.slardar.config.IConfigListener;
import com.bytedance.services.slardar.config.IConfigManager;
import com.larus.apm.impl.protector.RunnableProtector;
import hs3.c;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a<T extends c> implements IConfigListener {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f486956e = 1000;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f486957f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<T> f486958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f486959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f486960c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f486961d;

    /* JADX INFO: renamed from: hs3.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes14.dex */
    public class RunnableC6189a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f486962a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f486963b;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            this.f486963b.d(this.f486962a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public RunnableC6189a(a r100, c r101) {
            this.f486963b = r100;
            this.f486962a = r101;
        }
    }

    public boolean a(T r100) {
        return true;
    }

    public abstract void c(T r100);

    public void e(T r100) {
    }

    @Override // com.bytedance.services.slardar.config.IConfigListener
    public final void onReady() {
        this.f486959b = true;
        bt3.b.d.f20539a.e(new b(this));
    }

    @Override // com.bytedance.services.slardar.config.IConfigListener
    public void onRefresh(JSONObject r100, boolean r101) {
    }

    public final void f() {
        ((IConfigManager) ServiceManager.getService(IConfigManager.class)).registerConfigListener(this);
    }

    public a() {
        this.f486960c = false;
        this.f486961d = false;
        this.f486958a = new LinkedList();
    }

    public final void b(T r100) {
        bt3.b r101 = bt3.b.d.f20539a;
        if (r101.c() == true) goto L5;
        r101.e(new RunnableC6189a(this, r100));
        return;
    L5:
        d(r100);
    }

    public final void d(T r100) {
        if (a(r100) == true) goto L5;
        return;
    L5:
        e(r100);
        if (this.f486959b == false) goto L8;
        c(r100);
        return;
    L8:
        if (r100 == null) goto L32;
        LinkedList<T> r101 = this.f486958a;
        monitor-enter(r101);
    L23:
        th = move-exception;
        throw th;
    L13:
        if (this.f486958a.size() <= f486956e) goto L20;
        T r102 = this.f486958a.poll();     // Catch: Throwable -> L23
        if (f486957f == true) goto L17;
    L29:
        r102.a().toString();     // Catch: Exception -> L26 Throwable -> L23
        goto L20
    L17:
        if (this.f486960c == true) goto L29;
        k.b.f190610a.b();     // Catch: Throwable -> L23
        this.f486960c = true;     // Catch: Throwable -> L23
    L20:
        this.f486958a.add(r100);     // Catch: Throwable -> L23
        monitor-exit(r101);     // Catch: Throwable -> L23
        return;
    }

    public final void g(String r100, String r101, JSONObject r102, boolean r103, boolean r104) {
        if (d.j() == false) goto L5;
        ps3.b.a(new String[]{"type:" + r100 + " isSaveUnSampleLog:" + r104 + "isSampled:" + r103 + " log:" + r102});
    L5:
        if (r103 == false) goto L31;
        JSONArray r105 = null;
        if (this.f486961d == false) goto L9;
        JSONObject r106 = j.g(r102);
    L15:
        if (TextUtils.equals(r100, UploadTypeInf.TRACING) == false) goto L27;
        if (UploadTypeInf.BATCH_TRACING.equals(r101) == false) goto L25;
        if (r106 == null) goto L24;
        JSONArray r107 = r106.optJSONArray("wrapper_array_data");
        if (r107 == null) goto L24;
        r105 = r107;
    L24:
        jt3.a.f(new lt3.d(r105));
    L33:
        rs3.b r108 = rs3.b.a();
        r108.getClass();
        if (d.j() == false) goto L37;
        av3.b.a("LogObserver", "logObserverList:" + r108.f539105a.size());
    L37:
        if (r108.f539105a.size() == 0) goto L41;
        bt3.b.d.f20539a.j(new rs3.a(r108, r100, r101, r102));
    L41:
        if (TextUtils.equals(r100, UploadTypeInf.UI_ACTION) == false) goto L49;
        at3.a<JSONObject> r109 = ks3.a.a().f505906a;
        if (r109.f16222a.size() <= r109.f16223b) goto L45;
        r109.f16222a.removeFirst();
    L45:
        r109.f16222a.addLast(r102);
        return;
    L49:
        return;
    L25:
        jt3.a.f(new lt3.d(r106));
        goto L33
    L27:
        if (TextUtils.equals(r100, UploadTypeInf.COMMON_LOG) == false) goto L29;
        lt3.c r110 = new lt3.c(r101, r106);
        boolean r111 = jt3.a.f500287a;
        nu3.b.a(r110);
        goto L33
    L29:
        lt3.c r112 = new lt3.c(r100, r106);
        boolean r113 = jt3.a.f500287a;
        nu3.b.a(r112);
        goto L33
    L9:
        if (r102 != null) goto L47;
        r106 = null;
        goto L15
    L47:
        r106 = new JSONObject(r102.toString());     // Catch: Throwable -> L13
    L13:
        r106 = r102;
        goto L15
    L31:
        if (d.j() == false) goto L33;
        ls3.a.a(r100, r102, false);
        goto L33
    }
}

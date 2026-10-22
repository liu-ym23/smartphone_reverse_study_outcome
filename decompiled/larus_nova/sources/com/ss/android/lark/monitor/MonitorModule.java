package com.ss.android.lark.monitor;

import android.app.Activity;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.bytedance.apm.ApmAgent;
import com.bytedance.common.jato.JatoXL;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonResConstants;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.monitor.callback.DevicePerfManager;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public final class MonitorModule {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile MonitorModule f432319h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentLinkedDeque<String> f432320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<e> f432321b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f432322c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f432323d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ScheduledFuture f432324e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ScheduledFuture f432325f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ScheduledFuture f432326g;

    public static final enum Behaviour extends Enum<Behaviour> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Behaviour[] f432327a = null;
        public static final Behaviour open_page = null;
        public static final Behaviour open_tab = null;
        public static final Behaviour scroll_list = null;

        static {
            Behaviour r100 = new Behaviour("scroll_list", 0);
            scroll_list = r100;
            Behaviour r101 = new Behaviour("open_page", 1);
            open_page = r101;
            Behaviour r102 = new Behaviour("open_tab", 2);
            open_tab = r102;
            f432327a = new Behaviour[]{r100, r101, r102};
        }

        public static Behaviour[] values() {
            return (Behaviour[]) f432327a.clone();
        }

        public static Behaviour valueOf(String r100) {
            return (Behaviour) r27.a.a(Behaviour.class, r100);
        }

        public Behaviour(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum Business extends Enum<Business> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Business[] f432328a = null;
        public static final Business ccm = null;
        public static final Business common = null;
        public static final Business little_app = null;
        public static final Business messenger = null;
        public static final Business minutes = null;

        /* JADX INFO: renamed from: vc, reason: collision with root package name */
        public static final Business f432329vc = null;

        static {
            Business r100 = new Business(ThumbGlideUrl.SOURCE_VC, 0);
            f432329vc = r100;
            Business r101 = new Business("messenger", 1);
            messenger = r101;
            Business r102 = new Business(ChameleonResConstants.CCM_ROOT_DIR, 2);
            ccm = r102;
            Business r103 = new Business("little_app", 3);
            little_app = r103;
            Business r104 = new Business(DocumentType.MINUTES_NAME, 4);
            minutes = r104;
            Business r105 = new Business("common", 5);
            common = r105;
            f432328a = new Business[]{r100, r101, r102, r103, r104, r105};
        }

        public static Business[] values() {
            return (Business[]) f432328a.clone();
        }

        public static Business valueOf(String r100) {
            return (Business) r27.a.a(Business.class, r100);
        }

        public Business(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static MonitorModule e() {
        if (f432319h != null) goto L15;
        monitor-enter(MonitorModule.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f432319h != null) goto L9;
        f432319h = new MonitorModule();     // Catch: Throwable -> L11
    L9:
        monitor-exit(MonitorModule.class);     // Catch: Throwable -> L11
    L15:
        return f432319h;
    }

    public final void a() {
        ScheduledFuture r100 = this.f432326g;
        if (r100 == null) goto L6;
        r100.cancel(false);
        this.f432326g = null;
    L6:
        if (DevicePerfManager.b.f432386a.f432372e.f20370h == true) goto L8;
        return;
    L8:
        if (this.f432323d == true) goto L10;
        this.f432323d = true;
        CoreThreadPool.setAppCoreScene(true);
        JatoXL.startBlockGc("coreScene");
        JatoXL.lightJitBlockStart();
    L10:
        this.f432326g = CoreThreadPool.getDefault().getScheduleThreadPool().schedule(new q(this), 5000, TimeUnit.MILLISECONDS);
    }

    public final void b() {
        ScheduledFuture r100 = this.f432326g;
        if (r100 == null) goto L6;
        r100.cancel(false);
        this.f432326g = null;
    L6:
        if (DevicePerfManager.b.f432386a.f432372e.f20370h == true) goto L8;
        return;
    L8:
        if (this.f432323d == false) goto L12;
        this.f432326g = CoreThreadPool.getDefault().getScheduleThreadPool().schedule(new m(this), 500, TimeUnit.MILLISECONDS);
        return;
    }

    public final String d() {
        String r100 = this.f432320a.peek();
        if (this.f432322c == true) goto L5;
        return "StartUp";
    L5:
        if (TextUtils.isEmpty(r100) == false) goto L13;
        Activity r101 = AppLifecycle.a.f408803a.f();
        if (r101 != null) goto L14;
        return "background";
    L14:
        return r101.getClass().getName();
    L13:
        return r100.split("#hash")[0];
    }

    public MonitorModule() {
        this.f432320a = new ConcurrentLinkedDeque();
        this.f432321b = new ArrayList();
        this.f432322c = false;
        this.f432323d = false;
    }

    public static int c(ViewGroup r100) {
        int r101 = 0;
        if (r100 == null) goto L11;
        int r102 = r100.getChildCount();
        int r103 = 0;
    L5:
        if (r101 >= r102) goto L10;
        if ((r100.getChildAt(r101) instanceof ViewGroup) == false) goto L9;
        r103 = r103 + c((ViewGroup) r100.getChildAt(r101));
    L9:
        r101 = r101 + 1;
        goto L5
    L10:
        return r103;
    L11:
        return 0;
    }

    public final void g(final String r100) {
        if (this.f432322c == true) goto L5;
        return;
    L5:
        Log.i("ScenePerfMonitor", "startScene:" + r100);
        CoreThreadPool.getNonblockingHandler().post(new o(this, r100));
    }

    public final void f(Business r100, String r101) {
        String r102 = r100.name() + "_" + r101;
        g(r102);
        ApmAgent.startBatteryCollect(r102);
    }

    public final void h(Business r100, String r101) {
        String r102 = r100.name() + "_" + r101;
        j(r102, null);
        ApmAgent.stopBatteryCollect(r102);
    }

    public final void j(final String r100, final JSONObject r101) {
        Log.i("ScenePerfMonitor", "stopScene:" + r100);
        if (this.f432322c == true) goto L5;
        return;
    L5:
        CoreThreadPool.getNonblockingHandler().post(new l(this, r100, r101));
    }

    public final void i(Business r100, String r101, JSONObject r102) {
        String r103 = r100.name() + "_" + r101;
        j(r103, r102);
        ApmAgent.stopBatteryCollect(r103);
    }
}

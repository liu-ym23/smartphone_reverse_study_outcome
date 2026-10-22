package com.bytedance.bdp.appbase.base.log;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.bdp.appbase.base.bdptask.BdpHandler;
import com.bytedance.bdp.bdpbase.core.BdpTaskOptAB;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.bdpbase.util.ToastUtils;
import com.bytedance.bdp.serviceapi.defaults.log.BdpLogService;
import com.bytedance.bdp.serviceapi.hostimpl.info.BdpInfoService;
import com.bytedance.ee.lark.infra.foundation.log.AppBrandLogger;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes3.dex */
public class BdpAppLogServiceImpl implements BdpAppLogService {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f200566d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f200567e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final BdpHandler f200568f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g94.a f200569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference<StringBuilder> f200570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f200571c;

    /* JADX INFO: loaded from: classes11.dex */
    public class a implements j {
        @Override // com.bytedance.bdp.appbase.base.log.BdpAppLogServiceImpl.j
        public final void a() {
        }

        public a(String r100) {
        }
    }

    /* JADX INFO: loaded from: classes11.dex */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f200572a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f200573b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object[] f200574c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ BdpAppLogServiceImpl f200575d;

        public final void a() {
            if (this.f200572a.f200585b != null) goto L7;
            BdpAppLogServiceImpl.G2(this.f200573b);
        L7:
            if (this.f200572a.f200586c != null) goto L10;
            BdpAppLogServiceImpl r100 = this.f200575d;
            Object[] r101 = this.f200574c;
            int r102 = BdpAppLogServiceImpl.f200566d;
            r100.F2(r101);
        L10:
            BdpLogService r103 = BdpAppLogServiceImpl.I2();
            long r104 = this.f200572a.f200584a;
            r103.q1();
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

        public b(BdpAppLogServiceImpl r100, i r101, String r102, Object[] r103) {
            this.f200575d = r100;
            this.f200572a = r101;
            this.f200573b = r102;
            this.f200574c = r103;
        }
    }

    /* JADX INFO: loaded from: classes11.dex */
    public class c implements j {
        @Override // com.bytedance.bdp.appbase.base.log.BdpAppLogServiceImpl.j
        public final void a() {
        }

        public c(String r100) {
        }
    }

    /* JADX INFO: loaded from: classes11.dex */
    public class d implements j {
        @Override // com.bytedance.bdp.appbase.base.log.BdpAppLogServiceImpl.j
        public final void a() {
        }

        public d(String r100) {
        }
    }

    /* JADX INFO: loaded from: classes11.dex */
    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f200576a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f200577b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object[] f200578c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ BdpAppLogServiceImpl f200579d;

        public final void a() {
            if (this.f200576a.f200585b != null) goto L7;
            BdpAppLogServiceImpl.G2(this.f200577b);
        L7:
            if (this.f200576a.f200586c != null) goto L10;
            BdpAppLogServiceImpl r100 = this.f200579d;
            Object[] r101 = this.f200578c;
            int r102 = BdpAppLogServiceImpl.f200566d;
            r100.F2(r101);
        L10:
            BdpLogService r103 = BdpAppLogServiceImpl.I2();
            long r104 = this.f200576a.f200584a;
            r103.q1();
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

        public e(BdpAppLogServiceImpl r100, i r101, String r102, Object[] r103) {
            this.f200579d = r100;
            this.f200576a = r101;
            this.f200577b = r102;
            this.f200578c = r103;
        }
    }

    /* JADX INFO: loaded from: classes11.dex */
    public class f extends ThreadLocal<Integer> {
        @Override // java.lang.ThreadLocal
        public final Integer initialValue() {
            return Integer.valueOf(Process.myTid());
        }

        public f() {
        }
    }

    /* JADX INFO: loaded from: classes11.dex */
    public class g implements j {
        @Override // com.bytedance.bdp.appbase.base.log.BdpAppLogServiceImpl.j
        public final void a() {
        }

        public g(String r100) {
        }
    }

    /* JADX INFO: loaded from: classes11.dex */
    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f200580a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f200581b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object[] f200582c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ BdpAppLogServiceImpl f200583d;

        public final void a() {
            if (this.f200580a.f200585b != null) goto L7;
            BdpAppLogServiceImpl.G2(this.f200581b);
        L7:
            if (this.f200580a.f200586c != null) goto L10;
            BdpAppLogServiceImpl r100 = this.f200583d;
            Object[] r101 = this.f200582c;
            int r102 = BdpAppLogServiceImpl.f200566d;
            r100.F2(r101);
        L10:
            BdpLogService r103 = BdpAppLogServiceImpl.I2();
            long r104 = this.f200580a.f200584a;
            r103.q1();
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

        public h(BdpAppLogServiceImpl r100, i r101, String r102, Object[] r103) {
            this.f200583d = r100;
            this.f200580a = r101;
            this.f200581b = r102;
            this.f200582c = r103;
        }
    }

    /* JADX INFO: loaded from: classes11.dex */
    public class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f200584a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f200585b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f200586c;

        public i(BdpAppLogServiceImpl r100) {
            Integer r101 = r100.f200571c.get();
            if (r101 != null) goto L5;
            int r102 = 0;
        L6:
            this.f200584a = r102;
            System.currentTimeMillis();
            return;
        L5:
            r102 = r101.intValue();
            goto L6
        }
    }

    /* JADX INFO: loaded from: classes11.dex */
    public interface j {
        void a();
    }

    static {
        if (i94.a.f488780a == null) goto L8;
        if (ThreadMethodProxy.isAlive(i94.a.f488780a) == false) goto L8;
        i94.a.b r100 = i94.a.f488780a;
    L20:
        f200568f = new BdpHandler(r100.getLooper());
        return;
    L8:
        monitor-enter(i94.a.class);
    L22:
        th = move-exception;
        throw th;
    L10:
        if (i94.a.f488780a != null) goto L12;
    L13:
        i94.a.f488780a = new i94.a.b();     // Catch: Throwable -> L22
        if (((Boolean) BdpTaskOptAB.f201086b.getValue()).booleanValue() == false) goto L16;
        Process.setThreadPriority(1);     // Catch: Throwable -> L22
    L16:
        ThreadMethodProxy.start(i94.a.f488780a);     // Catch: Throwable -> L22
        new BdpHandler(i94.a.f488780a.getLooper());     // Catch: Throwable -> L22
    L17:
        i94.a.b r101 = i94.a.f488780a;     // Catch: Throwable -> L22
        monitor-exit(i94.a.class);     // Catch: Throwable -> L22
        r100 = r101;
        goto L20
    L12:
        if (ThreadMethodProxy.isAlive(i94.a.f488780a) == true) goto L17;
        goto L13
    }

    public static String H2() {
        if (TextUtils.isEmpty(f200567e) == false) goto L6;
        f200567e = ((BdpInfoService) BdpManager.getInst().getService(BdpInfoService.class)).getHostInfo().getChannel();
    L6:
        return f200567e;
    }

    @Override // com.bytedance.bdp.appbase.base.log.BdpAppLogService
    public final boolean isLocalTest() {
        return "local_test".equals(H2());
    }

    public BdpAppLogServiceImpl() {
        this.f200569a = null;
        this.f200570b = new AtomicReference(new StringBuilder());
        this.f200571c = new f();
    }

    public static BdpLogService I2() {
        BdpLogService r100 = (BdpLogService) BdpManager.getInst().getService(BdpLogService.class);
        r100.isEnabled();
        return r100;
    }

    public static boolean J2() {
        if (BdpManager.getInst().isDebugMode() == false) goto L5;
    L8:
        return true;
    L5:
        if ("local_test".equals(H2()) == true) goto L8;
        return false;
    }

    public static Object[] E2(Object... r100) {
        int r101 = r100.length;
        if (r101 <= 0) goto L14;
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L14;
        Object r103 = r100[r102];
        if ((r103 instanceof String) == true) goto L13;
        if ((r103 instanceof Throwable) == true) goto L13;
        r100[r102] = String.valueOf(r103);
    L13:
        r102 = r102 + 1;
    L14:
        return r100;
    }

    public static String G2(String r100) {
        if (r100 != null) goto L6;
        return "tma";
    L6:
        if (r100.startsWith(AppBrandLogger.TAG_PREFIX) == false) goto L8;
        return r100;
    L8:
        return AppBrandLogger.TAG_PREFIX.concat(r100);
    }

    @Override // com.bytedance.bdp.appbase.base.log.BdpAppLogService
    public final void E(Object... r100) {
        E2(r100);
        i r101 = new i(this);
        boolean r102 = J2();
        if (BdpManager.getInst().isDebugMode() == false) goto L5;
        String r103 = G2("BdpAppMonitor");
        String r104 = F2(r100);
        r101.f200585b = r103;
        r101.f200586c = r104;
        L2(r104, new com.bytedance.bdp.appbase.base.log.a(r103));
    L6:
        if (r102 == false) goto L13;
        String r105 = r101.f200586c;
        if (r105 != null) goto L11;
        r105 = F2(r100);
    L11:
        r101.f200586c = r105;
        Lazy r106 = ToastUtils.f201329a;
        ToastUtils.a(z84.a.a(), r101.f200586c);
        return;
    L13:
        return;
    L5:
        K2(new com.bytedance.bdp.appbase.base.log.b(this, r101, r100));
        goto L6
    }

    public final String F2(Object[] r110) {
        boolean r100 = ((Boolean) BdpTaskOptAB.f201086b.getValue()).booleanValue();
        if (r100 == false) goto L8;
        StringBuilder r101 = this.f200570b.getAndSet(null);
        if (r101 != null) goto L7;
        r101 = new StringBuilder();
    L10:
        if (BdpManager.getInst().isDebugMode() == false) goto L21;
        StackTraceElement[] r102 = new Throwable().getStackTrace();
        if (r102.length <= 3) goto L16;
        StackTraceElement r103 = r102[3];
        if (r103 == null) goto L16;
        String r104 = r103.getMethodName();
        int r105 = r103.getLineNumber();
        String r106 = r103.getFileName();
    L17:
        r101.append(r106);
        r101.append(" (");
        if (f200566d > 0) goto L20;
        f200566d = Process.myPid();
    L20:
        r101.append(f200566d);
        r101.append(") [");
        r101.append(r104);
        r101.append(':');
        r101.append(r105);
        r101.append(']');
    L16:
        r105 = -1;
        r104 = "unknown";
        r106 = "";
    L21:
        int r107 = r110.length;
        int r108 = 0;
    L23:
        if (r108 >= r107) goto L33;
        Object r109 = r110[r108];
        r101.append(' ');
        if ((r109 instanceof Throwable) == false) goto L27;
        String r111 = Log.getStackTraceString((Throwable) r109);
    L29:
        if ((r101.length() + r111.length()) > 4096) goto L30;
        r101.append(r111);
        r108 = r108 + 1;
        goto L23
    L30:
        r101.append(r111, 0, Math.min(r111.length(), Math.max(0, 4096 - r101.length())));
        return r101.toString();
    L27:
        r111 = String.valueOf(r109);
        goto L29
    L33:
        String r112 = r101.toString();
        if (r100 == true) goto L36;
    L40:
        return r112;
    L36:
        if (r101.length() <= 0) goto L40;
        if (r101.length() > 4096) goto L40;
        this.f200570b.set(r101);
        goto L40
    L7:
        r101.setLength(0);
        goto L10
    L8:
        r101 = new StringBuilder();
        goto L10
    }

    public final void K2(Runnable r100) {
        if (((Boolean) BdpTaskOptAB.f201086b.getValue()).booleanValue() == true) goto L5;
        f200568f.post(r100);
        return;
    L5:
        if (this.f200569a != null) goto L7;
        this.f200569a = new g94.a();
    L7:
        this.f200569a.b(r100);
    }

    @Override // com.bytedance.bdp.appbase.base.log.BdpAppLogService
    public final void Y1(Throwable r100) {
        if (J2() == false) goto L6;
        r100.printStackTrace();
        return;
    }

    @Override // com.bytedance.bdp.appbase.base.log.BdpAppLogService
    public final void o(Object... r100) {
        E2(r100);
        i r101 = new i(this);
        if (BdpManager.getInst().isDebugMode() == false) goto L5;
        String r102 = G2("AbsContextServiceFetcher");
        String r103 = F2(r100);
        r101.f200585b = r102;
        r101.f200586c = r103;
        L2(r103, new com.bytedance.bdp.appbase.base.log.c(r102));
    L7:
        if (isLocalTest() == true) goto L9;
        return;
    L9:
        if (r100.length <= 0) goto L16;
        Object r104 = r100[r100.length - 1];
        if ((r104 instanceof Throwable) == false) goto L17;
        Throwable r105 = (Throwable) r104;
        r105.printStackTrace();
        throw new RuntimeException(r105);
    L17:
        return;
    L16:
        return;
    L5:
        K2(new com.bytedance.bdp.appbase.base.log.d(this, r101, r100));
        goto L7
    }

    public static void L2(String r100, j r101) {
        int r102 = r100.length();
        if (r102 > 3800) goto L6;
        r101.a();
        return;
    L6:
        String r103 = "<continue_" + ((System.nanoTime() / 100) % 100000) + ">";
        StringBuilder r104 = new StringBuilder((r103.length() * 2) + 3800);
        ArrayList r105 = new ArrayList((r102 / 3800) + 1);
        int r106 = 0;
    L7:
        if (r106 >= r102) goto L16;
        r104.setLength(0);
        if (r106 <= 0) goto L11;
        r104.append(r103);
    L11:
        int r107 = r106 + 3800;
        if (r107 < r102) goto L14;
        r104.append(r100, r106, r102);
    L15:
        r105.add(r104.toString());
        r106 = r107;
        goto L7
    L14:
        r104.append(r100, r106, r107);
        r104.append(r103);
        goto L15
    L16:
        Iterator r108 = r105.iterator();
    L18:
        if (r108.hasNext() == false) goto L20;
        String r109 = (String) r108.next();
        r101.a();
        goto L18
    }

    @Override // com.bytedance.bdp.appbase.base.log.BdpAppLogService
    public final void d(String r100, Object... r101) {
        if (J2() == false) goto L10;
        String r102 = G2(r100);
        String r103 = F2(r101);
        if (BdpManager.getInst().isDebugMode() == false) goto L8;
        L2(r103, new c(r102));
        return;
    L8:
        I2().d(r102, r103);
        return;
    }

    @Override // com.bytedance.bdp.appbase.base.log.BdpAppLogService
    public final void e(String r100, Object... r101) {
        E2(r101);
        i r102 = new i(this);
        if (BdpManager.getInst().isDebugMode() == false) goto L6;
        String r103 = G2(r100);
        String r104 = F2(r101);
        r102.f200585b = r103;
        r102.f200586c = r104;
        L2(r104, new a(r103));
        return;
    L6:
        K2(new b(this, r102, r100, r101));
    }

    @Override // com.bytedance.bdp.appbase.base.log.BdpAppLogService
    public final void i(String r100, Object... r101) {
        E2(r101);
        i r102 = new i(this);
        if (BdpManager.getInst().isDebugMode() == false) goto L6;
        String r103 = G2(r100);
        String r104 = F2(r101);
        r102.f200585b = r103;
        r102.f200586c = r104;
        L2(r104, new g(r103));
        return;
    L6:
        K2(new h(this, r102, r100, r101));
    }

    @Override // com.bytedance.bdp.appbase.base.log.BdpAppLogService
    public final void w(String r100, Object... r101) {
        E2(r101);
        i r102 = new i(this);
        if (BdpManager.getInst().isDebugMode() == false) goto L6;
        String r103 = G2(r100);
        String r104 = F2(r101);
        r102.f200585b = r103;
        r102.f200586c = r104;
        L2(r104, new d(r103));
        return;
    L6:
        K2(new e(this, r102, r100, r101));
    }
}

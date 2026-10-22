package vic;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Message;
import android.provider.Settings;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.videoshop.context.VideoContext;
import com.ss.android.videoshop.log.tracer.LogTracer;
import com.ss.android.videoshop.log.tracer.PathID;
import com.ss.android.videoshop.mediaview.LayerHostMediaLayout;
import fjc.f;
import fjc.g;
import nic.i;
import nic.n;

/* JADX INFO: loaded from: classes40.dex */
public final class a implements WeakHandler.IHandler, vic.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f555362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakHandler f555363b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ejc.b f555364c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f555365d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f555366e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f555367f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f555368g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public i f555369h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Context f555370i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f555371j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f555372k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f555373l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f555374m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f555375n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f555376o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f555377p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f555378q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f555379r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f555380s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f555381t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public VideoContext f555382u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f555383v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f555384w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f555385x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public n f555386y;

    /* JADX INFO: renamed from: vic.a$a, reason: collision with other inner class name */
    public class RunnableC8013a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f555387a;

        @Override // java.lang.Runnable
        public final void run() {
            a.b(this.f555387a, true);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public RunnableC8013a(a r100) {
            this.f555387a = r100;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f555388a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f555388a.c();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(a r100) {
            this.f555388a = r100;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ bjc.b f555389a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f555390b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f555391c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a f555392d;

        public final void a() {
            if (this.f555392d.f555368g == false) goto L11;
            bjc.b r100 = this.f555389a;
            if (r100 == null) goto L7;
            r100.a("portrait", "true");
        L7:
            a r101 = this.f555392d;
            i r102 = r101.f555369h;
            if (r102 == null) goto L10;
            VideoContext r103 = (VideoContext) r102;
            r103.y0(false, r101.f555375n, this.f555390b, this.f555391c);
        L10:
            this.f555392d.getClass();
            this.f555392d.f();
            a r104 = this.f555392d;
            r104.f555367f = 0;
            r104.i();
            return;
        L11:
            bjc.b r105 = this.f555389a;
            if (r105 == null) goto L14;
            r105.a("portrait", "false");
        L14:
            a r106 = this.f555392d;
            i r107 = r106.f555369h;
            if (r107 == null) goto L17;
            VideoContext r108 = (VideoContext) r107;
            r108.y0(false, r106.f555375n, this.f555390b, this.f555391c);
        L17:
            this.f555392d.f();
            a r109 = this.f555392d;
            r109.f555367f = 0;
            r109.i();
            this.f555392d.f555382u.j0();
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

        public c(a r100, bjc.b r101, boolean r102, boolean r103) {
            this.f555392d = r100;
            this.f555389a = r101;
            this.f555390b = r102;
            this.f555391c = r103;
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f555393a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f555393a.f555366e = false;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public d(a r100) {
            this.f555393a = r100;
        }
    }

    public static boolean j() {
        String r100 = Build.MODEL;
        if (r100.equals("IN2010") == false) goto L5;
    L16:
        return true;
    L5:
        if (r100.equals("IN2020") == true) goto L16;
        if (r100.equals("KB2000") == true) goto L16;
        if (r100.equals("SM-G9910") == true) goto L16;
        if (r100.equals("SM-G9980") == true) goto L16;
        if (r100.equals("SM-G9960") == true) goto L16;
        return false;
    }

    public final void c() {
        int r100 = 0;
        bjc.b r101 = bjc.b.b("EnterFullScreenHideNavigation", PathID.ENTER_FULLSCREEN, 0);
        LogTracer.INS.addTrace(this.f555382u.m0(), r101);
        ejc.b r102 = this.f555364c;
        if (r102 == null) goto L5;
        vic.c r103 = r102.f472910l;
    L6:
        Activity r104 = fjc.d.a(this.f555370i);
        if (r104 == null) goto L33;
        Window r105 = r104.getWindow();
        if (r105 == null) goto L34;
        if (r103 != null) goto L14;
    L15:
        r100 = 514;
    L16:
        View r106 = r105.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L21;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r107 = ThreadMethodProxy.currentThread();
        if (r107 == com.larus.home.impl.utils.c.f346341a) goto L21;
        com.larus.home.impl.utils.c.a(r107, "getDecorView");
    L21:
        if (r106 != null) goto L23;
        return;
    L23:
        if (fjc.e.a(r105) == false) goto L25;
        r105.clearFlags(1024);
    L25:
        int r108 = r106.getSystemUiVisibility();
        int r109 = 5124;
        if (r100 == 0) goto L28;
        r109 = 5124 | r100;
    L28:
        if (r108 == r109) goto L32;
        r106.setSystemUiVisibility(r109);
        return;
    L32:
        return;
    L14:
        if (r103.f555395a == false) goto L16;
    L34:
        return;
    L33:
        return;
    L5:
        r103 = null;
        goto L6
    }

    public final void f() {
        Activity r100 = fjc.d.a(this.f555370i);
        if (r100 != null) goto L5;
        return;
    L5:
        Window r101 = r100.getWindow();
        if (r101 != null) goto L8;
        return;
    L8:
        LogTracer.INS.addTrace(this.f555382u.m0(), bjc.b.b("FOExitFullScreenMode", PathID.EXIT_FULLSCREEN, 0));
        if (this.f555378q == true) goto L14;
        if (fjc.e.a(r101) == false) goto L14;
        r101.clearFlags(1024);
    L14:
        if (this.f555381t == false) goto L22;
        View r102 = r101.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L20;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r103 = ThreadMethodProxy.currentThread();
        if (r103 == com.larus.home.impl.utils.c.f346341a) goto L20;
        com.larus.home.impl.utils.c.a(r103, "getDecorView");
    L20:
        r102.setSystemUiVisibility(this.f555376o);
        return;
    }

    public final void i() {
        Activity r100 = fjc.d.a(this.f555370i);
        if (Build.VERSION.SDK_INT < 28) goto L11;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.getWindow() != null) goto L8;
        return;
    L8:
        if (j() == false) goto L14;
        Window r101 = r100.getWindow();
        WindowManager.LayoutParams r102 = r101.getAttributes();
        r102.layoutInDisplayCutoutMode = this.f555377p;
        r101.setAttributes(r102);
        return;
    L14:
        return;
    }

    public final void k() {
        if (this.f555365d == true) goto L5;
        return;
    L5:
        if (this.f555372k == false) goto L19;
        this.f555362a.f555396a.remove(this);
        this.f555362a.f555396a.add(this);
        e r100 = this.f555362a;
        if (r100.f555399d == true) goto L21;
        e.a r101 = r100.f555397b;     // Catch: IllegalStateException -> L13
        if (r101 == null) goto L20;
        r101.enable();     // Catch: IllegalStateException -> L13
        r100.f555399d = true;     // Catch: IllegalStateException -> L13
        return;
    L20:
        return;
    L13:
        e = move-exception;
        Logger.throwException(e);
        return;
    L21:
        return;
    }

    public a(Context r100) {
        this.f555363b = new WeakHandler(this);
        boolean r101 = false;
        this.f555367f = 0;
        this.f555371j = -1;
        this.f555373l = -1;
        this.f555375n = -1;
        this.f555377p = 0;
        this.f555379r = 200;
        boolean r102 = true;
        this.f555380s = true;
        this.f555381t = true;
        this.f555383v = false;
        this.f555385x = -1;
        this.f555386y = new oic.c();
        if (fjc.d.a(r100) == null) goto L21;
        this.f555370i = r100;
        Activity r103 = fjc.d.a(r100);
        if (r103 != null) goto L22;
    L18:
        this.f555372k = r102;
        ajc.b.a("FullScreenOperator", "fixedOrientation:" + this.f555372k);
        this.f555362a = new e(r100);
        return;
    L22:
        ActivityInfo r104 = r103.getPackageManager().getActivityInfo(r103.getComponentName(), 0);     // Catch: Exception -> L16
        if (r104 == null) goto L18;
        int r105 = r104.screenOrientation;     // Catch: Exception -> L16
        this.f555373l = r105;     // Catch: Exception -> L16
        if (g.e(r105) == true) goto L14;
        if (g.f(r105) == true) goto L14;
        if (r105 == 14) goto L14;
    L15:
        r102 = r101;
    L14:
        r101 = true;
    L16:
        e = move-exception;
        e.printStackTrace();
        goto L18
    L21:
        throw new RuntimeException("FullScreenOperator context must be activity");
    }

    @Override // vic.d
    public final void a(int r100) {
        ajc.b.a("FullScreenOperator", "onScreenOrientationChanged orientation:" + f.a(r100));
        if (this.f555365d == true) goto L5;
        return;
    L5:
        if (this.f555366e == true) goto L34;
        n r101 = this.f555386y;
        if (r101 == null) goto L33;
        VideoContext r102 = this.f555382u;
        if (this.f555385x >= 0) goto L12;
    L15:
        this.f555385x = g.b(this.f555370i);
    L16:
        int r103 = this.f555385x;
        e r104 = this.f555362a;
        if (r104 != null) goto L30;
    L27:
        boolean r105 = true;
    L28:
        r101.a(r102, this, r100, r103, r105);
        return;
    L30:
        if (Settings.System.getInt(r104.f555398c.getContentResolver(), "accelerometer_rotation", 0) != 1) goto L23;
        boolean r106 = true;
    L24:
        if (r106 == true) goto L27;
        r105 = false;
    L23:
        r106 = false;
        goto L24
    L12:
        if (this.f555371j == 2) goto L15;
        if (this.f555384w == false) goto L16;
    L33:
        return;
    }

    public final void d(boolean r100) {
        LogTracer.INS.addTrace(this.f555382u.m0(), bjc.b.b("FOEnteringFullScreen", PathID.ENTER_FULLSCREEN, 0));
        if (this.f555383v == false) goto L5;
        fjc.a.a().post(new b(this));
    L6:
        i r101 = this.f555369h;
        if (r101 == null) goto L9;
        VideoContext r102 = (VideoContext) r101;
        r102.y0(true, this.f555375n, r100, false);
    L9:
        this.f555382u.j0();
        return;
    L5:
        c();
        goto L6
    }

    public final int g(boolean r100) {
        boolean r101 = true;
        if (r100 == false) goto L56;
        if (this.f555382u.f455965s == false) goto L21;
        e.a r102 = this.f555362a.f555397b;
        if (r102 != null) goto L9;
        int r103 = -1;
    L10:
        if (r103 != (-1)) goto L15;
        int r104 = this.f555373l;
        if (r104 == 8) goto L14;
        if (r104 != 0) goto L15;
    L14:
        return r104;
    L15:
        if (r103 == 8) goto L67;
        if (r103 != 0) goto L19;
        return r103;
    L19:
        return this.f555373l;
    L67:
        return r103;
    L9:
        r103 = r102.f555400a;
        goto L10
    L21:
        if (this.f555368g == true) goto L23;
        e.a r105 = this.f555362a.f555397b;
        if (r105 != null) goto L33;
        int r106 = -1;
    L34:
        if (r106 != (-1)) goto L40;
        int r107 = this.f555373l;
        if (r107 == 8) goto L38;
        if (r107 != 0) goto L40;
    L38:
        return r107;
    L40:
        if (r106 != 9) goto L48;
        Activity r108 = fjc.d.a(this.f555370i);
        if (r108 == null) goto L48;
        int r109 = r108.getRequestedOrientation();
        if (r109 == 8) goto L46;
        if (r109 != 0) goto L48;
    L46:
        return r109;
    L48:
        if (8 == r106) goto L51;
        r101 = false;
    L51:
        if (r101 == true) goto L69;
        return 0;
    L69:
        return 8;
    L33:
        r106 = r105.f555400a;
        goto L34
    L23:
        if (g.f(this.f555373l) == false) goto L26;
        return 1;
    L26:
        if (g.e(this.f555373l) == true) goto L28;
        return 1;
    L28:
        return this.f555373l;
    L56:
        if (this.f555382u.f455965s == false) goto L60;
        return this.f555373l;
    L60:
        if (g.f(this.f555373l) == false) goto L63;
        return 1;
    L63:
        if (g.e(this.f555373l) == true) goto L65;
        return 1;
    L65:
        return this.f555373l;
    }

    public final void h(int r100) {
        boolean r101 = true;
        this.f555366e = true;
        this.f555363b.postDelayed(new d(this), 300);
        fjc.d.a(this.f555370i).setRequestedOrientation(r100);     // Catch: Throwable -> L13
        ajc.b.a("FullScreenOperator", "requestOrientation orientation:" + f.a(r100));     // Catch: Throwable -> L13
        PathID r102 = PathID.ENTER_FULLSCREEN;     // Catch: Throwable -> L13
        if (this.f555367f == 3) goto L7;
        r101 = false;
    L7:
        if (r101 == false) goto L9;
        r102 = PathID.EXIT_FULLSCREEN;     // Catch: Throwable -> L13
    L9:
        bjc.b r103 = bjc.b.b("FORequestOrientation", r102, 6);     // Catch: Throwable -> L13
        if (r103 == null) goto L16;
        r103.a("orientation", "" + r100);     // Catch: Throwable -> L13
        LogTracer.INS.addTrace(this.f555382u.m0(), r103);     // Catch: Throwable -> L13
        return;
    L16:
        return;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public final void handleMsg(Message r100) {
        int r101 = r100.what;
        boolean r102 = true;
        if (r101 == 1) goto L9;
        if (r101 == 2) goto L7;
        return;
    L7:
        if (this.f555367f != 1) goto L73;
        ajc.b.a("FullScreenOperator", "MSG_VIDEO_ENTERING_FULLSCREEN");
        d(((Boolean) r100.obj).booleanValue());
        this.f555367f = 2;
        this.f555384w = true;
        return;
    L73:
        return;
    L9:
        int r103 = r100.arg1;
        if (this.f555365d == true) goto L12;
    L69:
        i r104 = this.f555369h;
        if (r104 == null) goto L82;
        VideoContext r105 = (VideoContext) r104;
        r105.S(this.f555365d, r103);
        return;
    L82:
        return;
    L12:
        if (this.f555385x >= 0) goto L14;
    L17:
        this.f555385x = g.b(this.f555370i);
    L19:
        if (r103 == this.f555385x) goto L69;
        if (r103 == (-1)) goto L69;
        if (r103 == 9) goto L69;
        if (r103 != 1) goto L46;
        boolean r106 = this.f555382u.f455965s;
        if (r106 == false) goto L33;
        if (r106 == false) goto L46;
        if (this.f555374m == false) goto L46;
    L33:
        if (this.f555367f != 2) goto L35;
        boolean r107 = true;
    L36:
        if (r107 == false) goto L75;
        i r108 = this.f555369h;
        if (r108 == null) goto L43;
        if (((VideoContext) r108).z0(false, r103) == false) goto L43;
        return;
    L43:
        if (this.f555368g == true) goto L76;
        e(true, false);
        return;
    L76:
        return;
    L75:
        return;
    L35:
        r107 = false;
    L46:
        if (this.f555367f != 2) goto L48;
        boolean r109 = true;
    L49:
        if (r109 == false) goto L58;
        int r110 = g.b(this.f555370i);
        if (r103 == (-1)) goto L54;
        if (r103 == r110) goto L54;
    L55:
        if (r102 == false) goto L57;
        h(r103);
    L57:
        c();
        return;
    L54:
        r102 = false;
        goto L55
    L58:
        i r111 = this.f555369h;
        if (r111 == null) goto L64;
        if (((VideoContext) r111).z0(true, r103) == false) goto L64;
        return;
    L64:
        if (this.f555368g == true) goto L79;
        VideoContext r112 = this.f555382u;
        RunnableC8013a r113 = new RunnableC8013a(this);
        LayerHostMediaLayout r114 = r112.f455949c;
        if (r114 == null) goto L68;
        r114.o0(r113);
        return;
    L68:
        r113.run();
        return;
    L79:
        return;
    L48:
        r109 = false;
        goto L49
    L14:
        if (this.f555371j == 2) goto L17;
        if (this.f555384w == false) goto L19;
        goto L17
    }

    public static void b(a r100, boolean r101) {
        r100.getClass();
        ajc.b.a("FullScreenOperator", "enterfullscreen videoScreenState:" + r100.f555367f);
        if (r100.f555367f != 0) goto L50;
        LogTracer.INS.addTrace(r100.f555382u.m0(), bjc.b.b("FOEnterFullScreen", PathID.ENTER_FULLSCREEN, 6));
        boolean r102 = true;
        r100.f555367f = 1;
        Activity r103 = fjc.d.a(r100.f555370i);
        if (r103 == null) goto L15;
        r100.f555378q = fjc.e.a(r103.getWindow());
        if (Build.VERSION.SDK_INT >= 28) goto L10;
    L14:
        r100.f555383v = false;
    L16:
        Activity r104 = fjc.d.a(r100.f555370i);
        if (r104 == null) goto L27;
        Window r105 = r104.getWindow();
        if (r105 == null) goto L27;
        View r106 = r105.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L25;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r107 = ThreadMethodProxy.currentThread();
        if (r107 == com.larus.home.impl.utils.c.f346341a) goto L25;
        com.larus.home.impl.utils.c.a(r107, "getDecorView");
    L25:
        if (r106 == null) goto L27;
        int r108 = r106.getSystemUiVisibility();
    L28:
        r100.f555376o = r108;
        r100.f555374m = r101;
        int r109 = r100.g(true);
        r100.f555375n = r109;
        i r110 = r100.f555369h;
        if (r110 == null) goto L31;
        ((VideoContext) r110).A0(true, r109, r101, false);
    L31:
        int r111 = r100.f555375n;
        int r112 = g.b(r100.f555370i);
        if (r111 == (-1)) goto L35;
        if (r111 == r112) goto L35;
    L37:
        if (r102 == false) goto L39;
        ajc.b.a("FullScreenOperator", "enterfullscreen needRequestOrientation targetOrientation:" + f.a(r100.f555375n) + " halfScreenUiFlags:" + r100.f555376o);
        r100.h(r100.f555375n);
        r100.f555363b.sendMessageDelayed(Message.obtain(r100.f555363b, 2, Boolean.valueOf(r101)), (long) r100.f555379r);
        r100.f555384w = false;
        return;
    L39:
        ajc.b.a("FullScreenOperator", "enterfullscreen do not needRequestOrientation targetOrientation:" + f.a(r100.f555375n) + " halfScreenUiFlags:" + r100.f555376o);
        LayerHostMediaLayout r113 = r100.f555382u.f455949c;
        if (r113 != null) goto L42;
    L46:
        r100.d(r101);
        r100.f555367f = 2;
        return;
    L42:
        if (r113.a0() == false) goto L46;
        if (r113.V() == false) goto L46;
        r100.f555363b.sendMessageDelayed(Message.obtain(r100.f555363b, 2, Boolean.valueOf(r101)), r100.f555379r);
        r100.f555384w = false;
        return;
    L35:
        r102 = false;
    L27:
        r108 = -1;
        goto L28
    L10:
        if (r103.getWindow() == null) goto L14;
        if (j() == false) goto L14;
        Window r114 = r103.getWindow();
        WindowManager.LayoutParams r115 = r114.getAttributes();
        r100.f555377p = r115.layoutInDisplayCutoutMode;
        r115.layoutInDisplayCutoutMode = 1;
        r114.setAttributes(r115);
        r100.f555383v = true;
        goto L16
    L15:
        r100.f555378q = false;
        goto L16
    }

    public final void e(boolean r100, boolean r101) {
        ajc.b.a("FullScreenOperator", "exitfullscreen videoScreenState:" + this.f555367f);
        if (this.f555367f == 2) goto L5;
        return;
    L5:
        bjc.b r102 = bjc.b.b("FOExitFullScreen", PathID.EXIT_FULLSCREEN, 6);
        LogTracer.INS.addTrace(this.f555382u.m0(), r102);
        this.f555367f = 3;
        int r103 = g(false);
        this.f555375n = r103;
        this.f555374m = r100;
        i r104 = this.f555369h;
        if (r104 == null) goto L8;
        ((VideoContext) r104).A0(false, r103, r100, r101);
    L8:
        h(this.f555375n);
        c r105 = new c(this, r102, r100, r101);
        LayerHostMediaLayout r106 = this.f555382u.f455949c;
        if (r106 != null) goto L11;
    L13:
        r105.run();
        return;
    L11:
        if (r106.a0() == false) goto L13;
        this.f555363b.post(r105);
    }
}

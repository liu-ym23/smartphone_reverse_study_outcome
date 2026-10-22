package jo2;

import android.os.SystemClock;
import android.view.Choreographer;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livehostapi.platform.IHostPerformanceMonitor;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.performance.scrollstall.ScrollState;
import com.bytedance.android.livesdk.service.f;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.performance.IStallCallback;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.common.utility.concurrent.SimpleThreadFactory;
import com.bytedance.ies.sdk.widgets.priority.PriorityModule;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jo2.d f499833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final jo2.d f499834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final jo2.d f499835c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final jo2.d f499836d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final IHostPerformanceMonitor f499837e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ExecutorService f499838f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f499839g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f499840h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f499841i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f499842j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f499843k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f499844l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final a f499845m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final C6470b f499846n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c f499847o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final d f499848p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final IPerformanceManager f499849q;

    public static final class a implements IStallCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f499850a;

        /* JADX INFO: renamed from: jo2.b$a$a, reason: collision with other inner class name */
        public static final class RunnableC6469a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f499851a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ double f499852b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ JSONObject f499853c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ long f499854d;

            public RunnableC6469a(a r100, double r101, JSONObject r102, long r103) {
                this.f499851a = r100;
                this.f499852b = r101;
                this.f499853c = r102;
                this.f499854d = r103;
            }

            public final void a() {
                jo2.d r100 = this.f499851a.f499850a.f499833a;
                ScrollState r101 = ScrollState.DRAG;
                r100.getClass();
                Intrinsics.checkNotNullParameter(r101, "scrollState");
                r100.f499872a = r101.getValue();
                b r102 = this.f499851a.f499850a;
                r102.f499833a.a(r102.f499837e.getCpuRate());
                b r103 = this.f499851a.f499850a;
                jo2.d r104 = r103.f499833a;
                r104.f499889r = r103.f499837e.getGpuUsage();
                this.f499851a.f499850a.f499833a.c(this.f499852b, this.f499853c);
                this.f499851a.f499850a.f499833a.b(this.f499854d);
                b.a(this.f499851a.f499850a, r101);
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
        }

        @Override // com.bytedance.android.livesdkapi.performance.IStallCallback
        public final void onBlockReady(long r100, int r101, long r102) {
        }

        public a(b r100) {
            this.f499850a = r100;
        }

        @Override // com.bytedance.android.livesdkapi.performance.IStallCallback
        public final void onFpsReady(double r110, JSONObject r111) {
            long r100 = SystemClock.uptimeMillis();
            b r101 = this.f499850a;
            long r112 = r100 - r101.f499840h;
            r101.f499838f.submit(new RunnableC6469a(this, r110, r111, r112));
        }
    }

    /* JADX INFO: renamed from: jo2.b$b, reason: collision with other inner class name */
    public static final class C6470b implements IStallCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f499855a;

        /* JADX INFO: renamed from: jo2.b$b$a */
        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ C6470b f499856a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ double f499857b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ JSONObject f499858c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ long f499859d;

            public a(C6470b r100, double r101, JSONObject r102, long r103) {
                this.f499856a = r100;
                this.f499857b = r101;
                this.f499858c = r102;
                this.f499859d = r103;
            }

            public final void a() {
                jo2.d r100 = this.f499856a.f499855a.f499834b;
                ScrollState r101 = ScrollState.FLING;
                r100.getClass();
                Intrinsics.checkNotNullParameter(r101, "scrollState");
                r100.f499872a = r101.getValue();
                b r102 = this.f499856a.f499855a;
                r102.f499834b.a(r102.f499837e.getCpuRate());
                b r103 = this.f499856a.f499855a;
                jo2.d r104 = r103.f499834b;
                r104.f499889r = r103.f499837e.getGpuUsage();
                this.f499856a.f499855a.f499834b.c(this.f499857b, this.f499858c);
                this.f499856a.f499855a.f499834b.b(this.f499859d);
                b.a(this.f499856a.f499855a, r101);
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
        }

        @Override // com.bytedance.android.livesdkapi.performance.IStallCallback
        public final void onBlockReady(long r100, int r101, long r102) {
        }

        public C6470b(b r100) {
            this.f499855a = r100;
        }

        @Override // com.bytedance.android.livesdkapi.performance.IStallCallback
        public final void onFpsReady(double r110, JSONObject r111) {
            long r100 = SystemClock.uptimeMillis();
            b r101 = this.f499855a;
            long r112 = r100 - r101.f499841i;
            r101.f499838f.submit(new a(this, r110, r111, r112));
        }
    }

    public static final class c implements IStallCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f499860a;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f499861a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ double f499862b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ JSONObject f499863c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ long f499864d;

            public a(c r100, double r101, JSONObject r102, long r103) {
                this.f499861a = r100;
                this.f499862b = r101;
                this.f499863c = r102;
                this.f499864d = r103;
            }

            public final void a() {
                jo2.d r100 = this.f499861a.f499860a.f499835c;
                ScrollState r101 = ScrollState.FULL;
                r100.getClass();
                Intrinsics.checkNotNullParameter(r101, "scrollState");
                r100.f499872a = r101.getValue();
                b r102 = this.f499861a.f499860a;
                r102.f499835c.a(r102.f499837e.getCpuRate());
                b r103 = this.f499861a.f499860a;
                jo2.d r104 = r103.f499835c;
                r104.f499889r = r103.f499837e.getGpuUsage();
                this.f499861a.f499860a.f499835c.c(this.f499862b, this.f499863c);
                this.f499861a.f499860a.f499835c.b(this.f499864d);
                b.a(this.f499861a.f499860a, r101);
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
        }

        @Override // com.bytedance.android.livesdkapi.performance.IStallCallback
        public final void onBlockReady(long r100, int r101, long r102) {
        }

        public c(b r100) {
            this.f499860a = r100;
        }

        @Override // com.bytedance.android.livesdkapi.performance.IStallCallback
        public final void onFpsReady(double r110, JSONObject r111) {
            long r100 = SystemClock.uptimeMillis();
            b r101 = this.f499860a;
            long r112 = r100 - r101.f499839g;
            r101.f499838f.submit(new a(this, r110, r111, r112));
        }
    }

    public static final class d implements IStallCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f499865a;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f499866a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ double f499867b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ JSONObject f499868c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ long f499869d;

            public a(d r100, double r101, JSONObject r102, long r103) {
                this.f499866a = r100;
                this.f499867b = r101;
                this.f499868c = r102;
                this.f499869d = r103;
            }

            public final void a() {
                jo2.d r100 = this.f499866a.f499865a.f499836d;
                ScrollState r101 = ScrollState.SCROLL_FINISHED;
                r100.getClass();
                Intrinsics.checkNotNullParameter(r101, "scrollState");
                r100.f499872a = r101.getValue();
                b r102 = this.f499866a.f499865a;
                r102.f499836d.a(r102.f499837e.getCpuRate());
                b r103 = this.f499866a.f499865a;
                jo2.d r104 = r103.f499836d;
                r104.f499889r = r103.f499837e.getGpuUsage();
                this.f499866a.f499865a.f499836d.c(this.f499867b, this.f499868c);
                this.f499866a.f499865a.f499836d.b(this.f499869d);
                b.a(this.f499866a.f499865a, r101);
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
        }

        @Override // com.bytedance.android.livesdkapi.performance.IStallCallback
        public final void onBlockReady(long r100, int r101, long r102) {
        }

        public d(b r100) {
            this.f499865a = r100;
        }

        @Override // com.bytedance.android.livesdkapi.performance.IStallCallback
        public final void onFpsReady(double r110, JSONObject r111) {
            long r100 = SystemClock.uptimeMillis();
            b r101 = this.f499865a;
            long r112 = r100 - r101.f499842j;
            r101.f499838f.submit(new a(this, r110, r111, r112));
        }
    }

    public static final class e implements Choreographer.FrameCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f499870a;

        public e(b r100) {
            this.f499870a = r100;
        }

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long r100) {
            IPerformanceManager r101 = this.f499870a.f499849q;
            if (r101 == null) goto L5;
            r101.stopMonitorFps(ScrollState.SCROLL_FINISHED.getValue(), this.f499870a.f499848p);
        L5:
            IPerformanceManager r102 = this.f499870a.f499849q;
            if (r102 == null) goto L9;
            r102.releaseFpsMonitor(ScrollState.SCROLL_FINISHED.getValue());
            return;
        }
    }

    public final void b() {
        IPerformanceManager r100 = this.f499849q;
        if (r100 == null) goto L5;
        r100.stopMonitorFps(ScrollState.DRAG.getValue(), this.f499845m);
    L5:
        IPerformanceManager r101 = this.f499849q;
        if (r101 == null) goto L9;
        r101.releaseFpsMonitor(ScrollState.DRAG.getValue());
        return;
    }

    public final void c() {
        IPerformanceManager r100 = this.f499849q;
        if (r100 == null) goto L5;
        r100.stopMonitorFps(ScrollState.FULL.getValue(), this.f499847o);
    L5:
        IPerformanceManager r101 = this.f499849q;
        if (r101 == null) goto L9;
        r101.releaseFpsMonitor(ScrollState.FULL.getValue());
        return;
    }

    public final void d() {
        Choreographer.getInstance().postFrameCallback(new e(this));     // Catch: Throwable -> L4
        return;
    L4:
        IPerformanceManager r100 = this.f499849q;
        if (r100 == null) goto L7;
        r100.stopMonitorFps(ScrollState.SCROLL_FINISHED.getValue(), this.f499848p);
    L7:
        IPerformanceManager r101 = this.f499849q;
        if (r101 == null) goto L13;
        r101.releaseFpsMonitor(ScrollState.SCROLL_FINISHED.getValue());
        return;
    }

    public b(IPerformanceManager r100) {
        this.f499849q = r100;
        this.f499833a = new jo2.d();
        this.f499834b = new jo2.d();
        this.f499835c = new jo2.d();
        this.f499836d = new jo2.d();
        this.f499837e = ((f) TTLiveSDKContext.getHostService()).f157991a.hostPerformanceMonitor();
        this.f499838f = PThreadExecutorsUtils.newSingleThreadExecutor(new SimpleThreadFactory("scroll_stall_thread"));
        this.f499839g = -1;
        this.f499840h = -1;
        this.f499841i = -1;
        this.f499842j = -1;
        this.f499843k = -1;
        this.f499844l = -1;
        this.f499845m = new a(this);
        this.f499846n = new C6470b(this);
        this.f499847o = new c(this);
        this.f499848p = new d(this);
    }

    public static final void a(b r100, ScrollState r101) {
        r100.getClass();
        int r102 = jo2.a.f499832a[r101.ordinal()];
        Integer r103 = null;
        if (r102 != 1) goto L5;
        jo2.d r104 = r100.f499833a;
    L15:
        if (r104 == null) goto L42;
        HashMap r105 = new HashMap();
        r105.put("room_id", String.valueOf(r100.f499843k));
        r105.put("room_count", String.valueOf(r100.f499844l + 1));
        r105.put("fps", String.valueOf(r104.f499874c));
        r105.put("drop_frame_times", String.valueOf(r104.f499877f));
        StringCompanionObject r106 = StringCompanionObject.INSTANCE;
        r105.put(IPerformanceManager.Stall.stall_ui_rate, String.format("%.4f", Arrays.copyOf(new Object[]{Double.valueOf(r104.f499876e)}, 1)));
        r105.put("minor_drop_count", String.valueOf(r104.f499880i));
        r105.put("minor_drop_rate", String.format("%.4f", Arrays.copyOf(new Object[]{Float.valueOf(r104.f499879h)}, 1)));
        r105.put("medium_drop_count", String.valueOf(r104.f499883l));
        r105.put("medium_drop_rate", String.format("%.4f", Arrays.copyOf(new Object[]{Float.valueOf(r104.f499882k)}, 1)));
        r105.put("critical_drop_count", String.valueOf(r104.f499886o));
        r105.put("critical_drop_rate", String.format("%.4f", Arrays.copyOf(new Object[]{Float.valueOf(r104.f499885n)}, 1)));
        r105.put("state", r104.f499872a);
        r105.put("duration", String.valueOf(r104.f499873b));
        r105.put("cpu_rate", String.format("%.4f", Arrays.copyOf(new Object[]{Double.valueOf(r104.f499888q)}, 1)));
        r105.put("gpu_rate", String.format("%.4f", Arrays.copyOf(new Object[]{Double.valueOf(r104.f499889r)}, 1)));
        IInteractService r107 = (IInteractService) k.f(IInteractService.class);
        if (r107 == null) goto L19;
        r105.put("scene", String.valueOf(r107.getCurrentScene()));
    L19:
        r104.f499890s = "";
        RoomContext.a r108 = RoomContext.Companion;
        long r109 = r100.f499843k;
        r108.getClass();
        RoomContext r110 = RoomContext.a.a(null, r109);
        if (r110 == null) goto L40;
        ILinkServiceExternal r111 = (ILinkServiceExternal) k.f(ILinkServiceExternal.class);
        if (r111 == null) goto L24;
        r103 = Integer.valueOf(r111.getEnterRoomLinkmicScene());
    L24:
        r105.put("link_scene", String.valueOf(r103));
        Room r112 = r110.getRoom().getValue();
        if (r112 == null) goto L40;
        LiveMode r113 = r112.getStreamType();
        if (r113 != null) goto L30;
    L38:
        String r114 = "video";
    L39:
        r104.f499890s = r114;
        goto L40
    L30:
        switch(jo2.c.f499871a[r113.ordinal()]) {
            case 1: goto L37;
            case 2: goto L36;
            case 3: goto L35;
            case 4: goto L34;
            case 5: goto L33;
            case 6: goto L32;
            default: goto L38;
        };
    L32:
        r114 = LiveMode.SCENE_ACQUAINTANCE;
        goto L39
    L33:
        r114 = PriorityModule.SCENE_THIRD_PARTY;
        goto L39
    L34:
        r114 = "audio";
        goto L39
    L35:
        r114 = "game";
        goto L39
    L36:
        r114 = "official";
        goto L39
    L37:
        r114 = "media";
    L40:
        r105.put(IPerformanceManager.Params.room_type, r104.f499890s);
        u.l().sendLog("livesdk_slide_performance_monitor", r105, new Object[]{Room.class});
        return;
    L42:
        return;
    L5:
        if (r102 != 2) goto L7;
        r104 = r100.f499834b;
        goto L15
    L7:
        if (r102 != 3) goto L9;
        r104 = r100.f499835c;
        goto L15
    L9:
        if (r102 == 4) goto L11;
        r104 = null;
        goto L15
    L11:
        r104 = r100.f499836d;
        goto L15
    }
}

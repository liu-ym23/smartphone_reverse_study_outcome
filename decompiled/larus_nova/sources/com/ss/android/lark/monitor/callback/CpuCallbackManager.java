package com.ss.android.lark.monitor.callback;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes36.dex */
public final class CpuCallbackManager {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile CpuCallbackManager f432359f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f432360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<b> f432361b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f432362c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f432363d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f432364e;

    public static final enum CpuIdleCallBackPriority extends Enum<CpuIdleCallBackPriority> {
        public static final CpuIdleCallBackPriority HIGH = null;
        public static final CpuIdleCallBackPriority LOW = null;
        public static final CpuIdleCallBackPriority MIDDLE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CpuIdleCallBackPriority[] f432365a = null;

        static {
            CpuIdleCallBackPriority r100 = new CpuIdleCallBackPriority("LOW", 0);
            LOW = r100;
            CpuIdleCallBackPriority r101 = new CpuIdleCallBackPriority("MIDDLE", 1);
            MIDDLE = r101;
            CpuIdleCallBackPriority r102 = new CpuIdleCallBackPriority("HIGH", 2);
            HIGH = r102;
            f432365a = new CpuIdleCallBackPriority[]{r100, r101, r102};
        }

        public static CpuIdleCallBackPriority[] values() {
            return (CpuIdleCallBackPriority[]) f432365a.clone();
        }

        public static CpuIdleCallBackPriority valueOf(String r100) {
            return (CpuIdleCallBackPriority) r27.a.a(CpuIdleCallBackPriority.class, r100);
        }

        public CpuIdleCallBackPriority(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface a {
        void b(float r100);
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f432366a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CpuIdleCallBackPriority f432367b;

        public b(c r100, CpuIdleCallBackPriority r101) {
            this.f432366a = r100;
            this.f432367b = r101;
        }
    }

    public interface c {
        void onIdle();
    }

    public interface d extends c {
    }

    public static CpuCallbackManager a() {
        if (f432359f != null) goto L15;
        monitor-enter(MemoryCallbackManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f432359f != null) goto L9;
        f432359f = new CpuCallbackManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(MemoryCallbackManager.class);     // Catch: Throwable -> L11
    L15:
        return f432359f;
    }

    public CpuCallbackManager() {
        this.f432362c = -1.0f;
        this.f432363d = 30;
        this.f432364e = 5;
        this.f432360a = new CopyOnWriteArrayList();
        this.f432361b = new ArrayList();
        if (DevicePerfManager.b.f432386a.f432372e.f20370h == false) goto L6;
        this.f432363d = 44;
        this.f432364e = 3;
        return;
    }

    public final void b(d r100) {
        CpuIdleCallBackPriority r101 = CpuIdleCallBackPriority.MIDDLE;
        List<b> r102 = this.f432361b;
        monitor-enter(r102);
        b r103 = new b(r100, r101);     // Catch: Throwable -> L16
        int r104 = 0;
        if (((ArrayList) this.f432361b).size() == 0) goto L13;
        int r105 = ((ArrayList) this.f432361b).size() - 1;     // Catch: Throwable -> L16
        int r106 = 0;
    L7:
        if (r105 < 0) goto L12;
        if (((b) ((ArrayList) this.f432361b).get(r105)).f432367b.ordinal() >= r101.ordinal()) goto L10;
        int r107 = r105;
        r105 = r105 - 1;     // Catch: Throwable -> L16
        r106 = r107;
        goto L7
    L10:
        r104 = r105 + 1;     // Catch: Throwable -> L16
        goto L13
    L12:
        r104 = r106;
    L13:
        ((ArrayList) this.f432361b).add(r104, r103);     // Catch: Throwable -> L16
        monitor-exit(r102);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }
}

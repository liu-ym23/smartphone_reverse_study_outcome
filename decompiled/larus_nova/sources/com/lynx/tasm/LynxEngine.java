package com.lynx.tasm;

import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.ILynxUIRenderer;
import com.lynx.tasm.behavior.LynxUIOwner;
import com.lynx.tasm.behavior.LynxUIRenderer;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes32.dex */
public class LynxEngine {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<LynxTemplateRender> f381648a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f381649b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TemplateBundle f381650c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LynxEngineState f381651d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ThreadStrategyForRendering f381652e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ILynxUIRenderer f381653f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TasmPlatformInvoker f381654g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public t1 f381655h;

    public static final enum LynxEngineState extends Enum<LynxEngineState> {
        public static final LynxEngineState DESTROYED = null;
        public static final LynxEngineState FREEZED = null;
        public static final LynxEngineState ON_REUSING = null;
        public static final LynxEngineState READY_BE_REUSED = null;
        public static final LynxEngineState UN_LOADED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LynxEngineState[] f381656a = null;

        static {
            LynxEngineState r100 = new LynxEngineState("UN_LOADED", 0);
            UN_LOADED = r100;
            LynxEngineState r101 = new LynxEngineState("READY_BE_REUSED", 1);
            READY_BE_REUSED = r101;
            LynxEngineState r102 = new LynxEngineState("ON_REUSING", 2);
            ON_REUSING = r102;
            LynxEngineState r103 = new LynxEngineState("FREEZED", 3);
            FREEZED = r103;
            LynxEngineState r104 = new LynxEngineState("DESTROYED", 4);
            DESTROYED = r104;
            f381656a = new LynxEngineState[]{r100, r101, r102, r103, r104};
        }

        public static LynxEngineState[] values() {
            return (LynxEngineState[]) f381656a.clone();
        }

        public static LynxEngineState valueOf(String r100) {
            return (LynxEngineState) r27.a.a(LynxEngineState.class, r100);
        }

        public LynxEngineState(String r100, int r101) {
            super(r100, r101);
        }
    }

    private native long nativeCreate();

    private native void nativeDestroyEngine(long r100);

    private native long nativeDetachEngine(long r100);

    public final synchronized boolean a() {
        monitor-enter(this);
        if (this.f381651d != LynxEngineState.READY_BE_REUSED) goto L6;
        boolean r100 = true;
    L7:
        monitor-exit(this);
        return r100;
    L6:
        r100 = false;
    L9:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean c() {
        monitor-enter(this);
        if (this.f381651d == LynxEngineState.UN_LOADED) goto L6;
        boolean r100 = true;
    L7:
        monitor-exit(this);
        return r100;
    L6:
        r100 = false;
    L9:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean d() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.f381651d != LynxEngineState.READY_BE_REUSED) goto L9;
        e(LynxEngineState.ON_REUSING);     // Catch: Throwable -> L12
        monitor-exit(this);
        return true;
    L9:
        monitor-exit(this);
        return false;
    }

    public final void b() {
        if (this.f381651d == LynxEngineState.READY_BE_REUSED) goto L8;
        WeakReference<LynxTemplateRender> r100 = this.f381648a;
        if (r100 == null) goto L8;
        if (r100.get() == null) goto L8;
    L15:
        e(LynxEngineState.DESTROYED);
        u.b.f383806a.delete(this);
        long r101 = this.f381649b;
        if (r101 == 0) goto L19;
        this.f381649b = 0;
        nativeDestroyEngine(r101);
        return;
    L19:
        return;
    L8:
        ILynxUIRenderer r102 = this.f381653f;
        if (r102 == null) goto L14;
        LynxUIRenderer r103 = (LynxUIRenderer) r102;
        r103.l();
        LynxUIOwner r104 = r103.f381917b;
        if (r104 == null) goto L14;
        r104.destroy();
    L14:
        this.f381653f = null;
        goto L15
    }

    public final String toString() {
        return "LynxEngineWrapper{mNativePtr=" + this.f381649b + ", mLynxEngineState=" + this.f381651d + '}';
    }

    public final synchronized void e(LynxEngineState r100) {
        monitor-enter(this);
        LLog.i("LynxEngineWrapper", this + "updateLynxEngineState:" + r100.name());     // Catch: Throwable -> L13
        LynxEngineState r101 = this.f381651d;     // Catch: Throwable -> L13
        LynxEngineState r102 = LynxEngineState.DESTROYED;     // Catch: Throwable -> L13
        if (r101 != r102) goto L10;
        if (r100 == r102) goto L8;
        LLog.e("LynxEngineWrapper", "lynxEngineState has been destroyed." + this);     // Catch: Throwable -> L13
    L8:
        monitor-exit(this);
        return;
    L10:
        this.f381651d = r100;     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public LynxEngine(TemplateBundle r100, LynxTemplateRender r101) {
        this.f381651d = LynxEngineState.UN_LOADED;
        this.f381649b = nativeCreate();
        this.f381648a = new WeakReference(r101);
        this.f381650c = r100;
        this.f381652e = r101.getThreadStrategyForRendering();
    }
}

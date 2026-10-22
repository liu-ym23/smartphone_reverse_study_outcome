package dwa;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.Reflect;
import com.ss.android.lark.monitor.callback.MemoryCallbackManager;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes34.dex */
public final class j extends b implements com.ss.android.lark.h.b {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final boolean f470379j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile j f470380k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f470381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f470382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Resources f470383c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f470384d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ScheduledExecutorService f470385e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, ConcurrentLinkedQueue<View>> f470386f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ConcurrentHashMap<String, l> f470387g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public g f470388h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final FrameLayout f470389i;

    public class a implements MemoryCallbackManager.MemoryCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f470390a;

        @Override // com.ss.android.lark.monitor.callback.MemoryCallbackManager.MemoryCallback
        public final void onTrimMemory(int r100, int r101, int r102, int r103) {
        }

        /* JADX WARN: Type inference failed for: r1v3, types: [dwa.g] */
        @Override // com.ss.android.lark.monitor.callback.MemoryCallbackManager.MemoryCallback
        public final void onJavaMemoryReachTop() {
            final j r100 = this.f470390a;
            if (r100.f470388h != null) goto L5;
            r100.f470388h = new g(r100);
        L5:
            CoreThreadPool.getNonblockingHandler().removeCallbacks(r100.f470388h);
            CoreThreadPool.getNonblockingHandler().postDelayed(r100.f470388h, 0);
        }

        public a(j r100) {
            this.f470390a = r100;
        }
    }

    static {
        if (Runtime.getRuntime().availableProcessors() <= 4) goto L5;
        boolean r100 = true;
    L6:
        f470379j = r100;
        return;
    L5:
        r100 = false;
        goto L6
    }

    public j(Context r100) {
        this.f470381a = 0;
        this.f470382b = 0;
        this.f470385e = CoreThreadPool.getDefault().getSingleScheduledThreadPool("PreLoadAsyncInflater");
        this.f470386f = new ConcurrentHashMap();
        this.f470387g = new ConcurrentHashMap();
        int r101 = com.larksuite.framework.utils.autoscale.a.f285947a;
        Context r102 = r100.getApplicationContext();
        this.f470384d = r102;
        this.f470383c = r102.getResources();
        this.f470389i = new FrameLayout(r102);
        com.ss.android.lark.h.a().addUiModeChangeListener(this);
        MemoryCallbackManager.getInstance().registerMemoryCallback(new a(this));
    }

    public static j d(Context r100) {
        if (f470380k != null) goto L15;
        monitor-enter(j.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f470380k != null) goto L9;
        f470380k = new j(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(j.class);     // Catch: Throwable -> L11
    L15:
        return f470380k;
    }

    public final dwa.a e(Context r100) {
        return new dwa.a(new e(r100), this.f470385e);
    }

    public final View f(ViewStub r100) {
        ConcurrentHashMap<Integer, ConcurrentLinkedQueue<View>> r101 = this.f470386f;
        if (r101 == null) goto L7;
        ConcurrentLinkedQueue<View> r102 = r101.get(Integer.valueOf(r100.getLayoutResource()));
        if (r102 == null) goto L7;
        View r103 = r102.poll();
    L8:
        if (r103 == null) goto L30;
        ViewStub.OnInflateListener r104 = (ViewStub.OnInflateListener) new Reflect(r100).e("mInflateListener", new Class[0]).f285916a;     // Catch: Throwable -> L12
        boolean r105 = true;
    L13:
        if (r105 == false) goto L24;
        g(r100.getContext(), r103);
        if (r100.getInflatedId() == (-1)) goto L17;
        r103.setId(r100.getInflatedId());
    L17:
        ViewGroup r106 = (ViewGroup) r100.getParent();
        int r107 = r106.indexOfChild(r100);
        r106.removeViewInLayout(r100);
        ViewGroup.LayoutParams r108 = r100.getLayoutParams();
        if (r108 == null) goto L20;
        r106.addView(r103, r107, r108);
    L21:
        if (r104 == null) goto L24;
        r104.onInflate(r100, r103);
        goto L24
    L20:
        r106.addView(r103, r107);
    L24:
        if (f470379j == false) goto L33;
        dwa.a r109 = e(this.f470384d);
        int r110 = r100.getLayoutResource();
        FrameLayout r111 = this.f470389i;
        k r112 = new k(this, r110);
        dwa.a.C5718a r113 = r109.f470358d.acquire();
        if (r113 != null) goto L28;
        r113 = new dwa.a.C5718a();
    L28:
        r113.f470360b = r109.f470355a;
        r113.f470359a = 0;
        r113.f470362d = r110;
        r113.f470361c = r111;
        r113.f470364f = r112;
        r109.f470356b.execute(new dwa.a.b(r109, r113));
        return r103;
    L33:
        return r103;
    L12:
        r103 = r100.inflate();
        r104 = null;
        r105 = false;
        goto L13
    L30:
        return r100.inflate();
    L7:
        r103 = null;
        goto L8
    }

    public static void g(Context r100, View r101) {
        if (r100 == null) goto L12;
        if (r101 != null) goto L6;
        return;
    L6:
        if ((r100 instanceof e) == false) goto L8;
        r100 = ((e) r100).getBaseContext();
    L8:
        Context r102 = r101.getContext();
        if ((r102 instanceof MutableContextWrapper) == false) goto L13;
        ((MutableContextWrapper) r102).setBaseContext(r100);
        return;
    L13:
        return;
    }
}

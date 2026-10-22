package et3;

import android.view.Choreographer;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.apm.constant.FilterTypeStringDef;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static boolean f473889n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f473890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f473891b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f473892c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public InterfaceC5817c f473893d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final h f473894e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public et3.d f473895f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LinkedList<Integer> f473896g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HashMap<String, String> f473897h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f473898i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final JSONObject f473899j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f473900k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f473901l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f473902m;

    /* JADX INFO: loaded from: classes14.dex */
    public class a extends RecyclerView.OnScrollListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f473903a;

        public a(c r100) {
            this.f473903a = r100;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public final void onScrollStateChanged(RecyclerView r100, int r101) {
            super.onScrollStateChanged(r100, r101);
            if (r101 == 0) goto L5;
            this.f473903a.d();
            return;
        L5:
            this.f473903a.f();
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public interface b {
        void blockTimeCallBack(long r100, int r101);
    }

    /* JADX INFO: renamed from: et3.c$c, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes14.dex */
    public interface InterfaceC5817c {
        void dropFrame(JSONObject r100);
    }

    /* JADX INFO: loaded from: classes14.dex */
    public interface d {
        void fpsCallBack(double r100);
    }

    public c() {
        throw null;
    }

    public final synchronized void f() {
        monitor-enter(this);
        h r100 = this.f473894e;     // Catch: Throwable -> L11
        if (r100 == null) goto L8;
        r100.d();     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L8:
        a();     // Catch: Throwable -> L11
        String r101 = this.f473890a;     // Catch: Throwable -> L11
        com.bytedance.apm.block.g.f190348c = true;     // Catch: Throwable -> L11
        com.bytedance.apm.block.g.f190346a.remove(r101);     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final void a() {
        if (this.f473891b == true) goto L5;
        return;
    L5:
        long r100 = this.f473901l - this.f473900k;
        if (r100 <= 0) goto L15;
        int r101 = this.f473902m;
        if (r101 <= 1) goto L15;
        long r102 = (((((long) (r101 - 1)) * 1000) * 1000) * 1000) / r100;
        d r103 = this.f473892c;
        if (r103 == null) goto L13;
        r103.fpsCallBack(r102);
    L13:
        et3.b r104 = et3.b.C5816b.f473888a;
        HashMap<String, String> r105 = this.f473897h;
        r104.getClass();
        bt3.b.d.f20539a.e(new et3.a(r104, this.f473890a, r105, r102));
    L15:
        if (this.f473895f == null) goto L17;
        Choreographer.getInstance().removeFrameCallback(this.f473895f);
    L17:
        monitor-enter(this);
    L27:
        th = move-exception;
        throw th;
    L19:
        if (this.f473896g.isEmpty() == false) goto L22;
        monitor-exit(this);     // Catch: Throwable -> L27
    L25:
        this.f473891b = false;
        return;
    L22:
        LinkedList<Integer> r106 = this.f473896g;     // Catch: Throwable -> L27
        this.f473896g = new LinkedList();     // Catch: Throwable -> L27
        monitor-exit(this);     // Catch: Throwable -> L27
        bt3.b.d.f20539a.e(new e(this, r106));
        goto L25
    }

    public final void d() {
        h r100 = this.f473894e;
        if (r100 == null) goto L7;
        r100.c();
        return;
    L7:
        if (this.f473891b == false) goto L10;
        return;
    L10:
        if (this.f473898i == false) goto L12;
    L21:
        monitor-enter(this);
        this.f473896g.clear();     // Catch: Throwable -> L30
        monitor-exit(this);     // Catch: Throwable -> L30
        this.f473900k = -1;
        this.f473901l = -1;
        this.f473902m = 0;
        this.f473895f = new et3.d(this);
        Choreographer.getInstance().postFrameCallback(this.f473895f);     // Catch: Exception -> L27
    L28:
        String r101 = this.f473890a;
        com.bytedance.apm.block.g.f190348c = true;
        com.bytedance.apm.block.g.f190346a.add(r101);
        this.f473891b = true;
        return;
    L27:
        this.f473891b = false;
        this.f473900k = -1;
        this.f473901l = -1;
        this.f473902m = 0;
        this.f473895f = null;
    L30:
        th = move-exception;
        throw th;
    L12:
        if (com.bytedance.apm.d.f190533u == false) goto L18;
        String r102 = this.f473890a;
        if (zs3.c.f573475a.d(FilterTypeStringDef.FPS_DROP, r102) == true) goto L17;
        String r103 = this.f473890a;
        if (zs3.c.f573475a.d("fps", r103) == false) goto L18;
    L17:
        boolean r104 = true;
    L19:
        if (r104 == true) goto L21;
        return;
    L18:
        r104 = false;
        goto L19
    }

    public c(String r100) {
        this(r100, true, null);
    }

    public final void b(InterfaceC5817c r100) {
        h r101 = this.f473894e;
        if (r101 == null) goto L5;
        r101.f473917e = r100;
    L5:
        this.f473893d = r100;
    }

    public final void c(d r100) {
        h r101 = this.f473894e;
        if (r101 == null) goto L5;
        r101.f473916d = r100;
    L5:
        this.f473892c = r100;
    }

    public final void e(RecyclerView r100) {
        h r101 = this.f473894e;
        if (r101 == null) goto L9;
        r101.getClass();
        if (r100 == null) goto L13;
        r100.addOnScrollListener(new f(r101));
        return;
    L13:
        return;
    L9:
        if (r100 != null) goto L11;
        return;
    L11:
        r100.addOnScrollListener(new a(this));
    }

    public c(String r100, boolean r101, JSONObject r102) {
        this.f473891b = false;
        this.f473897h = new HashMap();
        this.f473900k = -1;
        this.f473901l = -1;
        this.f473902m = 0;
        this.f473899j = r102;
        if (f473889n == false) goto L6;
        this.f473894e = new h(r100, r101, r102);
        return;
    L6:
        this.f473890a = r100;
        this.f473898i = r101;
        this.f473896g = new LinkedList();
    }
}

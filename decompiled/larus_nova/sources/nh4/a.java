package nh4;

import android.content.Context;
import com.bytedance.crash.i;
import com.bytedance.crash.npth_repair.NpthRepair;
import com.bytedance.crash.npth_repair.monitor.SignalMonitor;
import com.bytedance.crash.npth_repair.nativeCrash.ArtDumpNativeStackFixer;
import com.bytedance.crash.npth_repair.nativeCrash.DvmSuspendTimeOpt;
import com.bytedance.crash.util.p;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f519163g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f519164h = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static nh4.b f519165i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final C6926a f519166j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final b f519167k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final c f519168l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f519169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f519170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArrayList<f> f519171c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f519172d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f519173e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f519174f;

    /* JADX INFO: renamed from: nh4.a$a, reason: collision with other inner class name */
    public static class C6926a implements f {
        public C6926a() {
        }

        @Override // nh4.a.f
        public final int a(int r100) {
            if (a.f519163g == true) goto L15;
            if (a.f519164h == false) goto L12;
            boolean r101 = true;
            if ((r100 & 1) != 0) goto L10;
            r101 = false;
        L10:
            if (r101 == true) goto L15;
            return -1;
        L12:
            return -1;
        L15:
            return ArtDumpNativeStackFixer.a();
        }
    }

    public static class b implements f {
        public b() {
        }

        @Override // nh4.a.f
        public final int a(int r100) {
            if ((r100 & 2) == 0) goto L5;
            boolean r101 = true;
        L6:
            if (r101 == true) goto L8;
            return -1;
        L8:
            return DvmSuspendTimeOpt.a();
        L5:
            r101 = false;
            goto L6
        }
    }

    public static class c implements f {
        public c() {
        }

        @Override // nh4.a.f
        public final int a(int r100) {
            if ((r100 & 4) == 0) goto L5;
            boolean r101 = true;
        L6:
            if (r101 == true) goto L8;
            return -1;
        L8:
            return SignalMonitor.b().c(a.f519165i.f519180d);
        L5:
            r101 = false;
            goto L6
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f519175a;

        @Override // java.lang.Runnable
        public final void run() {
            int r100 = 0;
        L4:
            if (r100 >= 3) goto L15;
            if (r100 >= this.f519175a.f519171c.size()) goto L16;
            ((f) ListProtector.get(this.f519175a.f519171c, r100)).a(this.f519175a.f519172d);     // Catch: Throwable -> L10
            r100 = r100 + 1;
            goto L4
        L16:
            return;
        L9:
            return;
        }

        public d(a r100) {
            this.f519175a = r100;
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f519176a = null;

        static {
            f519176a = new a();
        }
    }

    public interface f {
        int a(int r100);
    }

    static {
        f519166j = new C6926a();
        f519167k = new b();
        f519168l = new c();
    }

    public final void a() {
        nh4.b r100 = f519165i;
        this.f519172d = r100.f519178b;
        this.f519173e = r100.f519177a;
        this.f519174f = r100.f519179c;
        p.e("type: " + this.f519172d + " debug: " + this.f519174f + " delayedTime: " + this.f519173e);
        boolean r101 = true;
        if (this.f519169a == true) goto L5;
        this.f519169a = true;
        boolean r102 = this.f519174f;
        Context r103 = i.getContext();
        if (r103 == null) goto L10;
        int r104 = NpthRepair.a(r103, r102);
    L11:
        this.f519170b = r104;
        if (r104 == 0) goto L14;
    L13:
        r101 = false;
    L15:
        if (r101 == false) goto L18;
        wh4.b.postDelayed(new d(this), this.f519173e);
        return;
    L18:
        return;
    L14:
        ArrayList<f> r105 = new ArrayList();
        this.f519171c = r105;
        r105.add(f519166j);
        this.f519171c.add(f519167k);
        this.f519171c.add(f519168l);
        goto L15
    L10:
        r104 = -7;
        goto L11
    L5:
        if (this.f519170b != 0) goto L13;
        goto L13
    }

    public a() {
        this.f519169a = false;
        this.f519170b = -1;
    }
}

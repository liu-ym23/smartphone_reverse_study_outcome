package tn1;

import android.os.Build;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.livesdk.config.ts0;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static volatile b f546859m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f546860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f546861b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Integer> f546862c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f546863d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<tn1.a> f546864e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f546865f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f546866g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f546867h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f546868i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final a f546869j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public JSONArray f546870k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public JSONArray f546871l;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f546872a;

        public final void a() {
            if (((CopyOnWriteArrayList) this.f546872a.f546864e).isEmpty() == true) goto L19;
            Iterator r100 = ((CopyOnWriteArrayList) this.f546872a.f546864e).iterator();
        L6:
            if (r100.hasNext() == false) goto L13;
            tn1.a r101 = (tn1.a) r100.next();
            if (r101 == null) goto L12;
            if (r101.f546858d == null) goto L12;
            c.a("SlideTaskDelay", "waitFirstFrameRunnable targetTask position=" + r101.f546857c);
            r101.f546858d.run();
        L12:
            ((CopyOnWriteArrayList) this.f546872a.f546864e).remove(r101);
            goto L6
        L13:
            b r102 = this.f546872a;
            r102.f546866g = false;
            r102.f546868i = false;
            i0.c().removeCallbacks(this.f546872a.f546869j);
            return;
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

        public a(b r100) {
            this.f546872a = r100;
        }
    }

    public static b a() {
        if (f546859m != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f546859m != null) goto L9;
        f546859m = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f546859m;
    }

    public final boolean b() {
        int r100 = this.f546860a;
        if (r100 != 1) goto L5;
    L6:
        boolean r101 = this.f546861b;
        if (r101 == false) goto L9;
        if (r101 == false) goto L18;
        List<Integer> r102 = this.f546862c;
        if (r102 == null) goto L18;
        if (r102.contains(Integer.valueOf(Build.VERSION.SDK_INT)) == false) goto L18;
        return true;
    L18:
        return false;
    L9:
        if (this.f546868i == false) goto L11;
        return false;
    L11:
        return true;
    L5:
        if (r100 != 2) goto L18;
        goto L6
    }

    public final void c() {
        if (((CopyOnWriteArrayList) this.f546864e).isEmpty() == false) goto L5;
        return;
    L5:
        int r100 = this.f546860a;
        if (r100 != 0) goto L8;
        e();
        return;
    L8:
        if (r100 == 1) goto L53;
        if (r100 == 2) goto L13;
        return;
    L13:
        if (this.f546865f == 0) goto L15;
        return;
    L15:
        if (ts0.f121323a.getValue().mIsWaitFirstFrame == false) goto L51;
        c.a("SlideTaskDelay", "mayRunSlideTask hasFirstFrame=" + this.f546866g + " targetPosition=" + this.f546867h);
        if (this.f546866g == false) goto L19;
        e();
        return;
    L19:
        d();
        Iterator r101 = ((CopyOnWriteArrayList) this.f546864e).iterator();
    L21:
        if (r101.hasNext() == false) goto L76;
        tn1.a r102 = (tn1.a) r101.next();
        if (r102 == null) goto L21;
        if (r102.f546858d == null) goto L21;
        boolean r103 = false;
        if (r102.f546857c != this.f546867h) goto L29;
        boolean r104 = true;
    L30:
        List<Integer> r105 = this.f546862c;
        if (r105 != null) goto L33;
    L35:
        boolean r106 = false;
    L36:
        if (r104 == false) goto L39;
        if (r106 == true) goto L39;
        r103 = true;
    L39:
        this.f546868i = r103;
        c.a("SlideTaskDelay", "runTargetTask isTargetTask=" + r104 + " isAndroid1213=" + r106 + " isNeedWaitFirstFrame=" + this.f546868i);
        if (r104 == true) goto L41;
        if (this.f546861b == false) goto L49;
        if (r106 == false) goto L48;
        c.a("SlideTaskDelay", "direct run isPost=" + this.f546861b);
        r102.f546858d.run();
    L50:
        ((CopyOnWriteArrayList) this.f546864e).remove(r102);
        goto L21
    L48:
        c.a("SlideTaskDelay", "insert queue run isPost=" + this.f546861b);
        i0.g(r102.f546858d);
        goto L50
    L49:
        c.a("SlideTaskDelay", "direct run isPost=" + this.f546861b);
        r102.f546858d.run();
        goto L50
    L41:
        if (r106 == true) goto L42;
        i0.c().postDelayed(this.f546869j, ts0.f121323a.getValue().mDurationWait);
        goto L21
    L42:
        r102.f546858d.run();
        ((CopyOnWriteArrayList) this.f546864e).remove(r102);
        goto L21
    L33:
        if (r105.contains(Integer.valueOf(Build.VERSION.SDK_INT)) == false) goto L35;
        r106 = true;
        goto L36
    L29:
        r104 = false;
        goto L30
    L76:
        return;
    L51:
        e();
        return;
    L53:
        if (this.f546865f != 0) goto L73;
        e();
        return;
    }

    public final void d() {
        if (this.f546863d == true) goto L6;
        return;
    L6:
        if (this.f546870k != null) goto L9;
        this.f546870k = new JSONArray();
    L9:
        if (this.f546871l != null) goto L11;
        this.f546871l = new JSONArray();
    L11:
        int r100 = 0;
    L13:
        if (r100 >= ((CopyOnWriteArrayList) this.f546864e).size()) goto L18;
        tn1.a r101 = (tn1.a) ListProtector.get(this.f546864e, r100);
        if (r101 == null) goto L17;
        this.f546870k.put(r101.f546855a);
        this.f546871l.put(r101.f546857c + "_" + r101.f546856b);
    L17:
        r100 = r100 + 1;
        goto L13
    L18:
        c.a("SlideTaskDelay", "mTotalSlideTasks=" + ((CopyOnWriteArrayList) this.f546864e).size() + "，printTotalSlideTaskIds=" + this.f546870k.toString());
        StringBuilder r102 = new StringBuilder("printTotalSlideTasks=");
        r102.append(this.f546871l.toString());
        c.a("SlideTaskDelay", r102.toString());
    }

    public b() {
        ts0 r100 = ts0.f121323a;
        this.f546860a = r100.getValue().mStrategy;
        this.f546861b = r100.getValue().mIsPost;
        this.f546862c = r100.getValue().mOsVersionFilterList;
        this.f546863d = r100.getValue().mLog;
        this.f546864e = new CopyOnWriteArrayList();
        this.f546865f = 0;
        this.f546866g = false;
        this.f546867h = -1;
        this.f546868i = false;
        this.f546869j = new a(this);
        this.f546870k = null;
        this.f546871l = null;
    }

    public final void e() {
        d();
        Iterator r100 = ((CopyOnWriteArrayList) this.f546864e).iterator();
    L4:
        if (r100.hasNext() == false) goto L19;
        tn1.a r101 = (tn1.a) r100.next();
        if (r101 == null) goto L4;
        if (r101.f546858d == null) goto L4;
        if (this.f546861b == false) goto L17;
        List<Integer> r102 = this.f546862c;
        if (r102 != null) goto L14;
    L16:
        c.a("SlideTaskDelay", "insert queue run isPost=" + this.f546861b);
        i0.g(r101.f546858d);
    L18:
        ((CopyOnWriteArrayList) this.f546864e).remove(r101);
        goto L4
    L14:
        if (r102.contains(Integer.valueOf(Build.VERSION.SDK_INT)) == false) goto L16;
        c.a("SlideTaskDelay", "direct run isPost=" + this.f546861b);
        r101.f546858d.run();
        goto L18
    L17:
        c.a("SlideTaskDelay", "direct run isPost=" + this.f546861b);
        r101.f546858d.run();
        goto L18
    L19:
        this.f546866g = false;
    }
}

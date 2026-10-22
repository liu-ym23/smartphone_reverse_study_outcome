package wt3;

import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends vt3.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ut3.c f561191b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public C8158a f561192c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f561193d;

    /* JADX INFO: renamed from: wt3.a$a, reason: collision with other inner class name */
    public class C8158a extends cv3.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a f561194d;

        public final void a() {
            a r100 = this.f561194d;
            r100.getClass();
            String r101 = xu3.e.a(st3.a.b().f543560a.toArray());
            if (TextUtils.isEmpty(r101) == false) goto L6;
            r101 = "";
        L6:
            vt3.b.f557197a = r101;
            double r102 = vt3.e.a();
            bq7.a r103 = r100.f557196a.f557205e;
            if (r103 == null) goto L24;
            float r104 = (float) r102;
            cq7.a r105 = r103.f20045e;
            if (r105.a() == true) goto L11;
            boolean r106 = hq7.a.f486512a;
        L21:
            boolean r107 = false;
        L22:
            if (r107 == false) goto L25;
            r107 = vt3.b.a(r100.f561191b, r102, r100.f561193d);
        L25:
            r100.e("run judge process cpu usage task, is over max threshold?: " + r107 + " speed: " + r102 + ", back max speed: " + r100.f561191b.f551638c + ", fore max speed: " + r100.f561191b.f551639d);
            if (r100.g(r107) == false) goto L29;
            cv3.b.a(AsyncTaskManagerType.CPU).b(r100.f561192c);
            return;
        L29:
            return;
        L11:
            bq7.a r108 = (bq7.a) r105.f464791a;
            if (r108.f20046f.f15913c != null) goto L15;
            boolean r109 = hq7.a.f486512a;
        L20:
            r107 = true;
            goto L22
        L15:
            if (r104 < 0.0f) goto L21;
            if (0.0f <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L19;
            ((bq7.a) r108.f20044d.f20047a).f20046f.getClass();
        L19:
            boolean r110 = hq7.a.f486512a;
            goto L20
        L24:
            r107 = vt3.b.a(r100.f561191b, r102, r100.f561193d);
            goto L25
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

        public C8158a(a r100, long r101, long r102) {
            this.f561194d = r100;
            super(r101, r102);
        }
    }

    public abstract long f();

    public abstract boolean g(boolean r100);

    @Override // vt3.a, vt3.f
    public final void c() {
        super.c();
        cv3.b.a(AsyncTaskManagerType.CPU).b(this.f561192c);
    }

    public a(vt3.d r100) {
        super(r100);
    }

    @Override // vt3.a, vt3.f
    public void a(boolean r100) {
        super.a(r100);
        cv3.b.a(AsyncTaskManagerType.CPU).b(this.f561192c);
        vt3.d r101 = this.f557196a;
        monitor-enter(r101);
        r101.a(r101.f557212l);     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // vt3.a, vt3.f
    public final void d(ut3.c r100, boolean r101) {
        super.d(r100, r101);
        this.f561191b = r100;
        this.f561193d = r101;
        av3.b.d("APM-CPU", "enter : " + b() + " provideDetectInterval : " + f() + " isBack : " + r101);
        C8158a r102 = this.f561192c;
        if (r102 != null) goto L5;
        this.f561192c = new C8158a(this, f(), f());
    L8:
        cv3.b.a(AsyncTaskManagerType.CPU).c(this.f561192c);
        return;
    L5:
        long r103 = f();
        long r104 = f();
        r102.f465483a = r103;
        r102.f465485c = r104;
        if (r104 <= 0) goto L8;
        r102.f465484b = true;
        goto L8
    }
}

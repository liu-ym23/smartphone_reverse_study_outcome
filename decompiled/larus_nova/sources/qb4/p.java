package qb4;

import android.view.MotionEvent;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<b> f532370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f532371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f532372c;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p f532373a;

        public final void a() {
            int r100 = ((ArrayList) this.f532373a.f532370a).size() - 1;     // Catch: Exception -> L18 Throwable -> L14
            double r101 = ((b) ((ArrayList) this.f532373a.f532370a).get(r100)).f532378e;     // Catch: Exception -> L18 Throwable -> L14
        L4:
            if (r100 < 0) goto L12;
            b r102 = (b) ((ArrayList) this.f532373a.f532370a).get(r100);     // Catch: Exception -> L18 Throwable -> L14
            long r103 = r102.f532378e;     // Catch: Exception -> L18 Throwable -> L14
            if (r101 >= r103) goto L10;
            if (r100 == 0) goto L10;
            int r104 = n.f532367a;     // Catch: Exception -> L18 Throwable -> L14
        L11:
            r100 = r100 - 1;     // Catch: Exception -> L18 Throwable -> L14
        L10:
            x.a(r103, r102.f532374a, r102.f532375b, r102.f532379f, r102.f532376c, r102.f532377d);     // Catch: Exception -> L18 Throwable -> L14
            r101 = r101 - 33.3333d;     // Catch: Exception -> L18 Throwable -> L14
            int r105 = n.f532367a;     // Catch: Exception -> L18 Throwable -> L14
            goto L11
        L12:
            ((ArrayList) this.f532373a.f532370a).clear();     // Catch: Exception -> L18 Throwable -> L14
        L14:
            th = move-exception;
            this.f532373a.f532371b = false;
            throw th;
        L13:
            this.f532373a.f532371b = false;
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

        public a(p r100) {
            this.f532373a = r100;
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f532374a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f532375b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f532376c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f532377d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f532378e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f532379f;

        public b() {
        }
    }

    public final void b() {
        c0.a.f532328a.a(new a(this));     // Catch: Exception -> L4
        return;
    }

    public p(int r100) {
        this.f532370a = new ArrayList();
        this.f532371b = false;
        this.f532372c = 6000;
        if (r100 <= 6000) goto L6;
        this.f532372c = r100;
        return;
    }

    public final void a(MotionEvent r100) {
        if (this.f532371b == false) goto L27;
        return;
    L27:
    L21:
        int r101 = 1;
    L22:
        if (r101 != 1) goto L31;
    L23:
        this.f532371b = true;
        b();
        return;
    L31:
        return;
    L16:
        th = th;
        r101 = 1;
    L18:
        if (r101 != 1) goto L20;
        this.f532371b = true;
        b();
    L20:
        throw th;
    L6:
        if (((ArrayList) this.f532370a).size() >= this.f532372c) goto L13;
        r101 = r100.getAction();     // Catch: Throwable -> L16 Exception -> L21
        b r102 = new b();     // Catch: Throwable -> L10 Exception -> L12
        r102.f532374a = r100.getPressure();     // Catch: Throwable -> L10 Exception -> L12
        r102.f532375b = r100.getTouchMajor();     // Catch: Throwable -> L10 Exception -> L12
        r102.f532376c = r100.getX();     // Catch: Throwable -> L10 Exception -> L12
        r102.f532377d = r100.getY();     // Catch: Throwable -> L10 Exception -> L12
        r102.f532378e = r100.getEventTime();     // Catch: Throwable -> L10 Exception -> L12
        r102.f532379f = r100.getAction();     // Catch: Throwable -> L10 Exception -> L12
        ((ArrayList) this.f532370a).add(r102);     // Catch: Throwable -> L10 Exception -> L12
        ((ArrayList) this.f532370a).size();     // Catch: Throwable -> L10 Exception -> L12
        int r103 = n.f532367a;     // Catch: Throwable -> L10 Exception -> L12
    L14:
        if (r101 == 1) goto L23;
        return;
    L10:
        th = th;
        goto L18
    L13:
        r101 = 1;
        goto L14
    }
}

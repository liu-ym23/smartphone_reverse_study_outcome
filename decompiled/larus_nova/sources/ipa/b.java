package ipa;

import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.relax.RelaxEngine;
import com.relax.RelaxJNI;
import com.relax.RelaxView;
import com.relax.TimingTracker;
import com.relax.embedding.LLog;
import com.relax.v;
import java.nio.ByteBuffer;
import java.util.HashMap;

/* JADX INFO: loaded from: classes34.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RelaxEngine f495315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RelaxView f495316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f495317c;

    public class a implements TimingTracker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f495318a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f495319b;

        /* JADX INFO: renamed from: ipa.b$a$a, reason: collision with other inner class name */
        public class RunnableC6342a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Object f495320a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f495321b;

            public final void a() {
                if (this.f495321b.f495318a == null) goto L6;
                LLog.i("onReportTimingSetup: " + this.f495320a);
                a r100 = this.f495321b;
                v r101 = r100.f495318a;
                RelaxView r102 = r100.f495319b.f495316b;
                HashMap r103 = (HashMap) this.f495320a;
                r101.getClass();
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

            public RunnableC6342a(a r100, Object r101) {
                this.f495321b = r100;
                this.f495320a = r101;
            }
        }

        /* JADX INFO: renamed from: ipa.b$a$b, reason: collision with other inner class name */
        public class RunnableC6343b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Object f495322a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Object f495323b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ a f495324c;

            @Override // java.lang.Runnable
            public final void run() {
                a r100 = this.f495324c;     // Catch: Throwable -> L6
                if (r100.f495318a == null) goto L9;
                RelaxView r101 = r100.f495319b.f495316b;     // Catch: Throwable -> L6
                HashMap r102 = (HashMap) this.f495322a;     // Catch: Throwable -> L6
                HashMap r103 = (HashMap) this.f495323b;     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }

            public RunnableC6343b(a r100, Object r101, Object r102, String r103) {
                this.f495324c = r100;
                this.f495322a = r101;
                this.f495323b = r102;
            }
        }

        public class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f495325a;

            @Override // java.lang.Runnable
            public final void run() {
                a r100 = this.f495325a;     // Catch: Throwable -> L6
                if (r100.f495318a == null) goto L9;
                RelaxView r101 = r100.f495319b.f495316b;     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }

            public c(a r100, HashMap r101) {
                this.f495325a = r100;
            }
        }

        @Override // com.relax.TimingTracker
        public final void onFirstFMP() {
            v r100 = this.f495318a;
            if (r100 == null) goto L6;
            r100.getClass();
            return;
        }

        @Override // com.relax.TimingTracker
        public final void onPerformanceEvent(HashMap<String, Object> r100) {
            c r101 = new c(this, r100);
            b.a(this.f495319b, r101);
        }

        @Override // com.relax.TimingTracker
        public final void onReportTimingSetup(ByteBuffer r100) {
            RunnableC6342a r101 = new RunnableC6342a(this, ipa.c.a(r100));
            b.a(this.f495319b, r101);
        }

        public a(b r100, v r101) {
            this.f495319b = r100;
            this.f495318a = r101;
        }

        @Override // com.relax.TimingTracker
        public final void onReportTimingUpdate(ByteBuffer r100, ByteBuffer r101, String r102) {
            RunnableC6343b r103 = new RunnableC6343b(this, ipa.c.a(r100), ipa.c.a(r101), r102);
            b.a(this.f495319b, r103);
        }
    }

    /* JADX INFO: renamed from: ipa.b$b, reason: collision with other inner class name */
    public static class C6344b {
    }

    public b(RelaxView r100) {
        this.f495315a = null;
        this.f495316b = null;
        this.f495317c = new Handler(Looper.getMainLooper());
        this.f495316b = r100;
    }

    public final void b(v r100) {
        RelaxEngine r101 = this.f495315a;
        a r102 = new a(this, r100);
        monitor-enter(r101);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (r101.f404544c.b() == true) goto L8;
        monitor-exit(r101);
        return;
    L8:
        RelaxJNI r103 = r101.f404543b;     // Catch: Throwable -> L13
        if (r103 == null) goto L11;
        r103.setTimingTracker(r102);     // Catch: Throwable -> L13
    L11:
        monitor-exit(r101);
    }

    public static void a(b r100, Runnable r101) {
        r100.getClass();
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        r101.run();
        return;
    L5:
        r100.f495317c.post(r101);
    }

    public final void c(String r100, long r101) {
        long r102 = r101 * 1000;
        RelaxEngine r103 = this.f495315a;
        if (r103 == null) goto L17;
        monitor-enter(r103);
    L14:
        th = move-exception;
        throw th;
    L6:
        if (r103.f404544c.b() == true) goto L9;
        monitor-exit(r103);
        return;
    L9:
        RelaxJNI r104 = r103.f404543b;     // Catch: Throwable -> L14
        if (r104 == null) goto L12;
        r104.setTiming("", r100, r102);     // Catch: Throwable -> L14
    L12:
        monitor-exit(r103);
        return;
    }
}

package xq7;

import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.android.monitorV2.webview.m;
import com.bytedance.ies.web.jsbridge2.TimeLineEvent;
import com.bytedance.ies.web.jsbridge2.c0;
import com.bytedance.ies.web.jsbridge2.o0;
import com.bytedance.ies.web.jsbridge2.u;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.SoftReference;
import java.util.Iterator;
import java.util.List;
import jz2.h;
import jz2.i;

/* JADX INFO: loaded from: classes22.dex */
public final class a implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SoftReference<WebView> f564811a;

    /* JADX INFO: renamed from: xq7.a$a, reason: collision with other inner class name */
    public class RunnableC8264a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f564812a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ o0 f564813b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f564814c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a f564815d;

        public final void a() {
            WebView r100 = this.f564815d.f564811a.get();
            if (r100 != null) goto L5;
            return;
        L5:
            if (TextUtils.isEmpty(this.f564812a) == true) goto L32;
            o0 r101 = this.f564813b;
            if (r101 == null) goto L19;
            List<TimeLineEvent> r102 = r101.f249419c;
            if (r102 == null) goto L19;
            Iterator<TimeLineEvent> r103 = r102.iterator();
        L13:
            if (r103.hasNext() == false) goto L19;
            TimeLineEvent r104 = r103.next();
            if (r104 == null) goto L13;
            if ("label_create_java_call".equals(r104.getLabel()) == false) goto L13;
            long r105 = r104.getElapsedTimestamp();
        L20:
            i r106 = new i();
            r106.f501150a = this.f564812a;
            r106.f501151b = 0;
            r106.f501155f = r105;
            if (r105 == 0) goto L23;
            long r107 = this.f564814c;
            r106.f501156g = r107;
            r106.f501154e = r107 - r105;
        L23:
            m.f163358f.p(r100, r106);
            return;
        L19:
            r105 = 0;
            goto L20
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

        public RunnableC8264a(a r100, String r101, o0 r102, long r103) {
            this.f564815d = r100;
            this.f564812a = r101;
            this.f564813b = r102;
            this.f564814c = r103;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f564816a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ o0 f564817b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f564818c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f564819d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ long f564820e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ a f564821f;

        public final void a() {
            WebView r100 = this.f564821f.f564811a.get();
            if (r100 != null) goto L5;
            return;
        L5:
            if (TextUtils.isEmpty(this.f564816a) == true) goto L44;
            o0 r101 = this.f564817b;
            if (r101 == null) goto L19;
            List<TimeLineEvent> r102 = r101.f249419c;
            if (r102 == null) goto L19;
            Iterator<TimeLineEvent> r103 = r102.iterator();
        L13:
            if (r103.hasNext() == false) goto L19;
            TimeLineEvent r104 = r103.next();
            if (r104 == null) goto L13;
            if ("label_create_java_call".equals(r104.getLabel()) == false) goto L13;
            long r105 = r104.getElapsedTimestamp();
        L20:
            i r106 = new i();
            r106.f501150a = this.f564816a;
            a r107 = this.f564821f;
            int r108 = this.f564818c;
            r107.getClass();
            int r109 = 3;
            if (r108 == 1) goto L25;
            if (r108 == 2) goto L24;
            int r110 = 3;
        L26:
            r106.f501151b = r110;
            r106.f501152c = this.f564819d;
            r106.f501155f = r105;
            if (r105 == 0) goto L29;
            long r111 = this.f564820e;
            r106.f501156g = r111;
            r106.f501154e = r111 - r105;
        L29:
            m r112 = m.f163358f;
            r112.p(r100, r106);
            h r113 = new h();
            r113.f501149c = this.f564816a;
            a r114 = this.f564821f;
            int r115 = this.f564818c;
            r114.getClass();
            if (r115 == 1) goto L34;
            if (r115 != 2) goto L35;
            r109 = 2;
        L35:
            r113.f501147a = r109;
            r113.f501148b = this.f564819d;
            r112.o(r100, r113);
            return;
        L34:
            r109 = 1;
            goto L35
        L24:
            r110 = 2;
            goto L26
        L25:
            r110 = 1;
        L19:
            r105 = 0;
            goto L20
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

        public b(a r100, String r101, o0 r102, int r103, String r104, long r105) {
            this.f564821f = r100;
            this.f564816a = r101;
            this.f564817b = r102;
            this.f564818c = r103;
            this.f564819d = r104;
            this.f564820e = r105;
        }
    }

    @Override // com.bytedance.ies.web.jsbridge2.u
    public final /* synthetic */ void b(c0 r100, int r101) {
    }

    public a(WebView r100) {
        this.f564811a = new SoftReference(r100);
    }

    @Override // com.bytedance.ies.web.jsbridge2.u
    public final void a(String r100, String r101, o0 r102) {
        com.bytedance.android.monitorV2.executor.a.d(new RunnableC8264a(this, r101, r102, SystemClock.elapsedRealtime()));
    }

    @Override // com.bytedance.ies.web.jsbridge2.u
    public final void c(String r100, String r110, int r111, String r112, o0 r113) {
        com.bytedance.android.monitorV2.executor.a.d(new b(this, r110, r113, r111, r112, SystemClock.elapsedRealtime()));
    }
}

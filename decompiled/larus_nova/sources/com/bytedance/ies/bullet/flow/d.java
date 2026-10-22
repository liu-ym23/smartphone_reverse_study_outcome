package com.bytedance.ies.bullet.flow;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.ies.bullet.core.q;
import com.bytedance.ies.bullet.service.base.o;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public q f246641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f246642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentLinkedQueue<Runnable> f246643c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.ies.bullet.flow.e f246644d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handler f246645e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.ies.bullet.flow.e f246646f;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f246647a;

        public a(d r100) {
            this.f246647a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            q r100 = this.f246647a.f246641a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.rS();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f246648a;

        public b(d r100) {
            this.f246648a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            q r100 = this.f246648a.f246641a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.lX();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f246649a;

        public c(d r100) {
            this.f246649a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            q r100 = this.f246649a.f246641a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.onClose();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ies.bullet.flow.d$d, reason: collision with other inner class name */
    public static final class RunnableC3525d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f246650a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Uri f246651b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Throwable f246652c;

        public RunnableC3525d(d r100, Uri r101, Throwable r102) {
            this.f246650a = r100;
            this.f246651b = r101;
            this.f246652c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            q r100 = this.f246650a.f246641a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.TH(this.f246651b, this.f246652c);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f246653a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Uri f246654b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ o f246655c;

        public e(d r100, Uri r101, o r102) {
            this.f246653a = r100;
            this.f246654b = r101;
            this.f246655c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            q r100 = this.f246653a.f246641a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.gQ(this.f246654b, this.f246655c);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f246656a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Uri f246657b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ o f246658c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Throwable f246659d;

        public f(d r100, Uri r101, o r102, Throwable r103) {
            this.f246656a = r100;
            this.f246657b = r101;
            this.f246658c = r102;
            this.f246659d = r103;
        }

        @Override // java.lang.Runnable
        public final void run() {
            q r100 = this.f246656a.f246641a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.LG(this.f246657b, this.f246658c, this.f246659d);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f246660a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Uri f246661b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Throwable f246662c;

        public g(d r100, Uri r101, Throwable r102) {
            this.f246660a = r100;
            this.f246661b = r101;
            this.f246662c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            q r100 = this.f246660a.f246641a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.onLoadFail(this.f246661b, this.f246662c);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f246663a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Uri f246664b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ o f246665c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ t36.j f246666d;

        public h(d r100, Uri r101, o r102, t36.j r103) {
            this.f246663a = r100;
            this.f246664b = r101;
            this.f246665c = r102;
            this.f246666d = r103;
        }

        @Override // java.lang.Runnable
        public final void run() {
            q r100 = this.f246663a.f246641a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.bK(this.f246664b, this.f246665c, this.f246666d);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f246667a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Uri f246668b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ h16.e f246669c;

        public i(d r100, Uri r101, h16.e r102) {
            this.f246667a = r100;
            this.f246668b = r101;
            this.f246669c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            q r100 = this.f246667a.f246641a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.Ox(this.f246668b, this.f246669c);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f246670a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Uri f246671b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ o f246672c;

        public j(d r100, Uri r101, o r102) {
            this.f246670a = r100;
            this.f246671b = r101;
            this.f246672c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            q r100 = this.f246670a.f246641a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.go(this.f246671b, this.f246672c);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class k implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f246673a;

        public k(d r100) {
            this.f246673a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            q r100 = this.f246673a.f246641a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.onOpen();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class l implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f246674a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Uri f246675b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ o f246676c;

        public l(d r100, Uri r101, o r102) {
            this.f246674a = r100;
            this.f246675b = r101;
            this.f246676c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            q r100 = this.f246674a.f246641a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.HP(this.f246675b, this.f246676c);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    @Override // com.bytedance.ies.bullet.core.q
    public final void lX() {
        a(new b(this));
    }

    @Override // com.bytedance.ies.bullet.core.q
    public final void onClose() {
        a(new c(this));
    }

    @Override // com.bytedance.ies.bullet.core.q
    public final void onOpen() {
        a(new k(this));
    }

    @Override // com.bytedance.ies.bullet.core.q
    public final void rS() {
        a(new a(this));
    }

    public d() {
        this.f246643c = new ConcurrentLinkedQueue();
        com.bytedance.ies.bullet.flow.e r100 = new com.bytedance.ies.bullet.flow.e();
        this.f246644d = r100;
        this.f246645e = new Handler(Looper.getMainLooper());
        this.f246646f = r100;
    }

    @Override // com.bytedance.ies.bullet.core.s
    public final u26.b getLynxClient() {
        return this.f246646f;
    }

    public final void a(Runnable r100) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.f246642b == true) goto L6;
        this.f246643c.add(r100);     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L6:
        if (Intrinsics.areEqual(this.f246645e.getLooper(), Looper.myLooper()) == false) goto L8;
        r100.run();     // Catch: Throwable -> L14
    L9:
        monitor-exit(this);
        return;
    L8:
        this.f246645e.post(r100);     // Catch: Throwable -> L14
        goto L9
    }

    @Override // com.bytedance.ies.bullet.core.s
    public final void HP(Uri r100, o r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        a(new l(this, r100, r101));
    }

    @Override // com.bytedance.ies.bullet.core.s
    public final void Ox(Uri r100, h16.e r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        a(new i(this, r100, r101));
    }

    @Override // com.bytedance.ies.bullet.core.s
    public final void TH(Uri r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter(r101, "e");
        a(new RunnableC3525d(this, r100, r101));
    }

    @Override // com.bytedance.ies.bullet.core.s
    public final void gQ(Uri r100, o r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        a(new e(this, r100, r101));
    }

    @Override // com.bytedance.ies.bullet.core.s
    public final void go(Uri r100, o r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        a(new j(this, r100, r101));
    }

    @Override // com.bytedance.ies.bullet.core.s
    public final void onLoadFail(Uri r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter(r101, "e");
        a(new g(this, r100, r101));
    }

    @Override // com.bytedance.ies.bullet.core.s
    public final void LG(Uri r100, o r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        a(new f(this, r100, r101, r102));
    }

    @Override // com.bytedance.ies.bullet.core.s
    public final void bK(Uri r100, o r101, t36.j r102) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter(r102, "schemaModelUnion");
        a(new h(this, r100, r101, r102));
    }
}

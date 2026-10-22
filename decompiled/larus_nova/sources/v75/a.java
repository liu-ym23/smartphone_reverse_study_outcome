package v75;

import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.bytedance.ee.bear.drive.loader.model.InfoCode;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import com.bytedance.ee.util.ui.m;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements u75.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<u75.b.a> f553484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f553485b;

    /* JADX INFO: renamed from: v75.a$a, reason: collision with other inner class name */
    public static final class RunnableC7968a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f553486a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ErrCode f553487b;

        public RunnableC7968a(a r100, ErrCode r101) {
            this.f553486a = r100;
            this.f553487b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Iterator<u75.b.a> r100 = this.f553486a.f553484a.iterator();     // Catch: Throwable -> L9
        L4:
            if (r100.hasNext() == false) goto L21;
            u75.b.a r101 = r100.next();     // Catch: Throwable -> L9
            if (r101 == null) goto L4;
            r101.c(this.f553487b);     // Catch: Throwable -> L9
            goto L4
        L21:
            return;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L13;
            return;
        L13:
            throw th;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f553488a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ InfoCode f553489b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ I f553490c;

        public b(a r100, InfoCode r101, I r102) {
            this.f553488a = r100;
            this.f553489b = r101;
            this.f553490c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Iterator<u75.b.a> r100 = this.f553488a.f553484a.iterator();     // Catch: Throwable -> L9
        L4:
            if (r100.hasNext() == false) goto L21;
            u75.b.a r101 = r100.next();     // Catch: Throwable -> L9
            if (r101 == null) goto L4;
            r101.a(this.f553489b, this.f553490c);     // Catch: Throwable -> L9
            goto L4
        L21:
            return;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L13;
            return;
        L13:
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f553491a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f553492b;

        public c(a r100, int r101) {
            this.f553491a = r100;
            this.f553492b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Iterator<u75.b.a> r100 = this.f553491a.f553484a.iterator();     // Catch: Throwable -> L9
        L4:
            if (r100.hasNext() == false) goto L21;
            u75.b.a r101 = r100.next();     // Catch: Throwable -> L9
            if (r101 == null) goto L4;
            r101.onProgress(this.f553492b);     // Catch: Throwable -> L9
            goto L4
        L21:
            return;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L13;
            return;
        L13:
            throw th;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f553493a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ z f553494b;

        public d(a r100, z r101) {
            this.f553493a = r100;
            this.f553494b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Iterator<u75.b.a> r100 = this.f553493a.f553484a.iterator();     // Catch: Throwable -> L9
        L4:
            if (r100.hasNext() == false) goto L21;
            u75.b.a r101 = r100.next();     // Catch: Throwable -> L9
            if (r101 == null) goto L4;
            r101.b(this.f553494b);     // Catch: Throwable -> L9
            goto L4
        L21:
            return;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L13;
            return;
        L13:
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(List<? extends u75.b.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "listeners");
        this.f553484a = r100;
        this.f553485b = true;
    }

    @Override // u75.b.a
    public final void b(z r100) {
        Intrinsics.checkNotNullParameter(r100, "previewFileModel");
        tt5.a.h("DriveComponent", "load()#onSuccess");
        if (this.f553485b == true) goto L5;
        return;
    L5:
        m.a(new d(this, r100));
    }

    @Override // u75.b.a
    public final void c(ErrCode r100) {
        Intrinsics.checkNotNullParameter(r100, "code");
        tt5.a.h("DriveComponent", "load()#onFailed=" + r100);
        if (this.f553485b == true) goto L5;
        return;
    L5:
        m.a(new RunnableC7968a(this, r100));
    }

    @Override // u75.b.a
    public final void onProgress(int r100) {
        if (r100 != 0) goto L4;
    L5:
        tt5.a.h("DriveComponent", "load()#onProgress=" + r100);
    L7:
        if (this.f553485b == true) goto L9;
        return;
    L9:
        m.a(new c(this, r100));
        return;
    L4:
        if (r100 != 100) goto L7;
        goto L5
    }

    @Override // u75.b.a
    public final <I> void a(InfoCode r100, I r101) {
        Intrinsics.checkNotNullParameter(r100, "code");
        tt5.a.h("DriveComponent", "load()#onInfo=" + r100);
        if (this.f553485b == true) goto L5;
        return;
    L5:
        m.a(new b(this, r100, r101));
    }
}

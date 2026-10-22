package v75;

import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.bytedance.ee.bear.drive.loader.model.InfoCode;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import com.bytedance.ee.util.ui.m;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements u75.b.a {
    public final List<u75.b.a> a;
    public boolean b;

    /* JADX INFO: renamed from: v75.a$a, reason: collision with other inner class name */
    public static final class RunnableC0310a implements Runnable {
        public final /* synthetic */ a a;
        public final /* synthetic */ ErrCode b;

        public RunnableC0310a(a r1, ErrCode r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Iterator<u75.b.a> r0 = this.a.a.iterator();     // Catch: Throwable -> L9
        L4:
            if (r0.hasNext() == false) goto L21;
            u75.b.a r1 = r0.next();     // Catch: Throwable -> L9
            if (r1 == null) goto L4;
            r1.c(this.b);     // Catch: Throwable -> L9
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
        public final /* synthetic */ a a;
        public final /* synthetic */ InfoCode b;
        public final /* synthetic */ I c;

        public b(a r1, InfoCode r2, I r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Iterator<u75.b.a> r0 = this.a.a.iterator();     // Catch: Throwable -> L9
        L4:
            if (r0.hasNext() == false) goto L21;
            u75.b.a r1 = r0.next();     // Catch: Throwable -> L9
            if (r1 == null) goto L4;
            r1.a(this.b, this.c);     // Catch: Throwable -> L9
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
        public final /* synthetic */ a a;
        public final /* synthetic */ int b;

        public c(a r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Iterator<u75.b.a> r0 = this.a.a.iterator();     // Catch: Throwable -> L9
        L4:
            if (r0.hasNext() == false) goto L21;
            u75.b.a r1 = r0.next();     // Catch: Throwable -> L9
            if (r1 == null) goto L4;
            r1.onProgress(this.b);     // Catch: Throwable -> L9
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
        public final /* synthetic */ a a;
        public final /* synthetic */ z b;

        public d(a r1, z r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Iterator<u75.b.a> r0 = this.a.a.iterator();     // Catch: Throwable -> L9
        L4:
            if (r0.hasNext() == false) goto L21;
            u75.b.a r1 = r0.next();     // Catch: Throwable -> L9
            if (r1 == null) goto L4;
            r1.b(this.b);     // Catch: Throwable -> L9
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
    public a(List<? extends u75.b.a> r2) {
        Intrinsics.checkNotNullParameter(r2, "listeners");
        this.a = r2;
        this.b = true;
    }

    @Override // u75.b.a
    public final void b(z r3) {
        Intrinsics.checkNotNullParameter(r3, "previewFileModel");
        tt5.a.h("DriveComponent", "load()#onSuccess");
        if (this.b == true) goto L5;
        return;
    L5:
        m.a(new d(this, r3));
    }

    @Override // u75.b.a
    public final void c(ErrCode r3) {
        Intrinsics.checkNotNullParameter(r3, "code");
        tt5.a.h("DriveComponent", "load()#onFailed=" + r3);
        if (this.b == true) goto L5;
        return;
    L5:
        m.a(new RunnableC0310a(this, r3));
    }

    @Override // u75.b.a
    public final void onProgress(int r3) {
        if (r3 != 0) goto L4;
    L5:
        tt5.a.h("DriveComponent", "load()#onProgress=" + r3);
    L7:
        if (this.b == true) goto L9;
        return;
    L9:
        m.a(new c(this, r3));
        return;
    L4:
        if (r3 != 100) goto L7;
        goto L5
    }

    @Override // u75.b.a
    public final <I> void a(InfoCode r3, I r4) {
        Intrinsics.checkNotNullParameter(r3, "code");
        tt5.a.h("DriveComponent", "load()#onInfo=" + r3);
        if (this.b == true) goto L5;
        return;
    L5:
        m.a(new b(this, r3, r4));
    }
}

package px4;

import android.content.Context;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.util.io.FileUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.vfs.VFSPath;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class y implements u45.a {
    public final /* synthetic */ w a;
    public final /* synthetic */ VFSPath b;
    public final /* synthetic */ VFSPath c;
    public final /* synthetic */ Function0<Unit> d;
    public final /* synthetic */ Function0<Unit> e;

    public static final class a implements Runnable {
        public final /* synthetic */ Function0<Unit> a;

        public a(Function0<Unit> r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ Function0<Unit> a;

        public b(Function0<Unit> r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ Function0<Unit> a;

        public c(Function0<Unit> r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // u45.a
    public final void onStart() {
        tt5.a.b("LynxDownloadScmPresenter", "onStart");
        w r0 = this.a;
        r0.getClass();
        com.bytedance.ee.util.ui.j.c(new a0(r0, "downloading..."));
    }

    @Override // u45.a
    public final void a(int r4) {
        w r0 = this.a;
        r0.getClass();
        com.bytedance.ee.util.ui.j.c(new a0(r0, "downloading..." + r4 + '%'));
    }

    @Override // u45.a
    public final void b(VFSPath r7) {
        Intrinsics.checkNotNullParameter(r7, "path");
        tt5.a.h("LynxDownloadScmPresenter", "onDownloadComplete");
        VFSPath r3 = this.c.getParent();     // Catch: Throwable -> L9 IOException -> L11
        if (r3 != null) goto L7;
    L5:
        FileUtils.m(this.b);
        return;
    L7:
        VFSPath r4 = r3.subPath(this.c.getName() + "_temp");     // Catch: Throwable -> L9 IOException -> L11
        FileUtils.m(this.c);     // Catch: Throwable -> L9 IOException -> L11
        FileUtils.m(r4);     // Catch: Throwable -> L9 IOException -> L11
        int r5 = w.c;     // Catch: Throwable -> L9 IOException -> L11
        w.a.a(r7, r4);     // Catch: Throwable -> L9 IOException -> L11
        r4.toFile().renameTo(this.c.toFile());     // Catch: Throwable -> L9 IOException -> L11
        this.c.subPath("current_revision").toFile().renameTo(this.c.subPath("docs_lynx_channel").subPath("current_revision").toFile());     // Catch: Throwable -> L9 IOException -> L11
        tt5.a.b("LynxDownloadScmPresenter", "onDownloadComplete");     // Catch: Throwable -> L9 IOException -> L11
        w r8 = this.a;     // Catch: Throwable -> L9 IOException -> L11
        r8.getClass();     // Catch: Throwable -> L9 IOException -> L11
        com.bytedance.ee.util.ui.j.c(new z(r8));     // Catch: Throwable -> L9 IOException -> L11
        com.bytedance.ee.util.ui.j.c(new a(this.e));     // Catch: Throwable -> L9 IOException -> L11
        Context r9 = this.a.a;     // Catch: Throwable -> L9 IOException -> L11
        Toast.showSuccessText(r9, r9.getString(2131887648), 1);     // Catch: Throwable -> L9 IOException -> L11
    L9:
        th = move-exception;
        FileUtils.m(this.b);
        throw th;
    L11:
        e = move-exception;
        this.a.a(e, this.b, this.c);     // Catch: Throwable -> L9
        com.bytedance.ee.util.ui.j.c(new b(this.d));     // Catch: Throwable -> L9
        goto L5
    }

    @Override // u45.a
    public final void c(Exception r4) {
        this.a.a(r4, this.b, this.c);
        com.bytedance.ee.util.ui.j.c(new c(this.d));
    }

    public y(w r1, VFSPath r2, VFSPath r3, e r4, u r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}

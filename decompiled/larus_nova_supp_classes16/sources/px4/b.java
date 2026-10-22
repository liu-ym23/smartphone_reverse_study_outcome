package px4;

import android.app.Dialog;
import android.content.Context;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.util.io.FileUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSPath;
import java.io.File;
import java.io.IOException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements u45.a {
    public final /* synthetic */ Ref.ObjectRef<jx4.u> a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ VFSPath c;
    public final /* synthetic */ Function0<Unit> d;
    public final /* synthetic */ VFSPath e;
    public final /* synthetic */ Function0<Unit> f;

    public static final class a implements Runnable {
        public final /* synthetic */ Ref.ObjectRef<jx4.u> a;
        public final /* synthetic */ Function0<Unit> b;

        public a(Ref.ObjectRef<jx4.u> r1, Function0<Unit> r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            jx4.u r0 = (jx4.u) this.a.element;     // Catch: Throwable -> L7
            if (r0 == null) goto L5;
            r0.b();     // Catch: Throwable -> L7
        L5:
            this.b.invoke();     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    /* JADX INFO: renamed from: px4.b$b, reason: collision with other inner class name */
    public static final class RunnableC0274b implements Runnable {
        public final /* synthetic */ Ref.ObjectRef<jx4.u> a;
        public final /* synthetic */ Function0<Unit> b;

        public RunnableC0274b(Ref.ObjectRef<jx4.u> r1, Function0<Unit> r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            jx4.u r0 = (jx4.u) this.a.element;     // Catch: Throwable -> L7
            if (r0 == null) goto L5;
            r0.b();     // Catch: Throwable -> L7
        L5:
            this.b.invoke();     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ Ref.ObjectRef<jx4.u> a;
        public final /* synthetic */ Function0<Unit> b;

        public c(Ref.ObjectRef<jx4.u> r1, Function0<Unit> r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            jx4.u r0 = (jx4.u) this.a.element;     // Catch: Throwable -> L7
            if (r0 == null) goto L5;
            r0.b();     // Catch: Throwable -> L7
        L5:
            this.b.invoke();     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ Ref.ObjectRef<jx4.u> a;
        public final /* synthetic */ int b;

        public d(Ref.ObjectRef<jx4.u> r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            jx4.u r0 = (jx4.u) this.a.element;     // Catch: Throwable -> L10
            if (r0 == null) goto L13;
            String r1 = "downloading..." + this.b + '%';     // Catch: Throwable -> L10
            Dialog r2 = r0.b;     // Catch: Throwable -> L10
            if (r2 != null) goto L7;
            return;
        L7:
            if (r2.isShowing() == false) goto L18;
            r0.c.setText(r1);     // Catch: Throwable -> L10
            return;
        L18:
            return;
        L13:
            return;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L19;
            throw th;
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ Ref.ObjectRef<jx4.u> a;
        public final /* synthetic */ Context b;

        public e(Ref.ObjectRef<jx4.u> r1, Context r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            Ref.ObjectRef<jx4.u> r0 = this.a;
            if (r0.element != null) goto L13;
            r0.element = new jx4.u(this.b, "downloading...");
            jx4.u r1 = (jx4.u) this.a.element;
            if (r1 == null) goto L9;
            Dialog r2 = r1.b;
            if (r2 == null) goto L9;
            r2.setCancelable(false);
        L9:
            jx4.u r3 = (jx4.u) this.a.element;
            if (r3 == null) goto L14;
            r3.c();
            return;
        L14:
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
    }

    @Override // u45.a
    public final void onStart() {
        tt5.a.b("BitableSCMResourceDownloader", "onStart");
        com.bytedance.ee.util.ui.j.c(new e(this.a, this.b));
    }

    @Override // u45.a
    public final void a(int r3) {
        com.bytedance.ee.util.ui.j.c(new d(this.a, r3));
    }

    @Override // u45.a
    public final void b(VFSPath r9) {
        Intrinsics.checkNotNullParameter(r9, "path");
        tt5.a.h("BitableSCMResourceDownloader", "onDownloadComplete");
        VFSPath r2 = this.e.getParent();     // Catch: Throwable -> L20 IOException -> L22
        if (r2 != null) goto L7;
    L5:
        FileUtils.m(this.c);
        return;
    L7:
        VFSPath r3 = r2.subPath(this.e.getName() + "_temp");     // Catch: Throwable -> L20 IOException -> L22
        FileUtils.m(this.e);     // Catch: Throwable -> L20 IOException -> L22
        FileUtils.m(r3);     // Catch: Throwable -> L20 IOException -> L22
        int r4 = w.c;     // Catch: Throwable -> L20 IOException -> L22
        w.a.a(r9, r3);     // Catch: Throwable -> L20 IOException -> L22
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L10
        r3.subPath("bitable_lynx_channel.zst").toFile().delete();     // Catch: Throwable -> L10
        Object r11 = Result.constructor-impl(Boolean.valueOf(r3.subPath("bitable_lynx_channel.zip").toFile().delete()));     // Catch: Throwable -> L10
    L12:
        Throwable r12 = Result.exceptionOrNull-impl(r11);     // Catch: Throwable -> L20 IOException -> L22
        int r5 = 0;
        if (r12 == null) goto L15;
        tt5.a.e("BitableSCMResourceDownloader", "onDownloadComplete deleteFile failed", r12, false);     // Catch: Throwable -> L20 IOException -> L22
    L15:
        VFSFile r13 = r3.subPath("bitable_lynx_channel").toFile();     // Catch: Throwable -> L20 IOException -> L22
        File[] r6 = r13.listFiles();     // Catch: Throwable -> L20 IOException -> L22
        int r7 = r6.length;     // Catch: Throwable -> L20 IOException -> L22
    L16:
        if (r5 >= r7) goto L18;
        File r8 = r6[r5];     // Catch: Throwable -> L20 IOException -> L22
        r8.renameTo(r3.subPath(r8.getName()).toFile());     // Catch: Throwable -> L20 IOException -> L22
        r5 = r5 + 1;     // Catch: Throwable -> L20 IOException -> L22
        goto L16
    L18:
        r13.delete();     // Catch: Throwable -> L20 IOException -> L22
        r3.toFile().renameTo(this.e.toFile());     // Catch: Throwable -> L20 IOException -> L22
        px4.c.a = null;     // Catch: Throwable -> L20 IOException -> L22
        px4.c.b(this.b);     // Catch: Throwable -> L20 IOException -> L22
        tt5.a.b("BitableSCMResourceDownloader", "onDownloadComplete");     // Catch: Throwable -> L20 IOException -> L22
        com.bytedance.ee.util.ui.j.c(new a(this.a, this.f));     // Catch: Throwable -> L20 IOException -> L22
        Toast.showSuccessText(this.b, "下载成功，重新加载 Lynx 页面生效", 1);     // Catch: Throwable -> L20 IOException -> L22
    L10:
        th = move-exception;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L20 IOException -> L22
        r11 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L20 IOException -> L22
    L22:
        e = move-exception;
        String r0 = px4.c.a;     // Catch: Throwable -> L20
        px4.c.a(e, this.c, this.b);     // Catch: Throwable -> L20
        com.bytedance.ee.util.ui.j.c(new RunnableC0274b(this.a, this.d));     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        FileUtils.m(this.c);
        throw th;
    }

    @Override // u45.a
    public final void c(Exception r3) {
        String r0 = px4.c.a;
        px4.c.a(r3, this.c, this.b);
        com.bytedance.ee.util.ui.j.c(new c(this.a, this.d));
    }

    public b(Ref.ObjectRef r1, Context r2, VFSPath r3, g r4, VFSPath r5, f r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}

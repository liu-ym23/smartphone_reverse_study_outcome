package he5;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.diskmanager.Biz;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;
import com.bytedance.ee.util.io.FileUtils;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.vfs.VFSPath;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.schedulers.ExecutorScheduler;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements uqb.b {
    public static final ExecutorScheduler c = null;
    public final String a;
    public Disposable b;

    public static final class a {
    }

    public static final class b {
        public static final /* synthetic */ int a = 0;

        static {
        }

        public static VFSPath b(Context r4) {
            Intrinsics.checkNotNullParameter(r4, "context");
            int r5 = ay4.c.a;
            return ay4.c.a.f(Biz.DYNAMIC, null, false, true, 6).subPath("lynx_res");
        }

        public static ie5.e d(BufferedReader r15) throws IOException {
            ie5.e r2 = new ie5.e();     // Catch: Throwable -> L26
            Ref.ObjectRef r3 = new Ref.ObjectRef();     // Catch: Throwable -> L26
        L4:
            String r4 = r15.readLine();     // Catch: Throwable -> L26
            Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L26
            r3.element = r4;     // Catch: Throwable -> L26
            if (r4 != null) goto L8;
        L32:
            r15.close();     // Catch: Exception -> L23
        L25:
            return r2;
        L23:
            e = move-exception;
            tt5.a.f("LynxResUtil", e, false);
            goto L25
        L8:
            if (StringsKt.startsWith$default(r4, "version", false, 2, null) == false) goto L13;
            String[] r5 = (String[]) StringsKt.split$default((CharSequence) r3.element, new String[]{":"}, false, 0, 6, null).toArray(new String[0]);     // Catch: Throwable -> L26
            if (r5.length != 2) goto L18;
            r2.b = r5[1];     // Catch: Throwable -> L26
        L18:
            if (TextUtils.isEmpty(r2.a) == true) goto L4;
            if (TextUtils.isEmpty(r2.b) == true) goto L4;
        L13:
            if (StringsKt.startsWith$default((String) r3.element, "revision", false, 2, null) == false) goto L18;
            String[] r6 = (String[]) StringsKt.split$default((CharSequence) r3.element, new String[]{":"}, false, 0, 6, null).toArray(new String[0]);     // Catch: Throwable -> L26
            if (r6.length != 2) goto L18;
            r2.a = r6[1];     // Catch: Throwable -> L26
        L26:
            th = move-exception;
            r15.close();     // Catch: Exception -> L29
        L31:
            throw th;
        L29:
            e = move-exception;
            tt5.a.f("LynxResUtil", e, false);
            goto L31
        }

        public static VFSPath c(Context r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r2, "channel");
            VFSPath r3 = b(r1);
            if (TextUtils.isEmpty(r2) == false) goto L7;
            tt5.a.h("LynxResUtil", "getResourceRootDir(): channel is empty,return folder spaceRes");
            return r3;
        L7:
            return r3.subPath(r2);
        }

        public static void a(Context r9, String r10, VFSPath r11) {
            Closeable r3 = null;
            InputStream r4 = null;
            OutputStream r5 = null;
            r5 = null;
            r3 = null;
            String[] r6 = r9.getAssets().list(r10);     // Catch: Throwable -> L32 Exception -> L34
            if (r6 != null) goto L6;
        L16:
            InputStream r12 = r9.getAssets().open(r10);     // Catch: Throwable -> L32 Exception -> L34
            VFSPath r13 = r11.getParent();     // Catch: Throwable -> L28 Exception -> L30
            if (r13 == null) goto L20;
            com.suite.lark.component.storage.ext.b.d(r13);     // Catch: Throwable -> L28 Exception -> L30
        L20:
            r5 = ay4.d.a().s(r11, false);     // Catch: Throwable -> L28 Exception -> L30
            byte[] r14 = new byte[DocUserPermission.USER_PERM_FULL_ACCESS];     // Catch: Throwable -> L28 Exception -> L30
        L21:
            int r15 = r12.read(r14);     // Catch: Throwable -> L28 Exception -> L30
            if (r15 == (-1)) goto L24;
            r5.write(r14, 0, r15);     // Catch: Throwable -> L28 Exception -> L30
            goto L21
        L24:
            r5.flush();     // Catch: Throwable -> L28 Exception -> L30
            r12.close();     // Catch: Throwable -> L28 Exception -> L30
            r5.close();     // Catch: Throwable -> L28 Exception -> L30
            r4 = r12;
            OutputStream r16 = r5;
        L26:
            FileUtils.e(new Closeable[]{r4, r16});
            return;
        L30:
            Exception e = e;
            Closeable r8 = r5;
            r3 = r12;
            Closeable r17 = r8;
        L41:
            tt5.a.f("LynxResUtil", e, false);     // Catch: Throwable -> L38
            throw e;     // Catch: Throwable -> L38
        L38:
            Throwable th = th;
        L39:
            FileUtils.e(new Closeable[]{r3, r17});
            throw th;
        L28:
            th = th;
            Closeable r18 = r5;
            r3 = r12;
            r17 = r18;
            goto L39
        L6:
            if (r6.length != 0) goto L8;
            boolean r7 = true;
        L10:
            if ((!r7) == false) goto L16;
            com.suite.lark.component.storage.ext.b.d(r11);     // Catch: Throwable -> L32 Exception -> L34
            Iterator r19 = ArrayIteratorKt.iterator(r6);     // Catch: Throwable -> L32 Exception -> L34
        L13:
            if (r19.hasNext() == false) goto L15;
            String r20 = (String) r19.next();     // Catch: Throwable -> L32 Exception -> L34
            Intrinsics.checkNotNull(r20);     // Catch: Throwable -> L32 Exception -> L34
            a(r9, r10 + '/' + r20, r11.subPath(r20));     // Catch: Throwable -> L32 Exception -> L34
            goto L13
        L15:
            r16 = null;
            goto L26
        L8:
            r7 = false;
        L34:
            e = move-exception;
            e = e;
            r17 = null;
        L32:
            th = move-exception;
            th = th;
            r17 = null;
            goto L39
        }
    }

    /* JADX INFO: renamed from: he5.c$c, reason: collision with other inner class name */
    public static final class C0243c<T, R> implements Function {
        public final /* synthetic */ c a;
        public final /* synthetic */ String b;

        public C0243c(c r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r14) {
            Intrinsics.checkNotNullParameter((Boolean) r14, "it");
            String r15 = this.a.a;
            String r0 = this.b;
            Application r2 = eu5.b.a;
            int r3 = b.a;
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r15, "channel");
            Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L5
            Object r6 = Result.constructor-impl(b.d(new BufferedReader(new InputStreamReader(r2.getAssets().open("offline/" + r15 + "/current_revision")))));     // Catch: Throwable -> L5
        L7:
            Throwable r7 = Result.exceptionOrNull-impl(r6);
            if (r7 == null) goto L10;
            iu5.d.a("LynxResUtil getAssetVersion ", r7);
        L10:
            ie5.e r8 = new ie5.e();
            if (Result.isFailure-impl(r6) == false) goto L13;
            r6 = r8;
        L13:
            String r9 = ((ie5.e) r6).b;
            if (r9 != null) goto L16;
        L19:
            boolean r10 = true;
        L20:
            if (r10 == true) goto L46;
            VFSPath r11 = b.b(r2);
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r15, "channel");
        L26:
            th = move-exception;
            tt5.a.e("LynxResUtil", "getResLocalVersion error", th, false);
        L28:
            ie5.e r12 = new ie5.e();
        L30:
            if (TextUtils.equals(r9, r12.b) == true) goto L36;
            tt5.a.h("SevenZLoader", "replaceLocal");
            int r13 = b.a;
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r15, "channel");
            FileUtils.p(b.c(r2, r15));
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r15, "channel");
            Intrinsics.checkNotNullParameter(r11, "dest");
            VFSPath r4 = b.b(r2).subPath(r15 + ".7z");
            FileUtils.m(r4);
            b.a(r2, "offline/" + r15 + '/' + r15 + ".7z", r4);
            int r1 = com.bytedance.ee.util.io.d.a(r4.getRealPath(), r11.getRealPath());
            FileUtils.m(r4);
            if (r1 == 0) goto L36;
            throw new IllegalAccessException("extract7z failed " + r1);
        L36:
            VFSPath r16 = r11.subPath(r15).subPath(r0);
            InputStream r17 = ay4.d.a().l(r16);
            byte[] r18 = ByteStreamsKt.readBytes(r17);     // Catch: Throwable -> L40
            CloseableKt.closeFinally(r17, null);
            return new uqb.c(r18, r16.getRealPath(), "SevenZLoader");
        L40:
            th = move-exception;
            throw th;     // Catch: Throwable -> L42
        L42:
            th = move-exception;
            CloseableKt.closeFinally(r17, th);
            throw th;
        L23:
            if (com.suite.lark.component.storage.ext.b.b(b.c(r2, r15).subPath("current_revision")) == false) goto L28;
            r12 = b.d(new BufferedReader(new PolarisFileReaderWrapper(ay4.d.a().r(b.c(r2, r15).subPath("current_revision"), false))));     // Catch: Throwable -> L26
            goto L30
        L46:
            throw new IllegalArgumentException("assetVersion is null");
        L16:
            if (r9.length() == 0) goto L19;
            r10 = false;
        L5:
            th = move-exception;
            Result.Companion r19 = Result.Companion;
            r6 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L7
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ uqb.a a;

        public d(uqb.a r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            uqb.c r3 = (uqb.c) r2;
            uqb.a r0 = this.a;
            Intrinsics.checkNotNull(r3);
            r0.a(r3);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ uqb.a a;

        public e(uqb.a r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            iu5.d.a("SevenZLoader loadAssetStream", r3);
            uqb.a r0 = this.a;
            Intrinsics.checkNotNull(r3);
            r0.onFailed(r3);
        }
    }

    static {
        c = new ExecutorScheduler(CoreThreadPool.getDefault().getSingleScheduledThreadPool("SevenZLoader"), false);
    }

    public c() {
        Intrinsics.checkNotNullParameter("docs_lynx_channel", "channel");
        this.a = "docs_lynx_channel";
    }

    public final void a(String r3, uqb.a r4) {
        Intrinsics.checkNotNullParameter(r3, "templatePath");
        Intrinsics.checkNotNullParameter(r4, "resourceCallBack");
        tt5.a.h("SevenZLoader", "start to async load from assets");
        if (Intrinsics.areEqual("docs_lynx_channel", this.a) == true) goto L6;
        r4.onFailed(new Exception("7z Channel/Bundle invalid"));
        return;
    L6:
        this.b = Single.just(Boolean.TRUE).map(new C0243c(this, r3)).subscribeOn(c).subscribe(new d(r4), new e(r4));
    }
}

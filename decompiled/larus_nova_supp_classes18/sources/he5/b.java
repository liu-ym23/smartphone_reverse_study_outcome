package he5;

import android.app.Application;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.vfs.VFSPath;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.schedulers.ExecutorScheduler;
import java.io.FileNotFoundException;
import java.io.InputStream;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements uqb.b {
    public static final ExecutorScheduler c = null;
    public final String a;
    public Disposable b;

    public static final class a {
    }

    /* JADX INFO: renamed from: he5.b$b, reason: collision with other inner class name */
    public static final class C0242b<T, R> implements Function {
        public final /* synthetic */ b a;
        public final /* synthetic */ String b;

        public C0242b(b r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r6) {
            Intrinsics.checkNotNullParameter((Boolean) r6, "it");
            String r7 = this.a.a;
            String r0 = this.b;
            Application r1 = eu5.b.a;
            com.bytedance.ee.bear.lynx.api.c r2 = (com.bytedance.ee.bear.lynx.api.c) org.koin.java.a.c(com.bytedance.ee.bear.lynx.api.c.class, null, null, 6);
            Intrinsics.checkNotNull(r1);
            VFSPath r8 = r2.b(r1).subPath(r7).subPath(r0);
            if (com.suite.lark.component.storage.ext.b.b(r8) == false) goto L14;
            InputStream r3 = ay4.d.a().l(r8);
            byte[] r4 = ByteStreamsKt.readBytes(r3);     // Catch: Throwable -> L8
            CloseableKt.closeFinally(r3, null);
            return new uqb.c(r4, r8.getRealPath(), "DebugSpecificLoader");
        L8:
            th = move-exception;
            throw th;     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            CloseableKt.closeFinally(r3, th);
            throw th;
        L14:
            throw new FileNotFoundException(r0);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ uqb.a a;

        public c(uqb.a r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            uqb.c r3 = (uqb.c) r2;
            uqb.a r0 = this.a;
            Intrinsics.checkNotNull(r3);
            r0.a(r3);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ uqb.a a;

        public d(uqb.a r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            uqb.a r0 = this.a;
            Intrinsics.checkNotNull(r3);
            r0.onFailed(r3);
        }
    }

    static {
        c = new ExecutorScheduler(CoreThreadPool.getDefault().getSingleScheduledThreadPool("DebugSpecificLoader"), false);
    }

    public b() {
        Intrinsics.checkNotNullParameter("docs_lynx_channel", "channel");
        this.a = "docs_lynx_channel";
    }

    public final void a(String r3, uqb.a r4) {
        Intrinsics.checkNotNullParameter(r3, "templatePath");
        Intrinsics.checkNotNullParameter(r4, "resourceCallBack");
        tt5.a.h("DebugSpecificLoader", "start to async load from specific");
        if (this.a.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        r4.onFailed(new Exception("LOCAL_FILE Channel/Bundle invalid"));
        return;
    L9:
        this.b = Single.just(Boolean.TRUE).map(new C0242b(this, r3)).subscribeOn(c).subscribe(new c(r4), new d(r4));
        return;
    L5:
        r0 = false;
        goto L6
    }
}

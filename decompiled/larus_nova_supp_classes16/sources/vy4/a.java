package vy4;

import android.content.Context;
import com.bytedance.ee.bear.doc.resupdate.EChannel;
import com.bytedance.ee.bear.doc.resupdate.d0;
import com.bytedance.ee.bear.doc.resupdate.h;
import com.bytedance.ee.util.io.FileUtils;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSPath;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static CountDownLatch a;

    /* JADX INFO: renamed from: vy4.a$a, reason: collision with other inner class name */
    public static final class C0314a<T> implements Consumer {
        public final /* synthetic */ Context a;
        public final /* synthetic */ VFSFile b;

        public C0314a(Context r1, VFSFile r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            Boolean r4 = (Boolean) r3;
            Iterator<String> r5 = EChannel.getChannelList(!com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.full_pkg_included")).iterator();
        L4:
            if (r5.hasNext() == false) goto L6;
            String r0 = r5.next();
            Context r1 = this.a;
            Intrinsics.checkNotNull(r0);
            a.c(r1, r0);
            goto L4
        L6:
            CountDownLatch r6 = a.a;
            if (r6 == null) goto L9;
            r6.countDown();
        L9:
            tt5.a.h("ResCleanUtils", "cleanResource, clean gecko dir success");
            FileUtils.p(this.b.getVfsPath());
            tt5.a.h("ResCleanUtils", "cleanResource, clean space_res dir success");
        }
    }

    public static final class b<T> implements Consumer {
        public static final b<T> a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            CountDownLatch r0 = a.a;
            if (r0 == null) goto L5;
            r0.countDown();
        L5:
            tt5.a.e("ResCleanUtils", "cleanResource failed", r5, false);
        }
    }

    static {
    }

    public static void a(Context r5) {
        VFSFile r0 = d0.j(null);
        VFSFile r1 = ay4.d.a().i(r0.getAbsolutePath() + '_' + System.currentTimeMillis());
        if (r0.renameTo(r1) == false) goto L5;
        a = new CountDownLatch(1);
        Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).subscribe(new C0314a(r5, r1), b.a);
        return;
    L5:
        tt5.a.k("ResCleanUtils", "cleanResource: rename failed ");
    }

    @JvmStatic
    public static final void b(Context r1, String r2) throws Exception {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "channel");
        tt5.a.h("ResCleanUtils", "cleanSpaceResourceByChannel, channel = " + r2);
        FileUtils.l(d0.j(r2).getVfsPath());
    }

    @JvmStatic
    public static final void c(Context r3, String r4) throws IOException {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "channel");
        tt5.a.h("ResCleanUtils", "clearGeckoResourceByChannel, channel = " + r4);
        String r0 = ((h) org.koin.java.a.c(h.class, null, null, 6)).b(r3);
        VFSPath r5 = com.bytedance.ee.bear.doc.resupdate.c.b(r3).getVfsPath();
        Intrinsics.checkNotNull(r0);
        FileUtils.p(r5.subPath(r0).subPath(r4));
    }
}

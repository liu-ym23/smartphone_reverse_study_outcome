package vy4;

import android.content.Context;
import com.bytedance.ee.bear.doc.resupdate.EChannel;
import com.bytedance.ee.bear.doc.resupdate.d0;
import com.bytedance.ee.bear.doc.resupdate.h;
import com.bytedance.ee.util.io.FileUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSPath;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static CountDownLatch f557611a;

    /* JADX INFO: renamed from: vy4.a$a, reason: collision with other inner class name */
    public static final class C8052a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f557612a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ VFSFile f557613b;

        public C8052a(Context r100, VFSFile r101) {
            this.f557612a = r100;
            this.f557613b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Boolean r101 = (Boolean) r100;
            Iterator<String> r102 = EChannel.getChannelList(!com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.mobile.full_pkg_included")).iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            String r103 = r102.next();
            Context r104 = this.f557612a;
            Intrinsics.checkNotNull(r103);
            a.c(r104, r103);
            goto L4
        L6:
            CountDownLatch r105 = a.f557611a;
            if (r105 == null) goto L9;
            r105.countDown();
        L9:
            tt5.a.h("ResCleanUtils", "cleanResource, clean gecko dir success");
            FileUtils.p(this.f557613b.getVfsPath());
            tt5.a.h("ResCleanUtils", "cleanResource, clean space_res dir success");
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b<T> f557614a = null;

        static {
            f557614a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            CountDownLatch r102 = a.f557611a;
            if (r102 == null) goto L5;
            r102.countDown();
        L5:
            tt5.a.e("ResCleanUtils", "cleanResource failed", r101, false);
        }
    }

    static {
    }

    public static void a(Context r100) {
        VFSFile r101 = d0.j(null);
        VFSFile r102 = ay4.d.a().i(r101.getAbsolutePath() + '_' + System.currentTimeMillis());
        if (r101.renameTo(r102) == false) goto L5;
        f557611a = new CountDownLatch(1);
        Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).subscribe(new C8052a(r100, r102), b.f557614a);
        return;
    L5:
        tt5.a.k("ResCleanUtils", "cleanResource: rename failed ");
    }

    @JvmStatic
    public static final void b(Context r100, String r101) throws Exception {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "channel");
        tt5.a.h("ResCleanUtils", "cleanSpaceResourceByChannel, channel = " + r101);
        FileUtils.l(d0.j(r101).getVfsPath());
    }

    @JvmStatic
    public static final void c(Context r100, String r101) throws IOException {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "channel");
        tt5.a.h("ResCleanUtils", "clearGeckoResourceByChannel, channel = " + r101);
        String r102 = ((h) org.koin.java.a.c(h.class, null, null, 6)).b(r100);
        VFSPath r103 = com.bytedance.ee.bear.doc.resupdate.c.b(r100).getVfsPath();
        Intrinsics.checkNotNull(r102);
        FileUtils.p(r103.subPath(r102).subPath(r101));
    }
}

package u25;

import android.text.TextUtils;
import android.util.Pair;
import com.bumptech.glide.Glide;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.document.offline.drive.DriveCompressCheckerV2;
import com.bytedance.ee.bear.document.offline.sync.preloadexecutor.subblock.SubBlockModel;
import com.bytedance.ee.bear.middleground.drive.export.DownloadRequestInfo;
import com.bytedance.ee.util.glide.BearGlideUrl;
import com.bytedance.ee.util.io.FileUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import j25.q;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import k25.e0;
import k25.m0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import s45.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j extends r25.j implements w85.a.b {
    public final BlockingQueue<c> d;
    public final BlockingQueue<String> e;
    public final BlockingQueue<c> f;
    public final Set<String> g;
    public final d h;
    public a i;
    public PthreadHandlerThreadV2 j;
    public final com.bytedance.ee.bear.contract.j k;
    public AccountService$Account l;
    public boolean m;
    public final DriveCompressCheckerV2 n;

    public class a implements Runnable {
        public final /* synthetic */ j a;

        /* JADX INFO: Infinite loop detected, blocks: 8, insns: 0 */
        public final void a() {
        L6:
            this.a.h();     // Catch: Exception -> L4
            j r0 = this.a;     // Catch: Exception -> L4
            j.j(r0, (c) ((LinkedBlockingQueue) r0.d).take());     // Catch: Exception -> L4
        L4:
            e = move-exception;
            tt5.a.d("PreloadImageExecutor", "Consumer  e: " + e);
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            throw null;     // Catch: Throwable -> L4
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(j r1) {
            this.a = r1;
        }
    }

    public j(boolean r3) {
        this.d = new LinkedBlockingQueue();
        this.e = new LinkedBlockingQueue();
        this.f = new LinkedBlockingQueue();
        this.g = Collections.newSetFromMap(new ConcurrentHashMap());
        this.k = com.bytedance.ee.bear.contract.j.a.a;
        this.h = new d();
        tt5.a.h("PreloadImageExecutor", "PreloadImageExecutor only_wifi_config = " + r3);
        this.n = new DriveCompressCheckerV2(eu5.b.a);
    }

    public static void l(b r4) {
        tt5.a.h("PreloadImageExecutor", "doResultUpdate... in : " + ThreadMethodProxy.currentThread().getName());
        if (r4 != null) goto L5;
        return;
    L5:
        m0 r0 = e0.m().n(r4.a, r4.b);
        x25.f r2 = r0.u;
        if (r2 != null) goto L10;
        tt5.a.d("PreloadImageExecutor", "doResultUpdate... can not find target resource data");
        return;
    L10:
        if (r4.c == false) goto L12;
        r2.c(3);
    L13:
        AtomicInteger r5 = r0.u.a;
        if (r5 != null) goto L16;
        int r6 = 0;
    L17:
        tt5.a.b("PreloadImageExecutor", "doResultUpdate... status code = " + r6 + "ObjToken = " + du5.b.g(r0.k));
        e0.m().I(r0);
        return;
    L16:
        r6 = r5.get();
        goto L17
    L12:
        r2.c(2);
        goto L13
    }

    @Override // w85.a.b
    public final void e(String r3) {
        tt5.a.h("PreloadImageExecutor-ImgCb", "onDownloadStart(): url = " + du5.b.g(r3));
        Set<String> r0 = this.g;
        if (r0 == null) goto L6;
        r0.add(r3);
        return;
    }

    public final void k(u25.a r16) {
        tt5.a.h("PreloadImageExecutor", "doImgBatchDownload... in thread : " + ThreadMethodProxy.currentThread().getName());
        if (r16 != null) goto L5;
    L62:
        tt5.a.h("PreloadImageExecutor", "no imgs for this batch");
        return;
    L5:
        if (r16.d.isEmpty() == true) goto L62;
        tt5.a.h("PreloadImageExecutor", "doImgSlicing... in:" + ThreadMethodProxy.currentThread().getName());
        ArrayList r0 = new ArrayList();
        ArrayList r2 = new ArrayList();
        Iterator<SubBlockModel> r3 = r16.d.iterator();
    L9:
        if (r3.hasNext() == false) goto L17;
        SubBlockModel r4 = r3.next();
        if (this.g.contains(r4.getUrl()) == true) goto L12;
        if (((v45.a) org.koin.java.a.a(v45.a.class)).g(r4.getUrl()) == true) goto L15;
        r0.add(r4);
        goto L9
    L15:
        r2.add(r4);
        goto L9
    L12:
        tt5.a.b("PreloadImageExecutor", "img : " + r4.getUrl() + " hit the cache");
        goto L9
    L17:
        r16.d.clear();
        r16.d.addAll(r2);
        r16.d.addAll(r0);
        tt5.a.h("PreloadImageExecutor", "doImgBatchDownload... netimg-size:" + r0.size() + " driveimg-size:" + r2.size() + "in thread : " + ThreadMethodProxy.currentThread().getName());
        d r5 = this.h;
        if (r5.a == null) goto L24;
        Iterator<SubBlockModel> r6 = r16.d.iterator();
    L22:
        if (r6.hasNext() == false) goto L24;
        r5.a.put(r6.next().getUrl(), r16);
    L24:
        Iterator r1 = r0.iterator();
    L26:
        if (r1.hasNext() == false) goto L42;
        SubBlockModel r7 = (SubBlockModel) r1.next();
        if (this.l == null) goto L26;
        tt5.a.b("PreloadImageExecutor", "consume url = " + r7.getUrl());     // Catch: Exception -> L40
        e(r7.getUrl());     // Catch: Exception -> L40
        String r8 = yu5.c.h(r7.getUrl());     // Catch: Exception -> L40
        String r9 = UriProtector.parse(r8).getScheme() + "://" + p.u + p.a().s0(UriProtector.parse(r8).getPath());     // Catch: Exception -> L40
        q r10 = e0.m().y(r8);     // Catch: Exception -> L40
        if (r10 == null) goto L35;
        if (TextUtils.isEmpty(r10.d) == true) goto L35;
        this.g.add(r7.getUrl());     // Catch: Exception -> L40
        c(r7.getUrl(), null);     // Catch: Exception -> L40
    L35:
        File r11 = (File) Glide.with(eu5.b.a).load(new BearGlideUrl(r9, new i())).downloadOnly(ShareItemModel.SRC_TINT_UNDEFINED, ShareItemModel.SRC_TINT_UNDEFINED).get();     // Catch: Exception -> L40
        if (com.bytedance.ee.util.io.b.c(ay4.d.a().t(r11)) == true) goto L37;
        tt5.a.k("PreloadImageExecutor", "preloadImages is not image: ");     // Catch: Exception -> L40
        a(r7.getUrl(), "", 1);     // Catch: Exception -> L40
        goto L26
    L37:
        q r12 = new q();     // Catch: Exception -> L40
        r12.a = r11.getName() + OfflineDoc.DASH_DELIMITER + System.currentTimeMillis();     // Catch: Exception -> L40
        r12.b = r7.getObjToken();     // Catch: Exception -> L40
        r12.c = r8;     // Catch: Exception -> L40
        r12.d = e0.D(r11.getAbsolutePath());     // Catch: Exception -> L40
        r12.h = Long.valueOf(FileUtils.v(ay4.d.a().t(r11)));     // Catch: Exception -> L40
        r12.g = p.a().s0(UriProtector.parse(r8).getPath());     // Catch: Exception -> L40
        long r13 = e0.m().u(r12);     // Catch: Exception -> L40
        this.g.add(r7.getUrl());     // Catch: Exception -> L40
        tt5.a.h("PreloadImageExecutor", "preloadImages ret: " + r13);     // Catch: Exception -> L40
        c(r7.getUrl(), null);     // Catch: Exception -> L40
    L40:
        e = move-exception;
        tt5.a.d("PreloadImageExecutor", "consume() SubBlockModel ... e = " + e);
        a(r7.getUrl(), "", 1);
        goto L26
    L42:
        ArrayList r14 = new ArrayList();
        Iterator r17 = r2.iterator();
    L44:
        if (r17.hasNext() == false) goto L47;
        r14.add(((SubBlockModel) r17.next()).getUrl());
        goto L44
    L47:
        if (r14.isEmpty() == false) goto L49;
        tt5.a.h("PreloadImageExecutor", "batchDownloadDriveImage(): empty");
        return;
    L49:
        tt5.a.h("PreloadImageExecutor", "batchDownloadDriveImage()... with type = " + r16.c + " with token = " + du5.b.g(r16.b));
        ArrayList r18 = new ArrayList();
        Iterator r19 = r14.iterator();
    L51:
        if (r19.hasNext() == false) goto L60;
        String r20 = (String) r19.next();
        Pair<Boolean, Integer> r21 = this.n.a(r20);
        boolean r22 = ((Boolean) r21.first).booleanValue();
        if (r22 == false) goto L55;
        DownloadRequestInfo.DownloadType r23 = DownloadRequestInfo.DownloadType.COVER;
    L56:
        if (r22 == false) goto L58;
        int r24 = ((Integer) r21.second).intValue();
    L59:
        w85.a.C0319a r26 = new w85.a.C0319a();
        r26.d = r20;
        r26.b = r23;
        r26.k = new DownloadRequestInfo.b(r24, r24);
        r26.h = r16.b;
        r26.i = r16.c;
        r18.add(r26.a());
        goto L51
    L58:
        r24 = DriveCompressCheckerV2.CoverSize.ORIGINAL.size;
        goto L59
    L55:
        r23 = DownloadRequestInfo.DownloadType.IMG;
        goto L56
    L60:
        ((w85.c) org.koin.java.a.a(w85.c.class)).a(r18, this);
    }

    public final void m(u25.a r6) {
        String r1 = r6.a;
        String r2 = r6.b;
        List<SubBlockModel> r3 = r6.d;
        if (r3 != null) goto L5;
    L14:
        boolean r7 = true;
    L15:
        b r0 = new b(r1, r2, r7);
        BlockingQueue<c> r8 = this.d;     // Catch: Exception -> L20
        if (r8 == null) goto L25;
        ((LinkedBlockingQueue) r8).put(r0);     // Catch: Exception -> L20
        return;
    L25:
        return;
    L20:
        e = move-exception;
        tt5.a.e("PreloadImageExecutor", "pushResultUpdateJob... err happens : ", e, false);
        return;
    L5:
        if (r3.isEmpty() == true) goto L14;
        Set<String> r4 = r6.e;
        if (r4 != null) goto L11;
    L13:
        r7 = false;
        goto L15
    L11:
        if (r4.size() != r6.d.size()) goto L13;
        goto L13
    }

    public static void j(j r4, c r5) {
        r4.getClass();
    L14:
        e = move-exception;
        tt5.a.d("PreloadImageExecutor", "consume()... e = " + e);
        return;
    L4:
        if (r4.l == null) goto L17;
        if (r5 == null) goto L17;
        tt5.a.h("PreloadImageExecutor", "do image job, type = " + r5.a());     // Catch: Exception -> L14
        if (r5.a() != 0) goto L11;
        r4.k((u25.a) r5);     // Catch: Exception -> L14
        goto L17
    L11:
        if (r5.a() != 1) goto L17;
        l((b) r5);     // Catch: Exception -> L14
    L17:
    }

    @Override // w85.a.b
    public final void c(String r2, w85.b r3) {
        tt5.a.b("PreloadImageExecutor-ImgCb", "onDownloadSuccess(): url " + du5.b.g(r2));
        u25.a r4 = this.h.a(r2, true);
        if (r4 == null) goto L8;
        m(r4);
        Function1<u25.a, Unit> r5 = r4.g;
        if (r5 == null) goto L9;
        r5.invoke(r4);
        return;
    L9:
        return;
    }

    @Override // w85.a.b
    public final void a(String r2, String r3, int r4) {
        tt5.a.d("PreloadImageExecutor-ImgCb", "onDownloadFail(): url = " + du5.b.g(r2) + ",errorCode = " + r4);
        Set<String> r5 = this.g;
        if (r5 == null) goto L8;
        if (r5.contains(r2) == false) goto L8;
        this.g.remove(r2);
    L8:
        if (this.k.getNetworkState().a() == true) goto L10;
        this.e.add(r2);
        return;
    L10:
        u25.a r6 = this.h.a(r2, false);
        if (r6 == null) goto L15;
        m(r6);
        return;
    }
}

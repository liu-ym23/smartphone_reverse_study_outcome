package com.ss.android.lark.videosend.compress;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.monitor.MonitorModule;
import com.ss.android.lark.videosend.tools.CompressPathManager;
import com.ss.android.lark.videosend.tools.VideoTools;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f444936d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<com.ss.android.lark.videosend.compress.a> f444937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Long, Long> f444938b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f444939c;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f444940a = null;

        static {
            f444940a = new d();
        }
    }

    static {
    }

    public d() {
        this.f444937a = Collections.synchronizedList(new ArrayList());
        this.f444938b = Collections.synchronizedMap(new HashMap());
        this.f444939c = CoreThreadPool.getDefault().getSingleScheduledThreadPool("lk-media-compress");
    }

    public final synchronized void b(long r100) {
        monitor-enter(this);
        Iterator<com.ss.android.lark.videosend.compress.a> r101 = this.f444937a.iterator();     // Catch: Throwable -> L15
    L6:
        if (r101.hasNext() == false) goto L10;
        com.ss.android.lark.videosend.compress.a r102 = r101.next();     // Catch: Throwable -> L15
        if (r100 != r102.f444926a) goto L6;
    L11:
        if (r102 == null) goto L17;
        String r103 = "cancel: " + r100 + ", isPre: " + r102.f444933h;     // Catch: Throwable -> L15
        Log.i("MediaCompressDispatcher", r103);     // Catch: Throwable -> L15
        if (VideoTools.cancelCompressingTask(CompressPathManager.generateTempPath(r102.a())) == true) goto L17;
        r102.f444928c.b(new ErrorResult(r103));     // Catch: Throwable -> L15
    L17:
        Long r104 = this.f444938b.get(Long.valueOf(r100));     // Catch: Throwable -> L15
        if (r104 == null) goto L20;
        r100 = r104.longValue();     // Catch: Throwable -> L15
    L20:
        Map<Long, l> r105 = i.f444954a;     // Catch: Throwable -> L15
        i.b.f444957a.getClass();     // Catch: Throwable -> L15
        i.a(r100);     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L10:
        r102 = null;
    L15:
        th = move-exception;
        throw th;
    }

    public final synchronized void c(com.ss.android.lark.videosend.compress.a r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "param");     // Catch: Throwable -> L14
        Log.i("MediaCompressDispatcher", "add compress param: " + r100);     // Catch: Throwable -> L14
        if (this.f444937a.size() != 0) goto L7;
        boolean r101 = true;
    L8:
        e r102 = new e(r100.f444928c.d(), r100.f444926a, this);     // Catch: Throwable -> L14
        Intrinsics.checkNotNullParameter(r102, "<set-?>");     // Catch: Throwable -> L14
        r100.f444928c = r102;     // Catch: Throwable -> L14
        d(r100);     // Catch: Throwable -> L14
        if (r101 == false) goto L11;
        MonitorModule.e().f(MonitorModule.Business.messenger, "scene_media_compress");     // Catch: Throwable -> L14
        e(r100);     // Catch: Throwable -> L14
    L11:
        Log.i("MediaCompressDispatcher", "isIdled:" + r101);     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L7:
        r101 = false;
    L14:
        th = move-exception;
        throw th;
    }

    public final void d(com.ss.android.lark.videosend.compress.a r110) {
        long r100 = r110.f444926a;
        if (r110.f444933h == false) goto L5;
        Log.i("MediaCompressDispatcher", "enqueue pre task: " + r100);
        this.f444937a.add(r110);
    L32:
        Iterator<com.ss.android.lark.videosend.compress.a> r111 = this.f444937a.iterator();
        String r101 = "compress list:\n";
    L34:
        if (r111.hasNext() == false) goto L36;
        com.ss.android.lark.videosend.compress.a r102 = r111.next();
        r101 = r101 + "id=" + r102.f444926a + ",isPre=" + r102.f444933h + ';';
        goto L34
    L36:
        Log.i("MediaCompressDispatcher", r101);
        return;
    L5:
        Iterator<com.ss.android.lark.videosend.compress.a> r103 = this.f444937a.iterator();
        int r104 = 0;
        int r105 = 0;
    L7:
        if (r103.hasNext() == false) goto L12;
        if (r103.next().f444933h == true) goto L13;
        r105 = r105 + 1;
    L13:
        Log.i("MediaCompressDispatcher", "enqueue common task: " + r100 + ", first pre index: " + r105);
        if (r105 == (-1)) goto L31;
        if (r105 == 0) goto L17;
        ListProtector.add(this.f444937a, r105, r110);
        goto L32
    L17:
        com.ss.android.lark.videosend.compress.a r106 = (com.ss.android.lark.videosend.compress.a) CollectionsKt.firstOrNull(this.f444937a);
        if (r106 != null) goto L21;
        ListProtector.add(this.f444937a, r105, r110);
        goto L32
    L21:
        if (this.f444937a.size() <= 0) goto L23;
        boolean r107 = Intrinsics.areEqual(((com.ss.android.lark.videosend.compress.a) ListProtector.get(this.f444937a, 0)).a(), r110.a());
    L24:
        Log.i("MediaCompressDispatcher", r110.f444926a + " with first: " + ((com.ss.android.lark.videosend.compress.a) ListProtector.get(this.f444937a, 0)).f444926a + " is same task: " + r107);
        if (r107 == false) goto L28;
        r106.f444928c.h(r110.f444932g, r110.a());
        this.f444938b.put(Long.valueOf(r100), Long.valueOf(r106.f444926a));
        r106.f444926a = r100;
        r106.f444933h = false;
        m r108 = r110.f444928c;
        Intrinsics.checkNotNullParameter(r108, "<set-?>");
        r106.f444928c = r108;
        r106.f444932g = r110.f444932g;
        r106.f444931f = r110.f444931f;
        r106.f444935j = r110.f444935j;
        goto L32
    L28:
        if (this.f444937a.size() <= 0) goto L30;
        r104 = 1;
    L30:
        ListProtector.add(this.f444937a, r104, r110);
        b(r106.f444926a);
        goto L32
    L23:
        r107 = false;
        goto L24
    L31:
        this.f444937a.add(r110);
        goto L32
    L12:
        r105 = -1;
        goto L13
    }

    public final void e(com.ss.android.lark.videosend.compress.a r100) {
        Log.i("MediaCompressDispatcher", "perform compress: " + r100.f444926a + ", is pre: " + r100.f444933h);
        if (Intrinsics.areEqual(r100.f444930e, Boolean.TRUE) == false) goto L5;
        Runnable r101 = new MediaCompressUploadTask(r100);
    L6:
        Executor r102 = this.f444939c;
        if (r102 == null) goto L10;
        r102.execute(r101);
        return;
    L10:
        return;
    L5:
        r101 = new f(r100);
        goto L6
    }

    public static final void a(d r100, long r101) {
        Log.i("MediaCompressDispatcher", "removeCompressParam: " + r101);
        Iterator<com.ss.android.lark.videosend.compress.a> r102 = r100.f444937a.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        com.ss.android.lark.videosend.compress.a r103 = r102.next();
        if (r101 != r103.f444926a) goto L4;
    L9:
        r100.f444937a.remove(r103);
        return;
    L8:
        r103 = null;
        goto L9
    }
}

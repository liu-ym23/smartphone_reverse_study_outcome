package k27;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.mira.Mira;
import com.bytedance.mira.helper.PluginDirHelper;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.morpheus.mira.MiraMorpheusHelper$DownloadType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.depend.IDownloadInterceptor;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.impls.AbsDownloadEngine;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import h27.a;
import h27.c;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import l27.b;
import p27.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class d {
    public static final String e = null;
    public static volatile d f;
    public final Application a;
    public MiraMorpheusHelper$DownloadType b;
    public final Map<String, Integer> c;
    public final List<Integer> d;

    static {
        e = "morpheus-".concat(d.class.getSimpleName());
    }

    public static d b() {
        if (f != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f != null) goto L9;
        f = new d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return f;
    }

    public d() {
        this.b = MiraMorpheusHelper$DownloadType.CONCURRENCE;
        this.d = new ArrayList();
        this.a = a.b.b();
        a.getContext().getSharedPreferences("morpheus_pre_download", 0);
        this.c = new HashMap();
        List<String> r0 = Mira.getInstalledPackageNames();
        if (r0 == null) goto L8;
        Iterator<String> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        String r2 = r1.next();
        ((HashMap) this.c).put(r2 + "_" + Mira.getInstalledPluginVersion(r2), 0);
        goto L6
    L10:
        return;
    }

    public final void c(Context r7) {
        AbsDownloadEngine r0 = DownloadComponentManager.getDownloadEngine();
        monitor-enter(r0);
        Iterator r1 = ((ArrayList) this.d).iterator();     // Catch: Throwable -> L11
    L6:
        if (r1.hasNext() == false) goto L8;
        Integer r2 = (Integer) r1.next();     // Catch: Throwable -> L11
        e.c(r7.getApplicationContext()).b(r2);     // Catch: Throwable -> L11
        MiraLogger.d(e, "resumeAllPausedDownloadTask : id=" + r2);     // Catch: Throwable -> L11
        goto L6
    L8:
        ((ArrayList) this.d).clear();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final void d(String r3, int r4, int r5) {
        ((HashMap) this.c).put(r3 + "_" + r4, Integer.valueOf(r5));
    }

    public final void a(e r11, b r12, a r13, int r14, boolean r15) {
        IDownloadListener r0 = new c(r12, r11, r14, r15);
        IDownloadInterceptor r16 = new b(r12);
        a.b.getClass();
        if (this.b != MiraMorpheusHelper$DownloadType.QUEUE) goto L6;
        if (r14 == 1) goto L6;
        EnqueueType r1 = EnqueueType.ENQUEUE_TAIL;
    L7:
        a.b.getClass();
        ArrayList r2 = new ArrayList();
        if (TextUtils.isEmpty(null) == true) goto L10;
        r2.add(new HttpHeader("host", null));
    L10:
        DownloadTask r17 = Downloader.with(Mira.getAppContext()).onlyWifi(r12.j).savePath(PluginDirHelper.getDownloadDir()).monitorScene("morpheus_plugin_download").extraHeaders(r2).mimeType("mime_type_plugin").interceptor(r16).isOpenLimitSpeed(r12.o).enqueueType(r1).ignoreInterceptor(true);
        a.b.getClass();
        r17.mainThreadListener(r0);
        if (r13 != null) goto L13;
    L24:
        boolean r3 = false;
    L26:
        if (r3 == false) goto L33;
        if (TextUtils.isEmpty(r13.e) == false) goto L30;
        String r4 = r13.d;
    L31:
        r17.name(p27.b.a(r12.m, r12.a, r4, true)).url(r13.b).backUpUrls(r13.c).md5(r13.d).taskKey(r4).retryCount(5);
    L52:
        if (r11 == null) goto L54;
        r17.extra(r11.c());
    L55:
        int r18 = r17.download();
        a.b.getClass();
        if (r14 != 1) goto L83;
        Application r19 = this.a;
        AbsDownloadEngine r110 = DownloadComponentManager.getDownloadEngine();
        monitor-enter(r110);
        Iterator r111 = Downloader.getInstance(r19).getDownloadingDownloadInfosWithMimeType("mime_type_plugin").iterator();     // Catch: Throwable -> L80
    L61:
        if (r111.hasNext() == false) goto L78;
        DownloadInfo r112 = (DownloadInfo) r111.next();     // Catch: Throwable -> L80
        if (r112.getId() == r18) goto L61;
        e.c(r19.getApplicationContext()).a(Integer.valueOf(r112.getId()));     // Catch: Throwable -> L80
        ((ArrayList) this.d).add(Integer.valueOf(r112.getId()));     // Catch: Throwable -> L80
        MiraLogger.d(e, "pauseAllOtherDownloadTask : id=" + r112.getId() + " name=" + r112.getName() + " md5=" + r112.getMd5());     // Catch: Throwable -> L80
        String r5 = r112.getPackageName();     // Catch: Throwable -> L80
        int r6 = r112.getAppVersionCode();     // Catch: Throwable -> L80
        long r7 = r112.getTotalBytes();     // Catch: Throwable -> L80
        long r8 = r112.getCurBytes();     // Catch: Throwable -> L80
        c r9 = c.a();     // Catch: Throwable -> L80
        r9.getClass();     // Catch: Throwable -> L80
        if (r5 != null) goto L67;
        Logger.e(MiraLogger.TAG_DOWNLOAD, "modifyState ERROR: newState is null or newState.packageName is null.");     // Catch: Throwable -> L80
    L73:
        a.b.getClass();     // Catch: Throwable -> L80
        h27.d.a().c(r112.getName());     // Catch: Throwable -> L80
        goto L61
    L67:
        Map r10 = r9.c;     // Catch: Throwable -> L80
        monitor-enter(r10);     // Catch: Throwable -> L80
        i27.a r20 = (i27.a) ((HashMap) r9.c).get(r5);     // Catch: Throwable -> L75
        if (r20 == null) goto L72;
        r20.c = 10;     // Catch: Throwable -> L75
        r20.b = r6;     // Catch: Throwable -> L75
        r20.g = 0;     // Catch: Throwable -> L75
        r20.i = null;     // Catch: Throwable -> L75
        r20.h = null;     // Catch: Throwable -> L75
        r20.e = r8;     // Catch: Throwable -> L75
        r20.d = r7;     // Catch: Throwable -> L75
    L72:
        monitor-exit(r10);     // Catch: Throwable -> L75
        goto L73
    L75:
        th = move-exception;
        throw th;     // Catch: Throwable -> L80
    L78:
        monitor-exit(r110);     // Catch: Throwable -> L80
        return;
    L80:
        th = move-exception;
        throw th;
    L83:
        return;
    L54:
        r17.extra(new e(r3).c());
        goto L55
    L30:
        r4 = r13.e;
        goto L31
    L33:
        if (TextUtils.isEmpty(r12.f) == false) goto L35;
        String r113 = r12.e;
    L36:
        r17.name(p27.b.a(r12.m, r12.a, r113, false)).url(r12.c).backUpUrls(r12.d).md5(r12.e).taskKey(r113);
        n27.c r114 = n27.c.c();
        String r21 = r12.c;
        r114.getClass();
        boolean r115 = new URL(r21).getPath().startsWith("/v1/resource");     // Catch: MalformedURLException -> L39
    L41:
        if (r115 == true) goto L43;
        r17.retryCount(5);
        goto L52
    L43:
        List r116 = r12.d;
        if (r116 == null) goto L52;
        if (((ArrayList) r116).isEmpty() == true) goto L52;
        String r117 = (String) ListProtector.get(r12.d, 0);
        n27.c.c().getClass();
        String r118 = new URL(r117).getHost();     // Catch: Throwable -> L50
    L51:
        r2.add(new HttpHeader("X-Origin-Server-Host", r118));
        r17.extraHeaders(r2);
    L50:
        r118 = null;
    L39:
        e = move-exception;
        e.printStackTrace();
        r115 = false;
        goto L41
    L35:
        r113 = r12.f;
        goto L36
    L13:
        if (TextUtils.isEmpty(r13.b) == false) goto L17;
        if (r13.c.isEmpty() == false) goto L17;
    L21:
        boolean r22 = false;
    L22:
        if (r22 == false) goto L24;
        r3 = true;
    L17:
        if (TextUtils.isEmpty(r13.d) == true) goto L21;
        if (r13.f <= 0) goto L21;
        r22 = true;
    L6:
        r1 = EnqueueType.ENQUEUE_NONE;
        goto L7
    }
}

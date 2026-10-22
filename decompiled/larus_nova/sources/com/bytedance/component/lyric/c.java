package com.bytedance.component.lyric;

import android.content.Context;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.mediakit.medialoader.AVMDLDataLoaderConfigure;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import jg4.j;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements jg4.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DownloadTask f202992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f202993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f202994c;

    public static final class a extends AbsDownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j f202995a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final jg4.d f202996b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final b f202997c;

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onCanceled(DownloadInfo r100) {
            super.onCanceled(r100);
            this.f202996b.e(this.f202995a);
            this.f202997c.f202998a = false;
            kg4.a.b("LyricDownloadListener ;; onCanceled entity = " + r100);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onPause(DownloadInfo r100) {
            super.onPause(r100);
            kg4.a.b("LyricDownloadListener ;; onPause entity = " + r100);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onProgress(DownloadInfo r100) {
            if (r100 != null) goto L4;
            return;
        L4:
            if (r100.getTotalBytes() == 0) goto L8;
            kg4.a.b("LyricDownloadListener ;; downLoadProgress = " + ((r100.getCurBytes() / r100.getTotalBytes()) * ((long) 100)));
            return;
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onSuccessed(DownloadInfo r100) {
            super.onSuccessed(r100);
            this.f202996b.g(this.f202995a);
            this.f202997c.f202998a = false;
            kg4.a.b("LyricDownloadListener ;; onSuccessed entity = " + r100);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onFailed(DownloadInfo r100, BaseException r101) {
            Intrinsics.checkNotNullParameter(r101, "e");
            super.onFailed(r100, r101);
            jg4.d r102 = this.f202996b;
            j r103 = this.f202995a;
            int r104 = r101.getErrorCode();
            String r105 = r101.getErrorMessage();
            if (r105 != null) goto L5;
            r105 = "";
        L5:
            r102.h(r103, r104, r105);
            this.f202997c.f202998a = false;
            kg4.a.b("LyricDownloadListener ;; onFailed entity = " + r100 + ", e = " + r101);
        }

        public a(Context r100, j r101, jg4.d r102, b r103) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "request");
            Intrinsics.checkNotNullParameter(r102, "callback");
            Intrinsics.checkNotNullParameter(r103, "lyricDownloadState");
            this.f202995a = r101;
            this.f202996b = r102;
            this.f202997c = r103;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f202998a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == true) goto L6;
            return false;
        L6:
            if (this.f202998a == ((b) r100).f202998a) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            boolean r100 = this.f202998a;
            if (r100 == false) goto L6;
            return 1;
        L6:
            return r100 ? 1 : 0;
        }

        public final String toString() {
            return "LyricDownloadState(isDownLoading=" + this.f202998a + ")";
        }

        public b() {
            this.f202998a = false;
        }
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class d() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.ss.android.socialbase.downloader.model.DownloadTask");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.ss.android.socialbase.downloader.model.DownloadTask");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.ss.android.socialbase.downloader.model.DownloadTask");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.ss.android.socialbase.downloader.model.DownloadTask");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.ss.android.socialbase.downloader.model.DownloadTask");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.ss.android.socialbase.downloader.model.DownloadTask");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.ss.android.socialbase.downloader.model.DownloadTask");
    }

    @Override // jg4.e
    public final boolean b() {
        return this.f202993b.f202998a;
    }

    public final Context getContext() {
        return this.f202994c;
    }

    public c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f202994c = r100;
        this.f202993b = new b();
    }

    @Override // jg4.e
    public final void c(j r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        this.f202993b.f202998a = false;
        Integer r101 = r100.f498986b;
        if (r101 == null) goto L5;
        int r102 = r101.intValue();
        Downloader.getInstance(this.f202994c).cancel(r102);
    L5:
        this.f202992a = null;
    }

    @Override // jg4.e
    public final void a(j r100, jg4.d r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "callback");
        c(r100);
        kg4.a.b("开始下载");
        this.f202993b.f202998a = true;
        DownloadTask r102 = Downloader.with(this.f202994c).url(r100.f498994j).name(r100.f498996l).savePath(r100.f498995k).monitorScene("musicpack_lyrics");
        this.f202992a = r102;
        if (r102 == null) goto L17;
        r102.autoRemoveCallback(true);
    L17:
        Class r103 = d();     // Catch: Exception -> L7
        Object r104 = r103.newInstance();     // Catch: Exception -> L7
        Method r105 = r103.getDeclaredMethod("setCacheLifeTimeMax", new Class[0]);     // Catch: Exception -> L7
        r105.setAccessible(true);     // Catch: Exception -> L7
        r105.invoke(r104, new Object[]{Integer.valueOf(AVMDLDataLoaderConfigure.DEFAULT_MAX_CACHE_AGE)});     // Catch: Exception -> L7
    L9:
        a r106 = new a(this.f202994c, r100, r101, this.f202993b);
        DownloadTask r107 = this.f202992a;
        if (r107 == null) goto L14;
        DownloadTask r108 = r107.subThreadListener(r106);
        if (r108 == null) goto L14;
        Integer r109 = Integer.valueOf(r108.download());
    L15:
        r100.f498986b = r109;
        return;
    L14:
        r109 = null;
    L7:
        e = move-exception;
        kg4.a.b("set cache life time max fail : " + e.getMessage());
        goto L9
    }
}

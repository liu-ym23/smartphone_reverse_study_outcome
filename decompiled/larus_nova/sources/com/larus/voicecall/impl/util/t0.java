package com.larus.voicecall.impl.util;

import com.bytedance.keva.Keva;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.platform.IFlowSdkDepend;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: classes32.dex */
public final class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t0 f379475a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f379476b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Keva f379477c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f379478d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicBoolean f379479e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f379480f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f379481g = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f379482a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f379483b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f379484c;

        public final String toString() {
            return "url:" + this.f379482a + ",channel:" + this.f379483b + ",saveKey:" + this.f379484c;
        }

        public a(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "url");
            Intrinsics.checkNotNullParameter(r101, "channel");
            Intrinsics.checkNotNullParameter("PATH_KEY_BALL_BIG_VIDEO", "saveKey");
            this.f379482a = r100;
            this.f379483b = r101;
            this.f379484c = "PATH_KEY_BALL_BIG_VIDEO";
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f379485a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f379486b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f379487c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f379488d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f379489e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f379490f;

        public final boolean a() {
            String r100 = this.f379489e;
            if (r100 != null) goto L5;
            t0 r101 = t0.f379475a;
            String r102 = this.f379485a;
            r101.getClass();
            if (t0.f(r102) == true) goto L17;
            return false;
        L17:
            if (this.f379487c > 0) goto L19;
            return false;
        L19:
            if (this.f379488d <= 0) goto L27;
        L20:
            return true;
        L27:
            return false;
        L5:
            if (r100.length() <= 0) goto L7;
            boolean r103 = true;
        L8:
            if (r103 == true) goto L10;
            return false;
        L10:
            if (this.f379487c > 0) goto L12;
            return false;
        L12:
            if (this.f379488d > 0) goto L20;
            return false;
        L7:
            r103 = false;
            goto L8
        }

        public final String toString() {
            return "localUri:" + this.f379485a + ",networkUrl:" + this.f379489e + ",firstFrame:" + this.f379486b + ",width:" + this.f379487c + ",height:" + this.f379488d;
        }

        public /* synthetic */ b(String r100, int r101, int r110, int r111) {
            this(r100, r101, r110, r111, null, null);
        }

        public b(String r100, int r101, int r102, int r103, String r104, String r105) {
            Intrinsics.checkNotNullParameter(r100, "localUri");
            this.f379485a = r100;
            this.f379486b = r101;
            this.f379487c = r102;
            this.f379488d = r103;
            this.f379489e = r104;
            this.f379490f = r105;
        }
    }

    public t0() {
    }

    static {
        f379475a = new t0();
        f379476b = LazyKt.lazy(new r0());
        f379477c = Keva.getRepo("REALTIME_BIG_VIDEO_PATH");
        f379478d = LazyKt.lazy(new s0());
        f379479e = new AtomicBoolean(false);
        File r100 = e(AppHost.f326268a.getApplication().getCacheDir().getPath() + "/realtime");
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.getPath();
    L6:
        String r103 = "";
        if (r102 != null) goto L9;
        r102 = "";
    L9:
        File r104 = e(r102.concat("/video"));
        if (r104 == null) goto L12;
        r101 = r104.getPath();
    L12:
        if (r101 == null) goto L15;
        r103 = r101;
    L15:
        String r105 = r103.concat("/bg_small_video.mp4");
        String r106 = r103.concat("/ball_small_video.mp4");
        f379480f = new b(r105, R.drawable.larus_bg_realtime_small_video_frame, 400, 866);
        int r107 = 480;
        f379481g = new b(r106, R.drawable.larus_ball_small_video_frame, r107, r107);
        return;
    L5:
        r102 = null;
        goto L6
    }

    public static b c() {
        String r100 = f379477c.getString("PATH_KEY_BALL_BIG_VIDEO", "");
        Intrinsics.checkNotNull(r100);
        int r101 = 900;
        return new b(r100, R.drawable.larus_ball_small_video_frame, r101, r101);
    }

    public static b d() {
        Lazy r100 = f379478d;
        if (((Boolean) r100.getValue()).booleanValue() == false) goto L8;
        if (c().a() == false) goto L8;
        return c();
    L8:
        if (((Boolean) r100.getValue()).booleanValue() == true) goto L10;
    L13:
        b r101 = f379481g;
        if (r101.a() == true) goto L22;
        b("ball_small_video.mp4", r101.f379485a);
        if (r101.a() == false) goto L20;
        return r101;
    L20:
        return null;
    L22:
        return r101;
    L10:
        if (f379479e.getAndSet(true) == true) goto L13;
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new RealtimeDiskExt$preloadBigVideoIfNeed$1(null), 2, null);
        goto L13
    }

    public static File e(String r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L7
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);     // Catch: Throwable -> L7
        if (r102.exists() == true) goto L5;
        r102.mkdirs();     // Catch: Throwable -> L7
    L5:
        Object r103 = Result.m9449constructorimpl(r102);     // Catch: Throwable -> L7
    L10:
        if (Result.m9455isFailureimpl(r103) == false) goto L13;
        r103 = null;
    L13:
        return (File) r103;
    L7:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public static boolean f(String r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L8
        if (new PolarisFileWrapper(r100).exists() == true) goto L6;
        return false;
    L6:
        Object r102 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 != null) goto L14;
        return true;
    L14:
        FLogger.f375446a.e("RealtimeDiskExt", "isFileExits failed:" + r103);
        return false;
    L8:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public static final void a(t0 r100, a r101) {
        r100.getClass();
        long r102 = System.currentTimeMillis();
        IFlowSdkDepend r103 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r103 == null) goto L5;
        r103.a0();
        String r104 = com.larus.home.impl.sdk.g.f346177a.c(r101.f379482a, r101.f379483b, false);
    L6:
        if (r104 != null) goto L8;
        r104 = "";
    L8:
        boolean r105 = f(r104);
        if (r105 == false) goto L11;
        f379477c.storeString(r101.f379484c, r104);
    L11:
        long r106 = System.currentTimeMillis() - r102;
        FLogger.f375446a.i("RealtimeDiskExt", "loadSyncGeckoResource, config:" + r101 + ",isSuccess:" + r105 + ",costTime:" + r106);
        return;
    L5:
        r104 = null;
        goto L6
    }

    public static void b(String r100, String r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L19
        long r103 = System.currentTimeMillis();     // Catch: Throwable -> L19
        PolarisFileWrapper r104 = new PolarisFileWrapper(r101);     // Catch: Throwable -> L19
        InputStream r105 = AppHost.f326268a.getApplication().getAssets().open(r100);     // Catch: Throwable -> L19
        PolarisFileOutputStreamWrapper r106 = new PolarisFileOutputStreamWrapper(r104);     // Catch: Throwable -> L14
        Intrinsics.checkNotNull(r105);     // Catch: Throwable -> L9
        ByteStreamsKt.copyTo$default(r105, r106, 0, 2, null);     // Catch: Throwable -> L9
        CloseableKt.closeFinally(r106, null);     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r105, null);     // Catch: Throwable -> L19
        long r107 = System.currentTimeMillis() - r103;     // Catch: Throwable -> L19
        FLogger.f375446a.i("RealtimeDiskExt", "copyFromAssets, costTime:" + r107);     // Catch: Throwable -> L19
        Object r108 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L19
    L21:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L34;
        String r110 = r109.toString();
        yp9.d.f568725b.a("RealtimeDiskExt", r110);
        FLogger.f375446a.e("RealtimeDiskExt", "copy from asset failed:" + r110);
        return;
    L34:
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        CloseableKt.closeFinally(r106, th);     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        CloseableKt.closeFinally(r105, th);     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    }
}

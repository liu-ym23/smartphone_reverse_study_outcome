package com.larus.share.impl.sdk.special;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.bigimg.ImageSave;
import com.larus.bmhome.bigimg.i1;
import com.larus.bmhome.creative.CreativeScene;
import com.larus.bmhome.share.panel.ShareChannel;
import com.larus.common_ui.dialog.l0;
import com.larus.platform.api.z3;
import com.larus.platform.service.DownloadWatermarkService;
import com.larus.platform.service.q3;
import com.larus.platform.service.watermark.DownloadWatermarkScene;
import com.larus.platform.service.watermark.WatermarkPerfLogger;
import com.larus.platform.service.z2;
import com.larus.share.impl.util.f;
import com.larus.utils.logger.FLogger;
import com.larus.utils.r;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: classes31.dex */
public final class ShareImageSpecialHandler {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f368736b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, i<String>> f368737a;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f368738a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f368739b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f368738a, r101.f368738a) == true) goto L12;
            return false;
        L12:
            if (this.f368739b == r101.f368739b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f368738a.hashCode() * 31;
            if (this.f368739b == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "ShareVideoSaveResult(path=" + this.f368738a + ", mdlCacheHit=" + this.f368739b + ')';
        }

        public b(String r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "path");
            this.f368738a = r100;
            this.f368739b = r101;
        }
    }

    public static String k(int r100) {
        if (r100 != 1) goto L5;
        return "image";
    L5:
        if (r100 != 2) goto L7;
        return CreativeScene.IMAGE_TO_IMAGE;
    L7:
        if (r100 != 4) goto L9;
        return "music";
    L9:
        if (r100 != 5) goto L11;
        return CreativeScene.AVATAR_IMAGE;
    L11:
        if (r100 != 6) goto L13;
        return "video";
    L13:
        if (r100 == 7) goto L15;
        return "";
    L15:
        return CreativeScene.AI_BEAUTIFY_IMAGE;
    }

    static {
        f368736b = CollectionsKt.listOf(new String[]{ShareChannel.SAVE_IMAGE, ShareChannel.SAVE_VIDEO, "more"});
    }

    public ShareImageSpecialHandler() {
        this.f368737a = new ConcurrentHashMap();
    }

    public static void a(l0 r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L17;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public static final String c(ShareImageSpecialHandler r100, String r101) {
        r100.getClass();
        StringCompanionObject r102 = StringCompanionObject.INSTANCE;
        return String.format(Locale.getDefault(), "%d_%d.%s", Arrays.copyOf(new Object[]{Long.valueOf(System.currentTimeMillis()), Long.valueOf(Math.abs(r101.hashCode())), "mp4"}, 3));
    }

    public static final WatermarkPerfLogger.a b(ShareImageSpecialHandler r100, String r101, com.larus.bmhome.share.panel.b r102) {
        r100.getClass();
        FLogger.f375446a.i("ShareImageSpecialHandler", "video share perf, videUrl = ".concat(r101));
        if (r102.f313880w != null) goto L5;
        return null;
    L5:
        DownloadWatermarkService.f365700a.getClass();
        boolean r103 = DownloadWatermarkService.d();
        int r104 = WatermarkPerfLogger.f365828a;
        if (r103 == false) goto L8;
        WatermarkPerfLogger.Version r105 = WatermarkPerfLogger.Version.ENTERPRISE;
    L9:
        WatermarkPerfLogger.a r106 = WatermarkPerfLogger.a("creation_video_share", r105, DownloadWatermarkScene.CI_GEN_VIDEO_SHARE);
        if (r103 == true) goto L12;
    L17:
        WatermarkPerfLogger.Path r107 = WatermarkPerfLogger.Path.NONE;
    L18:
        r106.c(r107);
        return r106;
    L12:
        if (r101.length() <= 0) goto L14;
        boolean r108 = true;
    L15:
        if (r108 == false) goto L17;
        r107 = WatermarkPerfLogger.Path.A;
        goto L18
    L14:
        r108 = false;
        goto L15
    L8:
        r105 = WatermarkPerfLogger.Version.PERSONAL;
        goto L9
    }

    public static final void d(ShareImageSpecialHandler r100, int r101, String r102) {
        i<String> r103 = r100.f368737a.remove(Integer.valueOf(r101));
        if (r103 != null) goto L6;
        return;
    L6:
        if (r103.isActive() == false) goto L11;
        r103.resumeWith(Result.m9449constructorimpl(r102));
        return;
    }

    public static final void g(ShareImageSpecialHandler r100, Context r101, String r102) {
        r100.getClass();
        PolarisFileWrapper r103 = new PolarisFileWrapper(r102);
        String r104 = i1.b() + File.separator + System.currentTimeMillis() + ".mp4";
        PolarisFileWrapper r105 = new PolarisFileWrapper(r104);
        PolarisFileInputStreamWrapper r106 = null;
        PolarisFileInputStreamWrapper r107 = new PolarisFileInputStreamWrapper(r103);     // Catch: Throwable -> L23 Exception -> L25
        BufferedOutputStream r108 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r105));     // Catch: Throwable -> L17 Exception -> L20
    L57:
        byte[] r109 = new byte[1024];     // Catch: Throwable -> L13 Exception -> L15
    L7:
        int r110 = r107.read(r109);     // Catch: Throwable -> L13 Exception -> L15
        if (r110 <= 0) goto L10;
        r108.write(r109, 0, r110);     // Catch: Throwable -> L13 Exception -> L15
        goto L7
    L10:
        r.u(r101, r104, false);     // Catch: Throwable -> L13 Exception -> L15
        r107.close();     // Catch: IOException -> L30
    L33:
        r108.close();     // Catch: IOException -> L30
        return;
    L15:
        e = e;
    L22:
        r106 = r107;
    L48:
        FLogger.f375446a.e("ShareImageSpecialHandler", "saveVideoToAlbumBeforeQ failed", e);     // Catch: Throwable -> L37
        if (r106 == null) goto L32;
        r106.close();     // Catch: IOException -> L30
    L32:
        if (r108 != null) goto L33;
        return;
    L37:
        th = th;
        r107 = r106;
    L19:
        r106 = r107;
    L39:
        if (r106 != null) goto L52;
    L43:
        if (r108 == null) goto L47;
        r108.close();     // Catch: IOException -> L41
    L41:
        e = move-exception;
        FLogger.f375446a.e("ShareImageSpecialHandler", "finally close stream failed", e);
    L47:
        throw th;
    L52:
        r106.close();     // Catch: IOException -> L41
    L13:
        th = th;
    L20:
        e = e;
        r108 = null;
    L17:
        th = th;
        r108 = null;
        goto L19
    L30:
        e = move-exception;
        FLogger.f375446a.e("ShareImageSpecialHandler", "finally close stream failed", e);
        return;
    L25:
        e = e;
        r108 = null;
    L23:
        th = th;
        r108 = null;
        goto L39
    }

    public static String h(String r110, String r111, String r112) {
        if (r111.length() != 0) goto L5;
        boolean r100 = true;
    L6:
        Object r101 = null;
        if (r100 == false) goto L9;
    L35:
        FLogger.f375446a.i("ShareImageSpecialHandler", "[copyMdlCacheFile] local file miss, key=" + r110 + ", localPath=" + r111);
        return null;
    L9:
        if (new PolarisFileWrapper(r111).exists() == false) goto L35;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L21
        PolarisFileWrapper r103 = new PolarisFileWrapper(r112);     // Catch: Throwable -> L21
        File r113 = r103.getParentFile();     // Catch: Throwable -> L21
        if (r113 != null) goto L14;
    L19:
        FilesKt.copyTo$default(new PolarisFileWrapper(r111), r103, true, 0, 4, null);     // Catch: Throwable -> L21
        Object r114 = Result.m9449constructorimpl(r103.getAbsolutePath());     // Catch: Throwable -> L21
    L24:
        if (Result.m9456isSuccessimpl(r114) == false) goto L26;
        FLogger.f375446a.i("ShareImageSpecialHandler", "[copyMdlCacheFile] hit, key=" + r110 + ", path=" + ((String) r114));
    L26:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);
        if (r115 == null) goto L30;
        FLogger.f375446a.e("ShareImageSpecialHandler", "[copyMdlCacheFile] copy failed, key=" + r110 + ", " + r115);
    L30:
        if (Result.m9455isFailureimpl(r114) == true) goto L34;
        r101 = r114;
    L34:
        return (String) r101;
    L14:
        if ((true ^ r113.exists()) == true) goto L17;
        r113 = null;
    L17:
        if (r113 == null) goto L19;
        r113.mkdirs();     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L24
    L5:
        r100 = false;
        goto L6
    }

    public static final Object e(ShareImageSpecialHandler r110, String r111, String r112, String r113, Continuation r114) {
        r110.getClass();
        if ((r114 instanceof ShareImageSpecialHandler$saveVideoByMdlCache$1) == false) goto L7;
        ShareImageSpecialHandler$saveVideoByMdlCache$1 r100 = (ShareImageSpecialHandler$saveVideoByMdlCache$1) r114;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r115 = r100.result;
        Object r116 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = r100.label;
        boolean r103 = false;
        if (r102 == 0) goto L14;
        if (r102 != 1) goto L13;
        r113 = (String) r100.L$1;
        r111 = (String) r100.L$0;
        ResultKt.throwOnFailure(r115);
    L83:
        String r117 = (String) r115;
        if (r117 != null) goto L86;
    L87:
        r103 = true;
    L88:
        if (r103 == false) goto L90;
        FLogger.f375446a.i("ShareImageSpecialHandler", "[saveVideoByMdlCache] mdl download failed, key=" + r111);
    L94:
        return null;
    L90:
        String r118 = h(r111, r117, r113);
        if (r118 == null) goto L94;
        return new b(r118, true);
    L86:
        if (r117.length() != 0) goto L88;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r115);
        if (r111 != null) goto L17;
    L20:
        boolean r119 = true;
    L21:
        if (r119 == true) goto L94;
        if (r111 != null) goto L25;
    L28:
        boolean r120 = true;
    L29:
        if (r120 == false) goto L95;
    L74:
        String r121 = null;
    L75:
        if (r121 != null) goto L97;
        z2 r122 = z2.f365865a;
        if (r122.enableVideoDownloadMdl() == true) goto L80;
        FLogger.f375446a.i("ShareImageSpecialHandler", "[saveVideoByMdlCache] mdl download disabled, key=" + r111);
        goto L94
    L80:
        long r104 = r122.getCreationVideoMdlDownloadTimeoutMs();
        ShareImageSpecialHandler$saveVideoByMdlCache$downloadedLocalFilePath$1 r123 = new ShareImageSpecialHandler$saveVideoByMdlCache$downloadedLocalFilePath$1(r112, r111, null);
        r100.L$0 = r111;
        r100.L$1 = r113;
        r100.label = 1;
        r115 = TimeoutKt.c(r104, r123, r100);
        if (r115 != r116) goto L83;
        return r116;
    L97:
        return new b(r121, true);
    L95:
        Result.Companion r124 = Result.Companion;     // Catch: Throwable -> L37
        Lazy r125 = q3.f365794a;     // Catch: Throwable -> L37
        z3 r126 = q3.a();     // Catch: Throwable -> L37
        if (r126 == null) goto L34;
        yq9.a r127 = r126.g(r111);     // Catch: Throwable -> L37
    L35:
        Object r128 = Result.m9449constructorimpl(r127);     // Catch: Throwable -> L37
    L39:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r128);
        if (r105 == null) goto L43;
        FLogger.f375446a.e("ShareImageSpecialHandler", "[copyCompleteMdlCache] get cache failed, key=" + r111 + ", " + r105);
    L43:
        if (Result.m9455isFailureimpl(r128) == false) goto L45;
        r128 = null;
    L45:
        yq9.a r129 = (yq9.a) r128;
        if (r129 == null) goto L48;
        String r106 = r129.f568862c;
    L49:
        if (r129 == null) goto L65;
        long r107 = r129.f568860a;
        if (r107 <= 0) goto L65;
        if (r129.f568861b < r107) goto L65;
        if (r106 != null) goto L56;
    L59:
        boolean r108 = true;
    L60:
        if (r108 == true) goto L65;
        if (new PolarisFileWrapper(r106).exists() == false) goto L65;
        r121 = h(r111, r106, r113);
        goto L75
    L56:
        if (r106.length() == 0) goto L59;
        r108 = false;
    L65:
        FLogger r109 = FLogger.f375446a;
        StringBuilder r130 = new StringBuilder("[copyCompleteMdlCache] miss, key=");
        r130.append(r111);
        r130.append(", mediaSize=");
        if (r129 == null) goto L68;
        Long r131 = Long.valueOf(r129.f568860a);
    L69:
        r130.append(r131);
        r130.append(", cacheSize=");
        if (r129 == null) goto L72;
        Long r132 = Long.valueOf(r129.f568861b);
    L73:
        r130.append(r132);
        r130.append(", localPath=");
        r130.append(r106);
        r109.i("ShareImageSpecialHandler", r130.toString());
        goto L74
    L72:
        r132 = null;
        goto L73
    L68:
        r131 = null;
        goto L69
    L48:
        r106 = null;
        goto L49
    L34:
        r127 = null;
    L37:
        th = move-exception;
        Result.Companion r133 = Result.Companion;
        r128 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L39
    L25:
        if (r111.length() == 0) goto L28;
        r120 = false;
        goto L29
    L17:
        if (r111.length() == 0) goto L20;
        r119 = false;
    L7:
        r100 = new ShareImageSpecialHandler$saveVideoByMdlCache$1(r110, r114);
        goto L8
    }

    public static final Object f(ShareImageSpecialHandler r100, Context r101, String r102, String r103, Continuation r104) {
        r100.getClass();
        j r105 = new j(IntrinsicsKt.intercepted(r104), 1);
        r105.C();
        Ref.IntRef r106 = new Ref.IntRef();
        DownloadTask r107 = Downloader.with(r101).url(r102).savePath(r103).name(System.currentTimeMillis() + ".mp4").subThreadListener(new d(r100, r106));
        int r108 = r107.getDownloadId();
        r106.element = r108;
        r100.f368737a.put(Boxing.boxInt(r108), r105);
        r105.i(new c(r100, r106, r101));
        r107.asyncDownload(null);
        Object r109 = r105.B();
        if (r109 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r104);
    L5:
        return r109;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean i(Context r210, final String r211, final String r212, final com.larus.bmhome.share.panel.b r213, final boolean r214, final Function1<? super Integer, Unit> r215) {
        Intrinsics.checkNotNullParameter(r213, "shareContent");
        boolean r100 = false;
        if (r213.f313875r == true) goto L6;
        FLogger.f375446a.i("ShareImageSpecialHandler", "isShareOriginImage false so not take effect");
        return false;
    L6:
        Unit r110 = null;
        if ((r210 instanceof LifecycleOwner) == false) goto L9;
        LifecycleOwner r101 = (LifecycleOwner) r210;
    L10:
        if (r101 == null) goto L14;
        CoroutineScope r102 = LifecycleOwnerKt.getLifecycleScope(r101);
        if (r102 == null) goto L14;
    L15:
        CoroutineScope r111 = r102;
        if (r210 == 0) goto L18;
        WeakReference r103 = new WeakReference(r210);
    L19:
        int r104 = f.f368775a;
        if (f.a(r213.f313858a) == true) goto L22;
        Bitmap r105 = r213.f313859b;
        if (r105 != null) goto L67;
    L73:
        return false;
    L67:
        if (r105.isRecycled() != true) goto L69;
        boolean r112 = true;
    L70:
        if (r112 == true) goto L73;
        final WeakReference r106 = r103;
        ImageSave.z(ImageSave.f295932a, "", r213.f313859b, r213.f313873p, null, r213.f313874q, false, r111, new com.larus.share.impl.sdk.special.b(r106, this, r211, r212, r213, r214, r215), 40);
        return true;
    L69:
        r112 = false;
        goto L70
    L22:
        if ((r210 instanceof Activity) == false) goto L24;
        l0 r107 = new l0(r210, 0.0f, false, 6);
    L25:
        if (r107 == null) goto L27;
        r107.setCancelable(true);
    L27:
        if (r214 == false) goto L34;
        if (r107 == null) goto L34;
        if (DialogLancet.shouldBlockDialogShow(r107) == false) goto L81;
        DialogLancet.handleBlockedDialogShow(r107);
        goto L34
    L81:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L74
    L33:
        DialogLancet.beforeDialogShow(r107);
        r107.show();
        DialogLancet.afterDialogShow(r107);
    L34:
        if (r107 == null) goto L36;
        WeakReference r216 = new WeakReference(r107);
    L37:
        FLogger r108 = FLogger.f375446a;
        StringBuilder r109 = new StringBuilder("loadingDialog is not null ");
        if (r107 == null) goto L40;
        r100 = true;
    L40:
        r109.append(r100);
        r109.append(" show");
        r108.i("ShareImageSpecialHandler", r109.toString());
        String r113 = r213.f313858a;
        if (r113 != null) goto L43;
        r113 = "";
    L43:
        String r114 = r113;
        Integer r115 = r213.f313880w;
        ImageSave r116 = ImageSave.f295932a;     // Catch: Exception -> L50
        Map<String, String> r117 = r213.f313873p;     // Catch: Exception -> L50
        ShareImageSpecialHandler$handleShareImage$1 r118 = new ShareImageSpecialHandler$handleShareImage$1(r114, r115, this, r213, null);     // Catch: Exception -> L50
        boolean r119 = r213.f313874q;     // Catch: Exception -> L50
        final WeakReference r120 = r103;
        final WeakReference r121 = r216;
        Function1 r122 = new com.larus.share.impl.sdk.special.a(r120, this, r213, r211, r212, r214, r215, r121);     // Catch: Exception -> L50
        boolean r123 = true;
        ImageSave.z(r116, r114, null, r117, r118, r119, false, r111, r122, 34);     // Catch: Exception -> L48
    L63:
        return r123;
    L48:
        e = e;
    L52:
        Exception r124 = e;
        Result.Companion r125 = Result.Companion;     // Catch: Throwable -> L60
        if (r216 == null) goto L58;
        l0 r126 = (l0) r216.get();     // Catch: Throwable -> L60
        if (r126 == null) goto L58;
        a(r126);     // Catch: Throwable -> L60
        r110 = Unit.INSTANCE;     // Catch: Throwable -> L60
    L58:
        Result.m9449constructorimpl(r110);     // Catch: Throwable -> L60
    L62:
        FLogger.f375446a.i("ShareImageSpecialHandler", "loadingDialog dismiss due to exception: " + r124.getMessage());
    L60:
        th = move-exception;
        Result.Companion r127 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L50:
        e = e;
        r123 = true;
        goto L52
    L36:
        r216 = null;
        goto L37
    L24:
        r107 = null;
        goto L25
    L18:
        r103 = null;
    L14:
        r102 = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        goto L15
    L9:
        r101 = null;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean j(Context r110, String r111, String r112, com.larus.bmhome.share.panel.b r113, boolean r210, Function1<? super Integer, Unit> r211) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r113, "shareContent");
        int r100 = f.f368775a;
        boolean r101 = false;
        if (f.a(r113.f313862e) == true) goto L5;
        return false;
    L5:
        LifecycleOwner r102 = null;
        if ((r110 instanceof Activity) == false) goto L8;
        l0 r103 = new l0(r110, 0.0f, false, 6);
    L10:
        if (r103 == null) goto L12;
        r103.setCancelable(true);
    L12:
        if (r210 == false) goto L19;
        if (r103 == null) goto L19;
        if (DialogLancet.shouldBlockDialogShow(r103) == false) goto L36;
        DialogLancet.handleBlockedDialogShow(r103);
        goto L19
    L36:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L35
    L18:
        DialogLancet.beforeDialogShow(r103);
        r103.show();
        DialogLancet.afterDialogShow(r103);
    L19:
        if (r103 == null) goto L21;
        WeakReference r104 = new WeakReference(r103);
    L22:
        FLogger r105 = FLogger.f375446a;
        StringBuilder r106 = new StringBuilder("[handleShareVideo] loadingDialog is not null ");
        if (r103 == null) goto L25;
        r101 = true;
    L25:
        r106.append(r101);
        r106.append(" show");
        r105.i("ShareImageSpecialHandler", r106.toString());
        if ((r110 instanceof LifecycleOwner) == false) goto L28;
        r102 = (LifecycleOwner) r110;
    L28:
        if (r102 == null) goto L32;
        CoroutineScope r107 = LifecycleOwnerKt.getLifecycleScope(r102);
        if (r107 == null) goto L32;
    L33:
        BuildersKt.launch$default(r107, Dispatchers.getIO(), null, new ShareImageSpecialHandler$handleShareVideo$1(r113, this, r110, r111, r112, r210, r211, r104, null), 2, null);
        return true;
    L32:
        r107 = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        goto L33
    L21:
        r104 = null;
        goto L22
    L8:
        r103 = null;
        goto L10
    }
}

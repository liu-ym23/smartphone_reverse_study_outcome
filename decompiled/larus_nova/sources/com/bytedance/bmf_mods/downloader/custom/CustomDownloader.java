package com.bytedance.bmf_mods.downloader.custom;

import android.content.Context;
import android.os.Build;
import com.bytedance.bmf_mods.common.FileUtils;
import com.bytedance.bmf_mods.common.Logging;
import com.bytedance.bmf_mods.common.SoLoader;
import com.bytedance.bmf_mods.downloader.IDownloader;
import com.bytedance.bmf_mods_api.IDownloadCallback;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.cache.disk.DefaultDiskStorage;
import com.heytap.mcssdk.constant.b;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.File;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004JR\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\b2\n\u0010\f\u001a\u00060\rj\u0002`\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bH\u0002J\u0018\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\bH\u0002J\f\u0010\u0019\u001a\u00020\u001a*\u00020\u0014H\u0002J\f\u0010\u001b\u001a\u00020\u0014*\u00020\u0014H\u0002¨\u0006\u001d"}, d2 = {"Lcom/bytedance/bmf_mods/downloader/custom/CustomDownloader;", "Lcom/bytedance/bmf_mods/downloader/IDownloader;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)V", "download", "", "modelName", "", "cacheDirName", "tag", b.C, "modelPathBuilder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "params", "", "downloadCallback", "Lcom/bytedance/bmf_mods_api/IDownloadCallback;", "modelFile", "Ljava/io/File;", "dirFullPath", "md5", "modelFileName", "expectedMd5", "makeTempFileFormal", "", "tempFile", "Companion", "bmf_mods_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CustomDownloader implements IDownloader {
    public static final Companion Companion = null;
    private static final CopyOnWriteArraySet<String> downloadingFiles = null;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/bmf_mods/downloader/custom/CustomDownloader$Companion;", "", "()V", "downloadingFiles", "Ljava/util/concurrent/CopyOnWriteArraySet;", "", "bmf_mods_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        downloadingFiles = new CopyOnWriteArraySet();
    }

    public static final /* synthetic */ CopyOnWriteArraySet access$getDownloadingFiles$cp() {
        return downloadingFiles;
    }

    public CustomDownloader(Context r100) {
        if (r100 == null) goto L6;
        SoLoader.getInstance().setContext(r100);
        return;
    }

    private final boolean makeTempFileFormal(File r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L7
        if (r100.renameTo(FilesKt.resolveSibling(r100, StringsKt.removeSuffix(r100.getCanonicalPath(), DefaultDiskStorage.FileType.TEMP))) == false) goto L6;
        Object r102 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L10:
        return Result.m9456isSuccessimpl(r102);
    L6:
        throw new IllegalStateException("Check failed.".toString());     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    private final File tempFile(File r100) {
        return FilesKt.resolveSibling(r100, r100.getCanonicalPath() + DefaultDiskStorage.FileType.TEMP);
    }

    public static final /* synthetic */ boolean access$makeTempFileFormal(CustomDownloader r100, File r101) {
        return r100.makeTempFileFormal(r101);
    }

    public static final /* synthetic */ File access$tempFile(CustomDownloader r100, File r101) {
        return r100.tempFile(r101);
    }

    private final String modelFileName(String r100, String r101) {
        return r100 + '_' + r101;
    }

    private final File modelFile(String r100, String r101, String r102) {
        return new PolarisFileWrapper(r100, modelFileName(r101, r102));
    }

    public static final /* synthetic */ File access$modelFile(CustomDownloader r100, String r101, String r102, String r103) {
        return r100.modelFile(r101, r102, r103);
    }

    @Override // com.bytedance.bmf_mods.downloader.IDownloader
    public void download(final String r110, String r111, String r112, String r210, final StringBuilder r211, Map<String, String> r212, final IDownloadCallback r213) {
        Intrinsics.checkNotNullParameter(r110, "modelName");
        Intrinsics.checkNotNullParameter(r111, "cacheDirName");
        Intrinsics.checkNotNullParameter(r210, b.C);
        Intrinsics.checkNotNullParameter(r211, "modelPathBuilder");
        Intrinsics.checkNotNullParameter(r212, "params");
        Intrinsics.checkNotNullParameter(r213, "downloadCallback");
        String r100 = r212.get("host");
        boolean r101 = false;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L43;
        String r103 = r212.get("accessKey");
        if (r103 != null) goto L13;
    L14:
        r101 = true;
    L15:
        if (r101 == true) goto L43;
        monitor-enter(CustomDownloader.class);
        CopyOnWriteArraySet<String> r104 = downloadingFiles;     // Catch: Throwable -> L40
        if (r104.contains(r110) == false) goto L24;
        Logging.e("Another task is downloading the same model: " + r110);     // Catch: Throwable -> L40
        r213.callback(-100041);     // Catch: Throwable -> L40
        monitor-exit(CustomDownloader.class);
        return;
    L24:
        r104.add(r110);     // Catch: Throwable -> L40
        monitor-exit(CustomDownloader.class);
        final File r105 = FileUtils.getModelDownloadDir(SoLoader.getInstance().getAppContext(), r111);
        if (r105.exists() == true) goto L32;
        boolean r106 = r105.mkdirs();
        Logging.d("create model cache dir success: " + r106);
        if (r106 == true) goto L32;
        r213.callback(-100042);
        r104.remove(r110);
        return;
    L32:
        CustomDavinciRepo r107 = CustomDavinciRepo.INSTANCE;
        String r108 = r212.get("host");
        if (r108 != null) goto L35;
        r108 = "";
    L35:
        String r109 = r108;
        String r113 = r212.get("accessKey");
        if (r113 != null) goto L38;
        r113 = "";
    L38:
        r107.getDownloadUrl(r109, r113, r110, Build.MODEL, r212.get(b.f276371u), r212.get("appVersion"), r212.get("platformSdkVersion"), r212.get("deviceId"), new AnonymousClass2(r213, r110, this, r105, r211));
        return;
    L40:
        th = move-exception;
        throw th;
    L13:
        if (r103.length() != 0) goto L15;
    L43:
        r213.callback(-100020);
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }
}

package com.ss.android.lark.videosend.compress;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.FileUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.base.model.dispatch.ResourcePreprocessor;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.monitor.callback.CpuCallbackManager;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.videosend.checker.raw.VideoPreCheckRawService;
import com.ss.android.lark.videosend.pre.LimitConfig;
import com.ss.android.lark.videosend.pre.PreCompressConfig;
import com.ss.android.lark.videosend.pre.VideoPreProcessSettingUtils;
import com.ss.android.lark.videosend.tools.CompressPathManager;
import com.ss.android.lark.videosend.tools.VideoTools;
import java.util.UUID;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001:\u0003 !\"B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0005H\u0002J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0018\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u0005H\u0002J \u0010\u001c\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u000fH\u0002J\u0018\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/ss/android/lark/videosend/compress/VideoPreCompressManager;", "", "<init>", "()V", "TAG", "", "REPORT_KEY_PRE_COMPRESS_VIDEO", "preCompressService", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlin.jvm.PlatformType", VideoTools.ERROR_TYPE_COMPRESS, "", "param", "Lcom/ss/android/lark/videosend/compress/VideoPreCompressManager$PreCompressParam;", "check", "Lcom/ss/android/lark/videosend/compress/VideoPreCompressManager$Result;", "compressPath", "cpuUsage", "", "checkFile", "mediaPath", "checkDispatcher", "isEnable", "", "scene", "Lcom/ss/android/lark/videosend/compress/VideoPreCompressManager$Scene;", "compressInner", "targetPath", "reportResult", "result", "logMsg", "content", "PreCompressParam", "Scene", "Result", "videosend_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoPreCompressManager {
    public static final VideoPreCompressManager INSTANCE = null;
    private static final String REPORT_KEY_PRE_COMPRESS_VIDEO = "video_predicte_compress_dev";
    private static final String TAG = "VideoPreCompressManager";
    private static final ScheduledExecutorService preCompressService = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0014\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/videosend/compress/VideoPreCompressManager$Result;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "OK", "SWITCH_CLOSE", "FIRST_OPEN_ALBUM", "IS_RAW", "HAS_CACHE", "ORIGIN_NOT_READ", "ORIGIN_NOT_TRANSCODE", "ORIGIN_SIZE", "ORIGIN_DURATION", "LEFT_SPACE", "CPU_BUSY", "DISPATCHER_BUSY", "toString", "videosend_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Result extends Enum<Result> {
        public static final Result CPU_BUSY = null;
        public static final Result DISPATCHER_BUSY = null;
        public static final Result FIRST_OPEN_ALBUM = null;
        public static final Result HAS_CACHE = null;
        public static final Result IS_RAW = null;
        public static final Result LEFT_SPACE = null;
        public static final Result OK = null;
        public static final Result ORIGIN_DURATION = null;
        public static final Result ORIGIN_NOT_READ = null;
        public static final Result ORIGIN_NOT_TRANSCODE = null;
        public static final Result ORIGIN_SIZE = null;
        public static final Result SWITCH_CLOSE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Result[] f444916a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f444917b = null;
        private final String value;

        public static EnumEntries<Result> getEntries() {
            return f444917b;
        }

        static {
            Result r100 = new Result("OK", 0, com.bytedance.android.ec.core.event.a.VALUE_CLICK_TYPE);
            OK = r100;
            Result r101 = new Result("SWITCH_CLOSE", 1, "switch_close");
            SWITCH_CLOSE = r101;
            Result r102 = new Result("FIRST_OPEN_ALBUM", 2, "first_open_album");
            FIRST_OPEN_ALBUM = r102;
            Result r103 = new Result("IS_RAW", 3, "is_raw");
            IS_RAW = r103;
            Result r104 = new Result("HAS_CACHE", 4, "has_cache");
            HAS_CACHE = r104;
            Result r105 = new Result("ORIGIN_NOT_READ", 5, "origin_not_read");
            ORIGIN_NOT_READ = r105;
            Result r110 = new Result("ORIGIN_NOT_TRANSCODE", 6, "origin_not_transcode");
            ORIGIN_NOT_TRANSCODE = r110;
            Result r111 = new Result("ORIGIN_SIZE", 7, "origin_size");
            ORIGIN_SIZE = r111;
            Result r112 = new Result("ORIGIN_DURATION", 8, "origin_duration");
            ORIGIN_DURATION = r112;
            Result r113 = new Result("LEFT_SPACE", 9, "left_space");
            LEFT_SPACE = r113;
            Result r114 = new Result("CPU_BUSY", 10, "cpu_busy");
            CPU_BUSY = r114;
            Result r106 = new Result("DISPATCHER_BUSY", 11, "dispatcher_busy");
            DISPATCHER_BUSY = r106;
            Result[] r107 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106};
            f444916a = r107;
            f444917b = EnumEntriesKt.enumEntries(r107);
        }

        public static Result[] values() {
            return (Result[]) f444916a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.value;
        }

        public static Result valueOf(String r100) {
            return (Result) r27.a.a(Result.class, r100);
        }

        public Result(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\f\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/videosend/compress/VideoPreCompressManager$Scene;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SELECT_VIDEO", "OPEN_ALBUM", "PREVIEW_VIDEO", "SHARE_FROM_SYSTEM", "toString", "videosend_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Scene extends Enum<Scene> {
        public static final Scene OPEN_ALBUM = null;
        public static final Scene PREVIEW_VIDEO = null;
        public static final Scene SELECT_VIDEO = null;
        public static final Scene SHARE_FROM_SYSTEM = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Scene[] f444918a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f444919b = null;
        private final String value;

        public static EnumEntries<Scene> getEntries() {
            return f444919b;
        }

        static {
            Scene r100 = new Scene("SELECT_VIDEO", 0, "select_video");
            SELECT_VIDEO = r100;
            Scene r101 = new Scene("OPEN_ALBUM", 1, "open_album");
            OPEN_ALBUM = r101;
            Scene r102 = new Scene("PREVIEW_VIDEO", 2, "preview_video");
            PREVIEW_VIDEO = r102;
            Scene r103 = new Scene("SHARE_FROM_SYSTEM", 3, "share_from_system");
            SHARE_FROM_SYSTEM = r103;
            Scene[] r104 = {r100, r101, r102, r103};
            f444918a = r104;
            f444919b = EnumEntriesKt.enumEntries(r104);
        }

        public static Scene[] values() {
            return (Scene[]) f444918a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.value;
        }

        public static Scene valueOf(String r100) {
            return (Scene) r27.a.a(Scene.class, r100);
        }

        public Scene(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Scene f444920a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f444921b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f444922c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final oac.b f444923d;

        public final String toString() {
            return "scene:" + this.f444920a + ",mediaPath:" + this.f444921b.hashCode() + ",isOrigin:" + this.f444922c;
        }

        public a(Scene r100, String r101, boolean r102, ResourcePreprocessor.f.a r103) {
            Intrinsics.checkNotNullParameter(r100, "scene");
            Intrinsics.checkNotNullParameter(r101, "mediaPath");
            this.f444920a = r100;
            this.f444921b = r101;
            this.f444922c = r102;
            this.f444923d = r103;
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f444924a = null;

        static {
            int[] r100 = new int[Scene.values().length];
            r100[Scene.SELECT_VIDEO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[Scene.OPEN_ALBUM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[Scene.PREVIEW_VIDEO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[Scene.SHARE_FROM_SYSTEM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f444924a = r100;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f444925a;

        public c(a r100) {
            this.f444925a = r100;
        }

        public final void a() {
            a r100 = this.f444925a;
            String r101 = CompressPathManager.generateCompressFilePath(r100.f444921b, Boolean.valueOf(r100.f444922c));
            int r102 = ((int) CpuCallbackManager.a().f432362c) / RangesKt.coerceAtLeast(com.bytedance.apm.util.b.b(), 1);
            VideoPreCompressManager r103 = VideoPreCompressManager.INSTANCE;
            a r104 = this.f444925a;
            Intrinsics.checkNotNull(r101);
            Result r105 = VideoPreCompressManager.access$check(r103, r104, r101, r102);
            if (r105 != Result.OK) goto L5;
            VideoPreCompressManager.access$compressInner(r103, this.f444925a, r101);
        L8:
            VideoPreCompressManager.access$reportResult(r103, this.f444925a, r102, r105);
            return;
        L5:
            oac.b r106 = this.f444925a.f444923d;
            if (r106 == null) goto L8;
            r106.b(new ErrorResult("check failed:" + r105));
            goto L8
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    private VideoPreCompressManager() {
    }

    static {
        INSTANCE = new VideoPreCompressManager();
        preCompressService = CoreThreadPool.getDefault().getSingleScheduledThreadPool("pre_compress");
    }

    private final Result checkDispatcher(int r100) {
        if (r100 > ((PreCompressConfig) VideoPreProcessSettingUtils.f444965e.getValue()).getLimit().getCpu()) goto L5;
        int r101 = d.f444936d;
        int r102 = d.b.f444940a.f444937a.size();
        if (r102 < 5) goto L9;
        Log.i("MediaCompressDispatcher", "compress dispatcher is busy:" + r102);
        boolean r103 = true;
    L10:
        if (r103 == false) goto L14;
        return Result.DISPATCHER_BUSY;
    L14:
        return Result.OK;
    L9:
        r103 = false;
        goto L10
    L5:
        return Result.CPU_BUSY;
    }

    private final Result checkFile(String r100) {
        VFSFile r101 = VFSFiles.f444819b.i(r100);
        if (r101.canRead() == true) goto L7;
        return Result.ORIGIN_NOT_READ;
    L7:
        if (VideoTools.isCannotTransCode(r100) == true) goto L9;
        LimitConfig r102 = ((PreCompressConfig) VideoPreProcessSettingUtils.f444965e.getValue()).getLimit();
        if (r101.length() <= r102.getFileSize()) goto L15;
        return Result.ORIGIN_SIZE;
    L15:
        if (VideoTools.getVideoInfo(r100).duration > (r102.getVideoDuration() * 1000)) goto L17;
        long r103 = com.ss.android.lark.videosend.tools.j.a();
        if (r103 < r102.getDiskSpaceFreeSize()) goto L26;
        if (r103 < (((long) r102.getDiskSpaceFreeCount()) * r101.length())) goto L26;
        return Result.OK;
    L26:
        return Result.LEFT_SPACE;
    L17:
        return Result.ORIGIN_DURATION;
    L9:
        return Result.ORIGIN_NOT_TRANSCODE;
    }

    @JvmStatic
    public static final void compress(a r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        INSTANCE.logMsg(r100, "pre compress");
        preCompressService.execute(new c(r100));
    }

    private final boolean isEnable(Scene r100) {
        PreCompressConfig r101 = (PreCompressConfig) VideoPreProcessSettingUtils.f444965e.getValue();
        int r102 = b.f444924a[r100.ordinal()];
        if (r102 == 1) goto L22;
        if (r102 == 2) goto L19;
        if (r102 == 3) goto L16;
        if (r102 != 4) goto L14;
        if (r101.getSwitch().getShareFromSystemEnable() == 1) goto L26;
    L24:
        return false;
    L26:
        return true;
    L14:
        throw new NoWhenBranchMatchedException();
    L16:
        if (r101.getSwitch().getPreviewVideoEnable() != 1) goto L24;
        return true;
    L19:
        if (r101.getSwitch().getOpenAlbumEnable() != 1) goto L24;
        return true;
    L22:
        if (r101.getSwitch().getSelectVideoEnable() != 1) goto L24;
        return true;
    }

    private final void compressInner(a r100, String r101) {
        com.ss.android.lark.videosend.compress.a r102 = new com.ss.android.lark.videosend.compress.a(UUID.randomUUID().hashCode(), r100.f444921b, new oac.b(r101, r100.f444923d));
        r102.f444933h = true;
        r102.f444930e = Boolean.TRUE;
        r102.f444929d = r101;
        INSTANCE.logMsg(r100, "dispatcher compress");
        int r103 = d.f444936d;
        d.b.f444940a.c(r102);
    }

    private final void logMsg(a r100, String r101) {
        Log.i(TAG, "param -> " + r100 + ", content -> " + r101);
    }

    public static final /* synthetic */ void access$compressInner(VideoPreCompressManager r100, a r101, String r102) {
        r100.compressInner(r101, r102);
    }

    private final Result check(a r100, String r101, int r102) {
        if (isEnable(r100.f444920a) == true) goto L7;
        return Result.SWITCH_CLOSE;
    L7:
        if (VideoPreCheckRawService.b(r100.f444921b, r100.f444922c) == false) goto L11;
        return Result.IS_RAW;
    L11:
        if (FileUtils.r(r101) == true) goto L13;
        Result r103 = checkFile(r100.f444921b);
        Result r104 = Result.OK;
        if (r103 == r104) goto L17;
        return r103;
    L17:
        Result r105 = checkDispatcher(r102);
        if (r105 == r104) goto L21;
        return r105;
    L21:
        if (((oac.a) ApiUtils.getApi(oac.a.class)).isFirstOpenAlbum() == true) goto L23;
        return r104;
    L23:
        return Result.FIRST_OPEN_ALBUM;
    L13:
        return Result.HAS_CACHE;
    }

    private final void reportResult(a r100, int r101, Result r102) {
        String r103 = r100.f444920a.getValue();     // Catch: Exception -> L9
        if (r102 != Result.OK) goto L6;
        String r104 = VideoTools.ERROR_TYPE_COMPRESS;
    L7:
        JSONObject r105 = new JSONObject().put("scene", r103).put("cpuUsage", r101).put("result", r104).put("fail_reason", r102.getValue());     // Catch: Exception -> L9
        logMsg(r100, "reportResult:" + r105);     // Catch: Exception -> L9
        Statistics.sendEvent(REPORT_KEY_PRE_COMPRESS_VIDEO, r105);     // Catch: Exception -> L9
        return;
    L6:
        r104 = "none";
    L9:
        logMsg(r100, "reportResult failed");
    }

    public static final /* synthetic */ Result access$check(VideoPreCompressManager r100, a r101, String r102, int r103) {
        return r100.check(r101, r102, r103);
    }

    public static final /* synthetic */ void access$reportResult(VideoPreCompressManager r100, a r101, int r102, Result r103) {
        r100.reportResult(r101, r102, r103);
    }
}

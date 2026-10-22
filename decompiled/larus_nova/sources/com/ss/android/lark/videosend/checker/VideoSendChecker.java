package com.ss.android.lark.videosend.checker;

import android.os.Looper;
import com.bytedance.apm.constant.UploadTypeInf;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.FileUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.videosend.tools.LimitDisk;
import com.ss.android.lark.videosend.tools.ResolutionConfig;
import com.ss.android.lark.videosend.tools.VideoCompressTools;
import com.ss.android.lark.videosend.tools.VideoSendConfig;
import com.ss.android.lark.videosend.tools.VideoSettingUtils;
import com.ss.android.lark.videosend.tools.VideoTools;
import com.ss.android.lark.videosend.tools.j;
import com.ss.android.vesdk.VEUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class VideoSendChecker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VideoSendConfig f444842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference<a> f444843b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/videosend/checker/VideoSendChecker$Result;", "", "<init>", "(Ljava/lang/String;I)V", "LIMIT_SIZE", "LIMIT_DURATION", "LIMIT_RESOLUTION", "LIMIT_FPS", "LIMIT_BITRATE", "LIMIT_VE_NO_SUPPORT", "LIMIT_DISK", "VALID", "videosend_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Result extends Enum<Result> {
        public static final Result LIMIT_BITRATE = null;
        public static final Result LIMIT_DISK = null;
        public static final Result LIMIT_DURATION = null;
        public static final Result LIMIT_FPS = null;
        public static final Result LIMIT_RESOLUTION = null;
        public static final Result LIMIT_SIZE = null;
        public static final Result LIMIT_VE_NO_SUPPORT = null;
        public static final Result VALID = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Result[] f444844a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f444845b = null;

        public static EnumEntries<Result> getEntries() {
            return f444845b;
        }

        static {
            Result r100 = new Result("LIMIT_SIZE", 0);
            LIMIT_SIZE = r100;
            Result r101 = new Result("LIMIT_DURATION", 1);
            LIMIT_DURATION = r101;
            Result r102 = new Result("LIMIT_RESOLUTION", 2);
            LIMIT_RESOLUTION = r102;
            Result r103 = new Result("LIMIT_FPS", 3);
            LIMIT_FPS = r103;
            Result r104 = new Result("LIMIT_BITRATE", 4);
            LIMIT_BITRATE = r104;
            Result r105 = new Result("LIMIT_VE_NO_SUPPORT", 5);
            LIMIT_VE_NO_SUPPORT = r105;
            Result r110 = new Result("LIMIT_DISK", 6);
            LIMIT_DISK = r110;
            Result r111 = new Result("VALID", 7);
            VALID = r111;
            Result[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
            f444844a = r112;
            f444845b = EnumEntriesKt.enumEntries(r112);
        }

        public static Result[] values() {
            return (Result[]) f444844a.clone();
        }

        public static Result valueOf(String r100) {
            return (Result) r27.a.a(Result.class, r100);
        }

        public Result(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface a {
        void a(Result r100, ArrayList<String> r101);
    }

    public static final class b {
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f444846a = null;

        static {
            int[] r100 = new int[Result.values().length];
            r100[Result.LIMIT_SIZE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r100[Result.LIMIT_DURATION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r100[Result.LIMIT_RESOLUTION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[Result.LIMIT_FPS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r100[Result.LIMIT_BITRATE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r100[Result.LIMIT_VE_NO_SUPPORT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r100[Result.LIMIT_DISK.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r100[Result.VALID.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            f444846a = r100;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List<String> f444847a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ VideoSendChecker f444848b;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ VideoSendChecker f444849a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Ref.ObjectRef<Result> f444850b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ ArrayList<String> f444851c;

            public a(VideoSendChecker r100, Ref.ObjectRef<Result> r101, ArrayList<String> r102) {
                this.f444849a = r100;
                this.f444850b = r101;
                this.f444851c = r102;
            }

            @Override // java.lang.Runnable
            public final void run() {
                WeakReference<a> r100 = this.f444849a.f444843b;     // Catch: Throwable -> L8
                if (r100 == null) goto L11;
                a r101 = r100.get();     // Catch: Throwable -> L8
                if (r101 == null) goto L15;
                r101.a(this.f444850b.element, this.f444851c);     // Catch: Throwable -> L8
                return;
            L15:
                return;
            L11:
                return;
            L8:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L16;
                throw th;
            }
        }

        public d(List<String> r100, VideoSendChecker r101) {
            this.f444847a = r100;
            this.f444848b = r101;
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [T, com.ss.android.lark.videosend.checker.VideoSendChecker$Result] */
        /* JADX WARN: Type inference failed for: r5v1, types: [T, com.ss.android.lark.videosend.checker.VideoSendChecker$Result] */
        public final void a() {
            Ref.ObjectRef r100 = new Ref.ObjectRef();
            r100.element = Result.VALID;
            ArrayList r101 = new ArrayList();
            List<String> r102 = this.f444847a;
            VideoSendChecker r103 = this.f444848b;
            Iterator<T> r104 = r102.iterator();
        L4:
            if (r104.hasNext() == false) goto L11;
            String r105 = (String) r104.next();
            ?? r106 = r103.b(r105, false);
            Result r107 = Result.VALID;
            if (r107 == r106) goto L4;
            if (r100.element != r107) goto L10;
            r100.element = r106;
        L10:
            r101.add(r105);
            goto L4
        L11:
            UICallbackExecutor.execute(new a(this.f444848b, r100, r101));
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

    static {
    }

    public VideoSendChecker(int r100) {
        this.f444842a = VideoSettingUtils.e();
    }

    public final void a(List<String> r110, a r111) {
        Intrinsics.checkNotNullParameter(r110, "videos");
        Intrinsics.checkNotNullParameter(r111, "callback");
        LimitDisk r100 = j.f445016a;
        Intrinsics.checkNotNullParameter(r110, "videos");
        long r101 = j.a();
        Iterator r102 = ((ArrayList) r110).iterator();
        long r103 = 0;
        long r104 = 0;
    L4:
        if (r102.hasNext() == false) goto L6;
        long r105 = VFSFiles.f444819b.i((String) r102.next()).length();
        r104 = r104 + r105;
        r103 = RangesKt.coerceAtLeast(r105, r103);
        goto L4
    L6:
        LimitDisk r106 = j.f445016a;
        long r107 = RangesKt.coerceAtLeast(r104 + (((long) r106.getFreeMaxFactor()) * r103), r106.getFreeSize());
        if (r101 <= r107) goto L9;
        boolean r108 = true;
    L10:
        Log.i("VideoDiskSpaceUtils", "multiVideoHasSaveSpace(), hasSaveSpace=" + r108 + ", needSize=" + r107 + ", freeSize=" + r101);
        if (r108 == true) goto L14;
        r111.a(Result.LIMIT_DISK, new ArrayList(r110));
        return;
    L14:
        this.f444843b = new WeakReference(r111);
        d r112 = new d(r110, this);
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == false) goto L17;
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new pac.b(r112));
        return;
    L17:
        r112.run();
        return;
    L9:
        r108 = false;
        goto L10
    }

    public final Result b(String r100, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "path");
        ResolutionConfig r101 = this.f444842a.getLimitVideoResolution();
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);
        String[] r103 = FileUtils.f285888a;
        long r104 = r102.length();
        VEUtils.VEVideoFileInfo r105 = VideoTools.getVideoInfo(r100);
        Log.i("VideoSendChecker", String.valueOf(r105));
        if (r104 <= this.f444842a.getLimitFileSize()) goto L6;
        Result r106 = Result.LIMIT_SIZE;
    L24:
        Log.i("VideoSendChecker", "check video result: " + r106);
        int r107 = 1;
        switch(c.f444846a[r106.ordinal()]) {
            case 1: goto L35;
            case 2: goto L34;
            case 3: goto L33;
            case 4: goto L32;
            case 5: goto L31;
            case 6: goto L30;
            case 7: goto L29;
            case 8: goto L28;
            default: goto L27;
        };
    L28:
        String r108 = "";
        r107 = 0;
    L36:
        JSONObject r109 = new JSONObject();
        r109.put("intercept_result", r107);
        r109.put("intercept_type", r108);
        r109.put("video_duration", Float.valueOf(VideoCompressTools.a(r105.duration / 1000.0f)));
        r109.put("video_file_size", Float.valueOf(VideoCompressTools.a((r104 / 1024.0f) / 1024.0f)));
        r109.put("is_pre", r110 ? 1 : 0);
        Statistics.sendEvent("video_intercept_event_dev", r109);
        return r106;
    L29:
        r108 = UploadTypeInf.DISK;
        goto L36
    L30:
        r108 = "no_support";
        goto L36
    L31:
        r108 = "bitrate";
        goto L36
    L32:
        r108 = "fps";
        goto L36
    L33:
        r108 = "resolution";
        goto L36
    L34:
        r108 = "duration";
        goto L36
    L35:
        r108 = "size";
        goto L36
    L27:
        throw new NoWhenBranchMatchedException();
    L6:
        if (r105.duration <= (this.f444842a.getLimitVideoDuration() * 1000)) goto L9;
        r106 = Result.LIMIT_DURATION;
        goto L24
    L9:
        if ((r105.width * r105.height) <= (r101.getWidth() * r101.getHeight())) goto L12;
        r106 = Result.LIMIT_RESOLUTION;
        goto L24
    L12:
        if (r105.fps <= this.f444842a.getLimitVideoFrameRate()) goto L15;
        r106 = Result.LIMIT_FPS;
        goto L24
    L15:
        if ((r105.bitrate * 1000) <= this.f444842a.getLimitVideoBitrate()) goto L18;
        r106 = Result.LIMIT_BITRATE;
        goto L24
    L18:
        if (VideoTools.isCannotTransCode(r100) == false) goto L21;
        r106 = Result.LIMIT_VE_NO_SUPPORT;
        goto L24
    L21:
        if (j.b(VFSFiles.f444819b.i(r100).length()) == true) goto L23;
        r106 = Result.LIMIT_DISK;
        goto L24
    L23:
        r106 = Result.VALID;
        goto L24
    }
}

package com.ss.android.lark.videosend.checker.raw;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.utils.FileUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.videosend.pre.PreRawConfig;
import com.ss.android.lark.videosend.pre.RawItemConfig;
import com.ss.android.lark.videosend.pre.VideoPreProcessSettingUtils;
import com.ss.android.lark.videosend.tools.CompressPathManager;
import com.ss.android.lark.videosend.tools.VideoCompressTools;
import com.ss.android.lark.videosend.tools.VideoSendConfig;
import com.ss.android.lark.videosend.tools.VideoSettingUtils;
import com.ss.android.lark.videosend.tools.VideoTools;
import com.ss.android.vesdk.VEConstant$CODEC_ID;
import com.ss.android.vesdk.VEEditor;
import com.ss.android.vesdk.VEUtils;
import com.ss.android.vesdk.VEVideoEncodeSettings;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f444870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC5380a f444871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f444872c;

    /* JADX INFO: renamed from: com.ss.android.lark.videosend.checker.raw.a$a, reason: collision with other inner class name */
    public interface InterfaceC5380a {
        void onResult(String r100, int r101);
    }

    public static final class b {
    }

    static {
    }

    public final void c() {
        Log.i("CheckRawTask", "run task start, mediaPath:" + this.f444870a.hashCode());
        boolean r100 = false;
        if (a(false) == true) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L10;
    L13:
        r100 = true;
    L14:
        VEEditor r102 = (VEEditor) this.f444872c.getValue();
        if (r102 == null) goto L17;
        r102.destroy();
    L17:
        if (r101 == true) goto L21;
        if (r100 == true) goto L21;
        d(1);
        return;
    L21:
        long r103 = System.currentTimeMillis();
        Ref.BooleanRef r104 = new Ref.BooleanRef();
        r104.element = r101;
        Ref.BooleanRef r105 = new Ref.BooleanRef();
        r105.element = r100;
        Lazy r106 = InterLeaveChecker.f444857a;     // Catch: Exception -> L24
        InterLeaveChecker.a(this.f444870a, new com.ss.android.lark.videosend.checker.raw.b(r103, r104, r105, this));     // Catch: Exception -> L24
        return;
    L24:
        e = move-exception;
        Log.e("CheckRawTask", "checkInterLeave exception:" + e);
        d(1);
        return;
    L10:
        if (a(true) == false) goto L14;
        if (b(true) == false) goto L14;
    L5:
        if (b(false) == false) goto L7;
        r101 = true;
        goto L8
    }

    @Override // java.lang.Runnable
    public final void run() {
        c();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public final boolean a(boolean r110) {
        long r100 = System.currentTimeMillis();
        PreRawConfig r101 = (PreRawConfig) VideoPreProcessSettingUtils.f444966f.getValue();
        if (r110 == false) goto L5;
        RawItemConfig r102 = r101.getOrigin();
    L6:
        VideoSendConfig r103 = VideoSettingUtils.e();
        PolarisFileWrapper r104 = new PolarisFileWrapper(this.f444870a);
        String[] r105 = FileUtils.f285888a;
        long r106 = r104.length();
        VEUtils.VEVideoFileInfo r107 = VideoTools.getVideoInfo(this.f444870a);
        if (r106 <= r102.getLimitFileSize()) goto L9;
    L21:
        boolean r108 = false;
    L22:
        Log.i("CheckRawTask", "checkFileInfo, isOrigin:" + r110 + ", result:" + r108 + ", costTime:" + (System.currentTimeMillis() - r100));
        return r108;
    L9:
        if ((r107.bitrate * 1000) > r102.getLimitVideoBitrate()) goto L21;
        if ((r107.width * r107.height) > (r102.getLimitVideoWidth() * r102.getLimitVideoHeight())) goto L21;
        if (r107.duration > (r103.getLimitVideoDuration() * 1000)) goto L21;
        if (r107.fps > r103.getLimitVideoFrameRate()) goto L21;
        if (r107.bHDR == true) goto L21;
        if (r107.codec != VEConstant$CODEC_ID.AV_CODEC_ID_H264.ordinal()) goto L21;
        r108 = true;
        goto L22
    L5:
        r102 = r101.getCommon();
        goto L6
    }

    public final boolean b(boolean r100) {
        long r101 = System.currentTimeMillis();
        VEVideoEncodeSettings r102 = VideoTools.getVEVideoEncodeSettings(VideoCompressTools.b(this.f444870a, CompressPathManager.generateCompressFilePath(this.f444870a, Boolean.valueOf(r100))));     // Catch: Exception -> L7
        VEEditor r103 = (VEEditor) this.f444872c.getValue();     // Catch: Exception -> L7
        if (r103 == null) goto L9;
        boolean r104 = r103.isEnableRemuxVideo(r102);     // Catch: Exception -> L7
    L10:
        Log.i("CheckRawTask", "checkReMux, isOrigin:" + r100 + ", result:" + r104 + ", costTime:" + (System.currentTimeMillis() - r101));
        return r104;
    L9:
        r104 = false;
    L7:
        e = move-exception;
        Log.e("CheckRawTask", "checkReMux exception:" + e);
        goto L9
    }

    public final void d(int r100) {
        Log.i("CheckRawTask", "run task finish, result:" + r100);
        this.f444871b.onResult(this.f444870a, r100);
    }

    public a(String r100, VideoPreCheckRawService.b r101) {
        Intrinsics.checkNotNullParameter(r100, "mediaPath");
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f444870a = r100;
        this.f444871b = r101;
        this.f444872c = LazyKt.lazy(new CheckRawTask$editor$2(this));
    }
}

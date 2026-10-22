package com.ss.android.lark.videosend.tools;

import android.app.Application;
import android.text.TextUtils;
import com.android.ttcjpaysdk.bdpay.counter.outer.fallback.view.OuterPayFallbackWrapper;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSPath;
import com.ss.android.vesdk.VEConstant$CODEC_ID;
import com.ss.android.vesdk.VEUtils;
import com.suite.lark.platform.component.deviceperf.DevicePerfUtils;
import java.io.File;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public class CompressPathManager {
    private static final String FILE_PREFIX_SUCCESS_COMPRESS = "SUCCESS_COMPRESS_MEDIA_";
    private static final String TAG = "CompressPathManager";

    public static final enum CompileScene extends Enum<CompileScene> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CompileScene[] f444967a = null;
        public static final CompileScene common = null;
        public static final CompileScene low_bitrate = null;
        public static final CompileScene low_device = null;
        public static final CompileScene origin = null;
        public static final CompileScene weak_net = null;

        static {
            CompileScene r100 = new CompileScene("low_bitrate", 0);
            low_bitrate = r100;
            CompileScene r101 = new CompileScene(PlayerResolution.SDKKEY.ORIGIN, 1);
            origin = r101;
            CompileScene r102 = new CompileScene(OuterPayFallbackWrapper.FROM_SCENE_WEAK_NET, 2);
            weak_net = r102;
            CompileScene r103 = new CompileScene("low_device", 3);
            low_device = r103;
            CompileScene r104 = new CompileScene("common", 4);
            common = r104;
            f444967a = new CompileScene[]{r100, r101, r102, r103, r104};
        }

        public static CompileScene[] values() {
            return (CompileScene[]) f444967a.clone();
        }

        public static CompileScene valueOf(String r100) {
            return (CompileScene) r27.a.a(CompileScene.class, r100);
        }

        public CompileScene(String r100, int r101) {
            super(r100, r101);
        }
    }

    public CompressPathManager() {
    }

    public static boolean isLowLevelDevice() {
        DevicePerfUtils.DevicePerfLevel r100 = DevicePerfUtils.d();
        if (r100 != DevicePerfUtils.DevicePerfLevel.LOW) goto L5;
    L8:
        return true;
    L5:
        if (r100 == DevicePerfUtils.DevicePerfLevel.ULTRALOW) goto L8;
        return false;
    }

    public static String generateCommonCompressFilePath(String r100) {
        return generateCompressFilePath(r100, "_" + CompileScene.common.toString().hashCode());
    }

    public static String generateTempPath(String r100) {
        return r100 + ".temp";
    }

    public static CompileScene getCompileScene(String r100) {
        StringBuilder r101 = new StringBuilder("");
        CompileScene r102 = CompileScene.low_bitrate;
        r101.append(r102.toString().hashCode());
        if (r100.contains(r101.toString()) == true) goto L15;
        StringBuilder r103 = new StringBuilder("");
        r102 = CompileScene.origin;
        r103.append(r102.toString().hashCode());
        if (r100.contains(r103.toString()) == true) goto L15;
        StringBuilder r104 = new StringBuilder("");
        r102 = CompileScene.weak_net;
        r104.append(r102.toString().hashCode());
        if (r100.contains(r104.toString()) == true) goto L15;
        StringBuilder r105 = new StringBuilder("");
        r102 = CompileScene.low_device;
        r105.append(r102.toString().hashCode());
        if (r100.contains(r105.toString()) == true) goto L15;
        r102 = CompileScene.common;
    L15:
        Log.i(TAG, "getCompileScene(), compile scene: " + r102.toString());
        return r102;
    }

    public static boolean isOriginMode(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return false;
    L6:
        if (getCompileScene(r100) != CompileScene.origin) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean isWeakNetMode(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return false;
    L6:
        if (getCompileScene(r100) != CompileScene.weak_net) goto L9;
        return true;
    L9:
        return false;
    }

    private static String generateCompressFilePath(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return "";
    L5:
        if (FileUtils.r(r100) == false) goto L15;
        int r102 = l.f445018a;
        Application r103 = LarkContext.getApplication();
        Intrinsics.checkNotNull(r103);
        int r104 = com.suite.lark.platform.component.storage.file.dirs.h.f460642c;
        com.suite.lark.platform.component.storage.file.dirs.h r105 = com.suite.lark.platform.component.storage.file.dirs.h.a.a(r103);
        r105.c(l.b());
        VFSPath r106 = r105.b(new a());
        VFSFile r107 = l.b().i(r100);
        StringBuilder r108 = new StringBuilder();
        r108.append((FILE_PREFIX_SUCCESS_COMPRESS + r107.hashCode() + "_" + r107.lastModified() + "_" + r107.length()).hashCode());
        r108.append(File.separator);
        String r109 = r108.toString();
        String r110 = r107.getName();
        int r111 = r110.lastIndexOf(".");
        if (r111 <= 0) goto L10;
        String r112 = r110.substring(0, r111) + r101 + ".mp4";
    L12:
        return r106.subPath(r109 + r112).getRealPath();
    L10:
        r112 = r110 + r101;
        goto L12
    L15:
        return "";
    }

    private static String getVideoCacheSuffix(String r100, boolean r101) {
        Lazy r102 = VideoSettingUtils.f444982a;
        Intrinsics.checkNotNullParameter(r100, "mediaPath");
        VEUtils.VEVideoFileInfo r103 = VideoTools.getVideoInfo(r100);
        boolean r104 = false;
        if (r103.codec != VEConstant$CODEC_ID.AV_CODEC_ID_H264.ordinal()) goto L5;
        boolean r105 = true;
    L7:
        if (r103.bitrate >= VideoSettingUtils.c().getLowBitrateMax()) goto L9;
        boolean r106 = true;
    L10:
        Log.i("VideoSettingUtils", "isLowBitrateMode(), isH264:" + r105 + ", isLowBitrate:" + r106);
        if (r105 == false) goto L14;
        if (r106 == false) goto L14;
        r104 = true;
    L14:
        if (r104 == false) goto L16;
        CompileScene r107 = CompileScene.low_bitrate;
    L25:
        Log.i(TAG, "getVideoCacheSuffix(), compile scene: " + r107.toString());
        return "_" + r107.toString().hashCode();
    L16:
        if (r101 == false) goto L19;
        r107 = CompileScene.origin;
        goto L25
    L19:
        if (pac.a.a() == false) goto L22;
        r107 = CompileScene.weak_net;
        goto L25
    L22:
        if (isLowLevelDevice() == false) goto L24;
        r107 = CompileScene.low_device;
        goto L25
    L24:
        r107 = CompileScene.common;
        goto L25
    L9:
        r106 = false;
        goto L10
    L5:
        r105 = false;
        goto L7
    }

    public static boolean renameFile(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L18:
        return false;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L18;
        if (TextUtils.equals(r100, r101) == false) goto L11;
        return true;
    L11:
        if (FileUtils.r(r100) == true) goto L14;
        return false;
    L14:
        if (FileUtils.r(r101) == false) goto L16;
        return true;
    L16:
        return l.b().i(r100).renameTo(l.b().i(r101));
    }

    public static String generateCompressFilePath(String r100, Boolean r101) {
        return generateCompressFilePath(r100, getVideoCacheSuffix(r100, r101.booleanValue()));
    }
}

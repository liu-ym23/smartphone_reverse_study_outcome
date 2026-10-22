package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio;

import com.bytedance.lark.oggopus_rust_android.OggOpusEncoder;
import com.bytedance.lark.oggopus_rust_android.OggOpusEncoderInputInfo;
import com.bytedance.lark.oggopus_rust_android.Oggopus_rustKt;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.MmRecordFileHelper;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs.MmRecordingRemoteAudioSetting;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.h;
import java.io.File;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: loaded from: classes37.dex */
public final class MmRecordingAudioPersistent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a f434292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f434293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f434294c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ExecutorCoroutineDispatcher f434295d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public File f434296e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public VFSFile f434297f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f434298g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public OggOpusEncoder f434299h;

    public static final class a {
    }

    static {
    }

    public MmRecordingAudioPersistent(com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r100) {
        int r101 = f.f434365c;
        Intrinsics.checkNotNullParameter(r100, "userComponentContext");
        MmRecordingRemoteAudioSetting r102 = r100.getSettingsService().f434071b;
        this(r100, new f(r102.getMmAudioSampleRate(), r102.getMmAudioChannel()));
    }

    public MmRecordingAudioPersistent(com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, "uccApi");
        Intrinsics.checkNotNullParameter(r101, "audioFormat");
        this.f434292a = r100;
        this.f434293b = r101;
        this.f434294c = "MmRecordingAudioPersistent";
        this.f434295d = ExecutorsKt.from(CoreThreadPool.getDefault().getSingleScheduledThreadPool("MmAudioPersistent"));
    }

    public static final byte[] a(MmRecordingAudioPersistent r100, byte[] r101) {
        r100.getClass();
        if (r101.length != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L26;
        f r103 = r100.f434293b;
        long r104 = r103.f434366a;
        long r105 = r103.f434367b;
        if (r105 != 1) goto L11;
        String r106 = null;
    L24:
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L14
        Object r108 = Result.m9449constructorimpl(Oggopus_rustKt.encodeDataToOpus(r101, new OggOpusEncoderInputInfo(r104, r105), r106));     // Catch: Throwable -> L14
    L16:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L19;
        lvb.a.b(r100.f434294c, "[encodePcmPartToOgg] failed, pcmSize=" + r101.length + ", error=" + r109);
    L19:
        byte[] r110 = new byte[0];
        if (Result.m9455isFailureimpl(r108) == false) goto L23;
        r108 = r110;
    L23:
        return (byte[]) r108;
    L14:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    L11:
        r106 = "minutes_stereo";
        goto L24
    L26:
        return new byte[0];
    L5:
        r102 = false;
        goto L6
    }

    public static File e(String r100, String r101) {
        pub.a r102 = (pub.a) OfficeSDKManager.getHostGlobalService(pub.a.class);
        if (r102 == null) goto L5;
        PolarisFileWrapper r103 = r102.r0(r100, r101);
    L6:
        if (r103 == null) goto L8;
        return r103;
    L8:
        MmRecordFileHelper.f434037a.getClass();
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "meetingId");
        Intrinsics.checkNotNullParameter(r100, "userId");
        h r104 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.f434038a;
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter("MinutesRecordings", "directoryName");
        return com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.b(com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.a(r100, "MinutesRecordings"), r101);
    L5:
        r103 = null;
        goto L6
    }

    public static void f(String r100, String r101, String r102) {
        qvb.a r103 = qvb.a.f534934a;
        if (StringsKt.isBlank(r102) == true) goto L6;
        r100 = r100 + ':' + r102;
    L6:
        qvb.a.b(null, r100, r101, "warn", 1);
    }

    public final Object b(String r100, String r110, String r111, ContinuationImpl r112) {
        if (StringsKt.isBlank(r111) == false) goto L6;
        lvb.a.h(this.f434294c, "[assembleFullAudioFileFromParts] skip, audioFilePath is blank, recordingId=" + r110);
        return Boxing.boxBoolean(false);
    L6:
        MmRecordingRemoteAudioSetting r101 = this.f434292a.getSettingsService().f434071b;
        lvb.a.e(this.f434294c, "[audioFormat][assembleFullAudio] recordingId=" + r110 + ", formatId=" + System.identityHashCode(this.f434293b) + ", sampleRate=" + this.f434293b.f434366a + ", channelCount=" + this.f434293b.f434367b + ", currentSampleRate=" + r101.getMmAudioSampleRate() + ", currentChannelCount=" + r101.getMmAudioChannel());
        return BuildersKt.withContext(this.f434295d, new MmRecordingAudioPersistent$assembleFullAudioFileFromParts$2(r100, r110, this, r111, null), r112);
    }

    public final String c(String r100, String r101, MmRecordingSource r102, boolean r110) {
        String r103 = "";
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "recordingId");
        if (r110 == false) goto L5;
        boolean r111 = true;
    L9:
        Object r104 = null;
        if (r111 == true) goto L39;
        lvb.a.e(this.f434294c, "[createFullAudioFilePath] skip, full audio disabled, recordingId=" + r101 + ", source=" + r102);
        return null;
    L39:
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L24
        File r106 = e(r100, r101);     // Catch: Throwable -> L24
        if (r106.mkdirs() == false) goto L16;
    L19:
        h r107 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.f434038a;     // Catch: Throwable -> L24
        VFSFile r108 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.b(r106, System.currentTimeMillis() + ".ogg");     // Catch: Throwable -> L24
        if (r108.exists() == true) goto L22;
        r108.createNewFile();     // Catch: Throwable -> L24
    L22:
        Object r109 = Result.m9449constructorimpl(r108.getAbsolutePath());     // Catch: Throwable -> L24
    L26:
        Throwable r112 = Result.m9452exceptionOrNullimpl(r109);
        if (r112 == null) goto L34;
        lvb.a.c(this.f434294c, "[createFullAudioFilePath] failed, recordingId=" + r101 + ", error=" + r112);
        String r113 = r112.getClass().getSimpleName();
        String r114 = r112.getMessage();
        if (r114 == null) goto L32;
        r103 = r114;
    L32:
        f("full_audio_file_create_failed", r113, r103);
    L34:
        if (Result.m9455isFailureimpl(r109) == true) goto L38;
        r104 = r109;
    L38:
        return (String) r104;
    L16:
        if (r106.exists() == true) goto L19;
        lvb.a.b(this.f434294c, "[createFullAudioFilePath] make fullDir failed, dir=" + r106.getAbsolutePath());     // Catch: Throwable -> L24
        f("full_audio_file_create_failed", "make_full_dir_failed", "");     // Catch: Throwable -> L24
        return null;
    L24:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L26
    L5:
        pub.a r116 = (pub.a) OfficeSDKManager.getHostGlobalService(pub.a.class);
        if (r116 == null) goto L8;
        r111 = r116.F(r102);
        goto L9
    L8:
        r111 = false;
        goto L9
    }

    public final Object d(byte[] r110, int r111, int r112, Continuation<? super Result<ovb.a>> r113) {
        if ((r113 instanceof MmRecordingAudioPersistent$persistentAudioToFile$1) == false) goto L7;
        MmRecordingAudioPersistent$persistentAudioToFile$1 r100 = (MmRecordingAudioPersistent$persistentAudioToFile$1) r113;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r114 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        ResultKt.throwOnFailure(r114);
    L18:
        return ((Result) r114).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r114);
        ExecutorCoroutineDispatcher r115 = this.f434295d;
        MmRecordingAudioPersistent$persistentAudioToFile$2 r104 = new MmRecordingAudioPersistent$persistentAudioToFile$2(this, r111, r112, r110, null);
        r100.label = 1;
        r114 = BuildersKt.withContext(r115, r104, r100);
        if (r114 != r102) goto L18;
        return r102;
    L7:
        r100 = new MmRecordingAudioPersistent$persistentAudioToFile$1(this, r113);
        goto L8
    }
}

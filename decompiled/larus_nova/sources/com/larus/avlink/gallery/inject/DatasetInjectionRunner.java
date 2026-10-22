package com.larus.avlink.gallery.inject;

import android.media.MediaMetadataRetriever;
import androidx.camera.video.AudioStats;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.avlink.api.DatasetVideoRatio;
import com.larus.avlink.api.DatasetVideoResolution;
import com.larus.avlink.gallery.business.MediaLifecycleStateManager;
import com.larus.avlink.gallery.coordinator.MediaSyncCoordinator;
import com.larus.avlink.gallery.database.AlbumDataBaseHelper;
import com.larus.avlink.gallery.executor.MediaProcessingExecutor;
import com.larus.avlink.gallery.j;
import com.larus.avlink.gallery.model.MediaLifecycleState;
import com.larus.avlink.gallery.model.MediaMetadata;
import com.larus.avlink.gallery.processor.e;
import com.larus.dora.api.model.MediaInfo;
import com.larus.utils.logger.FLogger;
import com.mammon.speechaudiosdk.session.type.SpeechCode;
import f06.d;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes25.dex */
public final class DatasetInjectionRunner {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DatasetInjectionRunner f292593a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineScope f292594b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final MediaLifecycleStateManager f292595c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e f292596d = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f292597a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f292598b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f292597a == r101.f292597a) goto L12;
            return false;
        L12:
            if (this.f292598b == r101.f292598b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f292597a;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            long r102 = this.f292598b;
            return r101 + ((int) (r102 ^ (r102 >>> 32)));
        }

        public final String toString() {
            return "MediaIdentity(mediaId=" + this.f292597a + ", createTime=" + this.f292598b + ')';
        }

        public a(long r100, long r101) {
            this.f292597a = r100;
            this.f292598b = r101;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f292599a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f292600b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f292601c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f292602d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f292603e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f292604f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f292599a == r101.f292599a) goto L12;
            return false;
        L12:
            if (this.f292600b == r101.f292600b) goto L15;
            return false;
        L15:
            if (this.f292601c == r101.f292601c) goto L18;
            return false;
        L18:
            if (this.f292602d == r101.f292602d) goto L21;
            return false;
        L21:
            if (this.f292603e == r101.f292603e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f292604f, r101.f292604f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f292599a;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            long r102 = this.f292600b;
            int r103 = (((((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.f292601c) * 31) + this.f292602d) * 31;
            long r104 = this.f292603e;
            return ((r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31) + this.f292604f.hashCode();
        }

        public final String toString() {
            return "VideoModel(mediaId=" + this.f292599a + ", createTime=" + this.f292600b + ", width=" + this.f292601c + ", height=" + this.f292602d + ", durationMs=" + this.f292603e + ", source=" + this.f292604f + ')';
        }

        public b(long r100, long r101, int r102, int r103, long r104, String r110) {
            Intrinsics.checkNotNullParameter(r110, "source");
            this.f292599a = r100;
            this.f292600b = r101;
            this.f292601c = r102;
            this.f292602d = r103;
            this.f292603e = r104;
            this.f292604f = r110;
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f292605a = null;

        static {
            int[] r100 = new int[MediaLifecycleState.values().length];
            r100[MediaLifecycleState.COMPLETED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[MediaLifecycleState.FAILED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f292605a = r100;
        }
    }

    public DatasetInjectionRunner() {
    }

    static {
        f292593a = new DatasetInjectionRunner();
        f292594b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        f292595c = MediaLifecycleStateManager.f292361b.a();
        f292596d = new e();
    }

    public static a f(String r100) {
        List r101 = StringsKt.split$default(StringsKt.substringBeforeLast$default(r100, '.', null, 2, null), new char[]{'_'}, false, 0, 6, null);
        if (r101.size() >= 3) goto L5;
        return null;
    L5:
        Long r102 = StringsKt.toLongOrNull((String) ListProtector.get(r101, 1));
        if (r102 == null) goto L16;
        long r103 = r102.longValue();
        Long r104 = StringsKt.toLongOrNull((String) ListProtector.get(r101, 2));
        if (r104 == null) goto L16;
        long r105 = r104.longValue();
        if (r103 <= 0) goto L16;
        if (r105 <= 0) goto L16;
        return new a(r103, r105);
    L16:
        return null;
    }

    public static String d(MediaMetadataRetriever r110, int r111) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {Integer.valueOf(r111)};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(Integer.valueOf(SpeechCode.SPEECH_TOKEN_NOT_SUPPORT_ONLINE));
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        d r107 = r106.preInvoke(SpeechCode.SPEECH_TOKEN_NOT_SUPPORT_ONLINE, "android/media/MediaMetadataRetriever", "extractMetadata", r110, r101, "java.lang.String", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (String) r107.f474983b;
    L21:
        return r110.extractMetadata(r111);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static final Object b(DatasetInjectionRunner r510, PolarisFileWrapper r511, Continuation r512) {
        DatasetInjectionRunner r100 = r510;
        r510.getClass();
        String r101 = "enqueue pack ok, uniqId=";
        String r102 = "processArchive returned null, path=";
        if ((r512 instanceof DatasetInjectionRunner$enqueuePack$1) == false) goto L7;
        DatasetInjectionRunner$enqueuePack$1 r103 = (DatasetInjectionRunner$enqueuePack$1) r512;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L31;
        if (r107 == 1) goto L25;
        if (r107 == 2) goto L20;
        if (r107 != 3) goto L19;
        String r108 = (String) r103.L$1;
        File r109 = (File) r103.L$0;
        ResultKt.throwOnFailure(r105);     // Catch: Throwable -> L16
        r101 = "enqueue pack ok, uniqId=";
        File r110 = r109;
        String r111 = "DatasetInjectionRunner";
        Object r112 = null;
    L89:
        FLogger.f375446a.i(r111, r101 + r108 + ", path=" + r110.getAbsolutePath());     // Catch: Throwable -> L95
        File r113 = r110;
    L129:
        Object r114 = Result.m9449constructorimpl(r108);     // Catch: Throwable -> L93
    L110:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);
        if (r115 == null) goto L144;
        FLogger.f375446a.e(r111, "enqueue pack failed, path=" + r113.getAbsolutePath(), r115);
        return r112;
    L144:
        return r114;
    L93:
        th = th;
    L108:
        r110 = r113;
    L109:
        Result.Companion r116 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        r113 = r110;
    L95:
        th = th;
    L16:
        th = th;
        r113 = r109;
    L30:
        r111 = "DatasetInjectionRunner";
    L78:
        r112 = null;
        goto L108
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        r113 = (File) r103.L$0;
        ResultKt.throwOnFailure(r105);     // Catch: Throwable -> L23
        r102 = "processArchive returned null, path=";
        String r410 = "DatasetInjectionRunner";
    L121:
        r111 = r410;
        FLogger.f375446a.w(r111, r102 + r113.getAbsolutePath());     // Catch: Throwable -> L74
        r108 = null;
        r112 = null;
    L74:
        th = th;
    L76:
        th = th;
        r111 = r410;
    L23:
        th = th;
        goto L30
    L25:
        boolean r117 = r103.Z$0;
        long r118 = r103.J$1;
        long r119 = r103.J$0;
        DatasetInjectionRunner r120 = (DatasetInjectionRunner) r103.L$3;
        String r121 = (String) r103.L$2;
        String r122 = (String) r103.L$1;
        File r123 = (File) r103.L$0;
        ResultKt.throwOnFailure(r105);     // Catch: Throwable -> L28
        String r124 = r121;
        String r125 = r122;
        r110 = r123;
        r410 = "DatasetInjectionRunner";
        boolean r126 = r117;
        r100 = r120;
    L56:
        e r127 = f292596d;     // Catch: Throwable -> L99
        String r128 = r110.getAbsolutePath();     // Catch: Throwable -> L99
        String r129 = r110.getName();     // Catch: Throwable -> L99
        MediaInfo r130 = new MediaInfo(Boxing.boxLong(r119), r124, null, null, null, null, 0, 0, AudioStats.AUDIO_AMPLITUDE_NONE, Boxing.boxLong(r110.length()), null, null, Boxing.boxLong(r118), r110.getName(), null, null, null, 118268, null);     // Catch: Throwable -> L99
        if (r126 == false) goto L59;
        boolean r131 = true;
    L60:
        r127.getClass();     // Catch: Throwable -> L99
        e.c r132 = e.f(r128, r129, r125, r130, r131);     // Catch: Throwable -> L99
        if (r132 != null) goto L82;
        MediaLifecycleStateManager r133 = f292595c;     // Catch: Throwable -> L99
        r103.L$0 = r110;     // Catch: Throwable -> L99
        r103.L$1 = null;     // Catch: Throwable -> L79
        r103.L$2 = null;     // Catch: Throwable -> L79
        r103.L$3 = null;     // Catch: Throwable -> L79
        r103.label = 2;     // Catch: Throwable -> L99
        if (r133.b(r125, "No displayable file found in archive", r103) == r106) goto L143;
        r113 = r110;
        goto L121
    L143:
        return r106;
    L99:
        th = th;
    L100:
        r111 = r410;
    L81:
        r112 = null;
        r113 = r110;
    L79:
        th = th;
        goto L100
    L82:
        r111 = r410;
        r103.L$0 = r110;     // Catch: Throwable -> L97
        r103.L$1 = r125;     // Catch: Throwable -> L97
        r112 = null;
        r103.L$2 = null;     // Catch: Throwable -> L95
        r103.L$3 = null;     // Catch: Throwable -> L95
        r103.label = 3;     // Catch: Throwable -> L95
        if (r100.e(r125, r132, r103) == r106) goto L142;
        r108 = r125;
        goto L89
    L142:
        return r106;
    L97:
        th = th;
        goto L81
    L59:
        r131 = false;
    L28:
        th = th;
        r113 = r123;
        goto L30
    L31:
        ResultKt.throwOnFailure(r105);
        long r134 = System.currentTimeMillis();
        a r135 = f(r511.getName());
        if (r135 == null) goto L34;
        r119 = r135.f292597a;
    L35:
        if (r135 == null) goto L37;
        r134 = r135.f292598b;
    L37:
        r118 = r134;
        StringBuilder r136 = new StringBuilder();
        r136.append(r119);
        r136.append('_');
        r136.append(r118);
        r125 = r136.toString();
        if (StringsKt.endsWith(r511.getName(), ".zip", true) == false) goto L40;
        String r137 = "live_photo";
    L41:
        r126 = Intrinsics.areEqual(j.d(r137), "live_photo");
        if (r126 == false) goto L115;
        r137 = "image_pack";
    L115:
        Result.Companion r138 = Result.Companion;     // Catch: Throwable -> L105
        String r210 = r511.getName();     // Catch: Throwable -> L105
        long r139 = r511.length();     // Catch: Throwable -> L105
        r410 = "DatasetInjectionRunner";
        String r140 = StringsKt.substringBefore$default(r511.getName(), "_", null, 2, null);     // Catch: Throwable -> L103
    L101:
        th = th;
        r110 = r511;
        goto L100
    L48:
        if (StringsKt.isBlank(r140) == false) goto L50;
        r140 = "media";
    L50:
        MediaLifecycleState r310 = MediaLifecycleState.DOWNLOAD;     // Catch: Throwable -> L101
        String r311 = r511.getAbsolutePath();     // Catch: Throwable -> L101
        long r141 = r119;
        MediaMetadata r142 = new MediaMetadata(r125, r141, null, r210, Boxing.boxLong(r139), r137, 0, 0, 0, 0, 0, AudioStats.AUDIO_AMPLITUDE_NONE, r118, null, r140, r310, null, null, r311, null, null, null, null, 0, 16461764, null);     // Catch: Throwable -> L101
        AlbumDataBaseHelper r143 = AlbumDataBaseHelper.f292393a;     // Catch: Throwable -> L101
        r110 = r511;
        r103.L$0 = r110;     // Catch: Throwable -> L99
        r103.L$1 = r125;     // Catch: Throwable -> L99
        r103.L$2 = r137;     // Catch: Throwable -> L99
        r103.L$3 = r100;     // Catch: Throwable -> L99
        r103.J$0 = r119;     // Catch: Throwable -> L99
        r103.J$1 = r118;     // Catch: Throwable -> L99
        r103.Z$0 = r126;     // Catch: Throwable -> L99
        r103.label = 1;     // Catch: Throwable -> L99
        if (r143.h(r142, r103) == r106) goto L141;
        r124 = r137;
        goto L56
    L141:
        return r106;
    L103:
        th = th;
        r110 = r511;
        r112 = null;
        r111 = r410;
    L105:
        th = th;
        r110 = r511;
        r111 = "DatasetInjectionRunner";
        goto L81
    L40:
        r137 = "image_pack";
        goto L41
    L34:
        r119 = r134;
    L7:
        r103 = new DatasetInjectionRunner$enqueuePack$1(r100, r512);
        goto L8
    }

    public static final Object c(DatasetInjectionRunner r210, PolarisFileWrapper r211, Continuation r212) {
        r210.getClass();
        if ((r212 instanceof DatasetInjectionRunner$enqueueVideoMp4$1) == false) goto L7;
        DatasetInjectionRunner$enqueueVideoMp4$1 r100 = (DatasetInjectionRunner$enqueueVideoMp4$1) r212;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        DatasetInjectionRunner$enqueueVideoMp4$1 r102 = r100;
        Object r103 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        boolean r106 = true;
        if (r105 == 0) goto L61;
        if (r105 == 1) goto L19;
        if (r105 != 2) goto L18;
        int r107 = r102.I$3;
        int r108 = r102.I$2;
        int r109 = r102.I$1;
        int r110 = r102.I$0;
        DatasetInjectionRunner r111 = (DatasetInjectionRunner) r102.L$6;
        String r112 = (String) r102.L$5;
        Pair r113 = (Pair) r102.L$4;
        b r114 = (b) r102.L$3;
        DatasetVideoRatio r115 = (DatasetVideoRatio) r102.L$2;
        DatasetVideoResolution r116 = (DatasetVideoResolution) r102.L$1;
        File r117 = (File) r102.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L15
        String r118 = "DatasetInjectionRunner";
    L186:
        r111.getClass();     // Catch: Throwable -> L43
        MediaProcessingExecutor r119 = MediaSyncCoordinator.d();     // Catch: Throwable -> L43
        int r120 = MediaProcessingExecutor.f292540k;     // Catch: Throwable -> L43
        r119.a(r112, false);     // Catch: Throwable -> L43
        FLogger r121 = FLogger.f375446a;     // Catch: Throwable -> L43
        StringBuilder r122 = new StringBuilder("enqueue mp4 ok, uniqId=");     // Catch: Throwable -> L43
        r122.append(r112);     // Catch: Throwable -> L43
        r122.append(", output=");     // Catch: Throwable -> L43
        r122.append(r108);     // Catch: Throwable -> L43
        r122.append(Permission.EXECUTE);     // Catch: Throwable -> L43
        r122.append(r107);     // Catch: Throwable -> L43
        r122.append(" (setting=");     // Catch: Throwable -> L43
        r122.append(r116.getDisplayName());     // Catch: Throwable -> L43
        r122.append('/');     // Catch: Throwable -> L43
        r122.append(r115.getDisplayName());     // Catch: Throwable -> L43
        r122.append(", mapped=");     // Catch: Throwable -> L43
        r122.append(r110);     // Catch: Throwable -> L43
        r122.append(Permission.EXECUTE);     // Catch: Throwable -> L43
        r122.append(r109);     // Catch: Throwable -> L43
        r122.append("), encoded=");     // Catch: Throwable -> L43
        if (r113 == null) goto L32;
        Integer r123 = (Integer) r113.getFirst();     // Catch: Throwable -> L43
    L33:
        r122.append(r123);     // Catch: Throwable -> L43
        r122.append(Permission.EXECUTE);     // Catch: Throwable -> L43
        if (r113 == null) goto L36;
        Integer r124 = (Integer) r113.getSecond();     // Catch: Throwable -> L43
    L37:
        r122.append(r124);     // Catch: Throwable -> L43
        r122.append(", ");     // Catch: Throwable -> L43
        r122.append(r114.f292603e);     // Catch: Throwable -> L43
        r122.append("ms, source=");     // Catch: Throwable -> L43
        r122.append(r114.f292604f);     // Catch: Throwable -> L43
        r122.append(", path=");     // Catch: Throwable -> L43
        r122.append(r117.getAbsolutePath());     // Catch: Throwable -> L43
        String r125 = r118;
        r121.i(r125, r122.toString());     // Catch: Throwable -> L41
        Object r126 = Result.m9449constructorimpl(r112);     // Catch: Throwable -> L41
    L56:
        Throwable r127 = Result.m9452exceptionOrNullimpl(r126);
        if (r127 == null) goto L211;
        FLogger.f375446a.e(r125, "enqueue mp4 failed, path=" + r117.getAbsolutePath(), r127);
        return null;
    L211:
        return r126;
    L41:
        th = th;
    L54:
        File r128 = r117;
    L55:
        Result.Companion r129 = Result.Companion;
        r126 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        r117 = r128;
        goto L56
    L36:
        r124 = null;
        goto L37
    L32:
        r123 = null;
    L43:
        th = th;
        r125 = r118;
    L15:
        th = th;
        r125 = "DatasetInjectionRunner";
        goto L54
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        int r130 = r102.I$3;
        int r131 = r102.I$2;
        int r132 = r102.I$1;
        int r133 = r102.I$0;
        DatasetInjectionRunner r134 = (DatasetInjectionRunner) r102.L$6;
        String r135 = (String) r102.L$5;
        Pair r136 = (Pair) r102.L$4;
        b r137 = (b) r102.L$3;
        DatasetVideoRatio r138 = (DatasetVideoRatio) r102.L$2;
        DatasetVideoResolution r139 = (DatasetVideoResolution) r102.L$1;
        final File r140 = (File) r102.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L52
        MediaLifecycleStateManager r141 = f292595c;     // Catch: Throwable -> L49
        MediaLifecycleState r142 = MediaLifecycleState.DOWNLOADED_TEMP;     // Catch: Throwable -> L49
        r118 = "DatasetInjectionRunner";
        Function1 r143 = new com.larus.avlink.gallery.inject.a(r140);     // Catch: Throwable -> L47
        r102.L$0 = r140;     // Catch: Throwable -> L47
        r102.L$1 = r139;     // Catch: Throwable -> L47
        r102.L$2 = r138;     // Catch: Throwable -> L47
        r102.L$3 = r137;     // Catch: Throwable -> L47
        r102.L$4 = r136;     // Catch: Throwable -> L47
        r102.L$5 = r135;     // Catch: Throwable -> L47
        r102.L$6 = r134;     // Catch: Throwable -> L47
        r102.I$0 = r133;     // Catch: Throwable -> L47
        r102.I$1 = r132;     // Catch: Throwable -> L47
        r102.I$2 = r131;     // Catch: Throwable -> L47
        r102.I$3 = r130;     // Catch: Throwable -> L47
        r102.label = 2;     // Catch: Throwable -> L47
        File r144 = r140;
        if (MediaLifecycleStateManager.g(r141, r135, r142, r143, r102, 8) == r104) goto L210;
        r113 = r136;
        r111 = r134;
        r108 = r131;
        r109 = r132;
        r110 = r133;
        r117 = r144;
        r112 = r135;
        r114 = r137;
        r116 = r139;
        r115 = r138;
        r107 = r130;
        goto L186
    L210:
        return r104;
    L45:
        th = th;
    L46:
        r125 = r118;
    L51:
        r128 = r144;
    L47:
        th = th;
        r144 = r140;
    L49:
        th = th;
        r144 = r140;
        r125 = "DatasetInjectionRunner";
    L52:
        th = th;
        r125 = "DatasetInjectionRunner";
        r117 = r140;
        goto L54
    L61:
        ResultKt.throwOnFailure(r103);
        String r145 = r211.getName();
        List r146 = StringsKt.split$default(StringsKt.substringBeforeLast$default(r145, '.', null, 2, null), new char[]{'_'}, false, 0, 6, null);
        if (r146.size() < 8) goto L78;
        a r147 = f(r145);
        if (r147 == null) goto L78;
        Long r148 = StringsKt.toLongOrNull((String) ListProtector.get(r146, 4));
        if (r148 == null) goto L78;
        long r149 = r148.longValue();
        Integer r150 = StringsKt.toIntOrNull((String) ListProtector.get(r146, 5));
        if (r150 == null) goto L78;
        int r151 = r150.intValue();
        Integer r152 = StringsKt.toIntOrNull((String) ListProtector.get(r146, 6));
        if (r152 == null) goto L78;
        int r153 = r152.intValue();
        if (r153 <= 0) goto L78;
        if (r151 <= 0) goto L78;
        b r154 = new b(r147.f292597a, r147.f292598b, r153, r151, r149, "name");
    L80:
        if (r154 != null) goto L147;
        System.currentTimeMillis();
        MediaMetadataRetriever r155 = new MediaMetadataRetriever();
        r155.setDataSource(r211.getAbsolutePath());     // Catch: Throwable -> L133
        String r156 = d(r155, 18);     // Catch: Throwable -> L133
        if (r156 == null) goto L87;
        Integer r157 = StringsKt.toIntOrNull(r156);     // Catch: Throwable -> L133
        if (r157 == null) goto L87;
        int r158 = r157.intValue();     // Catch: Throwable -> L133
    L88:
        String r159 = d(r155, 19);     // Catch: Throwable -> L133
        if (r159 == null) goto L93;
        Integer r160 = StringsKt.toIntOrNull(r159);     // Catch: Throwable -> L133
        if (r160 == null) goto L93;
        int r161 = r160.intValue();     // Catch: Throwable -> L133
    L94:
        String r162 = d(r155, 24);     // Catch: Throwable -> L133
        if (r162 == null) goto L99;
        Integer r163 = StringsKt.toIntOrNull(r162);     // Catch: Throwable -> L133
        if (r163 == null) goto L99;
        int r164 = r163.intValue();     // Catch: Throwable -> L133
    L100:
        String r165 = d(r155, 9);     // Catch: Throwable -> L133
        if (r165 == null) goto L106;
        Long r166 = StringsKt.toLongOrNull(r165);     // Catch: Throwable -> L133
        if (r166 == null) goto L106;
        r166.longValue();     // Catch: Throwable -> L133
    L106:
        if (r164 != 90) goto L108;
    L110:
        Pair r167 = TuplesKt.to(Integer.valueOf(r161), Integer.valueOf(r158));     // Catch: Throwable -> L133
    L111:
        int r168 = ((Number) r167.component1()).intValue();     // Catch: Throwable -> L133
        int r169 = ((Number) r167.component2()).intValue();     // Catch: Throwable -> L133
        Integer r170 = Integer.valueOf(r168);     // Catch: Throwable -> L133
        if (r170.intValue() <= 0) goto L114;
        boolean r171 = true;
    L115:
        if (r171 == true) goto L118;
        r170 = null;
    L118:
        if (r170 == null) goto L120;
        r170.intValue();     // Catch: Throwable -> L133
    L120:
        Integer r172 = Integer.valueOf(r169);     // Catch: Throwable -> L133
        if (r172.intValue() > 0) goto L124;
        r106 = false;
    L124:
        if (r106 == true) goto L127;
        r172 = null;
    L127:
        if (r172 == null) goto L129;
        r172.intValue();     // Catch: Throwable -> L133
    L129:
        Intrinsics.checkNotNullParameter("probe", "source");     // Catch: Throwable -> L133
        Result.Companion r173 = Result.Companion;     // Catch: Throwable -> L138
    L131:
        r155.release();     // Catch: Throwable -> L138
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L138
        goto L147
    L114:
        r171 = false;
        goto L115
    L108:
        if (r164 == 270) goto L110;
        r167 = TuplesKt.to(Integer.valueOf(r158), Integer.valueOf(r161));     // Catch: Throwable -> L133
    L99:
        r164 = 0;
    L93:
        r161 = 0;
    L87:
        r158 = 0;
    L133:
        th = move-exception;
        FLogger.f375446a.w("DatasetInjectionRunner", "probeVideoModel failed, fallback to defaults, path=" + r211.getAbsolutePath() + ": " + th.getMessage());     // Catch: Throwable -> L140
        Intrinsics.checkNotNullParameter("default", "source");     // Catch: Throwable -> L140
        Result.Companion r174 = Result.Companion;     // Catch: Throwable -> L138
    L140:
        th = move-exception;
        Result.Companion r175 = Result.Companion;     // Catch: Throwable -> L144
        r155.release();     // Catch: Throwable -> L144
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L144
        throw th;
    L144:
        th = move-exception;
        Result.Companion r176 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        throw th;
    L138:
        th = move-exception;
        Result.Companion r177 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L147:
        MediaMetadataRetriever r178 = new MediaMetadataRetriever();
        r178.setDataSource(r211.getAbsolutePath());     // Catch: Throwable -> L168
        String r179 = d(r178, 18);     // Catch: Throwable -> L168
        if (r179 == null) goto L153;
        Integer r180 = StringsKt.toIntOrNull(r179);     // Catch: Throwable -> L168
        if (r180 == null) goto L153;
        int r181 = r180.intValue();     // Catch: Throwable -> L168
    L154:
        String r182 = d(r178, 19);     // Catch: Throwable -> L168
        if (r182 == null) goto L159;
        Integer r183 = StringsKt.toIntOrNull(r182);     // Catch: Throwable -> L168
        if (r183 == null) goto L159;
        int r184 = r183.intValue();     // Catch: Throwable -> L168
    L160:
        if (r181 <= 0) goto L163;
        if (r184 <= 0) goto L163;
        TuplesKt.to(Integer.valueOf(r181), Integer.valueOf(r184));     // Catch: Throwable -> L168
    L163:
        Result.Companion r185 = Result.Companion;     // Catch: Throwable -> L166
        r178.release();     // Catch: Throwable -> L166
        Unit r186 = Unit.INSTANCE;     // Catch: Throwable -> L166
    L164:
        Result.m9449constructorimpl(r186);     // Catch: Throwable -> L166
    L173:
        Intrinsics.checkNotNullParameter(null, "resolution");
        Intrinsics.checkNotNullParameter(null, MapBundleKey.OfflineMapKey.OFFLINE_RATION);
        int r187 = w88.c.f558659a;
        throw null;
    L159:
        r184 = 0;
    L153:
        r181 = 0;
    L166:
        th = move-exception;
        Result.Companion r188 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L168:
        th = move-exception;
        FLogger.f375446a.w("DatasetInjectionRunner", "probeEncodedSize failed, path=" + r211.getAbsolutePath() + ": " + th.getMessage());     // Catch: Throwable -> L175
        Result.Companion r189 = Result.Companion;     // Catch: Throwable -> L166
        r178.release();     // Catch: Throwable -> L166
        r186 = Unit.INSTANCE;     // Catch: Throwable -> L166
    L175:
        th = move-exception;
        Result.Companion r190 = Result.Companion;     // Catch: Throwable -> L179
        r178.release();     // Catch: Throwable -> L179
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L179
        throw th;
    L179:
        th = move-exception;
        Result.Companion r191 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        throw th;
    L78:
        r154 = null;
    L7:
        r100 = new DatasetInjectionRunner$enqueueVideoMp4$1(r210, r212);
        goto L8
    }

    public final Object e(String r100, final e.c r101, Continuation<? super Unit> r110) {
        if ((r110 instanceof DatasetInjectionRunner$completeArchive$1) == false) goto L7;
        DatasetInjectionRunner$completeArchive$1 r102 = (DatasetInjectionRunner$completeArchive$1) r110;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        DatasetInjectionRunner$completeArchive$1 r104 = r102;
        Object r111 = r104.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r104.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        r100 = (String) r104.L$0;
        ResultKt.throwOnFailure(r111);
    L21:
        MediaProcessingExecutor r107 = MediaSyncCoordinator.d();
        int r112 = MediaProcessingExecutor.f292540k;
        r107.a(r100, false);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        if (StringsKt.endsWith(StringsKt.substringAfterLast$default(r101.f292678a, '/', null, 2, null), ".mp4", true) == false) goto L17;
        final String r113 = "video_pack";
    L18:
        MediaLifecycleStateManager r108 = f292595c;
        MediaLifecycleState r109 = MediaLifecycleState.DOWNLOADED_TEMP;
        Function1 r114 = new com.larus.avlink.gallery.inject.b(r101, r113);
        r104.L$0 = r100;
        r104.label = 1;
        if (MediaLifecycleStateManager.g(r108, r100, r109, r114, r104, 8) != r105) goto L21;
        return r105;
    L17:
        r113 = "image_pack";
    L7:
        r102 = new DatasetInjectionRunner$completeArchive$1(this, r110);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x0174 -> B:20:0x00a8). Please report as a decompilation issue!!! */
    public static final Object a(DatasetInjectionRunner r110, List r111, Function1 r210, Continuation r211) {
        r110.getClass();
        if ((r211 instanceof DatasetInjectionRunner$awaitAllProcessed$1) == false) goto L7;
        DatasetInjectionRunner$awaitAllProcessed$1 r100 = (DatasetInjectionRunner$awaitAllProcessed$1) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        String r105 = "DatasetInjectionRunner";
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        Ref.LongRef r106 = (Ref.LongRef) r100.L$3;
        HashSet r107 = (HashSet) r100.L$2;
        Function1 r112 = (Function1) r100.L$1;
        List r113 = (List) r100.L$0;
        ResultKt.throwOnFailure(r102);
        List r108 = r113;
        DatasetInjectionRunner$awaitAllProcessed$1 r109 = r100;
        Function1 r114 = r112;
        String r115 = "DatasetInjectionRunner";
        Object r116 = r103;
        HashSet r117 = r107;
        Ref.LongRef r118 = r106;
    L21:
        if (r117.size() >= r108.size()) goto L53;
        Iterator r119 = r108.iterator();
        List r120 = r108;
        Function1 r121 = r114;
        HashSet r122 = r117;
        r100 = r109;
        r103 = r116;
        Ref.LongRef r123 = r118;
        r105 = r115;
        Iterator r124 = r119;
    L24:
        if (r124.hasNext() == false) goto L44;
        String r125 = (String) r124.next();
        if (r122.contains(r125) == true) goto L24;
        AlbumDataBaseHelper r126 = AlbumDataBaseHelper.f292393a;
        r100.L$0 = r120;
        r100.L$1 = r121;
        r100.L$2 = r122;
        r100.L$3 = r123;
        r100.L$4 = r124;
        r100.L$5 = r125;
        r100.label = 1;
        Object r127 = r126.o(r125, r100);
        if (r127 == r103) goto L61;
        HashSet r128 = r122;
        r102 = r127;
        Ref.LongRef r129 = r123;
        String r130 = r125;
    L31:
        MediaMetadata r131 = (MediaMetadata) r102;
        if (r131 == null) goto L34;
        MediaLifecycleState r132 = r131.getLifecycleState();
    L35:
        if (r132 != null) goto L37;
        int r133 = -1;
    L38:
        if (r133 == 1) goto L41;
        if (r133 == 2) goto L41;
        r123 = r129;
        r122 = r128;
    L41:
        r128.add(r130);
        r129.element = System.currentTimeMillis();
        r123 = r129;
        r122 = r128;
        goto L24
    L37:
        r133 = c.f292605a[r132.ordinal()];
        goto L38
    L34:
        r132 = null;
    L61:
        return r103;
    L44:
        if (r122.size() < r120.size()) goto L46;
    L52:
        r117 = r122;
        r115 = r105;
        r114 = r121;
        r108 = r120;
        goto L53
    L46:
        if ((System.currentTimeMillis() - r123.element) <= 300000) goto L48;
        FLogger.f375446a.w(r105, "awaitAllProcessed stalled: " + r122.size() + '/' + r120.size() + " done, no progress for 300000ms, giving up");
        goto L52
    L48:
        r100.L$0 = r120;
        r100.L$1 = r121;
        r100.L$2 = r122;
        r100.L$3 = r123;
        r100.L$4 = null;
        r100.L$5 = null;
        r100.label = 2;
        if (DelayKt.delay(500, r100) == r103) goto L61;
        r118 = r123;
        r115 = r105;
        r109 = r100;
        r116 = r103;
        r114 = r121;
        r117 = r122;
        r108 = r120;
    L53:
        long r134 = System.currentTimeMillis();
        FLogger.f375446a.i(r115, "awaitAllProcessed done, terminal=" + r117.size() + '/' + r108.size() + ", endTime=" + r134);
        r114.invoke(Boxing.boxLong(r134));
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r130 = (String) r100.L$5;
        r124 = (Iterator) r100.L$4;
        r129 = (Ref.LongRef) r100.L$3;
        r128 = (HashSet) r100.L$2;
        r121 = (Function1) r100.L$1;
        r120 = (List) r100.L$0;
        ResultKt.throwOnFailure(r102);
        goto L31
    L16:
        ResultKt.throwOnFailure(r102);
        if (r111.isEmpty() == false) goto L19;
        FLogger.f375446a.i("DatasetInjectionRunner", "awaitAllProcessed skipped, nothing enqueued");
        return Unit.INSTANCE;
    L19:
        HashSet r135 = new HashSet(r111.size());
        Ref.LongRef r136 = new Ref.LongRef();
        r136.element = System.currentTimeMillis();
        r118 = r136;
        r115 = "DatasetInjectionRunner";
        r109 = r100;
        r116 = r103;
        r114 = r210;
        r117 = r135;
        r108 = r111;
    L7:
        r100 = new DatasetInjectionRunner$awaitAllProcessed$1(r110, r211);
        goto L8
    }
}

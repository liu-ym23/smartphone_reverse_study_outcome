package com.obric.audio.continuous_talk;

import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.mammon.audiosdk.SAMICore;
import com.mammon.audiosdk.enums.SAMICoreDataType;
import com.mammon.audiosdk.enums.SAMICoreIdentify;
import com.mammon.audiosdk.enums.SAMICorePropertyId;
import com.mammon.audiosdk.structures.SAMICoreAudioBuffer;
import com.mammon.audiosdk.structures.SAMICoreBlock;
import com.mammon.audiosdk.structures.SAMICoreExtractorCreateParam;
import com.mammon.audiosdk.structures.SAMICoreExtractorParam;
import com.mammon.audiosdk.structures.SAMICoreFeature;
import com.mammon.audiosdk.structures.SAMICoreFeatureArray;
import com.mammon.audiosdk.structures.SAMICoreFeatureSet;
import com.mammon.audiosdk.structures.SAMICoreProperty;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes33.dex */
public final class s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f395221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SAMICore f395222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f395223c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f395224d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f395225e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f395226f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f395227g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float[] f395228h;

    public static final class a {
    }

    static {
    }

    public s0() {
        this(null);
    }

    public final boolean a() {
        if (this.f395224d == true) goto L5;
    L74:
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L11
        Result.m9449constructorimpl(Integer.valueOf(this.f395222b.SAMICoreDestroyHandle()));     // Catch: Throwable -> L11
    L13:
        this.f395225e = 16000;
        this.f395226f = 1;
        this.f395227g = 8000;
        SAMICoreExtractorCreateParam r101 = new SAMICoreExtractorCreateParam();
        r101.sampleRate = 16000;
        r101.numChannel = 1;
        r101.maxBlockSize = this.f395227g;
        int r102 = this.f395222b.SAMICoreCreateHandleByIdentify(SAMICoreIdentify.SAMICoreIdentify_Extractor_FLUTEVAD, r101);
        boolean r103 = false;
        if (r102 == 0) goto L17;
        FLogger.f375446a.e("ObricVadModel", "Create SAMICoreIdentify_Extractor_FLUTEVAD failed, ret=" + r102);
        this.f395224d = false;
        return false;
    L17:
        Object r104 = null;
        InputStream r105 = AppHost.f326268a.getApplication().getAssets().open("vad_model_20251124_v1.0.0.model");     // Catch: Throwable -> L27
        Intrinsics.checkNotNull(r105);     // Catch: Throwable -> L22
        byte[] r106 = ByteStreamsKt.readBytes(r105);     // Catch: Throwable -> L22
        CloseableKt.closeFinally(r105, null);     // Catch: Throwable -> L27
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L27
    L29:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L33;
        FLogger.f375446a.e("ObricVadModel", "readAssetBinary failed: vad_model_20251124_v1.0.0.model", r108);
    L33:
        if (Result.m9455isFailureimpl(r107) == true) goto L36;
        r104 = r107;
    L36:
        byte[] r109 = (byte[]) r104;
        if (r109 != null) goto L39;
    L45:
        boolean r110 = true;
    L46:
        if (r110 == false) goto L54;
        FLogger.f375446a.e("ObricVadModel", "Load model asset failed: vad_model_20251124_v1.0.0.model");
        Result.m9449constructorimpl(Integer.valueOf(this.f395222b.SAMICoreDestroyHandle()));     // Catch: Throwable -> L50
    L52:
        this.f395224d = false;
        return false;
    L50:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L52
    L54:
        SAMICoreProperty r112 = new SAMICoreProperty();
        SAMICorePropertyId r113 = SAMICorePropertyId.SAMICorePropertyId_LoadModelBinary;
        r112.f384359id = r113;
        r112.type = SAMICoreDataType.SAMICoreDataType_ModelBin;
        r112.dataByteArray = r109;
        r112.dataArrayLen = r109.length;
        int r114 = this.f395222b.SAMICoreSetProperty(r113, r112);
        if (r114 == 0) goto L57;
        FLogger.f375446a.e("ObricVadModel", "LoadModelBinary failed ret=" + r114);
        boolean r115 = false;
    L58:
        if (r115 == false) goto L72;
        String r116 = StringsKt.trimIndent("\n            {\n              \"likelihood_threshold\":0.5,\n              \"begin_smooth_window_ms\":480,\n              \"begin_smooth_voice_proportion\":0.5,\n              \"end_smooth_window_ms\":" + this.f395221a + ",\n              \"end_smooth_voice_proportion\":0.925\n            }\n        ");
        SAMICoreExtractorParam r117 = new SAMICoreExtractorParam();
        r117.name = "param";
        r117.strValue = r116;
        SAMICoreProperty r118 = new SAMICoreProperty();
        SAMICorePropertyId r119 = SAMICorePropertyId.SAMICorePropertyID_SetExtractorStringParameter;
        r118.f384359id = r119;
        r118.type = SAMICoreDataType.SAMICoreDataType_ExtractorParameter;
        r118.dataObjectArray = new SAMICoreExtractorParam[]{r117};
        r118.dataArrayLen = 1;
        if (this.f395222b.SAMICoreSetProperty(r119, r118) != 0) goto L68;
        r103 = true;
    L68:
        if (r103 == true) goto L70;
        FLogger.f375446a.w("ObricVadModel", "SetExtractorStringParameter failed, continue with engine defaults");
    L70:
        this.f395224d = true;
        return true;
    L72:
        Result.m9449constructorimpl(Integer.valueOf(this.f395222b.SAMICoreDestroyHandle()));     // Catch: Throwable -> L61
    L63:
        this.f395224d = false;
        return false;
    L61:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L63
    L57:
        r115 = true;
        goto L58
    L39:
        if (r109.length != 0) goto L41;
        boolean r121 = true;
    L42:
        if (r121 == true) goto L45;
        r110 = false;
        goto L46
    L41:
        r121 = false;
        goto L42
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        CloseableKt.closeFinally(r105, th);     // Catch: Throwable -> L27
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L11:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    L5:
        if (this.f395225e != 16000) goto L74;
        if (this.f395226f != 1) goto L74;
        return true;
    }

    public final boolean c() {
        Object r100 = this.f395223c;
        monitor-enter(r100);
        boolean r101 = a();     // Catch: Throwable -> L7
        monitor-exit(r100);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public final void d() {
        Object r100 = this.f395223c;
        monitor-enter(r100);
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L6
        Object r102 = Result.m9449constructorimpl(Integer.valueOf(this.f395222b.SAMICoreDestroyHandle()));     // Catch: Throwable -> L6
    L8:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);     // Catch: Throwable -> L14
        if (r103 == null) goto L11;
        FLogger.f375446a.e("ObricVadModel", "release vad model failed", r103);     // Catch: Throwable -> L14
    L11:
        this.f395224d = false;     // Catch: Throwable -> L14
        this.f395225e = 16000;     // Catch: Throwable -> L14
        this.f395226f = 1;     // Catch: Throwable -> L14
        this.f395227g = 8000;     // Catch: Throwable -> L14
        this.f395228h = null;     // Catch: Throwable -> L14
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r100);
        return;
    L14:
        th = move-exception;
        throw th;
    L6:
        th = move-exception;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L14
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L14
        goto L8
    }

    public s0(int r100) {
        this.f395221a = r100;
        this.f395222b = new SAMICore();
        this.f395223c = new Object();
        this.f395225e = 16000;
        this.f395226f = 1;
        this.f395227g = 8000;
    }

    public /* synthetic */ s0(Object r100) {
        this(800);
    }

    public final boolean b(byte[] r110, int r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, "buffer");
        Object r100 = this.f395223c;
        monitor-enter(r100);
    L63:
        th = move-exception;
        throw th;
    L5:
        boolean r101 = false;
        if (a() == true) goto L9;
        monitor-exit(r100);
        return false;
    L9:
        int r102 = RangesKt.coerceAtLeast(Math.min(r112, r110.length - r111), 0);     // Catch: Throwable -> L63
        if (r102 > 0) goto L15;
        FLogger.f375446a.w("ObricVadModel", "skip empty vad frame, sizeInBytes=" + r112 + ", offsetInBytes=" + r111);     // Catch: Throwable -> L63
        monitor-exit(r100);
        return false;
    L15:
        if (r102 <= 16000) goto L17;
        FLogger.f375446a.w("ObricVadModel", "vad frame too large, clamp to max. maxBytes=16000 actual=" + r102);     // Catch: Throwable -> L63
        r102 = 16000;
    L17:
        int r113 = r102 / 2;     // Catch: Throwable -> L63
        SAMICoreAudioBuffer r103 = new SAMICoreAudioBuffer();     // Catch: Throwable -> L63
        r103.isInterleave = 0;     // Catch: Throwable -> L63
        int r104 = this.f395226f;     // Catch: Throwable -> L63
        r103.numberChannels = r104;     // Catch: Throwable -> L63
        r103.numberSamples = r113;     // Catch: Throwable -> L63
        float[][] r105 = new float[r104][];     // Catch: Throwable -> L63
        int r106 = 0;
    L18:
        if (r106 >= r104) goto L26;
        float[] r107 = new float[r113];     // Catch: Throwable -> L63
        if (r106 != 0) goto L25;
        if (r113 <= 0) goto L25;
        ByteBuffer r108 = ByteBuffer.wrap(r110, r111, r113 * 2).order(ByteOrder.LITTLE_ENDIAN);     // Catch: Throwable -> L63
        int r109 = 0;
    L23:
        if (r109 >= r113) goto L25;
        r107[r109] = (r108.getShort() / 32767.0f) / 6.0f;     // Catch: Throwable -> L63
        r109 = r109 + 1;     // Catch: Throwable -> L63
    L25:
        Unit r114 = Unit.INSTANCE;     // Catch: Throwable -> L63
        r105[r106] = r107;     // Catch: Throwable -> L63
        r106 = r106 + 1;     // Catch: Throwable -> L63
        goto L18
    L26:
        r103.data = r105;     // Catch: Throwable -> L63
        SAMICoreBlock r115 = new SAMICoreBlock();     // Catch: Throwable -> L63
        r115.dataType = SAMICoreDataType.SAMICoreDataType_AudioBuffer;     // Catch: Throwable -> L63
        r115.numberAudioData = 1;     // Catch: Throwable -> L63
        r115.audioData = new SAMICoreAudioBuffer[]{r103};     // Catch: Throwable -> L63
        int r116 = this.f395222b.SAMICoreProcess(r115, null);     // Catch: Throwable -> L63
        if (r116 == 0) goto L31;
        FLogger.f375446a.e("ObricVadModel", "process audio data failed, ret=" + r116 + ", sampleRate=" + this.f395225e + ", maxBlockSize=" + this.f395227g + ", numberSamples=" + r113 + ", inputBytes=" + r102);     // Catch: Throwable -> L63
        monitor-exit(r100);
        return false;
    L31:
        SAMICoreProperty r117 = new SAMICoreProperty();     // Catch: Throwable -> L63
        int r118 = this.f395222b.SAMICoreGetPropertyById(SAMICorePropertyId.SAMICorePropertyID_FrameFeatures, r117);     // Catch: Throwable -> L63
        if (r118 == 0) goto L36;
        FLogger.f375446a.e("ObricVadModel", "get frame features failed, ret=" + r118);     // Catch: Throwable -> L63
        monitor-exit(r100);
        return false;
    L36:
        Object[] r119 = r117.dataObjectArray;     // Catch: Throwable -> L63
        if (r119 != null) goto L40;
        monitor-exit(r100);
        return false;
    L40:
        int r120 = r119.length;     // Catch: Throwable -> L63
        int r121 = 0;
    L41:
        if (r121 >= r120) goto L61;
        Object r122 = r119[r121];     // Catch: Throwable -> L63
        if ((r122 instanceof SAMICoreFeatureSet) == false) goto L45;
        SAMICoreFeatureSet r123 = (SAMICoreFeatureSet) r122;     // Catch: Throwable -> L63
    L46:
        if (r123 == null) goto L60;
        int r124 = r123.numFeatureTypes;     // Catch: Throwable -> L63
        int r125 = 0;
    L49:
        if (r125 >= r124) goto L60;
        SAMICoreFeatureArray r126 = r123.set[r125];     // Catch: Throwable -> L63
        if (r126.featureID != SAMICorePropertyId.SAMICorePropertyID_FrameFeature_FLUTEVAD.getValue()) goto L59;
        SAMICoreFeature[] r127 = r126.array;     // Catch: Throwable -> L63
        if (r127.length <= 0) goto L59;
        SAMICoreFeature r128 = r127[0];     // Catch: Throwable -> L63
        float[] r129 = r128.values;     // Catch: Throwable -> L63
        this.f395228h = Arrays.copyOf(r129, r129.length);     // Catch: Throwable -> L63
        if (r128.numValues <= 0) goto L57;
        r101 = true;
    L57:
        monitor-exit(r100);
        return r101;
    L59:
        r125 = r125 + 1;
    L60:
        r121 = r121 + 1;
        goto L41
    L45:
        r123 = null;
        goto L46
    L61:
        monitor-exit(r100);
        return false;
    }
}

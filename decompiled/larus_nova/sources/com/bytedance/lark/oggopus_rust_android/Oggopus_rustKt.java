package com.bytedance.lark.oggopus_rust_android;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.Intrinsics;
import oggopus_rust.proto.FuncErrorX7cd250264a8c023a;
import oggopus_rust.proto.FuncParamsX08e9d23f80c13545;
import oggopus_rust.proto.FuncParamsX0c021fdd7c0fb37f;
import oggopus_rust.proto.FuncParamsX1564c1b4b2eaf93e;
import oggopus_rust.proto.FuncParamsX17154e3229a0d50a;
import oggopus_rust.proto.FuncParamsX21b9ef75deec02da;
import oggopus_rust.proto.FuncParamsX6806fe1be2f98400;
import oggopus_rust.proto.FuncParamsX7ddd81440b9c908f;
import oggopus_rust.proto.FuncParamsX87d80ad0bc53ee0c;
import oggopus_rust.proto.FuncResultX71349210c8f0b089;
import oggopus_rust.proto.FuncResultXa6781d84def262ad;
import oggopus_rust.proto.FuncReturnX3dc8b8542df1cbb1;
import oggopus_rust.proto.FuncReturnXb05c0e03c1bfe022;
import okio.ByteString;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b\u001a \u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\b\u001a(\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\b\u001a\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bH\u0002\u001a\u0016\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0001\u001a\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0003\u001a\u000e\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\b\u001a \u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u001a\u0010\u0010\u001f\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010!\u001a\n\u0010\"\u001a\u00020#*\u00020$\u001a\n\u0010\"\u001a\u00020\r*\u00020%\u001a\n\u0010\"\u001a\u00020\u001e*\u00020&\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"CALLBACK_IDX_FREE", "", "decodeDataToWav", "", "opusData", "decodeFileToWav", "", "opusFile", "", "wavFile", "encodeDataToOpus", "pcmData", "info", "Lcom/bytedance/lark/oggopus_rust_android/OggOpusEncoderInputInfo;", "configId", "encodeFileToOpus", "pcmFile", "findLibraryName", "componentName", "getOpusWaveform", "file", "samplesCount", "isOggOpusData", "", "data", "isOggOpusFile", "muxRawOpusIntoOgg", "inputFilePath", "outputFilePath", "options", "Lcom/bytedance/lark/oggopus_rust_android/RawOpusOptions;", "setContextHoook", "contextHook", "Lcom/bytedance/lark/oggopus_rust_android/ContextHook;", "into", "Lcom/bytedance/lark/oggopus_rust_android/OggOpusCodecError;", "Loggopus_rust/proto/OggOpusCodecError;", "Loggopus_rust/proto/OggOpusEncoderInputInfo;", "Loggopus_rust/proto/RawOpusOptions;", "oggopus_rust_android_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class Oggopus_rustKt {
    public static final long CALLBACK_IDX_FREE = 0;

    public static final /* synthetic */ String access$findLibraryName(String r100) {
        return findLibraryName(r100);
    }

    public static final byte[] decodeDataToWav(byte[] r100) throws OggOpusCodecError {
        Intrinsics.checkNotNullParameter(r100, "opusData");
        MoltenFfiLibOggopusRust.Companion r101 = MoltenFfiLibOggopusRust.Companion;
        ByteString r102 = r101.buildExtra(new InvokeHookInfo("oggopus_rust", -8117217843902718851L, -1179165571, null, "decodeDataToWav"));
        ByteString.a r103 = ByteString.Companion;
        byte[] r104 = Arrays.copyOf(r100, r100.length);
        r103.getClass();
        byte[] r105 = new FuncParamsX0c021fdd7c0fb37f(ByteString.a.c(r104), r102).encode();
        long r106 = r101.getRuntime$oggopus_rust_android_release();     // Catch: RuntimeException -> L10
        Intrinsics.checkNotNull(r105);     // Catch: RuntimeException -> L10
        byte[] r107 = r101.molten_ffi_oggopus_rust_call(r106, 0, 5960278895967800478L, r105);     // Catch: RuntimeException -> L10
        FuncResultX71349210c8f0b089 r108 = FuncResultX71349210c8f0b089.ADAPTER.decode(r107);
        FuncErrorX7cd250264a8c023a r109 = r108.err;
        if (r109 != null) goto L8;
        FuncReturnXb05c0e03c1bfe022 r110 = r108.ret;
        Intrinsics.checkNotNull(r110);
        return r110.ret.toByteArray();
    L8:
        Intrinsics.checkNotNull(r109);
        throw into(r109.err);
    L10:
        e = move-exception;
        if (e.getMessage() == null) goto L16;
        DefaultCallStatusErrorHandler r111 = DefaultCallStatusErrorHandler.INSTANCE;
        String r112 = e.getMessage();
        Intrinsics.checkNotNull(r112);
        throw r111.report$oggopus_rust_android_release(new UnhandledException(r112));
    L16:
        throw DefaultCallStatusErrorHandler.INSTANCE.report$oggopus_rust_android_release(new UnhandledException("Rust panic"));
    }

    private static final synchronized String findLibraryName(String r100) {
        monitor-enter(Oggopus_rustKt.class);
        String r101 = System.getProperty("molten_ffi." + r100 + ".lib_name");     // Catch: Throwable -> L9
        if (r101 != null) goto L7;
        r101 = "lark";
    L7:
        monitor-exit(Oggopus_rustKt.class);
        return r101;
    L9:
        th = move-exception;
        throw th;
    }

    public static final RawOpusOptions into(oggopus_rust.proto.RawOpusOptions r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new RawOpusOptions(UInt.m9544constructorimpl(r100.bitrate_bps.intValue()), UInt.m9544constructorimpl(r100.frame_ms.intValue()), UInt.m9544constructorimpl(r100.channels.intValue()), UInt.m9544constructorimpl(r100.input_rate_hz.intValue()), null);
    }

    public static final boolean isOggOpusData(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        MoltenFfiLibOggopusRust.Companion r101 = MoltenFfiLibOggopusRust.Companion;
        ByteString r102 = r101.buildExtra(new InvokeHookInfo("oggopus_rust", -8117217843902718851L, -1179165571, null, "isOggOpusData"));
        ByteString.a r103 = ByteString.Companion;
        byte[] r104 = Arrays.copyOf(r100, r100.length);
        r103.getClass();
        byte[] r105 = new FuncParamsX7ddd81440b9c908f(ByteString.a.c(r104), r102).encode();
        long r106 = r101.getRuntime$oggopus_rust_android_release();     // Catch: RuntimeException -> L6
        Intrinsics.checkNotNull(r105);     // Catch: RuntimeException -> L6
        byte[] r107 = r101.molten_ffi_oggopus_rust_call(r106, 0, 1812880651975632378L, r105);     // Catch: RuntimeException -> L6
        Boolean r108 = FuncReturnX3dc8b8542df1cbb1.ADAPTER.decode(r107).ret;
        Intrinsics.checkNotNull(r108);
        return r108.booleanValue();
    L6:
        e = move-exception;
        if (e.getMessage() == null) goto L12;
        DefaultCallStatusErrorHandler r109 = DefaultCallStatusErrorHandler.INSTANCE;
        String r110 = e.getMessage();
        Intrinsics.checkNotNull(r110);
        throw r109.report$oggopus_rust_android_release(new UnhandledException(r110));
    L12:
        throw DefaultCallStatusErrorHandler.INSTANCE.report$oggopus_rust_android_release(new UnhandledException("Rust panic"));
    }

    public static final boolean isOggOpusFile(String r100) {
        Intrinsics.checkNotNullParameter(r100, "file");
        MoltenFfiLibOggopusRust.Companion r101 = MoltenFfiLibOggopusRust.Companion;
        byte[] r102 = new FuncParamsX21b9ef75deec02da(r100, r101.buildExtra(new InvokeHookInfo("oggopus_rust", -8117217843902718851L, -1179165571, null, "isOggOpusFile"))).encode();
        long r103 = r101.getRuntime$oggopus_rust_android_release();     // Catch: RuntimeException -> L6
        Intrinsics.checkNotNull(r102);     // Catch: RuntimeException -> L6
        byte[] r104 = r101.molten_ffi_oggopus_rust_call(r103, 0, -6690875367185768296L, r102);     // Catch: RuntimeException -> L6
        Boolean r105 = FuncReturnX3dc8b8542df1cbb1.ADAPTER.decode(r104).ret;
        Intrinsics.checkNotNull(r105);
        return r105.booleanValue();
    L6:
        e = move-exception;
        if (e.getMessage() == null) goto L12;
        DefaultCallStatusErrorHandler r106 = DefaultCallStatusErrorHandler.INSTANCE;
        String r107 = e.getMessage();
        Intrinsics.checkNotNull(r107);
        throw r106.report$oggopus_rust_android_release(new UnhandledException(r107));
    L12:
        throw DefaultCallStatusErrorHandler.INSTANCE.report$oggopus_rust_android_release(new UnhandledException("Rust panic"));
    }

    public static final void setContextHoook(ContextHook r100) {
        MoltenFfiLibOggopusRust.Companion.setContextHook$oggopus_rust_android_release(r100);
    }

    public static final OggOpusEncoderInputInfo into(oggopus_rust.proto.OggOpusEncoderInputInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new OggOpusEncoderInputInfo(r100.rate.longValue(), r100.channels.longValue());
    }

    public static final OggOpusCodecError into(oggopus_rust.proto.OggOpusCodecError r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new OggOpusCodecError(r100.code.longValue(), r100.message);
    }

    public static final void decodeFileToWav(String r100, String r110) throws OggOpusCodecError {
        Intrinsics.checkNotNullParameter(r100, "opusFile");
        Intrinsics.checkNotNullParameter(r110, "wavFile");
        MoltenFfiLibOggopusRust.Companion r101 = MoltenFfiLibOggopusRust.Companion;
        byte[] r102 = new FuncParamsX17154e3229a0d50a(r100, r110, r101.buildExtra(new InvokeHookInfo("oggopus_rust", -8117217843902718851L, -1179165571, null, "decodeFileToWav"))).encode();
        long r103 = r101.getRuntime$oggopus_rust_android_release();     // Catch: RuntimeException -> L9
        Intrinsics.checkNotNull(r102);     // Catch: RuntimeException -> L9
        byte[] r104 = r101.molten_ffi_oggopus_rust_call(r103, 0, -5598282515049229478L, r102);     // Catch: RuntimeException -> L9
        FuncErrorX7cd250264a8c023a r105 = FuncResultXa6781d84def262ad.ADAPTER.decode(r104).err;
        if (r105 != null) goto L7;
        return;
    L7:
        Intrinsics.checkNotNull(r105);
        throw into(r105.err);
    L9:
        e = move-exception;
        if (e.getMessage() == null) goto L15;
        DefaultCallStatusErrorHandler r111 = DefaultCallStatusErrorHandler.INSTANCE;
        String r106 = e.getMessage();
        Intrinsics.checkNotNull(r106);
        throw r111.report$oggopus_rust_android_release(new UnhandledException(r106));
    L15:
        throw DefaultCallStatusErrorHandler.INSTANCE.report$oggopus_rust_android_release(new UnhandledException("Rust panic"));
    }

    public static final byte[] getOpusWaveform(String r100, long r110) throws OggOpusCodecError {
        Intrinsics.checkNotNullParameter(r100, "file");
        MoltenFfiLibOggopusRust.Companion r101 = MoltenFfiLibOggopusRust.Companion;
        ByteString r102 = r101.buildExtra(new InvokeHookInfo("oggopus_rust", -8117217843902718851L, -1179165571, null, "getOpusWaveform"));
        byte[] r103 = new FuncParamsX08e9d23f80c13545(r100, Long.valueOf(r110), r102).encode();
        long r104 = r101.getRuntime$oggopus_rust_android_release();     // Catch: RuntimeException -> L10
        Intrinsics.checkNotNull(r103);     // Catch: RuntimeException -> L10
        byte[] r105 = r101.molten_ffi_oggopus_rust_call(r104, 0, -5433092646996487490L, r103);     // Catch: RuntimeException -> L10
        FuncResultX71349210c8f0b089 r106 = FuncResultX71349210c8f0b089.ADAPTER.decode(r105);
        FuncErrorX7cd250264a8c023a r111 = r106.err;
        if (r111 != null) goto L8;
        FuncReturnXb05c0e03c1bfe022 r107 = r106.ret;
        Intrinsics.checkNotNull(r107);
        return r107.ret.toByteArray();
    L8:
        Intrinsics.checkNotNull(r111);
        throw into(r111.err);
    L10:
        e = move-exception;
        if (e.getMessage() == null) goto L16;
        DefaultCallStatusErrorHandler r112 = DefaultCallStatusErrorHandler.INSTANCE;
        String r108 = e.getMessage();
        Intrinsics.checkNotNull(r108);
        throw r112.report$oggopus_rust_android_release(new UnhandledException(r108));
    L16:
        throw DefaultCallStatusErrorHandler.INSTANCE.report$oggopus_rust_android_release(new UnhandledException("Rust panic"));
    }

    public static final byte[] encodeDataToOpus(byte[] r100, OggOpusEncoderInputInfo r110, String r111) throws OggOpusCodecError {
        Intrinsics.checkNotNullParameter(r100, "pcmData");
        Intrinsics.checkNotNullParameter(r110, "info");
        MoltenFfiLibOggopusRust.Companion r101 = MoltenFfiLibOggopusRust.Companion;
        ByteString r102 = r101.buildExtra(new InvokeHookInfo("oggopus_rust", -8117217843902718851L, -1179165571, null, "encodeDataToOpus"));
        ByteString.a r103 = ByteString.Companion;
        byte[] r104 = Arrays.copyOf(r100, r100.length);
        r103.getClass();
        byte[] r105 = new FuncParamsX1564c1b4b2eaf93e(ByteString.a.c(r104), r110.into(), r111, r102).encode();
        long r106 = r101.getRuntime$oggopus_rust_android_release();     // Catch: RuntimeException -> L10
        Intrinsics.checkNotNull(r105);     // Catch: RuntimeException -> L10
        byte[] r107 = r101.molten_ffi_oggopus_rust_call(r106, 0, -2834221134032296532L, r105);     // Catch: RuntimeException -> L10
        FuncResultX71349210c8f0b089 r108 = FuncResultX71349210c8f0b089.ADAPTER.decode(r107);
        FuncErrorX7cd250264a8c023a r112 = r108.err;
        if (r112 != null) goto L8;
        FuncReturnXb05c0e03c1bfe022 r109 = r108.ret;
        Intrinsics.checkNotNull(r109);
        return r109.ret.toByteArray();
    L8:
        Intrinsics.checkNotNull(r112);
        throw into(r112.err);
    L10:
        e = move-exception;
        if (e.getMessage() == null) goto L16;
        DefaultCallStatusErrorHandler r113 = DefaultCallStatusErrorHandler.INSTANCE;
        String r114 = e.getMessage();
        Intrinsics.checkNotNull(r114);
        throw r113.report$oggopus_rust_android_release(new UnhandledException(r114));
    L16:
        throw DefaultCallStatusErrorHandler.INSTANCE.report$oggopus_rust_android_release(new UnhandledException("Rust panic"));
    }

    public static final void muxRawOpusIntoOgg(String r100, String r110, RawOpusOptions r111) throws OggOpusCodecError {
        Intrinsics.checkNotNullParameter(r100, "inputFilePath");
        Intrinsics.checkNotNullParameter(r110, "outputFilePath");
        MoltenFfiLibOggopusRust.Companion r101 = MoltenFfiLibOggopusRust.Companion;
        ByteString r102 = r101.buildExtra(new InvokeHookInfo("oggopus_rust", -8117217843902718851L, -1179165571, null, "muxRawOpusIntoOgg"));
        if (r111 == null) goto L5;
        oggopus_rust.proto.RawOpusOptions r112 = r111.into();
    L6:
        byte[] r103 = new FuncParamsX87d80ad0bc53ee0c(r100, r110, r112, r102).encode();
        long r104 = r101.getRuntime$oggopus_rust_android_release();     // Catch: RuntimeException -> L13
        Intrinsics.checkNotNull(r103);     // Catch: RuntimeException -> L13
        byte[] r105 = r101.molten_ffi_oggopus_rust_call(r104, 0, -8480614878311974163L, r103);     // Catch: RuntimeException -> L13
        FuncErrorX7cd250264a8c023a r106 = FuncResultXa6781d84def262ad.ADAPTER.decode(r105).err;
        if (r106 != null) goto L11;
        return;
    L11:
        Intrinsics.checkNotNull(r106);
        throw into(r106.err);
    L13:
        e = move-exception;
        if (e.getMessage() == null) goto L19;
        DefaultCallStatusErrorHandler r113 = DefaultCallStatusErrorHandler.INSTANCE;
        String r107 = e.getMessage();
        Intrinsics.checkNotNull(r107);
        throw r113.report$oggopus_rust_android_release(new UnhandledException(r107));
    L19:
        throw DefaultCallStatusErrorHandler.INSTANCE.report$oggopus_rust_android_release(new UnhandledException("Rust panic"));
    L5:
        r112 = null;
        goto L6
    }

    public static final void encodeFileToOpus(String r110, String r111, OggOpusEncoderInputInfo r112, String r113) throws OggOpusCodecError {
        Intrinsics.checkNotNullParameter(r110, "pcmFile");
        Intrinsics.checkNotNullParameter(r111, "opusFile");
        Intrinsics.checkNotNullParameter(r112, "info");
        MoltenFfiLibOggopusRust.Companion r100 = MoltenFfiLibOggopusRust.Companion;
        ByteString r101 = r100.buildExtra(new InvokeHookInfo("oggopus_rust", -8117217843902718851L, -1179165571, null, "encodeFileToOpus"));
        byte[] r102 = new FuncParamsX6806fe1be2f98400(r110, r111, r112.into(), r113, r101).encode();
        long r103 = r100.getRuntime$oggopus_rust_android_release();     // Catch: RuntimeException -> L9
        Intrinsics.checkNotNull(r102);     // Catch: RuntimeException -> L9
        byte[] r104 = r100.molten_ffi_oggopus_rust_call(r103, 0, 360199746218736909L, r102);     // Catch: RuntimeException -> L9
        FuncErrorX7cd250264a8c023a r105 = FuncResultXa6781d84def262ad.ADAPTER.decode(r104).err;
        if (r105 != null) goto L7;
        return;
    L7:
        Intrinsics.checkNotNull(r105);
        throw into(r105.err);
    L9:
        e = move-exception;
        if (e.getMessage() == null) goto L15;
        DefaultCallStatusErrorHandler r106 = DefaultCallStatusErrorHandler.INSTANCE;
        String r107 = e.getMessage();
        Intrinsics.checkNotNull(r107);
        throw r106.report$oggopus_rust_android_release(new UnhandledException(r107));
    L15:
        throw DefaultCallStatusErrorHandler.INSTANCE.report$oggopus_rust_android_release(new UnhandledException("Rust panic"));
    }
}

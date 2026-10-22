package com.larus.avatar.impl.scan.model;

import android.util.Base64;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.avatar.impl.scan.utils.AudioExtractor;
import com.larus.utils.logger.FLogger;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avatar.impl.scan.model.ScanCameraWerChecker$extractAudioFromVideo$2", f = "ScanCameraWerChecker.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ScanCameraWerChecker$extractAudioFromVideo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $videoPath;
    private /* synthetic */ Object L$0;
    int label;

    public ScanCameraWerChecker$extractAudioFromVideo$2(String r100, Continuation<? super ScanCameraWerChecker$extractAudioFromVideo$2> r101) {
        this.$videoPath = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        ScanCameraWerChecker$extractAudioFromVideo$2 r102 = new ScanCameraWerChecker$extractAudioFromVideo$2(this.$videoPath, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super String> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super String> r101) {
        return ((ScanCameraWerChecker$extractAudioFromVideo$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L34;
        ResultKt.throwOnFailure(r100);
        CoroutineScope r101 = (CoroutineScope) this.L$0;
        PolarisFileWrapper r102 = new PolarisFileWrapper(this.$videoPath);
        String r103 = null;
        if (r102.exists() == true) goto L8;
        FLogger.f375446a.e("ScanCameraWerChecker", "Video file not found: " + this.$videoPath);
        return null;
    L8:
        PolarisFileWrapper r104 = new PolarisFileWrapper(r102.getParent(), "temp_audio_" + UUID.randomUUID() + ".m4a");
        AudioExtractor.c r105 = AudioExtractor.a(new AudioExtractor(), this.$videoPath, r104.getAbsolutePath());     // Catch: Throwable -> L20
        if ((r105 instanceof AudioExtractor.c.b) == false) goto L13;
        byte[] r106 = FilesKt.readBytes(r104);     // Catch: Throwable -> L20
        String r107 = Base64.encodeToString(r106, 2);     // Catch: Throwable -> L20
        FLogger.f375446a.i("ScanCameraWerChecker", "Audio extraction completed, size: " + r106.length + " bytes");     // Catch: Throwable -> L20
        r103 = r107;
    L15:
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L24
        Boolean r109 = Boxing.boxBoolean(r104.delete());     // Catch: Throwable -> L24
    L16:
        Result.m9449constructorimpl(r109);     // Catch: Throwable -> L24
    L26:
        return r103;
    L13:
        if ((r105 instanceof AudioExtractor.c.a) == false) goto L19;
        FLogger.f375446a.e("ScanCameraWerChecker", "Audio extraction failed: " + ((AudioExtractor.c.a) r105).f291120b);     // Catch: Throwable -> L20
        goto L15
    L19:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L20
    L24:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L20:
        th = move-exception;
        FLogger.f375446a.e("ScanCameraWerChecker", "Audio extraction exception: " + th);     // Catch: Throwable -> L27
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L24
        r109 = Boxing.boxBoolean(r104.delete());     // Catch: Throwable -> L24
    L27:
        th = move-exception;
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L30
        Result.m9449constructorimpl(Boxing.boxBoolean(r104.delete()));     // Catch: Throwable -> L30
    L32:
        throw th;
    L30:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L32
    L34:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

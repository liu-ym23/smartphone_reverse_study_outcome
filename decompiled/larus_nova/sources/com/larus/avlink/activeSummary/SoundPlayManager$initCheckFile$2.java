package com.larus.avlink.activeSummary;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.avlink.n1;
import java.io.File;
import java.io.InputStream;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avlink.activeSummary.SoundPlayManager$initCheckFile$2", f = "SoundPlayManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class SoundPlayManager$initCheckFile$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $assetName;
    final /* synthetic */ Context $context;
    final /* synthetic */ File $file;
    int label;

    public SoundPlayManager$initCheckFile$2(File r100, Context r101, String r102, Continuation<? super SoundPlayManager$initCheckFile$2> r103) {
        this.$file = r100;
        this.$context = r101;
        this.$assetName = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new SoundPlayManager$initCheckFile$2(this.$file, this.$context, this.$assetName, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return ((SoundPlayManager$initCheckFile$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L31;
        ResultKt.throwOnFailure(r100);
        PolarisFileWrapper r101 = new PolarisFileWrapper(this.$file.getParentFile(), String.valueOf(UUID.randomUUID()));
        File r102 = r101.getParentFile();
        if (r102 == null) goto L7;
        Boxing.boxBoolean(r102.mkdirs());
    L7:
        InputStream r103 = this.$context.getAssets().open(this.$assetName);
        PolarisFileOutputStreamWrapper r104 = new PolarisFileOutputStreamWrapper(r101);     // Catch: Throwable -> L25
        Intrinsics.checkNotNull(r103);     // Catch: Throwable -> L20
        ByteStreamsKt.copyTo$default(r103, r104, 0, 2, null);     // Catch: Throwable -> L20
        CloseableKt.closeFinally(r104, null);     // Catch: Throwable -> L25
        CloseableKt.closeFinally(r103, null);
        File r105 = this.$file.getParentFile();
        if (r105 == null) goto L14;
        Boxing.boxBoolean(r105.mkdirs());
    L14:
        boolean r106 = r101.renameTo(this.$file);
        if (r106 == false) goto L17;
        n1.d("SummaryNotifySoundManager", "initCheckFile asset copy success, assetName=" + this.$assetName);
    L19:
        return Boxing.boxBoolean(r106);
    L17:
        n1.b("SummaryNotifySoundManager", "initCheckFile asset copy failed, assetName=" + this.$assetName);
        goto L19
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        CloseableKt.closeFinally(r104, th);     // Catch: Throwable -> L25
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        CloseableKt.closeFinally(r103, th);
        throw th;
    L31:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

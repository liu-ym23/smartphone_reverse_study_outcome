package com.larus.dora.impl.feedback;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.mammon.speechaudiosdk.session.type.SpeechCode;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.feedback.DoraGFeedbackFragment$getVideoDurationFromUri$2", f = "DoraGFeedbackFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraGFeedbackFragment$getVideoDurationFromUri$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Long>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Uri $uri;
    private /* synthetic */ Object L$0;
    int label;

    public DoraGFeedbackFragment$getVideoDurationFromUri$2(Context r100, Uri r101, Continuation<? super DoraGFeedbackFragment$getVideoDurationFromUri$2> r102) {
        this.$context = r100;
        this.$uri = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        DoraGFeedbackFragment$getVideoDurationFromUri$2 r102 = new DoraGFeedbackFragment$getVideoDurationFromUri$2(this.$context, this.$uri, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Long> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Long> r101) {
        return ((DoraGFeedbackFragment$getVideoDurationFromUri$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    public static String a(MediaMetadataRetriever r110) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {9};
        f06.b r111 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(Integer.valueOf(SpeechCode.SPEECH_TOKEN_NOT_SUPPORT_ONLINE));
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r104 = r103;
        int r105 = r104.length;
        int r106 = 0;
    L8:
        if (r106 >= r105) goto L15;
        f06.a r107 = r104[r106];
        int r112 = r106;
        int r113 = r105;
        f06.a[] r114 = r104;
        f06.d r108 = r107.preInvoke(SpeechCode.SPEECH_TOKEN_NOT_SUPPORT_ONLINE, "android/media/MediaMetadataRetriever", "extractMetadata", r110, r101, "java.lang.String", r111);     // Catch: Exception -> L22
        if (r108.f474982a == true) goto L17;
        r100.add(r107);     // Catch: Exception -> L22
    L17:
        if (r108.f474982a == false) goto L21;
        return (String) r108.f474983b;
    L21:
        return r110.extractMetadata(9);
    L14:
        r106 = r112 + 1;
        r105 = r113;
        r104 = r114;
        goto L8
    L15:
        r108 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L20;
        ResultKt.throwOnFailure(r100);
        CoroutineScope r101 = (CoroutineScope) this.L$0;
        Context r102 = this.$context;
        Uri r103 = this.$uri;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L13
        MediaMetadataRetriever r105 = new MediaMetadataRetriever();     // Catch: Throwable -> L13
        r105.setDataSource(r102, r103);     // Catch: Throwable -> L13
        String r106 = a(r105);     // Catch: Throwable -> L13
        if (r106 == null) goto L10;
        Long r107 = StringsKt.toLongOrNull(r106);     // Catch: Throwable -> L13
        if (r107 == null) goto L10;
        long r108 = r107.longValue();     // Catch: Throwable -> L13
    L11:
        r105.release();     // Catch: Throwable -> L13
        Object r109 = Result.m9449constructorimpl(Boxing.boxLong(r108 / ((long) 1000)));     // Catch: Throwable -> L13
    L15:
        Long r110 = Boxing.boxLong(0);
        if (Result.m9455isFailureimpl(r109) == true) goto L18;
        return r109;
    L18:
        return r110;
    L10:
        r108 = 0;
    L13:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

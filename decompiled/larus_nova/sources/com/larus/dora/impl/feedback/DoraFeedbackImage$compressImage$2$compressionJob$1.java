package com.larus.dora.impl.feedback;

import android.net.Uri;
import com.larus.bmhome.chat.bean.ProcessFileResultCode;
import com.larus.platform.spi.IAIChatUploadMediaService;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.model.VideoRef;
import com.tencent.connect.share.QzonePublish;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.feedback.DoraFeedbackImage$compressImage$2$compressionJob$1", f = "DoraGFeedbackViewModel.kt", i = {0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SET_PCDN_WATCH_THRESHOLD, 806}, m = "invokeSuspend", n = {QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH}, s = {"L$0"})
final class DoraFeedbackImage$compressImage$2$compressionJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ kotlinx.coroutines.i<String> $continuation;
    Object L$0;
    int label;
    final /* synthetic */ g this$0;

    public static final class a implements Function1<Integer, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f335552a;

        public a(g r100) {
            this.f335552a = r100;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Integer r100) {
            int r101 = r100.intValue();
            i r102 = this.f335552a.f335621c.f335631a.getImageSubmitCallback();
            if (r102 == null) goto L6;
            r102.c(this.f335552a.f335620b, r101);
        L6:
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DoraFeedbackImage$compressImage$2$compressionJob$1(g r100, kotlinx.coroutines.i<? super String> r101, Continuation<? super DoraFeedbackImage$compressImage$2$compressionJob$1> r102) {
        this.this$0 = r100;
        this.$continuation = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new DoraFeedbackImage$compressImage$2$compressionJob$1(this.this$0, this.$continuation, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((DoraFeedbackImage$compressImage$2$compressionJob$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r210) {
        Object r110 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r100 = this.label;
        if (r100 == 0) goto L15;
        if (r100 == 1) goto L10;
        if (r100 != 2) goto L9;
        ResultKt.throwOnFailure(r210);     // Catch: Exception -> L80
        Object r101 = r210;
    L64:
        ic8.n0 r102 = (ic8.n0) r101;     // Catch: Exception -> L80
        ProcessFileResultCode r103 = r102.f489244b;     // Catch: Exception -> L80
        if (r103 != null) goto L67;
    L69:
        boolean r111 = false;
    L70:
        if (r111 == true) goto L79;
        ic8.m0 r104 = r102.f489243a;     // Catch: Exception -> L80
        if (r104 == null) goto L74;
        String r112 = r104.f489227e;     // Catch: Exception -> L80
    L75:
        if (r112 != null) goto L77;
        r112 = "";
    L77:
        pk4.j.d("DoraGFeedbackViewModel", "compressedImagePath = ".concat(r112));     // Catch: Exception -> L80
        this.$continuation.resumeWith(Result.m9449constructorimpl(r112));     // Catch: Exception -> L80
    L83:
        return Unit.INSTANCE;
    L74:
        r112 = null;
        goto L75
    L79:
        throw new IOException("Compression failed");     // Catch: Exception -> L80
    L67:
        if (r103.isSuccess() == true) goto L69;
        r111 = true;
        goto L70
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        String r105 = (String) this.L$0;
        ResultKt.throwOnFailure(r210);     // Catch: Exception -> L13
        Object r106 = ((Result) r210).m9458unboximpl();     // Catch: Exception -> L13
    L33:
        if (Result.m9455isFailureimpl(r106) == false) goto L35;
        r106 = null;
    L35:
        String r107 = (String) r106;     // Catch: Exception -> L13
        if (r107 != null) goto L84;
    L43:
        boolean r108 = true;
    L44:
        if (r108 == false) goto L51;
        pk4.j.f("DoraGFeedbackViewModel", "compress video failed, will upload uncompressed local file. uri = " + this.this$0.f335619a);     // Catch: Exception -> L41
    L41:
        e = e;
        String r113 = r107;
    L50:
        pk4.j.g("DoraGFeedbackViewModel", "compress video error, will upload uncompressed local file. uri = " + this.this$0.f335619a, e);     // Catch: Exception -> L80
        r107 = r113;
    L51:
        this.this$0.f335628j = false;     // Catch: Exception -> L80
        if (r107 != null) goto L54;
    L57:
        boolean r114 = true;
    L58:
        if (r114 == true) goto L60;
        pk4.j.d("DoraGFeedbackViewModel", "upload compressed video path = " + r107);     // Catch: Exception -> L80
        this.$continuation.resumeWith(Result.m9449constructorimpl(r107));     // Catch: Exception -> L80
        goto L83
    L60:
        pk4.j.d("DoraGFeedbackViewModel", "upload uncompressed local video path = " + r105);     // Catch: Exception -> L80
        this.$continuation.resumeWith(Result.m9449constructorimpl(r105));     // Catch: Exception -> L80
        goto L83
    L54:
        if (r107.length() == 0) goto L57;
        r114 = false;
        goto L58
    L84:
        if (r107.length() == 0) goto L43;
        r108 = false;
    L13:
        e = e;
    L14:
        r113 = null;
        goto L50
    L15:
        ResultKt.throwOnFailure(r210);
        g r109 = this.this$0;     // Catch: Exception -> L80
        if (r109.f335624f == false) goto L61;
        int r115 = s0.f335673a;     // Catch: Exception -> L80
        String r116 = s0.a(g.a(r109), this.this$0.f335619a);     // Catch: Exception -> L80
        if (r116 != null) goto L21;
    L24:
        boolean r117 = true;
    L25:
        if (r117 == false) goto L86;
        kotlinx.coroutines.i<String> r118 = this.$continuation;     // Catch: Exception -> L80
        Result.Companion r119 = Result.Companion;     // Catch: Exception -> L80
        r118.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(new IOException("无法读取视频文件，请重新选择"))));     // Catch: Exception -> L80
        return Unit.INSTANCE;
    L86:
        t0 r120 = t0.f335676a;     // Catch: Exception -> L48
        String r121 = "compressed_video_" + System.currentTimeMillis();     // Catch: Exception -> L48
        a r122 = new a(this.this$0);     // Catch: Exception -> L48
        this.L$0 = r116;     // Catch: Exception -> L48
        this.label = 1;     // Catch: Exception -> L48
        r106 = r120.a(r116, r121, r122, this);     // Catch: Exception -> L48
        if (r106 != r110) goto L31;
        return r110;
    L31:
        r105 = r116;
    L48:
        e = e;
        r105 = r116;
        goto L14
    L21:
        if (r116.length() == 0) goto L24;
        r117 = false;
        goto L25
    L61:
        ns8.a r123 = new ns8.a(Boxing.boxInt(1080), null, Boxing.boxInt(80), null, false, VideoRef.VALUE_VIDEO_REF_CATEGORY);     // Catch: Exception -> L80
        IAIChatUploadMediaService.Companion r124 = IAIChatUploadMediaService.f365908a;     // Catch: Exception -> L80
        Uri r125 = this.this$0.f335619a;     // Catch: Exception -> L80
        this.label = 2;     // Catch: Exception -> L80
        r101 = IAIChatUploadMediaService.a.a(r124, r125, r123, false, false, null, this, 56);     // Catch: Exception -> L80
        if (r101 != r110) goto L64;
        return r110;
    L80:
        e = move-exception;
        kotlinx.coroutines.i<String> r126 = this.$continuation;
        Result.Companion r127 = Result.Companion;
        r126.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(e)));
        goto L83
    }
}

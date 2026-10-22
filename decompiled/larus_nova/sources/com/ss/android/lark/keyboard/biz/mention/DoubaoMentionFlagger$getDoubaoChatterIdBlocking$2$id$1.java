package com.ss.android.lark.keyboard.biz.mention;

import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.keyboard.viewmodel.KeyboardModel;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.keyboard.biz.mention.DoubaoMentionFlagger$getDoubaoChatterIdBlocking$2$id$1", f = "IMCommonAtStrategy.kt", i = {0}, l = {192, MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY}, m = "invokeSuspend", n = {"$this$runBlocking"}, s = {"L$0"})
final class DoubaoMentionFlagger$getDoubaoChatterIdBlocking$2$id$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public DoubaoMentionFlagger$getDoubaoChatterIdBlocking$2$id$1(Continuation<? super DoubaoMentionFlagger$getDoubaoChatterIdBlocking$2$id$1> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        DoubaoMentionFlagger$getDoubaoChatterIdBlocking$2$id$1 r102 = new DoubaoMentionFlagger$getDoubaoChatterIdBlocking$2$id$1(r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super String> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super String> r101) {
        return ((DoubaoMentionFlagger$getDoubaoChatterIdBlocking$2$id$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        Object r103 = null;
        if (r102 == 0) goto L15;
        if (r102 == 1) goto L12;
        if (r102 != 2) goto L11;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L8
    L39:
        Object r104 = Result.m9449constructorimpl((String) r100);     // Catch: Throwable -> L8
    L43:
        if (Result.m9455isFailureimpl(r104) == true) goto L46;
        r103 = r104;
    L46:
        String r105 = (String) r103;
        if (r105 != null) goto L50;
        return "";
    L50:
        return r105;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        CoroutineScope r106 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L25
    L19:
        Chatter r107 = (Chatter) r100;     // Catch: Throwable -> L25
        if (r107 == null) goto L22;
        String r108 = r107.getId();     // Catch: Throwable -> L25
    L23:
        Object r109 = Result.m9449constructorimpl(r108);     // Catch: Throwable -> L25
    L28:
        if (Result.m9455isFailureimpl(r109) == false) goto L30;
        r109 = null;
    L30:
        String r110 = (String) r109;
        if (r110 != null) goto L34;
        r110 = "";
    L34:
        if ((!StringsKt.isBlank(r110)) == false) goto L36;
        return r110;
    L36:
        DoubaoMentionFlagger$getDoubaoChatterIdBlocking$2$id$1$1$1 r111 = new DoubaoMentionFlagger$getDoubaoChatterIdBlocking$2$id$1$1$1(null);     // Catch: Throwable -> L8
        this.L$0 = null;     // Catch: Throwable -> L8
        this.label = 2;     // Catch: Throwable -> L8
        r100 = TimeoutKt.b(1500, r111, this);     // Catch: Throwable -> L8
        if (r100 != r101) goto L39;
        return r101;
    L22:
        r108 = null;
        goto L23
    L15:
        ResultKt.throwOnFailure(r100);
        CoroutineScope r112 = (CoroutineScope) this.L$0;
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L25
        KeyboardModel r114 = new KeyboardModel();     // Catch: Throwable -> L25
        SyncDataStrategy r115 = SyncDataStrategy.TRY_LOCAL;     // Catch: Throwable -> L25
        this.L$0 = r112;     // Catch: Throwable -> L25
        this.label = 1;     // Catch: Throwable -> L25
        r100 = r114.a(r115, this);     // Catch: Throwable -> L25
        if (r100 != r101) goto L19;
        return r101;
    L25:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L8:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L43
    }
}

package com.ss.android.lark.compose.chat_member_list;

import androidx.exifinterface.media.ExifInterface;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/FlowCollector;", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.compose.chat_member_list.ChatMembersViewModelKt$collectDataOrError$2", f = "ChatMembersViewModel.kt", i = {}, l = {TTVideoEngineInterface.PLAYER_OPTION_DECODE_EXTERN_INFO}, m = "invokeSuspend", n = {}, s = {})
final class ChatMembersViewModelKt$collectDataOrError$2 extends SuspendLambda implements Function3<FlowCollector<Object>, Throwable, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Throwable, Continuation<? super Unit>, Object> $onError;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public ChatMembersViewModelKt$collectDataOrError$2(Function2<? super Throwable, ? super Continuation<? super Unit>, ? extends Object> r100, Continuation<? super ChatMembersViewModelKt$collectDataOrError$2> r101) {
        this.$onError = r100;
        super(3, r101);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(FlowCollector<Object> r100, Throwable r101, Continuation<? super Unit> r102) {
        return invoke2(r100, r101, r102);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(FlowCollector<Object> r100, Throwable r101, Continuation<? super Unit> r102) {
        ChatMembersViewModelKt$collectDataOrError$2 r103 = new ChatMembersViewModelKt$collectDataOrError$2(this.$onError, r102);
        r103.L$0 = r101;
        return r103.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        Throwable r103 = (Throwable) this.L$0;
        Function2<Throwable, Continuation<? super Unit>, Object> r104 = this.$onError;
        this.label = 1;
        if (r104.invoke(r103, this) != r101) goto L12;
        return r101;
    }
}

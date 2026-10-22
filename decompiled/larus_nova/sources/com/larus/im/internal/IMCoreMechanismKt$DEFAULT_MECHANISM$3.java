package com.larus.im.internal;

import com.larus.im.internal.core.IMHandler;
import com.larus.im.internal.core.message.MessageHandler;
import com.larus.im.internal.database.entity.MessageEntity;
import com.larus.im.internal.protocol.bean.MessageBody;
import com.larus.im.internal.protocol.bean.PullSingleChainDownlinkBody;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n"}, d2 = {"<anonymous>", "", "conversationID", "", EffectConfiguration.KEY_CURSOR, "", "downlink", "Lcom/larus/im/internal/protocol/bean/PullSingleChainDownlinkBody;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.IMCoreMechanismKt$DEFAULT_MECHANISM$3", f = "IMCoreMechanism.kt", i = {0}, l = {154, 156}, m = "invokeSuspend", n = {"downlink"}, s = {"L$0"})
public final class IMCoreMechanismKt$DEFAULT_MECHANISM$3 extends SuspendLambda implements Function4<String, Long, PullSingleChainDownlinkBody, Continuation<? super Unit>, Object> {
    /* synthetic */ long J$0;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: renamed from: com.larus.im.internal.IMCoreMechanismKt$DEFAULT_MECHANISM$3$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes29.dex */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "it", "", "Lcom/larus/im/internal/database/entity/MessageEntity;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.im.internal.IMCoreMechanismKt$DEFAULT_MECHANISM$3$1", f = "IMCoreMechanism.kt", i = {}, l = {157}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<List<? extends MessageEntity>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r100) {
            super(2, r100);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            AnonymousClass1 r102 = new AnonymousClass1(r101);
            r102.L$0 = r100;
            return r102;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(List<? extends MessageEntity> r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(List<MessageEntity> r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L8;
            if (r101 != 1) goto L7;
            ResultKt.throwOnFailure(r110);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r110);
            List r102 = (List) this.L$0;
            MessageHandler r103 = MessageHandler.f347752a;
            this.label = 1;
            if (MessageHandler.s(r103, r102, false, false, false, null, this, 54) != r100) goto L12;
            return r100;
        }
    }

    public IMCoreMechanismKt$DEFAULT_MECHANISM$3(Continuation<? super IMCoreMechanismKt$DEFAULT_MECHANISM$3> r100) {
        super(4, r100);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Object invoke(String r100, Long r101, PullSingleChainDownlinkBody r102, Continuation<? super Unit> r110) {
        return invoke(r100, r101.longValue(), r102, r110);
    }

    public final Object invoke(String r100, long r101, PullSingleChainDownlinkBody r102, Continuation<? super Unit> r103) {
        IMCoreMechanismKt$DEFAULT_MECHANISM$3 r104 = new IMCoreMechanismKt$DEFAULT_MECHANISM$3(r103);
        r104.L$0 = r100;
        r104.J$0 = r101;
        r104.L$1 = r102;
        return r104.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L10;
        if (r101 == 1) goto L9;
        if (r101 != 2) goto L8;
        ResultKt.throwOnFailure(r110);
    L25:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        PullSingleChainDownlinkBody r102 = (PullSingleChainDownlinkBody) this.L$0;
        ResultKt.throwOnFailure(r110);
    L21:
        IMHandler r103 = IMHandler.f347513a;
        List<MessageBody> r104 = r102.messages;
        Map<String, MessageBody> r105 = r102.regenMessages;
        AnonymousClass1 r106 = new AnonymousClass1(null);
        this.L$0 = null;
        this.label = 2;
        if (r103.c("fetchMessage", r104, r105, r106, this) != r100) goto L25;
        return r100;
    L10:
        ResultKt.throwOnFailure(r110);
        String r111 = (String) this.L$0;
        long r107 = this.J$0;
        r102 = (PullSingleChainDownlinkBody) this.L$1;
        if (r111 != null) goto L13;
    L16:
        boolean r108 = true;
    L17:
        if (r108 == true) goto L21;
        be9.b r109 = ae9.b.a();
        this.L$0 = r102;
        this.label = 1;
        if (r109.n(r111, r107, this) != r100) goto L21;
        return r100;
    L13:
        if (StringsKt.isBlank(r111) == true) goto L16;
        r108 = false;
        goto L17
    }
}

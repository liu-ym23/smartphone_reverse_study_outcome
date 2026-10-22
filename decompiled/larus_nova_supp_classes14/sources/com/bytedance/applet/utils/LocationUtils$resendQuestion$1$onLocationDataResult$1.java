package com.bytedance.applet.utils;

import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.u1;
import com.larus.im.bean.message.Message;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.utils.LocationUtils$resendQuestion$1$onLocationDataResult$1", f = "LocationUtils.kt", i = {}, l = {47, 48}, m = "invokeSuspend", n = {}, s = {})
public final class LocationUtils$resendQuestion$1$onLocationDataResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $resendQuestionId;
    int label;

    /* JADX INFO: renamed from: com.bytedance.applet.utils.LocationUtils$resendQuestion$1$onLocationDataResult$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.applet.utils.LocationUtils$resendQuestion$1$onLocationDataResult$1$1", f = "LocationUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Message $question;
        int label;

        public AnonymousClass1(Message r1, Continuation<? super AnonymousClass1> r2) {
            this.$question = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.$question, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L16;
            ResultKt.throwOnFailure(r7);
            int r8 = i.a;
            Message r9 = this.$question;
            String r0 = com.larus.bmhome.chat.bean.d.H(r9);
            if (r0 != null) goto L7;
            r0 = "";
        L7:
            Map r1 = this.$question.getExt();
            if (r1 == null) goto L12;
            Map r2 = MapsKt.toMutableMap(r1);
            if (r2 == null) goto L12;
            r2.put("need_location", CommentScene.COMMENTSCENE_NO_AWEME);
        L13:
            u1.a.c(zh8.a.a.u1(), r9, r0, r2, null);
            return Unit.INSTANCE;
        L12:
            r2 = ILegacyChatUiServiceDelegate.b.S8(new Pair[]{TuplesKt.to("need_location", CommentScene.COMMENTSCENE_NO_AWEME)});
            goto L13
        L16:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public LocationUtils$resendQuestion$1$onLocationDataResult$1(String r1, Continuation<? super LocationUtils$resendQuestion$1$onLocationDataResult$1> r2) {
        this.$resendQuestionId = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new LocationUtils$resendQuestion$1$onLocationDataResult$1(this.$resendQuestionId, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r6);
    L21:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r6);
    L13:
        Message r7 = (Message) r6;
        if (r7 == null) goto L16;
        MainCoroutineDispatcher r2 = Dispatchers.getMain();
        AnonymousClass1 r3 = new AnonymousClass1(r7, null);
        this.label = 2;
        if (BuildersKt.withContext(r2, r3, this) != r0) goto L21;
        return r0;
    L16:
        return Unit.INSTANCE;
    L10:
        ResultKt.throwOnFailure(r6);
        IChatRepoService r8 = zh8.a.a;
        IChatRepoService r9 = zh8.a.a;
        String r4 = this.$resendQuestionId;
        this.label = 1;
        r6 = r9.E1(r4, this);
        if (r6 != r0) goto L13;
        return r0;
    }
}

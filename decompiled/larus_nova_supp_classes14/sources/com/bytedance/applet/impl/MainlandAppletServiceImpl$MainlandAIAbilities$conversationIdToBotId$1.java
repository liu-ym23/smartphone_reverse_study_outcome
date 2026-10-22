package com.bytedance.applet.impl;

import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.impl.MainlandAppletServiceImpl$MainlandAIAbilities$conversationIdToBotId$1", f = "MainlandAppletServiceImpl.kt", i = {}, l = {402}, m = "invokeSuspend", n = {}, s = {})
public final class MainlandAppletServiceImpl$MainlandAIAbilities$conversationIdToBotId$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $cvsID;
    int label;

    /* JADX INFO: renamed from: com.bytedance.applet.impl.MainlandAppletServiceImpl$MainlandAIAbilities$conversationIdToBotId$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.applet.impl.MainlandAppletServiceImpl$MainlandAIAbilities$conversationIdToBotId$1$1", f = "MainlandAppletServiceImpl.kt", i = {}, l = {404, 405}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ String $cvsID;
        int label;

        public AnonymousClass1(String r1, Continuation<? super AnonymousClass1> r2) {
            this.$cvsID = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.$cvsID, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r11);
        L18:
            List r12 = (List) r11;
            if (r12 == null) goto L23;
            String r13 = (String) CollectionsKt.firstOrNull(r12);
            if (r13 == null) goto L23;
            String r2 = this.$cvsID;
            ConcurrentHashMap r3 = x4.a.a;
            Intrinsics.checkNotNullParameter(r2, "sessionId");
            x4.a.a.putIfAbsent(r13, r2);
            return r13;
        L23:
            return "";
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r11);
        L13:
            wc9.e r14 = (wc9.e) r11;
            if (r14 == null) goto L23;
            this.label = 2;
            r11 = ic8.n.c(r14, this);
            if (r11 != r0) goto L18;
            return r0;
        L10:
            ResultKt.throwOnFailure(r11);
            IConversationRepoService r4 = RepoDispatcherDelegate.b.f();
            String r5 = this.$cvsID;
            this.label = 1;
            r11 = IConversationRepoService.a.c(r4, r5, false, null, this, 6);
            if (r11 != r0) goto L13;
            return r0;
        }
    }

    public MainlandAppletServiceImpl$MainlandAIAbilities$conversationIdToBotId$1(String r1, Continuation<? super MainlandAppletServiceImpl$MainlandAIAbilities$conversationIdToBotId$1> r2) {
        this.$cvsID = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MainlandAppletServiceImpl$MainlandAIAbilities$conversationIdToBotId$1(this.$cvsID, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        return r6;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        CoroutineDispatcher r7 = Dispatchers.getIO();
        AnonymousClass1 r2 = new AnonymousClass1(this.$cvsID, null);
        this.label = 1;
        r6 = BuildersKt.withContext(r7, r2, this);
        if (r6 != r0) goto L11;
        return r0;
    }
}

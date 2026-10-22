package com.obric.aiagent.messenger.stub;

import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes32.dex */
public final class MessageHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MessageHelper f384815a = null;

    public static final class a implements IIMCallback<List<? extends Message>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.i<List<Message>> f384816a;

        @Override // com.larus.im.callback.IIMCallback
        public final boolean mustInMain() {
            return !com.larus.im.internal.delegate.y0.a();
        }

        public a(kotlinx.coroutines.j r100) {
            this.f384816a = r100;
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onFailure(IIMError r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            Intrinsics.checkNotNullParameter(r100, "error");
            this.f384816a.resumeWith(Result.m9449constructorimpl(null));
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onSuccess(List<? extends Message> r100) {
            List<? extends Message> r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "result");
            this.f384816a.resumeWith(Result.m9449constructorimpl(r101));
        }
    }

    static {
        f384815a = new MessageHelper();
    }

    public MessageHelper() {
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.obric.aiagent.messenger.stub.l0] */
    public static void a(final String r100, final Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "questionId");
        Intrinsics.checkNotNullParameter(r101, "action");
        final long r102 = System.currentTimeMillis();
        ?? r103 = new l0(r100, r102, r101);
        Ref.BooleanRef r104 = new Ref.BooleanRef();
        n0 r105 = new n0(r100, r104, r103);
        com.larus.im.d.e().registerOnGlobalMessageObserver(r105);
        com.larus.im.d.e().m(r100, new m0(r104, r105, r103));
    }

    public final Object b(String r100, String r101, Continuation<? super List<Message>> r102) {
        if ((r102 instanceof MessageHelper$getAnswersByQueryId$1) == false) goto L7;
        MessageHelper$getAnswersByQueryId$1 r103 = (MessageHelper$getAnswersByQueryId$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        String r108 = (String) r103.L$1;
        String r109 = (String) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L19:
        List r110 = (List) r105;
        if (r110 == null) goto L22;
        return r110;
    L22:
        return CollectionsKt.emptyList();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        r103.L$0 = r100;
        r103.L$1 = r101;
        r103.label = 1;
        kotlinx.coroutines.j r111 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r103), 1);
        r111.C();
        com.larus.im.d.e().o(r100, r101, new a(r111));
        r105 = r111.B();
        if (r105 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
        DebugProbesKt.probeCoroutineSuspended(r103);
    L17:
        if (r105 != r106) goto L19;
        return r106;
    L7:
        r103 = new MessageHelper$getAnswersByQueryId$1(this, r102);
        goto L8
    }
}

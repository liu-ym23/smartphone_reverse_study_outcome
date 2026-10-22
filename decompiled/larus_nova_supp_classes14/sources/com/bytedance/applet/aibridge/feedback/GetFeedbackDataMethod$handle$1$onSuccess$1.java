package com.bytedance.applet.aibridge.feedback;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.feedback.FeedbackItem;
import com.larus.utils.logger.FLogger;
import f3.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import nuc.w0;
import ouc.d0;
import ouc.i;
import ouc.k;
import ouc.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.aibridge.feedback.GetFeedbackDataMethod$handle$1$onSuccess$1", f = "GetFeedbackDataMethod.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class GetFeedbackDataMethod$handle$1$onSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ h<AbsGetFeedbackDataMethodIDL.b> $callback;
    final /* synthetic */ AbsGetFeedbackDataMethodIDL.a $params;
    final /* synthetic */ Message $result;
    int label;
    final /* synthetic */ GetFeedbackDataMethod this$0;

    public GetFeedbackDataMethod$handle$1$onSuccess$1(Message r1, AbsGetFeedbackDataMethodIDL.a r2, h<AbsGetFeedbackDataMethodIDL.b> r3, GetFeedbackDataMethod r4, Continuation<? super GetFeedbackDataMethod$handle$1$onSuccess$1> r5) {
        this.$result = r1;
        this.$params = r2;
        this.$callback = r3;
        this.this$0 = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new GetFeedbackDataMethod$handle$1$onSuccess$1(this.$result, this.$params, this.$callback, this.this$0, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v11, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v18, types: [java.util.ArrayList] */
    public final Object invokeSuspend(Object r18) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L83;
        ResultKt.throwOnFailure(r18);
        Message r2 = this.$result;
        String r3 = this.$params.getEntityId();
        String r0 = this.$params.getEntityType();
        String r4 = this.$params.getScene();
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L68
        d0 r7 = null;
        if (r3 != null) goto L48;
        Integer r1 = r2.getFeedback();     // Catch: Throwable -> L68
        if (r1 != null) goto L11;
        FeedbackItem r6 = null;
    L31:
        Object r8 = new ArrayList();     // Catch: Throwable -> L68
        if (r6 == null) goto L34;
        r8.add(r6);     // Catch: Throwable -> L68
    L34:
        Map r9 = r2.getExt();     // Catch: Throwable -> L68
        if (r9 == null) goto L37;
        String r10 = (String) r9.get("feedback_infos");     // Catch: Throwable -> L68
    L38:
        if (r10 == null) goto L65;
        d0 r11 = k.n(xt7.d.b.e(r10));     // Catch: Throwable -> L68
        Iterator r12 = r11.keySet().iterator();     // Catch: Throwable -> L68
    L41:
        if (r12.hasNext() == false) goto L65;
        i r13 = (i) r11.get((String) r12.next());     // Catch: Throwable -> L68
        if (r13 == null) goto L45;
        d0 r14 = k.n(r13);     // Catch: Throwable -> L68
    L46:
        if (r14 == null) goto L41;
        FeedbackItem.a r15 = FeedbackItem.Companion;     // Catch: Throwable -> L68
        r15.getClass();     // Catch: Throwable -> L68
        Intrinsics.checkNotNullParameter(r14, "json");     // Catch: Throwable -> L68
        r8.add((FeedbackItem) xt7.d.b.b(r15.serializer(), r14));     // Catch: Throwable -> L68
        goto L41
    L45:
        r14 = null;
    L65:
        Object r16 = Result.constructor-impl(r8);     // Catch: Throwable -> L68
    L70:
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 != null) goto L73;
    L75:
        Throwable r19 = Result.exceptionOrNull-impl(r16);
        if (r19 == null) goto L79;
        com.larus.im.internal.delegate.a.b.e("msg_feedback", "[" + r2.getConversationId() + "][" + r2.getMessageId() + "][" + r3 + ']', r19);
        r16 = CollectionsKt.emptyList();
    L79:
        List r20 = (List) r16;
    L80:
        FLogger r21 = FLogger.a;
        r21.v("js_fb_get", "fb: " + CollectionsKt.joinToString$default(r20, null, null, null, 0, null, new b(), 31, null));
        AbsGetFeedbackDataMethodIDL.b r22 = k3.a.b(Reflection.getOrCreateKotlinClass(AbsGetFeedbackDataMethodIDL.b.class));
        this.this$0.getClass();
        AbsGetFeedbackDataMethodIDL.b(r22, r20);
        r21.v("js_fb_get", "fb_res: " + r22.toJson());
        this.$callback.b(r22, "get_feedback");
        return Unit.INSTANCE;
    L73:
        if (com.larus.im.internal.delegate.c.a.isDebug() == false) goto L75;
        r17.printStackTrace();
        com.larus.im.internal.delegate.a.b.e("message", "convert2Json failed, stack: " + ExceptionsKt.stackTraceToString(r17));
        goto L75
    L37:
        r10 = null;
        goto L38
    L11:
        int r23 = r1.intValue();     // Catch: Throwable -> L68
        Map r24 = r2.getExt();     // Catch: Throwable -> L68
        if (r24 == null) goto L16;
        String r25 = (String) r24.get("feedback_detail_type");     // Catch: Throwable -> L68
        if (r25 == null) goto L16;
        Integer r110 = StringsKt.toIntOrNull(r25);     // Catch: Throwable -> L68
    L17:
        Map r26 = r2.getExt();     // Catch: Throwable -> L68
        if (r26 == null) goto L25;
        String r27 = (String) r26.get("feedback_detail_types");     // Catch: Throwable -> L68
        if (r27 == null) goto L25;
        kuc.a.e(IntCompanionObject.INSTANCE);     // Catch: Throwable -> L68
        List r28 = zd9.i.b(r27, w0.a);     // Catch: Throwable -> L68
        if (r28 != null) goto L24;
        r28 = CollectionsKt.emptyList();     // Catch: Throwable -> L68
    L24:
        List r111 = r28;
    L26:
        Map r29 = r2.getExt();     // Catch: Throwable -> L68
        if (r29 == null) goto L29;
        String r112 = (String) r29.get("feedback_detail_content");     // Catch: Throwable -> L68
    L30:
        r6 = new FeedbackItem(r23, r110, r111, r112, null, null, null, null);     // Catch: Throwable -> L68
        goto L31
    L29:
        r112 = null;
    L25:
        r111 = null;
    L16:
        r110 = null;
        goto L17
    L48:
        Map r30 = r2.getExt();     // Catch: Throwable -> L68
        if (r30 == null) goto L66;
        String r31 = (String) r30.get("feedback_infos");     // Catch: Throwable -> L68
        if (r31 == null) goto L66;
        v r32 = xt7.d.b;     // Catch: Throwable -> L68
        d0 r33 = r32.e(r31);     // Catch: Throwable -> L68
        if ((r33 instanceof d0) == false) goto L56;
        d0 r34 = r33;     // Catch: Throwable -> L68
    L57:
        if (r34 != null) goto L59;
        r20 = CollectionsKt.emptyList();     // Catch: Throwable -> L68
        goto L80
    L59:
        Object r35 = r34.get(r3 + ':' + r4 + ':' + r0);     // Catch: Throwable -> L68
        if ((r35 instanceof d0) == false) goto L62;
        r7 = (d0) r35;     // Catch: Throwable -> L68
    L62:
        if (r7 != null) goto L64;
        r20 = CollectionsKt.emptyList();     // Catch: Throwable -> L68
        goto L80
    L64:
        FeedbackItem.a r36 = FeedbackItem.Companion;     // Catch: Throwable -> L68
        r36.getClass();     // Catch: Throwable -> L68
        Intrinsics.checkNotNullParameter(r7, "json");     // Catch: Throwable -> L68
        r8 = CollectionsKt.listOf((FeedbackItem) r32.b(r36.serializer(), r7));     // Catch: Throwable -> L68
        goto L65
    L56:
        r34 = null;
    L66:
        r20 = CollectionsKt.emptyList();     // Catch: Throwable -> L68
    L68:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L70
    L83:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

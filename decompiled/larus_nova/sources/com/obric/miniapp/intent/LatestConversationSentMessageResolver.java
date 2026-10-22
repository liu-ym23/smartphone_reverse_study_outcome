package com.obric.miniapp.intent;

import com.larus.im.bean.message.Message;
import java.util.List;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes33.dex */
public final class LatestConversationSentMessageResolver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LatestConversationSentMessageResolver f397681a = null;

    static {
        f397681a = new LatestConversationSentMessageResolver();
    }

    public LatestConversationSentMessageResolver() {
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00a5 -> B:29:0x00a8). Please report as a decompilation issue!!! */
    public final Object a(String r110, String r111, Set<String> r210, Function4<? super String, ? super Long, ? super Integer, ? super Continuation<? super List<Message>>, ? extends Object> r211, Continuation<? super Boolean> r212) {
        if ((r212 instanceof LatestConversationSentMessageResolver$isReplyToLatest$1) == false) goto L7;
        LatestConversationSentMessageResolver$isReplyToLatest$1 r100 = (LatestConversationSentMessageResolver$isReplyToLatest$1) r212;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        boolean r105 = false;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        Ref.LongRef r106 = (Ref.LongRef) r100.L$4;
        Function4<? super String, ? super Long, ? super Integer, ? super Continuation<? super List<Message>>, ? extends Object> r107 = (Function4) r100.L$3;
        Set<String> r108 = (Set) r100.L$2;
        String r112 = (String) r100.L$1;
        final String r113 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
        LatestConversationSentMessageResolver$isReplyToLatest$1 r109 = r100;
        String r114 = r112;
        final Ref.LongRef r115 = r106;
        Function4<? super String, ? super Long, ? super Integer, ? super Continuation<? super List<Message>>, ? extends Object> r116 = r107;
        Object r117 = r103;
        final Set<String> r118 = r108;
    L29:
        List r119 = (List) r102;
        Message r120 = (Message) SequencesKt.maxWithOrNull(SequencesKt.filter(SequencesKt.filter(SequencesKt.filter(CollectionsKt.asSequence(r119), new n(r113)), new o()), new p(r118)), new r(new q()));
        if (r120 == null) goto L39;
        if (Intrinsics.areEqual(r114, r120.getMessageId()) == false) goto L34;
    L35:
        r105 = true;
    L37:
        return Boxing.boxBoolean(r105);
    L34:
        if (Intrinsics.areEqual(r114, r120.getLocalMessageId()) == false) goto L37;
    L39:
        if (r119.size() < 50) goto L41;
        Long r121 = (Long) SequencesKt.minOrNull(SequencesKt.filter(SequencesKt.map(CollectionsKt.asSequence(r119), new l()), new m(r115)));
        if (r121 == null) goto L46;
        r115.element = r121.longValue();
        String r122 = r113;
    L25:
        Long r123 = Boxing.boxLong(r115.element);
        Integer r124 = Boxing.boxInt(50);
        r109.L$0 = r122;
        r109.L$1 = r114;
        r109.L$2 = r118;
        r109.L$3 = r116;
        r109.L$4 = r115;
        r109.label = 1;
        Object r125 = r116.invoke(r122, r123, r124, r109);
        if (r125 != r117) goto L28;
        return r117;
    L28:
        r113 = r122;
        r102 = r125;
        goto L29
    L46:
        return Boxing.boxBoolean(false);
    L41:
        return Boxing.boxBoolean(false);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        if (StringsKt.isBlank(r110) == true) goto L48;
        if (r111 != null) goto L18;
    L21:
        boolean r126 = true;
    L22:
        if (r126 == true) goto L48;
        Ref.LongRef r127 = new Ref.LongRef();
        r127.element = Long.MAX_VALUE;
        r116 = r211;
        r115 = r127;
        r109 = r100;
        r117 = r103;
        r122 = r110;
        r114 = r111;
        r118 = r210;
        goto L25
    L18:
        if (StringsKt.isBlank(r111) == true) goto L21;
        r126 = false;
    L48:
        return Boxing.boxBoolean(false);
    L7:
        r100 = new LatestConversationSentMessageResolver$isReplyToLatest$1(this, r212);
        goto L8
    }
}

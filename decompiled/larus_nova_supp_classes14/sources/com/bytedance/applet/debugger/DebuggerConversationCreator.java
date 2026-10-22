package com.bytedance.applet.debugger;

import com.bytedance.ai.api.DebuggerMode;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.im.bean.conversation.ConversationDeleteMode;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class DebuggerConversationCreator {

    public static final class a {
    }

    static {
    }

    public DebuggerConversationCreator() {
    }

    public final Object b(w r21, Continuation<? super x> r22) {
        w r0 = r21;
        if ((r22 instanceof DebuggerConversationCreator$create$1) == false) goto L7;
        DebuggerConversationCreator$create$1 r3 = (DebuggerConversationCreator$create$1) r22;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r3.label;
        if (r5 == 0) goto L23;
        if (r5 == 1) goto L20;
        if (r5 == 2) goto L17;
        if (r5 != 3) goto L16;
        ResultKt.throwOnFailure(r2);     // Catch: Throwable -> L62
    L58:
        Object r1 = new x.a("remote_conversation_unavailable", true);     // Catch: Throwable -> L62
    L60:
        Object r6 = Result.constructor-impl(r1);     // Catch: Throwable -> L62
    L64:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L73;
        FLogger.a.e("DebuggerConversationCreator", "create remote Debugger conversation failed", r7);
        return new x.a("remote_create_failed", true);
    L73:
        return r6;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        String r8 = (String) r3.L$2;
        DebuggerConversationCreator r9 = (DebuggerConversationCreator) r3.L$1;
        w r10 = (w) r3.L$0;
        ResultKt.throwOnFailure(r2);     // Catch: Throwable -> L62
        DebuggerConversationCreator r11 = r9;
        Object r12 = r2;
        Object r13 = r15;
    L46:
        if (r12 == null) goto L48;
        boolean r14 = true;
    L50:
        if (r14 == false) goto L52;
        r1 = new x.b(r8, r10.a);     // Catch: Throwable -> L62
        goto L60
    L52:
        if ((!StringsKt.isBlank(r8)) == false) goto L58;
        if (com.larus.im.j.f(r8) == true) goto L58;
        String r16 = r10.a;     // Catch: Throwable -> L62
        r3.L$0 = null;     // Catch: Throwable -> L62
        r3.L$1 = null;     // Catch: Throwable -> L62
        r3.L$2 = null;     // Catch: Throwable -> L62
        r3.label = 3;     // Catch: Throwable -> L62
        if (r11.a(r8, r16, r3) != r13) goto L58;
        return r13;
    L48:
        String r17 = r8;
        r0 = r10;
    L49:
        r10 = r0;
        r8 = r17;
        r14 = false;
        goto L50
    L20:
        DebuggerConversationCreator r18 = (DebuggerConversationCreator) r3.L$1;
        w r19 = (w) r3.L$0;
        ResultKt.throwOnFailure(r2);     // Catch: Throwable -> L62
        r11 = r18;
        r0 = r19;
        Object r20 = r2;
        r13 = r15;
    L32:
        wc9.e r23 = (wc9.e) r20;     // Catch: Throwable -> L62
        if (r23 == null) goto L35;
        r17 = r23.a;     // Catch: Throwable -> L62
    L36:
        if (r17 != null) goto L39;
        r17 = "";
    L39:
        if ((!StringsKt.isBlank(r17)) == false) goto L49;
        if (com.larus.im.j.f(r17) == true) goto L49;
        IConversationRepoService r24 = zh8.a.b;     // Catch: Throwable -> L62
        r3.L$0 = r0;     // Catch: Throwable -> L62
        r3.L$1 = r11;     // Catch: Throwable -> L62
        r3.L$2 = r17;     // Catch: Throwable -> L62
        r3.label = 2;     // Catch: Throwable -> L62
        r12 = IConversationRepoService.a.c(r24, r17, false, null, r3, 6);     // Catch: Throwable -> L62
        if (r12 != r13) goto L45;
        return r13;
    L45:
        r10 = r0;
        r8 = r17;
        goto L46
    L35:
        r17 = null;
        goto L36
    L23:
        ResultKt.throwOnFailure(r2);
        if (StringsKt.isBlank(r0.a) == true) goto L70;
        if (StringsKt.isBlank(r0.b) == true) goto L70;
        Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L62
        IConversationRepoService r26 = zh8.a.b;     // Catch: Throwable -> L62
        String r27 = r0.a;     // Catch: Throwable -> L62
        String r28 = r0.b;     // Catch: Throwable -> L62
        LinkedHashMap r29 = new LinkedHashMap();     // Catch: Throwable -> L62
        r29.put("doubao_miniapp_debug_flag", "true");     // Catch: Throwable -> L62
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L62
        r3.L$0 = r0;     // Catch: Throwable -> L62
        r3.L$1 = this;     // Catch: Throwable -> L62
        r3.label = 1;     // Catch: Throwable -> L62
        r13 = r15;
        r20 = IConversationRepoService.a.a(r26, r27, 3, r28, null, false, null, null, null, r29, r3, 240);     // Catch: Throwable -> L62
        if (r20 != r13) goto L31;
        return r13;
    L31:
        r11 = this;
    L70:
        return new x.a("invalid_create_request", false);
    L62:
        th = move-exception;
        Result.Companion r30 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r3 = new DebuggerConversationCreator$create$1(this, r22);
        goto L8
    }

    public final Object a(String r5, String r6, Continuation<? super Unit> r7) {
        if ((r7 instanceof DebuggerConversationCreator$cleanup$1) == false) goto L7;
        DebuggerConversationCreator$cleanup$1 r0 = (DebuggerConversationCreator$cleanup$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L17;
        if (r3 != 1) goto L16;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L13
    L25:
        Object r9 = Result.constructor-impl(Boxing.boxBoolean(((Boolean) r8).booleanValue()));     // Catch: Throwable -> L13
    L28:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L32;
        FLogger.a.e("DebuggerConversationCreator", "cleanup Debugger conversation failed", r10);
    L32:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r8);
        if (StringsKt.isBlank(r5) == true) goto L34;
        if (com.larus.im.j.f(r5) == true) goto L34;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L13
        IConversationRepoService r12 = zh8.a.b;     // Catch: Throwable -> L13
        ConversationDeleteMode r4 = ConversationDeleteMode.DeleteMode_RealDelete;     // Catch: Throwable -> L13
        r0.label = 1;     // Catch: Throwable -> L13
        r8 = r12.l(r5, r4, r6, r0);     // Catch: Throwable -> L13
        if (r8 != r2) goto L25;
        return r2;
    L34:
        return Unit.INSTANCE;
    L13:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new DebuggerConversationCreator$cleanup$1(this, r7);
        goto L8
    }

    public final Object c(String r9, DebuggerMode r10, Continuation<? super Pair<w, ? extends x>> r11) {
        if ((r11 instanceof DebuggerConversationCreator$createFromMainConversation$1) == false) goto L7;
        DebuggerConversationCreator$createFromMainConversation$1 r0 = (DebuggerConversationCreator$createFromMainConversation$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 == 1) goto L17;
        if (r3 == 2) goto L16;
        if (r3 != 3) goto L15;
        w r13 = (w) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L41:
        return TuplesKt.to(r13, r12);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        wc9.e r14 = (wc9.e) r0.L$2;
        r10 = (DebuggerMode) r0.L$1;
        String r4 = (String) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L28:
        String r15 = (String) CollectionsKt.firstOrNull((List) r12);
        if (r15 != null) goto L31;
    L42:
        return null;
    L31:
        if ((!StringsKt.isBlank(r15)) == true) goto L34;
        r15 = null;
    L34:
        if (r15 == null) goto L42;
        w r5 = new w(r15, r14.a, r10, r4);
        r0.L$0 = r5;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 3;
        r12 = b(r5, r0);
        if (r12 != r2) goto L39;
        return r2;
    L39:
        r13 = r5;
        goto L41
    L17:
        r10 = (DebuggerMode) r0.L$1;
        r9 = (String) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L21:
        wc9.e r16 = (wc9.e) r12;
        if (r16 != null) goto L24;
        return null;
    L24:
        r0.L$0 = r9;
        r0.L$1 = r10;
        r0.L$2 = r16;
        r0.label = 2;
        Object r6 = ic8.n.c(r16, r0);
        if (r6 != r2) goto L27;
        return r2;
    L27:
        r4 = r9;
        r14 = r16;
        r12 = r6;
        goto L28
    L18:
        ResultKt.throwOnFailure(r12);
        IConversationRepoService r17 = zh8.a.b;
        r0.L$0 = r9;
        r0.L$1 = r10;
        r0.label = 1;
        r12 = r17.f(r0);
        if (r12 != r2) goto L21;
        return r2;
    L7:
        r0 = new DebuggerConversationCreator$createFromMainConversation$1(this, r11);
        goto L8
    }
}

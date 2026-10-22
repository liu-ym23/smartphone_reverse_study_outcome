package com.bytedance.applet.view;

import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.google.gson.JsonObject;
import com.larus.utils.logger.FLogger;
import d3.b0;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.view.AppletFragment$setupEventListener$listener$1$onEvent$1", f = "AppletFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AppletFragment$setupEventListener$listener$1$onEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Long $eventIndex;
    final /* synthetic */ String $eventName;
    final /* synthetic */ String $eventParam;
    final /* synthetic */ boolean $isReceivedCompleted;
    int label;
    final /* synthetic */ AppletFragment this$0;

    public AppletFragment$setupEventListener$listener$1$onEvent$1(String r1, String r2, AppletFragment r3, Long r4, boolean r5, Continuation<? super AppletFragment$setupEventListener$listener$1$onEvent$1> r6) {
        this.$eventName = r1;
        this.$eventParam = r2;
        this.this$0 = r3;
        this.$eventIndex = r4;
        this.$isReceivedCompleted = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new AppletFragment$setupEventListener$listener$1$onEvent$1(this.$eventName, this.$eventParam, this.this$0, this.$eventIndex, this.$isReceivedCompleted, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L34;
        ResultKt.throwOnFailure(r11);
        FLogger r12 = FLogger.a;
        r12.i("FloatingSpeaker", "onEvent " + this.$eventName + ' ' + this.$eventParam);
        AppletFragment r0 = this.this$0;
        Long r3 = r0.j;
        if (r3 == null) goto L17;
        Long r4 = this.$eventIndex;
        boolean r5 = this.$isReceivedCompleted;
        long r6 = r3.longValue();
        r12.i("FloatingSpeaker", "lastMsgIndex = " + r6 + "  eventIndex " + r4 + ' ' + r5);
        if (r5 == false) goto L12;
        if (r4 == null) goto L12;
        if (r4.longValue() <= r6) goto L12;
        r0.j = r4;
    L12:
        if (r4 == null) goto L17;
        if (r4.longValue() >= r6) goto L17;
        r12.i("FloatingSpeaker", "history message , ignore it");
        return Unit.INSTANCE;
    L17:
        k2.m r13 = com.bytedance.assem.arch.service.e.a(this.this$0, Reflection.getOrCreateKotlinClass(k2.m.class));
        if (r13 == null) goto L32;
        k2.q r14 = r13.h();
        if (r14 == null) goto L32;
        b0 r15 = r14.getAIBridge();
        if (r15 == null) goto L32;
        JsonObject r1 = new JsonObject();
        String r2 = this.$eventParam;
        AppletFragment r7 = this.this$0;
        JSONObject r8 = new JSONObject(r2);
        Iterator<String> r9 = r8.keys();
    L25:
        if (r9.hasNext() == false) goto L30;
        String r10 = r9.next();
        if (Intrinsics.areEqual(r10, "isSend") == true) goto L28;
        r1.addProperty(r10, JSONObjectProtectorUtils.getString(r8, r10));
        goto L25
    L28:
        r1.addProperty(r10, Boxing.boxBoolean(JSONObjectProtectorUtils.getBoolean(r8, r10)));
        goto L25
    L30:
        r1.addProperty("botId", r7.h);
        Unit r16 = Unit.INSTANCE;
        r15.a("applet.chatEvent", r1);
    L32:
        return Unit.INSTANCE;
    L34:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

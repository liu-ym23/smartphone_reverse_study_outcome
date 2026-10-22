package com.obric.assistant.special_input;

import android.os.SystemClock;
import androidx.collection.LruCache;
import com.byted.cast.common.sink.ISendResultListener;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.bean.DMStateInfo;
import com.obric.aiagent.assistant.idl.bean.DMTaskState;
import com.obric.assistant.interaction.api.IKeyguardState;
import com.obric.assistant.task.ObricTaskStatusManager;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.special_input.SpecialInputAutoShowComponent$monitorAutoShowReplyPanel$1", f = "SpecialInputAutoShowComponent.kt", i = {}, l = {248}, m = "invokeSuspend", n = {}, s = {})
final class SpecialInputAutoShowComponent$monitorAutoShowReplyPanel$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SpecialInputAutoShowComponent this$0;

    /* JADX INFO: renamed from: com.obric.assistant.special_input.SpecialInputAutoShowComponent$monitorAutoShowReplyPanel$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n"}, d2 = {"<anonymous>", "Lcom/obric/aiagent/assistant/idl/bean/DMTaskState;", "dmStateInfo", "Lcom/obric/aiagent/assistant/idl/bean/DMStateInfo;", "message", "Lcom/larus/im/bean/message/Message;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.special_input.SpecialInputAutoShowComponent$monitorAutoShowReplyPanel$1$1", f = "SpecialInputAutoShowComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function3<DMStateInfo, Message, Continuation<? super DMTaskState>, Object> {
        /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;
        final /* synthetic */ SpecialInputAutoShowComponent this$0;

        public AnonymousClass1(SpecialInputAutoShowComponent r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(3, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(DMStateInfo r100, Message r101, Continuation<? super DMTaskState> r102) {
            AnonymousClass1 r103 = new AnonymousClass1(this.this$0, r102);
            r103.L$0 = r100;
            r103.L$1 = r101;
            return r103.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(DMStateInfo r100, Message r101, Continuation<? super DMTaskState> r102) {
            return invoke2(r100, r101, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L100;
            ResultKt.throwOnFailure(r110);
            DMStateInfo r111 = (DMStateInfo) this.L$0;
            Message r100 = (Message) this.L$1;
            IKeyguardState r101 = this.this$0.f392652t;
            boolean r102 = false;
            if (r101 != null) goto L7;
        L9:
            boolean r103 = false;
        L11:
            if (r103 == false) goto L51;
            if (r111 == null) goto L23;
            List<DMTaskState> r104 = r111.getActiveTasks();
            if (r104 == null) goto L23;
            Iterator<T> r105 = r104.iterator();
        L17:
            if (r105.hasNext() == false) goto L21;
            Object r106 = r105.next();
            if (com.obric.assistant.utils.l.f((DMTaskState) r106) == false) goto L17;
        L22:
            DMTaskState r107 = (DMTaskState) r106;
        L24:
            if (r107 != null) goto L28;
            FLogger.f375446a.i("SpecialInputAutoShowComponent", "no running task");
            return null;
        L28:
            if (com.obric.assistant.utils.l.e(r107) == true) goto L31;
            FLogger.f375446a.i("SpecialInputAutoShowComponent", "running task is not clarify");
            return null;
        L31:
            String r108 = com.obric.assistant.utils.l.a(r107);
            if (r108.length() != 0) goto L34;
            boolean r109 = true;
        L35:
            if (r109 == false) goto L39;
            FLogger.f375446a.i("SpecialInputAutoShowComponent", "clarify msg id is empty");
            return null;
        L39:
            if (Intrinsics.areEqual(this.this$0.f392651s.get(r108), Boxing.boxBoolean(true)) == false) goto L42;
            FLogger.f375446a.i("SpecialInputAutoShowComponent", "clarify msg id " + r108 + " is logged");
            return null;
        L42:
            laa.c r112 = (laa.c) this.this$0.f392647o.getValue();
            if (r112 != null) goto L45;
        L47:
            boolean r113 = false;
        L48:
            if (r113 == false) goto L52;
            FLogger.f375446a.i("SpecialInputAutoShowComponent", "clarify msg id " + r108 + " is not in list");
            return r107;
        L52:
            if (r100 != null) goto L55;
            FLogger.f375446a.i("SpecialInputAutoShowComponent", ISendResultListener.ERROR_MSG_DLNA_CUSTOMIZED_SERVICE_MESSAGE_NULL);
            return null;
        L55:
            String r114 = r100.getMessageId();
            if (r114 != null) goto L58;
        L59:
            r102 = true;
        L60:
            if (r102 == false) goto L64;
            FLogger.f375446a.i("SpecialInputAutoShowComponent", "message id is empty");
            return null;
        L64:
            if (r100.getMessageStatusLocal() == 21) goto L68;
            FLogger.f375446a.i("SpecialInputAutoShowComponent", "message id " + r100.getMessageId() + " has not received");
            return null;
        L68:
            if (com.obric.assistant.utils.k.c(r100) == true) goto L71;
            FLogger.f375446a.i("SpecialInputAutoShowComponent", "message is not omni message");
            return null;
        L71:
            LruCache<String, Boolean> r115 = this.this$0.f392651s;
            String r116 = r100.getMessageId();
            if (r116 != null) goto L75;
            r116 = "";
        L75:
            if (Intrinsics.areEqual(r115.get(r116), Boxing.boxBoolean(true)) == false) goto L78;
            FLogger.f375446a.i("SpecialInputAutoShowComponent", "message id " + r100.getMessageId() + " is logged");
            return null;
        L78:
            FLogger.f375446a.i("SpecialInputAutoShowComponent", "lastest msg id = " + r100.getMessageId());
            if (r107 != null) goto L94;
            if (r111 == null) goto L92;
            List<DMTaskState> r117 = r111.getActiveTasks();
            if (r117 == null) goto L92;
            Iterator<T> r118 = r117.iterator();
        L85:
            if (r118.hasNext() == false) goto L89;
            Object r119 = r118.next();
            if (com.obric.assistant.utils.l.f((DMTaskState) r119) == false) goto L85;
        L90:
            r107 = (DMTaskState) r119;
            if (r107 != null) goto L94;
        L89:
            r119 = null;
        L92:
            return null;
        L94:
            if (com.obric.assistant.utils.l.e(r107) == true) goto L96;
        L98:
            return null;
        L96:
            if (Intrinsics.areEqual(com.obric.assistant.utils.l.a(r107), r100.getMessageId()) == false) goto L98;
            return r107;
        L58:
            if (r114.length() != 0) goto L60;
        L45:
            if (r112.BL(r108) == true) goto L47;
            r113 = true;
            goto L48
        L34:
            r109 = false;
            goto L35
        L21:
            r106 = null;
        L23:
            r107 = null;
            goto L24
        L51:
            r107 = null;
            goto L52
        L7:
            if (r101.isDeviceLocked() != true) goto L9;
            r103 = true;
            goto L11
        L100:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.special_input.SpecialInputAutoShowComponent$monitorAutoShowReplyPanel$1$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SpecialInputAutoShowComponent f392663a;

        public AnonymousClass2(SpecialInputAutoShowComponent r100) {
            this.f392663a = r100;
        }

        public final Object a(DMTaskState r210, Continuation<? super Unit> r211) {
            if ((r211 instanceof SpecialInputAutoShowComponent$monitorAutoShowReplyPanel$1$2$emit$1) == false) goto L7;
            SpecialInputAutoShowComponent$monitorAutoShowReplyPanel$1$2$emit$1 r100 = (SpecialInputAutoShowComponent$monitorAutoShowReplyPanel$1$2$emit$1) r211;
            int r101 = r100.label;
            if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
            r100.label = r101 - Integer.MIN_VALUE;
        L8:
            Object r102 = r100.result;
            Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r104 = r100.label;
            boolean r105 = true;
            boolean r106 = false;
            if (r104 == 0) goto L14;
            if (r104 != 1) goto L13;
            String r107 = (String) r100.L$1;
            DMTaskState r108 = (DMTaskState) r100.L$0;
            ResultKt.throwOnFailure(r102);
            DMTaskState r110 = r108;
        L23:
            if (((Boolean) r102).booleanValue() == true) goto L26;
            FLogger.f375446a.i("SpecialInputAutoShowComponent", "cannot auto show input panel now");
            this.f392663a.f392651s.put(r107, Boxing.boxBoolean(true));
            return Unit.INSTANCE;
        L26:
            FLogger r109 = FLogger.f375446a;
            r109.i("SpecialInputAutoShowComponent", "auto show clarify task = " + com.obric.assistant.utils.l.g(r110));
            this.f392663a.f392651s.put(r107, Boxing.boxBoolean(true));
            ISpecialInputTask r111 = c.a();
            if (r111 == null) goto L29;
            ISpecialInputTask.a.a(r111, com.obric.assistant.special_input.util.j.d(ObricComplexTaskPanelType.CLARIFYING.getValue(), false, MapsKt.mapOf(TuplesKt.to("source_from", "intent_reply")), null, r110, 8), false, true, true, null, 16);
        L29:
            String r112 = sea.e.b();
            if (r112 != null) goto L32;
        L35:
            boolean r113 = true;
        L36:
            if (r113 == false) goto L38;
        L41:
            if (r112 != null) goto L43;
        L46:
            boolean r114 = true;
        L47:
            if (r114 == false) goto L49;
        L51:
            long r115 = sea.e.f541637e.get();
            if (r115 != 0) goto L55;
        L59:
            if (r106 == false) goto L62;
            r109.i("SpecialInputAutoShowComponent", "skip scrollToBottom due to recent complex task reply anchor");
            return Unit.INSTANCE;
        L62:
            laa.c r116 = (laa.c) this.f392663a.f392647o.getValue();
            if (r116 == null) goto L66;
            r116.kc();
        L66:
            return Unit.INSTANCE;
        L55:
            if ((SystemClock.elapsedRealtime() - r115) <= 2000) goto L58;
            r105 = false;
        L58:
            r106 = r105;
            goto L59
        L49:
            if (Intrinsics.areEqual(r112, r107) == false) goto L51;
        L43:
            if (r112.length() == 0) goto L46;
            r114 = false;
            goto L47
        L38:
            if (Intrinsics.areEqual(r112, r107) == true) goto L41;
            r109.i("SpecialInputAutoShowComponent", "skip scrollToBottom due to pending complex task reply target, pendingReplyMessageId=" + r112 + ", clarifyMsgId=" + r107);
            return Unit.INSTANCE;
        L32:
            if (r112.length() == 0) goto L35;
            r113 = false;
            goto L36
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r102);
            if (r210 == null) goto L17;
            String r117 = com.obric.assistant.utils.l.a(r210);
            SpecialInputAutoShowComponent r118 = this.f392663a;
            r100.L$0 = r210;
            r100.L$1 = r117;
            r100.label = 1;
            Object r119 = fga.a.C5900a.a(r118, false, false, r100, 7);
            if (r119 != r103) goto L21;
            return r103;
        L21:
            r110 = r210;
            r107 = r117;
            r102 = r119;
            goto L23
        L17:
            return Unit.INSTANCE;
        L7:
            r100 = new SpecialInputAutoShowComponent$monitorAutoShowReplyPanel$1$2$emit$1(this, r211);
            goto L8
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final /* bridge */ /* synthetic */ Object emit(Object r100, Continuation r101) {
            return a((DMTaskState) r100, r101);
        }
    }

    public SpecialInputAutoShowComponent$monitorAutoShowReplyPanel$1(SpecialInputAutoShowComponent r100, Continuation<? super SpecialInputAutoShowComponent$monitorAutoShowReplyPanel$1> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new SpecialInputAutoShowComponent$monitorAutoShowReplyPanel$1(this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((SpecialInputAutoShowComponent$monitorAutoShowReplyPanel$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
        ObricTaskStatusManager.f393357a.getClass();
        StateFlowImpl r103 = ObricTaskStatusManager.f393362f;
        SpecialInputAutoShowComponent r104 = this.this$0;
        int r105 = SpecialInputAutoShowComponent.f392639v;
        laa.c r106 = (laa.c) r104.f392647o.getValue();
        Intrinsics.checkNotNull(r106);
        kotlinx.coroutines.flow.v0 r107 = new kotlinx.coroutines.flow.v0(r103, r106.q90(), new AnonymousClass1(this.this$0, null));
        AnonymousClass2 r108 = new AnonymousClass2(this.this$0);
        this.label = 1;
        if (r107.collect(r108, this) != r101) goto L12;
        return r101;
    }
}

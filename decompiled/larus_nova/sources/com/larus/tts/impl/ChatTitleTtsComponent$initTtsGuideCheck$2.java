package com.larus.tts.impl;

import androidx.activity.result.ActivityResultCaller;
import androidx.collection.LruCache;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.ttsV2.TtsGuideDelegate;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.tts.impl.ChatTitleTtsComponent$initTtsGuideCheck$2", f = "ChatTitleTtsComponent.kt", i = {}, l = {663}, m = "invokeSuspend", n = {}, s = {})
final class ChatTitleTtsComponent$initTtsGuideCheck$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ChatTitleTtsComponent this$0;

    /* JADX INFO: renamed from: com.larus.tts.impl.ChatTitleTtsComponent$initTtsGuideCheck$2$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatTitleTtsComponent f370199a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Message f370200b;

        /* JADX INFO: renamed from: com.larus.tts.impl.ChatTitleTtsComponent$initTtsGuideCheck$2$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.tts.impl.ChatTitleTtsComponent$initTtsGuideCheck$2$1$1", f = "ChatTitleTtsComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C45011 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ com.larus.audio.ttsV2.a $it;
            final /* synthetic */ boolean $newIsTtsCheck;
            int label;
            final /* synthetic */ ChatTitleTtsComponent this$0;

            public C45011(com.larus.audio.ttsV2.a r100, boolean r101, ChatTitleTtsComponent r102, Continuation<? super C45011> r103) {
                this.$it = r100;
                this.$newIsTtsCheck = r101;
                this.this$0 = r102;
                super(2, r103);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                return new C45011(this.$it, this.$newIsTtsCheck, this.this$0, r101);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
                return invoke2(r100, r101);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
                return ((C45011) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r100) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L10;
                ResultKt.throwOnFailure(r100);
                com.larus.audio.ttsV2.a r101 = this.$it;
                boolean r102 = r101.f289910a;
                boolean r103 = this.$newIsTtsCheck;
                r101.getClass();
                ChatTitleTtsComponent r104 = this.this$0;
                int r105 = ChatTitleTtsComponent.f370179v;
                com.larus.platform.api.g0 r106 = r104.Y2();
                if (r106 == null) goto L8;
                r106.setEarphoneState(new lq9.q(r102, r103));
            L8:
                return Unit.INSTANCE;
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass1(ChatTitleTtsComponent r100, Message r101) {
            this.f370199a = r100;
            this.f370200b = r101;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r2v10 */
        /* JADX WARN: Type inference failed for: r2v11, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r2v14 */
        public final Object a(com.larus.audio.ttsV2.a r210, Continuation<? super Unit> r211) {
            if ((r211 instanceof ChatTitleTtsComponent$initTtsGuideCheck$2$1$emit$1) == false) goto L7;
            ChatTitleTtsComponent$initTtsGuideCheck$2$1$emit$1 r100 = (ChatTitleTtsComponent$initTtsGuideCheck$2$1$emit$1) r211;
            int r101 = r100.label;
            if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
            r100.label = r101 - Integer.MIN_VALUE;
        L8:
            Object r102 = r100.result;
            Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r104 = r100.label;
            boolean r105 = true;
            if (r104 == 0) goto L14;
            if (r104 != 1) goto L13;
            int r106 = r100.I$0;
            ResultKt.throwOnFailure(r102);
            ?? r107 = r106;
        L97:
            ChatTitleTtsComponent r108 = this.f370199a;
            int r109 = ChatTitleTtsComponent.f370179v;
            u7 r110 = (u7) r108.f370184l.getValue();
            if (r110 == null) goto L115;
            if (Intrinsics.areEqual(this.f370199a.f370182j.getValue(), Boxing.boxBoolean(true)) == true) goto L113;
            com.larus.platform.api.g0 r111 = this.f370199a.Y2();
            if (r111 == null) goto L108;
            lq9.q r112 = r111.getEarphoneState();
            if (r112 == null) goto L108;
            if (r112.f510350a != true) goto L108;
            boolean r113 = true;
        L109:
            if (r113 == false) goto L112;
            if (r107 != 0) goto L113;
        L112:
            r105 = false;
        L108:
            r113 = false;
        L113:
            r110.A5(r105);
        L115:
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r102);
            FLogger.f375446a.d("ChatTitleTtsComponent", "getEarphoneState: " + r210);
            if (r210.f289910a == true) goto L17;
        L35:
            boolean r114 = false;
        L36:
            ChatTitleTtsComponent r115 = this.f370199a;
            int r116 = ChatTitleTtsComponent.f370179v;
            com.larus.platform.api.g0 r117 = r115.Y2();
            if (r117 == null) goto L43;
            lq9.q r118 = r117.getEarphoneState();
            if (r118 == null) goto L43;
            if (r118.f510350a != true) goto L43;
            boolean r119 = true;
        L44:
            if (r119 == true) goto L46;
        L57:
            boolean r120 = false;
        L59:
            if (r114 == true) goto L61;
            if (r120 == true) goto L61;
        L86:
            if (r210.f289911b == false) goto L92;
            AudioServiceDelegate r121 = AudioServiceDelegate.f288288a;
            if (r121.q0() == true) goto L92;
            if (r121.D() == true) goto L92;
            ?? r122 = 1;
        L93:
            MainCoroutineDispatcher r123 = Dispatchers.getMain();
            C45011 r124 = new C45011(r210, r122, this.f370199a, null);
            r100.I$0 = r122;
            r100.label = 1;
            if (BuildersKt.withContext(r123, r124, r100) != r103) goto L96;
            return r103;
        L96:
            r107 = r122;
        L92:
            r122 = 0;
        L61:
            int r125 = wi8.e.f559860a;
            BotModel r126 = this.f370199a.j0();
            if (r126 == null) goto L65;
            String r127 = r126.getBotId();
            if (r127 == null) goto L65;
        L66:
            String r128 = r127;
            String r129 = this.f370199a.P2();
            LruCache<String, wc9.e> r130 = ko8.a.f504531a;
            wc9.e r131 = this.f370199a.U2();
            if (r131 == null) goto L69;
            Integer r132 = r131.f559219v;
        L70:
            String r133 = ko8.a.f(r132, this.f370199a.N2(), this.f370199a.L2());
            Message r134 = this.f370200b;
            if (r134 == null) goto L73;
            boolean r135 = com.larus.bmhome.chat.bean.d.Q0(r134);
        L74:
            Message r136 = this.f370200b;
            if (r136 == null) goto L77;
            boolean r137 = com.larus.bmhome.chat.bean.d.f0(r136);
        L78:
            long r138 = 0;
            if (r114 == false) goto L81;
            long r212 = 0;
        L82:
            if (r114 == false) goto L84;
            r138 = 1;
        L84:
            ActivityResultCaller r139 = s1a.a.c(this.f370199a);
            Intrinsics.checkNotNull(r139, "null cannot be cast to non-null type com.ixigua.lib.track.ITrackNode");
            wi8.e.a(false, r128, false, r129, r133, r135, r137, null, "connect_to_earphones", Boxing.boxLong(r212), Boxing.boxLong(r138), (by7.e) r139);
            goto L86
        L81:
            r212 = 1;
            goto L82
        L77:
            r137 = false;
            goto L78
        L73:
            r135 = false;
            goto L74
        L69:
            r132 = null;
        L65:
            r127 = "";
            goto L66
        L46:
            if (r210.f289910a == true) goto L57;
            if (r210.f289911b == false) goto L57;
            com.larus.platform.api.g0 r140 = this.f370199a.Y2();
            if (r140 != null) goto L52;
        L54:
            boolean r141 = false;
        L55:
            if (r141 == true) goto L57;
            r120 = true;
            goto L59
        L52:
            if (r140.getTtsChecked() != true) goto L54;
            r141 = true;
        L43:
            r119 = false;
            goto L44
        L17:
            if (r210.f289911b == false) goto L35;
            ChatTitleTtsComponent r142 = this.f370199a;
            int r143 = ChatTitleTtsComponent.f370179v;
            com.larus.platform.api.g0 r144 = r142.Y2();
            if (r144 != null) goto L21;
        L23:
            boolean r145 = false;
        L24:
            if (r145 == true) goto L35;
            com.larus.platform.api.g0 r146 = this.f370199a.Y2();
            if (r146 == null) goto L32;
            lq9.q r147 = r146.getEarphoneState();
            if (r147 == null) goto L32;
            if (r210.f289911b != r147.f510351b) goto L32;
            boolean r148 = true;
        L33:
            if (r148 == false) goto L35;
            r114 = true;
        L32:
            r148 = false;
            goto L33
        L21:
            if (r144.getTtsChecked() != true) goto L23;
            r145 = true;
        L7:
            r100 = new ChatTitleTtsComponent$initTtsGuideCheck$2$1$emit$1(this, r211);
            goto L8
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final /* bridge */ /* synthetic */ Object emit(Object r100, Continuation r101) {
            return a((com.larus.audio.ttsV2.a) r100, r101);
        }
    }

    public ChatTitleTtsComponent$initTtsGuideCheck$2(ChatTitleTtsComponent r100, Continuation<? super ChatTitleTtsComponent$initTtsGuideCheck$2> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ChatTitleTtsComponent$initTtsGuideCheck$2(this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ChatTitleTtsComponent$initTtsGuideCheck$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L6;
        ResultKt.throwOnFailure(r100);
    L24:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        if (s1a.a.c(this.this$0).isAdded() == false) goto L11;
        ChatTitleTtsComponent r103 = this.this$0;
        int r104 = ChatTitleTtsComponent.f370179v;
        u7 r105 = (u7) r103.f370184l.getValue();
        if (r105 == null) goto L17;
        List<Message> r106 = r105.zj();
        if (r106 == null) goto L17;
        Message r107 = (Message) CollectionsKt.firstOrNull(r106);
    L18:
        i1<com.larus.audio.ttsV2.a> r108 = TtsGuideDelegate.f289898b.f();
        if (r108 == null) goto L26;
        AnonymousClass1 r109 = new AnonymousClass1(this.this$0, r107);
        this.label = 1;
        if (r108.collect(r109, this) != r101) goto L24;
        return r101;
    L26:
        return Unit.INSTANCE;
    L17:
        r107 = null;
        goto L18
    L11:
        return Unit.INSTANCE;
    }
}

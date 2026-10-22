package com.ss.android.lark.inline.ai.logic.push;

import androidx.lifecycle.ViewModelKt;
import com.bytedance.lark.pb.space.doc.v1.InlineAITaskStatus;
import com.ss.android.lark.inline.ai.AbsInlineAIViewModel;
import com.ss.android.lark.log.Log;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: classes36.dex */
public final class SmoothOutputFilter extends com.ss.android.lark.inline.ai.logic.push.a.AbstractC5057a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f427316f = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AbsInlineAIViewModel f427317b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Channel<b> f427318c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap<String, c> f427319d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public InlineAITaskStatus f427320e;

    /* JADX INFO: renamed from: com.ss.android.lark.inline.ai.logic.push.SmoothOutputFilter$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.inline.ai.logic.push.SmoothOutputFilter$1", f = "SmoothOutputFilter.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ SmoothOutputFilter this$0;

        /* JADX INFO: renamed from: com.ss.android.lark.inline.ai.logic.push.SmoothOutputFilter$1$a */
        public static final class a<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ SmoothOutputFilter f427321a;

            public a(SmoothOutputFilter r100) {
                this.f427321a = r100;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(Object r100, Continuation r101) {
                ((Boolean) r100).booleanValue();
                Log.i("SmoothOutputFilter", "receive cancel, stop proceed");
                SmoothOutputFilter r102 = this.f427321a;
                InlineAITaskStatus r103 = r102.f427320e;
                if (r103 == null) goto L9;
                String r104 = r103.unique_task_id;
                if (r104 == null) goto L9;
                c r105 = r102.f427319d.get(r104);
                if (r105 == null) goto L9;
                r105.f427329c = true;
            L9:
                SmoothOutputFilter r106 = this.f427321a;
                InlineAITaskStatus r107 = r106.f427320e;
                if (r107 == null) goto L13;
                InlineAITaskStatus r108 = new InlineAITaskStatus.Builder().task_status("success").ai_message_id(r107.ai_message_id).seq_id(r107.seq_id).status_code(r107.status_code).session_id(r107.session_id).unique_task_id(r107.unique_task_id).content(r107.content).build();
                Log.i("SmoothOutputFilter", "receive cancel, directly print all");
                Intrinsics.checkNotNull(r108);
                r106.b(r108, true);
            L13:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass1(SmoothOutputFilter r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L6;
            ResultKt.throwOnFailure(r100);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            d1<Boolean> r103 = this.this$0.f427317b.getCancelFlow();
            a r104 = new a(this.this$0);
            this.label = 1;
            if (r103.collect(r104, this) != r101) goto L12;
            return r101;
        }
    }

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public InlineAITaskStatus f427322a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f427323b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f427324c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f427325d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f427326e;

        public b() {
            this.f427322a = new InlineAITaskStatus.Builder().build();
            this.f427326e = "";
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f427327a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f427328b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f427329c;

        public c() {
        }

        public final String toString() {
            return "TaskPrintParam(alreadyShowContentSize=" + this.f427327a + ", firstDataReceiveTime=" + this.f427328b + ')';
        }
    }

    static {
    }

    public SmoothOutputFilter(AbsInlineAIViewModel r110) {
        Intrinsics.checkNotNullParameter(r110, "inlineAIViewModel");
        this.f427317b = r110;
        this.f427318c = ChannelKt.Channel$default(0, null, null, 7, null);
        this.f427319d = new ConcurrentHashMap();
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(r110), null, null, new AnonymousClass1(this, null), 3, null);
    }

    @Override // slb.d.a
    public final void a(InlineAITaskStatus r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        c r102 = this.f427319d.get(r100.unique_task_id);
        boolean r103 = false;
        if (r102 != null) goto L5;
    L7:
        boolean r104 = false;
    L9:
        if (r104 == false) goto L12;
        Log.i("SmoothOutputFilter", "task canceled, return");
        return;
    L12:
        String r105 = r100.content;
        if (r105 != null) goto L15;
    L16:
        r103 = true;
    L18:
        if (r103 == true) goto L24;
        this.f427320e = r100;
        String r106 = r100.unique_task_id;
        c r107 = this.f427319d.get(r106);
        if (r107 != null) goto L23;
        r107 = new c();
        this.f427319d.put(r106, r107);
    L23:
        Log.i("SmoothOutputFilter", "sendData data.unique_task_id is " + r100.unique_task_id + ", put it to map");
        b r108 = new b();
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        r108.f427322a = r100;
        c(r108, r107);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this.f427317b), null, null, new SmoothOutputFilter$sendData$1(this, r108, null), 3, null);
    L24:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this.f427317b), null, null, new SmoothOutputFilter$receiveData$1(this, null), 3, null);
        return;
    L15:
        if (r105.length() != 0) goto L18;
    L5:
        if (r102.f427329c != true) goto L7;
        r104 = true;
        goto L9
    }

    public final void c(b r100, c r101) {
        c r102 = this.f427319d.get(r100.f427322a.unique_task_id);
        if (r102 == null) goto L5;
        long r103 = r102.f427328b;
    L7:
        if (r103 != 0) goto L9;
        r100.f427323b = 20;
        r101.f427328b = System.currentTimeMillis();
    L10:
        int r104 = r100.f427323b * ((int) Math.exp(-((r100.f427322a.content.length() - r101.f427327a) / 100)));
        if (r104 >= 16) goto L15;
        if (r104 == 0) goto L15;
        r100.f427324c = 16;
        r100.f427325d = MathKt.roundToInt(((double) 16) / ((double) r104));
    L16:
        r100.f427324c = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(r100.f427324c, 50), 16);
        Log.i("SmoothOutputFilter", "calculatePrintParams currentPrintDataCost : " + r100.f427324c + "  currentPrintStepNum : " + r100.f427325d);
        return;
    L15:
        r100.f427324c = r100.f427323b;
        r100.f427325d = 1;
        goto L16
    L9:
        r100.f427323b = (int) (((long) (r100.f427322a.content.length() * 1000)) / (System.currentTimeMillis() - r103));
        goto L10
    L5:
        r103 = 0;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v20, types: [com.ss.android.lark.inline.ai.logic.push.SmoothOutputFilter$b] */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.ss.android.lark.inline.ai.logic.push.SmoothOutputFilter$b] */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r13v0, types: [com.ss.android.lark.inline.ai.logic.push.SmoothOutputFilter, com.ss.android.lark.inline.ai.logic.push.a$a] */
    /* JADX WARN: Type inference failed for: r14v0, types: [com.ss.android.lark.inline.ai.logic.push.SmoothOutputFilter$b, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v14 */
    /* JADX WARN: Type inference failed for: r14v16 */
    /* JADX WARN: Type inference failed for: r14v17 */
    /* JADX WARN: Type inference failed for: r14v19 */
    /* JADX WARN: Type inference failed for: r14v20 */
    /* JADX WARN: Type inference failed for: r14v21 */
    /* JADX WARN: Type inference failed for: r14v30 */
    /* JADX WARN: Type inference failed for: r14v31 */
    /* JADX WARN: Type inference failed for: r14v32 */
    /* JADX WARN: Type inference failed for: r14v33 */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v5, types: [com.ss.android.lark.inline.ai.logic.push.SmoothOutputFilter$b] */
    /* JADX WARN: Type inference failed for: r14v8, types: [com.ss.android.lark.inline.ai.logic.push.SmoothOutputFilter$b, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r15v42 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    public final Object d(b r110, Continuation<? super Unit> r111) {
        String r100 = "success";
        if ((r111 instanceof SmoothOutputFilter$proceedResult$1) == false) goto L7;
        SmoothOutputFilter$proceedResult$1 r101 = (SmoothOutputFilter$proceedResult$1) r111;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r112 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L28;
        if (r104 == 1) goto L23;
        if (r104 == 2) goto L20;
        if (r104 != 3) goto L19;
        b r113 = (b) r101.L$1;
        ?? r105 = (b) r101.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Throwable -> L16
        ?? r106 = r105;
        ?? r114 = r113;
    L60:
        ?? r107 = r114;
        r110 = r106;
    L62:
        Object r115 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L64
        ?? r116 = r110;
    L67:
        Throwable r117 = Result.m9452exceptionOrNullimpl(r115);
        if (r117 == null) goto L72;
        Log.i("SmoothOutputFilter", "proceedResult err " + r117.getMessage());
        b(r116.f427322a, false);
    L72:
        return Unit.INSTANCE;
    L64:
        th = move-exception;
        ?? r118 = r110;
        th = th;
        r105 = r118;
    L66:
        Result.Companion r119 = Result.Companion;
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        r116 = r105;
    L16:
        th = th;
        goto L66
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        c r120 = (c) r101.L$3;
        b r108 = (b) r101.L$2;
        b r109 = (b) r101.L$1;
        b r121 = (b) r101.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Throwable -> L26
        ?? r122 = r108;
        ?? r123 = r109;
        ?? r124 = r121;
    L54:
        c(r122, r120);     // Catch: Throwable -> L26
        if (r122.f427326e.length() <= 0) goto L61;
        r101.L$0 = r124;     // Catch: Throwable -> L26
        r101.L$1 = r123;     // Catch: Throwable -> L26
        r101.L$2 = null;     // Catch: Throwable -> L26
        r101.L$3 = null;     // Catch: Throwable -> L26
        r101.label = 3;     // Catch: Throwable -> L26
        if (d(r122, r101) != r103) goto L59;
        return r103;
    L59:
        r114 = r123;
        r106 = r124;
        goto L60
    L61:
        r110 = r124;
        r107 = r123;
        goto L62
    L23:
        b r125 = (b) r101.L$2;
        b r126 = (b) r101.L$1;
        b r127 = (b) r101.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Throwable -> L26
        ?? r128 = r126;
        ?? r129 = r127;
        ?? r130 = r125;
    L33:
        String r131 = r130.f427322a.unique_task_id;     // Catch: Throwable -> L26
        c r132 = this.f427319d.get(r131);     // Catch: Throwable -> L26
        if (r132 != null) goto L37;
        r132 = new c();     // Catch: Throwable -> L26
        this.f427319d.put(r131, r132);     // Catch: Throwable -> L26
    L37:
        if (r132.f427329c == false) goto L41;
        return Unit.INSTANCE;
    L41:
        if ((r132.f427327a + r130.f427325d) <= r130.f427322a.content.length()) goto L43;
        int r133 = r130.f427322a.content.length();     // Catch: Throwable -> L26
    L44:
        String r134 = r130.f427322a.content.substring(0, r133);     // Catch: Throwable -> L26
        String r135 = r130.f427322a.content.substring(r133);     // Catch: Throwable -> L26
        Intrinsics.checkNotNullParameter(r135, "<set-?>");     // Catch: Throwable -> L26
        r130.f427326e = r135;     // Catch: Throwable -> L26
        r132.f427327a += r130.f427325d;     // Catch: Throwable -> L26
        if (Intrinsics.areEqual(r130.f427322a.task_status, "success") == true) goto L47;
        r100 = r130.f427322a.task_status;     // Catch: Throwable -> L26
    L50:
        InlineAITaskStatus r136 = new InlineAITaskStatus.Builder().task_status(r100).ai_message_id(r130.f427322a.ai_message_id).seq_id(r130.f427322a.seq_id).status_code(r130.f427322a.status_code).session_id(r130.f427322a.session_id).unique_task_id(r130.f427322a.unique_task_id).content(r134).build();     // Catch: Throwable -> L26
        MainCoroutineDispatcher r137 = Dispatchers.getMain();     // Catch: Throwable -> L26
        SmoothOutputFilter$proceedResult$2$1$2 r138 = new SmoothOutputFilter$proceedResult$2$1$2(this, r136, null);     // Catch: Throwable -> L26
        r101.L$0 = r129;     // Catch: Throwable -> L26
        r101.L$1 = r128;     // Catch: Throwable -> L26
        r101.L$2 = r130;     // Catch: Throwable -> L26
        r101.L$3 = r132;     // Catch: Throwable -> L26
        r101.label = 2;     // Catch: Throwable -> L26
        if (BuildersKt.withContext(r137, r138, r101) != r103) goto L53;
        return r103;
    L53:
        r122 = r130;
        r120 = r132;
        r123 = r128;
        r124 = r129;
        goto L54
    L47:
        if (r130.f427326e.length() <= 0) goto L50;
        r100 = "processing";
        goto L50
    L43:
        r133 = r132.f427327a + r130.f427325d;     // Catch: Throwable -> L26
        goto L44
    L28:
        ResultKt.throwOnFailure(r112);
        Result.Companion r139 = Result.Companion;     // Catch: Throwable -> L64
        CoroutineDispatcher r140 = Dispatchers.getIO();     // Catch: Throwable -> L64
        SmoothOutputFilter$proceedResult$2$1$1 r141 = new SmoothOutputFilter$proceedResult$2$1$1(r110, null);     // Catch: Throwable -> L64
        r101.L$0 = r110;     // Catch: Throwable -> L64
        r101.L$1 = r110;     // Catch: Throwable -> L64
        r101.L$2 = r110;     // Catch: Throwable -> L64
        r101.label = 1;     // Catch: Throwable -> L64
        if (BuildersKt.withContext(r140, r141, r101) != r103) goto L32;
        return r103;
    L32:
        ?? r142 = r110;
        r129 = r142;
        r128 = r142;
        r130 = r110;
    L26:
        th = th;
        r105 = 1;
    L7:
        r101 = new SmoothOutputFilter$proceedResult$1(this, r111);
        goto L8
    }
}

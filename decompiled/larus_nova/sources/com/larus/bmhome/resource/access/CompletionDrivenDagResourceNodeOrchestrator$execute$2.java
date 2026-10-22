package com.larus.bmhome.resource.access;

import com.android.ttcjpaysdk.base.weboffline.CJPayWebOfflineWorker;
import com.bytedance.ee.bear.middleground.comment.aibot.model.AiBotPollingAuthResult;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/bmhome/resource/access/PipelineExecuteResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.resource.access.CompletionDrivenDagResourceNodeOrchestrator$execute$2", f = "ResourceAccessPipeline.kt", i = {2, 2, 2, 2, 2, 2, 2, 3, 4}, l = {503, 516, 531, 541, 545}, m = "invokeSuspend", n = {"$this$coroutineScope", "knownKeys", AiBotPollingAuthResult.STATUS_PENDING, CJPayWebOfflineWorker.CJ_PAY_WEB_OFFLINE_FINISHED, "runningNodes", "runningJobs", "completedResults", "result", "result"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$0"})
final class CompletionDrivenDagResourceNodeOrchestrator$execute$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super h>, Object> {
    final /* synthetic */ h0 $context;
    final /* synthetic */ List<l0> $nodes;
    final /* synthetic */ f $task;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;

    /* JADX INFO: renamed from: com.larus.bmhome.resource.access.CompletionDrivenDagResourceNodeOrchestrator$execute$2$2, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<l0, Unit> {
        final /* synthetic */ CoroutineScope $$this$coroutineScope;
        final /* synthetic */ Channel<m0> $completedResults;
        final /* synthetic */ h0 $context;
        final /* synthetic */ Set<String> $finished;
        final /* synthetic */ LinkedHashMap<String, l0> $pending;
        final /* synthetic */ LinkedHashMap<String, Job> $runningJobs;
        final /* synthetic */ LinkedHashMap<String, l0> $runningNodes;
        final /* synthetic */ f $task;

        public AnonymousClass2(LinkedHashMap<String, l0> r100, Set<String> r101, f r102, h0 r103, LinkedHashMap<String, l0> r104, LinkedHashMap<String, Job> r105, CoroutineScope r106, Channel<m0> r107) {
            this.$pending = r100;
            this.$finished = r101;
            this.$task = r102;
            this.$context = r103;
            this.$runningNodes = r104;
            this.$runningJobs = r105;
            this.$$this$coroutineScope = r106;
            this.$completedResults = r107;
            super(1, Intrinsics.Kotlin.class, "launchNode", "invokeSuspend$launchNode(Ljava/util/LinkedHashMap;Ljava/util/Set;Lcom/larus/bmhome/resource/access/MutableResourceAccessTask;Lcom/larus/bmhome/resource/access/ResourceContext;Ljava/util/LinkedHashMap;Ljava/util/LinkedHashMap;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/channels/Channel;Lcom/larus/bmhome/resource/access/ResourceNode;)V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(l0 r110) {
            Intrinsics.checkNotNullParameter(r110, "p0");
            CompletionDrivenDagResourceNodeOrchestrator$execute$2.access$invokeSuspend$launchNode(this.$pending, this.$finished, this.$task, this.$context, this.$runningNodes, this.$runningJobs, this.$$this$coroutineScope, this.$completedResults, r110);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(l0 r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CompletionDrivenDagResourceNodeOrchestrator$execute$2(List<? extends l0> r100, f r101, h0 r102, Continuation<? super CompletionDrivenDagResourceNodeOrchestrator$execute$2> r103) {
        this.$nodes = r100;
        this.$task = r101;
        this.$context = r102;
        super(2, r103);
    }

    public static final /* synthetic */ Object access$invokeSuspend$cancelRunningNodes(LinkedHashMap r100, LinkedHashMap r101, Continuation r102) {
        return a(r100, r101, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        CompletionDrivenDagResourceNodeOrchestrator$execute$2 r102 = new CompletionDrivenDagResourceNodeOrchestrator$execute$2(this.$nodes, this.$task, this.$context, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super h> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super h> r101) {
        return ((CompletionDrivenDagResourceNodeOrchestrator$execute$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v11, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v18, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r10v19, types: [java.util.ArrayList] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:143:0x032c -> B:144:0x0332). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r210) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        int r102 = 1;
        Object r103 = null;
        if (r101 == 0) goto L16;
        if (r101 == 1) goto L15;
        if (r101 == 2) goto L14;
        if (r101 == 3) goto L13;
        if (r101 == 4) goto L12;
        if (r101 != 5) goto L11;
        g r104 = (g) this.L$0;
        ResultKt.throwOnFailure(r210);
    L169:
        return new h.c(((g.c) r104).f313651a);
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        g r105 = (g) this.L$0;
        ResultKt.throwOnFailure(r210);
    L161:
        return new h.b(((g.b) r105).f313650a);
    L13:
        Channel r106 = (Channel) this.L$6;
        LinkedHashMap r107 = (LinkedHashMap) this.L$5;
        LinkedHashMap r110 = (LinkedHashMap) this.L$4;
        Set r111 = (Set) this.L$3;
        LinkedHashMap r112 = (LinkedHashMap) this.L$2;
        Set r113 = (Set) this.L$1;
        CoroutineScope r114 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r210);
        LinkedHashMap r115 = r107;
        LinkedHashMap r108 = r112;
        Set r109 = r113;
        Object r116 = r210;
        CompletionDrivenDagResourceNodeOrchestrator$execute$2 r117 = this;
        Set r118 = r111;
        LinkedHashMap r119 = r110;
        CoroutineScope r120 = r114;
    L144:
        m0 r121 = (m0) r116;
        r119.remove(r121.f313701a.getKey());
        r115.remove(r121.f313701a.getKey());
        g r122 = r121.f313702b;
        if ((r122 instanceof g.a) == false) goto L153;
        g.a r123 = (g.a) r122;
        r117.$context.a(r123.f313649a);
        f r124 = r117.$task;
        l0 r125 = r121.f313701a;
        h0 r126 = r117.$context;
        i0 r127 = r123.f313649a;
        if (r127.f313681a == null) goto L149;
    L151:
        r124.e(new a0.e(r125.d(), r125.getKey(), r126.f313673c, r126.b()));
    L175:
        Object r128 = null;
    L176:
        r118.add(r121.f313701a.getKey());
        LinkedHashMap r129 = r108;
        Set r130 = r109;
        r102 = 1;
        r103 = r128;
    L26:
        if ((!r129.isEmpty()) == true) goto L30;
        if ((!r119.isEmpty()) == true) goto L30;
    L135:
        return h.a.f313668a;
    L30:
        if (r117.$task.c() == false) goto L37;
        r117.L$0 = r103;
        r117.L$1 = r103;
        r117.L$2 = r103;
        r117.L$3 = r103;
        r117.L$4 = r103;
        r117.L$5 = r103;
        r117.L$6 = r103;
        r117.label = r102;
        if (a(r115, r119, r117) != r100) goto L35;
        return r100;
    L35:
        return h.a.f313668a;
    L37:
        if (((r129.isEmpty() ? 1 : 0) ^ r102) == 0) goto L122;
        b r131 = b.f313624a;
        CompletionDrivenDagResourceNodeOrchestrator$execute$2 r132 = r117;
        CoroutineScope r211 = r120;
        r109 = r130;
        LinkedHashMap r133 = r129;
        Set r134 = r118;
        LinkedHashMap r135 = r119;
        LinkedHashMap r212 = r115;
        AnonymousClass2 r136 = new AnonymousClass2(r129, r118, r117.$task, r117.$context, r119, r115, r211, r106);
        Collection r137 = r133.values();
        ArrayList r138 = new ArrayList();
        Iterator r139 = r137.iterator();
    L39:
        boolean r140 = false;
        if (r139.hasNext() == false) goto L62;
        Object r141 = r139.next();
        List<String> r142 = ((l0) r141).f();
        if ((r142 instanceof Collection) == true) goto L44;
    L46:
        Iterator r143 = r142.iterator();
    L48:
        if (r143.hasNext() == false) goto L58;
        String r144 = (String) r143.next();
        if (r109.contains(r144) == true) goto L52;
    L55:
        boolean r145 = true;
    L56:
        if (r145 == true) goto L48;
    L59:
        if (r140 == false) goto L39;
        r138.add(r141);
        goto L39
    L52:
        if (r134.contains(r144) == true) goto L55;
        r145 = false;
    L58:
        r140 = true;
        goto L59
    L44:
        if (r142.isEmpty() == false) goto L46;
    L62:
        if (r138.isEmpty() == true) goto L124;
        ArrayList r146 = new ArrayList();
        Iterator r147 = r138.iterator();
    L66:
        if (r147.hasNext() == false) goto L73;
        Object r148 = r147.next();
        if (((l0) r148).g() != ResourceNodeCompletionMode.DETACHED) goto L70;
        boolean r149 = true;
    L71:
        if (r149 == false) goto L66;
        r146.add(r148);
        goto L66
    L70:
        r149 = false;
        goto L71
    L73:
        Iterator r150 = r146.iterator();
    L75:
        if (r150.hasNext() == false) goto L77;
        r136.invoke(r150.next());
        goto L75
    L77:
        Collection r151 = r135.values();
        if (r151.isEmpty() == true) goto L86;
        Iterator r152 = r151.iterator();
    L82:
        if (r152.hasNext() == false) goto L86;
        if (((((l0) r152.next()).h() ? 1 : 0) ^ r102) == 0) goto L82;
        boolean r153 = true;
    L87:
        if (r153 == true) goto L124;
        ArrayList r154 = new ArrayList();
        Iterator r155 = r138.iterator();
    L91:
        if (r155.hasNext() == false) goto L99;
        Object r156 = r155.next();
        if (((l0) r156).g() != ResourceNodeCompletionMode.BLOCKING) goto L95;
        boolean r157 = true;
    L96:
        if (r157 == false) goto L91;
        r154.add(r156);
        goto L91
    L95:
        r157 = false;
        goto L96
    L99:
        if (r154.isEmpty() == true) goto L124;
        if (r135.isEmpty() == false) goto L112;
        l0 r158 = (l0) CollectionsKt.first(r154);
        if (r158.h() == false) goto L111;
        ?? r159 = new ArrayList();
        Iterator r160 = r154.iterator();
    L107:
        if (r160.hasNext() == false) goto L118;
        Object r161 = r160.next();
        if (((l0) r161).h() == false) goto L107;
        r159.add(r161);
    L118:
        Iterator r162 = ((Iterable) r159).iterator();
    L120:
        if (r162.hasNext() == false) goto L124;
        r136.invoke(r162.next());
        goto L120
    L111:
        r159 = CollectionsKt.listOf(r158);
        goto L118
    L112:
        r159 = new ArrayList();
        Iterator r163 = r154.iterator();
    L114:
        if (r163.hasNext() == false) goto L118;
        Object r164 = r163.next();
        if (((l0) r164).h() == false) goto L114;
        r159.add(r164);
    L86:
        r153 = false;
    L124:
        if (r132.$task.c() == false) goto L130;
        r132.L$0 = null;
        r132.L$1 = null;
        r132.L$2 = null;
        r132.L$3 = null;
        r132.L$4 = null;
        r132.L$5 = null;
        r132.L$6 = null;
        r132.label = 2;
        if (a(r212, r135, r132) != r100) goto L129;
        return r100;
    L129:
        return h.a.f313668a;
    L130:
        LinkedHashMap r165 = r212;
        if (r133.isEmpty() == false) goto L137;
        if (r135.isEmpty() == true) goto L135;
    L137:
        if (r135.isEmpty() == false) goto L140;
        r r166 = new r("pipeline", "node_dependency_cycle", "resource access node dependency cycle", null);
        FLogger.f375446a.w("ResourceAccessPipeline", "[execute] node dependency cycle, pending=" + r133.keySet());
        return new h.b(r166);
    L140:
        CoroutineScope r167 = r211;
        r132.L$0 = r167;
        r132.L$1 = r109;
        LinkedHashMap r168 = r133;
        r132.L$2 = r168;
        r132.L$3 = r134;
        r132.L$4 = r135;
        r132.L$5 = r165;
        r132.L$6 = r106;
        r132.label = 3;
        r116 = r106.receive(r132);
        if (r116 != r100) goto L143;
        return r100;
    L143:
        r119 = r135;
        r115 = r165;
        r118 = r134;
        r108 = r168;
        r120 = r167;
        r117 = r132;
        goto L144
    L122:
        r132 = r117;
        r211 = r120;
        r109 = r130;
        r133 = r129;
        r134 = r118;
        r135 = r119;
        r212 = r115;
        goto L124
    L149:
        if (r127.f313687g.isEmpty() == false) goto L151;
    L153:
        if (Intrinsics.areEqual(r122, g.e.f313653a) == true) goto L175;
        if ((r122 instanceof g.b) == false) goto L163;
        r117.L$0 = r122;
        r117.L$1 = null;
        r117.L$2 = null;
        r117.L$3 = null;
        r117.L$4 = null;
        r117.L$5 = null;
        r117.L$6 = null;
        r117.label = 4;
        if (a(r115, r119, r117) != r100) goto L159;
        return r100;
    L159:
        r105 = r122;
        goto L161
    L163:
        if ((r122 instanceof g.c) == false) goto L170;
        r117.L$0 = r122;
        r117.L$1 = null;
        r117.L$2 = null;
        r117.L$3 = null;
        r117.L$4 = null;
        r117.L$5 = null;
        r117.L$6 = null;
        r117.label = 5;
        if (a(r115, r119, r117) != r100) goto L167;
        return r100;
    L167:
        r104 = r122;
        goto L169
    L170:
        r128 = null;
        if ((r122 instanceof g.d) == false) goto L174;
        r117.$context.a(new i0(null, null, null, null, null, ((g.d) r122).f313652a, null, 95));
        goto L176
    L174:
        throw new NoWhenBranchMatchedException();
    L14:
        ResultKt.throwOnFailure(r210);
        goto L129
    L15:
        ResultKt.throwOnFailure(r210);
        goto L35
    L16:
        ResultKt.throwOnFailure(r210);
        CoroutineScope r169 = (CoroutineScope) this.L$0;
        List<l0> r170 = this.$nodes;
        ArrayList r171 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r170, 10));
        Iterator r172 = r170.iterator();
    L18:
        if (r172.hasNext() == false) goto L20;
        r171.add(((l0) r172.next()).getKey());
        goto L18
    L20:
        Set r173 = CollectionsKt.toSet(r171);
        LinkedHashMap r174 = new LinkedHashMap();
        Iterator r175 = this.$nodes.iterator();
    L22:
        if (r175.hasNext() == false) goto L24;
        l0 r176 = (l0) r175.next();
        r174.put(r176.getKey(), r176);
        goto L22
    L24:
        LinkedHashSet r177 = new LinkedHashSet();
        LinkedHashMap r178 = new LinkedHashMap();
        r115 = new LinkedHashMap();
        r118 = r177;
        r130 = r173;
        r117 = this;
        r120 = r169;
        r106 = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        r119 = r178;
        r129 = r174;
        goto L26
    }

    public static final Object a(LinkedHashMap<String, Job> r100, LinkedHashMap<String, l0> r101, Continuation<? super Unit> r102) {
        if ((r102 instanceof CompletionDrivenDagResourceNodeOrchestrator$execute$2$cancelRunningNodes$1) == false) goto L7;
        CompletionDrivenDagResourceNodeOrchestrator$execute$2$cancelRunningNodes$1 r103 = (CompletionDrivenDagResourceNodeOrchestrator$execute$2$cancelRunningNodes$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        Iterator r108 = (Iterator) r103.L$2;
        LinkedHashMap<String, l0> r109 = (LinkedHashMap) r103.L$1;
        LinkedHashMap<String, Job> r110 = (LinkedHashMap) r103.L$0;
        ResultKt.throwOnFailure(r105);
        LinkedHashMap<String, l0> r111 = r109;
        LinkedHashMap<String, Job> r112 = r110;
    L20:
        if (r108.hasNext() == false) goto L24;
        Job r113 = (Job) r108.next();
        r103.L$0 = r112;
        r103.L$1 = r111;
        r103.L$2 = r108;
        r103.label = 1;
        if (r113.join(r103) != r106) goto L20;
        return r106;
    L24:
        r112.clear();
        r111.clear();
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        List r114 = CollectionsKt.toList(r100.values());
        Iterator r115 = r114.iterator();
    L16:
        if (r115.hasNext() == false) goto L18;
        Job.DefaultImpls.cancel$default((Job) r115.next(), null, 1, null);
        goto L16
    L18:
        r112 = r100;
        r108 = r114.iterator();
        r111 = r101;
    L7:
        r103 = new CompletionDrivenDagResourceNodeOrchestrator$execute$2$cancelRunningNodes$1(r102);
        goto L8
    }

    public static final void access$invokeSuspend$launchNode(LinkedHashMap r110, Set r111, f r112, h0 r113, LinkedHashMap r210, LinkedHashMap r211, CoroutineScope r212, Channel r213, l0 r214) {
        if (r214.g() != ResourceNodeCompletionMode.DETACHED) goto L8;
        r110.remove(r214.getKey());
        r111.add(r214.getKey());
        if (r112.c() == true) goto L12;
        CoroutineScope r100 = c.f313626a;
        Intrinsics.checkNotNullParameter(r112, "task");
        Intrinsics.checkNotNullParameter(r113, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r214, "node");
        BuildersKt.launch$default(c.f313626a, null, null, new DetachedResourceNodeDispatcher$launch$1(r112, r113, r214, null), 3, null);
        FLogger.f375446a.i("ResourceAccessPipeline", "[execute] launch detached node=" + r214.getKey() + ", taskId=" + r112.f313632a);
        return;
    L12:
        return;
    L8:
        if (r112.c() == true) goto L14;
        r110.remove(r214.getKey());
        r210.put(r214.getKey(), r214);
        r211.put(r214.getKey(), BuildersKt.launch$default(r212, null, null, new CompletionDrivenDagResourceNodeOrchestrator$execute$2$launchNode$1(r213, r112, r113, r214, null), 3, null));
        FLogger.f375446a.i("ResourceAccessPipeline", "[execute] launch node=" + r214.getKey() + ", taskId=" + r112.f313632a);
        return;
    }
}

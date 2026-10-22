package com.obric.assistant.state.multitask;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import com.obric.assistant.state.multitask.core.TaskDispatchResult;
import com.obric.assistant.state.multitask.core.TaskFlowDispatchStrategy;
import com.obric.assistant.state.multitask.internal.DefaultTaskFlowStateMachine;
import com.obric.assistant.state.multitask.internal.engine.TaskFlowEventBus;
import com.obric.assistant.state.multitask.internal.engine.TaskFlowPolicyEngine;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import jha.f;
import jha.g;
import jha.h;
import jha.i;
import jha.l;
import jha.n;
import jha.o;
import jha.q;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.a0;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.a1;

/* JADX INFO: loaded from: classes4.dex */
public final class TaskFlowManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TaskFlowManager f393247a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final TaskFlowEventBus f393248b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final TaskFlowPolicyEngine f393249c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap<g<?>, b<?>> f393250d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f393251e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicLong f393252f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final CoroutineScope f393253g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a1 f393254h = null;

    /* JADX INFO: loaded from: classes33.dex */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/state/multitask/TaskFlowManager$EntryLifecycle;", "", "<init>", "(Ljava/lang/String;I)V", "OPEN", "CLOSING", ErrorCode.CLOSED, "multitask_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum EntryLifecycle extends Enum<EntryLifecycle> {
        public static final EntryLifecycle CLOSED = null;
        public static final EntryLifecycle CLOSING = null;
        public static final EntryLifecycle OPEN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EntryLifecycle[] f393255a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f393256b = null;

        public static EnumEntries<EntryLifecycle> getEntries() {
            return f393256b;
        }

        static {
            EntryLifecycle r100 = new EntryLifecycle("OPEN", 0);
            OPEN = r100;
            EntryLifecycle r101 = new EntryLifecycle("CLOSING", 1);
            CLOSING = r101;
            EntryLifecycle r102 = new EntryLifecycle(ErrorCode.CLOSED, 2);
            CLOSED = r102;
            EntryLifecycle[] r103 = {r100, r101, r102};
            f393255a = r103;
            f393256b = EnumEntriesKt.enumEntries(r103);
        }

        public static EntryLifecycle[] values() {
            return (EntryLifecycle[]) f393255a.clone();
        }

        public static EntryLifecycle valueOf(String r100) {
            return (EntryLifecycle) r27.a.a(EntryLifecycle.class, r100);
        }

        public EntryLifecycle(String r100, int r101) {
            super(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a<S extends o> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l<S> f393257a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final q<S> f393258b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final CompletableDeferred<TaskDispatchResult> f393259c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f393257a, r101.f393257a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f393258b, r101.f393258b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f393259c, r101.f393259c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f393257a.hashCode() * 31) + this.f393258b.hashCode()) * 31) + this.f393259c.hashCode();
        }

        public final String toString() {
            return "TaskCommand(handle=" + this.f393257a + ", event=" + this.f393258b + ", result=" + this.f393259c + ')';
        }

        public a(l<S> r100, q<S> r101, CompletableDeferred<TaskDispatchResult> r102) {
            Intrinsics.checkNotNullParameter(r100, "handle");
            Intrinsics.checkNotNullParameter(r101, "event");
            Intrinsics.checkNotNullParameter(r102, "result");
            this.f393257a = r100;
            this.f393258b = r101;
            this.f393259c = r102;
        }
    }

    /* JADX INFO: loaded from: classes33.dex */
    public static final class b<S extends o> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l<S> f393260a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final i<S> f393261b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final jha.c f393262c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Channel<a<S>> f393263d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AtomicLong f393264e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final AtomicLong f393265f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final AtomicReference<EntryLifecycle> f393266g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final AtomicBoolean f393267h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final CompletableDeferred<Unit> f393268i;

        public b(l<S> r100, i<S> r101, jha.c r102) {
            Intrinsics.checkNotNullParameter(r100, "handle");
            Intrinsics.checkNotNullParameter(r101, "machine");
            Intrinsics.checkNotNullParameter(r102, "dispatchPolicy");
            this.f393260a = r100;
            this.f393261b = r101;
            this.f393262c = r102;
            this.f393263d = ChannelKt.Channel$default(64, null, null, 6, null);
            this.f393264e = new AtomicLong(0);
            this.f393265f = new AtomicLong(0);
            this.f393266g = new AtomicReference(EntryLifecycle.OPEN);
            this.f393267h = new AtomicBoolean(false);
            this.f393268i = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        }
    }

    /* JADX INFO: loaded from: classes33.dex */
    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f393269a = null;

        static {
            int[] r100 = new int[EntryLifecycle.values().length];
            r100[EntryLifecycle.OPEN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[EntryLifecycle.CLOSING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[EntryLifecycle.CLOSED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f393269a = r100;
        }
    }

    public TaskFlowManager() {
    }

    static {
        f393247a = new TaskFlowManager();
        TaskFlowEventBus r100 = new TaskFlowEventBus();
        f393248b = r100;
        f393249c = new TaskFlowPolicyEngine();
        f393250d = new ConcurrentHashMap();
        f393251e = new Object();
        f393252f = new AtomicLong(0);
        f393253g = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getDefault()).plus(new a0("task-flow-manager")));
        f393254h = r100.f393309b;
    }

    public static List c() {
        ConcurrentHashMap<g<?>, b<?>> r100 = f393250d;
        ArrayList r101 = new ArrayList(r100.size());
        Iterator<Map.Entry<g<?>, b<?>>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Map.Entry<g<?>, b<?>> r103 = r102.next();
        r101.add(TuplesKt.to(r103.getKey(), r103.getValue().f393261b.a()));
        goto L4
    L6:
        return r101;
    }

    public static final void a(b r100) {
        r100.f393266g.set(EntryLifecycle.CLOSED);
        SendChannel.a.a(r100.f393263d);
        r100.f393261b.destroy();
        Object r101 = f393251e;
        monitor-enter(r101);
        ConcurrentHashMap<g<?>, b<?>> r102 = f393250d;     // Catch: Throwable -> L14
        if (r102.get(r100.f393260a.f499139a) != r100) goto L7;
        r102.remove(r100.f393260a.f499139a);     // Catch: Throwable -> L14
    L7:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r101);
        r100.f393268i.complete(Unit.INSTANCE);
    L10:
        a r104 = (a) kotlinx.coroutines.channels.g.b(r100.f393263d.mo10964tryReceivePtdJZtk());
        if (r104 == null) goto L12;
        r104.f393259c.complete(TaskDispatchResult.CLOSED);
        goto L10
    L12:
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public static q d(g r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        b<?> r101 = f393250d.get(r100);
        if ((r101 instanceof b) == false) goto L5;
        b<?> r102 = r101;
    L6:
        if (r102 == null) goto L11;
        i<S> r103 = r102.f393261b;
        if (r103 != 0) goto L10;
        return null;
    L10:
        return r103.a();
    L11:
        return null;
    L5:
        r102 = null;
        goto L6
    }

    public static boolean e(q r100) {
        return r100.a().f499148b.a() instanceof h.c;
    }

    public static void f(b r100) {
        if (r100.f393267h.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        jha.c r101 = r100.f393262c;
        if (r101.f499124a != TaskFlowDispatchStrategy.CALLER_CONTEXT) goto L8;
        CoroutineStart r102 = CoroutineStart.UNDISPATCHED;
    L9:
        ExecutorCoroutineDispatcher r103 = f.f499127a;
        Intrinsics.checkNotNullParameter(r101, "policy");
        int r104 = f.b.f499133a[r101.f499124a.ordinal()];
        if (r104 != 1) goto L12;
        CoroutineContext r105 = f.f499127a;
    L21:
        if (r105 != null) goto L23;
        CoroutineContext r106 = new a0("task-flow-" + r100.f393262c.f499125b + '-' + r100.f393260a.f499139a + '#' + r100.f393260a.f499140b);
    L24:
        BuildersKt.launch(f393253g, r106, r102, new TaskFlowManager$startWorker$1(r100, null));
        return;
    L23:
        r106 = r105.plus(new a0("task-flow-" + r100.f393262c.f499125b + '-' + r100.f393260a.f499139a + '#' + r100.f393260a.f499140b));
        goto L24
    L12:
        if (r104 != 2) goto L14;
        r105 = f.b(r101.f499125b).f499131a;
        goto L21
    L14:
        if (r104 != 3) goto L17;
        r105 = null;
        goto L21
    L17:
        throw new NoWhenBranchMatchedException();
    L8:
        r102 = CoroutineStart.DEFAULT;
        goto L9
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public static CompletableDeferred g(l r110, q r111) {
        Intrinsics.checkNotNullParameter(r110, "handle");
        Intrinsics.checkNotNullParameter(r111, "event");
        jha.b r100 = jha.b.f499120a;
        if ((!Intrinsics.areEqual(jha.b.f499122c.get(), Boolean.TRUE)) == false) goto L69;
        Object r101 = null;
        CompletableDeferred r102 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        ConcurrentHashMap<g<?>, b<?>> r103 = f393250d;
        b<?> r104 = r103.get(r110.f499139a);
        if ((r104 instanceof b) == false) goto L7;
        b<?> r105 = r104;
    L8:
        if (r105 != null) goto L11;
    L13:
        r105 = null;
    L14:
        if (r105 != null) goto L28;
        b<?> r112 = r103.get(r110.f499139a);
        if ((r112 instanceof b) == false) goto L18;
        b<?> r113 = r112;
    L19:
        if (r113 == null) goto L21;
        r101 = r113.f393260a;
    L21:
        if (r101 != null) goto L23;
    L25:
        TaskDispatchResult r114 = TaskDispatchResult.CLOSED;
    L26:
        r102.complete(r114);
        return r102;
    L23:
        if (Intrinsics.areEqual(r101, r110) == true) goto L25;
        r114 = TaskDispatchResult.STALE;
        goto L26
    L18:
        r113 = null;
        goto L19
    L28:
        monitor-enter(r105);
    L65:
        th = move-exception;
        throw th;
    L30:
        if ((r111 instanceof q.b) == false) goto L35;
        r102.complete(TaskDispatchResult.DROPPED);     // Catch: Throwable -> L65
        monitor-exit(r105);
        return r102;
    L35:
        if (e(r111) == false) goto L43;
        if (r105.f393266g.get() == EntryLifecycle.OPEN) goto L41;
        r102.complete(TaskDispatchResult.CLOSED);     // Catch: Throwable -> L65
        monitor-exit(r105);
        return r102;
    L41:
        r105.f393266g.set(EntryLifecycle.CLOSING);     // Catch: Throwable -> L65
    L47:
        r105.f393265f.incrementAndGet();     // Catch: Throwable -> L65
        a r106 = new a(r110, r111, r102);     // Catch: Throwable -> L65
        Object r115 = r105.f393263d.mo10962trySendJP2dKIU((a<S>) r106);     // Catch: Throwable -> L65
        kotlinx.coroutines.channels.g.c r107 = kotlinx.coroutines.channels.g.f504696b;     // Catch: Throwable -> L65
        if ((true ^ (r115 instanceof kotlinx.coroutines.channels.g.c)) == false) goto L50;
    L59:
        Unit r116 = Unit.INSTANCE;     // Catch: Throwable -> L65
        monitor-exit(r105);
        if (r102.isCompleted() == true) goto L64;
        f(r105);
    L64:
        return r102;
    L50:
        if (e(r111) == true) goto L52;
    L54:
        r105.f393265f.decrementAndGet();     // Catch: Throwable -> L65
        if ((r115 instanceof kotlinx.coroutines.channels.g.a) == false) goto L57;
        TaskDispatchResult r117 = TaskDispatchResult.CLOSED;     // Catch: Throwable -> L65
    L58:
        r102.complete(r117);     // Catch: Throwable -> L65
        goto L59
    L57:
        r117 = TaskDispatchResult.DROPPED;     // Catch: Throwable -> L65
        goto L58
    L52:
        if ((r115 instanceof kotlinx.coroutines.channels.g.a) == true) goto L54;
        BuildersKt.launch$default(f393253g, null, null, new TaskFlowManager$tryDispatchTaskEvent$2$1(r105, r106, r102, null), 3, null);     // Catch: Throwable -> L65
        goto L59
    L43:
        if (r105.f393266g.get() == EntryLifecycle.OPEN) goto L47;
        r102.complete(TaskDispatchResult.CLOSED);     // Catch: Throwable -> L65
        monitor-exit(r105);
        return r102;
    L11:
        if (Intrinsics.areEqual(r105.f393260a, r110) == false) goto L13;
    L7:
        r105 = null;
        goto L8
    L69:
        throw new IllegalStateException("TaskFlow dispatch is not allowed from a critical resolver".toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v15, types: [T, java.lang.String] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*  JADX ERROR: JadxRuntimeException in pass: FinishTypeInference
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r4v19 boolean
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
        */
    public static final java.lang.Object b(com.obric.assistant.state.multitask.TaskFlowManager r19, com.obric.assistant.state.multitask.TaskFlowManager.b r20, com.obric.assistant.state.multitask.TaskFlowManager.a r21, kotlin.coroutines.Continuation r22) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r4v19 boolean
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:341)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            Method dump skipped, instruction units count: 543
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.obric.assistant.state.multitask.TaskFlowManager.b(com.obric.assistant.state.multitask.TaskFlowManager, com.obric.assistant.state.multitask.TaskFlowManager$b, com.obric.assistant.state.multitask.TaskFlowManager$a, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public static n h(g r100, q.b r101, jha.c r110, i r111) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "initialStateEvent");
        Intrinsics.checkNotNullParameter(r110, "dispatchPolicy");
        jha.b r102 = jha.b.f499120a;
        boolean r103 = true;
        if ((!Intrinsics.areEqual(jha.b.f499122c.get(), Boolean.TRUE)) == false) goto L56;
        Object r104 = f393251e;
        monitor-enter(r104);
        ConcurrentHashMap<g<?>, b<?>> r105 = f393250d;     // Catch: Throwable -> L52
        b<?> r106 = r105.get(r100);     // Catch: Throwable -> L52
        b<?> r107 = null;
        if ((r106 instanceof b) == false) goto L9;
        b<?> r108 = r106;     // Catch: Throwable -> L52
    L10:
        if (r108 == null) goto L32;
        monitor-enter(r108);     // Catch: Throwable -> L52
        EntryLifecycle r109 = r108.f393266g.get();     // Catch: Throwable -> L25
        if (r109 != null) goto L15;
        int r112 = -1;
    L16:
        if (r112 != 1) goto L18;
        n r113 = new n.b(r108.f393260a);     // Catch: Throwable -> L25
    L28:
        monitor-exit(r108);     // Catch: Throwable -> L52
    L48:
        monitor-exit(r104);
        if (r107 == null) goto L51;
        f(r107);
    L51:
        return r113;
    L18:
        if (r112 != 2) goto L20;
    L24:
        r113 = new n.a(r108.f393268i);     // Catch: Throwable -> L25
        goto L28
    L20:
        if (r112 == 3) goto L24;
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L25
    L15:
        r112 = c.f393269a[r109.ordinal()];     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L52
    L32:
        CompletableDeferred r114 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);     // Catch: Throwable -> L52
        l r115 = new l(r100, f393252f.incrementAndGet());     // Catch: Throwable -> L52
        if (r111 != null) goto L35;
        r111 = new DefaultTaskFlowStateMachine(r101);     // Catch: Throwable -> L52
    L35:
        b<?> r116 = new b(r115, r111, r110);     // Catch: Throwable -> L52
        a r117 = new a(r115, r101, r114);     // Catch: Throwable -> L52
        r116.f393265f.incrementAndGet();     // Catch: Throwable -> L52
        Object r118 = r116.f393263d.mo10962trySendJP2dKIU((a<S>) r117);     // Catch: Throwable -> L52
        kotlinx.coroutines.channels.g.c r119 = kotlinx.coroutines.channels.g.f504696b;     // Catch: Throwable -> L52
        if ((!(r118 instanceof kotlinx.coroutines.channels.g.c)) == true) goto L39;
        r116.f393265f.decrementAndGet();     // Catch: Throwable -> L52
        r116.f393266g.set(EntryLifecycle.CLOSED);     // Catch: Throwable -> L52
        SendChannel.a.a(r116.f393263d);     // Catch: Throwable -> L52
        r116.f393261b.destroy();     // Catch: Throwable -> L52
        r114.complete(TaskDispatchResult.DROPPED);     // Catch: Throwable -> L52
    L39:
        if (r116.f393266g.get() != EntryLifecycle.CLOSED) goto L42;
        r103 = false;
    L42:
        if (r103 == true) goto L45;
        r116 = null;
    L45:
        if (r116 == null) goto L47;
        r105.put(r100, r116);     // Catch: Throwable -> L52
        r113 = new n.d(r116.f393260a);     // Catch: Throwable -> L52
        r107 = r116;
        goto L48
    L47:
        r113 = new n.c(TaskDispatchResult.DROPPED);     // Catch: Throwable -> L52
        goto L48
    L9:
        r108 = null;
    L52:
        th = move-exception;
        throw th;
    L56:
        throw new IllegalStateException("TaskFlow dispatch is not allowed from a critical resolver".toString());
    }
}

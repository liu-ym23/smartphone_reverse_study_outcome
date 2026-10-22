package com.ss.android.lark.keyboard.inputstate;

import com.dtf.toyger.base.face.ToygerFaceAlgorithmConfig;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.biz.im.api.extension.keyboard.inputstate.InputStateHandler;
import com.ss.android.lark.keyboard.editor.FlowChatKeyboardEditor;
import com.ss.android.lark.keyboard.event.k;
import com.ss.android.lark.log.Log;
import cya.e;
import cya.f;
import cya.g;
import cya.h;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;

/* JADX INFO: loaded from: classes36.dex */
public final class InputStateController implements cya.d {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f429414l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f429415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f429416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Integer, g<?>> f429417c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<h> f429418d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CoroutineScope f429419e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<Integer, InputStateHandler<? extends h>> f429420f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Channel<Function1<Continuation<? super Unit>, Object>> f429421g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public e f429422h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public StateStack f429423i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f429424j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Function0<Unit> f429425k;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/keyboard/inputstate/InputStateController$StateStack;", "Ljava/util/LinkedList;", "Lcom/ss/android/lark/biz/im/api/extension/keyboard/inputstate/InputState;", ToygerFaceAlgorithmConfig.DEPTH, "", "<init>", "(I)V", "addLast", "", "e", "keyboard-assembler_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class StateStack extends LinkedList<h> {
        private final int depth;

        public /* bridge */ int getSize() {
            return super.size();
        }

        @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
        public final /* bridge */ int size() {
            return getSize();
        }

        public StateStack(int r100) {
            this.depth = r100;
        }

        public void addLast(h r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            super.addLast(r100);
            int r101 = size();
            int r102 = this.depth;
            boolean r103 = false;
            if (1 > r102) goto L6;
            if (r102 >= r101) goto L6;
            r103 = true;
        L6:
            if (r103 == false) goto L9;
            pollFirst();
            return;
        }

        @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
        public final /* bridge */ boolean contains(Object r100) {
            if ((r100 instanceof h) == true) goto L7;
            return false;
        L7:
            return contains((h) r100);
        }

        @Override // java.util.LinkedList, java.util.AbstractList, java.util.List
        public final /* bridge */ int indexOf(Object r100) {
            if ((r100 instanceof h) == true) goto L7;
            return -1;
        L7:
            return indexOf((h) r100);
        }

        @Override // java.util.LinkedList, java.util.AbstractList, java.util.List
        public final /* bridge */ int lastIndexOf(Object r100) {
            if ((r100 instanceof h) == true) goto L7;
            return -1;
        L7:
            return lastIndexOf((h) r100);
        }

        @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
        public final /* bridge */ boolean remove(Object r100) {
            if ((r100 instanceof h) == true) goto L7;
            return false;
        L7:
            return remove((h) r100);
        }

        public /* bridge */ h removeAt(int r100) {
            return remove(r100);
        }

        @Override // java.util.LinkedList, java.util.Deque
        public /* bridge */ /* synthetic */ void addLast(Object r100) {
            addLast((h) r100);
        }

        public /* bridge */ boolean contains(h r100) {
            return super.contains(r100);
        }

        public /* bridge */ int indexOf(h r100) {
            return super.indexOf(r100);
        }

        public /* bridge */ int lastIndexOf(h r100) {
            return super.lastIndexOf(r100);
        }

        @Override // java.util.LinkedList, java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public final /* bridge */ h remove(int r100) {
            return removeAt(r100);
        }

        public /* bridge */ boolean remove(h r100) {
            return super.remove(r100);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f429426a = null;

        static {
            int[] r100 = new int[InputStateHandler.TransformResult.values().length];
            r100[InputStateHandler.TransformResult.KeepTo.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[InputStateHandler.TransformResult.KeepFrom.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[InputStateHandler.TransformResult.KeepBoth.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f429426a = r100;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.inputstate.InputStateController$pop$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.keyboard.inputstate.InputStateController$pop$1", f = "InputStateController.kt", i = {0, 1}, l = {148, 148}, m = "invokeSuspend", n = {"from", "from"}, s = {"L$0", "L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ InputStateController this$0;

        public AnonymousClass1(InputStateController r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(1, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r100) {
            return new AnonymousClass1(this.this$0, r100);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r100) {
            return invoke2(r100);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super Unit> r100) {
            return ((AnonymousClass1) create(r100)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            e r103 = null;
            if (r102 == 0) goto L10;
            if (r102 == 1) goto L9;
            if (r102 != 2) goto L8;
            h r104 = (h) this.L$0;
            ResultKt.throwOnFailure(r100);
        L36:
            h r105 = r104;
        L37:
            InputStateController r106 = this.this$0;
            h r107 = r106.d();
            g<?> r108 = r106.g(r107);
            if (r108 == null) goto L40;
            r108.a(r107);
        L40:
            e r109 = this.this$0.f429422h;
            if (r109 != null) goto L43;
            Intrinsics.throwUninitializedPropertyAccessException("dependency");
        L44:
            k.a.a(r103.n().e(), com.ss.android.lark.keyboard.event.e.a(r105, r107));
            return Unit.INSTANCE;
        L43:
            r103 = r109;
            goto L44
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            InputStateController r110 = (InputStateController) this.L$1;
            h r111 = (h) this.L$0;
            ResultKt.throwOnFailure(r100);
            InputStateController r112 = r110;
            r105 = r111;
        L32:
            this.L$0 = r105;
            this.L$1 = null;
            this.label = 2;
            int r113 = InputStateController.f429414l;
            if (r112.k((h) r100, false) != r101) goto L35;
            return r101;
        L35:
            r104 = r105;
            goto L36
        L10:
            ResultKt.throwOnFailure(r100);
            InputStateController r114 = this.this$0;
            if (r114.f429424j == false) goto L13;
            r105 = r114.d();
            g<?> r115 = r114.g(r105);
            if (r115 == null) goto L17;
            r115.c(r105);
        L17:
            g<?> r116 = r114.g(r105);
            if (r116 == null) goto L20;
            r116.b(r105);
        L20:
            InputStateController r117 = this.this$0;
            r117.getClass();
            if (Intrinsics.areEqual(r105, h.f465974c) == true) goto L23;
            ((ArrayList) r117.f429418d).add(r105);
        L23:
            this.this$0.i();
            StateStack r118 = this.this$0.f429423i;
            if (r118 != null) goto L27;
            Intrinsics.throwUninitializedPropertyAccessException("stack");
            r118 = null;
        L27:
            if (r118.isEmpty() == false) goto L37;
            Log.i("InputStateController", "pop is empty: push default state into stack");
            InputStateController r119 = this.this$0;
            f r120 = r119.f429415a;
            this.L$0 = r105;
            this.L$1 = r119;
            this.label = 1;
            Object r121 = r120.a(false, this);
            if (r121 != r101) goto L31;
            return r101;
        L31:
            r112 = r119;
            r100 = r121;
            goto L32
        L13:
            return Unit.INSTANCE;
        }
    }

    static {
    }

    @Override // cya.d
    public final h d() {
        if (this.f429424j == true) goto L6;
        h.b r100 = h.f465973b;
        return h.f465974c;
    L6:
        StateStack r101 = this.f429423i;
        if (r101 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("stack");
        r101 = null;
    L9:
        h r102 = (h) CollectionsKt.lastOrNull(r101);
        if (r102 != null) goto L13;
        h.b r103 = h.f465973b;
        return h.f465974c;
    L13:
        return r102;
    }

    public final h f() {
        if ((!this.f429418d.isEmpty()) == true) goto L7;
        return null;
    L7:
        return (h) CollectionsKt.last(this.f429418d);
    }

    public final void i() {
        Log.i("InputStateController", "pop inner: state code: " + d().a());
        StateStack r100 = this.f429423i;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("stack");
        r100 = null;
    L5:
        r100.pollLast();
    }

    @Override // cya.d
    public final void pop() {
        m(new AnonymousClass1(this, null));
    }

    public InputStateController(f r100) {
        Intrinsics.checkNotNullParameter(r100, "stateRepo");
        this.f429415a = r100;
        this.f429416b = 2;
        this.f429417c = new LinkedHashMap();
        this.f429418d = new ArrayList();
        this.f429419e = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        ExecutorsKt.from(CoreThreadPool.getDefault().getCachedThreadPool());
        this.f429420f = new LinkedHashMap();
        this.f429421g = ChannelKt.Channel$default(0, null, null, 7, null);
        this.f429425k = new InputStateController$actionAfterInit$1(this);
    }

    @Override // cya.d
    public final boolean a(int r100) {
        if (c(r100) == false) goto L6;
        pop();
        return true;
    L6:
        return false;
    }

    @Override // cya.d
    public final void b(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        m(new InputStateController$push$1(this, r100, null));
    }

    @Override // cya.d
    public final boolean c(int r100) {
        int r101 = d().a();
        if ((r100 & r101) != r101) goto L5;
        return true;
    L5:
        return false;
    }

    public final g<?> g(h r100) {
        int r101 = r100.a();
        Map<Integer, g<?>> r102 = this.f429417c;
        Integer r103 = Integer.valueOf(r101);
        LinkedHashMap r104 = (LinkedHashMap) r102;
        Object r105 = r104.get(r103);
        Object r106 = r105;
        if (r105 != null) goto L11;
        InputStateHandler r107 = (InputStateHandler) ((LinkedHashMap) this.f429420f).get(Integer.valueOf(r101));
        if (r107 == null) goto L7;
        g<?> r108 = r107.a();
    L8:
        if (r108 == null) goto L10;
        r108.e(this.f429415a);
    L10:
        r104.put(r103, r108);
        r106 = r108;
        goto L11
    L7:
        r108 = null;
    L11:
        g<?> r109 = (g) r106;
        Log.i("InputStateController", "getStateConsumer: state code is " + r101);
        return r109;
    }

    public final void h(FlowChatKeyboardEditor.b r100) {
        Intrinsics.checkNotNullParameter(r100, "dependency");
        if (this.f429424j == false) goto L6;
        Log.i("InputStateController", "onInit: controller is inited , method return");
        return;
    L6:
        this.f429422h = r100;
        this.f429424j = true;
        this.f429423i = new StateStack(this.f429416b);
        BuildersKt.launch$default(this.f429419e, null, null, new InputStateController$onInit$1(this, null), 3, null);
        this.f429425k.invoke();
    }

    public final void j(h r100) {
        Log.i("InputStateController", "push inner: state code: " + r100.a());
        StateStack r101 = this.f429423i;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("stack");
        r101 = null;
    L5:
        r101.addLast(r100);
    }

    public final void l(InputStateHandler<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "inputStateHandler");
        this.f429420f.put(Integer.valueOf(r100.getCode()), r100);
    }

    public final void m(Function1<? super Continuation<? super Unit>, ? extends Object> r100) {
        if (CoroutineScopeKt.isActive(this.f429419e) == true) goto L6;
        Log.e("InputStateController", "submit: scope is canceled");
        return;
    L6:
        BuildersKt.launch$default(this.f429419e, null, null, new InputStateController$submit$1(this, r100, null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0079 -> B:22:0x0054). Please report as a decompilation issue!!! */
    public static final Object e(InputStateController r100, Continuation r101) {
        r100.getClass();
        if ((r101 instanceof InputStateController$startConsume$1) == false) goto L7;
        InputStateController$startConsume$1 r102 = (InputStateController$startConsume$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r106 = r102.label;
        if (r106 == 0) goto L20;
        if (r106 == 1) goto L17;
        if (r106 != 2) goto L16;
        ChannelIterator<Function1<Continuation<? super Unit>, Object>> r107 = (ChannelIterator) r102.L$1;
        ReceiveChannel r108 = (ReceiveChannel) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L33
        ?? r109 = r108;
    L22:
        r102.L$0 = r109;     // Catch: Throwable -> L33
        r102.L$1 = r107;     // Catch: Throwable -> L33
        r102.label = 1;     // Catch: Throwable -> L33
        r104 = r107.hasNext(r102);     // Catch: Throwable -> L33
        r106 = r109;
        if (r104 != r105) goto L26;
        return r105;
    L26:
        if (((Boolean) r104).booleanValue() == false) goto L30;
        Function1<Continuation<? super Unit>, Object> r110 = r107.next();     // Catch: Throwable -> L33
        r102.L$0 = r106;     // Catch: Throwable -> L33
        r102.L$1 = r107;     // Catch: Throwable -> L33
        r102.label = 2;     // Catch: Throwable -> L33
        r109 = r106;
        if (r110.invoke(r102) != r105) goto L22;
        return r105;
    L30:
        Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L33
        ChannelsKt.cancelConsumed(r106, null);
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r107 = (ChannelIterator) r102.L$1;
        ReceiveChannel r112 = (ReceiveChannel) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L33
        r106 = r112;
        goto L26
    L20:
        ResultKt.throwOnFailure(r104);
        Channel<Function1<Continuation<? super Unit>, Object>> r113 = r100.f429421g;
        r107 = r113.iterator();     // Catch: Throwable -> L33
        r109 = r113;
    L33:
        th = move-exception;
        throw th;     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        ChannelsKt.cancelConsumed(r106, th);
        throw th;
    L7:
        r102 = new InputStateController$startConsume$1(r100, r101);
        goto L8
    }

    public final Object k(h r100, boolean r101) {
        h r102 = d();
        g<?> r103 = g(r102);
        if (r103 == null) goto L6;
        r103.c(r102);
    L6:
        if (Intrinsics.areEqual(r102, h.f465974c) == true) goto L8;
        ((ArrayList) this.f429418d).add(r102);
    L8:
        Object r104 = ((LinkedHashMap) this.f429420f).get(Boxing.boxInt(r100.a()));
        e r105 = null;
        if ((r104 instanceof InputStateHandler) == false) goto L11;
        InputStateHandler r106 = (InputStateHandler) r104;
    L13:
        if (r106 != null) goto L16;
        Log.i("InputStateController", "unsupported input state, method return");
        return Boxing.boxBoolean(false);
    L16:
        int r107 = b.f429426a[r106.b(r102, r100).ordinal()];
        if (r107 != 1) goto L19;
        Log.i("InputStateController", "pushSuspend: keep to");
        g<?> r108 = g(r102);
        if (r108 == null) goto L34;
        r108.b(r102);
    L34:
        i();
        j(r100);
        g<?> r109 = g(r100);
        if (r109 == null) goto L37;
        r109.a(r100);
    L37:
        if (r101 == false) goto L44;
        e r110 = this.f429422h;
        if (r110 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("dependency");
    L42:
        k.a.a(r105.n().e(), com.ss.android.lark.keyboard.event.e.a(r102, r100));
        goto L44
    L41:
        r105 = r110;
    L44:
        return Boxing.boxBoolean(true);
    L19:
        if (r107 != 2) goto L21;
        Log.i("InputStateController", "pushSuspend: keep from");
        Unit r111 = Unit.INSTANCE;
        goto L37
    L21:
        if (r107 != 3) goto L29;
        Log.i("InputStateController", "pushSuspend: keep both");
        g<?> r112 = g(r102);
        if (r112 == null) goto L25;
        r112.f(r102);
    L25:
        j(r100);
        g<?> r113 = g(r100);
        if (r113 == null) goto L37;
        r113.a(r100);
        goto L37
    L29:
        throw new NoWhenBranchMatchedException();
    L11:
        r106 = null;
        goto L13
    }
}

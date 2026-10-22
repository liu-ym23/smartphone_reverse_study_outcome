package com.ss.android.lark.picker.doubao.view.pickercommon;

import com.bytedance.map.api.monitor.MapMonitorConst;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.doubao.api.DoubaoLocalChatterProvider;
import com.ss.android.lark.picker.doubao.api.DoubaoLocalChatterTagState;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 )2\u00020\u0001:\u0001)B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ2\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001e2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u001a0\u0019J\u0006\u0010%\u001a\u00020\u001aJ\b\u0010&\u001a\u00020\u001aH\u0002J\u000e\u0010'\u001a\u00020\u001aH\u0082@¢\u0006\u0002\u0010(R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u0017\u001a \u0012\u0004\u0012\u00020\u000f\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u001a0\u00190\u00180\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/ss/android/lark/picker/doubao/view/pickercommon/DoubaoChatterTagEnricher;", "", ShortVideoSegments.KEY_PROP_PROVIDER, "Lcom/ss/android/lark/picker/doubao/api/DoubaoLocalChatterProvider;", "mainDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "ioDispatcher", "batchWindowMs", "", "<init>", "(Lcom/ss/android/lark/picker/doubao/api/DoubaoLocalChatterProvider;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;J)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "pendingIds", "Ljava/util/LinkedHashSet;", "", "Lkotlin/collections/LinkedHashSet;", "inFlightIds", "", "resolvedStates", "", "Lcom/ss/android/lark/picker/doubao/api/DoubaoLocalChatterTagState;", "unavailableIds", "callbacks", "", "Lkotlin/Function1;", "", "flushJob", "Lkotlinx/coroutines/Job;", "destroyed", "", "request", "chatterId", "currentState", "Lcom/ss/android/lark/picker/doubao/view/pickercommon/DoubaoPickerTagState;", "currentHasTagData", "onResolved", MapMonitorConst.EVENT_DESTROY, "scheduleFlush", "flushPending", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "picker-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoubaoChatterTagEnricher {
    private static final Companion Companion = null;
    private static final long DEFAULT_BATCH_WINDOW_MS = 16;
    private static final String TAG = "DoubaoTagEnricher";
    private final long batchWindowMs;
    private final Map<String, List<Function1<DoubaoLocalChatterTagState, Unit>>> callbacks;
    private boolean destroyed;
    private Job flushJob;
    private final Set<String> inFlightIds;
    private final CoroutineDispatcher ioDispatcher;
    private final CoroutineDispatcher mainDispatcher;
    private final LinkedHashSet<String> pendingIds;
    private final DoubaoLocalChatterProvider provider;
    private final Map<String, DoubaoLocalChatterTagState> resolvedStates;
    private final CoroutineScope scope;
    private final Set<String> unavailableIds;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/picker/doubao/view/pickercommon/DoubaoChatterTagEnricher$Companion;", "", "<init>", "()V", "TAG", "", "DEFAULT_BATCH_WINDOW_MS", "", "picker-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.picker.doubao.view.pickercommon.DoubaoChatterTagEnricher$flushPending$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.picker.doubao.view.pickercommon.DoubaoChatterTagEnricher", f = "DoubaoChatterTagEnricher.kt", i = {0}, l = {97}, m = "flushPending", n = {"ids"}, s = {"L$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoubaoChatterTagEnricher this$0;

        public AnonymousClass1(DoubaoChatterTagEnricher r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return DoubaoChatterTagEnricher.access$flushPending(this.this$0, this);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.picker.doubao.view.pickercommon.DoubaoChatterTagEnricher$scheduleFlush$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.picker.doubao.view.pickercommon.DoubaoChatterTagEnricher$scheduleFlush$1", f = "DoubaoChatterTagEnricher.kt", i = {}, l = {82, 83}, m = "invokeSuspend", n = {}, s = {})
    public static final class C120901 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoubaoChatterTagEnricher this$0;

        public C120901(DoubaoChatterTagEnricher r100, Continuation<? super C120901> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C120901(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C120901) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L10;
            if (r102 == 1) goto L9;
            if (r102 != 2) goto L8;
            ResultKt.throwOnFailure(r100);
        L16:
            DoubaoChatterTagEnricher.access$setFlushJob$p(this.this$0, null);
            if ((!DoubaoChatterTagEnricher.access$getPendingIds$p(this.this$0).isEmpty()) == false) goto L20;
            DoubaoChatterTagEnricher.access$scheduleFlush(this.this$0);
        L20:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r100);
        L13:
            DoubaoChatterTagEnricher r103 = this.this$0;
            this.label = 2;
            if (DoubaoChatterTagEnricher.access$flushPending(r103, this) != r101) goto L16;
            return r101;
        L10:
            ResultKt.throwOnFailure(r100);
            long r104 = DoubaoChatterTagEnricher.access$getBatchWindowMs$p(this.this$0);
            this.label = 1;
            if (DelayKt.delay(r104, this) != r101) goto L13;
            return r101;
        }
    }

    static {
        Companion = new Companion(null);
    }

    private final void scheduleFlush() {
        Job r100 = this.flushJob;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        if (r101 == false) goto L9;
        return;
    L9:
        this.flushJob = BuildersKt.launch$default(this.scope, null, null, new C120901(this, null), 3, null);
        return;
    L5:
        if (r100.isActive() != true) goto L7;
        r101 = true;
        goto L7
    }

    public final void destroy() {
        if (this.destroyed == false) goto L5;
        return;
    L5:
        this.destroyed = true;
        CoroutineScopeKt.cancel$default(this.scope, null, 1, null);
        this.flushJob = null;
        this.pendingIds.clear();
        this.inFlightIds.clear();
        this.callbacks.clear();
        this.resolvedStates.clear();
        this.unavailableIds.clear();
    }

    public static final /* synthetic */ long access$getBatchWindowMs$p(DoubaoChatterTagEnricher r100) {
        return r100.batchWindowMs;
    }

    public static final /* synthetic */ LinkedHashSet access$getPendingIds$p(DoubaoChatterTagEnricher r100) {
        return r100.pendingIds;
    }

    public static final /* synthetic */ DoubaoLocalChatterProvider access$getProvider$p(DoubaoChatterTagEnricher r100) {
        return r100.provider;
    }

    public static final /* synthetic */ void access$scheduleFlush(DoubaoChatterTagEnricher r100) {
        r100.scheduleFlush();
    }

    private final Object flushPending(Continuation<? super Unit> r110) {
        if ((r110 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r100 = (AnonymousClass1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L18;
        if (r103 != 1) goto L17;
        List r104 = (List) r100.L$0;
        ResultKt.throwOnFailure(r111);     // Catch: Throwable -> L14
    L28:
        Object r112 = Result.m9449constructorimpl((Map) r111);     // Catch: Throwable -> L14
    L34:
        if (this.destroyed == false) goto L38;
        return Unit.INSTANCE;
    L38:
        if (Result.m9456isSuccessimpl(r112) == false) goto L59;
        Map r105 = (Map) r112;
        Iterator r106 = r104.iterator();
    L41:
        if (r106.hasNext() == false) goto L59;
        String r107 = (String) r106.next();
        DoubaoLocalChatterTagState r108 = (DoubaoLocalChatterTagState) r105.get(r107);
        List<Function1<DoubaoLocalChatterTagState, Unit>> r109 = this.callbacks.remove(r107);
        if (r109 != null) goto L45;
        r109 = CollectionsKt.emptyList();
    L45:
        this.inFlightIds.remove(r107);
        if (r108 == null) goto L47;
        this.resolvedStates.put(r107, r108);
        Iterator<T> r113 = r109.iterator();
    L50:
        if (r113.hasNext() == false) goto L41;
        Function1 r114 = (Function1) r113.next();
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L54
        r114.invoke(r108);     // Catch: Throwable -> L54
        Object r116 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L54
    L56:
        Throwable r117 = Result.m9452exceptionOrNullimpl(r116);
        if (r117 == null) goto L50;
        Log.e(TAG, "notify local chatter tag state failed", r117);
    L54:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L56
    L47:
        Boxing.boxBoolean(this.unavailableIds.add(r107));
    L59:
        Throwable r119 = Result.m9452exceptionOrNullimpl(r112);
        if (r119 == null) goto L66;
        Log.e(TAG, "get local chatter tag states failed, count=" + r104.size(), r119);
        Iterator r120 = r104.iterator();
    L63:
        if (r120.hasNext() == false) goto L66;
        String r121 = (String) r120.next();
        this.unavailableIds.add(r121);
        this.callbacks.remove(r121);
        this.inFlightIds.remove(r121);
    L66:
        return Unit.INSTANCE;
    L14:
        Throwable th10 = th;
    L32:
        Result.Companion r122 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th10));
        goto L34
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r111);
        List r123 = CollectionsKt.toList(this.pendingIds);
        this.pendingIds.clear();
        if (r123.isEmpty() == true) goto L68;
        if (this.destroyed == true) goto L68;
        this.inFlightIds.addAll(r123);
        Result.Companion r124 = Result.Companion;     // Catch: Throwable -> L30
        CoroutineDispatcher r125 = this.ioDispatcher;     // Catch: Throwable -> L30
        DoubaoChatterTagEnricher$flushPending$result$1$1 r126 = new DoubaoChatterTagEnricher$flushPending$result$1$1(this, r123, null);     // Catch: Throwable -> L30
        r100.L$0 = r123;     // Catch: Throwable -> L30
        r100.label = 1;     // Catch: Throwable -> L30
        Object r127 = BuildersKt.withContext(r125, r126, r100);     // Catch: Throwable -> L30
        if (r127 != r102) goto L27;
        return r102;
    L27:
        r104 = r123;
        r111 = r127;
    L30:
        th = move-exception;
        r104 = r123;
        th10 = th;
    L68:
        return Unit.INSTANCE;
    L7:
        r100 = new AnonymousClass1(this, r110);
        goto L8
    }

    public static final /* synthetic */ Object access$flushPending(DoubaoChatterTagEnricher r100, Continuation r101) {
        return r100.flushPending(r101);
    }

    public static final /* synthetic */ void access$setFlushJob$p(DoubaoChatterTagEnricher r100, Job r101) {
        r100.flushJob = r101;
    }

    public DoubaoChatterTagEnricher(DoubaoLocalChatterProvider r100, CoroutineDispatcher r101, CoroutineDispatcher r102, long r103) {
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
        Intrinsics.checkNotNullParameter(r101, "mainDispatcher");
        Intrinsics.checkNotNullParameter(r102, "ioDispatcher");
        this.provider = r100;
        this.mainDispatcher = r101;
        this.ioDispatcher = r102;
        this.batchWindowMs = r103;
        this.scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(r101));
        this.pendingIds = new LinkedHashSet();
        this.inFlightIds = new LinkedHashSet();
        this.resolvedStates = new LinkedHashMap();
        this.unavailableIds = new LinkedHashSet();
        this.callbacks = new LinkedHashMap();
    }

    public final void request(String r100, final DoubaoPickerTagState r101, final boolean r102, final Function1<? super DoubaoLocalChatterTagState, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "chatterId");
        Intrinsics.checkNotNullParameter(r101, "currentState");
        Intrinsics.checkNotNullParameter(r103, "onResolved");
        if (this.destroyed == false) goto L5;
        return;
    L5:
        if (r100.length() != 0) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == false) goto L10;
        return;
    L10:
        if (DoubaoChatterTagEnricherKt.access$hasAllLocalPersonalTags(r101) == false) goto L13;
        if (r102 == false) goto L13;
        return;
    L13:
        Function1<DoubaoLocalChatterTagState, Unit> r105 = new DoubaoChatterTagEnricher$request$callback$1(r101, r102, r103);
        DoubaoLocalChatterTagState r106 = this.resolvedStates.get(r100);
        if (r106 == null) goto L18;
        r105.invoke(r106);
        return;
    L18:
        if (this.unavailableIds.contains(r100) == false) goto L20;
        return;
    L20:
        Map<String, List<Function1<DoubaoLocalChatterTagState, Unit>>> r107 = this.callbacks;
        List<Function1<DoubaoLocalChatterTagState, Unit>> r108 = r107.get(r100);
        if (r108 != null) goto L23;
        r108 = new ArrayList();
        r107.put(r100, r108);
    L23:
        r108.add(r105);
        if (this.pendingIds.contains(r100) == false) goto L26;
        return;
    L26:
        if (this.inFlightIds.contains(r100) == true) goto L34;
        this.pendingIds.add(r100);
        scheduleFlush();
        return;
    L34:
        return;
    L7:
        r104 = false;
        goto L8
    }

    public /* synthetic */ DoubaoChatterTagEnricher(DoubaoLocalChatterProvider r100, CoroutineDispatcher r101, CoroutineDispatcher r102, long r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 2) == 0) goto L5;
        r101 = Dispatchers.getMain().getImmediate();
    L5:
        CoroutineDispatcher r103 = r101;
        if ((r111 & 4) == 0) goto L8;
        r102 = Dispatchers.getIO();
    L8:
        CoroutineDispatcher r104 = r102;
        if ((r111 & 8) == 0) goto L11;
        r110 = 16;
    L11:
        this(r100, r103, r104, r110);
    }
}

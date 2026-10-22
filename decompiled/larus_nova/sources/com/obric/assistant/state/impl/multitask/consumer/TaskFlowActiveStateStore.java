package com.obric.assistant.state.impl.multitask.consumer;

import android.os.SystemClock;
import com.bytedance.sdk.bridge.annotation.BridgeSyncType;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.state.api.multitask.IObricTaskFlowActiveStateService;
import com.obric.assistant.util.r;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import jha.o;
import jha.p;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u001e\n\u0002\b\b\b\u0000\u0018\u0000 E2\u00020\u00012\u00020\u0002:\u0005ABCDEB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u001e\u0010\u001c\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b0\u001d2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J \u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u0019H\u0016J \u0010\"\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u0019H\u0016J\u0010\u0010#\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u000fH\u0016J,\u0010$\u001a\u00020\u001f2\n\u0010%\u001a\u0006\u0012\u0002\b\u00030\n2\u000e\u0010&\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b2\u0006\u0010'\u001a\u00020\u0019H\u0016J\u0010\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010+\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020,H\u0002JP\u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020\u00102\n\u0010%\u001a\u0006\u0012\u0002\b\u00030\n2\u0010\u0010/\u001a\f\u0012\u0006\b\u0001\u0012\u00020\f\u0018\u00010\u000b2\u0010\u00100\u001a\f\u0012\u0006\b\u0001\u0012\u00020\f\u0018\u00010\u000b2\u000e\u0010&\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000bH\u0002J)\u00101\u001a\u0004\u0018\u00010\u00192\u0006\u0010.\u001a\u00020\u00102\u0010\u00102\u001a\f\u0012\u0006\b\u0001\u0012\u00020\f\u0018\u00010\u000bH\u0002¢\u0006\u0002\u00103J8\u00104\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020\u00102\u0014\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b0\u001d2\u0010\u0010&\u001a\f\u0012\u0006\b\u0001\u0012\u00020\f\u0018\u00010\u000bH\u0002J^\u00105\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u00106\u001a\u0002072<\b\u0002\u0010\b\u001a6\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b0\tj\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b`\rH\u0002J \u00108\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00192\u0006\u00109\u001a\u00020\u0019H\u0002J\u0010\u0010:\u001a\u00020\u00192\u0006\u0010.\u001a\u00020\u0010H\u0002J\u0010\u0010;\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020\u0015H\u0002J,\u0010<\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b0\u001d2\u0014\u0010=\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b0>H\u0002J4\u0010?\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b0\u001d2\u0014\u0010=\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b0>2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002JZ\u0010@\u001a6\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b0\tj\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b`\r2\u0014\u0010=\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b0>2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000RB\u0010\b\u001a6\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b0\tj\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b`\rX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\tj\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010`\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Lcom/obric/assistant/state/impl/multitask/consumer/TaskFlowActiveStateStore;", "Lcom/obric/assistant/state/api/multitask/IObricTaskFlowActiveStateService;", "Lcom/obric/assistant/state/impl/multitask/consumer/TaskFlowActiveStateReceiver;", "<init>", "()V", "lock", "", "dispatchLock", "activeStates", "Ljava/util/LinkedHashMap;", "Lcom/obric/assistant/state/multitask/core/TaskFlowId;", "Lcom/obric/assistant/state/multitask/core/TaskStateEnvelope;", "Lcom/obric/assistant/state/multitask/core/TaskState;", "Lkotlin/collections/LinkedHashMap;", "observerRegistrations", "Lcom/obric/assistant/state/api/multitask/ObricTaskFlowActiveStateObserver;", "Lcom/obric/assistant/state/impl/multitask/consumer/TaskFlowActiveStateStore$ObserverRegistration;", "registrationGeneration", "Ljava/util/concurrent/atomic/AtomicLong;", "asyncCommands", "Lkotlinx/coroutines/channels/Channel;", "Lcom/obric/assistant/state/impl/multitask/consumer/TaskFlowActiveStateStore$AsyncCommand;", "asyncScope", "Lkotlinx/coroutines/CoroutineScope;", "isActive", "", "filter", "Lcom/obric/assistant/state/api/multitask/ObricTaskFlowActiveStateFilter;", "getActiveStates", "", "registerObserver", "", "observer", "sticky", "registerSyncObserver", "unregisterObserver", "onStateChanged", "taskFlowId", "changedState", "active", "processAsyncRegistration", "command", "Lcom/obric/assistant/state/impl/multitask/consumer/TaskFlowActiveStateStore$AsyncCommand$Register;", "processAsyncStateChange", "Lcom/obric/assistant/state/impl/multitask/consumer/TaskFlowActiveStateStore$AsyncCommand$StateChanged;", "processStateChange", "registration", "previousActiveState", "currentActiveState", "matches", "state", "(Lcom/obric/assistant/state/impl/multitask/consumer/TaskFlowActiveStateStore$ObserverRegistration;Lcom/obric/assistant/state/multitask/core/TaskStateEnvelope;)Ljava/lang/Boolean;", "notifyObserver", "newRegistration", "dispatchMode", "Lcom/obric/assistant/state/impl/multitask/consumer/TaskFlowActiveStateStore$DispatchMode;", "logRegistration", "replaced", "isCurrent", "enqueueAsyncCommand", "immutableSnapshot", "states", "", "filterSnapshot", "filterStateMap", "DispatchMode", "ObserverRegistration", "StateTransition", "AsyncCommand", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskFlowActiveStateStore implements IObricTaskFlowActiveStateService {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f393007h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f393008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f393009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashMap<jha.g<?>, p<? extends o>> f393010c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedHashMap<zga.e, c> f393011d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicLong f393012e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Channel<a> f393013f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CoroutineScope f393014g;

    /* JADX INFO: renamed from: com.obric.assistant.state.impl.multitask.consumer.TaskFlowActiveStateStore$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.state.impl.multitask.consumer.TaskFlowActiveStateStore$1", f = "ObricTaskFlowActiveStateServiceImpl.kt", i = {}, l = {85}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ TaskFlowActiveStateStore this$0;

        public AnonymousClass1(TaskFlowActiveStateStore r100, Continuation<? super AnonymousClass1> r101) {
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

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0036 -> B:13:0x003b). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L8;
            if (r101 != 1) goto L7;
            ChannelIterator<a> r102 = (ChannelIterator) this.L$0;
            ResultKt.throwOnFailure(r110);
            ChannelIterator<a> r103 = r102;
            Object r104 = r100;
            AnonymousClass1 r105 = this;
        L14:
            if (((Boolean) r110).booleanValue() == false) goto L29;
            a r111 = r103.next();
            if ((r111 instanceof a.C4633a) == false) goto L18;
            TaskFlowActiveStateStore r106 = r105.this$0;
            int r107 = TaskFlowActiveStateStore.f393007h;
            r106.getClass();
            ((a.C4633a) r111).getClass();
            r106.d(null);
            throw null;
        L18:
            if ((r111 instanceof a.b) == false) goto L25;
            TaskFlowActiveStateStore r108 = r105.this$0;
            a.b r112 = (a.b) r111;
            int r109 = TaskFlowActiveStateStore.f393007h;
            r108.getClass();
            Iterator<T> r113 = r112.f393017a.iterator();
        L21:
            if (r113.hasNext() == false) goto L23;
            r108.g((c) r113.next(), r112.f393018b, r112.f393019c, r112.f393020d, r112.f393021e);
            goto L21
        L23:
            AnonymousClass1 r114 = r105;
            r100 = r104;
            ChannelIterator<a> r115 = r103;
        L9:
            r114.L$0 = r115;
            r114.label = 1;
            Object r116 = r115.hasNext(r114);
            if (r116 != r100) goto L12;
            return r100;
        L12:
            Object r117 = r100;
            r105 = r114;
            r110 = r116;
            r103 = r115;
            r104 = r117;
            goto L14
        L25:
            throw new NoWhenBranchMatchedException();
        L29:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r110);
            r115 = this.this$0.f393013f.iterator();
            r114 = this;
            goto L9
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/state/impl/multitask/consumer/TaskFlowActiveStateStore$DispatchMode;", "", "<init>", "(Ljava/lang/String;I)V", BridgeSyncType.ASYNC, BridgeSyncType.SYNC, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum DispatchMode extends Enum<DispatchMode> {
        public static final DispatchMode ASYNC = null;
        public static final DispatchMode SYNC = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DispatchMode[] f393015a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f393016b = null;

        public static EnumEntries<DispatchMode> getEntries() {
            return f393016b;
        }

        static {
            DispatchMode r100 = new DispatchMode(BridgeSyncType.ASYNC, 0);
            ASYNC = r100;
            DispatchMode r101 = new DispatchMode(BridgeSyncType.SYNC, 1);
            SYNC = r101;
            DispatchMode[] r102 = {r100, r101};
            f393015a = r102;
            f393016b = EnumEntriesKt.enumEntries(r102);
        }

        public static DispatchMode[] values() {
            return (DispatchMode[]) f393015a.clone();
        }

        public static DispatchMode valueOf(String r100) {
            return (DispatchMode) r27.a.a(DispatchMode.class, r100);
        }

        public DispatchMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes33.dex */
    public interface a {

        /* JADX INFO: renamed from: com.obric.assistant.state.impl.multitask.consumer.TaskFlowActiveStateStore$a$a, reason: collision with other inner class name */
        public static final class C4633a implements a {
            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C4633a) == true) goto L8;
                return false;
            L8:
                ((C4633a) r100).getClass();
                if (Intrinsics.areEqual(null, null) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(null, null) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                throw null;
            }

            public final String toString() {
                return "Register(registration=null, activeStates=null, sticky=false, replaced=false)";
            }
        }

        public static final class b implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final List<c> f393017a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final jha.g<?> f393018b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final p<? extends o> f393019c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final p<? extends o> f393020d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final p<? extends o> f393021e;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof b) == true) goto L8;
                return false;
            L8:
                b r101 = (b) r100;
                if (Intrinsics.areEqual(this.f393017a, r101.f393017a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f393018b, r101.f393018b) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.f393019c, r101.f393019c) == true) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.f393020d, r101.f393020d) == true) goto L21;
                return false;
            L21:
                if (Intrinsics.areEqual(this.f393021e, r101.f393021e) == true) goto L23;
                return false;
            L23:
                return true;
            }

            public final int hashCode() {
                int r100 = ((this.f393017a.hashCode() * 31) + this.f393018b.hashCode()) * 31;
                p<? extends o> r101 = this.f393019c;
                int r102 = 0;
                if (r101 != null) goto L5;
                int r103 = 0;
            L6:
                int r104 = (r100 + r103) * 31;
                p<? extends o> r105 = this.f393020d;
                if (r105 == null) goto L11;
                r102 = r105.hashCode();
            L11:
                return ((r104 + r102) * 31) + this.f393021e.hashCode();
            L5:
                r103 = r101.hashCode();
                goto L6
            }

            public final String toString() {
                return "StateChanged(registrations=" + this.f393017a + ", taskFlowId=" + this.f393018b + ", previousActiveState=" + this.f393019c + ", currentActiveState=" + this.f393020d + ", changedState=" + this.f393021e + ')';
            }

            public b(List<c> r100, jha.g<?> r101, p<? extends o> r102, p<? extends o> r103, p<? extends o> r104) {
                Intrinsics.checkNotNullParameter(r100, "registrations");
                Intrinsics.checkNotNullParameter(r101, "taskFlowId");
                Intrinsics.checkNotNullParameter(r104, "changedState");
                this.f393017a = r100;
                this.f393018b = r101;
                this.f393019c = r102;
                this.f393020d = r103;
                this.f393021e = r104;
            }
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class b {
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final zga.e f393022a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final zga.d f393023b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final DispatchMode f393024c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f393025d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final LinkedHashMap<jha.g<?>, p<? extends o>> f393026e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f393022a, r101.f393022a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f393023b, r101.f393023b) == true) goto L15;
            return false;
        L15:
            if (this.f393024c == r101.f393024c) goto L18;
            return false;
        L18:
            if (this.f393025d == r101.f393025d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f393026e, r101.f393026e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((this.f393022a.hashCode() * 31) + this.f393023b.hashCode()) * 31) + this.f393024c.hashCode()) * 31;
            long r101 = this.f393025d;
            return ((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f393026e.hashCode();
        }

        public final String toString() {
            return "ObserverRegistration(observer=" + this.f393022a + ", filter=" + this.f393023b + ", dispatchMode=" + this.f393024c + ", generation=" + this.f393025d + ", activeStates=" + this.f393026e + ')';
        }

        public c(zga.e r100, zga.d r101, DispatchMode r102, long r103, LinkedHashMap<jha.g<?>, p<? extends o>> r104) {
            Intrinsics.checkNotNullParameter(r100, "observer");
            Intrinsics.checkNotNullParameter(r101, "filter");
            Intrinsics.checkNotNullParameter(r102, "dispatchMode");
            Intrinsics.checkNotNullParameter(r104, "activeStates");
            this.f393022a = r100;
            this.f393023b = r101;
            this.f393024c = r102;
            this.f393025d = r103;
            this.f393026e = r104;
        }
    }

    static {
    }

    public TaskFlowActiveStateStore() {
        this.f393008a = new Object();
        this.f393009b = new Object();
        this.f393010c = new LinkedHashMap();
        this.f393011d = new LinkedHashMap();
        this.f393012e = new AtomicLong(0);
        this.f393013f = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        CoroutineScope r100 = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getDefault()));
        this.f393014g = r100;
        BuildersKt.launch$default(r100, null, null, new AnonymousClass1(this, null), 3, null);
    }

    @Override // com.obric.assistant.state.api.multitask.IObricTaskFlowActiveStateService
    public final void a(zga.e r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        Object r101 = this.f393008a;
        monitor-enter(r101);
        c r102 = this.f393011d.remove(r100);     // Catch: Throwable -> L9
        monitor-exit(r101);
        if (r102 == null) goto L14;
        FLogger.f375446a.i("ObricTaskFlowActiveState", "observer_unregistered observer=".concat(r100.getClass().getName()));
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.assistant.state.api.multitask.IObricTaskFlowActiveStateService
    public final boolean b(r r100) {
        Intrinsics.checkNotNullParameter(r100, "filter");
        Object r101 = this.f393008a;
        monitor-enter(r101);
        List r102 = CollectionsKt.toList(this.f393010c.values());     // Catch: Throwable -> L19
        monitor-exit(r101);
        List r103 = r102;
        if ((r103 instanceof Collection) == true) goto L9;
    L11:
        Iterator r104 = r103.iterator();
    L13:
        if (r104.hasNext() == false) goto L17;
        if (r100.a((p) r104.next()) == false) goto L13;
        return true;
    L17:
        return false;
    L9:
        if (r103.isEmpty() == false) goto L11;
    L19:
        th = move-exception;
        throw th;
    }

    public final boolean d(c r100) {
        Object r101 = this.f393008a;
        monitor-enter(r101);
        c r102 = this.f393011d.get(r100.f393022a);     // Catch: Throwable -> L12
        boolean r103 = false;
        if (r102 == null) goto L10;
        if (r102.f393025d != r100.f393025d) goto L10;
        r103 = true;
    L10:
        monitor-exit(r101);
        return r103;
    L12:
        th = move-exception;
        throw th;
    }

    public static Boolean e(c r100, p r101) {
        if (r101 != null) goto L12;
    L6:
        boolean r102 = false;
    L7:
        return Boolean.valueOf(r102);
    L9:
        th = move-exception;
        FLogger.f375446a.e("ObricTaskFlowActiveState", "apply observer filter failed", th);
        return null;
    L12:
        boolean r103 = r100.f393023b.a(r101);     // Catch: Throwable -> L9
        r102 = true;
        if (r103 != true) goto L6;
        goto L6
    }

    @Override // com.obric.assistant.state.api.multitask.IObricTaskFlowActiveStateService
    public final void c(zga.e r110, zga.d r111) {
        Intrinsics.checkNotNullParameter(r110, "observer");
        Intrinsics.checkNotNullParameter(r111, "filter");
        Object r100 = this.f393009b;
        monitor-enter(r100);
        Object r101 = this.f393008a;     // Catch: Throwable -> L40
        monitor-enter(r101);     // Catch: Throwable -> L40
        List r102 = CollectionsKt.toList(this.f393010c.values());     // Catch: Throwable -> L37
        monitor-exit(r101);     // Catch: Throwable -> L40
        ArrayList r103 = new ArrayList();     // Catch: Throwable -> L33
        Iterator r104 = r102.iterator();     // Catch: Throwable -> L33
    L10:
        if (r104.hasNext() == false) goto L14;
        Object r105 = r104.next();     // Catch: Throwable -> L33
        if (r111.a((p) r105) == false) goto L10;
        r103.add(r105);     // Catch: Throwable -> L33
        goto L10
    L14:
        LinkedHashMap r106 = new LinkedHashMap();     // Catch: Throwable -> L33
        Iterator r107 = r103.iterator();     // Catch: Throwable -> L33
    L15:
        if (r107.hasNext() == false) goto L19;
        Object r108 = r107.next();     // Catch: Throwable -> L33
        r106.put(((p) r108).f499147a, r108);     // Catch: Throwable -> L33
        goto L15
    L19:
        Object r109 = this.f393008a;     // Catch: Throwable -> L40
        monitor-enter(r109);     // Catch: Throwable -> L40
        boolean r112 = this.f393011d.containsKey(r110);     // Catch: Throwable -> L30
        c r113 = new c(r110, r111, DispatchMode.SYNC, this.f393012e.incrementAndGet(), r106);     // Catch: Throwable -> L30
        this.f393011d.put(r110, r113);     // Catch: Throwable -> L30
        Unit r114 = Unit.INSTANCE;     // Catch: Throwable -> L30
        monitor-exit(r109);     // Catch: Throwable -> L40
        FLogger r115 = FLogger.f375446a;     // Catch: Throwable -> L40
        StringBuilder r116 = new StringBuilder("observer_");     // Catch: Throwable -> L40
        if (r112 == false) goto L26;
        String r117 = "replaced";
    L27:
        r116.append(r117);     // Catch: Throwable -> L40
        r116.append(" observer=");     // Catch: Throwable -> L40
        r116.append(r113.f393022a.getClass().getName());     // Catch: Throwable -> L40
        r116.append(",mode=");     // Catch: Throwable -> L40
        r116.append(r113.f393024c);     // Catch: Throwable -> L40
        r116.append(",sticky=true,filteredCount=");     // Catch: Throwable -> L40
        r116.append(r113.f393026e.size());     // Catch: Throwable -> L40
        r115.i("ObricTaskFlowActiveState", r116.toString());     // Catch: Throwable -> L40
        f(r113, Collections.unmodifiableList(new ArrayList(r106.values())), null);     // Catch: Throwable -> L40
        monitor-exit(r100);
        return;
    L26:
        r117 = "registered";
        goto L27
    L30:
        th = move-exception;
        throw th;     // Catch: Throwable -> L40
    L33:
        th = move-exception;
        FLogger.f375446a.e("ObricTaskFlowActiveState", "apply observer initial filter failed", th);     // Catch: Throwable -> L40
        return;
    L37:
        th = move-exception;
        throw th;     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        throw th;
    }

    public final void f(c r100, List<? extends p<? extends o>> r101, p<? extends o> r102) {
        if (d(r100) == true) goto L5;
        return;
    L5:
        long r103 = SystemClock.elapsedRealtime();
        r100.f393022a.a(r101, r102);     // Catch: Throwable -> L17
        FLogger r104 = FLogger.f375446a;     // Catch: Throwable -> L17
        StringBuilder r105 = new StringBuilder("observer_notified observer=");     // Catch: Throwable -> L17
        r105.append(r100.f393022a.getClass().getName());     // Catch: Throwable -> L17
        r105.append(",mode=");     // Catch: Throwable -> L17
        r105.append(r100.f393024c);     // Catch: Throwable -> L17
        r105.append(",taskFlowId=");     // Catch: Throwable -> L17
        String r106 = null;
        if (r102 == null) goto L9;
        Object r107 = r102.f499147a;     // Catch: Throwable -> L17
    L10:
        r105.append(r107);     // Catch: Throwable -> L17
        r105.append(",state=");     // Catch: Throwable -> L17
        if (r102 == null) goto L15;
        S r108 = r102.f499148b;     // Catch: Throwable -> L17
        if (r108 == 0) goto L15;
        r106 = r108.getClass().getSimpleName();     // Catch: Throwable -> L17
    L15:
        r105.append(r106);     // Catch: Throwable -> L17
        r105.append(",filteredCount=");     // Catch: Throwable -> L17
        r105.append(r101.size());     // Catch: Throwable -> L17
        r105.append(",callbackCostMs=");     // Catch: Throwable -> L17
        r105.append(SystemClock.elapsedRealtime() - r103);     // Catch: Throwable -> L17
        r104.i("ObricTaskFlowActiveState", r105.toString());     // Catch: Throwable -> L17
        return;
    L9:
        r107 = null;
    L17:
        th = move-exception;
        FLogger.f375446a.e("ObricTaskFlowActiveState", "notify observer failed", th);
    }

    public final void g(c r100, jha.g<?> r101, p<? extends o> r102, p<? extends o> r103, p<? extends o> r104) {
        if (d(r100) == true) goto L5;
        return;
    L5:
        Boolean r105 = e(r100, r102);
        if (r105 == null) goto L23;
        boolean r106 = r105.booleanValue();
        Boolean r107 = e(r100, r103);
        if (r107 == null) goto L24;
        boolean r108 = r107.booleanValue();
        if (r106 == true) goto L13;
        if (r108 == true) goto L13;
        return;
    L13:
        p<? extends o> r109 = r100.f393026e.get(r101);
        if (r108 == false) goto L17;
        if (r103 == null) goto L17;
        r100.f393026e.put(r101, r103);
    L19:
        if (Intrinsics.areEqual(r109, r100.f393026e.get(r101)) == false) goto L21;
        return;
    L21:
        f(r100, Collections.unmodifiableList(new ArrayList(r100.f393026e.values())), r104);
        return;
    L17:
        r100.f393026e.remove(r101);
        goto L19
    L24:
        return;
    }
}

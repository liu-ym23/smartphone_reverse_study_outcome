package com.ss.android.lark.voiceinput.impl.service;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes38.dex */
public final class VoiceOperationCoordinator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f445084a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<Throwable, Unit> f445085b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StateFlowImpl f445086c;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\rj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/voiceinput/impl/service/VoiceOperationCoordinator$Kind;", "", "<init>", "(Ljava/lang/String;I)V", "Prepare", "Start", "Stop", "Cancel", "MaxDurationReached", "Retry", "SwitchLanguage", "isTerminal", "", "()Z", "voice-input-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Kind extends Enum<Kind> {
        public static final Kind Cancel = null;
        public static final Kind MaxDurationReached = null;
        public static final Kind Prepare = null;
        public static final Kind Retry = null;
        public static final Kind Start = null;
        public static final Kind Stop = null;
        public static final Kind SwitchLanguage = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Kind[] f445087a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f445088b = null;

        public static EnumEntries<Kind> getEntries() {
            return f445088b;
        }

        static {
            Kind r100 = new Kind("Prepare", 0);
            Prepare = r100;
            Kind r101 = new Kind("Start", 1);
            Start = r101;
            Kind r102 = new Kind("Stop", 2);
            Stop = r102;
            Kind r103 = new Kind("Cancel", 3);
            Cancel = r103;
            Kind r104 = new Kind("MaxDurationReached", 4);
            MaxDurationReached = r104;
            Kind r105 = new Kind("Retry", 5);
            Retry = r105;
            Kind r110 = new Kind("SwitchLanguage", 6);
            SwitchLanguage = r110;
            Kind[] r111 = {r100, r101, r102, r103, r104, r105, r110};
            f445087a = r111;
            f445088b = EnumEntriesKt.enumEntries(r111);
        }

        public static Kind[] values() {
            return (Kind[]) f445087a.clone();
        }

        public final boolean isTerminal() {
            if (this != Stop) goto L5;
        L10:
            return true;
        L5:
            if (this == Cancel) goto L10;
            if (this == MaxDurationReached) goto L10;
            return false;
        }

        public static Kind valueOf(String r100) {
            return (Kind) r27.a.a(Kind.class, r100);
        }

        public Kind(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class Operation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Kind f445089a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function1<Continuation<? super Result<Unit>>, Object> f445090b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Function1<Result<Unit>, Unit> f445091c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Function0<Unit> f445092d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final StateFlowImpl f445093e;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/voiceinput/impl/service/VoiceOperationCoordinator$Operation$CallbackState;", "", "<init>", "(Ljava/lang/String;I)V", "Pending", "Delivered", "voice-input-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum CallbackState extends Enum<CallbackState> {
            public static final CallbackState Delivered = null;
            public static final CallbackState Pending = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ CallbackState[] f445094a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ EnumEntries f445095b = null;

            public static EnumEntries<CallbackState> getEntries() {
                return f445095b;
            }

            static {
                CallbackState r100 = new CallbackState("Pending", 0);
                Pending = r100;
                CallbackState r101 = new CallbackState("Delivered", 1);
                Delivered = r101;
                CallbackState[] r102 = {r100, r101};
                f445094a = r102;
                f445095b = EnumEntriesKt.enumEntries(r102);
            }

            public static CallbackState[] values() {
                return (CallbackState[]) f445094a.clone();
            }

            public static CallbackState valueOf(String r100) {
                return (CallbackState) r27.a.a(CallbackState.class, r100);
            }

            public CallbackState(String r100, int r101) {
                super(r100, r101);
            }
        }

        public final void a() {
            StateFlowImpl r100 = this.f445093e;
        L3:
            Object r101 = r100.getValue();
            CallbackState r102 = (CallbackState) r101;
            if (r100.compareAndSet(r101, CallbackState.Delivered) == false) goto L3;
            if (r101 != CallbackState.Pending) goto L8;
            boolean r103 = true;
        L9:
            if (r103 == false) goto L19;
            Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L12
            this.f445092d.invoke();     // Catch: Throwable -> L12
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L12
            return;
        L12:
            th = move-exception;
            Result.Companion r105 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            return;
        L19:
            return;
        L8:
            r103 = false;
            goto L9
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Operation(Kind r100, Function1<? super Continuation<? super Result<Unit>>, ? extends Object> r101, Function1<? super Result<Unit>, Unit> r102, Function0<Unit> r103) {
            Intrinsics.checkNotNullParameter(r100, "kind");
            Intrinsics.checkNotNullParameter(r101, "execute");
            Intrinsics.checkNotNullParameter(r102, "onComplete");
            Intrinsics.checkNotNullParameter(r103, "onCancelled");
            this.f445089a = r100;
            this.f445090b = r101;
            this.f445091c = r102;
            this.f445092d = r103;
            this.f445093e = j1.a(CallbackState.Pending);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/voiceinput/impl/service/VoiceOperationCoordinator$Submission;", "", "<init>", "(Ljava/lang/String;I)V", "Started", "Queued", "Coalesced", "RejectedBusy", "RejectedClosed", "voice-input-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Submission extends Enum<Submission> {
        public static final Submission Coalesced = null;
        public static final Submission Queued = null;
        public static final Submission RejectedBusy = null;
        public static final Submission RejectedClosed = null;
        public static final Submission Started = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Submission[] f445096a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f445097b = null;

        public static EnumEntries<Submission> getEntries() {
            return f445097b;
        }

        static {
            Submission r100 = new Submission("Started", 0);
            Started = r100;
            Submission r101 = new Submission("Queued", 1);
            Queued = r101;
            Submission r102 = new Submission("Coalesced", 2);
            Coalesced = r102;
            Submission r103 = new Submission("RejectedBusy", 3);
            RejectedBusy = r103;
            Submission r104 = new Submission("RejectedClosed", 4);
            RejectedClosed = r104;
            Submission[] r105 = {r100, r101, r102, r103, r104};
            f445096a = r105;
            f445097b = EnumEntriesKt.enumEntries(r105);
        }

        public static Submission[] values() {
            return (Submission[]) f445096a.clone();
        }

        public static Submission valueOf(String r100) {
            return (Submission) r27.a.a(Submission.class, r100);
        }

        public Submission(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface a {

        /* JADX INFO: renamed from: com.ss.android.lark.voiceinput.impl.service.VoiceOperationCoordinator$a$a, reason: collision with other inner class name */
        public static final class C5384a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C5384a f445098a = null;

            static {
                f445098a = new C5384a();
            }

            public C5384a() {
            }

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C5384a) == true) goto L9;
                return false;
            L9:
                C5384a r101 = (C5384a) r100;
                return true;
            }

            public final int hashCode() {
                return 1087030810;
            }

            public final String toString() {
                return "Cancelled";
            }
        }

        public static final class b implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Operation f445099a;

            public b(Operation r100) {
                this.f445099a = r100;
            }
        }
    }

    public interface b {

        public static final class a implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f445100a = null;

            static {
                f445100a = new a();
            }

            public a() {
            }

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof a) == true) goto L9;
                return false;
            L9:
                a r101 = (a) r100;
                return true;
            }

            public final int hashCode() {
                return 135164941;
            }

            public final String toString() {
                return "Closed";
            }
        }

        /* JADX INFO: renamed from: com.ss.android.lark.voiceinput.impl.service.VoiceOperationCoordinator$b$b, reason: collision with other inner class name */
        public static final class C5385b implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C5385b f445101a = null;

            static {
                f445101a = new C5385b();
            }

            public C5385b() {
            }

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C5385b) == true) goto L9;
                return false;
            L9:
                C5385b r101 = (C5385b) r100;
                return true;
            }

            public final int hashCode() {
                return -2118121803;
            }

            public final String toString() {
                return "Idle";
            }
        }

        public static final class c implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Operation f445102a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Operation f445103b;

            public /* synthetic */ c() {
                throw null;
            }

            public c(Operation r100, Operation r101) {
                Intrinsics.checkNotNullParameter(r100, "active");
                this.f445102a = r100;
                this.f445103b = r101;
            }
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f445104a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Submission f445105b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Operation f445106c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f445107d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f445104a, r101.f445104a) == true) goto L12;
            return false;
        L12:
            if (this.f445105b == r101.f445105b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f445106c, r101.f445106c) == true) goto L18;
            return false;
        L18:
            if (this.f445107d == r101.f445107d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f445104a.hashCode() * 31) + this.f445105b.hashCode()) * 31;
            Operation r101 = this.f445106c;
            if (r101 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = (r100 + r102) * 31;
            if (this.f445107d == false) goto L9;
            int r104 = 1231;
        L11:
            return r103 + r104;
        L9:
            r104 = 1237;
            goto L11
        L5:
            r102 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "SubmissionDecision(nextState=" + this.f445104a + ", submission=" + this.f445105b + ", replacedOperation=" + this.f445106c + ", shouldCancelIncoming=" + this.f445107d + ')';
        }

        public c(b r100, Submission r101, Operation r102, boolean r103, int r104) {
            if ((r104 & 4) == 0) goto L6;
            r102 = null;
        L6:
            if ((r104 & 8) == 0) goto L8;
            r103 = false;
        L8:
            Intrinsics.checkNotNullParameter(r100, "nextState");
            Intrinsics.checkNotNullParameter(r101, "submission");
            this.f445104a = r100;
            this.f445105b = r101;
            this.f445106c = r102;
            this.f445107d = r103;
        }
    }

    public final a b(Operation r100) {
        StateFlowImpl r101 = this.f445086c;
    L3:
        Object r102 = r101.getValue();
        b r103 = (b) r102;
        boolean r104 = r103 instanceof b.c;
        if (r104 == false) goto L12;
        b.c r105 = (b.c) r103;
        if (r105.f445102a != r100) goto L12;
        Operation r106 = r105.f445103b;
        if (r106 == null) goto L11;
        b r107 = new b.c(r106, null);
    L14:
        if (r101.compareAndSet(r102, r107) == false) goto L3;
        if (r104 == false) goto L20;
        b.c r108 = (b.c) r103;
        if (r108.f445102a != r100) goto L20;
        return new a.b(r108.f445103b);
    L20:
        return a.C5384a.f445098a;
    L11:
        r107 = b.C5385b.f445101a;
    L12:
        r107 = r103;
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VoiceOperationCoordinator(CoroutineScope r100, Function1<? super Throwable, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, "onOperationFailure");
        this.f445084a = r100;
        this.f445085b = r101;
        this.f445086c = j1.a(b.C5385b.f445101a);
    }

    public static c c(b.c r100, Submission r101) {
        return new c(r100, r101, null, false, 12);
    }

    public static c d(b r100, Operation r101) {
        if (Intrinsics.areEqual(r100, b.C5385b.f445101a) == false) goto L6;
        return new c(new b.c(r101, null), Submission.Started, null, false, 12);
    L6:
        if ((r100 instanceof b.c) == false) goto L46;
        b.c r102 = (b.c) r100;
        Kind r103 = r101.f445089a;
        Kind r104 = Kind.Prepare;
        if (r103 == r104) goto L53;
        Operation r105 = r102.f445103b;
        if (r102.f445102a.f445089a.isTerminal() == true) goto L42;
        if (r105 == null) goto L18;
        Kind r106 = r105.f445089a;
        if (r106 == null) goto L18;
        boolean r107 = true;
        if (r106.isTerminal() != true) goto L18;
    L19:
        if (r107 == true) goto L42;
        if (r101.f445089a.isTerminal() == true) goto L54;
        Operation r108 = r102.f445102a;
        Kind r109 = r108.f445089a;
        if (r109 == r104) goto L55;
        Kind r110 = r101.f445089a;
        if (r109 == r110) goto L30;
    L32:
        if (r105 != null) goto L35;
        return new c(new b.c(r108, r101), Submission.Queued, null, false, 12);
    L35:
        if (r105.f445089a == r110) goto L38;
        return c(r102, Submission.RejectedBusy);
    L38:
        if (r110 == Kind.SwitchLanguage) goto L60;
        return c(r102, Submission.Coalesced);
    L60:
        return new c(new b.c(r108, r101), Submission.Queued, r105, false, 8);
    L30:
        if (r110 == Kind.SwitchLanguage) goto L32;
        return c(r102, Submission.Coalesced);
    L55:
        return c(r102, Submission.RejectedBusy);
    L54:
        return new c(new b.c(r102.f445102a, r101), Submission.Queued, r105, false, 8);
    L18:
        r107 = false;
    L42:
        if (r101.f445089a.isTerminal() == false) goto L44;
        Submission r111 = Submission.Coalesced;
    L61:
        return c(r102, r111);
    L44:
        r111 = Submission.RejectedBusy;
        goto L61
    L53:
        return c(r102, Submission.RejectedBusy);
    L46:
        b.a r112 = b.a.f445100a;
        if (Intrinsics.areEqual(r100, r112) == false) goto L51;
        return new c(r112, Submission.RejectedClosed, null, true, 4);
    L51:
        throw new NoWhenBranchMatchedException();
    }

    public static final Object a(VoiceOperationCoordinator r110, Operation r111, Continuation r112) {
        r110.getClass();
        if ((r112 instanceof VoiceOperationCoordinator$runOperation$1) == false) goto L7;
        VoiceOperationCoordinator$runOperation$1 r100 = (VoiceOperationCoordinator$runOperation$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        boolean r104 = false;
        if (r103 == 0) goto L19;
        if (r103 != 1) goto L18;
        r111 = (Operation) r100.L$0;
        ResultKt.throwOnFailure(r113);     // Catch: Throwable -> L14 CancellationException -> L16
    L30:
        Object r114 = ((Result) r113).m9458unboximpl();     // Catch: Throwable -> L14 CancellationException -> L16
    L33:
        a r105 = r110.b(r111);
        if ((r105 instanceof a.b) == false) goto L59;
        Throwable r106 = Result.m9452exceptionOrNullimpl(r114);
        if (r106 != null) goto L72;
    L42:
        StateFlowImpl r107 = r111.f445093e;
    L43:
        Object r108 = r107.getValue();
        Operation.CallbackState r109 = (Operation.CallbackState) r108;
        if (r107.compareAndSet(r108, Operation.CallbackState.Delivered) == false) goto L43;
        if (r108 != Operation.CallbackState.Pending) goto L48;
        r104 = true;
    L48:
        if (r104 == true) goto L74;
    L53:
        Operation r115 = ((a.b) r105).f445099a;
        if (r115 == null) goto L82;
        if (CoroutineScopeKt.isActive(r110.f445084a) == false) goto L82;
        BuildersKt.launch$default(r110.f445084a, null, null, new VoiceOperationCoordinator$startRunner$1(r110, r115, null), 3, null);
    L82:
        return Unit.INSTANCE;
    L74:
        r111.f445091c.invoke(Result.m9448boximpl(r114));     // Catch: Throwable -> L51
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L53
    L72:
        r110.f445085b.invoke(r106);     // Catch: Throwable -> L39
        Object r117 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L39
    L41:
        Result.m9448boximpl(r117);
    L39:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L41
    L59:
        if (Intrinsics.areEqual(r105, a.C5384a.f445098a) == true) goto L82;
        throw new NoWhenBranchMatchedException();
        goto L63
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        ResultKt.throwOnFailure(r113);
        b r119 = (b) r110.f445086c.getValue();
        if ((r119 instanceof b.c) == true) goto L22;
    L24:
        boolean r120 = false;
    L25:
        if (r120 == true) goto L27;
        r111.a();
        return Unit.INSTANCE;
    L27:
        Function1<Continuation<? super Result<Unit>>, Object> r121 = r111.f445090b;     // Catch: Throwable -> L14 CancellationException -> L16
        r100.L$0 = r111;     // Catch: Throwable -> L14 CancellationException -> L16
        r100.label = 1;     // Catch: Throwable -> L14 CancellationException -> L16
        r113 = r121.invoke(r100);     // Catch: Throwable -> L14 CancellationException -> L16
        if (r113 != r102) goto L30;
        return r102;
    L22:
        if (((b.c) r119).f445102a != r111) goto L24;
        r120 = true;
    L14:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L63:
        a r123 = r110.b(r111);
        if ((r123 instanceof a.b) == false) goto L71;
        r111.a();
        Operation r124 = ((a.b) r123).f445099a;
        if (r124 == null) goto L71;
        if (CoroutineScopeKt.isActive(r110.f445084a) == false) goto L71;
        BuildersKt.launch$default(r110.f445084a, null, null, new VoiceOperationCoordinator$startRunner$1(r110, r124, null), 3, null);
    L71:
        return Unit.INSTANCE;
    L7:
        r100 = new VoiceOperationCoordinator$runOperation$1(r110, r112);
        goto L8
    }
}

package com.bytedance.navigation.kmp.handler.projection;

import com.bytedance.ee.bear.middleground.comment.aibot.model.AiBotPollingAuthResult;
import com.bytedance.navigation.kmp.utils.NaviThreadManager;
import com.mammon.audiosdk.session.type.RequestEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: loaded from: classes21.dex */
public final class ProjectionUploadManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProjectionUploadManager f265836a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Channel<a> f265837b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CoroutineScope f265838c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile boolean f265839d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static g f265840e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f265841f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f265842g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static com.bytedance.navigation.kmp.handler.projection.a f265843h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f265844i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f265845j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static Job f265846k;

    /* JADX INFO: renamed from: com.bytedance.navigation.kmp.handler.projection.ProjectionUploadManager$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.navigation.kmp.handler.projection.ProjectionUploadManager$1", f = "ProjectionUploadManager.kt", i = {}, l = {59, 61, 62, 64, 65, 66}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r100) {
            super(2, r100);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00ad -> B:10:0x002e). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch(this.label) {
                case 0: goto L8;
                case 1: goto L7;
                case 2: goto L6;
                case 3: goto L6;
                case 4: goto L6;
                case 5: goto L6;
                case 6: goto L6;
                default: goto L5;
            };
        L6:
            ChannelIterator<a> r101 = (ChannelIterator) this.L$0;
            ResultKt.throwOnFailure(r110);
            ChannelIterator<a> r111 = r101;
        L9:
            AnonymousClass1 r102 = this;
        L10:
            r102.L$0 = r111;
            r102.label = 1;
            Object r103 = r111.hasNext(r102);
            if (r103 != r100) goto L13;
            return r100;
        L13:
            AnonymousClass1 r104 = r102;
            ChannelIterator<a> r105 = r111;
            r110 = r103;
            AnonymousClass1 r106 = r104;
        L15:
            if (((Boolean) r110).booleanValue() == false) goto L57;
            a r112 = r105.next();
            if (Intrinsics.areEqual(r112, a.d.f265851a) == false) goto L22;
            ProjectionUploadManager r113 = ProjectionUploadManager.f265836a;
            r106.L$0 = r105;
            r106.label = 2;
            if (ProjectionUploadManager.b(r113, r106) != r100) goto L38;
            return r100;
        L38:
            r111 = r105;
            r102 = r106;
            goto L10
        L22:
            if (Intrinsics.areEqual(r112, a.e.f265852a) == false) goto L33;
            ProjectionUploadManager r114 = ProjectionUploadManager.f265836a;
            r106.L$0 = r105;
            r106.label = 3;
            r114.getClass();
            ProjectionUploadManager.f265842g = false;
            ProjectionUploadManager.f265843h = null;
            Job r107 = ProjectionUploadManager.f265846k;
            if (r107 == null) goto L26;
            Job.DefaultImpls.cancel$default(r107, null, 1, null);
        L26:
            ProjectionUploadManager.f265846k = null;
            Object r115 = r114.h(r106);
            if (r115 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L30;
            r115 = Unit.INSTANCE;
        L30:
            if (r115 != r100) goto L38;
            return r100;
        L33:
            if ((r112 instanceof a.b) == false) goto L40;
            a.b r116 = (a.b) r112;
            ProjectionUploadManager.f265836a.getClass();
            if (ProjectionUploadManager.f265842g == false) goto L38;
            ProjectionUploadManager.f265843h = new com.bytedance.navigation.kmp.handler.projection.a(r116.f265848a, r116.f265849b);
            goto L38
        L40:
            if ((r112 instanceof a.C3720a) == false) goto L45;
            ProjectionUploadManager r108 = ProjectionUploadManager.f265836a;
            com.bytedance.navigation.kmp.handler.projection.b r117 = ((a.C3720a) r112).f265847a;
            r106.L$0 = r105;
            r106.label = 4;
            if (ProjectionUploadManager.a(r108, r117, r106) != r100) goto L38;
            return r100;
        L45:
            if (Intrinsics.areEqual(r112, a.c.f265850a) == false) goto L50;
            ProjectionUploadManager r118 = ProjectionUploadManager.f265836a;
            r106.L$0 = r105;
            r106.label = 5;
            if (r118.h(r106) != r100) goto L38;
            return r100;
        L50:
            if (Intrinsics.areEqual(r112, a.f.f265853a) == false) goto L55;
            ProjectionUploadManager r119 = ProjectionUploadManager.f265836a;
            r106.L$0 = r105;
            r106.label = 6;
            if (ProjectionUploadManager.c(r119, r106) != r100) goto L38;
            return r100;
        L55:
            throw new NoWhenBranchMatchedException();
        L57:
            return Unit.INSTANCE;
        L7:
            r105 = (ChannelIterator) this.L$0;
            ResultKt.throwOnFailure(r110);
            r106 = this;
            goto L15
        L8:
            ResultKt.throwOnFailure(r110);
            r111 = ProjectionUploadManager.f265837b.iterator();
            goto L9
        L5:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static abstract class a {

        /* JADX INFO: renamed from: com.bytedance.navigation.kmp.handler.projection.ProjectionUploadManager$a$a, reason: collision with other inner class name */
        public static final class C3720a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final com.bytedance.navigation.kmp.handler.projection.b f265847a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C3720a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f265847a, ((C3720a) r100).f265847a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f265847a.hashCode();
            }

            public final String toString() {
                return "Append(frame=" + this.f265847a + ")";
            }

            public C3720a(com.bytedance.navigation.kmp.handler.projection.b r100) {
                Intrinsics.checkNotNullParameter(r100, "frame");
                this.f265847a = r100;
            }
        }

        public static final class b extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final double f265848a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final long f265849b;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof b) == true) goto L8;
                return false;
            L8:
                b r101 = (b) r100;
                if (Double.compare(this.f265848a, r101.f265848a) == 0) goto L12;
                return false;
            L12:
                if (this.f265849b == r101.f265849b) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                long r100 = Double.doubleToLongBits(this.f265848a);
                int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
                long r102 = this.f265849b;
                return r101 + ((int) (r102 ^ (r102 >>> 32)));
            }

            public final String toString() {
                return "Direction(direction=" + this.f265848a + ", timestamp=" + this.f265849b + ")";
            }

            public b(double r100, long r101) {
                this.f265848a = r100;
                this.f265849b = r101;
            }
        }

        public static final class c extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f265850a = null;

            static {
                f265850a = new c();
            }

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof c) == true) goto L9;
                return false;
            L9:
                c r101 = (c) r100;
                return true;
            }

            public final int hashCode() {
                return -168849333;
            }

            public final String toString() {
                return "Flush";
            }

            public c() {
            }
        }

        public static final class d extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f265851a = null;

            static {
                f265851a = new d();
            }

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof d) == true) goto L9;
                return false;
            L9:
                d r101 = (d) r100;
                return true;
            }

            public final int hashCode() {
                return -2136506195;
            }

            public final String toString() {
                return RequestEvent.StartSession;
            }

            public d() {
            }
        }

        public static final class e extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final e f265852a = null;

            static {
                f265852a = new e();
            }

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof e) == true) goto L9;
                return false;
            L9:
                e r101 = (e) r100;
                return true;
            }

            public final int hashCode() {
                return 1679978555;
            }

            public final String toString() {
                return "StopSession";
            }

            public e() {
            }
        }

        public static final class f extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final f f265853a = null;

            static {
                f265853a = new f();
            }

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof f) == true) goto L9;
                return false;
            L9:
                f r101 = (f) r100;
                return true;
            }

            public final int hashCode() {
                return -1648604116;
            }

            public final String toString() {
                return "UploadFinished";
            }

            public f() {
            }
        }

        public a() {
        }
    }

    public static final class b extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public b(CoroutineExceptionHandler.Key r100) {
            super(r100);
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public final void handleException(CoroutineContext r100, Throwable r101) {
            d37.i r102 = d37.i.f466749a;
            d37.i.e("ProjectionUploadManager coroutine failed", r101);
        }
    }

    public ProjectionUploadManager() {
    }

    public static void i() {
        Object r100 = null;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        int r102 = w27.e.f558039a;     // Catch: Throwable -> L9
        e37.f r103 = w27.f.f558040a;     // Catch: Throwable -> L9
        if (r103 == null) goto L6;
        Boolean r104 = r103.h();     // Catch: Throwable -> L9
    L7:
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L9
    L11:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L15;
        d37.i r107 = d37.i.f466749a;
        d37.i.e("Projection upload settings read failed", r106);
    L15:
        if (Result.m9455isFailureimpl(r105) == true) goto L18;
        r100 = r105;
    L18:
        f265839d = Intrinsics.areEqual((Boolean) r100, Boolean.TRUE);
        if (f265839d == true) goto L21;
        return;
    L21:
        e(a.d.f265851a, "start session");
        return;
    L6:
        r104 = null;
    L9:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    static {
        f265836a = new ProjectionUploadManager();
        f265837b = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        CoroutineScope r100 = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault().plus(SupervisorKt.SupervisorJob$default(null, 1, null)).plus(new b(CoroutineExceptionHandler.Key)));
        f265838c = r100;
        f265840e = new g(0);
        BuildersKt.launch$default(r100, null, null, new AnonymousClass1(null), 3, null);
    }

    public static void j() {
        if (f265839d == true) goto L5;
        return;
    L5:
        e(a.e.f265852a, "stop session");
        f265839d = false;
    }

    public static Object g(ContinuationImpl r100) {
        ProjectionUploadManager$persistState$2 r101 = new ProjectionUploadManager$persistState$2(f265840e, null);
        NaviThreadManager.f265968a.getValue().getClass();
        Object r102 = NaviThreadManager.b(r101, r100);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    public final Object f(Continuation<? super Unit> r100) {
        if ((r100 instanceof ProjectionUploadManager$ensureStateLoaded$1) == false) goto L7;
        ProjectionUploadManager$ensureStateLoaded$1 r101 = (ProjectionUploadManager$ensureStateLoaded$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ProjectionUploadManager r106 = (ProjectionUploadManager) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L21:
        f265840e = (g) r103;
        f265841f = true;
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        if (f265841f == true) goto L17;
        ProjectionUploadManager$ensureStateLoaded$2 r107 = new ProjectionUploadManager$ensureStateLoaded$2(null);
        r101.L$0 = this;
        r101.label = 1;
        NaviThreadManager.f265968a.getValue().getClass();
        r103 = NaviThreadManager.b(r107, r101);
        if (r103 != r104) goto L21;
        return r104;
    L17:
        return Unit.INSTANCE;
    L7:
        r101 = new ProjectionUploadManager$ensureStateLoaded$1(this, r100);
        goto L8
    }

    public final Object h(Continuation<? super Unit> r110) {
        if ((r110 instanceof ProjectionUploadManager$requestFlush$1) == false) goto L7;
        ProjectionUploadManager$requestFlush$1 r100 = (ProjectionUploadManager$requestFlush$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        ProjectionUploadManager r104 = (ProjectionUploadManager) r100.L$0;
        ResultKt.throwOnFailure(r111);
    L37:
        List<c> r112 = f265840e.f265887b;
    L38:
        f265844i = true;
        BuildersKt.launch$default(f265838c, null, null, new ProjectionUploadManager$requestFlush$2(r112, null), 3, null);
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ProjectionUploadManager r105 = (ProjectionUploadManager) r100.L$0;
        ResultKt.throwOnFailure(r111);
    L21:
        if (f265844i == false) goto L25;
        f265845j = true;
        return Unit.INSTANCE;
    L25:
        if ((!f265840e.f265887b.isEmpty()) == false) goto L31;
        if ((!f265840e.f265886a.isEmpty()) == false) goto L29;
        f265845j = true;
    L29:
        r112 = f265840e.f265887b;
        goto L38
    L31:
        if ((!f265840e.f265886a.isEmpty()) == false) goto L43;
        g r113 = f265840e;
        if (r113.f265887b.isEmpty() == false) goto L41;
        List r106 = CollectionsKt.emptyList();
        List<c> r114 = r113.f265886a;
        Intrinsics.checkNotNullParameter(r106, AiBotPollingAuthResult.STATUS_PENDING);
        Intrinsics.checkNotNullParameter(r114, "inflight");
        f265840e = new g(r106, r114);
        r100.L$0 = r105;
        r100.label = 2;
        r105.getClass();
        if (g(r100) != r102) goto L37;
        return r102;
    L41:
        throw new IllegalArgumentException("inflight must be empty before freezing pending records".toString());
    L43:
        return Unit.INSTANCE;
    L16:
        ResultKt.throwOnFailure(r111);
        r100.L$0 = this;
        r100.label = 1;
        if (f(r100) != r102) goto L19;
        return r102;
    L19:
        r105 = this;
    L7:
        r100 = new ProjectionUploadManager$requestFlush$1(this, r110);
        goto L8
    }

    public static final Object b(ProjectionUploadManager r110, Continuation r111) {
        r110.getClass();
        if ((r111 instanceof ProjectionUploadManager$handleStartSession$1) == false) goto L7;
        ProjectionUploadManager$handleStartSession$1 r100 = (ProjectionUploadManager$handleStartSession$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        ProjectionUploadManager r113 = (ProjectionUploadManager) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L25:
        f265846k = BuildersKt.launch$default(f265838c, null, null, new ProjectionUploadManager$handleStartSession$2(null), 3, null);
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r110 = (ProjectionUploadManager) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L22:
        r100.L$0 = r110;
        r100.label = 2;
        if (r110.h(r100) != r102) goto L25;
        return r102;
    L16:
        ResultKt.throwOnFailure(r112);
        f265842g = true;
        f265843h = null;
        Job r114 = f265846k;
        if (r114 == null) goto L19;
        Job.DefaultImpls.cancel$default(r114, null, 1, null);
    L19:
        r100.L$0 = r110;
        r100.label = 1;
        if (r110.f(r100) != r102) goto L22;
        return r102;
    L7:
        r100 = new ProjectionUploadManager$handleStartSession$1(r110, r111);
        goto L8
    }

    public static final Object c(ProjectionUploadManager r100, Continuation r101) {
        r100.getClass();
        if ((r101 instanceof ProjectionUploadManager$handleUploadFinished$1) == false) goto L7;
        ProjectionUploadManager$handleUploadFinished$1 r102 = (ProjectionUploadManager$handleUploadFinished$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L16;
        if (r106 == 1) goto L15;
        if (r106 != 2) goto L14;
        ResultKt.throwOnFailure(r104);
    L25:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r100 = (ProjectionUploadManager) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L19:
        f265844i = false;
        if (f265845j == false) goto L25;
        f265845j = false;
        r102.L$0 = null;
        r102.label = 2;
        if (r100.h(r102) != r105) goto L25;
        return r105;
    L16:
        ResultKt.throwOnFailure(r104);
        g r107 = f265840e;
        r107.getClass();
        List r108 = CollectionsKt.emptyList();
        List<c> r109 = r107.f265886a;
        Intrinsics.checkNotNullParameter(r109, AiBotPollingAuthResult.STATUS_PENDING);
        Intrinsics.checkNotNullParameter(r108, "inflight");
        f265840e = new g(r109, r108);
        r102.L$0 = r100;
        r102.label = 1;
        if (g(r102) != r105) goto L19;
        return r105;
    L7:
        r102 = new ProjectionUploadManager$handleUploadFinished$1(r100, r101);
        goto L8
    }

    public static void e(a r100, String r101) {
        Object r102 = f265837b.mo10962trySendJP2dKIU(r100);
        kotlinx.coroutines.channels.g.c r103 = kotlinx.coroutines.channels.g.f504696b;
        if ((r102 instanceof kotlinx.coroutines.channels.g.c) == false) goto L6;
        d37.i r104 = d37.i.f466749a;
        e37.c.a.a("Projection upload " + r101 + " enqueue failed");
        return;
    }

    public static final Object a(ProjectionUploadManager r210, com.bytedance.navigation.kmp.handler.projection.b r211, Continuation r212) {
        ProjectionUploadManager r100 = r210;
        r210.getClass();
        if ((r212 instanceof ProjectionUploadManager$handleAppend$1) == false) goto L7;
        ProjectionUploadManager$handleAppend$1 r101 = (ProjectionUploadManager$handleAppend$1) r212;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L16;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        ResultKt.throwOnFailure(r103);
    L29:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        com.bytedance.navigation.kmp.handler.projection.a r106 = (com.bytedance.navigation.kmp.handler.projection.a) r101.L$2;
        com.bytedance.navigation.kmp.handler.projection.b r107 = (com.bytedance.navigation.kmp.handler.projection.b) r101.L$1;
        ProjectionUploadManager r108 = (ProjectionUploadManager) r101.L$0;
        ResultKt.throwOnFailure(r103);
        com.bytedance.navigation.kmp.handler.projection.a r109 = r106;
        r100 = r108;
    L25:
        g r110 = f265840e;
        r107.getClass();
        Intrinsics.checkNotNullParameter(r109, "direction");
        ProjectionUploadManager r213 = r100;
        c r111 = new c(r107.f265857a, r107.f265858b, r107.f265859c, r107.f265860d, r107.f265861e, r109.f265854a, r109.f265855b);
        r110.getClass();
        Intrinsics.checkNotNullParameter(r111, "record");
        List r112 = CollectionsKt.plus(r110.f265886a, r111);
        List<c> r113 = r110.f265887b;
        Intrinsics.checkNotNullParameter(r112, AiBotPollingAuthResult.STATUS_PENDING);
        Intrinsics.checkNotNullParameter(r113, "inflight");
        f265840e = new g(r112, r113);
        r101.L$0 = null;
        r101.L$1 = null;
        r101.L$2 = null;
        r101.label = 2;
        r213.getClass();
        if (g(r101) != r104) goto L29;
        return r104;
    L16:
        ResultKt.throwOnFailure(r103);
        if (f265842g == false) goto L30;
        r109 = f265843h;
        if (r109 == null) goto L31;
        r101.L$0 = r100;
        r107 = r211;
        r101.L$1 = r107;
        r101.L$2 = r109;
        r101.label = 1;
        if (r100.f(r101) != r104) goto L25;
        return r104;
    L31:
        return Unit.INSTANCE;
    L30:
        return Unit.INSTANCE;
    L7:
        r101 = new ProjectionUploadManager$handleAppend$1(r100, r212);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00ac -> B:27:0x00af). Please report as a decompilation issue!!! */
    public static final Object d(ProjectionUploadManager r100, List r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof ProjectionUploadManager$uploadSnapshot$1) == false) goto L7;
        ProjectionUploadManager$uploadSnapshot$1 r103 = (ProjectionUploadManager$uploadSnapshot$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        List r108 = (List) r103.L$2;
        String r109 = (String) r103.L$1;
        Iterator r110 = (Iterator) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L28:
        if (((Boolean) r105).booleanValue() == true) goto L23;
        d37.i r111 = d37.i.f466749a;
        e37.c.a.a("Projection upload failed after retry, drop records: navId=" + r109 + ", count=" + r108.size());
    L23:
        if (r110.hasNext() == false) goto L31;
        Map.Entry r112 = (Map.Entry) r110.next();
        r109 = (String) r112.getKey();
        r108 = (List) r112.getValue();
        ProjectionUploadManager$uploadSnapshot$3$success$1 r113 = new ProjectionUploadManager$uploadSnapshot$3$success$1(new Ref.IntRef(), r109, r108, null);
        r103.L$0 = r110;
        r103.L$1 = r109;
        r103.L$2 = r108;
        r103.label = 1;
        r105 = ProjectionUploadManagerKt.a(r113, r103);
        if (r105 != r106) goto L28;
        return r106;
    L31:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        LinkedHashMap r114 = new LinkedHashMap();
        Iterator r115 = r101.iterator();
    L16:
        if (r115.hasNext() == false) goto L21;
        Object r116 = r115.next();
        String r117 = ((c) r116).f265862a;
        Object r118 = r114.get(r117);
        if (r118 != null) goto L20;
        r118 = new ArrayList();
        r114.put(r117, r118);
    L20:
        ((List) r118).add(r116);
        goto L16
    L21:
        r110 = r114.entrySet().iterator();
    L7:
        r103 = new ProjectionUploadManager$uploadSnapshot$1(r100, r102);
        goto L8
    }
}

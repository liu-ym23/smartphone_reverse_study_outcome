package com.larus.agents.impl.network;

import com.larus.agents.impl.experience.KevaWorkExperienceCache;
import com.larus.agents.impl.experience.WorkExperienceMutationResult;
import com.larus.agents.impl.experience.p;
import com.larus.agents.impl.experience.s;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes24.dex */
public final class CachedWorkExperienceRepository implements m {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f286699d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f286700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.larus.agents.impl.experience.m f286701b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<String> f286702c;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.agents.impl.network.CachedWorkExperienceRepository$delete$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.agents.impl.network.CachedWorkExperienceRepository", f = "WorkExperienceApi.kt", i = {0, 0, 1, 1, 1, 2}, l = {419, 422, 423}, m = "delete", n = {"experienceId", "accountId", "experienceId", "accountId", "result", "result"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ CachedWorkExperienceRepository this$0;

        public AnonymousClass1(CachedWorkExperienceRepository r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.delete(null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.agents.impl.network.CachedWorkExperienceRepository$delete$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.agents.impl.network.CachedWorkExperienceRepository$delete$2", f = "WorkExperienceApi.kt", i = {}, l = {422}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ String $accountId;
        int label;
        final /* synthetic */ CachedWorkExperienceRepository this$0;

        public AnonymousClass2(CachedWorkExperienceRepository r100, String r101, Continuation<? super AnonymousClass2> r102) {
            this.this$0 = r100;
            this.$accountId = r101;
            super(1, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r100) {
            return new AnonymousClass2(this.this$0, this.$accountId, r100);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r100) {
            return invoke2(r100);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super Unit> r100) {
            return ((AnonymousClass2) create(r100)).invokeSuspend(Unit.INSTANCE);
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
            com.larus.agents.impl.experience.m r103 = this.this$0.f286701b;
            String r104 = this.$accountId;
            this.label = 1;
            if (r103.j(r104, this) != r101) goto L12;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.larus.agents.impl.network.CachedWorkExperienceRepository$delete$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.agents.impl.network.CachedWorkExperienceRepository$delete$3", f = "WorkExperienceApi.kt", i = {}, l = {424}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ String $accountId;
        final /* synthetic */ String $experienceId;
        int label;
        final /* synthetic */ CachedWorkExperienceRepository this$0;

        public AnonymousClass3(CachedWorkExperienceRepository r100, String r101, String r102, Continuation<? super AnonymousClass3> r103) {
            this.this$0 = r100;
            this.$accountId = r101;
            this.$experienceId = r102;
            super(1, r103);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r100) {
            return new AnonymousClass3(this.this$0, this.$accountId, this.$experienceId, r100);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r100) {
            return invoke2(r100);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super Unit> r100) {
            return ((AnonymousClass3) create(r100)).invokeSuspend(Unit.INSTANCE);
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
            com.larus.agents.impl.experience.m r103 = this.this$0.f286701b;
            String r104 = this.$accountId;
            String r105 = this.$experienceId;
            this.label = 1;
            if (r103.a(r104, r105, this) != r101) goto L12;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.larus.agents.impl.network.CachedWorkExperienceRepository$update$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.agents.impl.network.CachedWorkExperienceRepository", f = "WorkExperienceApi.kt", i = {0, 0, 1, 1, 1, 2}, l = {405, 408, 410}, m = "update", n = {"experienceId", "accountId", "experienceId", "accountId", "result", "result"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0"})
    public static final class C107791 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ CachedWorkExperienceRepository this$0;

        public C107791(CachedWorkExperienceRepository r100, Continuation<? super C107791> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.update(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.agents.impl.network.CachedWorkExperienceRepository$update$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.agents.impl.network.CachedWorkExperienceRepository$update$2", f = "WorkExperienceApi.kt", i = {}, l = {408}, m = "invokeSuspend", n = {}, s = {})
    public static final class C107802 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ String $accountId;
        int label;
        final /* synthetic */ CachedWorkExperienceRepository this$0;

        public C107802(CachedWorkExperienceRepository r100, String r101, Continuation<? super C107802> r102) {
            this.this$0 = r100;
            this.$accountId = r101;
            super(1, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r100) {
            return new C107802(this.this$0, this.$accountId, r100);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r100) {
            return invoke2(r100);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super Unit> r100) {
            return ((C107802) create(r100)).invokeSuspend(Unit.INSTANCE);
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
            com.larus.agents.impl.experience.m r103 = this.this$0.f286701b;
            String r104 = this.$accountId;
            this.label = 1;
            if (r103.j(r104, this) != r101) goto L12;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.larus.agents.impl.network.CachedWorkExperienceRepository$update$3, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.agents.impl.network.CachedWorkExperienceRepository$update$3", f = "WorkExperienceApi.kt", i = {}, l = {411}, m = "invokeSuspend", n = {}, s = {})
    public static final class C107813 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ String $accountId;
        final /* synthetic */ String $experienceId;
        int label;
        final /* synthetic */ CachedWorkExperienceRepository this$0;

        public C107813(CachedWorkExperienceRepository r100, String r101, String r102, Continuation<? super C107813> r103) {
            this.this$0 = r100;
            this.$accountId = r101;
            this.$experienceId = r102;
            super(1, r103);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r100) {
            return new C107813(this.this$0, this.$accountId, this.$experienceId, r100);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r100) {
            return invoke2(r100);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super Unit> r100) {
            return ((C107813) create(r100)).invokeSuspend(Unit.INSTANCE);
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
            com.larus.agents.impl.experience.m r103 = this.this$0.f286701b;
            String r104 = this.$accountId;
            String r105 = this.$experienceId;
            this.label = 1;
            if (r103.a(r104, r105, this) != r101) goto L12;
            return r101;
        }
    }

    static {
    }

    public static Object f() {
        Result.Companion r100 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(new IllegalStateException("account changed during work experience request")));
    }

    public static Object g() {
        Result.Companion r100 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(new IllegalStateException("work experience cache changed during refresh")));
    }

    public final String j() {
        String r100 = this.f286702c.invoke();
        if (r100 == null) goto L8;
        if ((!StringsKt.isBlank(r100)) == false) goto L8;
        return r100;
    L8:
        return null;
    }

    public CachedWorkExperienceRepository(Object r100) {
        NetworkWorkExperienceRepository r101 = new NetworkWorkExperienceRepository();
        KevaWorkExperienceCache r102 = new KevaWorkExperienceCache();
        Function0<String> r103 = new com.larus.agents.impl.network.a();
        Intrinsics.checkNotNullParameter(r101, "remote");
        Intrinsics.checkNotNullParameter(r102, "local");
        Intrinsics.checkNotNullParameter(r103, "accountIdProvider");
        this.f286700a = r101;
        this.f286701b = r102;
        this.f286702c = r103;
    }

    @Override // com.larus.agents.impl.network.m
    public final Object e(Continuation<? super Result<Boolean>> r110) {
        if ((r110 instanceof CachedWorkExperienceRepository$getEnabled$1) == false) goto L7;
        CachedWorkExperienceRepository$getEnabled$1 r100 = (CachedWorkExperienceRepository$getEnabled$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L18;
        if (r103 == 1) goto L17;
        if (r103 == 2) goto L16;
        if (r103 != 3) goto L15;
        Object r104 = r100.L$0;
        ResultKt.throwOnFailure(r111);
    L47:
        if (Intrinsics.areEqual((Boolean) r111, Boxing.boxBoolean(false)) == false) goto L51;
        return g();
    L51:
        return r104;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        Long r105 = (Long) r100.L$1;
        String r106 = (String) r100.L$0;
        ResultKt.throwOnFailure(r111);
        Object r112 = ((Result) r111).m9458unboximpl();
        Long r113 = r105;
        String r107 = r106;
    L30:
        if (n(r107) == true) goto L34;
        return f();
    L34:
        if (Result.m9455isFailureimpl(r112) == false) goto L36;
        Object r108 = null;
    L37:
        Boolean r114 = (Boolean) r108;
        if (r114 != null) goto L40;
        return r112;
    L40:
        if (r107 == null) goto L52;
        if (r113 == null) goto L53;
        CachedWorkExperienceRepository$getEnabled$stored$1 r109 = new CachedWorkExperienceRepository$getEnabled$stored$1(this, r107, r114, r113, null);
        r100.L$0 = r112;
        r100.L$1 = null;
        r100.label = 3;
        Object r115 = h("settings refresh", r109, r100);
        if (r115 != r102) goto L45;
        return r102;
    L45:
        r104 = r112;
        r111 = r115;
        goto L47
    L53:
        return r112;
    L52:
        return r112;
    L36:
        r108 = r112;
        goto L37
    L17:
        String r116 = (String) r100.L$0;
        ResultKt.throwOnFailure(r111);
    L23:
        String r117 = r116;
        Long r118 = (Long) r111;
        String r119 = r117;
    L25:
        m r120 = this.f286700a;
        r100.L$0 = r119;
        r100.L$1 = r118;
        r100.label = 2;
        Object r121 = r120.e(r100);
        if (r121 != r102) goto L28;
        return r102;
    L28:
        r107 = r119;
        r113 = r118;
        r112 = r121;
        goto L30
    L18:
        ResultKt.throwOnFailure(r111);
        r116 = j();
        if (r116 == null) goto L24;
        CachedWorkExperienceRepository$getEnabled$revision$1$1 r122 = new CachedWorkExperienceRepository$getEnabled$revision$1$1(this, r116, null);
        r100.L$0 = r116;
        r100.label = 1;
        r111 = h("settings revision", r122, r100);
        if (r111 != r102) goto L23;
        return r102;
    L24:
        r119 = r116;
        r118 = null;
    L7:
        r100 = new CachedWorkExperienceRepository$getEnabled$1(this, r110);
        goto L8
    }

    public final Object l(Continuation<? super Boolean> r100) {
        if ((r100 instanceof CachedWorkExperienceRepository$getCachedEnabled$1) == false) goto L7;
        CachedWorkExperienceRepository$getCachedEnabled$1 r101 = (CachedWorkExperienceRepository$getCachedEnabled$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        String r106 = (String) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L21:
        Boolean r107 = (Boolean) r103;
        if (n(r106) == true) goto L24;
        return null;
    L24:
        return r107;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        String r108 = j();
        if (r108 != null) goto L17;
        return null;
    L17:
        r101.L$0 = r108;
        r101.label = 1;
        Object r109 = h("settings read", new CachedWorkExperienceRepository$cachedEnabled$2(this, r108, null), r101);
        if (r109 != r104) goto L20;
        return r104;
    L20:
        r106 = r108;
        r103 = r109;
    L7:
        r101 = new CachedWorkExperienceRepository$getCachedEnabled$1(this, r100);
        goto L8
    }

    public final Object m(Continuation<? super s> r100) {
        if ((r100 instanceof CachedWorkExperienceRepository$getCachedFirstPage$1) == false) goto L7;
        CachedWorkExperienceRepository$getCachedFirstPage$1 r101 = (CachedWorkExperienceRepository$getCachedFirstPage$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        String r106 = (String) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L21:
        s r107 = (s) r103;
        if (n(r106) == true) goto L24;
        return null;
    L24:
        return r107;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        String r108 = j();
        if (r108 != null) goto L17;
        return null;
    L17:
        r101.L$0 = r108;
        r101.label = 1;
        Object r109 = h("list read", new CachedWorkExperienceRepository$cachedFirstPage$2(this, r108, null), r101);
        if (r109 != r104) goto L20;
        return r104;
    L20:
        r106 = r108;
        r103 = r109;
    L7:
        r101 = new CachedWorkExperienceRepository$getCachedFirstPage$1(this, r100);
        goto L8
    }

    public final boolean n(String r100) {
        return Intrinsics.areEqual(j(), r100);
    }

    @Override // com.larus.agents.impl.network.m
    public final Object a(p r100, Continuation<? super WorkExperienceMutationResult> r101) {
        if ((r101 instanceof CachedWorkExperienceRepository$create$1) == false) goto L7;
        CachedWorkExperienceRepository$create$1 r102 = (CachedWorkExperienceRepository$create$1) r101;
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
        WorkExperienceMutationResult r107 = (WorkExperienceMutationResult) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L32:
        return r107;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r108 = (String) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L20:
        WorkExperienceMutationResult r109 = (WorkExperienceMutationResult) r104;
        if (n(r108) == true) goto L25;
        return WorkExperienceMutationResult.FAILURE;
    L25:
        if (r109 != WorkExperienceMutationResult.SUCCESS) goto L33;
        if (r108 == null) goto L34;
        Function1<? super Continuation<? super Unit>, ? extends Object> r110 = new CachedWorkExperienceRepository$create$2(this, r108, null);
        r102.L$0 = r109;
        r102.label = 2;
        if (i("create mutation", r110, r102) != r105) goto L30;
        return r105;
    L30:
        r107 = r109;
        goto L32
    L34:
        return r109;
    L33:
        return r109;
    L16:
        ResultKt.throwOnFailure(r104);
        String r111 = j();
        m r112 = this.f286700a;
        r102.L$0 = r111;
        r102.label = 1;
        Object r113 = r112.a(r100, r102);
        if (r113 != r105) goto L19;
        return r105;
    L19:
        r104 = r113;
        r108 = r111;
    L7:
        r102 = new CachedWorkExperienceRepository$create$1(this, r101);
        goto L8
    }

    @Override // com.larus.agents.impl.network.m
    public final Object b(boolean r100, Continuation<? super WorkExperienceMutationResult> r101) {
        if ((r101 instanceof CachedWorkExperienceRepository$updateEnabled$1) == false) goto L7;
        CachedWorkExperienceRepository$updateEnabled$1 r102 = (CachedWorkExperienceRepository$updateEnabled$1) r101;
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
        WorkExperienceMutationResult r107 = (WorkExperienceMutationResult) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L31:
        return r107;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r100 = r102.Z$0;
        String r108 = (String) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L19:
        WorkExperienceMutationResult r109 = (WorkExperienceMutationResult) r104;
        if (n(r108) == true) goto L24;
        return WorkExperienceMutationResult.FAILURE;
    L24:
        if (r109 != WorkExperienceMutationResult.SUCCESS) goto L32;
        if (r108 == null) goto L33;
        Function1<? super Continuation<? super Unit>, ? extends Object> r110 = new CachedWorkExperienceRepository$updateEnabled$2(this, r108, r100, null);
        r102.L$0 = r109;
        r102.label = 2;
        if (i("settings mutation", r110, r102) != r105) goto L29;
        return r105;
    L29:
        r107 = r109;
        goto L31
    L33:
        return r109;
    L32:
        return r109;
    L16:
        ResultKt.throwOnFailure(r104);
        r108 = j();
        m r111 = this.f286700a;
        r102.L$0 = r108;
        r102.Z$0 = r100;
        r102.label = 1;
        r104 = r111.b(r100, r102);
        if (r104 != r105) goto L19;
        return r105;
    L7:
        r102 = new CachedWorkExperienceRepository$updateEnabled$1(this, r101);
        goto L8
    }

    @Override // com.larus.agents.impl.network.m
    public final Object c(String r110, Continuation<? super Result<com.larus.agents.impl.experience.n>> r111) {
        String r100 = r110;
        if ((r111 instanceof CachedWorkExperienceRepository$getDetail$1) == false) goto L7;
        CachedWorkExperienceRepository$getDetail$1 r101 = (CachedWorkExperienceRepository$getDetail$1) r111;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        CachedWorkExperienceRepository$getDetail$1 r103 = r101;
        Object r104 = r103.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r103.label;
        if (r106 == 0) goto L18;
        if (r106 == 1) goto L17;
        if (r106 == 2) goto L16;
        if (r106 != 3) goto L15;
        Object r107 = r103.L$0;
        ResultKt.throwOnFailure(r104);
    L47:
        if (Intrinsics.areEqual((Boolean) r104, Boxing.boxBoolean(false)) == false) goto L51;
        return g();
    L51:
        return r107;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        Long r108 = (Long) r103.L$1;
        String r109 = (String) r103.L$0;
        ResultKt.throwOnFailure(r104);
        Long r112 = r108;
        Object r113 = ((Result) r104).m9458unboximpl();
    L30:
        if (n(r109) == true) goto L34;
        return f();
    L34:
        if (Result.m9455isFailureimpl(r113) == false) goto L36;
        Object r114 = null;
    L37:
        com.larus.agents.impl.experience.n r115 = (com.larus.agents.impl.experience.n) r114;
        if (r115 != null) goto L40;
        return r113;
    L40:
        if (r109 == null) goto L52;
        if (r112 == null) goto L53;
        CachedWorkExperienceRepository$getDetail$stored$1 r116 = new CachedWorkExperienceRepository$getDetail$stored$1(this, r109, r115, r112, null);
        r103.L$0 = r113;
        r103.L$1 = null;
        r103.label = 3;
        r104 = h("detail refresh", r116, r103);
        if (r104 != r105) goto L45;
        return r105;
    L45:
        r107 = r113;
        goto L47
    L53:
        return r113;
    L52:
        return r113;
    L36:
        r114 = r113;
        goto L37
    L17:
        String r117 = (String) r103.L$1;
        String r118 = (String) r103.L$0;
        ResultKt.throwOnFailure(r104);
        String r119 = r117;
        r100 = r118;
        Object r120 = r104;
    L23:
        Long r121 = (Long) r120;
    L25:
        m r122 = this.f286700a;
        r103.L$0 = r119;
        r103.L$1 = r121;
        r103.label = 2;
        Object r123 = r122.c(r100, r103);
        if (r123 != r105) goto L28;
        return r105;
    L28:
        r113 = r123;
        r112 = r121;
        r109 = r119;
        goto L30
    L18:
        ResultKt.throwOnFailure(r104);
        r119 = j();
        if (r119 == null) goto L24;
        CachedWorkExperienceRepository$getDetail$revision$1$1 r124 = new CachedWorkExperienceRepository$getDetail$revision$1$1(this, r119, r110, null);
        r103.L$0 = r100;
        r103.L$1 = r119;
        r103.label = 1;
        r120 = h("detail revision", r124, r103);
        if (r120 != r105) goto L23;
        return r105;
    L24:
        r121 = null;
    L7:
        r101 = new CachedWorkExperienceRepository$getDetail$1(this, r111);
        goto L8
    }

    @Override // com.larus.agents.impl.network.m
    public Object delete(String r100, Continuation<? super WorkExperienceMutationResult> r110) {
        if ((r110 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r101 = (AnonymousClass1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r111 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L18;
        if (r104 == 1) goto L17;
        if (r104 == 2) goto L16;
        if (r104 != 3) goto L15;
        WorkExperienceMutationResult r105 = (WorkExperienceMutationResult) r101.L$0;
        ResultKt.throwOnFailure(r111);
    L37:
        return r105;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r105 = (WorkExperienceMutationResult) r101.L$2;
        String r106 = (String) r101.L$1;
        String r107 = (String) r101.L$0;
        ResultKt.throwOnFailure(r111);
    L33:
        Function1<? super Continuation<? super Unit>, ? extends Object> r112 = new AnonymousClass3(this, r106, r107, null);
        r101.L$0 = r105;
        r101.L$1 = null;
        r101.L$2 = null;
        r101.label = 3;
        if (i("delete detail mutation", r112, r101) != r103) goto L37;
        return r103;
    L17:
        String r108 = (String) r101.L$1;
        String r109 = (String) r101.L$0;
        ResultKt.throwOnFailure(r111);
        r106 = r108;
        r100 = r109;
    L22:
        WorkExperienceMutationResult r113 = (WorkExperienceMutationResult) r111;
        if (n(r106) == true) goto L27;
        return WorkExperienceMutationResult.FAILURE;
    L27:
        if (r113 != WorkExperienceMutationResult.SUCCESS) goto L38;
        if (r106 == null) goto L39;
        Function1<? super Continuation<? super Unit>, ? extends Object> r114 = new AnonymousClass2(this, r106, null);
        r101.L$0 = r100;
        r101.L$1 = r106;
        r101.L$2 = r113;
        r101.label = 2;
        if (i("delete list mutation", r114, r101) != r103) goto L32;
        return r103;
    L32:
        r107 = r100;
        r105 = r113;
        goto L33
    L39:
        return r113;
    L38:
        return r113;
    L18:
        ResultKt.throwOnFailure(r111);
        String r115 = j();
        m r116 = this.f286700a;
        r101.L$0 = r100;
        r101.L$1 = r115;
        r101.label = 1;
        Object r117 = r116.delete(r100, r101);
        if (r117 != r103) goto L21;
        return r103;
    L21:
        r106 = r115;
        r111 = r117;
    L7:
        r101 = new AnonymousClass1(this, r110);
        goto L8
    }

    public final Object k(String r100, Continuation<? super com.larus.agents.impl.experience.n> r101) {
        if ((r101 instanceof CachedWorkExperienceRepository$getCachedDetail$1) == false) goto L7;
        CachedWorkExperienceRepository$getCachedDetail$1 r102 = (CachedWorkExperienceRepository$getCachedDetail$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        String r107 = (String) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L21:
        com.larus.agents.impl.experience.n r108 = (com.larus.agents.impl.experience.n) r104;
        if (n(r107) == true) goto L24;
        return null;
    L24:
        return r108;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        String r109 = j();
        if (r109 != null) goto L17;
        return null;
    L17:
        r102.L$0 = r109;
        r102.label = 1;
        Object r110 = h("detail read", new CachedWorkExperienceRepository$cachedDetail$2(this, r109, r100, null), r102);
        if (r110 != r105) goto L20;
        return r105;
    L20:
        r104 = r110;
        r107 = r109;
    L7:
        r102 = new CachedWorkExperienceRepository$getCachedDetail$1(this, r101);
        goto L8
    }

    @Override // com.larus.agents.impl.network.m
    public final Object d(int r110, String r111, Continuation<? super Result<s>> r112) {
        int r100 = r110;
        if ((r112 instanceof CachedWorkExperienceRepository$list$1) == false) goto L7;
        CachedWorkExperienceRepository$list$1 r101 = (CachedWorkExperienceRepository$list$1) r112;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        CachedWorkExperienceRepository$list$1 r103 = r101;
        Object r104 = r103.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r103.label;
        if (r106 == 0) goto L21;
        if (r106 == 1) goto L20;
        if (r106 == 2) goto L19;
        if (r106 == 3) goto L17;
        if (r106 != 4) goto L16;
        Object r107 = r103.L$0;
        ResultKt.throwOnFailure(r104);
    L67:
        if (Intrinsics.areEqual((Boolean) r104, Boxing.boxBoolean(false)) == false) goto L71;
        return g();
    L71:
        return r107;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        Long r108 = (Long) r103.L$1;
        String r109 = (String) r103.L$0;
        ResultKt.throwOnFailure(r104);
        Long r113 = r108;
        Object r114 = ((Result) r104).m9458unboximpl();
    L18:
        String r115 = r109;
        if (n(r115) == true) goto L54;
        return f();
    L54:
        if (Result.m9455isFailureimpl(r114) == false) goto L56;
        Object r116 = null;
    L57:
        s r117 = (s) r116;
        if (r117 != null) goto L60;
        return r114;
    L60:
        if (r115 == null) goto L73;
        if (r113 == null) goto L74;
        CachedWorkExperienceRepository$list$stored$1 r118 = new CachedWorkExperienceRepository$list$stored$1(this, r115, r117, r113, null);
        r103.L$0 = r114;
        r103.L$1 = null;
        r103.label = 4;
        r104 = h("list refresh", r118, r103);
        if (r104 != r105) goto L65;
        return r105;
    L65:
        r107 = r114;
        goto L67
    L74:
        return r114;
    L73:
        return r114;
    L56:
        r116 = r114;
        goto L57
    L19:
        r100 = r103.I$0;
        r109 = (String) r103.L$0;
        ResultKt.throwOnFailure(r104);
    L43:
        Long r119 = (Long) r104;
    L45:
        m r120 = this.f286700a;
        r103.L$0 = r109;
        r103.L$1 = r119;
        r103.label = 3;
        Object r121 = r120.d(r100, null, r103);
        if (r121 != r105) goto L48;
        return r105;
    L48:
        r114 = r121;
        r113 = r119;
        goto L18
    L20:
        String r122 = (String) r103.L$0;
        ResultKt.throwOnFailure(r104);
        Object r123 = ((Result) r104).m9458unboximpl();
    L34:
        if (n(r122) == false) goto L37;
        return r123;
    L37:
        return f();
    L21:
        ResultKt.throwOnFailure(r104);
        if (r111 != null) goto L24;
    L27:
        boolean r124 = true;
    L28:
        if (r124 == true) goto L38;
        String r125 = j();
        m r126 = this.f286700a;
        r103.L$0 = r125;
        r103.label = 1;
        r123 = r126.d(r110, r111, r103);
        if (r123 != r105) goto L32;
        return r105;
    L32:
        r122 = r125;
        goto L34
    L38:
        r109 = j();
        if (r109 == null) goto L44;
        CachedWorkExperienceRepository$list$revision$1$1 r127 = new CachedWorkExperienceRepository$list$revision$1$1(this, r109, null);
        r103.L$0 = r109;
        r103.I$0 = r100;
        r103.label = 2;
        r104 = h("list revision", r127, r103);
        if (r104 != r105) goto L43;
        return r105;
    L44:
        r119 = null;
        goto L45
    L24:
        if (StringsKt.isBlank(r111) == true) goto L27;
        r124 = false;
    L7:
        r101 = new CachedWorkExperienceRepository$list$1(this, r112);
        goto L8
    }

    public final <T> Object h(String r100, Function1<? super Continuation<? super T>, ? extends Object> r101, Continuation<? super T> r102) {
        if ((r102 instanceof CachedWorkExperienceRepository$cacheRead$1) == false) goto L7;
        CachedWorkExperienceRepository$cacheRead$1 r103 = (CachedWorkExperienceRepository$cacheRead$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L16;
        if (r107 != 1) goto L15;
        r100 = (String) r103.L$0;
        ResultKt.throwOnFailure(r105);     // Catch: Throwable -> L22
    L20:
        Object r108 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L22
    L25:
        if (Result.m9452exceptionOrNullimpl(r108) == null) goto L31;
        FLogger.f375446a.w("CachedWorkExperienceRepo", r100 + " cache operation failed");
        return null;
    L31:
        return r108;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r105);
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L22
        r103.L$0 = r100;     // Catch: Throwable -> L22
        r103.label = 1;     // Catch: Throwable -> L22
        r105 = r101.invoke(r103);     // Catch: Throwable -> L22
        if (r105 != r106) goto L20;
        return r106;
    L22:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r103 = new CachedWorkExperienceRepository$cacheRead$1(this, r102);
        goto L8
    }

    public final Object i(String r100, Function1<? super Continuation<? super Unit>, ? extends Object> r101, Continuation<? super Unit> r102) {
        if ((r102 instanceof CachedWorkExperienceRepository$cacheWrite$1) == false) goto L7;
        CachedWorkExperienceRepository$cacheWrite$1 r103 = (CachedWorkExperienceRepository$cacheWrite$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L16;
        if (r107 != 1) goto L15;
        r100 = (String) r103.L$0;
        ResultKt.throwOnFailure(r105);     // Catch: Throwable -> L22
    L20:
        Object r108 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L22
    L25:
        if (Result.m9452exceptionOrNullimpl(r108) == null) goto L28;
        FLogger.f375446a.w("CachedWorkExperienceRepo", r100 + " cache operation failed");
    L28:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r105);
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L22
        r103.L$0 = r100;     // Catch: Throwable -> L22
        r103.label = 1;     // Catch: Throwable -> L22
        if (r101.invoke(r103) != r106) goto L20;
        return r106;
    L22:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r103 = new CachedWorkExperienceRepository$cacheWrite$1(this, r102);
        goto L8
    }

    @Override // com.larus.agents.impl.network.m
    public Object update(String r100, p r110, Continuation<? super WorkExperienceMutationResult> r111) {
        if ((r111 instanceof C107791) == false) goto L7;
        C107791 r101 = (C107791) r111;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r112 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L18;
        if (r104 == 1) goto L17;
        if (r104 == 2) goto L16;
        if (r104 != 3) goto L15;
        WorkExperienceMutationResult r105 = (WorkExperienceMutationResult) r101.L$0;
        ResultKt.throwOnFailure(r112);
    L37:
        return r105;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r105 = (WorkExperienceMutationResult) r101.L$2;
        String r113 = (String) r101.L$1;
        String r106 = (String) r101.L$0;
        ResultKt.throwOnFailure(r112);
    L33:
        Function1<? super Continuation<? super Unit>, ? extends Object> r114 = new C107813(this, r113, r106, null);
        r101.L$0 = r105;
        r101.L$1 = null;
        r101.L$2 = null;
        r101.label = 3;
        if (i("update detail mutation", r114, r101) != r103) goto L37;
        return r103;
    L17:
        String r107 = (String) r101.L$1;
        String r115 = (String) r101.L$0;
        ResultKt.throwOnFailure(r112);
        r113 = r107;
        r100 = r115;
    L22:
        WorkExperienceMutationResult r116 = (WorkExperienceMutationResult) r112;
        if (n(r113) == true) goto L27;
        return WorkExperienceMutationResult.FAILURE;
    L27:
        if (r116 != WorkExperienceMutationResult.SUCCESS) goto L38;
        if (r113 == null) goto L39;
        Function1<? super Continuation<? super Unit>, ? extends Object> r108 = new C107802(this, r113, null);
        r101.L$0 = r100;
        r101.L$1 = r113;
        r101.L$2 = r116;
        r101.label = 2;
        if (i("update list mutation", r108, r101) != r103) goto L32;
        return r103;
    L32:
        r106 = r100;
        r105 = r116;
        goto L33
    L39:
        return r116;
    L38:
        return r116;
    L18:
        ResultKt.throwOnFailure(r112);
        String r117 = j();
        m r109 = this.f286700a;
        r101.L$0 = r100;
        r101.L$1 = r117;
        r101.label = 1;
        Object r118 = r109.update(r100, r110, r101);
        if (r118 != r103) goto L21;
        return r103;
    L21:
        r112 = r118;
        r113 = r117;
    L7:
        r101 = new C107791(this, r111);
        goto L8
    }
}

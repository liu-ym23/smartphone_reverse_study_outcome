package com.larus.avlink.aiproactive;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "Lcom/larus/avlink/aiproactive/TopBannerState;", "envStatus", "Lcom/larus/avlink/aiproactive/EnvObserveStatus;", "imuVisible", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avlink.aiproactive.AiProactiveTaskViewModel$bannerStateFlow$1", f = "AiProactiveTaskViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AiProactiveTaskViewModel$bannerStateFlow$1 extends SuspendLambda implements Function3<EnvObserveStatus, Boolean, Continuation<? super j0>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ boolean Z$0;
    int label;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f291546a = null;

        static {
            int[] r100 = new int[EnvObserveStatus.values().length];
            r100[EnvObserveStatus.NOT_OPEN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[EnvObserveStatus.PAUSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[EnvObserveStatus.RUNNING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f291546a = r100;
        }
    }

    public AiProactiveTaskViewModel$bannerStateFlow$1(Continuation<? super AiProactiveTaskViewModel$bannerStateFlow$1> r100) {
        super(3, r100);
    }

    public final Object invoke(EnvObserveStatus r100, boolean r101, Continuation<? super j0> r102) {
        AiProactiveTaskViewModel$bannerStateFlow$1 r103 = new AiProactiveTaskViewModel$bannerStateFlow$1(r102);
        r103.L$0 = r100;
        r103.Z$0 = r101;
        return r103.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(EnvObserveStatus r100, Boolean r101, Continuation<? super j0> r102) {
        return invoke(r100, r101.booleanValue(), r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r100);
        EnvObserveStatus r101 = (EnvObserveStatus) this.L$0;
        boolean r102 = this.Z$0;
        int r103 = a.f291546a[r101.ordinal()];
        if (r103 == 1) goto L17;
        if (r103 == 2) goto L22;
        if (r103 != 3) goto L14;
        if (r102 == false) goto L21;
        return j0.d.f291587a;
    L21:
        return j0.c.f291586a;
    L14:
        throw new NoWhenBranchMatchedException();
    L22:
        return j0.b.f291585a;
    L17:
        return j0.a.f291584a;
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

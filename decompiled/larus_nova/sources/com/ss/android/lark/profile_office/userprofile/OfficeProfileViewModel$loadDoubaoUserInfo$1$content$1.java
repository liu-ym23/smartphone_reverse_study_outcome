package com.ss.android.lark.profile_office.userprofile;

import com.google.gson.Gson;
import com.ss.android.lark.utils.e0;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel$loadDoubaoUserInfo$1$content$1", f = "OfficeProfileViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class OfficeProfileViewModel$loadDoubaoUserInfo$1$content$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ v1c.a $doubaoData;
    int label;

    public OfficeProfileViewModel$loadDoubaoUserInfo$1$content$1(v1c.a r100, Continuation<? super OfficeProfileViewModel$loadDoubaoUserInfo$1$content$1> r101) {
        this.$doubaoData = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new OfficeProfileViewModel$loadDoubaoUserInfo$1$content$1(this.$doubaoData, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super String> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super String> r101) {
        return ((OfficeProfileViewModel$loadDoubaoUserInfo$1$content$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L9;
        ResultKt.throwOnFailure(r100);
        Gson r101 = e0.f444707a;
        String r102 = e0.c(this.$doubaoData);
        if (r102 != null) goto L10;
        return "";
    L10:
        return r102;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

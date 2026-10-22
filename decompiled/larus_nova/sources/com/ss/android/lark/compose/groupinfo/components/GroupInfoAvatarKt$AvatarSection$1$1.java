package com.ss.android.lark.compose.groupinfo.components;

import com.ss.android.lark.image.compose.common.url.a;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.compose.groupinfo.components.GroupInfoAvatarKt$AvatarSection$1$1", f = "GroupInfoAvatar.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class GroupInfoAvatarKt$AvatarSection$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $avatarRefreshKey;
    final /* synthetic */ a $state;
    int label;

    public GroupInfoAvatarKt$AvatarSection$1$1(long r100, a r101, Continuation<? super GroupInfoAvatarKt$AvatarSection$1$1> r102) {
        this.$avatarRefreshKey = r100;
        this.$state = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new GroupInfoAvatarKt$AvatarSection$1$1(this.$avatarRefreshKey, this.$state, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((GroupInfoAvatarKt$AvatarSection$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r100);
        if (this.$avatarRefreshKey <= 0) goto L8;
        a r101 = this.$state;
        int r102 = ((Number) r101.f426273a.getValue()).intValue() + 1;
        r101.f426273a.setValue(Integer.valueOf(r102));
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

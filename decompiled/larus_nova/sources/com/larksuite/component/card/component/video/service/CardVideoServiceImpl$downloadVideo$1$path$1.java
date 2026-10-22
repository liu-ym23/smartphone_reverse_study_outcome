package com.larksuite.component.card.component.video.service;

import com.ss.android.lark.widget.photo.preview.utils.DownloadCheckUtil;
import com.ss.android.lark.widget.photopicker.f;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larksuite.component.card.component.video.service.CardVideoServiceImpl$downloadVideo$1$path$1", f = "CardVideoServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CardVideoServiceImpl$downloadVideo$1$path$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $responsePath;
    int label;

    public CardVideoServiceImpl$downloadVideo$1$path$1(String r100, Continuation<? super CardVideoServiceImpl$downloadVideo$1$path$1> r101) {
        this.$responsePath = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new CardVideoServiceImpl$downloadVideo$1$path$1(this.$responsePath, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super String> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super String> r101) {
        return ((CardVideoServiceImpl$downloadVideo$1$path$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L5;
        ResultKt.throwOnFailure(r100);
        String r101 = this.$responsePath;
        Intrinsics.checkNotNull(r101);
        int r102 = DownloadCheckUtil.f447128a;
        Intrinsics.checkNotNullParameter(r101, "path");
        f.a().o();
        throw null;
    L5:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

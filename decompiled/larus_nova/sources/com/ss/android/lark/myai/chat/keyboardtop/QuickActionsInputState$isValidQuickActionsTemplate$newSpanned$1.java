package com.ss.android.lark.myai.chat.keyboardtop;

import android.text.SpannableStringBuilder;
import com.ss.android.lark.myai.chat.quickactions.QuickActionsTemplateFormatter;
import com.ss.android.lark.myai.chat.quickactions.b;
import java.util.ArrayList;
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

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/text/SpannableStringBuilder;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.myai.chat.keyboardtop.QuickActionsInputState$isValidQuickActionsTemplate$newSpanned$1", f = "QuickActionsInputState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class QuickActionsInputState$isValidQuickActionsTemplate$newSpanned$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SpannableStringBuilder>, Object> {
    int label;
    final /* synthetic */ a this$0;

    public QuickActionsInputState$isValidQuickActionsTemplate$newSpanned$1(a r100, Continuation<? super QuickActionsInputState$isValidQuickActionsTemplate$newSpanned$1> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new QuickActionsInputState$isValidQuickActionsTemplate$newSpanned$1(this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super SpannableStringBuilder> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super SpannableStringBuilder> r101) {
        return ((QuickActionsInputState$isValidQuickActionsTemplate$newSpanned$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L5;
        ResultKt.throwOnFailure(r100);
        int r101 = b.f432865a;
        a r102 = this.this$0;
        Intrinsics.checkNotNullParameter(r102, "quickActionsInputState");
        System.nanoTime();
        new SpannableStringBuilder();
        new QuickActionsTemplateFormatter();
        r102.getClass();
        new ArrayList();
        throw null;
    L5:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

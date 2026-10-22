package com.larus.music.qq;

import android.os.Bundle;
import com.tencent.qqmusic.third.api.contract.IQQMusicApi;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.music.qq.QQMusicApiUtils$isUserLoginWhenStartQQProcess$1", f = "QQMusicApiUtils.kt", i = {0, 0, 0, 0}, l = {310}, m = "invokeSuspend", n = {"maxLoopTimes", "currentLoopCount", "errcode", "loginStatus"}, s = {"I$0", "I$1", "I$2", "I$3"})
final class QQMusicApiUtils$isUserLoginWhenStartQQProcess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IQQMusicApi $api;
    final /* synthetic */ Function2<Integer, Boolean, Unit> $callback;
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public QQMusicApiUtils$isUserLoginWhenStartQQProcess$1(IQQMusicApi r100, Function2<? super Integer, ? super Boolean, Unit> r101, Continuation<? super QQMusicApiUtils$isUserLoginWhenStartQQProcess$1> r102) {
        this.$api = r100;
        this.$callback = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new QQMusicApiUtils$isUserLoginWhenStartQQProcess$1(this.$api, this.$callback, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((QQMusicApiUtils$isUserLoginWhenStartQQProcess$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        boolean r102 = false;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        int r103 = this.I$3;
        int r104 = this.I$2;
        int r105 = this.I$1;
        int r106 = this.I$0;
        ResultKt.throwOnFailure(r110);
    L9:
        if (r105 >= r106) goto L24;
        QQMusicApiUtils r111 = QQMusicApiUtils.f359493a;
        Pair r112 = QQMusicApiUtils.e(this.$api, "getLoginState", null);
        Bundle r107 = (Bundle) r112.getSecond();
        if (r107 == null) goto L13;
        r103 = r107.getInt("data");
    L14:
        r104 = ((Number) r112.getFirst()).intValue();
        if (r103 != 0) goto L16;
        r105 = r105 + 1;
        this.I$0 = r106;
        this.I$1 = r105;
        this.I$2 = r104;
        this.I$3 = r103;
        this.label = 1;
        if (DelayKt.delay(100, this) != r100) goto L9;
        return r100;
    L16:
        Function2<Integer, Boolean, Unit> r113 = this.$callback;
        Integer r108 = Boxing.boxInt(r104);
        if (r103 == 0) goto L19;
        r102 = true;
    L19:
        r113.invoke(r108, Boxing.boxBoolean(r102));
        return Unit.INSTANCE;
    L13:
        r103 = 0;
        goto L14
    L24:
        Function2<Integer, Boolean, Unit> r114 = this.$callback;
        Integer r109 = Boxing.boxInt(r104);
        if (r103 == 0) goto L27;
        r102 = true;
    L27:
        r114.invoke(r109, Boxing.boxBoolean(r102));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r110);
        r104 = -1;
        r106 = 2;
        r103 = 0;
        r105 = 0;
        goto L9
    }
}

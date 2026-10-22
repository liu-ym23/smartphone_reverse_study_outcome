package com.larus.avatar.impl.upload.utils;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes23.dex */
public final class ViewModelUtilsKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final Object b(ApiCallConfig r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof ViewModelUtilsKt$safelyCall$1) == false) goto L7;
        ViewModelUtilsKt$safelyCall$1 r102 = (ViewModelUtilsKt$safelyCall$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L18;
        if (r106 == 1) goto L15;
        if (r106 != 2) goto L14;
        ResultKt.throwOnFailure(r104);
    L27:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ApiCallConfig r107 = (ApiCallConfig) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L22
        r100 = r107;
    L28:
        goto L27
    L18:
        ResultKt.throwOnFailure(r104);
        Function1<? super Continuation<? super Unit>, ? extends Object> r108 = r100.f291318a;     // Catch: Throwable -> L22
        r102.L$0 = r100;     // Catch: Throwable -> L22
        r102.label = 1;     // Catch: Throwable -> L22
        Object r109 = r108.invoke(r102);     // Catch: Throwable -> L22
        r100 = r109;
        if (r109 != r105) goto L28;
        return r105;
    L22:
        th = move-exception;
        Function2<? super Throwable, ? super Continuation<? super Unit>, ? extends Object> r110 = r100.f291319b;
        r102.L$0 = null;
        r102.label = 2;
        if (r110.invoke(th, r102) != r105) goto L27;
        return r105;
    L7:
        r102 = new ViewModelUtilsKt$safelyCall$1(r101);
        goto L8
    }

    public static final void d(ViewModel r100, com.larus.avatar.impl.upload.viewmodel.a r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "config");
        ApiCallConfig r102 = new ApiCallConfig();
        r101.invoke(r102);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(r100), Dispatchers.getIO(), null, new ViewModelUtilsKt$viewModelApiCall$1$1(r102, null), 2, null);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0053 -> B:27:0x0059). Please report as a decompilation issue!!! */
    public static final <T> Object c(int r100, Function1<? super Continuation<? super T>, ? extends Object> r101, Continuation<? super T> r102) {
        if ((r102 instanceof ViewModelUtilsKt$tryDo$1) == false) goto L7;
        ViewModelUtilsKt$tryDo$1 r103 = (ViewModelUtilsKt$tryDo$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L18;
        if (r107 != 1) goto L17;
        int r108 = r103.I$1;
        int r109 = r103.I$0;
        Function1<? super Continuation<? super T>, ? extends Object> r110 = (Function1) r103.L$0;
        ResultKt.throwOnFailure(r105);     // Catch: Throwable -> L14
    L24:
        return r105;
    L14:
        Throwable th10 = th;
    L27:
        if (r108 == r109) goto L30;
        Function1<? super Continuation<? super T>, ? extends Object> r111 = r110;
        int r112 = r109;
        int r113 = r108 + 1;
        r100 = r112;
    L34:
        r103.L$0 = r111;     // Catch: Throwable -> L25
        r103.I$0 = r100;     // Catch: Throwable -> L25
        r103.I$1 = r113;     // Catch: Throwable -> L25
        r103.label = 1;     // Catch: Throwable -> L25
        r105 = r111.invoke(r103);     // Catch: Throwable -> L25
        if (r105 != r106) goto L24;
        return r106;
    L25:
        th = move-exception;
        int r114 = r113;
        r109 = r100;
        r108 = r114;
        r110 = r111;
        th10 = th;
    L30:
        Intrinsics.checkNotNull(th10);
        throw th10;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r105);
        if (1 > r100) goto L29;
        r111 = r101;
        r113 = 1;
        goto L34
    L29:
        th10 = null;
    L7:
        r103 = new ViewModelUtilsKt$tryDo$1(r102);
        goto L8
    }

    public static Job a(CoroutineScope r100, CoroutineDispatcher r101, Function2 r102, int r103) {
        CoroutineContext r104 = r101;
        if ((r103 & 1) == 0) goto L6;
        r104 = EmptyCoroutineContext.INSTANCE;
    L6:
        if ((r103 & 2) == 0) goto L8;
        CoroutineStart r105 = CoroutineStart.DEFAULT;
    L9:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r104, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r105, "start");
        Intrinsics.checkNotNullParameter(r102, "block");
        return BuildersKt.launch(r100, r104, r105, new ViewModelUtilsKt$safeLaunch$1(r102, null));
    L8:
        r105 = null;
        goto L9
    }
}

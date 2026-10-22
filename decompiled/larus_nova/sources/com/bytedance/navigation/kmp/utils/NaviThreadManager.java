package com.bytedance.navigation.kmp.utils;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: classes21.dex */
public final class NaviThreadManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<NaviThreadManager> f265968a = null;

    public static final class a {
    }

    public NaviThreadManager() {
    }

    static {
        f265968a = LazyKt.lazy(new c());
    }

    public static Object b(Function1 r100, Continuation r101) {
        return BuildersKt.withContext(Dispatchers.getIO(), new NaviThreadManager$runOnIO$2(r100, null), r101);
    }

    public final <T> Object a(Function1<? super Continuation<? super T>, ? extends Object> r100, Continuation<? super T> r110) {
        if ((r110 instanceof NaviThreadManager$ensureMain$1) == false) goto L7;
        NaviThreadManager$ensureMain$1 r101 = (NaviThreadManager$ensureMain$1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r111 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        boolean r105 = true;
        if (r104 == 0) goto L18;
        if (r104 == 1) goto L17;
        if (r104 == 2) goto L16;
        if (r104 != 3) goto L15;
        ResultKt.throwOnFailure(r111);
    L52:
        return r111;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r111);
    L48:
        return r111;
    L17:
        r100 = (Function1) r101.L$0;
        ResultKt.throwOnFailure(r111);
    L44:
        if (((Boolean) r111).booleanValue() == false) goto L49;
        r101.L$0 = null;
        r101.label = 2;
        r111 = r100.invoke(r101);
        if (r111 != r103) goto L48;
        return r103;
    L49:
        MainCoroutineDispatcher r112 = Dispatchers.getMain();
        NaviThreadManager$ensureMain$2 r106 = new NaviThreadManager$ensureMain$2(r100, null);
        r101.L$0 = null;
        r101.label = 3;
        r111 = BuildersKt.withContext(r112, r106, r101);
        if (r111 != r103) goto L52;
        return r103;
    L18:
        ResultKt.throwOnFailure(r111);
        r101.L$0 = r100;
        r101.label = 1;
        CoroutineDispatcher r113 = (CoroutineDispatcher) r101.getContext().get(CoroutineDispatcher.Key);
        if (Intrinsics.areEqual(r113, Dispatchers.getMain()) == false) goto L22;
    L40:
        r111 = Boxing.boxBoolean(r105);
        if (r111 != r103) goto L44;
        return r103;
    L22:
        if (r113 == null) goto L28;
        String r107 = r113.toString();
        if (r107 == null) goto L28;
        if (StringsKt.contains(r107, "Main", true) != true) goto L28;
        boolean r108 = true;
    L29:
        if (r108 == true) goto L40;
        if (r113 == null) goto L36;
        String r114 = r113.toString();
        if (r114 == null) goto L36;
        if (StringsKt.contains(r114, "UI", true) != true) goto L36;
        boolean r115 = true;
    L37:
        if (r115 == true) goto L40;
        r105 = false;
    L36:
        r115 = false;
    L28:
        r108 = false;
    L7:
        r101 = new NaviThreadManager$ensureMain$1(this, r110);
        goto L8
    }
}

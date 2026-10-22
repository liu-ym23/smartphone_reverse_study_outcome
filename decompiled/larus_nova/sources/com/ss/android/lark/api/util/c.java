package com.ss.android.lark.api.util;

import com.ss.android.lark.forseti.node.ForsetiFragmentDisplayControllerImpl;
import com.ss.android.lark.forseti.widget.ForsetiNodeViewGroup;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class c {
    public static final void a(final ForsetiNodeViewGroup r100, final ForsetiFragmentDisplayControllerImpl.b r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "listener");
        Function0<Unit> r102 = new ViewExtKt$addSafeGlobalLayoutListener$addOnGlobalLayoutListener$1(r100, r101);
        if (r100.isAttachedToWindow() == false) goto L5;
        r102.invoke();
    L5:
        r100.addOnAttachStateChangeListener(new a(r102, r100, r101));
    }

    public static final void b(final ForsetiNodeViewGroup r100, final ForsetiFragmentDisplayControllerImpl.a r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "listener");
        Function0<Unit> r102 = new ViewExtKt$addSafeGlobalLayoutListenerV2$addOnGlobalLayoutListener$1(r100, r101);
        b r103 = new b(r102, r100, r101);
        if (r100.isAttachedToWindow() == false) goto L5;
        r102.invoke();
    L5:
        r100.addOnAttachStateChangeListener(r103);
    }
}

package com.ss.android.ainote;

import android.text.Editable;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes34.dex */
public final class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VCAINoteEditText f407240a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.keyboard.edittext2.copy.a.b f407241b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f407242c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CoroutineScope f407243d;

    public static final class a {
    }

    static {
    }

    public z0(VCAINoteEditText r100) {
        Intrinsics.checkNotNullParameter(r100, "editText");
        this.f407240a = r100;
        this.f407241b = com.ss.android.lark.keyboard.edittext2.copy.a.f428969a;
        this.f407243d = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate());
    }

    public static final void a(z0 r100, CharSequence r101) {
        Editable r102 = r100.f407240a.getEditableText();
        int r103 = r100.f407240a.getSelectionEnd();
        int r104 = r100.f407240a.getSelectionStart();
        if ((r103 - r104) <= 0) goto L5;
        r102.delete(r104, r103);
    L5:
        if (r104 >= 0) goto L7;
        r104 = r102.length();
    L7:
        r100.f407240a.setSelection(r104);
        r102.insert(r104, r101);
    }

    public static final Object b(z0 r100, Function1 r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof VCAINoteEditTextCopyCoordinator$withPasteStrategy$1) == false) goto L7;
        VCAINoteEditTextCopyCoordinator$withPasteStrategy$1 r103 = (VCAINoteEditTextCopyCoordinator$withPasteStrategy$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        eob.a r108 = (eob.a) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L17:
        com.ss.android.lark.keyboard.edittext2.edittors.anchor.paste.c r109 = com.ss.android.lark.keyboard.edittext2.edittors.anchor.paste.c.f428985a;
        r108.X();
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        r108 = (eob.a) r100.f407240a.q(eob.a.f473406f);
        r108.U(com.ss.android.lark.keyboard.edittext2.edittors.anchor.paste.c.f428985a);
        r103.L$0 = r108;
        r103.label = 1;
        if (r101.invoke(r103) != r106) goto L17;
        return r106;
    L7:
        r103 = new VCAINoteEditTextCopyCoordinator$withPasteStrategy$1(r100, r102);
        goto L8
    }
}

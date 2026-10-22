package com.ss.android.lark.keyboard.edittext2.edittors.at;

import com.ss.android.lark.keyboard.edittext2.base.FunctionEditText;
import com.ss.android.lark.log.Log;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class EditTextSpanHolder implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f429036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FunctionEditText f429037b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function1<? super FunctionEditText, Unit> f429038c;

    public EditTextSpanHolder(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        this.f429036a = r100;
        this.f429038c = EditTextSpanHolder$actionOnAttached$1.INSTANCE;
    }

    public final void a(Function1<? super FunctionEditText, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        this.f429038c = r100;
        FunctionEditText r101 = this.f429037b;
        if (r101 == null) goto L6;
        r100.invoke(r101);
        this.f429038c = EditTextSpanHolder$consumeAction$1.INSTANCE;
        return;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.at.d
    public final void c(FunctionEditText r100) {
        Intrinsics.checkNotNullParameter(r100, "editText");
        if (this.f429037b == null) goto L5;
        return;
    L5:
        Log.i(this.f429036a, "onSpanAttached: invoke action on attach.");
        this.f429038c.invoke(r100);
        this.f429038c = EditTextSpanHolder$consumeAction$1.INSTANCE;
        this.f429037b = r100;
    }
}

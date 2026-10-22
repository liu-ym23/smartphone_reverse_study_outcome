package com.ss.android.lark.todo.impl.features.common.richtext2;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f442461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f442462b;

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        c r101 = this.f442462b;
        if (r101 == null) goto L6;
        r101.a(this.f442461a);
        return;
    }

    public a(String r100, c r101) {
        Intrinsics.checkNotNullParameter(r100, "mAtId");
        this.f442461a = r100;
        this.f442462b = r101;
    }
}

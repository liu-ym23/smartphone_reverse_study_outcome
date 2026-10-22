package com.larus.bmhome.chat.component.bottom.core.inputtext;

import android.text.Editable;
import android.widget.TextView;
import com.larus.bmhome.chat.component.bottom.core.m6;
import com.larus.bmhome.view.ChatInputText;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class q extends f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ChatInputText f299143e;

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final Object b1() {
        Editable r100 = this.f299143e.getText();
        if (r100 == null) goto L5;
        String r101 = r100.toString();
    L6:
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    public q(ChatInputText r100) {
        Intrinsics.checkNotNullParameter(r100, "inputText");
        super(r100);
        this.f299143e = r100;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void T0(m6 r100) {
        this.f299143e.setOnEnterKeySend(r100);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void a(boolean r100) {
        this.f299143e.getClass();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.f, com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void m1(Function1<? super Boolean, Unit> r100) {
        this.f299143e.setVisibilityChangeCallback(r100);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void setText(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f299143e.setText(r100, TextView.BufferType.SPANNABLE);
    }
}

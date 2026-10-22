package com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.text;

import android.view.View;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class f implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<View, Boolean> f412258a;

    /* JADX WARN: Multi-variable type inference failed */
    public f(Function1<? super View, Boolean> r100) {
        this.f412258a = r100;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r100) {
        Function1<View, Boolean> r101 = this.f412258a;
        Intrinsics.checkNotNull(r100);
        return r101.invoke(r100).booleanValue();
    }
}

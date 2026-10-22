package com.ss.android.lark.widget.photo.preview.ocr;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SelectionMenu.c f447075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1<SelectionMenu.c, Unit> f447076b;

    /* JADX WARN: Multi-variable type inference failed */
    public b(SelectionMenu.c r100, Function1<? super SelectionMenu.c, Unit> r101) {
        this.f447075a = r100;
        this.f447076b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f447075a.f447043c.invoke();
        this.f447076b.invoke(this.f447075a);
    }
}

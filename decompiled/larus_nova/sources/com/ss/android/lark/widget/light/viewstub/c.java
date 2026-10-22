package com.ss.android.lark.widget.light.viewstub;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements View.OnScrollChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2<Integer, Integer, Unit> f446335a;

    /* JADX WARN: Multi-variable type inference failed */
    public c(Function2<? super Integer, ? super Integer, Unit> r100) {
        this.f446335a = r100;
    }

    @Override // android.view.View.OnScrollChangeListener
    public final void onScrollChange(View r100, int r101, int r102, int r103, int r104) {
        this.f446335a.invoke(Integer.valueOf(r101), Integer.valueOf(r102));
    }
}

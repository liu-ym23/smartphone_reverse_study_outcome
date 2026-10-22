package com.ss.android.lark.newemoji.emojioptions;

import android.view.View;

/* JADX INFO: loaded from: classes36.dex */
public final class h implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OptionsSelectPopupMenu<Object> f433015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f433016b;

    public h(OptionsSelectPopupMenu<Object> r100, Object r101) {
        this.f433015a = r100;
        this.f433016b = r101;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, java.lang.Object] */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        OptionsSelectPopupMenu<Object> r101 = this.f433015a;
        r101.f432966c = this.f433016b;
        r101.e();
        this.f433015a.d(false);
    }
}

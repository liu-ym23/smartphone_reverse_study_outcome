package com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender;

import android.view.View;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f412460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AbsTextLayoutCacheStore f412461b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.widget.light.viewstub.h f412462c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ View f412463d;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        this.f412460a.removeOnAttachStateChangeListener(this);
        this.f412461b.h(this.f412462c, this.f412463d);
    }

    public b(View r100, AbsTextLayoutCacheStore r101, com.ss.android.lark.widget.light.viewstub.h r102, View r103) {
        this.f412460a = r100;
        this.f412461b = r101;
        this.f412462c = r102;
        this.f412463d = r103;
    }
}

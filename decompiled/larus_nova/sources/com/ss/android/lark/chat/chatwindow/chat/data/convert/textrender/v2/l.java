package com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2;

import android.view.View;

/* JADX INFO: loaded from: classes35.dex */
public final class l implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f412521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TextLayoutCacheStoreImpl2 f412522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.widget.light.viewstub.h f412523c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ View f412524d;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        this.f412521a.removeOnAttachStateChangeListener(this);
        this.f412522b.g(this.f412523c, this.f412524d);
    }

    public l(View r100, TextLayoutCacheStoreImpl2 r101, com.ss.android.lark.widget.light.viewstub.h r102, View r103) {
        this.f412521a = r100;
        this.f412522b = r101;
        this.f412523c = r102;
        this.f412524d = r103;
    }
}

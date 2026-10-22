package com.larksuite.framework.section.utils;

import android.view.View;

/* JADX INFO: loaded from: classes24.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.larksuite.framework.section.c f285706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.todo.impl.features.detail.viewmodel.a f285707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f285708c;

    public b(com.larksuite.framework.section.c r100, com.ss.android.lark.todo.impl.features.detail.viewmodel.a.s r101, String r102) {
        this.f285706a = r100;
        this.f285707b = r101;
        this.f285708c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f285706a.b(this.f285707b, this.f285708c);
    }
}

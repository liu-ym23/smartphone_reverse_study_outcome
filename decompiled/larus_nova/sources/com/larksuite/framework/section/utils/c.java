package com.larksuite.framework.section.utils;

import android.view.View;

/* JADX INFO: loaded from: classes24.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f285709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f285710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.larksuite.framework.section.c f285711c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.todo.impl.features.detail.viewmodel.a f285712d;

    public c(e r100, long r101, com.larksuite.framework.section.c r102, com.ss.android.lark.todo.impl.features.detail.viewmodel.a.a2 r103) {
        this.f285709a = r100;
        this.f285710b = r101;
        this.f285711c = r102;
        this.f285712d = r103;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        long r101 = System.currentTimeMillis();
        e r102 = this.f285709a;
        if ((r101 - r102.f285716b) <= this.f285710b) goto L6;
        r102.f285716b = System.currentTimeMillis();
        this.f285711c.a(this.f285712d);
        return;
    }
}

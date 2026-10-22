package com.larus.search.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes31.dex */
public final class d0 implements com.larus.common_ui.dialog.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a0 f367626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f367627b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f367628c;

    @Override // com.larus.common_ui.dialog.u
    public final void cancel() {
        this.f367626a.f367469b.put(this.f367627b, Boolean.FALSE);
        this.f367628c.invoke();
    }

    public d0(a0 r100, String r101, y r102) {
        this.f367626a = r100;
        this.f367627b = r101;
        this.f367628c = r102;
    }
}

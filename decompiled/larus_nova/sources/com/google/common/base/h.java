package com.google.common.base;

import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
public final class h extends i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f274715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ i f274716c;

    @Override // com.google.common.base.i
    public final CharSequence c(@CheckForNull Object r100) {
        if (r100 != null) goto L5;
        return this.f274715b;
    L5:
        return this.f274716c.c(r100);
    }

    public h(i r100, i r101) {
        this.f274716c = r100;
        this.f274715b = "null";
        super(r101);
    }
}

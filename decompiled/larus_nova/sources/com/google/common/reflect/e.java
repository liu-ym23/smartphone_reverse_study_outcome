package com.google.common.reflect;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX INFO: loaded from: classes23.dex */
public final class e extends d.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TypeVariable f275697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d.c f275698c;

    public e(TypeVariable r100, d.c r101) {
        this.f275697b = r100;
        this.f275698c = r101;
    }

    @Override // com.google.common.reflect.d.c
    public final Type a(TypeVariable r100, e r101) {
        if (r100.getGenericDeclaration().equals(this.f275697b.getGenericDeclaration()) == false) goto L6;
        return r100;
    L6:
        return this.f275698c.a(r100, r101);
    }
}

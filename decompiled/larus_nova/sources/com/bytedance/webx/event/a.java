package com.bytedance.webx.event;

import oq7.b;
import oq7.c;

/* JADX INFO: loaded from: classes22.dex */
public abstract class a<T extends c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f272596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f272597b;

    public abstract iq7.a d();

    public final T b() {
        if (this.f272596a != null) goto L6;
        this.f272596a = (T) ((oq7.a) d().getContext()).f524890b;
    L6:
        return this.f272596a;
    }

    public final b c() {
        if (this.f272597b != null) goto L6;
        this.f272597b = d().getContext();
    L6:
        return this.f272597b;
    }

    public a() {
    }
}

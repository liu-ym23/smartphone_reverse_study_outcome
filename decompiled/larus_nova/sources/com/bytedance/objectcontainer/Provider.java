package com.bytedance.objectcontainer;

/* JADX INFO: loaded from: classes21.dex */
public abstract class Provider<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OnCreateGetter<T> f266129a;

    public abstract Object a();

    public Provider() {
        this.f266129a = new OnCreateGetter();
    }
}

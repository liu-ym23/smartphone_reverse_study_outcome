package com.larus.livetutor.impl.repository.viewmodel;

/* JADX INFO: loaded from: classes30.dex */
public abstract class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f356220a;

    public l0() {
    }

    public abstract int a();

    public abstract String b();

    public final String toString() {
        return getClass().getSimpleName() + " reason = " + b() + ", code = " + a() + ", msg = " + this.f356220a;
    }
}

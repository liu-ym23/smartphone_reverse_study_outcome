package com.ss.android.lark.image.entity;

/* JADX INFO: loaded from: classes36.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f426346a;

    public abstract String b();

    public b() {
        this("");
    }

    public final String toString() {
        return "key=" + a() + ",level=" + b();
    }

    public String a() {
        return this.f426346a;
    }

    public b(String r100) {
        this.f426346a = r100;
    }
}

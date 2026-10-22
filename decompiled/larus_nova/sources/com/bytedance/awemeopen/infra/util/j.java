package com.bytedance.awemeopen.infra.util;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;

/* JADX INFO: loaded from: classes46.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f198966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f198967b;

    public abstract void a(LifecycleOwner r100, Lifecycle.Event r101);

    /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.awemeopen.infra.util.i] */
    public j() {
        this.f198967b = new i(this);
    }
}

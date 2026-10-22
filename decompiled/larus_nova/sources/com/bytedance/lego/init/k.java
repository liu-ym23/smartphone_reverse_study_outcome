package com.bytedance.lego.init;

import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bf6.f f254531a;

    @Override // java.lang.Runnable
    public final void run() {
        InitTaskDispatcher r100 = InitTaskDispatcher.f254510o;
        bf6.f r101 = this.f254531a;
        r100.getClass();
        InitTaskDispatcher.d(r101);
    }

    @Override // com.bytedance.lego.init.m
    public final bf6.f p() {
        return this.f254531a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(Ref.ObjectRef r100) {
        this.f254531a = (bf6.f) r100.element;
    }
}

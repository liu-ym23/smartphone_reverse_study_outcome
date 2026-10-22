package com.bytedance.ies.bullet.core.event;

import com.bytedance.ies.bullet.core.kit.bridge.h;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f246497a;

    /* JADX INFO: renamed from: com.bytedance.ies.bullet.core.event.a$a, reason: collision with other inner class name */
    public static final class C3523a {
    }

    static {
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.h
    public final String getName() {
        return "__updateData";
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.h
    public final Object getParams() {
        return this.f246497a;
    }

    public a(Object r100) {
        this.f246497a = r100;
    }
}

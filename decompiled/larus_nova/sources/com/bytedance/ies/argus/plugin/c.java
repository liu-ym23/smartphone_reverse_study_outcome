package com.bytedance.ies.argus.plugin;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SecurePluginType f246081a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f246082b;

    public final SecurePluginType getType() {
        return this.f246081a;
    }

    public c(SecurePluginType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f246081a = r100;
        this.f246082b = r100.getStringValue();
    }
}

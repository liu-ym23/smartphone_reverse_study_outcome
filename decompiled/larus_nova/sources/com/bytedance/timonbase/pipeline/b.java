package com.bytedance.timonbase.pipeline;

import com.bytedance.timon.pipeline.TimonSystem;
import dh7.c;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements TimonSystem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f270821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Boolean> f270822b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Boolean> f270823c;

    @Override // com.bytedance.timon.pipeline.TimonSystem
    public final String name() {
        return this.f270821a;
    }

    @Override // com.bytedance.timon.pipeline.TimonSystem
    public final boolean postInvoke(c r100) {
        return this.f270823c.invoke().booleanValue();
    }

    @Override // com.bytedance.timon.pipeline.TimonSystem
    public final boolean preInvoke(c r100) {
        return this.f270822b.invoke().booleanValue();
    }

    public b(String r100, Function0<Boolean> r101, Function0<Boolean> r102) {
        this.f270821a = r100;
        this.f270822b = r101;
        this.f270823c = r102;
    }
}

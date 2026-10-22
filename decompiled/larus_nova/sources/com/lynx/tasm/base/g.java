package com.lynx.tasm.base;

import com.lynx.base.memory.MemoryPressureCallback;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes32.dex */
public final class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g f381868b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<MemoryPressureCallback> f381869a;

    static {
        f381868b = new g();
    }

    public g() {
        this.f381869a = new CopyOnWriteArrayList();
    }
}

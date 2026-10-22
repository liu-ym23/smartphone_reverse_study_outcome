package com.bytedance.badger;

import com.bytedance.badger.collect.impl.interfaces.ILogger;

/* JADX INFO: loaded from: classes3.dex */
public final class t implements ILogger {
    public t() {
    }

    @Override // com.bytedance.badger.collect.impl.interfaces.ILogger
    public final void debug(String r100, String r101) {
        e.b(r100, r101);
    }

    @Override // com.bytedance.badger.collect.impl.interfaces.ILogger
    public final void error(String r100, String r101, Throwable r102) {
        e.c(r100, r101, r102);
    }

    @Override // com.bytedance.badger.collect.impl.interfaces.ILogger
    public final void info(String r100, String r101) {
        e.f(r100, r101);
    }

    @Override // com.bytedance.badger.collect.impl.interfaces.ILogger
    public final void warn(String r100, String r101) {
        e.g(r100, r101);
    }
}

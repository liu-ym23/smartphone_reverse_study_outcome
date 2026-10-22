package com.larus.im.internal.jni;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0006\u001a\u00020\u0007H\u0082 J\u0006\u0010\b\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/larus/im/internal/jni/OmniFoundationInitializer;", "", "<init>", "()V", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "initInjection", "", "initialize", "omnisdk-foundation_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OmniFoundationInitializer {
    public static final OmniFoundationInitializer INSTANCE = null;
    private static final AtomicBoolean initialized = null;

    private OmniFoundationInitializer() {
    }

    private final native void initInjection();

    static {
        INSTANCE = new OmniFoundationInitializer();
        initialized = new AtomicBoolean(false);
    }

    public final void initialize() {
        AtomicBoolean r100 = initialized;
        if (r100.get() == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (r100.get() == false) goto L10;
        monitor-exit(this);
        return;
    L10:
        OmniSoNameProvider.INSTANCE.loadFoundationLibrary();     // Catch: Throwable -> L13
        INSTANCE.initInjection();     // Catch: Throwable -> L13
        r100.set(true);     // Catch: Throwable -> L13
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(this);
    }
}

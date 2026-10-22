package com.bytedance.jedi.arch.internal;

import io.reactivex.disposables.Disposable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0002"}, d2 = {"DISPOSED", "Lio/reactivex/disposables/Disposable;", "arch_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class LifecycleAwareObserverKt {
    private static final Disposable DISPOSED = null;

    static {
        DISPOSED = new LifecycleAwareObserverKt$DISPOSED$1();
    }

    public static final /* synthetic */ Disposable access$getDISPOSED$p() {
        return DISPOSED;
    }
}

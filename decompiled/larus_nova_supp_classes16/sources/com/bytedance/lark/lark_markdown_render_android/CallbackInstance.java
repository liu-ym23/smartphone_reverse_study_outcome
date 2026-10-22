package com.bytedance.lark.lark_markdown_render_android;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/lark/lark_markdown_render_android/CallbackInstance;", "", "()V", "currentInstanceId", "Ljava/util/concurrent/atomic/AtomicLong;", "idToInstance", "", "", "Lcom/bytedance/lark/lark_markdown_render_android/MoltenFFICallback;", "getInstance", "id", "registerInstance", "cb", "unregisterInstance", "", "instanceId", "lark_markdown_render_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CallbackInstance {
    public static final CallbackInstance INSTANCE = null;
    private static final AtomicLong currentInstanceId = null;
    private static final Map<Long, MoltenFFICallback> idToInstance = null;

    private CallbackInstance() {
    }

    static {
        INSTANCE = new CallbackInstance();
        currentInstanceId = new AtomicLong(100);
        idToInstance = new LinkedHashMap();
    }

    public final MoltenFFICallback getInstance(long r2) {
        monitor-enter(this);
        MoltenFFICallback r3 = idToInstance.get(Long.valueOf(r2));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r3;
    L6:
        th = move-exception;
        throw th;
    }

    public final long registerInstance(MoltenFFICallback r5) {
        Intrinsics.checkNotNullParameter(r5, "cb");
        monitor-enter(this);
        long r0 = currentInstanceId.incrementAndGet();     // Catch: Throwable -> L7
        Long r2 = Long.valueOf(r0);     // Catch: Throwable -> L7
        idToInstance.put(r2, r5);     // Catch: Throwable -> L7
        monitor-exit(this);
        return r0;
    L7:
        th = move-exception;
        throw th;
    }

    public final void unregisterInstance(long r3) {
        monitor-enter(this);
        Map<Long, MoltenFFICallback> r0 = idToInstance;     // Catch: Throwable -> L10
        if (r0.get(Long.valueOf(r3)) != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        MoltenFFICallback r4 = r0.remove(Long.valueOf(r3));     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}

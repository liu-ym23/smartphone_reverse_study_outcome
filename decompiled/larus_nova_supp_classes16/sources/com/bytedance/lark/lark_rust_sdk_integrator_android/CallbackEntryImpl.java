package com.bytedance.lark.lark_rust_sdk_integrator_android;

import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/lark/lark_rust_sdk_integrator_android/CallbackEntryImpl;", "Lcom/bytedance/lark/lark_rust_sdk_integrator_android/CallbackEntry;", "()V", "invoke", "", "sender", "", "instanceId", "methodId", "params", "Lcom/bytedance/lark/lark_rust_sdk_integrator_android/RustBuffer$ByValue;", "outBuf", "Lcom/bytedance/lark/lark_rust_sdk_integrator_android/RustBufferByReference;", "Companion", "lark_rust_sdk_integrator_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CallbackEntryImpl implements CallbackEntry {
    public static final a Companion = null;
    private static final CallbackEntry entry = null;

    public static final class a {
        public a() {
        }
    }

    public CallbackEntryImpl() {
    }

    static {
        Companion = new a();
        entry = new CallbackEntryImpl();
    }

    public static final CallbackEntry getEntry() {
        Companion.getClass();
        return access$getEntry$cp();
    }

    public static final /* synthetic */ CallbackEntry access$getEntry$cp() {
        return entry;
    }

    @Override // com.bytedance.lark.lark_rust_sdk_integrator_android.CallbackEntry
    public int invoke(long r3, long r5, long r7, RustBuffer.ByValue r9, RustBufferByReference r10) {
        Intrinsics.checkNotNullParameter(r9, "params");
        Intrinsics.checkNotNullParameter(r10, "outBuf");
        com.bytedance.lark.lark_rust_sdk_integrator_android.a r4 = com.bytedance.lark.lark_rust_sdk_integrator_android.a.a;
        monitor-enter(r4);
        i r6 = (i) ((LinkedHashMap) com.bytedance.lark.lark_rust_sdk_integrator_android.a.b).get(Long.valueOf(r5));     // Catch: Throwable -> L14
        monitor-exit(r4);
        if (r6 == null) goto L13;
        if (r7 != 0) goto L10;
        r4.a(r5);
    L10:
        BufferCallStatus r8 = r6.onInvoke();
        r10.setValue(r8.data);
        return r8.code;
    L13:
        throw new RuntimeException("No registered callback<InstanceId(" + r5 + ")>");
    L14:
        th = move-exception;
        throw th;
    }
}

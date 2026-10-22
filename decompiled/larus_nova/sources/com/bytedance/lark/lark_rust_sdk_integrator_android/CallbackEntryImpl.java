package com.bytedance.lark.lark_rust_sdk_integrator_android;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/lark/lark_rust_sdk_integrator_android/CallbackEntryImpl;", "Lcom/bytedance/lark/lark_rust_sdk_integrator_android/CallbackEntry;", "()V", AbsMethodDelegate.TAG_INVOKE, "", "sender", "", "instanceId", "methodId", "params", "Lcom/bytedance/lark/lark_rust_sdk_integrator_android/RustBuffer$ByValue;", "outBuf", "Lcom/bytedance/lark/lark_rust_sdk_integrator_android/RustBufferByReference;", "Companion", "lark_rust_sdk_integrator_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
    public int invoke(long r100, long r101, long r102, RustBuffer.ByValue r103, RustBufferByReference r110) {
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r110, "outBuf");
        com.bytedance.lark.lark_rust_sdk_integrator_android.a r104 = com.bytedance.lark.lark_rust_sdk_integrator_android.a.f253244a;
        monitor-enter(r104);
        i r105 = (i) ((LinkedHashMap) com.bytedance.lark.lark_rust_sdk_integrator_android.a.f253245b).get(Long.valueOf(r101));     // Catch: Throwable -> L14
        monitor-exit(r104);
        if (r105 == null) goto L13;
        if (r102 != 0) goto L10;
        r104.a(r101);
    L10:
        BufferCallStatus r106 = r105.onInvoke();
        r110.setValue(r106.data);
        return r106.code;
    L13:
        throw new RuntimeException("No registered callback<InstanceId(" + r101 + ")>");
    L14:
        th = move-exception;
        throw th;
    }
}

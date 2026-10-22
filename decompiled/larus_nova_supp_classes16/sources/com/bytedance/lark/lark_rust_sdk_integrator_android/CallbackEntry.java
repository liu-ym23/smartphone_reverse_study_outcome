package com.bytedance.lark.lark_rust_sdk_integrator_android;

import com.sun.jna.Callback;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/bytedance/lark/lark_rust_sdk_integrator_android/CallbackEntry;", "Lcom/sun/jna/Callback;", "invoke", "", "sender", "", "instanceId", "methodId", "params", "Lcom/bytedance/lark/lark_rust_sdk_integrator_android/RustBuffer$ByValue;", "outRef", "Lcom/bytedance/lark/lark_rust_sdk_integrator_android/RustBufferByReference;", "lark_rust_sdk_integrator_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface CallbackEntry extends Callback {
    int invoke(long r1, long r3, long r5, RustBuffer.ByValue r7, RustBufferByReference r8);
}

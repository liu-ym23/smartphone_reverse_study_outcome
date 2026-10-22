package com.bytedance.lark.base.open.pkm;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.ByReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/lark/base/open/pkm/RustBufferByReference;", "Lcom/sun/jna/ptr/ByReference;", "()V", "setValue", "", "value", "Lcom/bytedance/lark/base/open/pkm/RustBuffer$ByValue;", "open_pkm_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RustBufferByReference extends ByReference {
    public RustBufferByReference() {
        super(16);
    }

    public final void setValue(RustBuffer.ByValue r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        Pointer r101 = getPointer();
        r101.setInt(0, r100.capacity);
        r101.setInt(4, r100.len);
        r101.setPointer(8, r100.data);
    }
}

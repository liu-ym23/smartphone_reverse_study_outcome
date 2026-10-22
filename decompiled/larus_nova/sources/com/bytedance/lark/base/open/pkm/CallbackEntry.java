package com.bytedance.lark.base.open.pkm;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.sun.jna.Callback;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/bytedance/lark/base/open/pkm/CallbackEntry;", "Lcom/sun/jna/Callback;", AbsMethodDelegate.TAG_INVOKE, "", "sender", "", "instanceId", "methodId", "params", "Lcom/bytedance/lark/base/open/pkm/RustBuffer$ByValue;", "outRef", "Lcom/bytedance/lark/base/open/pkm/RustBufferByReference;", "open_pkm_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface CallbackEntry extends Callback {
    int invoke(long r100, long r101, long r102, RustBuffer.ByValue r103, RustBufferByReference r104);
}

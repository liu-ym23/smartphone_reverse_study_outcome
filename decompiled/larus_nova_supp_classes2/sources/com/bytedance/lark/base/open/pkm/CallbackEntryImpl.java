package com.bytedance.lark.base.open.pkm;

import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/lark/base/open/pkm/CallbackEntryImpl;", "Lcom/bytedance/lark/base/open/pkm/CallbackEntry;", "()V", "invoke", "", "sender", "", "instanceId", "methodId", "params", "Lcom/bytedance/lark/base/open/pkm/RustBuffer$ByValue;", "outBuf", "Lcom/bytedance/lark/base/open/pkm/RustBufferByReference;", "Companion", "open_pkm_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    @Override // com.bytedance.lark.base.open.pkm.CallbackEntry
    public int invoke(long r4, long r6, long r8, RustBuffer.ByValue r10, RustBufferByReference r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "outBuf");
        com.bytedance.lark.base.open.pkm.a r5 = com.bytedance.lark.base.open.pkm.a.f7223a;
        monitor-enter(r5);
        g r7 = (g) ((LinkedHashMap) com.bytedance.lark.base.open.pkm.a.f7225c).get(Long.valueOf(r6));     // Catch: Throwable -> L14
        monitor-exit(r5);
        if (r7 == null) goto L13;
        if (r8 != 0) goto L10;
        r5.a(r6);
    L10:
        BufferCallStatus r9 = r7.a(r8, r10);
        r11.setValue(r9.data);
        return r9.code;
    L13:
        throw new RuntimeException("No registered callback<InstanceId(" + r6 + ")>");
    L14:
        th = move-exception;
        throw th;
    }
}

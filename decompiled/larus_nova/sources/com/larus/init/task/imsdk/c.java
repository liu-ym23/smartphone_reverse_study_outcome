package com.larus.init.task.imsdk;

import com.bytedance.lark.pb.basic.v1.MoltenInvokeMeta;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class c implements com.bytedance.lark.view_flow_wrapper.e {
    public c() {
    }

    @Override // com.bytedance.lark.view_flow_wrapper.e
    public final byte[] a(com.bytedance.lark.view_flow_wrapper.k r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        String r101 = com.larksuite.framework.utils.k0.a(10);     // Catch: Throwable -> L5
        byte[] r102 = MoltenInvokeMeta.ADAPTER.encode(new MoltenInvokeMeta.Builder().context_id(r101).build());     // Catch: Throwable -> L5
        FLogger.f375446a.i("LarusMoltenFFIContextHook", "larus onInvoke context_id:" + r101 + ", info:" + r100);     // Catch: Throwable -> L5
        return r102;
    L5:
        th = move-exception;
        FLogger.f375446a.i("LarusMoltenFFIContextHook", "larus onInvoke failed, info:" + r100 + ", error: " + th.getMessage());
        return null;
    }

    @Override // com.bytedance.lark.view_flow_wrapper.e
    public final void onInvokeeEnd(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "invokeeObj");
    L10:
        th = move-exception;
        FLogger.f375446a.i("LarusMoltenFFIContextHook", "larus onInvokeeEnd failed, error: " + th.getMessage());
        return;
    L4:
        if ((r100 instanceof MoltenInvokeMeta) == false) goto L6;
        MoltenInvokeMeta r101 = (MoltenInvokeMeta) r100;     // Catch: Throwable -> L10
    L7:
        if (r101 == null) goto L15;
        FLogger.f375446a.i("LarusMoltenFFIContextHook", "larus onInvokeeEnd context_id:" + r101.context_id);     // Catch: Throwable -> L10
        return;
    L15:
        return;
    L6:
        r101 = null;
        goto L7
    }

    @Override // com.bytedance.lark.view_flow_wrapper.e
    public final MoltenInvokeMeta onInvokeeStart(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "hookBuf");
        MoltenInvokeMeta r101 = MoltenInvokeMeta.ADAPTER.decode(r100);     // Catch: Throwable -> L9
        MoltenInvokeMeta r102 = r101;     // Catch: Throwable -> L9
        FLogger r103 = FLogger.f375446a;     // Catch: Throwable -> L9
        StringBuilder r104 = new StringBuilder("larus onInvokeeStart context_id:");     // Catch: Throwable -> L9
        if (r102 == null) goto L6;
        String r105 = r102.context_id;     // Catch: Throwable -> L9
    L7:
        r104.append(r105);     // Catch: Throwable -> L9
        r103.i("LarusMoltenFFIContextHook", r104.toString());     // Catch: Throwable -> L9
        return r101;
    L6:
        r105 = null;
    L9:
        th = move-exception;
        FLogger.f375446a.i("LarusMoltenFFIContextHook", "larus onInvokeeStart failed, error: " + th.getMessage());
        return null;
    }
}

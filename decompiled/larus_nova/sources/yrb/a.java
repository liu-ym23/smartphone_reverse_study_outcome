package yrb;

import com.bytedance.lark.pb.basic.v1.MoltenInvokeMeta;
import com.bytedance.lark.view_flow_wrapper.e;
import com.bytedance.lark.view_flow_wrapper.k;
import com.larksuite.framework.utils.k0;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements e {
    public a() {
    }

    @Override // com.bytedance.lark.view_flow_wrapper.e
    public final byte[] a(k r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        String r101 = k0.a(10);     // Catch: Throwable -> L5
        byte[] r102 = MoltenInvokeMeta.ADAPTER.encode(new MoltenInvokeMeta.Builder().context_id(r101).build());     // Catch: Throwable -> L5
        Log.i("MoltenFFIContextHook", "onInvoke context_id:" + r101 + ", info:" + r100);     // Catch: Throwable -> L5
        return r102;
    L5:
        th = move-exception;
        Log.i("MoltenFFIContextHook", "onInvoke failed, info:" + r100 + ", error: " + th.getMessage());
        return null;
    }

    @Override // com.bytedance.lark.view_flow_wrapper.e
    public final void onInvokeeEnd(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "invokeeObj");
    L10:
        th = move-exception;
        Log.i("MoltenFFIContextHook", "onInvokeeEnd failed, error: " + th.getMessage());
        return;
    L4:
        if ((r100 instanceof MoltenInvokeMeta) == false) goto L6;
        MoltenInvokeMeta r101 = (MoltenInvokeMeta) r100;     // Catch: Throwable -> L10
    L7:
        if (r101 == null) goto L15;
        Log.i("MoltenFFIContextHook", "onInvokeeEnd context_id:" + r101.context_id);     // Catch: Throwable -> L10
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
        StringBuilder r103 = new StringBuilder("onInvokeeStart context_id:");     // Catch: Throwable -> L9
        if (r102 == null) goto L6;
        String r104 = r102.context_id;     // Catch: Throwable -> L9
    L7:
        r103.append(r104);     // Catch: Throwable -> L9
        Log.i("MoltenFFIContextHook", r103.toString());     // Catch: Throwable -> L9
        return r101;
    L6:
        r104 = null;
    L9:
        th = move-exception;
        Log.i("MoltenFFIContextHook", "onInvokeeStart failed, error: " + th.getMessage());
        return null;
    }
}

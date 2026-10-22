package yrb;

import com.bytedance.lark.view_flow_wrapper.y;
import com.bytedance.lark.view_flow_wrapper.z;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c implements y {
    public c() {
    }

    @Override // com.bytedance.lark.view_flow_wrapper.y
    public final void a(z r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        Log.i("ViewFlowLogCallback", "onCallbackInfo info:" + r100);
    }
}

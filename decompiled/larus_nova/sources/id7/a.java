package id7;

import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public abstract class a {
    public a() {
    }

    public abstract void a(le7.a<?> r100, Object r101);

    public abstract boolean b(le7.a r100, me7.d r101, com.bytedance.sdk.xbridge.cn.protocol.d r102);

    public void c(String r100, Object r101, com.bytedance.sdk.xbridge.cn.platform.web.c r102) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
    }
}

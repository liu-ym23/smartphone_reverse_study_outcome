package com.bytedance.locallife.biz.base;

import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.lynx.tasm.LynxError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class d extends wp6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f256553a = null;

    static {
        f256553a = new d();
    }

    public d() {
    }

    @Override // wp6.a
    public final Integer f(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        HostServiceUtilsKt.S().j(r100);
        return super.f(r100);
    }
}

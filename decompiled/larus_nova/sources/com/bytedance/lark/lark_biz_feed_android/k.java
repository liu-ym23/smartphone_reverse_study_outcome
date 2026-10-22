package com.bytedance.lark.lark_biz_feed_android;

import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class k extends v0 {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.lark.lark_biz_feed_android.v0
    public final void a() {
        Lazy<Long> r100 = MoltenFfiLibLarkBizFeed.f253143a;     // Catch: RuntimeException -> L4
        MoltenFfiLibLarkBizFeed.molten_ffi_lark_biz_feed_free(MoltenFfiLibLarkBizFeed.a.b(), this.f253203a, -2643198276404248576L);     // Catch: RuntimeException -> L4
        return;
    L4:
        e = move-exception;
        if (e.getMessage() == null) goto L9;
        int r101 = h.f253168a;
        String r102 = e.getMessage();
        Intrinsics.checkNotNull(r102);
        UnhandledException r103 = new UnhandledException(r102);
        Intrinsics.checkNotNullParameter(r103, "e");
        throw r103;
    L9:
        int r104 = h.f253168a;
        UnhandledException r105 = new UnhandledException("Rust panic");
        Intrinsics.checkNotNullParameter(r105, "e");
        throw r105;
    }

    public k(long r100) {
        super(r100);
    }
}

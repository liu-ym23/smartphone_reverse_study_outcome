package com.larksuite.framework.http.v2.internal.main;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/larksuite/framework/http/v2/LarkHttpClient;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class LarkHttpImpl$evictAll$1 extends Lambda implements Function1<com.larksuite.framework.http.v2.c, Unit> {
    public static final LarkHttpImpl$evictAll$1 INSTANCE = null;

    static {
        INSTANCE = new LarkHttpImpl$evictAll$1();
    }

    public LarkHttpImpl$evictAll$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(com.larksuite.framework.http.v2.c r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$removeExpired");
        r100.getOriginal().connectionPool().evictAll();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(com.larksuite.framework.http.v2.c r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
